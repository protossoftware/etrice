/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.ETypedElement

class PostprocessingHelpers {
	
	public static int UNBOUNDED_MULTIPLICITY = ETypedElement::UNBOUNDED_MULTIPLICITY
	
	def static getClass(EPackage pckg, String name) {
		pckg.getEClassifier(name) as EClass
	}
	
	def static getAttribute(EClass cls, String name) {
		cls.EAllAttributes.findFirst(a | a.name.equals(name))
	}
	
	def static getReference(EClass cls, String name) {
		cls.EAllReferences.findFirst(a | a.name.equals(name))
	}
	
	def static addOperation(EClass owner, String name, EClassifier type, String body) {
		addOperation(owner, name, type, 1, body)
	}
	
	def static addOperation(EClass owner, String name, EClassifier type, Integer upperBound, String body) {
		val op = EcoreFactory::eINSTANCE.createEOperation()
		op.setName(name)
		op.setEType(type)
		op.setUpperBound(upperBound)
		
		val anno = EcoreFactory::eINSTANCE.createEAnnotation
		anno.setSource("http://www.eclipse.org/emf/2002/GenModel")
		anno.details.put("body", body)
		op.EAnnotations.add(anno)
		
		owner.EOperations.add(op)
	}
	
}