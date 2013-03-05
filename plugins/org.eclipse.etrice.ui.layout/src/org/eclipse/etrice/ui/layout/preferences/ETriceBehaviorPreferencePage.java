/*******************************************************************************
 * Copyright (c) 2012 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.layout.preferences;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.etrice.ui.layout.Activator;
import org.eclipse.etrice.ui.layout.preferences.ETricePreferenceUtil.ElementType;
import org.eclipse.etrice.ui.layout.preferences.ETricePreferenceUtil.NewOptionDialog;
import org.eclipse.etrice.ui.layout.preferences.ETricePreferenceUtil.OptionsTableProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ListDialog;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.service.EclipseLayoutInfoService;
import de.cau.cs.kieler.kiml.ui.views.LayoutViewPart;

/**
 * Preference page for eTrice Behavior preferences
 * 
 * @author jayant
 */
public class ETriceBehaviorPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Creates the behavior layout preference page.
	 * 
	 * @author jayant
	 */
	public ETriceBehaviorPreferencePage() {
		super();
		setDescription("Preference Page for configuring layout options specific to eTrice Behavior diagrams");
	}

	/** table viewer to refresh after changes to the option table data. */
	private TableViewer optionTableViewer;

	/** list of layout option entries. */
	private List<OptionsTableProvider.DataEntry> optionEntries;

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected Control createContents(Composite parent) {
		Group optionsGroup = createOptionsGroup(parent);
		optionsGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return optionsGroup;
	}

	/**
	 * Creates the group that holds the diagram element options table.
	 * 
	 * @param parent
	 *            the parent control
	 * @return a group with the diagram element options table
	 */
	protected Group createOptionsGroup(final Composite parent) {
		Group elementGroup = new Group(parent, SWT.NONE);
		elementGroup.setText(Messages.getString("kiml.ui.28")); //$NON-NLS-1$
		IPreferenceStore preferenceStore = getPreferenceStore();
		LayoutDataService dataService = LayoutDataService.getInstance();
		Collection<LayoutOptionData<?>> layoutOptionData = dataService
				.getOptionData();
		optionEntries = new LinkedList<OptionsTableProvider.DataEntry>();

		// add options for edit parts and behavior domain model elements
		Set<String> elements = EclipseLayoutInfoService.getInstance()
				.getRegisteredElements();

		for (String element : elements) {
			
			//Finding whether diagram element is an Edit Part or Model Element 
			Class<?> elementClass = null;
			ElementType type;
			try {
				elementClass = Class.forName(element);
				try {
					type = PictogramElement.class.isAssignableFrom(elementClass)
							 ? ElementType.EDIT_PART : ElementType.MODEL_ELEM;
				} catch (NullPointerException e) {
					type = ElementType.MODEL_ELEM;
				}
			} catch (ClassNotFoundException e) {
				type = ElementType.MODEL_ELEM;
			}
			
			//Making the element name more presentable
			int dotIndex = element.lastIndexOf('.');
			String partName = element.substring(dotIndex + 1);
			if (partName.endsWith("Impl")) {
				partName = partName.substring(0,
						partName.length() - "Impl".length());
			}
			
			for (LayoutOptionData<?> data : layoutOptionData) {
				String preference = EclipseLayoutInfoService.getPreferenceName(
						element, data.getId());
				if (preferenceStore.contains(preference)) {
					Object value = data.parseValue(preferenceStore
							.getString(preference));
					if (value != null) {
						// If element is edit part or behavior model element,
						// then add to the option table
						if (type == ElementType.EDIT_PART
								|| ETriceDomainModelElement
										.isBehaviorModelElement(element))
							optionEntries
									.add(new OptionsTableProvider.DataEntry(
											partName, element, type, data,
											value));
					}
				}
			}
		}

		// add options for diagram types(only those which are relevant to eTrice
		// Behavior Diagram)
		for (Pair<String, String> diagramType : ETriceDomainModelElement.BEHAVIOR_DIAGRAM_TYPES) {
			for (LayoutOptionData<?> data : layoutOptionData) {
				String preference = EclipseLayoutInfoService.getPreferenceName(
						diagramType.getFirst(), data.getId());
				if (preferenceStore.contains(preference)) {
					Object value = data.parseValue(preferenceStore
							.getString(preference));
					if (value != null) {
						optionEntries.add(new OptionsTableProvider.DataEntry(
								diagramType.getSecond(),
								diagramType.getFirst(), ElementType.DIAG_TYPE,
								data, value));
					}
				}
			}
		}

		// create the table and actions to edit layout option values
		addOptionTable(elementGroup, optionEntries);

		elementGroup.setLayout(new GridLayout(2, false));
		return elementGroup;
	}

	/**
	 * Adds a table to display options and buttons to edit the options.
	 * 
	 * @param parent
	 *            the parent to which controls are added
	 * @param entries
	 *            the list of table entries
	 */
	private void addOptionTable(final Composite parent,
			final List<OptionsTableProvider.DataEntry> entries) {
		// construct the options table
		final Table table = new Table(parent, SWT.BORDER);
		final TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText(Messages.getString("kiml.ui.29")); //$NON-NLS-1$
		final TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText(Messages.getString("kiml.ui.9")); //$NON-NLS-1$
		final TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setText(Messages.getString("kiml.ui.19")); //$NON-NLS-1$
		final TableColumn column4 = new TableColumn(table, SWT.NONE);
		column4.setText(Messages.getString("kiml.ui.20")); //$NON-NLS-1$
		table.setHeaderVisible(true);
		final TableViewer tableViewer = new TableViewer(table);
		OptionsTableProvider optionsTableProvider = new OptionsTableProvider();
		tableViewer.setContentProvider(optionsTableProvider);
		tableViewer.setLabelProvider(optionsTableProvider);
		tableViewer.setInput(entries);
		optionTableViewer = tableViewer;

		column1.pack();
		column2.pack();
		column3.pack();
		column4.pack();
		GridData tableLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1);
		table.setLayoutData(tableLayoutData);
		table.pack();
		tableLayoutData.heightHint = ETricePreferenceUtil.OPTIONS_TABLE_HEIGHT;

		// add button to add new options
		Composite composite = new Composite(parent, SWT.NONE);
		final Button newButton = new Button(composite, SWT.PUSH | SWT.CENTER);
		newButton.setText(Messages.getString("kiml.ui.41")); //$NON-NLS-1$

		// add button to edit the options
		final Button editButton = new Button(composite, SWT.PUSH | SWT.CENTER);
		editButton.setText(Messages.getString("kiml.ui.21")); //$NON-NLS-1$
		editButton.setEnabled(false);
		editButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent event) {
				OptionsTableProvider.DataEntry entry = ETricePreferenceUtil
						.getEntry(entries, table.getSelectionIndex());
				if (entry != null) {
					ETricePreferenceUtil.showEditDialog(parent.getShell(),
							entry);
					tableViewer.refresh();
				}
			}
		});

		// add button to remove an option
		final Button removeButton = new Button(composite, SWT.PUSH | SWT.CENTER);
		removeButton.setText(Messages.getString("kiml.ui.22")); //$NON-NLS-1$
		removeButton.setEnabled(false);
		removeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent event) {
				OptionsTableProvider.DataEntry entry = ETricePreferenceUtil
						.getEntry(entries, table.getSelectionIndex());
				if (entry != null) {
					entry.setValue(null);
					tableViewer.refresh();
					int count = 0;
					for (OptionsTableProvider.DataEntry e : entries) {
						if (e.getValue() != null) {
							count++;
						}
					}
					if (count == 0) {
						editButton.setEnabled(false);
						removeButton.setEnabled(false);
					}
				}
			}
		});

		// react on selection changes of the options table
		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent event) {
				if (!entries.isEmpty() && event.item != null) {
					editButton.setEnabled(true);
					removeButton.setEnabled(true);
				} else {
					editButton.setEnabled(false);
					removeButton.setEnabled(false);
				}
			}
		});
		newButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent event) {
				int newIndex = showNewDialog(parent.getShell(), entries);
				if (newIndex >= 0) {
					tableViewer.refresh();
					tableViewer.setSelection(new StructuredSelection(entries
							.get(newIndex)));
					editButton.setEnabled(true);
					removeButton.setEnabled(true);
					column1.pack();
					column2.pack();
					column3.pack();
					column4.pack();
				}
			}
		});

		composite.setLayout(new FillLayout(SWT.VERTICAL));
		GridData compositeLayoutData = new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1);
		composite.setLayoutData(compositeLayoutData);
	}

	/**
	 * Shows an input dialog to add a new layout option to the list.
	 * 
	 * @param shell
	 *            the current shell
	 * @param entries
	 *            the list of table entries
	 * @return the table index to put focus on, or -1 if the focus should not be
	 *         changed
	 */
	private int showNewDialog(final Shell shell,
			final List<OptionsTableProvider.DataEntry> entries) {

		NewOptionDialog dialog = new NewOptionDialog(shell) {
			// Overriding the function for Behavior diagrams specific
			// implementation

			/**
			 * @author jayant
			 */
			@Override
			protected String showBrowseModelElementDialog() {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
						this.getShell(), new LabelProvider(),
						new TreeNodeContentProvider());
				dialog.setTitle("Select Behavior Model Element");

				TreeNode[] input = ETriceDomainModelElement.BEHAVIOR_MODEL
						.getChildren();
				dialog.setInput(input);

				if (dialog.open() == ElementTreeSelectionDialog.OK) {
					Object[] result = dialog.getResult();
					if (result != null && result.length > 0) {
						return ((ETriceDomainModelElement) result[0]).getId();
					}
				}
				return null;
			}

			/**
			 * @author jayant
			 */
			@Override
			protected String showBrowseDiagtDialog() {
				ListDialog dialog = new ListDialog(this.getShell());
				dialog.setTitle(Messages.getString("kiml.ui.57")); //$NON-NLS-1$
				dialog.setContentProvider(ArrayContentProvider.getInstance());
				dialog.setLabelProvider(new LabelProvider());

				SelectionData[] input = new SelectionData[ETriceDomainModelElement.BEHAVIOR_DIAGRAM_TYPES
						.size()];
				int i = 0;
				for (Pair<String, String> type : ETriceDomainModelElement.BEHAVIOR_DIAGRAM_TYPES) {
					SelectionData seld = new SelectionData(type);
					input[i++] = seld;
				}
				Arrays.sort(input);
				dialog.setInput(input);
				if (dialog.open() == ListDialog.OK) {
					Object[] result = dialog.getResult();
					if (result != null && result.length > 0) {
						return ((SelectionData) result[0]).getId();
					}
				}
				return null;
			}
		};

		if (dialog.open() == NewOptionDialog.OK) {
			OptionsTableProvider.DataEntry newEntry = dialog.createDataEntry();
			if (newEntry == null) {
				MessageDialog.openError(shell,
						Messages.getString("kiml.ui.51"),
						Messages.getString("kiml.ui.52"));
			} else {
				// look for an existing entry with same identifiers
				int oldIndex = 0;
				OptionsTableProvider.DataEntry oldEntry = null;
				for (OptionsTableProvider.DataEntry e : entries) {
					if (e.getValue() != null) {
						if (e.equals(newEntry)) {
							oldEntry = e;
							break;
						}
						oldIndex++;
					}
				}
				if (oldEntry != null) {
					return oldIndex;
				} else {
					entries.add(newEntry);
					return entries.size() - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	public void init(final IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getSharedPreferenceStore());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();

		// clear the layout options table
		for (OptionsTableProvider.DataEntry entry : optionEntries) {
			entry.setValue(null);
		}
		optionTableViewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean performOk() {
		EclipseLayoutInfoService infoService = EclipseLayoutInfoService
				.getInstance();
		IPreferenceStore preferenceStore = getPreferenceStore();

		// store data for the diagram element and diagram type options
		for (OptionsTableProvider.DataEntry entry : optionEntries) {
			Object oldValue = infoService.getOptionValue(entry.getElementId(),
					entry.getOptionData().getId());
			Object newValue = entry.getValue();
			if (oldValue == null && newValue != null
					|| !oldValue.equals(newValue)) {
				String preference = EclipseLayoutInfoService.getPreferenceName(
						entry.getElementId(), entry.getOptionData().getId());
				if (newValue == null) {
					infoService.removeOptionValue(entry.getElementId(), entry
							.getOptionData().getId());
					preferenceStore.setToDefault(preference);
					infoService.getRegisteredElements().remove(
							entry.getElementId());
				} else {
					infoService.addOptionValue(entry.getElementId(), entry
							.getOptionData().getId(), newValue);
					preferenceStore.setValue(preference, newValue.toString());
					if (entry.getType() != ElementType.DIAG_TYPE) {
						infoService.getRegisteredElements().add(
								entry.getElementId());
					}
				}
			}
		}

		LayoutViewPart layoutView = LayoutViewPart.findView();
		if (layoutView != null) {
			layoutView.refresh();
		}
		return true;
	}

}
