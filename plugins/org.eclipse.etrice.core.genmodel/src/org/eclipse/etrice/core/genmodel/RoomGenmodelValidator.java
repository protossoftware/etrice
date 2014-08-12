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

package org.eclipse.etrice.core.genmodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.genmodel.base.NullLogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;


public class RoomGenmodelValidator implements ICustomValidator {

	private static final Set<EClass> classesToCheck = new HashSet<EClass>();
	{
		classesToCheck.add(RoomPackage.Literals.ROOM_MODEL);
	}
	
	private class Diag implements IDiagnostician {
		private ValidationMessageAcceptor acceptor;
		
		private Diag(ValidationMessageAcceptor acceptor){
			this.acceptor = acceptor;
		}
		
		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature) {
			acceptor.acceptWarning(msg, source, feature, INSIGNIFICANT_INDEX, null);
		}

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature, int index) {
			acceptor.acceptWarning(msg, source, feature, index, null);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature) {
			acceptor.acceptError(msg, source, feature, INSIGNIFICANT_INDEX, null);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature, int index) {
			 acceptor.acceptError(msg, source, feature, index, null);
		}

		@Override
		public boolean isFailed() {
			return false;
		}
	}
	
	
	@Override
	public String getName() {
		return "Genmodel Validator";
	}

	
	@Override
	public String getDescription() {
		return "This validator checks ROOM models by creating actual system instances, which covers aspects like wiring.";
	}

	
	@Override
	public Set<EClass> getClassesToCheck() {
		return classesToCheck;
	}


	@Override
	public void validate(EObject object, ValidationMessageAcceptor messageAcceptor, ValidationContext context) {
		if(!(object instanceof RoomModel))
			return;
		
		if(context.isGeneration())
			return;
		
		RoomModel model = (RoomModel) object;
		if (context.getCheckMode() == CheckMode.ALL) {
//			System.out.println("checking model " + model.getName());

			ArrayList<RoomModel> models = new ArrayList<RoomModel>();

			Resource resource = model.eResource();
			if (resource != null) {
				ResourceSet rs = resource.getResourceSet();
				if (rs != null) {
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

			Diag diagnostician = new Diag(messageAcceptor);
			GeneratorModelBuilder builder = new GeneratorModelBuilder(new NullLogger(), diagnostician);
			builder.createGeneratorModel(models, true);

//			System.out.println("done checking model " + model.getName() + " with result: "
//					+ (diagnostician.isFailed() ? "failed" : "ok"));
		}
		
	}

}
