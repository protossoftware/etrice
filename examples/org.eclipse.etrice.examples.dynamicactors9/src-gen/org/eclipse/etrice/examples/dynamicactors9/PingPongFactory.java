package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.examples.dynamicactors9.PingPong;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;

public class PingPongFactory implements IOptionalActorFactory {
	
	private PathToPeers path2peers = new PathToPeers();
	
	public PingPong create(OptionalActorInterfaceBase ai, String name) {
		// set port mappings of this sub tree
		path2peers.put("/receiver/sender", "/sender/receiver");
		path2peers.put("/receiver/timing", "/room_basic_service_timing_PTimer");
		path2peers.put("/sender/receiver", "/receiver/sender");
		ai.setPath2peers(path2peers);
		
		// instantiate sub tree
		PingPong actor = new PingPong(ai, name);
		
		ai.setPath2peers(null);
		
		return actor;
	}
}
