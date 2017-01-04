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

namespace etRuntime {

const String RTSystemProtocol::RT_SYSTEM_PORT_NAME = "RTSystemPort";

RTSystemPort::RTSystemPort(IInterfaceItemOwner* actor, int localId) :
		RTSystemServicesProtocolPort(actor, RTSystemProtocol::RT_SYSTEM_PORT_NAME.c_str(), localId) {
}

RTSystemConjPort::RTSystemConjPort(IInterfaceItemOwner* actor, int localId) :
		RTSystemServicesProtocolConjReplPort(actor, RTSystemProtocol::RT_SYSTEM_PORT_NAME.c_str(), localId) {
}

InterfaceItemBase* RTSystemConjPort::createInterfaceItem(IInterfaceItemOwner* rcv, const String& name, int lid, int idx) {
	return new RTSystemConjSubPort(rcv, name, lid, idx);
}

RTSystemConjSubPort::RTSystemConjSubPort(IInterfaceItemOwner* actor, const String& name, int localId, int idx) :
		RTSystemServicesProtocolConjPort(actor, name.c_str(), localId, idx) {
}

}  // namespace etRuntime

