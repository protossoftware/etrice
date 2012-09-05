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

class AbstractMessageReceiver: public RTObject, public virtual IMessageReceiver {

public:
	Address getAddress() const {
		return m_address;
	}
	virtual ~AbstractMessageReceiver();

protected:
	AbstractMessageReceiver(IRTObject* parent, Address address, std::string name)
	: IMessageReceiver(),
	  RTObject(parent, name),
	  m_address(address)
	{

	}

private:
	Address m_address;

	AbstractMessageReceiver();
};


}
#endif /* ABSTRACTMESSAGERECEIVER_H_ */
