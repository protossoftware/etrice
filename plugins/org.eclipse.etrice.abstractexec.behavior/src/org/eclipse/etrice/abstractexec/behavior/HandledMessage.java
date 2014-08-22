/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.AbstractMessage;

public class HandledMessage {
	private AbstractInterfaceItem ifitem;
	private AbstractMessage msg;
	private EObject origin;

	public HandledMessage(AbstractInterfaceItem ifitem, AbstractMessage msg, EObject origin) {
		this.ifitem = ifitem;
		this.msg = msg;
		this.origin = origin;
	}

	public AbstractInterfaceItem getIfitem() {
		return ifitem;
	}

	public AbstractMessage getMsg() {
		return msg;
	}

	public EObject getOrigin() {
		return origin;
	}
}