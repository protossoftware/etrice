/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *
 *******************************************************************************/

/**
 * \file etMutex.h
 *
 * etMutex.h defines a generic interface for platform specific implementations of a mutex
 *
 * \author Henrik Rentz-Reichert
 */
#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETLOCK_H_
#define _ETLOCK_H_

typedef void etLock_lock(void* lockData);
typedef void etLock_unlock(void* lockData);

typedef struct etLock {
	etLock_lock* lockFct;
	etLock_unlock* unlockFct;
	void* lockData;
}
etLock;

#endif /* _ETLOCK_H_ */

#ifdef __cplusplus
}
#endif
