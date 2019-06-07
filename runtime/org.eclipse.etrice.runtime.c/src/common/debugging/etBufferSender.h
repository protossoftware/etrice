/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etSender.h
 *
 * an interface for sending a buffer contents
 *
 * \author: hrentzreichert
 */
#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETBUFFERSENDER_H_
#define _ETBUFFERSENDER_H_

#include <stddef.h>
#include "etDatatypes.h"

struct etBufferSender;

typedef void* etBufferSender_getBuffer(struct etBufferSender* self, size_t size);
typedef void etBufferSender_sendBuffer(struct etBufferSender* self, void* buffer, size_t size);

typedef struct etBufferSender {
	etBufferSender_getBuffer* getBuffer;
	etBufferSender_sendBuffer* sendBuffer;
}
etBufferSender;

#endif /* _ETBUFFERSENDER_H_ */

#ifdef __cplusplus
}
#endif
