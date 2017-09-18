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

#ifndef SRC_DEBUGGING_MSCFILTERTEST_H_
#define SRC_DEBUGGING_MSCFILTERTEST_H_

#include "util/etTestSuite.h"

class MSCFilterTest: public etTestSuite {
public:
	MSCFilterTest() :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MSCFilterTest") {
	}

protected:
	void testFilter(void);
	void testReduceString(void);

	void runAllTestCases(void);
};

#endif /* SRC_DEBUGGING_MSCFILTERTEST_H_ */
