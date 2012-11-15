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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'fsmdefinition'", "'initial'", "';'", "'randomtest'", "'fsm:'", "'transition'", "'to'", "'trigger:'", "'guards:'", "'constraints:'", "'condition'", "'precondition'", "'postcondition'", "'state'", "'loops:'", "'randseed:'", "'.'", "'='"
    };
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) ) | ( (lv_RandomTests_1_0= ruleRandomTest ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_FsmDefinitions_0_0 = null;

        EObject lv_RandomTests_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:79:28: ( ( ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) ) | ( (lv_RandomTests_1_0= ruleRandomTest ) ) )* )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:1: ( ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) ) | ( (lv_RandomTests_1_0= ruleRandomTest ) ) )*
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:1: ( ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) ) | ( (lv_RandomTests_1_0= ruleRandomTest ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }
                else if ( (LA1_0==14) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:2: ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:80:2: ( (lv_FsmDefinitions_0_0= ruleFsmDefinition ) )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:81:1: (lv_FsmDefinitions_0_0= ruleFsmDefinition )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:81:1: (lv_FsmDefinitions_0_0= ruleFsmDefinition )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:82:3: lv_FsmDefinitions_0_0= ruleFsmDefinition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getFsmDefinitionsFsmDefinitionParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFsmDefinition_in_ruleModel131);
            	    lv_FsmDefinitions_0_0=ruleFsmDefinition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"FsmDefinitions",
            	            		lv_FsmDefinitions_0_0, 
            	            		"FsmDefinition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:99:6: ( (lv_RandomTests_1_0= ruleRandomTest ) )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:99:6: ( (lv_RandomTests_1_0= ruleRandomTest ) )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:100:1: (lv_RandomTests_1_0= ruleRandomTest )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:100:1: (lv_RandomTests_1_0= ruleRandomTest )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:101:3: lv_RandomTests_1_0= ruleRandomTest
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getRandomTestsRandomTestParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRandomTest_in_ruleModel158);
            	    lv_RandomTests_1_0=ruleRandomTest();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"RandomTests",
            	            		lv_RandomTests_1_0, 
            	            		"RandomTest");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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


    // $ANTLR start "entryRuleFsmDefinition"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:125:1: entryRuleFsmDefinition returns [EObject current=null] : iv_ruleFsmDefinition= ruleFsmDefinition EOF ;
    public final EObject entryRuleFsmDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFsmDefinition = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:126:2: (iv_ruleFsmDefinition= ruleFsmDefinition EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:127:2: iv_ruleFsmDefinition= ruleFsmDefinition EOF
            {
             newCompositeNode(grammarAccess.getFsmDefinitionRule()); 
            pushFollow(FOLLOW_ruleFsmDefinition_in_entryRuleFsmDefinition195);
            iv_ruleFsmDefinition=ruleFsmDefinition();

            state._fsp--;

             current =iv_ruleFsmDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFsmDefinition205); 

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
    // $ANTLR end "entryRuleFsmDefinition"


    // $ANTLR start "ruleFsmDefinition"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:134:1: ruleFsmDefinition returns [EObject current=null] : (otherlv_0= 'fsmdefinition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' ( (lv_states_3_0= ruleStateDeclaration ) ) ( (lv_states_4_0= ruleStateDeclaration ) )* otherlv_5= ';' ) ;
    public final EObject ruleFsmDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_states_3_0 = null;

        EObject lv_states_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:137:28: ( (otherlv_0= 'fsmdefinition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' ( (lv_states_3_0= ruleStateDeclaration ) ) ( (lv_states_4_0= ruleStateDeclaration ) )* otherlv_5= ';' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:138:1: (otherlv_0= 'fsmdefinition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' ( (lv_states_3_0= ruleStateDeclaration ) ) ( (lv_states_4_0= ruleStateDeclaration ) )* otherlv_5= ';' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:138:1: (otherlv_0= 'fsmdefinition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' ( (lv_states_3_0= ruleStateDeclaration ) ) ( (lv_states_4_0= ruleStateDeclaration ) )* otherlv_5= ';' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:138:3: otherlv_0= 'fsmdefinition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'initial' ( (lv_states_3_0= ruleStateDeclaration ) ) ( (lv_states_4_0= ruleStateDeclaration ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleFsmDefinition242); 

                	newLeafNode(otherlv_0, grammarAccess.getFsmDefinitionAccess().getFsmdefinitionKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:142:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:143:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:143:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:144:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFsmDefinition259); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFsmDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFsmDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleFsmDefinition276); 

                	newLeafNode(otherlv_2, grammarAccess.getFsmDefinitionAccess().getInitialKeyword_2());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:164:1: ( (lv_states_3_0= ruleStateDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:165:1: (lv_states_3_0= ruleStateDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:165:1: (lv_states_3_0= ruleStateDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:166:3: lv_states_3_0= ruleStateDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getFsmDefinitionAccess().getStatesStateDeclarationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleStateDeclaration_in_ruleFsmDefinition297);
            lv_states_3_0=ruleStateDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFsmDefinitionRule());
            	        }
                   		add(
                   			current, 
                   			"states",
                    		lv_states_3_0, 
                    		"StateDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:182:2: ( (lv_states_4_0= ruleStateDeclaration ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==24) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:183:1: (lv_states_4_0= ruleStateDeclaration )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:183:1: (lv_states_4_0= ruleStateDeclaration )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:184:3: lv_states_4_0= ruleStateDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFsmDefinitionAccess().getStatesStateDeclarationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateDeclaration_in_ruleFsmDefinition318);
            	    lv_states_4_0=ruleStateDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFsmDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_4_0, 
            	            		"StateDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFsmDefinition331); 

                	newLeafNode(otherlv_5, grammarAccess.getFsmDefinitionAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleFsmDefinition"


    // $ANTLR start "entryRuleRandomTest"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:212:1: entryRuleRandomTest returns [EObject current=null] : iv_ruleRandomTest= ruleRandomTest EOF ;
    public final EObject entryRuleRandomTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTest = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:213:2: (iv_ruleRandomTest= ruleRandomTest EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:214:2: iv_ruleRandomTest= ruleRandomTest EOF
            {
             newCompositeNode(grammarAccess.getRandomTestRule()); 
            pushFollow(FOLLOW_ruleRandomTest_in_entryRuleRandomTest367);
            iv_ruleRandomTest=ruleRandomTest();

            state._fsp--;

             current =iv_ruleRandomTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRandomTest377); 

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
    // $ANTLR end "entryRuleRandomTest"


    // $ANTLR start "ruleRandomTest"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:221:1: ruleRandomTest returns [EObject current=null] : (otherlv_0= 'randomtest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fsm:' ( (otherlv_3= RULE_ID ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? otherlv_6= ';' ) ;
    public final EObject ruleRandomTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_loopsDeclaration_4_0 = null;

        EObject lv_seedDeclaration_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:224:28: ( (otherlv_0= 'randomtest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fsm:' ( (otherlv_3= RULE_ID ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? otherlv_6= ';' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:225:1: (otherlv_0= 'randomtest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fsm:' ( (otherlv_3= RULE_ID ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? otherlv_6= ';' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:225:1: (otherlv_0= 'randomtest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fsm:' ( (otherlv_3= RULE_ID ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? otherlv_6= ';' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:225:3: otherlv_0= 'randomtest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fsm:' ( (otherlv_3= RULE_ID ) ) ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) ) ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleRandomTest414); 

                	newLeafNode(otherlv_0, grammarAccess.getRandomTestAccess().getRandomtestKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:229:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:230:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:230:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:231:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRandomTest431); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRandomTestAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTestRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleRandomTest448); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomTestAccess().getFsmKeyword_2());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:251:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:252:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:252:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:253:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTestRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRandomTest468); 

            		newLeafNode(otherlv_3, grammarAccess.getRandomTestAccess().getFsmFsmDefinitionCrossReference_3_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:264:2: ( (lv_loopsDeclaration_4_0= ruleLoopsDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:265:1: (lv_loopsDeclaration_4_0= ruleLoopsDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:265:1: (lv_loopsDeclaration_4_0= ruleLoopsDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:266:3: lv_loopsDeclaration_4_0= ruleLoopsDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getRandomTestAccess().getLoopsDeclarationLoopsDeclarationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLoopsDeclaration_in_ruleRandomTest489);
            lv_loopsDeclaration_4_0=ruleLoopsDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomTestRule());
            	        }
                   		set(
                   			current, 
                   			"loopsDeclaration",
                    		lv_loopsDeclaration_4_0, 
                    		"LoopsDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:282:2: ( (lv_seedDeclaration_5_0= ruleSeedDeclaration ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:283:1: (lv_seedDeclaration_5_0= ruleSeedDeclaration )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:283:1: (lv_seedDeclaration_5_0= ruleSeedDeclaration )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:284:3: lv_seedDeclaration_5_0= ruleSeedDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomTestAccess().getSeedDeclarationSeedDeclarationParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSeedDeclaration_in_ruleRandomTest510);
                    lv_seedDeclaration_5_0=ruleSeedDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomTestRule());
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

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleRandomTest523); 

                	newLeafNode(otherlv_6, grammarAccess.getRandomTestAccess().getSemicolonKeyword_6());
                

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
    // $ANTLR end "ruleRandomTest"


    // $ANTLR start "entryRuleGuardDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:312:1: entryRuleGuardDeclaration returns [EObject current=null] : iv_ruleGuardDeclaration= ruleGuardDeclaration EOF ;
    public final EObject entryRuleGuardDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:313:2: (iv_ruleGuardDeclaration= ruleGuardDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:314:2: iv_ruleGuardDeclaration= ruleGuardDeclaration EOF
            {
             newCompositeNode(grammarAccess.getGuardDeclarationRule()); 
            pushFollow(FOLLOW_ruleGuardDeclaration_in_entryRuleGuardDeclaration559);
            iv_ruleGuardDeclaration=ruleGuardDeclaration();

            state._fsp--;

             current =iv_ruleGuardDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardDeclaration569); 

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
    // $ANTLR end "entryRuleGuardDeclaration"


    // $ANTLR start "ruleGuardDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:321:1: ruleGuardDeclaration returns [EObject current=null] : ( (lv_signal_0_0= ruleSignalDeclaration ) ) ;
    public final EObject ruleGuardDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_signal_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:324:28: ( ( (lv_signal_0_0= ruleSignalDeclaration ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:325:1: ( (lv_signal_0_0= ruleSignalDeclaration ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:325:1: ( (lv_signal_0_0= ruleSignalDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:326:1: (lv_signal_0_0= ruleSignalDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:326:1: (lv_signal_0_0= ruleSignalDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:327:3: lv_signal_0_0= ruleSignalDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getGuardDeclarationAccess().getSignalSignalDeclarationParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleSignalDeclaration_in_ruleGuardDeclaration614);
            lv_signal_0_0=ruleSignalDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"signal",
                    		lv_signal_0_0, 
                    		"SignalDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleGuardDeclaration"


    // $ANTLR start "entryRuleTransitionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:351:1: entryRuleTransitionDeclaration returns [EObject current=null] : iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF ;
    public final EObject entryRuleTransitionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:352:2: (iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:353:2: iv_ruleTransitionDeclaration= ruleTransitionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getTransitionDeclarationRule()); 
            pushFollow(FOLLOW_ruleTransitionDeclaration_in_entryRuleTransitionDeclaration649);
            iv_ruleTransitionDeclaration=ruleTransitionDeclaration();

            state._fsp--;

             current =iv_ruleTransitionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionDeclaration659); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:360:1: ruleTransitionDeclaration returns [EObject current=null] : (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )? (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )? (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )? otherlv_11= ';' ) ;
    public final EObject ruleTransitionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_trigger_5_0 = null;

        EObject lv_triggers_7_0 = null;

        EObject lv_precondition_9_0 = null;

        EObject lv_postcondition_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:363:28: ( (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )? (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )? (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )? otherlv_11= ';' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:364:1: (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )? (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )? (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )? otherlv_11= ';' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:364:1: (otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )? (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )? (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )? otherlv_11= ';' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:364:3: otherlv_0= 'transition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )? (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )? (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )? otherlv_11= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTransitionDeclaration696); 

                	newLeafNode(otherlv_0, grammarAccess.getTransitionDeclarationAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:368:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:369:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:369:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:370:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionDeclaration713); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTransitionDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTransitionDeclaration730); 

                	newLeafNode(otherlv_2, grammarAccess.getTransitionDeclarationAccess().getToKeyword_2());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:390:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:391:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:391:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:392:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionDeclarationRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionDeclaration750); 

            		newLeafNode(otherlv_3, grammarAccess.getTransitionDeclarationAccess().getDestinationStateDeclarationCrossReference_3_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:403:2: (otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:403:4: otherlv_4= 'trigger:' ( (lv_trigger_5_0= ruleSignalDeclaration ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTransitionDeclaration763); 

                        	newLeafNode(otherlv_4, grammarAccess.getTransitionDeclarationAccess().getTriggerKeyword_4_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:407:1: ( (lv_trigger_5_0= ruleSignalDeclaration ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:408:1: (lv_trigger_5_0= ruleSignalDeclaration )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:408:1: (lv_trigger_5_0= ruleSignalDeclaration )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:409:3: lv_trigger_5_0= ruleSignalDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getTriggerSignalDeclarationParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration784);
                    lv_trigger_5_0=ruleSignalDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"trigger",
                            		lv_trigger_5_0, 
                            		"SignalDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:425:4: (otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:425:6: otherlv_6= 'guards:' ( (lv_triggers_7_0= ruleGuardDeclaration ) )+
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleTransitionDeclaration799); 

                        	newLeafNode(otherlv_6, grammarAccess.getTransitionDeclarationAccess().getGuardsKeyword_5_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:429:1: ( (lv_triggers_7_0= ruleGuardDeclaration ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:430:1: (lv_triggers_7_0= ruleGuardDeclaration )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:430:1: (lv_triggers_7_0= ruleGuardDeclaration )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:431:3: lv_triggers_7_0= ruleGuardDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getTriggersGuardDeclarationParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGuardDeclaration_in_ruleTransitionDeclaration820);
                    	    lv_triggers_7_0=ruleGuardDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"triggers",
                    	            		lv_triggers_7_0, 
                    	            		"GuardDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:447:5: (otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:447:7: otherlv_8= 'constraints:' ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleTransitionDeclaration836); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransitionDeclarationAccess().getConstraintsKeyword_6_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:451:1: ( ( (lv_precondition_9_0= rulePreconditionDeclaration ) ) | ( (lv_postcondition_10_0= rulePostconditionDeclaration ) ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==22) ) {
                            alt7=1;
                        }
                        else if ( (LA7_0==23) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:451:2: ( (lv_precondition_9_0= rulePreconditionDeclaration ) )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:451:2: ( (lv_precondition_9_0= rulePreconditionDeclaration ) )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:452:1: (lv_precondition_9_0= rulePreconditionDeclaration )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:452:1: (lv_precondition_9_0= rulePreconditionDeclaration )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:453:3: lv_precondition_9_0= rulePreconditionDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getPreconditionPreconditionDeclarationParserRuleCall_6_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePreconditionDeclaration_in_ruleTransitionDeclaration858);
                    	    lv_precondition_9_0=rulePreconditionDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"precondition",
                    	            		lv_precondition_9_0, 
                    	            		"PreconditionDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:470:6: ( (lv_postcondition_10_0= rulePostconditionDeclaration ) )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:470:6: ( (lv_postcondition_10_0= rulePostconditionDeclaration ) )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:471:1: (lv_postcondition_10_0= rulePostconditionDeclaration )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:471:1: (lv_postcondition_10_0= rulePostconditionDeclaration )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:472:3: lv_postcondition_10_0= rulePostconditionDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransitionDeclarationAccess().getPostconditionPostconditionDeclarationParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePostconditionDeclaration_in_ruleTransitionDeclaration885);
                    	    lv_postcondition_10_0=rulePostconditionDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransitionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"postcondition",
                    	            		lv_postcondition_10_0, 
                    	            		"PostconditionDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleTransitionDeclaration901); 

                	newLeafNode(otherlv_11, grammarAccess.getTransitionDeclarationAccess().getSemicolonKeyword_7());
                

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


    // $ANTLR start "entryRuleConditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:500:1: entryRuleConditionDeclaration returns [EObject current=null] : iv_ruleConditionDeclaration= ruleConditionDeclaration EOF ;
    public final EObject entryRuleConditionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:501:2: (iv_ruleConditionDeclaration= ruleConditionDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:502:2: iv_ruleConditionDeclaration= ruleConditionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getConditionDeclarationRule()); 
            pushFollow(FOLLOW_ruleConditionDeclaration_in_entryRuleConditionDeclaration937);
            iv_ruleConditionDeclaration=ruleConditionDeclaration();

            state._fsp--;

             current =iv_ruleConditionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionDeclaration947); 

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
    // $ANTLR end "entryRuleConditionDeclaration"


    // $ANTLR start "ruleConditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:509:1: ruleConditionDeclaration returns [EObject current=null] : (otherlv_0= 'condition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) ;
    public final EObject ruleConditionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_signal_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:512:28: ( (otherlv_0= 'condition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:513:1: (otherlv_0= 'condition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:513:1: (otherlv_0= 'condition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:513:3: otherlv_0= 'condition' ( (lv_signal_1_0= ruleSignalDeclaration ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleConditionDeclaration984); 

                	newLeafNode(otherlv_0, grammarAccess.getConditionDeclarationAccess().getConditionKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:517:1: ( (lv_signal_1_0= ruleSignalDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:518:1: (lv_signal_1_0= ruleSignalDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:518:1: (lv_signal_1_0= ruleSignalDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:519:3: lv_signal_1_0= ruleSignalDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getConditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSignalDeclaration_in_ruleConditionDeclaration1005);
            lv_signal_1_0=ruleSignalDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"signal",
                    		lv_signal_1_0, 
                    		"SignalDeclaration");
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
    // $ANTLR end "ruleConditionDeclaration"


    // $ANTLR start "entryRulePreconditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:543:1: entryRulePreconditionDeclaration returns [EObject current=null] : iv_rulePreconditionDeclaration= rulePreconditionDeclaration EOF ;
    public final EObject entryRulePreconditionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreconditionDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:544:2: (iv_rulePreconditionDeclaration= rulePreconditionDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:545:2: iv_rulePreconditionDeclaration= rulePreconditionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPreconditionDeclarationRule()); 
            pushFollow(FOLLOW_rulePreconditionDeclaration_in_entryRulePreconditionDeclaration1041);
            iv_rulePreconditionDeclaration=rulePreconditionDeclaration();

            state._fsp--;

             current =iv_rulePreconditionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePreconditionDeclaration1051); 

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
    // $ANTLR end "entryRulePreconditionDeclaration"


    // $ANTLR start "rulePreconditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:552:1: rulePreconditionDeclaration returns [EObject current=null] : (otherlv_0= 'precondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) ;
    public final EObject rulePreconditionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_signal_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:555:28: ( (otherlv_0= 'precondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:556:1: (otherlv_0= 'precondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:556:1: (otherlv_0= 'precondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:556:3: otherlv_0= 'precondition' ( (lv_signal_1_0= ruleSignalDeclaration ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_rulePreconditionDeclaration1088); 

                	newLeafNode(otherlv_0, grammarAccess.getPreconditionDeclarationAccess().getPreconditionKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:560:1: ( (lv_signal_1_0= ruleSignalDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:561:1: (lv_signal_1_0= ruleSignalDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:561:1: (lv_signal_1_0= ruleSignalDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:562:3: lv_signal_1_0= ruleSignalDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getPreconditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSignalDeclaration_in_rulePreconditionDeclaration1109);
            lv_signal_1_0=ruleSignalDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPreconditionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"signal",
                    		lv_signal_1_0, 
                    		"SignalDeclaration");
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
    // $ANTLR end "rulePreconditionDeclaration"


    // $ANTLR start "entryRulePostconditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:586:1: entryRulePostconditionDeclaration returns [EObject current=null] : iv_rulePostconditionDeclaration= rulePostconditionDeclaration EOF ;
    public final EObject entryRulePostconditionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostconditionDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:587:2: (iv_rulePostconditionDeclaration= rulePostconditionDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:588:2: iv_rulePostconditionDeclaration= rulePostconditionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPostconditionDeclarationRule()); 
            pushFollow(FOLLOW_rulePostconditionDeclaration_in_entryRulePostconditionDeclaration1145);
            iv_rulePostconditionDeclaration=rulePostconditionDeclaration();

            state._fsp--;

             current =iv_rulePostconditionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostconditionDeclaration1155); 

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
    // $ANTLR end "entryRulePostconditionDeclaration"


    // $ANTLR start "rulePostconditionDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:595:1: rulePostconditionDeclaration returns [EObject current=null] : (otherlv_0= 'postcondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) ;
    public final EObject rulePostconditionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_signal_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:598:28: ( (otherlv_0= 'postcondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:599:1: (otherlv_0= 'postcondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:599:1: (otherlv_0= 'postcondition' ( (lv_signal_1_0= ruleSignalDeclaration ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:599:3: otherlv_0= 'postcondition' ( (lv_signal_1_0= ruleSignalDeclaration ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_rulePostconditionDeclaration1192); 

                	newLeafNode(otherlv_0, grammarAccess.getPostconditionDeclarationAccess().getPostconditionKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:603:1: ( (lv_signal_1_0= ruleSignalDeclaration ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:604:1: (lv_signal_1_0= ruleSignalDeclaration )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:604:1: (lv_signal_1_0= ruleSignalDeclaration )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:605:3: lv_signal_1_0= ruleSignalDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getPostconditionDeclarationAccess().getSignalSignalDeclarationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSignalDeclaration_in_rulePostconditionDeclaration1213);
            lv_signal_1_0=ruleSignalDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPostconditionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"signal",
                    		lv_signal_1_0, 
                    		"SignalDeclaration");
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
    // $ANTLR end "rulePostconditionDeclaration"


    // $ANTLR start "entryRuleStateDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:629:1: entryRuleStateDeclaration returns [EObject current=null] : iv_ruleStateDeclaration= ruleStateDeclaration EOF ;
    public final EObject entryRuleStateDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:630:2: (iv_ruleStateDeclaration= ruleStateDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:631:2: iv_ruleStateDeclaration= ruleStateDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStateDeclarationRule()); 
            pushFollow(FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration1249);
            iv_ruleStateDeclaration=ruleStateDeclaration();

            state._fsp--;

             current =iv_ruleStateDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateDeclaration1259); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:638:1: ruleStateDeclaration returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )? ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+ otherlv_5= ';' ) ;
    public final EObject ruleStateDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_condition_3_0 = null;

        EObject lv_transitions_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:641:28: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )? ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+ otherlv_5= ';' ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:642:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )? ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+ otherlv_5= ';' )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:642:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )? ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+ otherlv_5= ';' )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:642:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )? ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+ otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleStateDeclaration1296); 

                	newLeafNode(otherlv_0, grammarAccess.getStateDeclarationAccess().getStateKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:646:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:647:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:647:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:648:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateDeclaration1313); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStateDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:664:2: (otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:664:4: otherlv_2= 'constraints:' ( (lv_condition_3_0= ruleConditionDeclaration ) )+
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleStateDeclaration1331); 

                        	newLeafNode(otherlv_2, grammarAccess.getStateDeclarationAccess().getConstraintsKeyword_2_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:668:1: ( (lv_condition_3_0= ruleConditionDeclaration ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:669:1: (lv_condition_3_0= ruleConditionDeclaration )
                    	    {
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:669:1: (lv_condition_3_0= ruleConditionDeclaration )
                    	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:670:3: lv_condition_3_0= ruleConditionDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStateDeclarationAccess().getConditionConditionDeclarationParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConditionDeclaration_in_ruleStateDeclaration1352);
                    	    lv_condition_3_0=ruleConditionDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStateDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"condition",
                    	            		lv_condition_3_0, 
                    	            		"ConditionDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:686:5: ( (lv_transitions_4_0= ruleTransitionDeclaration ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==16) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:687:1: (lv_transitions_4_0= ruleTransitionDeclaration )
            	    {
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:687:1: (lv_transitions_4_0= ruleTransitionDeclaration )
            	    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:688:3: lv_transitions_4_0= ruleTransitionDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateDeclarationAccess().getTransitionsTransitionDeclarationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransitionDeclaration_in_ruleStateDeclaration1376);
            	    lv_transitions_4_0=ruleTransitionDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_4_0, 
            	            		"TransitionDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleStateDeclaration1389); 

                	newLeafNode(otherlv_5, grammarAccess.getStateDeclarationAccess().getSemicolonKeyword_4());
                

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


    // $ANTLR start "entryRuleLoopsDeclaration"
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:716:1: entryRuleLoopsDeclaration returns [EObject current=null] : iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF ;
    public final EObject entryRuleLoopsDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopsDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:717:2: (iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:718:2: iv_ruleLoopsDeclaration= ruleLoopsDeclaration EOF
            {
             newCompositeNode(grammarAccess.getLoopsDeclarationRule()); 
            pushFollow(FOLLOW_ruleLoopsDeclaration_in_entryRuleLoopsDeclaration1425);
            iv_ruleLoopsDeclaration=ruleLoopsDeclaration();

            state._fsp--;

             current =iv_ruleLoopsDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopsDeclaration1435); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:725:1: ruleLoopsDeclaration returns [EObject current=null] : (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleLoopsDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:728:28: ( (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:729:1: (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:729:1: (otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:729:3: otherlv_0= 'loops:' ( (lv_val_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleLoopsDeclaration1472); 

                	newLeafNode(otherlv_0, grammarAccess.getLoopsDeclarationAccess().getLoopsKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:733:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:734:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:734:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:735:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLoopsDeclaration1489); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:759:1: entryRuleSeedDeclaration returns [EObject current=null] : iv_ruleSeedDeclaration= ruleSeedDeclaration EOF ;
    public final EObject entryRuleSeedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeedDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:760:2: (iv_ruleSeedDeclaration= ruleSeedDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:761:2: iv_ruleSeedDeclaration= ruleSeedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSeedDeclarationRule()); 
            pushFollow(FOLLOW_ruleSeedDeclaration_in_entryRuleSeedDeclaration1530);
            iv_ruleSeedDeclaration=ruleSeedDeclaration();

            state._fsp--;

             current =iv_ruleSeedDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSeedDeclaration1540); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:768:1: ruleSeedDeclaration returns [EObject current=null] : (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleSeedDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:771:28: ( (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:772:1: (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:772:1: (otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:772:3: otherlv_0= 'randseed:' ( (lv_val_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleSeedDeclaration1577); 

                	newLeafNode(otherlv_0, grammarAccess.getSeedDeclarationAccess().getRandseedKeyword_0());
                
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:776:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:777:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:777:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:778:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSeedDeclaration1594); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:802:1: entryRuleSignalDeclaration returns [EObject current=null] : iv_ruleSignalDeclaration= ruleSignalDeclaration EOF ;
    public final EObject entryRuleSignalDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignalDeclaration = null;


        try {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:803:2: (iv_ruleSignalDeclaration= ruleSignalDeclaration EOF )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:804:2: iv_ruleSignalDeclaration= ruleSignalDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSignalDeclarationRule()); 
            pushFollow(FOLLOW_ruleSignalDeclaration_in_entryRuleSignalDeclaration1635);
            iv_ruleSignalDeclaration=ruleSignalDeclaration();

            state._fsp--;

             current =iv_ruleSignalDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalDeclaration1645); 

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
    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:811:1: ruleSignalDeclaration returns [EObject current=null] : ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? ) ;
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
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:814:28: ( ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:1: ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:1: ( ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )? )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:2: ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_signame_2_0= RULE_ID ) ) ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )?
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:2: ( ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==27) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:3: ( (lv_port_0_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:815:3: ( (lv_port_0_0= RULE_ID ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:816:1: (lv_port_0_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:816:1: (lv_port_0_0= RULE_ID )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:817:3: lv_port_0_0= RULE_ID
                    {
                    lv_port_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalDeclaration1688); 

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

                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleSignalDeclaration1705); 

                        	newLeafNode(otherlv_1, grammarAccess.getSignalDeclarationAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:837:3: ( (lv_signame_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:838:1: (lv_signame_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:838:1: (lv_signame_2_0= RULE_ID )
            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:839:3: lv_signame_2_0= RULE_ID
            {
            lv_signame_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalDeclaration1724); 

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

            // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:855:2: ( (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) ) | (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) ) )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_STRING) ) {
                    alt13=2;
                }
                else if ( (LA13_1==RULE_INT) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:855:3: (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:855:3: (otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:855:5: otherlv_3= '=' ( (lv_intVal_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleSignalDeclaration1743); 

                        	newLeafNode(otherlv_3, grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_0_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:859:1: ( (lv_intVal_4_0= RULE_INT ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:860:1: (lv_intVal_4_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:860:1: (lv_intVal_4_0= RULE_INT )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:861:3: lv_intVal_4_0= RULE_INT
                    {
                    lv_intVal_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignalDeclaration1760); 

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
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:878:6: (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:878:6: (otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:878:8: otherlv_5= '=' ( (lv_strVal_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleSignalDeclaration1785); 

                        	newLeafNode(otherlv_5, grammarAccess.getSignalDeclarationAccess().getEqualsSignKeyword_2_1_0());
                        
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:882:1: ( (lv_strVal_6_0= RULE_STRING ) )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:883:1: (lv_strVal_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:883:1: (lv_strVal_6_0= RULE_STRING )
                    // ../org.eclipse.etrice.generator.fsmtest/src-gen/org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.g:884:3: lv_strVal_6_0= RULE_STRING
                    {
                    lv_strVal_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSignalDeclaration1802); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFsmDefinition_in_ruleModel131 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_ruleRandomTest_in_ruleModel158 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_ruleFsmDefinition_in_entryRuleFsmDefinition195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFsmDefinition205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleFsmDefinition242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFsmDefinition259 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFsmDefinition276 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_ruleFsmDefinition297 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_ruleFsmDefinition318 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_13_in_ruleFsmDefinition331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRandomTest_in_entryRuleRandomTest367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRandomTest377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleRandomTest414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTest431 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRandomTest448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTest468 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleLoopsDeclaration_in_ruleRandomTest489 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_ruleSeedDeclaration_in_ruleRandomTest510 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRandomTest523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardDeclaration_in_entryRuleGuardDeclaration559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardDeclaration569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_ruleGuardDeclaration614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionDeclaration_in_entryRuleTransitionDeclaration649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionDeclaration659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTransitionDeclaration696 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionDeclaration713 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransitionDeclaration730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionDeclaration750 = new BitSet(new long[]{0x00000000001C2000L});
    public static final BitSet FOLLOW_18_in_ruleTransitionDeclaration763 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_ruleTransitionDeclaration784 = new BitSet(new long[]{0x0000000000182000L});
    public static final BitSet FOLLOW_19_in_ruleTransitionDeclaration799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGuardDeclaration_in_ruleTransitionDeclaration820 = new BitSet(new long[]{0x0000000000102010L});
    public static final BitSet FOLLOW_20_in_ruleTransitionDeclaration836 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rulePreconditionDeclaration_in_ruleTransitionDeclaration858 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_rulePostconditionDeclaration_in_ruleTransitionDeclaration885 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_13_in_ruleTransitionDeclaration901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionDeclaration_in_entryRuleConditionDeclaration937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionDeclaration947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleConditionDeclaration984 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_ruleConditionDeclaration1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePreconditionDeclaration_in_entryRulePreconditionDeclaration1041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePreconditionDeclaration1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulePreconditionDeclaration1088 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_rulePreconditionDeclaration1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostconditionDeclaration_in_entryRulePostconditionDeclaration1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostconditionDeclaration1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePostconditionDeclaration1192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_rulePostconditionDeclaration1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateDeclaration_in_entryRuleStateDeclaration1249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateDeclaration1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleStateDeclaration1296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateDeclaration1313 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleStateDeclaration1331 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleConditionDeclaration_in_ruleStateDeclaration1352 = new BitSet(new long[]{0x0000000000310000L});
    public static final BitSet FOLLOW_ruleTransitionDeclaration_in_ruleStateDeclaration1376 = new BitSet(new long[]{0x0000000000112000L});
    public static final BitSet FOLLOW_13_in_ruleStateDeclaration1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopsDeclaration_in_entryRuleLoopsDeclaration1425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopsDeclaration1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleLoopsDeclaration1472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLoopsDeclaration1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSeedDeclaration_in_entryRuleSeedDeclaration1530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSeedDeclaration1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleSeedDeclaration1577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSeedDeclaration1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalDeclaration_in_entryRuleSignalDeclaration1635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalDeclaration1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalDeclaration1688 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSignalDeclaration1705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalDeclaration1724 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleSignalDeclaration1743 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignalDeclaration1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleSignalDeclaration1785 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSignalDeclaration1802 = new BitSet(new long[]{0x0000000000000002L});

}