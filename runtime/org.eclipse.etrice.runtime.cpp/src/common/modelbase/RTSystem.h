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
#ifndef SRC_COMMON_MODELBASE_RTSYSTEM_H_
#define SRC_COMMON_MODELBASE_RTSYSTEM_H_

#include "common/messaging/RTObject.h"
#include <string>

namespace etRuntime {

class RTSystem: public RTObject {

public:
	explicit RTSystem(std::string name) :
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
