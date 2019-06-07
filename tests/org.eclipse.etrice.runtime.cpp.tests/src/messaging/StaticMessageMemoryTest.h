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

#ifndef SRC_MESSAGING_STATICMESSAGEMEMORYTEST_H_
#define SRC_MESSAGING_STATICMESSAGEMEMORYTEST_H_

#include "util/etTestSuite.h"

class StaticMessageMemoryTest: public etTestSuite {
public:
	StaticMessageMemoryTest(void) :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.StaticMessageMemoryTest") {
	}

protected:
	void runAllTestCases(void);
	void test(void);
};

#endif /* SRC_MESSAGING_STATICMESSAGEMEMORYTEST_H_ */
