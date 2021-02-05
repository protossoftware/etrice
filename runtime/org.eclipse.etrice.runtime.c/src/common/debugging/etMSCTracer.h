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
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etMSCTracer.h
 *
 * Binary variant of textual async MSC Logger.
 * These methods are called if 'ET_MSC_TRACER_ACTIVATE' is defined.
 * The implementation is not provided due platform and real-time specifics.
 * It is intended to be used together with the generated etrice instance model (genmodel).
 *
 */

#ifndef SRC_COMMON_DEBUGGING_ETMSCTRACER_H_
#define SRC_COMMON_DEBUGGING_ETMSCTRACER_H_

#include "etDatatypes.h"
#include "etRuntimeConfig.h"

#ifdef ET_MSC_TRACER_ACTIVATE
	// plain text
	#define ET_MSC_TRACER_ACTOR_NOTE(text)				etMSCTracer_setNote(self->constData->objId, text);
	#define ET_MSC_TRACER_GLOBAL_EVENT(text)			etMSCTracer_globalEvent(text);
	#define ET_MSC_TRACER_HIDDEN_TEXT(text)				etMSCTracer_hiddenText(text);
	// id based for generator							// translate to genmodel ids
	#define ET_MSC_TRACER_ASYNC_OUT(peerAddr, msgId) 	etMSCTracer_asyncOut(peerAddr - BASE_ADDRESS, msgId - 1);
	#define ET_MSC_TRACER_ASYNC_BCAST(peerAddr, msgId) 	etMSCTracer_asyncBroadcast(peerAddr - BASE_ADDRESS, msgId - 1);
	#define ET_MSC_TRACER_ASYNC_IN(peerAddr, msgId) 	etMSCTracer_asyncIn(peerAddr - BASE_ADDRESS, msgId - 1);
	#define ET_MSC_TRACER_SET_STATE(objId, stateId) 	etMSCTracer_setState(objId, stateId - 2);
	#define ET_MSC_TRACER_SET_NOTE(objId, text) 		etMSCTracer_setNote(objId, text);
#else
	#define ET_MSC_TRACER_SET_NOTE(objId, text)
	#define ET_MSC_TRACER_GLOBAL_EVENT(text)
	#define ET_MSC_TRACER_HIDDEN_TEXT(text)
	#define ET_MSC_TRACER_ASYNC_OUT(peerAddr, msgId)
	#define ET_MSC_TRACER_ASYNC_BCAST(peerAddr, msgId)
	#define ET_MSC_TRACER_ASYNC_IN(peerAddr, msgId)
	#define ET_MSC_TRACER_SET_STATE(objId, stateId)
#endif

//
// - logging methods
//

/**
 * logs an outgoing asynchronous message
 *
 * \param peerObjId the receiver genmodel objId
 * \param msgId the message genmodel objId
 */
void etMSCTracer_asyncOut(uint16 peerObjId, uint8 msgId);

/**
 * logs an outgoing asynchronous broadcast
 *
 * \param peerObjId the receiver genmodel objId
 * \param msgId the message genmodel objId
 */
void etMSCTracer_asyncBroadcast(uint16 peerObjId, uint8 msgId);

/**
 * logs an incoming asynchronous message
 *
 * \param peerObjId the sender genmodel objId
 * \param msgId the message genmodel objId
 */
void etMSCTracer_asyncIn(uint16 peerObjId, uint8 msgId);

/**
 * logs a state change for the actor instance
 *
 * \param objId the actor genmodel objId
 * \param stateName the new state
 */
void etMSCTracer_setState(uint16 objId, uint8 stateId);

/**
 * logs a note for the actor instance
 *
 * \param objId the actor genmodel objId
 * \param text
 */
void etMSCTracer_setNote(uint16 objId, const char *text);

/**
 * logs a global event
 *
 * \param text
 */
void etMSCTracer_globalEvent(const char *text);

/**
 * hidden text in diagram source
 *
 * \param text
 */
void etMSCTracer_hiddenText(const char *text);

//
// - control methods
//

/**
 * start or resume tracing
 */
void etMSCTracer_start();

/**
 * suspend tracing
 */
void etMSCTracer_stop();

/**
 * write traces and create diagram
 */
void etMSCTracer_flush();


#endif /* SRC_COMMON_DEBUGGING_ETMSCTRACER_H_ */
