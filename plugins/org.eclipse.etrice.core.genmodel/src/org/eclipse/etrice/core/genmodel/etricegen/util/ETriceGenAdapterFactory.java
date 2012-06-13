/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.*;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.ITransitionChainVisitor;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage
 * @generated
 */
public class ETriceGenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ETriceGenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETriceGenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ETriceGenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETriceGenSwitch<Adapter> modelSwitch =
		new ETriceGenSwitch<Adapter>() {
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter caseInstanceBase(InstanceBase object) {
				return createInstanceBaseAdapter();
			}
			@Override
			public Adapter caseStructureInstance(StructureInstance object) {
				return createStructureInstanceAdapter();
			}
			@Override
			public Adapter caseSubSystemInstance(SubSystemInstance object) {
				return createSubSystemInstanceAdapter();
			}
			@Override
			public Adapter caseActorInstance(ActorInstance object) {
				return createActorInstanceAdapter();
			}
			@Override
			public Adapter caseInterfaceItemInstance(InterfaceItemInstance object) {
				return createInterfaceItemInstanceAdapter();
			}
			@Override
			public Adapter casePortInstance(PortInstance object) {
				return createPortInstanceAdapter();
			}
			@Override
			public Adapter caseBindingInstance(BindingInstance object) {
				return createBindingInstanceAdapter();
			}
			@Override
			public Adapter caseSAPInstance(SAPInstance object) {
				return createSAPInstanceAdapter();
			}
			@Override
			public Adapter caseSPPInstance(SPPInstance object) {
				return createSPPInstanceAdapter();
			}
			@Override
			public Adapter caseServiceImplInstance(ServiceImplInstance object) {
				return createServiceImplInstanceAdapter();
			}
			@Override
			public Adapter caseConnectionInstance(ConnectionInstance object) {
				return createConnectionInstanceAdapter();
			}
			@Override
			public Adapter caseActiveTrigger(ActiveTrigger object) {
				return createActiveTriggerAdapter();
			}
			@Override
			public Adapter caseTransitionChain(TransitionChain object) {
				return createTransitionChainAdapter();
			}
			@Override
			public Adapter caseITransitionChainVisitor(ITransitionChainVisitor object) {
				return createITransitionChainVisitorAdapter();
			}
			@Override
			public Adapter caseIDiagnostician(IDiagnostician object) {
				return createIDiagnosticianAdapter();
			}
			@Override
			public Adapter caseExpandedActorClass(ExpandedActorClass object) {
				return createExpandedActorClassAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase <em>Instance Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
	 * @generated
	 */
	public Adapter createInstanceBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance <em>Structure Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
	 * @generated
	 */
	public Adapter createStructureInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance <em>Sub System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
	 * @generated
	 */
	public Adapter createSubSystemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance <em>Actor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
	 * @generated
	 */
	public Adapter createActorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance <em>Interface Item Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
	 * @generated
	 */
	public Adapter createInterfaceItemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance <em>Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance
	 * @generated
	 */
	public Adapter createPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance <em>Binding Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance
	 * @generated
	 */
	public Adapter createBindingInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance <em>SAP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SAPInstance
	 * @generated
	 */
	public Adapter createSAPInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance <em>SPP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance
	 * @generated
	 */
	public Adapter createSPPInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance <em>Service Impl Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance
	 * @generated
	 */
	public Adapter createServiceImplInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance
	 * @generated
	 */
	public Adapter createConnectionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger <em>Active Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger
	 * @generated
	 */
	public Adapter createActiveTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain <em>Transition Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.TransitionChain
	 * @generated
	 */
	public Adapter createTransitionChainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ITransitionChainVisitor <em>ITransition Chain Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ITransitionChainVisitor
	 * @generated
	 */
	public Adapter createITransitionChainVisitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link IDiagnostician <em>IDiagnostician</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see IDiagnostician
	 * @generated
	 */
	public Adapter createIDiagnosticianAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass <em>Expanded Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
	 * @generated
	 */
	public Adapter createExpandedActorClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ETriceGenAdapterFactory
