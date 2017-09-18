/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
