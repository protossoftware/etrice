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

#ifndef PORTBASE_H_
#define PORTBASE_H_

#include "common/modelbase/IInterfaceItemOwner.h"
#include "common/modelbase/InterfaceItemBase.h"

namespace etRuntime {

class PortBase: public InterfaceItemBase {

public:
	virtual ~PortBase() {}

protected:
	PortBase(IInterfaceItemOwner* owner, const String& name, int localId) :
			InterfaceItemBase(owner, name, localId, 0) {
	}

	PortBase(IInterfaceItemOwner* owner, const String& name, int localId, int idx) :
			InterfaceItemBase(owner, name, localId, idx) {
	}

private:

	PortBase(PortBase const&);
	PortBase & operator =(PortBase const&);

};

} /* namespace etRuntime */
#endif /* PORTBASE_H_ */
