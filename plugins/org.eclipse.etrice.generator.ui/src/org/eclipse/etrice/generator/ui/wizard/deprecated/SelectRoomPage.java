/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard.deprecated;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.google.inject.Injector;

public class SelectRoomPage extends WizardPage implements SelectionListener {

	private Text roomFileText;
	private TreeViewer roomContentTree;
	
	private ILabelProvider roomLabelProvider;
	
	private IResource resourceSelection = null;
	private RoomModel selectedRoomModel = null;


	public SelectRoomPage(IStructuredSelection initialSelection, Injector roomInjector) {
		super("select_room_page");

		roomLabelProvider = roomInjector.getInstance(ILabelProvider.class);
		
		if (initialSelection != null && initialSelection.getFirstElement() instanceof IResource)
			resourceSelection = (IResource) initialSelection.getFirstElement();
	}
	
	public RoomModel getSelectedRoomModel(){
		return selectedRoomModel;
	}
	
	public IFile getSelectedRoomResource(){
		if(selectedRoomModel != null)
			return (IFile) resourceSelection;
		
		return null;
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		// - top level composite
		Composite topLevel = new Composite(parent, SWT.NONE);
		GridLayout gl_topLevel = new GridLayout();
		gl_topLevel.marginHeight = 0;
		topLevel.setLayout(gl_topLevel);
		topLevel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		topLevel.setFont(parent.getFont());

		// 1. room file selection
		Composite firstComp = new Composite(topLevel, SWT.NONE);
		firstComp.setLayout(new GridLayout(3, false));
		firstComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		Label roomFileLabel = new Label(firstComp, SWT.NONE);
		roomFileLabel.setText(".room file: ");
		roomFileText = new Text(firstComp, SWT.BORDER);
		roomFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		roomFileText.setEditable(false);
		Button roomFileBrowse = new Button(firstComp, SWT.PUSH);
		roomFileBrowse.setText("Browse");
		roomFileBrowse.addSelectionListener(this);

		// separator
		Label separator = new Label(topLevel, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// 2. tree overview of (sub)systems
		roomContentTree = new TreeViewer(topLevel, SWT.V_SCROLL | SWT.BORDER);
		roomContentTree.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		roomContentTree.setLabelProvider(roomLabelProvider);
		roomContentTree.setContentProvider(new ContenProvider());
		roomContentTree.getTree().setEnabled(false);
		roomContentTree.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);

		setControl(topLevel);
		setUserInput(resourceSelection);
		setPageComplete();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(),
				new BaseWorkbenchContentProvider());
		dialog.setTitle("Select a .room file");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setAllowMultiple(false);
		dialog.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof IResource && !(element instanceof IFile)
						|| ((IFile) element).getName().endsWith(".room");
			}

		});

		if (resourceSelection != null){
			dialog.setInitialSelection(resourceSelection);
			if(dialog.getFirstResult() == null)
				dialog.setInitialSelection(resourceSelection.getParent());
		}

		if (dialog.open() != Dialog.OK || dialog.getFirstResult() == null)
			return;

		setUserInput((IResource) dialog.getFirstResult());
		setPageComplete();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	protected void setUserInput(IResource resource) {
		resourceSelection = resource;
		roomContentTree.setInput(null);
		selectedRoomModel = null;

		if (resourceSelection == null) {
			roomFileText.setText("");
			return;
		}

		String path = resource.getFullPath().toString();
		roomFileText.setText(resource.getFullPath().removeFirstSegments(1).toString());

		if (!(resource instanceof IFile)) {
			setErrorMessage("Selected path must be a file.");
			return;
		}

		final URI uri = URI.createPlatformResourceURI(path, false);
		ResourceSet rs = new ResourceSetImpl();
		Resource roomRes = rs.getResource(uri, true);
		
		if (roomRes != null && !roomRes.getContents().isEmpty()
				&& roomRes.getContents().iterator().next() instanceof RoomModel) {
			roomContentTree.setInput(roomRes);

			RoomModel model = (RoomModel) roomRes.getContents().iterator().next();
			if (model.getSystems().isEmpty()) {
				setErrorMessage("Room model must contain at least one logical system");
				return;
			}
			if(!roomRes.getErrors().isEmpty()){
				setErrorMessage("Room model has validation erros");
				return;
			}
			selectedRoomModel = model;
		}
		else {
			setErrorMessage("Selected file does not contain a ROOM model.");
			return;
		}

		setErrorMessage(null);
	}

	@SuppressWarnings("deprecation")
	protected void setPageComplete() {
		setPageComplete(selectedRoomModel != null);
		
		if(isPageComplete()){
			MappingCreationPage page2 = (MappingCreationPage) getWizard().getPages()[1];
			page2.createMapping(selectedRoomModel);
			SaveMappingPage page3 = (SaveMappingPage) getWizard().getPages()[2];
			page3.setModelPath((IFile) resourceSelection);
		}
		
	}

	private class ContenProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			viewer.getControl().setEnabled(newInput != null);
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Resource)
				return new Object[] { ((Resource) inputElement).getContents().iterator().next() };

			return new Object[0];
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			List<Object> objects = new ArrayList<Object>();
			if (parentElement instanceof RoomModel) {
				RoomModel model = (RoomModel) parentElement;
				objects.addAll(model.getSystems());
			}
			else if (parentElement instanceof LogicalSystem)
				objects.addAll(((LogicalSystem) parentElement).getSubSystems());

			return objects.toArray();
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof EObject)
				return ((EObject) element).eContainer();

			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof RoomModel || element instanceof LogicalSystem;
		}

	}
}
