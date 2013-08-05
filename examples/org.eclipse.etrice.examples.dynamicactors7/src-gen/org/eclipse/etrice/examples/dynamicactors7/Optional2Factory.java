package org.eclipse.etrice.examples.dynamicactors7;

import org.eclipse.etrice.examples.dynamicactors7.Optional2;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;

public class Optional2Factory implements IOptionalActorFactory {
	
	private PathToPeers path2peers = new PathToPeers();
	
	public Optional2 create(OptionalActorInterfaceBase ai, String name) {
		// set port mappings of this sub tree
		path2peers.put("/sub2/pout", "/pout");
		path2peers.put("/sub2/pin", "/pin");
		ai.setPath2peers(path2peers);
		
		// instantiate sub tree
		Optional2 actor = new Optional2(ai, name);
		
		ai.setPath2peers(null);
		
		return actor;
	}
}
