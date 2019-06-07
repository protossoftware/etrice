/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef SUBSYSTEMCLASSBASE_H_
#define SUBSYSTEMCLASSBASE_H_

#include "common/containers/Map.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/modelbase/IInterfaceItemOwner.h"
#include "common/modelbase/IReplicatedInterfaceItem.h"
#include "common/modelbase/RTSystemProtocol.h"
#include "etDatatypes.h"


namespace etRuntime {

class ActorClassBase;

class SubSystemClassBase: public RTObject, public virtual IEventReceiver, public virtual IInterfaceItemOwner {
public:
	virtual ~SubSystemClassBase() {}

	virtual void init();
	virtual void instantiateMessageServices() = 0;
	virtual void mapThreads(void) = 0;
	virtual void initialize(void) = 0;
	virtual void setProbesActive(bool recursive, bool active) {}

	void start();
	void stop();
	virtual void destroy();

	IMessageService* getMsgService(int idx) const;
	Address getFreeAddress(int msgSvcId) const;

	ActorClassBase* getInstance(const String& path) const;

	void addPathToThread(const String& path, int thread);
	int getThreadForPath(const String& path) const;

	void resetAll();

	virtual IEventReceiver* getEventReceiver() const {
		return const_cast<SubSystemClassBase*>(this);
	}

	virtual int getThread() {
		return 0;
	}

	virtual IReplicatedInterfaceItem* getSystemPort() const {
		return const_cast<RTSystemConjPort*>(&m_RTSystemPort);
	}

	virtual etBool hasGeneratedMSCInstrumentation() const {
		return false;
	}

protected:

	SubSystemClassBase(IRTObject* parent, String name);

	//--------------------- ports
	RTSystemConjPort m_RTSystemPort;

	//--------------------- interface item IDs
	static const int IFITEM_RTSystemPort = 0;

private:

	Map<String, int> m_path2thread;

	SubSystemClassBase();
	SubSystemClassBase(SubSystemClassBase const&);
	SubSystemClassBase& operator=(SubSystemClassBase const&);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMCLASSBASE_H_ */
