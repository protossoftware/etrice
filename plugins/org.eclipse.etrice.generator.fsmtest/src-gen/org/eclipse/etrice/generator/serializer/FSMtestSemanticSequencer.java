package org.eclipse.etrice.generator.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.generator.fsmtest.ConditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmDefinition;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.GuardDeclaration;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.Model;
import org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.RandomTest;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;
import org.eclipse.etrice.generator.services.FSMtestGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class FSMtestSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FSMtestGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == FsmtestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FsmtestPackage.CONDITION_DECLARATION:
				if(context == grammarAccess.getConditionDeclarationRule()) {
					sequence_ConditionDeclaration(context, (ConditionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.FSM_DEFINITION:
				if(context == grammarAccess.getFsmDefinitionRule()) {
					sequence_FsmDefinition(context, (FsmDefinition) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.GUARD_DECLARATION:
				if(context == grammarAccess.getGuardDeclarationRule()) {
					sequence_GuardDeclaration(context, (GuardDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.LOOPS_DECLARATION:
				if(context == grammarAccess.getLoopsDeclarationRule()) {
					sequence_LoopsDeclaration(context, (LoopsDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.POSTCONDITION_DECLARATION:
				if(context == grammarAccess.getPostconditionDeclarationRule()) {
					sequence_PostconditionDeclaration(context, (PostconditionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.PRECONDITION_DECLARATION:
				if(context == grammarAccess.getPreconditionDeclarationRule()) {
					sequence_PreconditionDeclaration(context, (PreconditionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.RANDOM_TEST:
				if(context == grammarAccess.getRandomTestRule()) {
					sequence_RandomTest(context, (RandomTest) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.SEED_DECLARATION:
				if(context == grammarAccess.getSeedDeclarationRule()) {
					sequence_SeedDeclaration(context, (SeedDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.SIGNAL_DECLARATION:
				if(context == grammarAccess.getSignalDeclarationRule()) {
					sequence_SignalDeclaration(context, (SignalDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.STATE_DECLARATION:
				if(context == grammarAccess.getStateDeclarationRule()) {
					sequence_StateDeclaration(context, (StateDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.TRANSITION_DECLARATION:
				if(context == grammarAccess.getTransitionDeclarationRule()) {
					sequence_TransitionDeclaration(context, (TransitionDeclaration) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     signal=SignalDeclaration
	 */
	protected void sequence_ConditionDeclaration(EObject context, ConditionDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.CONDITION_DECLARATION__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.CONDITION_DECLARATION__SIGNAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0(), semanticObject.getSignal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID states+=StateDeclaration states+=StateDeclaration*)
	 */
	protected void sequence_FsmDefinition(EObject context, FsmDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     signal=SignalDeclaration
	 */
	protected void sequence_GuardDeclaration(EObject context, GuardDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.GUARD_DECLARATION__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.GUARD_DECLARATION__SIGNAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGuardDeclarationAccess().getSignalSignalDeclarationParserRuleCall_0(), semanticObject.getSignal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_LoopsDeclaration(EObject context, LoopsDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.LOOPS_DECLARATION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.LOOPS_DECLARATION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLoopsDeclarationAccess().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (FsmDefinitions+=FsmDefinition | RandomTests+=RandomTest)*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     signal=SignalDeclaration
	 */
	protected void sequence_PostconditionDeclaration(EObject context, PostconditionDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.POSTCONDITION_DECLARATION__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.POSTCONDITION_DECLARATION__SIGNAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPostconditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0(), semanticObject.getSignal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     signal=SignalDeclaration
	 */
	protected void sequence_PreconditionDeclaration(EObject context, PreconditionDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.PRECONDITION_DECLARATION__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.PRECONDITION_DECLARATION__SIGNAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPreconditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0(), semanticObject.getSignal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID fsm=[FsmDefinition|ID] loopsDeclaration=LoopsDeclaration seedDeclaration=SeedDeclaration?)
	 */
	protected void sequence_RandomTest(EObject context, RandomTest semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_SeedDeclaration(EObject context, SeedDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.SEED_DECLARATION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.SEED_DECLARATION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSeedDeclarationAccess().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (port=ID? signame=ID (intVal=INT | strVal=STRING)?)
	 */
	protected void sequence_SignalDeclaration(EObject context, SignalDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID condition+=ConditionDeclaration* transitions+=TransitionDeclaration+)
	 */
	protected void sequence_StateDeclaration(EObject context, StateDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         destination=[StateDeclaration|ID] 
	 *         trigger=SignalDeclaration? 
	 *         triggers+=GuardDeclaration* 
	 *         (precondition+=PreconditionDeclaration | postcondition+=PostconditionDeclaration)*
	 *     )
	 */
	protected void sequence_TransitionDeclaration(EObject context, TransitionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
