/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class MemberSelectionDialog extends FormDialog {

	private class MemberContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			EList<Attribute> attributes = ac.getAttributes();
			EList<StandardOperation> operations = ac.getOperations();
			
			Object[] elements = new Object[attributes.size()+operations.size()];
			System.arraycopy(attributes.toArray(), 0, elements, 0, attributes.size());
			System.arraycopy(operations.toArray(), 0, elements, attributes.size(), operations.size());
			
			return elements;
		}
		
	}
	
	private class MemberLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex==0) {
				return labelProvider.getImage(element);
			}
			
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				if (element instanceof Attribute)
					return ((Attribute) element).getType().getType().getName();
				else if (element instanceof Operation)
					return ((Operation) element).getReturnType()==null ? "void":((Operation) element).getReturnType().getType().getName();
				break;
			case 1:
				if (element instanceof Attribute) {
					int sz = ((Attribute) element).getSize();
					if (sz>1)
						return ((Attribute) element).getName()+"["+sz+"]";
					else
						return ((Attribute) element).getName();
				}
				else if (element instanceof Operation)
					return ((Operation) element).getName();
				break;
			case 2:
				if (element instanceof Operation)
					return RoomHelpers.getTypedArgumentList((Operation) element);
			}
			return null;
		}
		
	}
	
	private ActorClass ac;
	private TableViewer viewer;

	@Inject
	ILabelProvider labelProvider;
	private Object selected;
	
	/**
	 * @param shell
	 */
	public MemberSelectionDialog(Shell shell, ActorClass ac) {
		super(shell);
		this.ac = ac;
		
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}
	
	@Override
	protected void createFormContent(IManagedForm mform) {
		FormToolkit toolkit = mform.getToolkit();

		Form form = mform.getForm().getForm();
		form.setText("Select an Attribute or Operation");

		form.setImage(Activator.getImage("icons/Behavior.gif"));
		toolkit.decorateFormHeading(form);

		Composite body = form.getBody();
		
		viewer = new TableViewer(body, SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL);
		
		// HOWTO: add table columns
		TableColumn col0 = new TableColumn(viewer.getTable(), SWT.NONE);
		col0.setText("type");
		TableColumn col1 = new TableColumn(viewer.getTable(), SWT.NONE);
		col1.setText("name");
		TableColumn col2 = new TableColumn(viewer.getTable(), SWT.NONE);
		col2.setText("parameters");
		viewer.getTable().setHeaderVisible(true);
		
		viewer.setContentProvider(new MemberContentProvider());
		viewer.setLabelProvider(new MemberLabelProvider());
		
		viewer.setInput(ac);
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Button ok = getButton(OK);
				if (ok!=null) {
					if (event.getSelection() instanceof IStructuredSelection) {
						Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
						ok.setEnabled(element instanceof Attribute || element instanceof Operation);
					}
				}
			}
		});

		// the table layout is crucial!
		TableColumnLayout layout = new TableColumnLayout();
		body.setLayout(layout);

		layout.setColumnData(col0, new ColumnWeightData(20));
		layout.setColumnData(col1, new ColumnWeightData(30));
		layout.setColumnData(col2, new ColumnWeightData(50));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			selected = ((IStructuredSelection) selection).getFirstElement();
		}
		super.okPressed();
	}
	
	public Object getSelected() {
		return selected;
	}
	
}
