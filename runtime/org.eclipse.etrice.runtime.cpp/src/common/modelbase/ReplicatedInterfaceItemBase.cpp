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
#include "common/debugging/MSCFunctionObject.h"
#include <iterator>
#include <queue>
#include <string>
#include <vector>

namespace etRuntime {

ReplicatedInterfaceItemBase::ReplicatedInterfaceItemBase(IInterfaceItemOwner* owner, const std::string& name, int localId) :
		RTObject(owner, name),
		m_localId(localId),
		m_items(),
		m_releasedIndices() {
}

ReplicatedInterfaceItemBase::~ReplicatedInterfaceItemBase() {
	for(std::vector<InterfaceItemBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		delete *it;
	}
}

InterfaceItemBase* ReplicatedInterfaceItemBase::createSubInterfaceItem() {
	int newIndex = getFreeIndex();
	std::stringstream itemName;
	itemName << getName() << SEP << newIndex;

	InterfaceItemBase* item = createInterfaceItem(this, itemName.str(), m_localId, newIndex);
	m_items.push_back(item);
	return item;
}

void ReplicatedInterfaceItemBase::removeItem(InterfaceItemBase& item) {
	std::vector<InterfaceItemBase*>::iterator it = m_items.begin();
	while (it != m_items.end() && *it != &item) {
		++it;
	}
	if (it != m_items.end()) {
		m_items.erase(it);
		m_releasedIndices.push(item.getIdx());
	}
}

int ReplicatedInterfaceItemBase::getFreeIndex() {
	if (m_releasedIndices.empty())
		return m_items.size();
	else {
		int idx = m_releasedIndices.front();
		m_releasedIndices.pop();

		return idx;
	}
}

InterfaceItemBase* ReplicatedInterfaceItemBase::getInterfaceItem(int idx) const {
	for (std::vector<InterfaceItemBase*>::const_iterator it = m_items.begin(); it != m_items.end(); ++it) {
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

std::string ReplicatedInterfaceItemBase::toString() const {
	return "replicated port " + getName();
}

IInterfaceItem* ReplicatedInterfaceItemBase::connectWith(IInterfaceItem* peer) {
	// TODO JH dynamic
//	if (peer instanceof InterfaceItemBroker)
//		return peer.connectWith(this);
//	else
	return peer->connectWith(createSubInterfaceItem());
}

}  // namespace etRuntime

