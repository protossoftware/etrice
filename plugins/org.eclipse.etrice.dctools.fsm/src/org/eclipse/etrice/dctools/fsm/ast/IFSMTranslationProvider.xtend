/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast

import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.ModelComponent

/**
 * @author Henrik Rentz-Reichert
 *
 */
interface IFSMTranslationProvider {
	
	/** 
	 * start sequence for tags to be translated
	 */
	public static final String TAG_START="<|"
	
	/** 
	 * end sequence for tags to be translated
	 */
	public static final String TAG_END="|>"
	
	/** 
	 * the container class for which translations have to be provided.
	 * This can be either of
	 * <ul>
	 * <li>{@link ModelComponent}</li>
	 * <li>DataClass</li>
	 * <li>ProtocolClass</li>
	 * <li>PortClass</li>
	 * </ul>
	 * @param container
	 */
	def void setContainerClass(EObject container) 
	
	/** 
	 * @return true if translation should be applied to members (attributes, operations and port.msg)
	 */
	def boolean translateMembers() 
	
	/** 
	 * yield a sequence that sends a message through an interface item (port or SAP).
	 * Is called whenever <i>port</i>.<i>msg</i>(<i>args</i>)
	 * or <i>port</i>[<i>index</i>].<i>msg</i>(<i>args</i>) is found in the detail code
	 * @param item the interface item
	 * @param msg the message to send
	 * @param ifitem the pointer of the interface item
	 * @param args the message parameters
	 * @param index array index for replicated ports, should be null for simple ports
	 * and may be null for broadcast through replicated port
	 * @param orig the original text
	 * @return the translation
	 */
	def String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject msg, String ifitem, String args, String index, String orig) 
	
	/** 
	 * @return true if translations are provided for tags
	 */
	def boolean translateTags() 
	
	/** 
	 * yield a replacement for a tag. Is called whenever &lt;|<i>tag</i>|>
	 * is found in the detail code
	 * @param tag the tag name
	 * @param code the detail code containing the tag
	 * @return the translated tag
	 */
	def String translateTag(String tag, DetailCode code) 
	
}