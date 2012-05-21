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

package org.eclipse.etrice.generator.c.gen;

import java.util.ArrayList;

import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.ILanguageExtension;

import com.google.inject.Inject;

public class CTranslationProvider implements ITranslationProvider {

	@Inject private RoomExtensions roomExt;
	@Inject ILogger logger;
	@Inject ILanguageExtension langExt;
	
	@Override
	public void setActorClass(ActorClass ac) {
	}

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public String getAttributeText(Attribute att, String orig) {
		return "self->"+att.getName();
	}

	@Override
	public String getOperationText(Operation op, ArrayList<String> args, String orig) {
		StringBuilder result = new StringBuilder();
		result.append(langExt.memberInUse(((RoomClass)op.eContainer()).getName(), op.getName())+"(self");
		for (String arg : args) {
			result.append(", "+arg);
		}
		result.append(") /* ORIG: "+orig+" */");
		return result.toString();
	}

	@Override
	public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String index, String orig) {
		StringBuilder argtext = new StringBuilder();
		for (String arg : args) {
			argtext.append(", "+arg);
		}

		String result = orig;
		if (item instanceof Port) {
			Port p = (Port) item;
			if (p.getProtocol().getCommType()==CommunicationType.EVENT_DRIVEN) {
				if (p.getMultiplicity()==1)
					result = roomExt.getPortClassName(p)+"_"+msg.getName()+"(&self->constData->"+item.getName()+argtext+")";
				else {
					if (index==null)
						result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_broadcast(&self->constData->"+item.getName()+argtext+")";
					else
						result = roomExt.getPortClassName(p)+"_"+msg.getName()+"(&self->constData->"+item.getName()+", "+index+argtext+")";
				}
			}
			else if (p.getProtocol().getCommType()==CommunicationType.DATA_DRIVEN) {
				if (p.isConjugated())
					result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_set(&(self->"+item.getName()+")"+argtext+")";
				else
					result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_get(&(self->constData->"+item.getName()+"))";
			}
			
			result += " /* "+orig+" */";
		}
		else if (item instanceof SAPRef) {
			result = roomExt.getPortClassName(((SAPRef)item))+"_"+msg.getName()+"(&self->constData->"+item.getName()+argtext+")";
		}
		else if (item instanceof SPPRef) {
			if (index==null)
				result = roomExt.getPortClassName(((SPPRef)item))+"_"+msg.getName()+"_broadcast(&self->constData->"+item.getName()+argtext+")";
			else
				result = roomExt.getPortClassName(((SPPRef)item))+"_"+msg.getName()+"(&self->constData->"+item.getName()+", "+index+argtext+")";
		}
		return result;
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		String result = orig;
		if (item instanceof Port) {
			Port p = (Port) item;
			result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_get(&(self->constData->"+item.getName()+"))";
			result += " /* "+orig+" */";
		}
		return result;
	}

	@Override
	public boolean translateTags() {
		return true;
	}

	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("ifitem.index"))
			return "((etReplSubPort*)ifitem)->index";
		
		if (tag.equals("MODEL_LOCATION")) {
			return RoomNameProvider.getDetailCodeLocation(code);
		}
		
		logger.logInfo("unrecognized tag '"+tag+"' in "
				+RoomNameProvider.getDetailCodeLocation(code)+" of "
				+RoomNameProvider.getClassLocation(RoomNameProvider.getModelClass(code)));
		return TAG_START+"?"+tag+"?"+TAG_END;
	}

}
