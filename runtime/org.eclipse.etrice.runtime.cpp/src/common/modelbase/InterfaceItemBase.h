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

#ifndef INTERFACEITEMBASE_H_
#define INTERFACEITEMBASE_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/messaging/AbstractMessageReceiver.h"
#include <string>

namespace etRuntime {
class IEventReceiver;


class InterfaceItemBase : public AbstractMessageReceiver{
public:
	InterfaceItemBase (IEventReceiver& evtReceiver, IRTObject* parentActor, std::string name, int localId, int idx, Address ownAddress, Address peerAddress);
	InterfaceItemBase(const InterfaceItemBase & right);
	virtual ~InterfaceItemBase();

	int getIdx() const  { return m_idx; } ;
	IEventReceiver& getEventReceiver() {	return *m_eventReceiver; };
	std::string& getActorPath() {	return m_actorPath; };
	int getLocalId() const {return m_localId; };

	void setMsgReceiver(IMessageReceiver& msgReceiver) {	m_ownMsgReceiver = &msgReceiver; };

protected:
	IMessageReceiver* getMsgReceiver() const{ return m_ownMsgReceiver; };
	IMessageReceiver* getPeerMsgReceiver() const { return m_peerMsgReceiver;	};
	Address getPeerAddress() const { return m_peerAddress; };

private:

	int m_idx;
	int m_localId;

	std::string m_actorPath;

	Address m_peerAddress;
	IMessageReceiver* m_ownMsgReceiver;
	IMessageReceiver* m_peerMsgReceiver;
	IEventReceiver* m_eventReceiver;

	InterfaceItemBase();
	InterfaceItemBase & operator = (const InterfaceItemBase& right);

};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
