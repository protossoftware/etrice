/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DeleteWithoutConfirmFeature extends DefaultDeleteFeature {

	public DeleteWithoutConfirmFeature(IFeatureProvider fp) {
		super(fp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.features.DefaultDeleteFeature#getUserDecision(org.eclipse.graphiti.features.context.IDeleteContext)
	 */
	@Override
	protected boolean getUserDecision(IDeleteContext context) {
		IPreferenceStore store = UIBaseActivator.getDefault().getPreferenceStore();
		boolean confirm = store.getBoolean(UIBasePreferenceConstants.CONFIRM_DELETE);
		return confirm? super.getUserDecision(context) : true;
	}
}
