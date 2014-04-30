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
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.LiteralArray;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.common.serializer.BaseSemanticSequencer;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.ConfigValueArray;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.EnumConfigValue;
import org.eclipse.etrice.core.config.Import;
import org.eclipse.etrice.core.config.LiteralConfigValue;
import org.eclipse.etrice.core.config.PortClassConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.RefSegment;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.services.ConfigGrammarAccess;
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
public class ConfigSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private ConfigGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == ConfigPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ConfigPackage.ACTOR_CLASS_CONFIG:
				if(context == grammarAccess.getActorClassConfigRule() ||
				   context == grammarAccess.getConfigElementRule()) {
					sequence_ActorClassConfig(context, (ActorClassConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.ACTOR_INSTANCE_CONFIG:
				if(context == grammarAccess.getActorInstanceConfigRule() ||
				   context == grammarAccess.getConfigElementRule()) {
					sequence_ActorInstanceConfig(context, (ActorInstanceConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.ATTR_CLASS_CONFIG:
				if(context == grammarAccess.getAttrClassConfigRule() ||
				   context == grammarAccess.getAttrConfigRule()) {
					sequence_AttrClassConfig(context, (AttrClassConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.ATTR_INSTANCE_CONFIG:
				if(context == grammarAccess.getAttrConfigRule() ||
				   context == grammarAccess.getAttrInstanceConfigRule()) {
					sequence_AttrInstanceConfig(context, (AttrInstanceConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.CONFIG_MODEL:
				if(context == grammarAccess.getConfigModelRule()) {
					sequence_ConfigModel(context, (ConfigModel) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.CONFIG_VALUE_ARRAY:
				if(context == grammarAccess.getConfigValueArrayRule()) {
					sequence_ConfigValueArray(context, (ConfigValueArray) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.DYNAMIC_CONFIG:
				if(context == grammarAccess.getDynamicConfigRule()) {
					sequence_DynamicConfig(context, (DynamicConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.ENUM_CONFIG_VALUE:
				if(context == grammarAccess.getConfigValueRule() ||
				   context == grammarAccess.getEnumConfigValueRule()) {
					sequence_EnumConfigValue(context, (EnumConfigValue) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.LITERAL_CONFIG_VALUE:
				if(context == grammarAccess.getConfigValueRule() ||
				   context == grammarAccess.getLiteralConfigValueRule()) {
					sequence_LiteralConfigValue(context, (LiteralConfigValue) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.PORT_CLASS_CONFIG:
				if(context == grammarAccess.getPortClassConfigRule()) {
					sequence_PortClassConfig(context, (PortClassConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.PORT_INSTANCE_CONFIG:
				if(context == grammarAccess.getPortInstanceConfigRule()) {
					sequence_PortInstanceConfig(context, (PortInstanceConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.PROTOCOL_CLASS_CONFIG:
				if(context == grammarAccess.getConfigElementRule() ||
				   context == grammarAccess.getProtocolClassConfigRule()) {
					sequence_ProtocolClassConfig(context, (ProtocolClassConfig) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.REF_PATH:
				if(context == grammarAccess.getRefPathRule()) {
					sequence_RefPath(context, (RefPath) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.REF_SEGMENT:
				if(context == grammarAccess.getRefSegmentRule()) {
					sequence_RefSegment(context, (RefSegment) semanticObject); 
					return; 
				}
				else break;
			case ConfigPackage.SUB_SYSTEM_CONFIG:
				if(context == grammarAccess.getConfigElementRule() ||
				   context == grammarAccess.getSubSystemConfigRule()) {
					sequence_SubSystemConfig(context, (SubSystemConfig) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (actor=[ActorClass|FQN] attributes+=AttrClassConfig*)
	 */
	protected void sequence_ActorClassConfig(EObject context, ActorClassConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (root=[LogicalSystem|FQN] subSystem=[SubSystemRef|ID] path=RefPath attributes+=AttrInstanceConfig* ports+=PortInstanceConfig*)
	 */
	protected void sequence_ActorInstanceConfig(EObject context, ActorInstanceConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attribute=[Attribute|ID] value=ConfigValueArray? (min=NumberLiteral? max=NumberLiteral? attributes+=AttrClassConfig*)?)
	 */
	protected void sequence_AttrClassConfig(EObject context, AttrClassConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attribute=[Attribute|ID] value=ConfigValueArray? ((dynConfig?='dynamic configuration' readOnly?='read'?)? attributes+=AttrInstanceConfig*)?)
	 */
	protected void sequence_AttrInstanceConfig(EObject context, AttrInstanceConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=FQN imports+=Import* configElements+=ConfigElement*)
	 */
	protected void sequence_ConfigModel(EObject context, ConfigModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=ConfigValue values+=ConfigValue*)
	 */
	protected void sequence_ConfigValueArray(EObject context, ConfigValueArray semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((filePath=STRING | (userCode1=STRING userCode2=STRING)) polling=TIME?)
	 */
	protected void sequence_DynamicConfig(EObject context, DynamicConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[EnumerationType|ID] value=[EnumLiteral|ID])
	 */
	protected void sequence_EnumConfigValue(EObject context, EnumConfigValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.ENUM_CONFIG_VALUE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.ENUM_CONFIG_VALUE__TYPE));
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.ENUM_CONFIG_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.ENUM_CONFIG_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeIDTerminalRuleCall_0_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralIDTerminalRuleCall_2_0_1(), semanticObject.getValue());
		feeder.finish();
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
	 *     value=Literal
	 */
	protected void sequence_LiteralConfigValue(EObject context, LiteralConfigValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.LITERAL_CONFIG_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.LITERAL_CONFIG_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralConfigValueAccess().getValueLiteralParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (attributes+=AttrClassConfig*)
	 */
	protected void sequence_PortClassConfig(EObject context, PortClassConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (item=[InterfaceItem|ID] attributes+=AttrInstanceConfig*)
	 */
	protected void sequence_PortInstanceConfig(EObject context, PortInstanceConfig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (protocol=[ProtocolClass|FQN] regular=PortClassConfig? conjugated=PortClassConfig?)
	 */
	protected void sequence_ProtocolClassConfig(EObject context, ProtocolClassConfig semanticObject) {
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
	 *     (ref=ID idx=INT?)
	 */
	protected void sequence_RefSegment(EObject context, RefSegment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (root=[LogicalSystem|FQN] subSystem=[SubSystemRef|ID] dynConfig=DynamicConfig)
	 */
	protected void sequence_SubSystemConfig(EObject context, SubSystemConfig semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__ROOT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__ROOT));
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__SUB_SYSTEM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__SUB_SYSTEM));
			if(transientValues.isValueTransient(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__DYN_CONFIG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ConfigPackage.Literals.SUB_SYSTEM_CONFIG__DYN_CONFIG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemFQNParserRuleCall_1_0_1(), semanticObject.getRoot());
		feeder.accept(grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefIDTerminalRuleCall_3_0_1(), semanticObject.getSubSystem());
		feeder.accept(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_5_0(), semanticObject.getDynConfig());
		feeder.finish();
	}
}
