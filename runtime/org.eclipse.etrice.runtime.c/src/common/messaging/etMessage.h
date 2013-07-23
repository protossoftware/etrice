/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETMESSAGE_H_
#define _ETMESSAGE_H_

#include "etDatatypes.h"

typedef struct etMessage{
	struct etMessage* next;
	etInt16 address;
	etInt16 evtID;
} etMessage;

void etMessage_init(etMessage* self);

#endif /* _ETMESSAGE_H_ */
