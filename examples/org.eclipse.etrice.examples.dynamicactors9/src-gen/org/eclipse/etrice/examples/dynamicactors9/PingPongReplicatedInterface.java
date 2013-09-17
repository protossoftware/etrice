package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedOptionalActorInterfaceBase;

class PingPongReplicatedInterface extends ReplicatedOptionalActorInterfaceBase {
	//--------------------- brokers for ports on the interface

	//--------------------- interface item IDs
	
	//--------------------- construction
	public PingPongReplicatedInterface (IEventReceiver parent, String name) {
		super(parent, name, "PingPong");
		
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
