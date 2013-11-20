/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;

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
    if (this instanceof State) 
      return ((State)this).getName();
    else if (this instanceof TrPoint)
      return ((TrPoint)this).getName();
    else if (this instanceof ChoicePoint)
      return ((ChoicePoint)this).getName();
    else if (this instanceof Transition)
      return ((Transition)this).getName();
    return "";
    
  }

} //StateGraphItemImpl
