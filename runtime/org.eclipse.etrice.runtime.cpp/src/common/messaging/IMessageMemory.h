/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_MESSAGING_IMESSAGEMEMORY_H_
#define SRC_COMMON_MESSAGING_IMESSAGEMEMORY_H_

#include "common/messaging/Message.h"
#include "common/messaging/IRTObject.h"

namespace etRuntime {

class IMessageMemory : virtual IRTObject {
public:
	virtual ~IMessageMemory() {}

	// returns a buffer of the specified size in bytes
	// use the placement constructor to create objects and call the destructor explicitly
	virtual Message* getMessageBuffer(size_t size) = 0;
	// frees the buffer
	virtual void returnMessageBuffer(const Message* buffer) = 0;
};

} /* namespace etRuntime */

#endif /* SRC_COMMON_MESSAGING_IMESSAGEMEMORY_H_ */
