/*
 * DebuggingService.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "DebuggingService.h"
#include "common/modelbase/ActorClassBase.h"

namespace etRuntime {

DebuggingService* DebuggingService::s_instance = 0;

DebuggingService::DebuggingService()
: asyncLogger() ,
  syncLogger(),
  portInstances()
{
}

DebuggingService::~DebuggingService() {
}


void DebuggingService::addMessageAsyncOut(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageAsyncOut(portInstances.at(source)->getActorRTObject().getInstancePath(),
								   portInstances.at(target)->getActorRTObject().getInstancePath(), msg);
}

void DebuggingService::addMessageAsyncIn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageAsyncIn(portInstances.at(source)->getActorRTObject().getInstancePath(),
								  portInstances.at(target)->getActorRTObject().getInstancePath(), msg);
}

void DebuggingService::addMessageSyncCall(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncCall(portInstances.at(source)->getActorRTObject().getInstancePath(),
								   portInstances.at(target)->getActorRTObject().getInstancePath(), msg);
}

void DebuggingService::addMessageSyncReturn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncReturn(portInstances.at(source)->getActorRTObject().getInstancePath(),
		                             portInstances.at(target)->getActorRTObject().getInstancePath(), msg);
}

void DebuggingService::addActorState(const ActorClassBase& actor,
		std::string state) {
	asyncLogger.addActorState(actor.getInstancePath(), state);
}

void DebuggingService::addPortInstance(PortBase& port) {
	portInstances.at(port.getAddress()) = &port;
}

MSCLogger& DebuggingService::getSyncLogger() {
	return syncLogger;
}

MSCLogger& DebuggingService::getAsyncLogger() {
	return asyncLogger;
}


} /* namespace etRuntime */
