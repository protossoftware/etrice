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

#include "common/modelbase/SubSystemClassBase.h"
#include "common/debugging/DebuggingService.h"
#include "common/debugging/MSCLogger.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"
#include "common/modelbase/ActorClassBase.h"
#include <iostream>
#include <iterator>
#include <map>
#include <string>
#include <vector>



namespace etRuntime {

SubSystemClassBase::SubSystemClassBase(IRTObject* parent, std::string name) :
		RTObject(parent, name),
		m_RTSystemPort(this, IFITEM_RTSystemPort) {
	DebuggingService::getInstance().getAsyncLogger().setMSC(name + "_Async", "log/");
	DebuggingService::getInstance().getAsyncLogger().open();
	DebuggingService::getInstance().getSyncLogger().setMSC(name + "_Sync", "log/");
	DebuggingService::getInstance().getSyncLogger().open();

	RTServices::getInstance().setSubSystem(this);
}

void SubSystemClassBase::init() {

	std::cout << "*** MainComponent " << getInstancePath() << "::init ***" << std::endl;

	// MessageService
	instantiateMessageServices();

	// this is the place to connect the message services if necessary
	// normaly the ports will address the correct target message service directly
	// it is just for test purposes
	// RTServices::getInstance().getMsgSvcCtrl().connectAll();

	instantiateActors();
//	std::cout << toStringRecursive() << std::endl;

	// initialize all actor instances
	for (std::vector<IRTObject*>::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		ActorClassBase* child = dynamic_cast<ActorClassBase*>(*it);
		if (child != 0)
			child->init();
	}
}

void SubSystemClassBase::start() {
	// start all actors instances
	m_RTSystemPort.executeInitialTransition();

	// start all message services
	RTServices::getInstance().getMsgSvcCtrl().start();

}

void SubSystemClassBase::stop() {
	std::cout << "*** MainComponent " << getInstancePath() << "::stop ***" << std::endl;

	RTServices::getInstance().getMsgSvcCtrl().stop();
	std::cout << "=== done stop MsgSvcCtrl" << std::endl;

	// stop all actor instances
	for (std::vector<IRTObject*>::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		ActorClassBase* child = dynamic_cast<ActorClassBase*>(*it);
		if (child != 0)
			child->stop();
	}
	std::cout << "=== done stop actor instances" << std::endl;
}

void SubSystemClassBase::destroy() {
	std::cout << "*** MainComponent " << this->getInstancePath() << "::destroy ***" << std::endl;
	RTObject::destroy();
//	std::cout << toStringRecursive() << std::endl;
	std::cout << "=== done destroy actor instances" << std::endl;

	DebuggingService::getInstance().getAsyncLogger().close();
	DebuggingService::getInstance().getSyncLogger().close();
	std::cout << "=== done close loggers" << std::endl;

	RTServices::getInstance().destroy();
	std::cout << "=== done destroy RTServices\n\n\n" << std::endl;
}

IMessageService* SubSystemClassBase::getMsgService(int idx) const {
	return RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(idx);
}

ActorClassBase* SubSystemClassBase::getInstance(const std::string& path) const {
	IRTObject* object = getObject(path);

	return dynamic_cast<ActorClassBase*>(object);
}

void SubSystemClassBase::addPathToThread(const std::string& path, int thread) {
	m_path2thread[path] = thread;
}

int SubSystemClassBase::getThreadForPath(const std::string& path) const {
	std::map<std::string, int> ::const_iterator it = m_path2thread.find(path);
	if (it == m_path2thread.end())
		return -1;

	return it->second;
}

void SubSystemClassBase::resetAll() {
	m_path2thread.clear();
}

} /* namespace etRuntime */

