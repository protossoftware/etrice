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

#ifndef MESSAGESEQUEUE_H_
#define MESSAGESEQUEUE_H_

#include "common/messaging/RTObject.h"
#include <string>
#include "common/messaging/Message.h"

namespace etRuntime {

class MessageSeQueue: public RTObject {
	public:
		MessageSeQueue(IRTObject* parent, std::string name);
		virtual ~MessageSeQueue();

		void push(Message* msg);
		Message* pop();

		long getSize() const {return m_size;	}
		Message* getFirst() const {return m_first;	}
		Message* getLast() const { return m_last;	}
		bool isNotEmpty() const { return m_last != 0;	}
		long getHightWaterMark() const { return m_highWaterMark;	}

	private:
		Message* m_first;
		Message* m_last;
		long m_highWaterMark;
		long m_size;

		MessageSeQueue();
		MessageSeQueue(const MessageSeQueue& right);
		MessageSeQueue& operator=(const MessageSeQueue& right);

};

} /* namespace etRuntime */
#endif /* MESSAGESEQUEUE_H_ */
