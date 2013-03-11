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

#include "SubSystemClassBase.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/RTServices.h"
#include "ActorClassBase.h"
#include "common/debugging/DebuggingService.h"

namespace etRuntime {


SubSystemClassBase::~SubSystemClassBase() {
	m_testSem = 0;
	m_RTSystemPort = 0;
}

SubSystemClassBase::SubSystemClassBase(IRTObject* parent, std::string name)
	: 	RTObject(parent, name),
		IEventReceiver(),
		m_RTSystemPort(0),
		m_instances(),
		m_testSem(0),
		m_testErrorCode(0)
{
	DebuggingService::getInstance().getAsyncLogger().setMSC(name + "_Async", "");
	DebuggingService::getInstance().getAsyncLogger().open();
	DebuggingService::getInstance().getSyncLogger().setMSC(name + "_Sync", "");
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

	// initialize all actor m_instances
	for (unsigned int i = 0; i < m_instances.size(); i++) {
		m_instances[i]->init();
	}
}

void SubSystemClassBase::start(bool singlethreaded) {
	// start all actors instances
	m_RTSystemPort->executeInitialTransition();

	// start all message services
	RTServices::getInstance().getMsgSvcCtrl().start(singlethreaded);

}

void SubSystemClassBase::stop(bool singlethreaded) {
	std::cout << "*** MainComponent " << this->getInstancePath() << "::stop ***" << std::endl;

	RTServices::getInstance().getMsgSvcCtrl().stop(singlethreaded);
	std::cout << "=== done stop MsgSvcCtrl" << std::endl;

	// stop all actor instances
	for (unsigned int i = 0; i < m_instances.size(); i++) {
		m_instances[i]->stop();
	}
	std::cout << "=== done stop actor instances" << std::endl;
}

void SubSystemClassBase::runOnce() {
	// run all message services one time
	RTServices::getInstance().getMsgSvcCtrl().runOnce();

}

void SubSystemClassBase::destroy() {
	std::cout << "*** MainComponent " << this->getInstancePath() << "::destroy ***" << std::endl;
	for (unsigned int i = 0; i < m_instances.size(); i++) {
		m_instances[i]->destroy();
	}
	std::cout << "=== done destroy actor instances" << std::endl;

	DebuggingService::getInstance().getAsyncLogger().close();
	DebuggingService::getInstance().getSyncLogger().close();
	std::cout << "=== done close loggers" << std::endl;

	RTServices::getInstance().destroy();
	std::cout << "=== done destroy RTServices\n\n\n" << std::endl;
}

MessageService* SubSystemClassBase::getMsgService(int idx) const {
	return RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(idx);
}

ActorClassBase* SubSystemClassBase::getInstance(unsigned int i) {
	if (i < 0 || i >= m_instances.size())
		return 0;

	return m_instances[i];
}

ActorClassBase* SubSystemClassBase::getInstance(std::string path) {
	for (unsigned int i = 0; i < m_instances.size(); i++) {
		if (m_instances[i]->getInstancePath() == path)
			return m_instances[i];
	}

	return 0;
}

// this is to run integration tests
// TODO synchronized
void SubSystemClassBase::setTestSemaphore(TestSemaphore& sem) {
	m_testErrorCode = -1;
	m_testSem = &sem;
}

//TODO synchronized
int SubSystemClassBase::getTestErrorCode() const {
	return m_testErrorCode;
}

void SubSystemClassBase::testFinished(int errorCode) {
	if (m_testSem != 0) {
		std::cout
			<< "org.eclipse.etrice.runtime.cpp.modelbase.SubSystemClassBase.testFinished(int): before releasing semaphore"
			<< std::endl;
		//m_testSem.printWaitingThreads();
		//TODO synchronized (this) {
		m_testErrorCode = errorCode;
		m_testSem->give();
		//}
		std::cout
			<< "org.eclipse.etrice.runtime.cpp.modelbase.SubSystemClassBase.testFinished(int): semaphore released"
			<< std::endl;
		//m_testSem.printWaitingThreads();
		//TODO
		//Thread.yield();
	}
}


} /* namespace etRuntime */

