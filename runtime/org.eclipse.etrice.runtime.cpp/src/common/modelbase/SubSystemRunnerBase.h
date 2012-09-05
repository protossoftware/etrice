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

namespace etRuntime {

class SubSystemRunnerBase {
public:
	SubSystemRunnerBase();
	~SubSystemRunnerBase();

	/**
	 * blocks until the String "quit" is entered on the console
	 */
protected:
	static void waitForQuit() {
		// waiting for command line input
		std::string token = "";
		std::cout << "type 'quit' to exit" << std::endl;
		while (token != "quit") {
			std::getline(std::cin, token);
			std::cout << "echo: " << token << std::endl;
		}
	}

};

} /* namespace etRuntime */
#endif /* SUBSYSTEMRUNNERBASE_H_ */
