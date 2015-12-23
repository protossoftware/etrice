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

#ifndef IMESSAGERECEIVER_H_
#define IMESSAGERECEIVER_H_

#include "common/messaging/Address.h"
#include "common/messaging/Message.h"
#include "common/messaging/IRTObject.h"

namespace etRuntime {

class IMessageReceiver : public virtual IRTObject{
public:
	virtual ~IMessageReceiver() {}

	virtual void receive(const Message* msg) = 0;
	virtual const Address& getAddress() const = 0;

};

} /* namespace etRuntime */
#endif /* IMESSAGERECEIVER_H_ */
