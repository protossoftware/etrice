package org.eclipse.etrice.generator.base;

import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;

public interface IDataConfiguration {

	public static boolean LANGUAGE_SPECIFIC_VALUES = false;
	
	public void doSetup();
	
	public boolean setResources(ResourceSet resource, ILogger logger);
	
	// static configuration
	
	/**
	 * Array formatting: x,x,x,x,x
	 */
	public String getAttrClassConfigValue(ActorClass actor, List<Attribute> path);
	public String getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path);
	public String getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path);
	public String getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path);
	
	public String getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path);
	
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
