package org.eclipse.etrice.examples.dynamicactors5;

import org.eclipse.etrice.examples.dynamicactors5.Optional;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

public class OptionalFactory implements IOptionalActorFactory {
	
	public Optional create(OptionalActorInterfaceBase ai, String name) {
		// instantiate sub tree
		Optional actor = new Optional(ai, name);
		
		// wiring
		InterfaceItemBase.connect(ai, "p0", name+"/p0");
		
		return actor;
	}
}
