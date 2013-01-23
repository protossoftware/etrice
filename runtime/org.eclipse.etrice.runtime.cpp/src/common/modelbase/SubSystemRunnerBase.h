/*
 * SubSystemRunnerBase.h
 *
 * The base class for running components.
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef SUBSYSTEMRUNNERBASE_H_
#define SUBSYSTEMRUNNERBASE_H_

#include <iostream>
#include <string>
#ifdef WIN32
#include <windows.h>
#include "common/modelbase/TestSemaphore.h"
#endif

namespace etRuntime {

class SubSystemClassBase;

class SubSystemRunnerBase {
public:
	SubSystemRunnerBase();
	~SubSystemRunnerBase();
	static void run(SubSystemClassBase& mainComponent, int argc, char* argv[] );

protected:
	/**
	 * blocks until the String "quit" is entered on the console
	 */
	static void waitForTestcase();
	static TestSemaphore s_testSem;

private:
	static const std::string OPTION_RUN_AS_TEST;
	static const std::string OPTION_RUN_AS_TEST_SINGLETHREADED;
	static const std::string OPTION_RUN_SINGLETHREADED;
	static void waitForQuitMultiThreaded();
	static void waitAndPollSingleThreaded(SubSystemClassBase& mainComponent, int cycles);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMRUNNERBASE_H_ */
