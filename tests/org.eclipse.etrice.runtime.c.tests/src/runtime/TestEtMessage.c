/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "TestEtMessage.h"

#include <stddef.h>
#include "etUnit/etUnit.h"
#include "messaging/etMessage.h"



void TestEtMessage_testBasicMessage(etInt16 id){

	etMessage msg1 = {(etMessage*)1234567, 123,456,};
	etMessage msg2 = {NULL, 222,333};

	// basic checks -> detects structure changes that would cause problems for generated code
	EXPECT_EQUAL_PTR(id, "Message.next", 1234567, msg1.next);
	EXPECT_EQUAL_INT16(id, "Message.address", 123, msg1.address);
	EXPECT_EQUAL_INT16(id, "Message.evtID", 456, msg1.evtID);

	// build pointer ring
	msg1.next = &msg2;
	msg2.next = &msg1;

	EXPECT_EQUAL_INT16(id, "msg1.NextMsg", msg2.evtID, msg1.next->evtID);
	EXPECT_EQUAL_INT16(id, "msg2.NextMsg", msg1.evtID, msg2.next->evtID);

}

void TestEtMessage_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestMessage");
	ADD_TESTCASE(TestEtMessage_testBasicMessage);
	etUnit_closeTestSuite();
}

