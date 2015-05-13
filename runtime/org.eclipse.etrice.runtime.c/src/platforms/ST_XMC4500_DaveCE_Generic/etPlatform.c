/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution), Thomas Jung
 *
 *******************************************************************************/

#include "etPlatform.h"
#include "etDatatypes.h"
#include "osal/etTime.h"

// Ticks are generated every 100ms
#define TICKS_PER_SECOND 1000UL


void initHw(void) {

	etTime_init();
}
