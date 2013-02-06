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

#include "RTServices.h"

namespace etRuntime {

RTServices* RTServices::s_instance = 0;

RTServices::RTServices()
	:	m_subSystem(0),
	 	m_messageServiceController(	new MessageServiceController())
{
}

RTServices::~RTServices() {
	// TODO Auto-generated destructor stub
}

void RTServices::destroy() {
	// TODO: also clean up all sub elements
	m_subSystem = 0;
	m_messageServiceController = 0;
	//TODO is delete necessary here??
	//delete s_instance;
	s_instance = 0;
}

MessageServiceController& RTServices::getMsgSvcCtrl() {
	//TODO
	//assert(m_messageServiceController != 0);
	return *m_messageServiceController;
}

} /* namespace etRuntime */
