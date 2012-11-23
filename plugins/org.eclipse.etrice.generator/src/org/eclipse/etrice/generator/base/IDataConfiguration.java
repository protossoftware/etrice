/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;

public interface IDataConfiguration {
	
	public void doSetup();
	public boolean setResources(ResourceSet resource, ILogger logger);
	
	// static configuration
	
	public String getAttrClassConfigValue(ActorClass actor, List<Attribute> path);
	public String getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path);
	public String getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path);
	public String getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path);
	
	public String getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path);
	public String getAttrInstanceConfigValue(InterfaceItemInstance item, List<Attribute> path);
	
	// dynamic configuration
	
	public String getUserCode1(SubSystemClass subsystem);
	public String getUserCode2(SubSystemClass subsystem);
	public int getPollingTimerUser(SubSystemClass subsystem);
	public boolean hasVariableService(SubSystemClass subsystem);
	
	public List<Attribute> getDynConfigReadAttributes(String actorInstance);
	public List<Attribute> getDynConfigWriteAttributes(String actorInstance);
	
	public List<Attribute> getDynConfigReadAttributes(ActorClass actor);
	public List<Attribute> getDynConfigWriteAttributes(ActorClass actor);
	
}
