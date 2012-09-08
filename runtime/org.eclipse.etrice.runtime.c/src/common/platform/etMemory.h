/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETMEMORY_H_
#define _ETMEMORY_H_

#include "etDatatypes.h"
#include "etRuntimeConfig.h"

#define CONSTANT_MEM_CEIL(n)	\
		((n)+(((int32)STRUCT_ALIGN-((n)&((int32)STRUCT_ALIGN-1)))&((int32)STRUCT_ALIGN-1)))

#define MEM_ALIGNMENT		STRUCT_ALIGN      /* power of 2 and >= sizeof(int) ! */
#define MEM_CEIL(n)			CONSTANT_MEM_CEIL(n)

#endif /* _ETMEMORY_H_ */
