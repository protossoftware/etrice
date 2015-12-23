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
#ifndef SRC_COMMON_MODELBASE_IINTERFACEITEM_H_
#define SRC_COMMON_MODELBASE_IINTERFACEITEM_H_

#include "common/messaging/IRTObject.h"

namespace etRuntime {

class IInterfaceItem : public virtual IRTObject {
public:
	virtual ~IInterfaceItem() {}
	virtual IInterfaceItem* connectWith(IInterfaceItem* peer) = 0;
};

} /* namespace etRuntime */

#endif /* SRC_COMMON_MODELBASE_IINTERFACEITEM_H_ */
