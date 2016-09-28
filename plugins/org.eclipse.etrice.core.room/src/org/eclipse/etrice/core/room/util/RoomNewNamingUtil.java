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

package org.eclipse.etrice.core.room.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.validation.ValidationHelpers;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.util.FSMNewNamingUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @see FSMNewNamingUtil
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomNewNamingUtil extends FSMNewNamingUtil {

	@Inject protected IQualifiedNameProvider fqnProvider;	

	/**
	 * @param prefix a prefix (e.g. to distinguish ports, SAPs, SPPs)
	 * @param acc a {@link ActorContainerClass}
	 * @return a unique name for a new {@link InterfaceItem} of the actor container class
	 */
	public String getUniqueName(String prefix, StructureClass sc) {
		final Set<String> names = getAllNamesFromCompleteHierarchy(sc);
		
		for (int i = 0; i < 1000; i++) {
			String name = prefix+i;
			if (!names.contains(name))
				return name;
		}
		
		return "not_unique";
	}
	
	/**
	 * @see FSMNewNamingUtil#getAllNamesFromCompleteHierarchy(StateGraph)
	 */
	private Set<String> getAllNamesFromCompleteHierarchy(StructureClass sc){
		final HashSet<StructureClass> visitedClass = Sets.newHashSet(sc);
		final HashSet<StructureClass> leafClass = Sets.newHashSet(sc);
		final LinkedList<StructureClass> stack = Lists.newLinkedList();
		stack.push(sc);

		// fix point iteration to find all derived class
		while (!stack.isEmpty()) {
			StructureClass baseClass = stack.pop();
			Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(baseClass, sc.eResource().getResourceSet());
			for (Setting setting : usages) {
				StructureClass derivedClass = null;
				if (setting.getEStructuralFeature() == FSMPackage.Literals.MODEL_COMPONENT__BASE)
					if(setting.getEObject() instanceof StructureClass)
						derivedClass = ((StructureClass) setting.getEObject());

				if (derivedClass != null && visitedClass.add(derivedClass)) {
					stack.push(derivedClass);
					leafClass.add(derivedClass);
					leafClass.remove(baseClass);
				}
			}
		}
		
		final Set<String> allNames = Sets.newHashSet();
		// gather all named elements of super classes
		for(StructureClass toVisit : leafClass){
			ValidationHelpers.saveRecursiveVisitor(toVisit, new Function<StructureClass, StructureClass>(){
	
				@Override
				public StructureClass apply(StructureClass input) {
					for (EObject containee : input.eContents()) {
						QualifiedName qualifiedName = fqnProvider.apply(containee);
						String name = (qualifiedName != null) ? qualifiedName.getLastSegment() : null;
						if (name != null)
							allNames.add(name);
					}
					return (input instanceof ActorClass) ? ((ActorClass) input).getActorBase() : null;
				}});
		}
		
		return allNames;
	}

}
