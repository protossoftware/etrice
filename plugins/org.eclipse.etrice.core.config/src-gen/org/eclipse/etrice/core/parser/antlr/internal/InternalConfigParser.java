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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SubSystemConfig'", "'{'", "'}'", "'dynamic configuration'", "'file path'", "'user import'", "'user constructor'", "'polling timer [ms]'", "'ActorClassConfig'", "'ActorInstanceConfig'", "'/'", "'ProtocolClassConfig'", "'regular'", "'conjugate'", "'Port'", "'InterfaceItem'", "'Attr'", "'='", "'min'", "'max'", "'read'", "'write'", "'import'", "'from'", "'model'", "'.*'", "'.'", "','", "'false'", "'true'", "'+'", "'-'"
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:76:1: ruleConfigModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleConfigElement ) )* ) ;
    public final EObject ruleConfigModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_configElements_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:79:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleConfigElement ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleConfigElement ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleConfigElement ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleConfigElement ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:80:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:81:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:81:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:82:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleConfigModel131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:98:3: ( (lv_configElements_1_0= ruleConfigElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||LA2_0==15||(LA2_0>=21 && LA2_0<=22)||LA2_0==24||LA2_0==28) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:99:1: (lv_configElements_1_0= ruleConfigElement )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:99:1: (lv_configElements_1_0= ruleConfigElement )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:100:3: lv_configElements_1_0= ruleConfigElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigModelAccess().getConfigElementsConfigElementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConfigElement_in_ruleConfigModel153);
            	    lv_configElements_1_0=ruleConfigElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configElements",
            	            		lv_configElements_1_0, 
            	            		"ConfigElement");
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


    // $ANTLR start "entryRuleConfigElement"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:124:1: entryRuleConfigElement returns [EObject current=null] : iv_ruleConfigElement= ruleConfigElement EOF ;
    public final EObject entryRuleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigElement = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:125:2: (iv_ruleConfigElement= ruleConfigElement EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:126:2: iv_ruleConfigElement= ruleConfigElement EOF
            {
             newCompositeNode(grammarAccess.getConfigElementRule()); 
            pushFollow(FOLLOW_ruleConfigElement_in_entryRuleConfigElement190);
            iv_ruleConfigElement=ruleConfigElement();

            state._fsp--;

             current =iv_ruleConfigElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConfigElement200); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:133:1: ruleConfigElement returns [EObject current=null] : (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) ;
    public final EObject ruleConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_SubSystemConfig_0 = null;

        EObject this_ActorClassConfig_1 = null;

        EObject this_ActorInstanceConfig_2 = null;

        EObject this_ProtocolClassConfig_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:136:28: ( (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:137:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:137:1: (this_SubSystemConfig_0= ruleSubSystemConfig | this_ActorClassConfig_1= ruleActorClassConfig | this_ActorInstanceConfig_2= ruleActorInstanceConfig | this_ProtocolClassConfig_3= ruleProtocolClassConfig )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 15:
            case 22:
            case 28:
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
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:138:5: this_SubSystemConfig_0= ruleSubSystemConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getSubSystemConfigParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSubSystemConfig_in_ruleConfigElement247);
                    this_SubSystemConfig_0=ruleSubSystemConfig();

                    state._fsp--;

                     
                            current = this_SubSystemConfig_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:148:5: this_ActorClassConfig_1= ruleActorClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorClassConfigParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleActorClassConfig_in_ruleConfigElement274);
                    this_ActorClassConfig_1=ruleActorClassConfig();

                    state._fsp--;

                     
                            current = this_ActorClassConfig_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:158:5: this_ActorInstanceConfig_2= ruleActorInstanceConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getActorInstanceConfigParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleActorInstanceConfig_in_ruleConfigElement301);
                    this_ActorInstanceConfig_2=ruleActorInstanceConfig();

                    state._fsp--;

                     
                            current = this_ActorInstanceConfig_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:168:5: this_ProtocolClassConfig_3= ruleProtocolClassConfig
                    {
                     
                            newCompositeNode(grammarAccess.getConfigElementAccess().getProtocolClassConfigParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleProtocolClassConfig_in_ruleConfigElement328);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:184:1: entryRuleSubSystemConfig returns [EObject current=null] : iv_ruleSubSystemConfig= ruleSubSystemConfig EOF ;
    public final EObject entryRuleSubSystemConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:185:2: (iv_ruleSubSystemConfig= ruleSubSystemConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:186:2: iv_ruleSubSystemConfig= ruleSubSystemConfig EOF
            {
             newCompositeNode(grammarAccess.getSubSystemConfigRule()); 
            pushFollow(FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig363);
            iv_ruleSubSystemConfig=ruleSubSystemConfig();

            state._fsp--;

             current =iv_ruleSubSystemConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemConfig373); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:193:1: ruleSubSystemConfig returns [EObject current=null] : (otherlv_0= 'SubSystemConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_dynConfig_3_0= ruleDynamicConfig ) ) otherlv_4= '}' ) ;
    public final EObject ruleSubSystemConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_dynConfig_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:196:28: ( (otherlv_0= 'SubSystemConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_dynConfig_3_0= ruleDynamicConfig ) ) otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:197:1: (otherlv_0= 'SubSystemConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_dynConfig_3_0= ruleDynamicConfig ) ) otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:197:1: (otherlv_0= 'SubSystemConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_dynConfig_3_0= ruleDynamicConfig ) ) otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:197:3: otherlv_0= 'SubSystemConfig' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_dynConfig_3_0= ruleDynamicConfig ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleSubSystemConfig410); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemConfigAccess().getSubSystemConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:201:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:202:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:202:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:203:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemConfig430); 

            		newLeafNode(otherlv_1, grammarAccess.getSubSystemConfigAccess().getSubSystemSubSystemClassCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSubSystemConfig442); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:218:1: ( (lv_dynConfig_3_0= ruleDynamicConfig ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:219:1: (lv_dynConfig_3_0= ruleDynamicConfig )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:219:1: (lv_dynConfig_3_0= ruleDynamicConfig )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:220:3: lv_dynConfig_3_0= ruleDynamicConfig
            {
             
            	        newCompositeNode(grammarAccess.getSubSystemConfigAccess().getDynConfigDynamicConfigParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDynamicConfig_in_ruleSubSystemConfig463);
            lv_dynConfig_3_0=ruleDynamicConfig();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubSystemConfigRule());
            	        }
                   		set(
                   			current, 
                   			"dynConfig",
                    		lv_dynConfig_3_0, 
                    		"DynamicConfig");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleSubSystemConfig475); 

                	newLeafNode(otherlv_4, grammarAccess.getSubSystemConfigAccess().getRightCurlyBracketKeyword_4());
                

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:248:1: entryRuleDynamicConfig returns [EObject current=null] : iv_ruleDynamicConfig= ruleDynamicConfig EOF ;
    public final EObject entryRuleDynamicConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDynamicConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:249:2: (iv_ruleDynamicConfig= ruleDynamicConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:250:2: iv_ruleDynamicConfig= ruleDynamicConfig EOF
            {
             newCompositeNode(grammarAccess.getDynamicConfigRule()); 
            pushFollow(FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig511);
            iv_ruleDynamicConfig=ruleDynamicConfig();

            state._fsp--;

             current =iv_ruleDynamicConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDynamicConfig521); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:257:1: ruleDynamicConfig returns [EObject current=null] : (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:260:28: ( (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:261:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:261:1: (otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:261:3: otherlv_0= 'dynamic configuration' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleDynamicConfig558); 

                	newLeafNode(otherlv_0, grammarAccess.getDynamicConfigAccess().getDynamicConfigurationKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleDynamicConfig570); 

                	newLeafNode(otherlv_1, grammarAccess.getDynamicConfigAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:269:1: ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:271:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:271:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:272:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:275:2: ( ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:276:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:276:3: ( ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( LA5_0 >=17 && LA5_0<=18 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:278:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:278:4: ({...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:279:5: {...}? => ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:279:110: ( ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:280:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:6: ({...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:7: {...}? => ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:16: ( (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) ) | ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==17) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==18) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:17: (otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:283:19: otherlv_3= 'file path' ( (lv_filePath_4_0= RULE_STRING ) )
            	            {
            	            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleDynamicConfig629); 

            	                	newLeafNode(otherlv_3, grammarAccess.getDynamicConfigAccess().getFilePathKeyword_2_0_0_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:287:1: ( (lv_filePath_4_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:288:1: (lv_filePath_4_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:288:1: (lv_filePath_4_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:289:3: lv_filePath_4_0= RULE_STRING
            	            {
            	            lv_filePath_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig646); 

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
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:6: ( (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) ) (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:7: (otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:306:9: otherlv_5= 'user import' ( (lv_userCode1_6_0= RULE_STRING ) )
            	            {
            	            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleDynamicConfig672); 

            	                	newLeafNode(otherlv_5, grammarAccess.getDynamicConfigAccess().getUserImportKeyword_2_0_1_0_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:310:1: ( (lv_userCode1_6_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:311:1: (lv_userCode1_6_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:311:1: (lv_userCode1_6_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:312:3: lv_userCode1_6_0= RULE_STRING
            	            {
            	            lv_userCode1_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig689); 

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

            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:328:3: (otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:328:5: otherlv_7= 'user constructor' ( (lv_userCode2_8_0= RULE_STRING ) )
            	            {
            	            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleDynamicConfig708); 

            	                	newLeafNode(otherlv_7, grammarAccess.getDynamicConfigAccess().getUserConstructorKeyword_2_0_1_1_0());
            	                
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:332:1: ( (lv_userCode2_8_0= RULE_STRING ) )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:333:1: (lv_userCode2_8_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:333:1: (lv_userCode2_8_0= RULE_STRING )
            	            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:334:3: lv_userCode2_8_0= RULE_STRING
            	            {
            	            lv_userCode2_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDynamicConfig725); 

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
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:357:4: ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:357:4: ({...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:358:5: {...}? => ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:358:110: ( ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:359:6: ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getDynamicConfigAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:362:6: ({...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:362:7: {...}? => (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDynamicConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:362:16: (otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:362:18: otherlv_9= 'polling timer [ms]' ( (lv_polling_10_0= RULE_INT ) )
            	    {
            	    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleDynamicConfig800); 

            	        	newLeafNode(otherlv_9, grammarAccess.getDynamicConfigAccess().getPollingTimerMsKeyword_2_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:366:1: ( (lv_polling_10_0= RULE_INT ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:367:1: (lv_polling_10_0= RULE_INT )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:367:1: (lv_polling_10_0= RULE_INT )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:368:3: lv_polling_10_0= RULE_INT
            	    {
            	    lv_polling_10_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDynamicConfig817); 

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

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleDynamicConfig881); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:411:1: entryRuleActorClassConfig returns [EObject current=null] : iv_ruleActorClassConfig= ruleActorClassConfig EOF ;
    public final EObject entryRuleActorClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:412:2: (iv_ruleActorClassConfig= ruleActorClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:413:2: iv_ruleActorClassConfig= ruleActorClassConfig EOF
            {
             newCompositeNode(grammarAccess.getActorClassConfigRule()); 
            pushFollow(FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig917);
            iv_ruleActorClassConfig=ruleActorClassConfig();

            state._fsp--;

             current =iv_ruleActorClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClassConfig927); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:420:1: ruleActorClassConfig returns [EObject current=null] : (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject ruleActorClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:423:28: ( (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:424:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:424:1: (otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:424:3: otherlv_0= 'ActorClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleActorClassConfig964); 

                	newLeafNode(otherlv_0, grammarAccess.getActorClassConfigAccess().getActorClassConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:428:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:429:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:429:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:430:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getActorActorClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorClassConfig987);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleActorClassConfig999); 

                	newLeafNode(otherlv_2, grammarAccess.getActorClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:447:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==29) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:448:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:448:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:449:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrClassConfig_in_ruleActorClassConfig1020);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleActorClassConfig1033); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:477:1: entryRuleActorInstanceConfig returns [EObject current=null] : iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF ;
    public final EObject entryRuleActorInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:478:2: (iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:479:2: iv_ruleActorInstanceConfig= ruleActorInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig1069);
            iv_ruleActorInstanceConfig=ruleActorInstanceConfig();

            state._fsp--;

             current =iv_ruleActorInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceConfig1079); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:486:1: ruleActorInstanceConfig returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleActorInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_path_4_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_ports_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:489:28: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:490:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:490:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:492:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:492:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:493:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:496:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?)
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:497:3: ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:497:3: ( ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=3;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    int LA9_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA9_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        alt9=2;
                    }


                    }
                    break;
                case 15:
                    {
                    int LA9_4 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
                        alt9=2;
                    }


                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:499:4: ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:499:4: ({...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:500:5: {...}? => ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:500:114: ( ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:501:6: ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:504:6: ({...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:504:7: {...}? => (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:504:16: (otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )* )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:504:18: otherlv_1= 'ActorInstanceConfig' ( ( ruleFQN ) ) otherlv_3= '/' ( (lv_path_4_0= ruleRefPath ) ) otherlv_5= '{' ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )*
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleActorInstanceConfig1161); 

            	        	newLeafNode(otherlv_1, grammarAccess.getActorInstanceConfigAccess().getActorInstanceConfigKeyword_0_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:508:1: ( ( ruleFQN ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:509:1: ( ruleFQN )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:509:1: ( ruleFQN )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:510:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getActorInstanceConfigRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getRootSubSystemClassCrossReference_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFQN_in_ruleActorInstanceConfig1184);
            	    ruleFQN();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleActorInstanceConfig1196); 

            	        	newLeafNode(otherlv_3, grammarAccess.getActorInstanceConfigAccess().getSolidusKeyword_0_2());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:527:1: ( (lv_path_4_0= ruleRefPath ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:528:1: (lv_path_4_0= ruleRefPath )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:528:1: (lv_path_4_0= ruleRefPath )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:529:3: lv_path_4_0= ruleRefPath
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPathRefPathParserRuleCall_0_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefPath_in_ruleActorInstanceConfig1217);
            	    lv_path_4_0=ruleRefPath();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"path",
            	            		lv_path_4_0, 
            	            		"RefPath");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleActorInstanceConfig1229); 

            	        	newLeafNode(otherlv_5, grammarAccess.getActorInstanceConfigAccess().getLeftCurlyBracketKeyword_0_4());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:549:1: ( (lv_attributes_6_0= ruleAttrInstanceConfig ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==29) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:550:1: (lv_attributes_6_0= ruleAttrInstanceConfig )
            	    	    {
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:550:1: (lv_attributes_6_0= ruleAttrInstanceConfig )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:551:3: lv_attributes_6_0= ruleAttrInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_0_5_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_ruleActorInstanceConfig1250);
            	    	    lv_attributes_6_0=ruleAttrInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"attributes",
            	    	            		lv_attributes_6_0, 
            	    	            		"AttrInstanceConfig");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:574:4: ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:574:4: ({...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:575:5: {...}? => ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:575:114: ( ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:576:6: ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:6: ({...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:7: {...}? => ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorInstanceConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:16: ( ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}' )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:17: ( (lv_ports_7_0= rulePortInstanceConfig ) )* otherlv_8= '}'
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:579:17: ( (lv_ports_7_0= rulePortInstanceConfig ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==28) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:580:1: (lv_ports_7_0= rulePortInstanceConfig )
            	    	    {
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:580:1: (lv_ports_7_0= rulePortInstanceConfig )
            	    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:581:3: lv_ports_7_0= rulePortInstanceConfig
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getActorInstanceConfigAccess().getPortsPortInstanceConfigParserRuleCall_1_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_rulePortInstanceConfig_in_ruleActorInstanceConfig1328);
            	    	    lv_ports_7_0=rulePortInstanceConfig();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceConfigRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"ports",
            	    	            		lv_ports_7_0, 
            	    	            		"PortInstanceConfig");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleActorInstanceConfig1341); 

            	        	newLeafNode(otherlv_8, grammarAccess.getActorInstanceConfigAccess().getRightCurlyBracketKeyword_1_1());
            	        

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	    	 				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleActorInstanceConfig", "getUnorderedGroupHelper().canLeave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorInstanceConfigAccess().getUnorderedGroup());
            	

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:624:1: entryRuleProtocolClassConfig returns [EObject current=null] : iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF ;
    public final EObject entryRuleProtocolClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:625:2: (iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:626:2: iv_ruleProtocolClassConfig= ruleProtocolClassConfig EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassConfigRule()); 
            pushFollow(FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig1423);
            iv_ruleProtocolClassConfig=ruleProtocolClassConfig();

            state._fsp--;

             current =iv_ruleProtocolClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClassConfig1433); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:633:1: ruleProtocolClassConfig returns [EObject current=null] : (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:636:28: ( (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:637:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:637:1: (otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:637:3: otherlv_0= 'ProtocolClassConfig' ( ( ruleFQN ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleProtocolClassConfig1470); 

                	newLeafNode(otherlv_0, grammarAccess.getProtocolClassConfigAccess().getProtocolClassConfigKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:641:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:642:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:642:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:643:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassConfigRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getProtocolProtocolClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClassConfig1493);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClassConfig1505); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:660:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:662:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:662:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:663:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3());
            	
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:666:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:667:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:667:3: ( ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( LA10_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:669:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:669:4: ({...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:670:5: {...}? => ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:670:116: ( ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:671:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:674:6: ({...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:674:7: {...}? => (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:674:16: (otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:674:18: otherlv_4= 'regular' ( (lv_regular_5_0= rulePortClassConfig ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleProtocolClassConfig1563); 

            	        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassConfigAccess().getRegularKeyword_3_0_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:678:1: ( (lv_regular_5_0= rulePortClassConfig ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:679:1: (lv_regular_5_0= rulePortClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:679:1: (lv_regular_5_0= rulePortClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:680:3: lv_regular_5_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getRegularPortClassConfigParserRuleCall_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1584);
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
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:703:4: ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:703:4: ({...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:704:5: {...}? => ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:704:116: ( ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:705:6: ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getProtocolClassConfigAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:708:6: ({...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:708:7: {...}? => (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProtocolClassConfig", "true");
            	    }
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:708:16: (otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:708:18: otherlv_6= 'conjugate' ( (lv_conjugated_7_0= rulePortClassConfig ) )
            	    {
            	    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleProtocolClassConfig1652); 

            	        	newLeafNode(otherlv_6, grammarAccess.getProtocolClassConfigAccess().getConjugateKeyword_3_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:712:1: ( (lv_conjugated_7_0= rulePortClassConfig ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:713:1: (lv_conjugated_7_0= rulePortClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:713:1: (lv_conjugated_7_0= rulePortClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:714:3: lv_conjugated_7_0= rulePortClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassConfigAccess().getConjugatedPortClassConfigParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1673);
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

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleProtocolClassConfig1726); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:756:1: entryRulePortClassConfig returns [EObject current=null] : iv_rulePortClassConfig= rulePortClassConfig EOF ;
    public final EObject entryRulePortClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:757:2: (iv_rulePortClassConfig= rulePortClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:758:2: iv_rulePortClassConfig= rulePortClassConfig EOF
            {
             newCompositeNode(grammarAccess.getPortClassConfigRule()); 
            pushFollow(FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig1762);
            iv_rulePortClassConfig=rulePortClassConfig();

            state._fsp--;

             current =iv_rulePortClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClassConfig1772); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:765:1: rulePortClassConfig returns [EObject current=null] : ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:768:28: ( ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:1: ( () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:2: () otherlv_1= 'Port' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrClassConfig ) )* otherlv_4= '}'
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:769:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:770:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassConfigAccess().getPortClassConfigAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_rulePortClassConfig1818); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassConfigAccess().getPortKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePortClassConfig1830); 

                	newLeafNode(otherlv_2, grammarAccess.getPortClassConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:783:1: ( (lv_attributes_3_0= ruleAttrClassConfig ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:784:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:784:1: (lv_attributes_3_0= ruleAttrClassConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:785:3: lv_attributes_3_0= ruleAttrClassConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrClassConfig_in_rulePortClassConfig1851);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePortClassConfig1864); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:813:1: entryRulePortInstanceConfig returns [EObject current=null] : iv_rulePortInstanceConfig= rulePortInstanceConfig EOF ;
    public final EObject entryRulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:814:2: (iv_rulePortInstanceConfig= rulePortInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:815:2: iv_rulePortInstanceConfig= rulePortInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getPortInstanceConfigRule()); 
            pushFollow(FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig1900);
            iv_rulePortInstanceConfig=rulePortInstanceConfig();

            state._fsp--;

             current =iv_rulePortInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortInstanceConfig1910); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:822:1: rulePortInstanceConfig returns [EObject current=null] : (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) ;
    public final EObject rulePortInstanceConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:825:28: ( (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:826:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:826:1: (otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:826:3: otherlv_0= 'InterfaceItem' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_rulePortInstanceConfig1947); 

                	newLeafNode(otherlv_0, grammarAccess.getPortInstanceConfigAccess().getInterfaceItemKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:830:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:831:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:831:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:832:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortInstanceConfig1967); 

            		newLeafNode(otherlv_1, grammarAccess.getPortInstanceConfigAccess().getItemInterfaceItemCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePortInstanceConfig1979); 

                	newLeafNode(otherlv_2, grammarAccess.getPortInstanceConfigAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:847:1: ( (lv_attributes_3_0= ruleAttrInstanceConfig ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:848:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:848:1: (lv_attributes_3_0= ruleAttrInstanceConfig )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:849:3: lv_attributes_3_0= ruleAttrInstanceConfig
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_rulePortInstanceConfig2000);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePortInstanceConfig2013); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:879:1: entryRuleAttrClassConfig returns [EObject current=null] : iv_ruleAttrClassConfig= ruleAttrClassConfig EOF ;
    public final EObject entryRuleAttrClassConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrClassConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:880:2: (iv_ruleAttrClassConfig= ruleAttrClassConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:881:2: iv_ruleAttrClassConfig= ruleAttrClassConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrClassConfigRule()); 
            pushFollow(FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig2051);
            iv_ruleAttrClassConfig=ruleAttrClassConfig();

            state._fsp--;

             current =iv_ruleAttrClassConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrClassConfig2061); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:888:1: ruleAttrClassConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )? ) ;
    public final EObject ruleAttrClassConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_value_3_0 = null;

        EObject lv_min_8_0 = null;

        EObject lv_max_11_0 = null;

        EObject lv_attributes_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:891:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:892:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:892:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:892:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleAttrClassConfig2098); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrClassConfigAccess().getAttrKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:896:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:897:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:897:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:898:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrClassConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttrClassConfig2118); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrClassConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:909:2: (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:909:4: otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleAttrClassConfig2131); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:913:1: ( (lv_value_3_0= ruleLiteralArray ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:914:1: (lv_value_3_0= ruleLiteralArray )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:914:1: (lv_value_3_0= ruleLiteralArray )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:915:3: lv_value_3_0= ruleLiteralArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteralArray_in_ruleAttrClassConfig2152);
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

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:931:4: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:931:6: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) ) ( (lv_attributes_12_0= ruleAttrClassConfig ) )* otherlv_13= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAttrClassConfig2167); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrClassConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:935:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:937:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:937:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:938:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
                    	
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:941:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )* )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:942:3: ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )*
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:942:3: ( ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( LA14_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                            alt14=1;
                        }
                        else if ( LA14_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:944:4: ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:944:4: ({...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:945:5: {...}? => ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleAttrClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0)");
                    	    }
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:945:114: ( ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:946:6: ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 0);
                    	    	 				
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:949:6: ({...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:949:7: {...}? => (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleAttrClassConfig", "true");
                    	    }
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:949:16: (otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:949:18: otherlv_6= 'min' otherlv_7= '=' ( (lv_min_8_0= ruleNumberLiteral ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleAttrClassConfig2225); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getAttrClassConfigAccess().getMinKeyword_3_1_0_0());
                    	        
                    	    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleAttrClassConfig2237); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_0_1());
                    	        
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:957:1: ( (lv_min_8_0= ruleNumberLiteral ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:958:1: (lv_min_8_0= ruleNumberLiteral )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:958:1: (lv_min_8_0= ruleNumberLiteral )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:959:3: lv_min_8_0= ruleNumberLiteral
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMinNumberLiteralParserRuleCall_3_1_0_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2258);
                    	    lv_min_8_0=ruleNumberLiteral();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	    	        }
                    	           		set(
                    	           			current, 
                    	           			"min",
                    	            		lv_min_8_0, 
                    	            		"NumberLiteral");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:982:4: ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:982:4: ({...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:983:5: {...}? => ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleAttrClassConfig", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1)");
                    	    }
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:983:114: ( ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:984:6: ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1(), 1);
                    	    	 				
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:987:6: ({...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:987:7: {...}? => (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleAttrClassConfig", "true");
                    	    }
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:987:16: (otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:987:18: otherlv_9= 'max' otherlv_10= '=' ( (lv_max_11_0= ruleNumberLiteral ) )
                    	    {
                    	    otherlv_9=(Token)match(input,32,FOLLOW_32_in_ruleAttrClassConfig2326); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAttrClassConfigAccess().getMaxKeyword_3_1_1_0());
                    	        
                    	    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleAttrClassConfig2338); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getAttrClassConfigAccess().getEqualsSignKeyword_3_1_1_1());
                    	        
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:995:1: ( (lv_max_11_0= ruleNumberLiteral ) )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:996:1: (lv_max_11_0= ruleNumberLiteral )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:996:1: (lv_max_11_0= ruleNumberLiteral )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:997:3: lv_max_11_0= ruleNumberLiteral
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getMaxNumberLiteralParserRuleCall_3_1_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2359);
                    	    lv_max_11_0=ruleNumberLiteral();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	    	        }
                    	           		set(
                    	           			current, 
                    	           			"max",
                    	            		lv_max_11_0, 
                    	            		"NumberLiteral");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getAttrClassConfigAccess().getUnorderedGroup_3_1());
                    	

                    }

                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1027:2: ( (lv_attributes_12_0= ruleAttrClassConfig ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==29) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1028:1: (lv_attributes_12_0= ruleAttrClassConfig )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1028:1: (lv_attributes_12_0= ruleAttrClassConfig )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1029:3: lv_attributes_12_0= ruleAttrClassConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrClassConfigAccess().getAttributesAttrClassConfigParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttrClassConfig_in_ruleAttrClassConfig2421);
                    	    lv_attributes_12_0=ruleAttrClassConfig();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrClassConfigRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_12_0, 
                    	            		"AttrClassConfig");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,15,FOLLOW_15_in_ruleAttrClassConfig2434); 

                        	newLeafNode(otherlv_13, grammarAccess.getAttrClassConfigAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1057:1: entryRuleAttrInstanceConfig returns [EObject current=null] : iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF ;
    public final EObject entryRuleAttrInstanceConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrInstanceConfig = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1058:2: (iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1059:2: iv_ruleAttrInstanceConfig= ruleAttrInstanceConfig EOF
            {
             newCompositeNode(grammarAccess.getAttrInstanceConfigRule()); 
            pushFollow(FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig2472);
            iv_ruleAttrInstanceConfig=ruleAttrInstanceConfig();

            state._fsp--;

             current =iv_ruleAttrInstanceConfig; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrInstanceConfig2482); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1066:1: ruleAttrInstanceConfig returns [EObject current=null] : (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1069:28: ( (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1070:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1070:1: (otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1070:3: otherlv_0= 'Attr' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )? (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleAttrInstanceConfig2519); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrInstanceConfigAccess().getAttrKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1074:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1075:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1075:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1076:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttrInstanceConfig2539); 

            		newLeafNode(otherlv_1, grammarAccess.getAttrInstanceConfigAccess().getAttributeAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1087:2: (otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==30) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1087:4: otherlv_2= '=' ( (lv_value_3_0= ruleLiteralArray ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleAttrInstanceConfig2552); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrInstanceConfigAccess().getEqualsSignKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1091:1: ( (lv_value_3_0= ruleLiteralArray ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1092:1: (lv_value_3_0= ruleLiteralArray )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1092:1: (lv_value_3_0= ruleLiteralArray )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1093:3: lv_value_3_0= ruleLiteralArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getValueLiteralArrayParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteralArray_in_ruleAttrInstanceConfig2573);
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

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1109:4: (otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==14) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1109:6: otherlv_4= '{' ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )? ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAttrInstanceConfig2588); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrInstanceConfigAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1113:1: ( ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==16) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1113:2: ( (lv_dynConfig_5_0= 'dynamic configuration' ) ) ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1113:2: ( (lv_dynConfig_5_0= 'dynamic configuration' ) )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1114:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            {
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1114:1: (lv_dynConfig_5_0= 'dynamic configuration' )
                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1115:3: lv_dynConfig_5_0= 'dynamic configuration'
                            {
                            lv_dynConfig_5_0=(Token)match(input,16,FOLLOW_16_in_ruleAttrInstanceConfig2607); 

                                    newLeafNode(lv_dynConfig_5_0, grammarAccess.getAttrInstanceConfigAccess().getDynConfigDynamicConfigurationKeyword_3_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
                            	        }
                                   		setWithLastConsumed(current, "dynConfig", true, "dynamic configuration");
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1128:2: ( ( (lv_readOnly_6_0= 'read' ) ) | otherlv_7= 'write' )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==33) ) {
                                alt18=1;
                            }
                            else if ( (LA18_0==34) ) {
                                alt18=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 0, input);

                                throw nvae;
                            }
                            switch (alt18) {
                                case 1 :
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1128:3: ( (lv_readOnly_6_0= 'read' ) )
                                    {
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1128:3: ( (lv_readOnly_6_0= 'read' ) )
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1129:1: (lv_readOnly_6_0= 'read' )
                                    {
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1129:1: (lv_readOnly_6_0= 'read' )
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1130:3: lv_readOnly_6_0= 'read'
                                    {
                                    lv_readOnly_6_0=(Token)match(input,33,FOLLOW_33_in_ruleAttrInstanceConfig2639); 

                                            newLeafNode(lv_readOnly_6_0, grammarAccess.getAttrInstanceConfigAccess().getReadOnlyReadKeyword_3_1_1_0_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAttrInstanceConfigRule());
                                    	        }
                                           		setWithLastConsumed(current, "readOnly", true, "read");
                                    	    

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1144:7: otherlv_7= 'write'
                                    {
                                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleAttrInstanceConfig2670); 

                                        	newLeafNode(otherlv_7, grammarAccess.getAttrInstanceConfigAccess().getWriteKeyword_3_1_1_1());
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1148:4: ( (lv_attributes_8_0= ruleAttrInstanceConfig ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==29) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1149:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    {
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1149:1: (lv_attributes_8_0= ruleAttrInstanceConfig )
                    	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1150:3: lv_attributes_8_0= ruleAttrInstanceConfig
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrInstanceConfigAccess().getAttributesAttrInstanceConfigParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttrInstanceConfig_in_ruleAttrInstanceConfig2694);
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
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleAttrInstanceConfig2707); 

                        	newLeafNode(otherlv_9, grammarAccess.getAttrInstanceConfigAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1178:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1179:2: (iv_ruleRefPath= ruleRefPath EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1180:2: iv_ruleRefPath= ruleRefPath EOF
            {
             newCompositeNode(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath2745);
            iv_ruleRefPath=ruleRefPath();

            state._fsp--;

             current =iv_ruleRefPath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath2755); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1187:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token lv_refs_0_0=null;
        Token otherlv_1=null;
        Token lv_refs_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1190:28: ( ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1191:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1191:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1191:2: ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1191:2: ( (lv_refs_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1192:1: (lv_refs_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1192:1: (lv_refs_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1193:3: lv_refs_0_0= RULE_ID
            {
            lv_refs_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath2797); 

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

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1209:2: (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==23) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1209:4: otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleRefPath2815); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1213:1: ( (lv_refs_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1214:1: (lv_refs_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1214:1: (lv_refs_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1215:3: lv_refs_2_0= RULE_ID
            	    {
            	    lv_refs_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath2832); 

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
            	    break loop22;
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1239:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1240:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1241:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport2875);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport2885); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1248:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1251:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1252:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1252:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1252:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleImport2922); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1256:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            else if ( (LA23_0==37) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1256:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1256:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1256:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1256:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1257:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1257:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1258:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport2945);
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

                    otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleImport2957); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1279:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleImport2976); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1283:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1284:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1284:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1285:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport2994); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1309:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1310:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1311:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3036);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN3047); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1318:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1321:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1322:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1322:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1323:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN3094);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1333:1: (kw= '.*' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1334:2: kw= '.*'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleImportedFQN3113); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1347:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1348:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1349:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN3156);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN3167); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1356:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1359:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1360:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1360:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1360:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3207); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1367:1: (kw= '.' this_ID_2= RULE_ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==39) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1368:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,39,FOLLOW_39_in_ruleFQN3226); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN3241); 

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


    // $ANTLR start "entryRuleLiteralArray"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1388:1: entryRuleLiteralArray returns [EObject current=null] : iv_ruleLiteralArray= ruleLiteralArray EOF ;
    public final EObject entryRuleLiteralArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralArray = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1389:2: (iv_ruleLiteralArray= ruleLiteralArray EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1390:2: iv_ruleLiteralArray= ruleLiteralArray EOF
            {
             newCompositeNode(grammarAccess.getLiteralArrayRule()); 
            pushFollow(FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray3288);
            iv_ruleLiteralArray=ruleLiteralArray();

            state._fsp--;

             current =iv_ruleLiteralArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralArray3298); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1397:1: ruleLiteralArray returns [EObject current=null] : ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) ;
    public final EObject ruleLiteralArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_literals_0_0 = null;

        EObject lv_literals_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1400:28: ( ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1401:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1401:1: ( ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )* )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1401:2: ( (lv_literals_0_0= ruleLiteral ) ) (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1401:2: ( (lv_literals_0_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1402:1: (lv_literals_0_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1402:1: (lv_literals_0_0= ruleLiteral )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1403:3: lv_literals_0_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray3344);
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

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1419:2: (otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1419:4: otherlv_1= ',' ( (lv_literals_2_0= ruleLiteral ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleLiteralArray3357); 

            	        	newLeafNode(otherlv_1, grammarAccess.getLiteralArrayAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1423:1: ( (lv_literals_2_0= ruleLiteral ) )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1424:1: (lv_literals_2_0= ruleLiteral )
            	    {
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1424:1: (lv_literals_2_0= ruleLiteral )
            	    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1425:3: lv_literals_2_0= ruleLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLiteralArrayAccess().getLiteralsLiteralParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralArray3378);
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
    // $ANTLR end "ruleLiteralArray"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1449:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1450:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1451:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3416);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3426); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1458:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1461:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1462:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1462:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 41:
            case 42:
                {
                alt27=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 39:
            case 43:
            case 44:
                {
                alt27=2;
                }
                break;
            case RULE_STRING:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1463:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral3473);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1473:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3500);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1483:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral3527);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1499:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1500:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1501:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3562);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral3572); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1508:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1511:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1512:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1512:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1512:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1512:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1513:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1518:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            else if ( (LA28_0==42) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1518:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleBooleanLiteral3619); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1523:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1523:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1524:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1524:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1525:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,42,FOLLOW_42_in_ruleBooleanLiteral3643); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1546:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1547:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1548:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3693);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral3703); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1555:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1558:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1559:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1559:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt29=2;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==RULE_INT) ) {
                    int LA29_3 = input.LA(3);

                    if ( (LA29_3==39) ) {
                        alt29=2;
                    }
                    else if ( (LA29_3==EOF||(LA29_3>=13 && LA29_3<=15)||(LA29_3>=21 && LA29_3<=22)||LA29_3==24||(LA29_3>=28 && LA29_3<=29)||(LA29_3>=31 && LA29_3<=32)||LA29_3==40) ) {
                        alt29=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA29_1==39) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==RULE_INT) ) {
                    int LA29_3 = input.LA(3);

                    if ( (LA29_3==39) ) {
                        alt29=2;
                    }
                    else if ( (LA29_3==EOF||(LA29_3>=13 && LA29_3<=15)||(LA29_3>=21 && LA29_3<=22)||LA29_3==24||(LA29_3>=28 && LA29_3<=29)||(LA29_3>=31 && LA29_3<=32)||LA29_3==40) ) {
                        alt29=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA29_2==39) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA29_3 = input.LA(2);

                if ( (LA29_3==39) ) {
                    alt29=2;
                }
                else if ( (LA29_3==EOF||(LA29_3>=13 && LA29_3<=15)||(LA29_3>=21 && LA29_3<=22)||LA29_3==24||(LA29_3>=28 && LA29_3<=29)||(LA29_3>=31 && LA29_3<=32)||LA29_3==40) ) {
                    alt29=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt29=1;
                }
                break;
            case 39:
                {
                alt29=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1560:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral3750);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1570:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral3777);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1586:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1587:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1588:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3812);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral3822); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1595:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1598:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1599:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1599:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1599:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1599:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1600:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1605:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1606:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1606:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1607:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral3877);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1631:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1632:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1633:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3913);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral3923); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1640:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1643:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1644:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1644:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1644:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1644:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1645:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1650:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1651:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1651:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1652:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral3978);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1676:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1677:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1678:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4014);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral4024); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1685:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1688:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1689:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1689:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1689:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1689:2: ()
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1690:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1695:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1696:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1696:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1697:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral4075); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1721:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1722:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1723:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger4117);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger4128); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1730:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1733:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1734:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1734:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT||(LA30_0>=43 && LA30_0<=44)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_HEX) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1735:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger4175);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1747:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger4208);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1765:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1769:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1770:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4260);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger4271); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1780:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1784:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1785:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1785:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1785:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1785:2: (kw= '+' | kw= '-' )?
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            else if ( (LA31_0==44) ) {
                alt31=2;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1786:2: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleSignedInteger4314); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1793:2: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleSignedInteger4333); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger4350); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1816:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1820:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1821:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4406);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal4417); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1831:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1835:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1836:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal4460); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1854:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1855:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1856:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal4509);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal4520); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1863:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1866:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1867:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1867:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt32=4;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1868:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal4567);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1880:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal4600);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1892:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal4633);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1904:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal4666);
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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1922:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1926:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1927:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal4718);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal4729); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1937:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1941:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1942:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1942:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1942:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1942:2: (kw= '+' | kw= '-' )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==43) ) {
                alt33=1;
            }
            else if ( (LA33_0==44) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1943:2: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleDecimal4772); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1950:2: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimal4791); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal4808); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,39,FOLLOW_39_in_ruleDecimal4826); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal4841); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1986:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1990:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:1991:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal4897);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal4908); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2001:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2005:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2006:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2006:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2006:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2006:2: (kw= '+' | kw= '-' )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==43) ) {
                alt34=1;
            }
            else if ( (LA34_0==44) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2007:2: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleDotDecimal4951); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2014:2: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDotDecimal4970); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,39,FOLLOW_39_in_ruleDotDecimal4985); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal5000); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2043:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2047:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2048:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5056);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot5067); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2058:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2062:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2063:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2063:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2063:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2063:2: (kw= '+' | kw= '-' )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==43) ) {
                alt35=1;
            }
            else if ( (LA35_0==44) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2064:2: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleDecimalDot5110); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2071:2: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimalDot5129); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot5146); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,39,FOLLOW_39_in_ruleDecimalDot5164); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2100:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2104:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2105:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5215);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp5226); 

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
    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2115:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2119:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2120:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2120:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2120:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2120:2: (kw= '+' | kw= '-' )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==43) ) {
                alt36=1;
            }
            else if ( (LA36_0==44) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2121:2: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleDecimalExp5269); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.config/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalConfig.g:2128:2: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleDecimalExp5288); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5305); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,39,FOLLOW_39_in_ruleDecimalExp5323); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5338); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp5358); 

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


    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA32_eotS =
        "\12\uffff";
    static final String DFA32_eofS =
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA32_minS =
        "\3\6\1\47\1\uffff\1\6\1\10\3\uffff";
    static final String DFA32_maxS =
        "\1\54\3\47\1\uffff\2\50\3\uffff";
    static final String DFA32_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA32_specialS =
        "\12\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\3\40\uffff\1\4\3\uffff\1\1\1\2",
            "\1\3\40\uffff\1\4",
            "\1\3\40\uffff\1\4",
            "\1\5",
            "",
            "\1\6\6\uffff\3\7\5\uffff\2\7\1\uffff\1\7\3\uffff\2\7\1\uffff"+
            "\2\7\7\uffff\1\7",
            "\1\10\4\uffff\3\11\5\uffff\2\11\1\uffff\1\11\3\uffff\2\11"+
            "\1\uffff\2\11\7\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1867:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleConfigModel_in_entryRuleConfigModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleConfigModel131 = new BitSet(new long[]{0x000000081160A002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_ruleConfigModel153 = new BitSet(new long[]{0x000000001160A002L});
    public static final BitSet FOLLOW_ruleConfigElement_in_entryRuleConfigElement190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConfigElement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_ruleConfigElement247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_ruleConfigElement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_ruleConfigElement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_ruleConfigElement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemConfig_in_entryRuleSubSystemConfig363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemConfig373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemConfig410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemConfig430 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemConfig442 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_ruleSubSystemConfig463 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubSystemConfig475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDynamicConfig_in_entryRuleDynamicConfig511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDynamicConfig521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDynamicConfig558 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDynamicConfig570 = new BitSet(new long[]{0x0000000000160000L});
    public static final BitSet FOLLOW_17_in_ruleDynamicConfig629 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig646 = new BitSet(new long[]{0x0000000000168000L});
    public static final BitSet FOLLOW_18_in_ruleDynamicConfig672 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig689 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDynamicConfig708 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDynamicConfig725 = new BitSet(new long[]{0x0000000000168000L});
    public static final BitSet FOLLOW_20_in_ruleDynamicConfig800 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDynamicConfig817 = new BitSet(new long[]{0x0000000000168000L});
    public static final BitSet FOLLOW_15_in_ruleDynamicConfig881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClassConfig_in_entryRuleActorClassConfig917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClassConfig927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleActorClassConfig964 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClassConfig987 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClassConfig999 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_ruleActorClassConfig1020 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_15_in_ruleActorClassConfig1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceConfig_in_entryRuleActorInstanceConfig1069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceConfig1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleActorInstanceConfig1161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorInstanceConfig1184 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleActorInstanceConfig1196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefPath_in_ruleActorInstanceConfig1217 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorInstanceConfig1229 = new BitSet(new long[]{0x0000000030408002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_ruleActorInstanceConfig1250 = new BitSet(new long[]{0x0000000030408002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_ruleActorInstanceConfig1328 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_15_in_ruleActorInstanceConfig1341 = new BitSet(new long[]{0x0000000010408002L});
    public static final BitSet FOLLOW_ruleProtocolClassConfig_in_entryRuleProtocolClassConfig1423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClassConfig1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClassConfig1470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClassConfig1493 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClassConfig1505 = new BitSet(new long[]{0x0000000006008000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClassConfig1563 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1584 = new BitSet(new long[]{0x0000000006008000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClassConfig1652 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_ruleProtocolClassConfig1673 = new BitSet(new long[]{0x0000000006008000L});
    public static final BitSet FOLLOW_15_in_ruleProtocolClassConfig1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClassConfig_in_entryRulePortClassConfig1762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClassConfig1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rulePortClassConfig1818 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePortClassConfig1830 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_rulePortClassConfig1851 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_15_in_rulePortClassConfig1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortInstanceConfig_in_entryRulePortInstanceConfig1900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortInstanceConfig1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePortInstanceConfig1947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortInstanceConfig1967 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePortInstanceConfig1979 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_rulePortInstanceConfig2000 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_15_in_rulePortInstanceConfig2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_entryRuleAttrClassConfig2051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrClassConfig2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAttrClassConfig2098 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttrClassConfig2118 = new BitSet(new long[]{0x0000000040004002L});
    public static final BitSet FOLLOW_30_in_ruleAttrClassConfig2131 = new BitSet(new long[]{0x00001E80000000E0L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_ruleAttrClassConfig2152 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAttrClassConfig2167 = new BitSet(new long[]{0x00000001A0008000L});
    public static final BitSet FOLLOW_31_in_ruleAttrClassConfig2225 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAttrClassConfig2237 = new BitSet(new long[]{0x00001880000000C0L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2258 = new BitSet(new long[]{0x00000001A0008000L});
    public static final BitSet FOLLOW_32_in_ruleAttrClassConfig2326 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAttrClassConfig2338 = new BitSet(new long[]{0x00001880000000C0L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleAttrClassConfig2359 = new BitSet(new long[]{0x00000001A0008000L});
    public static final BitSet FOLLOW_ruleAttrClassConfig_in_ruleAttrClassConfig2421 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrClassConfig2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_entryRuleAttrInstanceConfig2472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrInstanceConfig2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAttrInstanceConfig2519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttrInstanceConfig2539 = new BitSet(new long[]{0x0000000040004002L});
    public static final BitSet FOLLOW_30_in_ruleAttrInstanceConfig2552 = new BitSet(new long[]{0x00001E80000000E0L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_ruleAttrInstanceConfig2573 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleAttrInstanceConfig2588 = new BitSet(new long[]{0x0000000020018000L});
    public static final BitSet FOLLOW_16_in_ruleAttrInstanceConfig2607 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAttrInstanceConfig2639 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_34_in_ruleAttrInstanceConfig2670 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_ruleAttrInstanceConfig_in_ruleAttrInstanceConfig2694 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrInstanceConfig2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_entryRuleRefPath2745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefPath2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath2797 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleRefPath2815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath2832 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleImport2922 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport2945 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleImport2957 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_37_in_ruleImport2976 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN3094 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleImportedFQN3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN3156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3207 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleFQN3226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN3241 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleLiteralArray_in_entryRuleLiteralArray3288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralArray3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray3344 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleLiteralArray3357 = new BitSet(new long[]{0x00001E80000000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralArray3378 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleBooleanLiteral3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleBooleanLiteral3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral3978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral4075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger4117 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger4208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleSignedInteger4314 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44_in_ruleSignedInteger4333 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal4509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal4718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDecimal4772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44_in_ruleDecimal4791 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal4808 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDecimal4826 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal4897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal4908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDotDecimal4951 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_44_in_ruleDotDecimal4970 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDotDecimal4985 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal5000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDecimalDot5110 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44_in_ruleDecimalDot5129 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot5146 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDecimalDot5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp5226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDecimalExp5269 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44_in_ruleDecimalExp5288 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5305 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDecimalExp5323 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5338 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp5358 = new BitSet(new long[]{0x0000000000000002L});

}
