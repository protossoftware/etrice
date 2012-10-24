/*
 * SubSystemRunnerBase.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "SubSystemRunnerBase.h"
#include "SubSystemClassBase.h"

namespace etRuntime {

SubSystemRunnerBase::SubSystemRunnerBase() {
}

SubSystemRunnerBase::~SubSystemRunnerBase() {
}


void SubSystemRunnerBase::waitMultiThreaded() {
	// waiting for command line input
	std::string token = "";
	std::cout << "type 'quit' to exit" << std::endl;
	while (token != "quit") {
		std::getline(std::cin, token);
		std::cout << "echo: " << token << std::endl;
	}
}

void SubSystemRunnerBase::waitAndPollSingleThreaded(SubSystemClassBase& mainComponent) {
	mainComponent.runOnce();

	std::string token = "";
	std::cout << "type 'quit' to exit" << std::endl;
	#ifndef WIN32
	   pollfd cinfd[1];
	   // Theoretically this should always be 0, but one fileno call isn't going to hurt, and if
	   // we try to run somewhere that stdin isn't fd 0 then it will still just work
	   cinfd[0].fd = fileno(stdin);
	   cinfd[0].events = POLLIN;
	#else
	   HANDLE h = GetStdHandle(STD_INPUT_HANDLE);
	#endif
	   while (token != "quit")
	   {
	#ifndef WIN32
		  if (poll(cinfd, 1, 1000))
	#else
		  // doesn't work as expected:
		  if (WaitForSingleObject(h, 100) == WAIT_OBJECT_0)
	#endif
		  {
				std::getline(std::cin, token);
				std::cout << "echo: " << token << std::endl;
		  }
		  mainComponent.runOnce();
	   }
}
} /* namespace etRuntime */
