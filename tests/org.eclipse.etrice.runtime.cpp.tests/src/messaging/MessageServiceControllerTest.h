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

#ifndef SRC_MESSAGING_MESSAGESERVICECONTROLLERTEST_H_
#define SRC_MESSAGING_MESSAGESERVICECONTROLLERTEST_H_

#include "util/etTestSuite.h"
#include "osal/etTimer.h"

class MessageServiceControllerTest: public etTestSuite {
public:
	MessageServiceControllerTest();
	~MessageServiceControllerTest();

protected:
	void testThreadIds(void);
	void testMsgSvcManagement(void);

	void runAllTestCases(void);

private:
	etTimer m_timer;

	void timeout(void);
	static void timeout(void* self) {
		(static_cast<MessageServiceControllerTest*>(self))->timeout();
	}
};

#endif /* SRC_MESSAGING_MESSAGESERVICECONTROLLERTEST_H_ */
