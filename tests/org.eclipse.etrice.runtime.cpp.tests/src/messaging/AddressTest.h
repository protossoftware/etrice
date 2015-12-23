/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_MESSAGING_ADDRESSTEST_H_
#define SRC_MESSAGING_ADDRESSTEST_H_

#include "util/etTestSuite.h"

class AddressTest : public etTestSuite {

public:
	AddressTest() :
		etTestSuite("AddressTest"){
	}

protected:
	void testAddress();
	void testToString();

	virtual void runAllTestCases();
};



#endif /* SRC_MESSAGING_ADDRESSTEST_H_ */
