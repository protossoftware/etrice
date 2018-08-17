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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import org.eclipse.etrice.core.genmodel.etricegen.Root;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IRoomGenerator {

	/**
	 * generate code from an eTrice generator model
	 * 
	 * @param root the root object of the eTrice generator model
	 */
	void doGenerate(Root root);
}
