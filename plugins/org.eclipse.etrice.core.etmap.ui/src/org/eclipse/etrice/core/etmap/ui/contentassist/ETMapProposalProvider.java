/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.etmap.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.contentassist.ImportModelAssist;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ETMapProposalProvider extends AbstractETMapProposalProvider {

	@Override
	public void completeImport_ImportedNamespace(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupImportedNamespace(model, context, acceptor, RoomPackage.eINSTANCE.getLogicalSystem(), ETPhysPackage.eINSTANCE.getPhysicalSystem());
	}
	
	@Override
	public void completeImport_ImportURI(EObject model, Assignment assignment,
			final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		ImportModelAssist.addPaths(this, context, acceptor, ".room");
		ImportModelAssist.addPaths(this, context, acceptor, ".etphys");
	}
	
}
