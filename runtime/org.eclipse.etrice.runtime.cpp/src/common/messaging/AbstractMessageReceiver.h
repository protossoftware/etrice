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

#ifndef ABSTRACTMESSAGERECEIVER_H_
#define ABSTRACTMESSAGERECEIVER_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/RTObject.h"
#include <string>

namespace etRuntime {

class AbstractMessageReceiver: public RTObject, public virtual IMessageReceiver {

public:
	Address getAddress() const {
		return m_address;
	}
	virtual ~AbstractMessageReceiver() {};

protected:
	AbstractMessageReceiver(IRTObject* parent, Address address, std::string name)
	: IMessageReceiver(),
	  RTObject(parent, name),
	  m_address(address)
	{

	}

private:
	Address m_address;

	AbstractMessageReceiver();
};


}
#endif /* ABSTRACTMESSAGERECEIVER_H_ */
