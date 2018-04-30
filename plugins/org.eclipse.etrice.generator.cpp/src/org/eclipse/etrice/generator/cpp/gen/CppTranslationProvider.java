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

package org.eclipse.etrice.generator.cpp.gen;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author hrentz
 *
 */
public class CppTranslationProvider extends DefaultTranslationProvider {

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public boolean translateTags() {
		return true;
	}

	@Override
	public String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject abstractMsg, List<String> args, String index, String orig) {
		if (index==null)
			return orig;

		if (!(abstractMsg instanceof Message))
			return "";

		Message msg = (Message) abstractMsg;
		// TODO: overload operator[] ???
		return item.getName()+".get("+index+")."+msg.getName()+"("+IterableExtensions.join(args, ", ")+")";
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		return item.getName() + "." + msg.getName() + "()";
	}

	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("ifitem.index"))
			return "ifitem.getIdx()";

		return super.translateTag(tag, code);
	}

}
