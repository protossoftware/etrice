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
import org.eclipse.etrice.core.common.services.BaseTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'('", "','", "')'", "'='", "'AnnotationType'", "'{'", "'target'", "'}'", "'optional'", "'mandatory'", "'attribute'", "':'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalBaseTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBaseTestParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g"; }



     	private BaseTestGrammarAccess grammarAccess;
     	
        public InternalBaseTestParser(TokenStream input, BaseTestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BaseModel";	
       	}
       	
       	@Override
       	protected BaseTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBaseModel"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:68:1: entryRuleBaseModel returns [EObject current=null] : iv_ruleBaseModel= ruleBaseModel EOF ;
    public final EObject entryRuleBaseModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseModel = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:69:2: (iv_ruleBaseModel= ruleBaseModel EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:70:2: iv_ruleBaseModel= ruleBaseModel EOF
            {
             newCompositeNode(grammarAccess.getBaseModelRule()); 
            pushFollow(FOLLOW_ruleBaseModel_in_entryRuleBaseModel75);
            iv_ruleBaseModel=ruleBaseModel();

            state._fsp--;

             current =iv_ruleBaseModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseModel85); 

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
    // $ANTLR end "entryRuleBaseModel"


    // $ANTLR start "ruleBaseModel"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:77:1: ruleBaseModel returns [EObject current=null] : ( ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) ) )* ;
    public final EObject ruleBaseModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_1 = null;

        EObject lv_elements_0_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:80:28: ( ( ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) ) )* )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:81:1: ( ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) ) )*
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:81:1: ( ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:82:1: ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:82:1: ( (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType ) )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:83:1: (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:83:1: (lv_elements_0_1= ruleAnnotation | lv_elements_0_2= ruleAnnotationType )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==13) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==18) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:84:3: lv_elements_0_1= ruleAnnotation
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBaseModelAccess().getElementsAnnotationParserRuleCall_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAnnotation_in_ruleBaseModel132);
            	            lv_elements_0_1=ruleAnnotation();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getBaseModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"elements",
            	                    		lv_elements_0_1, 
            	                    		"Annotation");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:99:8: lv_elements_0_2= ruleAnnotationType
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBaseModelAccess().getElementsAnnotationTypeParserRuleCall_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAnnotationType_in_ruleBaseModel151);
            	            lv_elements_0_2=ruleAnnotationType();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getBaseModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"elements",
            	                    		lv_elements_0_2, 
            	                    		"AnnotationType");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruleBaseModel"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:125:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:126:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:127:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation190);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation200); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:134:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:137:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:138:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:138:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:138:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAnnotation237); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:142:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:143:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:143:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:144:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleAnnotation260);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:157:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:157:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleAnnotation273); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:161:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:162:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:162:1: (lv_attributes_3_0= ruleKeyValue )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:163:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation294);
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

                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:179:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:179:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleAnnotation307); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:183:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:184:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:184:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:185:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation328);
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
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleAnnotation342); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:213:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:214:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:215:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue380);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue390); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:222:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:225:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:226:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:226:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:226:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:226:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:227:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:227:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:228:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue432); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleKeyValue449); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:248:1: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:249:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:249:1: (lv_value_2_0= ruleLiteral )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:250:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleKeyValue470);
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


    // $ANTLR start "entryRuleAnnotationType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:274:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:275:2: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:276:2: iv_ruleAnnotationType= ruleAnnotationType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationType_in_entryRuleAnnotationType506);
            iv_ruleAnnotationType=ruleAnnotationType();

            state._fsp--;

             current =iv_ruleAnnotationType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationType516); 

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
    // $ANTLR end "entryRuleAnnotationType"


    // $ANTLR start "ruleAnnotationType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:283:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
    public final EObject ruleAnnotationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_docu_2_0 = null;

        AntlrDatatypeRuleToken lv_targets_6_0 = null;

        AntlrDatatypeRuleToken lv_targets_8_0 = null;

        AntlrDatatypeRuleToken lv_targets_10_0 = null;

        EObject lv_attributes_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:286:28: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:287:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:287:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:287:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleAnnotationType553); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:291:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:292:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:292:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:293:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationType570); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:309:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:310:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:310:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:311:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleAnnotationType596);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleAnnotationType609); 

                	newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleAnnotationType621); 

                	newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
                
            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleAnnotationType633); 

                	newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:339:1: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:339:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:339:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:340:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:340:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:341:3: lv_targets_6_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType655);
                    lv_targets_6_0=ruleAnnotationTargetType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"targets",
                            		lv_targets_6_0, 
                            		"AnnotationTargetType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:358:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:358:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:358:8: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleAnnotationType674); 

                        	newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                        
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:362:1: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:363:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:363:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:364:3: lv_targets_8_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType695);
                    lv_targets_8_0=ruleAnnotationTargetType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"targets",
                            		lv_targets_8_0, 
                            		"AnnotationTargetType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:380:2: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==15) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:380:4: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleAnnotationType708); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:384:1: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:385:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:385:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:386:3: lv_targets_10_0= ruleAnnotationTargetType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType729);
                    	    lv_targets_10_0=ruleAnnotationTargetType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"targets",
                    	            		lv_targets_10_0, 
                    	            		"AnnotationTargetType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleAnnotationType743); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:406:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:407:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:407:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:408:3: lv_attributes_12_0= ruleAnnotationAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotationAttribute_in_ruleAnnotationType766);
            	    lv_attributes_12_0=ruleAnnotationAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_12_0, 
            	            		"AnnotationAttribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleAnnotationType779); 

                	newLeafNode(otherlv_13, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_8());
                

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
    // $ANTLR end "ruleAnnotationType"


    // $ANTLR start "entryRuleAnnotationTargetType"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:436:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:437:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:438:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType816);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType827); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:445:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:448:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:449:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType866); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:464:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:465:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:466:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute910);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute920); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:473:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:476:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:477:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:477:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==24) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==RULE_ID) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==25) ) {
                            int LA9_5 = input.LA(5);

                            if ( ((LA9_5>=33 && LA9_5<=36)) ) {
                                alt9=1;
                            }
                            else if ( (LA9_5==19) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==23) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==24) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==RULE_ID) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==25) ) {
                            int LA9_5 = input.LA(5);

                            if ( ((LA9_5>=33 && LA9_5<=36)) ) {
                                alt9=1;
                            }
                            else if ( (LA9_5==19) ) {
                                alt9=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:478:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute967);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:488:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute994);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:504:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:505:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:506:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute1029);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute1039); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:513:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:516:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            else if ( (LA10_0==23) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:517:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:518:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:518:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:519:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,22,FOLLOW_22_in_ruleSimpleAnnotationAttribute1083); 

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
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:533:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleSimpleAnnotationAttribute1114); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleSimpleAnnotationAttribute1127); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:541:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:542:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:542:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:543:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute1144); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSimpleAnnotationAttribute1161); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:563:1: ( (lv_type_5_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:564:1: (lv_type_5_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:564:1: (lv_type_5_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:565:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute1182);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:589:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:590:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:591:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute1218);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute1228); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:598:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:601:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            else if ( (LA11_0==23) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:602:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:603:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:603:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:604:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,22,FOLLOW_22_in_ruleEnumAnnotationAttribute1272); 

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
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:618:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleEnumAnnotationAttribute1303); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleEnumAnnotationAttribute1316); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:626:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:627:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:627:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:628:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute1333); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleEnumAnnotationAttribute1350); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleEnumAnnotationAttribute1362); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:652:1: ( (lv_values_6_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:653:1: (lv_values_6_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:653:1: (lv_values_6_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:654:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute1379); 

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

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:670:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:670:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleEnumAnnotationAttribute1397); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:674:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:675:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:675:1: (lv_values_8_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:676:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute1414); 

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
            	    break loop12;
                }
            } while (true);

            otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleEnumAnnotationAttribute1433); 

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


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:704:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:705:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:706:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation1469);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation1479); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:713:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:716:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:717:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:717:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:717:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:717:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:718:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleDocumentation1525); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:727:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_STRING) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:728:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:728:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:729:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation1542); 

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
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleDocumentation1560); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:759:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:760:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:761:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1598);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1608); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:768:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:771:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:772:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:772:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
                {
                alt14=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 30:
            case 31:
            case 32:
                {
                alt14=2;
                }
                break;
            case RULE_STRING:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:773:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral1655);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:783:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral1682);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:793:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral1709);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:809:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:810:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:811:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1744);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1754); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:818:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:821:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:822:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:822:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:822:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:822:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:823:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:828:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            else if ( (LA15_0==29) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:828:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleBooleanLiteral1801); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:833:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:833:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:834:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:834:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:835:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,29,FOLLOW_29_in_ruleBooleanLiteral1825); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:856:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:857:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:858:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1875);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1885); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:865:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:868:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:869:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:869:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt16=2;
            switch ( input.LA(1) ) {
            case 30:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==32) ) {
                        alt16=2;
                    }
                    else if ( (LA16_3==EOF||(LA16_3>=15 && LA16_3<=16)) ) {
                        alt16=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA16_1==32) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case 31:
                {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==32) ) {
                        alt16=2;
                    }
                    else if ( (LA16_3==EOF||(LA16_3>=15 && LA16_3<=16)) ) {
                        alt16=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA16_2==32) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA16_3 = input.LA(2);

                if ( (LA16_3==32) ) {
                    alt16=2;
                }
                else if ( (LA16_3==EOF||(LA16_3>=15 && LA16_3<=16)) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt16=1;
                }
                break;
            case 32:
                {
                alt16=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:870:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral1932);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:880:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral1959);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:896:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:897:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:898:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1994);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral2004); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:905:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:908:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:909:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:909:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:909:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:909:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:910:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:915:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:916:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:916:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:917:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral2059);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:941:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:942:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:943:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral2095);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral2105); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:950:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:953:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:954:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:954:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:954:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:954:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:955:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:960:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:961:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:961:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:962:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral2160);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:986:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:987:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:988:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2196);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral2206); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:995:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:998:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:999:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:999:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:999:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:999:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1000:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1005:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1006:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1006:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1007:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral2257); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1031:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1032:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1033:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger2299);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger2310); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1040:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1043:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1044:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1044:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT||(LA17_0>=30 && LA17_0<=31)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_HEX) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1045:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger2357);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1057:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger2390);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1075:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1079:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1080:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2442);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger2453); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1090:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1094:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1095:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1095:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1095:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1095:2: (kw= '+' | kw= '-' )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            else if ( (LA18_0==31) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1096:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleSignedInteger2496); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1103:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleSignedInteger2515); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger2532); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1126:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1130:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1131:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2588);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal2599); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1141:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1145:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1146:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal2642); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1164:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1165:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1166:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal2691);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal2702); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1173:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1176:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1177:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1177:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1178:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal2749);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1190:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal2782);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1202:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal2815);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1214:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal2848);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1232:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1236:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1237:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal2900);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal2911); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1247:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1251:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1252:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1252:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1252:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1252:2: (kw= '+' | kw= '-' )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            else if ( (LA20_0==31) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1253:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimal2954); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1260:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimal2973); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal2990); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimal3008); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal3023); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1296:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1300:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1301:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal3079);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal3090); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1311:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1315:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1316:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1316:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1316:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1316:2: (kw= '+' | kw= '-' )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            else if ( (LA21_0==31) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1317:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDotDecimal3133); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1324:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDotDecimal3152); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,32,FOLLOW_32_in_ruleDotDecimal3167); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal3182); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1353:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1357:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1358:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot3238);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot3249); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1368:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1372:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1373:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1373:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1373:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1373:2: (kw= '+' | kw= '-' )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            else if ( (LA22_0==31) ) {
                alt22=2;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1374:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimalDot3292); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1381:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalDot3311); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot3328); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimalDot3346); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1410:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1414:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1415:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3397);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp3408); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1425:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1429:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1430:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1430:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1430:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1430:2: (kw= '+' | kw= '-' )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            else if ( (LA23_0==31) ) {
                alt23=2;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1431:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleDecimalExp3451); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1438:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalExp3470); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3487); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimalExp3505); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3520); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp3540); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1481:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1482:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1483:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3590);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3601); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1490:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1493:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1494:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1494:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1494:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3641); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1501:1: (kw= '.' this_ID_2= RULE_ID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1502:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,32,FOLLOW_32_in_ruleFQN3660); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3675); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1522:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1524:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt25=1;
                }
                break;
            case 34:
                {
                alt25=2;
                }
                break;
            case 35:
                {
                alt25=3;
                }
                break;
            case 36:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleLiteralType3736); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1531:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1531:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1531:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_34_in_ruleLiteralType3753); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1537:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1537:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1537:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,35,FOLLOW_35_in_ruleLiteralType3770); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1543:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1543:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1543:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,36,FOLLOW_36_in_ruleLiteralType3787); 

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


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\12\uffff";
    static final String DFA19_eofS =
        "\5\uffff\1\6\1\uffff\1\11\2\uffff";
    static final String DFA19_minS =
        "\3\6\1\40\1\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA19_maxS =
        "\4\40\1\uffff\1\20\1\uffff\1\20\2\uffff";
    static final String DFA19_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\4\1\1";
    static final String DFA19_specialS =
        "\12\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\3\27\uffff\1\1\1\2\1\4",
            "\1\3\31\uffff\1\4",
            "\1\3\31\uffff\1\4",
            "\1\5",
            "",
            "\1\7\10\uffff\2\6",
            "",
            "\1\10\6\uffff\2\11",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1177:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleBaseModel_in_entryRuleBaseModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleBaseModel132 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_ruleAnnotationType_in_ruleBaseModel151 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAnnotation237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleAnnotation260 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAnnotation273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation294 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleAnnotation307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation328 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleAnnotation342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue432 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKeyValue449 = new BitSet(new long[]{0x00000001F00000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationType_in_entryRuleAnnotationType506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationType516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAnnotationType553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationType570 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleAnnotationType596 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAnnotationType609 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAnnotationType621 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAnnotationType633 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType655 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_19_in_ruleAnnotationType674 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType695 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_15_in_ruleAnnotationType708 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_ruleAnnotationType729 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleAnnotationType743 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_ruleAnnotationType766 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_21_in_ruleAnnotationType779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleSimpleAnnotationAttribute1083 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23_in_ruleSimpleAnnotationAttribute1114 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSimpleAnnotationAttribute1127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute1144 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSimpleAnnotationAttribute1161 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute1218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleEnumAnnotationAttribute1272 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23_in_ruleEnumAnnotationAttribute1303 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleEnumAnnotationAttribute1316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute1333 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEnumAnnotationAttribute1350 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEnumAnnotationAttribute1362 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute1379 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_15_in_ruleEnumAnnotationAttribute1397 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute1414 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleEnumAnnotationAttribute1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation1469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDocumentation1525 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation1542 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_ruleDocumentation1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleBooleanLiteral1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanLiteral1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral2095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger2299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleSignedInteger2496 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31_in_ruleSignedInteger2515 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal2691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal2900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDecimal2954 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31_in_ruleDecimal2973 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal2990 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDecimal3008 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal3079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDotDecimal3133 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31_in_ruleDotDecimal3152 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDotDecimal3167 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot3238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDecimalDot3292 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31_in_ruleDecimalDot3311 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot3328 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDecimalDot3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDecimalExp3451 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31_in_ruleDecimalExp3470 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3487 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDecimalExp3505 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3520 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3590 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3641 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleFQN3660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3675 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_33_in_ruleLiteralType3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleLiteralType3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLiteralType3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleLiteralType3787 = new BitSet(new long[]{0x0000000000000002L});

}