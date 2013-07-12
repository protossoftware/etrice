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
		MessageDispatcher(IRTObject* parent, Address addr, std::string name);
		virtual ~MessageDispatcher();

		void addMessageReceiver(IMessageReceiver& receiver);
		void receive(Message* msg);

		Address getAddress() const { return m_address; };

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


