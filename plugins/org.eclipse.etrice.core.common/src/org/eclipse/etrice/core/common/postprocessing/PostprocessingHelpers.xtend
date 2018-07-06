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

package org.eclipse.etrice.core.common.postprocessing

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.util.EcoreUtil

class PostprocessingHelpers {
	
	public static int UNBOUNDED_MULTIPLICITY = ETypedElement::UNBOUNDED_MULTIPLICITY
	public static String JAVADOC_NEWLINE = "<br>"
	
	def static getClass(EPackage pckg, String name) {
		pckg.getEClassifier(name) as EClass
	}
	
	def static setDocumentation(EModelElement eModelElement, String documentation){
		EcoreUtil::setDocumentation(eModelElement, JAVADOC_NEWLINE+documentation)
	}
	
	def static getAttribute(EClass cls, String name) {
		cls.EAllAttributes.findFirst(a | a.name.equals(name))
	}
	
	def static getReference(EClass cls, String name) {
		cls.EAllReferences.findFirst(a | a.name.equals(name))
	}
	
	def static addOperation(EClass owner, String name, EClassifier type) {
		addOperation(owner, name, type, 1, null)
	}
	
	def static addOperation(EClass owner, String name, EClassifier type, String body) {
		addOperation(owner, name, type, 1, body)
	}
	
	def static addOperation(EClass owner, String name, EClassifier type, Integer upperBound, String body) {
		val op = EcoreFactory::eINSTANCE.createEOperation()
		op.setName(name)
		op.setEType(type)
		op.setUpperBound(upperBound)
		
		if (body !== null) {
			val anno = EcoreFactory::eINSTANCE.createEAnnotation
			anno.setSource("http://www.eclipse.org/emf/2002/GenModel")
			anno.details.put("body", body)
			op.EAnnotations.add(anno)
		}
		
		owner.EOperations.add(op)
	}
	
	def static addAttribute(EClass owner, String name, EClassifier type, Object defaultValue) {
		val attr = EcoreFactory::eINSTANCE.createEAttribute
		attr.setName(name)
		attr.setEType(type)
		attr.defaultValue = defaultValue
		
		owner.EStructuralFeatures.add(attr)
	}
	
	def static addClass(EPackage pck, String name) {
		val cls = EcoreFactory::eINSTANCE.createEClass
		cls.name = name
		pck.EClassifiers.add(cls)
		
		return cls
	}
	
	/* this does not work because the EMF generator doesn't pick up the annotation
	def static addDerivedReferenceList(EClass owner, String name, EClassifier type, int upperBound, String body) {
		val ref = EcoreFactory::eINSTANCE.createEReference
		ref.setName(name)
		ref.setEType(type)
		ref.setUpperBound(upperBound)
		ref.setChangeable(false)
		ref.setTransient(true)
		ref.setVolatile(true)
		ref.setDerived(true)

		val anno = EcoreFactory::eINSTANCE.createEAnnotation
		anno.setSource("http://www.eclipse.org/emf/2002/GenModel")
		anno.details.put("body", body)
		ref.EAnnotations.add(anno)
		
		owner.EStructuralFeatures.add(ref)
	}
	*/
}