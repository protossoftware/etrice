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
#include "base/etMemory_VariableSize.h"
#include "base/etMemory_FixedSize.h"
#include "base/etMemory_FreeList.h"

#define KBYTE			1024
#define BUF_SIZE		(256*KBYTE)
#define BUF_SIZE_SMALL	(2*KBYTE)
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


static void TestEtMemory_testVariableSize(etInt16 id) {
	etUInt8* buffer = malloc(BUF_SIZE);
	const etUInt16 blockSize = 2 * KBYTE;
	const int nBlocks = BUF_SIZE / blockSize;
	etMemory* mem = etMemory_VariableSize_init(buffer, BUF_SIZE);
	int i;
	void* obj;

	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	/* nBlocks-1 objects can be allocated */
	for (i=1; i<nBlocks; ++i) {
		obj = mem->alloc(mem, blockSize);
		if (obj==NULL) {
			EXPECT_TRUE(id, "obj==NULL", ET_FALSE);
		}
	}

	/* another block should fail */
	obj = mem->alloc(mem, blockSize);
	if (obj!=NULL) {
		EXPECT_TRUE(id, "obj!=NULL", ET_FALSE);
	}
}

static void TestEtMemory_testFixedSize(etInt16 id) {
	etUInt8* buffer = malloc(BUF_SIZE);
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
		mem->free(mem, objects[i*2]);
	}
	for (i=0; i<TEST_BLOCKS/2; ++i) {
		objects[i*2] = mem->alloc(mem, TEST_BLOCK_SIZE);
		if (objects[i*2]==NULL)
			EXPECT_TRUE(id, "objects[i*2]==NULL", ET_FALSE);
	}
}

static int local_dump_statistics_line(etMemory* mem, int slot) {
	int nobj = etMemory_FreeList_nObjects(mem, slot);
	int size = etMemory_FreeList_sizeObjects(mem, slot);
	int subtotal = nobj*size;

	printf("  slot %3d with %4d objects of size %4d totaling to %8d\n", slot, nobj, size, subtotal);

	return subtotal;
}

static void local_dump_statistics(etMemory* mem, etUInt16 nSlots) {
	int slot;
	int total = 0;
	printf("memory statistics of free list memory management at %p\n", mem);
	for (slot=0; slot<nSlots; ++slot) {
		total += local_dump_statistics_line(mem, slot);
	}
	printf("  total                                           %12d\n", total);
}

static etUInt32 local_alloc(etInt16 id, etMemory* mem, etUInt8* objects[NSIZES][NOBJ], etUInt8 sizes[NSIZES]) {
	int i, kind;
	etUInt32 total = 0;

	for (kind=0; kind<NSIZES; ++kind) {
		total += sizes[kind] * NOBJ;
		for (i=0; i<NOBJ; ++i) {
			objects[kind][i] = mem->alloc(mem, sizes[kind]);
			if (objects[kind][i]==NULL)
				EXPECT_TRUE(id, "objects[kind][i]==NULL", ET_FALSE);
		}
	}

	return total;
}


static void local_free(etInt16 id, etMemory* mem, etUInt8* objects[NSIZES][NOBJ], etUInt8 sizes[NSIZES]) {
	int i, kind;

	for (kind=0; kind<NSIZES; ++kind) {
		for (i=0; i<NOBJ; ++i) {
			mem->free(mem, objects[kind][i]);
		}
	}
}

static void checkSlot(etInt16 id, etMemory* mem, int slot, etUInt16 size, etUInt16 nObj) {
	char text[32];
	sprintf(text, "slot %d size", size);
	EXPECT_EQUAL_UINT16(id, text, size, etMemory_FreeList_sizeObjects(mem, slot));
	sprintf(text, "slot %d nobj", nObj);
	EXPECT_EQUAL_UINT16(id, text, nObj, etMemory_FreeList_nObjects(mem, slot));
}

static void checkState(etInt16 id, etMemory* mem, const char* text, etUInt32 actual, etUInt32 expected) {
	int slot;

	EXPECT_EQUAL_UINT32(id, text, actual, expected);
	EXPECT_EQUAL_UINT16(id, "free slots", NSLOTS-NSIZES, etMemory_FreeList_freeSlots(mem));

	slot = 0;
	checkSlot(id, mem, slot++, SIZE5, NOBJ);
	checkSlot(id, mem, slot++, SIZE0, NOBJ);
	checkSlot(id, mem, slot++, SIZE4, NOBJ);
	checkSlot(id, mem, slot++, SIZE1, NOBJ);
	slot++;
	checkSlot(id, mem, slot++, SIZE2, NOBJ);
	checkSlot(id, mem, slot++, SIZE6, NOBJ);
	checkSlot(id, mem, slot++, SIZE3, NOBJ);
}

static void TestEtMemory_testFreeList(etInt16 id) {
	etUInt8* buffer = malloc(BUF_SIZE);
	static etUInt8 sizes[NSIZES] = { SIZE0, SIZE1, SIZE2, SIZE3, SIZE4, SIZE5, SIZE6 };
	etUInt8* objects[NSIZES][NOBJ];
	etMemory* mem = etMemory_FreeList_init(buffer, BUF_SIZE, NSLOTS);
	etUInt32 free = etMemory_FreeList_getFreeHeapMem(mem);
	etUInt32 diff, total;
	int slot;

	printf("initial free heap is %ld\n", free);

	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	total = local_alloc(id, mem, objects, sizes);
	printf("after alloc\n");
	local_dump_statistics(mem, NSLOTS);

	local_free(id, mem, objects, sizes);
	printf("after free\n");
	local_dump_statistics(mem, NSLOTS);

	diff = free;
	free = etMemory_FreeList_getFreeHeapMem(mem);
	diff -= free;

	/* correction by management data */
	diff -= NSIZES*NOBJ*etMemory_FreeList_MgmtDataPerObject();

	printf("free heap is %ld\n", free);
	fflush(stdout);

	/* do checks */
	checkState(id, mem, "allocated total", total, diff);

	/* allocate and free again */
	local_alloc(id, mem, objects, sizes);
	local_free(id, mem, objects, sizes);

	/* expect same results as before */
	checkState(id, mem, "free unchanged", free, etMemory_FreeList_getFreeHeapMem(mem));
}

static void TestEtMemory_testFreeListOverflow(etInt16 id) {
	etUInt8* buffer = malloc(BUF_SIZE_SMALL);
	etMemory* mem = etMemory_FreeList_init(buffer, BUF_SIZE_SMALL, NSLOTS);
	void* obj;

	EXPECT_TRUE(id, "mem!=NULL", mem!=NULL);

	obj = mem->alloc(mem, BUF_SIZE_SMALL+1);
	EXPECT_TRUE(id, "insufficient space, expect NULL", NULL==obj);
}

static void TestEtMemory_testStatistics(etInt16 id) {
	etMemoryStatistics* stat;
	int n;

	EXPECT_EQUAL_INT32(id, "tests created some memory managements", 4, etRuntime_getMemoryManagementCount());

	n = 0;
	stat = etRuntime_getMemoryManagementStatistics(n);
	EXPECT_TRUE(id, "stat!=NULL", stat!=NULL);
	printf("checking memory management %d, %s, max %d, fail %d\n", n, etRuntime_getMemoryManagementName(n), stat->maxUsed, stat->nFailingRequests);
	fflush(stdout);
	EXPECT_EQUAL_INT32(id, "maxUsed", 0, stat->maxUsed);
	EXPECT_EQUAL_INT32(id, "nFailingRequests", 1, stat->nFailingRequests);

	n = 1;
	stat = etRuntime_getMemoryManagementStatistics(n);
	EXPECT_TRUE(id, "stat!=NULL", stat!=NULL);
	printf("checking memory management %d, %s, max %d, fail %d\n", n, etRuntime_getMemoryManagementName(n), stat->maxUsed, stat->nFailingRequests);
	fflush(stdout);
	EXPECT_EQUAL_INT32(id, "maxUsed", 261784, stat->maxUsed);
	EXPECT_EQUAL_INT32(id, "nFailingRequests", 0, stat->nFailingRequests);

	n = 2;
	stat = etRuntime_getMemoryManagementStatistics(n);
	EXPECT_TRUE(id, "stat!=NULL", stat!=NULL);
	printf("checking memory management %d, %s, max %d, fail %d\n", n, etRuntime_getMemoryManagementName(n), stat->maxUsed, stat->nFailingRequests);
	fflush(stdout);
	EXPECT_EQUAL_INT32(id, "maxUsed", 131144, stat->maxUsed);
	EXPECT_EQUAL_INT32(id, "nFailingRequests", 0, stat->nFailingRequests);

	n = 3;
	stat = etRuntime_getMemoryManagementStatistics(n);
	EXPECT_TRUE(id, "stat!=NULL", stat!=NULL);
	printf("checking memory management %d, %s, max %d, fail %d\n", n, etRuntime_getMemoryManagementName(n), stat->maxUsed, stat->nFailingRequests);
	fflush(stdout);
	EXPECT_EQUAL_INT32(id, "maxUsed", 260016, stat->maxUsed);
	EXPECT_EQUAL_INT32(id, "nFailingRequests", 1, stat->nFailingRequests);
}

void TestEtMemory_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestMemory");
	ADD_TESTCASE(TestEtMemory_testVariableSize);
	ADD_TESTCASE(TestEtMemory_testFixedSize);
	ADD_TESTCASE(TestEtMemory_testFreeList);
	ADD_TESTCASE(TestEtMemory_testFreeListOverflow);
	/*ADD_TESTCASE(TestEtMemory_testStatistics);*/
	etUnit_closeTestSuite();
}

