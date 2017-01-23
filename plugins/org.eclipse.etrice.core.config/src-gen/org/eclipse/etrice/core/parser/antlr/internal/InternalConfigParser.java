package org.eclipse.etrice.core.parser.antlr.internal; 

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
import org.eclipse.etrice.core.services.ConfigGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ConfigModel'", "'{'", "'}'", "'SubSystemConfig'", "'/'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling interval'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'conjugated'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'read'", "'write'", "','", "'.'", "':'", "'optional'", "'mandatory'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'['", "']'", "'s'", "'ms'", "'us'", "'ns'", "'false'", "'true'", "'+'", "'-'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_HEX=7;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalConfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConfig.g"; }



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
    // InternalConfig.g:68:1: entryRuleConfigModel returns [EObject current=null] : iv_ruleConfigModel= ruleConfigModel EOF ;
    public final EObject entryRuleConfigModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigModel = null;


        try {
            // InternalConfig.g:69:2: (iv_ruleConfigModel= ruleConfigModel EOF )
            // InternalConfig.g:70:2: iv_ruleConfigModel= ruleConfigModel EOF
            {
             newCompositeNode(grammarAccess.getConfigModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigModel=ruleConfigModel();

            state._fsp--;

             current =iv_ruleConfigModel; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:77:1: ruleConfigModel returns [EObject current=null] : (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' ) ;
    public final EObject ruleConfigModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_configElements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:80:28: ( (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' ) )
            // InternalConfig.g:81:1: (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' )
            {
            // InternalConfig.g:81:1: (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' )
            // InternalConfig.g:81:3: otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getConfigModelAccess().getConfigModelKeyword_0());
                
            // InternalConfig.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalConfig.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // InternalConfig.g:86:1: (lv_name_1_0= ruleFQN )
            // InternalConfig.g:87:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getConfigModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.etrice.core.common.Base.FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getConfigModelAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalConfig.g:107:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalConfig.g:108:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalConfig.g:108:1: (lv_imports_3_0= ruleImport )
            	    // InternalConfig.g:109:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"org.eclipse.etrice.core.common.Base.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalConfig.g:125:3: ( (lv_configElements_4_0= ruleConfigElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15||(LA2_0>=22 && LA2_0<=24)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConfig.g:126:1: (lv_configElements_4_0= ruleConfigElement )
            	    {
            	    // InternalConfig.g:126:1: (lv_configElements_4_0= ruleConfigElement )
            	    // InternalConfig.g:127:3: lv_configElements_4_0= ruleConfigElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_configElements_4_0=ruleConfigElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configElements",
            	            		lv_configElements_4_0, 
            	            		"org.eclipse.etrice.core.Config.ConfigElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getConfigModelAccess().getRightCurlyBracketKeyword_5());
                

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


    // $ANTLR start "entryRuleConfigElement"
    // InternalConfig.g:155:1: entryRuleConfigElement returns [EObject current=null] : iv_ruleConfigElement= ruleConfigElement EOF ;
    public final EObject entryRuleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigElement = null;


        try {
            // InternalConfig.g:156:2: (iv_ruleConfigElement= ruleConfigElement EOF )
            // InternalConfig.g:157:2: iv_ruleConfigElement= ruleConfigElement EOF
            {
             newCompositeNode(grammarAccess.getConfigElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigElement=ruleConfigElement();

            state._fsp--;

             current =iv_ruleConfigElement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConfigElement"


    // $ANTLR start "ruleConfigElement"
    // InternalConfig.g:164:1: ruleConfigElement returns [EObject current=null] : (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) ;
    public final EObject ruleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_SubSystemConfig_0 = null;

        EObject this_ActorClassConfig_1 = null;

        EObject this_ActorInstanceConfig_2 = null;

        EObject this_ProtocolClassConfig_3 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:167:28: ( (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) )
            // InternalConfig.g:168:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            {
            // InternalConfig.g:168:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 24:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalConfig.g:169:5: this_SubSystemConfig_0= ruleSubSystemConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SubSystemConfig_0=ruleSubSystemConfig();

                    state._fsp--;

                     
                            current = this_SubSystemConfig_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:179:5: this_ActorClassConfig_1= ruleActorClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ActorClassConfig_1=ruleActorClassConfig();

                    state._fsp--;

                     
                            current = this_ActorClassConfig_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalConfig.g:189:5: this_ActorInstanceConfig_2= ruleActorInstanceConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ActorInstanceConfig_2=ruleActorInstanceConfig();

                    state._fsp--;

                     
                            current = this_ActorInstanceConfig_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalConfig.g:199:5: this_ProtocolClassConfig_3= ruleProtocolClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ProtocolClassConfig_3=ruleProtocolClassConfig();

                    state._fsp--;

                     
                            current = this_ProtocolClassConfig_3; 
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
    // $ANTLR end "ruleConfigElement"


    // $ANTLR start "entryRuleSubSystemConfig"
    // InternalConfig.g:215:1: entryRuleSubSystemConfig returns [EObject current=null] : iv_ruleSubSystemConfig= ruleSubSystemConfig EOF ;
    public final EObject entryRuleSubSystemConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemConfig = null;


        try {
            // InternalConfig.g:216:2: (iv_ruleSubSystemConfig= ruleSubSystemConfig EOF )
            // InternalConfig.g:217:2: iv_ruleSubSystemConfig= ruleSubSystemConfig EOF
            {
             newCompositeNode(grammarAccess.getSubSystemConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubSystemConfig=ruleSubSystemConfig();

            state._fsp--;

             current =iv_ruleSubSystemConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSubSystemConfig"


    // $ANTLR start "ruleSubSystemConfig"
    // InternalConfig.g:224:1: ruleSubSystemConfig returns [EObject current=null] : (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' ) ;
    public final EObject ruleSubSystemConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_dynConfig_5_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:227:28: ( (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' ) )
            // InternalConfig.g:228:1: (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' )
            {
            // InternalConfig.g:228:1: (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' )
            // InternalConfig.g:228:3: otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0());
                
            // InternalConfig.g:232:1: ( ( ruleFQN ) )
            // InternalConfig.g:233:1: ( ruleFQN )
            {
            // InternalConfig.g:233:1: ( ruleFQN )
            // InternalConfig.g:234:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemConfigAccess().getSolidusKeyword_2());
                
            // InternalConfig.g:251:1: ( (otherlv_3= RULE_ID ) )
            // InternalConfig.g:252:1: (otherlv_3= RULE_ID )
            {
            // InternalConfig.g:252:1: (otherlv_3= RULE_ID )
            // InternalConfig.g:253:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemConfigRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_4); 

            		newLeafNode(otherlv_3, grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalConfig.g:268:1: ( (lv_dynConfig_5_0= ruleDynamicConfig ) )
            // InternalConfig.g:269:1: (lv_dynConfig_5_0= ruleDynamicConfig )
            {
            // InternalConfig.g:269:1: (lv_dynConfig_5_0= ruleDynamicConfig )
            // InternalConfig.g:270:3: lv_dynConfig_5_0= ruleDynamicConfig
            {
             
            	        newCompositeNode(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_dynConfig_5_0=ruleDynamicConfig();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubSystemConfigRule());
            	        }
                   		set(
                   			current, 
                   			"dynConfig",
                    		lv_dynConfig_5_0, 
                    		"org.eclipse.etrice.core.Config.DynamicConfig");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleSubSystemConfig"


    // $ANTLR start "entryRuleDynamicConfig"
    // InternalConfig.g:298:1: entryRuleDynamicConfig returns [EObject current=null] : iv_ruleDynamicConfig= ruleDynamicConfig EOF ;
    public final EObject entryRuleDynamicConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDynamicConfig = null;


        try {
            // InternalConfig.g:299:2: (iv_ruleDynamicConfig= ruleDynamicConfig EOF )
            // InternalConfig.g:300:2: iv_ruleDynamicConfig= ruleDynamicConfig EOF
            {
             newCompositeNode(grammarAccess.getDynamicConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDynamicConfig=ruleDynamicConfig();

            state._fsp--;

             current =iv_ruleDynamicConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDynamicConfig"


    // $ANTLR start "ruleDynamicConfig"
    // InternalConfig.g:307:1: ruleDynamicConfig returns [EObject current=null] : (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) ;
    public final EObject ruleDynamicConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_filePath_4_0=null;
        Token otherlv_5=null;
        Token lv_userCode1_6_0=null;
        Token otherlv_7=null;
        Token lv_userCode2_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_polling_10_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:310:28: ( (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) )
            // InternalConfig.g:311:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            {
            // InternalConfig.g:311:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            // InternalConfig.g:311:3: otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalConfig.g:319:1: ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) ) )
            // InternalConfig.g:321:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalConfig.g:321:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?) )
            // InternalConfig.g:322:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	
            // InternalConfig.g:325:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?)
            // InternalConfig.g:326:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+ {...}?
            {
            // InternalConfig.g:326:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( LA5_0 >= 18 && LA5_0 <= 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConfig.g:328:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    {
            	    // InternalConfig.g:328:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    // InternalConfig.g:329:5: {...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalConfig.g:329:110: ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    // InternalConfig.g:330:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // InternalConfig.g:333:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    // InternalConfig.g:333:7: {...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // InternalConfig.g:333:16: ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
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
            	            // InternalConfig.g:333:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            {
            	            // InternalConfig.g:333:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            // InternalConfig.g:333:19: otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) )
            	            {
            	            otherlv_3=(Token)match(input,18,FOLLOW_11); 

            	                	newLeafNode(otherlv_3, grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0());
            	                
            	            // InternalConfig.g:337:1: ( (lv_filePath_4_0= RULE_STRING ) )
            	            // InternalConfig.g:338:1: (lv_filePath_4_0= RULE_STRING )
            	            {
            	            // InternalConfig.g:338:1: (lv_filePath_4_0= RULE_STRING )
            	            // InternalConfig.g:339:3: lv_filePath_4_0= RULE_STRING
            	            {
            	            lv_filePath_4_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	            			newLeafNode(lv_filePath_4_0, grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"filePath",
            	                    		lv_filePath_4_0, 
            	                    		"org.eclipse.xtext.common.Terminals.STRING");
            	            	    

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalConfig.g:356:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            {
            	            // InternalConfig.g:356:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            // InternalConfig.g:356:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            {
            	            // InternalConfig.g:356:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) )
            	            // InternalConfig.g:356:9: otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) )
            	            {
            	            otherlv_5=(Token)match(input,19,FOLLOW_11); 

            	                	newLeafNode(otherlv_5, grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0());
            	                
            	            // InternalConfig.g:360:1: ( (lv_userCode1_6_0= RULE_STRING ) )
            	            // InternalConfig.g:361:1: (lv_userCode1_6_0= RULE_STRING )
            	            {
            	            // InternalConfig.g:361:1: (lv_userCode1_6_0= RULE_STRING )
            	            // InternalConfig.g:362:3: lv_userCode1_6_0= RULE_STRING
            	            {
            	            lv_userCode1_6_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            	            			newLeafNode(lv_userCode1_6_0, grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"userCode1",
            	                    		lv_userCode1_6_0, 
            	                    		"org.eclipse.xtext.common.Terminals.STRING");
            	            	    

            	            }


            	            }


            	            }

            	            // InternalConfig.g:378:3: (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            // InternalConfig.g:378:5: otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) )
            	            {
            	            otherlv_7=(Token)match(input,20,FOLLOW_11); 

            	                	newLeafNode(otherlv_7, grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0());
            	                
            	            // InternalConfig.g:382:1: ( (lv_userCode2_8_0= RULE_STRING ) )
            	            // InternalConfig.g:383:1: (lv_userCode2_8_0= RULE_STRING )
            	            {
            	            // InternalConfig.g:383:1: (lv_userCode2_8_0= RULE_STRING )
            	            // InternalConfig.g:384:3: lv_userCode2_8_0= RULE_STRING
            	            {
            	            lv_userCode2_8_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            	            			newLeafNode(lv_userCode2_8_0, grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"userCode2",
            	                    		lv_userCode2_8_0, 
            	                    		"org.eclipse.xtext.common.Terminals.STRING");
            	            	    

            	            }


            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalConfig.g:407:4: ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) )
            	    {
            	    // InternalConfig.g:407:4: ({...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) ) )
            	    // InternalConfig.g:408:5: {...}? => ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalConfig.g:408:110: ( ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) ) )
            	    // InternalConfig.g:409:6: ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // InternalConfig.g:412:6: ({...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) ) )
            	    // InternalConfig.g:412:7: {...}? => (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // InternalConfig.g:412:16: (otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) ) )
            	    // InternalConfig.g:412:18: otherlv_9= 'polling interval' ( (lv_polling_10_0= ruleTIME ) )
            	    {
            	    otherlv_9=(Token)match(input,21,FOLLOW_14); 

            	        	newLeafNode(otherlv_9, grammarAccess.getDynamicConfigAccess().getPollingIntervalKeyword_2_1_0());
            	        
            	    // InternalConfig.g:416:1: ( (lv_polling_10_0= ruleTIME ) )
            	    // InternalConfig.g:417:1: (lv_polling_10_0= ruleTIME )
            	    {
            	    // InternalConfig.g:417:1: (lv_polling_10_0= ruleTIME )
            	    // InternalConfig.g:418:3: lv_polling_10_0= ruleTIME
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDynamicConfigAccess().getPollingTIMEParserRuleCall_2_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_12);
            	    lv_polling_10_0=ruleTIME();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDynamicConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"polling",
            	            		lv_polling_10_0, 
            	            		"org.eclipse.etrice.core.common.Base.TIME");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	    	 				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canLeave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	

            }

            otherlv_11=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_11, grammarAccess.getDynamicConfigAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleDynamicConfig"


    // $ANTLR start "entryRuleActorClassConfig"
    // InternalConfig.g:461:1: entryRuleActorClassConfig returns [EObject current=null] : iv_ruleActorClassConfig= ruleActorClassConfig EOF ;
    public final EObject entryRuleActorClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClassConfig = null;


        try {
            // InternalConfig.g:462:2: (iv_ruleActorClassConfig= ruleActorClassConfig EOF )
            // InternalConfig.g:463:2: iv_ruleActorClassConfig= ruleActorClassConfig EOF
            {
             newCompositeNode(grammarAccess.getActorClassConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorClassConfig=ruleActorClassConfig();

            state._fsp--;

             current =iv_ruleActorClassConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:470:1: ruleActorClassConfig returns [EObject current=null] : (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject ruleActorClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:473:28: ( (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // InternalConfig.g:474:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // InternalConfig.g:474:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // InternalConfig.g:474:3: otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0());
                
            // InternalConfig.g:478:1: ( ( ruleFQN ) )
            // InternalConfig.g:479:1: ( ruleFQN )
            {
            // InternalConfig.g:479:1: ( ruleFQN )
            // InternalConfig.g:480:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_2, grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalConfig.g:497:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==30) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalConfig.g:498:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // InternalConfig.g:498:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // InternalConfig.g:499:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_attributes_3_0=ruleAttrClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"org.eclipse.etrice.core.Config.AttrClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getActorClassConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // InternalConfig.g:527:1: entryRuleActorInstanceConfig returns [EObject current=null] : iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF ;
    public final EObject entryRuleActorInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceConfig = null;


        try {
            // InternalConfig.g:528:2: (iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF )
            // InternalConfig.g:529:2: iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorInstanceConfig=ruleActorInstanceConfig();

            state._fsp--;

             current =iv_ruleActorInstanceConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:536:1: ruleActorInstanceConfig returns [EObject current=null] : (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' ) ;
    public final EObject ruleActorInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        EObject lv_path_5_0 = null;

        EObject lv_attributes_8_0 = null;

        EObject lv_ports_9_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:539:28: ( (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' ) )
            // InternalConfig.g:540:1: (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' )
            {
            // InternalConfig.g:540:1: (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' )
            // InternalConfig.g:540:3: otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0());
                
            // InternalConfig.g:544:1: ( ( ruleFQN ) )
            // InternalConfig.g:545:1: ( ruleFQN )
            {
            // InternalConfig.g:545:1: ( ruleFQN )
            // InternalConfig.g:546:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_2());
                
            // InternalConfig.g:563:1: ( (otherlv_3= RULE_ID ) )
            // InternalConfig.g:564:1: (otherlv_3= RULE_ID )
            {
            // InternalConfig.g:564:1: (otherlv_3= RULE_ID )
            // InternalConfig.g:565:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceConfigRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_7); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_4());
                
            // InternalConfig.g:580:1: ( (lv_path_5_0= ruleRefPath ) )
            // InternalConfig.g:581:1: (lv_path_5_0= ruleRefPath )
            {
            // InternalConfig.g:581:1: (lv_path_5_0= ruleRefPath )
            // InternalConfig.g:582:3: lv_path_5_0= ruleRefPath
            {
             
            	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_path_5_0=ruleRefPath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_5_0, 
                    		"org.eclipse.etrice.core.Config.RefPath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_16); 

                	newLeafNode(otherlv_6, grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_6());
                
            // InternalConfig.g:602:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) )
            // InternalConfig.g:604:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) )
            {
            // InternalConfig.g:604:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) )
            // InternalConfig.g:605:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	
            // InternalConfig.g:608:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* )
            // InternalConfig.g:609:3: ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )*
            {
            // InternalConfig.g:609:3: ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( LA9_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                    alt9=1;
                }
                else if ( LA9_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalConfig.g:611:4: ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) )
            	    {
            	    // InternalConfig.g:611:4: ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) )
            	    // InternalConfig.g:612:5: {...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalConfig.g:612:116: ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ )
            	    // InternalConfig.g:613:6: ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // InternalConfig.g:616:6: ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==30) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalConfig.g:616:7: {...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    	    }
            	    	    // InternalConfig.g:616:16: ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )
            	    	    // InternalConfig.g:617:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
            	    	    {
            	    	    // InternalConfig.g:617:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
            	    	    // InternalConfig.g:618:3: lv_attributes_8_0= ruleAttrInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_7_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_16);
            	    	    lv_attributes_8_0=ruleAttrInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"attributes",
            	    	            		lv_attributes_8_0, 
            	    	            		"org.eclipse.etrice.core.Config.AttrInstanceConfig");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalConfig.g:641:4: ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) )
            	    {
            	    // InternalConfig.g:641:4: ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) )
            	    // InternalConfig.g:642:5: {...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalConfig.g:642:116: ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ )
            	    // InternalConfig.g:643:6: ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // InternalConfig.g:646:6: ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==29) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalConfig.g:646:7: {...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    	    }
            	    	    // InternalConfig.g:646:16: ( (lv_ports_9_0= rulePortInstanceConfig ) )
            	    	    // InternalConfig.g:647:1: (lv_ports_9_0= rulePortInstanceConfig )
            	    	    {
            	    	    // InternalConfig.g:647:1: (lv_ports_9_0= rulePortInstanceConfig )
            	    	    // InternalConfig.g:648:3: lv_ports_9_0= rulePortInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_7_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_16);
            	    	    lv_ports_9_0=rulePortInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"ports",
            	    	            		lv_ports_9_0, 
            	    	            		"org.eclipse.etrice.core.Config.PortInstanceConfig");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	

            }

            otherlv_10=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_10, grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_8());
                

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


    // $ANTLR start "entryRuleProtocolClassConfig"
    // InternalConfig.g:690:1: entryRuleProtocolClassConfig returns [EObject current=null] : iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF ;
    public final EObject entryRuleProtocolClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClassConfig = null;


        try {
            // InternalConfig.g:691:2: (iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF )
            // InternalConfig.g:692:2: iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocolClassConfig=ruleProtocolClassConfig();

            state._fsp--;

             current =iv_ruleProtocolClassConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProtocolClassConfig"


    // $ANTLR start "ruleProtocolClassConfig"
    // InternalConfig.g:699:1: ruleProtocolClassConfig returns [EObject current=null] : (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_9= '}' ) ;
    public final EObject ruleProtocolClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_regular_5_0 = null;

        EObject lv_conjugated_8_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:702:28: ( (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_9= '}' ) )
            // InternalConfig.g:703:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_9= '}' )
            {
            // InternalConfig.g:703:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_9= '}' )
            // InternalConfig.g:703:3: otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0());
                
            // InternalConfig.g:707:1: ( ( ruleFQN ) )
            // InternalConfig.g:708:1: ( ruleFQN )
            {
            // InternalConfig.g:708:1: ( ruleFQN )
            // InternalConfig.g:709:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_17); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalConfig.g:726:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) )
            // InternalConfig.g:728:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            {
            // InternalConfig.g:728:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            // InternalConfig.g:729:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	
            // InternalConfig.g:732:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )* )
            // InternalConfig.g:733:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )*
            {
            // InternalConfig.g:733:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 >= 26 && LA11_0 <= 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalConfig.g:735:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // InternalConfig.g:735:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    // InternalConfig.g:736:5: {...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalConfig.g:736:116: ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    // InternalConfig.g:737:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalConfig.g:740:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    // InternalConfig.g:740:7: {...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // InternalConfig.g:740:16: (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    // InternalConfig.g:740:18: otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_18); 

            	        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0());
            	        
            	    // InternalConfig.g:744:1: ( (lv_regular_5_0= rulePortClassConfig ) )
            	    // InternalConfig.g:745:1: (lv_regular_5_0= rulePortClassConfig )
            	    {
            	    // InternalConfig.g:745:1: (lv_regular_5_0= rulePortClassConfig )
            	    // InternalConfig.g:746:3: lv_regular_5_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_17);
            	    lv_regular_5_0=rulePortClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"regular",
            	            		lv_regular_5_0, 
            	            		"org.eclipse.etrice.core.Config.PortClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalConfig.g:769:4: ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // InternalConfig.g:769:4: ({...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) ) )
            	    // InternalConfig.g:770:5: {...}? => ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalConfig.g:770:116: ( ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) ) )
            	    // InternalConfig.g:771:6: ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalConfig.g:774:6: ({...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) ) )
            	    // InternalConfig.g:774:7: {...}? => ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // InternalConfig.g:774:16: ( (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) ) )
            	    // InternalConfig.g:774:17: (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' ) ( (lv_conjugated_8_0= rulePortClassConfig ) )
            	    {
            	    // InternalConfig.g:774:17: (otherlv_6= 'conjugate' | otherlv_7= 'conjugated' )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==26) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==27) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalConfig.g:774:19: otherlv_6= 'conjugate'
            	            {
            	            otherlv_6=(Token)match(input,26,FOLLOW_18); 

            	                	newLeafNode(otherlv_6, grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // InternalConfig.g:779:7: otherlv_7= 'conjugated'
            	            {
            	            otherlv_7=(Token)match(input,27,FOLLOW_18); 

            	                	newLeafNode(otherlv_7, grammarAccess.getProtocolClassConfigAccess().getConjugatedKeyword_3_1_0_1());
            	                

            	            }
            	            break;

            	    }

            	    // InternalConfig.g:783:2: ( (lv_conjugated_8_0= rulePortClassConfig ) )
            	    // InternalConfig.g:784:1: (lv_conjugated_8_0= rulePortClassConfig )
            	    {
            	    // InternalConfig.g:784:1: (lv_conjugated_8_0= rulePortClassConfig )
            	    // InternalConfig.g:785:3: lv_conjugated_8_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_17);
            	    lv_conjugated_8_0=rulePortClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"conjugated",
            	            		lv_conjugated_8_0, 
            	            		"org.eclipse.etrice.core.Config.PortClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	

            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleProtocolClassConfig"


    // $ANTLR start "entryRulePortClassConfig"
    // InternalConfig.g:827:1: entryRulePortClassConfig returns [EObject current=null] : iv_rulePortClassConfig= rulePortClassConfig EOF ;
    public final EObject entryRulePortClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClassConfig = null;


        try {
            // InternalConfig.g:828:2: (iv_rulePortClassConfig= rulePortClassConfig EOF )
            // InternalConfig.g:829:2: iv_rulePortClassConfig= rulePortClassConfig EOF
            {
             newCompositeNode(grammarAccess.getPortClassConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePortClassConfig=rulePortClassConfig();

            state._fsp--;

             current =iv_rulePortClassConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePortClassConfig"


    // $ANTLR start "rulePortClassConfig"
    // InternalConfig.g:836:1: rulePortClassConfig returns [EObject current=null] : ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:839:28: ( ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // InternalConfig.g:840:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // InternalConfig.g:840:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // InternalConfig.g:840:2: () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            // InternalConfig.g:840:2: ()
            // InternalConfig.g:841:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassConfigAccess().getPortKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_2, grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalConfig.g:854:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalConfig.g:855:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // InternalConfig.g:855:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // InternalConfig.g:856:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_attributes_3_0=ruleAttrClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"org.eclipse.etrice.core.Config.AttrClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getPortClassConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "rulePortClassConfig"


    // $ANTLR start "entryRulePortInstanceConfig"
    // InternalConfig.g:884:1: entryRulePortInstanceConfig returns [EObject current=null] : iv_rulePortInstanceConfig= rulePortInstanceConfig EOF ;
    public final EObject entryRulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortInstanceConfig = null;


        try {
            // InternalConfig.g:885:2: (iv_rulePortInstanceConfig= rulePortInstanceConfig EOF )
            // InternalConfig.g:886:2: iv_rulePortInstanceConfig= rulePortInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getPortInstanceConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePortInstanceConfig=rulePortInstanceConfig();

            state._fsp--;

             current =iv_rulePortInstanceConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePortInstanceConfig"


    // $ANTLR start "rulePortInstanceConfig"
    // InternalConfig.g:893:1: rulePortInstanceConfig returns [EObject current=null] : (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:896:28: ( (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) )
            // InternalConfig.g:897:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            {
            // InternalConfig.g:897:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            // InternalConfig.g:897:3: otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0());
                
            // InternalConfig.g:901:1: ( (otherlv_1= RULE_ID ) )
            // InternalConfig.g:902:1: (otherlv_1= RULE_ID )
            {
            // InternalConfig.g:902:1: (otherlv_1= RULE_ID )
            // InternalConfig.g:903:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_4); 

            		newLeafNode(otherlv_1, grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_2, grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalConfig.g:918:1: ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalConfig.g:919:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    {
            	    // InternalConfig.g:919:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    // InternalConfig.g:920:3: lv_attributes_3_0= ruleAttrInstanceConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_attributes_3_0=ruleAttrInstanceConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortInstanceConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"org.eclipse.etrice.core.Config.AttrInstanceConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getPortInstanceConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "rulePortInstanceConfig"


    // $ANTLR start "entryRuleAttrClassConfig"
    // InternalConfig.g:950:1: entryRuleAttrClassConfig returns [EObject current=null] : iv_ruleAttrClassConfig= ruleAttrClassConfig EOF ;
    public final EObject entryRuleAttrClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrClassConfig = null;


        try {
            // InternalConfig.g:951:2: (iv_ruleAttrClassConfig= ruleAttrClassConfig EOF )
            // InternalConfig.g:952:2: iv_ruleAttrClassConfig= ruleAttrClassConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrClassConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttrClassConfig=ruleAttrClassConfig();

            state._fsp--;

             current =iv_ruleAttrClassConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAttrClassConfig"


    // $ANTLR start "ruleAttrClassConfig"
    // InternalConfig.g:959:1: ruleAttrClassConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? ) ;
    public final EObject ruleAttrClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject lv_value_3_0 = null;

        EObject lv_min_7_0 = null;

        EObject lv_max_10_0 = null;

        EObject lv_attributes_11_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:962:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? ) )
            // InternalConfig.g:963:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? )
            {
            // InternalConfig.g:963:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? )
            // InternalConfig.g:963:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0());
                
            // InternalConfig.g:967:1: ( (otherlv_1= RULE_ID ) )
            // InternalConfig.g:968:1: (otherlv_1= RULE_ID )
            {
            // InternalConfig.g:968:1: (otherlv_1= RULE_ID )
            // InternalConfig.g:969:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrClassConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_19); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // InternalConfig.g:980:2: (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalConfig.g:980:4: otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_20); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // InternalConfig.g:984:1: ( (lv_value_3_0= ruleConfigValueArray ) )
                    // InternalConfig.g:985:1: (lv_value_3_0= ruleConfigValueArray )
                    {
                    // InternalConfig.g:985:1: (lv_value_3_0= ruleConfigValueArray )
                    // InternalConfig.g:986:3: lv_value_3_0= ruleConfigValueArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_value_3_0=ruleConfigValueArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"org.eclipse.etrice.core.Config.ConfigValueArray");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalConfig.g:1002:4: (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalConfig.g:1002:6: otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_22); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalConfig.g:1006:1: ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* )
                    // InternalConfig.g:1006:2: (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )*
                    {
                    // InternalConfig.g:1006:2: (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==32) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalConfig.g:1006:4: otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) )
                            {
                            otherlv_5=(Token)match(input,32,FOLLOW_23); 

                                	newLeafNode(otherlv_5, grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0());
                                
                            otherlv_6=(Token)match(input,31,FOLLOW_24); 

                                	newLeafNode(otherlv_6, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1());
                                
                            // InternalConfig.g:1014:1: ( (lv_min_7_0= ruleNumberLiteral ) )
                            // InternalConfig.g:1015:1: (lv_min_7_0= ruleNumberLiteral )
                            {
                            // InternalConfig.g:1015:1: (lv_min_7_0= ruleNumberLiteral )
                            // InternalConfig.g:1016:3: lv_min_7_0= ruleNumberLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_25);
                            lv_min_7_0=ruleNumberLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"org.eclipse.etrice.core.common.Base.NumberLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalConfig.g:1032:4: (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==33) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalConfig.g:1032:6: otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) )
                            {
                            otherlv_8=(Token)match(input,33,FOLLOW_23); 

                                	newLeafNode(otherlv_8, grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0());
                                
                            otherlv_9=(Token)match(input,31,FOLLOW_24); 

                                	newLeafNode(otherlv_9, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1());
                                
                            // InternalConfig.g:1040:1: ( (lv_max_10_0= ruleNumberLiteral ) )
                            // InternalConfig.g:1041:1: (lv_max_10_0= ruleNumberLiteral )
                            {
                            // InternalConfig.g:1041:1: (lv_max_10_0= ruleNumberLiteral )
                            // InternalConfig.g:1042:3: lv_max_10_0= ruleNumberLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_15);
                            lv_max_10_0=ruleNumberLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"max",
                                    		lv_max_10_0, 
                                    		"org.eclipse.etrice.core.common.Base.NumberLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalConfig.g:1058:4: ( (lv_attributes_11_0= ruleAttrClassConfig ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==30) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalConfig.g:1059:1: (lv_attributes_11_0= ruleAttrClassConfig )
                    	    {
                    	    // InternalConfig.g:1059:1: (lv_attributes_11_0= ruleAttrClassConfig )
                    	    // InternalConfig.g:1060:3: lv_attributes_11_0= ruleAttrClassConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    lv_attributes_11_0=ruleAttrClassConfig();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_11_0, 
                    	            		"org.eclipse.etrice.core.Config.AttrClassConfig");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_2); 

                        	newLeafNode(otherlv_12, grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_2());
                        

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
    // $ANTLR end "ruleAttrClassConfig"


    // $ANTLR start "entryRuleAttrInstanceConfig"
    // InternalConfig.g:1088:1: entryRuleAttrInstanceConfig returns [EObject current=null] : iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF ;
    public final EObject entryRuleAttrInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrInstanceConfig = null;


        try {
            // InternalConfig.g:1089:2: (iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF )
            // InternalConfig.g:1090:2: iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrInstanceConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttrInstanceConfig=ruleAttrInstanceConfig();

            state._fsp--;

             current =iv_ruleAttrInstanceConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAttrInstanceConfig"


    // $ANTLR start "ruleAttrInstanceConfig"
    // InternalConfig.g:1097:1: ruleAttrInstanceConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? ) ;
    public final EObject ruleAttrInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_dynConfig_5_0=null;
        Token lv_readOnly_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_value_3_0 = null;

        EObject lv_attributes_8_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1100:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? ) )
            // InternalConfig.g:1101:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? )
            {
            // InternalConfig.g:1101:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? )
            // InternalConfig.g:1101:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0());
                
            // InternalConfig.g:1105:1: ( (otherlv_1= RULE_ID ) )
            // InternalConfig.g:1106:1: (otherlv_1= RULE_ID )
            {
            // InternalConfig.g:1106:1: (otherlv_1= RULE_ID )
            // InternalConfig.g:1107:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_19); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // InternalConfig.g:1118:2: (otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalConfig.g:1118:4: otherlv_2= '=' ( (lv_value_3_0= ruleConfigValueArray ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_20); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // InternalConfig.g:1122:1: ( (lv_value_3_0= ruleConfigValueArray ) )
                    // InternalConfig.g:1123:1: (lv_value_3_0= ruleConfigValueArray )
                    {
                    // InternalConfig.g:1123:1: (lv_value_3_0= ruleConfigValueArray )
                    // InternalConfig.g:1124:3: lv_value_3_0= ruleConfigValueArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getValueConfigValueArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
                    lv_value_3_0=ruleConfigValueArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrInstanceConfigRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"org.eclipse.etrice.core.Config.ConfigValueArray");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalConfig.g:1140:4: (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==13) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalConfig.g:1140:6: otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_26); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalConfig.g:1144:1: ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* )
                    // InternalConfig.g:1144:2: ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )*
                    {
                    // InternalConfig.g:1144:2: ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==17) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalConfig.g:1144:3: ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            {
                            // InternalConfig.g:1144:3: ( (lv_dynConfig_5_0= 'dynamic configuration' ) )
                            // InternalConfig.g:1145:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            {
                            // InternalConfig.g:1145:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            // InternalConfig.g:1146:3: lv_dynConfig_5_0= 'dynamic configuration'
                            {
                            lv_dynConfig_5_0=(Token)match(input,17,FOLLOW_27); 

                                    newLeafNode(lv_dynConfig_5_0, grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
                            	        }
                                   		setWithLastConsumed(current, "dynConfig", true, "dynamic configuration");
                            	    

                            }


                            }

                            // InternalConfig.g:1159:2: ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==34) ) {
                                alt20=1;
                            }
                            else if ( (LA20_0==35) ) {
                                alt20=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 20, 0, input);

                                throw nvae;
                            }
                            switch (alt20) {
                                case 1 :
                                    // InternalConfig.g:1159:3: ( (lv_readOnly_6_0= 'read' ) )
                                    {
                                    // InternalConfig.g:1159:3: ( (lv_readOnly_6_0= 'read' ) )
                                    // InternalConfig.g:1160:1: (lv_readOnly_6_0= 'read' )
                                    {
                                    // InternalConfig.g:1160:1: (lv_readOnly_6_0= 'read' )
                                    // InternalConfig.g:1161:3: lv_readOnly_6_0= 'read'
                                    {
                                    lv_readOnly_6_0=(Token)match(input,34,FOLLOW_15); 

                                            newLeafNode(lv_readOnly_6_0, grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_0_1_0_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
                                    	        }
                                           		setWithLastConsumed(current, "readOnly", true, "read");
                                    	    

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalConfig.g:1175:7: otherlv_7= 'write'
                                    {
                                    otherlv_7=(Token)match(input,35,FOLLOW_15); 

                                        	newLeafNode(otherlv_7, grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_0_1_1());
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // InternalConfig.g:1179:4: ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==30) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalConfig.g:1180:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    {
                    	    // InternalConfig.g:1180:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    // InternalConfig.g:1181:3: lv_attributes_8_0= ruleAttrInstanceConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    lv_attributes_8_0=ruleAttrInstanceConfig();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrInstanceConfigRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_8_0, 
                    	            		"org.eclipse.etrice.core.Config.AttrInstanceConfig");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }

                    otherlv_9=(Token)match(input,14,FOLLOW_2); 

                        	newLeafNode(otherlv_9, grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_2());
                        

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
    // $ANTLR end "ruleAttrInstanceConfig"


    // $ANTLR start "entryRuleConfigValueArray"
    // InternalConfig.g:1209:1: entryRuleConfigValueArray returns [EObject current=null] : iv_ruleConfigValueArray= ruleConfigValueArray EOF ;
    public final EObject entryRuleConfigValueArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigValueArray = null;


        try {
            // InternalConfig.g:1210:2: (iv_ruleConfigValueArray= ruleConfigValueArray EOF )
            // InternalConfig.g:1211:2: iv_ruleConfigValueArray= ruleConfigValueArray EOF
            {
             newCompositeNode(grammarAccess.getConfigValueArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigValueArray=ruleConfigValueArray();

            state._fsp--;

             current =iv_ruleConfigValueArray; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConfigValueArray"


    // $ANTLR start "ruleConfigValueArray"
    // InternalConfig.g:1218:1: ruleConfigValueArray returns [EObject current=null] : ( ( (lv_values_0_0= ruleConfigValue ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )* ) ;
    public final EObject ruleConfigValueArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1221:28: ( ( ( (lv_values_0_0= ruleConfigValue ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )* ) )
            // InternalConfig.g:1222:1: ( ( (lv_values_0_0= ruleConfigValue ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )* )
            {
            // InternalConfig.g:1222:1: ( ( (lv_values_0_0= ruleConfigValue ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )* )
            // InternalConfig.g:1222:2: ( (lv_values_0_0= ruleConfigValue ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )*
            {
            // InternalConfig.g:1222:2: ( (lv_values_0_0= ruleConfigValue ) )
            // InternalConfig.g:1223:1: (lv_values_0_0= ruleConfigValue )
            {
            // InternalConfig.g:1223:1: (lv_values_0_0= ruleConfigValue )
            // InternalConfig.g:1224:3: lv_values_0_0= ruleConfigValue
            {
             
            	        newCompositeNode(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_28);
            lv_values_0_0=ruleConfigValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigValueArrayRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_0_0, 
                    		"org.eclipse.etrice.core.Config.ConfigValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalConfig.g:1240:2: (otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==36) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalConfig.g:1240:4: otherlv_1= ',' ( (lv_values_2_0= ruleConfigValue ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_20); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConfigValueArrayAccess().getCommaKeyword_1_0());
            	        
            	    // InternalConfig.g:1244:1: ( (lv_values_2_0= ruleConfigValue ) )
            	    // InternalConfig.g:1245:1: (lv_values_2_0= ruleConfigValue )
            	    {
            	    // InternalConfig.g:1245:1: (lv_values_2_0= ruleConfigValue )
            	    // InternalConfig.g:1246:3: lv_values_2_0= ruleConfigValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigValueArrayAccess().getValuesConfigValueParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_28);
            	    lv_values_2_0=ruleConfigValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigValueArrayRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"org.eclipse.etrice.core.Config.ConfigValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


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
    // $ANTLR end "ruleConfigValueArray"


    // $ANTLR start "entryRuleConfigValue"
    // InternalConfig.g:1270:1: entryRuleConfigValue returns [EObject current=null] : iv_ruleConfigValue= ruleConfigValue EOF ;
    public final EObject entryRuleConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigValue = null;


        try {
            // InternalConfig.g:1271:2: (iv_ruleConfigValue= ruleConfigValue EOF )
            // InternalConfig.g:1272:2: iv_ruleConfigValue= ruleConfigValue EOF
            {
             newCompositeNode(grammarAccess.getConfigValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigValue=ruleConfigValue();

            state._fsp--;

             current =iv_ruleConfigValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConfigValue"


    // $ANTLR start "ruleConfigValue"
    // InternalConfig.g:1279:1: ruleConfigValue returns [EObject current=null] : (this_LiteralConfigValue_0= ruleLiteralConfigValue | this_EnumConfigValue_1= ruleEnumConfigValue ) ;
    public final EObject ruleConfigValue() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralConfigValue_0 = null;

        EObject this_EnumConfigValue_1 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1282:28: ( (this_LiteralConfigValue_0= ruleLiteralConfigValue | this_EnumConfigValue_1= ruleEnumConfigValue ) )
            // InternalConfig.g:1283:1: (this_LiteralConfigValue_0= ruleLiteralConfigValue | this_EnumConfigValue_1= ruleEnumConfigValue )
            {
            // InternalConfig.g:1283:1: (this_LiteralConfigValue_0= ruleLiteralConfigValue | this_EnumConfigValue_1= ruleEnumConfigValue )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_HEX)||(LA25_0>=52 && LA25_0<=55)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalConfig.g:1284:5: this_LiteralConfigValue_0= ruleLiteralConfigValue
                    {
                     
                            newCompositeNode(grammarAccess.getConfigValueAccess().getLiteralConfigValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LiteralConfigValue_0=ruleLiteralConfigValue();

                    state._fsp--;

                     
                            current = this_LiteralConfigValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:1294:5: this_EnumConfigValue_1= ruleEnumConfigValue
                    {
                     
                            newCompositeNode(grammarAccess.getConfigValueAccess().getEnumConfigValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EnumConfigValue_1=ruleEnumConfigValue();

                    state._fsp--;

                     
                            current = this_EnumConfigValue_1; 
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
    // $ANTLR end "ruleConfigValue"


    // $ANTLR start "entryRuleLiteralConfigValue"
    // InternalConfig.g:1310:1: entryRuleLiteralConfigValue returns [EObject current=null] : iv_ruleLiteralConfigValue= ruleLiteralConfigValue EOF ;
    public final EObject entryRuleLiteralConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralConfigValue = null;


        try {
            // InternalConfig.g:1311:2: (iv_ruleLiteralConfigValue= ruleLiteralConfigValue EOF )
            // InternalConfig.g:1312:2: iv_ruleLiteralConfigValue= ruleLiteralConfigValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralConfigValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralConfigValue=ruleLiteralConfigValue();

            state._fsp--;

             current =iv_ruleLiteralConfigValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteralConfigValue"


    // $ANTLR start "ruleLiteralConfigValue"
    // InternalConfig.g:1319:1: ruleLiteralConfigValue returns [EObject current=null] : ( (lv_value_0_0= ruleLiteral ) ) ;
    public final EObject ruleLiteralConfigValue() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1322:28: ( ( (lv_value_0_0= ruleLiteral ) ) )
            // InternalConfig.g:1323:1: ( (lv_value_0_0= ruleLiteral ) )
            {
            // InternalConfig.g:1323:1: ( (lv_value_0_0= ruleLiteral ) )
            // InternalConfig.g:1324:1: (lv_value_0_0= ruleLiteral )
            {
            // InternalConfig.g:1324:1: (lv_value_0_0= ruleLiteral )
            // InternalConfig.g:1325:3: lv_value_0_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getLiteralConfigValueAccess().getValueLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralConfigValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.etrice.core.common.Base.Literal");
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
    // $ANTLR end "ruleLiteralConfigValue"


    // $ANTLR start "entryRuleEnumConfigValue"
    // InternalConfig.g:1349:1: entryRuleEnumConfigValue returns [EObject current=null] : iv_ruleEnumConfigValue= ruleEnumConfigValue EOF ;
    public final EObject entryRuleEnumConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumConfigValue = null;


        try {
            // InternalConfig.g:1350:2: (iv_ruleEnumConfigValue= ruleEnumConfigValue EOF )
            // InternalConfig.g:1351:2: iv_ruleEnumConfigValue= ruleEnumConfigValue EOF
            {
             newCompositeNode(grammarAccess.getEnumConfigValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumConfigValue=ruleEnumConfigValue();

            state._fsp--;

             current =iv_ruleEnumConfigValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnumConfigValue"


    // $ANTLR start "ruleEnumConfigValue"
    // InternalConfig.g:1358:1: ruleEnumConfigValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleEnumConfigValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:1361:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalConfig.g:1362:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalConfig.g:1362:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalConfig.g:1362:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalConfig.g:1362:2: ( (otherlv_0= RULE_ID ) )
            // InternalConfig.g:1363:1: (otherlv_0= RULE_ID )
            {
            // InternalConfig.g:1363:1: (otherlv_0= RULE_ID )
            // InternalConfig.g:1364:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumConfigValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            		newLeafNode(otherlv_0, grammarAccess.getEnumConfigValueAccess().getTypeEnumerationTypeCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumConfigValueAccess().getFullStopKeyword_1());
                
            // InternalConfig.g:1379:1: ( (otherlv_2= RULE_ID ) )
            // InternalConfig.g:1380:1: (otherlv_2= RULE_ID )
            {
            // InternalConfig.g:1380:1: (otherlv_2= RULE_ID )
            // InternalConfig.g:1381:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumConfigValueRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getEnumConfigValueAccess().getValueEnumLiteralCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleEnumConfigValue"


    // $ANTLR start "entryRuleRefPath"
    // InternalConfig.g:1400:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalConfig.g:1401:2: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalConfig.g:1402:2: iv_ruleRefPath= ruleRefPath EOF
            {
             newCompositeNode(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefPath=ruleRefPath();

            state._fsp--;

             current =iv_ruleRefPath; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRefPath"


    // $ANTLR start "ruleRefPath"
    // InternalConfig.g:1409:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1412:28: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalConfig.g:1413:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalConfig.g:1413:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalConfig.g:1413:2: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalConfig.g:1413:2: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalConfig.g:1414:1: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalConfig.g:1414:1: (lv_refs_0_0= ruleRefSegment )
            // InternalConfig.g:1415:3: lv_refs_0_0= ruleRefSegment
            {
             
            	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_30);
            lv_refs_0_0=ruleRefSegment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefPathRule());
            	        }
                   		add(
                   			current, 
                   			"refs",
                    		lv_refs_0_0, 
                    		"org.eclipse.etrice.core.Config.RefSegment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalConfig.g:1431:2: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalConfig.g:1431:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // InternalConfig.g:1435:1: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalConfig.g:1436:1: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalConfig.g:1436:1: (lv_refs_2_0= ruleRefSegment )
            	    // InternalConfig.g:1437:3: lv_refs_2_0= ruleRefSegment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_30);
            	    lv_refs_2_0=ruleRefSegment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRefPathRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"refs",
            	            		lv_refs_2_0, 
            	            		"org.eclipse.etrice.core.Config.RefSegment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end "ruleRefPath"


    // $ANTLR start "entryRuleRefSegment"
    // InternalConfig.g:1461:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalConfig.g:1462:2: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalConfig.g:1463:2: iv_ruleRefSegment= ruleRefSegment EOF
            {
             newCompositeNode(grammarAccess.getRefSegmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefSegment=ruleRefSegment();

            state._fsp--;

             current =iv_ruleRefSegment; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRefSegment"


    // $ANTLR start "ruleRefSegment"
    // InternalConfig.g:1470:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:1473:28: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalConfig.g:1474:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalConfig.g:1474:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalConfig.g:1474:2: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalConfig.g:1474:2: ( (lv_ref_0_0= RULE_ID ) )
            // InternalConfig.g:1475:1: (lv_ref_0_0= RULE_ID )
            {
            // InternalConfig.g:1475:1: (lv_ref_0_0= RULE_ID )
            // InternalConfig.g:1476:3: lv_ref_0_0= RULE_ID
            {
            lv_ref_0_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            			newLeafNode(lv_ref_0_0, grammarAccess.getRefSegmentAccess().getRefIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSegmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ref",
                    		lv_ref_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalConfig.g:1492:2: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalConfig.g:1492:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_14); 

                        	newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                        
                    // InternalConfig.g:1496:1: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalConfig.g:1497:1: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalConfig.g:1497:1: (lv_idx_2_0= RULE_INT )
                    // InternalConfig.g:1498:3: lv_idx_2_0= RULE_INT
                    {
                    lv_idx_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_idx_2_0, grammarAccess.getRefSegmentAccess().getIdxINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRefSegmentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"idx",
                            		lv_idx_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

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
    // $ANTLR end "ruleRefSegment"


    // $ANTLR start "entryRuleKeyValue"
    // InternalConfig.g:1524:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalConfig.g:1525:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalConfig.g:1526:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1533:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1536:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalConfig.g:1537:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalConfig.g:1537:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalConfig.g:1537:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalConfig.g:1537:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalConfig.g:1538:1: (lv_key_0_0= RULE_ID )
            {
            // InternalConfig.g:1538:1: (lv_key_0_0= RULE_ID )
            // InternalConfig.g:1539:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            			newLeafNode(lv_key_0_0, grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_32); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalConfig.g:1559:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalConfig.g:1560:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalConfig.g:1560:1: (lv_value_2_0= ruleLiteral )
            // InternalConfig.g:1561:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.etrice.core.common.Base.Literal");
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
    // InternalConfig.g:1587:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalConfig.g:1588:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalConfig.g:1589:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1596:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:1599:28: (this_ID_0= RULE_ID )
            // InternalConfig.g:1600:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalConfig.g:1615:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalConfig.g:1616:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalConfig.g:1617:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1624:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1627:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalConfig.g:1628:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalConfig.g:1628:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==41) ) {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==RULE_ID) ) {
                        int LA28_4 = input.LA(4);

                        if ( (LA28_4==38) ) {
                            int LA28_5 = input.LA(5);

                            if ( ((LA28_5>=58 && LA28_5<=61)) ) {
                                alt28=1;
                            }
                            else if ( (LA28_5==13) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 28, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==40) ) {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==41) ) {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==RULE_ID) ) {
                        int LA28_4 = input.LA(4);

                        if ( (LA28_4==38) ) {
                            int LA28_5 = input.LA(5);

                            if ( ((LA28_5>=58 && LA28_5<=61)) ) {
                                alt28=1;
                            }
                            else if ( (LA28_5==13) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 28, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalConfig.g:1629:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:1639:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:1655:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalConfig.g:1656:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalConfig.g:1657:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1664:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalConfig.g:1667:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalConfig.g:1668:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalConfig.g:1668:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalConfig.g:1668:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalConfig.g:1668:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==39) ) {
                alt29=1;
            }
            else if ( (LA29_0==40) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalConfig.g:1668:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalConfig.g:1668:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalConfig.g:1669:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalConfig.g:1669:1: (lv_optional_0_0= 'optional' )
                    // InternalConfig.g:1670:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,39,FOLLOW_33); 

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
                    // InternalConfig.g:1684:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_33); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,41,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalConfig.g:1692:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalConfig.g:1693:1: (lv_name_3_0= RULE_ID )
            {
            // InternalConfig.g:1693:1: (lv_name_3_0= RULE_ID )
            // InternalConfig.g:1694:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            			newLeafNode(lv_name_3_0, grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_35); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalConfig.g:1714:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalConfig.g:1715:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalConfig.g:1715:1: (lv_type_5_0= ruleLiteralType )
            // InternalConfig.g:1716:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_type_5_0=ruleLiteralType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_5_0, 
                    		"org.eclipse.etrice.core.common.Base.LiteralType");
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
    // InternalConfig.g:1740:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalConfig.g:1741:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalConfig.g:1742:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1749:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalConfig.g:1752:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalConfig.g:1753:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalConfig.g:1753:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalConfig.g:1753:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalConfig.g:1753:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==39) ) {
                alt30=1;
            }
            else if ( (LA30_0==40) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalConfig.g:1753:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalConfig.g:1753:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalConfig.g:1754:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalConfig.g:1754:1: (lv_optional_0_0= 'optional' )
                    // InternalConfig.g:1755:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,39,FOLLOW_33); 

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
                    // InternalConfig.g:1769:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_33); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,41,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalConfig.g:1777:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalConfig.g:1778:1: (lv_name_3_0= RULE_ID )
            {
            // InternalConfig.g:1778:1: (lv_name_3_0= RULE_ID )
            // InternalConfig.g:1779:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            			newLeafNode(lv_name_3_0, grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_4); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,13,FOLLOW_11); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalConfig.g:1803:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalConfig.g:1804:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalConfig.g:1804:1: (lv_values_6_0= RULE_STRING )
            // InternalConfig.g:1805:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

            			newLeafNode(lv_values_6_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"values",
                    		lv_values_6_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalConfig.g:1821:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==36) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalConfig.g:1821:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,36,FOLLOW_11); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalConfig.g:1825:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalConfig.g:1826:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalConfig.g:1826:1: (lv_values_8_0= RULE_STRING )
            	    // InternalConfig.g:1827:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

            	    			newLeafNode(lv_values_8_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"values",
            	            		lv_values_8_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

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


    // $ANTLR start "entryRuleImport"
    // InternalConfig.g:1855:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalConfig.g:1856:2: (iv_ruleImport= ruleImport EOF )
            // InternalConfig.g:1857:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalConfig.g:1864:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1867:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalConfig.g:1868:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalConfig.g:1868:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalConfig.g:1868:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_37); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalConfig.g:1872:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            else if ( (LA32_0==44) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalConfig.g:1872:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalConfig.g:1872:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalConfig.g:1872:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalConfig.g:1872:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalConfig.g:1873:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalConfig.g:1873:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalConfig.g:1874:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_importedNamespace_1_0=ruleImportedFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_1_0, 
                            		"org.eclipse.etrice.core.common.Base.ImportedFQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,43,FOLLOW_11); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:1895:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_11); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalConfig.g:1899:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalConfig.g:1900:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalConfig.g:1900:1: (lv_importURI_4_0= RULE_STRING )
            // InternalConfig.g:1901:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_importURI_4_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_4_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalConfig.g:1925:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalConfig.g:1926:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalConfig.g:1927:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1934:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:1937:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalConfig.g:1938:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalConfig.g:1938:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalConfig.g:1939:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_39);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalConfig.g:1949:1: (kw= '.*' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==45) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalConfig.g:1950:2: kw= '.*'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

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
    // InternalConfig.g:1963:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalConfig.g:1964:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalConfig.g:1965:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:1972:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:1975:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalConfig.g:1976:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalConfig.g:1976:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalConfig.g:1976:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalConfig.g:1976:2: ()
            // InternalConfig.g:1977:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,46,FOLLOW_40); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalConfig.g:1986:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_STRING) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalConfig.g:1987:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalConfig.g:1987:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalConfig.g:1988:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

            	    			newLeafNode(lv_lines_2_0, grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDocumentationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"lines",
            	            		lv_lines_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_2); 

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


    // $ANTLR start "entryRuleTIME"
    // InternalConfig.g:2016:1: entryRuleTIME returns [String current=null] : iv_ruleTIME= ruleTIME EOF ;
    public final String entryRuleTIME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTIME = null;


        try {
            // InternalConfig.g:2017:2: (iv_ruleTIME= ruleTIME EOF )
            // InternalConfig.g:2018:2: iv_ruleTIME= ruleTIME EOF
            {
             newCompositeNode(grammarAccess.getTIMERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTIME=ruleTIME();

            state._fsp--;

             current =iv_ruleTIME.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTIME"


    // $ANTLR start "ruleTIME"
    // InternalConfig.g:2025:1: ruleTIME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) ;
    public final AntlrDatatypeRuleToken ruleTIME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:2028:28: ( ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) )
            // InternalConfig.g:2029:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            {
            // InternalConfig.g:2029:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            int alt35=4;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 51:
                    {
                    alt35=4;
                    }
                    break;
                case 50:
                    {
                    alt35=3;
                    }
                    break;
                case 49:
                    {
                    alt35=2;
                    }
                    break;
                case 48:
                    {
                    alt35=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalConfig.g:2029:2: (this_INT_0= RULE_INT kw= 's' )
                    {
                    // InternalConfig.g:2029:2: (this_INT_0= RULE_INT kw= 's' )
                    // InternalConfig.g:2029:7: this_INT_0= RULE_INT kw= 's'
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_41); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:2043:6: (this_INT_2= RULE_INT kw= 'ms' )
                    {
                    // InternalConfig.g:2043:6: (this_INT_2= RULE_INT kw= 'ms' )
                    // InternalConfig.g:2043:11: this_INT_2= RULE_INT kw= 'ms'
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_42); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
                        
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalConfig.g:2057:6: (this_INT_4= RULE_INT kw= 'us' )
                    {
                    // InternalConfig.g:2057:6: (this_INT_4= RULE_INT kw= 'us' )
                    // InternalConfig.g:2057:11: this_INT_4= RULE_INT kw= 'us'
                    {
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_43); 

                    		current.merge(this_INT_4);
                        
                     
                        newLeafNode(this_INT_4, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
                        
                    kw=(Token)match(input,50,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalConfig.g:2071:6: (this_INT_6= RULE_INT kw= 'ns' )
                    {
                    // InternalConfig.g:2071:6: (this_INT_6= RULE_INT kw= 'ns' )
                    // InternalConfig.g:2071:11: this_INT_6= RULE_INT kw= 'ns'
                    {
                    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_44); 

                    		current.merge(this_INT_6);
                        
                     
                        newLeafNode(this_INT_6, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
                        
                    kw=(Token)match(input,51,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
                        

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
    // $ANTLR end "ruleTIME"


    // $ANTLR start "entryRuleLiteral"
    // InternalConfig.g:2094:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalConfig.g:2095:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalConfig.g:2096:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2103:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:2106:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalConfig.g:2107:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalConfig.g:2107:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 52:
            case 53:
                {
                alt36=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 54:
            case 55:
                {
                alt36=2;
                }
                break;
            case RULE_STRING:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalConfig.g:2108:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2118:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalConfig.g:2128:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2144:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalConfig.g:2145:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalConfig.g:2146:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2153:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:2156:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalConfig.g:2157:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalConfig.g:2157:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalConfig.g:2157:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalConfig.g:2157:2: ()
            // InternalConfig.g:2158:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalConfig.g:2163:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==52) ) {
                alt37=1;
            }
            else if ( (LA37_0==53) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalConfig.g:2163:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,52,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2168:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalConfig.g:2168:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalConfig.g:2169:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalConfig.g:2169:1: (lv_isTrue_2_0= 'true' )
                    // InternalConfig.g:2170:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,53,FOLLOW_2); 

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
    // InternalConfig.g:2191:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalConfig.g:2192:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalConfig.g:2193:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2200:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:2203:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalConfig.g:2204:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalConfig.g:2204:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt38=2;
            switch ( input.LA(1) ) {
            case 54:
                {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==RULE_INT) ) {
                    int LA38_3 = input.LA(3);

                    if ( (LA38_3==37) ) {
                        alt38=2;
                    }
                    else if ( (LA38_3==EOF||(LA38_3>=13 && LA38_3<=14)||(LA38_3>=29 && LA38_3<=30)||LA38_3==33||LA38_3==36) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==RULE_INT) ) {
                    int LA38_3 = input.LA(3);

                    if ( (LA38_3==37) ) {
                        alt38=2;
                    }
                    else if ( (LA38_3==EOF||(LA38_3>=13 && LA38_3<=14)||(LA38_3>=29 && LA38_3<=30)||LA38_3==33||LA38_3==36) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==37) ) {
                    alt38=2;
                }
                else if ( (LA38_3==EOF||(LA38_3>=13 && LA38_3<=14)||(LA38_3>=29 && LA38_3<=30)||LA38_3==33||LA38_3==36) ) {
                    alt38=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt38=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalConfig.g:2205:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2215:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalConfig.g:2231:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalConfig.g:2232:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalConfig.g:2233:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2240:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:2243:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalConfig.g:2244:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalConfig.g:2244:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalConfig.g:2244:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalConfig.g:2244:2: ()
            // InternalConfig.g:2245:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalConfig.g:2250:2: ( (lv_value_1_0= ruleReal ) )
            // InternalConfig.g:2251:1: (lv_value_1_0= ruleReal )
            {
            // InternalConfig.g:2251:1: (lv_value_1_0= ruleReal )
            // InternalConfig.g:2252:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleReal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.etrice.core.common.Base.Real");
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
    // InternalConfig.g:2276:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalConfig.g:2277:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalConfig.g:2278:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2285:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:2288:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalConfig.g:2289:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalConfig.g:2289:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalConfig.g:2289:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalConfig.g:2289:2: ()
            // InternalConfig.g:2290:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalConfig.g:2295:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalConfig.g:2296:1: (lv_value_1_0= ruleInteger )
            {
            // InternalConfig.g:2296:1: (lv_value_1_0= ruleInteger )
            // InternalConfig.g:2297:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleInteger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.etrice.core.common.Base.Integer");
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
    // InternalConfig.g:2321:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalConfig.g:2322:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalConfig.g:2323:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2330:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:2333:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalConfig.g:2334:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalConfig.g:2334:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalConfig.g:2334:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalConfig.g:2334:2: ()
            // InternalConfig.g:2335:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalConfig.g:2340:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalConfig.g:2341:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalConfig.g:2341:1: (lv_value_1_0= RULE_STRING )
            // InternalConfig.g:2342:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // InternalConfig.g:2366:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalConfig.g:2367:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalConfig.g:2368:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2375:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:2378:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalConfig.g:2379:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalConfig.g:2379:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_INT||(LA40_0>=54 && LA40_0<=55)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_HEX) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalConfig.g:2379:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalConfig.g:2379:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalConfig.g:2379:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalConfig.g:2379:3: (kw= '+' | kw= '-' )?
                    int alt39=3;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==54) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==55) ) {
                        alt39=2;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalConfig.g:2380:2: kw= '+'
                            {
                            kw=(Token)match(input,54,FOLLOW_14); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalConfig.g:2387:2: kw= '-'
                            {
                            kw=(Token)match(input,55,FOLLOW_14); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getHyphenMinusKeyword_0_0_1()); 
                                

                            }
                            break;

                    }

                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getIntegerAccess().getINTTerminalRuleCall_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:2400:10: this_HEX_3= RULE_HEX
                    {
                    this_HEX_3=(Token)match(input,RULE_HEX,FOLLOW_2); 

                    		current.merge(this_HEX_3);
                        
                     
                        newLeafNode(this_HEX_3, grammarAccess.getIntegerAccess().getHEXTerminalRuleCall_1()); 
                        

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


    // $ANTLR start "entryRuleReal"
    // InternalConfig.g:2415:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalConfig.g:2416:2: (iv_ruleReal= ruleReal EOF )
            // InternalConfig.g:2417:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2424:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalConfig.g:2427:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalConfig.g:2428:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalConfig.g:2428:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt41=2;
            switch ( input.LA(1) ) {
            case 54:
                {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==RULE_INT) ) {
                    int LA41_3 = input.LA(3);

                    if ( (LA41_3==37) ) {
                        int LA41_4 = input.LA(4);

                        if ( (LA41_4==RULE_INT) ) {
                            int LA41_5 = input.LA(5);

                            if ( (LA41_5==EOF||(LA41_5>=13 && LA41_5<=14)||(LA41_5>=29 && LA41_5<=30)||LA41_5==33||LA41_5==36) ) {
                                alt41=1;
                            }
                            else if ( ((LA41_5>=56 && LA41_5<=57)) ) {
                                alt41=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 41, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==RULE_INT) ) {
                    int LA41_3 = input.LA(3);

                    if ( (LA41_3==37) ) {
                        int LA41_4 = input.LA(4);

                        if ( (LA41_4==RULE_INT) ) {
                            int LA41_5 = input.LA(5);

                            if ( (LA41_5==EOF||(LA41_5>=13 && LA41_5<=14)||(LA41_5>=29 && LA41_5<=30)||LA41_5==33||LA41_5==36) ) {
                                alt41=1;
                            }
                            else if ( ((LA41_5>=56 && LA41_5<=57)) ) {
                                alt41=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 41, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA41_3 = input.LA(2);

                if ( (LA41_3==37) ) {
                    int LA41_4 = input.LA(3);

                    if ( (LA41_4==RULE_INT) ) {
                        int LA41_5 = input.LA(4);

                        if ( (LA41_5==EOF||(LA41_5>=13 && LA41_5<=14)||(LA41_5>=29 && LA41_5<=30)||LA41_5==33||LA41_5==36) ) {
                            alt41=1;
                        }
                        else if ( ((LA41_5>=56 && LA41_5<=57)) ) {
                            alt41=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalConfig.g:2429:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2441:5: this_DecimalExp_1= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DecimalExp_1=ruleDecimalExp();

                    state._fsp--;


                    		current.merge(this_DecimalExp_1);
                        
                     
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
    // InternalConfig.g:2459:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalConfig.g:2463:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalConfig.g:2464:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2474:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalConfig.g:2478:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalConfig.g:2479:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalConfig.g:2479:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalConfig.g:2479:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalConfig.g:2479:2: (kw= '+' | kw= '-' )?
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                alt42=1;
            }
            else if ( (LA42_0==55) ) {
                alt42=2;
            }
            switch (alt42) {
                case 1 :
                    // InternalConfig.g:2480:2: kw= '+'
                    {
                    kw=(Token)match(input,54,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2487:2: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_29); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,37,FOLLOW_14); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); 

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


    // $ANTLR start "entryRuleDecimalExp"
    // InternalConfig.g:2523:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalConfig.g:2527:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalConfig.g:2528:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2538:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalConfig.g:2542:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalConfig.g:2543:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalConfig.g:2543:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalConfig.g:2543:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalConfig.g:2543:2: (kw= '+' | kw= '-' )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==54) ) {
                alt43=1;
            }
            else if ( (LA43_0==55) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // InternalConfig.g:2544:2: kw= '+'
                    {
                    kw=(Token)match(input,54,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2551:2: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_29); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,37,FOLLOW_14); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_45); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalConfig.g:2576:1: (kw= 'e' | kw= 'E' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==56) ) {
                alt44=1;
            }
            else if ( (LA44_0==57) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalConfig.g:2577:2: kw= 'e'
                    {
                    kw=(Token)match(input,56,FOLLOW_46); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2584:2: kw= 'E'
                    {
                    kw=(Token)match(input,57,FOLLOW_46); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalConfig.g:2589:2: (kw= '+' | kw= '-' )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==54) ) {
                alt45=1;
            }
            else if ( (LA45_0==55) ) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // InternalConfig.g:2590:2: kw= '+'
                    {
                    kw=(Token)match(input,54,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalConfig.g:2597:2: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_14); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_5_1()); 
                        

                    }
                    break;

            }

            this_INT_9=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_9);
                
             
                newLeafNode(this_INT_9, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_6()); 
                

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
    // InternalConfig.g:2620:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalConfig.g:2621:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalConfig.g:2622:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalConfig.g:2629:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalConfig.g:2632:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalConfig.g:2633:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalConfig.g:2633:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalConfig.g:2633:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalConfig.g:2640:1: (kw= '.' this_ID_2= RULE_ID )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==37) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalConfig.g:2641:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_47); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalConfig.g:2661:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalConfig.g:2663:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalConfig.g:2664:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalConfig.g:2664:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt47=1;
                }
                break;
            case 59:
                {
                alt47=2;
                }
                break;
            case 60:
                {
                alt47=3;
                }
                break;
            case 61:
                {
                alt47=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalConfig.g:2664:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalConfig.g:2664:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalConfig.g:2664:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalConfig.g:2670:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalConfig.g:2670:6: (enumLiteral_1= 'ptInteger' )
                    // InternalConfig.g:2670:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalConfig.g:2676:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalConfig.g:2676:6: (enumLiteral_2= 'ptReal' )
                    // InternalConfig.g:2676:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalConfig.g:2682:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalConfig.g:2682:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalConfig.g:2682:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); 

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000040001C0C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001C0C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000002C4000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000060004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000E004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080002002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00F00000000000F0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000340004000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00C00000000000C0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000240004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040024000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00F00000000000E0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000004000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000800000000020L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x00C0000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000002000000002L});

}
