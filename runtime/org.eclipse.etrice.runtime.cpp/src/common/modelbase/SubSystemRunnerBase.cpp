/*
 * SubSystemRunnerBase.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "common/modelbase/SubSystemRunnerBase.h"
#include "common/modelbase/SubSystemClassBase.h"
#include "common/platform/etTimer.h"
#include <unistd.h>
#include <iostream>
#include <sstream>

namespace etRuntime {

const std::string SubSystemRunnerBase::OPTION_RUN_AS_TEST = "-run_as_test";
const std::string SubSystemRunnerBase::OPTION_RUN_AS_TEST_SINGLETHREADED = "-run_as_test_single_threaded";
const std::string SubSystemRunnerBase::OPTION_RUN_SINGLETHREADED = "-run_single_threaded";

TestSemaphore SubSystemRunnerBase::s_testSem;

SubSystemRunnerBase::SubSystemRunnerBase() {
}

SubSystemRunnerBase::~SubSystemRunnerBase() {
}

void SubSystemRunnerBase::run(SubSystemClassBase& mainComponent, int argc, char* argv[] ) {

	//etUserEntry(); /* platform specific */

	std::cout << "***   T H E   B E G I N   ***" << std::endl;

	bool test = false;
	bool singleThreaded = false;
	int cycles = 100;

	for (int i=1; i<argc; ++i) { // omit first argument, which is the program name
		if (SubSystemRunnerBase::OPTION_RUN_AS_TEST.compare(argv[i]) == 0) {
			std::cout << "*** running as test" << std::endl;
			test = true;
		}
		else if (SubSystemRunnerBase::OPTION_RUN_AS_TEST_SINGLETHREADED.compare(argv[i]) == 0) {

			singleThreaded = true;
			i++;
			if (i < argc) {
				std::stringstream sstr(argv[i]);
			    sstr >> cycles;
			}
			std::cout << "*** running as test singlethreaded " << cycles << " cycles" << std::endl;
		}
		else if (SubSystemRunnerBase::OPTION_RUN_SINGLETHREADED.compare(argv[i]) == 0) {

			singleThreaded = true;
			i++;
			if (i < argc) {
				std::stringstream sstr(argv[i]);
			    sstr >> cycles;
			}
			std::cout << "*** running singlethreaded " << cycles << " cycles" << std::endl;
		}
		else {
			std::cout << "*** running multithreaded" << std::endl;
		}
	}

	if (test)
		mainComponent.setTestSemaphore(s_testSem);

	mainComponent.init(); // lifecycle init
	mainComponent.start(singleThreaded); // lifecycle start

	// application runs until quit
	if (test) {
		waitForTestcase();
	}
	else if (singleThreaded){
		waitAndPollSingleThreaded(mainComponent, cycles);
	}
	else {
		waitForQuitMultiThreaded();
	}
	// end the lifecycle
	mainComponent.stop(singleThreaded); // lifecycle stop
	mainComponent.destroy(); // lifecycle destroy

	std::cout << "***   T H E   E N D   ***" << std::endl;

	//etUserExit(); /* platform specific */
}

void SubSystemRunnerBase::waitForTestcase() {
	//std::cout << "=== waitForTestcase: before acq. semaphore, thread " << Thread.currentThread().getName() << std::endl;
	s_testSem.take();
	//std::cout << "=== waitForTestcase: after acq. semaphore, thread " << Thread.currentThread().getName() << std::endl;
}

void SubSystemRunnerBase::waitForQuitMultiThreaded() {
	// waiting for command line input
	std::string token = "";
	std::cout << "type 'quit' to exit" << std::endl;
	while (token != "quit") {
		std::getline(std::cin, token);
		std::cout << "echo: " << token << std::endl;
	}
}

void SubSystemRunnerBase::waitAndPollSingleThreaded(SubSystemClassBase& mainComponent, int cycles) {
	for (int i=0; i< cycles; ++i) {
		if (etTimer_executeNeeded()) {
			mainComponent.runOnce();
		}
		usleep(100000);
	}
}
} /* namespace etRuntime */
