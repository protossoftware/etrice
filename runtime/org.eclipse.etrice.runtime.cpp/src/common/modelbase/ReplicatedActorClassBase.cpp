/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "ReplicatedActorClassBase.h"

namespace etRuntime {

ReplicatedActorClassBase::ReplicatedActorClassBase(IRTObject* parent, const std::string& name) :
		RTObject(parent, name), m_items() {
}

ReplicatedActorClassBase::~ReplicatedActorClassBase() {
	for(std::vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		delete *it;
	}
}

void ReplicatedActorClassBase::createSubActors(int number) {
	for (int i = 0; i < number; i++) {
		std::stringstream itemName;
		itemName << getName() << SEP << i;
		ActorClassBase* item = createActor(getParent(), itemName.str());
		m_items.push_back(item);
	}
}

void ReplicatedActorClassBase::initialize() {
	for(std::vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		(*it)->initialize();
	}
}

void ReplicatedActorClassBase::setProbesActive(bool recursive, bool active) {
	for(std::vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it)
			(*it)->setProbesActive(recursive, active);
}

} // namespace etRuntime
