/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core

import com.google.common.collect.Maps
import java.util.Map
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.xtext.validation.AbstractValidationDiagnostic
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestNames extends TestBase {

	val Map<EObject, Boolean> nameErrorMap = Maps.newHashMap
	Resource res

	@Before
	def void SetUp() {
		prepare(CoreTestsActivator.getInstance().getBundle())
		res = getResource("NamesAreUnique.room")
		
		val model = res.contents.head
		val diag = getDiag(model)
		diag.children.forEach[
			if(it instanceof AbstractValidationDiagnostic){
				val obj = it.sourceEObject
				var nameError = nameErrorMap.get(obj)
				if(nameError === null) nameError = false
				nameErrorMap.put(obj, (nameError || it.isNameErrorMessage))
			}
		]
	}

	@Test
	def void RoomClassNames() {		
		Assert.assertTrue(hasNameErrorMessage(res.getEObject("ActorClass:ClassDuplicate1")))
		Assert.assertTrue(hasNameErrorMessage(res.getEObject("LogicalSystem:ClassDuplicate1")))
		Assert.assertTrue(hasNameErrorMessage(res.getEObject("AnnotationType:ClassDuplicate1")))
		Assert.assertTrue(hasNameErrorMessage(res.getEObject("EnumerationType:ClassDuplicate1")))
		Assert.assertTrue(hasNameErrorMessage(res.getEObject("PrimitiveType:ClassDuplicate1")))
	}

	@Test
	def void BaseClassNames() {
		val ac = res.getEObject("ActorClass:Base")
		val dc = res.getEObject("DataClass:DBase")
		
		val items = newArrayList(ac, dc)
		items += ac.eContents
		items += dc.eContents
		Assert.assertEquals("Unexpected item count", 15, items.size)
		items.forEach[
			Assert.assertFalse("expected no name error: " + it, it.hasNameErrorMessage)
		]
	}
	
	@Test
	def void OverrideNames(){
		val ac = res.getEObject("ActorClass:Override")
		val dc = res.getEObject("DataClass:DOverride")
		
		val items = newArrayList(ac, dc)
		items += ac.eContents
		items += dc.eContents
		Assert.assertEquals("Unexpected item count", 9, items.size)
		items.forEach[
			Assert.assertFalse("expected no name error: " + it, it.hasNameErrorMessage)
		]
	}

	@Test
	def void InheritedNames() {
		val ac = res.getEObject("ActorClass:Sub")
		val dc = res.getEObject("DataClass:DSub")
		
		val items = newArrayList()
		items += ac.eContents.filter[!(it instanceof ExternalPort)]
		items += dc.eContents
		Assert.assertEquals("Unexpected item count", 13, items.size)
		items.forEach[
			Assert.assertTrue("expected name error: " + it, it.hasNameErrorMessage)
		]
	}

	@Test
	def void FlatNames() {
		val ac = res.getEObject("ActorClass:Flat")
		val dc = res.getEObject("DataClass:DFlat")
		val lc = res.getEObject("DataClass:LFlat")
		val sc = res.getEObject("DataClass:SFlat")
		val enum = res.getEObject("DataClass:EnumFlat")
		
		val items = newArrayList
		items += ac.eContents.filter[!(it instanceof ExternalPort)]
		items += dc.eContents
		items += lc.eContents
		items += sc.eContents
		items += enum.eContents
		Assert.assertEquals("Unexpected item count", 16, items.size)
		items.forEach[
			Assert.assertTrue("expected name error: " + it, it.hasNameErrorMessage)
		]
	}
	
	private def boolean hasNameErrorMessage(EObject obj){
		nameErrorMap.containsKey(obj) && nameErrorMap.get(obj)
	}

	protected def boolean isNameErrorMessage(Diagnostic diag) {
		val message = diag.message
		return diag.severity >= Diagnostic.ERROR && (message.contains("Duplicate name") || (message.contains("Name") && message.contains("is already assigned to")))
	}
}
