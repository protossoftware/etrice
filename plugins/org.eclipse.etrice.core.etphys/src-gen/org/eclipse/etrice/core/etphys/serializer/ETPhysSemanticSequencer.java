package org.eclipse.etrice.core.etphys.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etphys.eTPhys.Documentation;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.Import;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class ETPhysSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ETPhysGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ETPhysPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ETPhysPackage.DOCUMENTATION:
				if(context == grammarAccess.getDocumentationRule()) {
					sequence_Documentation(context, (Documentation) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.NODE_CLASS:
				if(context == grammarAccess.getNodeClassRule()) {
					sequence_NodeClass(context, (NodeClass) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.NODE_REF:
				if(context == grammarAccess.getNodeRefRule()) {
					sequence_NodeRef(context, (NodeRef) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.PHYSICAL_MODEL:
				if(context == grammarAccess.getPhysicalModelRule()) {
					sequence_PhysicalModel(context, (PhysicalModel) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.PHYSICAL_SYSTEM:
				if(context == grammarAccess.getPhysicalSystemRule()) {
					sequence_PhysicalSystem(context, (PhysicalSystem) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.RUNTIME_CLASS:
				if(context == grammarAccess.getRuntimeClassRule()) {
					sequence_RuntimeClass(context, (RuntimeClass) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.THREAD:
				if(context == grammarAccess.getThreadRule()) {
					sequence_Thread(context, (org.eclipse.etrice.core.etphys.eTPhys.Thread) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     text+=STRING+
	 */
	protected void sequence_Documentation(EObject context, Documentation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     (name=ID docu=Documentation? runtime=[RuntimeClass|FQN] threads+=Thread*)
	 */
	protected void sequence_NodeClass(EObject context, NodeClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=[NodeClass|FQN] docu=Documentation?)
	 */
	protected void sequence_NodeRef(EObject context, NodeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=FQN imports+=Import* (systems+=PhysicalSystem | nodeClasses+=NodeClass | runtimeClasses+=RuntimeClass)*)
	 */
	protected void sequence_PhysicalModel(EObject context, PhysicalModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? nodeRefs+=NodeRef*)
	 */
	protected void sequence_PhysicalSystem(EObject context, PhysicalSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? threadModel=ThreadModel)
	 */
	protected void sequence_RuntimeClass(EObject context, RuntimeClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (default?='DefaultThread'? name=ID execmode=ExecMode prio=PRIO? stacksize=INT?)
	 */
	protected void sequence_Thread(EObject context, org.eclipse.etrice.core.etphys.eTPhys.Thread semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
