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

#include "debugging/MSCFunctionObjectTest.h"
#include "common/debugging/MSCFunctionObject.h"
#include "common/debugging/DebuggingService.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void MSCFunctionObjectTest::test() {
	DebuggingService::getInstance().getSyncLogger().setMSC(
			"MSCFunctionObjectTest", "log/");
	DebuggingService::getInstance().getSyncLogger().open();
	DebuggingService::getInstance().getSyncLogger().setObjectName("main");
	MSCFunctionObject* obj = new MSCFunctionObject("MSCFunctionObjectTest",
			"test(void)");
	TestClassA* tca = new TestClassA();
	tca->test();
	delete tca;
	delete obj;
	DebuggingService::getInstance().getSyncLogger().close();
}

void MSCFunctionObjectTest::runAllTestCases() {
	ADD_TESTCASE_CPP(test);
}

TestClassA::TestClassA() :
		tcb() {
	MSCFunctionObject("TestClassA", "Constructor");
}

TestClassA::~TestClassA() {
	MSCFunctionObject("TestClassA", "Destructor");
}

void TestClassA::test() {

	MSCFunctionObject msc("TestClassA", "test");
	tcb.test();
}

TestClassB::TestClassB() {
	MSCFunctionObject("TestClassB", "Constructor");
}

TestClassB::~TestClassB() {
	MSCFunctionObject("TestClassB", "Destructor");
}

void TestClassB::test() {
	MSCFunctionObject("TestClassB", "test");
}

