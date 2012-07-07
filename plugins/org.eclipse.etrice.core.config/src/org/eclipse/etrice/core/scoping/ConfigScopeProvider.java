/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrConfig;
import org.eclipse.etrice.core.config.PortClassConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 * 
 * @see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 *      how and when to use it
 * 
 */
public class ConfigScopeProvider extends AbstractDeclarativeScopeProvider {

	public IScope scope_PortInstanceConfig_item(PortInstanceConfig ctx,
			EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		ActorInstanceConfig actorConfig = (ActorInstanceConfig) ctx
				.eContainer();
		SubSystemClass subsystem = actorConfig.getRoot();
		if (subsystem != null) {
			ActorContainerClass acc = ConfigUtil.resolve(subsystem,
					actorConfig.getPath());
			for (InterfaceItem item : ConfigUtil.getConfigurableInterfaceItems(
					acc, true))
				scopes.add(EObjectDescription.create(item.getName(), item));
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	public IScope scope_AttrConfig_attribute(AttrConfig ctx, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		if (ctx.eContainer() instanceof AttrConfig)
			collectAttributes((AttrConfig) ctx.eContainer(), scopes);
		else if (ctx.eContainer() instanceof ActorClassConfig)
			collectAttributes((ActorClassConfig) ctx.eContainer(), scopes);
		else if (ctx.eContainer() instanceof ActorInstanceConfig)
			collectAttributes((ActorInstanceConfig) ctx.eContainer(), scopes);
		else if (ctx.eContainer() instanceof PortClassConfig)
			collectAttributes((PortClassConfig) ctx.eContainer(), scopes);
		else if (ctx.eContainer() instanceof PortInstanceConfig)
			collectAttributes((PortInstanceConfig) ctx.eContainer(), scopes);
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	private void collectAttributes(AttrConfig config,
			List<IEObjectDescription> scopes) {
		if (config.getAttribute().getRefType().getType() instanceof DataClass) {
			DataClass dc = (DataClass) config.getAttribute().getRefType()
					.getType();
			for (Attribute att : RoomHelpers.getAllAttributes(dc)) {
				scopes.add(EObjectDescription.create(att.getName(), att));
			}
		}
	}

	private void collectAttributes(ActorClassConfig config,
			List<IEObjectDescription> scopes) {
		ActorClass actor = config.getActor();
		if (actor != null) {
			for (Attribute att : RoomHelpers.getAllAttributes(actor)) {
				scopes.add(EObjectDescription.create(att.getName(), att));
			}
		}
	}

	private void collectAttributes(ActorInstanceConfig config,
			List<IEObjectDescription> scopes) {
		SubSystemClass subsystem = config.getRoot();
		if (subsystem != null) {
			ActorContainerClass actor = ConfigUtil.resolve(subsystem,
					config.getPath());
			if (actor instanceof ActorClass) {
				for (Attribute att : RoomHelpers
						.getAllAttributes((ActorClass) actor)) {
					scopes.add(EObjectDescription.create(att.getName(), att));
				}
			}
		}
	}

	private void collectAttributes(PortClassConfig config,
			List<IEObjectDescription> scopes) {
		ProtocolClassConfig protocolConfig = (ProtocolClassConfig) config
				.eContainer();
		PortClass portClass = null;
		if (protocolConfig.getRegular() == config)
			portClass = protocolConfig.getProtocol().getRegular();
		else
			portClass = protocolConfig.getProtocol().getConjugate();

		if (portClass != null)
			for (Attribute att : portClass.getAttributes())
				scopes.add(EObjectDescription.create(att.getName(), att));
	}

	private void collectAttributes(PortInstanceConfig config,
			List<IEObjectDescription> scopes) {
		PortClass portClass = ConfigUtil.getPortClass(config);
		if (portClass != null)
			for (Attribute att : portClass.getAttributes())
				scopes.add(EObjectDescription.create(att.getName(), att));
	}
}

/*
 * IScope scope_<RefDeclaringEClass>_<Reference>( <ContextType> ctx, EReference
 * ref)
 * 
 * IScope scope_<TypeToReturn>(<ContextType> ctx, EReference ref)
 */
