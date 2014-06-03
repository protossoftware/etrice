/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.serializer;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.xtext.serializer.sequencer.LegacyTransientValueService;

/**
 * Bug: sometimes xtext does not serialize the default values of required rules
 */
public class ETPhysTransientValueService extends LegacyTransientValueService {

	// Serialize default values of features
	protected Set<EStructuralFeature> features;

	public ETPhysTransientValueService() {
		features = new HashSet<EStructuralFeature>();
		features.add(ETPhysPackage.Literals.NODE_CLASS__PRIOMAX);
		features.add(ETPhysPackage.Literals.NODE_CLASS__PRIOMIN);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__EXECMODE);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__MSGBLOCKSIZE);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__MSGPOOLSIZE);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__PRIO);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__STACKSIZE);
		features.add(ETPhysPackage.Literals.PHYSICAL_THREAD__TIME);
		features.add(ETPhysPackage.Literals.RUNTIME_CLASS__THREAD_MODEL);
	}

	@Override
	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature) {
		if (!feature.isTransient() && features.contains(feature)) {
			// hide interval if thread is blocked
			if (feature.equals(ETPhysPackage.Literals.PHYSICAL_THREAD__TIME)
					&& ((PhysicalThread) semanticObject).getExecmode() == ExecMode.BLOCKED)
				return ValueTransient.YES;
			return ValueTransient.NO;
		}

		return super.isValueTransient(semanticObject, feature);
	}

}
