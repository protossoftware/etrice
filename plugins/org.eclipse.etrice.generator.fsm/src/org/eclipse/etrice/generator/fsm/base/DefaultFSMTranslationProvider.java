/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;

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
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemMessageText(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.util.ArrayList, java.lang.String, java.lang.String)
	 */
	@Override
	public String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject msg,
			ArrayList<String> args, String index, String orig) {
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
