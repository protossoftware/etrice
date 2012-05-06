package org.eclipse.etrice.core.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.services.ConfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ActorClassConfig'", "'{'", "'}'", "'ActorInstanceConfig'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalConfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g"; }



     	private ConfigGrammarAccess grammarAccess;
     	
        public InternalConfigParser(TokenStream input, ConfigGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConfigModel";	
       	}
       	
       	@Override
       	protected ConfigGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleConfigModel"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:67:1: entryRuleConfigModel returns [EObject current=null] : iv_ruleConfigModel= ruleConfigModel EOF ;
    public final EObject entryRuleConfigModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigModel = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:68:2: (iv_ruleConfigModel= ruleConfigModel EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:69:2: iv_ruleConfigModel= ruleConfigModel EOF
            {
             newCompositeNode(grammarAccess.getConfigModelRule()); 
            pushFollow(FOLLOW_ruleConfigModel_in_entryRuleConfigModel75);
            iv_ruleConfigModel=ruleConfigModel();

            state._fsp--;

             current =iv_ruleConfigModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigModel85); 

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
    // $ANTLR end "entryRuleConfigModel"


    // $ANTLR start "ruleConfigModel"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:76:1: ruleConfigModel returns [EObject current=null] : ( ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )* ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )* ) ;
    public final EObject ruleConfigModel() throws RecognitionException {
        EObject current = null;

        EObject lv_actorClassConfigs_0_0 = null;

        AntlrDatatypeRuleToken lv_actorInstanceConfigs_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:79:28: ( ( ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )* ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: ( ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )* ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: ( ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )* ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:2: ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )* ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:2: ( (lv_actorClassConfigs_0_0= ruleActorClassConfig ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:81:1: (lv_actorClassConfigs_0_0= ruleActorClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:81:1: (lv_actorClassConfigs_0_0= ruleActorClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:82:3: lv_actorClassConfigs_0_0= ruleActorClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getActorClassConfigsActorClassConfigParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorClassConfig_in_ruleConfigModel131);
            	    lv_actorClassConfigs_0_0=ruleActorClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorClassConfigs",
            	            		lv_actorClassConfigs_0_0, 
            	            		"ActorClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:98:3: ( (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:99:1: (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:99:1: (lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:100:3: lv_actorInstanceConfigs_1_0= ruleActorInstanceConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getActorInstanceConfigsActorInstanceConfigParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstanceConfig_in_ruleConfigModel153);
            	    lv_actorInstanceConfigs_1_0=ruleActorInstanceConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorInstanceConfigs",
            	            		lv_actorInstanceConfigs_1_0, 
            	            		"ActorInstanceConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleConfigModel"


    // $ANTLR start "entryRuleActorClassConfig"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:124:1: entryRuleActorClassConfig returns [EObject current=null] : iv_ruleActorClassConfig= ruleActorClassConfig EOF ;
    public final EObject entryRuleActorClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:125:2: (iv_ruleActorClassConfig= ruleActorClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:126:2: iv_ruleActorClassConfig= ruleActorClassConfig EOF
            {
             newCompositeNode(grammarAccess.getActorClassConfigRule()); 
            pushFollow(FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig190);
            iv_ruleActorClassConfig=ruleActorClassConfig();

            state._fsp--;

             current =iv_ruleActorClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClassConfig200); 

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
    // $ANTLR end "entryRuleActorClassConfig"


    // $ANTLR start "ruleActorClassConfig"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:133:1: ruleActorClassConfig returns [EObject current=null] : (otherlv_0= 'ActorClassConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= '}' ) ;
    public final EObject ruleActorClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:136:28: ( (otherlv_0= 'ActorClassConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:137:1: (otherlv_0= 'ActorClassConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:137:1: (otherlv_0= 'ActorClassConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:137:3: otherlv_0= 'ActorClassConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleActorClassConfig237); 

                	newLeafNode(otherlv_0, grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:141:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:142:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:142:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:143:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClassConfig257); 

            		newLeafNode(otherlv_1, grammarAccess.getActorClassConfigAccess().getActorClassActorClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleActorClassConfig269); 

                	newLeafNode(otherlv_2, grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleActorClassConfig281); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleActorClassConfig"


    // $ANTLR start "entryRuleActorInstanceConfig"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:170:1: entryRuleActorInstanceConfig returns [String current=null] : iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF ;
    public final String entryRuleActorInstanceConfig() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleActorInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:171:2: (iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:172:2: iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig318);
            iv_ruleActorInstanceConfig=ruleActorInstanceConfig();

            state._fsp--;

             current =iv_ruleActorInstanceConfig.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceConfig329); 

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
    // $ANTLR end "entryRuleActorInstanceConfig"


    // $ANTLR start "ruleActorInstanceConfig"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:179:1: ruleActorInstanceConfig returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'ActorInstanceConfig' kw= '{' kw= '}' ) ;
    public final AntlrDatatypeRuleToken ruleActorInstanceConfig() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:182:28: ( (kw= 'ActorInstanceConfig' kw= '{' kw= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:183:1: (kw= 'ActorInstanceConfig' kw= '{' kw= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:183:1: (kw= 'ActorInstanceConfig' kw= '{' kw= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:184:2: kw= 'ActorInstanceConfig' kw= '{' kw= '}'
            {
            kw=(Token)match(input,14,FOLLOW_14_in_ruleActorInstanceConfig367); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0()); 
                
            kw=(Token)match(input,12,FOLLOW_12_in_ruleActorInstanceConfig380); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_1()); 
                
            kw=(Token)match(input,13,FOLLOW_13_in_ruleActorInstanceConfig393); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_2()); 
                

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
    // $ANTLR end "ruleActorInstanceConfig"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleConfigModel_in_entryRuleConfigModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_ruleConfigModel131 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_ruleConfigModel153 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClassConfig200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleActorClassConfig237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClassConfig257 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClassConfig269 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClassConfig281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceConfig329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleActorInstanceConfig367 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorInstanceConfig380 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorInstanceConfig393 = new BitSet(new long[]{0x0000000000000002L});

}