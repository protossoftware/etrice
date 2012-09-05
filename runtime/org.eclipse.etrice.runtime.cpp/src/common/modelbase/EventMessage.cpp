/*
 * EventMessage.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "EventMessage.h"
#include <sstream>

namespace etRuntime {

std::string EventMessage::toString() {
	std::stringstream strm;
	strm << "EventMessage(" << getAddress().toString() << ", evt=" << m_evtId << ")";
	return strm.str();

}

EventMessage::~EventMessage() {
}

} /* namespace etRuntime */
