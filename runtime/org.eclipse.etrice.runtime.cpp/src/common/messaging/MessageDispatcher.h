/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef MESSAGEDISPATCHER_H_
#define MESSAGEDISPATCHER_H_

#include "common/containers/Vector.h"
#include "common/containers/Set.h"
#include "common/containers/Map.h"
#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/RTObject.h"



namespace etRuntime {

class MessageDispatcher : public RTObject, public virtual IMessageReceiver {
	public:
		MessageDispatcher(IRTObject* parent, const Address& addr, const String& name);
		virtual ~MessageDispatcher() {}

		Address getFreeAddress();
		void freeAddress(const Address& addr);
		void addMessageReceiver(IMessageReceiver& receiver);
		void removeMessageReceiver(IMessageReceiver& receiver);
		void addPollingMessageReceiver(IMessageReceiver& receiver);
		void removePollingMessageReceiver(IMessageReceiver& receiver);
		void receive(const Message* msg);

		const Address& getAddress() const { return m_address; };

	protected:
		String toString() const;

	private:
		Map<int, IMessageReceiver*> m_local_map;
		Vector<Address> m_freeAdresses;
		Set<IMessageReceiver*> m_pollingMessageReceiver;
		Address m_address;
		int m_nextFreeObjId;

		MessageDispatcher();
		MessageDispatcher(MessageDispatcher const&);
		MessageDispatcher& operator=(MessageDispatcher const&);
};

} /* namespace etRuntime */
#endif /* MESSAGEDISPATCHER_H_ */


