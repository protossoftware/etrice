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
#ifndef SRC_COMMON_MODELBASE_IREPLICATEDINTERFACEITEM_H_
#define SRC_COMMON_MODELBASE_IREPLICATEDINTERFACEITEM_H_

#include "common/modelbase/IInterfaceItem.h"

namespace etRuntime {

class InterfaceItemBase;

class IReplicatedInterfaceItem: public virtual IInterfaceItem {
public:
	virtual ~IReplicatedInterfaceItem() {}

	virtual InterfaceItemBase* createSubInterfaceItem() = 0;
	virtual void removeItem(InterfaceItemBase& item) = 0;
};
} /* namespace etRuntime */

#endif /* SRC_COMMON_MODELBASE_IREPLICATEDINTERFACEITEM_H_ */
