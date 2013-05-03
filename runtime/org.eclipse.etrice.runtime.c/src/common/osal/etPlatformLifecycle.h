/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETPLATFORMLIFECYCLE_H_
#define _ETPLATFORMLIFECYCLE_H_

/**
 * etPlatformLifecycle.h defines a generic interface for platform specific startup and shutdown functions
 * those functions are called at specific points during the lifecycle of an eTrice application
 * they can be used to integrate and execute platform or OS specific code
 *
 * */

#include "etDatatypes.h"


/**
 * Platform specific code, called at the start of the system startup of the main function
 * */
void etUserEntry(void);

/**
 * Platform specific code, called at the end of the startup right before the start of the actual application
 * */
void etUserPreRun(void);

/**
 * Platform specific code, called at the beginning of the shutdown right after before the stop of the actual application
 * */
void etUserPostRun(void);

/**
 * Platform specific code, called at the end of the system shutdown of the main function
 * */
void etUserExit(void);

#endif /* _ETPLATFORMLIFECYCLE_H_ */
