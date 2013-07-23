/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "TestEtQueue.h"

#include <stddef.h>
#include "etUnit/etUnit.h"
#include "base/etQueue.h"

#define MAX 1000

typedef struct etTestObject {
	etQueueObj base;
	etInt16 a;
	etInt16 b;
} etTestObject;

static void TestEtQueue_test(etInt16 id){
	etTestObject objects[MAX];
	int16 i;

	etQueue queue;
	etQueue_init(&queue);

	for(i=0; i<MAX; i++){
		objects[i].a = i;
		objects[i].b = i*2;
	}

	int j;
	for(j=0; j<3; j++){
		for (i=0; i<MAX; i++){
			etQueue_push(&queue, &(objects[i].base));
		}
		for (i=0; i<MAX; i++){
			etTestObject* obj = (etTestObject*) etQueue_pop(&queue);
			// EXPECTS are hidden to avoid too many testcases in log
			if (obj == NULL){
				EXPECT_FALSE(id, "obj == NULL", TRUE);
				break;
			}
			if (2*obj->a != obj->b){
				EXPECT_FALSE(id, "2*obj->a != obj->b", TRUE);
				break;
			}
			if (obj->a != i){
				EXPECT_FALSE(id, "obj->a != i", TRUE);
				break;
			}
		}
		EXPECT_EQUAL_INT32(id, "i==MAX", MAX, i);
	}
}

void TestEtQueue_runSuite(void){
	etUnit_openTestSuite("TestQueue");
	ADD_TESTCASE(TestEtQueue_test);
	etUnit_closeTestSuite();
}

