/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		jci (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import org.eclipse.swt.widgets.Control;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IMemberAwareConfiguration {

	/**
	 * calls {@link #configureMemberAwareness(Control, boolean, boolean)} with the last two arguments set to false.
	 * 
	 * @param ctrl a dialog {@link Control}
	 */
	void configureMemberAwareness(Control ctrl);
	
	/**
	 * calls {@link #configureMemberAwareness(Control, boolean, boolean, boolean)} with <code>false</code> as last
	 * parameter.
	 * 
	 * @param ctrl a dialog {@link Control}
	 * @param useMembers <code>true</code> if this should be member aware
	 * @param useMessages <code>true</code> if this should be message aware
	 */
	void configureMemberAwareness(Control ctrl, boolean useMembers, boolean useMessages);
	
	/**
	 * used to configure member and message awareness. This means that code can be inserted
	 * by using the corresponding buttons of the {@link AbstractMemberAwarePropertyDialog}.
	 * 
	 * @param ctrl a dialog {@link Control}
	 * @param useMembers <code>true</code> if this should be member aware
	 * @param useMessages <code>true</code> if this should be message aware
	 * @param useRecvMessagesOnly <code>true</code> if only received messages can be used
	 */
	void configureMemberAwareness(Control ctrl, boolean useMembers, boolean useMessages, boolean useRecvMessagesOnly);
}
