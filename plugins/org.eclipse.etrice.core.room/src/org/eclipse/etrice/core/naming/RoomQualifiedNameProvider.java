/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.naming;

import org.eclipse.etrice.core.fsm.naming.FSMQualifiedNameProvider;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.xtext.naming.QualifiedName;

public class RoomQualifiedNameProvider extends FSMQualifiedNameProvider {

	// important: don't rely on cross reference resolution here

	// public QualifiedName qualifiedName(RefinedState rs) {
	// QualifiedName fqn = QualifiedName.create();
	// BaseState base = rs.getBase();
	// if (base!=null)
	// {
	// fqn = QualifiedName.create(base.getName());
	// EObject parent = base.eContainer().eContainer();
	// while (parent instanceof BaseState) {
	// fqn = QualifiedName.create(((BaseState)parent).getName()).append(fqn);
	// parent = parent.eContainer().eContainer();
	// }
	// }
	// return fqn;
	// }

	public RoomQualifiedNameProvider() {
		super();
	}

	public QualifiedName qualifiedName(Message m) {
		ProtocolClass pc = (ProtocolClass) m.eContainer();
		String list;
		if (pc.getIncomingMessages().contains(m))
			list = "in";
		else
			list = "out";

		return getFullyQualifiedName(pc).append(list).append(m.getName());
	}

	public QualifiedName qualifiedName(PortClass pc) {
		ProtocolClass p = (ProtocolClass) pc.eContainer();
		return getFullyQualifiedName(p).append(p.getRegular() == pc ? "regular" : "conjugated");
	}
}
