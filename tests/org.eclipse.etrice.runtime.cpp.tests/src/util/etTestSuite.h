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
#ifndef SRC_UTIL_ETTESTSUITE_H_
#define SRC_UTIL_ETTESTSUITE_H_

#include <string>

class etTestSuite {
public:
	etTestSuite(const std::string& name) :
			m_suiteName(name),
			m_caseId(0) {
	}
	virtual ~etTestSuite() {
	}

	void run();

protected:

	// asserts
	void assertEquals(const int arg1, const int arg2);

	// infra
#define ADD_TESTCASE(testcase) \
	{openTestCase(#testcase); \
	testcase(); \
	closeTestCase(m_caseId);}

	void openTestCase(const std::string& name);
	void closeTestCase(int id);

	virtual void runAllTestCases() = 0;

	std::string m_suiteName;
	int m_caseId;

};

#endif /* SRC_UTIL_ETTESTSUITE_H_ */
