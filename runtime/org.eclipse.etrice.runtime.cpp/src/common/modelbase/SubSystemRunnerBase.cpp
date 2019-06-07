/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "SubSystemRunnerBase.h"

#include "common/modelbase/SubSystemClassBase.h"
#include "runtime/etRuntime.h"
#include "etUnit/etUnit.h"
#include <cstring>

namespace etRuntime {

const String SubSystemRunnerBase::OPTION_RUN_AS_TEST = "-run_as_test";
const String SubSystemRunnerBase::OPTION_RUN_HEADLESS = "-headless";

void SubSystemRunnerBase::run(SubSystemClassBase& main_component, int argc, char* argv[]) {

	printf("***   T H E   B E G I N   ***\n");

	etBool headless = false;
	for (int i = 1; i < argc; ++i) { // omit first argument, which is the program name
		if (OPTION_RUN_AS_TEST.compare(argv[i]) == 0) {
			printf("*** running as test\n");
			headless = true;
		} else if (OPTION_RUN_HEADLESS.compare(argv[i]) == 0) {
			printf("*** running headless\n");
			headless = true;
		}
	}

	main_component.init(); // lifecycle init
	main_component.start(); // lifecycle start

	// application runs until quit
	if (headless)
		waitForTerminate();
	else
		waitForQuit();

	// end the lifecycle
	main_component.stop(); // lifecycle stop
	main_component.destroy(); // lifecycle destroy

	printf("***   T H E   E N D   ***\n");

}

void SubSystemRunnerBase::waitForQuit() {
	// waiting for command line input
//	std::cout << "waitForQuit 30sec" << std::endl;
//	Sleep(30000);
//	std::cout << "return from waitForQuit" << std::endl;

	printf("type quit to exit\n");
	fflush(stdout);
	while (ET_TRUE) {
		char line[64];

		if (fgets(line, 64, stdin) != NULL) {
			if (strncmp(line, "quit", 4)==0)
				break;
		}
	}

	// not thread safe ??
//	std::string token;
//	std::cout << "type 'quit' to exit" << std::endl;
//	while (token != "quit") {
//		std::getline(std::cin, token);
//		//std::cout << "echo: " << token << std::endl;
//	}
}

void SubSystemRunnerBase::waitForTerminate() {
	printf("=== waitForTestcase: before acq. semaphore\n");
	etSema_waitForWakeup(etRuntime_getTerminateSemaphore());
	printf("=== waitForTestcase: after acq. semaphore\n");
}

} /* namespace etRuntime */
