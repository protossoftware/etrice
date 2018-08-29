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

package org.eclipse.etrice.ui.common.base.refactoring

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase
import org.eclipse.graphiti.mm.pictograms.Diagram
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor
import org.eclipse.xtext.ui.refactoring.impl.EmfResourceChangeUtil
import org.eclipse.xtext.ui.refactoring.impl.EmfResourceReferenceUpdater

/**
 *  Update diagrams in case of xtext rename refactoring
 */
class DiagramReferenceUpdater extends EmfResourceReferenceUpdater {
	
	@Inject DiagramAccessBase diagramAccess
	@Inject EmfResourceChangeUtil changeUtil

	
	override protected createReferenceUpdates(ElementRenameArguments elementRenameArguments, Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		
		//-- update references in diagrams
		super.createReferenceUpdates(elementRenameArguments, resource2references, resourceSet, updateAcceptor, monitor)
		
		//-- rename diagrams
		val diagramMap = ArrayListMultimap.create => [map |
			// there could be several (orphaned) diagrams for one ActorClass
			resource2references.keySet.map[uri | resourceSet.getResource(uri, false)].map[contents].flatten.filter(Diagram).forEach[diagram |
				map.put(diagram.link.businessObjects.head, diagram)
			]
		]
		elementRenameArguments.renamedElementURIs.map[origURI | resourceSet.getEObject(elementRenameArguments.getNewElementURI(origURI), false)].filter(ModelComponent).forEach[mc |
			val wsDiagrams = diagramMap.get(mc).filter[eResource.URI.isPlatformResource].toList
			val newFileName = diagramAccess.getDigramFileName(mc)
			
			val workspaceRoot = ResourcesPlugin.workspace.root
			val parents = wsDiagrams.groupBy[workspaceRoot.getFile(new Path(eResource.URI.segmentsList.tail.join('/'))).parent]
			parents.forEach[parent, diagrams | 
				// avoid file name conflicts => choose latest modified
				val diagram = diagrams.maxBy[eResource.timeStamp]
				val diagFile = workspaceRoot.getFile(new Path(diagram.eResource.URI.segmentsList.tail.join('/')))
				updateAcceptor.accept(diagram.eResource.URI, new RenameResourceChange(diagFile.fullPath, newFileName))
				// TODO update name of diagram
			]
		]
		
	}
	
}
