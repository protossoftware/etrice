package org.eclipse.etrice.core.etmap.parser.antlr.internal; 

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
import org.eclipse.etrice.core.etmap.services.ETMapGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETMapParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'='", "'optional'", "'mandatory'", "'attribute'", "':'", "','", "'import'", "'from'", "'model'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_HEX=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
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
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalETMapParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETMapParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETMapParser.tokenNames; }
    public String getGrammarFileName() { return "InternalETMap.g"; }



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
    // InternalETMap.g:68:1: entryRuleMappingModel returns [EObject current=null] : iv_ruleMappingModel= ruleMappingModel EOF ;
    public final EObject entryRuleMappingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingModel = null;


        try {
            // InternalETMap.g:69:2: (iv_ruleMappingModel= ruleMappingModel EOF )
            // InternalETMap.g:70:2: iv_ruleMappingModel= ruleMappingModel EOF
            {
             newCompositeNode(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingModel=ruleMappingModel();

            state._fsp--;

             current =iv_ruleMappingModel; 
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
    // $ANTLR end "entryRuleMappingModel"


    // $ANTLR start "ruleMappingModel"
    // InternalETMap.g:77:1: ruleMappingModel returns [EObject current=null] : (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) ;
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
            // InternalETMap.g:80:28: ( (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) )
            // InternalETMap.g:81:1: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            {
            // InternalETMap.g:81:1: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            // InternalETMap.g:81:3: otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getMappingModelAccess().getMappingModelKeyword_0());
                
            // InternalETMap.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalETMap.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // InternalETMap.g:86:1: (lv_name_1_0= ruleFQN )
            // InternalETMap.g:87:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getMappingModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
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

                	newLeafNode(otherlv_2, grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalETMap.g:107:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalETMap.g:108:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalETMap.g:108:1: (lv_imports_3_0= ruleImport )
            	    // InternalETMap.g:109:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
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

            // InternalETMap.g:125:3: ( (lv_mappings_4_0= ruleMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalETMap.g:126:1: (lv_mappings_4_0= ruleMapping )
            	    {
            	    // InternalETMap.g:126:1: (lv_mappings_4_0= ruleMapping )
            	    // InternalETMap.g:127:3: lv_mappings_4_0= ruleMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingModelAccess().getMappingsMappingParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_mappings_4_0=ruleMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"mappings",
            	            		lv_mappings_4_0, 
            	            		"org.eclipse.etrice.core.etmap.ETMap.Mapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETMap.g:155:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // InternalETMap.g:156:2: (iv_ruleMapping= ruleMapping EOF )
            // InternalETMap.g:157:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
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
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalETMap.g:164:1: ruleMapping returns [EObject current=null] : (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_subsysMappings_5_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:167:28: ( (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) )
            // InternalETMap.g:168:1: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            {
            // InternalETMap.g:168:1: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            // InternalETMap.g:168:3: otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getMappingAccess().getMappingKeyword_0());
                
            // InternalETMap.g:172:1: ( ( ruleFQN ) )
            // InternalETMap.g:173:1: ( ruleFQN )
            {
            // InternalETMap.g:173:1: ( ruleFQN )
            // InternalETMap.g:174:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMappingRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMappingAccess().getLogicalSysLogicalSystemCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalETMap.g:191:1: ( ( ruleFQN ) )
            // InternalETMap.g:192:1: ( ruleFQN )
            {
            // InternalETMap.g:192:1: ( ruleFQN )
            // InternalETMap.g:193:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMappingRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMappingAccess().getPhysicalSysPhysicalSystemCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalETMap.g:210:1: ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalETMap.g:211:1: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    {
            	    // InternalETMap.g:211:1: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    // InternalETMap.g:212:3: lv_subsysMappings_5_0= ruleSubSystemMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMappingAccess().getSubsysMappingsSubSystemMappingParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_subsysMappings_5_0=ruleSubSystemMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMappingRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subsysMappings",
            	            		lv_subsysMappings_5_0, 
            	            		"org.eclipse.etrice.core.etmap.ETMap.SubSystemMapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETMap.g:240:1: entryRuleSubSystemMapping returns [EObject current=null] : iv_ruleSubSystemMapping= ruleSubSystemMapping EOF ;
    public final EObject entryRuleSubSystemMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemMapping = null;


        try {
            // InternalETMap.g:241:2: (iv_ruleSubSystemMapping= ruleSubSystemMapping EOF )
            // InternalETMap.g:242:2: iv_ruleSubSystemMapping= ruleSubSystemMapping EOF
            {
             newCompositeNode(grammarAccess.getSubSystemMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubSystemMapping=ruleSubSystemMapping();

            state._fsp--;

             current =iv_ruleSubSystemMapping; 
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
    // $ANTLR end "entryRuleSubSystemMapping"


    // $ANTLR start "ruleSubSystemMapping"
    // InternalETMap.g:249:1: ruleSubSystemMapping returns [EObject current=null] : (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleSubSystemMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_threadMappings_5_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:252:28: ( (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? ) )
            // InternalETMap.g:253:1: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? )
            {
            // InternalETMap.g:253:1: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? )
            // InternalETMap.g:253:3: otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0());
                
            // InternalETMap.g:257:1: ( (otherlv_1= RULE_ID ) )
            // InternalETMap.g:258:1: (otherlv_1= RULE_ID )
            {
            // InternalETMap.g:258:1: (otherlv_1= RULE_ID )
            // InternalETMap.g:259:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemMappingRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            		newLeafNode(otherlv_1, grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalETMap.g:274:1: ( (otherlv_3= RULE_ID ) )
            // InternalETMap.g:275:1: (otherlv_3= RULE_ID )
            {
            // InternalETMap.g:275:1: (otherlv_3= RULE_ID )
            // InternalETMap.g:276:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            		newLeafNode(otherlv_3, grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0()); 
            	

            }


            }

            // InternalETMap.g:287:2: (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalETMap.g:287:4: otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_10); 

                        	newLeafNode(otherlv_4, grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalETMap.g:291:1: ( (lv_threadMappings_5_0= ruleThreadMapping ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalETMap.g:292:1: (lv_threadMappings_5_0= ruleThreadMapping )
                    	    {
                    	    // InternalETMap.g:292:1: (lv_threadMappings_5_0= ruleThreadMapping )
                    	    // InternalETMap.g:293:3: lv_threadMappings_5_0= ruleThreadMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSubSystemMappingAccess().getThreadMappingsThreadMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_10);
                    	    lv_threadMappings_5_0=ruleThreadMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSubSystemMappingRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"threadMappings",
                    	            		lv_threadMappings_5_0, 
                    	            		"org.eclipse.etrice.core.etmap.ETMap.ThreadMapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

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


    // $ANTLR start "entryRuleThreadMapping"
    // InternalETMap.g:321:1: entryRuleThreadMapping returns [EObject current=null] : iv_ruleThreadMapping= ruleThreadMapping EOF ;
    public final EObject entryRuleThreadMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThreadMapping = null;


        try {
            // InternalETMap.g:322:2: (iv_ruleThreadMapping= ruleThreadMapping EOF )
            // InternalETMap.g:323:2: iv_ruleThreadMapping= ruleThreadMapping EOF
            {
             newCompositeNode(grammarAccess.getThreadMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThreadMapping=ruleThreadMapping();

            state._fsp--;

             current =iv_ruleThreadMapping; 
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
    // $ANTLR end "entryRuleThreadMapping"


    // $ANTLR start "ruleThreadMapping"
    // InternalETMap.g:330:1: ruleThreadMapping returns [EObject current=null] : (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleThreadMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:333:28: ( (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalETMap.g:334:1: (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalETMap.g:334:1: (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            // InternalETMap.g:334:3: otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0());
                
            // InternalETMap.g:338:1: ( (otherlv_1= RULE_ID ) )
            // InternalETMap.g:339:1: (otherlv_1= RULE_ID )
            {
            // InternalETMap.g:339:1: (otherlv_1= RULE_ID )
            // InternalETMap.g:340:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getThreadMappingRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            		newLeafNode(otherlv_1, grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalETMap.g:355:1: ( (otherlv_3= RULE_ID ) )
            // InternalETMap.g:356:1: (otherlv_3= RULE_ID )
            {
            // InternalETMap.g:356:1: (otherlv_3= RULE_ID )
            // InternalETMap.g:357:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getThreadMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getThreadMappingAccess().getPhysicalThreadPhysicalThreadCrossReference_3_0()); 
            	

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
    // $ANTLR end "ruleThreadMapping"


    // $ANTLR start "entryRuleKeyValue"
    // InternalETMap.g:378:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalETMap.g:379:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalETMap.g:380:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalETMap.g:387:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:390:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalETMap.g:391:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalETMap.g:391:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalETMap.g:391:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalETMap.g:391:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalETMap.g:392:1: (lv_key_0_0= RULE_ID )
            {
            // InternalETMap.g:392:1: (lv_key_0_0= RULE_ID )
            // InternalETMap.g:393:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_1=(Token)match(input,19,FOLLOW_12); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalETMap.g:413:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalETMap.g:414:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalETMap.g:414:1: (lv_value_2_0= ruleLiteral )
            // InternalETMap.g:415:3: lv_value_2_0= ruleLiteral
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
    // InternalETMap.g:441:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalETMap.g:442:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalETMap.g:443:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalETMap.g:450:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:453:28: (this_ID_0= RULE_ID )
            // InternalETMap.g:454:5: this_ID_0= RULE_ID
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
    // InternalETMap.g:469:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalETMap.g:470:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalETMap.g:471:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalETMap.g:478:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:481:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalETMap.g:482:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalETMap.g:482:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==23) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=38 && LA6_5<=41)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==13) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==21) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==22) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==23) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=38 && LA6_5<=41)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==13) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalETMap.g:483:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalETMap.g:493:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalETMap.g:509:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalETMap.g:510:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalETMap.g:511:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalETMap.g:518:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalETMap.g:521:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalETMap.g:522:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalETMap.g:522:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalETMap.g:522:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalETMap.g:522:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalETMap.g:522:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETMap.g:522:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETMap.g:523:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETMap.g:523:1: (lv_optional_0_0= 'optional' )
                    // InternalETMap.g:524:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,20,FOLLOW_13); 

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
                    // InternalETMap.g:538:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalETMap.g:546:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalETMap.g:547:1: (lv_name_3_0= RULE_ID )
            {
            // InternalETMap.g:547:1: (lv_name_3_0= RULE_ID )
            // InternalETMap.g:548:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_4=(Token)match(input,23,FOLLOW_15); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalETMap.g:568:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalETMap.g:569:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalETMap.g:569:1: (lv_type_5_0= ruleLiteralType )
            // InternalETMap.g:570:3: lv_type_5_0= ruleLiteralType
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
    // InternalETMap.g:594:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalETMap.g:595:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalETMap.g:596:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalETMap.g:603:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalETMap.g:606:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalETMap.g:607:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalETMap.g:607:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalETMap.g:607:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalETMap.g:607:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalETMap.g:607:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETMap.g:607:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETMap.g:608:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETMap.g:608:1: (lv_optional_0_0= 'optional' )
                    // InternalETMap.g:609:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,20,FOLLOW_13); 

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
                    // InternalETMap.g:623:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalETMap.g:631:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalETMap.g:632:1: (lv_name_3_0= RULE_ID )
            {
            // InternalETMap.g:632:1: (lv_name_3_0= RULE_ID )
            // InternalETMap.g:633:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_4=(Token)match(input,23,FOLLOW_4); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,13,FOLLOW_16); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalETMap.g:657:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalETMap.g:658:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalETMap.g:658:1: (lv_values_6_0= RULE_STRING )
            // InternalETMap.g:659:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalETMap.g:675:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalETMap.g:675:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,24,FOLLOW_16); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalETMap.g:679:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalETMap.g:680:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalETMap.g:680:1: (lv_values_8_0= RULE_STRING )
            	    // InternalETMap.g:681:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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
            	    break loop9;
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
    // InternalETMap.g:709:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalETMap.g:710:2: (iv_ruleImport= ruleImport EOF )
            // InternalETMap.g:711:2: iv_ruleImport= ruleImport EOF
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
    // InternalETMap.g:718:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:721:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalETMap.g:722:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalETMap.g:722:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalETMap.g:722:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_18); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalETMap.g:726:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
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
                    // InternalETMap.g:726:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalETMap.g:726:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalETMap.g:726:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalETMap.g:726:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalETMap.g:727:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalETMap.g:727:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalETMap.g:728:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_19);
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

                    otherlv_2=(Token)match(input,26,FOLLOW_16); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:749:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_16); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalETMap.g:753:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalETMap.g:754:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalETMap.g:754:1: (lv_importURI_4_0= RULE_STRING )
            // InternalETMap.g:755:3: lv_importURI_4_0= RULE_STRING
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
    // InternalETMap.g:779:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalETMap.g:780:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalETMap.g:781:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalETMap.g:788:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:791:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalETMap.g:792:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalETMap.g:792:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalETMap.g:793:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_20);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalETMap.g:803:1: (kw= '.*' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalETMap.g:804:2: kw= '.*'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

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
    // InternalETMap.g:817:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalETMap.g:818:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalETMap.g:819:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalETMap.g:826:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:829:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalETMap.g:830:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalETMap.g:830:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalETMap.g:830:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalETMap.g:830:2: ()
            // InternalETMap.g:831:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FOLLOW_21); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalETMap.g:840:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_STRING) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalETMap.g:841:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalETMap.g:841:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalETMap.g:842:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_21); 

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
            	    break loop12;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); 

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
    // InternalETMap.g:874:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalETMap.g:875:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalETMap.g:876:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalETMap.g:883:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:886:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalETMap.g:887:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalETMap.g:887:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 31:
            case 32:
                {
                alt13=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 33:
            case 34:
                {
                alt13=2;
                }
                break;
            case RULE_STRING:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalETMap.g:888:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalETMap.g:898:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalETMap.g:908:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalETMap.g:924:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalETMap.g:925:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalETMap.g:926:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalETMap.g:933:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:936:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalETMap.g:937:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalETMap.g:937:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalETMap.g:937:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalETMap.g:937:2: ()
            // InternalETMap.g:938:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalETMap.g:943:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            else if ( (LA14_0==32) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalETMap.g:943:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalETMap.g:948:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalETMap.g:948:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalETMap.g:949:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalETMap.g:949:1: (lv_isTrue_2_0= 'true' )
                    // InternalETMap.g:950:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,32,FOLLOW_2); 

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
    // InternalETMap.g:971:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalETMap.g:972:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalETMap.g:973:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalETMap.g:980:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:983:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalETMap.g:984:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalETMap.g:984:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt15=2;
            switch ( input.LA(1) ) {
            case 33:
                {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_INT) ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3==EOF) ) {
                        alt15=1;
                    }
                    else if ( (LA15_3==35) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==RULE_INT) ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3==EOF) ) {
                        alt15=1;
                    }
                    else if ( (LA15_3==35) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA15_3 = input.LA(2);

                if ( (LA15_3==EOF) ) {
                    alt15=1;
                }
                else if ( (LA15_3==35) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt15=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalETMap.g:985:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalETMap.g:995:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalETMap.g:1011:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalETMap.g:1012:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalETMap.g:1013:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalETMap.g:1020:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:1023:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalETMap.g:1024:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalETMap.g:1024:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalETMap.g:1024:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalETMap.g:1024:2: ()
            // InternalETMap.g:1025:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalETMap.g:1030:2: ( (lv_value_1_0= ruleReal ) )
            // InternalETMap.g:1031:1: (lv_value_1_0= ruleReal )
            {
            // InternalETMap.g:1031:1: (lv_value_1_0= ruleReal )
            // InternalETMap.g:1032:3: lv_value_1_0= ruleReal
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
    // InternalETMap.g:1056:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalETMap.g:1057:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalETMap.g:1058:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalETMap.g:1065:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:1068:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalETMap.g:1069:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalETMap.g:1069:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalETMap.g:1069:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalETMap.g:1069:2: ()
            // InternalETMap.g:1070:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalETMap.g:1075:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalETMap.g:1076:1: (lv_value_1_0= ruleInteger )
            {
            // InternalETMap.g:1076:1: (lv_value_1_0= ruleInteger )
            // InternalETMap.g:1077:3: lv_value_1_0= ruleInteger
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
    // InternalETMap.g:1101:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalETMap.g:1102:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalETMap.g:1103:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalETMap.g:1110:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:1113:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalETMap.g:1114:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalETMap.g:1114:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalETMap.g:1114:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalETMap.g:1114:2: ()
            // InternalETMap.g:1115:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalETMap.g:1120:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalETMap.g:1121:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalETMap.g:1121:1: (lv_value_1_0= RULE_STRING )
            // InternalETMap.g:1122:3: lv_value_1_0= RULE_STRING
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
    // InternalETMap.g:1146:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalETMap.g:1147:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalETMap.g:1148:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalETMap.g:1155:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:1158:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalETMap.g:1159:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalETMap.g:1159:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT||(LA17_0>=33 && LA17_0<=34)) ) {
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
                    // InternalETMap.g:1159:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalETMap.g:1159:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalETMap.g:1159:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalETMap.g:1159:3: (kw= '+' | kw= '-' )?
                    int alt16=3;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==33) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==34) ) {
                        alt16=2;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalETMap.g:1160:2: kw= '+'
                            {
                            kw=(Token)match(input,33,FOLLOW_22); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalETMap.g:1167:2: kw= '-'
                            {
                            kw=(Token)match(input,34,FOLLOW_22); 

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
                    // InternalETMap.g:1180:10: this_HEX_3= RULE_HEX
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
    // InternalETMap.g:1195:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalETMap.g:1196:2: (iv_ruleReal= ruleReal EOF )
            // InternalETMap.g:1197:2: iv_ruleReal= ruleReal EOF
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
    // InternalETMap.g:1204:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalETMap.g:1207:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalETMap.g:1208:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalETMap.g:1208:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt18=2;
            switch ( input.LA(1) ) {
            case 33:
                {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==RULE_INT) ) {
                    int LA18_3 = input.LA(3);

                    if ( (LA18_3==35) ) {
                        int LA18_4 = input.LA(4);

                        if ( (LA18_4==RULE_INT) ) {
                            int LA18_5 = input.LA(5);

                            if ( ((LA18_5>=36 && LA18_5<=37)) ) {
                                alt18=2;
                            }
                            else if ( (LA18_5==EOF) ) {
                                alt18=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==RULE_INT) ) {
                    int LA18_3 = input.LA(3);

                    if ( (LA18_3==35) ) {
                        int LA18_4 = input.LA(4);

                        if ( (LA18_4==RULE_INT) ) {
                            int LA18_5 = input.LA(5);

                            if ( ((LA18_5>=36 && LA18_5<=37)) ) {
                                alt18=2;
                            }
                            else if ( (LA18_5==EOF) ) {
                                alt18=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA18_3 = input.LA(2);

                if ( (LA18_3==35) ) {
                    int LA18_4 = input.LA(3);

                    if ( (LA18_4==RULE_INT) ) {
                        int LA18_5 = input.LA(4);

                        if ( ((LA18_5>=36 && LA18_5<=37)) ) {
                            alt18=2;
                        }
                        else if ( (LA18_5==EOF) ) {
                            alt18=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalETMap.g:1209:5: this_Decimal_0= ruleDecimal
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
                    // InternalETMap.g:1221:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalETMap.g:1239:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalETMap.g:1243:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalETMap.g:1244:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalETMap.g:1254:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalETMap.g:1258:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalETMap.g:1259:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalETMap.g:1259:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalETMap.g:1259:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalETMap.g:1259:2: (kw= '+' | kw= '-' )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            else if ( (LA19_0==34) ) {
                alt19=2;
            }
            switch (alt19) {
                case 1 :
                    // InternalETMap.g:1260:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_22); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1267:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_23); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,35,FOLLOW_22); 

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
    // InternalETMap.g:1303:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalETMap.g:1307:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalETMap.g:1308:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalETMap.g:1318:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalETMap.g:1322:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalETMap.g:1323:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalETMap.g:1323:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalETMap.g:1323:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalETMap.g:1323:2: (kw= '+' | kw= '-' )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            else if ( (LA20_0==34) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // InternalETMap.g:1324:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_22); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1331:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_23); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,35,FOLLOW_22); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_24); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalETMap.g:1356:1: (kw= 'e' | kw= 'E' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                alt21=1;
            }
            else if ( (LA21_0==37) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalETMap.g:1357:2: kw= 'e'
                    {
                    kw=(Token)match(input,36,FOLLOW_25); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1364:2: kw= 'E'
                    {
                    kw=(Token)match(input,37,FOLLOW_25); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalETMap.g:1369:2: (kw= '+' | kw= '-' )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            else if ( (LA22_0==34) ) {
                alt22=2;
            }
            switch (alt22) {
                case 1 :
                    // InternalETMap.g:1370:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_22); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1377:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

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
    // InternalETMap.g:1400:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalETMap.g:1401:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalETMap.g:1402:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalETMap.g:1409:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalETMap.g:1412:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalETMap.g:1413:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalETMap.g:1413:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalETMap.g:1413:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalETMap.g:1420:1: (kw= '.' this_ID_2= RULE_ID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==35) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalETMap.g:1421:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,35,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_26); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "ruleLiteralType"
    // InternalETMap.g:1441:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalETMap.g:1443:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalETMap.g:1444:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalETMap.g:1444:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt24=1;
                }
                break;
            case 39:
                {
                alt24=2;
                }
                break;
            case 40:
                {
                alt24=3;
                }
                break;
            case 41:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalETMap.g:1444:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalETMap.g:1444:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalETMap.g:1444:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1450:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalETMap.g:1450:6: (enumLiteral_1= 'ptInteger' )
                    // InternalETMap.g:1450:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalETMap.g:1456:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalETMap.g:1456:6: (enumLiteral_2= 'ptReal' )
                    // InternalETMap.g:1456:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalETMap.g:1462:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalETMap.g:1462:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalETMap.g:1462:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,41,FOLLOW_2); 

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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000200C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000007800000E0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000003C000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000600000040L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000002L});

}