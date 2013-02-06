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

#include <string>

namespace etRuntime {

class IRTObject {

public:
	virtual ~IRTObject() {};

	static const char PATH_DELIM = '/';
	static const char PATHNAME_DELIM = '_';
	static const std::string NO_NAME;

	virtual const std::string& getInstancePath() const = 0;
	virtual const std::string& getInstancePathName() const = 0;
};

}

#endif /* IRTOBJECT_H_ */
