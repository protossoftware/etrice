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

void initHw(void) {

	etTimeInit();
}
