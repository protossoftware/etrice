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
import java.util.Set;

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
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.util.RoomCrossReferencer;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;

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
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getOptionalInstances <em>Optional Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getOptionalActorClasses <em>Optional Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getWiredInstances <em>Wired Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl#getUsedEnumClasses <em>Used Enum Classes</em>}</li>
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

	private HashMap<ActorClass, BasicEList<ActorClass>> subClasses = new HashMap<ActorClass, BasicEList<ActorClass>>();

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
	 * The cached value of the '{@link #getOptionalInstances() <em>Optional Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<OptionalActorInstance> optionalInstances;

	/**
	 * The cached value of the '{@link #getOptionalActorClasses() <em>Optional Actor Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalActorClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorClass> optionalActorClasses;

	/**
	 * The cached value of the '{@link #getWiredInstances() <em>Wired Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWiredInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<WiredStructureClass> wiredInstances;

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
	public EList<EnumerationType> getUsedEnumClasses() {
		if (usedEnumClasses==null) {
			computeUsedClasses();
		}
		return usedEnumClasses;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OptionalActorInstance> getOptionalInstances() {
		if (optionalInstances == null) {
			optionalInstances = new EObjectContainmentEList<OptionalActorInstance>(OptionalActorInstance.class, this, ETriceGenPackage.ROOT__OPTIONAL_INSTANCES);
		}
		return optionalInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorClass> getOptionalActorClasses() {
		if (optionalActorClasses == null) {
			optionalActorClasses = new EObjectResolvingEList<ActorClass>(ActorClass.class, this, ETriceGenPackage.ROOT__OPTIONAL_ACTOR_CLASSES);
		}
		return optionalActorClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WiredStructureClass> getWiredInstances() {
		if (wiredInstances == null) {
			wiredInstances = new EObjectContainmentEList<WiredStructureClass>(WiredStructureClass.class, this, ETriceGenPackage.ROOT__WIRED_INSTANCES);
		}
		return wiredInstances;
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
		Set<RoomModel> models = crossReferencer.getReferencedModels(cls);
		
		BasicEList<RoomModel> result = new BasicEList<RoomModel>(models);
		Comparator<RoomModel> comp = new RoomModelComparator();
		Collections.sort(result, comp);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProtocolClass> getReferencedProtocolClasses(RoomClass rc) {
		Set<ProtocolClass> protocolClasses = crossReferencer.getReferencedProtocolClasses(rc);
		
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
	public EList<DataClass> getReferencedDataClasses(RoomClass rc) {
		return new BasicEList<DataClass>(crossReferencer.getReferencedDataClasses(rc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EnumerationType> getReferencedEnumClasses(RoomClass rc) {
		return new BasicEList<EnumerationType>(crossReferencer.getReferencedEnumClasses(rc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorClass> getReferencedActorClasses(RoomClass rc) {
		return new BasicEList<ActorClass>(crossReferencer.getReferencedActorClasses(rc));
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
	 * @generated NOT
	 */
	public StructureInstance getInstance(String path) {
		if (!path.startsWith(Character.toString(InstanceBase.pathDelim)))
			return null;
		
		path = path.substring(1);
		String[] segments = path.split(Character.toString(InstanceBase.pathDelim));
		if (segments.length<=1)
			return null;

		String seg = segments[0];
		for (SystemInstance si : getSystemInstances()) {
			if (si.getName().equals(seg)) {
				seg = segments[1];
				for (SubSystemInstance ssi : si.getInstances()) {
					if (ssi.getName().equals(seg)) {
						StructureInstance inst = ssi;
						int i = 2;
						while (i<segments.length && inst!=null) {
							boolean found = false;
							for (AbstractInstance ai : inst.getInstances()) {
								if (ai.getName().equals(segments[i])) {
									if (!(ai instanceof StructureInstance))
										return null;
									
									inst = (StructureInstance) ai;
									++i;
									found = true;
									break;
								}
							}
							if (!found)
								return null;
						}
						return inst;
					}
				}
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorClass> getSubClasses(ActorClass ac) {
		BasicEList<ActorClass> subCls = subClasses.get(ac);
		if (subCls==null)
			subCls = new BasicEList<ActorClass>();
		return subCls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void computeSubClasses() {
		for (RoomModel mdl : getModels()) {
			for (ActorClass ac : mdl.getActorClasses()) {
				ActorClass base = ac.getBase();
				while (base!=null) {
					BasicEList<ActorClass> subs = subClasses.get(base);
					if (subs==null)
						subClasses.put(base, subs = new BasicEList<ActorClass>());
					subs.add(ac);
					base = base.getBase();
				}
			}
		}
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
			case ETriceGenPackage.ROOT__OPTIONAL_INSTANCES:
				return ((InternalEList<?>)getOptionalInstances()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.ROOT__WIRED_INSTANCES:
				return ((InternalEList<?>)getWiredInstances()).basicRemove(otherEnd, msgs);
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
			case ETriceGenPackage.ROOT__OPTIONAL_INSTANCES:
				return getOptionalInstances();
			case ETriceGenPackage.ROOT__OPTIONAL_ACTOR_CLASSES:
				return getOptionalActorClasses();
			case ETriceGenPackage.ROOT__WIRED_INSTANCES:
				return getWiredInstances();
			case ETriceGenPackage.ROOT__USED_ENUM_CLASSES:
				return getUsedEnumClasses();
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
			case ETriceGenPackage.ROOT__OPTIONAL_INSTANCES:
				getOptionalInstances().clear();
				getOptionalInstances().addAll((Collection<? extends OptionalActorInstance>)newValue);
				return;
			case ETriceGenPackage.ROOT__OPTIONAL_ACTOR_CLASSES:
				getOptionalActorClasses().clear();
				getOptionalActorClasses().addAll((Collection<? extends ActorClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__WIRED_INSTANCES:
				getWiredInstances().clear();
				getWiredInstances().addAll((Collection<? extends WiredStructureClass>)newValue);
				return;
			case ETriceGenPackage.ROOT__USED_ENUM_CLASSES:
				getUsedEnumClasses().clear();
				getUsedEnumClasses().addAll((Collection<? extends EnumerationType>)newValue);
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
			case ETriceGenPackage.ROOT__OPTIONAL_INSTANCES:
				getOptionalInstances().clear();
				return;
			case ETriceGenPackage.ROOT__OPTIONAL_ACTOR_CLASSES:
				getOptionalActorClasses().clear();
				return;
			case ETriceGenPackage.ROOT__WIRED_INSTANCES:
				getWiredInstances().clear();
				return;
			case ETriceGenPackage.ROOT__USED_ENUM_CLASSES:
				getUsedEnumClasses().clear();
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
			case ETriceGenPackage.ROOT__OPTIONAL_INSTANCES:
				return optionalInstances != null && !optionalInstances.isEmpty();
			case ETriceGenPackage.ROOT__OPTIONAL_ACTOR_CLASSES:
				return optionalActorClasses != null && !optionalActorClasses.isEmpty();
			case ETriceGenPackage.ROOT__WIRED_INSTANCES:
				return wiredInstances != null && !wiredInstances.isEmpty();
			case ETriceGenPackage.ROOT__USED_ENUM_CLASSES:
				return !getUsedEnumClasses().isEmpty();
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

	private RoomCrossReferencer crossReferencer = new RoomCrossReferencer();
	
	private BasicEList<DataClass> usedDataClasses = null;
	private BasicEList<EnumerationType> usedEnumClasses = null;
	private BasicEList<ProtocolClass> usedProtocolClasses = null;
	private BasicEList<ActorClass> usedActorClasses = null;
	private BasicEList<RoomModel> usedRoomModels = null;
	
	private void computeUsedClasses() {
		if (isLibrary()) {
			usedDataClasses = new BasicEList<DataClass>();
			usedEnumClasses = new BasicEList<EnumerationType>();
			usedProtocolClasses = new BasicEList<ProtocolClass>();
			usedActorClasses = new BasicEList<ActorClass>();
			usedRoomModels = new BasicEList<RoomModel>();
			subSystemClasses = new BasicEList<SubSystemClass>();
			for (RoomModel mdl : getModels()) {
				usedDataClasses.addAll(mdl.getDataClasses());
				usedEnumClasses.addAll(mdl.getEnumerationTypes());
				
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
					else if (obj instanceof ActorInterfaceInstance) {
						ActorInterfaceInstance aii = (ActorInterfaceInstance) obj;
						actorClasses.add(aii.getActorClass());
						for (OptionalActorInstance oai : aii.getOptionalInstances()) {
							actorClasses.add(oai.getActorClass());
						}
					}
				}
			}
			for (OptionalActorInstance oai: getOptionalInstances()) {
				actorClasses.add(oai.getActorClass());
			}
			
			HashSet<DataClass> dataClasses = new HashSet<DataClass>();
			HashSet<EnumerationType> enumClasses = new HashSet<EnumerationType>();
			HashSet<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
			HashSet<RoomModel> models = new HashSet<RoomModel>();
			
			crossReferencer.getReferencedClassesAndModels(dataClasses, enumClasses, protocolClasses,
					actorClasses, models);
			
			usedDataClasses = new BasicEList<DataClass>(dataClasses);
			usedEnumClasses = new BasicEList<EnumerationType>(enumClasses);
			usedProtocolClasses = new BasicEList<ProtocolClass>(protocolClasses);
			usedActorClasses = new BasicEList<ActorClass>(actorClasses);
			usedRoomModels = new BasicEList<RoomModel>(models);
		}
		
		RoomClassComparator rcComp = new RoomClassComparator();
		RoomModelComparator mdlComp = new RoomModelComparator();
		Collections.sort(usedDataClasses, rcComp);
		Collections.sort(usedEnumClasses, rcComp);
		Collections.sort(usedProtocolClasses, rcComp);
		Collections.sort(usedActorClasses, rcComp);
		Collections.sort(usedRoomModels, mdlComp);
	}

} //RootImpl
