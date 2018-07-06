/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.editor;

import org.eclipse.etrice.ui.behavior.fsm.provider.GenModelProvider;
import org.eclipse.etrice.ui.behavior.fsm.provider.IInjectorProvider;
import org.eclipse.etrice.ui.common.base.editor.AbstractBaseDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramContainer;

/**
 * This class augments the AbstractDiagramTypeProvider to help manage 
 * functionality provided by {@link AbstractFSMEditor}. Diagram editor plugins 
 * that extend {@link AbstractFSMEditor} should also extend and use this class.
 */
public abstract class AbstractFSMDiagramTypeProvider extends AbstractBaseDiagramTypeProvider implements IInjectorProvider {
	
	public GenModelProvider getGenModelProvider() {
		// create always new one for now
//		Stopwatch timer = Stopwatch.createStarted();
//		GenModelProvider genModelProvider = new GenModelProvider(this);
//		System.out.println(timer.stop().elapsed(TimeUnit.MILLISECONDS));	
		return new GenModelProvider(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#resourceReloaded(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public void resourceReloaded(Diagram diagram) {
		super.resourceReloaded(diagram);
		IDiagramContainer dgContainer = this.getDiagramBehavior().getDiagramContainer();
		if(dgContainer instanceof AbstractFSMEditor)
		{
			((AbstractFSMEditor)dgContainer).attachDiagnosingModelObserver();
		}
	}
}
