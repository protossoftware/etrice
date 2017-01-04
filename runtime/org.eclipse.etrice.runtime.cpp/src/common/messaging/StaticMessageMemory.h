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

#ifndef SRC_COMMON_MESSAGING_STATICMESSAGEMEMORY_H_
#define SRC_COMMON_MESSAGING_STATICMESSAGEMEMORY_H_

#include "common/messaging/IMessageMemory.h"
#include "common/messaging/RTObject.h"
#include "common/messaging/MessageSeQueue.h"

namespace etRuntime {

class StaticMessageMemory : public IMessageMemory, public RTObject {
public:
	StaticMessageMemory(IRTObject* parent, const String& name, size_t size, int number);
	virtual ~StaticMessageMemory();

	// returns a buffer of the specified size in bytes
	Message* getMessageBuffer(size_t size);
	// frees the buffer
	void returnMessageBuffer(const Message* buffer);

	// return the size in bytes of one message buffer
	int getBufferSize(void) { return m_size; }
	// returns the number of free message buffers
	int getMessagePoolSize(void) { return m_msgPool.getSize(); }

private:
	size_t m_size;
	MessageSeQueue m_msgPool;
	uint8_t* m_buffer;
};

} /* namespace etRuntime */

#endif /* SRC_COMMON_MESSAGING_STATICMESSAGEMEMORY_H_ */
