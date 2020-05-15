/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.core.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule;
import org.eclipse.etrice.core.fsm.ui.labeling.FSMLabelProvider;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageData;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.jface.viewers.StyledString;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class RoomLabelProvider extends FSMLabelProvider {

	@Inject
	private RoomHelpers roomHelpers;

	@Inject
	private RoomNameProvider roomNameProvider;

	@Inject
	public RoomLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// custom images for ROOM classes

	String image(RoomModel rm) {
		return "RoomModel.gif";
	}

	@Override
	public String image(Import im) {
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

	String image(SAP sap) {
		return "SAP.gif";
	}

	String image(SPP spp) {
		return "SPP.gif";
	}

	String image(ActorRef ar) {
		return "ActorRef.gif";
	}

	String image(SubSystemRef ar) {
		return "SubSystemRef.gif";
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

	String image(ClassStructor structor){
		if(structor.isConstructor())
			return "ctor.png";
		return "dtor.png";
	}

	String image(Port p) {
		boolean relay = roomHelpers.isRelay(p);
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

	String image(ActorInstanceMapping aim) {
		return "actorInstanceMapping.gif";
	}
	String image(LogicalThread lt) {
		return "LogicalThread.png";
	}

	String image(AnnotationType at) {
		return "annotation_obj.gif";
	}

	String image(AnnotationAttribute aa) {
		return "Attribute.gif";
	}

	String image(EnumerationType et) {
		return "EnumerationType.gif";
	}

	String image(EnumLiteral lit) {
		return "EnumLiteral.gif";
	}

	String image(ProtocolSemantics ps) {
		return "ProtocolSemantics.png";
	}

	String image(SemanticsRule ps) {
		return "SemanticsRule.png";
	}

	// custom labels

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

	StyledString text(ActorClass ac) {
		String base = ac.getActorBase()!=null? " extends "+ac.getActorBase().getName():"";
		StyledString result = new StyledString(ac.getName()+base);
		int pos = result.toString().indexOf(" extends ");
		if (pos>=0)
			result.setStyle(pos+1, 7, getKeywordStyler());
		return result;
	}

	String text(Port p) {
		String location = null;
		if (roomHelpers.isInternal(p))
			location = "internal";
		else if (roomHelpers.isExternal(p)) {
			location = "external";
		}
		else
			location = "relay";
		String conjugated = p.isConjugated()?"conjugated ":"";
		String multiplicity = p.getMultiplicity()>1? ("["+p.getMultiplicity()+"]") : p.getMultiplicity()==-1? "[*]" : "";
		String protocol = p.getProtocol()!=null? (" : "+p.getProtocol().getName()):"";
		return conjugated+" "+location+" Port "+p.getName()+multiplicity+protocol;
	}

	String text(Binding bind) {
		return roomNameProvider.getDisplayName(bind);
	}

	String text(ExternalPort ep) {
		return text(ep.getInterfacePort());
	}

	String text(SAP sap) {
		String protocol = sap.getProtocol()!=null? (" : "+sap.getProtocol().getName()):"";
		return "SAP "+sap.getName()+protocol;
	}

	String text(SPP spp) {
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
		String type = attr.getType().getType()!=null? (" : "+attr.getType().getType().getName()):"";
		String value = (attr.getDefaultValueLiteral()!=null && !attr.getDefaultValueLiteral().isEmpty())?
				(" = "+attr.getDefaultValueLiteral()) : "";
		String mult = attr.getSize()>1? ("["+attr.getSize()+"]") : "";
		return "Attr "+attr.getName()+mult+type+value;
	}

	StyledString text(Operation op) {
		/* TODO TS: create complete signature including return type and ref */

		String signature = roomNameProvider.getSignature(op);
		if (op instanceof PortOperation && ((PortOperation) op).getSendsMsg()!=null) {
		}
		StyledString result = new StyledString(signature);
		int pos = result.toString().indexOf(" sends ");
		if (pos>=0)
			result.setStyle(pos+1, 5, getKeywordStyler());

		return result;
	}

	String text(Message m) {
		String signature = "";
		if (m.getData()!=null) {
			MessageData data = m.getData();
			signature = data.getRefType().getType().getName() + (data.getRefType().isRef() ? " ref" : "");
		}
		signature = "("+signature+")";
		return m.getName()+signature;
	}

	String text(ActorInstanceMapping aim) {
		return aim.getPath().toString()+" -> "+aim.getThread().getName();
	}

	String text (LogicalThread lt ) {
		return lt.getName();
	}

	String text (EnumLiteral lit) {
		return lit.getName()+" = "+lit.getLiteralValue();
	}

	String text(ProtocolSemantics ps) {
		return "ProtocolSemantics";
	}

	String text(SemanticsRule rule) {
		if (rule instanceof InSemanticsRule)
			return "in: "+rule.getMsg();
		else
			return "out: "+rule.getMsg();
	}


}
