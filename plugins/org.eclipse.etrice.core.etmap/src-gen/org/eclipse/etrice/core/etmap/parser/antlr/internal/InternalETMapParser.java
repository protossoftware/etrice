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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_CC_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'MappingModel'", "'{'", "'}'", "'Mapping'", "'->'", "'SubSystemMapping'", "'ThreadMapping'", "'='", "'optional'", "'mandatory'", "'attribute'", "':'", "','", "'import'", "'from'", "'model'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'e'", "'E'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_HEX=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=8;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
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
    // InternalETMap.g:65:1: entryRuleMappingModel returns [EObject current=null] : iv_ruleMappingModel= ruleMappingModel EOF ;
    public final EObject entryRuleMappingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingModel = null;


        try {
            // InternalETMap.g:65:53: (iv_ruleMappingModel= ruleMappingModel EOF )
            // InternalETMap.g:66:2: iv_ruleMappingModel= ruleMappingModel EOF
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
    // InternalETMap.g:72:1: ruleMappingModel returns [EObject current=null] : (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) ;
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
            // InternalETMap.g:78:2: ( (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' ) )
            // InternalETMap.g:79:2: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            {
            // InternalETMap.g:79:2: (otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}' )
            // InternalETMap.g:80:3: otherlv_0= 'MappingModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_mappings_4_0= ruleMapping ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingModelAccess().getMappingModelKeyword_0());
            		
            // InternalETMap.g:84:3: ( (lv_name_1_0= ruleFQN ) )
            // InternalETMap.g:85:4: (lv_name_1_0= ruleFQN )
            {
            // InternalETMap.g:85:4: (lv_name_1_0= ruleFQN )
            // InternalETMap.g:86:5: lv_name_1_0= ruleFQN
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

            otherlv_2=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getMappingModelAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalETMap.g:107:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==26) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalETMap.g:108:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalETMap.g:108:4: (lv_imports_3_0= ruleImport )
            	    // InternalETMap.g:109:5: lv_imports_3_0= ruleImport
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

            // InternalETMap.g:126:3: ( (lv_mappings_4_0= ruleMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalETMap.g:127:4: (lv_mappings_4_0= ruleMapping )
            	    {
            	    // InternalETMap.g:127:4: (lv_mappings_4_0= ruleMapping )
            	    // InternalETMap.g:128:5: lv_mappings_4_0= ruleMapping
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

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

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
    // InternalETMap.g:153:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // InternalETMap.g:153:48: (iv_ruleMapping= ruleMapping EOF )
            // InternalETMap.g:154:2: iv_ruleMapping= ruleMapping EOF
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
    // InternalETMap.g:160:1: ruleMapping returns [EObject current=null] : (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_subsysMappings_5_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:166:2: ( (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' ) )
            // InternalETMap.g:167:2: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            {
            // InternalETMap.g:167:2: (otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}' )
            // InternalETMap.g:168:3: otherlv_0= 'Mapping' ( ( ruleFQN ) ) otherlv_2= '->' ( ( ruleFQN ) ) otherlv_4= '{' ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingAccess().getMappingKeyword_0());
            		
            // InternalETMap.g:172:3: ( ( ruleFQN ) )
            // InternalETMap.g:173:4: ( ruleFQN )
            {
            // InternalETMap.g:173:4: ( ruleFQN )
            // InternalETMap.g:174:5: ruleFQN
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

            otherlv_2=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalETMap.g:192:3: ( ( ruleFQN ) )
            // InternalETMap.g:193:4: ( ruleFQN )
            {
            // InternalETMap.g:193:4: ( ruleFQN )
            // InternalETMap.g:194:5: ruleFQN
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

            otherlv_4=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalETMap.g:212:3: ( (lv_subsysMappings_5_0= ruleSubSystemMapping ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalETMap.g:213:4: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    {
            	    // InternalETMap.g:213:4: (lv_subsysMappings_5_0= ruleSubSystemMapping )
            	    // InternalETMap.g:214:5: lv_subsysMappings_5_0= ruleSubSystemMapping
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

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

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
    // InternalETMap.g:239:1: entryRuleSubSystemMapping returns [EObject current=null] : iv_ruleSubSystemMapping= ruleSubSystemMapping EOF ;
    public final EObject entryRuleSubSystemMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemMapping = null;


        try {
            // InternalETMap.g:239:57: (iv_ruleSubSystemMapping= ruleSubSystemMapping EOF )
            // InternalETMap.g:240:2: iv_ruleSubSystemMapping= ruleSubSystemMapping EOF
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
    // InternalETMap.g:246:1: ruleSubSystemMapping returns [EObject current=null] : (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? ) ;
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
            // InternalETMap.g:252:2: ( (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? ) )
            // InternalETMap.g:253:2: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? )
            {
            // InternalETMap.g:253:2: (otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )? )
            // InternalETMap.g:254:3: otherlv_0= 'SubSystemMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubSystemMappingAccess().getSubSystemMappingKeyword_0());
            		
            // InternalETMap.g:258:3: ( (otherlv_1= RULE_ID ) )
            // InternalETMap.g:259:4: (otherlv_1= RULE_ID )
            {
            // InternalETMap.g:259:4: (otherlv_1= RULE_ID )
            // InternalETMap.g:260:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubSystemMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_1, grammarAccess.getSubSystemMappingAccess().getLogicalSubSysSubSystemRefCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSubSystemMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalETMap.g:275:3: ( (otherlv_3= RULE_ID ) )
            // InternalETMap.g:276:4: (otherlv_3= RULE_ID )
            {
            // InternalETMap.g:276:4: (otherlv_3= RULE_ID )
            // InternalETMap.g:277:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubSystemMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_3, grammarAccess.getSubSystemMappingAccess().getNodeNodeRefCrossReference_3_0());
            				

            }


            }

            // InternalETMap.g:288:3: (otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalETMap.g:289:4: otherlv_4= '{' ( (lv_threadMappings_5_0= ruleThreadMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getSubSystemMappingAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalETMap.g:293:4: ( (lv_threadMappings_5_0= ruleThreadMapping ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==19) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalETMap.g:294:5: (lv_threadMappings_5_0= ruleThreadMapping )
                    	    {
                    	    // InternalETMap.g:294:5: (lv_threadMappings_5_0= ruleThreadMapping )
                    	    // InternalETMap.g:295:6: lv_threadMappings_5_0= ruleThreadMapping
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

                    otherlv_6=(Token)match(input,15,FOLLOW_2); 

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
            // InternalETMap.g:321:54: (iv_ruleThreadMapping= ruleThreadMapping EOF )
            // InternalETMap.g:322:2: iv_ruleThreadMapping= ruleThreadMapping EOF
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
    // InternalETMap.g:328:1: ruleThreadMapping returns [EObject current=null] : (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleThreadMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalETMap.g:334:2: ( (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalETMap.g:335:2: (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalETMap.g:335:2: (otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            // InternalETMap.g:336:3: otherlv_0= 'ThreadMapping' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getThreadMappingAccess().getThreadMappingKeyword_0());
            		
            // InternalETMap.g:340:3: ( (otherlv_1= RULE_ID ) )
            // InternalETMap.g:341:4: (otherlv_1= RULE_ID )
            {
            // InternalETMap.g:341:4: (otherlv_1= RULE_ID )
            // InternalETMap.g:342:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThreadMappingRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_1, grammarAccess.getThreadMappingAccess().getLogicalThreadLogicalThreadCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getThreadMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalETMap.g:357:3: ( (otherlv_3= RULE_ID ) )
            // InternalETMap.g:358:4: (otherlv_3= RULE_ID )
            {
            // InternalETMap.g:358:4: (otherlv_3= RULE_ID )
            // InternalETMap.g:359:5: otherlv_3= RULE_ID
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
    // InternalETMap.g:374:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalETMap.g:374:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalETMap.g:375:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalETMap.g:381:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:387:2: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalETMap.g:388:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalETMap.g:388:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalETMap.g:389:3: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalETMap.g:389:3: ( (lv_key_0_0= RULE_ID ) )
            // InternalETMap.g:390:4: (lv_key_0_0= RULE_ID )
            {
            // InternalETMap.g:390:4: (lv_key_0_0= RULE_ID )
            // InternalETMap.g:391:5: lv_key_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalETMap.g:411:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalETMap.g:412:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalETMap.g:412:4: (lv_value_2_0= ruleLiteral )
            // InternalETMap.g:413:5: lv_value_2_0= ruleLiteral
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
    // InternalETMap.g:434:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalETMap.g:434:60: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalETMap.g:435:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalETMap.g:441:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalETMap.g:447:2: (this_ID_0= RULE_ID )
            // InternalETMap.g:448:2: this_ID_0= RULE_ID
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
    // InternalETMap.g:458:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalETMap.g:458:60: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalETMap.g:459:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalETMap.g:465:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;



        	enterRule();

        try {
            // InternalETMap.g:471:2: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalETMap.g:472:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalETMap.g:472:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==23) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==24) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=39 && LA6_5<=42)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==14) ) {
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
            else if ( (LA6_0==22) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==23) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_ID) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==24) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5>=39 && LA6_5<=42)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_5==14) ) {
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
                    // InternalETMap.g:473:3: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalETMap.g:482:3: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalETMap.g:494:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalETMap.g:494:66: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalETMap.g:495:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalETMap.g:501:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalETMap.g:507:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalETMap.g:508:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalETMap.g:508:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalETMap.g:509:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalETMap.g:509:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalETMap.g:510:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETMap.g:510:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETMap.g:511:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETMap.g:511:5: (lv_optional_0_0= 'optional' )
                    // InternalETMap.g:512:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,21,FOLLOW_13); 

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
                    // InternalETMap.g:525:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_13); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalETMap.g:534:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalETMap.g:535:4: (lv_name_3_0= RULE_ID )
            {
            // InternalETMap.g:535:4: (lv_name_3_0= RULE_ID )
            // InternalETMap.g:536:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,24,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
            		
            // InternalETMap.g:556:3: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalETMap.g:557:4: (lv_type_5_0= ruleLiteralType )
            {
            // InternalETMap.g:557:4: (lv_type_5_0= ruleLiteralType )
            // InternalETMap.g:558:5: lv_type_5_0= ruleLiteralType
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
    // InternalETMap.g:579:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalETMap.g:579:64: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalETMap.g:580:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalETMap.g:586:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalETMap.g:592:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalETMap.g:593:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalETMap.g:593:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalETMap.g:594:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalETMap.g:594:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalETMap.g:595:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETMap.g:595:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETMap.g:596:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETMap.g:596:5: (lv_optional_0_0= 'optional' )
                    // InternalETMap.g:597:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,21,FOLLOW_13); 

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
                    // InternalETMap.g:610:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_13); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalETMap.g:619:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalETMap.g:620:4: (lv_name_3_0= RULE_ID )
            {
            // InternalETMap.g:620:4: (lv_name_3_0= RULE_ID )
            // InternalETMap.g:621:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalETMap.g:645:3: ( (lv_values_6_0= RULE_STRING ) )
            // InternalETMap.g:646:4: (lv_values_6_0= RULE_STRING )
            {
            // InternalETMap.g:646:4: (lv_values_6_0= RULE_STRING )
            // InternalETMap.g:647:5: lv_values_6_0= RULE_STRING
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

            // InternalETMap.g:663:3: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalETMap.g:664:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,25,FOLLOW_16); 

            	    				newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalETMap.g:668:4: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalETMap.g:669:5: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalETMap.g:669:5: (lv_values_8_0= RULE_STRING )
            	    // InternalETMap.g:670:6: lv_values_8_0= RULE_STRING
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

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

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
    // InternalETMap.g:695:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalETMap.g:695:47: (iv_ruleImport= ruleImport EOF )
            // InternalETMap.g:696:2: iv_ruleImport= ruleImport EOF
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
    // InternalETMap.g:702:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_4=null;
        Token lv_importURI_5_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:708:2: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) )
            // InternalETMap.g:709:2: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            {
            // InternalETMap.g:709:2: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            // InternalETMap.g:710:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalETMap.g:714:3: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==28) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalETMap.g:715:4: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    {
                    // InternalETMap.g:715:4: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    // InternalETMap.g:716:5: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    {
                    // InternalETMap.g:716:5: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalETMap.g:717:6: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalETMap.g:717:6: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalETMap.g:718:7: lv_importedNamespace_1_0= ruleImportedFQN
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

                    // InternalETMap.g:735:5: (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==27) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalETMap.g:736:6: otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,27,FOLLOW_16); 

                            						newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1_0());
                            					
                            // InternalETMap.g:740:6: ( (lv_importURI_3_0= RULE_STRING ) )
                            // InternalETMap.g:741:7: (lv_importURI_3_0= RULE_STRING )
                            {
                            // InternalETMap.g:741:7: (lv_importURI_3_0= RULE_STRING )
                            // InternalETMap.g:742:8: lv_importURI_3_0= RULE_STRING
                            {
                            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            								newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getImportRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"importURI",
                            									lv_importURI_3_0,
                            									"org.eclipse.xtext.common.Terminals.STRING");
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:761:4: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    {
                    // InternalETMap.g:761:4: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    // InternalETMap.g:762:5: otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_16); 

                    					newLeafNode(otherlv_4, grammarAccess.getImportAccess().getModelKeyword_1_1_0());
                    				
                    // InternalETMap.g:766:5: ( (lv_importURI_5_0= RULE_STRING ) )
                    // InternalETMap.g:767:6: (lv_importURI_5_0= RULE_STRING )
                    {
                    // InternalETMap.g:767:6: (lv_importURI_5_0= RULE_STRING )
                    // InternalETMap.g:768:7: lv_importURI_5_0= RULE_STRING
                    {
                    lv_importURI_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    							newLeafNode(lv_importURI_5_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getImportRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"importURI",
                    								lv_importURI_5_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalETMap.g:790:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalETMap.g:790:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalETMap.g:791:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalETMap.g:797:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:803:2: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalETMap.g:804:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalETMap.g:804:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalETMap.g:805:3: this_FQN_0= ruleFQN (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_20);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalETMap.g:815:3: (kw= '.*' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==29) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalETMap.g:816:4: kw= '.*'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

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
    // InternalETMap.g:826:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalETMap.g:826:54: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalETMap.g:827:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalETMap.g:833:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalETMap.g:839:2: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalETMap.g:840:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalETMap.g:840:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalETMap.g:841:3: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalETMap.g:841:3: ()
            // InternalETMap.g:842:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalETMap.g:852:3: ( (lv_lines_2_0= RULE_STRING ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_STRING) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalETMap.g:853:4: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalETMap.g:853:4: (lv_lines_2_0= RULE_STRING )
            	    // InternalETMap.g:854:5: lv_lines_2_0= RULE_STRING
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
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,31,FOLLOW_2); 

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
    // InternalETMap.g:878:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalETMap.g:878:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalETMap.g:879:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalETMap.g:885:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;



        	enterRule();

        try {
            // InternalETMap.g:891:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalETMap.g:892:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalETMap.g:892:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 32:
            case 33:
                {
                alt14=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 34:
            case 35:
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
                    // InternalETMap.g:893:3: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalETMap.g:902:3: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalETMap.g:911:3: this_StringLiteral_2= ruleStringLiteral
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
    // InternalETMap.g:923:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalETMap.g:923:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalETMap.g:924:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalETMap.g:930:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalETMap.g:936:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalETMap.g:937:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalETMap.g:937:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalETMap.g:938:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalETMap.g:938:3: ()
            // InternalETMap.g:939:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalETMap.g:945:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            else if ( (LA15_0==33) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalETMap.g:946:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalETMap.g:951:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalETMap.g:951:4: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalETMap.g:952:5: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalETMap.g:952:5: (lv_isTrue_2_0= 'true' )
                    // InternalETMap.g:953:6: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,33,FOLLOW_2); 

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
    // InternalETMap.g:970:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalETMap.g:970:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalETMap.g:971:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalETMap.g:977:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalETMap.g:983:2: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalETMap.g:984:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalETMap.g:984:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt16=2;
            switch ( input.LA(1) ) {
            case 34:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==36) ) {
                        alt16=2;
                    }
                    else if ( (LA16_3==EOF) ) {
                        alt16=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==RULE_INT) ) {
                    int LA16_3 = input.LA(3);

                    if ( (LA16_3==36) ) {
                        alt16=2;
                    }
                    else if ( (LA16_3==EOF) ) {
                        alt16=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 3, input);

                        throw nvae;
                    }
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

                if ( (LA16_3==36) ) {
                    alt16=2;
                }
                else if ( (LA16_3==EOF) ) {
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalETMap.g:985:3: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalETMap.g:994:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalETMap.g:1006:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalETMap.g:1006:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalETMap.g:1007:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalETMap.g:1013:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:1019:2: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalETMap.g:1020:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalETMap.g:1020:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalETMap.g:1021:3: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalETMap.g:1021:3: ()
            // InternalETMap.g:1022:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
            					current);
            			

            }

            // InternalETMap.g:1028:3: ( (lv_value_1_0= ruleReal ) )
            // InternalETMap.g:1029:4: (lv_value_1_0= ruleReal )
            {
            // InternalETMap.g:1029:4: (lv_value_1_0= ruleReal )
            // InternalETMap.g:1030:5: lv_value_1_0= ruleReal
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
    // InternalETMap.g:1051:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalETMap.g:1051:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalETMap.g:1052:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalETMap.g:1058:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalETMap.g:1064:2: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalETMap.g:1065:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalETMap.g:1065:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalETMap.g:1066:3: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalETMap.g:1066:3: ()
            // InternalETMap.g:1067:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
            					current);
            			

            }

            // InternalETMap.g:1073:3: ( (lv_value_1_0= ruleInteger ) )
            // InternalETMap.g:1074:4: (lv_value_1_0= ruleInteger )
            {
            // InternalETMap.g:1074:4: (lv_value_1_0= ruleInteger )
            // InternalETMap.g:1075:5: lv_value_1_0= ruleInteger
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
    // InternalETMap.g:1096:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalETMap.g:1096:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalETMap.g:1097:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalETMap.g:1103:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalETMap.g:1109:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalETMap.g:1110:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalETMap.g:1110:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalETMap.g:1111:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalETMap.g:1111:3: ()
            // InternalETMap.g:1112:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            					current);
            			

            }

            // InternalETMap.g:1118:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalETMap.g:1119:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalETMap.g:1119:4: (lv_value_1_0= RULE_STRING )
            // InternalETMap.g:1120:5: lv_value_1_0= RULE_STRING
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
    // InternalETMap.g:1140:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalETMap.g:1140:47: (iv_ruleInteger= ruleInteger EOF )
            // InternalETMap.g:1141:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalETMap.g:1147:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;


        	enterRule();

        try {
            // InternalETMap.g:1153:2: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalETMap.g:1154:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalETMap.g:1154:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT||(LA18_0>=34 && LA18_0<=35)) ) {
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
                    // InternalETMap.g:1155:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalETMap.g:1155:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalETMap.g:1156:4: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalETMap.g:1156:4: (kw= '+' | kw= '-' )?
                    int alt17=3;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==34) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==35) ) {
                        alt17=2;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalETMap.g:1157:5: kw= '+'
                            {
                            kw=(Token)match(input,34,FOLLOW_22); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalETMap.g:1163:5: kw= '-'
                            {
                            kw=(Token)match(input,35,FOLLOW_22); 

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
                    // InternalETMap.g:1178:3: this_HEX_3= RULE_HEX
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
    // InternalETMap.g:1189:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalETMap.g:1189:44: (iv_ruleReal= ruleReal EOF )
            // InternalETMap.g:1190:2: iv_ruleReal= ruleReal EOF
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
    // InternalETMap.g:1196:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;



        	enterRule();

        try {
            // InternalETMap.g:1202:2: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalETMap.g:1203:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalETMap.g:1203:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt19=2;
            switch ( input.LA(1) ) {
            case 34:
                {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==RULE_INT) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==36) ) {
                        int LA19_4 = input.LA(4);

                        if ( (LA19_4==RULE_INT) ) {
                            int LA19_5 = input.LA(5);

                            if ( (LA19_5==EOF) ) {
                                alt19=1;
                            }
                            else if ( ((LA19_5>=37 && LA19_5<=38)) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==RULE_INT) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==36) ) {
                        int LA19_4 = input.LA(4);

                        if ( (LA19_4==RULE_INT) ) {
                            int LA19_5 = input.LA(5);

                            if ( (LA19_5==EOF) ) {
                                alt19=1;
                            }
                            else if ( ((LA19_5>=37 && LA19_5<=38)) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA19_3 = input.LA(2);

                if ( (LA19_3==36) ) {
                    int LA19_4 = input.LA(3);

                    if ( (LA19_4==RULE_INT) ) {
                        int LA19_5 = input.LA(4);

                        if ( (LA19_5==EOF) ) {
                            alt19=1;
                        }
                        else if ( ((LA19_5>=37 && LA19_5<=38)) ) {
                            alt19=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalETMap.g:1204:3: this_Decimal_0= ruleDecimal
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
                    // InternalETMap.g:1215:3: this_DecimalExp_1= ruleDecimalExp
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
    // InternalETMap.g:1229:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:1231:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalETMap.g:1232:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalETMap.g:1241:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:1248:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalETMap.g:1249:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalETMap.g:1249:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalETMap.g:1250:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalETMap.g:1250:3: (kw= '+' | kw= '-' )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==34) ) {
                alt20=1;
            }
            else if ( (LA20_0==35) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // InternalETMap.g:1251:4: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1257:4: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_23); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,36,FOLLOW_22); 

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
    // InternalETMap.g:1289:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:1291:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalETMap.g:1292:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalETMap.g:1301:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalETMap.g:1308:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalETMap.g:1309:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalETMap.g:1309:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalETMap.g:1310:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalETMap.g:1310:3: (kw= '+' | kw= '-' )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            else if ( (LA21_0==35) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // InternalETMap.g:1311:4: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1317:4: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_23); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,36,FOLLOW_22); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_24); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3());
            		
            // InternalETMap.g:1342:3: (kw= 'e' | kw= 'E' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            else if ( (LA22_0==38) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalETMap.g:1343:4: kw= 'e'
                    {
                    kw=(Token)match(input,37,FOLLOW_25); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1349:4: kw= 'E'
                    {
                    kw=(Token)match(input,38,FOLLOW_25); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalETMap.g:1355:3: (kw= '+' | kw= '-' )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            else if ( (LA23_0==35) ) {
                alt23=2;
            }
            switch (alt23) {
                case 1 :
                    // InternalETMap.g:1356:4: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalETMap.g:1362:4: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_22); 

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
    // InternalETMap.g:1382:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalETMap.g:1382:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalETMap.g:1383:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalETMap.g:1389:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalETMap.g:1395:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalETMap.g:1396:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalETMap.g:1396:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalETMap.g:1397:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalETMap.g:1404:3: (kw= '.' this_ID_2= RULE_ID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==36) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalETMap.g:1405:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,36,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_26); 

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
    // InternalETMap.g:1422:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalETMap.g:1428:2: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalETMap.g:1429:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalETMap.g:1429:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt25=1;
                }
                break;
            case 40:
                {
                alt25=2;
                }
                break;
            case 41:
                {
                alt25=3;
                }
                break;
            case 42:
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
                    // InternalETMap.g:1430:3: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalETMap.g:1430:3: (enumLiteral_0= 'ptBoolean' )
                    // InternalETMap.g:1431:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalETMap.g:1438:3: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalETMap.g:1438:3: (enumLiteral_1= 'ptInteger' )
                    // InternalETMap.g:1439:4: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalETMap.g:1446:3: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalETMap.g:1446:3: (enumLiteral_2= 'ptReal' )
                    // InternalETMap.g:1447:4: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalETMap.g:1454:3: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalETMap.g:1454:3: (enumLiteral_3= 'ptCharacter' )
                    // InternalETMap.g:1455:4: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,42,FOLLOW_2); 

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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000004018000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000F000000E0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000078000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000C00000040L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000002L});

}