/*
 * RTServices.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

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
