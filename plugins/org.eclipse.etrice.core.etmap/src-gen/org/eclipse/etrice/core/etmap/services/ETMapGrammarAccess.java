/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etmap.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ETMapGrammarAccess extends AbstractGrammarElementFinder {
	
	public class MappingModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.etrice.core.etmap.ETMap.MappingModel");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMappingModelKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameFQNParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cImportsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cImportsImportParserRuleCall_3_0 = (RuleCall)cImportsAssignment_3.eContents().get(0);
		private final Assignment cMappingsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMappingsMappingParserRuleCall_4_0 = (RuleCall)cMappingsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//MappingModel:
		//	'MappingModel' name=FQN '{'
		//	imports+=Import*
		//	mappings+=Mapping*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'MappingModel' name=FQN '{' imports+=Import* mappings+=Mapping* '}'
		public Group getGroup() { return cGroup; }
		
		//'MappingModel'
		public Keyword getMappingModelKeyword_0() { return cMappingModelKeyword_0; }
		
		//name=FQN
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//FQN
		public RuleCall getNameFQNParserRuleCall_1_0() { return cNameFQNParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//imports+=Import*
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }
		
		//Import
		public RuleCall getImportsImportParserRuleCall_3_0() { return cImportsImportParserRuleCall_3_0; }
		
		//mappings+=Mapping*
		public Assignment getMappingsAssignment_4() { return cMappingsAssignment_4; }
		
		//Mapping
		public RuleCall getMappingsMappingParserRuleCall_4_0() { return cMappingsMappingParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class MappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.etrice.core.etmap.ETMap.Mapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMappingKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLogicalSysAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cLogicalSysLogicalSystemCrossReference_1_0 = (CrossReference)cLogicalSysAssignment_1.eContents().get(0);
		private final RuleCall cLogicalSysLogicalSystemFQNParserRuleCall_1_0_1 = (RuleCall)cLogicalSysLogicalSystemCrossReference_1_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cPhysicalSysAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cPhysicalSysPhysicalSystemCrossReference_3_0 = (CrossReference)cPhysicalSysAssignment_3.eContents().get(0);
		private final RuleCall cPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1 = (RuleCall)cPhysicalSysPhysicalSystemCrossReference_3_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSubsysMappingsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cSubsysMappingsSubSystemMappingParserRuleCall_5_0 = (RuleCall)cSubsysMappingsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Mapping:
		//	'Mapping' logicalSys=[room::LogicalSystem|FQN] '->' physicalSys=[phys::PhysicalSystem|FQN] '{'
		//	subsysMappings+=SubSystemMapping*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'Mapping' logicalSys=[room::LogicalSystem|FQN] '->' physicalSys=[phys::PhysicalSystem|FQN] '{'
		//subsysMappings+=SubSystemMapping* '}'
		public Group getGroup() { return cGroup; }
		
		//'Mapping'
		public Keyword getMappingKeyword_0() { return cMappingKeyword_0; }
		
		//logicalSys=[room::LogicalSystem|FQN]
		public Assignment getLogicalSysAssignment_1() { return cLogicalSysAssignment_1; }
		
		//[room::LogicalSystem|FQN]
		public CrossReference getLogicalSysLogicalSystemCrossReference_1_0() { return cLogicalSysLogicalSystemCrossReference_1_0; }
		
		//FQN
		public RuleCall getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1() { return cLogicalSysLogicalSystemFQNParserRuleCall_1_0_1; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//physicalSys=[phys::PhysicalSystem|FQN]
		public Assignment getPhysicalSysAssignment_3() { return cPhysicalSysAssignment_3; }
		
		//[phys::PhysicalSystem|FQN]
		public CrossReference getPhysicalSysPhysicalSystemCrossReference_3_0() { return cPhysicalSysPhysicalSystemCrossReference_3_0; }
		
		//FQN
		public RuleCall getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1() { return cPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//subsysMappings+=SubSystemMapping*
		public Assignment getSubsysMappingsAssignment_5() { return cSubsysMappingsAssignment_5; }
		
		//SubSystemMapping
		public RuleCall getSubsysMappingsSubSystemMappingParserRuleCall_5_0() { return cSubsysMappingsSubSystemMappingParserRuleCall_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class SubSystemMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.etrice.core.etmap.ETMap.SubSystemMapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSubSystemMappingKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLogicalSubSysAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cLogicalSubSysSubSystemRefCrossReference_1_0 = (CrossReference)cLogicalSubSysAssignment_1.eContents().get(0);
		private final RuleCall cLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1 = (RuleCall)cLogicalSubSysSubSystemRefCrossReference_1_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNodeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cNodeNodeRefCrossReference_3_0 = (CrossReference)cNodeAssignment_3.eContents().get(0);
		private final RuleCall cNodeNodeRefIDTerminalRuleCall_3_0_1 = (RuleCall)cNodeNodeRefCrossReference_3_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cThreadMappingsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cThreadMappingsThreadMappingParserRuleCall_4_1_0 = (RuleCall)cThreadMappingsAssignment_4_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		
		//SubSystemMapping:
		//	'SubSystemMapping' logicalSubSys=[room::SubSystemRef] '->' node=[phys::NodeRef] ('{'
		//	threadMappings+=ThreadMapping*
		//	'}')?;
		@Override public ParserRule getRule() { return rule; }
		
		//'SubSystemMapping' logicalSubSys=[room::SubSystemRef] '->' node=[phys::NodeRef] ('{' threadMappings+=ThreadMapping*
		//'}')?
		public Group getGroup() { return cGroup; }
		
		//'SubSystemMapping'
		public Keyword getSubSystemMappingKeyword_0() { return cSubSystemMappingKeyword_0; }
		
		//logicalSubSys=[room::SubSystemRef]
		public Assignment getLogicalSubSysAssignment_1() { return cLogicalSubSysAssignment_1; }
		
		//[room::SubSystemRef]
		public CrossReference getLogicalSubSysSubSystemRefCrossReference_1_0() { return cLogicalSubSysSubSystemRefCrossReference_1_0; }
		
		//ID
		public RuleCall getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1() { return cLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//node=[phys::NodeRef]
		public Assignment getNodeAssignment_3() { return cNodeAssignment_3; }
		
		//[phys::NodeRef]
		public CrossReference getNodeNodeRefCrossReference_3_0() { return cNodeNodeRefCrossReference_3_0; }
		
		//ID
		public RuleCall getNodeNodeRefIDTerminalRuleCall_3_0_1() { return cNodeNodeRefIDTerminalRuleCall_3_0_1; }
		
		//('{' threadMappings+=ThreadMapping* '}')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }
		
		//threadMappings+=ThreadMapping*
		public Assignment getThreadMappingsAssignment_4_1() { return cThreadMappingsAssignment_4_1; }
		
		//ThreadMapping
		public RuleCall getThreadMappingsThreadMappingParserRuleCall_4_1_0() { return cThreadMappingsThreadMappingParserRuleCall_4_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4_2() { return cRightCurlyBracketKeyword_4_2; }
	}
	public class ThreadMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.etrice.core.etmap.ETMap.ThreadMapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cThreadMappingKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLogicalThreadAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cLogicalThreadLogicalThreadCrossReference_1_0 = (CrossReference)cLogicalThreadAssignment_1.eContents().get(0);
		private final RuleCall cLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1 = (RuleCall)cLogicalThreadLogicalThreadCrossReference_1_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cPhysicalThreadAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cPhysicalThreadPhysicalThreadCrossReference_3_0 = (CrossReference)cPhysicalThreadAssignment_3.eContents().get(0);
		private final RuleCall cPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1 = (RuleCall)cPhysicalThreadPhysicalThreadCrossReference_3_0.eContents().get(1);
		
		//ThreadMapping:
		//	'ThreadMapping' logicalThread=[room::LogicalThread] '->' physicalThread=[phys::PhysicalThread];
		@Override public ParserRule getRule() { return rule; }
		
		//'ThreadMapping' logicalThread=[room::LogicalThread] '->' physicalThread=[phys::PhysicalThread]
		public Group getGroup() { return cGroup; }
		
		//'ThreadMapping'
		public Keyword getThreadMappingKeyword_0() { return cThreadMappingKeyword_0; }
		
		//logicalThread=[room::LogicalThread]
		public Assignment getLogicalThreadAssignment_1() { return cLogicalThreadAssignment_1; }
		
		//[room::LogicalThread]
		public CrossReference getLogicalThreadLogicalThreadCrossReference_1_0() { return cLogicalThreadLogicalThreadCrossReference_1_0; }
		
		//ID
		public RuleCall getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1() { return cLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//physicalThread=[phys::PhysicalThread]
		public Assignment getPhysicalThreadAssignment_3() { return cPhysicalThreadAssignment_3; }
		
		//[phys::PhysicalThread]
		public CrossReference getPhysicalThreadPhysicalThreadCrossReference_3_0() { return cPhysicalThreadPhysicalThreadCrossReference_3_0; }
		
		//ID
		public RuleCall getPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1() { return cPhysicalThreadPhysicalThreadIDTerminalRuleCall_3_0_1; }
	}
	
	
	private final MappingModelElements pMappingModel;
	private final MappingElements pMapping;
	private final SubSystemMappingElements pSubSystemMapping;
	private final ThreadMappingElements pThreadMapping;
	
	private final Grammar grammar;
	
	private final BaseGrammarAccess gaBase;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ETMapGrammarAccess(GrammarProvider grammarProvider,
			BaseGrammarAccess gaBase,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaBase = gaBase;
		this.gaTerminals = gaTerminals;
		this.pMappingModel = new MappingModelElements();
		this.pMapping = new MappingElements();
		this.pSubSystemMapping = new SubSystemMappingElements();
		this.pThreadMapping = new ThreadMappingElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.etrice.core.etmap.ETMap".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//MappingModel:
	//	'MappingModel' name=FQN '{'
	//	imports+=Import*
	//	mappings+=Mapping*
	//	'}';
	public MappingModelElements getMappingModelAccess() {
		return pMappingModel;
	}
	
	public ParserRule getMappingModelRule() {
		return getMappingModelAccess().getRule();
	}
	
	//Mapping:
	//	'Mapping' logicalSys=[room::LogicalSystem|FQN] '->' physicalSys=[phys::PhysicalSystem|FQN] '{'
	//	subsysMappings+=SubSystemMapping*
	//	'}';
	public MappingElements getMappingAccess() {
		return pMapping;
	}
	
	public ParserRule getMappingRule() {
		return getMappingAccess().getRule();
	}
	
	//SubSystemMapping:
	//	'SubSystemMapping' logicalSubSys=[room::SubSystemRef] '->' node=[phys::NodeRef] ('{'
	//	threadMappings+=ThreadMapping*
	//	'}')?;
	public SubSystemMappingElements getSubSystemMappingAccess() {
		return pSubSystemMapping;
	}
	
	public ParserRule getSubSystemMappingRule() {
		return getSubSystemMappingAccess().getRule();
	}
	
	//ThreadMapping:
	//	'ThreadMapping' logicalThread=[room::LogicalThread] '->' physicalThread=[phys::PhysicalThread];
	public ThreadMappingElements getThreadMappingAccess() {
		return pThreadMapping;
	}
	
	public ParserRule getThreadMappingRule() {
		return getThreadMappingAccess().getRule();
	}
	
	//// **************************************************************
	//// AnnotationType and Annotation Rules
	//Annotation:
	//	'@' type=[AnnotationType|FQN] ('(' attributes+=KeyValue (',' attributes+=KeyValue)* ')')?;
	public BaseGrammarAccess.AnnotationElements getAnnotationAccess() {
		return gaBase.getAnnotationAccess();
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}
	
	//KeyValue:
	//	key=ID '=' value=Literal;
	public BaseGrammarAccess.KeyValueElements getKeyValueAccess() {
		return gaBase.getKeyValueAccess();
	}
	
	public ParserRule getKeyValueRule() {
		return getKeyValueAccess().getRule();
	}
	
	//AnnotationType:
	//	'AnnotationType' name=ID docu=Documentation? '{'
	//	'target' '=' (targets+=AnnotationTargetType | '{' targets+=AnnotationTargetType (',' targets+=AnnotationTargetType)*
	//	'}') attributes+=AnnotationAttribute*
	//	'}';
	public BaseGrammarAccess.AnnotationTypeElements getAnnotationTypeAccess() {
		return gaBase.getAnnotationTypeAccess();
	}
	
	public ParserRule getAnnotationTypeRule() {
		return getAnnotationTypeAccess().getRule();
	}
	
	////
	//// Sub-grammars should use AnnotationTargetType to refer to 
	//// specific sub-grammar targets. For example, valid values for 
	//// AnnotationTargetType in the Room.xtext sub-grammar include "ActorClass", 
	//// "ActorBehavior", "ProtocolClass", etc. The sub-grammar is responsible for 
	//// implementing validation, quick-fixes, and code completion proposals via the 
	//// usual Xtext mechanisms.
	////
	//AnnotationTargetType:
	//	ID;
	public BaseGrammarAccess.AnnotationTargetTypeElements getAnnotationTargetTypeAccess() {
		return gaBase.getAnnotationTargetTypeAccess();
	}
	
	public ParserRule getAnnotationTargetTypeRule() {
		return getAnnotationTargetTypeAccess().getRule();
	}
	
	//AnnotationAttribute:
	//	SimpleAnnotationAttribute | EnumAnnotationAttribute;
	public BaseGrammarAccess.AnnotationAttributeElements getAnnotationAttributeAccess() {
		return gaBase.getAnnotationAttributeAccess();
	}
	
	public ParserRule getAnnotationAttributeRule() {
		return getAnnotationAttributeAccess().getRule();
	}
	
	//SimpleAnnotationAttribute:
	//	(optional?='optional' | 'mandatory') 'attribute' name=ID ':' type=LiteralType;
	public BaseGrammarAccess.SimpleAnnotationAttributeElements getSimpleAnnotationAttributeAccess() {
		return gaBase.getSimpleAnnotationAttributeAccess();
	}
	
	public ParserRule getSimpleAnnotationAttributeRule() {
		return getSimpleAnnotationAttributeAccess().getRule();
	}
	
	//EnumAnnotationAttribute:
	//	(optional?='optional' | 'mandatory') 'attribute' name=ID ':' '{' values+=STRING (',' values+=STRING)* '}';
	public BaseGrammarAccess.EnumAnnotationAttributeElements getEnumAnnotationAttributeAccess() {
		return gaBase.getEnumAnnotationAttributeAccess();
	}
	
	public ParserRule getEnumAnnotationAttributeRule() {
		return getEnumAnnotationAttributeAccess().getRule();
	}
	
	//// **************************************************************
	//// Import rules
	//// HOWTO: use a combination of URI global scopes and namespace aware local scope provider
	//// this is configured in the work flow by
	////			fragment = scoping.ImportURIScopingFragment {}
	//// and by overriding configureIScopeProviderDelegate in the runtime module with 
	////			ImportedNamespaceAwareLocalScopeProvider
	//// also configure in the RuntimeModule
	////	public Class<? extends ImportUriResolver> bindImportUriResolver() {
	////		return PlatformRelativeUriResolver.class;
	////	}
	//// and in the UiRuntimeModule
	////	public Class<? extends org.eclipse.xtext.ui.editor.IURIEditorOpener> bindIURIEditorOpener() {
	////		return GlobalNonPlatformURIEditorOpener.class;
	////	}
	////	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
	////		return ImportAwareHyperlinkHelper.class;
	////	}
	//// the attribute 'importedNamespace' is picked up by the ImportedNamespaceAwareLocalScopeProvider
	//// the attribute 'importURI' is picked up by the ImportUriGlobalScopeProvider
	//Import:
	//	'import' (importedNamespace=ImportedFQN ('from' importURI=STRING)? | 'model' importURI=STRING);
	public BaseGrammarAccess.ImportElements getImportAccess() {
		return gaBase.getImportAccess();
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}
	
	//ImportedFQN:
	//	FQN '.*'?;
	public BaseGrammarAccess.ImportedFQNElements getImportedFQNAccess() {
		return gaBase.getImportedFQNAccess();
	}
	
	public ParserRule getImportedFQNRule() {
		return getImportedFQNAccess().getRule();
	}
	
	//// **************************************************************
	//// Documentation Rule
	//Documentation:
	//	{Documentation}
	//	'['
	//	lines+=STRING*
	//	']';
	public BaseGrammarAccess.DocumentationElements getDocumentationAccess() {
		return gaBase.getDocumentationAccess();
	}
	
	public ParserRule getDocumentationRule() {
		return getDocumentationAccess().getRule();
	}
	
	//// **************************************************************
	//// Time Rule
	//TIME ecore::ELong:
	//	INT 's' | INT 'ms' | INT 'us' | INT 'ns';
	public BaseGrammarAccess.TIMEElements getTIMEAccess() {
		return gaBase.getTIMEAccess();
	}
	
	public ParserRule getTIMERule() {
		return getTIMEAccess().getRule();
	}
	
	//enum LiteralType:
	//	BOOL='ptBoolean' |
	//	INT='ptInteger' |
	//	REAL='ptReal' |
	//	CHAR='ptCharacter';
	public BaseGrammarAccess.LiteralTypeElements getLiteralTypeAccess() {
		return gaBase.getLiteralTypeAccess();
	}
	
	public EnumRule getLiteralTypeRule() {
		return getLiteralTypeAccess().getRule();
	}
	
	//LiteralArray:
	//	literals+=Literal (',' literals+=Literal)*;
	public BaseGrammarAccess.LiteralArrayElements getLiteralArrayAccess() {
		return gaBase.getLiteralArrayAccess();
	}
	
	public ParserRule getLiteralArrayRule() {
		return getLiteralArrayAccess().getRule();
	}
	
	//// Value Types for Attributes
	//Literal:
	//	BooleanLiteral | NumberLiteral | StringLiteral;
	public BaseGrammarAccess.LiteralElements getLiteralAccess() {
		return gaBase.getLiteralAccess();
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//BooleanLiteral:
	//	{BooleanLiteral} ('false' | isTrue?='true');
	public BaseGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaBase.getBooleanLiteralAccess();
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}
	
	//NumberLiteral:
	//	IntLiteral | RealLiteral;
	public BaseGrammarAccess.NumberLiteralElements getNumberLiteralAccess() {
		return gaBase.getNumberLiteralAccess();
	}
	
	public ParserRule getNumberLiteralRule() {
		return getNumberLiteralAccess().getRule();
	}
	
	//RealLiteral:
	//	{RealLiteral} value=Real;
	public BaseGrammarAccess.RealLiteralElements getRealLiteralAccess() {
		return gaBase.getRealLiteralAccess();
	}
	
	public ParserRule getRealLiteralRule() {
		return getRealLiteralAccess().getRule();
	}
	
	//IntLiteral:
	//	{IntLiteral} value=Integer;
	public BaseGrammarAccess.IntLiteralElements getIntLiteralAccess() {
		return gaBase.getIntLiteralAccess();
	}
	
	public ParserRule getIntLiteralRule() {
		return getIntLiteralAccess().getRule();
	}
	
	//StringLiteral:
	//	{StringLiteral} value=STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaBase.getStringLiteralAccess();
	}
	
	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}
	
	//Integer ecore::ELong:
	//	('+' | '-')? INT | HEX;
	public BaseGrammarAccess.IntegerElements getIntegerAccess() {
		return gaBase.getIntegerAccess();
	}
	
	public ParserRule getIntegerRule() {
		return getIntegerAccess().getRule();
	}
	
	//Real ecore::EDouble:
	//	Decimal | DecimalExp;
	public BaseGrammarAccess.RealElements getRealAccess() {
		return gaBase.getRealAccess();
	}
	
	public ParserRule getRealRule() {
		return getRealAccess().getRule();
	}
	
	//Decimal hidden():
	//	('+' | '-')? INT '.' INT;
	public BaseGrammarAccess.DecimalElements getDecimalAccess() {
		return gaBase.getDecimalAccess();
	}
	
	public ParserRule getDecimalRule() {
		return getDecimalAccess().getRule();
	}
	
	////DotDecimal hidden():
	////	('+' | '-')? '.' INT;
	////
	////DecimalDot hidden():
	////	('+' | '-')? INT '.';
	//DecimalExp hidden():
	//	('+' | '-')? INT '.' INT ('e' | 'E') ('+' | '-')? INT;
	public BaseGrammarAccess.DecimalExpElements getDecimalExpAccess() {
		return gaBase.getDecimalExpAccess();
	}
	
	public ParserRule getDecimalExpRule() {
		return getDecimalExpAccess().getRule();
	}
	
	//FQN:
	//	ID ('.' ID)*;
	public BaseGrammarAccess.FQNElements getFQNAccess() {
		return gaBase.getFQNAccess();
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	//terminal HEX:
	//	('0x' | '0X') ('0'..'9' | 'a'..'f' | 'A'..'F')+;
	public TerminalRule getHEXRule() {
		return gaBase.getHEXRule();
	}
	
	//terminal CC_STRING:
	//	"'''"->"'''";
	public TerminalRule getCC_STRINGRule() {
		return gaBase.getCC_STRINGRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
