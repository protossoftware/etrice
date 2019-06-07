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
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etActor.h
 *
 * the base "class" of a actor
 */

#ifndef _ETACTOR_H_
#define _ETACTOR_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"

/** transition chain ID indicating that no chain fired */
#define NOT_CAUGHT 0

/**
 * event ID and interface item are code in one integer called trigger.
 * The event has a decimal shift of 2
 */
#define EVT_SHIFT 100

/**
 * this function handles system events
 *
 * \param ifitem the interface item that received the event
 * \param evt the event ID
 * \param generic_data a data pointer whose type can be inferred from the event type,
 * 	may be <code>NULL</code>
 *
 * 	\return <code>true</code> if the event was a system event and thus was already handled
 */
etBool handleSystemEvent(InterfaceItemBase* ifitem, int evt, void* generic_data);

#endif /* _ETACTOR_H_ */
