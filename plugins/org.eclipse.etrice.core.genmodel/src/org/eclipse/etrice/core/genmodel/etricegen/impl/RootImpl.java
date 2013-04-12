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

package org.eclipse.etrice.core.genmodel.etricegen.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;

import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#isLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getSystemInstances <em>System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getOwnSubSystemInstances <em>Own Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getSubSystemInstances <em>Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getXpActorClasses <em>Xp Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getUsedDataClasses <em>Used Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getUsedProtocolClasses <em>Used Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getUsedActorClasses <em>Used Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getUsedRoomModels <em>Used Room Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getSubSystemClasses <em>Sub System Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root {
	
	private class RoomClassComparator implements Comparator<RoomClass> {

		@Override
		public int compare(RoomClass o1, RoomClass o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

	private class RoomModelComparator implements Comparator<RoomModel> {

		@Override
		public int compare(RoomModel o1, RoomModel o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

	/**
	 * The default value of the '{@link #isLibrary() <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIBRARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLibrary() <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLibrary()
	 * @generated
	 * @ordered
	 */
	protected boolean library = LIBRARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSystemInstances() <em>System Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemInstance> systemInstances;

	/**
	 * The cached value of the '{@link #getOwnSubSystemInstances() <em>Own Sub System Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnSubSystemInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<SubSystemInstance> ownSubSystemInstances;

	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<RoomModel> models;

	/**
	 * The cached value of the '{@link #getXpActorClasses() <em>Xp Actor Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpActorClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpandedActorClass> xpActorClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SubSystemInstance> getSubSystemInstances() {
		if (getOwnSubSystemInstances().isEmpty()) {
			// we have top level logical system(s)
			// add all their sub system instances
			ArrayList<SubSystemInstance> result = new ArrayList<SubSystemInstance>();
			
			for (SystemInstance si : getSystemInstances()) {
				result.addAll(si.getInstances());
			}
			
			return new DelegatingEList.UnmodifiableEList<SubSystemInstance>(result);
		}
		else
			return new DelegatingEList.UnmodifiableEList<SubSystemInstance>((getOwnSubSystemInstances()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoomModel> getModels() {
		if (models == null) {
			models = new EObjectResolvingEList<RoomModel>(RoomModel.class, this, ETriceGenPackage.ROOT__MODELS);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpandedActorClass> getXpActorClasses() {
		if (xpActorClasses == null) {
			xpActorClasses = new EObjectContainmentEList<ExpandedActorClass>(ExpandedActorClass.class, this, ETriceGenPackage.ROOT__XP_ACTOR_CLASSES);
		}
		return xpActorClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DataClass> getUsedDataClasses() {
		if (usedDataClasses==null) {
			computeUsedClasses();
		}
		return usedDataClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProtocolClass> getUsedProtocolClasses() {
		if (usedProtocolClasses==null) {
			computeUsedClasses();
		}
		return usedProtocolClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorClass> getUsedActorClasses() {
		if (usedActorClasses==null) {
			computeUsedClasses();
		}
		return usedActorClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RoomModel> getUsedRoomModels() {
		if (usedRoomModels==null) {
			computeUsedClasses();
		}
		return usedRoomModels;
	}

	private BasicEList<SubSystemClass> subSystemClasses = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SubSystemClass> getSubSystemClasses() {
		if (subSystemClasses==null) {
			collectSubSystems();
		}
		return subSystemClasses;
	}

	private void collectSubSystems() {
		subSystemClasses = new BasicEList<SubSystemClass>();
	
		if (!getModels().isEmpty()) {
			for (RoomModel mdl : getModels()) {
				subSystemClasses.addAll(mdl.getSubSystemClasses());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLibrary() {
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibrary(boolean newLibrary) {
		boolean oldLibrary = library;
		library = newLibrary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ROOT__LIBRARY, oldLibrary, library));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemInstance> getSystemInstances() {
		if (systemInstances == null) {
			systemInstances = new EObjectContainmentEList<SystemInstance>(SystemInstance.class, this, ETriceGenPackage.ROOT__SYSTEM_INSTANCES);
		}
		return systemInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubSystemInstance> getOwnSubSystemInstances() {
		if (ownSubSystemInstances == null) {
			ownSubSystemInstances = new EObjectContainmentEList<SubSystemInstance>(SubSystemInstance.class, this, ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES);
		}
		return ownSubSystemInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RoomModel> getReferencedModels(RoomClass cls) {

		HashSet<DataClass> dataClasses = new HashSet<DataClass>();
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

		getReferencedClassesAndModels(dataClasses, protocolClasses,
				actorClasses, models);

		// remove own model
		models.remove(cls.eContainer());
		
		BasicEList<RoomModel> result = new BasicEList<RoomModel>(models);
		Comparator<RoomModel> comp = new RoomModelComparator();
		Collections.sort(result, comp);
		return result;
	}

	private void recursivelyAddReferencedClasses(ActorClass ac, HashSet<ActorClass> actorClasses) {
		actorClasses.add(ac);
		
		for (ActorRef ar : ac.getActorRefs()) {
			recursivelyAddReferencedClasses(ar.getType(), actorClasses);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProtocolClass> getReferencedProtocolClasses(ActorClass cls) {

		if (cls instanceof ExpandedActorClass)
			cls = ((ExpandedActorClass)cls).getActorClass();

		HashSet<DataClass> dataClasses = new HashSet<DataClass>();
		HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
		HashSet<RoomModel> models = new HashSet<RoomModel>();

		actorClasses.add(cls);

		getReferencedClassesAndModels(dataClasses, protocolClasses,
				actorClasses, models);
		
		BasicEList<ProtocolClass> result = new BasicEList<ProtocolClass>(protocolClasses);
		Comparator<RoomClass> comp = new RoomClassComparator();
		Collections.sort(result, comp);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExpandedActorClass getExpandedActorClass(ActorInstance ai) {
		for (ExpandedActorClass xpac : getXpActorClasses()) {
			if (xpac.getActorClass()==ai.getActorClass())
				return xpac;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__SYSTEM_INSTANCES:
				return ((InternalEList<?>)getSystemInstances()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES:
				return ((InternalEList<?>)getOwnSubSystemInstances()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return ((InternalEList<?>)getXpActorClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				return isLibrary();
			case ETriceGenPackage.ROOT__SYSTEM_INSTANCES:
				return getSystemInstances();
			case ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES:
				return getOwnSubSystemInstances();
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				return getSubSystemInstances();
			case ETriceGenPackage.ROOT__MODELS:
				return getModels();
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return getXpActorClasses();
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				return getUsedDataClasses();
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				return getUsedProtocolClasses();
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				return getUsedActorClasses();
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				return getUsedRoomModels();
			case ETriceGenPackage.ROOT__SUB_SYSTEM_CLASSES:
				return getSubSystemClasses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				setLibrary((Boolean)newValue);
				return;
			case ETriceGenPackage.ROOT__SYSTEM_INSTANCES:
				getSystemInstances().clear();
				getSystemInstances().addAll((Collection<? extends SystemInstance>)newValue);
				return;
			case ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES:
				getOwnSubSystemInstances().clear();
				getOwnSubSystemInstances().addAll((Collection<? extends SubSystemInstance>)newValue);
				return;
			case ETriceGenPackage.ROOT__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends RoomModel>)newValue);
				return;
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				getXpActorClasses().clear();
				getXpActorClasses().addAll((Collection<? extends ExpandedActorClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				getUsedDataClasses().clear();
				getUsedDataClasses().addAll((Collection<? extends DataClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				getUsedProtocolClasses().clear();
				getUsedProtocolClasses().addAll((Collection<? extends ProtocolClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				getUsedActorClasses().clear();
				getUsedActorClasses().addAll((Collection<? extends ActorClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				getUsedRoomModels().clear();
				getUsedRoomModels().addAll((Collection<? extends RoomModel>)newValue);
				return;
			case ETriceGenPackage.ROOT__SUB_SYSTEM_CLASSES:
				getSubSystemClasses().clear();
				getSubSystemClasses().addAll((Collection<? extends SubSystemClass>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				setLibrary(LIBRARY_EDEFAULT);
				return;
			case ETriceGenPackage.ROOT__SYSTEM_INSTANCES:
				getSystemInstances().clear();
				return;
			case ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES:
				getOwnSubSystemInstances().clear();
				return;
			case ETriceGenPackage.ROOT__MODELS:
				getModels().clear();
				return;
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				getXpActorClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				getUsedDataClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				getUsedProtocolClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				getUsedActorClasses().clear();
				return;
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				getUsedRoomModels().clear();
				return;
			case ETriceGenPackage.ROOT__SUB_SYSTEM_CLASSES:
				getSubSystemClasses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.ROOT__LIBRARY:
				return library != LIBRARY_EDEFAULT;
			case ETriceGenPackage.ROOT__SYSTEM_INSTANCES:
				return systemInstances != null && !systemInstances.isEmpty();
			case ETriceGenPackage.ROOT__OWN_SUB_SYSTEM_INSTANCES:
				return ownSubSystemInstances != null && !ownSubSystemInstances.isEmpty();
			case ETriceGenPackage.ROOT__SUB_SYSTEM_INSTANCES:
				return !getSubSystemInstances().isEmpty();
			case ETriceGenPackage.ROOT__MODELS:
				return models != null && !models.isEmpty();
			case ETriceGenPackage.ROOT__XP_ACTOR_CLASSES:
				return xpActorClasses != null && !xpActorClasses.isEmpty();
			case ETriceGenPackage.ROOT__USED_DATA_CLASSES:
				return !getUsedDataClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_PROTOCOL_CLASSES:
				return !getUsedProtocolClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_ACTOR_CLASSES:
				return !getUsedActorClasses().isEmpty();
			case ETriceGenPackage.ROOT__USED_ROOM_MODELS:
				return !getUsedRoomModels().isEmpty();
			case ETriceGenPackage.ROOT__SUB_SYSTEM_CLASSES:
				return !getSubSystemClasses().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (library: ");
		result.append(library);
		result.append(')');
		return result.toString();
	}

	private HashMap<String, DataClass> name2dc = new HashMap<String, DataClass>();
	
	private BasicEList<DataClass> usedDataClasses = null;
	private BasicEList<ProtocolClass> usedProtocolClasses = null;
	private BasicEList<ActorClass> usedActorClasses = null;
	private BasicEList<RoomModel> usedRoomModels = null;
	
	private void computeUsedClasses() {
		if (isLibrary()) {
			usedDataClasses = new BasicEList<DataClass>();
			usedProtocolClasses = new BasicEList<ProtocolClass>();
			usedActorClasses = new BasicEList<ActorClass>();
			usedRoomModels = new BasicEList<RoomModel>();
			subSystemClasses = new BasicEList<SubSystemClass>();
			for (RoomModel mdl : getModels()) {
				usedDataClasses.addAll(mdl.getDataClasses());
				
				for (GeneralProtocolClass gpc : mdl.getProtocolClasses()) {
					if (gpc instanceof ProtocolClass)
						usedProtocolClasses.add((ProtocolClass) gpc);
				}
				
				usedActorClasses.addAll(mdl.getActorClasses());
				subSystemClasses.addAll(mdl.getSubSystemClasses());
				usedRoomModels.add(mdl);
			}
		}
		else {
			for (RoomModel mdl : getModels()) {
				for (DataClass dc : mdl.getDataClasses()) {
					name2dc.put(dc.getName(), dc);
				}
			}
			
			// first we collect actor classes
			HashSet<ActorClass> actorClasses = new HashSet<ActorClass>();
			for (SubSystemInstance ci : getSubSystemInstances()) {
				TreeIterator<EObject> it = ci.eAllContents();
				while (it.hasNext()) {
					EObject obj = it.next();
					if (obj instanceof ActorInstance) {
						ActorClass ac = ((ActorInstance)obj).getActorClass();
						actorClasses.add(ac);
					}
				}
			}
			
			HashSet<DataClass> dataClasses = new HashSet<DataClass>();
			HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
			HashSet<RoomModel> models = new HashSet<RoomModel>();
			
			getReferencedClassesAndModels(dataClasses, protocolClasses,
					actorClasses, models);
			
			usedDataClasses = new BasicEList<DataClass>(dataClasses);
			usedProtocolClasses = new BasicEList<ProtocolClass>(protocolClasses);
			usedActorClasses = new BasicEList<ActorClass>(actorClasses);
			usedRoomModels = new BasicEList<RoomModel>(models);
		}
		
		RoomClassComparator rcComp = new RoomClassComparator();
		RoomModelComparator mdlComp = new RoomModelComparator();
		Collections.sort(usedDataClasses, rcComp);
		Collections.sort(usedProtocolClasses, rcComp);
		Collections.sort(usedActorClasses, rcComp);
		Collections.sort(usedRoomModels, mdlComp);
	}

	private void getReferencedClassesAndModels(HashSet<DataClass> dataClasses,
			HashSet<ProtocolClass> protocolClasses,
			HashSet<ActorClass> actorClasses, HashSet<RoomModel> models) {
		// add actor base classes
		LinkedList<ActorClass> tmpAc = new LinkedList<ActorClass>(actorClasses);
		for (ActorClass ac : tmpAc) {
			while (ac.getBase()!=null) {
				ac = ac.getBase();
				actorClasses.add(ac);
			}
		}
		
		// add referenced actor classes
		tmpAc = new LinkedList<ActorClass>(actorClasses);
		for (ActorClass ac : tmpAc) {
			for (ActorRef ref : ac.getActorRefs()) {
				actorClasses.add(ref.getType());
			}
		}
		
		// determine data and protocol classes used by actor classes
		for (ActorClass ac : actorClasses) {
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIfPorts());
			// ExtPorts are in the interface and thus already covered
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIntPorts());
			getInterfaceItemProtocolClasses(protocolClasses, ac.getStrSAPs());
			for (ServiceImplementation ispp : ac.getServiceImplementations()) {
				protocolClasses.add(ispp.getSpp().getProtocol());
			}
			getInterfaceItemProtocolClasses(protocolClasses, ac.getIfSPPs());
			getAttributeDataClasses(dataClasses, ac.getAttributes());
			getOperationDataClasses(dataClasses, ac.getOperations());
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
					getVarDeclDataClasses(dataClasses, Collections.singleton(m.getData()));
			}
			for (Message m : pc.getOutgoingMessages()) {
				if (m.getData()!=null)
					getVarDeclDataClasses(dataClasses, Collections.singleton(m.getData()));
			}
			
			if (pc.getRegular()!=null) {
				getAttributeDataClasses(dataClasses, pc.getRegular().getAttributes());
				getOperationDataClasses(dataClasses, pc.getRegular().getOperations());
			}
			if (pc.getConjugate()!=null) {
				getAttributeDataClasses(dataClasses, pc.getConjugate().getAttributes());
				getOperationDataClasses(dataClasses, pc.getConjugate().getOperations());
			}
		}
		
		// add data class base classes and data class attribute and operation classes
		boolean repeat = true;
		do {
			LinkedList<DataClass> tmpDc = new LinkedList<DataClass>(dataClasses);
			for (DataClass dc : tmpDc) {
				getAttributeDataClasses(dataClasses, dc.getAttributes());
				getOperationDataClasses(dataClasses, dc.getOperations());
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
		for (ProtocolClass pc : protocolClasses) {
			models.add((RoomModel) pc.eContainer());
		}
		for (ActorClass ac : actorClasses) {
			models.add((RoomModel) ac.eContainer());
		}
	}

	private void getInterfaceItemProtocolClasses(
			HashSet<ProtocolClass> protocolClasses, EList<? extends InterfaceItem> items) {
		for (InterfaceItem ii : items) {
			if (ii instanceof Port && ((Port)ii).getProtocol() instanceof ProtocolClass)
				protocolClasses.add((ProtocolClass) ((Port)ii).getProtocol());
			else if (ii instanceof SAPRef)
				protocolClasses.add(((SAPRef)ii).getProtocol());
			else if (ii instanceof SPPRef)
				protocolClasses.add(((SPPRef)ii).getProtocol());
		}
	}

	private void getOperationDataClasses(HashSet<DataClass> dataClasses, EList<? extends Operation> operations) {
		for (Operation op : operations) {
			if (op.getReturntype()!=null) {
				DataClass dc = name2dc.get(op.getReturntype().getType().getName());
				if (dc!=null)
					dataClasses.add(dc);
			}
			getVarDeclDataClasses(dataClasses, op.getArguments());
		}
	}

	private void getVarDeclDataClasses(HashSet<DataClass> dataClasses, Collection<VarDecl> decls) {
		for (VarDecl vd : decls) {
			DataClass dc = name2dc.get(vd.getRefType().getType().getName());
			if (dc!=null)
				dataClasses.add(dc);
		}
	}

	private void getAttributeDataClasses(HashSet<DataClass> dataClasses, Collection<Attribute> attributes) {
		for (Attribute attr : attributes) {
			DataClass dc = name2dc.get(attr.getRefType().getType().getName());
			if (dc!=null)
				dataClasses.add(dc);
		}
	}

	// TODO: is this the correct place?
	public HashSet<DataClass> getReferencedDataClasses(DataClass cls){
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		if (cls.getBase()!=null)
			dataClasses.add(cls.getBase());
		getAttributeDataClasses(dataClasses, cls.getAttributes());
		getOperationDataClasses(dataClasses, cls.getOperations());
		return dataClasses;
	}

	public HashSet<DataClass> getReferencedDataClasses(ActorClass cls){
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		do {
			getAttributeDataClasses(dataClasses, cls.getAttributes());
			getOperationDataClasses(dataClasses, cls.getOperations());
			cls = cls.getBase();
		}
		while (cls!=null);
		
		return dataClasses;
	}

	public HashSet<DataClass> getReferencedDataClasses(ProtocolClass pc){
		HashSet<DataClass> dataClasses = new  HashSet<DataClass>();
		getMessageDataClasses(dataClasses, pc.getIncomingMessages());
		getMessageDataClasses(dataClasses, pc.getOutgoingMessages());
		if (pc.getRegular()!=null) {
			getAttributeDataClasses(dataClasses, pc.getRegular().getAttributes());
			getOperationDataClasses(dataClasses, pc.getRegular().getOperations());
		}
		if (pc.getConjugate()!=null) {
			getAttributeDataClasses(dataClasses, pc.getConjugate().getAttributes());
			getOperationDataClasses(dataClasses, pc.getConjugate().getOperations());
		}
		return dataClasses;
	}
	
	private void getMessageDataClasses(HashSet<DataClass> dataClasses, EList<Message> messages) {
		for (Message message : messages) {
			if (message.getData()!=null) {
				if (message.getData().getRefType().getType() instanceof DataClass) {
					DataClass dc = (DataClass) message.getData().getRefType().getType();
					if (dc!=null)
						dataClasses.add(dc);
				}
			}
		}
	}

} //RootImpl
