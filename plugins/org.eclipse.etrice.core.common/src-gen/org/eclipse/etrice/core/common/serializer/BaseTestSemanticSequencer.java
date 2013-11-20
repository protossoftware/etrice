package org.eclipse.etrice.core.common.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.LiteralArray;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.common.basetest.BaseModel;
import org.eclipse.etrice.core.common.basetest.BasetestPackage;
import org.eclipse.etrice.core.common.serializer.BaseSemanticSequencer;
import org.eclipse.etrice.core.common.services.BaseTestGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class BaseTestSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private BaseTestGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == BasetestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BasetestPackage.BASE_MODEL:
				if(context == grammarAccess.getBaseModelRule()) {
					sequence_BaseModel(context, (BaseModel) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (elements+=Annotation | elements+=AnnotationType)*
	 */
	protected void sequence_BaseModel(EObject context, BaseModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
