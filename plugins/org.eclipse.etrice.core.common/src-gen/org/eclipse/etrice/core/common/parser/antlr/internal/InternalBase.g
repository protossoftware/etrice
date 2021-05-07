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
import org.eclipse.emf.common.util.Enumerator;
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
    	return "Annotation";
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

// Entry rule entryRuleAnnotation
entryRuleAnnotation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationRule()); }
	iv_ruleAnnotation=ruleAnnotation
	{ $current=$iv_ruleAnnotation.current; }
	EOF;

// Rule Annotation
ruleAnnotation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='@'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0());
				}
				ruleFQN
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0());
					}
					lv_attributes_3_0=ruleKeyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAnnotationRule());
						}
						add(
							$current,
							"attributes",
							lv_attributes_3_0,
							"org.eclipse.etrice.core.common.Base.KeyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0());
						}
						lv_attributes_5_0=ruleKeyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAnnotationRule());
							}
							add(
								$current,
								"attributes",
								lv_attributes_5_0,
								"org.eclipse.etrice.core.common.Base.KeyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3());
			}
		)?
	)
;

// Entry rule entryRuleKeyValue
entryRuleKeyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getKeyValueRule()); }
	iv_ruleKeyValue=ruleKeyValue
	{ $current=$iv_ruleKeyValue.current; }
	EOF;

// Rule KeyValue
ruleKeyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_key_0_0=RULE_ID
				{
					newLeafNode(lv_key_0_0, grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getKeyValueRule());
					}
					setWithLastConsumed(
						$current,
						"key",
						lv_key_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0());
				}
				lv_value_2_0=ruleLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getKeyValueRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"org.eclipse.etrice.core.common.Base.Literal");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAnnotationTargetType
entryRuleAnnotationTargetType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); }
	iv_ruleAnnotationTargetType=ruleAnnotationTargetType
	{ $current=$iv_ruleAnnotationTargetType.current.getText(); }
	EOF;

// Rule AnnotationTargetType
ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall());
	}
;

// Entry rule entryRuleAnnotationAttribute
entryRuleAnnotationAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationAttributeRule()); }
	iv_ruleAnnotationAttribute=ruleAnnotationAttribute
	{ $current=$iv_ruleAnnotationAttribute.current; }
	EOF;

// Rule AnnotationAttribute
ruleAnnotationAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0());
		}
		this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute
		{
			$current = $this_SimpleAnnotationAttribute_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1());
		}
		this_EnumAnnotationAttribute_1=ruleEnumAnnotationAttribute
		{
			$current = $this_EnumAnnotationAttribute_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSimpleAnnotationAttribute
entryRuleSimpleAnnotationAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); }
	iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute
	{ $current=$iv_ruleSimpleAnnotationAttribute.current; }
	EOF;

// Rule SimpleAnnotationAttribute
ruleSimpleAnnotationAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					lv_optional_0_0='optional'
					{
						newLeafNode(lv_optional_0_0, grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
						}
						setWithLastConsumed($current, "optional", lv_optional_0_0 != null, "optional");
					}
				)
			)
			    |
			otherlv_1='mandatory'
			{
				newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
			}
		)
		otherlv_2='attribute'
		{
			newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_4=':'
		{
			newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0());
				}
				lv_type_5_0=ruleLiteralType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleAnnotationAttributeRule());
					}
					set(
						$current,
						"type",
						lv_type_5_0,
						"org.eclipse.etrice.core.common.Base.LiteralType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEnumAnnotationAttribute
entryRuleEnumAnnotationAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); }
	iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute
	{ $current=$iv_ruleEnumAnnotationAttribute.current; }
	EOF;

// Rule EnumAnnotationAttribute
ruleEnumAnnotationAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					lv_optional_0_0='optional'
					{
						newLeafNode(lv_optional_0_0, grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
						}
						setWithLastConsumed($current, "optional", lv_optional_0_0 != null, "optional");
					}
				)
			)
			    |
			otherlv_1='mandatory'
			{
				newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
			}
		)
		otherlv_2='attribute'
		{
			newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_4=':'
		{
			newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				lv_values_6_0=RULE_STRING
				{
					newLeafNode(lv_values_6_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
					}
					addWithLastConsumed(
						$current,
						"values",
						lv_values_6_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			otherlv_7=','
			{
				newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
			}
			(
				(
					lv_values_8_0=RULE_STRING
					{
						newLeafNode(lv_values_8_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
						}
						addWithLastConsumed(
							$current,
							"values",
							lv_values_8_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)*
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleImportedFQN
entryRuleImportedFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getImportedFQNRule()); }
	iv_ruleImportedFQN=ruleImportedFQN
	{ $current=$iv_ruleImportedFQN.current.getText(); }
	EOF;

// Rule ImportedFQN
ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
		}
		this_FQN_0=ruleFQN
		{
			$current.merge(this_FQN_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			kw='.*'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1());
			}
		)?
	)
;

// Entry rule entryRuleDocumentation
entryRuleDocumentation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDocumentationRule()); }
	iv_ruleDocumentation=ruleDocumentation
	{ $current=$iv_ruleDocumentation.current; }
	EOF;

// Rule Documentation
ruleDocumentation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
					$current);
			}
		)
		otherlv_1='['
		{
			newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				lv_lines_2_0=RULE_STRING
				{
					newLeafNode(lv_lines_2_0, grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDocumentationRule());
					}
					addWithLastConsumed(
						$current,
						"lines",
						lv_lines_2_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)*
		otherlv_3=']'
		{
			newLeafNode(otherlv_3, grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleLiteral
entryRuleLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRule()); }
	iv_ruleLiteral=ruleLiteral
	{ $current=$iv_ruleLiteral.current; }
	EOF;

// Rule Literal
ruleLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	iv_ruleBooleanLiteral=ruleBooleanLiteral
	{ $current=$iv_ruleBooleanLiteral.current; }
	EOF;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			otherlv_1='false'
			{
				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
			}
			    |
			(
				(
					lv_isTrue_2_0='true'
					{
						newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBooleanLiteralRule());
						}
						setWithLastConsumed($current, "isTrue", lv_isTrue_2_0 != null, "true");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumberLiteralRule()); }
	iv_ruleNumberLiteral=ruleNumberLiteral
	{ $current=$iv_ruleNumberLiteral.current; }
	EOF;

// Rule NumberLiteral
ruleNumberLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleRealLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRealLiteralRule()); }
	iv_ruleRealLiteral=ruleRealLiteral
	{ $current=$iv_ruleRealLiteral.current; }
	EOF;

// Rule RealLiteral
ruleRealLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0());
				}
				lv_value_1_0=ruleReal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRealLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.etrice.core.common.Base.Real");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleIntLiteral
entryRuleIntLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntLiteralRule()); }
	iv_ruleIntLiteral=ruleIntLiteral
	{ $current=$iv_ruleIntLiteral.current; }
	EOF;

// Rule IntLiteral
ruleIntLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0());
				}
				lv_value_1_0=ruleInteger
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.etrice.core.common.Base.Integer");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	iv_ruleStringLiteral=ruleStringLiteral
	{ $current=$iv_ruleStringLiteral.current; }
	EOF;

// Rule StringLiteral
ruleStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
					$current);
			}
		)
		(
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
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleInteger
entryRuleInteger returns [String current=null]:
	{ newCompositeNode(grammarAccess.getIntegerRule()); }
	iv_ruleInteger=ruleInteger
	{ $current=$iv_ruleInteger.current.getText(); }
	EOF;

// Rule Integer
ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				kw='+'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0());
				}
				    |
				kw='-'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1());
				}
			)?
			this_INT_2=RULE_INT
			{
				$current.merge(this_INT_2);
			}
			{
				newLeafNode(this_INT_2, grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1());
			}
		)
		    |
		this_HEX_3=RULE_HEX
		{
			$current.merge(this_HEX_3);
		}
		{
			newLeafNode(this_HEX_3, grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleReal
entryRuleReal returns [String current=null]:
	{ newCompositeNode(grammarAccess.getRealRule()); }
	iv_ruleReal=ruleReal
	{ $current=$iv_ruleReal.current.getText(); }
	EOF;

// Rule Real
ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0());
		}
		this_Decimal_0=ruleDecimal
		{
			$current.merge(this_Decimal_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1());
		}
		this_DecimalExp_1=ruleDecimalExp
		{
			$current.merge(this_DecimalExp_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDecimal
entryRuleDecimal returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getDecimalRule()); }
	iv_ruleDecimal=ruleDecimal
	{ $current=$iv_ruleDecimal.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Decimal
ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
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
		)?
		this_INT_2=RULE_INT
		{
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
		this_INT_4=RULE_INT
		{
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

// Entry rule entryRuleDecimalExp
entryRuleDecimalExp returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getDecimalExpRule()); }
	iv_ruleDecimalExp=ruleDecimalExp
	{ $current=$iv_ruleDecimalExp.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule DecimalExp
ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
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
		)?
		this_INT_2=RULE_INT
		{
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
		this_INT_4=RULE_INT
		{
			$current.merge(this_INT_4);
		}
		{
			newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3());
		}
		(
			kw='e'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0());
			}
			    |
			kw='E'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1());
			}
		)
		(
			kw='+'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0());
			}
			    |
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1());
			}
		)?
		this_INT_9=RULE_INT
		{
			$current.merge(this_INT_9);
		}
		{
			newLeafNode(this_INT_9, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6());
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFQNRule()); }
	iv_ruleFQN=ruleFQN
	{ $current=$iv_ruleFQN.current.getText(); }
	EOF;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Rule LiteralType
ruleLiteralType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='ptBoolean'
			{
				$current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='ptInteger'
			{
				$current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='ptReal'
			{
				$current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='ptCharacter'
			{
				$current = grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3());
			}
		)
	)
;

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F')+;

RULE_CC_STRING : '\'\'\'' ( options {greedy=false;} : . )*'\'\'\'';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
