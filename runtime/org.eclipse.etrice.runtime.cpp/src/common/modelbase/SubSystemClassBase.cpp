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

#include "common/modelbase/SubSystemClassBase.h"
#include "common/debugging/DebuggingService.h"
#include "common/debugging/MSCLogger.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"
#include "common/modelbase/ActorClassBase.h"


namespace etRuntime {

SubSystemClassBase::SubSystemClassBase(IRTObject* parent, String name) :
		RTObject(parent, name),
		m_RTSystemPort(this, IFITEM_RTSystemPort) {
	String asyncMSCname(name);
	asyncMSCname += "_Async";
	String syncMSCname(name);
	syncMSCname += "_Sync";
	DebuggingService::getInstance().getAsyncLogger().setMSC(asyncMSCname.c_str(), "log/");
	DebuggingService::getInstance().getAsyncLogger().open();
	DebuggingService::getInstance().getSyncLogger().setMSC(syncMSCname.c_str(), "log/");
	DebuggingService::getInstance().getSyncLogger().open();
	DebuggingService::getInstance().getSyncLogger().setObjectName("main");

	RTServices::getInstance().setSubSystem(this);
}

void SubSystemClassBase::init() {

	printf("*** MainComponent %s::init ***\n", getInstancePath().c_str());

	// MessageService
	instantiateMessageServices();

	// this is the place to connect the message services if necessary
	// normaly the ports will address the correct target message service directly
	// it is just for test purposes
	// RTServices::getInstance().getMsgSvcCtrl().connectAll();
	mapThreads();
	initialize();
	setProbesActive(true, true);
//	std::cout << toStringRecursive() << std::endl;

	// initialize all actor instances
	for (ChildList::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
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
	printf("*** MainComponent %s::stop ***\n", getInstancePath().c_str());

	RTServices::getInstance().getMsgSvcCtrl().stop();
	printf("=== done stop MsgSvcCtrl\n");

	// stop all actor instances
	for (ChildList::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		ActorClassBase* child = dynamic_cast<ActorClassBase*>(*it);
		if (child != 0)
			child->stop();
	}
	printf("=== done stop actor instances\n");
}

void SubSystemClassBase::destroy() {
	printf("*** MainComponent %s::destroy ***\n", this->getInstancePath().c_str());
	RTObject::destroy();
//	std::cout << toStringRecursive() << std::endl;
	printf("=== done destroy actor instances\n");

	DebuggingService::getInstance().getAsyncLogger().close();
	DebuggingService::getInstance().getSyncLogger().close();
	printf("=== done close loggers\n");

	RTServices::getInstance().destroy();
	printf("=== done destroy RTServices\n\n\n\n");
}

IMessageService* SubSystemClassBase::getMsgService(int idx) const {
	return RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(idx);
}

ActorClassBase* SubSystemClassBase::getInstance(const String& path) const {
	IRTObject* object = getObject(path);

	return dynamic_cast<ActorClassBase*>(object);
}

void SubSystemClassBase::addPathToThread(const String& path, int thread) {
	m_path2thread[path] = thread;
}

int SubSystemClassBase::getThreadForPath(const String& path) const {
	Map<String, int> ::const_iterator it = m_path2thread.find(path);
	if (it == m_path2thread.end())
		return -1;

	return it->second;
}

void SubSystemClassBase::resetAll() {
	m_path2thread.clear();
}

} /* namespace etRuntime */

