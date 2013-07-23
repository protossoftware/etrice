/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.ui.editor.RoomEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

public class SuperClassListener implements IPartListener, ResourceSetListener, IXtextModelListener {

	private RoomDiagramEditor diagramEditor;
	private List<TransactionalEditingDomain> domains;
	private List<IXtextDocument> xtextDocuments;
	private boolean changeInSuperClass;
	
	public SuperClassListener(RoomDiagramEditor diagramEditor) {
		this.diagramEditor = diagramEditor;
		domains = new ArrayList<TransactionalEditingDomain>();
		xtextDocuments = new ArrayList<IXtextDocument>();
		changeInSuperClass = false;
	}
	
	public boolean isChangeInSuperClass() {
		return changeInSuperClass;
	}

	public void dispose(){
		for(TransactionalEditingDomain domain : domains){
			if(domain != null)
				domain.removeResourceSetListener(this);
		}
		for(IXtextDocument document : xtextDocuments){
			if(document != null)
				document.removeModelListener(this);
		}
	}
	
	// ---
	// IPartListener
	// ---

	@Override
	public void partActivated(IWorkbenchPart part) {

	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {

	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part instanceof RoomDiagramEditor){
			RoomDiagramEditor editor = (RoomDiagramEditor)part;
			TransactionalEditingDomain toRemove = editor.getEditingDomain();
			if(toRemove != null){
				toRemove.removeResourceSetListener(this);
				domains.remove(toRemove);
			}
		}
		
		if(part instanceof RoomEditor){
			IXtextDocument toRemove = ((RoomEditor) part).getDocument();
			if(toRemove != null){
				toRemove.removeModelListener(this);
				xtextDocuments.remove(toRemove);
			}
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		if(part == diagramEditor)
			changeInSuperClass = false;
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// initial
		if(part==diagramEditor){
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			for (IEditorReference editorRef : activePage.getEditorReferences()) {
				IEditorPart editor = editorRef.getEditor(false);
				if (editor != null && editor!=diagramEditor) 
					partOpened(editor);
			}
			return;
		}
		
		if(part instanceof RoomDiagramEditor){
			RoomDiagramEditor editor = (RoomDiagramEditor)part;
			TransactionalEditingDomain domain = editor.getEditingDomain();
			if(!domains.contains(domain) && diagramEditor.registerSuperClassListener(editor)){
				domain.addResourceSetListener(this);
				domains.add(domain);
			}
		}
		
		if(part instanceof RoomEditor){
			RoomEditor editor = (RoomEditor) part;
			IXtextDocument document = editor.getDocument();
						
			if(!xtextDocuments.contains(document) && diagramEditor.registerSuperClassListener(editor)){
				editor.getDocument().addModelListener(this);
				xtextDocuments.add(document);
			}
		}
	}
	
	// ---
	// ResourceSetListener
	// ---

	@Override
	public NotificationFilter getFilter() {
		return null;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		return null;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		// TODO: only set changed if resource is saved
		changeInSuperClass = true;
	}

	@Override
	public boolean isAggregatePrecommitListener() {
		return false;
	}

	@Override
	public boolean isPrecommitOnly() {
		return false;
	}

	@Override
	public boolean isPostcommitOnly() {
		return true;
	}
	
	// ---
	// IXtextModelListener
	// ---

	@Override
	public void modelChanged(XtextResource resource) {
		// TODO: only set changed if resource is saved
		changeInSuperClass = true;
	}

}
