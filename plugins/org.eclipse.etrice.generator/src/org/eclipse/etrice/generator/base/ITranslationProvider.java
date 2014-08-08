/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * This interface is used by the detail code parser to replace
 * common constructs in detail level code with a target language specific
 * piece of code.
 *
 * <p>
 * The constructs that are replaced are
 * <ul>
 *   <li>attributes</li>
 *   <li>operations</li>
 *   <li>port.message</li>
 *   <li>tags of the form <code><|tag|></code></li>
 * </ul>
 * </p>
 * 
 * @see DetailCodeTranslator
 * 
 * @author Henrik Rentz-Reichert
 */
public interface ITranslationProvider {

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
	 *   <li>{@link ActorClass}</li>
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
	 * yield text to read an attribute (array index may be null). Is called whenever <i>attribute</i> 
	 * or <i>attribute</i>[<i>index</i>] or is
	 * found in the detail code
	 * 
	 * @param att the actor class attribute
	 * @param index the index (should be null for scalars, !=null for arrays)
	 * @param orig the original text
	 * @return the translation
	 */
	String getAttributeGetter(Attribute att, String index, String orig);
	
	/**
	 * yield text to write an attribute (array index may be null). Is called whenever <i>attribute</i>.set(<i>value</i>)
	 * or <i>attribute</i>[<i>index</i>].set(<i>value</i>) is
	 * found in the detail code
	 * 
	 * @param att the actor class attribute
	 * @param index the index (should be null for scalars, !=null for arrays)
	 * @param value to assign to the attribute
	 * @param orig the original text
	 * @return the translation
	 */
	String getAttributeSetter(Attribute att, String index, String value, String orig);
	
	/**
	 * yield text for operation call. Is called whenever <i>operation</i>(<i>args</i>)
	 * is found in the detail code
	 * 
	 * @param op operation to call
	 * @param args the arguments to pass
	 * @param orig the original text
	 * @return the translation
	 */
	String getOperationText(Operation op, ArrayList<String> args, String orig);
	
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
	String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String index, String orig);
	
	/**
	 * yields a sequence that reads data from a <b>data driven</b> port.
	 * Is called whenever <i>port</i>.<i>msg</i> or <i>port</i>[<i>index</i>].<i>msg</i>
	 * is found in the detail code
	 * 
	 * @param item the interface item
	 * @param msg the message to read
	 * @param orig the original text
	 * @return the translation
	 */
	String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig);

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
	
	/**
	 * @return true if translations are provided for enumerations
	 */
	boolean translateEnums();
	
	/**
	 * yields a replacement for &lt;enumtype>.&lt;literal>
	 * 
	 * @param literal the enumeration literal to be translated
	 * @return the translated enumeration literal
	 */
	String getEnumText(EnumLiteral literal);
}