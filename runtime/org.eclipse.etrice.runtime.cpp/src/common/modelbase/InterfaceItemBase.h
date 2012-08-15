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

namespace etRuntime {
class IEventReceiver;


class InterfaceItemBase {
public:
	InterfaceItemBase (const IEventReceiver& actor, const char* name, int localId, int idx, Address ownAddress, Address peerAddress)
	: m_idx(idx),
	  m_localId(localId),
	  m_peerAddress(peerAddress),
	  m_ownAddress(ownAddress),
	  m_ownMsgReceiver(),
	  m_peerMsgReceiver(),
	  m_parent(actor)
	  {};

	virtual ~InterfaceItemBase();
	int getIdx() const  { return m_idx; } ;
	void setMsgReceiver(IMessageReceiver msgReceiver) {
		m_ownMsgReceiver = msgReceiver;
	};
	IEventReceiver getActor() {
		return m_parent;
	};

	int getLocalId() {return m_localId; };

protected:
	IMessageReceiver getMsgReceiver() const{
		return m_ownMsgReceiver;
	};

	IMessageReceiver getPeerMsgReceiver() const {
		return m_peerMsgReceiver;
	};
	Address getPeerAddress() const {
		return m_peerAddress;
	};
	Address getAddress() const {
		return m_ownAddress;
	};

private:
	InterfaceItemBase();

	int m_idx;
	int m_localId;

	Address m_peerAddress;
	Address m_ownAddress;
	IMessageReceiver m_ownMsgReceiver;
	IMessageReceiver m_peerMsgReceiver;

	IEventReceiver m_parent; //TODO: move to superclass
};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
