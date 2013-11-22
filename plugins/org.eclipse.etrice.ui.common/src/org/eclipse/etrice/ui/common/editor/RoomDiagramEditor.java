/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.core.ui.editor.RoomEditor;
import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.etrice.ui.common.commands.ChangeDiagramInputJob;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.EditorInputAdapter;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public abstract class RoomDiagramEditor extends DiagramEditor implements IInputUriHolder {

	@Inject
	protected IResourceValidator resourceValidator;

	private SaveOnFocusLostListener partListener;
	
	private SuperClassListener superClassListener;
	
	private ModificationTrackingEnabler mte = new ModificationTrackingEnabler();

	private boolean showLostDiagramInputDialog = true;

	private URI inputUri;
	
	public RoomDiagramEditor() {
		super();
		
		Injector injector = RoomUiModule.getInjector();
		injector.injectMembers(this);
		
		TrayDialog.setDialogHelpAvailable(false);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DiagramEditor#createDiagramBehavior()
	 */
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new CustomDiagramBehavior(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DiagramEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		IEditorInput newInput = EditorInputAdapter.adaptToDiagramEditorInput(input);
		if (newInput instanceof IDiagramEditorInput)
			this.inputUri = ((IDiagramEditorInput) newInput).getUri();
		
		super.init(site, input);
	}
	
	@Override
	public void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
		ResourceSet resourceSet = getEditingDomain().getResourceSet();
		Map<EObject, Collection<Setting>> result = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
		if (!result.isEmpty())
			System.err.println("ERROR in diagram viewer: could not resolve all proxies!");

		mte.setTarget(getEditingDomain());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#dispose()
	 */
	@Override
	public void dispose() {
		mte.unsetTarget(getEditingDomain());

		getSite().getPage().removePartListener(partListener);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(superClassListener);
		superClassListener.dispose();
		
		super.dispose();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(final IProgressMonitor monitor) {
		ResourceSet rs = getEditingDomain().getResourceSet();
		for (Resource res : rs.getResources()) {
			if (res instanceof XtextResource) {
				if (!res.isLoaded()) {
					try {
						res.load(Collections.EMPTY_MAP);
					} catch (IOException e) {
						MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: couldn't load referenced resource "+res.getURI());
						return;
					}
				}
				if (res.isModified()) {

					XtextResource xres = (XtextResource) res;
					ISerializer serializer = xres.getSerializer();
					
					if (xres.getContents().isEmpty()) {
						MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: part of textual model is empty, can't save");
						return;
					}

					// HOWTO: call serializer to validate the concrete syntax
					// this throws an exception which is caught further up the stack
					// and a dialog will be displayed
					serializer.serialize(xres.getContents().get(0));
					
					List<Issue> result = resourceValidator.validate(res, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
						public boolean isCanceled() {
							return monitor.isCanceled();
						}
					});
					if (!result.isEmpty()) {
						boolean error = false;
						MultiStatus ms = new MultiStatus(Activator.PLUGIN_ID, Status.ERROR, "validation errors during diagram save", null);
						for (Issue issue : result) {
							if (issue.isSyntaxError() || issue.getSeverity()==Severity.ERROR) {
								ms.add(new Status(Status.ERROR, Activator.PLUGIN_ID, issue.getMessage()));
								error = true;
							}
						}
						if (error) {
							MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: model is invalid, can't save");
							Activator.getDefault().getLog().log(ms);
							return;
						}
					}
				}
			}
		}
		super.doSave(monitor);
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		partListener = new SaveOnFocusLostListener(this);
		getSite().getPage().addPartListener(partListener);
		
		superClassListener = new SuperClassListener(this);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(superClassListener);
		
		/* we have to save here whether changes have been done or not to get rid of the dirty state
		 * CAUTION: save in
		 * init(IEditorSite site, IEditorInput input)
		 * or
		 * setInput(IEditorInput input)
		 * did not work correctly
		 */
//		if (AutoUpdateFeature.isLastDoneChanges())
			doSave(new NullProgressMonitor());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#setFocus()
	 */
	@Override
	public void setFocus() {
		boolean dirtyAlready = isDirty();
		
		// inside this call auto refresh will happen if (and turn the editor dirty)
		super.setFocus();
		
		if(superClassListener.isChangeInSuperClass())
			superClassChanged();
		
		if (!dirtyAlready && isDirty())
			doSave(null);
		
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject diagramBo = diagram.getLink().getBusinessObjects().iterator().next();
		if(diagramBo == null || diagramBo.eIsProxy())
			handleMissingDiagramBo(diagram);
	}
	
	protected void handleMissingDiagramBo(Diagram diagram){
		if(!showLostDiagramInputDialog)
			return;
		
		// show only once
		showLostDiagramInputDialog = false;
		MessageDialog dialog = new MessageDialog(getGraphicalControl().getShell(),
				"Diagram out-dated", null,
				"Diagram input lost. Cannot find ROOM file or class for "+diagram.getName() +"\n\n"
				+ "Please ensure that no whitespace or special characters are contained in any related path, file or project",
				MessageDialog.ERROR, new String[] { "OK", "Reconnect Diagram" }, 0);
		int result = dialog.open();
		
		if(result == 1)
			new ChangeDiagramInputJob("Change input for "+diagram.getName(), this).schedule();	
	}
	
	/**
	 * Check whether the given diagram editor manages a super class
	 * @param editor
	 * @return
	 */
	protected boolean registerSuperClassListener(RoomDiagramEditor editor) {
		if(!(this.getClass().equals(editor.getClass()) && this.getStructureClass() instanceof ActorClass))
			return false;
		
		StructureClass editorSc = editor.getStructureClass();
		if(editorSc instanceof ActorClass){
			URI editorResURI = toCurrentPlatformURI(editorSc.eResource().getURI());
			
			ActorClass base = (ActorClass) getStructureClass();
			while((base = base.getBase()) != null){
				URI baseResURI = toCurrentPlatformURI(base.eResource().getURI());
				if(editorResURI.equals(baseResURI))
					if(editorSc.getName().equals(base.getName()))
						return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Check whether the given room editor has a super class
	 * @param editor
	 * @return
	 */
	protected boolean registerSuperClassListener(RoomEditor editor) {
		if(!(this.getStructureClass() instanceof ActorClass))
			return false;
		
		return editor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>(){

			@Override
			public Boolean exec(XtextResource resource) throws Exception {
				
				URI editorResURI = toCurrentPlatformURI(resource.getURI());
				URI thisScResURI = toCurrentPlatformURI(getStructureClass().eResource().getURI());
				
				// ignore if in same file (handled by graphiti)
				if(thisScResURI.equals(editorResURI))
					return false;
				
				ActorClass base = (ActorClass) getStructureClass();
				while((base = base.getBase()) != null){
					URI baseResURI = toCurrentPlatformURI(base.eResource().getURI());
					if(editorResURI.equals(baseResURI))
						return true;
				}
				
				return false;
			}
		});
	}
	
	private URI toCurrentPlatformURI(URI uri){
		if(uri.isPlatform())
			return uri;
		else if(uri.isFile()){
			final IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			String rootString = rootPath.toFile().toString();
			String fileString = uri.toFileString();
			if(fileString.startsWith(rootString))
				return URI.createPlatformResourceURI(fileString.replace(rootString, ""), false);
		}
		return null;
	}
	
	protected abstract void superClassChanged();

	protected abstract StructureClass getStructureClass();

	public URI getInputUri() {
		return inputUri;
	}

}
