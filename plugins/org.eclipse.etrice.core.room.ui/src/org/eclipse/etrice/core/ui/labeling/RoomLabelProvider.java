/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.StylerFactory;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class RoomLabelProvider extends DefaultEObjectLabelProvider {

	private static final String KEYWORD_COLOR = "KEYWORD_COLOR";

	@Inject
	private StylerFactory stylerFactory;
	private Styler keywordStyler = null;
	private Styler typeStyler = null;
	
	@Inject
	public RoomLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
		
		JFaceResources.getColorRegistry().put(KEYWORD_COLOR, new RGB(50, 50, 50));
	}

	// custom images for ROOM classes
	
	String image(RoomModel rm) {
		return "RoomModel.gif";
	}
	
	String image(Import im) {
		return "RoomModelImport.gif";
	}
	
	String image(DataClass dc) {
		return "DataClass.gif";
	}
	
	String image(PrimitiveType pt) {
		return "PrimitiveType.gif";
	}
	
	String image(ExternalType et) {
		return "ExternalType.gif";
	}
	
	String image(Attribute a) {
		return "Attribute.gif";
	}

	String image(ProtocolClass pc) {
		return "ProtocolClass.gif";
	}

	String image(ActorClass ac) {
		return "ActorClass.gif";
	}

	String image(SubSystemClass cc) {
		return "SubSystemClass.gif";
	}

	String image(LogicalSystem sys) {
		return "LogicalSystem.gif";
	}

	String image(SAPRef sap) {
		return "SAP.gif";
	}

	String image(SPPRef spp) {
		return "SPP.gif";
	}

	String image(ActorRef ar) {
		return "ActorRef.gif";
	}

	String image(SubSystemRef ar) {
		return "SubSystemRef.gif";
	}

	String image(BaseState state) {
		return "State.gif";
	}

	String image(RefinedState state) {
		return "RefinedState.gif";
	}

	String image(ServiceImplementation svc) {
		return "ServiceImpl.gif";
	}

	String image(Message state) {
		if (state.isPriv())
			return "MessagePrivate.gif";
		else
			return "Message.gif";
	}

	String image(Operation op) {
		if (op instanceof PortOperation && ((PortOperation) op).getSendsMsg()!=null)
			return "OperationMsg.gif";
		else
			return "Operation.gif";
	}
	
	String image(Port p) {
		ActorClass ac = (ActorClass) p.eContainer();
		boolean relay = true;
		if (ac.getIntPorts().contains(p)) {
			relay = false;
		}
		else {
			for (ExternalPort ep : ac.getExtPorts()) {
				if (ep.getIfport()==p) {
					relay = false;
					break;
				}
			}
		}
		if (relay)
			if (p.isConjugated())
				if (p.isReplicated())
					return "ConjReplRelayPort.gif";
				else
					return "ConjRelayPort.gif";
			else
				if (p.isReplicated())
					return "ReplRelayPort.gif";
				else
					return "RelayPort.gif";
		else
			if (p.isConjugated())
				if (p.isReplicated())
					return "ConjReplPort.gif";
				else
					return "ConjPort.gif";
			else
				if (p.isReplicated())
					return "ReplPort.gif";
				else
					return "Port.gif";
	}
	
	// custom labels
	
	StyledString text(Import im) {
		if (im.getImportedNamespace()==null) {
			StyledString txt = new StyledString("import model "+im.getImportURI());
			txt.setStyle(0, 12, getKeywordStyler());
			return txt;
		}
		else {
			StyledString txt = new StyledString("import ns "+im.getImportedNamespace());
			txt.setStyle(0, 9, getKeywordStyler());
			return txt;
		}
	}
	
	String text(DataClass dc) {
		String base = dc.getBase()!=null? " extends "+dc.getBase().getName():"";
		return dc.getName()+base;
	}
	
	String text(PrimitiveType pt) {
		return pt.getName()+" -> "+pt.getTargetName();
	}
	
	String text(ExternalType et) {
		return et.getName()+" -> "+et.getTargetName();
	}
	
	String text(ProtocolClass pc) {
		String base = pc.getBase()!=null? " extends "+pc.getBase().getName():"";
		return pc.getName()+base;
	}
	
	String text(ActorClass ac) {
		String base = ac.getBase()!=null? " extends "+ac.getBase().getName():"";
		return ac.getName()+base;
	}
	
	String text(Port p) {
		String location = null;
		ActorClass ac = (ActorClass) p.eContainer();
		if (ac.getIntPorts().contains(p))
			location = "internal";
		else {
			for (ExternalPort ep : ac.getExtPorts()) {
				if (ep.getIfport()==p) {
					location = "external";
					break;
				}
			}
		}
		if (location==null)
			location = "relay";
		String conjugated = p.isConjugated()?"conjugated ":"";
		String multiplicity = p.getMultiplicity()>1? ("["+p.getMultiplicity()+"]") : p.getMultiplicity()==-1? "[*]" : "";
		String protocol = p.getProtocol()!=null? (" : "+p.getProtocol().getName()):"";
		return conjugated+" "+location+" Port "+p.getName()+multiplicity+protocol;
	}
	
	String text(ExternalPort ep) {
		return text(ep.getIfport());
	}
	
	String text(SAPRef sap) {
		String protocol = sap.getProtocol()!=null? (" : "+sap.getProtocol().getName()):"";
		return "SAP "+sap.getName()+protocol;
	}
	
	String text(SPPRef spp) {
		String protocol = spp.getProtocol()!=null? (" : "+spp.getProtocol().getName()):"";
		return "SPP "+spp.getName()+protocol;
	}
	
	String text(ServiceImplementation svc) {
		if (svc.getSpp()==null)
			return "Implementation";
		
		String protocol = svc.getSpp().getProtocol()!=null? (" : "+svc.getSpp().getProtocol().getName()):"";
		return "Implementation of "+svc.getSpp().getName()+protocol;
	}
	
	StyledString text(ActorRef ref) {
		String cls = ref.getType()!=null? (" : "+ref.getType().getName()):"";
		StyledString txt = new StyledString("ref "+ref.getName()+cls);
		if (!cls.isEmpty())
			txt.setStyle(txt.length()-cls.length()+2, cls.length()-2, getTypeStyler());
		return txt;
	}
	
	String text(SubSystemRef ref) {
		String cls = ref.getType()!=null? (" : "+ref.getType().getName()):"";
		return "ref "+ref.getName()+cls;
	}
	
	String text(Attribute attr) {
		String type = attr.getRefType().getType()!=null? (" : "+attr.getRefType().getType().getName()):"";
		String value = (attr.getDefaultValueLiteral()!=null && !attr.getDefaultValueLiteral().isEmpty())?
				(" = "+attr.getDefaultValueLiteral()) : "";
		String mult = attr.getSize()>1? ("["+attr.getSize()+"]") : "";
		return "Attr "+attr.getName()+mult+type+value;
	}
	
	StyledString text(Operation op) {
		/* TODO TS: create complete signature including return type and ref */

		String rt = op.getReturntype()!=null? ": "+op.getReturntype().getType().getName():"";
		String signature = RoomHelpers.getSignature(op);
		String special = RoomHelpers.isConstructor(op)? "ctor " : RoomHelpers.isDestructor(op)? "dtor " : "";
		if (op instanceof PortOperation && ((PortOperation) op).getSendsMsg()!=null)
			rt = " sends "+((PortOperation) op).getSendsMsg().getName();
		String destr = (op instanceof StandardOperation && ((StandardOperation)op).isDestructor())? "~":"";
		StyledString result = new StyledString(special+destr+op.getName()+signature+rt);
		int pos = result.toString().indexOf(" sends ");
		if (pos>=0)
			result.setStyle(pos+1, 5, getKeywordStyler());

		if (!special.isEmpty())
			result.setStyle(0, 4, getKeywordStyler());
		
		return result;
	}
	
	String text(Message m) {
		String signature = "";
		if (m.getData()!=null)
			signature = m.getData().getName()+":"+m.getData().getRefType().getType().getName();
		signature = "("+signature+")";
		return m.getName()+signature;
	}
	
	String text(BaseState s) {
		return s.getName();
	}
	
	String text(RefinedState rs) {
		if (rs.getBase()!=null)
			return text(rs.getBase());
		
		return "";
	}

	private Styler getKeywordStyler() {
		if (keywordStyler==null) {
			FontDescriptor font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT);
			FontDescriptor boldFont = font.setStyle(SWT.BOLD);
			keywordStyler = stylerFactory.createStyler(boldFont, KEYWORD_COLOR, null);
		}
		return keywordStyler;
	}

	private Styler getTypeStyler() {
		if (typeStyler==null) {
			FontDescriptor font = JFaceResources.getFontDescriptor(JFaceResources.TEXT_FONT);
			FontDescriptor italicFont = font.setStyle(SWT.ITALIC);
			typeStyler = stylerFactory.createStyler(italicFont, null, null);
		}
		return typeStyler;
	}
}
