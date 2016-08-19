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

#include "messaging/AddressTest.h"
#include "containers/StaticArrayTest.h"
#include "containers/StaticStringTest.h"

#include "etUnit/etUnit.h"

int main(){

	etUnit_open("log/testlog","TestCppRuntime");

	AddressTest addressTest;
	addressTest.run();

	StaticArrayTest staticArrayTest;
	staticArrayTest.run();

	StaticStringTest staticStringTest;
	staticStringTest.run();

	etUnit_close();

	return 0;
}

