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

#ifndef _ETUNIT_H_
#define _ETUNIT_H_

#include "etDatatypes.h"


/* open / close */
void etUnit_open(const char* testResultPath, const char* testFileName);
void etUnit_close(void);
void etUnit_openTestSuite(const char* testSuiteName);
void etUnit_closeTestSuite(void);
etInt16 etUnit_openTestCase(const char* testCaseName);
void etUnit_closeTestCase(etInt16 id);
etBool etUnit_isSuccess(etInt16 id);
void etUnit_testFinished(etInt16 id);

/* functions for more convenience for model and generator tests */

etInt16 etUnit_openAll(const char* testResultPath, const char* testFileName, const char* testSuiteName, const char* testCaseName);
void etUnit_closeAll(etInt16 id);

/* boolean values */
#define EXPECT_TRUE(id, msg, condition)		expectTrue(id, msg, condition, __FILE__, __LINE__)
#define EXPECT_FALSE(id, msg, condition)	expectFalse(id, msg, condition, __FILE__, __LINE__)

/* signed integer values */
#define EXPECT_EQUAL_INT8(id, msg, expected, actual)		expectEqualInt8(id, msg, expected, actual, __FILE__, __LINE__)
#define EXPECT_EQUAL_INT16(id, msg, expected, actual)		expectEqualInt16(id, msg, expected, actual, __FILE__, __LINE__)
#define EXPECT_EQUAL_INT32(id, msg, expected, actual)		expectEqualInt32(id, msg, expected, actual, __FILE__, __LINE__)

/* unsigned integer values */
#define EXPECT_EQUAL_UINT8(id, msg, expected, actual)		expectEqualUInt8(id, msg, expected, actual, __FILE__, __LINE__)
#define EXPECT_EQUAL_UINT16(id, msg, expected, actual)		expectEqualUInt16(id, msg, expected, actual, __FILE__, __LINE__)
#define EXPECT_EQUAL_UINT32(id, msg, expected, actual)		expectEqualUInt32(id, msg, expected, actual, __FILE__, __LINE__)

/* float values */
#define EXPECT_EQUAL_FLOAT32(id, msg, expected, actual, precision)		expectEqualFloat32(id, msg, expected, actual, precision, __FILE__, __LINE__)

/* Pointers */
#define EXPECT_EQUAL_PTR(id, msg, expected, actual) \
	expect_equal_void_ptr(id, msg, (const void*) expected, (const void*) actual, __FILE__, __LINE__)


/* more specialized functions */
#define EXPECT_ORDER_START(id, list, size)		expectOrderStart(id, list, size, __FILE__, __LINE__)
#define EXPECT_ORDER(id, msg, val)				expectOrder(id, msg, val, __FILE__, __LINE__)
#define EXPECT_ORDER_END(id, msg, val)			expectOrderEnd(id, msg, val, __FILE__, __LINE__)


/* Helpers for adding testcases */

#define ADD_TESTCASE(testcase) \
	{ etInt16 id = etUnit_openTestCase(#testcase); \
	testcase(id); \
	etUnit_closeTestCase(id);}

/* function prototypes, use above macros to call them */
void expectTrue(etInt16 id, const char* msg, etBool condition, const char* file, int line);
void expectFalse(etInt16 id, const char* msg, etBool condition, const char* file, int line);
void expectEqualInt8(etInt16 id, const char* msg, etInt8 expected, etInt8 actual, const char* file, int line);
void expectEqualInt16(etInt16 id, const char* msg, etInt16 expected, etInt16 actual, const char* file, int line);
void expectEqualInt32(etInt16 id, const char* msg, etInt32 expected, etInt32 actual, const char* file, int line);
void expectEqualUInt8(etInt16 id, const char* msg, etUInt8 expected, etUInt8 actual, const char* file, int line);
void expectEqualUInt16(etInt16 id, const char* msg, etUInt16 expected, etUInt16 actual, const char* file, int line);
void expectEqualUInt32(etInt16 id, const char* msg, etUInt32 expected, etUInt32 actual, const char* file, int line);
void expectEqualFloat32(etInt16 id, const char* msg, etFloat32 expected, etFloat32 actual, etFloat32 precision, const char* file, int line);
void expect_equal_void_ptr(etInt16 id, const char* msg, const void* expected, const void* actual, const char* file, int line);
void expectOrderStart(etInt16 id, etInt16* list, etInt16 size, const char* file, int line);
void expectOrder(etInt16 id, const char* msg, etInt16 identifier, const char* file, int line);
void expectOrderEnd(etInt16 id, const char* msg, etInt16 identifier, const char* file, int line);

#endif /* _ETUNIT_H_ */
