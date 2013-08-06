package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
import org.eclipse.etrice.runtime.java.modelbase.ScalarOptionalActorInterfaceBase;

class OptionalInterface extends ScalarOptionalActorInterfaceBase {
	//--------------------- brokers for ports on the interface
	protected InterfaceItemBroker fct = null;

	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
	
	//--------------------- construction
	public OptionalInterface (IEventReceiver parent, String name) {
		super(parent, name, "Optional");
		
		fct = new InterfaceItemBroker(this, "fct", IFITEM_fct);
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
