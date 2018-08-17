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

package org.eclipse.etrice.dctools.tests

import org.eclipse.etrice.dctools.ast.ITranslationProvider
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
import org.eclipse.etrice.core.room.PortOperation
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.room.Port
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.AccessorType

class TranslationProviderForTests implements ITranslationProvider {
	
	@Accessors(AccessorType.PUBLIC_GETTER)
	var messageTextCount = 0
	
	@Accessors(AccessorType.PUBLIC_GETTER)
	var attributeCount = 0
	
	@Accessors(AccessorType.PUBLIC_GETTER)
	var operationCount = 0
	
	override setContainerClass(EObject container) {
		// unused
	}
	
	//-- members
	
	override translateMembers() {
		true
	}
	
	override getAttributeGetter(Attribute att, String instance, String index, String orig) {
		attributeCount++
		val slf = if (instance===null) "globalScopeSelf" else instance
		val allArgs = slf + index.append
		att.name + "(" + allArgs + ")"
	}
	
	override getAttributeSetter(Attribute att, String instance, String index, String value, String orig) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getOperationText(Operation op, String instance, String args, String orig) {
		operationCount++
		val slf = if (instance===null) "globalScopeSelf" else instance
		val allArgs = slf + args.append
		op.name + "(" + allArgs + ")"
	}
	
	override getInterfaceItemMessageText(AbstractInterfaceItem item, EObject msg, String ifitem, String args, String index, String orig) {
		if (msg instanceof Message) {
			if (item instanceof Port) {
				messageTextCount++
				val protocol = item.protocol
				val allArgs = item.name + index.append + args.append
				if (index===null && item.multiplicity!=1) {
					protocol.name + "_" + msg.name + "_broadcast(" + allArgs + ")"
				}
				else {
					protocol.name + "_" + msg.name + "(" + allArgs + ")"
				}
			}
			else {
				orig
			}
		}
		else {
			orig
		}
	}
	
	override getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getInterfaceItemOperationText(AbstractInterfaceItem item, PortOperation op, String instance, String args, String orig) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	//-- enums
	
	override translateEnums() {
		true
	}
	
	override getEnumText(EnumLiteral literal) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	//-- tags
	
	override translateTags() {
		true
	}
	
	override translateTag(String tag, DetailCode code) {
		return TAG_START+"?"+tag+"?"+TAG_END;
	}
	
	private def append(String args) {
		if (args!==null && !args.trim.empty)
			", " + args
		else
			""
	}
	
}