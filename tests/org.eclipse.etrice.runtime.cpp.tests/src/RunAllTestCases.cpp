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

#include "common/containers/Set.h"
#include "containers/SetTest.h"
#include "containers/StaticDequeTest.h"
#include "containers/StaticArrayTest.h"
#include "containers/StaticStringTest.h"
#include "containers/StringTest.h"
#include "containers/VectorTest.h"
#include "containers/PairTest.h"
#include "containers/MapTest.h"
#include "debugging/MSCFunctionObjectTest.h"
#include "debugging/MSCFilterTest.h"
#include "debugging/MSCLoggerTest.h"
#include "debugging/DebuggingServiceTest.h"
#include "messaging/AddressTest.h"
#include "messaging/MessageTest.h"
#include "messaging/RTObjectTest.h"
#include "messaging/MessageSeQueueTest.h"
#include "messaging/MessageDispatcherTest.h"
#include "messaging/MessageServiceTest.h"
#include "messaging/MessageServiceControllerTest.h"
#include "messaging/StaticMessageMemoryTest.h"
#include "etUnit/etUnit.h"

int main() {

	etUnit_open("log", "TestCppRuntime");

	// Test containers
	StaticArrayTest staticArrayTest;
	staticArrayTest.run();

	StaticStringTest staticStringTest;
	staticStringTest.run();

	StaticDequeTest dequeTest;
	dequeTest.run();

	StringTest stringTest;
	stringTest.run();

	VectorTest vectorTest;
	vectorTest.run();

	SetTest setTest;
	setTest.run();

	PairTest pairTest;
	pairTest.run();

	MapTest mapTest;
	mapTest.run();

	// Test debugging
	MSCFilterTest filterTest;
	filterTest.run();

	MSCLoggerTest loggerTest;
	loggerTest.run();

	DebuggingServiceTest debugSvcTest;
	debugSvcTest.run();

	MSCFunctionObjectTest mscFunctionObjTest;
	mscFunctionObjTest.run();

	// Test messaging
	AddressTest addressTest;
	addressTest.run();

	MessageTest messageTest;
	messageTest.run();

	RTObjectTest rtobjectTest;
	rtobjectTest.run();

	MessageSeQueueTest msgQueueTest;
	msgQueueTest.run();

	MessageDispatcherTest msgDispatcherTest;
	msgDispatcherTest.run();

	MessageServiceTest msgServiceTest;
	msgServiceTest.run();

	MessageServiceControllerTest msgSvcCtrlTest;
	msgSvcCtrlTest.run();

	StaticMessageMemoryTest staticMsgMemTest;
	staticMsgMemTest.run();

	etUnit_close();

	printf("String allocations %d and deallocations %d\n", etRuntime::String::getNAllocations(), etRuntime::String::getNDeallocations());
	printf("String creations %d and destructions %d\n", etRuntime::String::getNCreated(), etRuntime::String::getNDestroyed());
	printf("Vector allocations %d and deallocations %d\n", etRuntime::VectorStats::getNAllocations(), etRuntime::VectorStats::getNDeallocations());
	printf("Vector creations %d and destructions %d\n", etRuntime::VectorStats::getNCreated(), etRuntime::VectorStats::getNDestroyed());
	printf("Set creations %d and destructions %d\n", etRuntime::SetStats::getNCreated(), etRuntime::SetStats::getNDestroyed());
	printf("Map creations %d and destructions %d\n", etRuntime::MapStats::getNCreated(), etRuntime::MapStats::getNDestroyed());

	fflush(stdout);

	return 0;
}

