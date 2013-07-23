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

class EventReceiver : public RTObject, public IEventReceiver{
public:
	EventReceiver(IRTObject* parent, std::string name)
	: RTObject(parent, name),
	  IEventReceiver()
	{};
	virtual ~EventReceiver();

private:
	EventReceiver();
	EventReceiver(const EventReceiver& right);
	EventReceiver& operator=(const EventReceiver& right);

};

} /* namespace etRuntime */
#endif /* EVENTRECEIVER_H_ */
