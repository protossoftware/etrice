/*
 * Message.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

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
