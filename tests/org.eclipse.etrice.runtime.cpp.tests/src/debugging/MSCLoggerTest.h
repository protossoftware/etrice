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

#ifndef SRC_MSCLOGGERTEST_H_
#define SRC_MSCLOGGERTEST_H_

#include "util/etTestSuite.h"

class MSCLoggerTest: public etTestSuite {
public:
	MSCLoggerTest(void) :
			etTestSuite("MSCLoggerTest") {
	}

protected:
	void testLogger(void);

	void runAllTestCases(void);
};

#endif /* SRC_MSCLOGGERTEST_H_ */
