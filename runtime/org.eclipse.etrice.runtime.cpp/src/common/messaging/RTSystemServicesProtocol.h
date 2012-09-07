/*
 * RTSystemServicesProtocol.h
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef RTSYSTEMSERVICESPROTOCOL_H_
#define RTSYSTEMSERVICESPROTOCOL_H_
#include "common/debugging/DebuggingService.h"
#include "common/modelbase/PortBase.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/messaging/Address.h"
#include <vector>

namespace etRuntime {

class RTSystemServicesProtocol {
public:
	class Events {
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
			return ((Events::MSG_MIN < evtId) && (evtId < Events::MSG_SEP));
		};
		static bool isValidIncomingEvtID(int evtId) {
			return ((Events::MSG_SEP <= evtId) && (evtId < Events::MSG_MAX));
		};
		static std::string getMessageString(int msg_id);

	private:
			static std::string s_messageStrings[];
	};

	//---------------------------------------------------
	// interface for port class
	//---------------------------------------------------
	class IRTSystemServicesProtocolPort {
	public:
		virtual void dummy() = 0;
	};

	//---------------------------------------------------
	// interface for conjugated port class
	//---------------------------------------------------
	class IRTSystemServicesProtocolConjPort {
	public:
		virtual void executeInitialTransition() = 0;
		virtual void startDebugging() = 0;
		virtual void stopDebugging() = 0;
	};

public:

	RTSystemServicesProtocol();
	virtual ~RTSystemServicesProtocol();

	//---------------------------------------------------
	// port class
	//---------------------------------------------------
	class RTSystemServicesProtocolPort : public PortBase , public IRTSystemServicesProtocolPort {
	public:
		RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
				int localId, Address addr, Address peerAddress);

		RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
				int localId, int idx, Address addr, Address peerAddress);

		void receive(Message m);
		// sent messages
		void dummy();
	};

	//---------------------------------------------------
	// replicated port class
	//---------------------------------------------------
	class RTSystemServicesProtocolPortRepl: public IRTSystemServicesProtocolPort {
	private:
		int m_replication;
		std::vector<RTSystemServicesProtocolPort> m_ports;

	public:
		//TODO: data type of addr and peerAddress?
		RTSystemServicesProtocolPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId,
										 const std::vector<Address>& addr, const std::vector<Address> peerAddress);

		int getReplication() const { return m_replication; } ;
		RTSystemServicesProtocolPort& get(int i) { return m_ports.at(i); };
		// outgoing messages
		void dummy();
	};


	//---------------------------------------------------
	// conjugated port class
	//---------------------------------------------------
	class RTSystemServicesProtocolConjPort : public PortBase, public IRTSystemServicesProtocolConjPort{
	public:
		RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
				std::string name, int localId, Address addr, Address peerAddress);
		RTSystemServicesProtocolConjPort(IEventReceiver& actor, IRTObject* parent,
				std::string name, int localId, int idx, Address addr,
				Address peerAddress);

		void receive(Message m);
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
		std::vector<RTSystemServicesProtocolConjPort> m_ports;

	public:
		//TODO: data type of addr and peerAddress
		RTSystemServicesProtocolConjPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId,
											 const std::vector<Address>& addr, const std::vector<Address> peerAddress);

		int getReplication() const { return m_replication; } ;
		RTSystemServicesProtocolConjPort& get(int i) { return m_ports.at(i); };

		void executeInitialTransition();
		void startDebugging();
		void stopDebugging();
	};
};

} /* namespace etRuntime */
#endif /* RTSYSTEMSERVICESPROTOCOL_H_ */
