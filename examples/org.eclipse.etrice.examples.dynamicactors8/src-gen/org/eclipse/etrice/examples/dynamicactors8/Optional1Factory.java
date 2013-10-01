package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.examples.dynamicactors8.Optional1;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

public class Optional1Factory implements IOptionalActorFactory {
	
	public Optional1 create(OptionalActorInterfaceBase ai, String name) {
		// instantiate sub tree
		Optional1 actor = new Optional1(ai, name);
		
		// wiring
		InterfaceItemBase.connect(ai, "fct", name+"/sub/fct");
		
		return actor;
	}
}
