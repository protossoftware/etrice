/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.generator.fsmtest.FsmDefinition;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.RandomTest;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl#getFsm <em>Fsm</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl#getLoopsDeclaration <em>Loops Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl#getSeedDeclaration <em>Seed Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomTestImpl extends MinimalEObjectImpl.Container implements RandomTest
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
   * The cached value of the '{@link #getFsm() <em>Fsm</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFsm()
   * @generated
   * @ordered
   */
  protected FsmDefinition fsm;

  /**
   * The cached value of the '{@link #getLoopsDeclaration() <em>Loops Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopsDeclaration()
   * @generated
   * @ordered
   */
  protected LoopsDeclaration loopsDeclaration;

  /**
   * The cached value of the '{@link #getSeedDeclaration() <em>Seed Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeedDeclaration()
   * @generated
   * @ordered
   */
  protected SeedDeclaration seedDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RandomTestImpl()
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
    return FsmtestPackage.Literals.RANDOM_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FsmDefinition getFsm()
  {
    if (fsm != null && fsm.eIsProxy())
    {
      InternalEObject oldFsm = (InternalEObject)fsm;
      fsm = (FsmDefinition)eResolveProxy(oldFsm);
      if (fsm != oldFsm)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmtestPackage.RANDOM_TEST__FSM, oldFsm, fsm));
      }
    }
    return fsm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FsmDefinition basicGetFsm()
  {
    return fsm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFsm(FsmDefinition newFsm)
  {
    FsmDefinition oldFsm = fsm;
    fsm = newFsm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__FSM, oldFsm, fsm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopsDeclaration getLoopsDeclaration()
  {
    return loopsDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLoopsDeclaration(LoopsDeclaration newLoopsDeclaration, NotificationChain msgs)
  {
    LoopsDeclaration oldLoopsDeclaration = loopsDeclaration;
    loopsDeclaration = newLoopsDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION, oldLoopsDeclaration, newLoopsDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopsDeclaration(LoopsDeclaration newLoopsDeclaration)
  {
    if (newLoopsDeclaration != loopsDeclaration)
    {
      NotificationChain msgs = null;
      if (loopsDeclaration != null)
        msgs = ((InternalEObject)loopsDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION, null, msgs);
      if (newLoopsDeclaration != null)
        msgs = ((InternalEObject)newLoopsDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION, null, msgs);
      msgs = basicSetLoopsDeclaration(newLoopsDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION, newLoopsDeclaration, newLoopsDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SeedDeclaration getSeedDeclaration()
  {
    return seedDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSeedDeclaration(SeedDeclaration newSeedDeclaration, NotificationChain msgs)
  {
    SeedDeclaration oldSeedDeclaration = seedDeclaration;
    seedDeclaration = newSeedDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__SEED_DECLARATION, oldSeedDeclaration, newSeedDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSeedDeclaration(SeedDeclaration newSeedDeclaration)
  {
    if (newSeedDeclaration != seedDeclaration)
    {
      NotificationChain msgs = null;
      if (seedDeclaration != null)
        msgs = ((InternalEObject)seedDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.RANDOM_TEST__SEED_DECLARATION, null, msgs);
      if (newSeedDeclaration != null)
        msgs = ((InternalEObject)newSeedDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.RANDOM_TEST__SEED_DECLARATION, null, msgs);
      msgs = basicSetSeedDeclaration(newSeedDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.RANDOM_TEST__SEED_DECLARATION, newSeedDeclaration, newSeedDeclaration));
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
      case FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION:
        return basicSetLoopsDeclaration(null, msgs);
      case FsmtestPackage.RANDOM_TEST__SEED_DECLARATION:
        return basicSetSeedDeclaration(null, msgs);
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
      case FsmtestPackage.RANDOM_TEST__NAME:
        return getName();
      case FsmtestPackage.RANDOM_TEST__FSM:
        if (resolve) return getFsm();
        return basicGetFsm();
      case FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION:
        return getLoopsDeclaration();
      case FsmtestPackage.RANDOM_TEST__SEED_DECLARATION:
        return getSeedDeclaration();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FsmtestPackage.RANDOM_TEST__NAME:
        setName((String)newValue);
        return;
      case FsmtestPackage.RANDOM_TEST__FSM:
        setFsm((FsmDefinition)newValue);
        return;
      case FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION:
        setLoopsDeclaration((LoopsDeclaration)newValue);
        return;
      case FsmtestPackage.RANDOM_TEST__SEED_DECLARATION:
        setSeedDeclaration((SeedDeclaration)newValue);
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
      case FsmtestPackage.RANDOM_TEST__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FsmtestPackage.RANDOM_TEST__FSM:
        setFsm((FsmDefinition)null);
        return;
      case FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION:
        setLoopsDeclaration((LoopsDeclaration)null);
        return;
      case FsmtestPackage.RANDOM_TEST__SEED_DECLARATION:
        setSeedDeclaration((SeedDeclaration)null);
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
      case FsmtestPackage.RANDOM_TEST__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FsmtestPackage.RANDOM_TEST__FSM:
        return fsm != null;
      case FsmtestPackage.RANDOM_TEST__LOOPS_DECLARATION:
        return loopsDeclaration != null;
      case FsmtestPackage.RANDOM_TEST__SEED_DECLARATION:
        return seedDeclaration != null;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RandomTestImpl
