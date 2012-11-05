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

#include "TestEtMemory.h"

#include <stddef.h>
#include <string.h>
#include "etUnit/etUnit.h"
#include "base/etMemory_FixedSize.h"
#include "base/etMemory_FreeList.h"

#define BUF_SIZE		(256*1024)
#define BLOCK_SIZE		128
#define TEST_BLOCKS		1024
#define TEST_BLOCK_SIZE	64

#define NOBJ			32
#define NSLOTS			8
#define SIZE0			64
#define SIZE1			16
#define SIZE2			32
#define SIZE3			48
#define SIZE4			(16*8)
#define SIZE5			112
#define SIZE6			96


static void TestEtMemory_testFixedSize(etInt16 id) {
	etUInt8 buffer[BUF_SIZE];
	etUInt8* objects[TEST_BLOCKS];
	int i;
	etMemory* mem = etMemory_FixedSize_init(buffer, BUF_SIZE, BLOCK_SIZE);
	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	for (i=0; i<TEST_BLOCKS; ++i) {
		objects[i] = mem->alloc(mem, TEST_BLOCK_SIZE);
		if (objects[i]==NULL)
			EXPECT_TRUE(id, "objects[i]==NULL", FALSE);

		memset(objects[i], i%4, TEST_BLOCK_SIZE);
	}
	for (i=0; i<TEST_BLOCKS/2; ++i) {
		mem->free(mem, objects[i*2], TEST_BLOCK_SIZE);
	}
	for (i=0; i<TEST_BLOCKS/2; ++i) {
		objects[i*2] = mem->alloc(mem, TEST_BLOCK_SIZE);
		if (objects[i*2]==NULL)
			EXPECT_TRUE(id, "objects[i*2]==NULL", FALSE);
	}
}

static void local_alloc(etInt16 id, etMemory* mem, etUInt8* objects[7][NOBJ], etUInt8 sizes[7]) {
	int i;
#define KIND	0
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	1
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	2
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	3
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	4
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	5
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}

#undef KIND
#define KIND	6
	for (i=0; i<NOBJ; ++i) {
		objects[KIND][i] = mem->alloc(mem, sizes[KIND]);
		if (objects[KIND][i]==NULL)
			EXPECT_TRUE(id, "objects[KIND][i]==NULL", FALSE);
	}
}


static void local_free(etInt16 id, etMemory* mem, etUInt8* objects[7][NOBJ], etUInt8 sizes[7]) {
	int i;
#undef KIND
#define KIND	0
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	1
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	2
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	3
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	4
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	5
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}

#undef KIND
#define KIND	6
	for (i=0; i<NOBJ; ++i) {
		mem->free(mem, objects[KIND][i], sizes[KIND]);
	}
}

static void TestEtMemory_testFreeList(etInt16 id) {
	static etUInt8 buffer[BUF_SIZE];
	static etUInt8 sizes[7] = { SIZE0, SIZE1, SIZE2, SIZE3, SIZE4, SIZE5, SIZE6 };
	etUInt8* objects[7][NOBJ];
	etMemory* mem = etMemory_FreeList_init(buffer, BUF_SIZE, NSLOTS);
	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	local_alloc(id, mem, objects, sizes);
	local_free(id, mem, objects, sizes);
	local_alloc(id, mem, objects, sizes);
	local_free(id, mem, objects, sizes);
}

void TestEtMemory_runSuite(void){
	etUnit_openTestSuite("TestMemory");
	ADD_TESTCASE(TestEtMemory_testFixedSize);
	ADD_TESTCASE(TestEtMemory_testFreeList);
	etUnit_closeTestSuite();
}

