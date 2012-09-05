/*
 * RTObject.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#include "RTObject.h"

namespace etRuntime {

RTObject::RTObject() :
		IRTObject(), m_parent(0), m_name(NO_NAME) {
}
;

RTObject::RTObject(IRTObject* parent, std::string name) :
		IRTObject(), m_parent(parent), m_name(name) {
}

RTObject::RTObject(const RTObject & right) :
		m_parent(right.m_parent),
		m_name(right.m_name)
{
};

RTObject & RTObject::operator = (RTObject right) 	{
   std::swap(right, *this);
   return *this;
}

RTObject::~RTObject() {
	m_parent = 0;
}

std::string RTObject::getInstancePath() const{
	std::string path = PATH_DELIM + m_name;

	if (m_parent != 0)
		path = m_parent->getInstancePath() + path;

	return path;
}

std::string RTObject::getInstancePathName() const{
	std::string path = PATHNAME_DELIM + m_name;

	if (m_parent != 0)
		path = m_parent->getInstancePathName() + path;

	return path;
}

} /* namespace etRuntime */
