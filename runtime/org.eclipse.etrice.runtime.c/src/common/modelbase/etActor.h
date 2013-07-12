/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETACTOR_H_
#define _ETACTOR_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"

#define NOT_CAUGHT 0
#define EVT_SHIFT 100

etBool handleSystemEvent(InterfaceItemBase* ifitem, int evt, void* generic_data);

#endif /* _ETACTOR_H_ */
