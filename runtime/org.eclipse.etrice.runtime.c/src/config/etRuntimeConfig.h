/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef ETGLOBALFLAGS_H_
#define ETGLOBALFLAGS_H_

/* flags for debugging */

#define ET_MSC_LOGGER_ACTIVATE  /* needs ET_LOGGER_ACTIVATE */
//#define ET_SYNC_MSC_LOGGER_ACTIVATE  /* needs ET_MSC_LOGGER_ACTIVATE */
#define ET_ASYNC_MSC_LOGGER_ACTIVATE  /* needs ET_MSC_LOGGER_ACTIVATE */
#define ET_LOGGER_ACTIVATE


#define STRUCT_ALIGN		8

/* timing and scheduling */
//#define FREQUENCY 10L
//#define ET_RUNTIME_MAXLOOP 100
/*#define ET_RUNTIME_ENDLESS*/

/* enable multi threading (e.g. for protection of message queues) */
#define ET_MULTI_THREADING

#endif /* ETGLOBALFLAGS_H_ */
