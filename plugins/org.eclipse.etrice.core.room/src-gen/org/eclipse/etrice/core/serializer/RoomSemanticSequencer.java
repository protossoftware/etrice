/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.LiteralArray;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMModel;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.serializer.FSMSemanticSequencer;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.InMessageHandler;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageData;
import org.eclipse.etrice.core.room.OutMessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RoomSemanticSequencer extends FSMSemanticSequencer {

	@Inject
	private RoomGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BasePackage.ANNOTATION:
				sequence_Annotation(context, (Annotation) semanticObject); 
				return; 
			case BasePackage.ANNOTATION_TYPE:
				sequence_AnnotationType(context, (AnnotationType) semanticObject); 
				return; 
			case BasePackage.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case BasePackage.DOCUMENTATION:
				sequence_Documentation(context, (Documentation) semanticObject); 
				return; 
			case BasePackage.ENUM_ANNOTATION_ATTRIBUTE:
				sequence_EnumAnnotationAttribute(context, (EnumAnnotationAttribute) semanticObject); 
				return; 
			case BasePackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case BasePackage.INT_LITERAL:
				sequence_IntLiteral(context, (IntLiteral) semanticObject); 
				return; 
			case BasePackage.KEY_VALUE:
				sequence_KeyValue(context, (KeyValue) semanticObject); 
				return; 
			case BasePackage.LITERAL_ARRAY:
				sequence_LiteralArray(context, (LiteralArray) semanticObject); 
				return; 
			case BasePackage.REAL_LITERAL:
				sequence_RealLiteral(context, (RealLiteral) semanticObject); 
				return; 
			case BasePackage.SIMPLE_ANNOTATION_ATTRIBUTE:
				sequence_SimpleAnnotationAttribute(context, (SimpleAnnotationAttribute) semanticObject); 
				return; 
			case BasePackage.STRING_LITERAL:
				sequence_StringLiteral(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == FSMPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FSMPackage.CP_BRANCH_TRANSITION:
				sequence_CPBranchTransition(context, (CPBranchTransition) semanticObject); 
				return; 
			case FSMPackage.CHOICE_POINT:
				sequence_ChoicePoint(context, (ChoicePoint) semanticObject); 
				return; 
			case FSMPackage.CHOICEPOINT_TERMINAL:
				sequence_ChoicepointTerminal(context, (ChoicepointTerminal) semanticObject); 
				return; 
			case FSMPackage.CONTINUATION_TRANSITION:
				sequence_ContinuationTransition(context, (ContinuationTransition) semanticObject); 
				return; 
			case FSMPackage.DETAIL_CODE:
				sequence_DetailCode(context, (DetailCode) semanticObject); 
				return; 
			case FSMPackage.ENTRY_POINT:
				sequence_EntryPoint(context, (EntryPoint) semanticObject); 
				return; 
			case FSMPackage.EXIT_POINT:
				sequence_ExitPoint(context, (ExitPoint) semanticObject); 
				return; 
			case FSMPackage.FSM_MODEL:
				sequence_FSMModel(context, (FSMModel) semanticObject); 
				return; 
			case FSMPackage.GUARD:
				sequence_Guard(context, (Guard) semanticObject); 
				return; 
			case FSMPackage.GUARDED_TRANSITION:
				sequence_GuardedTransition(context, (GuardedTransition) semanticObject); 
				return; 
			case FSMPackage.IN_SEMANTICS_RULE:
				sequence_InSemanticsRule(context, (InSemanticsRule) semanticObject); 
				return; 
			case FSMPackage.INITIAL_TRANSITION:
				sequence_InitialTransition(context, (InitialTransition) semanticObject); 
				return; 
			case FSMPackage.MESSAGE_FROM_IF:
				sequence_MessageFromIf(context, (MessageFromIf) semanticObject); 
				return; 
			case FSMPackage.OUT_SEMANTICS_RULE:
				sequence_OutSemanticsRule(context, (OutSemanticsRule) semanticObject); 
				return; 
			case FSMPackage.PROTOCOL_SEMANTICS:
				sequence_ProtocolSemantics(context, (ProtocolSemantics) semanticObject); 
				return; 
			case FSMPackage.REFINED_STATE:
				sequence_RefinedState(context, (RefinedState) semanticObject); 
				return; 
			case FSMPackage.REFINED_TRANSITION:
				sequence_RefinedTransition(context, (RefinedTransition) semanticObject); 
				return; 
			case FSMPackage.SIMPLE_STATE:
				sequence_SimpleState(context, (SimpleState) semanticObject); 
				return; 
			case FSMPackage.STATE_GRAPH:
				if (rule == grammarAccess.getStateGraphRule()) {
					sequence_StateGraph(context, (StateGraph) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getStateMachineRule()) {
					sequence_StateMachine(context, (StateGraph) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.STATE_TERMINAL:
				sequence_StateTerminal(context, (StateTerminal) semanticObject); 
				return; 
			case FSMPackage.SUB_STATE_TR_POINT_TERMINAL:
				sequence_SubStateTrPointTerminal(context, (SubStateTrPointTerminal) semanticObject); 
				return; 
			case FSMPackage.TR_POINT_TERMINAL:
				sequence_TrPointTerminal(context, (TrPointTerminal) semanticObject); 
				return; 
			case FSMPackage.TRANSITION_POINT:
				sequence_TransitionPoint(context, (TransitionPoint) semanticObject); 
				return; 
			case FSMPackage.TRIGGER:
				sequence_Trigger(context, (Trigger) semanticObject); 
				return; 
			case FSMPackage.TRIGGERED_TRANSITION:
				sequence_TriggeredTransition(context, (TriggeredTransition) semanticObject); 
				return; 
			}
		else if (epackage == RoomPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RoomPackage.ACTOR_CLASS:
				sequence_ActorClass(context, (ActorClass) semanticObject); 
				return; 
			case RoomPackage.ACTOR_INSTANCE_MAPPING:
				sequence_ActorInstanceMapping(context, (ActorInstanceMapping) semanticObject); 
				return; 
			case RoomPackage.ACTOR_REF:
				sequence_ActorRef(context, (ActorRef) semanticObject); 
				return; 
			case RoomPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case RoomPackage.BINDING:
				sequence_Binding(context, (Binding) semanticObject); 
				return; 
			case RoomPackage.BINDING_END_POINT:
				sequence_BindingEndPoint(context, (BindingEndPoint) semanticObject); 
				return; 
			case RoomPackage.CLASS_STRUCTOR:
				sequence_ClassStructor(context, (ClassStructor) semanticObject); 
				return; 
			case RoomPackage.COMPOUND_PROTOCOL_CLASS:
				sequence_CompoundProtocolClass(context, (CompoundProtocolClass) semanticObject); 
				return; 
			case RoomPackage.DATA_CLASS:
				sequence_DataClass(context, (DataClass) semanticObject); 
				return; 
			case RoomPackage.ENUM_LITERAL:
				sequence_EnumLiteral(context, (EnumLiteral) semanticObject); 
				return; 
			case RoomPackage.ENUMERATION_TYPE:
				sequence_EnumerationType(context, (EnumerationType) semanticObject); 
				return; 
			case RoomPackage.EXTERNAL_PORT:
				sequence_ExternalPort(context, (ExternalPort) semanticObject); 
				return; 
			case RoomPackage.EXTERNAL_TYPE:
				sequence_ExternalType(context, (ExternalType) semanticObject); 
				return; 
			case RoomPackage.IN_MESSAGE_HANDLER:
				sequence_InMessageHandler(context, (InMessageHandler) semanticObject); 
				return; 
			case RoomPackage.LAYER_CONNECTION:
				sequence_LayerConnection(context, (LayerConnection) semanticObject); 
				return; 
			case RoomPackage.LOGICAL_SYSTEM:
				sequence_LogicalSystem(context, (LogicalSystem) semanticObject); 
				return; 
			case RoomPackage.LOGICAL_THREAD:
				sequence_LogicalThread(context, (LogicalThread) semanticObject); 
				return; 
			case RoomPackage.MESSAGE:
				sequence_Message(context, (Message) semanticObject); 
				return; 
			case RoomPackage.MESSAGE_DATA:
				sequence_MessageData(context, (MessageData) semanticObject); 
				return; 
			case RoomPackage.OUT_MESSAGE_HANDLER:
				sequence_OutMessageHandler(context, (OutMessageHandler) semanticObject); 
				return; 
			case RoomPackage.PORT:
				sequence_Port(context, (Port) semanticObject); 
				return; 
			case RoomPackage.PORT_CLASS:
				sequence_PortClass(context, (PortClass) semanticObject); 
				return; 
			case RoomPackage.PORT_OPERATION:
				sequence_PortOperation(context, (PortOperation) semanticObject); 
				return; 
			case RoomPackage.PRIMITIVE_TYPE:
				sequence_PrimitiveType(context, (PrimitiveType) semanticObject); 
				return; 
			case RoomPackage.PROTOCOL_CLASS:
				sequence_ProtocolClass(context, (ProtocolClass) semanticObject); 
				return; 
			case RoomPackage.REF_PATH:
				sequence_RefPath(context, (RefPath) semanticObject); 
				return; 
			case RoomPackage.REF_SA_POINT:
				sequence_RefSAPoint(context, (RefSAPoint) semanticObject); 
				return; 
			case RoomPackage.REF_SEGMENT:
				sequence_RefSegment(context, (RefSegment) semanticObject); 
				return; 
			case RoomPackage.REFABLE_TYPE:
				sequence_RefableType(context, (RefableType) semanticObject); 
				return; 
			case RoomPackage.RELAY_SA_POINT:
				sequence_RelaySAPoint(context, (RelaySAPoint) semanticObject); 
				return; 
			case RoomPackage.ROOM_MODEL:
				sequence_RoomModel(context, (RoomModel) semanticObject); 
				return; 
			case RoomPackage.SAP:
				sequence_SAP(context, (SAP) semanticObject); 
				return; 
			case RoomPackage.SPP:
				sequence_SPP(context, (SPP) semanticObject); 
				return; 
			case RoomPackage.SP_POINT:
				sequence_SPPoint(context, (SPPoint) semanticObject); 
				return; 
			case RoomPackage.SERVICE_IMPLEMENTATION:
				sequence_ServiceImplementation(context, (ServiceImplementation) semanticObject); 
				return; 
			case RoomPackage.STANDARD_OPERATION:
				sequence_StandardOperation(context, (StandardOperation) semanticObject); 
				return; 
			case RoomPackage.SUB_PROTOCOL:
				sequence_SubProtocol(context, (SubProtocol) semanticObject); 
				return; 
			case RoomPackage.SUB_SYSTEM_CLASS:
				sequence_SubSystemClass(context, (SubSystemClass) semanticObject); 
				return; 
			case RoomPackage.SUB_SYSTEM_REF:
				sequence_SubSystemRef(context, (SubSystemRef) semanticObject); 
				return; 
			case RoomPackage.VAR_DECL:
				sequence_VarDecl(context, (VarDecl) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     RoomClass returns ActorClass
	 *     StructureClass returns ActorClass
	 *     ActorContainerClass returns ActorClass
	 *     ModelComponent returns ActorClass
	 *     ActorClass returns ActorClass
	 *
	 * Constraint:
	 *     (
	 *         (abstract?='abstract' | commType=ComponentCommunicationType)* 
	 *         name=ID 
	 *         docu=Documentation? 
	 *         base=[ActorClass|FQN]? 
	 *         annotations+=Annotation* 
	 *         serviceProvisionPoints+=SPP? 
	 *         (interfacePorts+=Port? serviceProvisionPoints+=SPP?)* 
	 *         structureDocu=Documentation? 
	 *         userCode1=DetailCode? 
	 *         userCode2=DetailCode? 
	 *         userCode3=DetailCode? 
	 *         connections+=LayerConnection? 
	 *         (
	 *             (
	 *                 bindings+=Binding | 
	 *                 serviceImplementations+=ServiceImplementation | 
	 *                 attributes+=Attribute | 
	 *                 actorRefs+=ActorRef | 
	 *                 serviceAccessPoints+=SAP | 
	 *                 internalPorts+=Port | 
	 *                 externalPorts+=ExternalPort
	 *             )? 
	 *             connections+=LayerConnection?
	 *         )* 
	 *         behaviorDocu=Documentation? 
	 *         behaviorAnnotations+=Annotation* 
	 *         (operations+=StandardOperation | structors+=ClassStructor)* 
	 *         stateMachine=StateMachine?
	 *     )
	 */
	protected void sequence_ActorClass(ISerializationContext context, ActorClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActorInstanceMapping returns ActorInstanceMapping
	 *
	 * Constraint:
	 *     (path=RefPath thread=[LogicalThread|ID] actorInstanceMappings+=ActorInstanceMapping*)
	 */
	protected void sequence_ActorInstanceMapping(ISerializationContext context, ActorInstanceMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActorContainerRef returns ActorRef
	 *     ActorRef returns ActorRef
	 *
	 * Constraint:
	 *     (refType=ReferenceType? name=ID multiplicity=MULTIPLICITY? type=[ActorClass|FQN] docu=Documentation?)
	 */
	protected void sequence_ActorRef(ISerializationContext context, ActorRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (name=ID size=INT? type=RefableType? defaultValueLiteral=STRING? docu=Documentation?)
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BindingEndPoint returns BindingEndPoint
	 *
	 * Constraint:
	 *     (actorRef=[ActorContainerRef|ID]? port=[Port|ID] sub=[SubProtocol|ID]?)
	 */
	protected void sequence_BindingEndPoint(ISerializationContext context, BindingEndPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Binding returns Binding
	 *
	 * Constraint:
	 *     (endpoint1=BindingEndPoint endpoint2=BindingEndPoint)
	 */
	protected void sequence_Binding(ISerializationContext context, Binding semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT1));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0(), semanticObject.getEndpoint1());
		feeder.accept(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0(), semanticObject.getEndpoint2());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ClassStructor returns ClassStructor
	 *
	 * Constraint:
	 *     ((name='ctor' | name='dtor') detailCode=DetailCode)
	 */
	protected void sequence_ClassStructor(ISerializationContext context, ClassStructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns CompoundProtocolClass
	 *     GeneralProtocolClass returns CompoundProtocolClass
	 *     CompoundProtocolClass returns CompoundProtocolClass
	 *
	 * Constraint:
	 *     (name=ID docu=Documentation? annotations+=Annotation* subProtocols+=SubProtocol*)
	 */
	protected void sequence_CompoundProtocolClass(ISerializationContext context, CompoundProtocolClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns DataClass
	 *     DataType returns DataClass
	 *     ComplexType returns DataClass
	 *     DataClass returns DataClass
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         docu=Documentation? 
	 *         base=[DataClass|FQN]? 
	 *         annotations+=Annotation* 
	 *         userCode1=DetailCode? 
	 *         userCode2=DetailCode? 
	 *         userCode3=DetailCode? 
	 *         (operations+=StandardOperation | structors+=ClassStructor | attributes+=Attribute)*
	 *     )
	 */
	protected void sequence_DataClass(ISerializationContext context, DataClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumLiteral returns EnumLiteral
	 *
	 * Constraint:
	 *     (name=ID literal=IntLiteral?)
	 */
	protected void sequence_EnumLiteral(ISerializationContext context, EnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns EnumerationType
	 *     DataType returns EnumerationType
	 *     EnumerationType returns EnumerationType
	 *
	 * Constraint:
	 *     (name=ID docu=Documentation? primitiveType=[PrimitiveType|FQN]? (literals+=EnumLiteral literals+=EnumLiteral*)?)
	 */
	protected void sequence_EnumerationType(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ExternalPort returns ExternalPort
	 *
	 * Constraint:
	 *     interfacePort=[Port|ID]
	 */
	protected void sequence_ExternalPort(ISerializationContext context, ExternalPort semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.EXTERNAL_PORT__INTERFACE_PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.EXTERNAL_PORT__INTERFACE_PORT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExternalPortAccess().getInterfacePortPortIDTerminalRuleCall_2_0_1(), semanticObject.eGet(RoomPackage.Literals.EXTERNAL_PORT__INTERFACE_PORT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns ExternalType
	 *     DataType returns ExternalType
	 *     ComplexType returns ExternalType
	 *     ExternalType returns ExternalType
	 *
	 * Constraint:
	 *     (name=ID targetName=STRING defaultValueLiteral=STRING? docu=Documentation?)
	 */
	protected void sequence_ExternalType(ISerializationContext context, ExternalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MessageHandler returns InMessageHandler
	 *     InMessageHandler returns InMessageHandler
	 *
	 * Constraint:
	 *     (msg=[Message|ID] detailCode=DetailCode)
	 */
	protected void sequence_InMessageHandler(ISerializationContext context, InMessageHandler semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInMessageHandlerAccess().getMsgMessageIDTerminalRuleCall_2_0_1(), semanticObject.eGet(RoomPackage.Literals.MESSAGE_HANDLER__MSG, false));
		feeder.accept(grammarAccess.getInMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0(), semanticObject.getDetailCode());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LayerConnection returns LayerConnection
	 *
	 * Constraint:
	 *     (from=SAPoint to=SPPoint)
	 */
	protected void sequence_LayerConnection(ISerializationContext context, LayerConnection semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__FROM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__FROM));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__TO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__TO));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0(), semanticObject.getFrom());
		feeder.accept(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0(), semanticObject.getTo());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns LogicalSystem
	 *     StructureClass returns LogicalSystem
	 *     LogicalSystem returns LogicalSystem
	 *
	 * Constraint:
	 *     (name=ID docu=Documentation? annotations+=Annotation* (connections+=LayerConnection | bindings+=Binding | subSystems+=SubSystemRef)*)
	 */
	protected void sequence_LogicalSystem(ISerializationContext context, LogicalSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LogicalThread returns LogicalThread
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_LogicalThread(ISerializationContext context, LogicalThread semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LOGICAL_THREAD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LOGICAL_THREAD__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MessageData returns MessageData
	 *
	 * Constraint:
	 *     (deprecatedName=ID? refType=RefableType)
	 */
	protected void sequence_MessageData(ISerializationContext context, MessageData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Message returns Message
	 *
	 * Constraint:
	 *     (priv?='private'? name=ID data=MessageData? annotations+=Annotation* docu=Documentation?)
	 */
	protected void sequence_Message(ISerializationContext context, Message semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MessageHandler returns OutMessageHandler
	 *     OutMessageHandler returns OutMessageHandler
	 *
	 * Constraint:
	 *     (msg=[Message|ID] detailCode=DetailCode)
	 */
	protected void sequence_OutMessageHandler(ISerializationContext context, OutMessageHandler semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutMessageHandlerAccess().getMsgMessageIDTerminalRuleCall_2_0_1(), semanticObject.eGet(RoomPackage.Literals.MESSAGE_HANDLER__MSG, false));
		feeder.accept(grammarAccess.getOutMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0(), semanticObject.getDetailCode());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PortClass returns PortClass
	 *
	 * Constraint:
	 *     (userCode=DetailCode? (msgHandlers+=MessageHandler | operations+=PortOperation | attributes+=Attribute)*)
	 */
	protected void sequence_PortClass(ISerializationContext context, PortClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Operation returns PortOperation
	 *     PortOperation returns PortOperation
	 *
	 * Constraint:
	 *     (name=ID (arguments+=VarDecl arguments+=VarDecl*)? (returnType=RefableType | sendsMsg=[Message|ID])? docu=Documentation? detailCode=DetailCode)
	 */
	protected void sequence_PortOperation(ISerializationContext context, PortOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InterfaceItem returns Port
	 *     Port returns Port
	 *     AbstractInterfaceItem returns Port
	 *
	 * Constraint:
	 *     (
	 *         conjugated?='conjugated'? 
	 *         name=ID 
	 *         multiplicity=MULTIPLICITY? 
	 *         protocol=[GeneralProtocolClass|FQN] 
	 *         annotations+=Annotation* 
	 *         docu=Documentation?
	 *     )
	 */
	protected void sequence_Port(ISerializationContext context, Port semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns PrimitiveType
	 *     DataType returns PrimitiveType
	 *     PrimitiveType returns PrimitiveType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=LiteralType 
	 *         targetName=STRING 
	 *         castName=FQN? 
	 *         defaultValueLiteral=STRING 
	 *         docu=Documentation?
	 *     )
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns ProtocolClass
	 *     GeneralProtocolClass returns ProtocolClass
	 *     ProtocolClass returns ProtocolClass
	 *
	 * Constraint:
	 *     (
	 *         commType=CommunicationType? 
	 *         name=ID 
	 *         docu=Documentation? 
	 *         base=[ProtocolClass|FQN]? 
	 *         annotations+=Annotation* 
	 *         userCode1=DetailCode? 
	 *         userCode2=DetailCode? 
	 *         userCode3=DetailCode? 
	 *         incomingMessages+=Message* 
	 *         outgoingMessages+=Message* 
	 *         regular=PortClass? 
	 *         conjugated=PortClass? 
	 *         semantics=ProtocolSemantics?
	 *     )
	 */
	protected void sequence_ProtocolClass(ISerializationContext context, ProtocolClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefPath returns RefPath
	 *
	 * Constraint:
	 *     (refs+=RefSegment refs+=RefSegment*)
	 */
	protected void sequence_RefPath(ISerializationContext context, RefPath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SAPoint returns RefSAPoint
	 *     RefSAPoint returns RefSAPoint
	 *
	 * Constraint:
	 *     ref=[ActorContainerRef|ID]
	 */
	protected void sequence_RefSAPoint(ISerializationContext context, RefSAPoint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.REF_SA_POINT__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.REF_SA_POINT__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRefSAPointAccess().getRefActorContainerRefIDTerminalRuleCall_1_0_1(), semanticObject.eGet(RoomPackage.Literals.REF_SA_POINT__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RefSegment returns RefSegment
	 *
	 * Constraint:
	 *     (ref=ID idx=INT?)
	 */
	protected void sequence_RefSegment(ISerializationContext context, RefSegment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefableType returns RefableType
	 *
	 * Constraint:
	 *     (type=[DataType|FQN] ref?='ref'?)
	 */
	protected void sequence_RefableType(ISerializationContext context, RefableType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SAPoint returns RelaySAPoint
	 *     RelaySAPoint returns RelaySAPoint
	 *
	 * Constraint:
	 *     relay=[SPP|ID]
	 */
	protected void sequence_RelaySAPoint(ISerializationContext context, RelaySAPoint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.RELAY_SA_POINT__RELAY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.RELAY_SA_POINT__RELAY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelaySAPointAccess().getRelaySPPIDTerminalRuleCall_1_0_1(), semanticObject.eGet(RoomPackage.Literals.RELAY_SA_POINT__RELAY, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RoomModel returns RoomModel
	 *
	 * Constraint:
	 *     (
	 *         name=FQN 
	 *         docu=Documentation? 
	 *         annotations+=Annotation* 
	 *         imports+=Import* 
	 *         annotationTypes+=AnnotationType* 
	 *         roomClasses+=RoomClass*
	 *     )
	 */
	protected void sequence_RoomModel(ISerializationContext context, RoomModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InterfaceItem returns SAP
	 *     SAP returns SAP
	 *     AbstractInterfaceItem returns SAP
	 *
	 * Constraint:
	 *     (name=ID protocol=[ProtocolClass|FQN] docu=Documentation?)
	 */
	protected void sequence_SAP(ISerializationContext context, SAP semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InterfaceItem returns SPP
	 *     SPP returns SPP
	 *     AbstractInterfaceItem returns SPP
	 *
	 * Constraint:
	 *     (name=ID protocol=[ProtocolClass|FQN] docu=Documentation?)
	 */
	protected void sequence_SPP(ISerializationContext context, SPP semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SPPoint returns SPPoint
	 *
	 * Constraint:
	 *     (ref=[ActorContainerRef|ID] service=[SPP|ID])
	 */
	protected void sequence_SPPoint(ISerializationContext context, SPPoint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SP_POINT__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SP_POINT__REF));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SP_POINT__SERVICE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SP_POINT__SERVICE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSPPointAccess().getRefActorContainerRefIDTerminalRuleCall_0_0_1(), semanticObject.eGet(RoomPackage.Literals.SP_POINT__REF, false));
		feeder.accept(grammarAccess.getSPPointAccess().getServiceSPPIDTerminalRuleCall_2_0_1(), semanticObject.eGet(RoomPackage.Literals.SP_POINT__SERVICE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ServiceImplementation returns ServiceImplementation
	 *
	 * Constraint:
	 *     spp=[SPP|ID]
	 */
	protected void sequence_ServiceImplementation(ISerializationContext context, ServiceImplementation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SERVICE_IMPLEMENTATION__SPP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SERVICE_IMPLEMENTATION__SPP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getServiceImplementationAccess().getSppSPPIDTerminalRuleCall_2_0_1(), semanticObject.eGet(RoomPackage.Literals.SERVICE_IMPLEMENTATION__SPP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Operation returns StandardOperation
	 *     StandardOperation returns StandardOperation
	 *
	 * Constraint:
	 *     (
	 *         override?='override'? 
	 *         name=ID 
	 *         (arguments+=VarDecl arguments+=VarDecl*)? 
	 *         returnType=RefableType? 
	 *         docu=Documentation? 
	 *         detailCode=DetailCode
	 *     )
	 */
	protected void sequence_StandardOperation(ISerializationContext context, StandardOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubProtocol returns SubProtocol
	 *
	 * Constraint:
	 *     (name=ID protocol=[GeneralProtocolClass|FQN])
	 */
	protected void sequence_SubProtocol(ISerializationContext context, SubProtocol semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__NAME));
			if (transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__PROTOCOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__PROTOCOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubProtocolAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubProtocolAccess().getProtocolGeneralProtocolClassFQNParserRuleCall_3_0_1(), semanticObject.eGet(RoomPackage.Literals.SUB_PROTOCOL__PROTOCOL, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RoomClass returns SubSystemClass
	 *     StructureClass returns SubSystemClass
	 *     ActorContainerClass returns SubSystemClass
	 *     SubSystemClass returns SubSystemClass
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         docu=Documentation? 
	 *         annotations+=Annotation* 
	 *         userCode1=DetailCode? 
	 *         userCode2=DetailCode? 
	 *         userCode3=DetailCode? 
	 *         (
	 *             actorInstanceMappings+=ActorInstanceMapping | 
	 *             threads+=LogicalThread | 
	 *             connections+=LayerConnection | 
	 *             bindings+=Binding | 
	 *             actorRefs+=ActorRef | 
	 *             serviceProvisionPoints+=SPP | 
	 *             relayPorts+=Port
	 *         )*
	 *     )
	 */
	protected void sequence_SubSystemClass(ISerializationContext context, SubSystemClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActorContainerRef returns SubSystemRef
	 *     SubSystemRef returns SubSystemRef
	 *
	 * Constraint:
	 *     (name=ID type=[SubSystemClass|FQN] docu=Documentation?)
	 */
	protected void sequence_SubSystemRef(ISerializationContext context, SubSystemRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VarDecl returns VarDecl
	 *
	 * Constraint:
	 *     (name=ID refType=RefableType varargs?='varargs'?)
	 */
	protected void sequence_VarDecl(ISerializationContext context, VarDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
