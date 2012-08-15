/*
 * Address.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef ADDRESS_H_
#define ADDRESS_H_

namespace etRuntime {

class Address {
public:
	Address(int nodeID,int threadID, int objectID)
	: m_nodeID(nodeID), m_threadID(threadID), m_objectID(objectID) {};
	Address(const Address & right)
	: m_nodeID(right.m_nodeID), m_threadID(right.m_threadID), m_objectID(right.m_objectID){};
	~Address();

	bool isValid() const { return (m_nodeID != 0) && (m_threadID != 0) && (m_objectID != 0);};
	int m_nodeID;
	int m_threadID;
	int m_objectID;

private:
	Address();
};

} /* namespace etRuntime */
#endif /* ADDRESS_H_ */

