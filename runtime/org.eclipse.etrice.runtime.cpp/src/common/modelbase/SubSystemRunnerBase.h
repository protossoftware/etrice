/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef SUBSYSTEMRUNNERBASE_H_
#define SUBSYSTEMRUNNERBASE_H_

#include <iostream>
#include <string>
#include "common/modelbase/TestSemaphore.h"

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
