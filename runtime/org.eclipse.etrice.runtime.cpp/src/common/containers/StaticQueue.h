/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_CONTAINERS_STATICQUEUE_H_
#define SRC_COMMON_CONTAINERS_STATICQUEUE_H_

#include "common/containers/StaticDeque.h"

/**
 * Queue implementation with a circular buffer
 * The type T must implement the copy constructor
 */
template<class T, int maxSize>
class StaticQueue : private StaticDeque<T, maxSize> {
public:
	StaticQueue(void) : StaticDeque<T, maxSize>() {}

	int size(void) const { return StaticDeque<T, maxSize>::size(); }
	bool empty(void) const { return StaticDeque<T, maxSize>::empty(); }
	T& front(void) const { return StaticDeque<T, maxSize>::front(); }
	void pop(void) { StaticDeque<T, maxSize>::pop_front(); }
	void push(const T& object) { StaticDeque<T, maxSize>::push_back(object); }
};

#endif /* SRC_COMMON_CONTAINERS_STATICQUEUE_H_ */
