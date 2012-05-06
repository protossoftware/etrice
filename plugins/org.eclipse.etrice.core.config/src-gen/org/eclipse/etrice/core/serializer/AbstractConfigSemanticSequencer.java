package org.eclipse.etrice.core.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.services.ConfigGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractConfigSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ConfigGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ConfigPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ConfigPackage.ACTOR_CLASS_CONFIG:
				if(context == grammarAccess.getActorClassConfigRule()) {
					sequence_ActorClassConfig(context, (ActorClassConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.CONFIG_MODEL:
				if(context == grammarAccess.getConfigModelRule()) {
					sequence_ConfigModel(context, (ConfigModel) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     actorClass=[ActorClass|ID]
	 */
	protected void sequence_ActorClassConfig(EObject context, ActorClassConfig semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.ACTOR_CLASS_CONFIG__ACTOR_CLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.ACTOR_CLASS_CONFIG__ACTOR_CLASS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getActorClassConfigAccess().getActorClassActorClassIDTerminalRuleCall_1_0_1(), semanticObject.getActorClass());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (actorClassConfigs+=ActorClassConfig* actorInstanceConfigs+=ActorInstanceConfig*)
	 */
	protected void sequence_ConfigModel(EObject context, ConfigModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
