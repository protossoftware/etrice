/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.fsm.base;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DefaultFSMTranslationProvider implements IFSMTranslationProvider {

	/**
	 * the logger used for issuing informations
	 */
	@Inject
	protected ILogger logger;
	
	/**
	 * the name provider for model objects
	 */
	@Inject
	protected FSMNameProvider fsmNameProvider;
	
	/**
	 * utility methods
	 */
	@Inject
	protected FSMHelpers fsmHelpers;

	/**
	 * @return <code>false</code>
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#translateMembers()
	 */
	@Override
	public boolean translateMembers() {
		return false;
	}

	/**
	 * @return the original String
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemMessageText(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.util.List, java.lang.String, java.lang.String)
	 */
	@Override
	public String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject msg,
			List<String> args, String index, String orig) {
				return orig;
			}

	/**
	 * @return <code>false</code>
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#translateTags()
	 */
	@Override
	public boolean translateTags() {
		return false;
	}

	/**
	 * translates only the tag <code>MODEL_LOCATION</code> and returns the location of the
	 * detail code <code>code</code> in the model.
	 * 
	 * <p>
	 * Issues an information and returns <code><|?<i>tag</i>?|><code>.
	 * </p>
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#translateTag(java.lang.String, org.eclipse.etrice.core.room.DetailCode)
	 */
	@Override
	public String translateTag(String tag, DetailCode code) {
		return TAG_START+"?"+tag+"?"+TAG_END;
	}

	@Override
	public void setContainerClass(EObject container) {
	}

}
