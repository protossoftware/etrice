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

namespace etRuntime {

class RTObject: public virtual IRTObject {
public:
	RTObject(IRTObject* parent, const String& name);

	virtual ~RTObject() {}

	virtual const String& getName() const {
		return m_name;
	}
	virtual String getInstancePath() const;
	virtual String getInstancePathName() const;

	virtual ChildList& getChildren() {
		return m_children;
	}

	virtual IRTObject* getParent() const {
		return m_parent;
	}

	virtual IRTObject* getRoot() const;

	virtual IRTObject* getChild(const String& name) const;

	virtual IRTObject* getObject(const String& path) const;

	virtual int getThreadForPath(const String& path) const;

protected:
	virtual void destroy();

	String toStringRecursive(const String& indent) const;
	String toStringRecursive() const;
	virtual String toString() const;

private:

	String m_name;
	IRTObject* m_parent;
	ChildList m_children;
#ifdef RTOBJECT_STORES_PATHS
	// for speed optimization the instance paths are created at instantiation
	// TODO: if not RTOBJECT_STORES_PATHS we need to return a copy
	// in the other case it would be more efficient to return const refs.
	// Can this be resolved in some way?
	String m_instancePath;
	String m_instancePathName;
#endif

	// unimplemented
	RTObject();
	RTObject(RTObject const&);
	RTObject& operator=(RTObject const&);
};

#ifdef RTOBJECT_STORES_PATHS
inline const String& RTObject::getInstancePath() const {
	return m_instancePath;
}
inline const String& RTObject::getInstancePathName() const {
	return m_instancePathName;
}
#endif

} /* namespace etRuntime */
#endif /* RTOBJECT_H_ */
