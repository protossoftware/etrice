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

/**
 * \file etMessage.h
 *
 * the message "base class" that is used for asynchronous messages
 *
 * \author Thomas Schuetz
 */

#ifndef _ETMESSAGE_H_
#define _ETMESSAGE_H_

#include "etDatatypes.h"

/**
 * the message structure
 */
typedef struct etMessage {
	struct etMessage* next;			/**< pointer to the next message or <code>NULL</code> (single linked list) */
	etInt16 address;				/**< the destination address */
	etInt16 evtID;					/**< the event id */
} etMessage;

/**
 * initializes the message fields ("constructor")
 *
 * \param self the this pointer
 */
void etMessage_init(etMessage* self);

#endif /* _ETMESSAGE_H_ */
