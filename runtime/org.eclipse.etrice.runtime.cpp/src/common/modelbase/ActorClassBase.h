/*
 * ActorClassBase.h
 *
 * The base class for model actor classes.
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef ACTORCLASSBASE_H_
#define ACTORCLASSBASE_H_

#include "common/modelbase/EventReceiver.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/RTServices.h"
#include "common/messaging/RTSystemServicesProtocol.h"

namespace etRuntime {

class ActorClassBase: public EventReceiver, public IMessageReceiver {
public:
	ActorClassBase(IRTObject* parent, std::string name, Address ownAddr, Address systemPortPeerAddr);
	virtual ~ActorClassBase();

	std::string toString();
	std::string getClassName() const {	return m_className;	}
	void setClassName(std::string className) {		m_className = className;	}
	virtual Address getAddress() const {
		// TODO: Actor should have its own address for services and debugging
		return Address(0,0,0);
	}

	//--------------------- lifecycle functions
	// automatically generated lifecycle functions
	virtual void init() = 0;
	virtual void start() = 0;
	virtual void stop() = 0;
	virtual void destroy() = 0;
	virtual void executeInitTransition() = 0;

	// not automatically generated lifecycle functions
	// are called, but with empty implementation -> can be overridden by user
	void initUser() {	}
	void startUser() {	}
	void stopUser() {	}
	void destroyUser() {	}
	virtual void receive(Message* msg) {	}

	int getState() const {	return m_state; 	}
	MessageService* getMsgsvc() const {	return m_ownMsgsvc; 	}

protected:
	static const int EVT_SHIFT = 1000;	// TODOHRR: use 256 or shift operation later
	static const int NO_STATE = 0;
	static const int STATE_TOP = 1;
	static const int NOT_CAUGHT = 0;

	/**
	 * the current state
	 */
	int m_state;
	RTSystemServicesProtocolPort* m_RTSystemPort;

	virtual bool handleSystemEvent(const InterfaceItemBase& ifitem, int evt, void* generic_data);
private:
	std::string m_className;
	Address m_ownAddr;
	MessageService* m_ownMsgsvc;

};

} /* namespace etRuntime */
#endif /* ACTORCLASSBASE_H_ */
