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

namespace etRuntime {
class IEventReceiver;

class PortBase : public InterfaceItemBase{
public:
	PortBase (const IEventReceiver& actor, const char * name, int localId, int idx, Address address, Address peerAddress)
		: InterfaceItemBase(actor, name, localId, idx, address, peerAddress){};
	virtual ~PortBase();

private:
	PortBase();

};

} /* namespace etRuntime */
#endif /* PORTBASE_H_ */
