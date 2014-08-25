/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class NullDiagnostician implements IDiagnostician {

	private boolean failed = false;
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician#warning(java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	public void warning(String msg, EObject source, EStructuralFeature feature) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician#warning(java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, int)
	 */
	@Override
	public void warning(String msg, EObject source, EStructuralFeature feature, int idx) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician#error(java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	public void error(String msg, EObject source, EStructuralFeature feature) {
		error(msg, source, feature, -1);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician#error(java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, int)
	 */
	@Override
	public void error(String msg, EObject source, EStructuralFeature feature, int idx) {
		failed = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician#isFailed()
	 */
	@Override
	public boolean isFailed() {
		return failed;
	}

}
