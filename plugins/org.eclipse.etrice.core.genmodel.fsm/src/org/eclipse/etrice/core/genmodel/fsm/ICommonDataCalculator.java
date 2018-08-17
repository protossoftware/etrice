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
 * 		hrr@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;

public interface ICommonDataCalculator {

	/**
	 *  calculates the common data of the transition associated with this link.
	 *  That means all triggers of all transition chain heads of this link are inspected.
	 *  If one of these has no data, the common data is null.
	 *  If all of them have a common parent data type (represented as some EObject), then this
	 *  is taken. If there is no common data type but there are data the link itself is returned
	 *  with the meaning that there is a generic base type (like Object in Java or void* in C/C++)
	 * 
	 *  @param l a link
	 *  @return an EObject with the meaning as explained above
	 */
	EObject calculateCommonData(Link l);
}
