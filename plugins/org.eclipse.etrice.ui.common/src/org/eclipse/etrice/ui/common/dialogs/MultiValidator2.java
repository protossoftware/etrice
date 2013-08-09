package org.eclipse.etrice.ui.common.dialogs;
/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

/**
 * A validator for cross-constraints between observables.
 * <p>
 * Validates <i>n</i> values and returns one common validation status.
 * <p>
 * See how a single validated value behaves: {@link MultiValidator#observeValidatedValue(IObservableValue)}
 * But is aware of converters and pre-validators and treats a last valid state of any value as failure.
 *
 */
public abstract class MultiValidator2 extends MultiValidator {

	private int targetCount;
	private DataBindingContext bindingContext;

	private List<IObservableValue> targets;
	private IObservableList converterStatusProviders;
	private IObservableValue converterStatusObservable;

	public MultiValidator2(DataBindingContext bindingContext, int values) {
		this.bindingContext = bindingContext;
		targetCount = values;

		converterStatusProviders = new WritableList(new ArrayList<ValidationStatusProvider>(targetCount),
				ValidationStatusProvider.class);
		converterStatusObservable = new AggregateValidationStatus(converterStatusProviders,
				AggregateValidationStatus.MAX_SEVERITY);
		targets = new ArrayList<IObservableValue>(targetCount);
		bindingContext.addValidationStatusProvider(this);
	}

	@Override
	protected final IStatus validate() {
		List<Object> values = new ArrayList<Object>(targetCount);
		for (IObservableValue observable : targets)
			// important, read from observable every time, otherwise
			// MultiValidator loses listeners to targets
			values.add(observable.getValue());

		// return validation error if not all inputs are valid
		IStatus converterStatus = (IStatus) converterStatusObservable.getValue();
		if (!converterStatus.isOK())
			return ValidationStatus.error("");

		// no validation if not complete
		if (targetCount != targets.size())
			return ValidationStatus.ok();

		return validate(values);
	}

	/**
	 * Validate all associated values.<br>
	 * Called when a value has changed and all values are in a valid state.
	 * 
	 * @param values
	 *            all 'middle' values from
	 *            {@link #installValidator(targetToMiddle,model)}
	 *            <ul>
	 *            <li>ordered according to calls of installValidator</li>
	 *            <li>if existent, a value is converted and validated</li>
	 *            <li>complete</li>
	 *            </ul>
	 * @return a common status
	 */
	public abstract IStatus validate(List<Object> values);

	/**
	 * Creates a binding between middle and model, that is validated by this
	 * multi-validator.
	 * 
	 * @param targetToMiddle
	 *            binding from a target (e.g. widget) to a middle value (may
	 *            have optional converters and validators between)
	 * @param model
	 */
	public void installValidator(Binding targetToMiddle, IObservableValue model) {
		IObservableValue target = (IObservableValue) targetToMiddle.getModel();
		targets.add(target);
		IObservableValue validatedObservable = observeValidatedValue(target);
		bindingContext.bindValue(validatedObservable, model);

		converterStatusProviders.add(targetToMiddle);
	}
}