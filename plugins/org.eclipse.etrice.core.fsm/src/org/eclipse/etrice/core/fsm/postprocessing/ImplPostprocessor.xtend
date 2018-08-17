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
 * 		Henrik Rentz-Reichert
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import org.eclipse.emf.ecore.EcorePackage

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class ImplPostprocessor {
	
	def process(GeneratedMetamodel metamodel) {
		val fsmPackage = metamodel.getEPackage
		
		val state = fsmPackage.getClass("State")
		state.addOperation("getName", EcorePackage.Literals.ESTRING, 1,
		// HOWTO: putting a fully qualified type name in <% %> makes ecore generate an import statement
			'''return (this instanceof <%org.eclipse.etrice.core.fsm.fSM.SimpleState%>)? ((SimpleState)this).getName() :(this instanceof <%org.eclipse.etrice.core.fsm.fSM.RefinedState%>)? (((RefinedState)this).getTarget()==null? "":((RefinedState)this).getTarget().getName()) :"";''')
		
		val stateGraphItem = fsmPackage.getClass("StateGraphItem")
		stateGraphItem.addOperation("getName", EcorePackage::eINSTANCE.getEClassifier("EString"), 1,
			'''
			if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.State%>) 
				return ((State)this).getName();
			else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.TrPoint%>)
				return ((TrPoint)this).getName();
			else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.ChoicePoint%>)
				return ((ChoicePoint)this).getName();
			else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.Transition%>)
				return ((Transition)this).getName();
			else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.RefinedTransition%>)
				return ((RefinedTransition)this).getTarget().getName();
			return "";
			''')
		
		val ifItem = fsmPackage.getClass("AbstractInterfaceItem")
        ifItem.addOperation("getDisplayName", EcorePackage::eINSTANCE.getEClassifier("EString"), 1,
            '''
                return getName();
            '''
        )
		ifItem.addOperation("getSemantics", fsmPackage.getEClassifier("ProtocolSemantics"))
		ifItem.addOperation("getAllIncomingAbstractMessages", EcorePackage.Literals.EOBJECT, -1, null)
		ifItem.addOperation("getAllOutgoingAbstractMessages", EcorePackage.Literals.EOBJECT, -1, null)
        ifItem.addOperation("isEventDriven", EcorePackage.Literals.EBOOLEAN, 1, "return true;")
		
		val itemOwner = fsmPackage.addClass("IInterfaceItemOwner")
		itemOwner.setAbstract(true)
		itemOwner.setInterface(true)
		itemOwner.addOperation("getAbstractInterfaceItems", fsmPackage.getEClassifier("AbstractInterfaceItem"), -1, null)
		itemOwner.addOperation("getAllAbstractInterfaceItems", fsmPackage.getEClassifier("AbstractInterfaceItem"), -1, null)
		
		val comp = fsmPackage.getClass("ModelComponent")
		comp.ESuperTypes.add(itemOwner)
	}
}

