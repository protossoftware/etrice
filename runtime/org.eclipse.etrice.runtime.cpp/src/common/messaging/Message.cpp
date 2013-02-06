/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "Message.h"

#include <sstream>

namespace etRuntime {


Message::~Message() {
	m_next = 0;
}

std::string Message::toString(){
   std::stringstream strm;
   strm << "EventMessage(" << m_address.toString() << ", evt=" << m_evtId << ")";
   if (m_data) {
	   strm << std::showbase << std::hex << m_data;
   }
   return strm.str();
}

} /* namespace etRuntime */
