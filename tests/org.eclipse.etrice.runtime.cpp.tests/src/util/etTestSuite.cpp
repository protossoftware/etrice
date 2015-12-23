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

#include "etTestSuite.h"

#include "etUnit/etUnit.h"

void etTestSuite::assertEquals(const int arg1, const int arg2) {
	EXPECT_EQUAL_INT32(1, "", arg1, arg2);
}

void etTestSuite::run() {
	etUnit_openTestSuite(m_suiteName.c_str());
	runAllTestCases();
	etUnit_closeTestSuite();
}

void etTestSuite::openTestCase(const std::string& name) {
	m_caseId = etUnit_openTestCase(name.c_str());
}
void etTestSuite::closeTestCase(int id) {
	etUnit_closeTestCase(m_caseId);
}

