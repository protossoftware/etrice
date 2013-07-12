/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StateGraphItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Graph Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StateGraphItemImpl extends MinimalEObjectImpl.Container implements StateGraphItem
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateGraphItemImpl()
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
    return RoomPackage.Literals.STATE_GRAPH_ITEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    if (this instanceof org.eclipse.etrice.core.room.State) 
      return ((org.eclipse.etrice.core.room.State)this).getName();
    else if (this instanceof org.eclipse.etrice.core.room.TrPoint)
      return ((org.eclipse.etrice.core.room.TrPoint)this).getName();
    else if (this instanceof org.eclipse.etrice.core.room.ChoicePoint)
      return ((org.eclipse.etrice.core.room.ChoicePoint)this).getName();
    else if (this instanceof org.eclipse.etrice.core.room.Transition)
      return ((org.eclipse.etrice.core.room.Transition)this).getName();
    return "";
    
  }

} //StateGraphItemImpl
