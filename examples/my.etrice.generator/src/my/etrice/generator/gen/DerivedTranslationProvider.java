/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package my.etrice.generator.gen;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.generator.java.gen.JavaTranslationProvider;


/**
 * EXAMPLE: derive translation provider and just override the tags.
 * Delegates to super.
 * NOTE: not necessary in the minimal version.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedTranslationProvider extends JavaTranslationProvider {

	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("Derived"))
			return "DerivedReplacement";
		
		return super.translateTag(tag, code);
	}
}
