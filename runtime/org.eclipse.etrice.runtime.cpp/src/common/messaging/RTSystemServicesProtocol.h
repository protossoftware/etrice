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
	RTSystemServicesProtocol();
	virtual ~RTSystemServicesProtocol();

		// message IDs
		// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
		// error if msgID <= MSG_MIN
		static const int MSG_MIN = 0;
		//IDs for outgoing messages
		static const  int OUT_dummy = 1;

		//IDs for incoming messages
		static const int IN_executeInitialTransition = 2;
		static const int IN_startDebugging = 3;
		static const int IN_stopDebugging = 4;

		//error if msgID >= MSG_MAX
		static const int MSG_MAX = 5;

private:
		static std::string s_messageStrings[];

public:
		static std::string getMessageString(int msg_id);

		//---------------------------------------------------
		// port class
		//---------------------------------------------------
		class RTSystemServicesProtocolPort : public PortBase {
		public:
			RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
					int localId, Address addr, Address peerAddress);

			RTSystemServicesProtocolPort(IEventReceiver& actor, IRTObject* parent, std::string name,
					int localId, int idx, Address addr, Address peerAddress);

			void receive(Message m);	// sent messages
			void dummy();
		};

		//---------------------------------------------------
		// replicated port class
		//---------------------------------------------------
		class RTSystemServicesProtocolPortRepl {
		private:
			int m_replication;
			std::vector<RTSystemServicesProtocolPort> m_ports;

		public:
			//TODO: data type of addr and peerAddress?
			RTSystemServicesProtocolPortRepl(IEventReceiver& actor, IRTObject* parent, std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address> peerAddress);

			int getReplication();
			RTSystemServicesProtocolPort& get(int i);		// outgoing messages
			void dummy();
		};

		//---------------------------------------------------
		// interface for port class
		//---------------------------------------------------
		class IRTSystemServicesProtocolPort {
		public:
			virtual void executeInitialTransition() = 0;
			virtual void startDebugging() = 0;
			virtual void stopDebugging() = 0;

		};

		//---------------------------------------------------
		// port class
		//---------------------------------------------------
		class RTSystemServicesProtocolConjPort : public PortBase {
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
		// replicated port class
		//---------------------------------------------------
		class RTSystemServicesProtocolConjPortRepl {
		private:
			int m_replication;
			std::vector<RTSystemServicesProtocolConjPort> m_ports;

		public:
			//TODO: data type of addr and peerAddress
			RTSystemServicesProtocolConjPortRepl(IEventReceiver& actor, IRTObject* parent,
					std::string name, int localId, const std::vector<Address>& addr, const std::vector<Address> peerAddress);

			int getReplication();
			RTSystemServicesProtocolConjPort& get(int i);

			void executeInitialTransition();
			void startDebugging();
			void stopDebugging();

		};

		//---------------------------------------------------
		// interface for conjugated port class
		//---------------------------------------------------
		class IRTSystemServicesProtocolConjPort {
		public:
			virtual void dummy() = 0;

		};

	};

} /* namespace etRuntime */
#endif /* RTSYSTEMSERVICESPROTOCOL_H_ */
