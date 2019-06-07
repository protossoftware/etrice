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
 * \file etConsoleLogger.h
 *
 * an interface for writing a buffer contents to stdout. This implementation is a singleton.
 *
 * \author: hrentzreichert
 */
#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETCONSOLELOGGER_H_
#define _ETCONSOLELOGGER_H_

#include <debugging/etBufferSender.h>
#include "etLogger.h"

extern etLogger theConsoleLogger;

/**
 * initializes the console logger. This function may be called several times but initializes only once.
 * If used in a multi-threaded environment, synchronization is needed (supply a lock).
 */
void etConsoleLogger_init();

#endif /* _ETCONSOLELOGGER_H_ */

#ifdef __cplusplus
}
#endif
