/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrentz (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.validation

import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import com.google.common.base.Function

/**
 * @author hrentz
 *
 */
class ValidationHelpers {

	public static class NamedObject {
		@Property String name
		@Property EObject obj
		@Property EStructuralFeature feature

		new(String name, EObject obj, EStructuralFeature feature) {
			this.name = name
			this.obj = obj
			this.feature = feature
		}
	}

	public static class NamedObjectList extends ArrayList<NamedObject> {
		def addAll(List<? extends EObject> items, EStructuralFeature feature) {
			items.forEach[this.add(new NamedObject(it.eGet(feature) as String, it, feature))]
		}
	}

	def static Iterable<NamedObject> removeUniques(List<NamedObject> items) {
		val Set<String> allOfName = newHashSet
		val Set<String> duplicateNames = newHashSet

		// first sweep: determine duplicate names
		for (i : items) {

			// if the name already occurred we have a duplicate name and hence an error
			if (allOfName.contains(i.name)) {
				duplicateNames.add(i.name)
			}
			else {
				allOfName.add(i.name);
			}
		}

		// second sweep: remove duplicates
		items.filter(i|duplicateNames.contains(i.name))
	}
	
	def static Iterable<NamedObject> inSameResource(Iterable<NamedObject> items, Resource resource) {
		items.filter(i|i.obj.eResource==resource)
	}
	
	/**
	 * Visitor for inheritance, safeguards from null, eProxy and circular issues.
	 * 
	 * @param start EObject, may be null
	 * @param function return null to exit
	 */
	def static <E extends EObject> saveRecursiveVisitor(E  start, Function<E , E> function){
		val Set<E> visited = newHashSet
		var E next = start
		while(next != null && !next.eIsProxy && (visited += next))
			next = function.apply(next)
	}
}
