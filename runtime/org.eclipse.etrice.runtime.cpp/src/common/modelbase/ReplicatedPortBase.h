/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_COMMON_MODELBASE_REPLICATEDPORTBASE_H_
#define SRC_COMMON_MODELBASE_REPLICATEDPORTBASE_H_

#include "common/modelbase/ReplicatedInterfaceItemBase.h"

namespace etRuntime {

class ReplicatedPortBase: public ReplicatedInterfaceItemBase {
public:
	virtual ~ReplicatedPortBase() {}

protected:
	ReplicatedPortBase(IInterfaceItemOwner* owner, const String& name, int localId) :
			ReplicatedInterfaceItemBase(owner, name, localId) {
	}

private:

	ReplicatedPortBase();
	ReplicatedPortBase(ReplicatedPortBase const&);
	ReplicatedPortBase& operator=(ReplicatedPortBase const&);
};

}  // namespace etRuntime

#endif /* SRC_COMMON_MODELBASE_REPLICATEDPORTBASE_H_ */
