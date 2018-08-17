/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.abstractexec.behavior.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;

public class DummyDataCalculator implements ICommonDataCalculator {

	@Override
	public EObject calculateCommonData(Link l) {
		return null;
	}

}
