/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.common.base.Annotation;

import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.StructureClassImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.StructureClassImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.StructureClassImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructureClassImpl extends RoomClassImpl implements StructureClass
{
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
   * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnections()
   * @generated
   * @ordered
   */
  protected EList<LayerConnection> connections;

  /**
   * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBindings()
   * @generated
   * @ordered
   */
  protected EList<Binding> bindings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructureClassImpl()
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
    return RoomPackage.Literals.STRUCTURE_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, RoomPackage.STRUCTURE_CLASS__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LayerConnection> getConnections()
  {
    if (connections == null)
    {
      connections = new EObjectContainmentEList<LayerConnection>(LayerConnection.class, this, RoomPackage.STRUCTURE_CLASS__CONNECTIONS);
    }
    return connections;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Binding> getBindings()
  {
    if (bindings == null)
    {
      bindings = new EObjectContainmentEList<Binding>(Binding.class, this, RoomPackage.STRUCTURE_CLASS__BINDINGS);
    }
    return bindings;
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
      case RoomPackage.STRUCTURE_CLASS__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case RoomPackage.STRUCTURE_CLASS__CONNECTIONS:
        return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
      case RoomPackage.STRUCTURE_CLASS__BINDINGS:
        return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.STRUCTURE_CLASS__ANNOTATIONS:
        return getAnnotations();
      case RoomPackage.STRUCTURE_CLASS__CONNECTIONS:
        return getConnections();
      case RoomPackage.STRUCTURE_CLASS__BINDINGS:
        return getBindings();
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
      case RoomPackage.STRUCTURE_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case RoomPackage.STRUCTURE_CLASS__CONNECTIONS:
        getConnections().clear();
        getConnections().addAll((Collection<? extends LayerConnection>)newValue);
        return;
      case RoomPackage.STRUCTURE_CLASS__BINDINGS:
        getBindings().clear();
        getBindings().addAll((Collection<? extends Binding>)newValue);
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
      case RoomPackage.STRUCTURE_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case RoomPackage.STRUCTURE_CLASS__CONNECTIONS:
        getConnections().clear();
        return;
      case RoomPackage.STRUCTURE_CLASS__BINDINGS:
        getBindings().clear();
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
      case RoomPackage.STRUCTURE_CLASS__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case RoomPackage.STRUCTURE_CLASS__CONNECTIONS:
        return connections != null && !connections.isEmpty();
      case RoomPackage.STRUCTURE_CLASS__BINDINGS:
        return bindings != null && !bindings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StructureClassImpl
