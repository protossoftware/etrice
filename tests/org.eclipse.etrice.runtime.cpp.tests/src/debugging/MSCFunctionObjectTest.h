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

#ifndef SRC_DEBUGGING_MSCFUNCTIONOBJECTTEST_H_
#define SRC_DEBUGGING_MSCFUNCTIONOBJECTTEST_H_

#include "util/etTestSuite.h"

class MSCFunctionObjectTest: public etTestSuite {
public:
	MSCFunctionObjectTest() :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MSFunctionObjectTest") {
	}

protected:
	void test(void);

	void runAllTestCases(void);
};

class TestClassB {
public:
	TestClassB(void);
	void test(void);
	~TestClassB(void);
};

class TestClassA {
public:
	TestClassA(void);
	void test(void);
	~TestClassA(void);
private:
	TestClassB tcb;
};

#endif /* SRC_DEBUGGING_MSCFUNCTIONOBJECTTEST_H_ */
