/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.ui.layout.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.LayoutDataService;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.LayoutOptionValidator;
import de.cau.cs.kieler.kiml.ui.LayouterHintDialog;
import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.service.EclipseLayoutDataService;
import de.cau.cs.kieler.kiml.ui.service.EclipseLayoutInfoService;

/**
 * The Utility class for eTrice Preference Pages. 
 * <p>
 * This class provides a few useful methods, an enumerated type and two static nested class :
 * <ul>
 * <li>{@link ElementType}</li>
 * <li>{@link NewOptionDialog}</li>
 * <li>{@link OptionsTableProvider}</li>
 * </ul>
 *  
 * @author jayant
 */
public final class ETricePreferenceUtil {

	/**
	 * Hidden constructor to avoid instantiation.
	 * 
	 * @author jayant
	 */
	private ETricePreferenceUtil() {

	}

	/** fixed height of the options table. */
	public static final int OPTIONS_TABLE_HEIGHT = 300;

	/**
	 * Fetches the entry with given index of a list of data entry, bypassing
	 * elements whose value was set to {@code null}.
	 * 
	 * @param entries
	 *            list of data entries
	 * @param index
	 *            index of the entry to look up
	 * @return the entry at the given index
	 */
	public static OptionsTableProvider.DataEntry getEntry(
			final List<OptionsTableProvider.DataEntry> entries, final int index) {
		ListIterator<OptionsTableProvider.DataEntry> entryIter = entries
				.listIterator();
		int i = 0;
		while (entryIter.hasNext()) {
			OptionsTableProvider.DataEntry entry = entryIter.next();
			if (entry.getValue() != null) {
				if (i == index) {
					return entry;
				}
				i++;
			}
		}
		return null;
	}

	/**
	 * Shows an input dialog to edit the given option table entry.
	 * 
	 * @param shell
	 *            the current shell
	 * @param entry
	 *            an option table entry
	 */
	public static void showEditDialog(final Shell shell,
			final OptionsTableProvider.DataEntry entry) {
		LayoutOptionData<?> optionData = entry.getOptionData();
		if (entry.getValue() != null) {
			if (optionData.equals(LayoutOptions.ALGORITHM)) {
				// show a selection dialog for a layouter hint
				LayouterHintDialog dialog = new LayouterHintDialog(shell, null);
				if (dialog.open() == LayouterHintDialog.OK) {
					String result = dialog.getSelectedHint();
					if (result != null) {
						entry.setValue(result);
					}
				}
			} else {
				// show an input dialog for some other option
				String value = entry.getValue().toString();
				InputDialog dialog = new InputDialog(shell,
						Messages.getString("kiml.ui.23"),
						Messages.getString("kiml.ui.24"), value,
						new LayoutOptionValidator(optionData));
				if (dialog.open() == InputDialog.OK) {
					String result = dialog.getValue().trim();
					switch (optionData.getType()) {
					case REMOTE_ENUM:
					case ENUM:
						entry.setValue(optionData.parseValue(result
								.toUpperCase()));
						break;
					default:
						entry.setValue(optionData.parseValue(result));
					}
				}
			}
		}
	}
	
	
	
	/**
	 * Enumeration of element types that can receive default options.
	 *
	 * @author msp
	 */
	public static enum ElementType {
	    
	    /** highest priority: edit parts of specific diagram editors. */
	    EDIT_PART,
	    
	    /** medium priority: domain model elements. */
	    MODEL_ELEM,
	    
	    /** lowest priority: diagram type definition (contributed via extension point). */
	    DIAG_TYPE;
	    
	    /**
	     * Returns a description for the element type.
	     * 
	     * @return a user-friendly description
	     */
	    public String getDescription() {
	        switch (this) {
	        case EDIT_PART:
	            return Messages.getString("kiml.ui.54");
	        case MODEL_ELEM:
	            return Messages.getString("kiml.ui.55");
	        case DIAG_TYPE:
	            return Messages.getString("kiml.ui.56");
	        }
	        return null;
	    }

	}
	
	
	
	/**
	 * A dialog to add new default layout options in the preference page.
	 * 
	 * @author msp
	 * @author jayant (adapted it for eTrice)
	 */
	public static class NewOptionDialog extends Dialog {

		/** the currently selected element type. */
		private ElementType elementType;
		/** the text for selection of a specific element. */
		private Text elementText;
		/** the value of the specific element or diagram type. */
		private String elementValue;
		/** the browse button for element selection. */
		private Button elementBrowseButton;
		/** the text for selection of a layout option. */
		private Text optionText;
		/** the value of the layout option identifier. */
		private String optionValue;

		/**
		 * Creates a new option dialog.
		 * 
		 * @param parentShell
		 *            the parent shell
		 */
		protected NewOptionDialog(final Shell parentShell) {
			super(parentShell);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setText(Messages.getString("kiml.ui.46")); //$NON-NLS-1$
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean close() {
			elementValue = elementText.getText();
			optionValue = optionText.getText();
			return super.close();
		}

		/** gap between label and control. */
		private static final int HORIZONTAL_GAP = 8;
		/** minimum width of each group. */
		private static final int MINIMUM_WIDTH = 500;

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Control createDialogArea(final Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			createTypeGroup(composite);
			createElementGroup(composite);
			createOptionGroup(composite);
			return composite;
		}

		/**
		 * Create group for element type selection.
		 * 
		 * @param parent
		 *            the parent control
		 */
		protected void createTypeGroup(final Composite parent) {
			Group group = new Group(parent, SWT.NONE);
			group.setText(Messages.getString("kiml.ui.42")); //$NON-NLS-1$
			GridLayout layout = new GridLayout(1, false);
			layout.horizontalSpacing = HORIZONTAL_GAP;
			group.setLayout(layout);
			String[][] labelsAndValues = new String[][] {
					{
							Messages.getString("kiml.ui.43"), ElementType.EDIT_PART.toString() }, //$NON-NLS-1$
					{
							Messages.getString("kiml.ui.44"), ElementType.MODEL_ELEM.toString() }, //$NON-NLS-1$
					{
							Messages.getString("kiml.ui.45"), ElementType.DIAG_TYPE.toString() } //$NON-NLS-1$
			};
			for (int i = 0; i < labelsAndValues.length; i++) {
				Button radio = new Button(group, SWT.RADIO | SWT.LEFT);
				radio.setSelection(i == 0);
				String[] labelAndValue = labelsAndValues[i];
				radio.setText(labelAndValue[0]);
				radio.setData(labelAndValue[1]);
				radio.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(final SelectionEvent event) {
						elementType = ElementType.valueOf((String) event.widget
								.getData());
						elementBrowseButton
								.setEnabled(elementType == ElementType.DIAG_TYPE
										|| elementType == ElementType.MODEL_ELEM);
					}
				});
			}
			elementType = ElementType.EDIT_PART;
			GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
			gridData.minimumWidth = MINIMUM_WIDTH;
			group.setLayoutData(gridData);
		}

		/**
		 * Create group for selection of specific element.
		 * 
		 * @param parent
		 *            the parent control
		 */
		protected void createElementGroup(final Composite parent) {
			Group group = new Group(parent, SWT.NONE);
			group.setText(Messages.getString("kiml.ui.47")); //$NON-NLS-1$
			group.setLayout(new GridLayout(2, false));
			Label label = new Label(group, SWT.WRAP);
			label.setText(Messages.getString("kiml.ui.53")); //$NON-NLS-1$
			GridData labelLayoutData = new GridData(SWT.LEFT, SWT.FILL, false,
					false, 2, 1);
			labelLayoutData.widthHint = MINIMUM_WIDTH - HORIZONTAL_GAP;
			label.setLayoutData(labelLayoutData);
			elementText = new Text(group, SWT.SINGLE | SWT.BORDER);
			elementText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
					false));
			elementBrowseButton = new Button(group, SWT.PUSH | SWT.CENTER);
			elementBrowseButton.setEnabled(false);
			elementBrowseButton.setText(Messages.getString("kiml.ui.48")); //$NON-NLS-1$
			elementBrowseButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent e) {
					String id = (elementType == ElementType.DIAG_TYPE) ? showBrowseDiagtDialog()
							: showBrowseModelElementDialog();
					if (id != null) {
						elementText.setText(id);
					}
				}
			});
			GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
			gridData.minimumWidth = MINIMUM_WIDTH;
			group.setLayoutData(gridData);
		}

		/**
		 * Create group for selection of a layout option.
		 * 
		 * @param parent
		 *            the parent control
		 */
		protected void createOptionGroup(final Composite parent) {
			Group group = new Group(parent, SWT.NONE);
			group.setText(Messages.getString("kiml.ui.49")); //$NON-NLS-1$
			group.setLayout(new GridLayout(2, false));
			optionText = new Text(group, SWT.SINGLE | SWT.BORDER);
			optionText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
					false));
			Button browseButton = new Button(group, SWT.PUSH | SWT.CENTER);
			browseButton.setText(Messages.getString("kiml.ui.48")); //$NON-NLS-1$
			browseButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent e) {
					String id = showBrowseOptionDialog();
					if (id != null) {
						optionText.setText(id);
					}
				}
			});
			GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
			gridData.minimumWidth = MINIMUM_WIDTH;
			group.setLayoutData(gridData);

		}

		/** data holder class for selection of a layout option or diagram type. */
		protected static final class SelectionData implements
				Comparable<SelectionData> {
			private String id;

			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			private String name;
			private LayoutOptionData.Type type;

			/**
			 * Create a selection data object from a layout option data.
			 * 
			 * @param optionData
			 *            a layout option data
			 */
			public SelectionData(final LayoutOptionData<?> optionData) {
				this.id = optionData.getId();
				this.name = optionData.getName();
				this.type = optionData.getType();
			}

			/**
			 * Create a selection data object from a diagram type.
			 * 
			 * @param diagramType
			 *            a pair with the diagram type identifier as first
			 *            element and the name as second element
			 */
			public SelectionData(final Pair<String, String> diagramType) {
				this.id = diagramType.getFirst();
				this.name = diagramType.getSecond();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean equals(final Object object) {
				if (object instanceof SelectionData) {
					SelectionData other = (SelectionData) object;
					return this.id.equals(other.id)
							&& this.name.equals(other.name);
				}
				return false;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int hashCode() {
				return id.hashCode() + name.hashCode();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String toString() {
				return name + " (" + id + ")";
			}

			/**
			 * {@inheritDoc}
			 */
			public int compareTo(final SelectionData other) {
				int nameComp = this.name.compareTo(other.name);
				if (nameComp == 0) {
					return this.id.compareTo(other.id);
				} else {
					return nameComp;
				}
			}
		}

		/**
		 * Open a dialog to browse diagram types.
		 * 
		 * @return the selected diagram type
		 */
		protected String showBrowseDiagtDialog() {
			ListDialog dialog = new ListDialog(this.getShell());
			dialog.setTitle(Messages.getString("kiml.ui.57")); //$NON-NLS-1$
			dialog.setContentProvider(ArrayContentProvider.getInstance());
			dialog.setLabelProvider(new LabelProvider());
			List<Pair<String, String>> diagramTypes = EclipseLayoutInfoService
					.getInstance().getDiagramTypes();
			SelectionData[] input = new SelectionData[diagramTypes.size()];
			int i = 0;
			for (Pair<String, String> type : diagramTypes) {
				SelectionData seld = new SelectionData(type);
				input[i++] = seld;
			}
			Arrays.sort(input);
			dialog.setInput(input);
			if (dialog.open() == ListDialog.OK) {
				Object[] result = dialog.getResult();
				if (result != null && result.length > 0) {
					return ((SelectionData) result[0]).id;
				}
			}
			return null;
		}

		/**
		 * Open a dialog to browse Domain Model Elements (Classes).
		 * 
		 * @return the selected Model Element
		 * 
		 * @author jayant
		 */
		protected String showBrowseModelElementDialog() {
			// The Exact Implementation depends on the respective preference
			// classes
			// from which the New Dialog is invoked

			return "null";
		}

		/**
		 * Open a dialog to browse layout options.
		 * 
		 * @return the selected layout option
		 */
		protected String showBrowseOptionDialog() {
			ListDialog dialog = new ListDialog(this.getShell());
			dialog.setTitle(Messages.getString("kiml.ui.50")); //$NON-NLS-1$
			dialog.setContentProvider(ArrayContentProvider.getInstance());
			dialog.setLabelProvider(new LabelProvider() {
				public Image getImage(final Object element) {
					if (element instanceof SelectionData) {
						KimlUiPlugin.Images images = KimlUiPlugin.getDefault()
								.getImages();
						switch (((SelectionData) element).type) {
						case OBJECT:
						case STRING:
							return images.getPropText();
						case BOOLEAN:
							return images.getPropTrue();
						case REMOTE_ENUM:
						case ENUM:
							return images.getPropChoice();
						case INT:
							return images.getPropInt();
						case FLOAT:
							return images.getPropFloat();
						default:
							break;
						}
					}
					return null;
				}
			});
			Collection<LayoutOptionData<?>> data = EclipseLayoutDataService
					.getInstance().getOptionData();
			ArrayList<SelectionData> inputList = new ArrayList<SelectionData>(
					data.size());
			for (LayoutOptionData<?> optionData : data) {
				// layout options without target definition are now shown to the
				// user
				if (!optionData.getTargets().isEmpty()) {
					inputList.add(new SelectionData(optionData));
				}
			}
			SelectionData[] input = inputList.toArray(new SelectionData[0]);
			Arrays.sort(input);
			dialog.setInput(input);
			if (dialog.open() == ListDialog.OK) {
				Object[] result = dialog.getResult();
				if (result != null && result.length > 0) {
					return ((SelectionData) result[0]).id;
				}
			}
			return null;
		}

		/**
		 * Create a new data entry for the layout option.
		 * 
		 * @return a new data entry, or {@code null} if the dialog contents are
		 *         invalid
		 */
		public OptionsTableProvider.DataEntry createDataEntry() {
			if (elementValue != null && optionValue != null) {
				String name;
				if (elementType == ElementType.DIAG_TYPE) {
					name = EclipseLayoutInfoService.getInstance()
							.getDiagramTypeName(elementValue);
				} else {
					int dotIndex = elementValue.lastIndexOf('.');
					name = elementValue.substring(dotIndex + 1);
				}
				LayoutOptionData<?> optionData = LayoutDataService
						.getInstance().getOptionData(optionValue);
				if (optionData != null) {
					Object value = optionData.getDefault();
					if (value == null) {
						value = optionData.getDefaultDefault();
					}
					if (name != null && value != null) {
						return new OptionsTableProvider.DataEntry(name,
								elementValue, elementType, optionData, value);
					}
				}
			}
			return null;
		}

	}

	/**
	 * Provider class for the options tables. Contains a label provider and a
	 * content provider.
	 * 
	 * @author msp
	 */
	public static class OptionsTableProvider extends LabelProvider implements
			ITableLabelProvider, IStructuredContentProvider {

		/** data type for row entries in the table. */
		public static class DataEntry {
			/** name of the associated diagram type or element. */
			private String elementName;
			/** identifier of the associated diagram type or element type. */
			private String elementId;
			/** type of element (diagram type / model element / edit part). */
			private ElementType type;
			/** layout option data. */
			private LayoutOptionData<?> optionData;
			/** the current value. */
			private Object value;

			/**
			 * Creates a data entry.
			 * 
			 * @param name
			 *            name of the associated diagram type or element
			 * @param id
			 *            identifier of the associated diagram type or element
			 *            type
			 * @param thetype
			 *            type of element (diagram type / model element / edit
			 *            part)
			 * @param theoptionData
			 *            layout option data
			 * @param thevalue
			 *            the current value
			 */
			public DataEntry(final String name, final String id,
					final ElementType thetype,
					final LayoutOptionData<?> theoptionData,
					final Object thevalue) {
				this.elementName = name;
				this.elementId = id;
				this.type = thetype;
				this.optionData = theoptionData;
				this.value = thevalue;
			}

			/**
			 * Returns the associated element name.
			 * 
			 * @return the name of the associated element
			 */
			public String getElementName() {
				return elementName;
			}

			/**
			 * Returns the associated element identifier.
			 * 
			 * @return the identifier of the associated element
			 */
			public String getElementId() {
				return elementId;
			}

			/**
			 * Returns the type of element (diagram type / model element / edit
			 * part).
			 * 
			 * @return the element type
			 */
			public ElementType getType() {
				return type;
			}

			/**
			 * Returns the option data.
			 * 
			 * @return the option data
			 */
			public LayoutOptionData<?> getOptionData() {
				return optionData;
			}

			/**
			 * Returns the value.
			 * 
			 * @return the value
			 */
			public Object getValue() {
				return value;
			}

			/**
			 * Sets the value.
			 * 
			 * @param thevalue
			 *            the new value
			 */
			public void setValue(final Object thevalue) {
				this.value = thevalue;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean equals(final Object object) {
				if (object instanceof DataEntry) {
					DataEntry other = (DataEntry) object;
					return this.elementId.equals(other.elementId)
							&& this.optionData.equals(other.optionData);
				} else {
					return false;
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int hashCode() {
				return elementId.hashCode() + optionData.hashCode();
			}
		}

		/** the "Element" column. */
		private static final int COL_ELEMENT = 0;
		/** the "Type" column. */
		private static final int COL_TYPE = 1;
		/** the "Option" column. */
		private static final int COL_OPTION = 2;
		/** the "Value" column. */
		private static final int COL_VALUE = 3;

		/**
		 * {@inheritDoc}
		 */
		public Image getColumnImage(final Object element, final int columnIndex) {
			if (element instanceof DataEntry && columnIndex == COL_VALUE) {
				DataEntry entry = (DataEntry) element;
				KimlUiPlugin.Images images = KimlUiPlugin.getDefault()
						.getImages();
				switch (entry.optionData.getType()) {
				case STRING:
					return images.getPropText();
				case BOOLEAN:
					if ((Boolean) entry.value) {
						return images.getPropTrue();
					} else {
						return images.getPropFalse();
					}
				case REMOTE_ENUM:
				case ENUM:
					return images.getPropChoice();
				case INT:
					return images.getPropInt();
				case FLOAT:
					return images.getPropFloat();
				default:
					break;
				}
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getColumnText(final Object element, final int columnIndex) {
			if (element instanceof DataEntry) {
				DataEntry entry = (DataEntry) element;
				switch (columnIndex) {
				case COL_ELEMENT:
					return entry.elementName;
				case COL_TYPE:
					return entry.type.getDescription();
				case COL_OPTION:
					return entry.optionData.getName();
				case COL_VALUE:
					if (entry.optionData.getType() == LayoutOptionData.Type.ENUM
							&& entry.value instanceof Integer) {
						return entry.optionData.getEnumValue(
								(Integer) entry.value).toString();
					} else {
						return entry.value.toString();
					}
				}
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(final Object inputElement) {
			if (inputElement instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<DataEntry> list = new ArrayList<DataEntry>(
						(List<DataEntry>) inputElement);
				ListIterator<DataEntry> listIter = list.listIterator();
				while (listIter.hasNext()) {
					DataEntry next = listIter.next();
					if (next.value == null) {
						listIter.remove();
					}
				}
				return list.toArray();
			} else if (inputElement instanceof Object[]) {
				return (Object[]) inputElement;
			} else {
				return null;
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(final Viewer viewer, final Object oldInput,
				final Object newInput) {
		}

	}

}
