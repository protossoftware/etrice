/*
 * IEventReceiver.h
 *
 *  Created on: 08.06.2012
 *      Author: karlitsc
 */

#ifndef IEVENTRECEIVER_H_
#define IEVENTRECEIVER_H_

#include "platforms/generic/etDatatypes.h"
#include "common/messaging/IRTObject.h"

namespace etRuntime {
class InterfaceItemBase;

class IEventReceiver {
public:
	IEventReceiver();
	virtual ~IEventReceiver();

	virtual void receiveEvent(const InterfaceItemBase& ifitem, etInt16 evt, void* data) = 0;

};

} /* namespace etRuntime */
#endif /* IEVENTRECEIVER_H_ */
