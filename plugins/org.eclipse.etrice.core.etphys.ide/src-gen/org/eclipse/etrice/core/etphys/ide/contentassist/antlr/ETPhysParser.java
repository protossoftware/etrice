/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etphys.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.etrice.core.etphys.ide.contentassist.antlr.internal.InternalETPhysParser;
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ETPhysParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ETPhysGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ETPhysGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPhysicalModelAccess().getAlternatives_4(), "rule__PhysicalModel__Alternatives_4");
			builder.put(grammarAccess.getPhysicalThreadAccess().getAlternatives_0(), "rule__PhysicalThread__Alternatives_0");
			builder.put(grammarAccess.getAnnotationTypeAccess().getAlternatives_6(), "rule__AnnotationType__Alternatives_6");
			builder.put(grammarAccess.getAnnotationAttributeAccess().getAlternatives(), "rule__AnnotationAttribute__Alternatives");
			builder.put(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0(), "rule__SimpleAnnotationAttribute__Alternatives_0");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0(), "rule__EnumAnnotationAttribute__Alternatives_0");
			builder.put(grammarAccess.getImportAccess().getAlternatives_1(), "rule__Import__Alternatives_1");
			builder.put(grammarAccess.getTIMEAccess().getAlternatives(), "rule__TIME__Alternatives");
			builder.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getNumberLiteralAccess().getAlternatives(), "rule__NumberLiteral__Alternatives");
			builder.put(grammarAccess.getIntegerAccess().getAlternatives(), "rule__Integer__Alternatives");
			builder.put(grammarAccess.getIntegerAccess().getAlternatives_0_0(), "rule__Integer__Alternatives_0_0");
			builder.put(grammarAccess.getRealAccess().getAlternatives(), "rule__Real__Alternatives");
			builder.put(grammarAccess.getDecimalAccess().getAlternatives_0(), "rule__Decimal__Alternatives_0");
			builder.put(grammarAccess.getDecimalExpAccess().getAlternatives_0(), "rule__DecimalExp__Alternatives_0");
			builder.put(grammarAccess.getDecimalExpAccess().getAlternatives_4(), "rule__DecimalExp__Alternatives_4");
			builder.put(grammarAccess.getDecimalExpAccess().getAlternatives_5(), "rule__DecimalExp__Alternatives_5");
			builder.put(grammarAccess.getExecModeAccess().getAlternatives(), "rule__ExecMode__Alternatives");
			builder.put(grammarAccess.getThreadModelAccess().getAlternatives(), "rule__ThreadModel__Alternatives");
			builder.put(grammarAccess.getLiteralTypeAccess().getAlternatives(), "rule__LiteralType__Alternatives");
			builder.put(grammarAccess.getPhysicalModelAccess().getGroup(), "rule__PhysicalModel__Group__0");
			builder.put(grammarAccess.getPhysicalSystemAccess().getGroup(), "rule__PhysicalSystem__Group__0");
			builder.put(grammarAccess.getNodeRefAccess().getGroup(), "rule__NodeRef__Group__0");
			builder.put(grammarAccess.getNodeClassAccess().getGroup(), "rule__NodeClass__Group__0");
			builder.put(grammarAccess.getNodeClassAccess().getGroup_4_0(), "rule__NodeClass__Group_4_0__0");
			builder.put(grammarAccess.getNodeClassAccess().getGroup_4_1(), "rule__NodeClass__Group_4_1__0");
			builder.put(grammarAccess.getNodeClassAccess().getGroup_4_2(), "rule__NodeClass__Group_4_2__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup(), "rule__PhysicalThread__Group__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_0(), "rule__PhysicalThread__Group_3_0__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_1(), "rule__PhysicalThread__Group_3_1__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_2(), "rule__PhysicalThread__Group_3_2__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_3(), "rule__PhysicalThread__Group_3_3__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_4(), "rule__PhysicalThread__Group_3_4__0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getGroup_3_5(), "rule__PhysicalThread__Group_3_5__0");
			builder.put(grammarAccess.getRuntimeClassAccess().getGroup(), "rule__RuntimeClass__Group__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup_2(), "rule__Annotation__Group_2__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup_2_2(), "rule__Annotation__Group_2_2__0");
			builder.put(grammarAccess.getKeyValueAccess().getGroup(), "rule__KeyValue__Group__0");
			builder.put(grammarAccess.getAnnotationTypeAccess().getGroup(), "rule__AnnotationType__Group__0");
			builder.put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1(), "rule__AnnotationType__Group_6_1__0");
			builder.put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1_2(), "rule__AnnotationType__Group_6_1_2__0");
			builder.put(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup(), "rule__SimpleAnnotationAttribute__Group__0");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup(), "rule__EnumAnnotationAttribute__Group__0");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6(), "rule__EnumAnnotationAttribute__Group_6__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup_1_0(), "rule__Import__Group_1_0__0");
			builder.put(grammarAccess.getImportAccess().getGroup_1_0_1(), "rule__Import__Group_1_0_1__0");
			builder.put(grammarAccess.getImportAccess().getGroup_1_1(), "rule__Import__Group_1_1__0");
			builder.put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
			builder.put(grammarAccess.getDocumentationAccess().getGroup(), "rule__Documentation__Group__0");
			builder.put(grammarAccess.getTIMEAccess().getGroup_0(), "rule__TIME__Group_0__0");
			builder.put(grammarAccess.getTIMEAccess().getGroup_1(), "rule__TIME__Group_1__0");
			builder.put(grammarAccess.getTIMEAccess().getGroup_2(), "rule__TIME__Group_2__0");
			builder.put(grammarAccess.getTIMEAccess().getGroup_3(), "rule__TIME__Group_3__0");
			builder.put(grammarAccess.getLiteralArrayAccess().getGroup(), "rule__LiteralArray__Group__0");
			builder.put(grammarAccess.getLiteralArrayAccess().getGroup_1(), "rule__LiteralArray__Group_1__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
			builder.put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
			builder.put(grammarAccess.getIntLiteralAccess().getGroup(), "rule__IntLiteral__Group__0");
			builder.put(grammarAccess.getStringLiteralAccess().getGroup(), "rule__StringLiteral__Group__0");
			builder.put(grammarAccess.getIntegerAccess().getGroup_0(), "rule__Integer__Group_0__0");
			builder.put(grammarAccess.getDecimalAccess().getGroup(), "rule__Decimal__Group__0");
			builder.put(grammarAccess.getDecimalExpAccess().getGroup(), "rule__DecimalExp__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getPhysicalModelAccess().getNameAssignment_1(), "rule__PhysicalModel__NameAssignment_1");
			builder.put(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3(), "rule__PhysicalModel__ImportsAssignment_3");
			builder.put(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0(), "rule__PhysicalModel__SystemsAssignment_4_0");
			builder.put(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1(), "rule__PhysicalModel__NodeClassesAssignment_4_1");
			builder.put(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2(), "rule__PhysicalModel__RuntimeClassesAssignment_4_2");
			builder.put(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1(), "rule__PhysicalSystem__NameAssignment_1");
			builder.put(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2(), "rule__PhysicalSystem__DocuAssignment_2");
			builder.put(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4(), "rule__PhysicalSystem__NodeRefsAssignment_4");
			builder.put(grammarAccess.getNodeRefAccess().getNameAssignment_1(), "rule__NodeRef__NameAssignment_1");
			builder.put(grammarAccess.getNodeRefAccess().getTypeAssignment_3(), "rule__NodeRef__TypeAssignment_3");
			builder.put(grammarAccess.getNodeRefAccess().getDocuAssignment_4(), "rule__NodeRef__DocuAssignment_4");
			builder.put(grammarAccess.getNodeClassAccess().getNameAssignment_1(), "rule__NodeClass__NameAssignment_1");
			builder.put(grammarAccess.getNodeClassAccess().getDocuAssignment_2(), "rule__NodeClass__DocuAssignment_2");
			builder.put(grammarAccess.getNodeClassAccess().getRuntimeAssignment_4_0_2(), "rule__NodeClass__RuntimeAssignment_4_0_2");
			builder.put(grammarAccess.getNodeClassAccess().getPriominAssignment_4_1_2(), "rule__NodeClass__PriominAssignment_4_1_2");
			builder.put(grammarAccess.getNodeClassAccess().getPriomaxAssignment_4_2_2(), "rule__NodeClass__PriomaxAssignment_4_2_2");
			builder.put(grammarAccess.getNodeClassAccess().getThreadsAssignment_5(), "rule__NodeClass__ThreadsAssignment_5");
			builder.put(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0(), "rule__PhysicalThread__DefaultAssignment_0_0");
			builder.put(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1(), "rule__PhysicalThread__NameAssignment_1");
			builder.put(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_3_0_2(), "rule__PhysicalThread__ExecmodeAssignment_3_0_2");
			builder.put(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_3_1_2(), "rule__PhysicalThread__TimeAssignment_3_1_2");
			builder.put(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_3_2_2(), "rule__PhysicalThread__PrioAssignment_3_2_2");
			builder.put(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_3_3_2(), "rule__PhysicalThread__StacksizeAssignment_3_3_2");
			builder.put(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_3_4_2(), "rule__PhysicalThread__MsgblocksizeAssignment_3_4_2");
			builder.put(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_3_5_2(), "rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2");
			builder.put(grammarAccess.getRuntimeClassAccess().getNameAssignment_1(), "rule__RuntimeClass__NameAssignment_1");
			builder.put(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2(), "rule__RuntimeClass__DocuAssignment_2");
			builder.put(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6(), "rule__RuntimeClass__ThreadModelAssignment_6");
			builder.put(grammarAccess.getAnnotationAccess().getTypeAssignment_1(), "rule__Annotation__TypeAssignment_1");
			builder.put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1(), "rule__Annotation__AttributesAssignment_2_1");
			builder.put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1(), "rule__Annotation__AttributesAssignment_2_2_1");
			builder.put(grammarAccess.getKeyValueAccess().getKeyAssignment_0(), "rule__KeyValue__KeyAssignment_0");
			builder.put(grammarAccess.getKeyValueAccess().getValueAssignment_2(), "rule__KeyValue__ValueAssignment_2");
			builder.put(grammarAccess.getAnnotationTypeAccess().getNameAssignment_1(), "rule__AnnotationType__NameAssignment_1");
			builder.put(grammarAccess.getAnnotationTypeAccess().getDocuAssignment_2(), "rule__AnnotationType__DocuAssignment_2");
			builder.put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_0(), "rule__AnnotationType__TargetsAssignment_6_0");
			builder.put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_1(), "rule__AnnotationType__TargetsAssignment_6_1_1");
			builder.put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_2_1(), "rule__AnnotationType__TargetsAssignment_6_1_2_1");
			builder.put(grammarAccess.getAnnotationTypeAccess().getAttributesAssignment_7(), "rule__AnnotationType__AttributesAssignment_7");
			builder.put(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0");
			builder.put(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2(), "rule__SimpleAnnotationAttribute__NameAssignment_2");
			builder.put(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4(), "rule__SimpleAnnotationAttribute__TypeAssignment_4");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__EnumAnnotationAttribute__OptionalAssignment_0_0");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2(), "rule__EnumAnnotationAttribute__NameAssignment_2");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5(), "rule__EnumAnnotationAttribute__ValuesAssignment_5");
			builder.put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1(), "rule__EnumAnnotationAttribute__ValuesAssignment_6_1");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0(), "rule__Import__ImportedNamespaceAssignment_1_0_0");
			builder.put(grammarAccess.getImportAccess().getImportURIAssignment_1_0_1_1(), "rule__Import__ImportURIAssignment_1_0_1_1");
			builder.put(grammarAccess.getImportAccess().getImportURIAssignment_1_1_1(), "rule__Import__ImportURIAssignment_1_1_1");
			builder.put(grammarAccess.getDocumentationAccess().getLinesAssignment_2(), "rule__Documentation__LinesAssignment_2");
			builder.put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0(), "rule__LiteralArray__LiteralsAssignment_0");
			builder.put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1(), "rule__LiteralArray__LiteralsAssignment_1_1");
			builder.put(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1(), "rule__BooleanLiteral__IsTrueAssignment_1_1");
			builder.put(grammarAccess.getRealLiteralAccess().getValueAssignment_1(), "rule__RealLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getIntLiteralAccess().getValueAssignment_1(), "rule__IntLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getStringLiteralAccess().getValueAssignment_1(), "rule__StringLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), "rule__NodeClass__UnorderedGroup_4");
			builder.put(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), "rule__PhysicalThread__UnorderedGroup_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ETPhysGrammarAccess grammarAccess;

	@Override
	protected InternalETPhysParser createParser() {
		InternalETPhysParser result = new InternalETPhysParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ETPhysGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ETPhysGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
