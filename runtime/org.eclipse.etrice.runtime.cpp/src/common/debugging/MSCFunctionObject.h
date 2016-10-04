/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_
#define SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_

#include <string>
#include "common/debugging/MSCLogger.h"

namespace etRuntime {

class MSCFunctionObject {
public:
	MSCFunctionObject(const std::string& objectName, const std::string& message);
	~MSCFunctionObject();

private:
	MSCLogger& m_syncLogger;
	const std::string m_targetName;
	const std::string m_sourceName;
};

} // namespace etRuntime

#endif /* SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_ */
