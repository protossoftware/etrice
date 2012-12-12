/*
 * PortBase.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

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
