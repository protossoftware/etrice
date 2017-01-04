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

ReplicatedActorClassBase::ReplicatedActorClassBase(IRTObject* parent, const String& name) :
		RTObject(parent, name), m_items() {
}

ReplicatedActorClassBase::~ReplicatedActorClassBase() {
	for(Vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		delete *it;
	}
}

void ReplicatedActorClassBase::createSubActors(int number) {
	m_items.reserve(m_items.size() + number);

	for (int i = 0; i < number; i++) {
		char buffer[64];
		sprintf(buffer, "%s%c%d", getName().c_str(), SEP, i);
		ActorClassBase* item = createActor(getParent(), buffer);
		m_items.push_back(item);
	}
}

void ReplicatedActorClassBase::initialize() {
	for(Vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it) {
		(*it)->initialize();
	}
}

void ReplicatedActorClassBase::setProbesActive(bool recursive, bool active) {
	for(Vector<ActorClassBase*>::iterator it = m_items.begin(); it != m_items.end(); ++it)
			(*it)->setProbesActive(recursive, active);
}

} // namespace etRuntime
