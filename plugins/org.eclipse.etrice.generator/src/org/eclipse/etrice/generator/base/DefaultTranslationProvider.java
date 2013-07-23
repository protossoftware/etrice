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

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;

import com.google.inject.Inject;

/**
 * A default implementation of an {@link ITranslationProvider}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DefaultTranslationProvider implements ITranslationProvider {

	/**
	 * the logger used for issuing informations
	 */
	@Inject ILogger logger;

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
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getAttributeGetter(org.eclipse.etrice.core.room.Attribute, java.lang.String, java.lang.String)
	 */
	@Override
	public String getAttributeGetter(Attribute att, String index, String orig) {
		return orig;
	}

	/**
	 * @return the original String
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getAttributeSetter(org.eclipse.etrice.core.room.Attribute, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getAttributeSetter(Attribute att, String index, String value, String orig) {
		return orig;
	}

	/**
	 * @return the original String
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getOperationText(org.eclipse.etrice.core.room.Operation, java.util.ArrayList, java.lang.String)
	 */
	@Override
	public String getOperationText(Operation op, ArrayList<String> args, String orig) {
		return orig;
	}

	/**
	 * @return the original String
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemMessageText(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.util.ArrayList, java.lang.String, java.lang.String)
	 */
	@Override
	public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String index, String orig) {
		return orig;
	}

	/**
	 * @return the original String
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemMessageValue(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.lang.String)
	 */
	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
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
		if (tag.equals("MODEL_LOCATION")) {
			return RoomNameProvider.getDetailCodeLocation(code);
		}
		
		logger.logInfo("unrecognized tag '"+tag+"' in "
				+RoomNameProvider.getDetailCodeLocation(code)+" of "
				+RoomNameProvider.getClassLocation(RoomNameProvider.getModelClass(code)));
		return TAG_START+"?"+tag+"?"+TAG_END;
	}

	@Override
	public void setContainerClass(EObject container) {
	}
	
}