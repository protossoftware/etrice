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

#include "StringTest.h"

#include "common/containers/String.h"
#include "util/etAssert.h"

using namespace etRuntime;

void StringTest::testConstructors(void) {
	// default constructors for simple types
	String string1; // nothing happens, but should not crash
	String string2("eTrice");
	String string3(string2);	// copy construction for unequal sizes

	EXPECT_EQUAL_INT8(m_caseId, "default string is not 0 at pos 0", 0,
			(int8)string1[0]);
	EXPECT_EQUAL_INT8(m_caseId, "value for string2 at pos 2 is wrong", 'r',
			(int8)string2[2]);
	EXPECT_EQUAL_INT8(m_caseId, "value for string2 at pos 4 is wrong", 'c',
			(int8)string2[4]);

	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'e',
			(int8)string3[0]);
	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'r',
			(int8)string3[2]);
	EXPECT_EQUAL_INT8(m_caseId, "copy constructor for string3 wrong", 'c',
			(int8)string3[4]);
}

void StringTest::testSettersAndGetters(void) {
	String string1("eTrice"); // nothing happens, but should not crash

	// getSize
	EXPECT_EQUAL_INT8(m_caseId, "length wrong", 6, string1.length());

	// getData
	EXPECT_EQUAL_INT8(m_caseId, "getData wrong", 'i', (int8)string1[3]);
}

void StringTest::testOperators(void) {
	String string1("eTrice"); // nothing happens, but should not crash

	String string2;
	string2 = string1;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp(string1.c_str(), string2.c_str())==0);

	string2 = "ROOM";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM", string2.c_str())==0);

	String string3("ROOM with ");
	string3 += "eTrice";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string3.c_str())==0);

	String string4("ROOM with ");
	String string5("eTrice");
	string4 += string5;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string4.c_str())==0);

	String string6("ROOM with ");
	String string7("eTrice");
	String string8 = string6 + string7;
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string8.c_str())==0);

	String string9("ROOM with ");
	String string10 = string9 + "eTrice";
	EXPECT_TRUE(m_caseId, "strings should be equal", std::strcmp("ROOM with eTrice", string10.c_str())==0);

	String string11("something");
	EXPECT_TRUE(m_caseId, "strings should be equal", string11=="something");

	String string12("something");
	EXPECT_TRUE(m_caseId, "strings should be equal", string11==string12);

	String string13("this is a long string");
	string13 = "short";	// new contents without re-allocation
	EXPECT_TRUE(m_caseId, "strings should be equal", string13=="short");

	String string14("aaa");
	String string15("bbb");
	EXPECT_TRUE(m_caseId, "strings should be equal", string14.compare("aaa")==0);
	EXPECT_TRUE(m_caseId, "strings should be equal", string14.compare(string15)<0);

	//
	// find and substr
	//
	String str = "We think in generalities, but we live in details.";
										// (quoting Alfred N. Whitehead)

	String str2 = str.substr(3, 5);     // "think"
	EXPECT_TRUE(m_caseId, "strings should be equal", str2.compare("think")==0);

	size_t pos = str.find("live");      // position of "live" in str
	EXPECT_EQUAL_INT32(m_caseId, "pos should be 33", 33, pos);

	String str3 = str.substr(pos);      // get from "live" to the end
	EXPECT_TRUE(m_caseId, "strings should be equal", str3.compare("live in details.")==0);

	String str5 = str.substr(pos, 4);      // get "live"
	EXPECT_TRUE(m_caseId, "strings should be equal", str5.compare("live")==0);

	String str4;
	str4 += 'a';
	EXPECT_TRUE(m_caseId, "strings should be equal", str4.compare("a")==0);
}

void StringTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testSettersAndGetters)
	ADD_TESTCASE_CPP(testOperators)
}
