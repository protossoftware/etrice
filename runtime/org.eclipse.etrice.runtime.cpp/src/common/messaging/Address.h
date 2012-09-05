/*
 * Address.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef ADDRESS_H_
#define ADDRESS_H_

#include <string>

namespace etRuntime {

class Address {
public:
	Address(int nodeID, int threadID, int objectID);
	Address(const Address & right);
	Address & operator = (Address s);
	bool operator< (const Address& right) const;
	~Address();

	std::string toString();
	std::string toID();

	Address createInc(int i);
	bool isValid() const {
		return (m_nodeID != 0) && (m_threadID != 0) && (m_objectID != 0);
	};

	int m_nodeID;
	int m_threadID;
	int m_objectID;

private:
	Address();
};

} /* namespace etRuntime */
#endif /* ADDRESS_H_ */


