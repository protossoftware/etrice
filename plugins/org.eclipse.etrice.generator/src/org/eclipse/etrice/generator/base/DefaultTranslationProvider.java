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

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.DefaultFSMTranslationProvider;

import com.google.inject.Inject;

/**
 * A default implementation of an {@link ITranslationProvider}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DefaultTranslationProvider extends DefaultFSMTranslationProvider implements ITranslationProvider {
	
	/**
	 * the name provider for model objects
	 */
	@Inject
	RoomNameProvider roomNameProvider;
	
	/**
	 * utility methods
	 */
	@Inject
	RoomHelpers roomHelpers;

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
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemMessageValue(org.eclipse.etrice.core.room.InterfaceItem, org.eclipse.etrice.core.room.Message, java.lang.String)
	 */
	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		return orig;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.fsm.base.DefaultFSMTranslationProvider#translateTag(java.lang.String, org.eclipse.etrice.core.fsm.fSM.DetailCode)
	 */
	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("MODEL_LOCATION")) {
			return roomNameProvider.getDetailCodeLocation(code);
		}
		
		logger.logInfo("unrecognized tag '"+tag+"' in "
				+roomNameProvider.getDetailCodeLocation(code)+" of "
				+roomNameProvider.getClassLocation(roomHelpers.getRoomClass(code)));
		
		return super.translateTag(tag, code);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#translateEnums()
	 */
	@Override
	public boolean translateEnums() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getEnumText(org.eclipse.etrice.core.room.EnumLiteral)
	 */
	@Override
	public String getEnumText(EnumLiteral literal) {
		EnumerationType et = (EnumerationType) literal.eContainer();
		return et.getName()+"."+literal.getName();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.ITranslationProvider#getInterfaceItemOperationText(org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem, org.eclipse.etrice.core.room.PortOperation, java.util.ArrayList, java.lang.String)
	 */
	@Override
	public String getInterfaceItemOperationText(AbstractInterfaceItem item,
			PortOperation op, ArrayList<String> args, String orig) {
		return orig;
	}
	
}