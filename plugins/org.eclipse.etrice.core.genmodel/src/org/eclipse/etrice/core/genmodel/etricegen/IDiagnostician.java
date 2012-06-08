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
