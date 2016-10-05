/*
* generated by Xtext
*/
package org.eclipse.etrice.core.common.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.etrice.core.common.services.BaseGrammarAccess;

@Singleton
public class BaseTestGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class BaseModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BaseModel");
		private final Assignment cElementsAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cElementsAlternatives_0 = (Alternatives)cElementsAssignment.eContents().get(0);
		private final RuleCall cElementsAnnotationParserRuleCall_0_0 = (RuleCall)cElementsAlternatives_0.eContents().get(0);
		private final RuleCall cElementsAnnotationTypeParserRuleCall_0_1 = (RuleCall)cElementsAlternatives_0.eContents().get(1);
		
		//// **************************************************************
		//// A simple model for testing Base grammar rules
		////
		//BaseModel:
		//	elements+=(Annotation | AnnotationType)*;
		public ParserRule getRule() { return rule; }

		//elements+=(Annotation | AnnotationType)*
		public Assignment getElementsAssignment() { return cElementsAssignment; }

		//Annotation | AnnotationType
		public Alternatives getElementsAlternatives_0() { return cElementsAlternatives_0; }

		//Annotation
		public RuleCall getElementsAnnotationParserRuleCall_0_0() { return cElementsAnnotationParserRuleCall_0_0; }

		//AnnotationType
		public RuleCall getElementsAnnotationTypeParserRuleCall_0_1() { return cElementsAnnotationTypeParserRuleCall_0_1; }
	}
	
	
	private final BaseModelElements pBaseModel;
	
	private final Grammar grammar;

	private final BaseGrammarAccess gaBase;

	@Inject
	public BaseTestGrammarAccess(GrammarProvider grammarProvider,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaBase = gaBase;
		this.pBaseModel = new BaseModelElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.etrice.core.common.BaseTest".equals(grammar.getName())) {
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
	

	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}

	
	//// **************************************************************
	//// A simple model for testing Base grammar rules
	////
	//BaseModel:
	//	elements+=(Annotation | AnnotationType)*;
	public BaseModelElements getBaseModelAccess() {
		return pBaseModel;
	}
	
	public ParserRule getBaseModelRule() {
		return getBaseModelAccess().getRule();
	}

	//// **************************************************************
	//// AnnotationType and Annotation Rules
	//Annotation:
	//	"@" type=[AnnotationType|FQN] ("(" attributes+=KeyValue ("," attributes+=KeyValue)* ")")?;
	public BaseGrammarAccess.AnnotationElements getAnnotationAccess() {
		return gaBase.getAnnotationAccess();
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
	}

	//KeyValue:
	//	key=ID "=" value=Literal;
	public BaseGrammarAccess.KeyValueElements getKeyValueAccess() {
		return gaBase.getKeyValueAccess();
	}
	
	public ParserRule getKeyValueRule() {
		return getKeyValueAccess().getRule();
	}

	//AnnotationType:
	//	"AnnotationType" name=ID docu=Documentation? "{" "target" "=" (targets+=AnnotationTargetType | "{"
	//	targets+=AnnotationTargetType ("," targets+=AnnotationTargetType)* "}") attributes+=AnnotationAttribute* "}";
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
	//	(optional?="optional" | "mandatory") "attribute" name=ID ":" type=LiteralType;
	public BaseGrammarAccess.SimpleAnnotationAttributeElements getSimpleAnnotationAttributeAccess() {
		return gaBase.getSimpleAnnotationAttributeAccess();
	}
	
	public ParserRule getSimpleAnnotationAttributeRule() {
		return getSimpleAnnotationAttributeAccess().getRule();
	}

	//EnumAnnotationAttribute:
	//	(optional?="optional" | "mandatory") "attribute" name=ID ":" "{" values+=STRING ("," values+=STRING)* "}";
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
	//	"import" (importedNamespace=ImportedFQN "from" | "model") importURI=STRING;
	public BaseGrammarAccess.ImportElements getImportAccess() {
		return gaBase.getImportAccess();
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//ImportedFQN:
	//	FQN ".*"?;
	public BaseGrammarAccess.ImportedFQNElements getImportedFQNAccess() {
		return gaBase.getImportedFQNAccess();
	}
	
	public ParserRule getImportedFQNRule() {
		return getImportedFQNAccess().getRule();
	}

	//// **************************************************************
	//// Documentation Rule
	//Documentation:
	//	{Documentation} "[" lines+=STRING* "]";
	public BaseGrammarAccess.DocumentationElements getDocumentationAccess() {
		return gaBase.getDocumentationAccess();
	}
	
	public ParserRule getDocumentationRule() {
		return getDocumentationAccess().getRule();
	}

	//// **************************************************************
	//// Time Rule
	//TIME returns ecore::ELong:
	//	INT "s" | INT "ms" | INT "us" | INT "ns";
	public BaseGrammarAccess.TIMEElements getTIMEAccess() {
		return gaBase.getTIMEAccess();
	}
	
	public ParserRule getTIMERule() {
		return getTIMEAccess().getRule();
	}

	//// **************************************************************
	//// Literal Rules
	//enum LiteralType:
	//	BOOL="ptBoolean" | INT="ptInteger" | REAL="ptReal" | CHAR="ptCharacter";
	public BaseGrammarAccess.LiteralTypeElements getLiteralTypeAccess() {
		return gaBase.getLiteralTypeAccess();
	}
	
	public EnumRule getLiteralTypeRule() {
		return getLiteralTypeAccess().getRule();
	}

	//LiteralArray:
	//	literals+=Literal ("," literals+=Literal)*;
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
	//	{BooleanLiteral} ("false" | isTrue?="true");
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

	//Integer returns ecore::ELong:
	//	("+" | "-")? INT | HEX;
	public BaseGrammarAccess.IntegerElements getIntegerAccess() {
		return gaBase.getIntegerAccess();
	}
	
	public ParserRule getIntegerRule() {
		return getIntegerAccess().getRule();
	}

	//Real returns ecore::EDouble:
	//	Decimal | / *DotDecimal | DecimalDot |* / DecimalExp;
	public BaseGrammarAccess.RealElements getRealAccess() {
		return gaBase.getRealAccess();
	}
	
	public ParserRule getRealRule() {
		return getRealAccess().getRule();
	}

	//Decimal hidden():
	//	("+" | "-")? INT "." INT;
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
	//	("+" | "-")? INT "." INT ("e" | "E") ("+" | "-")? INT;
	public BaseGrammarAccess.DecimalExpElements getDecimalExpAccess() {
		return gaBase.getDecimalExpAccess();
	}
	
	public ParserRule getDecimalExpRule() {
		return getDecimalExpAccess().getRule();
	}

	//FQN:
	//	ID ("." ID)*;
	public BaseGrammarAccess.FQNElements getFQNAccess() {
		return gaBase.getFQNAccess();
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}

	//terminal HEX:
	//	("0x" | "0X") ("0".."9" | "a".."f" | "A".."F")+;
	public TerminalRule getHEXRule() {
		return gaBase.getHEXRule();
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaBase.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaBase.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaBase.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaBase.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaBase.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaBase.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaBase.getANY_OTHERRule();
	} 
}
