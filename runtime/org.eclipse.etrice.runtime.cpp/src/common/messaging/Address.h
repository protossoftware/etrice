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
	~Address();

	int m_nodeID;
	int m_threadID;
	int m_objectID;

private:
	Address();
};

} /* namespace etRuntime */
#endif /* ADDRESS_H_ */

