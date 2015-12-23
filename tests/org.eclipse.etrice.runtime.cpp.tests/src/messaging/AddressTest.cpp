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

#include "AddressTest.h"

#include "common/messaging/Address.h"
#include "util/etAssert.h"

using namespace etRuntime;

void AddressTest::testAddress() {
	Address addr(1, 2, 3);
	assertEquals(1, addr.m_nodeID);
	assertEquals(2, addr.m_threadID);
	assertEquals(3, addr.m_objectID);
}

void AddressTest::testToString() {

}

void AddressTest::runAllTestCases(){
	ADD_TESTCASE(testAddress)
}
