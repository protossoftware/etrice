/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxEValidator;
import org.osgi.framework.Bundle;

import com.google.common.collect.Maps;

/**
 * Base class for tests helps with getting diagnostics from a model.
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class TestBase {

	private String basePath;
	
	protected RoomHelpers roomHelpers = new RoomHelpers();

	protected void prepare(Bundle bundle) {
		try {
			URL modelsDir = bundle.getEntry("models");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected Resource getResource(String modelName) {
		XtextResourceSet rs = new XtextResourceSet();
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		String path = basePath + modelName;
		URI uri = URI.createFileURI(path);
		return rs.getResource(uri, true);
	}
	
	public Diagnostic getDiag(EObject ele) {
		return getDiag(ele, true);
	}

	public Diagnostic getDiag(EObject ele, boolean disableConcreteSyntaxValidation) {
		Map<Object, Object> options = Maps.newHashMap();
		options.put(CheckMode.KEY, CheckMode.FAST_ONLY);
		options.put(CancelableDiagnostician.CANCEL_INDICATOR, CancelIndicator.NullImpl);
		
		if (disableConcreteSyntaxValidation) {
			// disable concrete syntax validation, since a semantic model that has been parsed 
			// from the concrete syntax always complies with it - otherwise there are parse errors.
			options.put(ConcreteSyntaxEValidator.DISABLE_CONCRETE_SYNTAX_EVALIDATOR, Boolean.TRUE);
		}
		// see EObjectValidator.getRootEValidator(Map<Object, Object>)
		options.put(EValidator.class, CoreTestsActivator.getInstance().getDiagnostician());
		return CoreTestsActivator.getInstance().getDiagnostician().validate(ele, options);
	}
	
	protected Stream<ActorClass> getActorClasses(RoomModel model) {
		return roomHelpers.getRoomClasses(model, ActorClass.class);
	}
	
	protected Stream<ProtocolClass> getProtocolClasses(RoomModel model) {
		return roomHelpers.getRoomClasses(model, ProtocolClass.class);
	}
	
	protected Stream<DataClass> getDataClasses(RoomModel model) {
		return roomHelpers.getRoomClasses(model, DataClass.class);
	}
}
