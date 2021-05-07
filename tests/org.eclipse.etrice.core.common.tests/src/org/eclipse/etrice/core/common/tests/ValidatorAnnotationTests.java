/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.BaseStandaloneSetup;
import org.eclipse.etrice.core.common.validation.BaseValidator;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

@Ignore	// TODO fix these tests
public class ValidatorAnnotationTests extends AbstractXtextTests {
	protected ValidatorTester<BaseValidator> tester;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(BaseStandaloneSetup.class);
		BaseValidator validator = get(BaseValidator.class);
		tester = new ValidatorTester<BaseValidator>(validator, getInjector());
	}
	
	@Test
	public void AnnotationWithAllFeatures() throws Exception {
		EObject model = getModelAndExpect(readFileIntoString("AnnotationTypeWithAllFeatures.etbase"), 0);
		AssertableDiagnostics result = getTester().validate(model);
		result.assertOK();
	}
	
	@Test
	public void NonUniqueAnnotationTypeTargets() throws Exception {
		EObject model = getModelAndExpect(readFileIntoString("NonUniqueAnnotationTypeTargets.etbase"), 0);
		AssertableDiagnostics result = getTester().validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains("The target TestTarget is defined more than once");
	}
	
	@Test
	public void UndefinedAttributeInAnnotation() throws Exception {
		EObject model = getModelAndExpect(readFileIntoString("UndefinedAttributeInAnnotation.etbase"), 0);
		AssertableDiagnostics result = getTester().validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains("Attribute xyz is undefined");
	}
	
	@Test
	public void MissingMandatoryAttributeInAnnotation() throws Exception {
		EObject model = getModelAndExpect(readFileIntoString("MissingMandatoryAttributeInAnnotation.etbase"), 0);
		AssertableDiagnostics result = getTester().validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains("Mandatory attribute ");
	}
	
	@Test
	public void InvalidEnumValue() throws Exception {
		EObject model = getModelAndExpect(readFileIntoString("InvalidEnumValueInAnnotation.etbase"), 0);
		AssertableDiagnostics result = getTester().validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains("Choose one of the allowed enum values");
	}
	
	@Test
	public void UnknownAnnotationType() throws Exception {
		getModelAndExpect(readFileIntoString("UnknownAnnotationType.etbase"), 1);
	}

	public ValidatorTester<BaseValidator> getTester() {
		return tester;
	}
}
