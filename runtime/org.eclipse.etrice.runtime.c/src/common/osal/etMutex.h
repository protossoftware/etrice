/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *
 *******************************************************************************/

#ifndef _ETMUTEX_H_
#define _ETMUTEX_H_

/**
 * etMutex.h defines a generic interface for platform specific implementations of a mutex
 *
 * */

#include "etDatatypes.h"

/**
 * etMutex holds the object data for a mutex (for self pointer)
 *
 * */
typedef struct etMutex {
	etOSMutexData osData;
} etMutex;

void etMutex_construct(etMutex* self);
void etMutex_destruct(etMutex* self);
void etMutex_enter(etMutex* self);
void etMutex_leave(etMutex* self);


#endif /* _ETMUTEX_H_ */
