package org.eclipse.etrice.generator.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.generator.services.FSMtestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFSMtestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'fsmtest'", "';'", "'states:'", "','", "'initial:'", "'loops:'", "'randseed:'", "'.'", "'='", "':'", "'-> '", "'in:'", "'out:'"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalFSMtestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFSMtestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFSMtestParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g"; }



     	private FSMtestGrammarAccess grammarAccess;
     	
        public InternalFSMtestParser(TokenStream input, FSMtestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected FSMtestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:76:1: ruleModel returns [EObject current=null] : ( (lv_Testscripts_0_0= ruleTestscript ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_Testscripts_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:79:28: ( ( (lv_Testscripts_0_0= ruleTestscript ) )* )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:1: ( (lv_Testscripts_0_0= ruleTestscript ) )*
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:1: ( (lv_Testscripts_0_0= ruleTestscript ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:81:1: (lv_Testscripts_0_0= ruleTestscript )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:81:1: (lv_Testscripts_0_0= ruleTestscript )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:82:3: lv_Testscripts_0_0= ruleTestscript
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getTestscriptsTestscriptParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestscript_in_ruleModel130);
            	    lv_Testscripts_0_0=ruleTestscript();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"Testscripts",
            	            		lv_Testscripts_0_0, 
            	            		"Testscript");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTestscript"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:106:1: entryRuleTestscript returns [EObject current=null] : iv_ruleTestscript= ruleTestscript EOF ;
    public final EObject entryRuleTestscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestscript = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:107:2: (iv_ruleTestscript= ruleTestscript EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:108:2: iv_ruleTestscript= ruleTestscript EOF
            {
             newCompositeNode(grammarAccess.getTestscriptRule()); 
            pushFollow(FOLLOW_ruleTestscript_in_entryRuleTestscript166);
            iv_ruleTestscript=ruleTestscript();

            state._fsp--;

             current =iv_ruleTestscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestscript176); 

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
    // $ANTLR end "entryRuleTestscript"


    // $ANTLR start "ruleTestscript"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:115:1: ruleTestscript returns [EObject current=null] : (otherlv_0= 'fsmtest' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) ) ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )* otherlv_7= ';' ) ;
    public final EObject ruleTestscript() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_7=null;
        EObject lv_stateDeclaration_2_0 = null;

        EObject lv_initialDeclaration_3_0 = null;

        EObject lv_loopsDeclaration_4_0 = null;

        EObject lv_seedDeclaration_5_0 = null;

        EObject lv_transitionDeclarations_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:118:28: ( (otherlv_0= 'fsmtest' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) ) ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )* otherlv_7= ';' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:119:1: (otherlv_0= 'fsmtest' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) ) ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )* otherlv_7= ';' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:119:1: (otherlv_0= 'fsmtest' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) ) ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )* otherlv_7= ';' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:119:3: otherlv_0= 'fsmtest' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) ) ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )* otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTestscript213); 

                	newLeafNode(otherlv_0, grammarAccess.getTestscriptAccess().getFsmtestKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:123:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:124:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:124:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:125:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTestscript230); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTestscriptAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTestscriptRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:141:2: ( (lv_stateDeclaration_2_0= ruleStateDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:142:1: (lv_stateDeclaration_2_0= ruleStateDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:142:1: (lv_stateDeclaration_2_0= ruleStateDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:143:3: lv_stateDeclaration_2_0= ruleStateDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getTestscriptAccess().getStateDeclarationStateDeclarationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleStateDeclaration_in_ruleTestscript256);
            lv_stateDeclaration_2_0=ruleStateDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestscriptRule());
            	        }
                   		set(
                   			current, 
                   			"stateDeclaration",
                    		lv_stateDeclaration_2_0, 
                    		"StateDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:159:2: ( (lv_initialDeclaration_3_0= ruleInitialDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:160:1: (lv_initialDeclaration_3_0= ruleInitialDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:160:1: (lv_initialDeclaration_3_0= ruleInitialDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:161:3: lv_initialDeclaration_3_0= ruleInitialDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getTestscriptAccess().getInitialDeclarationInitialDeclarationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleInitialDeclaration_in_ruleTestscript277);
            lv_initialDeclaration_3_0=ruleInitialDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestscriptRule());
            	        }
                   		set(
                   			current, 
                   			"initialDeclaration",
                    		lv_initialDeclaration_3_0, 
                    		"InitialDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:177:2: ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:178:1: (lv_loopsDeclaration_4_0= ruleLoopsDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:178:1: (lv_loopsDeclaration_4_0= ruleLoopsDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:179:3: lv_loopsDeclaration_4_0= ruleLoopsDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getTestscriptAccess().getLoopsDeclarationLoopsDeclarationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLoopsDeclaration_in_ruleTestscript298);
            lv_loopsDeclaration_4_0=ruleLoopsDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestscriptRule());
            	        }
                   		set(
                   			current, 
                   			"loopsDeclaration",
                    		lv_loopsDeclaration_4_0, 
                    		"LoopsDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:195:2: ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:196:1: (lv_seedDeclaration_5_0= ruleSeedDeclaration )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:196:1: (lv_seedDeclaration_5_0= ruleSeedDeclaration )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:197:3: lv_seedDeclaration_5_0= ruleSeedDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestscriptAccess().getSeedDeclarationSeedDeclarationParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSeedDeclaration_in_ruleTestscript319);
                    lv_seedDeclaration_5_0=ruleSeedDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestscriptRule());
                    	        }
                           		set(
                           			current, 
                           			"seedDeclaration",
                            		lv_seedDeclaration_5_0, 
                            		"SeedDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:213:3: ( (lv_transitionDeclarations_6_0= ruleTransitionDeclaration ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:214:1: (lv_transitionDeclarations_6_0= ruleTransitionDeclaration )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:214:1: (lv_transitionDeclarations_6_0= ruleTransitionDeclaration )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:215:3: lv_transitionDeclarations_6_0= ruleTransitionDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestscriptAccess().getTransitionDeclarationsTransitionDeclarationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransitionDeclaration_in_ruleTestscript341);
            	    lv_transitionDeclarations_6_0=ruleTransitionDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestscriptRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitionDeclarations",
            	            		lv_transitionDeclarations_6_0, 
            	            		"TransitionDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleTestscript354); 

                	newLeafNode(otherlv_7, grammarAccess.getTestscriptAccess().getSemicolonKeyword_7());
                

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
    // $ANTLR end "ruleTestscript"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:243:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:244:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:245:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState390);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState400); 

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:252:1: ruleState returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:255:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:256:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:256:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:257:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:257:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:258:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState441); 

            			newLeafNode(lv_name_0_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStateDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:282:1: entryRuleStateDeclaration returns [EObject current=null] : iv_ruleStateDeclaration= ruleStateDeclaration EOF ;
    public final EObject entryRuleStateDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:283:2: (iv_ruleStateDeclaration= ruleStateDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:284:2: iv_ruleStateDeclaration= ruleStateDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStateDeclarationRule()); 
            pushFollow(FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration481);
            iv_ruleStateDeclaration=ruleStateDeclaration();

            state._fsp--;

             current =iv_ruleStateDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateDeclaration491); 

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
    // $ANTLR end "entryRuleStateDeclaration"


    // $ANTLR start "ruleStateDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:291:1: ruleStateDeclaration returns [EObject current=null] : (otherlv_0= 'states:' ( (lv_states_1_0= ruleState ) ) (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )* ) ;
    public final EObject ruleStateDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_states_1_0 = null;

        EObject lv_states_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:294:28: ( (otherlv_0= 'states:' ( (lv_states_1_0= ruleState ) ) (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )* ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:295:1: (otherlv_0= 'states:' ( (lv_states_1_0= ruleState ) ) (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )* )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:295:1: (otherlv_0= 'states:' ( (lv_states_1_0= ruleState ) ) (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )* )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:295:3: otherlv_0= 'states:' ( (lv_states_1_0= ruleState ) ) (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleStateDeclaration528); 

                	newLeafNode(otherlv_0, grammarAccess.getStateDeclarationAccess().getStatesKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:299:1: ( (lv_states_1_0= ruleState ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:300:1: (lv_states_1_0= ruleState )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:300:1: (lv_states_1_0= ruleState )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:301:3: lv_states_1_0= ruleState
            {
             
            	        newCompositeNode(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleState_in_ruleStateDeclaration549);
            lv_states_1_0=ruleState();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStateDeclarationRule());
            	        }
                   		add(
                   			current, 
                   			"states",
                    		lv_states_1_0, 
                    		"State");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:317:2: (otherlv_2= ',' ( (lv_states_3_0= ruleState ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:317:4: otherlv_2= ',' ( (lv_states_3_0= ruleState ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleStateDeclaration562); 

            	        	newLeafNode(otherlv_2, grammarAccess.getStateDeclarationAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:321:1: ( (lv_states_3_0= ruleState ) )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:322:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:322:1: (lv_states_3_0= ruleState )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:323:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateDeclarationAccess().getStatesStateParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateDeclaration583);
            	    lv_states_3_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_3_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleStateDeclaration"


    // $ANTLR start "entryRuleInitialDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:347:1: entryRuleInitialDeclaration returns [EObject current=null] : iv_ruleInitialDeclaration= ruleInitialDeclaration EOF ;
    public final EObject entryRuleInitialDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:348:2: (iv_ruleInitialDeclaration= ruleInitialDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:349:2: iv_ruleInitialDeclaration= ruleInitialDeclaration EOF
            {
             newCompositeNode(grammarAccess.getInitialDeclarationRule()); 
            pushFollow(FOLLOW_ruleInitialDeclaration_in_entryRuleInitialDeclaration621);
            iv_ruleInitialDeclaration=ruleInitialDeclaration();

            state._fsp--;

             current =iv_ruleInitialDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialDeclaration631); 

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
    // $ANTLR end "entryRuleInitialDeclaration"


    // $ANTLR start "ruleInitialDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:356:1: ruleInitialDeclaration returns [EObject current=null] : (otherlv_0= 'initial:' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInitialDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:359:28: ( (otherlv_0= 'initial:' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:360:1: (otherlv_0= 'initial:' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:360:1: (otherlv_0= 'initial:' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:360:3: otherlv_0= 'initial:' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleInitialDeclaration668); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialDeclarationAccess().getInitialKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:364:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:365:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:365:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:366:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInitialDeclarationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialDeclaration688); 

            		newLeafNode(otherlv_1, grammarAccess.getInitialDeclarationAccess().getInitialStateCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleInitialDeclaration"


    // $ANTLR start "entryRuleLoopsDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:385:1: entryRuleLoopsDeclaration returns [EObject current=null] : iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF ;
    public final EObject entryRuleLoopsDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopsDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:386:2: (iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:387:2: iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF
            {
             newCompositeNode(grammarAccess.getLoopsDeclarationRule()); 
            pushFollow(FOLLOW_ruleLoopsDeclaration_in_entryRuleLoopsDeclaration724);
            iv_ruleLoopsDeclaration=ruleLoopsDeclaration();

            state._fsp--;

             current =iv_ruleLoopsDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopsDeclaration734); 

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
    // $ANTLR end "entryRuleLoopsDeclaration"


    // $ANTLR start "ruleLoopsDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:394:1: ruleLoopsDeclaration returns [EObject current=null] : (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleLoopsDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:397:28: ( (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:398:1: (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:398:1: (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:398:3: otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleLoopsDeclaration771); 

                	newLeafNode(otherlv_0, grammarAccess.getLoopsDeclarationAccess().getLoopsKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:402:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:403:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:403:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:404:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLoopsDeclaration788); 

            			newLeafNode(lv_val_1_0, grammarAccess.getLoopsDeclarationAccess().getValINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoopsDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleLoopsDeclaration"


    // $ANTLR start "entryRuleSeedDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:428:1: entryRuleSeedDeclaration returns [EObject current=null] : iv_ruleSeedDeclaration= ruleSeedDeclaration EOF ;
    public final EObject entryRuleSeedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeedDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:429:2: (iv_ruleSeedDeclaration= ruleSeedDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:430:2: iv_ruleSeedDeclaration= ruleSeedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSeedDeclarationRule()); 
            pushFollow(FOLLOW_ruleSeedDeclaration_in_entryRuleSeedDeclaration829);
            iv_ruleSeedDeclaration=ruleSeedDeclaration();

            state._fsp--;

             current =iv_ruleSeedDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSeedDeclaration839); 

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
    // $ANTLR end "entryRuleSeedDeclaration"


    // $ANTLR start "ruleSeedDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:437:1: ruleSeedDeclaration returns [EObject current=null] : (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleSeedDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:440:28: ( (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:441:1: (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:441:1: (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:441:3: otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSeedDeclaration876); 

                	newLeafNode(otherlv_0, grammarAccess.getSeedDeclarationAccess().getRandseedKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:445:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:446:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:446:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:447:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSeedDeclaration893); 

            			newLeafNode(lv_val_1_0, grammarAccess.getSeedDeclarationAccess().getValINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSeedDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleSeedDeclaration"


    // $ANTLR start "entryRuleSignalDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:471:1: entryRuleSignalDeclaration returns [EObject current=null] : iv_ruleSignalDeclaration= ruleSignalDeclaration EOF ;
    public final EObject entryRuleSignalDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignalDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:472:2: (iv_ruleSignalDeclaration= ruleSignalDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:473:2: iv_ruleSignalDeclaration= ruleSignalDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSignalDeclarationRule()); 
            pushFollow(FOLLOW_ruleSignalDeclaration_in_entryRuleSignalDeclaration934);
            iv_ruleSignalDeclaration=ruleSignalDeclaration();

            state._fsp--;

             current =iv_ruleSignalDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalDeclaration944); 

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
    // $ANTLR end "entryRuleSignalDeclaration"


    // $ANTLR start "ruleSignalDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:480:1: ruleSignalDeclaration returns [EObject current=null] : ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleSignalDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_port_0_0=null;
        Token otherlv_1=null;
        Token lv_signame_2_0=null;
        Token otherlv_3=null;
        Token lv_intVal_4_0=null;
        Token otherlv_5=null;
        Token lv_strVal_6_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:483:28: ( ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:1: ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:1: ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:2: ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )?
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:2: ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==18) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:3: ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:484:3: ( (lv_port_0_0= RULE_ID ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:485:1: (lv_port_0_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:485:1: (lv_port_0_0= RULE_ID )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:486:3: lv_port_0_0= RULE_ID
                    {
                    lv_port_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalDeclaration987); 

                    			newLeafNode(lv_port_0_0, grammarAccess.getSignalDeclarationAccess().getPortIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSignalDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"port",
                            		lv_port_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSignalDeclaration1004); 

                        	newLeafNode(otherlv_1, grammarAccess.getSignalDeclarationAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:506:3: ( (lv_signame_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:507:1: (lv_signame_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:507:1: (lv_signame_2_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:508:3: lv_signame_2_0= RULE_ID
            {
            lv_signame_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalDeclaration1023); 

            			newLeafNode(lv_signame_2_0, grammarAccess.getSignalDeclarationAccess().getSignameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSignalDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"signame",
                    		lv_signame_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:524:2: ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    alt6=1;
                }
                else if ( (LA6_1==RULE_STRING) ) {
                    alt6=2;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:524:3: (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:524:3: (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:524:5: otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleSignalDeclaration1042); 

                        	newLeafNode(otherlv_3, grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_0_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:528:1: ( (lv_intVal_4_0= RULE_INT ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:529:1: (lv_intVal_4_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:529:1: (lv_intVal_4_0= RULE_INT )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:530:3: lv_intVal_4_0= RULE_INT
                    {
                    lv_intVal_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignalDeclaration1059); 

                    			newLeafNode(lv_intVal_4_0, grammarAccess.getSignalDeclarationAccess().getIntValINTTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSignalDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"intVal",
                            		lv_intVal_4_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:547:6: (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:547:6: (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:547:8: otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleSignalDeclaration1084); 

                        	newLeafNode(otherlv_5, grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_1_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:551:1: ( (lv_strVal_6_0= RULE_STRING ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:552:1: (lv_strVal_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:552:1: (lv_strVal_6_0= RULE_STRING )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:553:3: lv_strVal_6_0= RULE_STRING
                    {
                    lv_strVal_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSignalDeclaration1101); 

                    			newLeafNode(lv_strVal_6_0, grammarAccess.getSignalDeclarationAccess().getStrValSTRINGTerminalRuleCall_2_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSignalDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"strVal",
                            		lv_strVal_6_0, 
                            		"STRING");
                    	    

                    }


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
    // $ANTLR end "ruleSignalDeclaration"


    // $ANTLR start "entryRuleSourceDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:577:1: entryRuleSourceDeclaration returns [EObject current=null] : iv_ruleSourceDeclaration= ruleSourceDeclaration EOF ;
    public final EObject entryRuleSourceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:578:2: (iv_ruleSourceDeclaration= ruleSourceDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:579:2: iv_ruleSourceDeclaration= ruleSourceDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSourceDeclarationRule()); 
            pushFollow(FOLLOW_ruleSourceDeclaration_in_entryRuleSourceDeclaration1145);
            iv_ruleSourceDeclaration=ruleSourceDeclaration();

            state._fsp--;

             current =iv_ruleSourceDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSourceDeclaration1155); 

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
    // $ANTLR end "entryRuleSourceDeclaration"


    // $ANTLR start "ruleSourceDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:586:1: ruleSourceDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ) ;
    public final EObject ruleSourceDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:589:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:590:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:590:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:590:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':'
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:590:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:591:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:591:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:592:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSourceDeclarationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSourceDeclaration1200); 

            		newLeafNode(otherlv_0, grammarAccess.getSourceDeclarationAccess().getRefStateCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSourceDeclaration1212); 

                	newLeafNode(otherlv_1, grammarAccess.getSourceDeclarationAccess().getColonKeyword_1());
                

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
    // $ANTLR end "ruleSourceDeclaration"


    // $ANTLR start "entryRuleDestinationDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:615:1: entryRuleDestinationDeclaration returns [EObject current=null] : iv_ruleDestinationDeclaration= ruleDestinationDeclaration EOF ;
    public final EObject entryRuleDestinationDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDestinationDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:616:2: (iv_ruleDestinationDeclaration= ruleDestinationDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:617:2: iv_ruleDestinationDeclaration= ruleDestinationDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDestinationDeclarationRule()); 
            pushFollow(FOLLOW_ruleDestinationDeclaration_in_entryRuleDestinationDeclaration1248);
            iv_ruleDestinationDeclaration=ruleDestinationDeclaration();

            state._fsp--;

             current =iv_ruleDestinationDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDestinationDeclaration1258); 

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
    // $ANTLR end "entryRuleDestinationDeclaration"


    // $ANTLR start "ruleDestinationDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:624:1: ruleDestinationDeclaration returns [EObject current=null] : (otherlv_0= '-> ' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDestinationDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:627:28: ( (otherlv_0= '-> ' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:628:1: (otherlv_0= '-> ' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:628:1: (otherlv_0= '-> ' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:628:3: otherlv_0= '-> ' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleDestinationDeclaration1295); 

                	newLeafNode(otherlv_0, grammarAccess.getDestinationDeclarationAccess().getHyphenMinusGreaterThanSignSpaceKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:632:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:633:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:633:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:634:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDestinationDeclarationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDestinationDeclaration1315); 

            		newLeafNode(otherlv_1, grammarAccess.getDestinationDeclarationAccess().getRefStateCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleDestinationDeclaration"


    // $ANTLR start "entryRuleTransitionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:653:1: entryRuleTransitionDeclaration returns [EObject current=null] : iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF ;
    public final EObject entryRuleTransitionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:654:2: (iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:655:2: iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getTransitionDeclarationRule()); 
            pushFollow(FOLLOW_ruleTransitionDeclaration_in_entryRuleTransitionDeclaration1351);
            iv_ruleTransitionDeclaration=ruleTransitionDeclaration();

            state._fsp--;

             current =iv_ruleTransitionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionDeclaration1361); 

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
    // $ANTLR end "entryRuleTransitionDeclaration"


    // $ANTLR start "ruleTransitionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:662:1: ruleTransitionDeclaration returns [EObject current=null] : ( ( (lv_source_0_0= ruleSourceDeclaration ) ) otherlv_1= 'in:' ( (lv_in_2_0= ruleSignalDeclaration ) )* otherlv_3= 'out:' ( (lv_out_4_0= ruleSignalDeclaration ) )* ( (lv_destination_5_0= ruleDestinationDeclaration ) ) ) ;
    public final EObject ruleTransitionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_source_0_0 = null;

        EObject lv_in_2_0 = null;

        EObject lv_out_4_0 = null;

        EObject lv_destination_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:665:28: ( ( ( (lv_source_0_0= ruleSourceDeclaration ) ) otherlv_1= 'in:' ( (lv_in_2_0= ruleSignalDeclaration ) )* otherlv_3= 'out:' ( (lv_out_4_0= ruleSignalDeclaration ) )* ( (lv_destination_5_0= ruleDestinationDeclaration ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:666:1: ( ( (lv_source_0_0= ruleSourceDeclaration ) ) otherlv_1= 'in:' ( (lv_in_2_0= ruleSignalDeclaration ) )* otherlv_3= 'out:' ( (lv_out_4_0= ruleSignalDeclaration ) )* ( (lv_destination_5_0= ruleDestinationDeclaration ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:666:1: ( ( (lv_source_0_0= ruleSourceDeclaration ) ) otherlv_1= 'in:' ( (lv_in_2_0= ruleSignalDeclaration ) )* otherlv_3= 'out:' ( (lv_out_4_0= ruleSignalDeclaration ) )* ( (lv_destination_5_0= ruleDestinationDeclaration ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:666:2: ( (lv_source_0_0= ruleSourceDeclaration ) ) otherlv_1= 'in:' ( (lv_in_2_0= ruleSignalDeclaration ) )* otherlv_3= 'out:' ( (lv_out_4_0= ruleSignalDeclaration ) )* ( (lv_destination_5_0= ruleDestinationDeclaration ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:666:2: ( (lv_source_0_0= ruleSourceDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:667:1: (lv_source_0_0= ruleSourceDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:667:1: (lv_source_0_0= ruleSourceDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:668:3: lv_source_0_0= ruleSourceDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getSourceSourceDeclarationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSourceDeclaration_in_ruleTransitionDeclaration1407);
            lv_source_0_0=ruleSourceDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_0_0, 
                    		"SourceDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleTransitionDeclaration1419); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionDeclarationAccess().getInKeyword_1());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:688:1: ( (lv_in_2_0= ruleSignalDeclaration ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:689:1: (lv_in_2_0= ruleSignalDeclaration )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:689:1: (lv_in_2_0= ruleSignalDeclaration )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:690:3: lv_in_2_0= ruleSignalDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getInSignalDeclarationParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration1440);
            	    lv_in_2_0=ruleSignalDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"in",
            	            		lv_in_2_0, 
            	            		"SignalDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleTransitionDeclaration1453); 

                	newLeafNode(otherlv_3, grammarAccess.getTransitionDeclarationAccess().getOutKeyword_3());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:710:1: ( (lv_out_4_0= ruleSignalDeclaration ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:711:1: (lv_out_4_0= ruleSignalDeclaration )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:711:1: (lv_out_4_0= ruleSignalDeclaration )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:712:3: lv_out_4_0= ruleSignalDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getOutSignalDeclarationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration1474);
            	    lv_out_4_0=ruleSignalDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"out",
            	            		lv_out_4_0, 
            	            		"SignalDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:728:3: ( (lv_destination_5_0= ruleDestinationDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:729:1: (lv_destination_5_0= ruleDestinationDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:729:1: (lv_destination_5_0= ruleDestinationDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:730:3: lv_destination_5_0= ruleDestinationDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getDestinationDestinationDeclarationParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDestinationDeclaration_in_ruleTransitionDeclaration1496);
            lv_destination_5_0=ruleDestinationDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"destination",
                    		lv_destination_5_0, 
                    		"DestinationDeclaration");
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
    // $ANTLR end "ruleTransitionDeclaration"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestscript_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleTestscript_in_entryRuleTestscript166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestscript176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTestscript213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTestscript230 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_ruleTestscript256 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleInitialDeclaration_in_ruleTestscript277 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleLoopsDeclaration_in_ruleTestscript298 = new BitSet(new long[]{0x0000000000021010L});
    public static final BitSet FOLLOW_ruleSeedDeclaration_in_ruleTestscript319 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransitionDeclaration_in_ruleTestscript341 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleTestscript354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateDeclaration491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleStateDeclaration528 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateDeclaration549 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleStateDeclaration562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateDeclaration583 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleInitialDeclaration_in_entryRuleInitialDeclaration621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialDeclaration631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInitialDeclaration668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialDeclaration688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopsDeclaration_in_entryRuleLoopsDeclaration724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopsDeclaration734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLoopsDeclaration771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLoopsDeclaration788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSeedDeclaration_in_entryRuleSeedDeclaration829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSeedDeclaration839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSeedDeclaration876 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSeedDeclaration893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_entryRuleSignalDeclaration934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalDeclaration944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalDeclaration987 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSignalDeclaration1004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalDeclaration1023 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSignalDeclaration1042 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignalDeclaration1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSignalDeclaration1084 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSignalDeclaration1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSourceDeclaration_in_entryRuleSourceDeclaration1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSourceDeclaration1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSourceDeclaration1200 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSourceDeclaration1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDestinationDeclaration_in_entryRuleDestinationDeclaration1248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDestinationDeclaration1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDestinationDeclaration1295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDestinationDeclaration1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionDeclaration_in_entryRuleTransitionDeclaration1351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionDeclaration1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSourceDeclaration_in_ruleTransitionDeclaration1407 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransitionDeclaration1419 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration1440 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleTransitionDeclaration1453 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration1474 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleDestinationDeclaration_in_ruleTransitionDeclaration1496 = new BitSet(new long[]{0x0000000000000002L});

}