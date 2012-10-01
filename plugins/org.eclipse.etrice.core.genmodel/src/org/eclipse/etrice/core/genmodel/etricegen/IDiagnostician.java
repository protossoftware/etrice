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

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface IDiagnostician {

	static final int INSIGNIFICANT_INDEX = -1;
	
	void warning(String msg, EObject source, EStructuralFeature feature);
	void warning(String msg, EObject source, EStructuralFeature feature, int idx);
	void error(String msg, EObject source, EStructuralFeature feature);
	void error(String msg, EObject source, EStructuralFeature feature, int idx);
	
	boolean isFailed();
}
