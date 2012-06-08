/*
 * InterfaceItemBaase.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef INTERFACEITEMBASE_H_
#define INTERFACEITEMBASE_H_

#include "common/messaging/Address.h"

namespace etRuntime {
class IEventReceiver;


class InterfaceItemBase {
public:
	InterfaceItemBase (const IEventReceiver& actor, char* name, int localId, int idx, Address ownAddress, Address peerAddress){};

	InterfaceItemBase();
	virtual ~InterfaceItemBase();
	int getIdx() { return m_idx; } ;
	void setMsgReceiver(IMessageReceiver msgReceiver) {
		m_ownMsgReceiver = msgReceiver;
	};
	IEventReceiver getActor() {
		return (IEventReceiver) getParent();
	};

	int getLocalId() {return m_localId; };

protected:
	IMessageReceiver getMsgReceiver() {
		return m_ownMsgReceiver;
	};

	IMessageReceiver getPeerMsgReceiver() {
		return m_peerMsgReceiver;
	};
	Address getPeerAddress() {
		return m_peerAddress;
	};

private:
	int m_idx;
	int m_localId;

	Address m_peerAddress;
	IMessageReceiver m_ownMsgReceiver;
	IMessageReceiver m_peerMsgReceiver;
};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
