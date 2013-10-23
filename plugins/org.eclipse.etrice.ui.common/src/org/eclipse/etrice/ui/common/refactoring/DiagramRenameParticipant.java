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

package org.eclipse.etrice.ui.common.refactoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.ui.common.DiagramAccessBase;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.FileStatusContext;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class DiagramRenameParticipant extends RenameParticipant {

	private URI roomURI;
	private List<IFile> diagramFiles;
	
	private static String[] diagramExtensions;
	private static String[] diagramEditorsIds;
	
	static {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.etrice.ui.common.refactoring.rename");
		diagramExtensions = new String[elements.length];
		diagramEditorsIds = new String[elements.length];
		for(int i=0;i<elements.length;i++){
			diagramExtensions[i] = elements[i].getAttribute("diagram_extension");
			diagramEditorsIds[i] = elements[i].getAttribute("editor_id");
		}
	}
	
	public DiagramRenameParticipant(){
		this.diagramFiles = new ArrayList<IFile>();
	}
	
	@Override
	protected boolean initialize(Object element) {		
		IFile roomFile = (IFile) element;
		IFolder diagramFolder = roomFile.getParent().getFolder(new Path(DiagramAccessBase.DIAGRAMS_FOLDER_NAME));
		
		if(!diagramFolder.exists())
			return false;
		
		// find all diagrams in diagram folder
		final  List<IFile> allDiagrams = new ArrayList<IFile>();
		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {
						
			@Override
			public boolean visit(IResourceProxy proxy) throws CoreException {
				for(String extension : diagramExtensions)
					if(proxy.getName().endsWith(extension))
						allDiagrams.add((IFile) proxy.requestResource());
				
				return true;
			}
		};
		try {
			diagramFolder.accept(visitor, IResource.DEPTH_ONE, IResource.FILE);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		
		// select diagrams that point to roomFile
		roomURI = URI.createPlatformResourceURI(roomFile.getFullPath().toString(), false);
		ResourceSet rs = new ResourceSetImpl();
		for(IFile diagramFile : allDiagrams){
			URI diagramURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), false);
			Resource res = rs.getResource(diagramURI, true);
			EObject obj = res.getContents().iterator().next();
			if(obj instanceof Diagram){
				Diagram diagram = (Diagram) obj;
				if(diagram.getLink().getBusinessObjects().isEmpty())
					continue;
				URI boURI = EcoreUtil.getURI(diagram.getLink().getBusinessObjects().iterator().next());
				if(roomURI.equals(boURI.trimFragment()))
					diagramFiles.add(diagramFile);
			}
		}
		
		return !diagramFiles.isEmpty();
	}

	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {
				
		// collect open diagrams
		final RefactoringStatus status = RefactoringStatus.create(Status.OK_STATUS);
		final List<IFile> toIgnore = new ArrayList<IFile>();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				for(IFile diagramFile : diagramFiles)
					if(isDiagramEditorOpen(diagramFile, page))
						toIgnore.add(diagramFile);
			}
		};
		Display.getDefault().syncExec(runnable);
		
		/* Issues:
		 * - after renaming open diagram causes exception and bad update (graphiti bug ?)
		 * - saving diagram here can cause deadlock somehow
		 */
		
		// print warning and ignore
		for(IFile diagramFile : toIgnore){
			diagramFiles.remove(diagramFile);
			status.addWarning("Cannot update open diagram " + diagramFile.getName(), new FileStatusContext(diagramFile, null));
		}
		
		return status;
	}	
	
	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		
		if(diagramFiles.isEmpty())
			return new NullChange();
		
		URI oldURI = roomURI;
		String newFileName = getArguments().getNewName();
		URI newURI = oldURI.trimSegments(1).appendSegment(newFileName);
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResource(oldURI, true);
		CompositeChange compositeChange = new DiagramCompositeChange(oldURI, newURI, rs);
		
		for(IFile diagramFile : diagramFiles){
			URI diagramURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), false);
			Resource diagramRes = rs.getResource(diagramURI, true);
			compositeChange.add(new DiagramUpdateChange(diagramRes));
		}
		
		return compositeChange;
		
	}
	
	/**
	 *  has to be executed in ui thread
	 */
	private boolean isDiagramEditorOpen(IFile input, IWorkbenchPage page){
		IEditorInput editorInput = new FileEditorInput(input);
		for(String editorId : diagramEditorsIds){
			IEditorReference[] editorRefs = page.findEditors(editorInput, editorId, IWorkbenchPage.MATCH_ID|IWorkbenchPage.MATCH_INPUT);
			if (editorRefs.length > 0)
				return true;
		}
		
		return false;
	}
	
	private class DiagramCompositeChange extends CompositeChange{
		
		private URI oldURI, newURI;
		private ResourceSet rs;
		
		public DiagramCompositeChange(URI oldURI, URI newURI, ResourceSet rs) {
			super("Update Diagrams");
			this.oldURI = oldURI;
			this.newURI = newURI;
			this.rs = rs;
		}
		
		public DiagramCompositeChange(URI oldURI, URI newURI, ResourceSet rs, Change[] childUndos) {
			super("Update Diagrams", childUndos);
			this.oldURI = oldURI;
			this.newURI = newURI;
			this.rs = rs;
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			Resource roomRes = rs.getResources().get(0);
			
			// resolve all cross references
			EcoreUtil.resolveAll(rs);
			
			// change uri of room objects
			roomRes.setURI(newURI);
			
			// perform child changes (and create undo changes):
			// save only diagrams to change cross references
			Change undoChange = super.perform(pm);
			
			return undoChange;
		}
		
		
		@Override
		protected Change createUndoChange(Change[] childUndos) {
			return new DiagramCompositeChange(newURI, oldURI, rs, childUndos);
		}
		
		
		@Override
		protected boolean internalContinueOnCancel() {
			return true;
		}
		
	}
	
	/**
	 * does diagramRes.save(null);
	 */
	private class DiagramUpdateChange extends ResourceChange{

		Resource diagramRes;
		
		public DiagramUpdateChange(Resource diagramRes){
			super();
			this.diagramRes = diagramRes;
			
			setValidationMethod(VALIDATE_NOT_DIRTY);
		}
		
		@Override
		public RefactoringStatus isValid(IProgressMonitor pm)
				throws CoreException, OperationCanceledException {
			
			// ResourceChange valid ?
			final RefactoringStatus status = super.isValid(pm);
			if(status.hasFatalError())
				return status;
			
			// diagram open ?
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					if(isDiagramEditorOpen((IFile) getModifiedResource(), page))
						status.addFatalError("Diagram " + diagramRes.getURI().lastSegment() + " is open");	
				}
			};
			Display.getDefault().syncExec(runnable);
			
			// resource still loaded ?
			if(!diagramRes.isLoaded())
				status.addFatalError("Expired");
			
			return status;
		}
		
		@Override
		protected IResource getModifiedResource() {
			IPath path = new Path(diagramRes.getURI().toPlatformString(false));
			return ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		}

		@Override
		public String getName() {
			return "Update references";
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			// save diagram resource to change cross references
			try {
				diagramRes.save(null);
			} catch (IOException e) {
				e.printStackTrace();
				throw new CoreException(Status.CANCEL_STATUS);
			}
			
			return new DiagramUpdateChange(diagramRes);
		}
		
	}

}
