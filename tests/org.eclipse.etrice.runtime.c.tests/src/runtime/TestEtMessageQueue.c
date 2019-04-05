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

#include "TestEtMessageQueue.h"
#include "etUnit/etUnit.h"
#include "messaging/etMessageQueue.h"

void TestEtMessageQueue_testPushPop(etInt16 id){

	etMessage msg1 = {NULL, 123, 456};
	etMessage msg2 = {NULL, 222, 333};

	etMessageQueue queue1;
	etMessageQueue_init(&queue1);

	etMessageQueue_push(&queue1, &msg1);
	etMessageQueue_push(&queue1, &msg2);

	EXPECT_EQUAL_INT16(id, "etMessageQueue.size before", 2, queue1.size);
	EXPECT_EQUAL_INT16(id, "etMessageQueue.statistics.highWaterMark before", 2, queue1.statistics.highWaterMark);

	etMessage* rcvMsg1 = etMessageQueue_pop(&queue1);
	etMessage* rcvMsg2 = etMessageQueue_pop(&queue1);

	EXPECT_EQUAL_INT16(id, "etMessageQueue.size after", 0, queue1.size);
	EXPECT_EQUAL_INT16(id, "etMessageQueue.statistics.highWaterMark after", 2, queue1.statistics.highWaterMark);

	EXPECT_EQUAL_INT16(id, "rcvMsg1->address", 123, rcvMsg1->address);
	EXPECT_EQUAL_INT16(id, "rcvMsg1->evtID", 456, rcvMsg1->evtID);
	EXPECT_EQUAL_PTR(id, "rcvMsg1->next", NULL, rcvMsg1->next);

	EXPECT_EQUAL_INT16(id, "rcvMsg2->address", 222, rcvMsg2->address);
	EXPECT_EQUAL_INT16(id, "rcvMsg2->evtID", 333, rcvMsg2->evtID);
	EXPECT_EQUAL_PTR(id, "rcvMsg2->next", NULL, rcvMsg2->next);

	EXPECT_EQUAL_PTR(id, "etMessageQueue->first", NULL, queue1.first);
	EXPECT_EQUAL_PTR(id, "etMessageQueue->last", NULL, queue1.last);

	etMessage* rcvMsg3 = etMessageQueue_pop(&queue1);
	EXPECT_EQUAL_PTR(id, "etMessageQueue_pop if empty", NULL, rcvMsg3);

}

#define MAX 1000

void TestEtMessageQueue_testMassiveMessaging(etInt16 id){

	etMessage msgArray[MAX];

	etMessageQueue queue1;
	etMessageQueue_init(&queue1);

	int16 i;
	for(i=0; i<MAX; i++){
		//etMessage_init(&msgArray[i]);
		msgArray[i].address = i;
		msgArray[i].evtID = i;
	}

	int j;
	for(j=0; j<3; j++){
		for (i=0; i<MAX; i++){
			etMessageQueue_push(&queue1, &(msgArray[i]));
		}
		for (i=0; i<MAX; i++){
			etMessage* msg = etMessageQueue_pop(&queue1);
			// EXPECTS are hidden to avoid too many testcases in log
			if (msg == NULL){
				EXPECT_FALSE(id, "msg == NULL", ET_TRUE);
				break;
			}
			if (msg->address != msg->evtID){
				EXPECT_FALSE(id, "msg->address != msg->evtID", ET_TRUE);
				break;
			}
			if (msg->address != i){
				EXPECT_FALSE(id, "msg->address != i", ET_TRUE);
				break;
			}
		}
		EXPECT_EQUAL_INT32(id, "i==MAX", MAX, i);
	}
}

void TestEtMessageQueue_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtMessageQueue");
	ADD_TESTCASE(TestEtMessageQueue_testPushPop);
	ADD_TESTCASE(TestEtMessageQueue_testMassiveMessaging);
	etUnit_closeTestSuite();
}
