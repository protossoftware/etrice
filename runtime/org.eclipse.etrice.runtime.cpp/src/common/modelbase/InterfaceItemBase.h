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

#ifndef INTERFACEITEMBASE_H_
#define INTERFACEITEMBASE_H_

#include "common/messaging/AbstractMessageReceiver.h"
#include "common/messaging/Address.h"
#include "common/messaging/IMessageService.h"
#include "common/modelbase/IInterfaceItem.h"

namespace etRuntime {

class IReplicatedInterfaceItem;
class IInterfaceItemOwner;
class IEventReceiver;
class IMessageService;

class InterfaceItemBase: public AbstractMessageReceiver, public virtual IInterfaceItem {
public:
	static void connect(IRTObject* obj, const String& path1, const String& path2);

	virtual ~InterfaceItemBase();

	// TODO JH sync on several member functions needed
	IInterfaceItem* connectWith(IInterfaceItem* peer);
	void disconnect();
	int getLocalId() const {
		return m_localId;
	}

	int getIdx() const {
		return m_idx;
	}

	IEventReceiver* getActor() const;

	virtual String toString() const;
protected:
	InterfaceItemBase(IInterfaceItemOwner* owner, const String& name, int localId, int idx);

	IMessageReceiver* getMsgReceiver() const {
		return m_ownMsgReceiver;
	}

	const Address& getPeerAddress() const {
		return m_peerAddress;
	}

	IMessageReceiver* getPeerMsgReceiver() const {
		return m_peerMsgReceiver;
	}

	void init(void);
	virtual void destroy();


private:
	int m_localId;
	int m_idx;
	Address m_peerAddress;
	IInterfaceItem* m_peer;
	IMessageService* m_ownMsgReceiver;
	IMessageReceiver* m_peerMsgReceiver;

	IReplicatedInterfaceItem* m_replicator;

	void disconnectInternal();

	InterfaceItemBase();
	InterfaceItemBase(InterfaceItemBase const&);
	InterfaceItemBase& operator =(InterfaceItemBase const&);

};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
