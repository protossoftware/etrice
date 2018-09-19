/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.doc.gen

import org.eclipse.etrice.generator.base.ITranslationProvider
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
import org.eclipse.etrice.core.room.PortOperation
import java.util.List
import org.eclipse.etrice.core.room.Operation
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.DetailCode

class DocTranslationProvider implements ITranslationProvider {
	
	override getAttributeGetter(Attribute att, String index, String orig) {
		""
	}
	
	override getAttributeSetter(Attribute att, String index, String value, String orig) {
		""
	}
	
	override getEnumText(EnumLiteral literal) {
		""
	}
	
	override getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		""
	}
	
	override getInterfaceItemOperationText(AbstractInterfaceItem item, PortOperation op, List<String> args, String orig) {
		""
	}
	
	override getOperationText(Operation op, List<String> args, String orig) {
		""
	}
	
	override translateEnums() {
		false
	}
	
	override getInterfaceItemMessageText(AbstractInterfaceItem item, EObject msg, List<String> args, String index, String orig) {
		""
	}
	
	override setContainerClass(EObject container) {
		
	}
	
	override translateMembers() {
		false
	}
	
	override translateTag(String tag, DetailCode code) {
		""
	}
	
	override translateTags() {
		false
	}
	
}