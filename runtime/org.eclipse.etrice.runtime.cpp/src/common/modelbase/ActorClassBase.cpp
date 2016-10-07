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

#include "ActorClassBase.h"
#include "common/modelbase/InterfaceItemBase.h"
#include "common/modelbase/RTSystemServicesProtocol.h"
#include "common/modelbase/SystemPortOwner.h"
#include "etDatatypes.h"
#include <iterator>
#include <string>
#include <vector>


namespace etRuntime {

ActorClassBase::ActorClassBase(IRTObject* parent, const std::string& name) :
		SystemPortOwner(parent, name),
		m_state(0),
		m_RTSystemPort(this, IFITEM_RTSystemPort),
		m_className("noname") {
}

ActorClassBase::~ActorClassBase() {
	m_state = 0;
}

void ActorClassBase::initialize() {
	// since we have no mapping for the system ports we connect them directly here
	IReplicatedInterfaceItem* systemPort = getSystemPort();
	if (systemPort != 0) {
		InterfaceItemBase* peer = systemPort->createSubInterfaceItem();
		m_RTSystemPort.connectWith(peer);
	}
}



//SubSystemClassBase* ActorClassBase::getSubSystem() const {
//	return 0; // TODO JH
//}

//--------------------- life cycle functions
void ActorClassBase::init() {
	ActorClassBase* child = 0;
	for (std::vector<IRTObject*>::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		if ((child = dynamic_cast<ActorClassBase*>(*it)) != 0)
			child->init();
	}

	initUser();
}

void ActorClassBase::start() {
	ActorClassBase* child = 0;
	for (std::vector<IRTObject*>::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		if ((child = dynamic_cast<ActorClassBase*>(*it)) != 0)
			child->start();
	}

	startUser();
}

void ActorClassBase::stop() {
	stopUser();

	ActorClassBase* child = 0;
	for (std::vector<IRTObject*>::iterator it = getChildren().begin(); it != getChildren().end(); ++it) {
		if ((child = dynamic_cast<ActorClassBase*>(*it)) != 0)
			child->stop();
	}
}

void ActorClassBase::destroy() {
	SystemPortOwner::destroy();
}

etBool ActorClassBase::handleSystemEvent(InterfaceItemBase* ifitem, int evt, void* generic_data) {
	if ((ifitem != 0) && (ifitem->getLocalId() != 0)) {
		return false;
	}

	switch (evt) {
	case RTSystemServicesProtocol::IN_executeInitialTransition:
		executeInitTransition();
		break;
	case RTSystemServicesProtocol::IN_startDebugging:
		break;
	case RTSystemServicesProtocol::IN_stopDebugging:
		break;
	default:
		return false;
	}
	return true;
}

std::string ActorClassBase::toString() const {
	ActorClassBase* thisPtr = const_cast<ActorClassBase*>(this);
	char buffer[10];
	sprintf(buffer, "%i", thisPtr->getThread());

	return getName() + " : " + getClassName() + " thread:" + buffer;
}

} /* namespace etRuntime */
