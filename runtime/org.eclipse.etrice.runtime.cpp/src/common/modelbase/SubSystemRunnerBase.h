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

#ifndef SUBSYSTEMRUNNERBASE_H_
#define SUBSYSTEMRUNNERBASE_H_

#include "common/containers/String.h"

namespace etRuntime {

class SubSystemClassBase;

class SubSystemRunnerBase {
public:
	SubSystemRunnerBase();
	virtual ~SubSystemRunnerBase() {}
	static void run(SubSystemClassBase& mainComponent, int argc, char* argv[]);
	static void waitForTerminate();

protected:
	/**
	 * blocks until the String "quit" is entered on the console
	 */
	static void waitForQuit();

private:
	static const String OPTION_RUN_AS_TEST;
	static const String OPTION_RUN_HEADLESS;

	SubSystemRunnerBase(SubSystemRunnerBase const&);
	SubSystemRunnerBase& operator=(SubSystemRunnerBase const&);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMRUNNERBASE_H_ */
