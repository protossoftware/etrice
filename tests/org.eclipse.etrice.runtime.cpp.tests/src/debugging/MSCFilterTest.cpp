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

#include "debugging/MSCFilterTest.h"
#include "common/debugging/MSCFilter.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void MSCFilterTest::testFilter() {
	const char* failMsg = "MSCFilter test failed";
	MSCFilter filter;

	// Test with no filter
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test"));

	// Test with one filter
	filter.addFilter(MSCFilter::FilterItem("test1", false));
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test1"));
	EXPECT_FALSE(m_caseId, failMsg, filter.applyTo("eTrice"));

	// Test with several filters
	filter.addFilter(MSCFilter::FilterItem("test2", false));
	filter.addFilter(MSCFilter::FilterItem("test3", false));
	filter.addFilter(MSCFilter::FilterItem("test4", false));
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test4"));
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test3"));
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test2"));
	EXPECT_TRUE(m_caseId, failMsg, filter.applyTo("test1"));
	EXPECT_FALSE(m_caseId, failMsg, filter.applyTo("eTrice"));
	EXPECT_FALSE(m_caseId, failMsg, filter.applyTo("blabla"));
}

void MSCFilterTest::testReduceString() {
}

void MSCFilterTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testFilter)
	// ADD_TESTCASE_CPP(testReduceString)
}
