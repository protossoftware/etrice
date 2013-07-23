/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class ModificationTrackingEnabler extends ResourceSetListenerImpl {
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#setTarget(org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	public void setTarget(TransactionalEditingDomain domain) {
		super.setTarget(domain);
		
		setTrackingModification();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
	 */
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		super.resourceSetChanged(event);
		
		setTrackingModification();
	}
	
	protected void setTrackingModification() {
		ResourceSet rs = getTarget().getResourceSet();
		for (Resource r : rs.getResources()) {
			if (!r.isTrackingModification())
				r.setTrackingModification(true);
		}
	}
}
