/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Jayant Gupta (contributed Action Code Editor)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.dialogs;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.ActionCodeEditorRegistry;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.ActionCodeEditorRegistry.ActionCodeEditorRegistryEntry;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.preferences.PreferenceConstants;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.dialogs.AbstractPropertyDialog;
import org.eclipse.etrice.ui.common.base.dialogs.MultiValidator2;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractMemberAwarePropertyDialog extends AbstractPropertyDialog implements IMemberAwareConfiguration {
	
	private class LastControlListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			if (e.getSource() instanceof Control) {
				boolean enableMemberButton = memberAware
						.contains(e.getSource());
				boolean enableMessageButton = messageAware.contains(e
						.getSource());
				if (enableMemberButton || enableMessageButton)
					lastFocusedField = (Control) e.getSource();
				else
					lastFocusedField = null;
				members.setEnabled(enableMemberButton);
				messages.setEnabled(enableMessageButton);
			} else {
				lastFocusedField = null;
				members.setEnabled(false);
				messages.setEnabled(false);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
		}
	}

	@Inject
	protected IFSMDialogFactory dialogFactory;
	
	private Control lastFocusedField = null;
	private Button members;
	private Button messages;
	private ModelComponent mc;
	private LastControlListener listener = new LastControlListener();
	private HashSet<Control> memberAware = new HashSet<Control>();
	private HashSet<Control> messageAware = new HashSet<Control>();
	private HashSet<Control> recvOnly = new HashSet<Control>();

	/**
	 * 
	 * @author jayant
	 */
	private HashMap<Control, IActionCodeEditor> actionEditorControlMap = new HashMap<Control, IActionCodeEditor>();

	/**
	 * @param shell
	 * @param title
	 * @param mc
	 */
	public AbstractMemberAwarePropertyDialog(Shell shell, String title, ModelComponent mc) {
		super(shell, title);
		this.mc = mc;
	}

	/**
	 * @return the ac
	 */
	public ModelComponent getModelComponent() {
		return mc;
	}

	/**
	 * @param body
	 */
	protected void createMembersAndMessagesButtons(Composite body) {
		Composite buttonsArea = getToolkit().createComposite(body);
		buttonsArea.setLayout(new GridLayout(2, true));
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.horizontalSpan = 2;
		buttonsArea.setLayoutData(gd);

		members = new Button(buttonsArea, SWT.PUSH);
		members.setText("Mem&bers");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		members.setLayoutData(gd);
		members.setEnabled(false);
		members.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleMembersPressed();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleMembersPressed();
			}
		});

		messages = new Button(buttonsArea, SWT.PUSH);
		messages.setText("Me&ssages");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		messages.setLayoutData(gd);
		messages.setEnabled(false);
		messages.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleMessagesPressed();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleMessagesPressed();
			}
		});
	}

	/**
	 * A delegate to
	 * {@link #createActionCodeEditor(Composite, String, DetailCode, EObject, EStructuralFeature, IValidator, MultiValidator2, IConverter, IConverter, boolean, boolean, boolean)}
	 * 
	 * @author jayant
	 */
	protected IActionCodeEditor createActionCodeEditor(Composite parent,
			String label, DetailCode detailCode, EObject obj,
			EStructuralFeature feat, IConverter s2m, IConverter m2s, IDetailExpressionProvider exprPovider) {
		return createActionCodeEditor(parent, label, detailCode, obj, feat,
				null, null, s2m, m2s, true, true, false, exprPovider);
	}

	/**
	 * Creates Action Code Editor with the given parameters and binds it with the
	 * model.
	 * 
	 * @author jayant
	 * 
	 * @param parent
	 *            the {@link Composite} which will hold the editor
	 * @param label
	 *            the label for the editor
	 * @param detailCode
	 *            the {@link DetailCode} object to be represented
	 * @param obj
	 *            the EMF object containing the detailCode code
	 * @param feat
	 *            the {@link EStructuralFeature} associated with the code
	 * @param singleValidator
	 *            an {@link IValidator} for the JFace Data binding
	 * @param multiValidator
	 *            a {@link MultiValidator2} for the JFace Data binding
	 * @param s2m
	 *            a String to Model converter
	 * @param m2s
	 *            a Model to string converter
	 * @param useMembers
	 *            true if the editor is to be member aware
	 * @param useMessages
	 *            true if the editor is to be message aware
	 * @param useRecvMessagesOnly
	 *            true if the editor could use receive messages only
	 * 
	 * @return the constructed instance of {@link IActionCodeEditor}
	 */
	protected IActionCodeEditor createActionCodeEditor(Composite parent,
			String label, DetailCode detailCode, EObject obj,
			EStructuralFeature feat, IValidator singleValidator,
			MultiValidator2 multiValidator, IConverter s2m, IConverter m2s,
			boolean useMembers, boolean useMessages, boolean useRecvMessagesOnly, IDetailExpressionProvider exprPovider) {
		Label l = getToolkit().createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));

		// get target language and selected editor
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String targetLanguage = store.getString(PreferenceConstants.EDITOR_LANGUAGE);
		String editor = (targetLanguage.equals(PreferenceConstants.JAVA_LANGUAGE))?
				PreferenceConstants.JAVA_EDITOR_PREFERENCE : PreferenceConstants.CPP_EDITOR_PREFERENCE;

		// Get editor id from preferences
		String id = Activator.getDefault().getPreferenceStore()
				.getString(editor);

		// Create new editor instance
		ActionCodeEditorRegistryEntry editorEntry = ActionCodeEditorRegistry.INSTANCE.getEditorWithId(id);
		if(editorEntry == null)
			return null;
		String editorText = FSMSupportUtil.getInstance().getFSMHelpers().getDetailCode(detailCode);
		IActionCodeEditor actionCodeEditor = editorEntry.newActionCodeEditor(parent, editorText, exprPovider);
		if (actionCodeEditor != null) {
			configureMemberAwareness(actionCodeEditor, useMembers, useMessages,
					useRecvMessagesOnly);
			getToolkit().adapt(actionCodeEditor.getControl(), true, true);

			// JFace Data-binding of editor's control with model.
			UpdateValueStrategy t2m = null;
			UpdateValueStrategy m2t = null;
			if (singleValidator != null || s2m != null || m2s != null) {
				t2m = new UpdateValueStrategy();
				if (s2m != null)
					t2m.setConverter(s2m);
				if (singleValidator != null) {
					t2m.setAfterConvertValidator(singleValidator);
					t2m.setBeforeSetValidator(singleValidator);
				}
				m2t = new UpdateValueStrategy();
				if (m2s != null)
					m2t.setConverter(m2s);
				if (singleValidator != null) {
					m2t.setAfterConvertValidator(singleValidator);
					m2t.setBeforeSetValidator(singleValidator);
				}
			}
			Object type = (s2m != null) ? s2m.getToType() : String.class;
			createBinding(actionCodeEditor.getControl(), obj, feat, type, t2m,
					m2t, multiValidator);
		}

		return actionCodeEditor;
	}

	protected void handleMembersPressed() {
		ISelectionDialog dlg = dialogFactory.createMemberSelectionDialog(getShell(), mc);
		if (dlg.open()==Window.OK) {
			insertText(dlg.getSelected());
		}
	}

	protected void handleMessagesPressed() {
		boolean receiveOnly = recvOnly.contains(lastFocusedField);
		ISelectionDialog dlg = dialogFactory.createMessageSelectionDialog(getShell(), mc, receiveOnly);
		if (dlg.open()==Window.OK) {
			insertText(dlg.getSelected());
		}
	}

	private void insertText(String txt) {
		if (lastFocusedField != null) {
			if (actionEditorControlMap.containsKey(lastFocusedField)) {
				(actionEditorControlMap.get(lastFocusedField)).insertText(txt);
			} else if (lastFocusedField instanceof Text) {
				Text lastTextField = (Text) lastFocusedField;
				int begin = txt.indexOf('(');
				int end = txt.indexOf(')');
				int offset = lastTextField.getSelection().x;
				lastTextField.insert(txt);
				if (begin >= 0 && end >= 0 && end > begin + 1)
					lastTextField
							.setSelection(offset + begin + 1, offset + end);
				lastTextField.setFocus();
			}
		}
	}

	@Override
	public void configureMemberAwareness(Control ctrl) {
		configureMemberAwareness(ctrl, false, false);
	}
	
	@Override
	public void configureMemberAwareness(Control ctrl, boolean useMembers, boolean useMessages) {
		configureMemberAwareness(ctrl, useMembers, useMembers, false);
	}
	
	@Override
	public void configureMemberAwareness(Control ctrl, boolean useMembers, boolean useMessages, boolean useRecvMessagesOnly) {
		if (useMembers)
			memberAware.add(ctrl);
		if (useMessages)
			messageAware.add(ctrl);
		if (useRecvMessagesOnly)
			recvOnly.add(ctrl);
		ctrl.addFocusListener(listener);
	}

	/**
	 * Configure an action code editor to the level of awareness. Helps activate
	 * and deactivate member and message buttons.
	 * 
	 * @author jayant
	 * 
	 * @param actionCodeEditor
	 *            the {@link IActionCodeEditor} instance to configure
	 * @param useMembers
	 *            true if the editor is to be member aware
	 * @param useMessages
	 *            true if the editor is to be message aware
	 * @param useRecvMessagesOnly
	 *            true if the editor could use receive messages only
	 */
	public void configureMemberAwareness(IActionCodeEditor actionCodeEditor,
			boolean useMembers, boolean useMessages, boolean useRecvMessagesOnly) {
		Control ctrl = actionCodeEditor.getControl();
		actionEditorControlMap.put(ctrl, actionCodeEditor);
		configureMemberAwareness(ctrl, useMembers, useMessages, useRecvMessagesOnly);
	}
}
