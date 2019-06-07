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
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_CONTAINERS_STATICARRAYTEST_H_
#define SRC_CONTAINERS_STATICARRAYTEST_H_

#include "etUnit/etUnit.h"
#include "util/etTestSuite.h"

class StaticArrayTest : public etTestSuite {

public:
	StaticArrayTest() :
		etTestSuite("org.eclipse.etrice.runtime.cpp.tests.StaticArrayTest"){
	}

protected:
	void testConstructors(void);
	void testSettersAndGetters(void);
	void testOperators(void);

	virtual void runAllTestCases();
};



#endif /* SRC_CONTAINERS_STATICARRAYTEST_H_ */
