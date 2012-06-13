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

package org.eclipse.etrice.ui.structure.dialogs;

import java.util.List;

import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.util.CompoundProtocolHelpers;
import org.eclipse.etrice.core.room.util.CompoundProtocolHelpers.Match;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class SubProtocolSelectionDialog extends FormDialog {

	private class MatchContentProvider implements IStructuredContentProvider {

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		@Override
		public void dispose() {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		@Override
		public Object[] getElements(Object inputElement) {
			return matches.toArray();
		}
		
	}
	
	private class MatchLabelProvider  extends LabelProvider implements ITableLabelProvider {

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Match) {
				SubProtocol sub = (columnIndex==0)?
					((Match) element).getLeft() : ((Match) element).getRight();
					
				if (sub==null)
					return "-/"+((columnIndex==0)? src.getProtocol().getName() : dst.getProtocol().getName());
				else
					return sub.getName()+"/"+sub.getProtocol().getName();
			}
			return null;
		}
		
	}
	
	private Port src;
	private Port dst;
	private TableViewer viewer;
	private List<Match> matches;
	private Match selected;

	/**
	 * @param shell
	 */
	public SubProtocolSelectionDialog(Shell shell, Port src, Port dst, Binding bind, StructureClass sc) {
		super(shell);
		
		this.src = src;
		this.dst = dst;
		
		matches = CompoundProtocolHelpers.getMatches(src, dst, sc, bind);

		// find match to select
		if (bind!=null) {
			for (Match match : matches) {
				if (match.getLeft()==bind.getEndpoint1().getSub() && match.getRight()==bind.getEndpoint2().getSub())
					selected = match;
			}
		}
		else
			selected = matches.get(0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.FormDialog#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm mform) {
		super.createFormContent(mform);

		Form form = mform.getForm().getForm();
		form.setText("Connect SubProtocol(s)");
		mform.getToolkit().decorateFormHeading(form);
		form.setImage(Activator.getImage("icons/Structure.gif"));

		Composite body = form.getBody();
		
		Table matchTable = mform.getToolkit().createTable(body, SWT.NONE | SWT.SINGLE | SWT.FULL_SELECTION);
		viewer = new TableViewer(matchTable);

		TableColumn col0 = new TableColumn(viewer.getTable(), SWT.NONE);
		col0.setText("Port "+src.getName());
		TableColumn col1 = new TableColumn(viewer.getTable(), SWT.NONE);
		col1.setText("Port "+dst.getName());
		viewer.getTable().setHeaderVisible(true);

		viewer.setContentProvider(new MatchContentProvider());
		viewer.setLabelProvider(new MatchLabelProvider());
		
		viewer.setInput(matches);

		TableColumnLayout layout = new TableColumnLayout();
		body.setLayout(layout);

		layout.setColumnData(col0, new ColumnWeightData(50));
		layout.setColumnData(col1, new ColumnWeightData(50));
		
		viewer.setSelection(new StructuredSelection(selected));
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Button ok = getButton(OK);
				if (ok!=null) {
					if (event.getSelection() instanceof IStructuredSelection) {
						Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
						ok.setEnabled(element instanceof Match);
					}
					else
						ok.setEnabled(false);
				}
			}
		});
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			selected = (Match) ((IStructuredSelection) selection).getFirstElement();
		}
		super.okPressed();
	}
	
	public Match getSelected() {
		return selected;
	}
}
