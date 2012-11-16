/**
 */
package org.eclipse.etrice.core.etmap.eTMap.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.etmap.eTMap.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ETMapFactoryImpl extends EFactoryImpl implements ETMapFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ETMapFactory init()
  {
    try
    {
      ETMapFactory theETMapFactory = (ETMapFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/etrice/core/etmap/ETMap"); 
      if (theETMapFactory != null)
      {
        return theETMapFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ETMapFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ETMapFactoryImpl()
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
      case ETMapPackage.MAPPING_MODEL: return createMappingModel();
      case ETMapPackage.MAPPING: return createMapping();
      case ETMapPackage.SUB_SYSTEM_MAPPING: return createSubSystemMapping();
      case ETMapPackage.ACTOR_INSTANCE_MAPPING: return createActorInstanceMapping();
      case ETMapPackage.REF_PATH: return createRefPath();
      case ETMapPackage.IMPORT: return createImport();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingModel createMappingModel()
  {
    MappingModelImpl mappingModel = new MappingModelImpl();
    return mappingModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mapping createMapping()
  {
    MappingImpl mapping = new MappingImpl();
    return mapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemMapping createSubSystemMapping()
  {
    SubSystemMappingImpl subSystemMapping = new SubSystemMappingImpl();
    return subSystemMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorInstanceMapping createActorInstanceMapping()
  {
    ActorInstanceMappingImpl actorInstanceMapping = new ActorInstanceMappingImpl();
    return actorInstanceMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefPath createRefPath()
  {
    RefPathImpl refPath = new RefPathImpl();
    return refPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ETMapPackage getETMapPackage()
  {
    return (ETMapPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ETMapPackage getPackage()
  {
    return ETMapPackage.eINSTANCE;
  }

} //ETMapFactoryImpl
