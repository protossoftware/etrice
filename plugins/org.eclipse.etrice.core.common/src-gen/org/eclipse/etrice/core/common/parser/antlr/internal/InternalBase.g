/*
* generated by Xtext
*/
grammar InternalBase;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.etrice.core.common.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.etrice.core.common.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;

}

@parser::members {

 	private BaseGrammarAccess grammarAccess;
 	
    public InternalBaseParser(TokenStream input, BaseGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "LiteralArray";	
   	}
   	
   	@Override
   	protected BaseGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleLiteralArray
entryRuleLiteralArray returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLiteralArrayRule()); }
	 iv_ruleLiteralArray=ruleLiteralArray 
	 { $current=$iv_ruleLiteralArray.current; } 
	 EOF 
;

// Rule LiteralArray
ruleLiteralArray returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
	    }
		lv_literals_0_0=ruleLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
	        }
       		add(
       			$current, 
       			"literals",
        		lv_literals_0_0, 
        		"Literal");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
	    }
		lv_literals_2_0=ruleLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
	        }
       		add(
       			$current, 
       			"literals",
        		lv_literals_2_0, 
        		"Literal");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleLiteral
entryRuleLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLiteralRule()); }
	 iv_ruleLiteral=ruleLiteral 
	 { $current=$iv_ruleLiteral.current; } 
	 EOF 
;

// Rule Literal
ruleLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
    }
    this_BooleanLiteral_0=ruleBooleanLiteral
    { 
        $current = $this_BooleanLiteral_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
    }
    this_NumberLiteral_1=ruleNumberLiteral
    { 
        $current = $this_NumberLiteral_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
    }
    this_StringLiteral_2=ruleStringLiteral
    { 
        $current = $this_StringLiteral_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	 iv_ruleBooleanLiteral=ruleBooleanLiteral 
	 { $current=$iv_ruleBooleanLiteral.current; } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            $current);
    }
)(	otherlv_1='false' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
    }

    |(
(
		lv_isTrue_2_0=	'true' 
    {
        newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBooleanLiteralRule());
	        }
       		setWithLastConsumed($current, "isTrue", true, "true");
	    }

)
)))
;





// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNumberLiteralRule()); }
	 iv_ruleNumberLiteral=ruleNumberLiteral 
	 { $current=$iv_ruleNumberLiteral.current; } 
	 EOF 
;

// Rule NumberLiteral
ruleNumberLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
    }
    this_IntLiteral_0=ruleIntLiteral
    { 
        $current = $this_IntLiteral_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
    }
    this_RealLiteral_1=ruleRealLiteral
    { 
        $current = $this_RealLiteral_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleRealLiteral
entryRuleRealLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRealLiteralRule()); }
	 iv_ruleRealLiteral=ruleRealLiteral 
	 { $current=$iv_ruleRealLiteral.current; } 
	 EOF 
;

// Rule RealLiteral
ruleRealLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
	    }
		lv_value_1_0=ruleReal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRealLiteralRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"Real");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleIntLiteral
entryRuleIntLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIntLiteralRule()); }
	 iv_ruleIntLiteral=ruleIntLiteral 
	 { $current=$iv_ruleIntLiteral.current; } 
	 EOF 
;

// Rule IntLiteral
ruleIntLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
	    }
		lv_value_1_0=ruleInteger		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIntLiteralRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"Integer");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	 iv_ruleStringLiteral=ruleStringLiteral 
	 { $current=$iv_ruleStringLiteral.current; } 
	 EOF 
;

// Rule StringLiteral
ruleStringLiteral returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            $current);
    }
)(
(
		lv_value_1_0=RULE_STRING
		{
			newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStringLiteralRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleInteger
entryRuleInteger returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getIntegerRule()); } 
	 iv_ruleInteger=ruleInteger 
	 { $current=$iv_ruleInteger.current.getText(); }  
	 EOF 
;

// Rule Integer
ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
    }
    this_SignedInteger_0=ruleSignedInteger    {
		$current.merge(this_SignedInteger_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
    }
    this_Hexadecimal_1=ruleHexadecimal    {
		$current.merge(this_Hexadecimal_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleSignedInteger
entryRuleSignedInteger returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getSignedIntegerRule()); } 
	 iv_ruleSignedInteger=ruleSignedInteger 
	 { $current=$iv_ruleSignedInteger.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule SignedInteger
ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
    }
)
    ;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleHexadecimal
entryRuleHexadecimal returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getHexadecimalRule()); } 
	 iv_ruleHexadecimal=ruleHexadecimal 
	 { $current=$iv_ruleHexadecimal.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Hexadecimal
ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
    this_HEX_0=RULE_HEX    {
		$current.merge(this_HEX_0);
    }

    { 
    newLeafNode(this_HEX_0, grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
    }

    ;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleReal
entryRuleReal returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getRealRule()); } 
	 iv_ruleReal=ruleReal 
	 { $current=$iv_ruleReal.current.getText(); }  
	 EOF 
;

// Rule Real
ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
    }
    this_Decimal_0=ruleDecimal    {
		$current.merge(this_Decimal_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
    }
    this_DotDecimal_1=ruleDotDecimal    {
		$current.merge(this_DotDecimal_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
    }
    this_DecimalDot_2=ruleDecimalDot    {
		$current.merge(this_DecimalDot_2);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
    }
    this_DecimalExp_3=ruleDecimalExp    {
		$current.merge(this_DecimalExp_3);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleDecimal
entryRuleDecimal returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getDecimalRule()); } 
	 iv_ruleDecimal=ruleDecimal 
	 { $current=$iv_ruleDecimal.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Decimal
ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
    }
    this_INT_4=RULE_INT    {
		$current.merge(this_INT_4);
    }

    { 
    newLeafNode(this_INT_4, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
    }
)
    ;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleDotDecimal
entryRuleDotDecimal returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getDotDecimalRule()); } 
	 iv_ruleDotDecimal=ruleDotDecimal 
	 { $current=$iv_ruleDotDecimal.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule DotDecimal
ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
    }
)?
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
    }
    this_INT_3=RULE_INT    {
		$current.merge(this_INT_3);
    }

    { 
    newLeafNode(this_INT_3, grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
    }
)
    ;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleDecimalDot
entryRuleDecimalDot returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getDecimalDotRule()); } 
	 iv_ruleDecimalDot=ruleDecimalDot 
	 { $current=$iv_ruleDecimalDot.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule DecimalDot
ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
    }
)
    ;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleDecimalExp
entryRuleDecimalExp returns [String current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
	}
	:
	{ newCompositeNode(grammarAccess.getDecimalExpRule()); } 
	 iv_ruleDecimalExp=ruleDecimalExp 
	 { $current=$iv_ruleDecimalExp.current.getText(); }  
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule DecimalExp
ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
    }
    @after { leaveRule(); }:
((
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
    }
)?    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
    }

	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
    }
    this_INT_4=RULE_INT    {
		$current.merge(this_INT_4);
    }

    { 
    newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
    }
    this_EXP_5=RULE_EXP    {
		$current.merge(this_EXP_5);
    }

    { 
    newLeafNode(this_EXP_5, grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
    }
)
    ;
finally {
	myHiddenTokenState.restore();
}





RULE_EXP : ('e'|'E') ('+'|'-')? ('0'..'9')+;

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F')+;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


