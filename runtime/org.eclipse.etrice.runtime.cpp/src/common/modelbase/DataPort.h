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
#ifndef SRC_COMMON_MODELBASE_DATAPORT_H_
#define SRC_COMMON_MODELBASE_DATAPORT_H_

#include "common/messaging/RTObject.h"
#include <string>

namespace etRuntime {

class DataPortBase: public RTObject {
public:
	static void connect(IRTObject* obj, const std::string& path1, const std::string& path2);

	DataPortBase(IRTObject* parent, const std::string& name, int localId) :
			RTObject(parent, name),
			m_localId(localId) {
	}

	int getLocalId() const {
		return m_localId;
	}

private:
	int m_localId;

	DataPortBase();
	DataPortBase(DataPortBase const&);
	DataPortBase& operator=(DataPortBase const&);
};

class DataSendPort: public DataPortBase {
public:
	DataSendPort(IRTObject* parent, const std::string& name, int localId) :
			DataPortBase(parent, name, localId) {
	}

private:

	DataSendPort(DataSendPort const&);
	DataSendPort& operator=(DataSendPort const&);
};

class DataReceivePort: public DataPortBase {
	friend class DataPortBase;
public:
	DataReceivePort(IRTObject* parent, const std::string& name, int localId) :
			DataPortBase(parent, name, localId) {
	}

	virtual void connect(DataSendPort* dataSendPort) = 0;
private:

	DataReceivePort(DataReceivePort const&);
	DataReceivePort& operator=(DataReceivePort const&);
};

} /* namespace etRuntime */

#endif /* SRC_COMMON_MODELBASE_DATAPORT_H_ */
