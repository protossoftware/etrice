/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;

/**
 * @author hrentz
 *
 */
public class JavaTranslationProvider extends DefaultTranslationProvider {

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public boolean translateTags() {
		return true;
	}
	
	@Override
	public String getAttributeSetter(Attribute att, String index, String value, String orig) {
		if (index!=null)
			return att.getName()+"["+index+"] = "+value;
		else
			return att.getName()+" = "+value;
	}
	
	@Override
	public String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject abstractMsg, List<String> args, String index, String orig) {
		if (index==null)
			return orig;

		if (!(abstractMsg instanceof Message))
			return orig;
		
		Message msg = (Message) abstractMsg;
		
		StringBuilder argtext = new StringBuilder();
		for (String arg : args) {
			argtext.append(", "+arg);
		}
		
		// remove leading ", "
		argtext.delete(0, 2);

		return item.getName()+".get("+index+")."+msg.getName()+"("+argtext.toString()+")";
	}
	
	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		return item.getName()+"."+msg.getName()+"()";
	}
	
	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("ifitem.index"))
			return "ifitem.getIdx()";
		
		return super.translateTag(tag, code);
	}

}
