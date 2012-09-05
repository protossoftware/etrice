/*
 * EventWithDataMessage.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "EventWithDataMessage.h"
#include <sstream>

namespace etRuntime {

EventWithDataMessage::~EventWithDataMessage() {
}

std::string EventWithDataMessage::toString() {
	std::stringstream strm;
	strm << "EventWithDataMessage(" << getAddress().toString() << ", evt=" << getEvtId() + ", m_data=" << dataToString() << ")";
	return strm.str();
}

std::string EventWithDataMessage::dataToString() {
	if (m_data == 0) {
		return "()";
	}
	//TODO: how to do this with all kinds of data??
	//return "(" + m_data + ")";
	return "()";
}

} /* namespace etRuntime */
