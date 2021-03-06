/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "common/modelbase/EventReceiver.h"

namespace etRuntime {

EventReceiver::EventReceiver(IRTObject* parent, const String& name) :
		RTObject(parent, name),
		m_thread(-1) {
}

int EventReceiver::getThread() {
	if (m_thread < 0) {
		m_thread = getThreadForPath(getInstancePath());
		if (m_thread < 0) {
			IEventReceiver* parent = dynamic_cast<IEventReceiver*>(getParent());
			if (parent != 0)
				m_thread = parent->getThread();
			else
				m_thread = 0;
		}
	}

	return m_thread;
}

} /* namespace etRuntime */
