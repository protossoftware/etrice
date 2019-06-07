/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef EVENTRECEIVER_H_
#define EVENTRECEIVER_H_

#include "common/messaging/RTObject.h"
#include "common/modelbase/IEventReceiver.h"

namespace etRuntime {

class EventReceiver : public RTObject, public virtual IEventReceiver{
public:

	virtual ~EventReceiver() {}

	virtual int getThread();

protected:
	EventReceiver(IRTObject* parent, const String& name);

private:

	int m_thread;

	EventReceiver(EventReceiver const&);
	EventReceiver& operator=(EventReceiver const&);

};

} /* namespace etRuntime */
#endif /* EVENTRECEIVER_H_ */
