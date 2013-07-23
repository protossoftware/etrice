package org.eclipse.etrice.core.etmap.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.Import;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.etmap.services.ETMapGrammarAccess;
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
public class ETMapSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ETMapGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ETMapPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ETMapPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case ETMapPackage.MAPPING:
				if(context == grammarAccess.getMappingRule()) {
					sequence_Mapping(context, (Mapping) semanticObject); 
					return; 
				}
				else break;
			case ETMapPackage.MAPPING_MODEL:
				if(context == grammarAccess.getMappingModelRule()) {
					sequence_MappingModel(context, (MappingModel) semanticObject); 
					return; 
				}
				else break;
			case ETMapPackage.SUB_SYSTEM_MAPPING:
				if(context == grammarAccess.getSubSystemMappingRule()) {
					sequence_SubSystemMapping(context, (SubSystemMapping) semanticObject); 
					return; 
				}
				else break;
			case ETMapPackage.THREAD_MAPPING:
				if(context == grammarAccess.getThreadMappingRule()) {
					sequence_ThreadMapping(context, (ThreadMapping) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (importedNamespace=ImportedFQN? importURI=STRING)
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=FQN imports+=Import* mappings+=Mapping*)
	 */
	protected void sequence_MappingModel(EObject context, MappingModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logicalSys=[LogicalSystem|FQN] physicalSys=[PhysicalSystem|FQN] subsysMappings+=SubSystemMapping*)
	 */
	protected void sequence_Mapping(EObject context, Mapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logicalSubSys=[SubSystemRef|ID] node=[NodeRef|ID] threadMappings+=ThreadMapping*)
	 */
	protected void sequence_SubSystemMapping(EObject context, SubSystemMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logicalThread=[LogicalThread|ID] physicalThread=[PhysicalThread|ID])
	 */
	protected void sequence_ThreadMapping(EObject context, ThreadMapping semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ETMapPackage.Literals.THREAD_MAPPING__LOGICAL_THREAD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ETMapPackage.Literals.THREAD_MAPPING__LOGICAL_THREAD));
			if(transientValues.isValueTransient(semanticObject, ETMapPackage.Literals.THREAD_MAPPING__PHYSICAL_THREAD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ETMapPackage.Literals.THREAD_MAPPING__PHYSICAL_THREAD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1(), semanticObject.getLogicalThread());
		feeder.accept(grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1(), semanticObject.getPhysicalThread());
		feeder.finish();
	}
}
