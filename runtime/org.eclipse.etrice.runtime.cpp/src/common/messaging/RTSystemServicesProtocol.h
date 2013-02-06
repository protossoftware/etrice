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

#ifndef RTSYSTEMSERVICESPROTOCOL_H_
#define RTSYSTEMSERVICESPROTOCOL_H_

#include "common/modelbase/PortBase.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/messaging/Address.h"
#include <vector>
#include <string>
#include <memory>

namespace etRuntime {

//---------------------------------------------------
// interface for port class
//---------------------------------------------------
class IRTSystemServicesProtocolPort {
public:
	virtual ~IRTSystemServicesProtocolPort() {};
	virtual void dummy() = 0;
};

//---------------------------------------------------
// interface for conjugated port class
//---------------------------------------------------
class IRTSystemServicesProtocolConjPort {
public:
	virtual ~IRTSystemServicesProtocolConjPort() {};
	virtual void executeInitialTransition() = 0;
	virtual void startDebugging() = 0;
	virtual void stopDebugging() = 0;
};


class RTSystemServicesProtocol {
public:
		enum eventIDs {
			MSG_MIN = 0,
			OUT_dummy = 1,
			MSG_SEP = 2,
			IN_executeInitialTransition = 2,
			IN_startDebugging = 3,
			IN_stopDebugging = 4,
			MSG_MAX = 5
		};
		static bool isValidEvtID(int evtId) {
			return ((MSG_MIN < evtId) && (evtId < MSG_MAX));
		};
		static bool isValidOutgoingEvtID(int evtId) {
			return ((MSG_MIN < evtId) && (evtId < MSG_SEP));
		};
		static bool isValidIncomingEvtID(int evtId) {
			return ((MSG_SEP <= evtId) && (evtId < MSG_MAX));
		};
		static std::string getMessageString(int msg_id);

	private:
		static std::string s_messageStrings[];

		RTSystemServicesProtocol();
		virtual ~RTSystemServicesProtocol();
};

	//---------------------------------------------------
	// port class
	//---------------------------------------------------
	class RTSystemServicesProtocolPort : public PortBase , public IRTSystemServicesProtocolPort {
	public:
		RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
				int localId, Address addr, Address peerAddress, bool doRegistration = true);

		RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
				int localId, int idx, Address addr, Address peerAddress, bool doRegistration = true);

		virtual void receive(Message* m);
		// sent messages
		void dummy();
	};

	//---------------------------------------------------
	// replicated port class
	//---------------------------------------------------
	class RTSystemServicesProtocolPortRepl: public IRTSystemServicesProtocolPort {
	private:
		int m_replication;
		RTSystemServicesProtocolPort* m_ports;

	public:
		RTSystemServicesProtocolPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId,
										 const std::vector<Address>& addr, const std::vector<Address> peerAddress);

		int getReplication() const { return m_replication; } ;
		RTSystemServicesProtocolPort& get(int i) { return m_ports[i]; };
		// outgoing messages
		void dummy();
	};


	//---------------------------------------------------
	// conjugated port class
	//---------------------------------------------------
	class RTSystemServicesProtocolConjPort : public PortBase, public IRTSystemServicesProtocolConjPort{
	public:
		RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
				std::string name, int localId, Address addr, Address peerAddress, bool doRegistration = true);
		RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
				std::string name, int localId, int idx, Address addr,
				Address peerAddress, bool doRegistration = true);

		virtual void receive(Message* m);
		void executeInitialTransition();
		void startDebugging();
		void stopDebugging();
	};

	//---------------------------------------------------
	// replicated conjugated port class
	//---------------------------------------------------
	class RTSystemServicesProtocolConjPortRepl : public IRTSystemServicesProtocolConjPort{
	private:
		int m_replication;
		RTSystemServicesProtocolConjPort* m_ports;  //dynamic array used instead of vector to avoid copy construction

	public:
		RTSystemServicesProtocolConjPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId,
											 const std::vector<Address>& addr, const std::vector<Address>& peerAddress);

		int getReplication() const { return m_replication; } ;
		RTSystemServicesProtocolConjPort& get(int i) { return m_ports[i]; };

		void executeInitialTransition();
		void startDebugging();
		void stopDebugging();
	};

} /* namespace etRuntime */
#endif /* RTSYSTEMSERVICESPROTOCOL_H_ */
