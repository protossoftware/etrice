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
#ifdef WIN32
#include <windows.h>
#endif

namespace etRuntime {

class SubSystemClassBase;

class SubSystemRunnerBase {
public:
	SubSystemRunnerBase();
	~SubSystemRunnerBase();

	/**
	 * blocks until the String "quit" is entered on the console
	 */
protected:
	static void waitForQuit(SubSystemClassBase& mainComponent) {
		waitAndPollSingleThreaded(mainComponent);
	}

private:
	static void waitMultiThreaded();
	static void waitAndPollSingleThreaded(SubSystemClassBase& mainComponent);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMRUNNERBASE_H_ */
