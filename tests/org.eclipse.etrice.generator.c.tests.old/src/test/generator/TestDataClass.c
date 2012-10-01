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
 * TestDataClass.c
 *
 *  Created on: 12.01.2012
 *      Author: tschuetz
 */


#include "TestDataClass.h"

#include "etUnit/etUnit.h"

#include "../../../src-gen/cGenRef/DataClass1.h"

void TestDataClass_Operations(void){

	DataClass1 d;
	d.Attr1 = 123;
	d.ComplexAttr.Attr1 = 456;
	d.ComplexAttr.Attr2 = (float32)789.123;
	d.ComplexAttr.Attr3 = 789;
	d.Attr3 = (float32)321.123;

	EXPECT_EQUAL_INT32("Operation DataClass1_MultiplyWithAttr1", 246, DataClass1_MultiplyWithAttr1(&d, 2));
	EXPECT_EQUAL_FLOAT32("Operation DataClass1_MultiplyWithAttr3", (float32)642.246, DataClass1_MultiplyWithAttr3(&d, 2), (float32)0.0001);

}


void TestDataClass_testDataClassDeepCopy(void){

	DataClass1 d, e;
	d.Attr1 = 123;
	d.ComplexAttr.Attr1 = 456;
	d.ComplexAttr.Attr2 = (float32)789.123;
	d.ComplexAttr.Attr3 = 789;
	d.Attr3 = (float32)321.123;

	DataClass1_deepCopy(&d,&e);

	EXPECT_EQUAL_INT32("Attr1", 123, e.Attr1);
	EXPECT_EQUAL_INT32("ComplexAttr.Attr1", 456, e.ComplexAttr.Attr1);
	EXPECT_EQUAL_FLOAT32("ComplexAttr.Attr2", (float32)789.123, e.ComplexAttr.Attr2, 0.001f);
	EXPECT_EQUAL_INT32("ComplexAttr.Attr3", 789, e.ComplexAttr.Attr3);
	EXPECT_EQUAL_FLOAT32("Attr3", (float32)321.123, e.Attr3, (float32)0.0001);

}

void TestDataClass_runSuite(void){
	etUnit_openTestSuite("TestDataClass");
	ADD_TESTCASE(TestDataClass_Operations);
	ADD_TESTCASE(TestDataClass_testDataClassDeepCopy);
	etUnit_closeTestSuite();
}
