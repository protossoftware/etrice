/**
 * 
 */
package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * @author hrentz
 *
 */
public abstract class SystemPortOwner extends EventReceiver implements IInterfaceItemOwner {

	/**
	 * @param parent
	 * @param name
	 */
	public SystemPortOwner(IRTObject parent, String name) {
		super(parent, name);
	}
	
	public IEventReceiver getEventReceiver() {
		return this;
	}

	@Override
	public IReplicatedInterfaceItem getSystemPort() {
		if (getParent() instanceof IInterfaceItemOwner)
			return ((IInterfaceItemOwner)getParent()).getSystemPort();
		
		return null;
	}
}
