/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;

public class HandledMessage {
	private AbstractInterfaceItem ifitem;
	private EObject msg;
	private EObject origin;
	private String reason;

	public HandledMessage(AbstractInterfaceItem ifitem, EObject msg, EObject origin) {
		this.ifitem = ifitem;
		this.msg = msg;
		this.origin = origin;
	}

	public AbstractInterfaceItem getIfitem() {
		return ifitem;
	}

	public EObject getMsg() {
		return msg;
	}

	public EObject getOrigin() {
		return origin;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}