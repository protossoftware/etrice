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

#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTObject.h"
#include "common/messaging/RTServices.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/modelbase/IInterfaceItemOwner.h"
#include "common/modelbase/InterfaceItemBase.h"
#include "common/modelbase/IReplicatedInterfaceItem.h"
#include <string>

namespace etRuntime {

void InterfaceItemBase::connect(IRTObject* obj, const std::string& path1, const std::string& path2) {
	IRTObject* obj1 = obj->getObject(path1);
	IRTObject* obj2 = obj->getObject(path2);

	IInterfaceItem* ifItem1 = dynamic_cast<IInterfaceItem*>(obj1);
	IInterfaceItem* ifItem2 = dynamic_cast<IInterfaceItem*>(obj2);

	if (ifItem1 != 0 && ifItem2 != 0) {
		ifItem1->connectWith(ifItem2);
	}
}

InterfaceItemBase::InterfaceItemBase(IInterfaceItemOwner* owner, const std::string& name, int localId, int idx) :
		AbstractMessageReceiver(owner->getEventReceiver(), name),
		m_localId(localId),
		m_idx(idx),
		m_peerAddress(Address::EMPTY),
		m_peer(0),
		m_ownMsgReceiver(0),
		m_peerMsgReceiver(0),
		m_replicator(0) {

	m_replicator = dynamic_cast<IReplicatedInterfaceItem*>(owner);

	int thread = owner->getEventReceiver()->getThread();
	if (thread >= 0) {
		IMessageService* msgSvc = RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(thread);
		Address addr = msgSvc->getFreeAddress();
		setAddress(addr);
		msgSvc->addMessageReceiver(*this);

		m_ownMsgReceiver = msgSvc;
	}
}

InterfaceItemBase::~InterfaceItemBase() {
	m_peerAddress = Address::EMPTY;
	m_ownMsgReceiver = 0;
	m_peerMsgReceiver = 0;
}

IInterfaceItem* InterfaceItemBase::connectWith(IInterfaceItem* peer) {
	if (peer != 0) {
		m_peer = peer;

//			if (peer instanceof IInterfaceItemBroker) {
//				this.peer = peer.connectWith(this);
//				return this.peer;
//			}

		IReplicatedInterfaceItem* replPeer = dynamic_cast<IReplicatedInterfaceItem*>(m_peer);
		if (replPeer != 0) {
			m_peer = replPeer->createSubInterfaceItem();
		}

		InterfaceItemBase* ifItemPeer = dynamic_cast<InterfaceItemBase*>(m_peer);
		if (ifItemPeer != 0) {
			// connect with each other
			m_peerAddress = ifItemPeer->getAddress();
			ifItemPeer->m_peerAddress = getAddress();
			m_peerMsgReceiver = ifItemPeer->m_ownMsgReceiver;
			ifItemPeer->m_peerMsgReceiver = m_ownMsgReceiver;
		}

	}

	return peer;
}

void InterfaceItemBase::disconnect() {
	disconnectInternal();
	if (m_peer != 0) {
		InterfaceItemBase* peer = dynamic_cast<InterfaceItemBase*>(m_peer);
		if (peer != 0)
			peer->disconnectInternal();
		m_peer = 0;
	}
}

void InterfaceItemBase::disconnectInternal() {
	m_peerAddress = Address::EMPTY;
	m_peerMsgReceiver = 0;

	if (m_replicator != 0)
		destroy();
}

IEventReceiver* InterfaceItemBase::getActor() const {
	return dynamic_cast<IEventReceiver*>(getParent());
}

void InterfaceItemBase::destroy() {
	if (m_peerAddress.isValid()) {
		disconnect();
	}

	if (m_replicator != 0) {
		m_replicator->removeItem(*this);
	}

	m_ownMsgReceiver->removeMessageReceiver(*this);
	m_ownMsgReceiver->freeAddress(getAddress());

	AbstractMessageReceiver::destroy();
}

std::string InterfaceItemBase::toString() const {
	std::stringstream result;

	result << ((m_replicator != 0) ? "sub " : "");
	result << "port " + getName() << " " << getAddress().toID() << " ";
	if(m_peerMsgReceiver == 0)
		result << "UNCONNECTED";
	else {
		result << " -> ";
		result << ((m_peer != 0) ? m_peer->getName() : "?");
		result << " " << m_peerAddress.toID();
	}

	return result.str();
}

} /* namespace etRuntime */
