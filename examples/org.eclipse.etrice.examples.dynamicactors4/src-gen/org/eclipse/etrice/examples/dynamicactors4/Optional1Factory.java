package org.eclipse.etrice.examples.dynamicactors4;

import org.eclipse.etrice.examples.dynamicactors4.Optional1;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;

public class Optional1Factory implements IOptionalActorFactory {
	
	private PathToPeers path2peers = new PathToPeers();
	
	public Optional1 create(OptionalActorInterfaceBase ai, String name) {
		// set port mappings of this sub tree
		path2peers.put("/sub1/p0", "/p0");
		path2peers.put("/sub1/hlp", "/sub1/helper/p0");
		path2peers.put("/sub1/helper/p0", "/sub1/hlp");
		ai.setPath2peers(path2peers);
		
		// instantiate sub tree
		Optional1 actor = new Optional1(ai, name);
		
		ai.setPath2peers(null);
		
		return actor;
	}
}
