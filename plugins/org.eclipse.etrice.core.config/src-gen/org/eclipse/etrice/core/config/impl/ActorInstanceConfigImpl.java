/**
 */
package org.eclipse.etrice.core.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.RefPath;

import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Instance Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl#getSubSystem <em>Sub System</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorInstanceConfigImpl extends ConfigElementImpl implements ActorInstanceConfig
{
  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected LogicalSystem root;

  /**
   * The cached value of the '{@link #getSubSystem() <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubSystem()
   * @generated
   * @ordered
   */
  protected SubSystemRef subSystem;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected RefPath path;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<AttrInstanceConfig> attributes;

  /**
   * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPorts()
   * @generated
   * @ordered
   */
  protected EList<PortInstanceConfig> ports;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorInstanceConfigImpl()
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
    return ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalSystem getRoot()
  {
    if (root != null && root.eIsProxy())
    {
      InternalEObject oldRoot = (InternalEObject)root;
      root = (LogicalSystem)eResolveProxy(oldRoot);
      if (root != oldRoot)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT, oldRoot, root));
      }
    }
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalSystem basicGetRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(LogicalSystem newRoot)
  {
    LogicalSystem oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT, oldRoot, root));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemRef getSubSystem()
  {
    if (subSystem != null && subSystem.eIsProxy())
    {
      InternalEObject oldSubSystem = (InternalEObject)subSystem;
      subSystem = (SubSystemRef)eResolveProxy(oldSubSystem);
      if (subSystem != oldSubSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM, oldSubSystem, subSystem));
      }
    }
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemRef basicGetSubSystem()
  {
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubSystem(SubSystemRef newSubSystem)
  {
    SubSystemRef oldSubSystem = subSystem;
    subSystem = newSubSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM, oldSubSystem, subSystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefPath getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(RefPath newPath, NotificationChain msgs)
  {
    RefPath oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(RefPath newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AttrInstanceConfig> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<AttrInstanceConfig>(AttrInstanceConfig.class, this, ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PortInstanceConfig> getPorts()
  {
    if (ports == null)
    {
      ports = new EObjectContainmentEList<PortInstanceConfig>(PortInstanceConfig.class, this, ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS);
    }
    return ports;
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
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH:
        return basicSetPath(null, msgs);
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS:
        return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
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
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT:
        if (resolve) return getRoot();
        return basicGetRoot();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM:
        if (resolve) return getSubSystem();
        return basicGetSubSystem();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH:
        return getPath();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES:
        return getAttributes();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS:
        return getPorts();
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
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT:
        setRoot((LogicalSystem)newValue);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM:
        setSubSystem((SubSystemRef)newValue);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH:
        setPath((RefPath)newValue);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends AttrInstanceConfig>)newValue);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS:
        getPorts().clear();
        getPorts().addAll((Collection<? extends PortInstanceConfig>)newValue);
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
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT:
        setRoot((LogicalSystem)null);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM:
        setSubSystem((SubSystemRef)null);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH:
        setPath((RefPath)null);
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES:
        getAttributes().clear();
        return;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS:
        getPorts().clear();
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
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ROOT:
        return root != null;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__SUB_SYSTEM:
        return subSystem != null;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PATH:
        return path != null;
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG__PORTS:
        return ports != null && !ports.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ActorInstanceConfigImpl
