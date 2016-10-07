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

#ifndef SUBSYSTEMCLASSBASE_H_
#define SUBSYSTEMCLASSBASE_H_

#include "common/modelbase/IEventReceiver.h"
#include "common/modelbase/IInterfaceItemOwner.h"
#include "common/modelbase/IReplicatedInterfaceItem.h"
#include "common/modelbase/RTSystemProtocol.h"
#include "etDatatypes.h"
#include <map>
#include <string>


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

	ActorClassBase* getInstance(const std::string& path) const;

	void addPathToThread(const std::string& path, int thread);
	int getThreadForPath(const std::string& path) const;

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

	SubSystemClassBase(IRTObject* parent, std::string name);

	//--------------------- ports
	RTSystemConjPort m_RTSystemPort;

	//--------------------- interface item IDs
	static const int IFITEM_RTSystemPort = 0;

private:

	std::map<std::string, int> m_path2thread;

	SubSystemClassBase();
	SubSystemClassBase(SubSystemClassBase const&);
	SubSystemClassBase& operator=(SubSystemClassBase const&);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMCLASSBASE_H_ */
