/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etPlatformLifecycle.h
 *
 * etPlatformLifecycle.h defines a generic interface for platform specific startup and shutdown functions
 * those functions are called at specific points during the lifecycle of an eTrice application
 * they can be used to integrate and execute platform or OS specific code
 *
 * \author Thomas Schuetz
 */

#ifndef _ETPLATFORMLIFECYCLE_H_
#define _ETPLATFORMLIFECYCLE_H_

#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * Platform specific code, called at the start of the system startup of the main function
 */
void etUserEntry(void);

/**
 * Platform specific code, called at the end of the startup right before the start of the actual application
 */
void etUserPreRun(void);

/**
 * Platform specific code, called at the beginning of the shutdown right after before the stop of the actual application
 */
void etUserPostRun(void);

/**
 * Platform specific code, called at the end of the system shutdown of the main function
 */
void etUserExit(void);

ET_EXTERN_C_END

#endif /* _ETPLATFORMLIFECYCLE_H_ */
