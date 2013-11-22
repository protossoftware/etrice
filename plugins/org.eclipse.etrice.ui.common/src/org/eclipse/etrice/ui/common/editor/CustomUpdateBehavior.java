/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.core.commands.operations.DefaultOperationHistory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.internal.editor.GFWorkspaceCommandStackImpl;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@SuppressWarnings("restriction")
public class CustomUpdateBehavior extends DefaultUpdateBehavior {
	
	@Inject
	private IResourceSetProvider resourceSetProvider;

	/**
	 * @param diagramBehavior
	 */
	public CustomUpdateBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);

		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior#createEditingDomain()
	 */
	@Override
	protected void createEditingDomain() {
		ResourceSet resourceSet;
		if (diagramBehavior.getDiagramContainer() instanceof IInputUriHolder) {
			URI uri = ((IInputUriHolder)diagramBehavior.getDiagramContainer()).getInputUri();
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
			IProject project = file.getProject();
			resourceSet = resourceSetProvider.get(project);
		}
		else {
			resourceSet = new XtextResourceSet();
		}
		
		final IWorkspaceCommandStack workspaceCommandStack = new GFWorkspaceCommandStackImpl(new DefaultOperationHistory());
		
		final TransactionalEditingDomainImpl editingDomain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE), workspaceCommandStack, resourceSet);
		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(editingDomain);
		initializeEditingDomain(editingDomain);
	}

}
