/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_COMMON_MODELBASE_SYSTEMPORTOWNER_H_
#define SRC_COMMON_MODELBASE_SYSTEMPORTOWNER_H_

#include "common/messaging/RTObject.h"
#include "common/modelbase/EventReceiver.h"
#include "common/modelbase/IInterfaceItemOwner.h"

namespace etRuntime {

class IReplicatedInterfaceItem;

class SystemPortOwner: public EventReceiver, public virtual IInterfaceItemOwner {
public:
	virtual ~SystemPortOwner() {}

	virtual IEventReceiver* getEventReceiver() const {
		return const_cast<SystemPortOwner*>(this);
	}

	virtual IReplicatedInterfaceItem* getSystemPort() const {
		IInterfaceItemOwner* parent = dynamic_cast<IInterfaceItemOwner*>(getParent());
		if (parent != 0) {
			return parent->getSystemPort();
		}

		return 0;
	}

protected:
	SystemPortOwner(IRTObject* parent, const String& name) :
		EventReceiver(parent, name) {
	}

private:
	SystemPortOwner();
	SystemPortOwner(SystemPortOwner const&);
	SystemPortOwner& operator=(SystemPortOwner const&);

};

} /* namespace etRuntime */
#endif /* SRC_COMMON_MODELBASE_SYSTEMPORTOWNER_H_ */
