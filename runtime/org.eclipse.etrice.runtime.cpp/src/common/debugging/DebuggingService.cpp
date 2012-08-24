/*
 * DebuggingService.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "DebuggingService.h"

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
	asyncLogger.addMessageAsyncOut(portInstances[source].getActor().getInstancePath(), portInstances[target].getActor().getInstancePath(), msg);
}

void DebuggingService::addMessageAsyncIn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageAsyncIn(portInstances[source].getActor().getInstancePath(), portInstances[target].getActor().getInstancePath(), msg);
}

void DebuggingService::addMessageSyncCall(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncCall(portInstances[source].getActor().getInstancePath(), portInstances[target].getActor().getInstancePath(), msg);
}

void DebuggingService::addMessageSyncReturn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncReturn(portInstances[source].getActor().getInstancePath(), portInstances[target].getActor().getInstancePath(), msg);
}

void DebuggingService::addActorState(const ActorClassBase& actor,
		std::string state) {
	asyncLogger.addActorState(actor.getInstancePath(), state);
}

void DebuggingService::addPortInstance(const PortBase& port) {
	portInstances[port.getAddress()] = port;
}

const MSCLogger& DebuggingService::getSyncLogger() {
	return syncLogger;
}

const MSCLogger& DebuggingService::getAsyncLogger() {
	return asyncLogger;
}


} /* namespace etRuntime */
