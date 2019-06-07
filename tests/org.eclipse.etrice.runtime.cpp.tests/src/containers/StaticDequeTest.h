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

#ifndef SRC_CONTAINERS_STATICDEQUETEST_H_
#define SRC_CONTAINERS_STATICDEQUETEST_H_

#include "util/etTestSuite.h"

class StaticDequeTest : public etTestSuite {
public:
	StaticDequeTest(void) : etTestSuite("org.eclipse.etrice.runtime.cpp.tests.StaticDequeTest") {}

protected:
	void runAllTestCases(void);

	void testConstructors(void);
	void testAssignment(void);
	void testPushPop(void);
	void testQueue(void);
	void testStack(void);
};

class DataClass {
public:
	int attr1;
	double attr2;
	std::string attr3;

	DataClass(int attr1, double attr2, const std::string& attr3) :
		attr1(attr1), attr2(attr2), attr3(attr3) {}

	bool operator==(const DataClass& d) const {
		return (attr1 == d.attr1
				&& attr2 == d.attr2
				&& attr3 == d.attr3);
	}
};



#endif /* SRC_CONTAINERS_STATICDEQUETEST_H_ */
