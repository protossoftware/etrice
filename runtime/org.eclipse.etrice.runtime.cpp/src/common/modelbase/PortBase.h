/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef PORTBASE_H_
#define PORTBASE_H_

#include "common/modelbase/InterfaceItemBase.h"
#include "common/messaging/Address.h"
#include <string>

namespace etRuntime {
class IEventReceiver;

class PortBase : public InterfaceItemBase{
public:
	PortBase (IEventReceiver& actor, IRTObject* parent, std::string name, int localId, int idx, Address address, Address peerAddress)
		: InterfaceItemBase(actor, parent, name, localId, idx, address, peerAddress){};
	PortBase(const PortBase & right)
		: InterfaceItemBase(right) {};


	virtual ~PortBase();

	virtual void send(int evtID);


private:
	PortBase();
	PortBase & operator = (const PortBase& right);

};

} /* namespace etRuntime */
#endif /* PORTBASE_H_ */
