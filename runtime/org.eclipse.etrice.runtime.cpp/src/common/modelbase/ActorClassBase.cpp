/*
 * ActorClassBase.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "ActorClassBase.h"

namespace etRuntime {

ActorClassBase::ActorClassBase(IRTObject* parent, std::string name, Address ownAddr, Address systemPortPeerAddr)
	: 	EventReceiver(parent, name),
		IMessageReceiver(),
		m_state(0),
		history(0), //to be instantiated by derived class
		m_RTSystemPort(0),
		m_className("noname"),
		m_ownAddr(ownAddr),
		m_ownMsgsvc(RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(ownAddr.m_threadID)) {

	// own ports
	m_RTSystemPort = new RTSystemServicesProtocolPort(*this, this, "RTSystemPort", 0, 0, ownAddr,
		systemPortPeerAddr);
}

ActorClassBase::~ActorClassBase() {
	delete m_RTSystemPort;
	m_RTSystemPort = 0;
	delete history;
	history = 0;
}

bool ActorClassBase::handleSystemEvent(InterfaceItemBase* ifitem, int evt, void* generic_data) {
	if ((ifitem != 0) && (ifitem->getLocalId() != 0)) {
		return false;
	}

	switch (evt) {
	case RTSystemServicesProtocol::IN_executeInitialTransition:
		executeInitTransition();
		break;
	case RTSystemServicesProtocol::IN_startDebugging:
		break;
	case RTSystemServicesProtocol::IN_stopDebugging:
		break;
	default:
		return false;
	}
	return true;
}

std::string ActorClassBase::toString() {
	return "ActorClass(className=" + m_className + ", instancePath=" + getInstancePath() + ")";
}

} /* namespace etRuntime */
