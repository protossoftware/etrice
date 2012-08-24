/*
 * InterfaceItemBaase.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "InterfaceItemBase.h"

namespace etRuntime {

InterfaceItemBase::InterfaceItemBase (const IEventReceiver& actor, std::string name, int localId, int idx, Address ownAddress, Address peerAddress)
: AbstractMessageReceiver(actor, ownAddress, name),
  m_idx(idx),
  m_localId(localId),
  m_peerAddress(peerAddress),
  m_ownMsgReceiver(RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(ownAddress.m_threadID)),
  m_peerMsgReceiver(peerAddress.isValid()? RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(peerAddress.m_threadID): 0)
{
	if (getAddress()!=null && this.ownMsgReceiver instanceof MessageService) {
		MessageService ms = (MessageService) this.ownMsgReceiver;
		// register at the own dispatcher to receive messages
		ms.getMessageDispatcher().addMessageReceiver(this);
}

InterfaceItemBase::~InterfaceItemBase() {
	// TODO Auto-generated destructor stub
}

} /* namespace etRuntime */
