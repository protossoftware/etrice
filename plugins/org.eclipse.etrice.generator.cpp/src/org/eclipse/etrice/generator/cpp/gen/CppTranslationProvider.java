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

import java.util.ArrayList;

import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.etrice.generator.base.ILogger;

import com.google.inject.Inject;

/**
 * @author hrentz
 *
 */
public class CppTranslationProvider extends DefaultTranslationProvider {

	@Inject ILogger logger;

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public boolean translateTags() {
		return true;
	}
	
	@Override
	public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String index, String orig) {
		if (index==null)
			return orig;
		
		StringBuilder argtext = new StringBuilder();
		for (String arg : args) {
			argtext.append(", "+arg);
		}

		// TODO: overload operator[] ???
		return item.getName()+".get("+index+")."+msg.getName()+"("+argtext.toString()+")";
	}
	
	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("ifitem.index"))
			return "ifitem.getIdx()";
		
		logger.logInfo("unrecognized tag '"+tag+"' in "
				+RoomNameProvider.getDetailCodeLocation(code)+" of "
				+RoomNameProvider.getClassLocation(RoomNameProvider.getModelClass(code)));
		return TAG_START+"?"+tag+"?"+TAG_END;
	}

}
