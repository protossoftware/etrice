/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.generator.base.logging.ILogger;

/**
 * A general interface used by the generator for data configuration.
 * 
 * @author Juergen Haug
 */
public interface IDataConfiguration {
	
	/**
	 * This general setup has to be called once per generator call.
	 */
	public void doSetup();
	
	/**
	 * @param resource a {@link ResourceSet}
	 * @param logger the {@link ILogger}
	 * @return <code>true</code> if all configurations found in the resources
	 * could successfully be read and validated
	 */
	public boolean setResources(ResourceSet resource, ILogger logger);
	
	// static configuration
	
	/**
	 * Static configuration for a (nested) attribute of an {@link ActorClass}
	 * 
	 * @param actor the {@link ActorClass}
	 * @param path a list (interpreted as path) of {@link Attribute}s
	 * @return the configuration value as string
	 */
	public String getAttrClassConfigValue(ActorClass actor, List<Attribute> path);

	/**
	 * Static configuration for a (nested) attribute of an {@link ProtocolClass}
	 * 
	 * @param pc the {@link ProtocolClass}
	 * @param regular a flag distinguishing between regular and conjugate {@link PortClass}
	 * 		of this protocol
	 * @param path a list (interpreted as path) of {@link Attribute}s
	 * @return the configuration value as string
	 */
	public String getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path);
	
	/**
	 * Static configuration for the minimum value of a (nested) attribute of an {@link ActorClass}
	 * 
	 * @param actor the {@link ActorClass}
	 * @param path a list (interpreted as path) of {@link Attribute}s
	 * @return the configuration value as string
	 */
	public String getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path);
	
	/**
	 * Static configuration for the maximum value of a (nested) attribute of an {@link ActorClass}
	 * 
	 * @param actor the {@link ActorClass}
	 * @param path a list (interpreted as path) of {@link Attribute}s
	 * @return the configuration value as string
	 */
	public String getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path);
	
	/**
	 * Static configuration for a (nested) attribute of an {@link ActorInstance}
	 * 
	 * @param ai the {@link ActorInstance}
	 * @param path a list (interpreted as path) of {@link Attribute}s
	 * @return the configuration value as string
	 */
	public String getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path);
	public String getAttrInstanceConfigValue(InterfaceItemInstance item, List<Attribute> path);
	
	
	// dynamic configuration
	
	/**
	 * Dynamic configuration of the user code 1 of a {@link SubSystemInstance}
	 * @param subsystem the {@link SubSystemInstance}
	 * @return the configured value
	 */
	public String getUserCode1(SubSystemInstance subsystem);
	
	/**
	 * Dynamic configuration of the user code 2 of a {@link SubSystemInstance}
	 * @param subsystem the {@link SubSystemInstance}
	 * @return the configured value
	 */
	public String getUserCode2(SubSystemInstance subsystem);
	
	/**
	 * Dynamic configuration of the polling timer of a {@link SubSystemInstance}
	 * @param subsystem the {@link SubSystemInstance}
	 * @return the configured value
	 */
	public long getPollingTimerUser(SubSystemInstance subsystem);
	
	/**
	 * @param subsystem the {@link SubSystemInstance}
	 * @return <code>true</code> if dynamic configuration has been configured
	 */
	public boolean hasVariableService(SubSystemInstance subsystem);
	
	/**
	 * @param ai an {@link ActorInstance}
	 * @return a list of {@link Attribute}s that are configured for
	 * 		dynamic read access
	 */
	public List<Attribute> getDynConfigReadAttributes(ActorInstance ai);
	
	/**
	 * @param ai an {@link ActorInstance}
	 * @return a list of {@link Attribute}s that are configured for
	 * 		dynamic write access
	 */
	public List<Attribute> getDynConfigWriteAttributes(ActorInstance ai);
	
	/**
	 * @param actor an {@link ActorClass}
	 * @return a list of {@link Attribute}s that are configured for
	 * 		dynamic read access
	 */
	public List<Attribute> getDynConfigReadAttributes(ActorClass actor);
	
	/**
	 * @param actor an {@link ActorClass}
	 * @return a list of {@link Attribute}s that are configured for
	 * 		dynamic write access
	 */
	public List<Attribute> getDynConfigWriteAttributes(ActorClass actor);
	
}
