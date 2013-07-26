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

package org.eclipse.etrice.core.ui;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.validation.RoomJavaValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;

import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;

public class RoomModelValidator extends RoomJavaValidator implements ILogger {

	private class Diag implements IDiagnostician {
		private boolean failed = false;

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature) {
			warning(msg, source, feature, INSIGNIFICANT_INDEX);
		}

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature, int index) {
			issueWarning(msg, source, feature, index);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature) {
			error(msg, source, feature, INSIGNIFICANT_INDEX);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature, int index) {
			failed = true;
			issueError(msg, source, feature, index);
		}

		@Override
		public boolean isFailed() {
			return failed;
		}
	}
	
	@Check
	public void checkModel(RoomModel model) {
		if (getCheckMode()==CheckMode.ALL) {
			System.out.println("checking model "+model.getName());
			
			ArrayList<RoomModel> models = new ArrayList<RoomModel>();
			
			Resource resource = model.eResource();
			if (resource!=null) {
				ResourceSet rs = resource.getResourceSet();
				if (rs!=null) {
					EcoreUtil.resolveAll(rs);
					for (Resource res : rs.getResources()) {
						for (EObject obj : res.getContents()) {
							if (obj instanceof RoomModel)
								models.add((RoomModel) obj);
						}
					}
				}
			}
			if (models.isEmpty())
				models.add(model);
			
			Diag diagnostician = new Diag();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(this, diagnostician);
			builder.createGeneratorModel(models, true);

			System.out.println("done checking model "+model.getName()+" with result: "+(diagnostician.isFailed()?"failed":"ok"));
		}
	}
	
	public void issueError(String msg, EObject source, EStructuralFeature feature, int index) {
		if (index==IDiagnostician.INSIGNIFICANT_INDEX)
			index = INSIGNIFICANT_INDEX;
		error(msg, source, feature, index);
	}

	public void issueWarning(String msg, EObject source, EStructuralFeature feature, int index) {
		if (index==IDiagnostician.INSIGNIFICANT_INDEX)
			index = INSIGNIFICANT_INDEX;
		warning(msg, source, feature, index);
	}

	@Override
	public void logInfo(String text) {
	}

	@Override
	public void logError(String text, EObject obj) {
	}

}
