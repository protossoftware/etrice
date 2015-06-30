/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.doc.ContextHelpProvider;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.xtext.resource.IEObjectDescription;


public abstract class AbstractPropertyDialog extends FormDialog {
	
	private class GlobalStatus extends ComputedValue {
		Collection<ControlDecoration> decorations = decoratorMap.keySet();

		/**
		 * @param valueType
		 */
		private GlobalStatus(Object valueType) {
			super(valueType);
		}
		
		@Override
		protected Object calculate() {
			boolean ok = true;
			IStatus newStatus = getGlobalValidationStatus();
			if (newStatus.getSeverity() > IStatus.OK)
				if (!newStatus.getMessage().isEmpty())
					validationText.setText(newStatus.getMessage());
			
			// iterate over all decoration and there validation status
			for(ControlDecoration decoration: decorations){
				IObservableValue observableValue = decoratorMap.get(decoration);
				IStatus status = (IStatus) observableValue.getValue();
				
				if (!status.isOK()) {
					// validation error
					ok = false;
					decoration.setDescriptionText(status.getMessage());
					decoration.show();
					// select severest and meaningful message
					if (status.getSeverity() > newStatus.getSeverity())
						if (!status.getMessage().isEmpty())
							newStatus = status;
				} else
					decoration.hide();
			}
			
			updateValidationFeedback(ok && newStatus.isOK());
			return newStatus;
		}
	}

	static class DescriptionBased_Reference2StringConverter extends Converter {

		private EAttribute nameAttr;

		DescriptionBased_Reference2StringConverter(Object type, EAttribute nameAttr) {
			super(type, String.class);
			this.nameAttr = nameAttr;
		}
		
		@Override
		public Object convert(Object fromObject) {
			if (fromObject instanceof IEObjectDescription)
				return ((IEObjectDescription)fromObject).getName();
			else if (fromObject instanceof EObject) {
				return ((EObject)fromObject).eGet(nameAttr);
			}
			
			return null;
		}
		
	}
	
	static class DescriptionBased_String2ReferenceConverter extends Converter {
		private EObject obj;
		private List<IEObjectDescription> candidates;

		DescriptionBased_String2ReferenceConverter(Object type, EObject obj, List<IEObjectDescription> candidates) {
			super(String.class, type);
			this.obj = obj;
			this.candidates = candidates;
		}

		@Override
		public Object convert(Object fromObject) {
			for (IEObjectDescription desc : candidates) {
				if (desc.getName().toString().equals(fromObject)) {
					EObject refObj = desc.getEObjectOrProxy();
					if (refObj.eIsProxy())
						refObj = EcoreUtil.resolve(refObj, obj);
					return refObj;
				}
			}
			return null;
		}
	}

	static class Reference2StringConverter extends Converter {

		private EAttribute nameAttr;

		Reference2StringConverter(Object type, EAttribute nameAttr) {
			super(type, String.class);
			this.nameAttr = nameAttr;
		}
		
		@Override
		public Object convert(Object fromObject) {
			return ((EObject)fromObject).eGet(nameAttr);
		}
		
	}
	
	static class String2ReferenceConverter extends Converter {
		private List<? extends EObject> candidates;
		private EAttribute nameAttr;

		String2ReferenceConverter(Object type, List<? extends EObject> candidates, EAttribute nameAttr) {
			super(String.class, type);
			this.candidates = candidates;
			this.nameAttr = nameAttr;
		}

		@Override
		public Object convert(Object fromObject) {
			for (EObject obj : candidates) {
				if (obj.eGet(nameAttr).equals(fromObject))
					return obj;
			}
			return null;
		}
	}

	static class Enum2StringConverter extends Converter {

		Enum2StringConverter() {
			super(Enumerator.class, String.class);
		}
		
		@Override
		public Object convert(Object fromObject) {
			return ((Enumerator)fromObject).getLiteral();
		}
	}

	static class String2EnumConverter extends Converter {

		private List<? extends Enumerator> choices;

		String2EnumConverter(Object type, List<? extends Enumerator> choices) {
			super(String.class, type);
			this.choices = choices;
		}
		
		@Override
		public Object convert(Object fromObject) {
			for (Enumerator choice : choices) {
				if (choice.getLiteral().equals(fromObject))
					return choice;
			}
			return null;
		}
	}
	
	
	private static String PREF_KEY_WIDTH = ".width";
	private static String PREF_KEY_HEIGHT = ".height";
	private static String WIDGET_DATA_KEY_VALSTATUS = "etrice.status";
		
	private IPreferenceStore preferenceStore;
	private String title;
	private FormToolkit toolkit;
	private DataBindingContext bindingContext;
	
	// decoration -> validation status
	private HashMap<ControlDecoration, IObservableValue> decoratorMap = new HashMap<ControlDecoration, IObservableValue>();
	
	// top validation message
	private GlobalStatus displayedValidationStatus;
	private Label validationLabel;
	private Label validationText;

	public AbstractPropertyDialog(Shell shell, String title) {
		super(shell);
		this.title = title;
		this.preferenceStore = UIBaseActivator.getDefault().getPreferenceStore();
	}

	abstract protected Image getImage();
	
	@Override
	public int open() {
		
		if(getShell() == null)
			create();
		
		setupUserDialogSize();
		
		return super.open();
	}
	
	@Override
	protected void createFormContent(IManagedForm mform) {
		toolkit = mform.getToolkit();
		bindingContext = new DataBindingContext();

		Form form = mform.getForm().getForm();
		form.setText(title);		
		
		form.setImage(getImage());
		mform.getToolkit().decorateFormHeading(form);

		Composite body = form.getBody();
		body.setLayout(new GridLayout(2, false));
		body.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        validationLabel = toolkit.createLabel(body, "", SWT.NONE);
        validationLabel.setText("ERROR:");
        validationLabel.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));

        validationText = toolkit.createLabel(
                body, "", SWT.NONE);
        validationText
                .setLayoutData(new GridData(
                        GridData.FILL_HORIZONTAL));

		createContent(mform, body, bindingContext);
				
		displayedValidationStatus = new GlobalStatus(IStatus.class);
		
		bindingContext.bindValue(WidgetProperties.text().observe(validationText), displayedValidationStatus);
		
		String featureId = getFeatureContextHelpId();
		if(ContextHelpProvider.isAvailable(featureId)){
			ContextHelpProvider.setHelp(body, featureId);
			setHelpAvailable(true);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.FormDialog#createButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createButtonBar(Composite parent) {
		Control bar = super.createButtonBar(parent);

		Object value = displayedValidationStatus.getValue();
		if (value instanceof IStatus) {
			boolean ok = ((IStatus) value).isOK();
			updateValidationFeedback(ok);
		}

		return bar;
	}

	protected void setValidationFeedbackOff() {
		if (validationLabel.isDisposed())
			return;
		
		validationLabel.setVisible(false);
		validationText.setVisible(false);
		
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (okButton!=null)
			okButton.setEnabled(false);
	}

	protected void updateValidationFeedback(boolean ok) {
		if (validationLabel.isDisposed())
			return;
		
		validationLabel.setVisible(!ok);
		validationText.setVisible(!ok);
		
		Button okButton = getButton(IDialogConstants.OK_ID);
		if (okButton!=null)
			okButton.setEnabled(ok);
	}
	
	protected void setValidationText (String text) {
		validationText.setText(text);
	}
	
	protected abstract void createContent(IManagedForm mform, Composite body,
			DataBindingContext bindingContext);
	
	protected Text createText(Composite parent, String label, EObject obj, EAttribute att) {
		return createText(parent, label, obj, att, null);
	}
	
	protected Text createText(Composite parent, String label, EObject obj, EAttribute att, IValidator validator) {
		return createText(parent, label, obj, att, validator, false);
	}
	
	protected Text createText(Composite parent, String label, EObject obj, EAttribute att, IValidator validator, boolean multiline) {
		return createText(parent, label, obj, att, validator, null, null, multiline);
	}
	
	protected Text createText(Composite parent, String label, EObject obj, EStructuralFeature feat, IValidator validator, IConverter s2m, IConverter m2s, boolean multiline) {
		return createText(parent, label, obj, feat, validator, null, s2m, m2s, multiline);
	}
	
	protected Text createText(Composite parent, String label, EObject obj, EStructuralFeature feat, IValidator singleValidator, MultiValidator2 multiValidator, IConverter s2m, IConverter m2s, boolean multiline) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));
		
		int style = SWT.BORDER;
		if (multiline)
			style |= SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
		Text text = toolkit.createText(parent, "", style);
		GridData gd = new GridData(multiline?GridData.FILL_BOTH:GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);
		
		UpdateValueStrategy t2m = null;
		UpdateValueStrategy m2t = null;
		if (singleValidator!=null || s2m!=null || m2s!=null) {
			t2m = new UpdateValueStrategy();
			if (s2m!=null)
				t2m.setConverter(s2m);
			if (singleValidator!=null) {
				t2m.setAfterConvertValidator(singleValidator);
				t2m.setBeforeSetValidator(singleValidator);
			}
			m2t = new UpdateValueStrategy();
			if (m2s!=null)
				m2t.setConverter(m2s);
			if (singleValidator!=null) {
				m2t.setAfterConvertValidator(singleValidator);
				m2t.setBeforeSetValidator(singleValidator);
			}
		}
		
		Object type = (s2m!= null)?s2m.getToType():String.class;
		createBinding(text, obj, feat, type, t2m, m2t, multiValidator);
		
		return text;
	}
	
	protected Text createFixedText(Composite parent, String label, String txt, boolean multiline) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));
		
		int style = SWT.BORDER;
		if (multiline)
			style |= SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
		Text text = toolkit.createText(parent, txt, style);
		GridData gd = new GridData(multiline?GridData.FILL_BOTH:GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);
		text.setEnabled(false);
		
		return text;
	}
	
	protected Button createCheck(Composite parent, String label, EObject obj, EAttribute att) {
		return createCheck(parent, label, obj, att, null, null);
	}
	
	protected Button createCheck(Composite parent, String label, EObject obj, EAttribute att, IValidator validator, MultiValidator2 multiValidator) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));
		
		Button check = toolkit.createButton(parent, "", SWT.CHECK);
		check.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		UpdateValueStrategy t2m = null;
		UpdateValueStrategy m2t = null;
		if (validator!=null) {
			t2m = new UpdateValueStrategy();
			t2m.setAfterConvertValidator(validator);
			t2m.setBeforeSetValidator(validator);
			m2t = new UpdateValueStrategy();
			m2t.setAfterConvertValidator(validator);
			m2t.setBeforeSetValidator(validator);
		}
		createBinding(check, obj, att, Boolean.class, t2m, m2t, multiValidator);
		
		return check;
	}
	
	protected Combo createCombo(Composite parent, String label, EObject obj, Object type, EReference ref, List<? extends EObject> candidates, EAttribute nameAttr) {
		return createCombo(parent, label, obj, type, ref, candidates, nameAttr, null, null);
	}
	
	protected Combo createCombo(Composite parent, String label, EObject obj, Object type, EReference ref, List<? extends EObject> candidates, EAttribute nameAttr, IValidator validator, MultiValidator2 multiValidator) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));

		Combo combo = new Combo(parent, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.HORIZONTAL));
		combo.setVisibleItemCount(10);
		toolkit.adapt(combo, true, true);
		
		Reference2StringConverter r2s = new Reference2StringConverter(type, nameAttr);
		for (EObject o : candidates) {
			combo.add((String) r2s.convert(o));
		}
		
		String2ReferenceConverter s2r = new String2ReferenceConverter(type, candidates, nameAttr);
		UpdateValueStrategy t2m = new UpdateValueStrategy().setConverter(s2r);
		UpdateValueStrategy m2t = new UpdateValueStrategy().setConverter(r2s);
		if (validator!=null) {
			t2m.setAfterConvertValidator(validator);
			t2m.setBeforeSetValidator(validator);
			m2t.setAfterConvertValidator(validator);
			m2t.setBeforeSetValidator(validator);
		}
		createBinding(combo, obj, ref, type, t2m, m2t, multiValidator);
		
		return combo;
	}
	
	protected Combo createComboUsingDesc(Composite parent, String label, EObject obj, Object type, EReference ref, List<IEObjectDescription> candidates, EAttribute nameAttr, IValidator validator){
		return createComboUsingDesc(parent, label, obj, type, ref, candidates, nameAttr, validator, null);
	}
	
	protected Combo createComboUsingDesc(Composite parent, String label, EObject obj, Object type, EReference ref, List<IEObjectDescription> candidates, EAttribute nameAttr, IValidator validator, MultiValidator2 multiValidator) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));

		Combo combo = new Combo(parent, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.HORIZONTAL));
		combo.setVisibleItemCount(10);
		toolkit.adapt(combo, true, true);
		
		DescriptionBased_Reference2StringConverter r2s = new DescriptionBased_Reference2StringConverter(type, nameAttr);
		for (IEObjectDescription desc : candidates) {
			combo.add(r2s.convert(desc).toString());
		}
		
		DescriptionBased_String2ReferenceConverter s2r = new DescriptionBased_String2ReferenceConverter(type, obj, candidates);
		UpdateValueStrategy t2m = new UpdateValueStrategy().setConverter(s2r);
		UpdateValueStrategy m2t = new UpdateValueStrategy().setConverter(r2s);
		if (validator!=null) {
			t2m.setAfterConvertValidator(validator);
			t2m.setBeforeSetValidator(validator);
			m2t.setAfterConvertValidator(validator);
			m2t.setBeforeSetValidator(validator);
		}
		
		createBinding(combo, obj, ref, type, t2m, m2t, multiValidator);
		
		return combo;
	}
	
	protected Combo createCombo(Composite parent, String label, EObject obj, Object type, EAttribute att, List<? extends Enumerator> choices) {
		return createCombo(parent, label, obj, type, att, choices, null, null);
	}
	
	protected Combo createCombo(Composite parent, String label, EObject obj, Object type, EAttribute att, List<? extends Enumerator> choices, IValidator singleValidator, MultiValidator2 multiValidator) {
		Label l = toolkit.createLabel(parent, label, SWT.NONE);
		l.setLayoutData(new GridData(SWT.NONE));

		Combo combo = new Combo(parent, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.HORIZONTAL));
		combo.setVisibleItemCount(10);
		toolkit.adapt(combo, true, true);
		
		for (Enumerator o : choices) 
			combo.add(o.getLiteral());
		
		UpdateValueStrategy t2m = new UpdateValueStrategy().setConverter(new String2EnumConverter(type, choices));
		UpdateValueStrategy m2t = new UpdateValueStrategy().setConverter(new Enum2StringConverter());
		if (singleValidator!=null) {
			t2m.setAfterConvertValidator(singleValidator);
			t2m.setBeforeSetValidator(singleValidator);
			m2t.setAfterConvertValidator(singleValidator);
			m2t.setBeforeSetValidator(singleValidator);
		}
		
		createBinding(combo, obj, att, type, t2m, m2t, multiValidator);
		
		return combo;
	}
	
	protected void createBinding(Widget widget, EObject obj, EStructuralFeature feature, Object objType, UpdateValueStrategy t2m, UpdateValueStrategy m2t, MultiValidator2 multiValidator){
		IObservableValue observableWidget = null;
		if(widget instanceof Text || widget instanceof StyledText)
			observableWidget = WidgetProperties.text(SWT.Modify).observe(widget);
		else if(widget instanceof Button || widget instanceof Combo)
			observableWidget = WidgetProperties.selection().observe(widget);
		IObservableValue observableObj = EMFProperties.value(feature).observe(obj);
		
		if(multiValidator != null){
			IObservableValue convertedObservable = new WritableValue(null, objType);
			Binding convertBinding = bindingContext.bindValue(observableWidget, convertedObservable, t2m, m2t);
			multiValidator.installValidator(convertBinding, observableObj);
		
			List<ValidationStatusProvider> valProviders = new ArrayList<ValidationStatusProvider>();
			valProviders.add(convertBinding);
			valProviders.add(multiValidator);
			widget.setData(WIDGET_DATA_KEY_VALSTATUS, createAggregateValidationStatus(valProviders));
		} else {
			Binding binding = bindingContext.bindValue(observableWidget, observableObj, t2m, m2t);
			widget.setData(WIDGET_DATA_KEY_VALSTATUS, binding.getValidationStatus());
		}
	}
	
	protected ControlDecoration createDecorator(Control ctrl, String message) {
		ControlDecoration controlDecoration = new ControlDecoration(ctrl, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(
				FieldDecorationRegistry.DEC_ERROR);
		controlDecoration.setImage(fieldDecoration.getImage());
		controlDecoration.hide();
       
		IObservableValue status = getObservableStatus(ctrl);
		if(status != null)
			decoratorMap.put(controlDecoration, status);

        return controlDecoration;
	}

	protected ControlDecoration createInfoDecorator(Control ctrl, String message) {
		ControlDecoration controlDecoration = new ControlDecoration(ctrl, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(
				FieldDecorationRegistry.DEC_INFORMATION);
		controlDecoration.setImage(fieldDecoration.getImage());

        return controlDecoration;
	}

	protected IStatus getGlobalValidationStatus() {
		return ValidationStatus.ok();
	}
	
	public void checkValidation() {
		if (displayedValidationStatus!=null && !displayedValidationStatus.isDisposed()) {
			displayedValidationStatus.calculate();
		}
	}
	
	protected DataBindingContext getBindingContext() {
		return bindingContext;
	}
	
	/**
	 * Returns the observable validation status for the given widget.
	 */
	protected IObservableValue getObservableStatus(Widget widget){
		return (IObservableValue) widget.getData(WIDGET_DATA_KEY_VALSTATUS);
	}

	/**
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
	private IObservableValue createAggregateValidationStatus(Collection<ValidationStatusProvider> valProvider){
		IObservableCollection observableStatusProvider = new WritableList(valProvider, ValidationStatusProvider.class);
		return new AggregateValidationStatus(observableStatusProvider, AggregateValidationStatus.MAX_SEVERITY);
	}
	
	private void setupUserDialogSize(){
		int width = preferenceStore.getInt(this.getClass().getName()+PREF_KEY_WIDTH);
		int height = preferenceStore.getInt(this.getClass().getName()+PREF_KEY_HEIGHT);
		if(width > 0 && height > 0)
			getShell().setSize(width, height);
		
		getShell().addControlListener(new ControlListener() {
			
			String dialogId = AbstractPropertyDialog.this.getClass().getName();
			
			@Override
			public void controlResized(ControlEvent e) {
				Point size = getShell().getSize();				
				preferenceStore.setValue(dialogId+PREF_KEY_WIDTH, size.x);
				preferenceStore.setValue(dialogId+PREF_KEY_HEIGHT, size.y);
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
			}
		});
	}
	
	/**
	 * Selects the string {@code selectSring} inside the Text & shifts the
	 * keyboard focus to it. If the select string is empty or not present inside
	 * the text, it does nothing.
	 * 
	 * @param text
	 * @param selectString
	 * 
	 * @author jayant
	 */
	protected void setTextSelectionAndFocus(Text text, String selectString) {
		if (selectString.isEmpty())
			return;
		String content = text.getText();
		int start = content.indexOf(selectString+'(');
		if (start != -1) {

			// find the index of closing brace
			int end = start + selectString.length() + 1;
			Stack<Character> parenthesis = new Stack<Character>();
			parenthesis.push('(');
			while (end < content.length() && !parenthesis.isEmpty()) {
				if (content.charAt(end) == '(')
					parenthesis.push('(');
				else if (content.charAt(end) == ')')
					parenthesis.pop();
				end++;
			}
			text.setFocus();
			text.setSelection(start, end);
		}
	}
	
	protected abstract String getFeatureContextHelpId();
}
