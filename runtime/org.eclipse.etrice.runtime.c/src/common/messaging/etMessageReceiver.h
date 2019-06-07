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
 * \file etMessageReceiver.h
 *
 * method prototypes used by the messaging
 *
 * \author Thomas Schuetz
 */

#ifndef _ETMESSAGERECEIVER_H_
#define _ETMESSAGERECEIVER_H_

#include "messaging/etMessage.h"

/**
 * method prototype that receives a message
 *
 * \param self the this pointer
 * \param ifitem a pointer to the interface item that received the message
 * \param msg the message
 */
typedef void (*etActorReceiveMessage)(void* self, const void* ifitem, const etMessage*  msg);

/**
 * method prototype for a dispatcher method
 *
 * \param msg the message
 *
 * \return <code>true</code> if the message could be delivered
 */
typedef etBool (*etDispatcherReceiveMessage)(const etMessage* msg);

/**
 * prototype for the periodic call to the <code>execute()</code> method of the dispatcher
 */
typedef void (*etDispatcherExecute)(void);

#endif /* _ETMESSAGERECEIVER_H_ */
