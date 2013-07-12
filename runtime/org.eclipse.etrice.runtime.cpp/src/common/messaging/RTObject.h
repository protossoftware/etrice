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

#include <string>
#include "common/messaging/IRTObject.h"

namespace etRuntime {

class RTObject :  public virtual IRTObject{
public:
	RTObject();
	RTObject(IRTObject* parent, std::string name);
	RTObject(const RTObject & right);
	RTObject & operator = (RTObject right);

	virtual ~RTObject();

	IRTObject* getParent() const { return m_parent; };
	const std::string& getName() const { return m_name; };

	virtual const std::string& getInstancePath() const;
	virtual const std::string& getInstancePathName() const;

private:
	void setPathNames();

	IRTObject* m_parent;
	std::string m_name;
	// for speed optimization the instance paths are created at instantiation
	// and used as const ref parameters in the logging methods to avoid copying
	std::string m_instancePath;
	std::string m_instancePathName;

};

} /* namespace etRuntime */
#endif /* RTOBJECT_H_ */
