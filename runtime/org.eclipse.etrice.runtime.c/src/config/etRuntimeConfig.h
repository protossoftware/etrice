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
 * file etRuntimeConfig.h
 *
 * preprocessor switches that configure the runtime
 *
 * \author Thomas Schuetz
 */

#ifndef ETGLOBALFLAGS_H_
#define ETGLOBALFLAGS_H_

/* runner */
#define ET_RUNNER_ACTIVATE
#undef 	ET_DO_NOT_USE_ARGC_ARGV

/* flags for debugging */

/* MSC logger */

/** switches the logger on */
#define ET_LOGGER_ACTIVATE

/** switches the MSC logger on, needs \ref ET_LOGGER_ACTIVATE */
#define ET_MSC_LOGGER_ACTIVATE

/** switches the logging of asynchronous messages on,  needs \ref ET_MSC_LOGGER_ACTIVATE */
#undef ET_SYNC_MSC_LOGGER_ACTIVATE
/** switches the logging of synchronous messages on,  needs \ref ET_MSC_LOGGER_ACTIVATE */
#define ET_ASYNC_MSC_LOGGER_ACTIVATE

/* data logger */

/** switches the data logger on */
#define ET_DATA_LOGGER_ACTIVATE

/* timing and scheduling */
/* #define FREQUENCY 10L */
/* #define ET_RUNTIME_MAXLOOP 100 */
/* #define ET_RUNTIME_ENDLESS */

/** enable multi threading (e.g. for protection of message queues) */
#define ET_MULTI_THREADING

#endif /* ETGLOBALFLAGS_H_ */
