/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

#include "TestEtMessageService.h"
#include "etUnit/etUnit.h"
#include "messaging/etMessageService.h"


/* mocking for MessageDispatcher */

static etInt16 receivedEventIDs[2] = {0,0};
static etInt16 receivedEventIDCounter = 0;

void MessageReceiver1(const etMessage* msg){
	receivedEventIDs[receivedEventIDCounter] = msg->evtID;
	receivedEventIDCounter++;
}

void MessageReceiver2(const etMessage* msg){
	receivedEventIDs[receivedEventIDCounter] = msg->evtID;
	receivedEventIDCounter++;
}

/* dummy message dispatcher */
etBool DummyMessageDispatcher(const etMessage* msg){
	switch(msg->address){
		case 11:
			MessageReceiver1(msg);
			break;
		case 22:
			MessageReceiver2(msg);
			break;
		default:
			break;
	}
	return ET_TRUE;
}

void TestEtMessageService_init(etInt16 id){

	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	etTime interval;

	uint8 msgBuffer[max*blockSize];

	etMessageService_init(
			&msgService,
			msgBuffer,
			max,
			blockSize,
			1024,
			0,
			interval,
			DummyMessageDispatcher,
			EXECMODE_BLOCKED);

	EXPECT_EQUAL_PTR(id, "msgService.messagePool.first", msgBuffer, msgService.messagePool.first);
	EXPECT_EQUAL_PTR(id, "msgService.messagePool in between", &msgBuffer[3*blockSize], msgService.messagePool.first->next->next->next);
	EXPECT_EQUAL_PTR(id, "msgService.messagePool.last(1)", &msgBuffer[5*blockSize], msgService.messagePool.first->next->next->next->next->next);
	EXPECT_EQUAL_PTR(id, "msgService.messagePool.last(2)", &msgBuffer[5*blockSize], msgService.messagePool.last);
	EXPECT_EQUAL_PTR(id, "msgService.messagePool.last.next", 0, msgService.messagePool.last->next);

	etMessageService_destroy(&msgService);
}

void TestEtMessageService_GetPushPopReturn(etInt16 id){

	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];
	etTime interval;

	etMessageService_init(
			&msgService,
			msgBuffer,
			max,
			blockSize,
			1024,
			0,
			interval,
			DummyMessageDispatcher,
			EXECMODE_BLOCKED);

	// get messages from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));

	EXPECT_EQUAL_INT16(id, "msgService.messagePool.size", 4, msgService.messagePool.size);

	// define content
	msg1->address = 11;
	msg1->evtID = 111;
	msg2->address = 22;
	msg2->evtID = 222;

	// push messages to queue
	etMessageService_pushMessage(&msgService, msg2);
	etMessageService_pushMessage(&msgService, msg1);

	EXPECT_EQUAL_INT16(id, "msgService.messageQueue.size", 2, msgService.messageQueue.size);

	// pop messages from queue
	etMessage* rcvMsg1 = etMessageService_popMessage(&msgService);
	etMessage* rcvMsg2 = etMessageService_popMessage(&msgService);

	EXPECT_EQUAL_INT16(id, "msgService.messageQueue.size",0, msgService.messageQueue.size);


	EXPECT_EQUAL_INT16(id, "msgService.popMessage", 22, rcvMsg1->address);
	EXPECT_EQUAL_INT16(id, "msgService.popMessage", 222, rcvMsg1->evtID);
	EXPECT_EQUAL_INT16(id, "msgService.popMessage", 11, rcvMsg2->address);
	EXPECT_EQUAL_INT16(id, "msgService.popMessage", 111, rcvMsg2->evtID);

	etMessageService_returnMessageBuffer(&msgService, rcvMsg1);
	etMessageService_returnMessageBuffer(&msgService, rcvMsg2);

	EXPECT_EQUAL_INT16(id, "msgService.messagePool.size", 6, msgService.messagePool.size);

	etMessageService_destroy(&msgService);
}

void TestEtMessageService_GetReturn(etInt16 id){

	etMessageService msgService;
	uint16 max = 2;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];
	etTime interval;

	etMessageService_init(
			&msgService,
			msgBuffer,
			max,
			blockSize,
			1024,
			0,
			interval,
			DummyMessageDispatcher,
			EXECMODE_BLOCKED);

	// get one message too much from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg3 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage)); /* this line triggers an error log */
	EXPECT_TRUE(id, "msgService getMessageBuffer", msg1!=NULL);
	EXPECT_TRUE(id, "msgService getMessageBuffer", msg2!=NULL);
	EXPECT_EQUAL_PTR(id, "msgService getMessageBuffer", msg3, NULL);

	// return messages
	etMessageService_returnMessageBuffer(&msgService, msg1);
	etMessageService_returnMessageBuffer(&msgService, msg2);
	EXPECT_EQUAL_INT16(id, "msgService.messagePool.size", 2, msgService.messagePool.size);

	// get message bigger than blocksize
	etMessage* msg4 = etMessageService_getMessageBuffer(&msgService, 33); /* this line triggers an error log */
	EXPECT_EQUAL_PTR(id, "msgService getMessageBuffer", msg4, NULL);

	etMessageService_destroy(&msgService);
}

#define TEST_EXECUTE__POOL_SIZE		6
#define TEST_EXECUTE__BLOCK_SIZE	32

void TestEtMessageService_execute(etInt16 id){
	/* msgService and buffer data have to be static because they are used in a separate thread */
	static etMessageService msgService;
	static uint8 msgBuffer[TEST_EXECUTE__POOL_SIZE*TEST_EXECUTE__BLOCK_SIZE];
	etTime interval;

	etMessageService_init(
			&msgService,
			msgBuffer,
			TEST_EXECUTE__POOL_SIZE,
			TEST_EXECUTE__BLOCK_SIZE,
			1024,
			0,
			interval,
			DummyMessageDispatcher,
			EXECMODE_BLOCKED);

	// get messages from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));

	// define content
	msg1->address = 11;
	msg1->evtID = 111;
	msg2->address = 22;
	msg2->evtID = 222;

	// push messages to queue
	etMessageService_pushMessage(&msgService, msg1);
	etMessageService_pushMessage(&msgService, msg2);

	etMessageService_start(&msgService);
	etThread_sleep(100); /* wait 100 ms for the delivery */

	EXPECT_EQUAL_INT16(id, "deliverAllMessages msg1", msg1->evtID, receivedEventIDs[0]);
	EXPECT_EQUAL_INT16(id, "deliverAllMessages msg2", msg2->evtID, receivedEventIDs[1]);
	EXPECT_EQUAL_INT16(id, "deliverAllMessages receivedEventIDCounter", 2, receivedEventIDCounter);

	etMessageService_stop(&msgService);
	// workaround: wait before destroy, thus preventing segmentation fault from msgServic thread
	etThread_sleep(100);
	etMessageService_destroy(&msgService);
}

void TestEtMessageService_getMessagePoolLowWaterMark(etInt16 id){
	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];
	etTime interval;

	etMessageService_init(
			&msgService,
			msgBuffer,
			max,
			blockSize,
			1024,
			0,
			interval,
			DummyMessageDispatcher,
			EXECMODE_BLOCKED);

	EXPECT_EQUAL_INT16(id, "inital low water mark", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "inital high water mark", 0, msgService.statistics.queueStatistics.highWaterMark);

	// get messages from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));

	// define content
	msg1->address = 11;
	msg1->evtID = 111;
	msg2->address = 22;
	msg2->evtID = 222;

	// push messages to queue
	etMessageService_pushMessage(&msgService, msg2);
	etMessageService_pushMessage(&msgService, msg1);

	EXPECT_EQUAL_INT16(id, "low water mark 1", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "high water mark 1", 2, msgService.statistics.queueStatistics.highWaterMark);

	// pop messages from queue
	etMessage* rcvMsg1 = etMessageService_popMessage(&msgService);
	etMessage* rcvMsg2 = etMessageService_popMessage(&msgService);

	etMessageService_returnMessageBuffer(&msgService, rcvMsg1);
	etMessageService_returnMessageBuffer(&msgService, rcvMsg2);

	EXPECT_EQUAL_INT16(id, "low water mark 2", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "high water mark 2", 2, msgService.statistics.queueStatistics.highWaterMark);

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	etMessageService_pushMessage(&msgService, msg1);

	/*still the same*/
	EXPECT_EQUAL_INT16(id, "low water mark 3", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "high water mark 3", 2, msgService.statistics.queueStatistics.highWaterMark);

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);

	/*  no message left */
	EXPECT_EQUAL_INT16(id, "low water mark 4", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "high water mark 4", max, msgService.statistics.queueStatistics.highWaterMark);

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	EXPECT_EQUAL_PTR(id, "check message for NULL", NULL, msg1);

	/*  still no message left */
	EXPECT_EQUAL_INT16(id, "low water mark 6", 0, msgService.statistics.queueStatistics.lowWaterMark);
	EXPECT_EQUAL_INT16(id, "high water mark 6", max, msgService.statistics.queueStatistics.highWaterMark);

	etMessageService_destroy(&msgService);
}


void TestEtMessageService_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtMessageService");
	ADD_TESTCASE(TestEtMessageService_init);
	ADD_TESTCASE(TestEtMessageService_GetPushPopReturn);
	ADD_TESTCASE(TestEtMessageService_GetReturn);
	ADD_TESTCASE(TestEtMessageService_execute);
	ADD_TESTCASE(TestEtMessageService_getMessagePoolLowWaterMark)
	etUnit_closeTestSuite();
}
