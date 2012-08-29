/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

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

import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.InitialDeclaration;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.Testscript;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testscript</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getStateDeclaration <em>State Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getInitialDeclaration <em>Initial Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getLoopsDeclaration <em>Loops Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getSeedDeclaration <em>Seed Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl#getTransitionDeclarations <em>Transition Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestscriptImpl extends MinimalEObjectImpl.Container implements Testscript
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
   * The cached value of the '{@link #getStateDeclaration() <em>State Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateDeclaration()
   * @generated
   * @ordered
   */
  protected StateDeclaration stateDeclaration;

  /**
   * The cached value of the '{@link #getInitialDeclaration() <em>Initial Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialDeclaration()
   * @generated
   * @ordered
   */
  protected InitialDeclaration initialDeclaration;

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
   * The cached value of the '{@link #getTransitionDeclarations() <em>Transition Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionDeclarations()
   * @generated
   * @ordered
   */
  protected EList<TransitionDeclaration> transitionDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestscriptImpl()
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
    return FsmtestPackage.Literals.TESTSCRIPT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateDeclaration getStateDeclaration()
  {
    return stateDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStateDeclaration(StateDeclaration newStateDeclaration, NotificationChain msgs)
  {
    StateDeclaration oldStateDeclaration = stateDeclaration;
    stateDeclaration = newStateDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__STATE_DECLARATION, oldStateDeclaration, newStateDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateDeclaration(StateDeclaration newStateDeclaration)
  {
    if (newStateDeclaration != stateDeclaration)
    {
      NotificationChain msgs = null;
      if (stateDeclaration != null)
        msgs = ((InternalEObject)stateDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__STATE_DECLARATION, null, msgs);
      if (newStateDeclaration != null)
        msgs = ((InternalEObject)newStateDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__STATE_DECLARATION, null, msgs);
      msgs = basicSetStateDeclaration(newStateDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__STATE_DECLARATION, newStateDeclaration, newStateDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitialDeclaration getInitialDeclaration()
  {
    return initialDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialDeclaration(InitialDeclaration newInitialDeclaration, NotificationChain msgs)
  {
    InitialDeclaration oldInitialDeclaration = initialDeclaration;
    initialDeclaration = newInitialDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION, oldInitialDeclaration, newInitialDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialDeclaration(InitialDeclaration newInitialDeclaration)
  {
    if (newInitialDeclaration != initialDeclaration)
    {
      NotificationChain msgs = null;
      if (initialDeclaration != null)
        msgs = ((InternalEObject)initialDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION, null, msgs);
      if (newInitialDeclaration != null)
        msgs = ((InternalEObject)newInitialDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION, null, msgs);
      msgs = basicSetInitialDeclaration(newInitialDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION, newInitialDeclaration, newInitialDeclaration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION, oldLoopsDeclaration, newLoopsDeclaration);
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
        msgs = ((InternalEObject)loopsDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION, null, msgs);
      if (newLoopsDeclaration != null)
        msgs = ((InternalEObject)newLoopsDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION, null, msgs);
      msgs = basicSetLoopsDeclaration(newLoopsDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION, newLoopsDeclaration, newLoopsDeclaration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__SEED_DECLARATION, oldSeedDeclaration, newSeedDeclaration);
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
        msgs = ((InternalEObject)seedDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__SEED_DECLARATION, null, msgs);
      if (newSeedDeclaration != null)
        msgs = ((InternalEObject)newSeedDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TESTSCRIPT__SEED_DECLARATION, null, msgs);
      msgs = basicSetSeedDeclaration(newSeedDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TESTSCRIPT__SEED_DECLARATION, newSeedDeclaration, newSeedDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransitionDeclaration> getTransitionDeclarations()
  {
    if (transitionDeclarations == null)
    {
      transitionDeclarations = new EObjectContainmentEList<TransitionDeclaration>(TransitionDeclaration.class, this, FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS);
    }
    return transitionDeclarations;
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
      case FsmtestPackage.TESTSCRIPT__STATE_DECLARATION:
        return basicSetStateDeclaration(null, msgs);
      case FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION:
        return basicSetInitialDeclaration(null, msgs);
      case FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION:
        return basicSetLoopsDeclaration(null, msgs);
      case FsmtestPackage.TESTSCRIPT__SEED_DECLARATION:
        return basicSetSeedDeclaration(null, msgs);
      case FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS:
        return ((InternalEList<?>)getTransitionDeclarations()).basicRemove(otherEnd, msgs);
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
      case FsmtestPackage.TESTSCRIPT__NAME:
        return getName();
      case FsmtestPackage.TESTSCRIPT__STATE_DECLARATION:
        return getStateDeclaration();
      case FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION:
        return getInitialDeclaration();
      case FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION:
        return getLoopsDeclaration();
      case FsmtestPackage.TESTSCRIPT__SEED_DECLARATION:
        return getSeedDeclaration();
      case FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS:
        return getTransitionDeclarations();
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
      case FsmtestPackage.TESTSCRIPT__NAME:
        setName((String)newValue);
        return;
      case FsmtestPackage.TESTSCRIPT__STATE_DECLARATION:
        setStateDeclaration((StateDeclaration)newValue);
        return;
      case FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION:
        setInitialDeclaration((InitialDeclaration)newValue);
        return;
      case FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION:
        setLoopsDeclaration((LoopsDeclaration)newValue);
        return;
      case FsmtestPackage.TESTSCRIPT__SEED_DECLARATION:
        setSeedDeclaration((SeedDeclaration)newValue);
        return;
      case FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS:
        getTransitionDeclarations().clear();
        getTransitionDeclarations().addAll((Collection<? extends TransitionDeclaration>)newValue);
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
      case FsmtestPackage.TESTSCRIPT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FsmtestPackage.TESTSCRIPT__STATE_DECLARATION:
        setStateDeclaration((StateDeclaration)null);
        return;
      case FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION:
        setInitialDeclaration((InitialDeclaration)null);
        return;
      case FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION:
        setLoopsDeclaration((LoopsDeclaration)null);
        return;
      case FsmtestPackage.TESTSCRIPT__SEED_DECLARATION:
        setSeedDeclaration((SeedDeclaration)null);
        return;
      case FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS:
        getTransitionDeclarations().clear();
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
      case FsmtestPackage.TESTSCRIPT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FsmtestPackage.TESTSCRIPT__STATE_DECLARATION:
        return stateDeclaration != null;
      case FsmtestPackage.TESTSCRIPT__INITIAL_DECLARATION:
        return initialDeclaration != null;
      case FsmtestPackage.TESTSCRIPT__LOOPS_DECLARATION:
        return loopsDeclaration != null;
      case FsmtestPackage.TESTSCRIPT__SEED_DECLARATION:
        return seedDeclaration != null;
      case FsmtestPackage.TESTSCRIPT__TRANSITION_DECLARATIONS:
        return transitionDeclarations != null && !transitionDeclarations.isEmpty();
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

} //TestscriptImpl
