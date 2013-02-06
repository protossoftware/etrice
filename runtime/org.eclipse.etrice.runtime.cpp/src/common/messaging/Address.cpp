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

#include "Address.h"
#include <sstream>
#include <iostream>

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

Address & Address::operator = (const Address& right) 	{
	if (this != &right) {
		m_nodeID   = right.m_nodeID;
		m_threadID = right.m_threadID;
		m_objectID = right.m_objectID;
	}
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

std::string Address::toString() const{
   std::stringstream strm;
   strm << "Address(nodeID=" << m_nodeID
		   << ",threadID=" << m_threadID  << ",objectID=" << m_objectID+")";
   return strm.str();
}
std::string Address::toID() const{
	std::stringstream strm;
	strm << m_nodeID << "_" << m_threadID << "_" << m_objectID;
	return strm.str();
}

Address Address::createInc(int i) {
	return Address(m_nodeID, m_threadID, m_objectID+i);
}

void Address::printAddrVector(const std::vector<std::vector<etRuntime::Address> >& addresses){
	std::vector<std::vector<etRuntime::Address> >::const_iterator outerIt = addresses.begin();
	std::cout << "{" ;
	for (int i=0; outerIt!= addresses.end(); ++outerIt,++i) {
		std::cout << "{" ;
		std::vector<etRuntime::Address>::const_iterator it = (*outerIt).begin();
		for (int j=0; it!=(*outerIt).end(); ++it,++j) {
			std::cout << (*it).toID() << ":" << addresses[i][j].toID() << ",";
		}
		std::cout << "}" << std::endl;
	}
	std::cout << "}" << std::endl;
}

} /* namespace etRuntime */
