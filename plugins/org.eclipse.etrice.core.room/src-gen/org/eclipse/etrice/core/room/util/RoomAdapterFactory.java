/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.room.RoomPackage
 * @generated
 */
public class RoomAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RoomPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RoomPackage.eINSTANCE;
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
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
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
  protected RoomSwitch<Adapter> modelSwitch =
    new RoomSwitch<Adapter>()
    {
      @Override
      public Adapter caseRoomModel(RoomModel object)
      {
        return createRoomModelAdapter();
      }
      @Override
      public Adapter caseRoomClass(RoomClass object)
      {
        return createRoomClassAdapter();
      }
      @Override
      public Adapter caseStructureClass(StructureClass object)
      {
        return createStructureClassAdapter();
      }
      @Override
      public Adapter caseActorContainerClass(ActorContainerClass object)
      {
        return createActorContainerClassAdapter();
      }
      @Override
      public Adapter caseVarDecl(VarDecl object)
      {
        return createVarDeclAdapter();
      }
      @Override
      public Adapter caseRefableType(RefableType object)
      {
        return createRefableTypeAdapter();
      }
      @Override
      public Adapter caseDataType(DataType object)
      {
        return createDataTypeAdapter();
      }
      @Override
      public Adapter caseComplexType(ComplexType object)
      {
        return createComplexTypeAdapter();
      }
      @Override
      public Adapter casePrimitiveType(PrimitiveType object)
      {
        return createPrimitiveTypeAdapter();
      }
      @Override
      public Adapter caseExternalType(ExternalType object)
      {
        return createExternalTypeAdapter();
      }
      @Override
      public Adapter caseDataClass(DataClass object)
      {
        return createDataClassAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseStandardOperation(StandardOperation object)
      {
        return createStandardOperationAdapter();
      }
      @Override
      public Adapter casePortOperation(PortOperation object)
      {
        return createPortOperationAdapter();
      }
      @Override
      public Adapter caseProtocolClass(ProtocolClass object)
      {
        return createProtocolClassAdapter();
      }
      @Override
      public Adapter caseMessage(Message object)
      {
        return createMessageAdapter();
      }
      @Override
      public Adapter casePortClass(PortClass object)
      {
        return createPortClassAdapter();
      }
      @Override
      public Adapter caseMessageHandler(MessageHandler object)
      {
        return createMessageHandlerAdapter();
      }
      @Override
      public Adapter caseInMessageHandler(InMessageHandler object)
      {
        return createInMessageHandlerAdapter();
      }
      @Override
      public Adapter caseOutMessageHandler(OutMessageHandler object)
      {
        return createOutMessageHandlerAdapter();
      }
      @Override
      public Adapter caseProtocolSemantics(ProtocolSemantics object)
      {
        return createProtocolSemanticsAdapter();
      }
      @Override
      public Adapter caseSemanticsRule(SemanticsRule object)
      {
        return createSemanticsRuleAdapter();
      }
      @Override
      public Adapter caseActorClass(ActorClass object)
      {
        return createActorClassAdapter();
      }
      @Override
      public Adapter caseInterfaceItem(InterfaceItem object)
      {
        return createInterfaceItemAdapter();
      }
      @Override
      public Adapter casePort(Port object)
      {
        return createPortAdapter();
      }
      @Override
      public Adapter caseExternalPort(ExternalPort object)
      {
        return createExternalPortAdapter();
      }
      @Override
      public Adapter caseSAPRef(SAPRef object)
      {
        return createSAPRefAdapter();
      }
      @Override
      public Adapter caseSPPRef(SPPRef object)
      {
        return createSPPRefAdapter();
      }
      @Override
      public Adapter caseServiceImplementation(ServiceImplementation object)
      {
        return createServiceImplementationAdapter();
      }
      @Override
      public Adapter caseLogicalSystem(LogicalSystem object)
      {
        return createLogicalSystemAdapter();
      }
      @Override
      public Adapter caseActorContainerRef(ActorContainerRef object)
      {
        return createActorContainerRefAdapter();
      }
      @Override
      public Adapter caseSubSystemRef(SubSystemRef object)
      {
        return createSubSystemRefAdapter();
      }
      @Override
      public Adapter caseSubSystemClass(SubSystemClass object)
      {
        return createSubSystemClassAdapter();
      }
      @Override
      public Adapter caseLogicalThread(LogicalThread object)
      {
        return createLogicalThreadAdapter();
      }
      @Override
      public Adapter caseActorInstancePath(ActorInstancePath object)
      {
        return createActorInstancePathAdapter();
      }
      @Override
      public Adapter caseBinding(Binding object)
      {
        return createBindingAdapter();
      }
      @Override
      public Adapter caseBindingEndPoint(BindingEndPoint object)
      {
        return createBindingEndPointAdapter();
      }
      @Override
      public Adapter caseLayerConnection(LayerConnection object)
      {
        return createLayerConnectionAdapter();
      }
      @Override
      public Adapter caseSAPoint(SAPoint object)
      {
        return createSAPointAdapter();
      }
      @Override
      public Adapter caseRefSAPoint(RefSAPoint object)
      {
        return createRefSAPointAdapter();
      }
      @Override
      public Adapter caseRelaySAPoint(RelaySAPoint object)
      {
        return createRelaySAPointAdapter();
      }
      @Override
      public Adapter caseSPPoint(SPPoint object)
      {
        return createSPPointAdapter();
      }
      @Override
      public Adapter caseActorRef(ActorRef object)
      {
        return createActorRefAdapter();
      }
      @Override
      public Adapter caseStateGraphNode(StateGraphNode object)
      {
        return createStateGraphNodeAdapter();
      }
      @Override
      public Adapter caseStateGraphItem(StateGraphItem object)
      {
        return createStateGraphItemAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseStateGraph(StateGraph object)
      {
        return createStateGraphAdapter();
      }
      @Override
      public Adapter caseSimpleState(SimpleState object)
      {
        return createSimpleStateAdapter();
      }
      @Override
      public Adapter caseRefinedState(RefinedState object)
      {
        return createRefinedStateAdapter();
      }
      @Override
      public Adapter caseDetailCode(DetailCode object)
      {
        return createDetailCodeAdapter();
      }
      @Override
      public Adapter caseTrPoint(TrPoint object)
      {
        return createTrPointAdapter();
      }
      @Override
      public Adapter caseTransitionPoint(TransitionPoint object)
      {
        return createTransitionPointAdapter();
      }
      @Override
      public Adapter caseEntryPoint(EntryPoint object)
      {
        return createEntryPointAdapter();
      }
      @Override
      public Adapter caseExitPoint(ExitPoint object)
      {
        return createExitPointAdapter();
      }
      @Override
      public Adapter caseChoicePoint(ChoicePoint object)
      {
        return createChoicePointAdapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter caseNonInitialTransition(NonInitialTransition object)
      {
        return createNonInitialTransitionAdapter();
      }
      @Override
      public Adapter caseTransitionChainStartTransition(TransitionChainStartTransition object)
      {
        return createTransitionChainStartTransitionAdapter();
      }
      @Override
      public Adapter caseInitialTransition(InitialTransition object)
      {
        return createInitialTransitionAdapter();
      }
      @Override
      public Adapter caseContinuationTransition(ContinuationTransition object)
      {
        return createContinuationTransitionAdapter();
      }
      @Override
      public Adapter caseTriggeredTransition(TriggeredTransition object)
      {
        return createTriggeredTransitionAdapter();
      }
      @Override
      public Adapter caseGuardedTransition(GuardedTransition object)
      {
        return createGuardedTransitionAdapter();
      }
      @Override
      public Adapter caseCPBranchTransition(CPBranchTransition object)
      {
        return createCPBranchTransitionAdapter();
      }
      @Override
      public Adapter caseTransitionTerminal(TransitionTerminal object)
      {
        return createTransitionTerminalAdapter();
      }
      @Override
      public Adapter caseStateTerminal(StateTerminal object)
      {
        return createStateTerminalAdapter();
      }
      @Override
      public Adapter caseTrPointTerminal(TrPointTerminal object)
      {
        return createTrPointTerminalAdapter();
      }
      @Override
      public Adapter caseSubStateTrPointTerminal(SubStateTrPointTerminal object)
      {
        return createSubStateTrPointTerminalAdapter();
      }
      @Override
      public Adapter caseChoicepointTerminal(ChoicepointTerminal object)
      {
        return createChoicepointTerminalAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseMessageFromIf(MessageFromIf object)
      {
        return createMessageFromIfAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseDocumentation(Documentation object)
      {
        return createDocumentationAdapter();
      }
      @Override
      public Adapter caseAnnotation(Annotation object)
      {
        return createAnnotationAdapter();
      }
      @Override
      public Adapter caseKeyValue(KeyValue object)
      {
        return createKeyValueAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
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
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RoomModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RoomModel
   * @generated
   */
  public Adapter createRoomModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RoomClass <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RoomClass
   * @generated
   */
  public Adapter createRoomClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StructureClass <em>Structure Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StructureClass
   * @generated
   */
  public Adapter createStructureClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ActorContainerClass <em>Actor Container Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ActorContainerClass
   * @generated
   */
  public Adapter createActorContainerClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.VarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.VarDecl
   * @generated
   */
  public Adapter createVarDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RefableType <em>Refable Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RefableType
   * @generated
   */
  public Adapter createRefableTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.DataType
   * @generated
   */
  public Adapter createDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ComplexType <em>Complex Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ComplexType
   * @generated
   */
  public Adapter createComplexTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.PrimitiveType
   * @generated
   */
  public Adapter createPrimitiveTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ExternalType <em>External Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ExternalType
   * @generated
   */
  public Adapter createExternalTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.DataClass <em>Data Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.DataClass
   * @generated
   */
  public Adapter createDataClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StandardOperation <em>Standard Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StandardOperation
   * @generated
   */
  public Adapter createStandardOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.PortOperation <em>Port Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.PortOperation
   * @generated
   */
  public Adapter createPortOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ProtocolClass <em>Protocol Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ProtocolClass
   * @generated
   */
  public Adapter createProtocolClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Message
   * @generated
   */
  public Adapter createMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.PortClass <em>Port Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.PortClass
   * @generated
   */
  public Adapter createPortClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.MessageHandler <em>Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.MessageHandler
   * @generated
   */
  public Adapter createMessageHandlerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.InMessageHandler <em>In Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.InMessageHandler
   * @generated
   */
  public Adapter createInMessageHandlerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.OutMessageHandler <em>Out Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.OutMessageHandler
   * @generated
   */
  public Adapter createOutMessageHandlerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ProtocolSemantics <em>Protocol Semantics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ProtocolSemantics
   * @generated
   */
  public Adapter createProtocolSemanticsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SemanticsRule <em>Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SemanticsRule
   * @generated
   */
  public Adapter createSemanticsRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ActorClass <em>Actor Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ActorClass
   * @generated
   */
  public Adapter createActorClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.InterfaceItem <em>Interface Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.InterfaceItem
   * @generated
   */
  public Adapter createInterfaceItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Port
   * @generated
   */
  public Adapter createPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ExternalPort <em>External Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ExternalPort
   * @generated
   */
  public Adapter createExternalPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SAPRef <em>SAP Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SAPRef
   * @generated
   */
  public Adapter createSAPRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SPPRef <em>SPP Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SPPRef
   * @generated
   */
  public Adapter createSPPRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ServiceImplementation <em>Service Implementation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ServiceImplementation
   * @generated
   */
  public Adapter createServiceImplementationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.LogicalSystem <em>Logical System</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.LogicalSystem
   * @generated
   */
  public Adapter createLogicalSystemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ActorContainerRef <em>Actor Container Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ActorContainerRef
   * @generated
   */
  public Adapter createActorContainerRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SubSystemRef <em>Sub System Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SubSystemRef
   * @generated
   */
  public Adapter createSubSystemRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SubSystemClass <em>Sub System Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SubSystemClass
   * @generated
   */
  public Adapter createSubSystemClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.LogicalThread <em>Logical Thread</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.LogicalThread
   * @generated
   */
  public Adapter createLogicalThreadAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ActorInstancePath <em>Actor Instance Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ActorInstancePath
   * @generated
   */
  public Adapter createActorInstancePathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Binding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Binding
   * @generated
   */
  public Adapter createBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.BindingEndPoint <em>Binding End Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.BindingEndPoint
   * @generated
   */
  public Adapter createBindingEndPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.LayerConnection <em>Layer Connection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.LayerConnection
   * @generated
   */
  public Adapter createLayerConnectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SAPoint <em>SA Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SAPoint
   * @generated
   */
  public Adapter createSAPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RefSAPoint <em>Ref SA Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RefSAPoint
   * @generated
   */
  public Adapter createRefSAPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RelaySAPoint <em>Relay SA Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RelaySAPoint
   * @generated
   */
  public Adapter createRelaySAPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SPPoint <em>SP Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SPPoint
   * @generated
   */
  public Adapter createSPPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ActorRef <em>Actor Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ActorRef
   * @generated
   */
  public Adapter createActorRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StateGraphNode <em>State Graph Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StateGraphNode
   * @generated
   */
  public Adapter createStateGraphNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StateGraphItem <em>State Graph Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StateGraphItem
   * @generated
   */
  public Adapter createStateGraphItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StateGraph <em>State Graph</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StateGraph
   * @generated
   */
  public Adapter createStateGraphAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SimpleState <em>Simple State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SimpleState
   * @generated
   */
  public Adapter createSimpleStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.RefinedState <em>Refined State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.RefinedState
   * @generated
   */
  public Adapter createRefinedStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.DetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.DetailCode
   * @generated
   */
  public Adapter createDetailCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TrPoint
   * @generated
   */
  public Adapter createTrPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TransitionPoint <em>Transition Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TransitionPoint
   * @generated
   */
  public Adapter createTransitionPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.EntryPoint <em>Entry Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.EntryPoint
   * @generated
   */
  public Adapter createEntryPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ExitPoint <em>Exit Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ExitPoint
   * @generated
   */
  public Adapter createExitPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ChoicePoint <em>Choice Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ChoicePoint
   * @generated
   */
  public Adapter createChoicePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.NonInitialTransition <em>Non Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.NonInitialTransition
   * @generated
   */
  public Adapter createNonInitialTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TransitionChainStartTransition <em>Transition Chain Start Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TransitionChainStartTransition
   * @generated
   */
  public Adapter createTransitionChainStartTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.InitialTransition <em>Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.InitialTransition
   * @generated
   */
  public Adapter createInitialTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ContinuationTransition <em>Continuation Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ContinuationTransition
   * @generated
   */
  public Adapter createContinuationTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TriggeredTransition
   * @generated
   */
  public Adapter createTriggeredTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.GuardedTransition <em>Guarded Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.GuardedTransition
   * @generated
   */
  public Adapter createGuardedTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.CPBranchTransition <em>CP Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.CPBranchTransition
   * @generated
   */
  public Adapter createCPBranchTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TransitionTerminal <em>Transition Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TransitionTerminal
   * @generated
   */
  public Adapter createTransitionTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.StateTerminal <em>State Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.StateTerminal
   * @generated
   */
  public Adapter createStateTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.TrPointTerminal <em>Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.TrPointTerminal
   * @generated
   */
  public Adapter createTrPointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal <em>Sub State Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.SubStateTrPointTerminal
   * @generated
   */
  public Adapter createSubStateTrPointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.ChoicepointTerminal <em>Choicepoint Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.ChoicepointTerminal
   * @generated
   */
  public Adapter createChoicepointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.MessageFromIf <em>Message From If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.MessageFromIf
   * @generated
   */
  public Adapter createMessageFromIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Documentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Documentation
   * @generated
   */
  public Adapter createDocumentationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Annotation
   * @generated
   */
  public Adapter createAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.KeyValue <em>Key Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.KeyValue
   * @generated
   */
  public Adapter createKeyValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.room.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.room.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
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
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //RoomAdapterFactory
