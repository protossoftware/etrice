/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui;

import org.eclipse.etrice.core.common.ui.modelpath.ModelPathChangeListener;
import org.eclipse.etrice.core.common.ui.modelpath.ModelPathResourceSetInitializer;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @see org.eclipse.xtext.ui.shared.sharedStateContributingModule
 */
public class SharedContributionModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IEagerContribution.class).to(ModelPathChangeListener.class);
		binder.bind(IResourceSetInitializer.class).to(ModelPathResourceSetInitializer.class);
	}
	
}