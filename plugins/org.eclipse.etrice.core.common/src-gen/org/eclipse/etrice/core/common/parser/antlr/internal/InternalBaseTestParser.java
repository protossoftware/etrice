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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'('", "','", "')'", "'='", "'AnnotationType'", "'{'", "'target'", "'}'", "'optional'", "'mandatory'", "'attribute'", "':'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    public static final int T__37=37;
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

            if ( (LA5_0==27) ) {
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

                            if ( (LA9_5==19) ) {
                                alt9=2;
                            }
                            else if ( ((LA9_5>=34 && LA9_5<=37)) ) {
                                alt9=1;
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

                            if ( (LA9_5==19) ) {
                                alt9=2;
                            }
                            else if ( ((LA9_5>=34 && LA9_5<=37)) ) {
                                alt9=1;
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


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:706:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:707:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:708:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1472);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN1483); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:715:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:718:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:719:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:719:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:720:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN1530);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:730:1: (kw= '.*' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:731:2: kw= '.*'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleImportedFQN1549); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:744:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:745:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:746:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation1591);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation1601); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:753:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:756:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:757:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:757:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:757:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:757:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:758:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleDocumentation1647); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:767:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_STRING) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:768:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:768:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:769:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation1664); 

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
            	    break loop14;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleDocumentation1682); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:801:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:802:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:803:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1722);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1732); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:810:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:813:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:814:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:814:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
                {
                alt15=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 31:
            case 32:
            case 33:
                {
                alt15=2;
                }
                break;
            case RULE_STRING:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:815:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral1779);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:825:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral1806);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:835:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral1833);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:851:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:852:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:853:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1868);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1878); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:860:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:863:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:864:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:864:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:864:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:864:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:865:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:870:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            else if ( (LA16_0==30) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:870:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleBooleanLiteral1925); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:875:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:875:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:876:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:876:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:877:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,30,FOLLOW_30_in_ruleBooleanLiteral1949); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:898:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:899:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:900:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1999);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral2009); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:907:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:910:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:911:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:911:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt17=2;
            switch ( input.LA(1) ) {
            case 31:
                {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==RULE_INT) ) {
                    int LA17_3 = input.LA(3);

                    if ( (LA17_3==33) ) {
                        alt17=2;
                    }
                    else if ( (LA17_3==EOF||(LA17_3>=15 && LA17_3<=16)) ) {
                        alt17=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_1==33) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case 32:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==RULE_INT) ) {
                    int LA17_3 = input.LA(3);

                    if ( (LA17_3==33) ) {
                        alt17=2;
                    }
                    else if ( (LA17_3==EOF||(LA17_3>=15 && LA17_3<=16)) ) {
                        alt17=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_2==33) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA17_3 = input.LA(2);

                if ( (LA17_3==33) ) {
                    alt17=2;
                }
                else if ( (LA17_3==EOF||(LA17_3>=15 && LA17_3<=16)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt17=1;
                }
                break;
            case 33:
                {
                alt17=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:912:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral2056);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:922:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral2083);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:938:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:939:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:940:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral2118);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral2128); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:947:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:950:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:951:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:951:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:951:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:951:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:952:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:957:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:958:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:958:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:959:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral2183);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:983:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:984:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:985:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral2219);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral2229); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:992:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:995:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:996:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:996:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:996:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:996:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:997:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1002:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1003:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1003:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1004:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral2284);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1028:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1029:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1030:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2320);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral2330); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1037:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1040:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1041:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1041:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1041:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1041:2: ()
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1042:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1047:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1048:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1048:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1049:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral2381); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1073:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1074:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1075:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger2423);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger2434); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1082:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1085:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1086:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1086:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT||(LA18_0>=31 && LA18_0<=32)) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_HEX) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1087:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger2481);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1099:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger2514);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1117:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1121:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1122:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2566);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger2577); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1132:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1136:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1137:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1137:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1137:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1137:2: (kw= '+' | kw= '-' )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            else if ( (LA19_0==32) ) {
                alt19=2;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1138:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleSignedInteger2620); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1145:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleSignedInteger2639); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger2656); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1168:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1172:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1173:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2712);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal2723); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1183:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1187:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1188:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal2766); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1206:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1207:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1208:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal2815);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal2826); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1215:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1218:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1219:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1219:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt20=4;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1220:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal2873);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1232:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal2906);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1244:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal2939);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1256:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal2972);
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1274:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1278:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1279:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal3024);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal3035); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1289:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1293:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1294:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1294:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1294:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1294:2: (kw= '+' | kw= '-' )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            else if ( (LA21_0==32) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1295:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimal3078); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1302:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimal3097); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal3114); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,33,FOLLOW_33_in_ruleDecimal3132); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal3147); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1338:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1342:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1343:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal3203);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal3214); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1353:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1357:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1358:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1358:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1358:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1358:2: (kw= '+' | kw= '-' )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            else if ( (LA22_0==32) ) {
                alt22=2;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1359:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDotDecimal3257); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1366:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleDotDecimal3276); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,33,FOLLOW_33_in_ruleDotDecimal3291); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal3306); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1395:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1399:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1400:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot3362);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot3373); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1410:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1414:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1415:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1415:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1415:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1415:2: (kw= '+' | kw= '-' )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            else if ( (LA23_0==32) ) {
                alt23=2;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1416:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalDot3416); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1423:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimalDot3435); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot3452); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,33,FOLLOW_33_in_ruleDecimalDot3470); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1452:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1456:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1457:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3521);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp3532); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1467:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1471:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1472:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1472:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1472:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1472:2: (kw= '+' | kw= '-' )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            else if ( (LA24_0==32) ) {
                alt24=2;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1473:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDecimalExp3575); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1480:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleDecimalExp3594); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3611); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,33,FOLLOW_33_in_ruleDecimalExp3629); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp3644); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp3664); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1523:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1524:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1525:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3714);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3725); 

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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1532:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1535:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1536:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1536:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1536:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3765); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1543:1: (kw= '.' this_ID_2= RULE_ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==33) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1544:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,33,FOLLOW_33_in_ruleFQN3784); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3799); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1564:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1566:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1567:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1567:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt26=1;
                }
                break;
            case 35:
                {
                alt26=2;
                }
                break;
            case 36:
                {
                alt26=3;
                }
                break;
            case 37:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1567:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1567:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1567:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_34_in_ruleLiteralType3860); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1573:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1573:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1573:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_35_in_ruleLiteralType3877); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1579:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1579:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1579:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_36_in_ruleLiteralType3894); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1585:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1585:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.common/src-gen/org/eclipse/etrice/core/common/parser/antlr/internal/InternalBaseTest.g:1585:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,37,FOLLOW_37_in_ruleLiteralType3911); 

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


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\12\uffff";
    static final String DFA20_eofS =
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA20_minS =
        "\3\6\1\41\1\uffff\1\6\1\10\3\uffff";
    static final String DFA20_maxS =
        "\4\41\1\uffff\2\20\3\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA20_specialS =
        "\12\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\30\uffff\1\1\1\2\1\4",
            "\1\3\32\uffff\1\4",
            "\1\3\32\uffff\1\4",
            "\1\5",
            "",
            "\1\6\10\uffff\2\7",
            "\1\10\6\uffff\2\11",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1219:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
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
    public static final BitSet FOLLOW_17_in_ruleKeyValue449 = new BitSet(new long[]{0x00000003E00000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationType_in_entryRuleAnnotationType506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationType516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAnnotationType553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationType570 = new BitSet(new long[]{0x0000000008080000L});
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
    public static final BitSet FOLLOW_25_in_ruleSimpleAnnotationAttribute1161 = new BitSet(new long[]{0x0000003C00000000L});
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
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN1530 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleImportedFQN1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation1591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDocumentation1647 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation1664 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_ruleDocumentation1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanLiteral1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBooleanLiteral1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral2118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral2219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral2320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger2423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger2566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleSignedInteger2620 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleSignedInteger2639 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal2712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal2815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal2873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal3024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDecimal3078 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleDecimal3097 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal3114 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleDecimal3132 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal3203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDotDecimal3257 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32_in_ruleDotDecimal3276 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleDotDecimal3291 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot3362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDecimalDot3416 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleDecimalDot3435 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot3452 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleDecimalDot3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp3521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDecimalExp3575 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleDecimalExp3594 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3611 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleDecimalExp3629 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp3644 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3765 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleFQN3784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3799 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_34_in_ruleLiteralType3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLiteralType3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleLiteralType3894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleLiteralType3911 = new BitSet(new long[]{0x0000000000000002L});

}