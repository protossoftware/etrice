/*
* generated by Xtext
*/
package org.eclipse.etrice.core.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.etrice.core.services.ConfigGrammarAccess;

public class ConfigParser extends AbstractContentAssistParser {
	
	@Inject
	private ConfigGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalConfigParser createParser() {
		org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalConfigParser result = new org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalConfigParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getConfigElementAccess().getAlternatives(), "rule__ConfigElement__Alternatives");
					put(grammarAccess.getDynamicConfigAccess().getAlternatives_2_0(), "rule__DynamicConfig__Alternatives_2_0");
					put(grammarAccess.getProtocolClassConfigAccess().getAlternatives_3_1_0(), "rule__ProtocolClassConfig__Alternatives_3_1_0");
					put(grammarAccess.getAttrConfigAccess().getAlternatives(), "rule__AttrConfig__Alternatives");
					put(grammarAccess.getAttrInstanceConfigAccess().getAlternatives_3_1_0_1(), "rule__AttrInstanceConfig__Alternatives_3_1_0_1");
					put(grammarAccess.getConfigValueAccess().getAlternatives(), "rule__ConfigValue__Alternatives");
					put(grammarAccess.getAnnotationTypeAccess().getAlternatives_6(), "rule__AnnotationType__Alternatives_6");
					put(grammarAccess.getAnnotationAttributeAccess().getAlternatives(), "rule__AnnotationAttribute__Alternatives");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0(), "rule__SimpleAnnotationAttribute__Alternatives_0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0(), "rule__EnumAnnotationAttribute__Alternatives_0");
					put(grammarAccess.getImportAccess().getAlternatives_1(), "rule__Import__Alternatives_1");
					put(grammarAccess.getTIMEAccess().getAlternatives(), "rule__TIME__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
					put(grammarAccess.getNumberLiteralAccess().getAlternatives(), "rule__NumberLiteral__Alternatives");
					put(grammarAccess.getIntegerAccess().getAlternatives(), "rule__Integer__Alternatives");
					put(grammarAccess.getIntegerAccess().getAlternatives_0_0(), "rule__Integer__Alternatives_0_0");
					put(grammarAccess.getRealAccess().getAlternatives(), "rule__Real__Alternatives");
					put(grammarAccess.getDecimalAccess().getAlternatives_0(), "rule__Decimal__Alternatives_0");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_0(), "rule__DecimalExp__Alternatives_0");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_4(), "rule__DecimalExp__Alternatives_4");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_5(), "rule__DecimalExp__Alternatives_5");
					put(grammarAccess.getLiteralTypeAccess().getAlternatives(), "rule__LiteralType__Alternatives");
					put(grammarAccess.getConfigModelAccess().getGroup(), "rule__ConfigModel__Group__0");
					put(grammarAccess.getSubSystemConfigAccess().getGroup(), "rule__SubSystemConfig__Group__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup(), "rule__DynamicConfig__Group__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup_2_0_0(), "rule__DynamicConfig__Group_2_0_0__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1(), "rule__DynamicConfig__Group_2_0_1__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_0(), "rule__DynamicConfig__Group_2_0_1_0__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup_2_0_1_1(), "rule__DynamicConfig__Group_2_0_1_1__0");
					put(grammarAccess.getDynamicConfigAccess().getGroup_2_1(), "rule__DynamicConfig__Group_2_1__0");
					put(grammarAccess.getActorClassConfigAccess().getGroup(), "rule__ActorClassConfig__Group__0");
					put(grammarAccess.getActorInstanceConfigAccess().getGroup(), "rule__ActorInstanceConfig__Group__0");
					put(grammarAccess.getProtocolClassConfigAccess().getGroup(), "rule__ProtocolClassConfig__Group__0");
					put(grammarAccess.getProtocolClassConfigAccess().getGroup_3_0(), "rule__ProtocolClassConfig__Group_3_0__0");
					put(grammarAccess.getProtocolClassConfigAccess().getGroup_3_1(), "rule__ProtocolClassConfig__Group_3_1__0");
					put(grammarAccess.getPortClassConfigAccess().getGroup(), "rule__PortClassConfig__Group__0");
					put(grammarAccess.getPortInstanceConfigAccess().getGroup(), "rule__PortInstanceConfig__Group__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup(), "rule__AttrClassConfig__Group__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup_2(), "rule__AttrClassConfig__Group_2__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup_3(), "rule__AttrClassConfig__Group_3__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup_3_1(), "rule__AttrClassConfig__Group_3_1__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_0(), "rule__AttrClassConfig__Group_3_1_0__0");
					put(grammarAccess.getAttrClassConfigAccess().getGroup_3_1_1(), "rule__AttrClassConfig__Group_3_1_1__0");
					put(grammarAccess.getAttrInstanceConfigAccess().getGroup(), "rule__AttrInstanceConfig__Group__0");
					put(grammarAccess.getAttrInstanceConfigAccess().getGroup_2(), "rule__AttrInstanceConfig__Group_2__0");
					put(grammarAccess.getAttrInstanceConfigAccess().getGroup_3(), "rule__AttrInstanceConfig__Group_3__0");
					put(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1(), "rule__AttrInstanceConfig__Group_3_1__0");
					put(grammarAccess.getAttrInstanceConfigAccess().getGroup_3_1_0(), "rule__AttrInstanceConfig__Group_3_1_0__0");
					put(grammarAccess.getConfigValueArrayAccess().getGroup(), "rule__ConfigValueArray__Group__0");
					put(grammarAccess.getConfigValueArrayAccess().getGroup_1(), "rule__ConfigValueArray__Group_1__0");
					put(grammarAccess.getEnumConfigValueAccess().getGroup(), "rule__EnumConfigValue__Group__0");
					put(grammarAccess.getRefPathAccess().getGroup(), "rule__RefPath__Group__0");
					put(grammarAccess.getRefPathAccess().getGroup_1(), "rule__RefPath__Group_1__0");
					put(grammarAccess.getRefSegmentAccess().getGroup(), "rule__RefSegment__Group__0");
					put(grammarAccess.getRefSegmentAccess().getGroup_1(), "rule__RefSegment__Group_1__0");
					put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup_2(), "rule__Annotation__Group_2__0");
					put(grammarAccess.getAnnotationAccess().getGroup_2_2(), "rule__Annotation__Group_2_2__0");
					put(grammarAccess.getKeyValueAccess().getGroup(), "rule__KeyValue__Group__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup(), "rule__AnnotationType__Group__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1(), "rule__AnnotationType__Group_6_1__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1_2(), "rule__AnnotationType__Group_6_1_2__0");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup(), "rule__SimpleAnnotationAttribute__Group__0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup(), "rule__EnumAnnotationAttribute__Group__0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6(), "rule__EnumAnnotationAttribute__Group_6__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getImportAccess().getGroup_1_0(), "rule__Import__Group_1_0__0");
					put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
					put(grammarAccess.getDocumentationAccess().getGroup(), "rule__Documentation__Group__0");
					put(grammarAccess.getTIMEAccess().getGroup_0(), "rule__TIME__Group_0__0");
					put(grammarAccess.getTIMEAccess().getGroup_1(), "rule__TIME__Group_1__0");
					put(grammarAccess.getTIMEAccess().getGroup_2(), "rule__TIME__Group_2__0");
					put(grammarAccess.getTIMEAccess().getGroup_3(), "rule__TIME__Group_3__0");
					put(grammarAccess.getLiteralArrayAccess().getGroup(), "rule__LiteralArray__Group__0");
					put(grammarAccess.getLiteralArrayAccess().getGroup_1(), "rule__LiteralArray__Group_1__0");
					put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
					put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
					put(grammarAccess.getIntLiteralAccess().getGroup(), "rule__IntLiteral__Group__0");
					put(grammarAccess.getStringLiteralAccess().getGroup(), "rule__StringLiteral__Group__0");
					put(grammarAccess.getIntegerAccess().getGroup_0(), "rule__Integer__Group_0__0");
					put(grammarAccess.getDecimalAccess().getGroup(), "rule__Decimal__Group__0");
					put(grammarAccess.getDecimalExpAccess().getGroup(), "rule__DecimalExp__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getConfigModelAccess().getNameAssignment_1(), "rule__ConfigModel__NameAssignment_1");
					put(grammarAccess.getConfigModelAccess().getImportsAssignment_3(), "rule__ConfigModel__ImportsAssignment_3");
					put(grammarAccess.getConfigModelAccess().getConfigElementsAssignment_4(), "rule__ConfigModel__ConfigElementsAssignment_4");
					put(grammarAccess.getSubSystemConfigAccess().getRootAssignment_1(), "rule__SubSystemConfig__RootAssignment_1");
					put(grammarAccess.getSubSystemConfigAccess().getSubSystemAssignment_3(), "rule__SubSystemConfig__SubSystemAssignment_3");
					put(grammarAccess.getSubSystemConfigAccess().getDynConfigAssignment_5(), "rule__SubSystemConfig__DynConfigAssignment_5");
					put(grammarAccess.getDynamicConfigAccess().getFilePathAssignment_2_0_0_1(), "rule__DynamicConfig__FilePathAssignment_2_0_0_1");
					put(grammarAccess.getDynamicConfigAccess().getUserCode1Assignment_2_0_1_0_1(), "rule__DynamicConfig__UserCode1Assignment_2_0_1_0_1");
					put(grammarAccess.getDynamicConfigAccess().getUserCode2Assignment_2_0_1_1_1(), "rule__DynamicConfig__UserCode2Assignment_2_0_1_1_1");
					put(grammarAccess.getDynamicConfigAccess().getPollingAssignment_2_1_1(), "rule__DynamicConfig__PollingAssignment_2_1_1");
					put(grammarAccess.getActorClassConfigAccess().getActorAssignment_1(), "rule__ActorClassConfig__ActorAssignment_1");
					put(grammarAccess.getActorClassConfigAccess().getAttributesAssignment_3(), "rule__ActorClassConfig__AttributesAssignment_3");
					put(grammarAccess.getActorInstanceConfigAccess().getRootAssignment_1(), "rule__ActorInstanceConfig__RootAssignment_1");
					put(grammarAccess.getActorInstanceConfigAccess().getSubSystemAssignment_3(), "rule__ActorInstanceConfig__SubSystemAssignment_3");
					put(grammarAccess.getActorInstanceConfigAccess().getPathAssignment_5(), "rule__ActorInstanceConfig__PathAssignment_5");
					put(grammarAccess.getActorInstanceConfigAccess().getAttributesAssignment_7_0(), "rule__ActorInstanceConfig__AttributesAssignment_7_0");
					put(grammarAccess.getActorInstanceConfigAccess().getPortsAssignment_7_1(), "rule__ActorInstanceConfig__PortsAssignment_7_1");
					put(grammarAccess.getProtocolClassConfigAccess().getProtocolAssignment_1(), "rule__ProtocolClassConfig__ProtocolAssignment_1");
					put(grammarAccess.getProtocolClassConfigAccess().getRegularAssignment_3_0_1(), "rule__ProtocolClassConfig__RegularAssignment_3_0_1");
					put(grammarAccess.getProtocolClassConfigAccess().getConjugatedAssignment_3_1_1(), "rule__ProtocolClassConfig__ConjugatedAssignment_3_1_1");
					put(grammarAccess.getPortClassConfigAccess().getAttributesAssignment_3(), "rule__PortClassConfig__AttributesAssignment_3");
					put(grammarAccess.getPortInstanceConfigAccess().getItemAssignment_1(), "rule__PortInstanceConfig__ItemAssignment_1");
					put(grammarAccess.getPortInstanceConfigAccess().getAttributesAssignment_3(), "rule__PortInstanceConfig__AttributesAssignment_3");
					put(grammarAccess.getAttrClassConfigAccess().getAttributeAssignment_1(), "rule__AttrClassConfig__AttributeAssignment_1");
					put(grammarAccess.getAttrClassConfigAccess().getValueAssignment_2_1(), "rule__AttrClassConfig__ValueAssignment_2_1");
					put(grammarAccess.getAttrClassConfigAccess().getMinAssignment_3_1_0_2(), "rule__AttrClassConfig__MinAssignment_3_1_0_2");
					put(grammarAccess.getAttrClassConfigAccess().getMaxAssignment_3_1_1_2(), "rule__AttrClassConfig__MaxAssignment_3_1_1_2");
					put(grammarAccess.getAttrClassConfigAccess().getAttributesAssignment_3_1_2(), "rule__AttrClassConfig__AttributesAssignment_3_1_2");
					put(grammarAccess.getAttrInstanceConfigAccess().getAttributeAssignment_1(), "rule__AttrInstanceConfig__AttributeAssignment_1");
					put(grammarAccess.getAttrInstanceConfigAccess().getValueAssignment_2_1(), "rule__AttrInstanceConfig__ValueAssignment_2_1");
					put(grammarAccess.getAttrInstanceConfigAccess().getDynConfigAssignment_3_1_0_0(), "rule__AttrInstanceConfig__DynConfigAssignment_3_1_0_0");
					put(grammarAccess.getAttrInstanceConfigAccess().getReadOnlyAssignment_3_1_0_1_0(), "rule__AttrInstanceConfig__ReadOnlyAssignment_3_1_0_1_0");
					put(grammarAccess.getAttrInstanceConfigAccess().getAttributesAssignment_3_1_1(), "rule__AttrInstanceConfig__AttributesAssignment_3_1_1");
					put(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_0(), "rule__ConfigValueArray__ValuesAssignment_0");
					put(grammarAccess.getConfigValueArrayAccess().getValuesAssignment_1_1(), "rule__ConfigValueArray__ValuesAssignment_1_1");
					put(grammarAccess.getLiteralConfigValueAccess().getValueAssignment(), "rule__LiteralConfigValue__ValueAssignment");
					put(grammarAccess.getEnumConfigValueAccess().getTypeAssignment_0(), "rule__EnumConfigValue__TypeAssignment_0");
					put(grammarAccess.getEnumConfigValueAccess().getValueAssignment_2(), "rule__EnumConfigValue__ValueAssignment_2");
					put(grammarAccess.getRefPathAccess().getRefsAssignment_0(), "rule__RefPath__RefsAssignment_0");
					put(grammarAccess.getRefPathAccess().getRefsAssignment_1_1(), "rule__RefPath__RefsAssignment_1_1");
					put(grammarAccess.getRefSegmentAccess().getRefAssignment_0(), "rule__RefSegment__RefAssignment_0");
					put(grammarAccess.getRefSegmentAccess().getIdxAssignment_1_1(), "rule__RefSegment__IdxAssignment_1_1");
					put(grammarAccess.getAnnotationAccess().getTypeAssignment_1(), "rule__Annotation__TypeAssignment_1");
					put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1(), "rule__Annotation__AttributesAssignment_2_1");
					put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1(), "rule__Annotation__AttributesAssignment_2_2_1");
					put(grammarAccess.getKeyValueAccess().getKeyAssignment_0(), "rule__KeyValue__KeyAssignment_0");
					put(grammarAccess.getKeyValueAccess().getValueAssignment_2(), "rule__KeyValue__ValueAssignment_2");
					put(grammarAccess.getAnnotationTypeAccess().getNameAssignment_1(), "rule__AnnotationType__NameAssignment_1");
					put(grammarAccess.getAnnotationTypeAccess().getDocuAssignment_2(), "rule__AnnotationType__DocuAssignment_2");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_0(), "rule__AnnotationType__TargetsAssignment_6_0");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_1(), "rule__AnnotationType__TargetsAssignment_6_1_1");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_2_1(), "rule__AnnotationType__TargetsAssignment_6_1_2_1");
					put(grammarAccess.getAnnotationTypeAccess().getAttributesAssignment_7(), "rule__AnnotationType__AttributesAssignment_7");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2(), "rule__SimpleAnnotationAttribute__NameAssignment_2");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4(), "rule__SimpleAnnotationAttribute__TypeAssignment_4");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__EnumAnnotationAttribute__OptionalAssignment_0_0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2(), "rule__EnumAnnotationAttribute__NameAssignment_2");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5(), "rule__EnumAnnotationAttribute__ValuesAssignment_5");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1(), "rule__EnumAnnotationAttribute__ValuesAssignment_6_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0(), "rule__Import__ImportedNamespaceAssignment_1_0_0");
					put(grammarAccess.getImportAccess().getImportURIAssignment_2(), "rule__Import__ImportURIAssignment_2");
					put(grammarAccess.getDocumentationAccess().getLinesAssignment_2(), "rule__Documentation__LinesAssignment_2");
					put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0(), "rule__LiteralArray__LiteralsAssignment_0");
					put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1(), "rule__LiteralArray__LiteralsAssignment_1_1");
					put(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1(), "rule__BooleanLiteral__IsTrueAssignment_1_1");
					put(grammarAccess.getRealLiteralAccess().getValueAssignment_1(), "rule__RealLiteral__ValueAssignment_1");
					put(grammarAccess.getIntLiteralAccess().getValueAssignment_1(), "rule__IntLiteral__ValueAssignment_1");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment_1(), "rule__StringLiteral__ValueAssignment_1");
					put(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), "rule__DynamicConfig__UnorderedGroup_2");
					put(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), "rule__ActorInstanceConfig__UnorderedGroup_7");
					put(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), "rule__ProtocolClassConfig__UnorderedGroup_3");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalConfigParser typedParser = (org.eclipse.etrice.core.ui.contentassist.antlr.internal.InternalConfigParser) parser;
			typedParser.entryRuleConfigModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ConfigGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ConfigGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
