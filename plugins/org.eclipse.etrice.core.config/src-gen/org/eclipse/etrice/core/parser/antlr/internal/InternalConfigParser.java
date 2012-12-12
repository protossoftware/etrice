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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ConfigModel'", "'{'", "'}'", "'SubSystemConfig'", "'/'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling timer [ms]'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'read'", "'write'", "'import'", "'from'", "'model'", "'.*'", "'.'", "','", "'false'", "'true'", "'+'", "'-'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_EXP=8;
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_HEX=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:76:1: ruleConfigModel returns [EObject current=null] : (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:79:28: ( (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: (otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:3: otherlv_0= 'ConfigModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_configElements_4_0= ruleConfigElement ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleConfigModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getConfigModelAccess().getConfigModelKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:84:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:85:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:85:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:86:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getConfigModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleConfigModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConfigModel155); 

                	newLeafNode(otherlv_2, grammarAccess.getConfigModelAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:106:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==36) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:107:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:107:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:108:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleConfigModel176);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:124:3: ( (lv_configElements_4_0= ruleConfigElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16||(LA2_0>=23 && LA2_0<=25)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:125:1: (lv_configElements_4_0= ruleConfigElement )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:125:1: (lv_configElements_4_0= ruleConfigElement )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:126:3: lv_configElements_4_0= ruleConfigElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConfigElement_in_ruleConfigModel198);
            	    lv_configElements_4_0=ruleConfigElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configElements",
            	            		lv_configElements_4_0, 
            	            		"ConfigElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleConfigModel211); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:154:1: entryRuleConfigElement returns [EObject current=null] : iv_ruleConfigElement= ruleConfigElement EOF ;
    public final EObject entryRuleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigElement = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:155:2: (iv_ruleConfigElement= ruleConfigElement EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:156:2: iv_ruleConfigElement= ruleConfigElement EOF
            {
             newCompositeNode(grammarAccess.getConfigElementRule()); 
            pushFollow(FOLLOW_ruleConfigElement_in_entryRuleConfigElement247);
            iv_ruleConfigElement=ruleConfigElement();

            state._fsp--;

             current =iv_ruleConfigElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigElement257); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:163:1: ruleConfigElement returns [EObject current=null] : (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) ;
    public final EObject ruleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_SubSystemConfig_0 = null;

        EObject this_ActorClassConfig_1 = null;

        EObject this_ActorInstanceConfig_2 = null;

        EObject this_ProtocolClassConfig_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:166:28: ( (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:167:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:167:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 23:
                {
                alt3=2;
                }
                break;
            case 24:
                {
                alt3=3;
                }
                break;
            case 25:
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
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:168:5: this_SubSystemConfig_0= ruleSubSystemConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSubSystemConfig_in_ruleConfigElement304);
                    this_SubSystemConfig_0=ruleSubSystemConfig();

                    state._fsp--;

                     
                            current = this_SubSystemConfig_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:178:5: this_ActorClassConfig_1= ruleActorClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleActorClassConfig_in_ruleConfigElement331);
                    this_ActorClassConfig_1=ruleActorClassConfig();

                    state._fsp--;

                     
                            current = this_ActorClassConfig_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:188:5: this_ActorInstanceConfig_2= ruleActorInstanceConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleActorInstanceConfig_in_ruleConfigElement358);
                    this_ActorInstanceConfig_2=ruleActorInstanceConfig();

                    state._fsp--;

                     
                            current = this_ActorInstanceConfig_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:198:5: this_ProtocolClassConfig_3= ruleProtocolClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleProtocolClassConfig_in_ruleConfigElement385);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:214:1: entryRuleSubSystemConfig returns [EObject current=null] : iv_ruleSubSystemConfig= ruleSubSystemConfig EOF ;
    public final EObject entryRuleSubSystemConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:215:2: (iv_ruleSubSystemConfig= ruleSubSystemConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:216:2: iv_ruleSubSystemConfig= ruleSubSystemConfig EOF
            {
             newCompositeNode(grammarAccess.getSubSystemConfigRule()); 
            pushFollow(FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig420);
            iv_ruleSubSystemConfig=ruleSubSystemConfig();

            state._fsp--;

             current =iv_ruleSubSystemConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemConfig430); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:223:1: ruleSubSystemConfig returns [EObject current=null] : (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:226:28: ( (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:227:1: (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:227:1: (otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:227:3: otherlv_0= 'SubSystemConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '{' ( (lv_dynConfig_5_0= ruleDynamicConfig ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleSubSystemConfig467); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:231:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:232:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:232:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:233:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemConfig490);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleSubSystemConfig502); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemConfigAccess().getSolidusKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:250:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:251:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:251:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:252:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemConfigRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemConfig522); 

            		newLeafNode(otherlv_3, grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleSubSystemConfig534); 

                	newLeafNode(otherlv_4, grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:267:1: ( (lv_dynConfig_5_0= ruleDynamicConfig ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:268:1: (lv_dynConfig_5_0= ruleDynamicConfig )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:268:1: (lv_dynConfig_5_0= ruleDynamicConfig )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:269:3: lv_dynConfig_5_0= ruleDynamicConfig
            {
             
            	        newCompositeNode(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDynamicConfig_in_ruleSubSystemConfig555);
            lv_dynConfig_5_0=ruleDynamicConfig();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubSystemConfigRule());
            	        }
                   		set(
                   			current, 
                   			"dynConfig",
                    		lv_dynConfig_5_0, 
                    		"DynamicConfig");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleSubSystemConfig567); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:297:1: entryRuleDynamicConfig returns [EObject current=null] : iv_ruleDynamicConfig= ruleDynamicConfig EOF ;
    public final EObject entryRuleDynamicConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDynamicConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:298:2: (iv_ruleDynamicConfig= ruleDynamicConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:299:2: iv_ruleDynamicConfig= ruleDynamicConfig EOF
            {
             newCompositeNode(grammarAccess.getDynamicConfigRule()); 
            pushFollow(FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig603);
            iv_ruleDynamicConfig=ruleDynamicConfig();

            state._fsp--;

             current =iv_ruleDynamicConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDynamicConfig613); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:1: ruleDynamicConfig returns [EObject current=null] : (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) ;
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
        Token lv_polling_10_0=null;
        Token otherlv_11=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:309:28: ( (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:310:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:310:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:310:3: otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleDynamicConfig650); 

                	newLeafNode(otherlv_0, grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleDynamicConfig662); 

                	newLeafNode(otherlv_1, grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:318:1: ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:320:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:320:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:321:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:324:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:325:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:325:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( LA5_0 >=19 && LA5_0<=20 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:327:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:327:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:328:5: {...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:328:110: ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:329:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:7: {...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:16: ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==19) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==20) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:19: otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) )
            	            {
            	            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleDynamicConfig721); 

            	                	newLeafNode(otherlv_3, grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:336:1: ( (lv_filePath_4_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:337:1: (lv_filePath_4_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:337:1: (lv_filePath_4_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:338:3: lv_filePath_4_0= RULE_STRING
            	            {
            	            lv_filePath_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig738); 

            	            			newLeafNode(lv_filePath_4_0, grammarAccess.getDynamicConfigAccess().getFilePathSTRINGTerminalRuleCall_2_0_0_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"filePath",
            	                    		lv_filePath_4_0, 
            	                    		"STRING");
            	            	    

            	            }


            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:355:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:355:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:355:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:355:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:355:9: otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) )
            	            {
            	            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleDynamicConfig764); 

            	                	newLeafNode(otherlv_5, grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:359:1: ( (lv_userCode1_6_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:360:1: (lv_userCode1_6_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:360:1: (lv_userCode1_6_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:361:3: lv_userCode1_6_0= RULE_STRING
            	            {
            	            lv_userCode1_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig781); 

            	            			newLeafNode(lv_userCode1_6_0, grammarAccess.getDynamicConfigAccess().getUserCode1STRINGTerminalRuleCall_2_0_1_0_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"userCode1",
            	                    		lv_userCode1_6_0, 
            	                    		"STRING");
            	            	    

            	            }


            	            }


            	            }

            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:377:3: (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:377:5: otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) )
            	            {
            	            otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleDynamicConfig800); 

            	                	newLeafNode(otherlv_7, grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:381:1: ( (lv_userCode2_8_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:382:1: (lv_userCode2_8_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:382:1: (lv_userCode2_8_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:383:3: lv_userCode2_8_0= RULE_STRING
            	            {
            	            lv_userCode2_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig817); 

            	            			newLeafNode(lv_userCode2_8_0, grammarAccess.getDynamicConfigAccess().getUserCode2STRINGTerminalRuleCall_2_0_1_1_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"userCode2",
            	                    		lv_userCode2_8_0, 
            	                    		"STRING");
            	            	    

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
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:406:4: ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:406:4: ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:407:5: {...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:407:110: ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:408:6: ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:411:6: ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:411:7: {...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:411:16: (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:411:18: otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) )
            	    {
            	    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleDynamicConfig892); 

            	        	newLeafNode(otherlv_9, grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:415:1: ( (lv_polling_10_0= RULE_INT ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:416:1: (lv_polling_10_0= RULE_INT )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:416:1: (lv_polling_10_0= RULE_INT )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:417:3: lv_polling_10_0= RULE_INT
            	    {
            	    lv_polling_10_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDynamicConfig909); 

            	    			newLeafNode(lv_polling_10_0, grammarAccess.getDynamicConfigAccess().getPollingINTTerminalRuleCall_2_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDynamicConfigRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"polling",
            	            		lv_polling_10_0, 
            	            		"INT");
            	    	    

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

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleDynamicConfig973); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:460:1: entryRuleActorClassConfig returns [EObject current=null] : iv_ruleActorClassConfig= ruleActorClassConfig EOF ;
    public final EObject entryRuleActorClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:461:2: (iv_ruleActorClassConfig= ruleActorClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:462:2: iv_ruleActorClassConfig= ruleActorClassConfig EOF
            {
             newCompositeNode(grammarAccess.getActorClassConfigRule()); 
            pushFollow(FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig1009);
            iv_ruleActorClassConfig=ruleActorClassConfig();

            state._fsp--;

             current =iv_ruleActorClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClassConfig1019); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:469:1: ruleActorClassConfig returns [EObject current=null] : (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject ruleActorClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:472:28: ( (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:473:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:473:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:473:3: otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleActorClassConfig1056); 

                	newLeafNode(otherlv_0, grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:477:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:478:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:478:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:479:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorClassConfig1079);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleActorClassConfig1091); 

                	newLeafNode(otherlv_2, grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:496:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==30) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:497:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:497:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:498:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrClassConfig_in_ruleActorClassConfig1112);
            	    lv_attributes_3_0=ruleAttrClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"AttrClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleActorClassConfig1125); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:526:1: entryRuleActorInstanceConfig returns [EObject current=null] : iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF ;
    public final EObject entryRuleActorInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:527:2: (iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:528:2: iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig1161);
            iv_ruleActorInstanceConfig=ruleActorInstanceConfig();

            state._fsp--;

             current =iv_ruleActorInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceConfig1171); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:535:1: ruleActorInstanceConfig returns [EObject current=null] : (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:538:28: ( (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:539:1: (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:539:1: (otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:539:3: otherlv_0= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_2= '/' ( (otherlv_3= RULE_ID ) ) otherlv_4= '/' ( (lv_path_5_0= ruleRefPath ) ) otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleActorInstanceConfig1208); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:543:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:544:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:544:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:545:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getRootLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorInstanceConfig1231);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleActorInstanceConfig1243); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:562:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:563:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:563:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:564:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceConfigRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstanceConfig1263); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceConfigAccess().getSubSystemSubSystemRefCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleActorInstanceConfig1275); 

                	newLeafNode(otherlv_4, grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_4());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:1: ( (lv_path_5_0= ruleRefPath ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:580:1: (lv_path_5_0= ruleRefPath )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:580:1: (lv_path_5_0= ruleRefPath )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:581:3: lv_path_5_0= ruleRefPath
            {
             
            	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleRefPath_in_ruleActorInstanceConfig1296);
            lv_path_5_0=ruleRefPath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_5_0, 
                    		"RefPath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleActorInstanceConfig1308); 

                	newLeafNode(otherlv_6, grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_6());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:601:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:603:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:603:1: ( ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:604:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:607:2: ( ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:608:3: ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:608:3: ( ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( LA9_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
                    alt9=1;
                }
                else if ( LA9_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:610:4: ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:610:4: ({...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:611:5: {...}? => ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:611:116: ( ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+ )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:612:6: ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:615:6: ({...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) ) )+
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
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:615:7: {...}? => ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    	    }
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:615:16: ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:616:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
            	    	    {
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:616:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:617:3: lv_attributes_8_0= ruleAttrInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_7_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_ruleActorInstanceConfig1374);
            	    	    lv_attributes_8_0=ruleAttrInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"attributes",
            	    	            		lv_attributes_8_0, 
            	    	            		"AttrInstanceConfig");
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
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:640:4: ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:640:4: ({...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:641:5: {...}? => ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:641:116: ( ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+ )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:642:6: ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:645:6: ({...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) ) )+
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
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:645:7: {...}? => ( (lv_ports_9_0= rulePortInstanceConfig ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    	    }
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:645:16: ( (lv_ports_9_0= rulePortInstanceConfig ) )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:646:1: (lv_ports_9_0= rulePortInstanceConfig )
            	    	    {
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:646:1: (lv_ports_9_0= rulePortInstanceConfig )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:647:3: lv_ports_9_0= rulePortInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_7_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_rulePortInstanceConfig_in_ruleActorInstanceConfig1450);
            	    	    lv_ports_9_0=rulePortInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"ports",
            	    	            		lv_ports_9_0, 
            	    	            		"PortInstanceConfig");
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

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleActorInstanceConfig1503); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:689:1: entryRuleProtocolClassConfig returns [EObject current=null] : iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF ;
    public final EObject entryRuleProtocolClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:690:2: (iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:691:2: iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassConfigRule()); 
            pushFollow(FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig1539);
            iv_ruleProtocolClassConfig=ruleProtocolClassConfig();

            state._fsp--;

             current =iv_ruleProtocolClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClassConfig1549); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:698:1: ruleProtocolClassConfig returns [EObject current=null] : (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' ) ;
    public final EObject ruleProtocolClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_regular_5_0 = null;

        EObject lv_conjugated_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:701:28: ( (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:702:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:702:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:702:3: otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleProtocolClassConfig1586); 

                	newLeafNode(otherlv_0, grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:706:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:707:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:707:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:708:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClassConfig1609);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClassConfig1621); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:725:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:727:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:727:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:728:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:731:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:732:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:732:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( LA10_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:734:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:734:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:735:5: {...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:735:116: ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:736:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:739:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:739:7: {...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:739:16: (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:739:18: otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleProtocolClassConfig1679); 

            	        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:743:1: ( (lv_regular_5_0= rulePortClassConfig ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:744:1: (lv_regular_5_0= rulePortClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:744:1: (lv_regular_5_0= rulePortClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:745:3: lv_regular_5_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1700);
            	    lv_regular_5_0=rulePortClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"regular",
            	            		lv_regular_5_0, 
            	            		"PortClassConfig");
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
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:768:4: ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:768:4: ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:5: {...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:116: ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:770:6: ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:773:6: ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:773:7: {...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:773:16: (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:773:18: otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) )
            	    {
            	    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleProtocolClassConfig1768); 

            	        	newLeafNode(otherlv_6, grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:777:1: ( (lv_conjugated_7_0= rulePortClassConfig ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:778:1: (lv_conjugated_7_0= rulePortClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:778:1: (lv_conjugated_7_0= rulePortClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:779:3: lv_conjugated_7_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1789);
            	    lv_conjugated_7_0=rulePortClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"conjugated",
            	            		lv_conjugated_7_0, 
            	            		"PortClassConfig");
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
            	    break loop10;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	

            }

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleProtocolClassConfig1842); 

                	newLeafNode(otherlv_8, grammarAccess.getProtocolClassConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:821:1: entryRulePortClassConfig returns [EObject current=null] : iv_rulePortClassConfig= rulePortClassConfig EOF ;
    public final EObject entryRulePortClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:822:2: (iv_rulePortClassConfig= rulePortClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:823:2: iv_rulePortClassConfig= rulePortClassConfig EOF
            {
             newCompositeNode(grammarAccess.getPortClassConfigRule()); 
            pushFollow(FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig1878);
            iv_rulePortClassConfig=rulePortClassConfig();

            state._fsp--;

             current =iv_rulePortClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClassConfig1888); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:830:1: rulePortClassConfig returns [EObject current=null] : ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:833:28: ( ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:834:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:834:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:834:2: () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:834:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:835:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_rulePortClassConfig1934); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassConfigAccess().getPortKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePortClassConfig1946); 

                	newLeafNode(otherlv_2, grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:848:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==30) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:849:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:849:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:850:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrClassConfig_in_rulePortClassConfig1967);
            	    lv_attributes_3_0=ruleAttrClassConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"AttrClassConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePortClassConfig1980); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:878:1: entryRulePortInstanceConfig returns [EObject current=null] : iv_rulePortInstanceConfig= rulePortInstanceConfig EOF ;
    public final EObject entryRulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:879:2: (iv_rulePortInstanceConfig= rulePortInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:880:2: iv_rulePortInstanceConfig= rulePortInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getPortInstanceConfigRule()); 
            pushFollow(FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig2016);
            iv_rulePortInstanceConfig=rulePortInstanceConfig();

            state._fsp--;

             current =iv_rulePortInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortInstanceConfig2026); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:887:1: rulePortInstanceConfig returns [EObject current=null] : (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:890:28: ( (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:891:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:891:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:891:3: otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_rulePortInstanceConfig2063); 

                	newLeafNode(otherlv_0, grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:895:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:896:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:896:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:897:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortInstanceConfig2083); 

            		newLeafNode(otherlv_1, grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePortInstanceConfig2095); 

                	newLeafNode(otherlv_2, grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:912:1: ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:913:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:913:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:914:3: lv_attributes_3_0= ruleAttrInstanceConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rulePortInstanceConfig2116);
            	    lv_attributes_3_0=ruleAttrInstanceConfig();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortInstanceConfigRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"AttrInstanceConfig");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePortInstanceConfig2129); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:944:1: entryRuleAttrClassConfig returns [EObject current=null] : iv_ruleAttrClassConfig= ruleAttrClassConfig EOF ;
    public final EObject entryRuleAttrClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:945:2: (iv_ruleAttrClassConfig= ruleAttrClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:946:2: iv_ruleAttrClassConfig= ruleAttrClassConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrClassConfigRule()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig2167);
            iv_ruleAttrClassConfig=ruleAttrClassConfig();

            state._fsp--;

             current =iv_ruleAttrClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrClassConfig2177); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:953:1: ruleAttrClassConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:956:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:957:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:957:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:957:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleAttrClassConfig2214); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:961:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:962:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:962:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:963:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrClassConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttrClassConfig2234); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:974:2: (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:974:4: otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleAttrClassConfig2247); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:978:1: ( (lv_value_3_0= ruleLiteralArray ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:979:1: (lv_value_3_0= ruleLiteralArray )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:979:1: (lv_value_3_0= ruleLiteralArray )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:980:3: lv_value_3_0= ruleLiteralArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteralArray_in_ruleAttrClassConfig2268);
                    lv_value_3_0=ruleLiteralArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"LiteralArray");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:996:4: (otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:996:6: otherlv_4= '{' ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAttrClassConfig2283); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1000:1: ( (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )* )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1000:2: (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )? (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )? ( (lv_attributes_11_0= ruleAttrClassConfig ) )*
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1000:2: (otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==32) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1000:4: otherlv_5= 'min' otherlv_6= '=' ( (lv_min_7_0= ruleNumberLiteral ) )
                            {
                            otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleAttrClassConfig2297); 

                                	newLeafNode(otherlv_5, grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0());
                                
                            otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleAttrClassConfig2309); 

                                	newLeafNode(otherlv_6, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1());
                                
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1008:1: ( (lv_min_7_0= ruleNumberLiteral ) )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1009:1: (lv_min_7_0= ruleNumberLiteral )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1009:1: (lv_min_7_0= ruleNumberLiteral )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1010:3: lv_min_7_0= ruleNumberLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2330);
                            lv_min_7_0=ruleNumberLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"NumberLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1026:4: (otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==33) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1026:6: otherlv_8= 'max' otherlv_9= '=' ( (lv_max_10_0= ruleNumberLiteral ) )
                            {
                            otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleAttrClassConfig2345); 

                                	newLeafNode(otherlv_8, grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0());
                                
                            otherlv_9=(Token)match(input,31,FOLLOW_31_in_ruleAttrClassConfig2357); 

                                	newLeafNode(otherlv_9, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1());
                                
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1034:1: ( (lv_max_10_0= ruleNumberLiteral ) )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1035:1: (lv_max_10_0= ruleNumberLiteral )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1035:1: (lv_max_10_0= ruleNumberLiteral )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1036:3: lv_max_10_0= ruleNumberLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2378);
                            lv_max_10_0=ruleNumberLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"max",
                                    		lv_max_10_0, 
                                    		"NumberLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1052:4: ( (lv_attributes_11_0= ruleAttrClassConfig ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1053:1: (lv_attributes_11_0= ruleAttrClassConfig )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1053:1: (lv_attributes_11_0= ruleAttrClassConfig )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1054:3: lv_attributes_11_0= ruleAttrClassConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttrClassConfig_in_ruleAttrClassConfig2401);
                    	    lv_attributes_11_0=ruleAttrClassConfig();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_11_0, 
                    	            		"AttrClassConfig");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }

                    otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleAttrClassConfig2415); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1082:1: entryRuleAttrInstanceConfig returns [EObject current=null] : iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF ;
    public final EObject entryRuleAttrInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1083:2: (iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1084:2: iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig2453);
            iv_ruleAttrInstanceConfig=ruleAttrInstanceConfig();

            state._fsp--;

             current =iv_ruleAttrInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrInstanceConfig2463); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1091:1: ruleAttrInstanceConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1094:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1095:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1095:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1095:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleAttrInstanceConfig2500); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1099:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1100:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1100:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1101:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttrInstanceConfig2520); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1112:2: (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1112:4: otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleAttrInstanceConfig2533); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1116:1: ( (lv_value_3_0= ruleLiteralArray ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1117:1: (lv_value_3_0= ruleLiteralArray )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1117:1: (lv_value_3_0= ruleLiteralArray )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1118:3: lv_value_3_0= ruleLiteralArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteralArray_in_ruleAttrInstanceConfig2554);
                    lv_value_3_0=ruleLiteralArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrInstanceConfigRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"LiteralArray");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1134:4: (otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==14) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1134:6: otherlv_4= '{' ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* ) otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAttrInstanceConfig2569); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1138:1: ( ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1138:2: ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )*
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1138:2: ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==18) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1138:3: ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1138:3: ( (lv_dynConfig_5_0= 'dynamic configuration' ) )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1139:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1139:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1140:3: lv_dynConfig_5_0= 'dynamic configuration'
                            {
                            lv_dynConfig_5_0=(Token)match(input,18,FOLLOW_18_in_ruleAttrInstanceConfig2589); 

                                    newLeafNode(lv_dynConfig_5_0, grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
                            	        }
                                   		setWithLastConsumed(current, "dynConfig", true, "dynamic configuration");
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1153:2: ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==34) ) {
                                alt19=1;
                            }
                            else if ( (LA19_0==35) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 0, input);

                                throw nvae;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1153:3: ( (lv_readOnly_6_0= 'read' ) )
                                    {
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1153:3: ( (lv_readOnly_6_0= 'read' ) )
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1154:1: (lv_readOnly_6_0= 'read' )
                                    {
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1154:1: (lv_readOnly_6_0= 'read' )
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1155:3: lv_readOnly_6_0= 'read'
                                    {
                                    lv_readOnly_6_0=(Token)match(input,34,FOLLOW_34_in_ruleAttrInstanceConfig2621); 

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
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1169:7: otherlv_7= 'write'
                                    {
                                    otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleAttrInstanceConfig2652); 

                                        	newLeafNode(otherlv_7, grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_0_1_1());
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1173:4: ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==30) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1174:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1174:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1175:3: lv_attributes_8_0= ruleAttrInstanceConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_ruleAttrInstanceConfig2676);
                    	    lv_attributes_8_0=ruleAttrInstanceConfig();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrInstanceConfigRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_8_0, 
                    	            		"AttrInstanceConfig");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }

                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleAttrInstanceConfig2690); 

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


    // $ANTLR start "entryRuleRefPath"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1203:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1204:2: (iv_ruleRefPath= ruleRefPath EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1205:2: iv_ruleRefPath= ruleRefPath EOF
            {
             newCompositeNode(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath2728);
            iv_ruleRefPath=ruleRefPath();

            state._fsp--;

             current =iv_ruleRefPath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath2738); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1212:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token lv_refs_0_0=null;
        Token otherlv_1=null;
        Token lv_refs_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1215:28: ( ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1216:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1216:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1216:2: ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1216:2: ( (lv_refs_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1217:1: (lv_refs_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1217:1: (lv_refs_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1218:3: lv_refs_0_0= RULE_ID
            {
            lv_refs_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath2780); 

            			newLeafNode(lv_refs_0_0, grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRefPathRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"refs",
                    		lv_refs_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1234:2: (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==17) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1234:4: otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRefPath2798); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1238:1: ( (lv_refs_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1239:1: (lv_refs_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1239:1: (lv_refs_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1240:3: lv_refs_2_0= RULE_ID
            	    {
            	    lv_refs_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath2815); 

            	    			newLeafNode(lv_refs_2_0, grammarAccess.getRefPathAccess().getRefsIDTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRefPathRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"refs",
            	            		lv_refs_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1264:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1265:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1266:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport2858);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport2868); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1273:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1276:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1277:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1277:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1277:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleImport2905); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1281:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==38) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1281:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1281:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1281:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1281:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1282:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1282:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1283:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport2928);
                    lv_importedNamespace_1_0=ruleImportedFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_1_0, 
                            		"ImportedFQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleImport2940); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1304:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleImport2959); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1308:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1309:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1309:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1310:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport2977); 

            			newLeafNode(lv_importURI_4_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_4_0, 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1334:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1335:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1336:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3019);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN3030); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1343:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1346:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1347:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1347:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1348:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN3077);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1358:1: (kw= '.*' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1359:2: kw= '.*'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleImportedFQN3096); 

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


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1372:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1373:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1374:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3139);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3150); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1381:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1384:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1385:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3190); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1392:1: (kw= '.' this_ID_2= RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1393:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,40,FOLLOW_40_in_ruleFQN3209); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3224); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1413:1: entryRuleLiteralArray returns [EObject current=null] : iv_ruleLiteralArray= ruleLiteralArray EOF ;
    public final EObject entryRuleLiteralArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralArray = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1414:2: (iv_ruleLiteralArray= ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1415:2: iv_ruleLiteralArray= ruleLiteralArray EOF
            {
             newCompositeNode(grammarAccess.getLiteralArrayRule()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray3271);
            iv_ruleLiteralArray=ruleLiteralArray();

            state._fsp--;

             current =iv_ruleLiteralArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray3281); 

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
    // $ANTLR end "entryRuleLiteralArray"


    // $ANTLR start "ruleLiteralArray"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1422:1: ruleLiteralArray returns [EObject current=null] : ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) ;
    public final EObject ruleLiteralArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_literals_0_0 = null;

        EObject lv_literals_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1425:28: ( ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1426:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1426:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1426:2: ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1426:2: ( (lv_literals_0_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1427:1: (lv_literals_0_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1427:1: (lv_literals_0_0= ruleLiteral )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1428:3: lv_literals_0_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray3327);
            lv_literals_0_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
            	        }
                   		add(
                   			current, 
                   			"literals",
                    		lv_literals_0_0, 
                    		"Literal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1444:2: (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1444:4: otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) )
            	    {
            	    otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleLiteralArray3340); 

            	        	newLeafNode(otherlv_1, grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1448:1: ( (lv_literals_2_0= ruleLiteral ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1449:1: (lv_literals_2_0= ruleLiteral )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1449:1: (lv_literals_2_0= ruleLiteral )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1450:3: lv_literals_2_0= ruleLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray3361);
            	    lv_literals_2_0=ruleLiteral();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLiteralArrayRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"literals",
            	            		lv_literals_2_0, 
            	            		"Literal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end "ruleLiteralArray"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1474:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1475:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1476:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3399);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3409); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1483:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1486:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1487:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1487:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 42:
            case 43:
                {
                alt28=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 40:
            case 44:
            case 45:
                {
                alt28=2;
                }
                break;
            case RULE_STRING:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1488:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral3456);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1498:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3483);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1508:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral3510);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1524:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1525:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1526:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3545);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral3555); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1533:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1536:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1537:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1537:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1537:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1537:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1538:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1543:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==42) ) {
                alt29=1;
            }
            else if ( (LA29_0==43) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1543:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleBooleanLiteral3602); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1548:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1548:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1549:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1549:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1550:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,43,FOLLOW_43_in_ruleBooleanLiteral3626); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1571:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1572:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1573:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3676);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral3686); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1580:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1583:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1584:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1584:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt30=2;
            switch ( input.LA(1) ) {
            case 44:
                {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==RULE_INT) ) {
                    int LA30_3 = input.LA(3);

                    if ( (LA30_3==40) ) {
                        alt30=2;
                    }
                    else if ( (LA30_3==EOF||(LA30_3>=14 && LA30_3<=15)||(LA30_3>=29 && LA30_3<=30)||LA30_3==33||LA30_3==41) ) {
                        alt30=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA30_1==40) ) {
                    alt30=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
                }
                break;
            case 45:
                {
                int LA30_2 = input.LA(2);

                if ( (LA30_2==RULE_INT) ) {
                    int LA30_3 = input.LA(3);

                    if ( (LA30_3==40) ) {
                        alt30=2;
                    }
                    else if ( (LA30_3==EOF||(LA30_3>=14 && LA30_3<=15)||(LA30_3>=29 && LA30_3<=30)||LA30_3==33||LA30_3==41) ) {
                        alt30=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA30_2==40) ) {
                    alt30=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA30_3 = input.LA(2);

                if ( (LA30_3==40) ) {
                    alt30=2;
                }
                else if ( (LA30_3==EOF||(LA30_3>=14 && LA30_3<=15)||(LA30_3>=29 && LA30_3<=30)||LA30_3==33||LA30_3==41) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt30=1;
                }
                break;
            case 40:
                {
                alt30=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1585:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral3733);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1595:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral3760);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1611:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1612:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1613:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3795);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral3805); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1620:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1623:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1624:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1624:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1624:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1624:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1625:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1630:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1631:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1631:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1632:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral3860);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1656:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1657:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1658:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3896);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral3906); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1665:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1668:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1669:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1669:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1669:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1669:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1670:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1675:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1676:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1676:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1677:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral3961);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1701:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1702:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1703:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3997);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral4007); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1710:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1713:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1714:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1714:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1714:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1714:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1715:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1720:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1721:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1721:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1722:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral4058); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1746:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1747:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1748:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger4100);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger4111); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1755:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1758:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1759:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1759:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT||(LA31_0>=44 && LA31_0<=45)) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_HEX) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1760:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger4158);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1772:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger4191);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1790:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1794:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1795:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4243);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger4254); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1805:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1809:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1810:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1810:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1810:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1810:2: (kw= '+' | kw= '-' )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==44) ) {
                alt32=1;
            }
            else if ( (LA32_0==45) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1811:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleSignedInteger4297); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1818:2: kw= '-'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleSignedInteger4316); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger4333); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1841:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1845:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1846:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4389);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal4400); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1856:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1860:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1861:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal4443); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1879:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1880:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1881:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal4492);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal4503); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1888:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1891:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1892:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1892:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt33=4;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1893:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal4550);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1905:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal4583);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1917:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal4616);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1929:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal4649);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1947:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1951:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1952:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal4701);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal4712); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1962:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1966:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1967:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1967:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1967:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1967:2: (kw= '+' | kw= '-' )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==44) ) {
                alt34=1;
            }
            else if ( (LA34_0==45) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1968:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimal4755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1975:2: kw= '-'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleDecimal4774); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal4791); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,40,FOLLOW_40_in_ruleDecimal4809); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal4824); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2011:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2015:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2016:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal4880);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal4891); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2026:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2030:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2031:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2031:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2031:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2031:2: (kw= '+' | kw= '-' )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==44) ) {
                alt35=1;
            }
            else if ( (LA35_0==45) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2032:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDotDecimal4934); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2039:2: kw= '-'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleDotDecimal4953); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,40,FOLLOW_40_in_ruleDotDecimal4968); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal4983); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2068:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2072:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2073:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5039);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot5050); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2083:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2087:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2088:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2088:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2088:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2088:2: (kw= '+' | kw= '-' )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==44) ) {
                alt36=1;
            }
            else if ( (LA36_0==45) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2089:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimalDot5093); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2096:2: kw= '-'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleDecimalDot5112); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot5129); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,40,FOLLOW_40_in_ruleDecimalDot5147); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2125:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2129:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2130:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5198);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp5209); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2140:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2144:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2145:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2145:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2145:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2145:2: (kw= '+' | kw= '-' )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            else if ( (LA37_0==45) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2146:2: kw= '+'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimalExp5252); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2153:2: kw= '-'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleDecimalExp5271); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5288); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,40,FOLLOW_40_in_ruleDecimalExp5306); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5321); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp5341); 

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

    // Delegated rules


    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\5\uffff\1\7\1\10\3\uffff";
    static final String DFA33_minS =
        "\3\6\1\50\1\uffff\1\6\1\10\3\uffff";
    static final String DFA33_maxS =
        "\1\55\3\50\1\uffff\2\51\3\uffff";
    static final String DFA33_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\1\1\4";
    static final String DFA33_specialS =
        "\12\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\3\41\uffff\1\4\3\uffff\1\1\1\2",
            "\1\3\41\uffff\1\4",
            "\1\3\41\uffff\1\4",
            "\1\5",
            "",
            "\1\6\7\uffff\2\7\15\uffff\2\7\2\uffff\1\7\7\uffff\1\7",
            "\1\11\5\uffff\2\10\15\uffff\2\10\2\uffff\1\10\7\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1892:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleConfigModel_in_entryRuleConfigModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleConfigModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleConfigModel143 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConfigModel155 = new BitSet(new long[]{0x0000001003818000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleConfigModel176 = new BitSet(new long[]{0x0000001003818000L});
    public static final BitSet FOLLOW_ruleConfigElement_in_ruleConfigModel198 = new BitSet(new long[]{0x0000000003818000L});
    public static final BitSet FOLLOW_15_in_ruleConfigModel211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_entryRuleConfigElement247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigElement257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_ruleConfigElement304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_ruleConfigElement331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_ruleConfigElement358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_ruleConfigElement385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemConfig430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSubSystemConfig467 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemConfig490 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubSystemConfig502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemConfig522 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemConfig534 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_ruleSubSystemConfig555 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubSystemConfig567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDynamicConfig613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDynamicConfig650 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDynamicConfig662 = new BitSet(new long[]{0x0000000000580000L});
    public static final BitSet FOLLOW_19_in_ruleDynamicConfig721 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig738 = new BitSet(new long[]{0x0000000000588000L});
    public static final BitSet FOLLOW_20_in_ruleDynamicConfig764 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig781 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDynamicConfig800 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig817 = new BitSet(new long[]{0x0000000000588000L});
    public static final BitSet FOLLOW_22_in_ruleDynamicConfig892 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDynamicConfig909 = new BitSet(new long[]{0x0000000000588000L});
    public static final BitSet FOLLOW_15_in_ruleDynamicConfig973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig1009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClassConfig1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleActorClassConfig1056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClassConfig1079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClassConfig1091 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_ruleActorClassConfig1112 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_15_in_ruleActorClassConfig1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig1161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceConfig1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleActorInstanceConfig1208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorInstanceConfig1231 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleActorInstanceConfig1243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstanceConfig1263 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleActorInstanceConfig1275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefPath_in_ruleActorInstanceConfig1296 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorInstanceConfig1308 = new BitSet(new long[]{0x0000000060008000L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_ruleActorInstanceConfig1374 = new BitSet(new long[]{0x0000000060008000L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_ruleActorInstanceConfig1450 = new BitSet(new long[]{0x0000000060008000L});
    public static final BitSet FOLLOW_15_in_ruleActorInstanceConfig1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig1539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClassConfig1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClassConfig1586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClassConfig1609 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClassConfig1621 = new BitSet(new long[]{0x000000000C008000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClassConfig1679 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1700 = new BitSet(new long[]{0x000000000C008000L});
    public static final BitSet FOLLOW_27_in_ruleProtocolClassConfig1768 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1789 = new BitSet(new long[]{0x000000000C008000L});
    public static final BitSet FOLLOW_15_in_ruleProtocolClassConfig1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig1878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClassConfig1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePortClassConfig1934 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePortClassConfig1946 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rulePortClassConfig1967 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_15_in_rulePortClassConfig1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig2016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortInstanceConfig2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePortInstanceConfig2063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortInstanceConfig2083 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePortInstanceConfig2095 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rulePortInstanceConfig2116 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_15_in_rulePortInstanceConfig2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig2167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrClassConfig2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAttrClassConfig2214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttrClassConfig2234 = new BitSet(new long[]{0x0000000080004002L});
    public static final BitSet FOLLOW_31_in_ruleAttrClassConfig2247 = new BitSet(new long[]{0x00003D00000000E0L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_ruleAttrClassConfig2268 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAttrClassConfig2283 = new BitSet(new long[]{0x0000000340008000L});
    public static final BitSet FOLLOW_32_in_ruleAttrClassConfig2297 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAttrClassConfig2309 = new BitSet(new long[]{0x00003100000000C0L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2330 = new BitSet(new long[]{0x0000000240008000L});
    public static final BitSet FOLLOW_33_in_ruleAttrClassConfig2345 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAttrClassConfig2357 = new BitSet(new long[]{0x00003100000000C0L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2378 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_ruleAttrClassConfig2401 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrClassConfig2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig2453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrInstanceConfig2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAttrInstanceConfig2500 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttrInstanceConfig2520 = new BitSet(new long[]{0x0000000080004002L});
    public static final BitSet FOLLOW_31_in_ruleAttrInstanceConfig2533 = new BitSet(new long[]{0x00003D00000000E0L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_ruleAttrInstanceConfig2554 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAttrInstanceConfig2569 = new BitSet(new long[]{0x0000000040048000L});
    public static final BitSet FOLLOW_18_in_ruleAttrInstanceConfig2589 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleAttrInstanceConfig2621 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_35_in_ruleAttrInstanceConfig2652 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_ruleAttrInstanceConfig2676 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrInstanceConfig2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_entryRuleRefPath2728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefPath2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath2780 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleRefPath2798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath2815 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleImport2905 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport2928 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleImport2940 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_38_in_ruleImport2959 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN3077 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleImportedFQN3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3190 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleFQN3209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3224 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray3271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralArray3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray3327 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleLiteralArray3340 = new BitSet(new long[]{0x00003D00000000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray3361 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleBooleanLiteral3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBooleanLiteral3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral3733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger4100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleSignedInteger4297 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_45_in_ruleSignedInteger4316 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger4333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal4492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal4616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal4701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal4712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDecimal4755 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_45_in_ruleDecimal4774 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal4791 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDecimal4809 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal4880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal4891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDotDecimal4934 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_45_in_ruleDotDecimal4953 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDotDecimal4968 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot5050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDecimalDot5093 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_45_in_ruleDecimalDot5112 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot5129 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDecimalDot5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDecimalExp5252 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_45_in_ruleDecimalExp5271 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5288 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDecimalExp5306 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5321 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp5341 = new BitSet(new long[]{0x0000000000000002L});

}
