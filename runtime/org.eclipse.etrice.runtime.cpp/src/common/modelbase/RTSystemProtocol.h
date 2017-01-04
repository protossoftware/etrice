/*
 * RTSystemProtocol.h
 *
 *  Created on: 09.12.2015
 *      Author: Juergen
 */

#ifndef SRC_COMMON_MESSAGING_RTSYSTEMPROTOCOL_H_
#define SRC_COMMON_MESSAGING_RTSYSTEMPROTOCOL_H_

#include "common/modelbase/RTSystemServicesProtocol.h"

namespace etRuntime {

class RTSystemProtocol {
public:
	static const String RT_SYSTEM_PORT_NAME;
};


class RTSystemPort: public RTSystemServicesProtocolPort {

public:
	RTSystemPort(IInterfaceItemOwner* actor, int localId);

private:
	RTSystemPort();
	RTSystemPort(RTSystemPort const&);
	RTSystemPort& operator=(RTSystemPort const&);

};

class RTSystemConjPort: public RTSystemServicesProtocolConjReplPort {
public:
	RTSystemConjPort(IInterfaceItemOwner* actor, int localId);
	virtual ~RTSystemConjPort() {}

protected:
	virtual InterfaceItemBase* createInterfaceItem(IInterfaceItemOwner* rcv, const String& name, int lid, int idx);

private:
	RTSystemConjPort();
	RTSystemConjPort(RTSystemConjPort const&);
	RTSystemConjPort& operator=(RTSystemConjPort const&);
};

class RTSystemConjSubPort: public RTSystemServicesProtocolConjPort {
public:
	RTSystemConjSubPort(IInterfaceItemOwner* actor, const String& name, int localId, int idx);
	virtual ~RTSystemConjSubPort() {}

private:
	RTSystemConjSubPort();
	RTSystemConjSubPort(RTSystemConjSubPort const&);
	RTSystemConjSubPort& operator=(RTSystemConjSubPort const&);

};

} /* namespace etRuntime */

#endif /* SRC_COMMON_MESSAGING_RTSYSTEMPROTOCOL_H_ */
