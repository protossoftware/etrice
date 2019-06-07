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

#include "StaticStringTest.h"

#include "common/containers/StaticString.h"
#include "util/etAssert.h"

using namespace etRuntime;

void StaticStringTest::testConstructors(void) {
	// default constructors for simple types
	StaticString<5> string1; // nothing happens, but should not crash
	StaticString<10> string2("eTrice");
	StaticString<8> string3(string2);	// copy construction for unequal sizes

	EXPECT_EQUAL_INT8(m_caseId, "default string is not 0 at pos 0", 0,
			string1[0]);
	EXPECT_EQUAL_INT8(m_caseId, "value for string2 at pos 2 is wrong", 'r',
			string2[2]);
	EXPECT_EQUAL_INT8(m_caseId, "value for string2 at pos 4 is wrong", 'c',
			string2[4]);

	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'e',
			string3[0]);
	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'r',
			string3[2]);
	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'c',
			string3[4]);
}

void StaticStringTest::testSettersAndGetters(void) {
	StaticString<8> string1("eTrice"); // nothing happens, but should not crash

	// getSize
	EXPECT_EQUAL_INT8(m_caseId, "length wrong", 6, string1.length());

	// getData
	EXPECT_EQUAL_INT8(m_caseId, "getData wrong", 'i', string1.getData()[3]);
}

void StaticStringTest::testOperators(void) {
	StaticString<8> string1("eTrice"); // nothing happens, but should not crash

	StaticString<8> string2;
	string2 = string1;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp(string1.getData(), string2.getData())==0);

	string2 = "ROOM";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM", string2.getData())==0);

	StaticString<32> string3("ROOM with ");
	string3 += "eTrice";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string3.getData())==0);

	StaticString<32> string4("ROOM with ");
	StaticString<32> string5("eTrice");
	string4 += string5;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string4.getData())==0);

	StaticString<32> string6("ROOM with ");
	StaticString<32> string7("eTrice");
	StaticString<32> string8 = string6 + string7;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string8.getData())==0);

	StaticString<32> string9("ROOM with ");
	StaticString<32> string10 = string9 + "eTrice";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string10.getData())==0);

	StaticString<32> string11("something");
	EXPECT_TRUE(m_caseId, "strings should be equal", string11=="something");

	StaticString<32> string12("something");
	EXPECT_TRUE(m_caseId, "strings should be equal", string11==string12);
}

void StaticStringTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testSettersAndGetters)
	ADD_TESTCASE_CPP(testOperators)
}
