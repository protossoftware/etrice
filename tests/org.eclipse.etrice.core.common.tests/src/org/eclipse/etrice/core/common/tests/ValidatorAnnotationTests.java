/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.BaseTestStandaloneSetup;
import org.eclipse.etrice.core.common.validation.BaseJavaValidator;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.junit.Before;
import org.junit.Test;

public class ValidatorAnnotationTests extends AbstractXtextTests {
	protected ValidatorTester<BaseJavaValidator> tester;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(BaseTestStandaloneSetup.class);
		BaseJavaValidator validator = get(BaseJavaValidator.class);
		tester = new ValidatorTester<BaseJavaValidator>(validator, getInjector());
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

	public ValidatorTester<BaseJavaValidator> getTester() {
		return tester;
	}
}
