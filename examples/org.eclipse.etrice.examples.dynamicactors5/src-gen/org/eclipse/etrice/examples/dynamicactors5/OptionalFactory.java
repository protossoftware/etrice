package org.eclipse.etrice.examples.dynamicactors5;

import org.eclipse.etrice.examples.dynamicactors5.Optional;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;

public class OptionalFactory implements IOptionalActorFactory {
	
	private PathToPeers path2peers = new PathToPeers();
	
	public Optional create(OptionalActorInterfaceBase ai, String name) {
		// set port mappings of this sub tree
		ai.setPath2peers(path2peers);
		
		// instantiate sub tree
		Optional actor = new Optional(ai, name);
		
		ai.setPath2peers(null);
		
		return actor;
	}
}
