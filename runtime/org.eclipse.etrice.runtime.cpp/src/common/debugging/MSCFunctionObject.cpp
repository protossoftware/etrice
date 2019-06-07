/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "common/debugging/MSCFunctionObject.h"
#include "common/debugging/DebuggingService.h"

using namespace etRuntime;

MSCFunctionObject::MSCFunctionObject(const String& objectName, const String& message) :
		m_syncLogger(DebuggingService::getInstance().getSyncLogger()),
		m_targetName(objectName),
		m_sourceName(m_syncLogger.getObjectName().c_str())
{
	m_syncLogger.setObjectName(m_targetName.c_str());
	m_syncLogger.addMessageSyncCall(m_sourceName.c_str(), m_targetName.c_str(), message.c_str());
}

MSCFunctionObject::~MSCFunctionObject() {
	m_syncLogger.setObjectName(m_sourceName.c_str());
	m_syncLogger.addMessageSyncReturn(m_sourceName.c_str(), m_targetName.c_str(), "return");
}

