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
 * \file etMemory_Dynamic.h
 *
 * etMemory wrapper for std malloc & free
 *
 */
#ifndef SRC_COMMON_BASE_ETMEMORY_DYNAMIC_H_
#define SRC_COMMON_BASE_ETMEMORY_DYNAMIC_H_

#include "base/etMemory.h"

ET_EXTERN_C_BEGIN

/**
 * etMemory based on std malloc and free - not recommended for embedded systems
 */
etMemory* etMemory_Dynamic_init();

ET_EXTERN_C_END

#endif /* SRC_COMMON_BASE_ETMEMORY_DYNAMIC_H_ */
