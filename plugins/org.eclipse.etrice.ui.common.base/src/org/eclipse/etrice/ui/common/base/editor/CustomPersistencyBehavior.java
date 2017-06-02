/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.editor;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class CustomPersistencyBehavior extends DefaultPersistencyBehavior {

	private SaveOnFocusLostListener saveOnFocusListener;
	
	public CustomPersistencyBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}
	
	@Override
	public Diagram loadDiagram(URI uri) {
		saveOnFocusListener = new SaveOnFocusLostListener((IEditorPart)diagramBehavior.getDiagramContainer().getWorkbenchPart());
		return super.loadDiagram(uri);
	}
	
	@Override
	protected Map<Resource, Map<?, ?>> createSaveOptions() {
		Map<Resource, Map<?, ?>> resMap = super.createSaveOptions();
		
		@SuppressWarnings("unchecked")
		Map<Object, Object> diagSaveOptions = (Map<Object, Object>) resMap.get(diagramBehavior.getDiagramTypeProvider().getDiagram().eResource());
		RelativeFileURIHandler.addToOptions(diagSaveOptions);

		return resMap;
	}
	
	@Override
	public void saveDiagram(IProgressMonitor monitor) {
		boolean valid = validateResourcesBeforeSave(monitor);

		if (valid)
			super.saveDiagram(monitor);

		// deactivate saveOnFocus for better usability
		// avoid retrigger loop from message box
		saveOnFocusListener.setActive(valid);
	}
	
	protected boolean validateResourcesBeforeSave(final IProgressMonitor monitor){
		final RunnableWithResult<Boolean> runnable = new RunnableWithResult.Impl<Boolean>() {

			@Override
			public void run() {
				setResult(false);
				
				boolean result = true;
				// copy list to avoid ConcurrentModification during serialize and validation
				final List<Resource> resources = Lists.newArrayList(diagramBehavior.getEditingDomain().getResourceSet().getResources());
				for(Resource res : resources){
					result &= !shouldSave(res) || validateResource(res, monitor);
				}
				
				setResult(result);
			}
			
		};
		
		try {
			return TransactionUtil.runExclusive(diagramBehavior.getEditingDomain(), runnable);
		}
		catch (InterruptedException e) {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: could not save model:\n\n"+e.getMessage());
			UIBaseActivator.getDefault().getLog().log(new Status(Status.ERROR, UIBaseActivator.PLUGIN_ID, e.getMessage(), e));
	
			return false;
		}
	}
	
	protected boolean validateResource(Resource res, final IProgressMonitor monitor) {
		IStatus resultStatus = null;		
		if(res instanceof XtextResource)
			resultStatus = validateSyntax((XtextResource) res);
		else
			resultStatus = Status.OK_STATUS;
		
		if (!resultStatus.isOK()) {
			final int filterMask = IStatus.OK | IStatus.INFO | IStatus.WARNING | IStatus.ERROR;
			ErrorDialog dialog = new ErrorDialog(diagramBehavior.getDiagramContainer().getSite().getShell(),
					"Save", "Cannot save diagram.", resultStatus, filterMask) {
				@Override
				public void create() {
					super.create();
					showDetailsArea();
				};
			};
			dialog.open();
		}
		
		return resultStatus.isOK();
	}

	protected IStatus validateSyntax(XtextResource resource) {		
		MultiStatus status = new MultiStatus(UIBaseActivator.PLUGIN_ID, 0, "Could not create textual representation of " + resource.getURI().lastSegment() + ".", null);
		for (Diagnostic diag : resource.validateConcreteSyntax())
			status.add(new Status(IStatus.ERROR, UIBaseActivator.PLUGIN_ID, diag.toString()));

		try {
			if(status.isOK())
				resource.getSerializer().serialize(resource.getContents().get(0));
		} catch(RuntimeException e){
			status.add(new Status(IStatus.ERROR, UIBaseActivator.PLUGIN_ID, e.getMessage()));
		}
		
		return status;
	}
	
	//
	// Old syntax + semantic validation backup
	//
	
	@Deprecated
	@Inject
	private IResourceValidator resourceValidator;
	
	@Deprecated
	@SuppressWarnings("unused")
	private boolean validateResourceFully(Resource res, final IProgressMonitor monitor) {
		if (res instanceof XtextResource) {
			if (!res.isLoaded()) {
				try {
					res.load(Collections.EMPTY_MAP);
				} catch (IOException e) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: couldn't load referenced resource "+res.getURI());
					return false;
				}
			}
			if (res.isModified()) {

				XtextResource xres = (XtextResource) res;
				ISerializer serializer = xres.getSerializer();
				
				if (xres.getContents().isEmpty()) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: part of textual model is empty, can't save");
					return false;
				}

				try {
					// HOWTO: call serializer to validate the concrete syntax
					// this throws an exception which is caught further up the stack
					// and a dialog will be displayed
					serializer.serialize(xres.getContents().get(0));
					
					List<Issue> result = resourceValidator.validate(res, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
						public boolean isCanceled() {
							if(monitor == null)
								return false;
							return monitor.isCanceled();
						}
					});
					if (!result.isEmpty()) {
						boolean error = false;
						MultiStatus ms = new MultiStatus(UIBaseActivator.PLUGIN_ID, Status.ERROR, "validation errors during diagram save", null);
						for (Issue issue : result) {
							if (issue.isSyntaxError() || issue.getSeverity()==Severity.ERROR) {
								ms.add(new Status(Status.ERROR, UIBaseActivator.PLUGIN_ID, issue.getMessage()));
								error = true;
							}
						}
						if (error) {
							StringBuilder messges = new StringBuilder();
							for(IStatus status : ms.getChildren())
								messges.append(status.getMessage()+"\n");
							MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: model is invalid, can't save:\n\n"+messges);
							UIBaseActivator.getDefault().getLog().log(ms);
							return false;
						}
					}
				}
				catch (RuntimeException e) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "ERROR", "Internal error: model is invalid, can't save:\n\n"+e.getMessage());
					UIBaseActivator.getDefault().getLog().log(new Status(Status.ERROR, UIBaseActivator.PLUGIN_ID, e.getMessage(),e));
					return false;
				}
			}
		}
		
		return true;
	}

}
