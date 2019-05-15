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

#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETRUNTIME_H_
#define _ETRUNTIME_H_

#include "messaging/etMessageService.h"
#include "base/etMemory.h"

/**
 * \file etRuntime.h
 *
 * runtime methods
 *
 * \author Thomas Schuetz
 */

#include "osal/etSema.h"

/**
 * returns the number of message services in this process
 *
 * \return the number of message services in this process
 */
int etRuntime_getMessageServiceCount();

/**
 * returns the statistics of a message service
 *
 * \param i the message service instance number
 * \return the statistics of this message service
 */
const etMessageServiceStatistics* etRuntime_getMessageServiceStatistics(unsigned int i);

/**
 * returns the name of a message service
 *
 * \param i the message service instance number
 * \return the name of this message service
 */
const char* etRuntime_getMessageServiceName(unsigned int i);

/**
 * finds a message service by its name and returns its index or -1 if not found
 *
 * \param name the name of the message service
 * \return the index of the message service or -1
 */
int etRuntime_getMessageServiceByName(const char* name);

/**
 * sets a flag in all message service structs that tells the message services to reset their statistics
 */
void etRuntime_resetAllMessageServiceStatistics();

/**
 * registers a message service
 * \param msgService the message service
 */
void etRuntime_registerMessageService(etMessageService* msgService);

/**
 * unregisters a message service
 * \param msgService the message service
 */
void etRuntime_unregisterMessageService(etMessageService* msgService);

/**
 * registers a memory management
 * \param mem the memory management
 */
void etRuntime_registerMemoryManagement(etMemory* mem);

/**
 * unregisters a memory management
 * \param mem the memory management
 */
void etRuntime_unregisterMemoryManagement(etMemory* mem);

/**
 * returns the number of memory managements in this process
 *
 * \return the number of memory managements in this process
 */
int etRuntime_getMemoryManagementCount();

/**
 * returns the statistics of a memory management
 *
 * \param i the memory management instance number
 * \return the statistics of this memory management
 */
const etMemoryStatistics* etRuntime_getMemoryManagementStatistics(unsigned int i);

/**
 * finds a memory management by its name and returns its index or -1 if not found
 *
 * \param name the name of the memory management
 * \return the index of the memory management or -1
 */
int etRuntime_getMemoryManagementByName(const char* name);

/**
 * returns the name of a memory management
 *
 * \param i the memory management instance number
 * \return the name of this memory management
 */
const char* etRuntime_getMemoryManagementName(unsigned int i);

/**
 * sets a flag in all memory management structs that tells the memory managements to reset their statistics
 */
void etRuntime_resetAllMemoryManagementStatistics();

/**
 * a global semaphore used to terminate the application in headless mode
 *
 * \return the semaphore
 */
etSema* etRuntime_getTerminateSemaphore();

#endif /* _ETRUNTIME_H_ */

#ifdef __cplusplus
}
#endif
