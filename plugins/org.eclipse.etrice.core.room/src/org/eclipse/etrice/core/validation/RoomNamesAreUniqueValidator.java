/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

import com.google.inject.Inject;

public class RoomNamesAreUniqueValidator extends NamesAreUniqueValidator {

	@Inject
	protected IQualifiedNameProvider fqnProvider;
	
	@Override
	public void checkUniqueNamesInResourceOf(EObject eObject) {		
		if (!(eObject instanceof RoomModel) && getContext() != null) {
			// restrict validation on current object's fqn
			QualifiedName restrictedFQN = fqnProvider.apply(eObject);
			if (restrictedFQN != null && restrictedFQN != QualifiedName.EMPTY)
				getContext().put(this, restrictedFQN);
		}

		// Every object is on global scope, thus delegate to NamesAreUniqueValidator
		// Validates only once per resource and #getContext()
		super.checkUniqueNamesInResourceOf(eObject);
	}

	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		if (acceptNamespace(object))
			super.acceptError(message, object, feature, index, code, issueData);
	}

	@Override
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		if (acceptNamespace(object))
			super.acceptError(message, object, offset, length, code, issueData);
	}

	protected boolean acceptNamespace(EObject eObject) {
		Map<Object, Object> context = getContext();
		if (context != null && context.containsKey(this)) {
			QualifiedName restrictedFQN = (QualifiedName) context.get(this);
			QualifiedName eObjectFQN = fqnProvider.apply(eObject);
			if (eObjectFQN != null){
				if(eObjectFQN.startsWith(restrictedFQN)){
					if(eObjectFQN.equals(restrictedFQN))
						return eObject == getCurrentObject();
					return true;
				}
			}
			
			return false;
		}

		return true;
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}
}
