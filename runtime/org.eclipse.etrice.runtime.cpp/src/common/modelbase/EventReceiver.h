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

#ifndef EVENTRECEIVER_H_
#define EVENTRECEIVER_H_

#include "common/messaging/RTObject.h"
#include "common/modelbase/IEventReceiver.h"
#include <string>

namespace etRuntime {

class EventReceiver : public RTObject, public virtual IEventReceiver{
public:

	virtual ~EventReceiver() {}

	virtual int getThread();

protected:
	EventReceiver(IRTObject* parent, const std::string& name);

private:

	int m_thread;

	EventReceiver(EventReceiver const&);
	EventReceiver& operator=(EventReceiver const&);

};

} /* namespace etRuntime */
#endif /* EVENTRECEIVER_H_ */
