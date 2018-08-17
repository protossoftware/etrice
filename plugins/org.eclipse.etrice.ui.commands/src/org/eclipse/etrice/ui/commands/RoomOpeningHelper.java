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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.commands;

import java.util.function.Predicate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.base.editor.AbstractBaseDiagramTypeProvider;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.xtext.ui.shared.Access;

public class RoomOpeningHelper {

	static private final String BEHAVIOR_DTP = "org.eclipse.etrice.ui.behavior.diagramTypeProvider";
	static private final String STRUCTURE_DTP = "org.eclipse.etrice.ui.structure.diagramTypeProvider";
	
	static public void openBehavior(EObject object) {
		if (object instanceof ActorClass) {
			ActorClass ac = (ActorClass) object;
			boolean hasManualBehavior = ac.getBehaviorAnnotations().parallelStream().anyMatch(new Predicate<Annotation>() {

				@Override
				public boolean test(Annotation annotation) {
					return annotation.getType() != null && "BehaviorManual".equals(annotation.getType().getName());
				}
			});
			if (hasManualBehavior) {
				showInTextualEditor(ac);
			} else {
				getBehaviorDiagramAccess().openDiagramEditor(ac);
			}
		}
	}
	
	static public void openStructure(EObject object) {
		if(object instanceof StructureClass){
			getStructureDiagramAccess().openDiagramEditor(object);
		}
	}

	static public void showInTextualEditor(EObject object) {
		URI uri = (object != null) ? EcoreUtil.getURI(object) : null;
		if (uri != null) {
			Access.getIURIEditorOpener().get().open(uri, true);
		}
	}
	
	static public DiagramAccessBase getBehaviorDiagramAccess() {
		return getDiagramAccess(BEHAVIOR_DTP);
	}
	
	static public DiagramAccessBase getStructureDiagramAccess() {
		return getDiagramAccess(STRUCTURE_DTP);
	}
	
	static DiagramAccessBase getDiagramAccess(String providerId) {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(providerId);
		if(dtp instanceof AbstractBaseDiagramTypeProvider) {
			return ((AbstractBaseDiagramTypeProvider) dtp).getDiagramAccess();
		}
		
		return null;
	}

}
