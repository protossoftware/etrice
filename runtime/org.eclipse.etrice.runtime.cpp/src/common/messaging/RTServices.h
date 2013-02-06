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
class MessageServiceController;


class RTServices {
public:
	virtual ~RTServices();

	static RTServices& getInstance() {
		if (s_instance == 0) {
			s_instance = new RTServices();
		}
		return *s_instance;
	}

	void destroy();
	MessageServiceController& getMsgSvcCtrl();
	SubSystemClassBase* getSubSystem() {	return m_subSystem;	};
	void setSubSystem(SubSystemClassBase* subSystem) { m_subSystem = subSystem;	};

private:
	static RTServices* s_instance;

	SubSystemClassBase* m_subSystem;
	MessageServiceController* m_messageServiceController;

	RTServices();
	RTServices(const RTServices & right);
	RTServices & operator = (const RTServices& right);

};

} /* namespace etRuntime */
#endif /* RTSERVICES_H_ */
