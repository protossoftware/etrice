/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.DebuggingServiceTest") {
	}

protected:
	void testLogging(void);

	void runAllTestCases(void);
};

class ActorClass: public ActorClassBase {
public:
	ActorClass(IRTObject* parent, const String& name) :
			ActorClassBase(parent, name) {
	}

	void receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) {
	}
	void executeInitTransition() {
	}
};

class SubSystemClass: public SubSystemClassBase {
public:
	SubSystemClass(IRTObject* parent, String name) :
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
	Port(IInterfaceItemOwner* owner, const String& name) :
			PortBase(owner, name, 0) {
	}

	void receive(const Message* msg) {
	}
};

#endif /* SRC_DEBUGGING_DEBUGGINGSERVICETEST_H_ */
