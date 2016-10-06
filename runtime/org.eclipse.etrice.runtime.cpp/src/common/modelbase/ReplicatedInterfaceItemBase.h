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
#ifndef SRC_COMMON_MODELBASE_REPLICATEDINTERFACEITEMBASE_H_
#define SRC_COMMON_MODELBASE_REPLICATEDINTERFACEITEMBASE_H_

#include "common/modelbase/IInterfaceItemOwner.h"
#include "common/modelbase/InterfaceItemBase.h"
#include "common/modelbase/IReplicatedInterfaceItem.h"
#include <queue>
#include <string>
#include <vector>

namespace etRuntime {

class ReplicatedInterfaceItemBase: public RTObject,
		public virtual IReplicatedInterfaceItem,
		public virtual IInterfaceItemOwner {

public:
	static const char SEP = ':';

	virtual ~ReplicatedInterfaceItemBase(){}

	virtual InterfaceItemBase* createSubInterfaceItem();
	virtual void removeItem(InterfaceItemBase& item);

	InterfaceItemBase* getInterfaceItem(int idx) const;
	int getNInterfaceItems() const {
		return m_items.size();
	}

	int getLocalId() const {
		return m_localId;
	}

	virtual IEventReceiver* getEventReceiver() const;
	virtual IReplicatedInterfaceItem* getSystemPort() const;

	std::string toString() const;

	virtual IInterfaceItem* connectWith(IInterfaceItem* peer);

protected:

	ReplicatedInterfaceItemBase(IInterfaceItemOwner* owner, const std::string& name, int localId);

	std::vector<InterfaceItemBase*>& getItems() {
		return m_items;
	}

	virtual InterfaceItemBase* createInterfaceItem(IInterfaceItemOwner* rcv, const std::string& name, int lid, int idx) = 0;
private:
	int m_localId;
	std::vector<InterfaceItemBase*> m_items;
	std::queue<int> m_releasedIndices;

	int getFreeIndex();

	ReplicatedInterfaceItemBase();
	ReplicatedInterfaceItemBase(ReplicatedInterfaceItemBase const&);
	ReplicatedInterfaceItemBase& operator=(ReplicatedInterfaceItemBase const&);
};

}  // namespace etRuntime

#endif /* SRC_COMMON_MODELBASE_REPLICATEDINTERFACEITEMBASE_H_ */
