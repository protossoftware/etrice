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


#ifndef _ETSTDMACROS_H_
#define _ETSTDMACROS_H_

#ifdef __cplusplus
#define ET_EXTERN_C_BEGIN					extern "C" {
#define ET_EXTERN_C_END						}
#define ET_CONST_MEMBER
#define ET_INITIALIZATION_OF_INST_VAR
#define ET_FOWARD_DECLARATION_OF_INST_VAR	extern
#else
#define ET_EXTERN_C_BEGIN
#define ET_EXTERN_C_END
#define ET_CONST_MEMBER						const
#define ET_INITIALIZATION_OF_INST_VAR		static
#define ET_FOWARD_DECLARATION_OF_INST_VAR	static
#endif

#endif /* _ETSTDMACROS_H_ */
