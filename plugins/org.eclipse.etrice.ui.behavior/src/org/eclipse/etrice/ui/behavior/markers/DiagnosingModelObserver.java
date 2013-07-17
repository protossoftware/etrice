/*******************************************************************************
 * Copyright (c) 2013 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.markers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Trigger;
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
	private RoomModel roomModel;

	public DiagnosingModelObserver() {
		elementDiagnosticMap = new HashMap<EObject, ArrayList<Diagnostic>>();
	}

	/**
	 * Starts listening to changes of the given {@link RoomModel}.
	 * 
	 * @param roomModel
	 * @author jayant
	 */
	public void observeRoomModel(RoomModel roomModel) {
		// Start observing the room model
		this.roomModel = roomModel;
		setTarget(roomModel);

		// Validate and Populate HashMap for rendering markers initially.
		updateElementDiagonosticMap();
	}

	/**
	 * Stops observing the {@link RoomModel}.
	 * 
	 * @author jayant
	 */
	public void removeObserver() {
		unsetTarget(roomModel);
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
		// This prevents the editor to hang on dispose (since all adapters are
		// then removed).
		if (notification.getEventType() < Notification.REMOVING_ADAPTER) {
			updateElementDiagonosticMap();
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
	private void updateElementDiagonosticMap() {
		// Clear HashMap to remove orphaned element references
		elementDiagnosticMap.clear();

		// Perform Model Validation and get the diagnostic
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(roomModel);

		// Inspect each child diagnostic
		for (Diagnostic diagnostic : diagnostics.getChildren()) {

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
				if (elementDiagnosticMap.get(eObject) == null)
					elementDiagnosticMap.put(eObject,
							new ArrayList<Diagnostic>());
				elementDiagnosticMap.get(eObject).add(diagnostic);
			}
		}
	}
}