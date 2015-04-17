/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jan Koehnlein (Itemis, initially from org.eclipse.xtext.gmf.glue)
 * 		Henrik Rentz-Reichert
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.concurrency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Lifecycle;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.shared.Access;

import com.google.common.collect.Lists;

/**
 * Detects concurrent modifications of eTrice structure and behavior
 * and Xtext editors based on Xtext's dirty state management.
 * <p>
 * Based on former ConcurrentModificationObserver and EditingDomainAdapter
 */
public class DirtyResourceTracker {

	public static void register(DiagramEditorBase diagramEditor){
		new DirtyResourceTracker(diagramEditor);
	}
	
	protected class DialogPrompter implements Runnable {

		private boolean isYesResult;

		public boolean isYesResult() {
			return isYesResult;
		}

		public void run() {
			Shell shell = Display.getDefault().getActiveShell();
			isYesResult = MessageDialog.open(MessageDialog.QUESTION, shell, "Concurrent Modification",
					"Other editors have a modified version of models you are going to change.\n"
							+ "If you apply your changes you are loosing the possibility to save the others.\n"
							+ "Apply changes anyway?", SWT.NONE);
		}
	}

	protected class ResourceSetListenerImpl implements ResourceSetListener {

		@Override
		public NotificationFilter getFilter() {
			return null;
		}

		@Override
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			checkConcurrentModificationOnTransaction();

			return null;
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
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
			return false;
		}

	}

	protected class PartListenerImpl implements IPartListener {

		@Override
		public void partActivated(IWorkbenchPart part) {

		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {

		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			dispose();
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
			updateDirtyStateOnEditorDeactivation();
		}

		@Override
		public void partOpened(IWorkbenchPart part) {

		}

	}

	protected class TransactionalEditingDomainListenerImpl implements TransactionalEditingDomainListener {

		@Override
		public void transactionStarting(TransactionalEditingDomainEvent event) {

		}

		@Override
		public void transactionInterrupted(TransactionalEditingDomainEvent event) {

		}

		@Override
		public void transactionStarted(TransactionalEditingDomainEvent event) {

		}

		@Override
		public void transactionClosing(TransactionalEditingDomainEvent event) {

		}

		@Override
		public void transactionClosed(TransactionalEditingDomainEvent event) {

		}

		@Override
		public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
			dispose();
		}

	}

	private DiagramEditorBase diagramEditor;
	private TransactionalEditingDomain editingDomain;
	private IDirtyStateManager dirtyStateManager;
	private Map<URI, IDirtyResource> uri2dirtyResource;
	private TransactionalEditingDomainListenerImpl editingDomainListener;
	private IPartListener uiPartListener;

	public DirtyResourceTracker(DiagramEditorBase diagramEditor) {
		this.diagramEditor = diagramEditor;
		this.editingDomain = diagramEditor.getEditingDomain();
		this.dirtyStateManager = Access.getIDirtyStateManager().get();
		this.uri2dirtyResource = new HashMap<URI, IDirtyResource>();
		this.editingDomainListener = new TransactionalEditingDomainListenerImpl();

		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		lifecycle.addTransactionalEditingDomainListener(editingDomainListener);
		editingDomain.addResourceSetListener(new ResourceSetListenerImpl());

		uiPartListener = new PartListenerImpl();
		diagramEditor.getSite().getWorkbenchWindow().getPartService().addPartListener(uiPartListener);
	}

	/**
	 * If execution of command is about to complete, check concurrent modification and prompt dialog
	 * @throws RollbackException
	 */
	public void checkConcurrentModificationOnTransaction() throws RollbackException {
		List<XtextResource> resourcesWithConflicts = null;
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if (resource instanceof XtextResource && resource.isModified()) {
				XtextResource xtextResource = (XtextResource) resource;
				IDirtyResource dirtyResource = uri2dirtyResource.get(xtextResource.getURI());
				if (dirtyResource == null) {
					if (!createAndRegisterDirtyState(xtextResource)) {
						if (resourcesWithConflicts == null) {
							resourcesWithConflicts = Lists.newArrayList();
						}
						resourcesWithConflicts.add(xtextResource);
					}
				}
			}
		}
		if (resourcesWithConflicts != null) {
			if (userApplyChanges()) {
				for (XtextResource resourceWithConflicts : resourcesWithConflicts) {
					try {
						IDirtyResource dirtyResource = createDirtyResource(resourceWithConflicts);
						// assert resource is serializable
						dirtyResource.getContents();
						dirtyStateManager.announceDirtyStateChanged(dirtyResource);
					}
					catch (Exception exc) {
						System.err.println("Error serializing resource: " + exc);
					}
				}
			}
			else {
				throw new RollbackException(new Status(IStatus.ERROR, UIBaseActivator.PLUGIN_ID,
						"Transaction aborted by user"));
			}
		}
	}

	/**
	 * Issue: Undo changes via change recording look like resource changes.<br>
	 * Thus resource gets dirty state if {@link DiagramEditorBase#isDirty()} and {@link Resource#isModified()}.
	 */
	public void updateDirtyStateOnEditorDeactivation() {
		if (!diagramEditor.isDirty()) {
			for (URI uri : uri2dirtyResource.keySet())
				dirtyStateManager.discardDirtyState(uri2dirtyResource.get(uri));
			uri2dirtyResource.clear();
		} else
			setResourcesDirtyState();
	}

	protected void setResourcesDirtyState() {
		List<URI> remainingURIs = Lists.newArrayList(uri2dirtyResource.keySet());
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				XtextResource xtextResource = (XtextResource) resource;
				remainingURIs.remove(xtextResource.getURI());
				IDirtyResource dirtyResource = uri2dirtyResource.get(xtextResource.getURI());
				if (xtextResource.isModified()) {
					if (dirtyResource == null) {
						createAndRegisterDirtyState(xtextResource);
					}
				}
				else {
					if (dirtyResource != null) {
						uri2dirtyResource.remove(xtextResource.getURI());
						dirtyStateManager.discardDirtyState(dirtyResource);
					}
				}
			}
		}
		// removed resources
		for (URI remainingURI : remainingURIs) {
			IDirtyResource dirtyResource = uri2dirtyResource.get(remainingURI);
			dirtyStateManager.discardDirtyState(dirtyResource);
			uri2dirtyResource.remove(remainingURI);
		}
	}

	protected boolean createAndRegisterDirtyState(XtextResource xtextResource) {
		IDirtyResource dirtyResource = createDirtyResource(xtextResource);
		if (dirtyResource == null) {
			return true;
		}
		else {
			boolean isSuccess = dirtyStateManager.manageDirtyState(dirtyResource);
			if (isSuccess) {
				uri2dirtyResource.put(xtextResource.getURI(), dirtyResource);
			}
			return isSuccess;
		}
	}

	protected IDirtyResource createDirtyResource(XtextResource xtextResource) {
		IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(xtextResource.getURI());
		if (resourceServiceProvider == null) {
			return null;
		}
		return new SimpleDirtyResource(xtextResource, resourceServiceProvider);
	}

	protected boolean userApplyChanges() {
		DialogPrompter dialogPrompter = new DialogPrompter();
		Display.getDefault().syncExec(dialogPrompter);
		boolean yesResult = dialogPrompter.isYesResult();
		return yesResult;
	}

	public void dispose() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(uiPartListener);

		for (IDirtyResource dirtyResource : uri2dirtyResource.values()) 
			dirtyStateManager.discardDirtyState(dirtyResource);
		uri2dirtyResource.clear();
		
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		if (lifecycle != null)
			lifecycle.removeTransactionalEditingDomainListener(editingDomainListener);
	}

}
