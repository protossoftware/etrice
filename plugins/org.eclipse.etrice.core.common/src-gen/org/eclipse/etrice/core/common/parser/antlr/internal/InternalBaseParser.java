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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'('", "','", "')'", "'='", "'optional'", "'mandatory'", "'attribute'", "':'", "'{'", "'}'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_EXP=8;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_HEX=7;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g"; }



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



    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:68:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:69:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:70:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation75);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:77:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:80:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:81:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:81:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:81:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAnnotation122); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:85:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:86:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:86:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:87:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleAnnotation145);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:100:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:100:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleAnnotation158); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:104:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:105:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:105:1: (lv_attributes_3_0= ruleKeyValue )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:106:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation179);
                    lv_attributes_3_0=ruleKeyValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"attributes",
                            		lv_attributes_3_0, 
                            		"KeyValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:122:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==15) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:122:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleAnnotation192); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:126:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:127:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:127:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:128:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation213);
                    	    lv_attributes_5_0=ruleKeyValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_5_0, 
                    	            		"KeyValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleAnnotation227); 

                        	newLeafNode(otherlv_6, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:156:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:157:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:158:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue265);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue275); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:165:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:168:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:169:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:169:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:169:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:169:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:170:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:170:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:171:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue317); 

            			newLeafNode(lv_key_0_0, grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleKeyValue334); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:191:1: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:192:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:192:1: (lv_value_2_0= ruleLiteral )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:193:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleKeyValue355);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Literal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleAnnotationTargetType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:219:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:220:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:221:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType394);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType405); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationTargetType"


    // $ANTLR start "ruleAnnotationTargetType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:228:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:231:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:232:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType444); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationTargetType"


    // $ANTLR start "entryRuleAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:247:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:248:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:249:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute488);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute498); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationAttribute"


    // $ANTLR start "ruleAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:256:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:259:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:260:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:260:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==20) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_ID) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==21) ) {
                            int LA3_5 = input.LA(5);

                            if ( ((LA3_5>=32 && LA3_5<=35)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_5==22) ) {
                                alt3=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==19) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==20) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_ID) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==21) ) {
                            int LA3_5 = input.LA(5);

                            if ( ((LA3_5>=32 && LA3_5<=35)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_5==22) ) {
                                alt3=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:261:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute545);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:271:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute572);
                    this_EnumAnnotationAttribute_1=ruleEnumAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_EnumAnnotationAttribute_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationAttribute"


    // $ANTLR start "entryRuleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:287:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:288:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:289:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute607);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute617); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAnnotationAttribute"


    // $ANTLR start "ruleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:296:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
    public final EObject ruleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_type_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:299:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:300:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:301:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:301:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:302:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,18,FOLLOW_18_in_ruleSimpleAnnotationAttribute661); 

                            newLeafNode(lv_optional_0_0, grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "optional", true, "optional");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:316:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleSimpleAnnotationAttribute692); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleSimpleAnnotationAttribute705); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:324:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:325:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:325:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:326:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute722); 

            			newLeafNode(lv_name_3_0, grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleSimpleAnnotationAttribute739); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:346:1: ( (lv_type_5_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:347:1: (lv_type_5_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:347:1: (lv_type_5_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:348:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute760);
            lv_type_5_0=ruleLiteralType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_5_0, 
                    		"LiteralType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAnnotationAttribute"


    // $ANTLR start "entryRuleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:372:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:373:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:374:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute796);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute806); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumAnnotationAttribute"


    // $ANTLR start "ruleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:381:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_values_6_0=null;
        Token otherlv_7=null;
        Token lv_values_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:384:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:385:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:386:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:386:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:387:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,18,FOLLOW_18_in_ruleEnumAnnotationAttribute850); 

                            newLeafNode(lv_optional_0_0, grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "optional", true, "optional");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:401:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleEnumAnnotationAttribute881); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleEnumAnnotationAttribute894); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:409:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:410:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:410:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:411:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute911); 

            			newLeafNode(lv_name_3_0, grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleEnumAnnotationAttribute928); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleEnumAnnotationAttribute940); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:435:1: ( (lv_values_6_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:436:1: (lv_values_6_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:436:1: (lv_values_6_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:437:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute957); 

            			newLeafNode(lv_values_6_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"values",
                    		lv_values_6_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:453:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:453:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleEnumAnnotationAttribute975); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:457:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:458:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:458:1: (lv_values_8_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:459:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute992); 

            	    			newLeafNode(lv_values_8_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"values",
            	            		lv_values_8_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_9=(Token)match(input,23,FOLLOW_23_in_ruleEnumAnnotationAttribute1011); 

                	newLeafNode(otherlv_9, grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumAnnotationAttribute"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:489:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:490:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:491:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1050);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN1061); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:498:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:501:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:502:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:502:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:503:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN1108);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:513:1: (kw= '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:514:2: kw= '.*'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleImportedFQN1127); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:527:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:528:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:529:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation1169);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation1179); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:536:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:539:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:540:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:540:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:540:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:540:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:541:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleDocumentation1225); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:550:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_STRING) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:551:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:551:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:552:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation1242); 

            	    			newLeafNode(lv_lines_2_0, grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDocumentationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"lines",
            	            		lv_lines_2_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleDocumentation1260); 

                	newLeafNode(otherlv_3, grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:584:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:585:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:586:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1300);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1310); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:593:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:596:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:597:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:597:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 27:
            case 28:
                {
                alt9=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 29:
            case 30:
            case 31:
                {
                alt9=2;
                }
                break;
            case RULE_STRING:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:598:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral1357);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:608:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral1384);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:618:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral1411);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:634:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:635:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:636:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1446);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1456); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:643:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:646:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:647:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:647:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:647:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:647:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:648:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:653:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            else if ( (LA10_0==28) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:653:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleBooleanLiteral1503); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:658:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:658:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:659:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:659:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:660:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,28,FOLLOW_28_in_ruleBooleanLiteral1527); 

                            newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "isTrue", true, "true");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:681:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:682:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:683:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1577);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1587); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:690:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:693:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:694:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:694:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt11=2;
            switch ( input.LA(1) ) {
            case 29:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==31) ) {
                    alt11=2;
                }
                else if ( (LA11_1==RULE_INT) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==31) ) {
                        alt11=2;
                    }
                    else if ( (LA11_3==EOF||(LA11_3>=15 && LA11_3<=16)) ) {
                        alt11=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case 30:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==RULE_INT) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==31) ) {
                        alt11=2;
                    }
                    else if ( (LA11_3==EOF||(LA11_3>=15 && LA11_3<=16)) ) {
                        alt11=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA11_2==31) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==31) ) {
                    alt11=2;
                }
                else if ( (LA11_3==EOF||(LA11_3>=15 && LA11_3<=16)) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt11=1;
                }
                break;
            case 31:
                {
                alt11=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:695:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral1634);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:705:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral1661);
                    this_RealLiteral_1=ruleRealLiteral();

                    state._fsp--;

                     
                            current = this_RealLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:721:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:722:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:723:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1696);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1706); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:730:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:733:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:734:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:734:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:734:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:734:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:735:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:740:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:741:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:741:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:742:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral1761);
            lv_value_1_0=ruleReal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"Real");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:766:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:767:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:768:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1797);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1807); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:775:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:778:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:779:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:779:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:779:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:779:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:780:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:785:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:786:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:786:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:787:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral1862);
            lv_value_1_0=ruleInteger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"Integer");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:811:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:812:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:813:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1898);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1908); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:820:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:823:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:824:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:824:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:824:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:824:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:825:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:830:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:831:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:831:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:832:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral1959); 

            			newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleInteger"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:856:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:857:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:858:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger2001);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger2012); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:865:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:868:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:869:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:869:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT||(LA12_0>=29 && LA12_0<=30)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_HEX) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:870:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger2059);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:882:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger2092);
                    this_Hexadecimal_1=ruleHexadecimal();

                    state._fsp--;


                    		current.merge(this_Hexadecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleSignedInteger"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:900:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:904:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:905:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2144);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger2155); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInteger"


    // $ANTLR start "ruleSignedInteger"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:915:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:919:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:920:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:920:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:920:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:920:2: (kw= '+' | kw= '-' )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:921:2: kw= '+'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleSignedInteger2198); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:928:2: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleSignedInteger2217); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger2234); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleSignedInteger"


    // $ANTLR start "entryRuleHexadecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:951:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:955:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:956:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2290);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal2301); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleHexadecimal"


    // $ANTLR start "ruleHexadecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:966:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:970:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:971:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal2344); 

            		current.merge(this_HEX_0);
                
             
                newLeafNode(this_HEX_0, grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleHexadecimal"


    // $ANTLR start "entryRuleReal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:989:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:990:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:991:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal2393);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal2404); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:998:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1001:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1002:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1002:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt14=4;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1003:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal2451);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1015:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal2484);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1027:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal2517);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1039:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal2550);
                    this_DecimalExp_3=ruleDecimalExp();

                    state._fsp--;


                    		current.merge(this_DecimalExp_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReal"


    // $ANTLR start "entryRuleDecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1057:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1061:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1062:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal2602);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal2613); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1072:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1076:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1077:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1077:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1077:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1077:2: (kw= '+' | kw= '-' )?
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            else if ( (LA15_0==30) ) {
                alt15=2;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1078:2: kw= '+'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleDecimal2656); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1085:2: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimal2675); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal2692); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimal2710); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal2725); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleDotDecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1121:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1125:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1126:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal2781);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal2792); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDotDecimal"


    // $ANTLR start "ruleDotDecimal"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1136:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1140:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1141:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1141:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1141:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1141:2: (kw= '+' | kw= '-' )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            else if ( (LA16_0==30) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1142:2: kw= '+'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleDotDecimal2835); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1149:2: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDotDecimal2854); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,31,FOLLOW_31_in_ruleDotDecimal2869); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal2884); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDotDecimal"


    // $ANTLR start "entryRuleDecimalDot"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1178:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1182:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1183:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot2940);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot2951); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDecimalDot"


    // $ANTLR start "ruleDecimalDot"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1193:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1197:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1198:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1198:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1198:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1198:2: (kw= '+' | kw= '-' )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
                alt17=2;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1199:2: kw= '+'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleDecimalDot2994); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1206:2: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimalDot3013); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot3030); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalDot3048); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDecimalDot"


    // $ANTLR start "entryRuleDecimalExp"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1235:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1239:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1240:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3099);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp3110); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDecimalExp"


    // $ANTLR start "ruleDecimalExp"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1250:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1254:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1255:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1255:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1255:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1255:2: (kw= '+' | kw= '-' )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1256:2: kw= '+'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleDecimalExp3153); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1263:2: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimalExp3172); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3189); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalExp3207); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3222); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp3242); 

            		current.merge(this_EXP_5);
                
             
                newLeafNode(this_EXP_5, grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDecimalExp"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1306:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1307:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1308:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3292);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3303); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1315:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1318:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1319:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1319:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1319:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3343); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1326:1: (kw= '.' this_ID_2= RULE_ID )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==31) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1327:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleFQN3362); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3377); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1347:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1349:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1350:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1350:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt20=1;
                }
                break;
            case 33:
                {
                alt20=2;
                }
                break;
            case 34:
                {
                alt20=3;
                }
                break;
            case 35:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1350:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1350:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1350:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,32,FOLLOW_32_in_ruleLiteralType3438); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1356:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1356:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1356:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,33,FOLLOW_33_in_ruleLiteralType3455); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1362:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1362:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1362:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,34,FOLLOW_34_in_ruleLiteralType3472); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1368:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1368:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBase.g:1368:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,35,FOLLOW_35_in_ruleLiteralType3489); 

                            current = grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralType"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\5\uffff\1\6\1\uffff\1\11\2\uffff";
    static final String DFA14_minS =
        "\3\6\1\37\1\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA14_maxS =
        "\4\37\1\uffff\1\20\1\uffff\1\20\2\uffff";
    static final String DFA14_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\4\1\1";
    static final String DFA14_specialS =
        "\12\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\26\uffff\1\1\1\2\1\4",
            "\1\3\30\uffff\1\4",
            "\1\3\30\uffff\1\4",
            "\1\5",
            "",
            "\1\7\10\uffff\2\6",
            "",
            "\1\10\6\uffff\2\11",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1002:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAnnotation122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleAnnotation145 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAnnotation158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation179 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleAnnotation192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation213 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleAnnotation227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue317 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKeyValue334 = new BitSet(new long[]{0x00000000F80000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSimpleAnnotationAttribute661 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleAnnotationAttribute692 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleAnnotationAttribute705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute722 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSimpleAnnotationAttribute739 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleEnumAnnotationAttribute850 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19_in_ruleEnumAnnotationAttribute881 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEnumAnnotationAttribute894 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute911 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEnumAnnotationAttribute928 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEnumAnnotationAttribute940 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute957 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_15_in_ruleEnumAnnotationAttribute975 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute992 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_23_in_ruleEnumAnnotationAttribute1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN1108 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleImportedFQN1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation1169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleDocumentation1225 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation1242 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleDocumentation1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleBooleanLiteral1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleBooleanLiteral1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger2001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleSignedInteger2198 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30_in_ruleSignedInteger2217 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal2393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal2602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDecimal2656 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30_in_ruleDecimal2675 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal2692 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDecimal2710 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal2781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDotDecimal2835 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_30_in_ruleDotDecimal2854 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDotDecimal2869 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot2940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDecimalDot2994 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30_in_ruleDecimalDot3013 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot3030 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDecimalDot3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDecimalExp3153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30_in_ruleDecimalExp3172 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3189 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDecimalExp3207 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3222 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3343 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleFQN3362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3377 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_32_in_ruleLiteralType3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleLiteralType3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleLiteralType3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLiteralType3489 = new BitSet(new long[]{0x0000000000000002L});

}