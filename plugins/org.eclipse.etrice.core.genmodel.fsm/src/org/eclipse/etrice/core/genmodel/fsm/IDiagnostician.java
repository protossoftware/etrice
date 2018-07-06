/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface IDiagnostician {

	/**
	 * A constant indicating that the index is not relevant or not applicable.
	 */
	static final int INSIGNIFICANT_INDEX = -1;
	
	/**
	 * Issue a warning on the source object associated with a structural feature,
	 * 
	 * @param msg the warning message
	 * @param source the offending object
	 * @param feature the feature that should be marked with the warning
	 */
	void warning(String msg, EObject source, EStructuralFeature feature);

	/**
	 * Issue a warning on the source object associated with a structural feature,
	 * 
	 * @param msg the warning message
	 * @param source the offending object
	 * @param feature the feature that should be marked with the warning
	 * @param idx the index if the feature has multiplicity>1
	 */
	void warning(String msg, EObject source, EStructuralFeature feature, int idx);
	
	/**
	 * Issue an error on the source object associated with a structural feature,
	 * 
	 * @param msg the error message
	 * @param source the offending object
	 * @param feature the feature that should be marked with the error
	 */
	void error(String msg, EObject source, EStructuralFeature feature);

	/**
	 * Issue a error on the source object associated with a structural feature,
	 * 
	 * @param msg the error message
	 * @param source the offending object
	 * @param feature the feature that should be marked with the error
	 * @param idx the index if the feature has multiplicity>1
	 */
	void error(String msg, EObject source, EStructuralFeature feature, int idx);
	
	/**
	 * @return <code>true</code> if at least one error has been issued before
	 */
	boolean isFailed();
}
