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

/*
 * RunCGeneratorTestcases.c
 *
 *  Created on: 12.01.2012
 *      Author: tschuetz
 */

#include "RunCGeneratorTestcases.h"

#include "TestDataClass.h"
#include "etUnit/etUnit.h"
#include "debugging/etMSCLogger.h"



void RunCGeneratorTestcases(void){
	etUnit_open("tmp/testlog","TestCGenerator");
	TestDataClass_runSuite();
	etUnit_close();
}
