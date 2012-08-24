/*
 * RTObject.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#ifndef RTOBJECT_H_
#define RTOBJECT_H_

#include <string>
#include "common/messaging/IRTObject.h"

namespace etRuntime {

class RTObject : public IRTObject{
public:
	RTObject();
	RTObject(IRTObject* parent, std::string name);
	RTObject(const RTObject & right);
	RTObject & operator = (RTObject right);

	virtual ~RTObject();

	IRTObject* getParent() { return m_parent; };
	std::string getInstancePath();
	std::string getInstancePathName();

private:
	IRTObject* m_parent;
	std::string m_name;

};

} /* namespace etRuntime */
#endif /* RTOBJECT_H_ */
