/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.ast

import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.PortOperation
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.dctools.fsm.ast.IFSMTranslationProvider

/** 
 * This interface is used by the detail code translator to replace
 * common constructs in detail level code with a target language specific
 * piece of code.
 * <p>
 * The constructs that are replaced are
 * <ul>
 * <li>attributes</li>
 * <li>operations</li>
 * <li>port.message</li>
 * <li>tags of the form <code><|tag|></code></li>
 * </ul>
 * </p>
 * @see DCTranslator
 * @author Henrik Rentz-Reichert
 */
interface ITranslationProvider extends IFSMTranslationProvider{
	
	/** 
	 * yield text to read an attribute (array index may be null). Is called whenever <i>attribute</i> 
	 * or <i>attribute</i>[<i>index</i>] or is
	 * found in the detail code
	 * @param att the actor class attribute
	 * @param instance a pointer to the instance object
	 * @param index the index (should be null for scalars, !=null for arrays)
	 * @param orig the original text
	 * @return the translation
	 */
	def String getAttributeGetter(Attribute att, String instance, String index, String orig) 
	
	/** 
	 * yield text to write an attribute (array index may be null). Is called whenever <i>attribute</i>.set(<i>value</i>)
	 * or <i>attribute</i>[<i>index</i>].set(<i>value</i>) is
	 * found in the detail code
	 * @param att the actor class attribute
	 * @param instance a pointer to the instance object
	 * @param index the index (should be null for scalars, !=null for arrays)
	 * @param value to assign to the attribute
	 * @param orig the original text
	 * @return the translation
	 */
	def String getAttributeSetter(Attribute att, String instance, String index, String value, String orig) 
	
	/** 
	 * yield text for operation call. Is called whenever <i>operation</i>(<i>args</i>)
	 * is found in the detail code
	 * @param op operation to call
	 * @param instance a pointer to the defining class instance
	 * @param args the arguments to pass
	 * @param orig the original text
	 * @return the translation
	 */
	def String getOperationText(Operation op, String instance, String args, String orig) 
	
	/** 
	 * yields a sequence that reads data from a <b>data driven</b> port.
	 * Is called whenever <i>port</i>.<i>msg</i> or <i>port</i>[<i>index</i>].<i>msg</i>
	 * is found in the detail code
	 * @param item the interface item
	 * @param msg the message to read
	 * @param orig the original text
	 * @return the translation
	 */
	def String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) 
	
	/** 
	 * @return true if translations are provided for enumerations
	 */
	def boolean translateEnums() 
	
	/** 
	 * yields a replacement for &lt;enumtype>.&lt;literal>
	 * @param literal the enumeration literal to be translated
	 * @return the translated enumeration literal
	 */
	def String getEnumText(EnumLiteral literal) 
	
	/** 
	 * yields a call to an operation of an interface item
	 * @param item the interface item
	 * @param op the port class operation
	 * @param instance a pointer to the defining class instance
	 * @param args the argument list
	 * @param orig the original test
	 * @return the translation
	 */
	def String getInterfaceItemOperationText(AbstractInterfaceItem item, PortOperation op, String instance, String args, String orig) 
	
}