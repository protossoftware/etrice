/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_MESSAGING_ADDRESSTEST_H_
#define SRC_MESSAGING_ADDRESSTEST_H_

#include "util/etTestSuite.h"


class AddressTest: public etTestSuite {

public:
	AddressTest(void) :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.AddressTest") {
	}

protected:
	void testConstructors(void);
	void testOperators(void);
	void testToString(void);
	void testToID(void);
	void testCreateInc(void);
	void testIsValid(void);

	virtual void runAllTestCases(void);
};

#endif /* SRC_MESSAGING_ADDRESSTEST_H_ */
