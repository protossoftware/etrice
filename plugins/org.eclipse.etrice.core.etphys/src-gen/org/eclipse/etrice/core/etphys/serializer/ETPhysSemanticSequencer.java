package org.eclipse.etrice.core.etphys.serializer;

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
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class ETPhysSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private ETPhysGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == ETPhysPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
			case ETPhysPackage.PHYSICAL_THREAD:
				if(context == grammarAccess.getPhysicalThreadRule()) {
					sequence_PhysicalThread(context, (PhysicalThread) semanticObject); 
					return; 
				}
				else break;
			case ETPhysPackage.RUNTIME_CLASS:
				if(context == grammarAccess.getRuntimeClassRule()) {
					sequence_RuntimeClass(context, (RuntimeClass) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         docu=Documentation? 
	 *         runtime=[RuntimeClass|FQN] 
	 *         priomin=PRIO 
	 *         priomax=PRIO 
	 *         threads+=PhysicalThread*
	 *     )
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
	 *     (
	 *         default?='DefaultThread'? 
	 *         name=ID 
	 *         execmode=ExecMode 
	 *         time=TIME? 
	 *         prio=PRIO 
	 *         stacksize=INT 
	 *         msgblocksize=INT 
	 *         msgpoolsize=INT
	 *     )
	 */
	protected void sequence_PhysicalThread(EObject context, PhysicalThread semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID docu=Documentation? threadModel=ThreadModel)
	 */
	protected void sequence_RuntimeClass(EObject context, RuntimeClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
