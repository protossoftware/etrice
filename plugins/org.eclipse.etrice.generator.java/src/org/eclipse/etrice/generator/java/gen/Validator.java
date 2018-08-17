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

package org.eclipse.etrice.generator.java.gen;

import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Validator {

	@Inject
	private ILogger logger;

	public boolean validate(Root genModel) {
		
//		currently unused

		int errorCount = 0;
//		for (RoomModel mdl : genModel.getUsedRoomModels()) {
//			TreeIterator<EObject> it = mdl.eAllContents();
//			while (it.hasNext()) {
//				EObject obj = it.next();
//				
//			}
//		}
		
		if (errorCount>0) {
			logger.logError("Java generator detected "+errorCount+" error(s) - terminating");
			return false;
		}
		
		return true;
	}
}
