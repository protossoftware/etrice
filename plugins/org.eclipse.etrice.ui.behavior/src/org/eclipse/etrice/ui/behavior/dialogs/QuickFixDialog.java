/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Sebastian Davids <sdavids@gmx.de> - Fix for bug 19346 - Dialog
 *     font should be activated and used by other components.
 *******************************************************************************/
package org.eclipse.etrice.ui.behavior.dialogs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.common.quickfix.IssueResolution;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

/**
 * An abstract class to select elements out of a list of elements.
 * 
 * @since 2.0
 */
public class QuickFixDialog extends SelectionDialog {

	private static final String TITLE = "Quick Fix";
	private static final String MESSAGE_AREA_LABEL = "Quick Fix";
	private static final String ISSUES_LIST_LABEL = "Select a Issue:";
	private static final String RESOLUTIONS_LIST_LABEL = "Select a fix:";
	private static final String DESCRIPTION_AREA_LABEL = "Description";

	private static final String ERROR_IMAGE = "icons/quickfix/error_tsk.gif";
	private static final String WARNING_IMAGE = "icons/quickfix/warn_tsk.gif";
	private static final String INFO_IMAGE = "icons/quickfix/info_tsk.gif";

	private HashMap<FeatureBasedDiagnostic, List<IssueResolution>> issueResolutionsMap;
	private TableViewer issueList;
	private TableViewer resolutionsList;
	private Label resolutionDescription;

	/**
	 * Constructs a list selection dialog.
	 * 
	 * @param parent
	 *            The parent for the list.
	 * @param renderer
	 *            ILabelProvider for the list
	 */
	public QuickFixDialog(
			Shell parent,
			HashMap<FeatureBasedDiagnostic, List<IssueResolution>> errorResolutionsMap) {
		super(parent);
		this.issueResolutionsMap = errorResolutionsMap;
		setTitle(TITLE);
		setMessage(MESSAGE_AREA_LABEL);
	}

	/*
	 * @see Dialog#createDialogArea(Composite)
	 */
	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		createMessageArea(contents);

		createLabel(contents, ISSUES_LIST_LABEL);
		createIssueList(contents);

		createLabel(contents, RESOLUTIONS_LIST_LABEL);
		createResolutionList(contents);

		createLabel(contents, DESCRIPTION_AREA_LABEL);
		createDescritionArea(contents);

		issueList.setInput(this);
		resolutionsList.setInput(this);
		issueList.setSelection(
				new StructuredSelection(issueList.getElementAt(0)), true);

		return contents;
	}

	/**
	 * @param control
	 */
	private void createIssueList(Composite control) {
		issueList = new TableViewer(control, SWT.BORDER | SWT.SINGLE
				| SWT.V_SCROLL);

		issueList.setContentProvider(new IStructuredContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {
				return issueResolutionsMap.keySet().toArray();
			}

			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});

		issueList.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return ((FeatureBasedDiagnostic) element).getMessage();
			}

			@Override
			public Image getImage(Object element) {
				switch (((Diagnostic) element).getSeverity()) {
				case Diagnostic.ERROR:
					return Activator.getImage(ERROR_IMAGE);

				case Diagnostic.WARNING:
					return Activator.getImage(WARNING_IMAGE);

				case Diagnostic.INFO:
					return Activator.getImage(INFO_IMAGE);
				}
				return null;
			}
		});

		issueList.setComparator(new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return ((FeatureBasedDiagnostic) e1).getMessage().compareTo(
						((FeatureBasedDiagnostic) e2).getMessage());
			}
		});

		issueList.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				resolutionsList.refresh();
				if (resolutionsList.getElementAt(0) != null)
					resolutionsList.setSelection(new StructuredSelection(
							resolutionsList.getElementAt(0)), true);
				updateOkState();
			}
		});
	}

	/**
	 * Create the table that shows the markers.
	 * 
	 * @param control
	 */
	private void createResolutionList(Composite control) {
		resolutionsList = new TableViewer(control, SWT.BORDER | SWT.SINGLE
				| SWT.V_SCROLL);

		resolutionsList.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				FeatureBasedDiagnostic selected = getSelectedIssue();
				if (selected == null) {
					return new Object[0];
				}
				return (issueResolutionsMap.get(selected)).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});

		resolutionsList.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return ((IssueResolution) element).getLabel();
			}

			@Override
			public Image getImage(Object element) {
				return Activator.getImage(((IssueResolution) element)
						.getImage());
			}
		});

		resolutionsList
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IssueResolution resolution = getSelectedResolution();
						String description = "";
						if (resolution != null)
							description = resolution.getDescription();
						resolutionDescription.setText(description);
						updateOkState();
					}
				});
	}

	/**
	 * Creates a label if name was not <code>null</code>.
	 * 
	 * @param parent
	 *            the parent composite.
	 * @param name
	 *            the name of the label.
	 * @return returns a label if a name was given, <code>null</code> otherwise.
	 */
	private Label createLabel(Composite parent, String name) {
		if (name == null) {
			return null;
		}
		Label label = new Label(parent, SWT.NONE);
		label.setText(name);
		label.setFont(parent.getFont());
		return label;
	}

	/**
	 * Creates the message text widget and sets layout data.
	 * 
	 * @param composite
	 *            the parent composite of the message area.
	 */
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		label.setLayoutData(data);

		return label;
	}

	private Label createDescritionArea(Composite composite) {
		Label label = super.createMessageArea(composite);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		label.setLayoutData(data);

		resolutionDescription = label;

		return label;
	}

	/**
	 * Return the currently selected issue.
	 * 
	 * @return {@link FeatureBasedDiagnostic} or <code>null</code> if there is
	 *         no selection.
	 */
	private FeatureBasedDiagnostic getSelectedIssue() {
		ISelection selection = issueList.getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}

		Object first = ((IStructuredSelection) selection).getFirstElement();

		return (FeatureBasedDiagnostic) first;
	}

	/**
	 * Return the currently selected resolution.
	 * 
	 * @return {@link IssueResolution} or <code>null</code> if there is no
	 *         selection.
	 */
	private IssueResolution getSelectedResolution() {
		ISelection selection = resolutionsList.getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}
		Object first = ((IStructuredSelection) selection).getFirstElement();
		return (IssueResolution) first;
	}

	/*
	 * @see Dialog#cancelPressed
	 */
	protected void cancelPressed() {
		setResult(null);
		super.cancelPressed();
	}

	@Override
	protected void okPressed() {
		Object[] results = new Object[] { getSelectedResolution() };
		setResult(Arrays.asList(results));
		super.okPressed();
	}

	/**
	 * Update the enablement of the OK button based on whether or not there is a
	 * selection.
	 */
	private void updateOkState() {
		Button okButton = getOkButton();
		if (okButton != null) {
			okButton.setEnabled(getSelectedResolution() != null);
		}
	}
}
