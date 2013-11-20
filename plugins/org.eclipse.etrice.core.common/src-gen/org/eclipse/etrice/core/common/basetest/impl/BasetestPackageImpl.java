/**
 */
package org.eclipse.etrice.core.common.basetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.core.common.basetest.BaseModel;
import org.eclipse.etrice.core.common.basetest.BasetestFactory;
import org.eclipse.etrice.core.common.basetest.BasetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasetestPackageImpl extends EPackageImpl implements BasetestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseModelEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.etrice.core.common.basetest.BasetestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BasetestPackageImpl()
  {
    super(eNS_URI, BasetestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link BasetestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BasetestPackage init()
  {
    if (isInited) return (BasetestPackage)EPackage.Registry.INSTANCE.getEPackage(BasetestPackage.eNS_URI);

    // Obtain or create and register package
    BasetestPackageImpl theBasetestPackage = (BasetestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BasetestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BasetestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBasetestPackage.createPackageContents();

    // Initialize created meta-data
    theBasetestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBasetestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BasetestPackage.eNS_URI, theBasetestPackage);
    return theBasetestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBaseModel()
  {
    return baseModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBaseModel_Elements()
  {
    return (EReference)baseModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasetestFactory getBasetestFactory()
  {
    return (BasetestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    baseModelEClass = createEClass(BASE_MODEL);
    createEReference(baseModelEClass, BASE_MODEL__ELEMENTS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(baseModelEClass, BaseModel.class, "BaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBaseModel_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, BaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //BasetestPackageImpl
