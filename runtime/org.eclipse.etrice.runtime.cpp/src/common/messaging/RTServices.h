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

#ifndef RTSERVICES_H_
#define RTSERVICES_H_

#include "common/messaging/MessageServiceController.h"

namespace etRuntime {

class SubSystemClassBase;

class RTServices {
public:
	static RTServices& getInstance() {
		static RTServices s_instance;

		return s_instance;
	}

	virtual ~RTServices() {
		m_subSystem = 0;
	}

	void destroy() {

	}
	MessageServiceController& getMsgSvcCtrl() {
		return m_messageServiceController;
	}
	SubSystemClassBase* getSubSystem() const {
		return m_subSystem;
	}
	void setSubSystem(SubSystemClassBase* subSystem) {
		m_subSystem = subSystem;
	}

private:
	SubSystemClassBase* m_subSystem;
	MessageServiceController m_messageServiceController;

	RTServices() :
			m_subSystem(0),
			m_messageServiceController() {
	}
	RTServices(RTServices const&);
	void operator=(RTServices const&);

};

} /* namespace etRuntime */
#endif /* RTSERVICES_H_ */
