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

#ifndef IRTOBJECT_H_
#define IRTOBJECT_H_

#include "common/containers/String.h"
#include "common/containers/Vector.h"

namespace etRuntime {

class IRTObject {

public:
	virtual ~IRTObject() {
	}

	static const char PATH_DELIM = '/';
	static const char PATHNAME_DELIM = '_';
	static const String NO_NAME;

	typedef Vector<IRTObject*> ChildList;

	virtual const String& getName() const = 0;
	virtual String getInstancePath() const = 0;
	virtual String getInstancePathName() const = 0;

	virtual ChildList& getChildren() = 0;

	virtual IRTObject* getParent() const = 0;

	virtual IRTObject* getRoot() const = 0;

	virtual IRTObject* getChild(const String& name) const = 0;

	virtual IRTObject* getObject(const String& path) const = 0;

	virtual int getThreadForPath(const String& path) const = 0;
};

}

#endif /* IRTOBJECT_H_ */
