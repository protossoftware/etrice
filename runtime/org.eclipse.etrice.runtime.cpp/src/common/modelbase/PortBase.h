/*
 * PortBase.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef PORTBASE_H_
#define PORTBASE_H_

#include "common/modelbase/InterfaceItemBase.h"
#include "common/messaging/Address.h"
#include <string>

namespace etRuntime {
class IEventReceiver;

class PortBase : public InterfaceItemBase{
public:
	PortBase (IEventReceiver& actor, IRTObject* parent, std::string name, int localId, int idx, Address address, Address peerAddress)
		: InterfaceItemBase(actor, parent, name, localId, idx, address, peerAddress){};
	virtual ~PortBase();

private:
	PortBase();

};

} /* namespace etRuntime */
#endif /* PORTBASE_H_ */
