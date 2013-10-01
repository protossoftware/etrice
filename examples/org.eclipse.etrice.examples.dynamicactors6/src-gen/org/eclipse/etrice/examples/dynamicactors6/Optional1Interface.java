package org.eclipse.etrice.examples.dynamicactors6;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
import org.eclipse.etrice.runtime.java.modelbase.ScalarOptionalActorInterfaceBase;

class Optional1Interface extends ScalarOptionalActorInterfaceBase {
	//--------------------- brokers for ports on the interface
	protected InterfaceItemBroker p0 = null;

	//--------------------- interface item IDs
	public static final int IFITEM_p0 = 1;
	
	//--------------------- construction
	public Optional1Interface (IEventReceiver parent, String name) {
		super(parent, name, "Optional1");
		
		p0 = new InterfaceItemBroker(this, "p0", IFITEM_p0);
	}
	
	@Override
	protected void logCreation(String actorClass, String name) {
		DebuggingService.getInstance().addMessageActorCreate(this, actorClass, name);
	}
	
	@Override
	protected void logDeletion(String name) {
		DebuggingService.getInstance().addMessageActorDestroy(this, name);
	}
}
