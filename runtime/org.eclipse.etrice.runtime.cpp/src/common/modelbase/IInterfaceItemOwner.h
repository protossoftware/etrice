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
#ifndef SRC_COMMON_MODELBASE_IINTERFACEITEMOWNER_H_
#define SRC_COMMON_MODELBASE_IINTERFACEITEMOWNER_H_

#include "common/messaging/IRTObject.h"

namespace etRuntime {

class IReplicatedInterfaceItem;
class IEventReceiver;

class IInterfaceItemOwner: public virtual IRTObject {
public:
	virtual ~IInterfaceItemOwner() {}
	virtual IEventReceiver* getEventReceiver() const = 0;
	virtual IReplicatedInterfaceItem* getSystemPort() const = 0;
};

} /* namespace etRuntime */
#endif /* SRC_COMMON_MODELBASE_IINTERFACEITEMOWNER_H_ */
