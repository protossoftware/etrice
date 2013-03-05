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

import org.eclipse.etrice.ui.layout.Activator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.kiml.ui.Messages;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutHandler;
import de.cau.cs.kieler.kiml.ui.service.EclipseLayoutInfoService;

/**
 * Preference page for common KIML preferences.
 * 
 * @author jayant
 */
public class ETriceLayoutPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	/** checkbox for animation. */
	private Button animationCheckBox;
	/** checkbox for zoom-to-fit. */
	private Button zoomCheckBox;
	/** checkbox for progress dialog. */
	private Button progressCheckBox;
	/** checkbox for edge routing style. */
	private Button obliqueCheckBox;

	/**
	 * Creates the layout preference page.
	 * 
	 * @author jayant
	 */
	public ETriceLayoutPreferencePage() {
		super();
		setDescription("Preferences for eTrice automatic diagram layout");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	protected Control createContents(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		Group generalGroup = createGeneralGroup(composite);
		generalGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Label redirectionText = new Label(composite, SWT.WRAP);
		redirectionText.setAlignment(SWT.LEFT);
		redirectionText
				.setText("Use sub-pages to set Diagram specific preferences");

		GridLayout compositeLayout = new GridLayout(1, false);
		composite.setLayout(compositeLayout);

		return composite;
	}

	/** margin width for layouts. */
	private static final int MARGIN_WIDTH = 10;
	/** margin height for layouts. */
	private static final int MARGIN_HEIGHT = 5;

	/**
	 * Creates the group for general options.
	 * 
	 * @param parent
	 *            the parent control
	 * @return a group with general options
	 */
	private Group createGeneralGroup(final Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(Messages.getString("kiml.ui.35")); //$NON-NLS-1$

		// add check box for animation
		animationCheckBox = new Button(generalGroup, SWT.CHECK | SWT.LEFT);
		animationCheckBox.setText(Messages.getString("kiml.ui.64")); //$NON-NLS-1$
		animationCheckBox.setSelection(getPreferenceStore().getBoolean(
				LayoutHandler.PREF_ANIMATION));

		// add check box for zoom-to-fit
		zoomCheckBox = new Button(generalGroup, SWT.CHECK | SWT.LEFT);
		zoomCheckBox.setText(Messages.getString("kiml.ui.65")); //$NON-NLS-1$
		zoomCheckBox.setSelection(getPreferenceStore().getBoolean(
				LayoutHandler.PREF_ZOOM));

		// add check box for progress dialog
		progressCheckBox = new Button(generalGroup, SWT.CHECK | SWT.LEFT);
		progressCheckBox.setText(Messages.getString("kiml.ui.66")); //$NON-NLS-1$
		progressCheckBox.setSelection(getPreferenceStore().getBoolean(
				LayoutHandler.PREF_PROGRESS));

		// add check box for oblique routing
		obliqueCheckBox = new Button(generalGroup, SWT.CHECK | SWT.LEFT);
		obliqueCheckBox.setText(Messages.getString("kiml.ui.36")); //$NON-NLS-1$
		obliqueCheckBox.setSelection(getPreferenceStore().getBoolean(
				EclipseLayoutInfoService.PREF_OBLIQUE_ROUTE));

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginWidth = MARGIN_WIDTH;
		layout.marginHeight = MARGIN_HEIGHT;
		generalGroup.setLayout(layout);
		return generalGroup;
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
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();
		IPreferenceStore preferenceStore = getPreferenceStore();

		// set default values for the general options
		animationCheckBox.setSelection(preferenceStore
				.getDefaultBoolean(LayoutHandler.PREF_ANIMATION));
		zoomCheckBox.setSelection(preferenceStore
				.getDefaultBoolean(LayoutHandler.PREF_ZOOM));
		progressCheckBox.setSelection(preferenceStore
				.getDefaultBoolean(LayoutHandler.PREF_PROGRESS));
		obliqueCheckBox
				.setSelection(preferenceStore
						.getDefaultBoolean(EclipseLayoutInfoService.PREF_OBLIQUE_ROUTE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		IPreferenceStore preferenceStore = getPreferenceStore();

		// set new values for the general options
		preferenceStore.setValue(LayoutHandler.PREF_ANIMATION,
				animationCheckBox.getSelection());
		preferenceStore.setValue(LayoutHandler.PREF_ZOOM,
				zoomCheckBox.getSelection());
		preferenceStore.setValue(LayoutHandler.PREF_PROGRESS,
				progressCheckBox.getSelection());
		preferenceStore.setValue(EclipseLayoutInfoService.PREF_OBLIQUE_ROUTE,
				obliqueCheckBox.getSelection());

		return true;
	}

}
