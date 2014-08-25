/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomCrossReferencer {
	
	private RoomHelpers roomHelpers = new RoomHelpers();
	
	public Set<RoomModel> getReferencedModels(RoomClass cls) {

		HashSet<DataClass> dataClasses = new HashSet<DataClass>();
		HashSet<EnumerationType> enumClasses = new HashSet<EnumerationType>();
		HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
		HashSet<RoomModel> models = new HashSet<RoomModel>();
		
		if (cls instanceof DataClass) {
			dataClasses.add((DataClass) cls);
		}
		else if (cls instanceof ProtocolClass) {
			protocolClasses.add((ProtocolClass) cls);
		}
		else if (cls instanceof ActorClass) {
			actorClasses.add((ActorClass) cls);
		}
		else if (cls instanceof SubSystemClass) {
			SubSystemClass cc = (SubSystemClass) cls;
			for (ActorRef ar : cc.getActorRefs()) {
				recursivelyAddReferencedClasses(ar.getType(), actorClasses);
			}
		}

		getReferencedClassesAndModels(dataClasses, enumClasses, protocolClasses,
				actorClasses, models);

		// remove own model
		models.remove(cls.eContainer());
		
		return models;
	}

	public Set<ProtocolClass> getReferencedProtocolClasses(RoomClass rc) {
		HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		if (rc instanceof ActorClass) {
			ActorClass cls = (ActorClass) rc;
			HashSet<DataClass> dataClasses = new HashSet<DataClass>();
			HashSet<EnumerationType> enumClasses = new HashSet<EnumerationType>();
			HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
			HashSet<RoomModel> models = new HashSet<RoomModel>();
			
			actorClasses.add(cls);
			
			getReferencedClassesAndModels(dataClasses, enumClasses, protocolClasses,
					actorClasses, models);
		}
		else if (rc instanceof ProtocolClass) {
			HashSet<DataClass> dataClasses = new HashSet<DataClass>();
			HashSet<EnumerationType> enumClasses = new HashSet<EnumerationType>();
			HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
			HashSet<RoomModel> models = new HashSet<RoomModel>();
			
			protocolClasses.add((ProtocolClass) rc);
			
			getReferencedClassesAndModels(dataClasses, enumClasses, protocolClasses,
					actorClasses, models);

			protocolClasses.remove((ProtocolClass) rc);
		}
		return protocolClasses;
	}

	public Set<DataClass> getReferencedDataClasses(RoomClass rc) {
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		HashSet<EnumerationType> enumClasses = new  HashSet<EnumerationType>();
		if (rc instanceof DataClass) {
			DataClass cls = (DataClass) rc;
			if (cls.getBase()!=null)
				dataClasses.add(cls.getBase());
			getAttributeDataClasses(dataClasses, enumClasses, cls.getAttributes());
			getOperationDataClasses(dataClasses, enumClasses, cls.getOperations());
		}
		else if (rc instanceof ActorClass) {
			ActorClass cls = (ActorClass) rc;
			do {
				getAttributeDataClasses(dataClasses, enumClasses, cls.getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, cls.getOperations());
				cls = cls.getActorBase();
			}
			while (cls!=null);
		}
		else if (rc instanceof ProtocolClass) {
			ProtocolClass pc = (ProtocolClass) rc;
			getMessageDataClasses(dataClasses, enumClasses, pc.getIncomingMessages());
			getMessageDataClasses(dataClasses, enumClasses, pc.getOutgoingMessages());
			if (pc.getRegular()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getRegular().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getRegular().getOperations());
			}
			if (pc.getConjugated()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getConjugated().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getConjugated().getOperations());
			}
		}
		return dataClasses;
	}

	public Set<EnumerationType> getReferencedEnumClasses(RoomClass rc) {
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		HashSet<EnumerationType> enumClasses = new  HashSet<EnumerationType>();
		if (rc instanceof DataClass) {
			DataClass cls = (DataClass) rc;
			if (cls.getBase()!=null)
				dataClasses.add(cls.getBase());
			getAttributeDataClasses(dataClasses, enumClasses, cls.getAttributes());
			getOperationDataClasses(dataClasses, enumClasses, cls.getOperations());
		}
		else if (rc instanceof ActorClass) {
			ActorClass cls = (ActorClass) rc;
			do {
				getAttributeDataClasses(dataClasses, enumClasses, cls.getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, cls.getOperations());
				cls = cls.getActorBase();
			}
			while (cls!=null);
		}
		else if (rc instanceof ProtocolClass) {
			ProtocolClass pc = (ProtocolClass) rc;
			getMessageDataClasses(dataClasses, enumClasses, pc.getIncomingMessages());
			getMessageDataClasses(dataClasses, enumClasses, pc.getOutgoingMessages());
			if (pc.getRegular()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getRegular().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getRegular().getOperations());
			}
			if (pc.getConjugated()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getConjugated().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getConjugated().getOperations());
			}
		}
		return enumClasses;
	}
	
	public Set<EnumerationType> getReferencedEnumClasses(PortClass pc) {
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		HashSet<EnumerationType> enumClasses = new  HashSet<EnumerationType>();
		
		getAttributeDataClasses(dataClasses, enumClasses, pc.getAttributes());
		getOperationDataClasses(dataClasses, enumClasses, pc.getOperations());
		
		return enumClasses;
	}
	
	public Set<DataClass> getReferencedDataClasses(PortClass pc) {
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		HashSet<EnumerationType> enumClasses = new  HashSet<EnumerationType>();
		
		getAttributeDataClasses(dataClasses, enumClasses, pc.getAttributes());
		getOperationDataClasses(dataClasses, enumClasses, pc.getOperations());
		
		return dataClasses;
	}

	public Set<ActorClass> getReferencedActorClasses(RoomClass rc) {
		HashSet<ActorClass> result = new HashSet<ActorClass>();
		if (rc instanceof ActorClass) {
			ActorClass cls = (ActorClass) rc;
			recursivelyAddReferencedClasses(cls, result);
		}
		else if (rc instanceof SubSystemClass) {
			SubSystemClass cls = (SubSystemClass) rc;
			for (ActorRef ar : cls.getActorRefs()) {
				recursivelyAddReferencedClasses(ar.getType(), result);
			}
		}
		return result;
	}

	private void recursivelyAddReferencedClasses(ActorClass ac, HashSet<ActorClass> actorClasses) {
		actorClasses.add(ac);
		
		for (ActorContainerRef ar : roomHelpers.getAllActorContainerRefs(ac)) {
			if (ar instanceof ActorRef) {
				recursivelyAddReferencedClasses(((ActorRef)ar).getType(), actorClasses);
			}
		}
	}

	public void getReferencedClassesAndModels(
			Set<DataClass> dataClasses,
			Set<EnumerationType> enumClasses,
			Set<ProtocolClass> protocolClasses,
			Set<ActorClass> actorClasses,
			Set<RoomModel> models) {
		
		// add actor base classes
		LinkedList<ActorClass> tmpAc = new LinkedList<ActorClass>(actorClasses);
		for (ActorClass ac : tmpAc) {
			while (ac.getActorBase()!=null) {
				ac = ac.getActorBase();
				actorClasses.add(ac);
			}
		}
		
		// add referenced actor classes
		boolean addedNew = false;
		do {
			tmpAc = new LinkedList<ActorClass>(actorClasses);
			addedNew = false;
			for (ActorClass ac : tmpAc) {
				for (ActorRef ref : ac.getActorRefs()) {
					ActorClass cls = ref.getType();
					addedNew |= actorClasses.add(cls);
					while (cls.getActorBase()!=null) {
						cls = cls.getActorBase();
						addedNew |= actorClasses.add(cls);
					}
				}
			}
		}
		while (addedNew);
		
		// determine data and protocol classes used by actor classes
		for (ActorClass ac : actorClasses) {
			getInterfaceItemProtocolClasses(protocolClasses, ac.getInterfacePorts());
			// ExtPorts are in the interface and thus already covered
			getInterfaceItemProtocolClasses(protocolClasses, ac.getInternalPorts());
			getInterfaceItemProtocolClasses(protocolClasses, ac.getServiceAccessPoints());
			for (ServiceImplementation ispp : ac.getServiceImplementations()) {
				protocolClasses.add(ispp.getSpp().getProtocol());
			}
			getInterfaceItemProtocolClasses(protocolClasses, ac.getServiceProvisionPoints());
			getAttributeDataClasses(dataClasses, enumClasses, ac.getAttributes());
			getOperationDataClasses(dataClasses, enumClasses, ac.getOperations());
		}
		
		// add protocol base classes
		LinkedList<ProtocolClass> tmpPc = new LinkedList<ProtocolClass>(protocolClasses);
		for (ProtocolClass pc : tmpPc) {
			while (pc.getBase()!=null) {
				pc = pc.getBase();
				protocolClasses.add(pc);
			}
		}
		
		// add data classes used by protocols
		for (ProtocolClass pc : protocolClasses) {
			for (Message m : pc.getIncomingMessages()) {
				if (m.getData()!=null)
					getVarDeclDataClasses(dataClasses, enumClasses, Collections.singleton(m.getData()));
			}
			for (Message m : pc.getOutgoingMessages()) {
				if (m.getData()!=null)
					getVarDeclDataClasses(dataClasses, enumClasses, Collections.singleton(m.getData()));
			}
			
			if (pc.getRegular()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getRegular().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getRegular().getOperations());
			}
			if (pc.getConjugated()!=null) {
				getAttributeDataClasses(dataClasses, enumClasses, pc.getConjugated().getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, pc.getConjugated().getOperations());
			}
		}
		
		// add data class base classes and data class attribute and operation classes
		boolean repeat = true;
		do {
			LinkedList<DataClass> tmpDc = new LinkedList<DataClass>(dataClasses);
			for (DataClass dc : tmpDc) {
				getAttributeDataClasses(dataClasses, enumClasses, dc.getAttributes());
				getOperationDataClasses(dataClasses, enumClasses, dc.getOperations());
				while (dc.getBase()!=null) {
					dc = dc.getBase();
					dataClasses.add(dc);
				}
			}
			
			if (tmpDc.size()==dataClasses.size())
				// nothing changed
				repeat = false;
		}
		while (repeat);
		
		// finally compute used models
		for (DataClass dc : dataClasses) {
			models.add((RoomModel) dc.eContainer());
		}
		for (EnumerationType et : enumClasses) {
			models.add((RoomModel) et.eContainer());
		}
		for (ProtocolClass pc : protocolClasses) {
			models.add((RoomModel) pc.eContainer());
		}
		for (ActorClass ac : actorClasses) {
			models.add((RoomModel) ac.eContainer());
		}
	}

	private void getInterfaceItemProtocolClasses(
			Set<ProtocolClass> protocolClasses, EList<? extends InterfaceItem> items) {
		for (InterfaceItem ii : items) {
			if (ii instanceof Port && ((Port)ii).getProtocol() instanceof ProtocolClass)
				protocolClasses.add((ProtocolClass) ((Port)ii).getProtocol());
			else if (ii instanceof SAP)
				protocolClasses.add(((SAP)ii).getProtocol());
			else if (ii instanceof SPP)
				protocolClasses.add(((SPP)ii).getProtocol());
		}
	}

	private void getOperationDataClasses(Set<DataClass> dataClasses, Set<EnumerationType> enumClasses, EList<? extends Operation> operations) {
		for (Operation op : operations) {
			if (op.getReturnType()!=null) {
				getClasses(op.getReturnType().getType(), dataClasses, enumClasses);
			}
			getVarDeclDataClasses(dataClasses, enumClasses, op.getArguments());
		}
	}

	private void getVarDeclDataClasses(Set<DataClass> dataClasses, Set<EnumerationType> enumClasses, Collection<VarDecl> decls) {
		for (VarDecl vd : decls) {
			getClasses(vd.getRefType().getType(), dataClasses, enumClasses);
		}
	}

	private void getAttributeDataClasses(Set<DataClass> dataClasses, Set<EnumerationType> enumClasses, Collection<Attribute> attributes) {
		for (Attribute attr : attributes) {
			getClasses(attr.getType().getType(), dataClasses, enumClasses);
		}
	}
	
	private void getMessageDataClasses(Set<DataClass> dataClasses, Set<EnumerationType> enumClasses, EList<Message> messages) {
		for (Message message : messages) {
			if (message.getData()!=null) {
				getClasses(message.getData().getRefType().getType(), dataClasses, enumClasses);
			}
		}
	}

	/**
	 * @param type
	 * @param dataClasses
	 * @param enumClasses
	 */
	private void getClasses(DataType type, Set<DataClass> dataClasses,
			Set<EnumerationType> enumClasses) {
		if (type instanceof DataClass)
			dataClasses.add((DataClass) type);
		else if (type instanceof EnumerationType)
			enumClasses.add((EnumerationType) type);
	}

}
