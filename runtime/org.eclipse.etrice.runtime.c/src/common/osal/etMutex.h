/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *
 *******************************************************************************/

/**
 * \file etMutex.h
 *
 * etMutex.h defines a generic interface for platform specific implementations of a mutex
 *
 * \author Thomas Schuetz, Thomas Jung
 */

#ifndef _ETMUTEX_H_
#define _ETMUTEX_H_

#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * etMutex holds the object data for a mutex (for self pointer)
 */
typedef struct etMutex {
	etOSMutexData osData;
} etMutex;

/**
 * initializes the mutex
 * \param self the 'this' pointer of the mutex
 */
void etMutex_construct(etMutex* self);

/**
 * destroys the mutex
 * \param self the 'this' pointer of the mutex
 */
void etMutex_destruct(etMutex* self);

/**
 * lock the mutex
 * \param self the 'this' pointer of the mutex
 */
void etMutex_enter(etMutex* self);

/**
 * unlock the mutex
 * \param self the 'this' pointer of the mutex
 */
void etMutex_leave(etMutex* self);

ET_EXTERN_C_END

#endif /* _ETMUTEX_H_ */
