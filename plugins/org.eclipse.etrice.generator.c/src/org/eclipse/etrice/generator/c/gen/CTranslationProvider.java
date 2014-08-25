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
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.etrice.generator.generic.ILanguageExtension;

import com.google.inject.Inject;

public class CTranslationProvider extends DefaultTranslationProvider {

	@Inject ILanguageExtension langExt;

	@Override
	public boolean translateMembers() {
		return true;
	}

	@Override
	public String getAttributeSetter(Attribute att, String index, String value, String orig) {
		if (index==null)
			return att.getName()+" = "+value;
		else
			return att.getName()+"["+index+"] = "+value;
	}

	@Override
	public String getInterfaceItemMessageText(AbstractInterfaceItem item, EObject abstractMsg, ArrayList<String> args, String index, String orig) {
		if (!(abstractMsg instanceof Message))
			return orig;
		
		Message msg = (Message) abstractMsg;
		
		StringBuilder argtext = new StringBuilder();
		for (String arg : args) {
			argtext.append(", "+arg);
		}
		String argtext2 = argtext.length()==0? "" : argtext.substring(2);

		String result = orig;
		if (item instanceof Port) {
			Port p = (Port) item;
			if (p.getProtocol() instanceof ProtocolClass) {

				ProtocolClass pc = (ProtocolClass) p.getProtocol();
				if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
					if (p.getMultiplicity()==1)
						result = item.getName()+"_"+msg.getName()+"("+argtext2+")";
					else {
						if (index==null)
							result = item.getName()+"_"+msg.getName()+"_broadcast("+argtext2+")";
						else
							result = item.getName()+"_"+msg.getName()+"("+index+argtext+")";
					}
				}
				else if (pc.getCommType()==CommunicationType.DATA_DRIVEN) {
					if (p.isConjugated())
						result = item.getName()+"_"+msg.getName()+"("+argtext2+")";
					else
						result = item.getName()+"_"+msg.getName();
				}
			}
		}
		else if (item instanceof SAP) {
			result = item.getName()+"_"+msg.getName()+"("+argtext2+")";
		}
		else if (item instanceof SPP) {
			if (index==null)
				result = item.getName()+"_"+msg.getName()+"_broadcast("+argtext2+")";
			else
				result = item.getName()+"_"+msg.getName()+"("+index+argtext+")";
		}
		
		return result;
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		String result = orig;
		if (item instanceof Port) {
			result = item.getName()+"_"+msg.getName();
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
			return "ifitem_index";

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
