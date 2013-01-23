/*
 * TestSemaphore.h
 *
 *  Created on: 31.08.2012
 *      Author: karlitsc
 */

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
