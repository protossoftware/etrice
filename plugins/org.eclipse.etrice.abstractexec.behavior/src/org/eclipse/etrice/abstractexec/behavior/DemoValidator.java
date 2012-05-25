/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.validation.IRoomValidator;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DemoValidator implements IRoomValidator {

	public static final String DEMO_ISSUE_CODE = "demo_issue";
	
	// HOWTO: if validator is running in check mode NORMAL there are issues with marker updates
	// the marker appears grayed and quick fixes aren't available

	@Override
	public void validate(EObject object,
			ValidationMessageAcceptor messageAcceptor) {
		
		if (!(object instanceof ActorClass))
			return;
		
		ActorClass ac = (ActorClass) object;
		if (!ac.getName().endsWith("_ac"))
			messageAcceptor.acceptWarning("ActorClass name must end with _ac", ac, RoomPackage.Literals.ROOM_CLASS__NAME, -1, DEMO_ISSUE_CODE, ac.getName());
	}

}
