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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;

import com.google.inject.Inject;

public class CTranslationProvider extends DefaultTranslationProvider {

	@Inject private RoomExtensions roomExt;
	@Inject ILanguageExtension langExt;
	private String self = "self->";
	
	@Override
	public void setContainerClass(EObject container) {
		if (container instanceof PortClass) {
			PortClass pc = (PortClass) container;
			ProtocolClass prot = (ProtocolClass) container.eContainer();
			String portClassName = roomExt.getPortClassName(prot, prot.getConjugated()==pc);
			self = "(("+portClassName+"_var*)(self->varData))->";
		}
	}

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public String getAttributeGetter(Attribute att, String index, String orig) {
		if (index==null)
			return getTranslationSwitch(orig, self+att.getName());
		else
			return getTranslationSwitch(orig, self+att.getName()+"["+index+"]");
	}

	@Override
	public String getAttributeSetter(Attribute att, String index, String value, String orig) {
		if (index==null)
			return getTranslationSwitch(orig, self+att.getName()+" = "+value);
		else
			return getTranslationSwitch(orig, self+att.getName()+"["+index+"] = "+value);
	}

	@Override
	public String getOperationText(Operation op, ArrayList<String> args, String orig) {
		StringBuilder result = new StringBuilder();
		result.append(langExt.memberInUse(((RoomClass)op.eContainer()).getName(), op.getName())+"(self");
		for (String arg : args) {
			result.append(", "+arg);
		}
		result.append(")");
		return getTranslationSwitch(orig, result.toString());
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
			if (p.getProtocol() instanceof ProtocolClass) {

				ProtocolClass pc = (ProtocolClass) p.getProtocol();
				if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
					if (p.getMultiplicity()==1)
						result = roomExt.getPortClassName(p)+"_"+msg.getName()+"(&self->constData->"+item.getName()+argtext+")";
					else {
						if (index==null)
							result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_broadcast(&self->constData->"+item.getName()+argtext+")";
						else
							result = roomExt.getPortClassName(p)+"_"+msg.getName()+"(&self->constData->"+item.getName()+", "+index+argtext+")";
					}
				}
				else if (pc.getCommType()==CommunicationType.DATA_DRIVEN) {
					if (p.isConjugated())
						result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_set(&(self->"+item.getName()+")"+argtext+")";
					else
						result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_get(&(self->constData->"+item.getName()+"))";
				}
			}
		}
		else if (item instanceof SAP) {
			result = roomExt.getPortClassName(((SAP)item))+"_"+msg.getName()+"(&self->constData->"+item.getName()+argtext+")";
		}
		else if (item instanceof SPP) {
			if (index==null)
				result = roomExt.getPortClassName(((SPP)item))+"_"+msg.getName()+"_broadcast(&self->constData->"+item.getName()+argtext+")";
			else
				result = roomExt.getPortClassName(((SPP)item))+"_"+msg.getName()+"(&self->constData->"+item.getName()+", "+index+argtext+")";
		}
		
		return getTranslationSwitch(orig, result);
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		String result = orig;
		if (item instanceof Port) {
			Port p = (Port) item;
			result = roomExt.getPortClassName(p)+"_"+msg.getName()+"_get(&(self->constData->"+item.getName()+"))";
		}
		return getTranslationSwitch(orig, result);
	}

	@Override
	public boolean translateTags() {
		return true;
	}

	@Override
	public String translateTag(String tag, DetailCode code) {
		if (tag.equals("ifitem.index"))
			return "((etReplSubPort*)ifitem)->index";

		return super.translateTag(tag, code);
	}

	@Override
	public boolean translateEnums() {
		return true;
	}

	@Override
	public String getEnumText(EnumLiteral literal) {
		EnumerationType et = (EnumerationType) literal.eContainer();
		return getTranslationSwitch(et.getName()+" dot "+literal.getName(), et.getName()+"_"+literal.getName());
	}
	
	private String getTranslationSwitch(String orig, String translated) {
		return "\n#ifdef ET_USE_ORIG_CODE\n"+orig +"\n#else\n"+translated+"\n#endif\n";
	}

}
