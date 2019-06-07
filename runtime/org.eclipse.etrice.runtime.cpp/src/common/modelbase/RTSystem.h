/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_COMMON_MODELBASE_RTSYSTEM_H_
#define SRC_COMMON_MODELBASE_RTSYSTEM_H_

#include "common/messaging/RTObject.h"
#include "common/containers/String.h"

namespace etRuntime {

class RTSystem: public RTObject {

public:
	explicit RTSystem(String name) :
			RTObject(0, name) {
	}
	virtual ~RTSystem() {}

private:
	RTSystem();
	RTSystem(RTSystem const&);
	RTSystem& operator=(RTSystem const&);

};

}  // namespace etRuntime

#endif /* SRC_COMMON_MODELBASE_RTSYSTEM_H_ */
