/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.AbstractMessage;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IFSMTranslationProvider {

	/**
	 * start sequence for tags to be translated
	 */
	public static final String TAG_START = "<|";
	/**
	 * end sequence for tags to be translated
	 */
	public static final String TAG_END = "|>";

	/**
	 * the container class for which translations have to be provided.
	 * This can be either of
	 * <ul>
	 *   <li>{@link ModelComponent}</li>
	 *   <li>{@link DataClass}</li>
	 *   <li>{@link ProtocolClass}</li>
	 *   <li>{@link PortClass}</li>
	 * </ul>
	 * 
	 * @param container
	 */
	void setContainerClass(EObject container);
	
	/**
	 * @return true if translation should be applied to members (attributes, operations and port.msg
	 */
	boolean translateMembers();
	
	/**
	 * yield a sequence that sends a message through an interface item (port or SAP).
	 * Is called whenever <i>port</i>.<i>msg</i>(<i>args</i>)
	 * or <i>port</i>[<i>index</i>].<i>msg</i>(<i>args</i>) is found in the detail code
	 * 
	 * @param item the interface item
	 * @param msg the message to send
	 * @param args the message data
	 * @param index array index for replicated ports, should be null for simple ports
	 * 				and may be null for broadcast through replicated port
	 * @param orig the original text
	 * @return the translation
	 */
	String getInterfaceItemMessageText(AbstractInterfaceItem item, AbstractMessage msg, ArrayList<String> args, String index, String orig);

	/**
	 * @return true if translations are provided for tags
	 */
	boolean translateTags();
	
	/**
	 * yield a replacement for a tag. Is called whenever &lt;|<i>tag</i>|>
	 * is found in the detail code
	 * 
	 * @param tag the tag name
	 * @param code the detail code containing the tag
	 * @return the translated tag
	 */
	String translateTag(String tag, DetailCode code);

}
