/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "common/messaging/RTObject.h"
#include "etDatatypes.h"

namespace etRuntime {

RTObject::RTObject(IRTObject* parent, const String& name) :
		m_name(name),
		m_parent(parent),
		m_children() {

	if (m_parent != 0) {
		m_parent->getChildren().push_back(this);
#ifdef RTOBJECT_STORES_PATHS
		m_instancePath = m_parent->getInstancePath() + PATH_DELIM + m_name;
		m_instancePathName = m_parent->getInstancePathName() + PATHNAME_DELIM + m_name;
#endif
	}
#ifdef RTOBJECT_STORES_PATHS
	else {
		m_instancePath = PATH_DELIM + m_name;
		m_instancePathName = PATHNAME_DELIM + m_name;
	}
#endif
}

void RTObject::destroy() {
	for (ChildList::iterator it = m_children.begin(); it != m_children.end(); ++it) {
		RTObject* child = dynamic_cast<RTObject*>(*it);
		if (child != 0) {
			child->destroy();
		}
	}

	// no removal in parent to maintain reference for deletion
	m_parent = 0;
}

IRTObject* RTObject::getRoot() const {
	IRTObject* root = const_cast<RTObject*>(this);
	while (root->getParent() != 0)
		root = root->getParent();

	return root;
}

IRTObject* RTObject::getChild(const String& name) const {
	for (ChildList::const_iterator it = m_children.begin(); it != m_children.end(); ++it) {
		if (name == ((*it)->getName())) {
			return *it;
		}
	}

	return 0;
}

IRTObject* RTObject::getObject(const String& path) const {
	etBool isAbsolute = (path[0] == PATH_DELIM);
	if (isAbsolute && getParent() != 0)
		return getParent()->getObject(path);

	String segment;
	std::size_t last = 0;
	if (isAbsolute) {
		last = 1;
		size_t first = path.find(PATH_DELIM, last);
		segment = path.substr(last, (first == String::npos) ? String::npos : first - 1);
		if (segment != m_name)
			return 0;

		last = first;
	}

	IRTObject* current = const_cast<RTObject*>(this);
	std::size_t next;
	while ((next = path.find(PATH_DELIM, last)) != String::npos) {
		if (next > last + 1) {
			segment = path.substr(last, next - last);
			current = current->getChild(segment);
			if (current == 0)
				return 0;
		}
		last = next + 1;
	}
	if (last < path.length() - 1) {
		segment = path.substr(last);
		current = current->getChild(segment);
	}

	return current;
}

int RTObject::getThreadForPath(const String& path) const {
	if (m_parent != 0)
		return m_parent->getThreadForPath(path);

	return -1;
}

String RTObject::toStringRecursive(const String& indent) const {
	String result(indent + toString() + "\n");

	String indentInc("  " + indent);
	ChildList::const_iterator it = m_children.begin();
	for (; it != m_children.end(); ++it) {
		RTObject* child = dynamic_cast<RTObject*>(*it);
		if (child != 0)
			result += child->toStringRecursive(indentInc);
	}

	return result;
}

#ifndef RTOBJECT_STORES_PATHS
String RTObject::getInstancePath() const {
	if (m_parent != 0) {
		return m_parent->getInstancePath() + PATH_DELIM + m_name;
	}
	else {
		return PATH_DELIM + m_name;
	}
}

String RTObject::getInstancePathName() const {
	if (m_parent != 0) {
		return m_parent->getInstancePathName() + PATHNAME_DELIM + m_name;
	}
	else {
		return PATHNAME_DELIM + m_name;
	}
}
#endif

String RTObject::toStringRecursive() const {
	return toStringRecursive("");
}

String RTObject::toString() const {
	return getName();
}

} /* namespace etRuntime */
