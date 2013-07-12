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

#ifndef TESTSEMAPHORE_H_
#define TESTSEMAPHORE_H_

#include <iostream>
#include <semaphore.h>

namespace etRuntime {

class TestSemaphore { //extends Semaphore
public:
	TestSemaphore(int permits = 1)
		: m_sem()
	{
		sem_init(&m_sem, 0, permits);
	}

	virtual ~TestSemaphore();

	void give() { sem_post(&m_sem); };
	void take() { sem_wait(&m_sem); };

	void printWaitingThreads();

private:
	sem_t m_sem;

	TestSemaphore(const TestSemaphore& right);
	TestSemaphore& operator=(const TestSemaphore& right);

};

} /* namespace etRuntime */
#endif /* TESTSEMAPHORE_H_ */
