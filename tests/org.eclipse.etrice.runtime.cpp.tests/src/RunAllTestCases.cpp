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

#include "containers/StaticArrayTest.h"
#include "containers/StaticStringTest.h"
//#include "debugging/MSCFilterTest.h"
//#include "debugging/MSCLoggerTest.h"
//#include "debugging/DebuggingServiceTest.h"
#include "messaging/AddressTest.h"
#include "messaging/MessageTest.h"
#include "messaging/RTObjectTest.h"
#include "messaging/MessageSeQueueTest.h"
#include "messaging/MessageDispatcherTest.h"
#include "messaging/MessageServiceTest.h"
//#include "messaging/MessageServiceControllerTest.h"

#include "etUnit/etUnit.h"

int main() {

	etUnit_open("log/testlog", "TestCppRuntime");

	// Test containers
	StaticArrayTest staticArrayTest;
	staticArrayTest.run();

	StaticStringTest staticStringTest;
	staticStringTest.run();

	// Test debugging
//	MSCFilterTest filterTest;
//	filterTest.run();
//
//	MSCLoggerTest loggerTest;
//	loggerTest.run();
//
//	DebuggingServiceTest debugSvcTest;
//	debugSvcTest.run();

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
//
//	MessageServiceControllerTest msgSvcCtrlTest;
//	msgSvcCtrlTest.run();

	etUnit_close();

	return 0;
}

