/*
 * InterfaceItemBaase.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

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
	InterfaceItemBase (IEventReceiver& actor, IRTObject* parent, std::string name, int localId, int idx, Address ownAddress, Address peerAddress);
	virtual ~InterfaceItemBase();

	int getIdx() const  { return m_idx; } ;
	IEventReceiver& getActor() {	return *m_actor; };
	IRTObject& getActorRTObject() {	return *this; };
	int getLocalId() const {return m_localId; };

	void setMsgReceiver(IMessageReceiver& msgReceiver) {	m_ownMsgReceiver = &msgReceiver; };

protected:
	IMessageReceiver* getMsgReceiver() const{ return m_ownMsgReceiver; };
	IMessageReceiver* getPeerMsgReceiver() const { return m_peerMsgReceiver;	};
	Address getPeerAddress() const { return m_peerAddress; };

private:

	int m_idx;
	int m_localId;

	Address m_peerAddress;
	IMessageReceiver* m_ownMsgReceiver;
	IMessageReceiver* m_peerMsgReceiver;
	IEventReceiver* m_actor;

	InterfaceItemBase();

};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
