package org.eclipse.etrice.core.fsm.serializer;

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
import org.eclipse.etrice.core.common.serializer.BaseSemanticSequencer;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.AbstractMessage;
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
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
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
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;
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
public class FSMSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private FSMGrammarAccess grammarAccess;
	
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
			case FSMPackage.ABSTRACT_INTERFACE_ITEM:
				if(context == grammarAccess.getAbstractInterfaceItemRule()) {
					sequence_AbstractInterfaceItem(context, (AbstractInterfaceItem) semanticObject); 
					return; 
				}
				else break;
			case FSMPackage.ABSTRACT_MESSAGE:
				if(context == grammarAccess.getAbstractMessageRule()) {
					sequence_AbstractMessage(context, (AbstractMessage) semanticObject); 
					return; 
				}
				else break;
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
			case FSMPackage.MODEL_COMPONENT:
				if(context == grammarAccess.getModelComponentRule()) {
					sequence_ModelComponent(context, (ModelComponent) semanticObject); 
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_AbstractInterfaceItem(EObject context, AbstractInterfaceItem semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbstractInterfaceItemAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_AbstractMessage(EObject context, AbstractMessage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.ABSTRACT_MESSAGE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.ABSTRACT_MESSAGE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbstractMessageAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         from=TransitionTerminal 
	 *         to=TransitionTerminal 
	 *         docu=Documentation? 
	 *         condition=DetailCode 
	 *         action=DetailCode?
	 *     )
	 */
	protected void sequence_CPBranchTransition(EObject context, CPBranchTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation?)
	 */
	protected void sequence_ChoicePoint(EObject context, ChoicePoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     cp=[ChoicePoint|ID]
	 */
	protected void sequence_ChoicepointTerminal(EObject context, ChoicepointTerminal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.CHOICEPOINT_TERMINAL__CP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.CHOICEPOINT_TERMINAL__CP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChoicepointTerminalAccess().getCpChoicePointIDTerminalRuleCall_1_0_1(), semanticObject.getCp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? from=TransitionTerminal to=TransitionTerminal docu=Documentation? action=DetailCode?)
	 */
	protected void sequence_ContinuationTransition(EObject context, ContinuationTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (used?='{' lines+=STRING*)
	 */
	protected void sequence_DetailCode(EObject context, DetailCode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EntryPoint(EObject context, EntryPoint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.TR_POINT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.TR_POINT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntryPointAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_ExitPoint(EObject context, ExitPoint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.TR_POINT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.TR_POINT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExitPointAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     components+=ModelComponent*
	 */
	protected void sequence_FSMModel(EObject context, FSMModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     guard=DetailCode
	 */
	protected void sequence_Guard(EObject context, Guard semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.GUARD__GUARD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.GUARD__GUARD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0(), semanticObject.getGuard());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         from=TransitionTerminal 
	 *         to=TransitionTerminal 
	 *         docu=Documentation? 
	 *         guard=DetailCode 
	 *         action=DetailCode?
	 *     )
	 */
	protected void sequence_GuardedTransition(EObject context, GuardedTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (msg=[AbstractMessage|ID] (followUps+=SemanticsRule | (followUps+=SemanticsRule followUps+=SemanticsRule+))?)
	 */
	protected void sequence_InSemanticsRule(EObject context, InSemanticsRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? to=TransitionTerminal docu=Documentation? action=DetailCode?)
	 */
	protected void sequence_InitialTransition(EObject context, InitialTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (message=[AbstractMessage|ID] from=[AbstractInterfaceItem|ID])
	 */
	protected void sequence_MessageFromIf(EObject context, MessageFromIf semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.MESSAGE_FROM_IF__MESSAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.MESSAGE_FROM_IF__MESSAGE));
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.MESSAGE_FROM_IF__FROM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.MESSAGE_FROM_IF__FROM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMessageFromIfAccess().getMessageAbstractMessageIDTerminalRuleCall_0_0_1(), semanticObject.getMessage());
		feeder.accept(grammarAccess.getMessageFromIfAccess().getFromAbstractInterfaceItemIDTerminalRuleCall_2_0_1(), semanticObject.getFrom());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (abstract?='abstract'? commType=ComponentCommunicationType? componentName=ID base=[ModelComponent|FQN]? stateMachine=StateMachine)
	 */
	protected void sequence_ModelComponent(EObject context, ModelComponent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (msg=[AbstractMessage|ID] (followUps+=SemanticsRule | (followUps+=SemanticsRule followUps+=SemanticsRule+))?)
	 */
	protected void sequence_OutSemanticsRule(EObject context, OutSemanticsRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rules+=SemanticsRule*)
	 */
	protected void sequence_ProtocolSemantics(EObject context, ProtocolSemantics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         target=[State|FQN] 
	 *         docu=Documentation? 
	 *         entryCode=DetailCode? 
	 *         exitCode=DetailCode? 
	 *         doCode=DetailCode? 
	 *         subgraph=StateGraph?
	 *     )
	 */
	protected void sequence_RefinedState(EObject context, RefinedState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=[Transition|FQN] docu=Documentation? action=DetailCode)
	 */
	protected void sequence_RefinedTransition(EObject context, RefinedTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? (entryCode=DetailCode? exitCode=DetailCode? doCode=DetailCode? subgraph=StateGraph?)?)
	 */
	protected void sequence_SimpleState(EObject context, SimpleState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((states+=State | trPoints+=TrPoint | chPoints+=ChoicePoint | transitions+=Transition | refinedTransitions+=RefinedTransition)*)
	 */
	protected void sequence_StateGraph(EObject context, StateGraph semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((states+=State | trPoints+=TrPoint | chPoints+=ChoicePoint | transitions+=Transition | refinedTransitions+=RefinedTransition)*)
	 */
	protected void sequence_StateMachine(EObject context, StateGraph semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     state=[State|ID]
	 */
	protected void sequence_StateTerminal(EObject context, StateTerminal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.STATE_TERMINAL__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.STATE_TERMINAL__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStateTerminalAccess().getStateStateIDTerminalRuleCall_0_1(), semanticObject.getState());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (trPoint=[TrPoint|ID] state=[State|ID])
	 */
	protected void sequence_SubStateTrPointTerminal(EObject context, SubStateTrPointTerminal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.SUB_STATE_TR_POINT_TERMINAL__TR_POINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.SUB_STATE_TR_POINT_TERMINAL__TR_POINT));
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.SUB_STATE_TR_POINT_TERMINAL__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.SUB_STATE_TR_POINT_TERMINAL__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointIDTerminalRuleCall_0_0_1(), semanticObject.getTrPoint());
		feeder.accept(grammarAccess.getSubStateTrPointTerminalAccess().getStateStateIDTerminalRuleCall_2_0_1(), semanticObject.getState());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     trPoint=[TrPoint|ID]
	 */
	protected void sequence_TrPointTerminal(EObject context, TrPointTerminal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FSMPackage.Literals.TR_POINT_TERMINAL__TR_POINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FSMPackage.Literals.TR_POINT_TERMINAL__TR_POINT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTrPointTerminalAccess().getTrPointTrPointIDTerminalRuleCall_1_0_1(), semanticObject.getTrPoint());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (handler?='handler'? name=ID)
	 */
	protected void sequence_TransitionPoint(EObject context, TransitionPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (msgFromIfPairs+=MessageFromIf msgFromIfPairs+=MessageFromIf* guard=Guard?)
	 */
	protected void sequence_Trigger(EObject context, Trigger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         from=TransitionTerminal 
	 *         to=TransitionTerminal 
	 *         docu=Documentation? 
	 *         triggers+=Trigger 
	 *         triggers+=Trigger* 
	 *         action=DetailCode?
	 *     )
	 */
	protected void sequence_TriggeredTransition(EObject context, TriggeredTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
