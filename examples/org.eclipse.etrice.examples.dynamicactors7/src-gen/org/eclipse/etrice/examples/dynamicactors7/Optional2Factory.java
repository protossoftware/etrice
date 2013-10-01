package org.eclipse.etrice.examples.dynamicactors7;

import org.eclipse.etrice.examples.dynamicactors7.Optional2;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

public class Optional2Factory implements IOptionalActorFactory {
	
	public Optional2 create(OptionalActorInterfaceBase ai, String name) {
		// instantiate sub tree
		Optional2 actor = new Optional2(ai, name);
		
		// wiring
		InterfaceItemBase.connect(ai, "pout", name+"/sub2/pout");
		InterfaceItemBase.connect(ai, "pin", name+"/sub2/pin");
		
		return actor;
	}
}
