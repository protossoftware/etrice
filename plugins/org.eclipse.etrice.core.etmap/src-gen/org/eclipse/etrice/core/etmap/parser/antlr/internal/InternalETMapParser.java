package org.eclipse.etrice.core.etmap.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.etmap.services.ETMapGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETMapParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ActorInstanceMapping'", "'/'", "'import'", "'from'", "'model'", "'.*'", "'.'"
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
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalETMapParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETMapParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETMapParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g"; }



     	private ETMapGrammarAccess grammarAccess;
     	
        public InternalETMapParser(TokenStream input, ETMapGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MappingModel";	
       	}
       	
       	@Override
       	protected ETMapGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMappingModel"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:67:1: entryRuleMappingModel returns [EObject current=null] : iv_ruleMappingModel= ruleMappingModel EOF ;
    public final EObject entryRuleMappingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingModel = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:68:2: (iv_ruleMappingModel= ruleMappingModel EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:69:2: iv_ruleMappingModel= ruleMappingModel EOF
            {
             newCompositeNode(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_ruleMappingModel_in_entryRuleMappingModel75);
            iv_ruleMappingModel=ruleMappingModel();

            state._fsp--;

             current =iv_ruleMappingModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMappingModel85); 

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
    // $ANTLR end "entryRuleMappingModel"


    // $ANTLR start "ruleMappingModel"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:76:1: ruleMappingModel returns [EObject current=null] : (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) ;
    public final EObject ruleMappingModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_mappings_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:79:28: ( (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:80:1: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:80:1: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:80:3: otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleMappingModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getMappingModelAccess().getMappingModelKeyword_0());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:84:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:85:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:85:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:86:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleMappingModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleMappingModel155); 

                	newLeafNode(otherlv_2, grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:106:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:107:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:107:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:108:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMappingModel176);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
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

            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:124:3: ( (lv_mappings_4_0= ruleMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:125:1: (lv_mappings_4_0= ruleMapping )
            	    {
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:125:1: (lv_mappings_4_0= ruleMapping )
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:126:3: lv_mappings_4_0= ruleMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMapping_in_ruleMappingModel198);
            	    lv_mappings_4_0=ruleMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"mappings",
            	            		lv_mappings_4_0, 
            	            		"Mapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleMappingModel211); 

                	newLeafNode(otherlv_5, grammarAccess.getMappingModelAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleMappingModel"


    // $ANTLR start "entryRuleMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:154:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:155:2: (iv_ruleMapping= ruleMapping EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:156:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_ruleMapping_in_entryRuleMapping247);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapping257); 

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
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:163:1: ruleMapping returns [EObject current=null] : (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_subsysMappings_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:166:28: ( (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:167:1: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:167:1: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:167:3: otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleMapping294); 

                	newLeafNode(otherlv_0, grammarAccess.getMappingAccess().getMappingKeyword_0());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:171:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:172:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:172:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:173:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMappingRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleMapping317);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleMapping329); 

                	newLeafNode(otherlv_2, grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:190:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:191:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:191:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:192:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMappingRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleMapping352);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleMapping364); 

                	newLeafNode(otherlv_4, grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:209:1: ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:210:1: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    {
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:210:1: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:211:3: lv_subsysMappings_5_0= ruleSubSystemMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemMapping_in_ruleMapping385);
            	    lv_subsysMappings_5_0=ruleSubSystemMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subsysMappings",
            	            		lv_subsysMappings_5_0, 
            	            		"SubSystemMapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleMapping398); 

                	newLeafNode(otherlv_6, grammarAccess.getMappingAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleSubSystemMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:239:1: entryRuleSubSystemMapping returns [EObject current=null] : iv_ruleSubSystemMapping= ruleSubSystemMapping EOF ;
    public final EObject entryRuleSubSystemMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemMapping = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:240:2: (iv_ruleSubSystemMapping= ruleSubSystemMapping EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:241:2: iv_ruleSubSystemMapping= ruleSubSystemMapping EOF
            {
             newCompositeNode(grammarAccess.getSubSystemMappingRule()); 
            pushFollow(FOLLOW_ruleSubSystemMapping_in_entryRuleSubSystemMapping434);
            iv_ruleSubSystemMapping=ruleSubSystemMapping();

            state._fsp--;

             current =iv_ruleSubSystemMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemMapping444); 

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
    // $ANTLR end "entryRuleSubSystemMapping"


    // $ANTLR start "ruleSubSystemMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:248:1: ruleSubSystemMapping returns [EObject current=null] : (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleSubSystemMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_actorInstanceMappings_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:251:28: ( (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:252:1: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:252:1: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:252:3: otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleSubSystemMapping481); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:256:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:257:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:257:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:258:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemMappingRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemMapping501); 

            		newLeafNode(otherlv_1, grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSubSystemMapping513); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:273:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:274:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:274:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:275:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemMapping533); 

            		newLeafNode(otherlv_3, grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:286:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:286:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleSubSystemMapping546); 

                        	newLeafNode(otherlv_4, grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:290:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:291:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:291:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:292:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSubSystemMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorInstanceMapping_in_ruleSubSystemMapping567);
                    	    lv_actorInstanceMappings_5_0=ruleActorInstanceMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSubSystemMappingRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorInstanceMappings",
                    	            		lv_actorInstanceMappings_5_0, 
                    	            		"ActorInstanceMapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleSubSystemMapping580); 

                        	newLeafNode(otherlv_6, grammarAccess.getSubSystemMappingAccess().getRightCurlyBracketKeyword_4_2());
                        

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
    // $ANTLR end "ruleSubSystemMapping"


    // $ANTLR start "entryRuleActorInstanceMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:320:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:321:2: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:322:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceMappingRule()); 
            pushFollow(FOLLOW_ruleActorInstanceMapping_in_entryRuleActorInstanceMapping618);
            iv_ruleActorInstanceMapping=ruleActorInstanceMapping();

            state._fsp--;

             current =iv_ruleActorInstanceMapping; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstanceMapping628); 

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
    // $ANTLR end "entryRuleActorInstanceMapping"


    // $ANTLR start "ruleActorInstanceMapping"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:329:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_path_1_0 = null;

        EObject lv_actorInstanceMappings_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:332:28: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:333:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:333:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:333:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleActorInstanceMapping665); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:337:1: ( (lv_path_1_0= ruleRefPath ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:338:1: (lv_path_1_0= ruleRefPath )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:338:1: (lv_path_1_0= ruleRefPath )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:339:3: lv_path_1_0= ruleRefPath
            {
             
            	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleRefPath_in_ruleActorInstanceMapping686);
            lv_path_1_0=ruleRefPath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActorInstanceMappingRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_1_0, 
                    		"RefPath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleActorInstanceMapping698); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:359:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:360:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:360:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:361:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstanceMapping718); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadThreadCrossReference_3_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:372:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==12) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:372:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleActorInstanceMapping731); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:376:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:377:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:377:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:378:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorInstanceMapping_in_ruleActorInstanceMapping752);
                    	    lv_actorInstanceMappings_5_0=ruleActorInstanceMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceMappingRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorInstanceMappings",
                    	            		lv_actorInstanceMappings_5_0, 
                    	            		"ActorInstanceMapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleActorInstanceMapping765); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorInstanceMappingAccess().getRightCurlyBracketKeyword_4_2());
                        

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
    // $ANTLR end "ruleActorInstanceMapping"


    // $ANTLR start "entryRuleRefPath"
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:406:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:407:2: (iv_ruleRefPath= ruleRefPath EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:408:2: iv_ruleRefPath= ruleRefPath EOF
            {
             newCompositeNode(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_ruleRefPath_in_entryRuleRefPath803);
            iv_ruleRefPath=ruleRefPath();

            state._fsp--;

             current =iv_ruleRefPath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefPath813); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:415:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token lv_refs_0_0=null;
        Token otherlv_1=null;
        Token lv_refs_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:418:28: ( ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:419:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:419:1: ( ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:419:2: ( (lv_refs_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:419:2: ( (lv_refs_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:420:1: (lv_refs_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:420:1: (lv_refs_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:421:3: lv_refs_0_0= RULE_ID
            {
            lv_refs_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath855); 

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

            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:437:2: (otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:437:4: otherlv_1= '/' ( (lv_refs_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRefPath873); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:441:1: ( (lv_refs_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:442:1: (lv_refs_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:442:1: (lv_refs_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:443:3: lv_refs_2_0= RULE_ID
            	    {
            	    lv_refs_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefPath890); 

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
            	    break loop8;
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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:467:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:468:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:469:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport933);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport943); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:476:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:479:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:480:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:480:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:480:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleImport980); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:484:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==21) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:484:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:484:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:484:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:484:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:485:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:485:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:486:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport1003);
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

                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleImport1015); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:507:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleImport1034); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:511:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:512:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:512:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:513:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport1052); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:537:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:538:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:539:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1094);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN1105); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:546:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:549:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:550:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:550:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:551:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN1152);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:561:1: (kw= '.*' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:562:2: kw= '.*'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleImportedFQN1171); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:575:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:576:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:577:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1214);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1225); 

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
    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:584:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:587:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:588:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:588:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:588:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1265); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:595:1: (kw= '.' this_ID_2= RULE_ID )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etmap/src-gen/org/eclipse/etrice/core/etmap/parser/antlr/internal/InternalETMap.g:596:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,23,FOLLOW_23_in_ruleFQN1284); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1299); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop11;
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMappingModel_in_entryRuleMappingModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMappingModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleMappingModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleMappingModel143 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMappingModel155 = new BitSet(new long[]{0x0000000000086000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMappingModel176 = new BitSet(new long[]{0x0000000000086000L});
    public static final BitSet FOLLOW_ruleMapping_in_ruleMappingModel198 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleMappingModel211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapping_in_entryRuleMapping247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapping257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleMapping294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleMapping317 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMapping329 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleMapping352 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMapping364 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_ruleMapping385 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleMapping398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemMapping_in_entryRuleSubSystemMapping434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemMapping444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSubSystemMapping481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemMapping501 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubSystemMapping513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemMapping533 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSubSystemMapping546 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_ruleSubSystemMapping567 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemMapping580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_entryRuleActorInstanceMapping618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstanceMapping628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleActorInstanceMapping665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefPath_in_ruleActorInstanceMapping686 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleActorInstanceMapping698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstanceMapping718 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleActorInstanceMapping731 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_ruleActorInstanceMapping_in_ruleActorInstanceMapping752 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleActorInstanceMapping765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefPath_in_entryRuleRefPath803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefPath813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath855 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleRefPath873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefPath890 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleImport980 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport1003 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleImport1015 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21_in_ruleImport1034 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN1152 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleImportedFQN1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1265 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleFQN1284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1299 = new BitSet(new long[]{0x0000000000800002L});

}