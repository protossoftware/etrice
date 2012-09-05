/*
 * RTSystemServicesProtocol.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "RTSystemServicesProtocol.h"
#include "common/modelbase/EventMessage.h"
#include "common/modelbase/EventWithDataMessage.h"

namespace etRuntime {

std::string RTSystemServicesProtocol::s_messageStrings[] =
	{	"MIN",
		"dummy",
		"executeInitialTransition",
		"startDebugging",
		"stopDebugging",
		"MAX"};

RTSystemServicesProtocol::RTSystemServicesProtocol() {
}

RTSystemServicesProtocol::~RTSystemServicesProtocol() {
}

std::string RTSystemServicesProtocol::getMessageString(int msg_id) {
	if (msg_id < MSG_MIN || msg_id > MSG_MAX + 1) {
		// id out of range
		return "Message ID out of range";
	} else {
		return s_messageStrings[msg_id];
	}
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

void RTSystemServicesProtocol::RTSystemServicesProtocolPort::receive(Message m) {
	if (!(m.isEvtMessage()))
		return;
	EventMessage& msg(static_cast<EventMessage&>(m));
	if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
		std::cout << "unknown" << std::endl;
	else {
		if (s_messageStrings[msg.getEvtId()] != "timerTick") {
			// TODOTS: model switch for activation
			DebuggingService::getInstance().addMessageAsyncIn(
					getPeerAddress(), getAddress(),
					s_messageStrings[msg.getEvtId()]);
		}

		if (msg.isEvtMessageWithData())
			getActor().receiveEvent(*this, msg.getEvtId(),
				(static_cast<EventWithDataMessage&>(msg)).getData());
		else
			getActor().receiveEvent(*this, msg.getEvtId(), 0);

	}
};

// sent messages

void RTSystemServicesProtocol::RTSystemServicesProtocolPort::dummy() {

	if (s_messageStrings[OUT_dummy] != "timerTick") {
		// TODOTS: model switch for activation
		DebuggingService::getInstance().addMessageAsyncOut(getAddress(),
				getPeerAddress(), s_messageStrings[OUT_dummy]);
	}
	if (getPeerAddress().isValid())
		getPeerMsgReceiver()->receive(
				new EventMessage(getPeerAddress(), OUT_dummy));

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

int RTSystemServicesProtocol::RTSystemServicesProtocolPortRepl::getReplication() {
	return m_replication;
};

RTSystemServicesProtocol::RTSystemServicesProtocolPort& RTSystemServicesProtocol::RTSystemServicesProtocolPortRepl::get(int i) {
	return m_ports.at(i);
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

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::receive(Message m) {
	if (!(m.isEvtMessage()))
		return;
	EventMessage& msg(static_cast<EventMessage&>(m));
	if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
		std::cout << "unknown" << std::endl;
	else {
		if (s_messageStrings[msg.getEvtId()] != "timerTick") {
			// TODOTS: model switch for activation
			DebuggingService::getInstance().addMessageAsyncIn(
					getPeerAddress(), getAddress(),
					s_messageStrings[msg.getEvtId()]);
		}

		if (msg.isEvtMessageWithData())
			getActor().receiveEvent(*this, msg.getEvtId(),
				(static_cast<EventWithDataMessage&>(msg)).getData());
		else
			getActor().receiveEvent(*this, msg.getEvtId(), 0);


	}
}

// sent messages

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::executeInitialTransition() {

	if (s_messageStrings[IN_executeInitialTransition] != "timerTick") {
		// TODOTS: model switch for activation
		DebuggingService::getInstance().addMessageAsyncOut(getAddress(),
				getPeerAddress(),
				s_messageStrings[IN_executeInitialTransition]);
	}
	if (getPeerAddress().isValid())
		getPeerMsgReceiver()->receive(
				new EventMessage(getPeerAddress(),
						IN_executeInitialTransition));

}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::startDebugging() {

	if (s_messageStrings[IN_startDebugging] != "timerTick") {
		// TODOTS: model switch for activation
		DebuggingService::getInstance().addMessageAsyncOut(getAddress(),
				getPeerAddress(), s_messageStrings[IN_startDebugging]);
	}
	if (getPeerAddress().isValid())
		getPeerMsgReceiver()->receive(
				new EventMessage(getPeerAddress(), IN_startDebugging));

}

void RTSystemServicesProtocol::RTSystemServicesProtocolConjPort::stopDebugging() {

	if (s_messageStrings[IN_stopDebugging] != "timerTick") {
		// TODOTS: model switch for activation
		DebuggingService::getInstance().addMessageAsyncOut(getAddress(),
				getPeerAddress(), s_messageStrings[IN_stopDebugging]);
	}
	if (getPeerAddress().isValid())
		getPeerMsgReceiver()->receive(
				new EventMessage(getPeerAddress(), IN_stopDebugging));

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

int RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::getReplication() {
	return m_replication;
}

RTSystemServicesProtocol::RTSystemServicesProtocolConjPort& RTSystemServicesProtocol::RTSystemServicesProtocolConjPortRepl::get(int i) {
	return m_ports.at(i);
}

// incoming messages

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
