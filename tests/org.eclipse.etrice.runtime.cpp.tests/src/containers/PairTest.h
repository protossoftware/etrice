/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_CONTAINERS_PAIRTEST_H_
#define SRC_CONTAINERS_PAIRTEST_H_

#include "etUnit/etUnit.h"
#include "util/etTestSuite.h"

class PairTest : public etTestSuite {

public:
	PairTest() :
		etTestSuite("PairTest"){
	}

protected:
	void testConstructors(void);
	void testOperators(void);

	virtual void runAllTestCases();
};



#endif /* SRC_CONTAINERS_PAIRTEST_H_ */
