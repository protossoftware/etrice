/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.commands.handlers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.editor.BehaviorExporter;
import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.etrice.ui.structure.editor.StructureExporter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExportDiagramsHandler extends AbstractHandler {

	@Inject
	protected IResourceValidator resourceValidator;
	private IPreferenceStore store;

	public ExportDiagramsHandler() {
		super();
		
		Injector injector = RoomUiModule.getInjector();
		injector.injectMembers(this);
		
		this.store = Activator.getDefault().getPreferenceStore();
	}

	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IEditorPart editor = window.getActivePage().getActiveEditor();
		if (editor instanceof XtextEditor) {
			final IPath path = ((FileEditorInput)editor.getEditorInput()).getPath();
			
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				// event from the xtext editor's outline view
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object sel = ss.getFirstElement();
				if (sel instanceof EObjectNode) {
					XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
					IXtextDocument document = xtextEditor.getDocument();
					final String fragment = ((EObjectNode) sel).getEObjectURI().fragment();
					if (checkPrerequisites(xtextEditor, document, fragment)) {
						document.readOnly(new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource resource) throws Exception {
								if (resource != null) {
									EObject object = resource.getEObject(fragment);
									
									if (object instanceof RoomModel)
										exportDiagrams((RoomModel)object, path, editor.getSite().getShell());
								}
							}
						});
					}
				}
			}
		}
		return null;
	}

	protected void exportDiagrams(RoomModel model, IPath modelPath, Shell shell) {
		IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(modelPath.removeLastSegments(1));
		String relPath = store.getString(PreferenceConstants.EXPORT_DIAGRAM_PATH);
		boolean projectRelative = PreferenceConstants.PATH_REL_TO_PROJECT.equals(
				store.getString(PreferenceConstants.EXPORT_DIAGRAM_PATH_RELATIVE_TO));
		
		IFolder folder;
		if (projectRelative) {
			IProject project = container.getProject();
			folder = project.getFolder(relPath);
		}
		else {
			folder = container.getFolder(new Path(relPath));
		}
		if (folder!=null) {
			if (!folder.exists())
				try {
					create(folder);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			
			if (folder.exists()) {
				String folderPath = folder.getLocation().toOSString();
				
				for (ActorClass ac : model.getActorClasses()) {
					if (ac.getStateMachine()!=null)
						BehaviorExporter.export(ac, folderPath);
					
					StructureExporter.export(ac, folderPath);
				}
				
				for (SubSystemClass ssc : model.getSubSystemClasses()) {
					StructureExporter.export(ssc, folderPath);
				}
				
				try {
					folder.refreshLocal(IResource.DEPTH_ONE, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void create(final IResource resource) throws CoreException {
		if (resource == null || resource.exists())
			return;
		if (!resource.getParent().exists())
			create(resource.getParent());
		switch (resource.getType()) {
		case IResource.FILE:
			((IFile) resource).create(new ByteArrayInputStream(new byte[0]), true, null);
			break;
		case IResource.FOLDER:
			((IFolder) resource).create(IResource.NONE, true, null);
			break;
		case IResource.PROJECT:
			((IProject) resource).create(null);
			((IProject) resource).open(null);
			break;
		}
	}
	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	protected boolean checkPrerequisites(XtextEditor xtextEditor,
			IXtextDocument document, final String fragment) {
		if (hasIssues(document, new NullProgressMonitor())) {
			MessageDialog.openError(xtextEditor.getSite().getShell(), "Validation Errors", "The editor has validation errors.\nCannot open diagram!");
			return false;
		}
		if (xtextEditor.isDirty()) {
			if (!MessageDialog.openQuestion(xtextEditor.getSite().getShell(), "Save model file", "The editor will be saved before opening the diagram editor.\nProceed?"))
				return false;
			// postpone save to avoid doing it twice
		}
		if (xtextEditor.isDirty()) {
			xtextEditor.doSave(new NullProgressMonitor());
		}
		return true;
	}

	// TODO: code copied from org.eclipse.etrice.ui.commands.handlers.AbstractEditHandler - refactor
	public boolean hasIssues(IXtextDocument xtextDocument, final IProgressMonitor monitor) {
		final boolean issues = xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource resource) throws Exception {
						if (resource == null)
							return false;
						List<Issue> issueList = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
							public boolean isCanceled() {
								return monitor.isCanceled();
							}
						});
						for (Issue issue : issueList) {
							if (issue.getSeverity()==Severity.ERROR)
								return true;
						}
						return false;
					}
				});
		return issues;
	}

	@Override
	public boolean isEnabled() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		if (part instanceof ContentOutline) {
			ISelection selection = ((ContentOutline)part).getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Object sel = ss.getFirstElement();
				if (sel instanceof EObjectNode) {
					EObjectNode node = (EObjectNode) sel;
					String fragment = node.getEObjectURI().fragment();
					return fragment.equals("/");
				}
			}
		}
		return false;
	}

}
