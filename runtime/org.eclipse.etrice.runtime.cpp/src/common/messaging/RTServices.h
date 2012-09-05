/*
 * RTServices.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

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

};

} /* namespace etRuntime */
#endif /* RTSERVICES_H_ */
