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

#ifndef _etThreadController_H_
#define _etThreadController_H_

#include "osal/etThread.h"

/**
 * etThreadController holds a complete list of all threads
 *
 **/
typedef struct etThreadController{
	etThread* threadList;	/**< list of all thread data (as array) **/
	int32 size;				/**< size of the list **/
}etThreadController;

int32 etThreadController_getNumberOfThreads(etThreadController* self);
void etThreadController_startAll(etThreadController* self);
void etThreadController_stopAll(etThreadController* self);
void etThreadController_getCurrentThreadId(void);

#endif /* _etThreadController_H_ */
