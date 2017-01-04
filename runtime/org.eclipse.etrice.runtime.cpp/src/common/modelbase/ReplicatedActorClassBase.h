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

#ifndef SRC_COMMON_MODELBASE_REPLICATEDACTORCLASSBASE_H_
#define SRC_COMMON_MODELBASE_REPLICATEDACTORCLASSBASE_H_

#include "common/messaging/RTObject.h"
#include "common/modelbase/ActorClassBase.h"
#include "common/containers/String.h"
#include "common/containers/Vector.h"

namespace etRuntime {

class ReplicatedActorClassBase : public RTObject {

public:
	static const char SEP = ':';

	ReplicatedActorClassBase(IRTObject* parent, const String& name);
	virtual ~ReplicatedActorClassBase(void);
	void createSubActors(int number);
	void initialize(void);
	void setProbesActive(bool recursive, bool active);
	int getNSubActors(void) { return m_items.size(); }
	ActorClassBase* getSubActor(int index) { return m_items[index]; }

protected:
	virtual ActorClassBase* createActor(IRTObject* parent, const String& name) = 0;

private:
	Vector<ActorClassBase*> m_items;
};

} // namespace et Runtime

#endif /* SRC_COMMON_MODELBASE_REPLICATEDACTORCLASSBASE_H_ */
