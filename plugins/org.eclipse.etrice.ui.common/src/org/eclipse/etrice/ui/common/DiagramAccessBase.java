/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class DiagramAccessBase {

	public static final String DIAGRAMS_FOLDER_NAME = "diagrams";
	
	/**
	 * 
	 */
	public DiagramAccessBase() {
		super();
	}

	public Diagram getDiagram(StructureClass sc) {
		Resource resource = sc.eResource();
		if (resource==null)
			return null;
		
		URI uri = resource.getURI();
		
		String modelName = ((RoomModel) sc.eContainer()).getName();
		
		URI diagURI = null;
		boolean exists = false;
		if (uri.isPlatformResource()) {
			uri = uri.trimSegments(1);
			IFolder parentFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(uri.toPlatformString(true)));
	
			IFolder diagramFolder = parentFolder.getFolder(DIAGRAMS_FOLDER_NAME);
			
			IFile diagramFile = diagramFolder.getFile(modelName+"."+sc.getName()+getFileExtension());
			diagURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			exists = diagramFile.exists();
		}
		else {
			File diagramFile = new File(uri.toFileString());
			diagramFile = new File(diagramFile.getParent()
					+File.separator+DIAGRAMS_FOLDER_NAME
					+File.separator+modelName+"."+sc.getName()+getFileExtension());
			diagURI = URI.createFileURI(diagramFile.getPath());
			exists = diagramFile.exists();
		}
		
		ResourceSet rs = new ResourceSetImpl();
		if (exists) {
			Resource diagRes = rs.getResource(diagURI, true);
			if (diagRes.getContents().isEmpty())
				return null;
			if (diagRes.getContents().get(0) instanceof Diagram) {
				Diagram diagram = (Diagram) diagRes.getContents().get(0);
				updateDiagram(diagram, false);
				return diagram;
			}
		}
		else {
			Resource diagRes = rs.createResource(diagURI);
			
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			boolean snap = store.getBoolean(PreferenceConstants.SNAP_TO_GRID);
			boolean useGrid = store.getBoolean(PreferenceConstants.USE_GRID);
			int horUnit = useGrid? store.getInt(PreferenceConstants.HOR_GRID_UNIT) : 0;
			int verUnit = useGrid? store.getInt(PreferenceConstants.VER_GRID_UNIT) : 0;
			
			Diagram diagram = Graphiti.getPeCreateService().createDiagram(
					getDiagramTypeId(),
					getDiagramName(sc),
					horUnit,
					verUnit,
					snap);
			diagRes.getContents().add(diagram);
			
			populateDiagram(sc, diagram);
			
			try {
				diagRes.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return diagram;
		}
		
		return null;
	}

	private void populateDiagram(StructureClass ac, Diagram diagram) {
		ResourceSet rs = diagram.eResource().getResourceSet();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rs);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
		}
	
		// IMPORTANT STEP: this resolves the object and creates a new resource in the resource set
		URI boUri = EcoreUtil.getURI(ac);
		ac = (StructureClass) editingDomain.getResourceSet().getEObject(boUri, true);
		
		editingDomain.getCommandStack().execute(getInitialCommand(ac, diagram, editingDomain));
		editingDomain.dispose();
	}

	/**
	 * @param diagram
	 */
	private void updateDiagram(Diagram diagram, boolean doSave) {
		ResourceSet rs = diagram.eResource().getResourceSet();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rs);
		try {
			if (editingDomain == null) {
				// Not yet existing, create one and start a write transaction
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
				((TransactionalEditingDomainImpl)editingDomain).startTransaction(false, null);
			}
			
			Command updateCommand = getUpdateCommand(diagram, editingDomain);
			if (updateCommand!=null) {
				editingDomain.getCommandStack().execute(updateCommand);
				
				if (doSave) {
					try {
						diagram.eResource().save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (InterruptedException e) {
		}
		
		editingDomain.dispose();
	}

	public RoomDiagramEditor findDiagramEditor(StructureClass sc) {
		IFileEditorInput input = getEditorInput(sc);
	
		return (RoomDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);
	}

	public RoomDiagramEditor openDiagramEditor(StructureClass sc) {
		IFileEditorInput input = getEditorInput(sc);
	
		try {
			return (RoomDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, getEditorId());
		} catch (PartInitException e) {
			String error = "Error while opening diagram editor";
			System.err.println(error);
		}
		return null;
	}

	private IFileEditorInput getEditorInput(StructureClass sc) {
		Diagram diagram = getDiagram(sc);
		
		URI uri = diagram.eResource().getURI();
		String platformString = null;
		if (uri.isPlatform()) {
			platformString = uri.toPlatformString(true);
		}
		else {
			uri = GlobalNonPlatformURIEditorOpener.getPlatformURI(uri);
			platformString = uri.toPlatformString(true);
		}
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
		IFileEditorInput input = new FileEditorInput(file);
		return input;
	}

	public abstract String getDiagramName(StructureClass sc);
	abstract protected String getFileExtension();
	abstract protected String getDiagramTypeId();
	abstract protected String getEditorId();
	abstract protected Command getInitialCommand(StructureClass ac, Diagram diagram, TransactionalEditingDomain editingDomain);
	abstract protected Command getUpdateCommand(Diagram diagram, TransactionalEditingDomain editingDomain);
}