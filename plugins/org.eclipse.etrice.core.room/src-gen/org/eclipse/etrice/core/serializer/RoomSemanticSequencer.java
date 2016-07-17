package org.eclipse.etrice.core.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RoomSemanticSequencer extends FSMSemanticSequencer {

	@Inject
	private RoomGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BasePackage.ANNOTATION:
				if(context == grammarAccess.getAnnotationRule()) {
					sequence_Annotation(context, (Annotation) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.ANNOTATION_TYPE:
				if(context == grammarAccess.getAnnotationTypeRule()) {
					sequence_AnnotationType(context, (AnnotationType) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.BOOLEAN_LITERAL:
				if(context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getLiteralRule()) {
					sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.DOCUMENTATION:
				if(context == grammarAccess.getDocumentationRule()) {
					sequence_Documentation(context, (Documentation) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.ENUM_ANNOTATION_ATTRIBUTE:
				if(context == grammarAccess.getAnnotationAttributeRule() ||
				   context == grammarAccess.getEnumAnnotationAttributeRule()) {
					sequence_EnumAnnotationAttribute(context, (EnumAnnotationAttribute) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.INT_LITERAL:
				if(context == grammarAccess.getIntLiteralRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getNumberLiteralRule()) {
					sequence_IntLiteral(context, (IntLiteral) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.KEY_VALUE:
				if(context == grammarAccess.getKeyValueRule()) {
					sequence_KeyValue(context, (KeyValue) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.LITERAL_ARRAY:
				if(context == grammarAccess.getLiteralArrayRule()) {
					sequence_LiteralArray(context, (LiteralArray) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.REAL_LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getNumberLiteralRule() ||
				   context == grammarAccess.getRealLiteralRule()) {
					sequence_RealLiteral(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.SIMPLE_ANNOTATION_ATTRIBUTE:
				if(context == grammarAccess.getAnnotationAttributeRule() ||
				   context == grammarAccess.getSimpleAnnotationAttributeRule()) {
					sequence_SimpleAnnotationAttribute(context, (SimpleAnnotationAttribute) semanticObject); 
					return; 
				}
				else break;
			case BasePackage.STRING_LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getStringLiteralRule()) {
					sequence_StringLiteral(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == FSMPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FSMPackage.CP_BRANCH_TRANSITION:
				if(context == grammarAccess.getCPBranchTransitionRule() ||
				   context == grammarAccess.getNonInitialTransitionRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getTransitionRule()) {
					sequence_CPBranchTransition(context, (CPBranchTransition) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.CHOICE_POINT:
				if(context == grammarAccess.getChoicePointRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule()) {
					sequence_ChoicePoint(context, (ChoicePoint) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.CHOICEPOINT_TERMINAL:
				if(context == grammarAccess.getChoicepointTerminalRule() ||
				   context == grammarAccess.getTransitionTerminalRule()) {
					sequence_ChoicepointTerminal(context, (ChoicepointTerminal) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.CONTINUATION_TRANSITION:
				if(context == grammarAccess.getContinuationTransitionRule() ||
				   context == grammarAccess.getNonInitialTransitionRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getTransitionRule()) {
					sequence_ContinuationTransition(context, (ContinuationTransition) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.DETAIL_CODE:
				if(context == grammarAccess.getDetailCodeRule()) {
					sequence_DetailCode(context, (DetailCode) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.ENTRY_POINT:
				if(context == grammarAccess.getEntryPointRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule() ||
				   context == grammarAccess.getTrPointRule()) {
					sequence_EntryPoint(context, (EntryPoint) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.EXIT_POINT:
				if(context == grammarAccess.getExitPointRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule() ||
				   context == grammarAccess.getTrPointRule()) {
					sequence_ExitPoint(context, (ExitPoint) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.FSM_MODEL:
				if(context == grammarAccess.getFSMModelRule()) {
					sequence_FSMModel(context, (FSMModel) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.GUARD:
				if(context == grammarAccess.getGuardRule()) {
					sequence_Guard(context, (Guard) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.GUARDED_TRANSITION:
				if(context == grammarAccess.getGuardedTransitionRule() ||
				   context == grammarAccess.getNonInitialTransitionRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getTransitionRule() ||
				   context == grammarAccess.getTransitionChainStartTransitionRule()) {
					sequence_GuardedTransition(context, (GuardedTransition) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.IN_SEMANTICS_RULE:
				if(context == grammarAccess.getInSemanticsRuleRule() ||
				   context == grammarAccess.getSemanticsRuleRule()) {
					sequence_InSemanticsRule(context, (InSemanticsRule) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.INITIAL_TRANSITION:
				if(context == grammarAccess.getInitialTransitionRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getTransitionRule()) {
					sequence_InitialTransition(context, (InitialTransition) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.MESSAGE_FROM_IF:
				if(context == grammarAccess.getMessageFromIfRule()) {
					sequence_MessageFromIf(context, (MessageFromIf) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.OUT_SEMANTICS_RULE:
				if(context == grammarAccess.getOutSemanticsRuleRule() ||
				   context == grammarAccess.getSemanticsRuleRule()) {
					sequence_OutSemanticsRule(context, (OutSemanticsRule) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.PROTOCOL_SEMANTICS:
				if(context == grammarAccess.getProtocolSemanticsRule()) {
					sequence_ProtocolSemantics(context, (ProtocolSemantics) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.REFINED_STATE:
				if(context == grammarAccess.getRefinedStateRule() ||
				   context == grammarAccess.getStateRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule()) {
					sequence_RefinedState(context, (RefinedState) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.REFINED_TRANSITION:
				if(context == grammarAccess.getRefinedTransitionRule()) {
					sequence_RefinedTransition(context, (RefinedTransition) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.SIMPLE_STATE:
				if(context == grammarAccess.getSimpleStateRule() ||
				   context == grammarAccess.getStateRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule()) {
					sequence_SimpleState(context, (SimpleState) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.STATE_GRAPH:
				if(context == grammarAccess.getStateGraphRule()) {
					sequence_StateGraph(context, (StateGraph) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getStateMachineRule()) {
					sequence_StateMachine(context, (StateGraph) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.STATE_TERMINAL:
				if(context == grammarAccess.getStateTerminalRule() ||
				   context == grammarAccess.getTransitionTerminalRule()) {
					sequence_StateTerminal(context, (StateTerminal) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.SUB_STATE_TR_POINT_TERMINAL:
				if(context == grammarAccess.getSubStateTrPointTerminalRule() ||
				   context == grammarAccess.getTransitionTerminalRule()) {
					sequence_SubStateTrPointTerminal(context, (SubStateTrPointTerminal) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.TR_POINT_TERMINAL:
				if(context == grammarAccess.getTrPointTerminalRule() ||
				   context == grammarAccess.getTransitionTerminalRule()) {
					sequence_TrPointTerminal(context, (TrPointTerminal) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.TRANSITION_POINT:
				if(context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getStateGraphNodeRule() ||
				   context == grammarAccess.getTrPointRule() ||
				   context == grammarAccess.getTransitionPointRule()) {
					sequence_TransitionPoint(context, (TransitionPoint) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.TRIGGER:
				if(context == grammarAccess.getTriggerRule()) {
					sequence_Trigger(context, (Trigger) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.TRIGGERED_TRANSITION:
				if(context == grammarAccess.getNonInitialTransitionRule() ||
				   context == grammarAccess.getStateGraphItemRule() ||
				   context == grammarAccess.getTransitionRule() ||
				   context == grammarAccess.getTransitionChainStartTransitionRule() ||
				   context == grammarAccess.getTriggeredTransitionRule()) {
					sequence_TriggeredTransition(context, (TriggeredTransition) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == RoomPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case RoomPackage.ACTOR_CLASS:
				if(context == grammarAccess.getActorClassRule() ||
				   context == grammarAccess.getActorContainerClassRule() ||
				   context == grammarAccess.getModelComponentRule() ||
				   context == grammarAccess.getRoomClassRule() ||
				   context == grammarAccess.getStructureClassRule()) {
					sequence_ActorClass(context, (ActorClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ACTOR_INSTANCE_MAPPING:
				if(context == grammarAccess.getActorInstanceMappingRule()) {
					sequence_ActorInstanceMapping(context, (ActorInstanceMapping) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ACTOR_REF:
				if(context == grammarAccess.getActorContainerRefRule() ||
				   context == grammarAccess.getActorRefRule()) {
					sequence_ActorRef(context, (ActorRef) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.BINDING:
				if(context == grammarAccess.getBindingRule()) {
					sequence_Binding(context, (Binding) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.BINDING_END_POINT:
				if(context == grammarAccess.getBindingEndPointRule()) {
					sequence_BindingEndPoint(context, (BindingEndPoint) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.CLASS_STRUCTOR:
				if(context == grammarAccess.getClassStructorRule()) {
					sequence_ClassStructor(context, (ClassStructor) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.COMPOUND_PROTOCOL_CLASS:
				if(context == grammarAccess.getCompoundProtocolClassRule() ||
				   context == grammarAccess.getGeneralProtocolClassRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_CompoundProtocolClass(context, (CompoundProtocolClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.DATA_CLASS:
				if(context == grammarAccess.getComplexTypeRule() ||
				   context == grammarAccess.getDataClassRule() ||
				   context == grammarAccess.getDataTypeRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_DataClass(context, (DataClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ENUM_LITERAL:
				if(context == grammarAccess.getEnumLiteralRule()) {
					sequence_EnumLiteral(context, (EnumLiteral) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ENUMERATION_TYPE:
				if(context == grammarAccess.getDataTypeRule() ||
				   context == grammarAccess.getEnumerationTypeRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_EnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.EXTERNAL_PORT:
				if(context == grammarAccess.getExternalPortRule()) {
					sequence_ExternalPort(context, (ExternalPort) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.EXTERNAL_TYPE:
				if(context == grammarAccess.getComplexTypeRule() ||
				   context == grammarAccess.getDataTypeRule() ||
				   context == grammarAccess.getExternalTypeRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_ExternalType(context, (ExternalType) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.IN_MESSAGE_HANDLER:
				if(context == grammarAccess.getInMessageHandlerRule() ||
				   context == grammarAccess.getMessageHandlerRule()) {
					sequence_InMessageHandler(context, (InMessageHandler) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.LAYER_CONNECTION:
				if(context == grammarAccess.getLayerConnectionRule()) {
					sequence_LayerConnection(context, (LayerConnection) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.LOGICAL_SYSTEM:
				if(context == grammarAccess.getLogicalSystemRule() ||
				   context == grammarAccess.getRoomClassRule() ||
				   context == grammarAccess.getStructureClassRule()) {
					sequence_LogicalSystem(context, (LogicalSystem) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.LOGICAL_THREAD:
				if(context == grammarAccess.getLogicalThreadRule()) {
					sequence_LogicalThread(context, (LogicalThread) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.MESSAGE:
				if(context == grammarAccess.getMessageRule()) {
					sequence_Message(context, (Message) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.OUT_MESSAGE_HANDLER:
				if(context == grammarAccess.getMessageHandlerRule() ||
				   context == grammarAccess.getOutMessageHandlerRule()) {
					sequence_OutMessageHandler(context, (OutMessageHandler) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.PORT:
				if(context == grammarAccess.getAbstractInterfaceItemRule() ||
				   context == grammarAccess.getInterfaceItemRule() ||
				   context == grammarAccess.getPortRule()) {
					sequence_Port(context, (Port) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.PORT_CLASS:
				if(context == grammarAccess.getPortClassRule()) {
					sequence_PortClass(context, (PortClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.PORT_OPERATION:
				if(context == grammarAccess.getOperationRule() ||
				   context == grammarAccess.getPortOperationRule()) {
					sequence_PortOperation(context, (PortOperation) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.PRIMITIVE_TYPE:
				if(context == grammarAccess.getDataTypeRule() ||
				   context == grammarAccess.getPrimitiveTypeRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_PrimitiveType(context, (PrimitiveType) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.PROTOCOL_CLASS:
				if(context == grammarAccess.getGeneralProtocolClassRule() ||
				   context == grammarAccess.getProtocolClassRule() ||
				   context == grammarAccess.getRoomClassRule()) {
					sequence_ProtocolClass(context, (ProtocolClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.REF_PATH:
				if(context == grammarAccess.getRefPathRule()) {
					sequence_RefPath(context, (RefPath) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.REF_SA_POINT:
				if(context == grammarAccess.getRefSAPointRule() ||
				   context == grammarAccess.getSAPointRule()) {
					sequence_RefSAPoint(context, (RefSAPoint) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.REF_SEGMENT:
				if(context == grammarAccess.getRefSegmentRule()) {
					sequence_RefSegment(context, (RefSegment) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.REFABLE_TYPE:
				if(context == grammarAccess.getRefableTypeRule()) {
					sequence_RefableType(context, (RefableType) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.RELAY_SA_POINT:
				if(context == grammarAccess.getRelaySAPointRule() ||
				   context == grammarAccess.getSAPointRule()) {
					sequence_RelaySAPoint(context, (RelaySAPoint) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.ROOM_MODEL:
				if(context == grammarAccess.getRoomModelRule()) {
					sequence_RoomModel(context, (RoomModel) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SAP:
				if(context == grammarAccess.getAbstractInterfaceItemRule() ||
				   context == grammarAccess.getInterfaceItemRule() ||
				   context == grammarAccess.getSAPRule()) {
					sequence_SAP(context, (SAP) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SPP:
				if(context == grammarAccess.getAbstractInterfaceItemRule() ||
				   context == grammarAccess.getInterfaceItemRule() ||
				   context == grammarAccess.getSPPRule()) {
					sequence_SPP(context, (SPP) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SP_POINT:
				if(context == grammarAccess.getSPPointRule()) {
					sequence_SPPoint(context, (SPPoint) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SERVICE_IMPLEMENTATION:
				if(context == grammarAccess.getServiceImplementationRule()) {
					sequence_ServiceImplementation(context, (ServiceImplementation) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.STANDARD_OPERATION:
				if(context == grammarAccess.getOperationRule() ||
				   context == grammarAccess.getStandardOperationRule()) {
					sequence_StandardOperation(context, (StandardOperation) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SUB_PROTOCOL:
				if(context == grammarAccess.getSubProtocolRule()) {
					sequence_SubProtocol(context, (SubProtocol) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SUB_SYSTEM_CLASS:
				if(context == grammarAccess.getActorContainerClassRule() ||
				   context == grammarAccess.getRoomClassRule() ||
				   context == grammarAccess.getStructureClassRule() ||
				   context == grammarAccess.getSubSystemClassRule()) {
					sequence_SubSystemClass(context, (SubSystemClass) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.SUB_SYSTEM_REF:
				if(context == grammarAccess.getActorContainerRefRule() ||
				   context == grammarAccess.getSubSystemRefRule()) {
					sequence_SubSystemRef(context, (SubSystemRef) semanticObject); 
					return; 
				}
				else break;
			case RoomPackage.VAR_DECL:
				if(context == grammarAccess.getVarDeclRule()) {
					sequence_VarDecl(context, (VarDecl) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         abstract?='abstract'? 
	 *         commType=ComponentCommunicationType? 
	 *         name=ID 
	 *         docu=Documentation? 
	 *         base=[ActorClass|FQN]? 
	 *         annotations+=Annotation* 
	 *         (serviceProvisionPoints+=SPP | interfacePorts+=Port)* 
	 *         (
	 *             structureDocu=Documentation? 
	 *             userCode1=DetailCode? 
	 *             userCode2=DetailCode? 
	 *             userCode3=DetailCode? 
	 *             (
	 *                 connections+=LayerConnection | 
	 *                 bindings+=Binding | 
	 *                 serviceImplementations+=ServiceImplementation | 
	 *                 attributes+=Attribute | 
	 *                 actorRefs+=ActorRef | 
	 *                 serviceAccessPoints+=SAP | 
	 *                 internalPorts+=Port | 
	 *                 externalPorts+=ExternalPort
	 *             )*
	 *         )? 
	 *         (
	 *             behaviorDocu=Documentation? 
	 *             behaviorAnnotations+=Annotation* 
	 *             (operations+=StandardOperation | structors+=ClassStructor)* 
	 *             stateMachine=StateMachine?
	 *         )?
	 *     )
	 */
	protected void sequence_ActorClass(EObject context, ActorClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=RefPath thread=[LogicalThread|ID] actorInstanceMappings+=ActorInstanceMapping*)
	 */
	protected void sequence_ActorInstanceMapping(EObject context, ActorInstanceMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=ReferenceType? name=ID multiplicity=MULTIPLICITY? type=[ActorClass|FQN] docu=Documentation?)
	 */
	protected void sequence_ActorRef(EObject context, ActorRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID size=INT? type=RefableType defaultValueLiteral=STRING? docu=Documentation?)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (actorRef=[ActorContainerRef|ID]? port=[Port|ID] sub=[SubProtocol|ID]?)
	 */
	protected void sequence_BindingEndPoint(EObject context, BindingEndPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (endpoint1=BindingEndPoint endpoint2=BindingEndPoint)
	 */
	protected void sequence_Binding(EObject context, Binding semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT1));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.BINDING__ENDPOINT2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0(), semanticObject.getEndpoint1());
		feeder.accept(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0(), semanticObject.getEndpoint2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((name='ctor' | name='dtor') detailCode=DetailCode)
	 */
	protected void sequence_ClassStructor(EObject context, ClassStructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? annotations+=Annotation* subProtocols+=SubProtocol*)
	 */
	protected void sequence_CompoundProtocolClass(EObject context, CompoundProtocolClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_DataClass(EObject context, DataClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID literal=IntLiteral?)
	 */
	protected void sequence_EnumLiteral(EObject context, EnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? primitiveType=[PrimitiveType|FQN]? (literals+=EnumLiteral literals+=EnumLiteral*)?)
	 */
	protected void sequence_EnumerationType(EObject context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     interfacePort=[Port|ID]
	 */
	protected void sequence_ExternalPort(EObject context, ExternalPort semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.EXTERNAL_PORT__INTERFACE_PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.EXTERNAL_PORT__INTERFACE_PORT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExternalPortAccess().getInterfacePortPortIDTerminalRuleCall_2_0_1(), semanticObject.getInterfacePort());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID targetName=STRING defaultValueLiteral=STRING? docu=Documentation?)
	 */
	protected void sequence_ExternalType(EObject context, ExternalType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (msg=[Message|ID] detailCode=DetailCode)
	 */
	protected void sequence_InMessageHandler(EObject context, InMessageHandler semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInMessageHandlerAccess().getMsgMessageIDTerminalRuleCall_2_0_1(), semanticObject.getMsg());
		feeder.accept(grammarAccess.getInMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0(), semanticObject.getDetailCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (from=SAPoint to=SPPoint)
	 */
	protected void sequence_LayerConnection(EObject context, LayerConnection semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__FROM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__FROM));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__TO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LAYER_CONNECTION__TO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0(), semanticObject.getFrom());
		feeder.accept(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0(), semanticObject.getTo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? annotations+=Annotation* (connections+=LayerConnection | bindings+=Binding | subSystems+=SubSystemRef)*)
	 */
	protected void sequence_LogicalSystem(EObject context, LogicalSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_LogicalThread(EObject context, LogicalThread semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.LOGICAL_THREAD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.LOGICAL_THREAD__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (priv?='private'? name=ID data=VarDecl? docu=Documentation?)
	 */
	protected void sequence_Message(EObject context, Message semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (msg=[Message|ID] detailCode=DetailCode)
	 */
	protected void sequence_OutMessageHandler(EObject context, OutMessageHandler semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__MSG));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.MESSAGE_HANDLER__DETAIL_CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOutMessageHandlerAccess().getMsgMessageIDTerminalRuleCall_2_0_1(), semanticObject.getMsg());
		feeder.accept(grammarAccess.getOutMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0(), semanticObject.getDetailCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (userCode=DetailCode? (msgHandlers+=MessageHandler | operations+=PortOperation | attributes+=Attribute)*)
	 */
	protected void sequence_PortClass(EObject context, PortClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (arguments+=VarDecl arguments+=VarDecl*)? (returnType=RefableType? | sendsMsg=[Message|ID])? docu=Documentation? detailCode=DetailCode)
	 */
	protected void sequence_PortOperation(EObject context, PortOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conjugated?='conjugated'? name=ID multiplicity=MULTIPLICITY? protocol=[GeneralProtocolClass|FQN] docu=Documentation?)
	 */
	protected void sequence_Port(EObject context, Port semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_PrimitiveType(EObject context, PrimitiveType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
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
	protected void sequence_ProtocolClass(EObject context, ProtocolClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refs+=RefSegment refs+=RefSegment*)
	 */
	protected void sequence_RefPath(EObject context, RefPath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[ActorContainerRef|ID]
	 */
	protected void sequence_RefSAPoint(EObject context, RefSAPoint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.REF_SA_POINT__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.REF_SA_POINT__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRefSAPointAccess().getRefActorContainerRefIDTerminalRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ref=ID idx=INT?)
	 */
	protected void sequence_RefSegment(EObject context, RefSegment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[DataType|FQN] ref?='ref'?)
	 */
	protected void sequence_RefableType(EObject context, RefableType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     relay=[SPP|ID]
	 */
	protected void sequence_RelaySAPoint(EObject context, RelaySAPoint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.RELAY_SA_POINT__RELAY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.RELAY_SA_POINT__RELAY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelaySAPointAccess().getRelaySPPIDTerminalRuleCall_1_0_1(), semanticObject.getRelay());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=FQN 
	 *         docu=Documentation? 
	 *         imports+=Import* 
	 *         (
	 *             primitiveTypes+=PrimitiveType | 
	 *             enumerationTypes+=EnumerationType | 
	 *             externalTypes+=ExternalType | 
	 *             dataClasses+=DataClass | 
	 *             protocolClasses+=GeneralProtocolClass | 
	 *             actorClasses+=ActorClass | 
	 *             subSystemClasses+=SubSystemClass | 
	 *             systems+=LogicalSystem | 
	 *             annotationTypes+=AnnotationType
	 *         )*
	 *     )
	 */
	protected void sequence_RoomModel(EObject context, RoomModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID protocol=[ProtocolClass|FQN])
	 */
	protected void sequence_SAP(EObject context, SAP semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SAP__PROTOCOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SAP__PROTOCOL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSAPAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSAPAccess().getProtocolProtocolClassFQNParserRuleCall_3_0_1(), semanticObject.getProtocol());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID protocol=[ProtocolClass|FQN])
	 */
	protected void sequence_SPP(EObject context, SPP semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SPP__PROTOCOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SPP__PROTOCOL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSPPAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSPPAccess().getProtocolProtocolClassFQNParserRuleCall_3_0_1(), semanticObject.getProtocol());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[ActorContainerRef|ID] service=[SPP|ID])
	 */
	protected void sequence_SPPoint(EObject context, SPPoint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SP_POINT__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SP_POINT__REF));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SP_POINT__SERVICE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SP_POINT__SERVICE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSPPointAccess().getRefActorContainerRefIDTerminalRuleCall_0_0_1(), semanticObject.getRef());
		feeder.accept(grammarAccess.getSPPointAccess().getServiceSPPIDTerminalRuleCall_2_0_1(), semanticObject.getService());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     spp=[SPP|ID]
	 */
	protected void sequence_ServiceImplementation(EObject context, ServiceImplementation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SERVICE_IMPLEMENTATION__SPP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SERVICE_IMPLEMENTATION__SPP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getServiceImplementationAccess().getSppSPPIDTerminalRuleCall_2_0_1(), semanticObject.getSpp());
		feeder.finish();
	}
	
	
	/**
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
	protected void sequence_StandardOperation(EObject context, StandardOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID protocol=[GeneralProtocolClass|FQN])
	 */
	protected void sequence_SubProtocol(EObject context, SubProtocol semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__NAME));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__PROTOCOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.SUB_PROTOCOL__PROTOCOL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubProtocolAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSubProtocolAccess().getProtocolGeneralProtocolClassFQNParserRuleCall_3_0_1(), semanticObject.getProtocol());
		feeder.finish();
	}
	
	
	/**
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
	protected void sequence_SubSystemClass(EObject context, SubSystemClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=[SubSystemClass|FQN] docu=Documentation?)
	 */
	protected void sequence_SubSystemRef(EObject context, SubSystemRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID refType=RefableType)
	 */
	protected void sequence_VarDecl(EObject context, VarDecl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.VAR_DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.VAR_DECL__NAME));
			if(transientValues.isValueTransient(semanticObject, RoomPackage.Literals.VAR_DECL__REF_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RoomPackage.Literals.VAR_DECL__REF_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getVarDeclAccess().getRefTypeRefableTypeParserRuleCall_2_0(), semanticObject.getRefType());
		feeder.finish();
	}
}
