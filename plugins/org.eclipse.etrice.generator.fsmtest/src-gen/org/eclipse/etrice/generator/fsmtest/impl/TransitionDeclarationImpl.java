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

import org.eclipse.etrice.generator.fsmtest.DestinationDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.SourceDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getOut <em>Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionDeclarationImpl extends MinimalEObjectImpl.Container implements TransitionDeclaration
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected SourceDeclaration source;

  /**
   * The cached value of the '{@link #getIn() <em>In</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIn()
   * @generated
   * @ordered
   */
  protected EList<SignalDeclaration> in;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected EList<SignalDeclaration> out;

  /**
   * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected DestinationDeclaration destination;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionDeclarationImpl()
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
    return FsmtestPackage.Literals.TRANSITION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SourceDeclaration getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(SourceDeclaration newSource, NotificationChain msgs)
  {
    SourceDeclaration oldSource = source;
    source = newSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(SourceDeclaration newSource)
  {
    if (newSource != source)
    {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SignalDeclaration> getIn()
  {
    if (in == null)
    {
      in = new EObjectContainmentEList<SignalDeclaration>(SignalDeclaration.class, this, FsmtestPackage.TRANSITION_DECLARATION__IN);
    }
    return in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SignalDeclaration> getOut()
  {
    if (out == null)
    {
      out = new EObjectContainmentEList<SignalDeclaration>(SignalDeclaration.class, this, FsmtestPackage.TRANSITION_DECLARATION__OUT);
    }
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DestinationDeclaration getDestination()
  {
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDestination(DestinationDeclaration newDestination, NotificationChain msgs)
  {
    DestinationDeclaration oldDestination = destination;
    destination = newDestination;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, oldDestination, newDestination);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDestination(DestinationDeclaration newDestination)
  {
    if (newDestination != destination)
    {
      NotificationChain msgs = null;
      if (destination != null)
        msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, null, msgs);
      if (newDestination != null)
        msgs = ((InternalEObject)newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, null, msgs);
      msgs = basicSetDestination(newDestination, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, newDestination, newDestination));
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
      case FsmtestPackage.TRANSITION_DECLARATION__SOURCE:
        return basicSetSource(null, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__IN:
        return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__OUT:
        return ((InternalEList<?>)getOut()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        return basicSetDestination(null, msgs);
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
      case FsmtestPackage.TRANSITION_DECLARATION__SOURCE:
        return getSource();
      case FsmtestPackage.TRANSITION_DECLARATION__IN:
        return getIn();
      case FsmtestPackage.TRANSITION_DECLARATION__OUT:
        return getOut();
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        return getDestination();
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
      case FsmtestPackage.TRANSITION_DECLARATION__SOURCE:
        setSource((SourceDeclaration)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__IN:
        getIn().clear();
        getIn().addAll((Collection<? extends SignalDeclaration>)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__OUT:
        getOut().clear();
        getOut().addAll((Collection<? extends SignalDeclaration>)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        setDestination((DestinationDeclaration)newValue);
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
      case FsmtestPackage.TRANSITION_DECLARATION__SOURCE:
        setSource((SourceDeclaration)null);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__IN:
        getIn().clear();
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__OUT:
        getOut().clear();
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        setDestination((DestinationDeclaration)null);
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
      case FsmtestPackage.TRANSITION_DECLARATION__SOURCE:
        return source != null;
      case FsmtestPackage.TRANSITION_DECLARATION__IN:
        return in != null && !in.isEmpty();
      case FsmtestPackage.TRANSITION_DECLARATION__OUT:
        return out != null && !out.isEmpty();
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        return destination != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionDeclarationImpl
