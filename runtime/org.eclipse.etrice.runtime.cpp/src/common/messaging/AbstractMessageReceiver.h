/*
 * AbstractMessageReceiver.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#ifndef ABSTRACTMESSAGERECEIVER_H_
#define ABSTRACTMESSAGERECEIVER_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/RTObject.h"
#include <string>

namespace etRuntime {

class AbstractMessageReceiver: public RTObject, public IMessageReceiver {

public:
	Address getAddress() const {
		return address_;
	}
	virtual ~AbstractMessageReceiver();

protected:
	AbstractMessageReceiver(IRTObject* parent, Address address, std::string name) :
			RTObject(parent, name), IMessageReceiver(), address_(address) {

	}

private:
	Address address_;

	AbstractMessageReceiver();
	AbstractMessageReceiver(const AbstractMessageReceiver& right);
	AbstractMessageReceiver& operator=(const AbstractMessageReceiver& right);
};


}
#endif /* ABSTRACTMESSAGERECEIVER_H_ */
