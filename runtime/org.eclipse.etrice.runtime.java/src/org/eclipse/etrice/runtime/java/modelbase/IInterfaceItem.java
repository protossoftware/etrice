package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

public interface IInterfaceItem extends IRTObject {

	IInterfaceItem connectWith(IInterfaceItem peer);
}
