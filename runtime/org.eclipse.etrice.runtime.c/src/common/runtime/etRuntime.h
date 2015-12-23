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

#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETRUNTIME_H_
#define _ETRUNTIME_H_

/**
 * \file etRuntime.h
 *
 * runtime methods
 *
 * \author Thomas Schuetz
 */

#include "osal/etSema.h"

/**
 * a global semaphore used to terminate the application in headless mode
 *
 * \return the semaphore
 */
etSema* etRuntime_getTerminateSemaphore();

#endif /* _ETRUNTIME_H_ */

#ifdef __cplusplus
}
#endif
