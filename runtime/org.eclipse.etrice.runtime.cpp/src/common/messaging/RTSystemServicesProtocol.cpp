/*
 * RTSystemServicesProtocol.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "RTSystemServicesProtocol.h"

namespace etRuntime {

std::string RTSystemServicesProtocol::Events::s_messageStrings[] =
	{	"MIN",
		"dummy",
		"executeInitialTransition",
		"startDebugging",
		"stopDebugging",
		"MAX"};

std::string RTSystemServicesProtocol::Events::getMessageString(int msg_id) {
	if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {
		return s_messageStrings[msg_id];
	} else {
		// id out of range
		return "Message ID out of range";
	}
}

//------------------------------------------------------------------
// RTSystemServicesProtocol: surrounding class
//------------------------------------------------------------------


RTSystemServicesProtocol::RTSystemServicesProtocol() {
}

RTSystemServicesProtocol::~RTSystemServicesProtocol() {
}


//------------------------------------------------------------------
// RTSystemServicesProtocolPort
//------------------------------------------------------------------

RTSystemServicesProtocol::RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
		int localId, Address addr, Address peerAddress)
:PortBase(actor, parent, name, localId, 0, addr, peerAddress)
{
	DebuggingService::getInstance().addPortInstance(*this);
};

RTSystemServicesProtocol::RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
		int localId, int idx, Address addr, Address peerAddress)
: PortBase(actor, parent, name, localId, idx, addr, peerAddress)
{
	DebuggingService::getInstance().addPortInstance(*this);
};

void RTSystemServicesProtocol::RTSystemServicesProtocolPort::receive(Message msg) {
	if (! Events::isValidIncomingEvtID(msg.getEvtId())) {
		std::cout << "unknown" << std::endl;
	}
	else {
		if (msg.hasDebugFlagSet()) {			// TODO: model switch for activation of this flag
			DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), Events::getMessageString(msg.getEvtId()));
		}
		getActor().receiveEvent(*this, msg.getEvtId(),	msg.getData());
	}
};

// sent messages

void RTSystemServicesProtocol::RTSystemServicesProtocolPort::dummy() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		Events::getMessageString(Events::OUT_dummy));
	PortBase::send(Events::OUT_dummy);
};

//------------------------------------------------------------------
// RTSystemServicesProtocolPortRepl
//------------------------------------------------------------------


RTSystemServicesProtocol::RTSystemServicesProtocolPortRepl::
RTSystemServicesProtocolPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address> peerAddress)
: m_replication(addr.size()),
  m_ports()
{
	char numstr[10]; // enough to hold all numbers up to 32-bits

	m_ports.reserve(m_replication);
	for (int i = 0; i < m_replication; ++i) {
		snprintf(numstr, sizeof(numstr), "%d", i);
		m_ports.push_back(RTSystemServicesProtocolPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]));
	}
};

// outgoing messages

void RTSystemServicesProtocol::RTSystemServicesProtocolPortRepl::dummy() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports.at(i).dummy();
	}
};

//------------------------------------------------------------------
// RTSystemServicesProtocolConjPort
//------------------------------------------------------------------

RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
		std::string name, int localId, Address addr, Address peerAddress)
			: PortBase(actor, parent, name, localId, 0, addr, peerAddress)
{
	DebuggingService::getInstance().addPortInstance(*this);
}
RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
		std::string name, int localId, int idx, Address addr,
		Address peerAddress)
: PortBase(actor, parent, name, localId, idx, addr, peerAddress)
{
	DebuggingService::getInstance().addPortInstance(*this);
}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::receive(Message msg) {
	if (! Events::isValidOutgoingEvtID(msg.getEvtId())) {  //conjugated port receives out-messages
		std::cout << "unknown" << std::endl;
	}
	else {
		if (msg.hasDebugFlagSet()) {			// TODO: model switch for activation of this flag
			DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), Events::getMessageString(msg.getEvtId()));
		}
		getActor().receiveEvent(*this, msg.getEvtId(),	msg.getData());
	}
}

// sent messages

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::executeInitialTransition() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		Events::getMessageString(Events::IN_executeInitialTransition));
	PortBase::send(Events::IN_executeInitialTransition);
}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::startDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		Events::getMessageString(Events::IN_startDebugging));
	PortBase::send(Events::IN_startDebugging);
}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::stopDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		Events::getMessageString(Events::IN_stopDebugging));
	PortBase::send(Events::IN_stopDebugging);
}

//------------------------------------------------------------------
// RTSystemServicesProtocolConjPortRepl
//------------------------------------------------------------------

//TODO: data type of addr and peerAddress
RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::
RTSystemServicesProtocolConjPortRepl(IEventReceiver& actor,	IRTObject* parent, std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address> peerAddress)
: m_replication(addr.size()),
  m_ports()
{
	char numstr[10]; // enough to hold all numbers up to 32-bits

	m_ports.reserve(m_replication);
	for (int i = 0; i < m_replication; ++i) {
		snprintf(numstr, sizeof(numstr), "%d", i);
		m_ports.push_back(RTSystemServicesProtocolConjPort(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]));
	}
};

// sent messages

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::executeInitialTransition() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports.at(i).executeInitialTransition();
	}
}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::startDebugging() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports.at(i).startDebugging();
	}
}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::stopDebugging() {
	for (int i = 0; i < m_replication; ++i) {
		m_ports.at(i).stopDebugging();
	}
}


} /* namespace etRuntime */
