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

#include "TestSemaphore.h"

namespace etRuntime {


TestSemaphore::~TestSemaphore() {
	sem_destroy(&m_sem);
}

void TestSemaphore::printWaitingThreads() {
	std::cout << ">>> begin semaphore info >>>" << std::endl;
	int value;
	sem_getvalue(&m_sem, &value);
	std::cout << "value of the semaphore:" << value << std::endl;
//		std::cout << "current thread is " + Thread.currentThread().getName() << std::endl;
//		Collection < Thread > threads = getQueuedThreads();
//		if (threads.isEmpty())
//			std::cout << " no waiting threads" << std::endl;
//		else
//			for (Thread thread : threads) {
//				std::cout << " blocked: " << thread.getName() << std::endl;
//			}
	std::cout << "<<< end semaphore info <<<" << std::endl;
}

} /* namespace etRuntime */
