/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.Documentation;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;

import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getInterfacePorts <em>Interface Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStructureDocu <em>Structure Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getInternalPorts <em>Internal Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getExternalPorts <em>External Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getServiceImplementations <em>Service Implementations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getServiceAccessPoints <em>Service Access Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getBehaviorDocu <em>Behavior Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getBehaviorAnnotations <em>Behavior Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getStructors <em>Structors</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorClassImpl#getOperations <em>Operations</em>}</li>
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
  protected static final ComponentCommunicationType COMM_TYPE_EDEFAULT = ComponentCommunicationType.EVENT_DRIVEN;

  /**
   * The cached value of the '{@link #getCommType() <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommType()
   * @generated
   * @ordered
   */
  protected ComponentCommunicationType commType = COMM_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentName()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentName()
   * @generated
   * @ordered
   */
  protected String componentName = COMPONENT_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected ModelComponent base;

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
   * The cached value of the '{@link #getInterfacePorts() <em>Interface Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfacePorts()
   * @generated
   * @ordered
   */
  protected EList<Port> interfacePorts;

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
   * The cached value of the '{@link #getInternalPorts() <em>Internal Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInternalPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> internalPorts;

  /**
   * The cached value of the '{@link #getExternalPorts() <em>External Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalPorts()
   * @generated
   * @ordered
   */
  protected EList<ExternalPort> externalPorts;

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
   * The cached value of the '{@link #getServiceAccessPoints() <em>Service Access Points</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceAccessPoints()
   * @generated
   * @ordered
   */
  protected EList<SAP> serviceAccessPoints;

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
   * The cached value of the '{@link #getBehaviorAnnotations() <em>Behavior Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> behaviorAnnotations;

  /**
   * The cached value of the '{@link #getStructors() <em>Structors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructors()
   * @generated
   * @ordered
   */
  protected EList<ClassStructor> structors;

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
  public ComponentCommunicationType getCommType()
  {
    return commType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommType(ComponentCommunicationType newCommType)
  {
    ComponentCommunicationType oldCommType = commType;
    commType = newCommType == null ? COMM_TYPE_EDEFAULT : newCommType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__COMM_TYPE, oldCommType, commType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComponentName_()
  {
    return componentName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentName(String newComponentName)
  {
    String oldComponentName = componentName;
    componentName = newComponentName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__COMPONENT_NAME, oldComponentName, componentName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelComponent getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (ModelComponent)eResolveProxy(oldBase);
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
  public ModelComponent basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(ModelComponent newBase)
  {
    ModelComponent oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CLASS__BASE, oldBase, base));
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
  public EList<Port> getInterfacePorts()
  {
    if (interfacePorts == null)
    {
      interfacePorts = new EObjectContainmentEList<Port>(Port.class, this, RoomPackage.ACTOR_CLASS__INTERFACE_PORTS);
    }
    return interfacePorts;
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
  public EList<Port> getInternalPorts()
  {
    if (internalPorts == null)
    {
      internalPorts = new EObjectContainmentEList<Port>(Port.class, this, RoomPackage.ACTOR_CLASS__INTERNAL_PORTS);
    }
    return internalPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalPort> getExternalPorts()
  {
    if (externalPorts == null)
    {
      externalPorts = new EObjectContainmentEList<ExternalPort>(ExternalPort.class, this, RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS);
    }
    return externalPorts;
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
  public EList<SAP> getServiceAccessPoints()
  {
    if (serviceAccessPoints == null)
    {
      serviceAccessPoints = new EObjectContainmentEList<SAP>(SAP.class, this, RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS);
    }
    return serviceAccessPoints;
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
  public EList<Annotation> getBehaviorAnnotations()
  {
    if (behaviorAnnotations == null)
    {
      behaviorAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS);
    }
    return behaviorAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassStructor> getStructors()
  {
    if (structors == null)
    {
      structors = new EObjectContainmentEList<ClassStructor>(ClassStructor.class, this, RoomPackage.ACTOR_CLASS__STRUCTORS);
    }
    return structors;
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
  public EList<Port> getExternalEndPorts()
  {
    EList<Port> ports = new BasicEList<Port>();
    for (ExternalPort ep : getExternalPorts()) {
      ports.add(ep.getInterfacePort());
    }
    return ports;
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getRelayPorts()
  {
    EList<Port> ports = new BasicEList<Port>(getInterfacePorts());
    for (ExternalPort ep : getExternalPorts()) {
      ports.remove(ep.getInterfacePort());
    }
    return ports;
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SPP> getImplementedSPPs()
  {
    EList<SPP> spps = new BasicEList<SPP>();
    for (ServiceImplementation spp : getServiceImplementations()) {
      spps.add(spp.getSpp());
    }
    return spps;
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass getActorBase()
  {
    return (ActorClass)getBase();
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComponentName()
  {
    return getName();
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractInterfaceItem> getAbstractInterfaceItems()
  {
    return new BasicEList<AbstractInterfaceItem>(new RoomHelpers().getInterfaceItems(this));
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractInterfaceItem> getAllAbstractInterfaceItems()
  {
    return new BasicEList<AbstractInterfaceItem>(new RoomHelpers().getAllInterfaceItems(this));
    
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
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return basicSetStateMachine(null, msgs);
      case RoomPackage.ACTOR_CLASS__INTERFACE_PORTS:
        return ((InternalEList<?>)getInterfacePorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return basicSetStructureDocu(null, msgs);
      case RoomPackage.ACTOR_CLASS__INTERNAL_PORTS:
        return ((InternalEList<?>)getInternalPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS:
        return ((InternalEList<?>)getExternalPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return ((InternalEList<?>)getServiceImplementations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS:
        return ((InternalEList<?>)getServiceAccessPoints()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return basicSetBehaviorDocu(null, msgs);
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS:
        return ((InternalEList<?>)getBehaviorAnnotations()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__STRUCTORS:
        return ((InternalEList<?>)getStructors()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.ACTOR_CLASS__COMPONENT_NAME:
        return getComponentName();
      case RoomPackage.ACTOR_CLASS__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return getStateMachine();
      case RoomPackage.ACTOR_CLASS__INTERFACE_PORTS:
        return getInterfacePorts();
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return getStructureDocu();
      case RoomPackage.ACTOR_CLASS__INTERNAL_PORTS:
        return getInternalPorts();
      case RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS:
        return getExternalPorts();
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return getServiceImplementations();
      case RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS:
        return getServiceAccessPoints();
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return getAttributes();
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return getBehaviorDocu();
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS:
        return getBehaviorAnnotations();
      case RoomPackage.ACTOR_CLASS__STRUCTORS:
        return getStructors();
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return getOperations();
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
        setCommType((ComponentCommunicationType)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__COMPONENT_NAME:
        setComponentName((String)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__BASE:
        setBase((ModelComponent)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        setStateMachine((StateGraph)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__INTERFACE_PORTS:
        getInterfacePorts().clear();
        getInterfacePorts().addAll((Collection<? extends Port>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        setStructureDocu((Documentation)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__INTERNAL_PORTS:
        getInternalPorts().clear();
        getInternalPorts().addAll((Collection<? extends Port>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS:
        getExternalPorts().clear();
        getExternalPorts().addAll((Collection<? extends ExternalPort>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        getServiceImplementations().clear();
        getServiceImplementations().addAll((Collection<? extends ServiceImplementation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS:
        getServiceAccessPoints().clear();
        getServiceAccessPoints().addAll((Collection<? extends SAP>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        setBehaviorDocu((Documentation)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS:
        getBehaviorAnnotations().clear();
        getBehaviorAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTORS:
        getStructors().clear();
        getStructors().addAll((Collection<? extends ClassStructor>)newValue);
        return;
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends StandardOperation>)newValue);
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
      case RoomPackage.ACTOR_CLASS__COMPONENT_NAME:
        setComponentName(COMPONENT_NAME_EDEFAULT);
        return;
      case RoomPackage.ACTOR_CLASS__BASE:
        setBase((ModelComponent)null);
        return;
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        setStateMachine((StateGraph)null);
        return;
      case RoomPackage.ACTOR_CLASS__INTERFACE_PORTS:
        getInterfacePorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        setStructureDocu((Documentation)null);
        return;
      case RoomPackage.ACTOR_CLASS__INTERNAL_PORTS:
        getInternalPorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS:
        getExternalPorts().clear();
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        getServiceImplementations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS:
        getServiceAccessPoints().clear();
        return;
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        getAttributes().clear();
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        setBehaviorDocu((Documentation)null);
        return;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS:
        getBehaviorAnnotations().clear();
        return;
      case RoomPackage.ACTOR_CLASS__STRUCTORS:
        getStructors().clear();
        return;
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        getOperations().clear();
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
      case RoomPackage.ACTOR_CLASS__COMPONENT_NAME:
        return COMPONENT_NAME_EDEFAULT == null ? componentName != null : !COMPONENT_NAME_EDEFAULT.equals(componentName);
      case RoomPackage.ACTOR_CLASS__BASE:
        return base != null;
      case RoomPackage.ACTOR_CLASS__STATE_MACHINE:
        return stateMachine != null;
      case RoomPackage.ACTOR_CLASS__INTERFACE_PORTS:
        return interfacePorts != null && !interfacePorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__STRUCTURE_DOCU:
        return structureDocu != null;
      case RoomPackage.ACTOR_CLASS__INTERNAL_PORTS:
        return internalPorts != null && !internalPorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__EXTERNAL_PORTS:
        return externalPorts != null && !externalPorts.isEmpty();
      case RoomPackage.ACTOR_CLASS__SERVICE_IMPLEMENTATIONS:
        return serviceImplementations != null && !serviceImplementations.isEmpty();
      case RoomPackage.ACTOR_CLASS__SERVICE_ACCESS_POINTS:
        return serviceAccessPoints != null && !serviceAccessPoints.isEmpty();
      case RoomPackage.ACTOR_CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_DOCU:
        return behaviorDocu != null;
      case RoomPackage.ACTOR_CLASS__BEHAVIOR_ANNOTATIONS:
        return behaviorAnnotations != null && !behaviorAnnotations.isEmpty();
      case RoomPackage.ACTOR_CLASS__STRUCTORS:
        return structors != null && !structors.isEmpty();
      case RoomPackage.ACTOR_CLASS__OPERATIONS:
        return operations != null && !operations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == IInterfaceItemOwner.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ModelComponent.class)
    {
      switch (derivedFeatureID)
      {
        case RoomPackage.ACTOR_CLASS__ABSTRACT: return FSMPackage.MODEL_COMPONENT__ABSTRACT;
        case RoomPackage.ACTOR_CLASS__COMM_TYPE: return FSMPackage.MODEL_COMPONENT__COMM_TYPE;
        case RoomPackage.ACTOR_CLASS__COMPONENT_NAME: return FSMPackage.MODEL_COMPONENT__COMPONENT_NAME;
        case RoomPackage.ACTOR_CLASS__BASE: return FSMPackage.MODEL_COMPONENT__BASE;
        case RoomPackage.ACTOR_CLASS__STATE_MACHINE: return FSMPackage.MODEL_COMPONENT__STATE_MACHINE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == IInterfaceItemOwner.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ModelComponent.class)
    {
      switch (baseFeatureID)
      {
        case FSMPackage.MODEL_COMPONENT__ABSTRACT: return RoomPackage.ACTOR_CLASS__ABSTRACT;
        case FSMPackage.MODEL_COMPONENT__COMM_TYPE: return RoomPackage.ACTOR_CLASS__COMM_TYPE;
        case FSMPackage.MODEL_COMPONENT__COMPONENT_NAME: return RoomPackage.ACTOR_CLASS__COMPONENT_NAME;
        case FSMPackage.MODEL_COMPONENT__BASE: return RoomPackage.ACTOR_CLASS__BASE;
        case FSMPackage.MODEL_COMPONENT__STATE_MACHINE: return RoomPackage.ACTOR_CLASS__STATE_MACHINE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(", componentName: ");
    result.append(componentName);
    result.append(')');
    return result.toString();
  }

} //ActorClassImpl
