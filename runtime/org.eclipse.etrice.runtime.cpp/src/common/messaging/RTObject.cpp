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

#include "RTObject.h"

namespace etRuntime {

RTObject::RTObject() :
		IRTObject(),
		m_parent(0),
		m_name(NO_NAME) ,
		m_instancePath(),
		m_instancePathName()
{
	setPathNames();
}

RTObject::RTObject(IRTObject* parent, std::string name) :
		IRTObject(),
		m_parent(parent),
		m_name(name),
		m_instancePath(),
		m_instancePathName()
{
	setPathNames();
}

RTObject::RTObject(const RTObject & right) :
		m_parent(right.m_parent),
		m_name(right.m_name),
		m_instancePath(right.m_instancePath),
		m_instancePathName(right.m_instancePathName)
{
}

RTObject & RTObject::operator = (RTObject right) 	{
   std::swap(right, *this);
   return *this;
}

RTObject::~RTObject() {
	m_parent = 0;
}

void RTObject::setPathNames() {
	if (m_parent != 0) {
		m_instancePath = m_parent->getInstancePath() + PATH_DELIM + m_name;
		m_instancePathName = m_parent->getInstancePathName() + PATHNAME_DELIM + m_name;
	}
	else {
		m_instancePath = PATH_DELIM + m_name;
		m_instancePathName = PATHNAME_DELIM + m_name;
	}
}

const std::string& RTObject::getInstancePath() const{
	return m_instancePath;
}

const std::string& RTObject::getInstancePathName() const{
	return m_instancePathName;
}

} /* namespace etRuntime */
