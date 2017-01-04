/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

#include "common/messaging/RTObject.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/modelbase/ReplicatedInterfaceItemBase.h"

namespace etRuntime {

ReplicatedInterfaceItemBase::ReplicatedInterfaceItemBase(IInterfaceItemOwner* owner, const String& name, int localId) :
		RTObject(owner, name),
		m_localId(localId),
		m_items(),
		m_releasedIndices() {
}

ReplicatedInterfaceItemBase::~ReplicatedInterfaceItemBase() {
	for(Vector<InterfaceItemBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		delete *it;
	}
}

InterfaceItemBase* ReplicatedInterfaceItemBase::createSubInterfaceItem() {
	int newIndex = getFreeIndex();
	char buffer[64];
	sprintf(buffer, "%s%c%d", getName().c_str(), SEP, newIndex);

	InterfaceItemBase* item = createInterfaceItem(this, buffer, m_localId, newIndex);
	m_items.push_back(item);
	return item;
}

void ReplicatedInterfaceItemBase::removeItem(InterfaceItemBase& item) {
	Vector<InterfaceItemBase*>::iterator it = m_items.begin();
	while (it != m_items.end() && *it != &item) {
		++it;
	}
	if (it != m_items.end()) {
		m_items.erase(it);
		m_releasedIndices.push_back(item.getIdx());
	}
}

int ReplicatedInterfaceItemBase::getFreeIndex() {
	if (m_releasedIndices.empty())
		return m_items.size();
	else {
		int idx = m_releasedIndices.front();
		m_releasedIndices.pop_back();

		return idx;
	}
}

InterfaceItemBase* ReplicatedInterfaceItemBase::getInterfaceItem(int idx) const {
	for (Vector<InterfaceItemBase*>::const_iterator it = m_items.begin(); it != m_items.end(); ++it) {
		if ((*it)->getIdx() == idx)
			return *it;
	}

	return 0;
}

IEventReceiver* ReplicatedInterfaceItemBase::getEventReceiver() const {
	return dynamic_cast<IEventReceiver*>(getParent());
}

IReplicatedInterfaceItem* ReplicatedInterfaceItemBase::getSystemPort() const {
	return dynamic_cast<IInterfaceItemOwner*>(getParent())->getSystemPort();
}

String ReplicatedInterfaceItemBase::toString() const {
	return String("replicated port ") + getName();
}

IInterfaceItem* ReplicatedInterfaceItemBase::connectWith(IInterfaceItem* peer) {
	// TODO JH dynamic
//	if (peer instanceof InterfaceItemBroker)
//		return peer.connectWith(this);
//	else
	return peer->connectWith(createSubInterfaceItem());
}

}  // namespace etRuntime

