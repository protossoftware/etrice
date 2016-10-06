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

#ifndef RTOBJECT_H_
#define RTOBJECT_H_

#include "common/messaging/IRTObject.h"
#include <string>
#include <vector>

namespace etRuntime {

class RTObject: public virtual IRTObject {
public:
	RTObject(IRTObject* parent, const std::string& name);

	virtual ~RTObject();

	virtual const std::string& getName() const {
		return m_name;
	}
	virtual const std::string& getInstancePath() const {
		return m_instancePath;
	}
	virtual const std::string& getInstancePathName() const {
		return m_instancePathName;
	}

	virtual std::vector<IRTObject*>& getChildren() {
		return m_children;
	}

	virtual IRTObject* getParent() const {
		return m_parent;
	}

	virtual IRTObject* getRoot() const;

	virtual IRTObject* getChild(const std::string& name) const;

	virtual IRTObject* getObject(const std::string& path) const;

	virtual int getThreadForPath(const std::string& path) const;

protected:
	virtual void destroy();

	std::string toStringRecursive(const std::string& indent) const;
	std::string toStringRecursive() const;
	virtual std::string toString() const;

private:

	std::string m_name;
	// for speed optimization the instance paths are created at instantiation
	// and used as const ref parameters in the logging methods to avoid copying
	std::string m_instancePath;
	std::string m_instancePathName;
	IRTObject* m_parent;
	std::vector<IRTObject*> m_children;

	RTObject();
	RTObject(RTObject const&);
	RTObject& operator=(RTObject const&);
};

} /* namespace etRuntime */
#endif /* RTOBJECT_H_ */
