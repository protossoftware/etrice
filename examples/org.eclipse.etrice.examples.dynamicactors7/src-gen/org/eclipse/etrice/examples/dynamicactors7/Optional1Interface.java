package org.eclipse.etrice.examples.dynamicactors7;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
import org.eclipse.etrice.runtime.java.modelbase.ScalarOptionalActorInterfaceBase;

class Optional1Interface extends ScalarOptionalActorInterfaceBase {
	//--------------------- brokers for ports on the interface
	protected InterfaceItemBroker pout = null;
	protected InterfaceItemBroker pin = null;

	//--------------------- interface item IDs
	public static final int IFITEM_pout = 1;
	public static final int IFITEM_pin = 2;
	
	//--------------------- construction
	public Optional1Interface (IEventReceiver parent, String name) {
		super(parent, name, "Optional1");
		
		pout = new InterfaceItemBroker(this, "pout", IFITEM_pout);
		pin = new InterfaceItemBroker(this, "pin", IFITEM_pin);
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
