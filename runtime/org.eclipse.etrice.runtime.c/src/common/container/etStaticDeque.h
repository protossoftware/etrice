/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
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

#ifndef SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_
#define SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_

#include <stdint.h>
#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * etStaticDeque (static double ended queue) is a data structure for storing objects of equal size in order.
 * The size of the deque is limited by the memory provided by the user.
 * Pushing/Popping elements to/from the front and the back as well as arbitrary access is supported in constant time.
 * The data structure relies on a circular buffer implemented as an array.
 */
typedef struct etStaticDeque {
	uint8_t* memory;	/* memory for the objects */
	int first;			/* index of the first object */
	int size;			/* current size of the queue */
	int maxSize;		/* the maximum size of the queue */
	int objectSize;		/* the size of the objects contained in this queue in bytes */
} etStaticDeque;

/**
 * Constructs the Deque on the given memory with specified size and objectSize.
 *
 * \param self The pointer to the StaticDeque
 * \param memory A pointer to the memory for the objects of the StaticDeque
 * \param memorySize The size of the memory in bytes
 * \param objectSize The size of the objects stored in the StaticDeque in bytes
 */
void etStaticDeque_construct(etStaticDeque* self, void* memory, int memorySize, int objectSize);

/**
 * Clears the Deque, removes all objects.
 *
 * \param self The pointer to the StaticDeque
 */
void etStaticDeque_clear(etStaticDeque* self);

/**
 * Returns a reference to an arbitrary object at the specified position.
 *
 * \param self The pointer to the StaticDeque
 * \param position The position of the object to be returned
 * \return The object at the specified position
 */
void* etStaticDeque_get(const etStaticDeque* self, int position);

/**
 * Copies the object and stores it at the front
 *
 * \param self The pointer to the StaticDeque
 * \param object The object to push to the front of the queue
 */
void etStaticDeque_push_front(etStaticDeque* self, void* object);

/**
 * Copies the object and stores it at the end
 *
 * \param self The pointer to the StaticDeque
 * \param object The object to push to the end of the queue
 */
void etStaticDeque_push_back(etStaticDeque* self, void* object);

/**
 * Removes the first object
 *
 * \param self The pointer to the StaticDeque
 */
void etStaticDeque_pop_front(etStaticDeque* self);

/**
 * Removes the last element
 *
 * \param self The pointer to the StaticDeque
 */
void etStaticDeque_pop_back(etStaticDeque* self);

/**
 * Returns a reference to the first object
 *
 * \param self The pointer to the StaticDeque
 * \return The object at the front of the queue
 */
void* etStaticDeque_front(const etStaticDeque* self);

/**
 * Returns a reference to the last object
 *
 * \param self The pointer to the StaticDeque
 * \return The object at the end of the queue
 */
void* etStaticDeque_back(const etStaticDeque* self);

ET_EXTERN_C_END

#endif /* SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_ */
