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

#include "messaging/RTObjectTest.h"

#include "common/messaging/IRTObject.h"
#include "common/messaging/RTObject.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void RTObjectTest::testConstructors() {

	const char* failMsg = "RTObject constructor test failed";

	// Test constructor RTObject(IRTObject* parent, const String& name)
	RTObject* rto1 = new RTObject(NULL, "grandparent");
	RTObject* rto2 = new RTObject(rto1, "parent");
	RTObject* rto3 = new RTObject(rto2, "child1");
	RTObject* rto4 = new RTObject(rto2, "child2");

	EXPECT_TRUE(m_caseId, failMsg, !rto1->getName().compare("grandparent"));
	EXPECT_TRUE(m_caseId, failMsg, !rto2->getName().compare("parent"));
	EXPECT_TRUE(m_caseId, failMsg, !rto3->getName().compare("child1"));
	EXPECT_TRUE(m_caseId, failMsg, !rto4->getName().compare("child2"));

	EXPECT_TRUE(m_caseId, failMsg,
			!rto1->getInstancePath().compare(
					IRTObject::PATH_DELIM + String("grandparent")));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto2->getInstancePath().compare(
					rto1->getInstancePath() + IRTObject::PATH_DELIM + "parent"));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto3->getInstancePath().compare(
					rto2->getInstancePath() + IRTObject::PATH_DELIM + "child1"));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto4->getInstancePath().compare(
					rto2->getInstancePath() + IRTObject::PATH_DELIM + "child2"));

	EXPECT_TRUE(m_caseId, failMsg,
			!rto1->getInstancePathName().compare(
					IRTObject::PATHNAME_DELIM + String("grandparent")));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto2->getInstancePathName().compare(
					rto1->getInstancePathName() + IRTObject::PATHNAME_DELIM
							+ "parent"));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto3->getInstancePathName().compare(
					rto2->getInstancePathName() + IRTObject::PATHNAME_DELIM
							+ "child1"));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto4->getInstancePathName().compare(
					rto2->getInstancePathName() + IRTObject::PATHNAME_DELIM
							+ "child2"));

	IRTObject::ChildList children1 = rto1->getChildren();
	IRTObject::ChildList children2 = rto2->getChildren();
	IRTObject::ChildList children3 = rto3->getChildren();
	IRTObject::ChildList children4 = rto4->getChildren();
	IRTObject *child1 = children2.front();
	IRTObject *child2 = children2.back();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto2, children1.back());
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, children1.size());
	EXPECT_TRUE(m_caseId, failMsg,
			(child1 == rto3 && child2 == rto4)
					|| (child1 == rto4 && child2 == rto3));
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 2, children2.size());
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, children3.size());
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, children4.size());

	EXPECT_EQUAL_PTR(m_caseId, failMsg, NULL, rto1->getParent());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1, rto2->getParent());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto2, rto3->getParent());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto2, rto4->getParent());

	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1, rto1->getRoot());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1, rto2->getRoot());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1, rto3->getRoot());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1, rto4->getRoot());

	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto2, rto1->getChild("parent"));
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto3, rto2->getChild("child1"));
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto4, rto2->getChild("child2"));

	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto4,
			rto1->getObject(rto4->getInstancePath()));
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto3,
			rto2->getObject(rto3->getInstancePath()));
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto1,
			rto3->getObject(rto1->getInstancePath()));
	EXPECT_EQUAL_PTR(m_caseId, failMsg, rto2,
			rto4->getObject(rto2->getInstancePath()));

	EXPECT_EQUAL_INT16(m_caseId, failMsg, -1,
			rto4->getThreadForPath(rto4->getInstancePath()));

	delete rto4;
	delete rto3;
	delete rto2;
	delete rto1;
}

void RTObjectTest::testGetters() {
	const char* failMsg = "RTObject Getter test failed";
	RTObject rto(NULL, "test");
	EXPECT_TRUE(m_caseId, failMsg, !rto.getName().compare("test"));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto.getInstancePath().compare(
					IRTObject::PATH_DELIM + String("test")));
	EXPECT_TRUE(m_caseId, failMsg,
			!rto.getInstancePathName().compare(
					IRTObject::PATHNAME_DELIM + String("test")));
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, rto.getChildren().size());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, NULL, rto.getParent());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &rto, rto.getRoot());
}

void RTObjectTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testGetters)
}
