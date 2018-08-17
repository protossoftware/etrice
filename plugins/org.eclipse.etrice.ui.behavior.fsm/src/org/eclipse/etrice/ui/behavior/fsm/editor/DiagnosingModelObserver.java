/*******************************************************************************
 * Copyright (c) 2013 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * An {@link EContentAdapter} which validates the {@link RoomModel} on each
 * change notification and stores the results of validation in a {@link HashMap}
 * of model elements and associated {@link Diagnostic}s.
 * 
 * @author jayant
 */
public class DiagnosingModelObserver extends EContentAdapter {

	/**
	 * A {@link HashMap} for storing {@link Diagnostic}s keyed on the model
	 * elements they belong to.
	 */
	private HashMap<EObject, ArrayList<Diagnostic>> elementDiagnosticMap;

	/**
	 * The {@link RoomModel} being observed.
	 */
	private EObject mdel;

	private boolean enabled;

	public DiagnosingModelObserver() {
		elementDiagnosticMap = new HashMap<EObject, ArrayList<Diagnostic>>();
	}

	/**
	 * @param enable diagnostics updates due to change notifications
	 */
	public void enable() {
		this.enabled = true;
	}
	
	/**
	 * @param disable diagnostics updates due to change notifications
	 */
	public void disable() {
		this.enabled = false;
	}

	/**
	 * @return whether the observer is enabled (i.e. whether change notifications will update the diagnostics) 
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * Starts listening to changes of the given {@link RoomModel}.
	 * 
	 * @param model
	 * @author jayant
	 */
	public void observeModel(EObject model) {
		// Start observing the room model
		this.mdel = model;
		setTarget(model);
		enable();

		// Validate and Populate HashMap for rendering markers initially.
		updateElementDiagnosticMap();
	}

	/**
	 * Stops observing the {@link RoomModel}.
	 * 
	 * @author jayant
	 */
	public void removeObserver() {
		disable();
		elementDiagnosticMap.clear();
		if(mdel != null) {
			unsetTarget(mdel);
			mdel = null;
		}
	}

	/**
	 * {@inheritDoc} Updates elementDiagnosticMap on each notification (except
	 * Adapter Removal)
	 * 
	 * @author jayant
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		// Re-Validate on each notification except Adapter Removal.
		// This prevents the editor to hang on dispose (since all adapters are then removed).
		if (notification.getEventType() < Notification.REMOVING_ADAPTER) {
			if(!(notification.getNewValue() instanceof EObject) || notification.getNewValue() instanceof DetailCode) {
				// Bug 531689: skip validation when user is typing in DetailCode or text field to prevent delay
			} else {
				updateElementDiagnosticMap();
			}
		}
	}

	public HashMap<EObject, ArrayList<Diagnostic>> getElementDiagonsticMap() {
		return elementDiagnosticMap;
	}

	/**
	 * Updates the elementDiagnosticMap by re-validating the model.
	 * 
	 * @author jayant
	 */
	private void updateElementDiagnosticMap() {
		if(!isEnabled()) return;
		
		// Clear HashMap to remove orphaned element references
		elementDiagnosticMap.clear();

		// Perform Model Validation and get the diagnostic
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(mdel);

		// A local HashMap for ensuring uniqueness of diagnostics
		HashMap<EObject, HashSet<String>> uniqueEnsurer = new HashMap<EObject, HashSet<String>>();
		uniqueEnsurer.clear();

		// Inspect each child diagnostic
		for (Diagnostic diagnostic : diagnostics.getChildren()) {
			if (diagnostic instanceof FeatureBasedDiagnostic) {
				// for each child diagnostic, find the associated EObject
				FeatureBasedDiagnostic featureBasedDiagnostic = (FeatureBasedDiagnostic) diagnostic;
				EObject source = featureBasedDiagnostic.getSourceEObject();
				
				EObject eObject = null;
				if (source instanceof StateGraph) {
					EStructuralFeature feature = featureBasedDiagnostic
							.getFeature();
					int index = featureBasedDiagnostic.getIndex();
					
					if (!feature.isMany())
						eObject = (EObject) source.eGet(feature);
					else if (index != ValidationMessageAcceptor.INSIGNIFICANT_INDEX) {
						List<?> list = (List<?>) source.eGet(feature);
						eObject = (EObject) list.get(index);
					}
				} else if (source instanceof Trigger)
					eObject = source.eContainer();
				else
					eObject = source;
				
				if (eObject != null) {
					// Add diagnostic to elementDiagnosticMap keyed on model element
					if (elementDiagnosticMap.get(eObject) == null){
						elementDiagnosticMap.put(eObject,
								new ArrayList<Diagnostic>());
						uniqueEnsurer.put(eObject, new HashSet<String>());
					}
					
					//Insert only if the Diagnostic reports a new error/warning  
					String certificate = featureBasedDiagnostic.getIssueCode();
					for(String data : featureBasedDiagnostic.getIssueData())
						certificate += data;
					if (!(uniqueEnsurer.get(eObject).contains(certificate))){
						uniqueEnsurer.get(eObject).add(certificate);
						elementDiagnosticMap.get(eObject).add(diagnostic);
					}
				}
			}
		}
	}
}