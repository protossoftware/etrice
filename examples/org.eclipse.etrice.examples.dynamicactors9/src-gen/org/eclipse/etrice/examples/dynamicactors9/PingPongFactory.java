package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.examples.dynamicactors9.PingPong;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

public class PingPongFactory implements IOptionalActorFactory {
	
	public PingPong create(OptionalActorInterfaceBase ai, String name) {
		// instantiate sub tree
		PingPong actor = new PingPong(ai, name);
		
		// wiring
		InterfaceItemBase.connect(ai, "room_basic_service_timing_PTimer", name+"/receiver/timing");
		
		return actor;
	}
}
