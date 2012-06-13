/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Documentation;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StateGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getGeneralAnnotations <em>General Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getIfPorts <em>If Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStructureDocu <em>Structure Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getIntPorts <em>Int Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getExtPorts <em>Ext Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getServiceImplementations <em>Service Implementations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStrSAPs <em>Str SA Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getBehaviorDocu <em>Behavior Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorClassImpl extends ActorContainerClassImpl implements ActorClass
{
  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #getCommType() <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommType()
   * @generated
   * @ordered
   */
  protected static final ActorCommunicationType COMM_TYPE_EDEFAULT = ActorCommunicationType.EVENT_DRIVEN;

  /**
   * The cached value of the '{@link #getCommType() <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommType()
   * @generated
   * @ordered
   */
  protected ActorCommunicationType commType = COMM_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected ActorClass base;

  /**
   * The cached value of the '{@link #getGeneralAnnotations() <em>General Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> generalAnnotations;

  /**
   * The cached value of the '{@link #getIfPorts() <em>If Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> ifPorts;

  /**
   * The cached value of the '{@link #getStructureDocu() <em>Structure Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructureDocu()
   * @generated
   * @ordered
   */
  protected Documentation structureDocu;

  /**
   * The cached value of the '{@link #getIntPorts() <em>Int Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> intPorts;

  /**
   * The cached value of the '{@link #getExtPorts() <em>Ext Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtPorts()
   * @generated
   * @ordered
   */
  protected EList<ExternalPort> extPorts;

  /**
   * The cached value of the '{@link #getServiceImplementations() <em>Service Implementations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceImplementations()
   * @generated
   * @ordered
   */
  protected EList<ServiceImplementation> serviceImplementations;

  /**
   * The cached value of the '{@link #getStrSAPs() <em>Str SA Ps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrSAPs()
   * @generated
   * @ordered
   */
  protected EList<SAPRef> strSAPs;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getBehaviorDocu() <em>Behavior Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorDocu()
   * @generated
   * @ordered
   */
  protected Documentation behaviorDocu;

  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<StandardOperation> operations;

  /**
   * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachine()
   * @generated
   * @ordered
   */
  protected StateGraph stateMachine;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RoomPackage.Literals.ACTOR_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorCommunicationType getCommType()
  {
    return commType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommType(ActorCommunicationType newCommType)
  {
    ActorCommunicationType oldCommType = commType;
    commType = newCommType == null ? COMM_TYPE_EDEFAULT : newCommType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__COMM_TYPE, oldCommType, commType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (ActorClass)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.ACTOR_CLASS__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(ActorClass newBase)
  {
    ActorClass oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__BASE, oldBase, base));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getGeneralAnnotations()
  {
    if (generalAnnotations == null)
    {
      generalAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS);
    }
    return generalAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getIfPorts()
  {
    if (ifPorts == null)
    {
      ifPorts = new EObjectContainmentEList<Port>(Port.class, this, RoomPackage.ACTOR_CLASS__IF_PORTS);
    }
    return ifPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation getStructureDocu()
  {
    return structureDocu;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStructureDocu(Documentation newStructureDocu, NotificationChain msgs)
  {
    Documentation oldStructureDocu = structureDocu;
    structureDocu = newStructureDocu;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU, oldStructureDocu, newStructureDocu);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructureDocu(Documentation newStructureDocu)
  {
    if (newStructureDocu != structureDocu)
    {
      NotificationChain msgs = null;
      if (structureDocu != null)
        msgs = ((InternalEObject)structureDocu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU, null, msgs);
      if (newStructureDocu != null)
        msgs = ((InternalEObject)newStructureDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU, null, msgs);
      msgs = basicSetStructureDocu(newStructureDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU, newStructureDocu, newStructureDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getIntPorts()
  {
    if (intPorts == null)
    {
      intPorts = new EObjectContainmentEList<Port>(Port.class, this, RoomPackage.ACTOR_CLASS__INT_PORTS);
    }
    return intPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalPort> getExtPorts()
  {
    if (extPorts == null)
    {
      extPorts = new EObjectContainmentEList<ExternalPort>(ExternalPort.class, this, RoomPackage.ACTOR_CLASS__EXT_PORTS);
    }
    return extPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceImplementation> getServiceImplementations()
  {
    if (serviceImplementations == null)
    {
      serviceImplementations = new EObjectContainmentEList<ServiceImplementation>(ServiceImplementation.class, this, RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS);
    }
    return serviceImplementations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SAPRef> getStrSAPs()
  {
    if (strSAPs == null)
    {
      strSAPs = new EObjectContainmentEList<SAPRef>(SAPRef.class, this, RoomPackage.ACTOR_CLASS__STR_SA_PS);
    }
    return strSAPs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, RoomPackage.ACTOR_CLASS__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation getBehaviorDocu()
  {
    return behaviorDocu;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorDocu(Documentation newBehaviorDocu, NotificationChain msgs)
  {
    Documentation oldBehaviorDocu = behaviorDocu;
    behaviorDocu = newBehaviorDocu;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU, oldBehaviorDocu, newBehaviorDocu);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviorDocu(Documentation newBehaviorDocu)
  {
    if (newBehaviorDocu != behaviorDocu)
    {
      NotificationChain msgs = null;
      if (behaviorDocu != null)
        msgs = ((InternalEObject)behaviorDocu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU, null, msgs);
      if (newBehaviorDocu != null)
        msgs = ((InternalEObject)newBehaviorDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU, null, msgs);
      msgs = basicSetBehaviorDocu(newBehaviorDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU, newBehaviorDocu, newBehaviorDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, RoomPackage.ACTOR_CLASS__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StandardOperation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<StandardOperation>(StandardOperation.class, this, RoomPackage.ACTOR_CLASS__OPERATIONS);
    }
    return operations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateGraph getStateMachine()
  {
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStateMachine(StateGraph newStateMachine, NotificationChain msgs)
  {
    StateGraph oldStateMachine = stateMachine;
    stateMachine = newStateMachine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__STATE_MACHINE, oldStateMachine, newStateMachine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateMachine(StateGraph newStateMachine)
  {
    if (newStateMachine != stateMachine)
    {
      NotificationChain msgs = null;
      if (stateMachine != null)
        msgs = ((InternalEObject)stateMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__STATE_MACHINE, null, msgs);
      if (newStateMachine != null)
        msgs = ((InternalEObject)newStateMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CLASS__STATE_MACHINE, null, msgs);
      msgs = basicSetStateMachine(newStateMachine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__STATE_MACHINE, newStateMachine, newStateMachine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS:
        return ((InternalEList<?>)getGeneralAnnotations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__IF_PORTS:
        return ((InternalEList<?>)getIfPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return basicSetStructureDocu(null, msgs);
      case RoomPackage.ACTOR_CLASS__INT_PORTS:
        return ((InternalEList<?>)getIntPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__EXT_PORTS:
        return ((InternalEList<?>)getExtPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return ((InternalEList<?>)getServiceImplementations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__STR_SA_PS:
        return ((InternalEList<?>)getStrSAPs()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return basicSetBehaviorDocu(null, msgs);
      case RoomPackage.ACTOR_CLASS__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return basicSetStateMachine(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CLASS__ABSTRACT:
        return isAbstract();
      case RoomPackage.ACTOR_CLASS__COMM_TYPE:
        return getCommType();
      case RoomPackage.ACTOR_CLASS__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS:
        return getGeneralAnnotations();
      case RoomPackage.ACTOR_CLASS__IF_PORTS:
        return getIfPorts();
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return getStructureDocu();
      case RoomPackage.ACTOR_CLASS__INT_PORTS:
        return getIntPorts();
      case RoomPackage.ACTOR_CLASS__EXT_PORTS:
        return getExtPorts();
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return getServiceImplementations();
      case RoomPackage.ACTOR_CLASS__STR_SA_PS:
        return getStrSAPs();
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return getAttributes();
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return getBehaviorDocu();
      case RoomPackage.ACTOR_CLASS__ANNOTATIONS:
        return getAnnotations();
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return getOperations();
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return getStateMachine();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CLASS__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__COMM_TYPE:
        setCommType((ActorCommunicationType)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__BASE:
        setBase((ActorClass)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS:
        getGeneralAnnotations().clear();
        getGeneralAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__IF_PORTS:
        getIfPorts().clear();
        getIfPorts().addAll((Collection<? extends Port>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        setStructureDocu((Documentation)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__INT_PORTS:
        getIntPorts().clear();
        getIntPorts().addAll((Collection<? extends Port>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__EXT_PORTS:
        getExtPorts().clear();
        getExtPorts().addAll((Collection<? extends ExternalPort>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        getServiceImplementations().clear();
        getServiceImplementations().addAll((Collection<? extends ServiceImplementation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STR_SA_PS:
        getStrSAPs().clear();
        getStrSAPs().addAll((Collection<? extends SAPRef>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        setBehaviorDocu((Documentation)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends StandardOperation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        setStateMachine((StateGraph)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CLASS__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case RoomPackage.ACTOR_CLASS__COMM_TYPE:
        setCommType(COMM_TYPE_EDEFAULT);
        return;
      case RoomPackage.ACTOR_CLASS__BASE:
        setBase((ActorClass)null);
        return;
      case RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS:
        getGeneralAnnotations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__IF_PORTS:
        getIfPorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        setStructureDocu((Documentation)null);
        return;
      case RoomPackage.ACTOR_CLASS__INT_PORTS:
        getIntPorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__EXT_PORTS:
        getExtPorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        getServiceImplementations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__STR_SA_PS:
        getStrSAPs().clear();
        return;
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        getAttributes().clear();
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        setBehaviorDocu((Documentation)null);
        return;
      case RoomPackage.ACTOR_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        getOperations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        setStateMachine((StateGraph)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RoomPackage.ACTOR_CLASS__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case RoomPackage.ACTOR_CLASS__COMM_TYPE:
        return commType != COMM_TYPE_EDEFAULT;
      case RoomPackage.ACTOR_CLASS__BASE:
        return base != null;
      case RoomPackage.ACTOR_CLASS__GENERAL_ANNOTATIONS:
        return generalAnnotations != null && !generalAnnotations.isEmpty();
      case RoomPackage.ACTOR_CLASS__IF_PORTS:
        return ifPorts != null && !ifPorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return structureDocu != null;
      case RoomPackage.ACTOR_CLASS__INT_PORTS:
        return intPorts != null && !intPorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__EXT_PORTS:
        return extPorts != null && !extPorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return serviceImplementations != null && !serviceImplementations.isEmpty();
      case RoomPackage.ACTOR_CLASS__STR_SA_PS:
        return strSAPs != null && !strSAPs.isEmpty();
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return behaviorDocu != null;
      case RoomPackage.ACTOR_CLASS__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return stateMachine != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(", commType: ");
    result.append(commType);
    result.append(')');
    return result.toString();
  }

} //ActorClassImpl
