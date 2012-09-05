/*
 * Address.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "Address.h"
#include <sstream>

namespace etRuntime {

Address::Address(int nodeID, int threadID, int objectID) :
		m_nodeID(nodeID),
		m_threadID(threadID),
		m_objectID(objectID) {
};

Address::Address(const Address & right) :
		m_nodeID(right.m_nodeID),
		m_threadID(right.m_threadID),
		m_objectID(right.m_objectID) {
};

Address & Address::operator = (Address s) 	{
   std::swap(s, *this);
   return *this;
}

bool Address::operator< (const Address& right) const {
	if (m_nodeID == right.m_nodeID) {
		if (m_threadID == right.m_threadID) {
			return (m_objectID < right.m_objectID);
		}
		else {
			return (m_threadID < right.m_threadID);
		}
	}
	else {
		return (m_nodeID < right.m_nodeID);
	}
}

Address::~Address() {
}

std::string Address::toString(){
   std::stringstream strm;
   strm << "Address(nodeID=" << m_nodeID
		   << ",threadID=" << m_threadID  << ",objectID=" << m_objectID+")";
   return strm.str();
}
std::string Address::toID(){
	std::stringstream strm;
	strm << m_nodeID << "_" << m_threadID << "_" << m_objectID;
	return strm.str();
}

Address Address::createInc(int i) {
	return Address(m_nodeID, m_threadID, m_objectID+i);
}


} /* namespace etRuntime */
