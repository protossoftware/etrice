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

#include "etUnit/etUnit.h"
#include <string.h>
#include <time.h>
#include "debugging/etLogger.h"


/*** member variables */

/* file handling */
static FILE* etUnit_reportfile = NULL;

/* counters */
static etInt16 etUnit_nextCaseId = 1;

#define ETUNIT_MAX_TEST_CASES		64
static etBool etUnit_testcaseSuccess[ETUNIT_MAX_TEST_CASES];

#define ETUNIT_FAILURE_TEXT_LEN 256

/* time measuring */
static clock_t etUnit_startTime = 0;
static clock_t etUnit_currentTime = 0;

/* order */
#define ETUNIT_ORDER_MAX	16
typedef struct OrderInfo {
	etInt16 id;
	etInt16 currentIndex;
	etInt16 size;
	etInt16* list;
}
OrderInfo;
static OrderInfo etUnit_orderInfo[ETUNIT_ORDER_MAX];

/* forward declarations of private functions */
static void expect_equal_int(etInt16 id, const char* message, etInt32 expected, etInt32 actual, const char* file, int line);
static void expect_equal_uint(etInt16 id, const char* message, etUInt32 expected, etUInt32 actual, const char* file, int line);
static void expect_equal_float(etInt16 id, const char* message, etFloat32 expected, etFloat32 actual, etFloat32 precision, const char* file, int line);
static void etUnit_handleExpect(etInt16 id, etBool result, const char *trace, const char* expected, const char* actual, const char* file, int line);

/* public functions */

void etUnit_open(const char* testResultPath, const char* testFileName) {
	etLogger_logInfoF("************* TEST START (%s) **************", testFileName);

	{
		char filename[ETUNIT_FAILURE_TEXT_LEN];
		int i;

		if (testResultPath!=NULL)
			sprintf(filename, "%s/%s.etu", testResultPath, testFileName);
		else
			sprintf(filename, "%s.etu", testFileName);

		/* init global data */
		for (i=0; i<ETUNIT_ORDER_MAX; ++i)
			etUnit_orderInfo[i].id = 0;
		for (i=0; i<ETUNIT_MAX_TEST_CASES; ++i)
			etUnit_testcaseSuccess[i] = TRUE;

		if (etUnit_reportfile == NULL) {
			etUnit_reportfile = etLogger_fopen(filename, "w+");
			if (etUnit_reportfile != NULL) {
				etLogger_fprintf(etUnit_reportfile, "etUnit report\n");
			} else {
				etLogger_logErrorF("Unable to open file %s", filename);
			}
		}
	}

	/* prepare time measurement */
	etUnit_startTime = clock();
	etUnit_currentTime = clock();
	etLogger_logInfoF("Start Time: %ld", etUnit_startTime);

}

void etUnit_close(void) {
	if (etUnit_reportfile != NULL) {
		etLogger_fclose(etUnit_reportfile);
		etUnit_reportfile = NULL;
	}
	etLogger_logInfoF("End Time: %ld", clock());
	etLogger_logInfoF("************* TEST END **************");
}

void etUnit_openTestSuite(const char* testSuiteName) {
	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "ts start: %s\n", testSuiteName);
	}
}

void etUnit_closeTestSuite(void) {
}

etInt16 etUnit_openTestCase(const char* testCaseName) {
	etInt16 caseId = etUnit_nextCaseId++;

	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "tc start %d: %s\n", caseId, testCaseName);
	}

	return caseId;
}

void etUnit_closeTestCase(etInt16 id) {
	clock_t time = clock() - etUnit_currentTime;
	etUnit_currentTime = clock();

	if (etUnit_reportfile != NULL) {
		etLogger_fprintf(etUnit_reportfile, "tc end %d: %d\n", id, time);
	}
}

etInt16 etUnit_openAll(const char* testResultPath, const char* testFileName, const char* testSuiteName, const char* testCaseName){
	etUnit_open(testResultPath, testFileName);
	etUnit_openTestSuite(testSuiteName);
	return etUnit_openTestCase(testCaseName);
}

void etUnit_closeAll(etInt16 id){
	etUnit_closeTestCase(id);
	etUnit_closeTestSuite();
	etUnit_close();
}

void expectTrue(etInt16 id, const char* message, etBool condition, const char* file, int line) {
	if (condition == FALSE) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: *** EXPECT_TRUE == FALSE", message);
		etUnit_handleExpect(id, FALSE, testresult, "TRUE", "FALSE", file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}

void expectFalse(etInt16 id, const char* message, etBool condition, const char* file, int line) {
	if (condition == TRUE) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "%s: EXPECT_FALSE == TRUE", message);
		etUnit_handleExpect(id, FALSE, testresult, "FALSE", "TRUE", file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}

void expectEqualInt8(etInt16 id, const char* message, etInt8 expected, etInt8 actual, const char* file, int line) {
	expect_equal_int(id, message, (etInt32) expected, (etInt32) actual, file, line);
}

void expectEqualInt16(etInt16 id, const char* message, etInt16 expected, etInt16 actual, const char* file, int line) {
	expect_equal_int(id, message, (etInt32) expected, (etInt32) actual, file, line);
}

void expectEqualInt32(etInt16 id, const char* message, etInt32 expected, etInt32 actual, const char* file, int line) {
	expect_equal_int(id, message, (etInt32) expected, (etInt32) actual, file, line);
}

void expectEqualUInt8(etInt16 id, const char* message, etUInt8 expected, etUInt8 actual, const char* file, int line) {
	expect_equal_uint(id, message, (etUInt32) expected, (etUInt32) actual, file, line);
}

void expectEqualUInt16(etInt16 id, const char* message, etUInt16 expected, etUInt16 actual, const char* file, int line) {
	expect_equal_uint(id, message, (etUInt32) expected, (etUInt32) actual, file, line);
}

void expectEqualUInt32(etInt16 id, const char* message, etUInt32 expected, etUInt32 actual, const char* file, int line) {
	expect_equal_uint(id, message, (etUInt32) expected, (etUInt32) actual, file, line);
}

void expect_equal_void_ptr(etInt16 id, const char* message, const void* expected, const void* actual, const char* file, int line) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		char exp[16], act[16];
		sprintf(testresult, "%s: expected=%ld, actual=%ld", message, (etUInt32) expected, (etUInt32) actual);
		sprintf(exp, "%ld", (etUInt32) expected);
		sprintf(act, "%ld", (etUInt32) actual);
		etUnit_handleExpect(id, FALSE, testresult, exp, act, file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}

void expectEqualFloat32(etInt16 id, const char* message, etFloat32 expected, etFloat32 actual, etFloat32 precision, const char* file, int line) {
	expect_equal_float(id, message, expected, actual, precision, file, line);
}

static OrderInfo* getOrderInfo(etInt16 id) {
	int i;
	for (i=0; i<ETUNIT_ORDER_MAX; ++i)
		if (etUnit_orderInfo[i].id==id)
			return etUnit_orderInfo+i;

	return NULL;
}

void expectOrderStart(etInt16 id, etInt16* list, etInt16 size, const char* file, int line) {
	int i;
	for (i=0; i<ETUNIT_ORDER_MAX; ++i)
		if (etUnit_orderInfo[i].id==0) {
			etUnit_orderInfo[i].id = id;
			etUnit_orderInfo[i].currentIndex = 0;
			etUnit_orderInfo[i].size = size;
			etUnit_orderInfo[i].list = list;
		}
}

void expectOrder(etInt16 id, const char* message, etInt16 identifier, const char* file, int line){
	OrderInfo* info = getOrderInfo(id);
	if (info!=NULL) {
		if (info->currentIndex < info->size) {
			if (info->list[info->currentIndex] != identifier){
				char testresult[ETUNIT_FAILURE_TEXT_LEN];
				char exp[16], act[16];
				sprintf(testresult, "EXPECT_ORDER %s: index=%d, expected=%d, actual=%d", message, info->currentIndex, identifier, info->list[info->currentIndex]);
				sprintf(exp, "%d", identifier);
				sprintf(act, "%d", info->list[info->currentIndex]);
				etUnit_handleExpect(id, FALSE, testresult, exp, act, file, line);
			}
			else {
				etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
				info->currentIndex++;
			}
		}
		else {
			char testresult[ETUNIT_FAILURE_TEXT_LEN];
			sprintf(testresult, "EXPECT_ORDER: index(%d) is too big in %s", info->currentIndex, message);
			etUnit_handleExpect(id, FALSE, testresult, NULL, NULL, file, line);
			etLogger_logInfoF("EXPECT_ORDER: index too big in %s", message);
		}
	}
}

void expectOrderEnd(etInt16 id, const char* message, etInt16 identifier, const char* file, int line) {
	OrderInfo* info = getOrderInfo(id);
	expectOrder(id, message, identifier, file, line);
	if (info->currentIndex != info->size){
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		sprintf(testresult, "EXPECT_ORDER_END %s: wrong index at the end: expected=%d, actual=%d", message, info->size, info->currentIndex);
		etUnit_handleExpect(id, FALSE, testresult, NULL, NULL, file, line);
	}
}

/* private functions */

static void expect_equal_int(etInt16 id, const char* message, etInt32 expected, etInt32 actual, const char* file, int line) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		char exp[16], act[16];
		sprintf(testresult, "%s: expected=%ld, actual=%ld", message, expected, actual);
		sprintf(exp, "%ld", expected);
		sprintf(act, "%ld", actual);
		etUnit_handleExpect(id, FALSE, testresult, exp, act, file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}

static void expect_equal_uint(etInt16 id, const char* message, etUInt32 expected, etUInt32 actual, const char* file, int line) {
	if (expected != actual) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		char exp[16], act[16];
		sprintf(testresult, "%s: expected=%lu, actual=%lu", message, expected, actual);
		sprintf(exp, "%lu", expected);
		sprintf(act, "%lu", actual);
		etUnit_handleExpect(id, FALSE, testresult, exp, act, file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}


static void expect_equal_float(etInt16 id, const char* message, etFloat32 expected, etFloat32 actual, etFloat32 precision, const char* file, int line) {
	if (expected - actual < -precision || expected - actual > precision) {
		char testresult[ETUNIT_FAILURE_TEXT_LEN];
		char exp[16], act[16];
		sprintf(testresult, "%s: expected=%f, actual=%f", message, expected, actual);
		sprintf(exp, "%f", expected);
		sprintf(act, "%f", actual);
		etUnit_handleExpect(id, FALSE, testresult, exp, act, file, line);
	} else {
		etUnit_handleExpect(id, TRUE, "", NULL, NULL, file, line);
	}
}

static void etUnit_handleExpect(etInt16 id, etBool result, const char *resulttext, const char* exp, const char* act, const char* file, int line) {
	if (result == TRUE) {
		/* nothing to do because no failure */
	}
	else {
		if (etUnit_testcaseSuccess[id] == TRUE){
			/* first failure will be remembered */
			etUnit_testcaseSuccess[id] = FALSE;

			if (act!=NULL && exp!=NULL)
				etLogger_fprintf(etUnit_reportfile, "tc fail %d: #%s#%s#%s:%d#%s\n", id, exp, act, file, line, resulttext);
			else
				etLogger_fprintf(etUnit_reportfile, "tc fail %d: ###%s:%d#%s\n", id, file, line, resulttext);
		}
		else{
			/* more than one error will be ignored */
		}
	}
}
