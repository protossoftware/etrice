package org.eclipse.etrice.core.common.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.LiteralArray;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
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
public class BaseSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BaseGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BasePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BasePackage.BOOLEAN_LITERAL:
				if(context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getLiteralRule()) {
					sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
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
			case BasePackage.STRING_LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getStringLiteralRule()) {
					sequence_StringLiteral(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (isTrue?='true'?)
	 */
	protected void sequence_BooleanLiteral(EObject context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Integer
	 */
	protected void sequence_IntLiteral(EObject context, IntLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, BasePackage.Literals.INT_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BasePackage.Literals.INT_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (literals+=Literal literals+=Literal*)
	 */
	protected void sequence_LiteralArray(EObject context, LiteralArray semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Real
	 */
	protected void sequence_RealLiteral(EObject context, RealLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, BasePackage.Literals.REAL_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BasePackage.Literals.REAL_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringLiteral(EObject context, StringLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, BasePackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BasePackage.Literals.STRING_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
}
