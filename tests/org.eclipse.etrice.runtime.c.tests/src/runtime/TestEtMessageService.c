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
void DummyMessageDispatcher(const etMessage* msg){
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
}

void TestEtMessageService_init(void){

	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;

	uint8 msgBuffer[max*blockSize];

	etMessageService_init(&msgService, msgBuffer, max, blockSize, DummyMessageDispatcher);

	EXPECT_EQUAL_PTR("msgService.messagePool.first", msgBuffer, msgService.messagePool.first);
	EXPECT_EQUAL_PTR("msgService.messagePool in between", &msgBuffer[3*blockSize], msgService.messagePool.first->next->next->next);
	EXPECT_EQUAL_PTR("msgService.messagePool.last(1)", &msgBuffer[5*blockSize], msgService.messagePool.first->next->next->next->next->next);
	EXPECT_EQUAL_PTR("msgService.messagePool.last(2)", &msgBuffer[5*blockSize], msgService.messagePool.last);
	EXPECT_EQUAL_PTR("msgService.messagePool.last.next", 0, msgService.messagePool.last->next);

}

void TestEtMessageService_GetPushPopReturn(void){

	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];

	etMessageService_init(&msgService, msgBuffer, max, blockSize, DummyMessageDispatcher);

	// get messages from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));

	EXPECT_EQUAL_INT16("msgService.messagePool.size", 4, msgService.messagePool.size);

	// define content
	msg1->address = 11;
	msg1->evtID = 111;
	msg2->address = 22;
	msg2->evtID = 222;

	// push messages to queue
	etMessageService_pushMessage(&msgService, msg2);
	etMessageService_pushMessage(&msgService, msg1);

	EXPECT_EQUAL_INT16("msgService.messageQueue.size", 2, msgService.messageQueue.size);

	// pop messages from queue
	etMessage* rcvMsg1 = etMessageService_popMessage(&msgService);
	etMessage* rcvMsg2 = etMessageService_popMessage(&msgService);

	EXPECT_EQUAL_INT16("msgService.messageQueue.size",0, msgService.messageQueue.size);


	EXPECT_EQUAL_INT16("msgService.popMessage", 22, rcvMsg1->address);
	EXPECT_EQUAL_INT16("msgService.popMessage", 222, rcvMsg1->evtID);
	EXPECT_EQUAL_INT16("msgService.popMessage", 11, rcvMsg2->address);
	EXPECT_EQUAL_INT16("msgService.popMessage", 111, rcvMsg2->evtID);

	etMessageService_returnMessageBuffer(&msgService, rcvMsg1);
	etMessageService_returnMessageBuffer(&msgService, rcvMsg2);

	EXPECT_EQUAL_INT16("msgService.messagePool.size", 6, msgService.messagePool.size);

}

void TestEtMessageService_GetReturn(void){

	etMessageService msgService;
	uint16 max = 2;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];

	etMessageService_init(&msgService, msgBuffer, max, blockSize, DummyMessageDispatcher);

	// get one message too much from pool
	etMessage* msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessage* msg3 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	EXPECT_TRUE("msgService getMessageBuffer", msg1!=NULL);
	EXPECT_TRUE("msgService getMessageBuffer", msg2!=NULL);
	EXPECT_EQUAL_PTR("msgService getMessageBuffer", msg3, NULL);

	// return messages
	etMessageService_returnMessageBuffer(&msgService, msg1);
	etMessageService_returnMessageBuffer(&msgService, msg2);
	EXPECT_EQUAL_INT16("msgService.messagePool.size", 2, msgService.messagePool.size);

	// get message bigger than blocksize
	etMessage* msg4 = etMessageService_getMessageBuffer(&msgService, 33);
	EXPECT_EQUAL_PTR("msgService getMessageBuffer", msg4, NULL);

}

void TestEtMessageService_execute(void){
	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];

	etMessageService_init(&msgService, msgBuffer, max, blockSize, DummyMessageDispatcher);

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

	/* make sure that receivedEventIDCounter==0 and receivedEventIDs[n]==0*/
	etMessageService_execute(&msgService);
	EXPECT_EQUAL_INT16("deliverAllMessages msg1", msg1->evtID, receivedEventIDs[0]);
	EXPECT_EQUAL_INT16("deliverAllMessages msg2", msg2->evtID, receivedEventIDs[1]);
	EXPECT_EQUAL_INT16("deliverAllMessages receivedEventIDCounter", 2, receivedEventIDCounter);
}

void TestEtMessageService_getMessagePoolLowWaterMark(void){
	etMessageService msgService;
	uint16 max = 6;
	uint16 blockSize = 32;
	uint8 msgBuffer[max*blockSize];

	etMessageService_init(&msgService, msgBuffer, max, blockSize, DummyMessageDispatcher);

	EXPECT_EQUAL_INT16("inital low water mark", max, etMessageService_getMessagePoolLowWaterMark(&msgService));

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

	EXPECT_EQUAL_INT16("low water mark 1", max-2, etMessageService_getMessagePoolLowWaterMark(&msgService));

	// pop messages from queue
	etMessage* rcvMsg1 = etMessageService_popMessage(&msgService);
	etMessage* rcvMsg2 = etMessageService_popMessage(&msgService);

	etMessageService_returnMessageBuffer(&msgService, rcvMsg1);
	etMessageService_returnMessageBuffer(&msgService, rcvMsg2);

	EXPECT_EQUAL_INT16("low water mark 2", max-2, etMessageService_getMessagePoolLowWaterMark(&msgService));

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	msg2 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	etMessageService_pushMessage(&msgService, msg1);

	/*still the same*/
	EXPECT_EQUAL_INT16("low water mark 3", max-2, etMessageService_getMessagePoolLowWaterMark(&msgService));

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);
	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	etMessageService_pushMessage(&msgService, msg2);

	/*  no message left */
	EXPECT_EQUAL_INT16("low water mark 4", 0, etMessageService_getMessagePoolLowWaterMark(&msgService));

	msg1 = etMessageService_getMessageBuffer(&msgService, sizeof(etMessage));
	EXPECT_EQUAL_PTR("check message for NULL", NULL, msg1);

	/*  still no message left */
	EXPECT_EQUAL_INT16("low water mark 6", 0, etMessageService_getMessagePoolLowWaterMark(&msgService));


}


void TestEtMessageService_runSuite(void){
	etUnit_openTestSuite("TestEtMessageService");
	ADD_TESTCASE(TestEtMessageService_init);
	ADD_TESTCASE(TestEtMessageService_GetPushPopReturn);
	ADD_TESTCASE(TestEtMessageService_GetReturn);
	ADD_TESTCASE(TestEtMessageService_execute);
	ADD_TESTCASE(TestEtMessageService_getMessagePoolLowWaterMark)
	etUnit_closeTestSuite();
}
