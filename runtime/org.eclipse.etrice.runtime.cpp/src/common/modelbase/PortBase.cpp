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

#include "PortBase.h"

namespace etRuntime {


PortBase::~PortBase() {
}

void PortBase::send(int evtID) {

	//TODO: how to avoid logging timerTicks
	//if (s_messageStrings[IRTSystemServicesProtocolPort::OUT_dummy] != "timerTick") {
	// TODOTS: model switch for activation
	if (getPeerAddress().isValid())
		getPeerMsgReceiver()->receive(
				new Message(getPeerAddress(), evtID)); //TODO: placement new mit message pool verwenden

};

} /* namespace etRuntime */
