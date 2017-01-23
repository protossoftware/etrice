/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;

import org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl;

import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;

import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Item</b></em>'.
 * <!-- end-user-doc -->
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolSemantics getSemantics()
  {
    if (getGeneralProtocol() instanceof ProtocolClass)
      return ((ProtocolClass)getGeneralProtocol()).getSemantics();
    else
      return null;
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getAllIncomingAbstractMessages()
  {
    return new BasicEList<EObject>(new RoomHelpers().getMessageListDeep(this, false));
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getAllOutgoingAbstractMessages()
  {
    return new BasicEList<EObject>(new RoomHelpers().getMessageListDeep(this, true));
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isEventDriven()
  {
    if (getGeneralProtocol() instanceof ProtocolClass)
        return ((ProtocolClass) getGeneralProtocol()).getCommType() == CommunicationType.EVENT_DRIVEN;
    else
        return false;
    
  }

} //InterfaceItemImpl
