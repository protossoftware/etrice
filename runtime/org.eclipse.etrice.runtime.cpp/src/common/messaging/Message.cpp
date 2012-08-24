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
   strm << "Message(" << m_address.toString() << ")";
   return strm.str();
}

} /* namespace etRuntime */
