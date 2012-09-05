/*
 * InterfaceItemBaase.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "InterfaceItemBase.h"
#include "common/messaging/AbstractMessageReceiver.h"
#include "common/messaging/RTServices.h"

namespace etRuntime {

InterfaceItemBase::InterfaceItemBase (IEventReceiver& actor, IRTObject* parent, std::string name, int localId, int idx, Address ownAddress, Address peerAddress)
: AbstractMessageReceiver(parent, ownAddress, name),
  m_idx(idx),
  m_localId(localId),
  m_peerAddress(peerAddress),
  m_ownMsgReceiver(RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(ownAddress.m_threadID)),
  m_peerMsgReceiver(peerAddress.isValid()? RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(peerAddress.m_threadID): 0),
  m_actor(&actor)
{
	if (getAddress().isValid() && m_ownMsgReceiver->isMsgService()) {
		MessageService* ms = static_cast<MessageService*>(m_ownMsgReceiver);
		// register at the own dispatcher to receive messages
		ms->getMessageDispatcher().addMessageReceiver(*this);
	}
}


InterfaceItemBase::~InterfaceItemBase() {
	// TODO Auto-generated destructor stub
}

} /* namespace etRuntime */
