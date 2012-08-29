package org.eclipse.etrice.generator.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.generator.fsmtest.DestinationDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.InitialDeclaration;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.Model;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.SourceDeclaration;
import org.eclipse.etrice.generator.fsmtest.State;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.Testscript;
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
			case FsmtestPackage.DESTINATION_DECLARATION:
				if(context == grammarAccess.getDestinationDeclarationRule()) {
					sequence_DestinationDeclaration(context, (DestinationDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.INITIAL_DECLARATION:
				if(context == grammarAccess.getInitialDeclarationRule()) {
					sequence_InitialDeclaration(context, (InitialDeclaration) semanticObject); 
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
			case FsmtestPackage.SOURCE_DECLARATION:
				if(context == grammarAccess.getSourceDeclarationRule()) {
					sequence_SourceDeclaration(context, (SourceDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.STATE:
				if(context == grammarAccess.getStateRule()) {
					sequence_State(context, (State) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.STATE_DECLARATION:
				if(context == grammarAccess.getStateDeclarationRule()) {
					sequence_StateDeclaration(context, (StateDeclaration) semanticObject); 
					return; 
				}
				else break;
			case FsmtestPackage.TESTSCRIPT:
				if(context == grammarAccess.getTestscriptRule()) {
					sequence_Testscript(context, (Testscript) semanticObject); 
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
	 *     ref=[State|ID]
	 */
	protected void sequence_DestinationDeclaration(EObject context, DestinationDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.DESTINATION_DECLARATION__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.DESTINATION_DECLARATION__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDestinationDeclarationAccess().getRefStateIDTerminalRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     initial=[State|ID]
	 */
	protected void sequence_InitialDeclaration(EObject context, InitialDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.INITIAL_DECLARATION__INITIAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.INITIAL_DECLARATION__INITIAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInitialDeclarationAccess().getInitialStateIDTerminalRuleCall_1_0_1(), semanticObject.getInitial());
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
	 *     Testscripts+=Testscript*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
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
	 *     ref=[State|ID]
	 */
	protected void sequence_SourceDeclaration(EObject context, SourceDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.SOURCE_DECLARATION__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.SOURCE_DECLARATION__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSourceDeclarationAccess().getRefStateIDTerminalRuleCall_0_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (states+=State states+=State*)
	 */
	protected void sequence_StateDeclaration(EObject context, StateDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_State(EObject context, State semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FsmtestPackage.Literals.STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FsmtestPackage.Literals.STATE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         stateDeclaration=StateDeclaration 
	 *         initialDeclaration=InitialDeclaration 
	 *         loopsDeclaration=LoopsDeclaration 
	 *         seedDeclaration=SeedDeclaration? 
	 *         transitionDeclarations+=TransitionDeclaration*
	 *     )
	 */
	protected void sequence_Testscript(EObject context, Testscript semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (source=SourceDeclaration in+=SignalDeclaration* out+=SignalDeclaration* destination=DestinationDeclaration)
	 */
	protected void sequence_TransitionDeclaration(EObject context, TransitionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
