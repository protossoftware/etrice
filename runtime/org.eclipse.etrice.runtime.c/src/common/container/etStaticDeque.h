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
	int objectSize;		/* the maximum size of the objects contained in this queue */
} etStaticDeque;

/**
 * Constructs the Deque on the given memory with specified size and objectSize.
 *
 * \param self the pointer to the StaticDeque
 * \param memory a pointer to the memory for the objects of the StaticDeque
 * \param size the maximum count of objects that fit into the specified memory
 * \param objectSize the size of the objects stored in the StaticDeque
 */
void etStaticDeque_construct(etStaticDeque* self, void* memory, int size, int objectSize);

/**
 * Clears the Deque, removes all objects.
 *
 * \param self the pointer to the StaticDeque
 */
void etStaticDeque_clear(etStaticDeque* self);

/**
 * Returns a reference to an arbitrary object at the specified position.
 *
 * \param self the pointer to the StaticDeque
 * \param position the position of the object to be returned
 * \return the object at the specified position
 */
void* etStaticDeque_get(const etStaticDeque* self, int position);

/**
 * Copies the object and stores it at the front
 *
 * \param self the pointer to the StaticDeque
 * \param object the object to push to the front of the queue
 */
void etStaticDeque_push_front(etStaticDeque* self, void* object);

/**
 * Copies the object and stores it at the end
 *
 * \param self the pointer to the StaticDeque
 * \param object the object to push to the end of the queue
 */
void etStaticDeque_push_back(etStaticDeque* self, void* object);

/**
 * Removes the first object
 *
 * \param self the pointer to the StaticDeque
 */
void etStaticDeque_pop_front(etStaticDeque* self);

/**
 * Removes the last element
 *
 * \param self the pointer to the StaticDeque
 */
void etStaticDeque_pop_back(etStaticDeque* self);

/**
 * Returns a reference to the first object
 *
 * \param self the pointer to the StaticDeque
 * \return the object at the front of the queue
 */
void* etStaticDeque_front(const etStaticDeque* self);

/**
 * Returns a reference to the last object
 *
 * \param self the pointer to the StaticDeque
 * \return the object at the end of the queue
 */
void* etStaticDeque_back(const etStaticDeque* self);

#endif /* SRC_COMMON_CONTAINERS_ETSTATICDEQUE_H_ */
