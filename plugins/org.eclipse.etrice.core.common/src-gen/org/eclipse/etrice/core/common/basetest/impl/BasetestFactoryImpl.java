/**
 */
package org.eclipse.etrice.core.common.basetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.common.basetest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasetestFactoryImpl extends EFactoryImpl implements BasetestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BasetestFactory init()
  {
    try
    {
      BasetestFactory theBasetestFactory = (BasetestFactory)EPackage.Registry.INSTANCE.getEFactory(BasetestPackage.eNS_URI);
      if (theBasetestFactory != null)
      {
        return theBasetestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BasetestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasetestFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case BasetestPackage.BASE_MODEL: return createBaseModel();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseModel createBaseModel()
  {
    BaseModelImpl baseModel = new BaseModelImpl();
    return baseModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasetestPackage getBasetestPackage()
  {
    return (BasetestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BasetestPackage getPackage()
  {
    return BasetestPackage.eINSTANCE;
  }

} //BasetestFactoryImpl
