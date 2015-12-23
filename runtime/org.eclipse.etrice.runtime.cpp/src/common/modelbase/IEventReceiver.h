/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef IEVENTRECEIVER_H_
#define IEVENTRECEIVER_H_

#include "common/messaging/IRTObject.h"

namespace etRuntime {

class InterfaceItemBase;

class IEventReceiver: public virtual IRTObject {
public:
	virtual ~IEventReceiver() {}

	virtual void receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) = 0;
	virtual int getThread() = 0;
};

} /* namespace etRuntime */
#endif /* IEVENTRECEIVER_H_ */
