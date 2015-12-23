/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

#include "common/modelbase/IEventReceiver.h"
#include "common/modelbase/RTSystemProtocol.h"
#include <string>

namespace etRuntime {

const std::string RTSystemProtocol::RT_SYSTEM_PORT_NAME = "RTSystemPort";

RTSystemPort::RTSystemPort(IInterfaceItemOwner* actor, int localId) :
		RTSystemServicesProtocolPort(actor, RTSystemProtocol::RT_SYSTEM_PORT_NAME, localId) {

	// since we have no mapping for the system ports we connect them directly here
	IReplicatedInterfaceItem* systemPort = actor->getSystemPort();
	if (systemPort != 0) {
		InterfaceItemBase* peer = systemPort->createSubInterfaceItem();
		connectWith(peer);
	}
}

RTSystemConjPort::RTSystemConjPort(IInterfaceItemOwner* actor, int localId) :
		RTSystemServicesProtocolConjReplPort(actor, RTSystemProtocol::RT_SYSTEM_PORT_NAME, localId) {
}

InterfaceItemBase* RTSystemConjPort::createInterfaceItem(IInterfaceItemOwner* rcv, const std::string& name, int lid, int idx) {
	return new RTSystemConjSubPort(rcv, name, lid, idx);
}

RTSystemConjSubPort::RTSystemConjSubPort(IInterfaceItemOwner* actor, const std::string& name, int localId, int idx) :
		RTSystemServicesProtocolConjPort(actor, name, localId, idx) {
}

}  // namespace etRuntime

