/*
 * MessageDispatcher.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#ifndef MESSAGEDISPATCHER_H_
#define MESSAGEDISPATCHER_H_

#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/IRTObject.h"
#include "common/messaging/RTObject.h"
#include <map>
#include <string>

namespace etRuntime {

class MessageDispatcher : public RTObject, public IMessageReceiver {
public:
	virtual ~MessageDispatcher();
	MessageDispatcher(IRTObject* parent, Address addr, std::string name);
	void addMessageReceiver(IMessageReceiver& receiver);
	void receive(Message* msg);
	Address getAddress() { return m_address; };

private:
	std::map<int, IMessageReceiver*> m_local_map;
	std::map<int, IMessageReceiver*> m_thread_map;
	std::map<int, IMessageReceiver*> m_node_map;
	Address m_address;

	MessageDispatcher();
	MessageDispatcher(const MessageDispatcher& right);
	MessageDispatcher& operator=(const MessageDispatcher& right);
};

} /* namespace etRuntime */
#endif /* MESSAGEDISPATCHER_H_ */


