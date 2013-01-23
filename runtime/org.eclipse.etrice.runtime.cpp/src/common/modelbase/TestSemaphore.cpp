/*
 * TestSemaphore.cpp
 *
 *  Created on: 31.08.2012
 *      Author: karlitsc
 */

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
