/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl;

import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InterfaceItemImpl extends AbstractInterfaceItemImpl implements InterfaceItem
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InterfaceItemImpl()
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
    return RoomPackage.Literals.INTERFACE_ITEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneralProtocolClass getGeneralProtocol()
  {
    if (this instanceof Port)
      return ((Port) this).getProtocol();
    else if (this instanceof SAP)
      return ((SAP) this).getProtocol();
    else if (this instanceof SPP)
      return ((SPP) this).getProtocol();
    return null;
    
  }

} //InterfaceItemImpl
