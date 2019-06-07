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

#include "common/modelbase/DataPort.h"

namespace etRuntime {

void DataPortBase::connect(IRTObject* obj, const String& path1, const String& path2) {
	IRTObject* obj1 = obj->getObject(path1);
	IRTObject* obj2 = obj->getObject(path2);

	DataReceivePort* recvPort = dynamic_cast<DataReceivePort*>(obj1);
	DataSendPort* sendPort = dynamic_cast<DataSendPort*>(obj2);
	if (recvPort == 0 || sendPort == 0) {
		recvPort = dynamic_cast<DataReceivePort*>(obj2);
		sendPort = dynamic_cast<DataSendPort*>(obj1);
	}

	if (recvPort != 0 && sendPort != 0)
		recvPort->connect(sendPort);
}

}

