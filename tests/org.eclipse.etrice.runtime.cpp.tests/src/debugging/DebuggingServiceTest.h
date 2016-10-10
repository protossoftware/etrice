/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_DEBUGGING_DEBUGGINGSERVICETEST_H_
#define SRC_DEBUGGING_DEBUGGINGSERVICETEST_H_

#include "util/etTestSuite.h"
#include "common/modelbase/ActorClassBase.h"
#include "common/modelbase/SubSystemClassBase.h"
#include "common/modelbase/PortBase.h"

using namespace etRuntime;

class DebuggingServiceTest: public etTestSuite {
public:
	DebuggingServiceTest() :
			etTestSuite("DebuggingServiceTest") {
	}

protected:
	void testLogging(void);

	void runAllTestCases(void);
};

class ActorClass: public ActorClassBase {
public:
	ActorClass(IRTObject* parent, const std::string& name) :
			ActorClassBase(parent, name) {
	}

	void receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) {
	}
	void executeInitTransition() {
	}
};

class SubSystemClass: public SubSystemClassBase {
public:
	SubSystemClass(IRTObject* parent, std::string name) :
			SubSystemClassBase(parent, name) {
	}

	void receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) {
	}
	void instantiateMessageServices() {
	}
	void mapThreads() {
	}
	void initialize() {
	}

};

class Port: public PortBase {
public:
	Port(IInterfaceItemOwner* owner, const std::string& name) :
			PortBase(owner, name, 0) {
	}

	void receive(const Message* msg) {
	}
};

#endif /* SRC_DEBUGGING_DEBUGGINGSERVICETEST_H_ */
