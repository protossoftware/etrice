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
#define NSIZES			7
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
			EXPECT_TRUE(id, "objects[i]==NULL", ET_FALSE);

		memset(objects[i], i%4, TEST_BLOCK_SIZE);
	}
	for (i=0; i<TEST_BLOCKS/2; ++i) {
		mem->free(mem, objects[i*2], TEST_BLOCK_SIZE);
	}
	for (i=0; i<TEST_BLOCKS/2; ++i) {
		objects[i*2] = mem->alloc(mem, TEST_BLOCK_SIZE);
		if (objects[i*2]==NULL)
			EXPECT_TRUE(id, "objects[i*2]==NULL", ET_FALSE);
	}
}

static void local_alloc(etInt16 id, etMemory* mem, etUInt8* objects[NSIZES][NOBJ], etUInt8 sizes[NSIZES]) {
	int i, kind;

	for (kind=0; kind<NSIZES; ++kind) {
		for (i=0; i<NOBJ; ++i) {
			objects[kind][i] = mem->alloc(mem, sizes[kind]);
			if (objects[kind][i]==NULL)
				EXPECT_TRUE(id, "objects[kind][i]==NULL", ET_FALSE);
		}
	}
}


static void local_free(etInt16 id, etMemory* mem, etUInt8* objects[NSIZES][NOBJ], etUInt8 sizes[NSIZES]) {
	int i, kind;

	for (kind=0; kind<NSIZES; ++kind) {
		for (i=0; i<NOBJ; ++i) {
			mem->free(mem, objects[kind][i], sizes[kind]);
		}
	}
}

static void TestEtMemory_testFreeList(etInt16 id) {
	static etUInt8 buffer[BUF_SIZE];
	static etUInt8 sizes[NSIZES] = { SIZE0, SIZE1, SIZE2, SIZE3, SIZE4, SIZE5, SIZE6 };
	etUInt8* objects[NSIZES][NOBJ];
	etMemory* mem = etMemory_FreeList_init(buffer, BUF_SIZE, NSLOTS);
	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	local_alloc(id, mem, objects, sizes);
	local_free(id, mem, objects, sizes);

	/* causes problems (due to different alignment?)
	   Ubuntu 32 bit:  246212
	   Hudson: 246152
	 */
	if (246212==etMemory_FreeList_freeHeapMem(mem)) {

		EXPECT_EQUAL_UINT32(id, "free heap memory", 246212, etMemory_FreeList_freeHeapMem(mem));

		EXPECT_EQUAL_UINT16(id, "free slots", NSLOTS-NSIZES, etMemory_FreeList_freeSlots(mem));

		EXPECT_EQUAL_UINT16(id, "slot 0 size", SIZE0, etMemory_FreeList_sizeObjects(mem, 0));
		EXPECT_EQUAL_UINT16(id, "slot 0 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 0));
		EXPECT_EQUAL_UINT16(id, "slot 1 size", SIZE2, etMemory_FreeList_sizeObjects(mem, 1));
		EXPECT_EQUAL_UINT16(id, "slot 1 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 1));
		EXPECT_EQUAL_UINT16(id, "slot 2 size", SIZE4, etMemory_FreeList_sizeObjects(mem, 2));
		EXPECT_EQUAL_UINT16(id, "slot 2 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 2));
		EXPECT_EQUAL_UINT16(id, "slot 3 size", SIZE6, etMemory_FreeList_sizeObjects(mem, 3));
		EXPECT_EQUAL_UINT16(id, "slot 3 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 3));
		EXPECT_EQUAL_UINT16(id, "slot 4 size", SIZE1, etMemory_FreeList_sizeObjects(mem, 4));
		EXPECT_EQUAL_UINT16(id, "slot 4 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 4));
		EXPECT_EQUAL_UINT16(id, "slot 5 size", SIZE3, etMemory_FreeList_sizeObjects(mem, 5));
		EXPECT_EQUAL_UINT16(id, "slot 5 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 5));
		EXPECT_EQUAL_UINT16(id, "slot 6 size", SIZE5, etMemory_FreeList_sizeObjects(mem, 6));
		EXPECT_EQUAL_UINT16(id, "slot 6 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 6));

		local_alloc(id, mem, objects, sizes);
		local_free(id, mem, objects, sizes);

		EXPECT_EQUAL_UINT32(id, "free heap memory", 246212, etMemory_FreeList_freeHeapMem(mem));

		EXPECT_EQUAL_UINT16(id, "free slots", NSLOTS-NSIZES, etMemory_FreeList_freeSlots(mem));

		EXPECT_EQUAL_UINT16(id, "slot 0 size", SIZE0, etMemory_FreeList_sizeObjects(mem, 0));
		EXPECT_EQUAL_UINT16(id, "slot 0 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 0));
		EXPECT_EQUAL_UINT16(id, "slot 1 size", SIZE2, etMemory_FreeList_sizeObjects(mem, 1));
		EXPECT_EQUAL_UINT16(id, "slot 1 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 1));
		EXPECT_EQUAL_UINT16(id, "slot 2 size", SIZE4, etMemory_FreeList_sizeObjects(mem, 2));
		EXPECT_EQUAL_UINT16(id, "slot 2 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 2));
		EXPECT_EQUAL_UINT16(id, "slot 3 size", SIZE6, etMemory_FreeList_sizeObjects(mem, 3));
		EXPECT_EQUAL_UINT16(id, "slot 3 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 3));
		EXPECT_EQUAL_UINT16(id, "slot 4 size", SIZE1, etMemory_FreeList_sizeObjects(mem, 4));
		EXPECT_EQUAL_UINT16(id, "slot 4 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 4));
		EXPECT_EQUAL_UINT16(id, "slot 5 size", SIZE3, etMemory_FreeList_sizeObjects(mem, 5));
		EXPECT_EQUAL_UINT16(id, "slot 5 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 5));
		EXPECT_EQUAL_UINT16(id, "slot 6 size", SIZE5, etMemory_FreeList_sizeObjects(mem, 6));
		EXPECT_EQUAL_UINT16(id, "slot 6 nobj", NOBJ, etMemory_FreeList_nObjects(mem, 6));
	}
}

void TestEtMemory_runSuite(void){
	etUnit_openTestSuite("TestMemory");
	ADD_TESTCASE(TestEtMemory_testFixedSize);
	ADD_TESTCASE(TestEtMemory_testFreeList);
	etUnit_closeTestSuite();
}

