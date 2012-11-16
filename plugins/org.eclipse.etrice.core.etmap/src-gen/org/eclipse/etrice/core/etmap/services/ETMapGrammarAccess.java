/*
* generated by Xtext
*/

package org.eclipse.etrice.core.etmap.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ETMapGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class MappingModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingModel");
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
		//
		//	"MappingModel" name=FQN "{" imports+=Import* mappings+=Mapping* "}";
		public ParserRule getRule() { return rule; }

		//"MappingModel" name=FQN "{" imports+=Import* mappings+=Mapping* "}"
		public Group getGroup() { return cGroup; }

		//"MappingModel"
		public Keyword getMappingModelKeyword_0() { return cMappingModelKeyword_0; }

		//name=FQN
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//FQN
		public RuleCall getNameFQNParserRuleCall_1_0() { return cNameFQNParserRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//imports+=Import*
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }

		//Import
		public RuleCall getImportsImportParserRuleCall_3_0() { return cImportsImportParserRuleCall_3_0; }

		//mappings+=Mapping*
		public Assignment getMappingsAssignment_4() { return cMappingsAssignment_4; }

		//Mapping
		public RuleCall getMappingsMappingParserRuleCall_4_0() { return cMappingsMappingParserRuleCall_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class MappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Mapping");
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
		//
		//	"Mapping" logicalSys=[room::LogicalSystem|FQN] "->" physicalSys=[phys::PhysicalSystem|FQN] "{"
		//
		//	subsysMappings+=SubSystemMapping* "}";
		public ParserRule getRule() { return rule; }

		//"Mapping" logicalSys=[room::LogicalSystem|FQN] "->" physicalSys=[phys::PhysicalSystem|FQN] "{"
		//
		//subsysMappings+=SubSystemMapping* "}"
		public Group getGroup() { return cGroup; }

		//"Mapping"
		public Keyword getMappingKeyword_0() { return cMappingKeyword_0; }

		//logicalSys=[room::LogicalSystem|FQN]
		public Assignment getLogicalSysAssignment_1() { return cLogicalSysAssignment_1; }

		//[room::LogicalSystem|FQN]
		public CrossReference getLogicalSysLogicalSystemCrossReference_1_0() { return cLogicalSysLogicalSystemCrossReference_1_0; }

		//FQN
		public RuleCall getLogicalSysLogicalSystemFQNParserRuleCall_1_0_1() { return cLogicalSysLogicalSystemFQNParserRuleCall_1_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }

		//physicalSys=[phys::PhysicalSystem|FQN]
		public Assignment getPhysicalSysAssignment_3() { return cPhysicalSysAssignment_3; }

		//[phys::PhysicalSystem|FQN]
		public CrossReference getPhysicalSysPhysicalSystemCrossReference_3_0() { return cPhysicalSysPhysicalSystemCrossReference_3_0; }

		//FQN
		public RuleCall getPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1() { return cPhysicalSysPhysicalSystemFQNParserRuleCall_3_0_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//subsysMappings+=SubSystemMapping*
		public Assignment getSubsysMappingsAssignment_5() { return cSubsysMappingsAssignment_5; }

		//SubSystemMapping
		public RuleCall getSubsysMappingsSubSystemMappingParserRuleCall_5_0() { return cSubsysMappingsSubSystemMappingParserRuleCall_5_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class SubSystemMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SubSystemMapping");
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
		//
		//	"SubSystemMapping" logicalSubSys=[room::SubSystemRef] "->" node=[phys::NodeRef] ("{" threadMappings+=ThreadMapping*
		//
		//	"}")?;
		public ParserRule getRule() { return rule; }

		//"SubSystemMapping" logicalSubSys=[room::SubSystemRef] "->" node=[phys::NodeRef] ("{" threadMappings+=ThreadMapping*
		//
		//"}")?
		public Group getGroup() { return cGroup; }

		//"SubSystemMapping"
		public Keyword getSubSystemMappingKeyword_0() { return cSubSystemMappingKeyword_0; }

		//logicalSubSys=[room::SubSystemRef]
		public Assignment getLogicalSubSysAssignment_1() { return cLogicalSubSysAssignment_1; }

		//[room::SubSystemRef]
		public CrossReference getLogicalSubSysSubSystemRefCrossReference_1_0() { return cLogicalSubSysSubSystemRefCrossReference_1_0; }

		//ID
		public RuleCall getLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1() { return cLogicalSubSysSubSystemRefIDTerminalRuleCall_1_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }

		//node=[phys::NodeRef]
		public Assignment getNodeAssignment_3() { return cNodeAssignment_3; }

		//[phys::NodeRef]
		public CrossReference getNodeNodeRefCrossReference_3_0() { return cNodeNodeRefCrossReference_3_0; }

		//ID
		public RuleCall getNodeNodeRefIDTerminalRuleCall_3_0_1() { return cNodeNodeRefIDTerminalRuleCall_3_0_1; }

		//("{" threadMappings+=ThreadMapping* "}")?
		public Group getGroup_4() { return cGroup_4; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }

		//threadMappings+=ThreadMapping*
		public Assignment getThreadMappingsAssignment_4_1() { return cThreadMappingsAssignment_4_1; }

		//ThreadMapping
		public RuleCall getThreadMappingsThreadMappingParserRuleCall_4_1_0() { return cThreadMappingsThreadMappingParserRuleCall_4_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4_2() { return cRightCurlyBracketKeyword_4_2; }
	}

	public class ThreadMappingElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ThreadMapping");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cThreadMappingKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLogicalThreadAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cLogicalThreadLogicalThreadCrossReference_1_0 = (CrossReference)cLogicalThreadAssignment_1.eContents().get(0);
		private final RuleCall cLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1 = (RuleCall)cLogicalThreadLogicalThreadCrossReference_1_0.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cPhysicalThreadAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cPhysicalThreadPhysThreadCrossReference_3_0 = (CrossReference)cPhysicalThreadAssignment_3.eContents().get(0);
		private final RuleCall cPhysicalThreadPhysThreadIDTerminalRuleCall_3_0_1 = (RuleCall)cPhysicalThreadPhysThreadCrossReference_3_0.eContents().get(1);
		
		//ThreadMapping:
		//
		//	"ThreadMapping" logicalThread=[room::LogicalThread] "->" physicalThread=[phys::PhysThread];
		public ParserRule getRule() { return rule; }

		//"ThreadMapping" logicalThread=[room::LogicalThread] "->" physicalThread=[phys::PhysThread]
		public Group getGroup() { return cGroup; }

		//"ThreadMapping"
		public Keyword getThreadMappingKeyword_0() { return cThreadMappingKeyword_0; }

		//logicalThread=[room::LogicalThread]
		public Assignment getLogicalThreadAssignment_1() { return cLogicalThreadAssignment_1; }

		//[room::LogicalThread]
		public CrossReference getLogicalThreadLogicalThreadCrossReference_1_0() { return cLogicalThreadLogicalThreadCrossReference_1_0; }

		//ID
		public RuleCall getLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1() { return cLogicalThreadLogicalThreadIDTerminalRuleCall_1_0_1; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }

		//physicalThread=[phys::PhysThread]
		public Assignment getPhysicalThreadAssignment_3() { return cPhysicalThreadAssignment_3; }

		//[phys::PhysThread]
		public CrossReference getPhysicalThreadPhysThreadCrossReference_3_0() { return cPhysicalThreadPhysThreadCrossReference_3_0; }

		//ID
		public RuleCall getPhysicalThreadPhysThreadIDTerminalRuleCall_3_0_1() { return cPhysicalThreadPhysThreadIDTerminalRuleCall_3_0_1; }
	}

	public class ImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cImportedNamespaceAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final RuleCall cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0 = (RuleCall)cImportedNamespaceAssignment_1_0_0.eContents().get(0);
		private final Keyword cFromKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Keyword cModelKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Assignment cImportURIAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cImportURISTRINGTerminalRuleCall_2_0 = (RuleCall)cImportURIAssignment_2.eContents().get(0);
		
		//Import:
		//
		//	"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING;
		public ParserRule getRule() { return rule; }

		//"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING
		public Group getGroup() { return cGroup; }

		//"import"
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//importedNamespace=ImportedFQN "from" | "model"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//importedNamespace=ImportedFQN "from"
		public Group getGroup_1_0() { return cGroup_1_0; }

		//importedNamespace=ImportedFQN
		public Assignment getImportedNamespaceAssignment_1_0_0() { return cImportedNamespaceAssignment_1_0_0; }

		//ImportedFQN
		public RuleCall getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0() { return cImportedNamespaceImportedFQNParserRuleCall_1_0_0_0; }

		//"from"
		public Keyword getFromKeyword_1_0_1() { return cFromKeyword_1_0_1; }

		//"model"
		public Keyword getModelKeyword_1_1() { return cModelKeyword_1_1; }

		//importURI=STRING
		public Assignment getImportURIAssignment_2() { return cImportURIAssignment_2; }

		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_2_0() { return cImportURISTRINGTerminalRuleCall_2_0; }
	}

	public class ImportedFQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImportedFQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cFQNParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopAsteriskKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ImportedFQN:
		//
		//	FQN ".*"?;
		public ParserRule getRule() { return rule; }

		//FQN ".*"?
		public Group getGroup() { return cGroup; }

		//FQN
		public RuleCall getFQNParserRuleCall_0() { return cFQNParserRuleCall_0; }

		//".*"?
		public Keyword getFullStopAsteriskKeyword_1() { return cFullStopAsteriskKeyword_1; }
	}

	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN:
		//
		//	ID ("." ID)*;
		public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private MappingModelElements pMappingModel;
	private MappingElements pMapping;
	private SubSystemMappingElements pSubSystemMapping;
	private ThreadMappingElements pThreadMapping;
	private ImportElements pImport;
	private ImportedFQNElements pImportedFQN;
	private FQNElements pFQN;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public ETMapGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
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
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//MappingModel:
	//
	//	"MappingModel" name=FQN "{" imports+=Import* mappings+=Mapping* "}";
	public MappingModelElements getMappingModelAccess() {
		return (pMappingModel != null) ? pMappingModel : (pMappingModel = new MappingModelElements());
	}
	
	public ParserRule getMappingModelRule() {
		return getMappingModelAccess().getRule();
	}

	//Mapping:
	//
	//	"Mapping" logicalSys=[room::LogicalSystem|FQN] "->" physicalSys=[phys::PhysicalSystem|FQN] "{"
	//
	//	subsysMappings+=SubSystemMapping* "}";
	public MappingElements getMappingAccess() {
		return (pMapping != null) ? pMapping : (pMapping = new MappingElements());
	}
	
	public ParserRule getMappingRule() {
		return getMappingAccess().getRule();
	}

	//SubSystemMapping:
	//
	//	"SubSystemMapping" logicalSubSys=[room::SubSystemRef] "->" node=[phys::NodeRef] ("{" threadMappings+=ThreadMapping*
	//
	//	"}")?;
	public SubSystemMappingElements getSubSystemMappingAccess() {
		return (pSubSystemMapping != null) ? pSubSystemMapping : (pSubSystemMapping = new SubSystemMappingElements());
	}
	
	public ParserRule getSubSystemMappingRule() {
		return getSubSystemMappingAccess().getRule();
	}

	//ThreadMapping:
	//
	//	"ThreadMapping" logicalThread=[room::LogicalThread] "->" physicalThread=[phys::PhysThread];
	public ThreadMappingElements getThreadMappingAccess() {
		return (pThreadMapping != null) ? pThreadMapping : (pThreadMapping = new ThreadMappingElements());
	}
	
	public ParserRule getThreadMappingRule() {
		return getThreadMappingAccess().getRule();
	}

	//Import:
	//
	//	"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING;
	public ImportElements getImportAccess() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//ImportedFQN:
	//
	//	FQN ".*"?;
	public ImportedFQNElements getImportedFQNAccess() {
		return (pImportedFQN != null) ? pImportedFQN : (pImportedFQN = new ImportedFQNElements());
	}
	
	public ParserRule getImportedFQNRule() {
		return getImportedFQNAccess().getRule();
	}

	//FQN:
	//
	//	ID ("." ID)*;
	public FQNElements getFQNAccess() {
		return (pFQN != null) ? pFQN : (pFQN = new FQNElements());
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}

	//terminal ID:
	//
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
