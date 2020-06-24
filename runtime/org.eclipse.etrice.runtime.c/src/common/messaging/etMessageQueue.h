/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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
 * \file etMessageQueue.h
 *
 * this component implements a message queue (fifo)
 *
 * \author Thomas Schuetz
 */

#ifndef _ETMESSAGEQUEUE_H_
#define _ETMESSAGEQUEUE_H_

#include "messaging/etMessage.h"
#include <stddef.h>

ET_EXTERN_C_BEGIN

/**
 * the message queue data structure
 */
typedef struct etMessageQueue {
	etMessage* first;				/**< the head of the list */
	etMessage* last;				/**< the tail of the list */
	etInt16 size;					/**< the size of the list */
}
etMessageQueue;

/**
 * initializes the queue data fields ("constructor")
 *
 * \param self the this pointer
 */
void etMessageQueue_init(etMessageQueue* self);

/**
 * appends a new message to the queue
 *
 * \param self the this pointer
 */
void etMessageQueue_push(etMessageQueue* self, etMessage* msg);
/**
 * removes the first message from the queue
 *
 * \param self the this pointer
 * \return the removed message
 */
etMessage* etMessageQueue_pop(etMessageQueue* self);

/**
 * returns the first message without removing it
 *
 * \param self the this pointer
 * \return the first message without removing it
 */
etMessage* etMessageQueue_getFirst(etMessageQueue* self);
/**
 * returns the last message without removing it
 *
 * \param self the this pointer
 * \return the last message without removing it
 */
etMessage* etMessageQueue_getLast(etMessageQueue* self);

/**
 * returns <code>true</code> if the message queue is not empty
 *
 * \param self the this pointer
 * \return <code>true</code> if the message queue is not empty
 */
etBool etMessageQueue_isNotEmpty(etMessageQueue* self);

/**
 * returns the size of the message queue
 *
 * \param self the this pointer
 * \return the size of the message queue
 */
etInt16 etMessageQueue_getSize(etMessageQueue* self);

ET_EXTERN_C_END

#endif /* _RMESSAGEQUEUE_H_ */
