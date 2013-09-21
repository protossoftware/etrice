/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.part.FileEditorInput;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ChangeDiagramInputJob extends Job {
	
	@Inject
	private ILabelProvider roomLabelProvider;
	
	private Diagram diagram;
	private RoomDiagramEditor editor;
	private boolean close, saveOnClose, reOpen;
	
	private IFile roomFile;
	private StructureClass sc;
	
	public ChangeDiagramInputJob(String name, RoomDiagramEditor editor) {
		super(name);
		this.editor = editor;
		
		Injector injector = RoomUiModule.getInjector();
		injector.injectMembers(this);
		
		diagram = editor.getDiagramTypeProvider().getDiagram();
		close = saveOnClose = reOpen = true;
	}
	
	public ChangeDiagramInputJob(String name, RoomDiagramEditor editor, boolean close, boolean saveOnClose, boolean reOpen) {
		this(name, editor);
		this.close = close;
		this.saveOnClose = saveOnClose;
		this.reOpen = reOpen;
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		
		URI diagramURI = diagram.eResource().getURI().trimFragment();
		final IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(diagramURI.toPlatformString(true)));
		IContainer diagramFolder = diagramFile.getParent();
		
		// find room files in parent model folder
		final IContainer modelFolder = diagramFolder.getParent();
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				roomFile = selectRoomFile(modelFolder);
			}
		});
		if(roomFile == null)
			return Status.OK_STATUS;
		
		URI newRoomURI = URI.createPlatformResourceURI(roomFile.getFullPath().toString(), false);
		ResourceSet rs = new ResourceSetImpl();
		Resource roomRes = rs.getResource(newRoomURI, true);
		EObject rootEObject = roomRes.getContents().iterator().next();
		if(!(rootEObject instanceof RoomModel))
			return Status.OK_STATUS;
		
		// select a structure class
		final RoomModel roomModel = (RoomModel) rootEObject;
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				sc = selectSc(roomModel);
			}
		}); 
		if(sc == null)
			return Status.OK_STATUS;
		
		// close diagram to avoid exception and bad update (graphiti bug ?)
		Runnable closeDiagramRunnable = new Runnable() {
			
			@Override
			public void run() {
				IWorkbenchWindow workbench = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				workbench.getActivePage().closeEditor(editor, saveOnClose);
			}
		};
		if(close)
			Display.getDefault().syncExec(closeDiagramRunnable);
		
		// new
		String newScName = sc.getName();
		String newDiagramName = roomModel.getName()+"."+newScName+"."+diagramURI.fileExtension();
		IPath newDiagramPath = diagramFile.getFullPath().removeLastSegments(1).append(newDiagramName);
		URI newDiagramURI = URI.createPlatformResourceURI(newDiagramPath.toString(), false);
		
		// old
		EObject oldDiagramSc = diagram.getLink().getBusinessObjects().iterator().next();
		URI oldScURI = EcoreUtil.getURI(oldDiagramSc);
		String oldScName = oldScURI.fragment().substring(oldScURI.fragment().indexOf(':') + 1).trim();
		URI oldRoomURI = oldScURI.trimFragment();
		
		// rename diagram
		if(!diagramURI.equals(newDiagramURI))
			try {
				diagramFile.move(newDiagramPath, false, monitor);
			}
			catch (CoreException e) {
				showError(e.getMessage());
				e.printStackTrace();
				return Status.CANCEL_STATUS;
			}
		
		// change uri and name to old one from diagram
		roomRes.setURI(oldRoomURI);
		sc.setName(oldScName);
		
		// resolve cross references
		Resource diagramRes = rs.getResource(newDiagramURI, true);
		EcoreUtil.resolveAll(diagramRes);
		
		// undo
		roomRes.setURI(newRoomURI);
		sc.setName(newScName);
		
		// save only diagram to change cross references and file name
		try {
			diagramRes.save(null);
		} catch (IOException e) {
			showError(e.getMessage());
			e.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		
		// reopen diagram
		final IFile newDiagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(newDiagramPath);
		Runnable openDiagramRunnable = new Runnable() {
			
			@Override
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorDescriptor desc = PlatformUI.getWorkbench().
				        getEditorRegistry().getDefaultEditor(newDiagramFile.getName());
				try {
					page.openEditor(new FileEditorInput(newDiagramFile), desc.getId());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		if(reOpen)
			Display.getDefault().asyncExec(openDiagramRunnable);
		
		return Status.OK_STATUS;
	}
	
	private void showError(final String message){
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Operation Failed", message);
			}
		});
	}

	private IFile selectRoomFile(IContainer container){
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(shell, false, container, IResource.FILE);
		
		// TODO: show only room files that are direct children of model folder (depth 1)
		dialog.setMessage("Select a ROOM file");
		dialog.setInitialPattern(".room");
		
		if(dialog.open() == Window.OK)
			return (IFile) dialog.getFirstResult();
		
		return null;
	}
	
	private StructureClass selectSc(RoomModel model){
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, roomLabelProvider);
		dialog.setMultipleSelection(false);
		dialog.setMessage("Select a new ROOM class");
		dialog.setFilter("*");
		dialog.setElements(getElements(model).toArray());
		
		if(dialog.open()==Window.OK)
			return (StructureClass) dialog.getFirstResult();
		
		return null;
	}

	protected List<StructureClass> getElements(RoomModel model){
		List<StructureClass> elements = new ArrayList<StructureClass>();
		elements.addAll(model.getActorClasses());
		elements.addAll(model.getSubSystemClasses());
		elements.addAll(model.getSystems());
		
		return elements;
	}

}
