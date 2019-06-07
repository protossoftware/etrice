/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_CONTAINERS_StaticDeque_H_
#define SRC_COMMON_CONTAINERS_StaticDeque_H_

#include <stdint.h>

/**
 * Implementation of a double ended queue with a circular buffer
 * The type T must implement the copy constructor
 */
template<class T, int maxSize>
class StaticDeque {
public:

	StaticDeque(void) : m_first(0), m_size(0) {}

	StaticDeque(const StaticDeque<T, maxSize>& copy) : m_first(0), m_size(0) {
		operator=(copy);
	}

	~StaticDeque(void) {
		reset();
	}

	StaticDeque<T, maxSize>& operator=(const StaticDeque<T, maxSize>& copy) {
		reset();
		for(int i = 0; i < copy.m_size; ++i) {
			push_back(copy[i]);
		}
		return *this;
	}

	// Returns the number of objects
	int size(void) const { return m_size; }

	bool empty(void) const { return !m_size; }

	// Returns a reference to an arbitrary object at the specified position
	T& operator[] (int position) const {
		// TODO JB: Handle position out of bounds exception
		return (T&) m_memory[(m_first + position * sizeof(T)) % (sizeof(T) * maxSize)];
	}

	// Copies the object and stores it at the front
	void push_front(const T& object) {
		// TODO JB: Handle out of memory exception
		if(m_size < maxSize) {
			++m_size;
			m_first = (m_first + (maxSize - 1) * sizeof(T)) % (sizeof(T) * maxSize);
			new (&operator[](0)) T(object);
		}
	}

	// Copies the object and stores it at the end
	void push_back(const T& object) {
		// TODO JB: Handle out of memory exception
		if(m_size < maxSize) {
			++m_size;
			new (&operator[](m_size - 1)) T(object);
		}
	}

	// Removes the first object
	void pop_front(void) {
		// TODO JB: Handle deque empty exception
		if(m_size > 0) {
			operator[](0).~T();
			m_first = (m_first + sizeof(T)) % (sizeof(T) * maxSize);
			--m_size;
		}
	}

	// Removes the last element
	void pop_back(void) {
		// TODO JB: Handle deque empty exception
		if(m_size > 0) {
			operator[](m_size - 1).~T();
			--m_size;
		}
	}

	// Returns a reference to the first object
	T& front(void) const {
		return operator[](0);
	}

	// Returns a reference to the last object
	T& back(void) const {
		return operator[](m_size - 1);
	}

private:
	uint8_t m_memory[sizeof(T) * maxSize];	// array for the objects
	int m_first;	// index of the first object
	int m_size;		// current size of the queue

	void reset(void) {
		while(m_size > 0) {
			pop_back();
		}
	}
};

#endif /* SRC_COMMON_CONTAINERS_StaticDeque_H_ */
