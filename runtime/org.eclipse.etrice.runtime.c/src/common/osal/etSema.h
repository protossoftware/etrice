/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETSEMA_H_
#define _ETSEMA_H_

/**
 * etSema.h defines a generic interface for platform specific implementations of a semaphore
 *
 * */

#include "etDatatypes.h"

/**
 * etSema holds the object data for a semaphore (for self pointer)
 *
 * */
typedef struct etSema {
	etOSSemaData osData;
} etSema;

void etSema_construct(etSema* self);
void etSema_destruct(etSema* self);
void etSema_wakeup(etSema* self);
void etSema_waitForWakeup(etSema* self);


#endif /* _ETSEMA_H_ */
