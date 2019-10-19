/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.editor;

import static org.eclipse.ui.PlatformUI.getWorkbench;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.ui.editor.ISaveOnFocusLostEditor;
import org.eclipse.etrice.core.common.ui.editor.SaveDialogEditor;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.ui.FSMUiModule;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
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
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class DiagramEditorBase extends DiagramEditor implements IInputUriHolder, ISaveOnFocusLostEditor {

	private final static String CONTEXT_ID = "org.eclipse.etrice.ui.common.base.context";
	
	protected ModificationTrackingEnabler mte = new ModificationTrackingEnabler();
	protected URI inputUri;
	private Object textEditorClass;
	
	private SuperClassListener superClassListener;

	private SaveDialogEditor saveDialog = new SaveDialogEditor();
	private boolean lastSaveFailed = false;

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
		if (!result.isEmpty()){
			System.err.println("ERROR in diagram viewer: could not resolve all proxies!");
			//System.out.println(result);
		}
	
		mte.setTarget(getEditingDomain());
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DiagramEditor#setFocus()
	 */
	@Override
	public void setFocus() {
		lastSaveFailed = false;
		if (getGraphicalViewer() == null) {
			return;
		}
		
		boolean dirtyAlready = isDirty();
		
		// inside this call auto refresh will happen if (and turn the editor dirty)
		super.setFocus();
		
		if (superClassListener != null && superClassListener.isChangeInSuperClass())
			superClassChanged();
		
		if (!dirtyAlready && isDirty())
			doSave(new NullProgressMonitor());
		
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject diagramBo = diagram.getLink().getBusinessObjects().iterator().next();
		if(diagramBo == null || diagramBo.eIsProxy()) {
			handleMissingDiagramBo(diagram);
		}
	}
	
	public ModelComponent getModelComponent() {
		IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
		if(diagramTypeProvider != null) {
			Diagram diagram = diagramTypeProvider.getDiagram();	
			if(diagram != null) {
				EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
				if (bo instanceof ModelComponent)
					return (ModelComponent) bo;
			}
		}
		
		return null;
	}

	@Override
	public void dispose() {
		mte.unsetTarget(getEditingDomain());
	
		if(superClassListener != null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(superClassListener);
			superClassListener.dispose();
		}
		
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		if(!getDiagramBehavior().isAlive()){
			// something is wrong, avoid further exceptions
			return;
		}
		
		superClassListener = new SuperClassListener(this, textEditorClass);
		getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(superClassListener);
		getWorkbench().getService(IContextService.class).activateContext(CONTEXT_ID);
		
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
			URI editorResURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(editorSc.eResource().getURI());
			
			ModelComponent base = getModelComponent();
			while((base = base.getBase()) != null){
				URI baseResURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(base.eResource().getURI());
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
				
				URI editorResURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(resource.getURI());
				URI thisScResURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(getModelComponent().eResource().getURI());
				
				// ignore if in same file (handled by graphiti)
				if(thisScResURI == null || thisScResURI.equals(editorResURI))
					return false;
				
				ModelComponent base = getModelComponent();
				while((base = base.getBase()) != null){
					URI baseResURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(base.eResource().getURI());
					if(editorResURI.equals(baseResURI))
						return true;
				}
				
				return false;
			}
		});
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

	@Override
	public int promptToSaveOnClose() {
		return saveDialog.open(getGraphicalControl().getShell(), getPartName());
	}
	
	@Override
	public boolean shouldSaveOnFocusLost() {
		// lastSaveFailed is heuristic to avoid unsuccessful re-save
		// TODO implement IValidatingEditor
		return saveDialog.getResult() != NO && !lastSaveFailed && isDirty();
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		super.doSave(monitor);
		
		// avoid auto re-save 
		lastSaveFailed = isDirty();
		// do not quit editor if save failed but was requested by user explicitly
		monitor.setCanceled(lastSaveFailed && saveDialog.getResult() == YES);
	}

}
