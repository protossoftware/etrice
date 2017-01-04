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

namespace etRuntime {

class AbstractMessageReceiver: public RTObject, public virtual IMessageReceiver {

public:

	virtual ~AbstractMessageReceiver() {}

	virtual const Address& getAddress() const {
		return m_address;
	}

protected:
	AbstractMessageReceiver(IRTObject* parent, const String& name) :
			RTObject(parent, name),
			m_address(Address::EMPTY) {
	}

	AbstractMessageReceiver(IRTObject* parent, const Address& address, const String& name) :
			RTObject(parent, name),
			m_address(address) {
	}

	void setAddress(const Address& address) {
		m_address = address;
	}

	virtual String toString() const {
		return getName() + " " + m_address.toID();
	}

private:
	Address m_address;

	AbstractMessageReceiver(AbstractMessageReceiver const&);
	AbstractMessageReceiver& operator=(AbstractMessageReceiver const&);
};

}
#endif /* ABSTRACTMESSAGERECEIVER_H_ */
