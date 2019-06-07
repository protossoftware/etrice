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

#include "etStaticDeque.h"

#include <string.h>

void etStaticDeque_construct(etStaticDeque* const self, void* memory, int memorySize, int objectSize) {
	self->size = 0;
	self->first = 0;
	self->memory = memory;
	self->maxSize = memorySize / objectSize;
	self->objectSize = objectSize;

	etStaticDeque_clear(self);
}

void etStaticDeque_clear(etStaticDeque* const self) {
	self->first = 0;
	self->size = 0;
}

void* etStaticDeque_get(const etStaticDeque* const self, int position) {
	/* TODO JB: Handle position out of bounds exception */
	return (void*) &self->memory[(self->first + position * self->objectSize) % (self->objectSize * self->maxSize)];
}

void etStaticDeque_push_front(etStaticDeque* const self, void* object) {
	/* TODO JB: Handle out of memory exception */
	if(self->size < self->maxSize) {
		++self->size;
		self->first = (self->first + (self->maxSize - 1) * self->objectSize) % (self->objectSize * self->maxSize);
		memcpy(etStaticDeque_front(self), object, self->objectSize);
	}
}

void etStaticDeque_push_back(etStaticDeque* const self, void* object) {
	/* TODO JB: Handle out of memory exception */
	if(self->size < self->maxSize) {
		++self->size;
		memcpy(etStaticDeque_back(self), object, self->objectSize);
	}
}

void etStaticDeque_pop_front(etStaticDeque* const self) {
	/* TODO JB: Handle deque empty exception */
	if(self->size > 0) {
		self->first = (self->first + self->objectSize) % (self->objectSize * self->maxSize);
		--self->size;
	}
}

void etStaticDeque_pop_back(etStaticDeque* const self) {
	/* TODO JB: Handle deque empty exception */
	if(self->size > 0) {
		--self->size;
	}
}

void* etStaticDeque_front(const etStaticDeque* const self) {
	return etStaticDeque_get(self, 0);
}

void* etStaticDeque_back(const etStaticDeque* const self) {
	return etStaticDeque_get(self, self->size - 1);
}
