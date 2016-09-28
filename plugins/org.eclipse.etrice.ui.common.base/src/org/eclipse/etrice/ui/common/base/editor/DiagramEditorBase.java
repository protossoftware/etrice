/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.editor;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.ui.FSMUiModule;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.EditorInputAdapter;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.help.IContextProvider;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class DiagramEditorBase extends DiagramEditor implements IInputUriHolder {

	protected ModificationTrackingEnabler mte = new ModificationTrackingEnabler();
	protected URI inputUri;
	private Object textEditorClass;
	
	private SuperClassListener superClassListener;

	public DiagramEditorBase(Object textEditorClass) {
		this.textEditorClass = textEditorClass;
		
		Injector injector = FSMUiModule.getInjector();
		injector.injectMembers(this);
		
		TrayDialog.setDialogHelpAvailable(false);
	}
	
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new CustomDiagramBehavior(this);
	}

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
	 * @see org.eclipse.graphiti.ui.editor.DiagramEditor#setFocus()
	 */
	@Override
	public void setFocus() {
		boolean dirtyAlready = isDirty();
		
		// inside this call auto refresh will happen if (and turn the editor dirty)
		super.setFocus();
		
		if (superClassListener.isChangeInSuperClass())
			superClassChanged();
		
		if (!dirtyAlready && isDirty())
			doSave(new NullProgressMonitor());
		
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject diagramBo = diagram.getLink().getBusinessObjects().iterator().next();
		if(diagramBo == null || diagramBo.eIsProxy())
			handleMissingDiagramBo(diagram);
	}
	
	public ModelComponent getModelComponent() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof ModelComponent)
			return (ModelComponent) bo;
		
		return null;
	}

	@Override
	public void dispose() {
		mte.unsetTarget(getEditingDomain());
	
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(superClassListener);
		superClassListener.dispose();
		
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		superClassListener = new SuperClassListener(this, textEditorClass);
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

	/**
	 * Check whether the given diagram editor manages a super class
	 * @param editor
	 * @return
	 */
	protected boolean registerSuperClassListener(DiagramEditorBase editor) {
		if (!(this.getClass().equals(editor.getClass()) && this.getModelComponent()!=null))
			return false;
		
		ModelComponent editorSc = editor.getModelComponent();
		if (editorSc!=null) {
			URI editorResURI = toCurrentPlatformURI(editorSc.eResource().getURI());
			
			ModelComponent base = getModelComponent();
			while((base = base.getBase()) != null){
				URI baseResURI = toCurrentPlatformURI(base.eResource().getURI());
				if(editorResURI.equals(baseResURI))
					if(editorSc.getComponentName().equals(base.getComponentName()))
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
	protected boolean registerSuperClassListener(XtextEditor editor) {
		if (!((Class<?>)textEditorClass).isInstance(editor))
			return false;
		if (this.getModelComponent()==null)
			return false;
		
		return editor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>(){
	
			@Override
			public Boolean exec(XtextResource resource) throws Exception {
				
				URI editorResURI = toCurrentPlatformURI(resource.getURI());
				URI thisScResURI = toCurrentPlatformURI(getModelComponent().eResource().getURI());
				
				// ignore if in same file (handled by graphiti)
				if(thisScResURI.equals(editorResURI))
					return false;
				
				ModelComponent base = getModelComponent();
				while((base = base.getBase()) != null){
					URI baseResURI = toCurrentPlatformURI(base.eResource().getURI());
					if(editorResURI.equals(baseResURI))
						return true;
				}
				
				return false;
			}
		});
	}

	private URI toCurrentPlatformURI(URI uri) {
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

	protected abstract void handleMissingDiagramBo(Diagram diagram);
	protected abstract void superClassChanged();
	protected abstract EObject getModel();

	public URI getInputUri() {
		return inputUri;
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key.equals(IContextProvider.class)) {
			return new SelectedModelHelpProvider(this);
		}
		return super.getAdapter(key);

	}

}
