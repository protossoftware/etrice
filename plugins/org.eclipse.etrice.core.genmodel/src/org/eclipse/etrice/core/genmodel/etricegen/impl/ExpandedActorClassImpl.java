/**
 *  Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  CONTRIBUTORS:
 *  		Henrik Rentz-Reichert (initial contribution)
 *  
 */
package org.eclipse.etrice.core.genmodel.etricegen.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.AbstractMessage;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expanded Actor Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpandedActorClassImpl extends ExpandedModelComponentImpl implements ExpandedActorClass {
	
	private RoomHelpers roomHelpers = new RoomHelpers();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandedActorClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.EXPANDED_ACTOR_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorClass getActorClass() {
		ActorClass actorClass = basicGetActorClass();
		return actorClass != null && actorClass.eIsProxy() ? (ActorClass)eResolveProxy((InternalEObject)actorClass) : actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ActorClass basicGetActorClass() {
		return (ActorClass) getModelComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VarDecl getVarDeclData(Transition trans) {
		return (VarDecl) getData(trans);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__ACTOR_CLASS:
				return basicGetActorClass() != null;
		}
		return super.eIsSet(featureID);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getOwnInterfaceItems()
	 */
	@Override
	public EList<AbstractInterfaceItem> getOwnInterfaceItems(ModelComponent mc) {
		BasicEList<AbstractInterfaceItem> ownIfItems = new BasicEList<AbstractInterfaceItem>();
		
		ActorClass ac = (ActorClass) mc;
		for (ExternalPort ep : ac.getExternalPorts()) {
			ownIfItems.add(ep.getInterfacePort());
		}
		ownIfItems.addAll(ac.getInternalPorts());
		ownIfItems.addAll(ac.getServiceAccessPoints());
		for (ServiceImplementation svc : ac.getServiceImplementations()) {
			ownIfItems.add(svc.getSpp());
		}
		
		return ownIfItems;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getAllInterfaceItems()
	 */
	@Override
	public EList<AbstractInterfaceItem> getAllInterfaceItems() {
		return new BasicEList<AbstractInterfaceItem>(roomHelpers.getAllInterfaceItems(getActorClass()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#addTransitionChain(org.eclipse.etrice.core.fsm.fSM.Transition)
	 */
	@Override
	public TransitionChain addTransitionChain(Transition t) {
		TransitionChain tc = super.addTransitionChain(t);
		
		if (t instanceof TriggeredTransition) {
			VarDecl data = null;
			
			// TODO: after introduction of VarDecl after 'action' leave this to validation
			
			boolean first = true;
			for (Trigger tr : ((TriggeredTransition)t).getTriggers()) {
				for (MessageFromIf mif : tr.getMsgFromIfPairs()) {
					VarDecl msgData = ((Message)mif.getMessage()).getData();
					if (first) {
						first = false;
						data = msgData;
					}
					else {
						if (data!=null) {
							if (msgData==null) {
								validationError("If one MessageFromIf has data all have to have data for a given transition!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
							}
							else {
								VarDecl a = msgData;
								if (data.getRefType().getType()!=a.getRefType().getType())
									validationError("The data types of all MessageFromIf have to be the same!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
								if (data.getRefType().isRef() !=a.getRefType().isRef())
									validationError("The data types of all MessageFromIf have to be the same ref type!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
							}
						}
						else {
							if (msgData!=null)
								validationError("If one MessageFromIf has no data all have to have no data for a given transition!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
						}
					}
				}
			}
	
			if (first)
				validationError("Triggered transition has to have a message from interface!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
			
			tc.setData(data);
		}
		
		return tc;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getIncomingMessages(org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem)
	 */
	@Override
	public EList<AbstractMessage> getIncomingMessages(AbstractInterfaceItem ifitem) {
		return new BasicEList<AbstractMessage>(roomHelpers.getMessageListDeep((InterfaceItem) ifitem, false));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getMessageID(org.eclipse.etrice.core.fsm.fSM.MessageFromIf)
	 */
	@Override
	public String getMessageID(MessageFromIf mif) {
		if (mif.getFrom() instanceof Port) {
			Port p = (Port) mif.getFrom();
			return p.getProtocol().getName()+(p.isConjugated()?".OUT_":".IN_")+mif.getMessage().getName();
		}
		else if (mif.getFrom() instanceof SAP) {
			SAP sap = (SAP) mif.getFrom();
			return sap.getProtocol().getName()+".OUT_"+mif.getMessage().getName();
		}
		else if (mif.getFrom() instanceof SPP) {
			SPP spp = (SPP) mif.getFrom();
			return spp.getProtocol().getName()+".IN_"+mif.getMessage().getName();
		}

		return "unknown interface item";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#computeCommonChainData(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public EObject computeCommonChainData(EList<TransitionChain> chains) {
		if (chains.size()==1)
			return chains.get(0).getData();
		else {
			ArrayList<RefableType> types = new ArrayList<RefableType>();
			for (TransitionChain chain : chains) {
				if (chain.getData()!=null)
					types.add(((VarDecl) chain.getData()).getRefType());
				else
					types.add(null);
			}
			RefableType rt = roomHelpers.getLastCommonSuperType(types);
			if (rt!=null) {
				VarDecl vd = RoomFactory.eINSTANCE.createVarDecl();
				vd.setName("data");
				vd.setRefType(rt);
				return vd;
			}
			else {
				return null;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getModelComponentName()
	 */
	@Override
	public String getModelComponentName() {
		return getActorClass().getName();
	}
	
} //ExpandedActorClassImpl
