/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef ACTORCLASSBASE_H_
#define ACTORCLASSBASE_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/modelbase/RTSystemProtocol.h"
#include "common/modelbase/SystemPortOwner.h"
#include "etDatatypes.h"

namespace etRuntime {


class ActorClassBase: public SystemPortOwner, public virtual IMessageReceiver {
public:

	virtual ~ActorClassBase();

	const String& getClassName() const {
		return m_className;
	}

	void setClassName(const String& className) {
		m_className = className;
	}

	virtual const Address& getAddress() const {
		// TODO: Actor should have its own address for services and debugging
		return Address::EMPTY;
	}

	virtual void initialize(void);
	virtual void setProbesActive(bool recursive, bool active) {}

	//SubSystemClassBase* getSubSystem() const;

	//--------------------- lifecycle functions
	// automatically generated lifecycle functions
	virtual void init();
	virtual void start();
	virtual void stop();
	virtual void destroy();
	virtual void executeInitTransition() = 0;

	// not automatically generated lifecycle functions
	// are called, but with empty implementation -> can be overridden by user
	virtual void initUser() {
	}
	virtual void startUser() {
	}
	virtual void stopUser() {
	}

	virtual void receive(const Message* msg) {
	}

	int getState() const {
		return m_state;
	}

protected:

	ActorClassBase(IRTObject* parent, const String& name);

	static const int EVT_SHIFT = 1000;	// TODOHRR: use 256 or shift operation later
	static const int NO_STATE = 0;
	static const int STATE_TOP = 1;
	static const int NOT_CAUGHT = 0;
	static const int IFITEM_RTSystemPort = 0;

	/**
	 * the current state
	 */
	int m_state;

	RTSystemPort m_RTSystemPort;

	virtual etBool handleSystemEvent(InterfaceItemBase* ifitem, int evt, void* generic_data);
	String toString() const;
private:
	String m_className;

	ActorClassBase();
	ActorClassBase(ActorClassBase const&);
	ActorClassBase& operator=(ActorClassBase const&);

};

} /* namespace etRuntime */
#endif /* ACTORCLASSBASE_H_ */
