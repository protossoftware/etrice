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

#include "common/messaging/RTObject.h"
#include "etDatatypes.h"
#include <iterator>
#include <string>
#include <vector>

namespace etRuntime {

RTObject::RTObject(IRTObject* parent, const std::string& name) :
		m_name(name),
		m_parent(parent),
		m_children() {

	if (m_parent != 0) {
		m_parent->getChildren().push_back(this);
		m_instancePath = m_parent->getInstancePath() + PATH_DELIM + m_name;
		m_instancePathName = m_parent->getInstancePathName() + PATHNAME_DELIM + m_name;
	} else {
		m_instancePath = PATH_DELIM + m_name;
		m_instancePathName = PATHNAME_DELIM + m_name;
	}
}

void RTObject::destroy() {
	for (std::vector<IRTObject*>::iterator it = m_children.begin(); it != m_children.end(); ++it) {
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

IRTObject* RTObject::getChild(const std::string& name) const {
	for (std::vector<IRTObject*>::const_iterator it = m_children.begin(); it != m_children.end(); ++it) {
		if (name == ((*it)->getName())) {
			return *it;
		}
	}

	return 0;
}

IRTObject* RTObject::getObject(const std::string& path) const {
	etBool isAbsolute = (path[0] == PATH_DELIM);
	if (isAbsolute && getParent() != 0)
		return getParent()->getObject(path);

	std::string segment;
	std::size_t last = 0;
	if (isAbsolute) {
		last = 1;
		size_t first = path.find(PATH_DELIM, last);
		segment = path.substr(last, (first == std::string::npos) ? std::string::npos : first - 1);
		if (segment != m_name)
			return 0;

		last = first;
	}

	IRTObject* current = const_cast<RTObject*>(this);
	std::size_t next;
	while ((next = path.find(PATH_DELIM, last)) != std::string::npos) {
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

int RTObject::getThreadForPath(const std::string& path) const {
	if (m_parent != 0)
		return m_parent->getThreadForPath(path);

	return -1;
}

std::string RTObject::toStringRecursive(const std::string& indent) const {
	std::string result(indent + toString() + "\n");

	std::string indentInc("  " + indent);
	std::vector<IRTObject*>::const_iterator it = m_children.begin();
	for (; it != m_children.end(); ++it) {
		RTObject* child = dynamic_cast<RTObject*>(*it);
		if (child != 0)
			result += child->toStringRecursive(indentInc);
	}

	return result;
}

std::string RTObject::toStringRecursive() const {
	return toStringRecursive("");
}

std::string RTObject::toString() const {
	return getName();
}

} /* namespace etRuntime */
