/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_
#define SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_

#include <stdint.h>

/**
 * Implementation of a double ended queue with a circular buffer
 */
typedef struct etStaticDeque {
	uint8_t* memory;	/* memory for the objects */
	int first;			/* index of the first object */
	int size;			/* current size of the queue */
	int maxSize;		/* the maximum size of the queue */
	int objectSize;		/* the maximum size of the objects contained in this queue */
} etStaticDeque;

/**
 * Constructs the Deque on the given memory with specified size and objectSize
 */
void etStaticDeque_construct(etStaticDeque* self, void* memory, int size, int objectSize);

/**
 * Clears the Deque, removes all objects
 */
void etStaticDeque_clear(etStaticDeque* const self);

/**
 * Returns a reference to an arbitrary object at the specified position
 */
void* etStaticDeque_get(const etStaticDeque* self, int position);

/**
 * Copies the object and stores it at the front
 */
void etStaticDeque_push_front(etStaticDeque* self, void* object);

/**
 * Copies the object and stores it at the end
 */
void etStaticDeque_push_back(etStaticDeque* self, void* object);

/**
 * Removes the first object
 */
void etStaticDeque_pop_front(etStaticDeque* self);

/**
 * Removes the last element
 */
void etStaticDeque_pop_back(etStaticDeque* self);

/**
 * Returns a reference to the first object
 */
void* etStaticDeque_front(const etStaticDeque* self);

/**
 * Returns a reference to the last object
 */
void* etStaticDeque_back(const etStaticDeque* self);

#endif /* SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_ */
