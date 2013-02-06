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

#include "InterfaceItemBase.h"
#include "common/messaging/AbstractMessageReceiver.h"
#include "common/messaging/RTServices.h"

namespace etRuntime {

InterfaceItemBase::InterfaceItemBase (IEventReceiver& evtReceiver, IRTObject* parent, std::string name, int localId, int idx, Address ownAddress, Address peerAddress)
: AbstractMessageReceiver(parent, ownAddress, name),
  m_idx(idx),
  m_localId(localId),
  m_actorPath(name),
  m_peerAddress(peerAddress),
  m_ownMsgReceiver(RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(ownAddress.m_threadID)),
  m_peerMsgReceiver(peerAddress.isValid()? RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(peerAddress.m_threadID): 0),
  m_eventReceiver(&evtReceiver)
{
	if (getAddress().isValid() && m_ownMsgReceiver->isMsgService()) {
		MessageService* ms = static_cast<MessageService*>(m_ownMsgReceiver);
		// register at the own dispatcher to receive messages
		ms->getMessageDispatcher().addMessageReceiver(*this);
	}
	if (parent) {
		m_actorPath = parent->getInstancePath();
	}
}

InterfaceItemBase::InterfaceItemBase(const InterfaceItemBase & right)
: AbstractMessageReceiver(right),
  m_idx(right.m_idx),
  m_localId(right.m_localId),
  m_actorPath(right.m_actorPath),
  m_peerAddress(right.m_peerAddress),
  m_ownMsgReceiver(right.m_ownMsgReceiver),
  m_peerMsgReceiver(right.m_peerMsgReceiver),
  m_eventReceiver(right.m_eventReceiver)
{

}


InterfaceItemBase::~InterfaceItemBase() {
	m_ownMsgReceiver = 0;
	m_peerMsgReceiver = 0;
	m_eventReceiver = 0;

}

} /* namespace etRuntime */
