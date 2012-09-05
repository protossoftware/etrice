/*
 * TestSemaphore.h
 *
 *  Created on: 31.08.2012
 *      Author: karlitsc
 */

#ifndef TESTSEMAPHORE_H_
#define TESTSEMAPHORE_H_

#include <iostream>

namespace etRuntime {

class TestSemaphore { //extends Semaphore
public:
	virtual ~TestSemaphore();

	TestSemaphore(int permits) {
	}
	void release(int count) {};

	void printWaitingThreads() {
		std::cout << ">>> begin semaphore info >>>" << std::endl;
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
private:
	TestSemaphore();
	TestSemaphore(const TestSemaphore& right);
	TestSemaphore& operator=(const TestSemaphore& right);

};

} /* namespace etRuntime */
#endif /* TESTSEMAPHORE_H_ */
