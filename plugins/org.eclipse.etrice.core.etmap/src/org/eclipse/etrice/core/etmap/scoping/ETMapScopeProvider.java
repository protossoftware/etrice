/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.Thread;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ETMapScopeProvider extends AbstractDeclarativeScopeProvider {
	
	public IScope scope_SubSystemMapping_logicalSubSys(SubSystemMapping ssm, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		Mapping map = (Mapping) ssm.eContainer();
		if (map.getLogicalSys()!=null)
			for (SubSystemRef subsys : map.getLogicalSys().getSubSystems()) {
				scopes.add(EObjectDescription.create(subsys.getName(), subsys));
			}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	public IScope scope_SubSystemMapping_node(SubSystemMapping ssm, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		Mapping map = (Mapping) ssm.eContainer();
		if (map.getPhysicalSys()!=null)
			for (NodeRef node : map.getPhysicalSys().getNodeRefs()) {
				scopes.add(EObjectDescription.create(node.getName(), node));
			}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	public IScope scope_ActorInstanceMapping_thread(ActorInstanceMapping aim, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		EObject parent = aim.eContainer();
		while (parent!=null) {
			if (parent instanceof SubSystemMapping)
				break;
			parent = parent.eContainer();
		}
		
		if (parent instanceof SubSystemMapping) {
			SubSystemMapping ssm = (SubSystemMapping) parent;
			for (Thread thread : ssm.getNode().getType().getThreads()) {
				scopes.add(EObjectDescription.create(thread.getName(), thread));
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
}
