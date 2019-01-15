/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.Import;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getEnumerationTypes <em>Enumeration Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getExternalTypes <em>External Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getDataClasses <em>Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getProtocolClasses <em>Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getActorClasses <em>Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getSubSystemClasses <em>Sub System Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getSystems <em>Systems</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RoomModelImpl#getAnnotationTypes <em>Annotation Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoomModelImpl extends MinimalEObjectImpl.Container implements RoomModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDocu() <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocu()
   * @generated
   * @ordered
   */
  protected Documentation docu;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getPrimitiveTypes() <em>Primitive Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimitiveTypes()
   * @generated
   * @ordered
   */
  protected EList<PrimitiveType> primitiveTypes;

  /**
   * The cached value of the '{@link #getEnumerationTypes() <em>Enumeration Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerationTypes()
   * @generated
   * @ordered
   */
  protected EList<EnumerationType> enumerationTypes;

  /**
   * The cached value of the '{@link #getExternalTypes() <em>External Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalTypes()
   * @generated
   * @ordered
   */
  protected EList<ExternalType> externalTypes;

  /**
   * The cached value of the '{@link #getDataClasses() <em>Data Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataClasses()
   * @generated
   * @ordered
   */
  protected EList<DataClass> dataClasses;

  /**
   * The cached value of the '{@link #getProtocolClasses() <em>Protocol Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProtocolClasses()
   * @generated
   * @ordered
   */
  protected EList<GeneralProtocolClass> protocolClasses;

  /**
   * The cached value of the '{@link #getActorClasses() <em>Actor Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorClasses()
   * @generated
   * @ordered
   */
  protected EList<ActorClass> actorClasses;

  /**
   * The cached value of the '{@link #getSubSystemClasses() <em>Sub System Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubSystemClasses()
   * @generated
   * @ordered
   */
  protected EList<SubSystemClass> subSystemClasses;

  /**
   * The cached value of the '{@link #getSystems() <em>Systems</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystems()
   * @generated
   * @ordered
   */
  protected EList<LogicalSystem> systems;

  /**
   * The cached value of the '{@link #getAnnotationTypes() <em>Annotation Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationTypes()
   * @generated
   * @ordered
   */
  protected EList<AnnotationType> annotationTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoomModelImpl()
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
    return RoomPackage.Literals.ROOM_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ROOM_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Documentation getDocu()
  {
    return docu;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDocu(Documentation newDocu, NotificationChain msgs)
  {
    Documentation oldDocu = docu;
    docu = newDocu;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ROOM_MODEL__DOCU, oldDocu, newDocu);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDocu(Documentation newDocu)
  {
    if (newDocu != docu)
    {
      NotificationChain msgs = null;
      if (docu != null)
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ROOM_MODEL__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ROOM_MODEL__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ROOM_MODEL__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, RoomPackage.ROOM_MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PrimitiveType> getPrimitiveTypes()
  {
    if (primitiveTypes == null)
    {
      primitiveTypes = new EObjectContainmentEList<PrimitiveType>(PrimitiveType.class, this, RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES);
    }
    return primitiveTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EnumerationType> getEnumerationTypes()
  {
    if (enumerationTypes == null)
    {
      enumerationTypes = new EObjectContainmentEList<EnumerationType>(EnumerationType.class, this, RoomPackage.ROOM_MODEL__ENUMERATION_TYPES);
    }
    return enumerationTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ExternalType> getExternalTypes()
  {
    if (externalTypes == null)
    {
      externalTypes = new EObjectContainmentEList<ExternalType>(ExternalType.class, this, RoomPackage.ROOM_MODEL__EXTERNAL_TYPES);
    }
    return externalTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DataClass> getDataClasses()
  {
    if (dataClasses == null)
    {
      dataClasses = new EObjectContainmentEList<DataClass>(DataClass.class, this, RoomPackage.ROOM_MODEL__DATA_CLASSES);
    }
    return dataClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<GeneralProtocolClass> getProtocolClasses()
  {
    if (protocolClasses == null)
    {
      protocolClasses = new EObjectContainmentEList<GeneralProtocolClass>(GeneralProtocolClass.class, this, RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES);
    }
    return protocolClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ActorClass> getActorClasses()
  {
    if (actorClasses == null)
    {
      actorClasses = new EObjectContainmentEList<ActorClass>(ActorClass.class, this, RoomPackage.ROOM_MODEL__ACTOR_CLASSES);
    }
    return actorClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SubSystemClass> getSubSystemClasses()
  {
    if (subSystemClasses == null)
    {
      subSystemClasses = new EObjectContainmentEList<SubSystemClass>(SubSystemClass.class, this, RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES);
    }
    return subSystemClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LogicalSystem> getSystems()
  {
    if (systems == null)
    {
      systems = new EObjectContainmentEList<LogicalSystem>(LogicalSystem.class, this, RoomPackage.ROOM_MODEL__SYSTEMS);
    }
    return systems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AnnotationType> getAnnotationTypes()
  {
    if (annotationTypes == null)
    {
      annotationTypes = new EObjectContainmentEList<AnnotationType>(AnnotationType.class, this, RoomPackage.ROOM_MODEL__ANNOTATION_TYPES);
    }
    return annotationTypes;
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
      case RoomPackage.ROOM_MODEL__DOCU:
        return basicSetDocu(null, msgs);
      case RoomPackage.ROOM_MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES:
        return ((InternalEList<?>)getPrimitiveTypes()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__ENUMERATION_TYPES:
        return ((InternalEList<?>)getEnumerationTypes()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__EXTERNAL_TYPES:
        return ((InternalEList<?>)getExternalTypes()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__DATA_CLASSES:
        return ((InternalEList<?>)getDataClasses()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES:
        return ((InternalEList<?>)getProtocolClasses()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__ACTOR_CLASSES:
        return ((InternalEList<?>)getActorClasses()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES:
        return ((InternalEList<?>)getSubSystemClasses()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__SYSTEMS:
        return ((InternalEList<?>)getSystems()).basicRemove(otherEnd, msgs);
      case RoomPackage.ROOM_MODEL__ANNOTATION_TYPES:
        return ((InternalEList<?>)getAnnotationTypes()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.ROOM_MODEL__NAME:
        return getName();
      case RoomPackage.ROOM_MODEL__DOCU:
        return getDocu();
      case RoomPackage.ROOM_MODEL__IMPORTS:
        return getImports();
      case RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES:
        return getPrimitiveTypes();
      case RoomPackage.ROOM_MODEL__ENUMERATION_TYPES:
        return getEnumerationTypes();
      case RoomPackage.ROOM_MODEL__EXTERNAL_TYPES:
        return getExternalTypes();
      case RoomPackage.ROOM_MODEL__DATA_CLASSES:
        return getDataClasses();
      case RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES:
        return getProtocolClasses();
      case RoomPackage.ROOM_MODEL__ACTOR_CLASSES:
        return getActorClasses();
      case RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES:
        return getSubSystemClasses();
      case RoomPackage.ROOM_MODEL__SYSTEMS:
        return getSystems();
      case RoomPackage.ROOM_MODEL__ANNOTATION_TYPES:
        return getAnnotationTypes();
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
      case RoomPackage.ROOM_MODEL__NAME:
        setName((String)newValue);
        return;
      case RoomPackage.ROOM_MODEL__DOCU:
        setDocu((Documentation)newValue);
        return;
      case RoomPackage.ROOM_MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
        getPrimitiveTypes().addAll((Collection<? extends PrimitiveType>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__ENUMERATION_TYPES:
        getEnumerationTypes().clear();
        getEnumerationTypes().addAll((Collection<? extends EnumerationType>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__EXTERNAL_TYPES:
        getExternalTypes().clear();
        getExternalTypes().addAll((Collection<? extends ExternalType>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__DATA_CLASSES:
        getDataClasses().clear();
        getDataClasses().addAll((Collection<? extends DataClass>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES:
        getProtocolClasses().clear();
        getProtocolClasses().addAll((Collection<? extends GeneralProtocolClass>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__ACTOR_CLASSES:
        getActorClasses().clear();
        getActorClasses().addAll((Collection<? extends ActorClass>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES:
        getSubSystemClasses().clear();
        getSubSystemClasses().addAll((Collection<? extends SubSystemClass>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__SYSTEMS:
        getSystems().clear();
        getSystems().addAll((Collection<? extends LogicalSystem>)newValue);
        return;
      case RoomPackage.ROOM_MODEL__ANNOTATION_TYPES:
        getAnnotationTypes().clear();
        getAnnotationTypes().addAll((Collection<? extends AnnotationType>)newValue);
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
      case RoomPackage.ROOM_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RoomPackage.ROOM_MODEL__DOCU:
        setDocu((Documentation)null);
        return;
      case RoomPackage.ROOM_MODEL__IMPORTS:
        getImports().clear();
        return;
      case RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
        return;
      case RoomPackage.ROOM_MODEL__ENUMERATION_TYPES:
        getEnumerationTypes().clear();
        return;
      case RoomPackage.ROOM_MODEL__EXTERNAL_TYPES:
        getExternalTypes().clear();
        return;
      case RoomPackage.ROOM_MODEL__DATA_CLASSES:
        getDataClasses().clear();
        return;
      case RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES:
        getProtocolClasses().clear();
        return;
      case RoomPackage.ROOM_MODEL__ACTOR_CLASSES:
        getActorClasses().clear();
        return;
      case RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES:
        getSubSystemClasses().clear();
        return;
      case RoomPackage.ROOM_MODEL__SYSTEMS:
        getSystems().clear();
        return;
      case RoomPackage.ROOM_MODEL__ANNOTATION_TYPES:
        getAnnotationTypes().clear();
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
      case RoomPackage.ROOM_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RoomPackage.ROOM_MODEL__DOCU:
        return docu != null;
      case RoomPackage.ROOM_MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case RoomPackage.ROOM_MODEL__PRIMITIVE_TYPES:
        return primitiveTypes != null && !primitiveTypes.isEmpty();
      case RoomPackage.ROOM_MODEL__ENUMERATION_TYPES:
        return enumerationTypes != null && !enumerationTypes.isEmpty();
      case RoomPackage.ROOM_MODEL__EXTERNAL_TYPES:
        return externalTypes != null && !externalTypes.isEmpty();
      case RoomPackage.ROOM_MODEL__DATA_CLASSES:
        return dataClasses != null && !dataClasses.isEmpty();
      case RoomPackage.ROOM_MODEL__PROTOCOL_CLASSES:
        return protocolClasses != null && !protocolClasses.isEmpty();
      case RoomPackage.ROOM_MODEL__ACTOR_CLASSES:
        return actorClasses != null && !actorClasses.isEmpty();
      case RoomPackage.ROOM_MODEL__SUB_SYSTEM_CLASSES:
        return subSystemClasses != null && !subSystemClasses.isEmpty();
      case RoomPackage.ROOM_MODEL__SYSTEMS:
        return systems != null && !systems.isEmpty();
      case RoomPackage.ROOM_MODEL__ANNOTATION_TYPES:
        return annotationTypes != null && !annotationTypes.isEmpty();
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RoomModelImpl
