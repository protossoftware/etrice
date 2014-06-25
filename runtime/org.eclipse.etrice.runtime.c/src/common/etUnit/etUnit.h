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

/**
 * \file etUnit.h
 *
 * a collection of methods for unit testing. The component uses a very simple file output format
 * which is translated into JUnit xml format by a separate tool written in Java and also part of the
 * eTrice project
 *
 * \author Thomas Schuetz
 */

#ifndef _ETUNIT_H_
#define _ETUNIT_H_

#include "etDatatypes.h"


/**
 * opens a file to protocol the test results
 *
 * \param testResultPath the file path
 * \param testFileName the file name
 */
void etUnit_open(const char* testResultPath, const char* testFileName);
/**
 * closes the protocol file
 */
void etUnit_close(void);
/**
 * opens a test suite which is a collection of test cases
 *
 * \param testSuiteName the name of the suite
 */
void etUnit_openTestSuite(const char* testSuiteName);
/**
 * closes the currently open test suite
 */
void etUnit_closeTestSuite(void);
/**
 * opens a test case. Multiple test cases can be open at a time
 *
 * \param testCaseName the name of the test case
 *
 * \return an id for the test case which has to be used as an identifier
 * for the expect... and other methods
 */
etInt16 etUnit_openTestCase(const char* testCaseName);
/**
 * closes a test case
 *
 * \param id the test case id
 */
void etUnit_closeTestCase(etInt16 id);
/**
 * indicate success of a test case
 *
 * \param id the test case id
 */
etBool etUnit_isSuccess(etInt16 id);
/**
 * releases the \ref etRuntime_getTerminateSemaphore() and thus makes the program terminate
 *
 * \param id (unused)
 */
void etUnit_testFinished(etInt16 id);

/* functions for more convenience for model and generator tests */

/**
 * opens a file, test suite and test case
 *
 * \param testResultPath the file path
 * \param testFileName the file name
 * \param testSuiteName the name of the suite
 * \param testCaseName the name of the test case
 *
 * \return an id for the test case which has to be used as an identifier
 * for the expect... and other methods
 */
etInt16 etUnit_openAll(const char* testResultPath, const char* testFileName, const char* testSuiteName, const char* testCaseName);
/**
 * closes test case, suite and file
 *
 * \param id the test case id
 */
void etUnit_closeAll(etInt16 id);

/*
 * boolean values
 */

/**
 * calls \ref expectTrue()
 */
#define EXPECT_TRUE(id, msg, condition)		expectTrue(id, msg, condition, __FILE__, __LINE__)
/** calls \ref expectFalse() */
#define EXPECT_FALSE(id, msg, condition)	expectFalse(id, msg, condition, __FILE__, __LINE__)

/*
 * signed integer values
 */
/** calls \ref expectEqualInt8() */
#define EXPECT_EQUAL_INT8(id, msg, expected, actual)		expectEqualInt8(id, msg, expected, actual, __FILE__, __LINE__)
/** calls \ref expectEqualInt16() */
#define EXPECT_EQUAL_INT16(id, msg, expected, actual)		expectEqualInt16(id, msg, expected, actual, __FILE__, __LINE__)
/** calls \ref expectEqualInt32() */
#define EXPECT_EQUAL_INT32(id, msg, expected, actual)		expectEqualInt32(id, msg, expected, actual, __FILE__, __LINE__)

/*
 * unsigned integer values
 */
/** calls \ref expectEqualUInt8() */
#define EXPECT_EQUAL_UINT8(id, msg, expected, actual)		expectEqualUInt8(id, msg, expected, actual, __FILE__, __LINE__)
/** calls \ref expectEqualUInt16() */
#define EXPECT_EQUAL_UINT16(id, msg, expected, actual)		expectEqualUInt16(id, msg, expected, actual, __FILE__, __LINE__)
/** calls \ref expectEqualUInt32() */
#define EXPECT_EQUAL_UINT32(id, msg, expected, actual)		expectEqualUInt32(id, msg, expected, actual, __FILE__, __LINE__)

/*
 * float values
 */
/** calls \ref expectEqualFloat32() */
#define EXPECT_EQUAL_FLOAT32(id, msg, expected, actual, precision)		expectEqualFloat32(id, msg, expected, actual, precision, __FILE__, __LINE__)
/** calls \ref expectEqualFloat64() */
#define EXPECT_EQUAL_FLOAT64(id, msg, expected, actual, precision)		expectEqualFloat64(id, msg, expected, actual, precision, __FILE__, __LINE__)

#define EXPECT_RANGE_FLOAT32(id, msg, min, max, actual)		expectRangeFloat32(id, msg, min, max, actual, __FILE__, __LINE__)
#define EXPECT_RANGE_FLOAT64(id, msg, min, max, actual)		expectRangeFloat64(id, msg, min, max, actual, __FILE__, __LINE__)

/*
 * Pointers
 */
/** calls \ref expect_equal_void_ptr() */
#define EXPECT_EQUAL_PTR(id, msg, expected, actual) \
	expect_equal_void_ptr(id, msg, (const void*) expected, (const void*) actual, __FILE__, __LINE__)


/*
 * more specialized functions
 */
/** calls \ref expectOrderStart() */
#define EXPECT_ORDER_START(id, list, size)		expectOrderStart(id, list, size, __FILE__, __LINE__)
/** calls \ref expectOrder() */
#define EXPECT_ORDER(id, msg, val)				expectOrder(id, msg, val, __FILE__, __LINE__)
/** calls \ref expectOrderEnd() */
#define EXPECT_ORDER_END(id, msg, val)			expectOrderEnd(id, msg, val, __FILE__, __LINE__)


/*
 * Helpers for adding test cases
 */

/**
 * code block with calls \ref etUnit_openTestCase() followed by a call to the passed
 * test case followed by a call to \ref etUnit_closeTestCase
 *
 * \param testcase the name of a test case method
 */
#define ADD_TESTCASE(testcase) \
	{ etInt16 id = etUnit_openTestCase(#testcase); \
	testcase(id); \
	etUnit_closeTestCase(id);}

/*
 * function prototypes, use above macros to call them
 */

/**
 * reports an error if the condition is <code>false</code>
 *
 * \param id the test case id
 * \param msg the result message
 * \param condition the condition that is expected to be <code>true</code>
 * \param file the file name with the test case
 * \param line the line
 */
void expectTrue(etInt16 id, const char* msg, etBool condition, const char* file, int line);
/**
 * reports an error if the condition is <code>true</code>
 *
 * \param id the test case id
 * \param msg the result message
 * \param condition the condition that is expected to be <code>false</code>
 * \param file the file name with the test case
 * \param line the line
 */
void expectFalse(etInt16 id, const char* msg, etBool condition, const char* file, int line);
/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualInt8(etInt16 id, const char* msg, etInt8 expected, etInt8 actual, const char* file, int line);

/**
 * reports an error if a value is not inside a range e.g. [2, 123]
 *
 * \param id the test case id
 * \param msg the result message
 * \param min the lower limit (inclusive)
 * \param max the upper limit (inclusive)
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectRangeInt8(etInt16 id, const char* msg, etInt8 min, etInt8 max, etInt8 actual, const char* file, int line);

/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualInt16(etInt16 id, const char* msg, etInt16 expected, etInt16 actual, const char* file, int line);
/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualInt32(etInt16 id, const char* msg, etInt32 expected, etInt32 actual, const char* file, int line);
/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualUInt8(etInt16 id, const char* msg, etUInt8 expected, etUInt8 actual, const char* file, int line);
/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualUInt16(etInt16 id, const char* msg, etUInt16 expected, etUInt16 actual, const char* file, int line);
/**
 * reports an error if two integers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualUInt32(etInt16 id, const char* msg, etUInt32 expected, etUInt32 actual, const char* file, int line);
/**
 * reports an error if two floats aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param precision expected +/- precision defines the window for acceptance of an actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualFloat32(etInt16 id, const char* msg, etFloat32 expected, etFloat32 actual, etFloat32 precision, const char* file, int line);
/**
 * reports an error if two floats aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param precision expected +/- precision defines the window for acceptance of an actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectEqualFloat64(etInt16 id, const char* msg, etFloat64 expected, etFloat64 actual, etFloat64 precision, const char* file, int line);

/**
 * reports an error if a value is not inside a range e.g. [-5.1, +3.0]
 *
 * \param id the test case id
 * \param msg the result message
 * \param min the lower limit (inclusive)
 * \param max the upper limit (inclusive)
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectRangeFloat32(etInt16 id, const char* message, etFloat32 min, etFloat32 max, etFloat32 actual, const char* file, int line) ;

/**
 * reports an error if a value is not inside a range e.g. [-5.1, +3.0]
 *
 * \param id the test case id
 * \param msg the result message
 * \param min the lower limit (inclusive)
 * \param max the upper limit (inclusive)
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expectRangeFloat64(etInt16 id, const char* message, etFloat64 min, etFloat64 max, etFloat64 actual, const char* file, int line) ;

/**
 * reports an error if two pointers aren't equal
 *
 * \param id the test case id
 * \param msg the result message
 * \param expected the expected value
 * \param actual the actual value
 * \param file the file name with the test case
 * \param line the line
 */
void expect_equal_void_ptr(etInt16 id, const char* msg, const void* expected, const void* actual, const char* file, int line);
/**
 * start of a comparison of an expected order. Initially with this method
 * a list of integers is passed. Later calls of \ref expectOrder(etInt16, const char* msg, etInt16, const char* int)
 * are compared against the next value in the list and the list pointer is incremented
 *
 * \param id the test case id
 * \param list the list of expected values
 * \param size the size of the list
 * \param file the file name with the test case
 * \param line the line
 */
void expectOrderStart(etInt16 id, etInt16* list, etInt16 size, const char* file, int line);
/**
 * reports an error if the identifier doesn't match the next value in the list
 *
 * \param id the test case id
 * \param msg the result message
 * \param identifier the expected next value
 * \param file the file name with the test case
 * \param line the line
 */
void expectOrder(etInt16 id, const char* msg, etInt16 identifier, const char* file, int line);
/**
 * reports an error if the identifier doesn't match the next value in the list which
 * is expected to be the last one
 *
 * \param id the test case id
 * \param msg the result message
 * \param identifier the expected next value
 * \param file the file name with the test case
 * \param line the line
 */
void expectOrderEnd(etInt16 id, const char* msg, etInt16 identifier, const char* file, int line);

#endif /* _ETUNIT_H_ */


