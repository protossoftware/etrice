/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_
#define SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_

#include "common/debugging/MSCLogger.h"
#include "common/containers/String.h"

namespace etRuntime {

class MSCFunctionObject {
public:
	MSCFunctionObject(const String& objectName, const String& message);
	~MSCFunctionObject();

private:
	MSCLogger& m_syncLogger;
	const String m_targetName;
	const String m_sourceName;
};

} // namespace etRuntime

#endif /* SRC_COMMON_DEBUGGING_MSCFUNCTIONOBJECT_H_ */
