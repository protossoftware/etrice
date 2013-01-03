/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.tests;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxEValidator;

import com.google.common.collect.Maps;

/**
 * Base class for tests helps with getting diagnostics from a model.
 * 
 * @author Henrik Rentz-Reichert initial contribution and API
 * 
 */
public class TestBase {

	private Resource resource;
	private String basePath;
	private HashMap<String, Diagnostic> infoMsg2diagnostic = new HashMap<String, Diagnostic>();
	private HashMap<String, Diagnostic> warnMsg2diagnostic = new HashMap<String, Diagnostic>();
	private HashMap<String, Diagnostic> errorMsg2diagnostic = new HashMap<String, Diagnostic>();
	private HashMap<String, List<AbstractValidationDiagnostic>> issueCode2diagnostic = new HashMap<String, List<AbstractValidationDiagnostic>>();

	protected void prepare(String modelFile) {
		try {
			URL modelsDir = Activator.getInstance().getBundle()
					.getEntry("models");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		resource = getResource(modelFile);

		Diagnostic diag = getDiag(resource.getContents().get(0));
		createMappedDiagnostics(diag);
	}

	protected RoomModel getRoomModel() {
		return (RoomModel) resource.getContents().get(0);
	}

	/**
	 * @return a map from message text to Diagnostic object
	 */
	protected HashMap<String, Diagnostic> getInfoMsgToDiagnostic() {
		return infoMsg2diagnostic;
	}

	/**
	 * @return a map from message text to Diagnostic object
	 */
	protected HashMap<String, Diagnostic> getWarningMsgToDiagnostic() {
		return warnMsg2diagnostic;
	}

	/**
	 * @return a map from message text to Diagnostic object
	 */
	protected HashMap<String, Diagnostic> getErrorMsgToDiagnostic() {
		return errorMsg2diagnostic;
	}

	/**
	 * 
	 * @return a map from issueCode to Diagnostic object
	 */
	protected HashMap<String, List<AbstractValidationDiagnostic>> getIssueCode2diagnostic() {
		return issueCode2diagnostic;
	}

	protected Resource getResource(String modelName) {
		XtextResourceSet rs = new XtextResourceSet();
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		String path = basePath + modelName;
		URI uri = URI.createFileURI(path);
		return rs.getResource(uri, true);
	}

	protected Diagnostic getDiag(EObject ele) {
		Map<Object, Object> options = Maps.newHashMap();
		options.put(CheckMode.KEY, CheckMode.ALL);
		options.put(CancelableDiagnostician.CANCEL_INDICATOR,
				CancelIndicator.NullImpl);
		// disable concrete syntax validation, since a semantic model that has
		// been parsed
		// from the concrete syntax always complies with it - otherwise there
		// are parse errors.
		options.put(
				ConcreteSyntaxEValidator.DISABLE_CONCRETE_SYNTAX_EVALIDATOR,
				Boolean.TRUE);
		// see EObjectValidator.getRootEValidator(Map<Object, Object>)
		options.put(EValidator.class, Activator.getInstance()
				.getDiagnostician());
		return Activator.getInstance().getDiagnostician()
				.validate(ele, options);
	}

	/**
	 * @param diag
	 * @param errorMsg2diagnostic
	 */
	private void createMappedDiagnostics(Diagnostic diag) {
		for (Diagnostic d : diag.getChildren()) {
			if ((d.getSeverity() & Diagnostic.INFO) != 0) {
				infoMsg2diagnostic.put(d.getMessage(), d);
			} else if ((d.getSeverity() & Diagnostic.WARNING) != 0) {
				warnMsg2diagnostic.put(d.getMessage(), d);
			} else if ((d.getSeverity() & Diagnostic.ERROR) != 0) {
				errorMsg2diagnostic.put(d.getMessage(), d);
			}
			if (d instanceof AbstractValidationDiagnostic) {
				AbstractValidationDiagnostic dx = (AbstractValidationDiagnostic) d;
				List<AbstractValidationDiagnostic> list = issueCode2diagnostic
						.get(dx.getIssueCode());
				if (list == null) {
					list = new ArrayList<AbstractValidationDiagnostic>();
					issueCode2diagnostic.put(dx.getIssueCode(), list);
				}
				list.add(dx);
			}

		}
		for (Diagnostic d : diag.getChildren()) {
			if (!d.getChildren().isEmpty())
				createMappedDiagnostics(d);
		}
	}
}
