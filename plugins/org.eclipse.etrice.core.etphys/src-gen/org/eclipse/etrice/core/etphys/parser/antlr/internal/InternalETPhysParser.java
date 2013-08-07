package org.eclipse.etrice.core.etphys.parser.antlr.internal; 

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
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETPhysParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'DefaultThread'", "'Thread'", "'execmode'", "'interval'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'model'", "'['", "']'", "'+'", "'-'", "'import'", "'from'", "'.*'", "'.'", "'s'", "'ms'", "'us'", "'ns'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalETPhysParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETPhysParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETPhysParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g"; }



     	private ETPhysGrammarAccess grammarAccess;
     	
        public InternalETPhysParser(TokenStream input, ETPhysGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PhysicalModel";	
       	}
       	
       	@Override
       	protected ETPhysGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:68:1: entryRulePhysicalModel returns [EObject current=null] : iv_rulePhysicalModel= rulePhysicalModel EOF ;
    public final EObject entryRulePhysicalModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalModel = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:69:2: (iv_rulePhysicalModel= rulePhysicalModel EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:70:2: iv_rulePhysicalModel= rulePhysicalModel EOF
            {
             newCompositeNode(grammarAccess.getPhysicalModelRule()); 
            pushFollow(FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel75);
            iv_rulePhysicalModel=rulePhysicalModel();

            state._fsp--;

             current =iv_rulePhysicalModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalModel85); 

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
    // $ANTLR end "entryRulePhysicalModel"


    // $ANTLR start "rulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:77:1: rulePhysicalModel returns [EObject current=null] : (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' ) ;
    public final EObject rulePhysicalModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_systems_4_0 = null;

        EObject lv_nodeClasses_5_0 = null;

        EObject lv_runtimeClasses_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:80:28: ( (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:81:1: (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:81:1: (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:81:3: otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePhysicalModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:86:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:87:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePhysicalModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_rulePhysicalModel155); 

                	newLeafNode(otherlv_2, grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:107:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==36) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:108:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:108:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:109:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_rulePhysicalModel176);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
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

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:125:3: ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt2=1;
                    }
                    break;
                case 17:
                    {
                    alt2=2;
                    }
                    break;
                case 30:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:125:4: ( (lv_systems_4_0= rulePhysicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:125:4: ( (lv_systems_4_0= rulePhysicalSystem ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:126:1: (lv_systems_4_0= rulePhysicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:126:1: (lv_systems_4_0= rulePhysicalSystem )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:127:3: lv_systems_4_0= rulePhysicalSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhysicalSystem_in_rulePhysicalModel199);
            	    lv_systems_4_0=rulePhysicalSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_4_0, 
            	            		"PhysicalSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:144:6: ( (lv_nodeClasses_5_0= ruleNodeClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:144:6: ( (lv_nodeClasses_5_0= ruleNodeClass ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:145:1: (lv_nodeClasses_5_0= ruleNodeClass )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:145:1: (lv_nodeClasses_5_0= ruleNodeClass )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:146:3: lv_nodeClasses_5_0= ruleNodeClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNodeClass_in_rulePhysicalModel226);
            	    lv_nodeClasses_5_0=ruleNodeClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodeClasses",
            	            		lv_nodeClasses_5_0, 
            	            		"NodeClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:163:6: ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:163:6: ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:164:1: (lv_runtimeClasses_6_0= ruleRuntimeClass )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:164:1: (lv_runtimeClasses_6_0= ruleRuntimeClass )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:165:3: lv_runtimeClasses_6_0= ruleRuntimeClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRuntimeClass_in_rulePhysicalModel253);
            	    lv_runtimeClasses_6_0=ruleRuntimeClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"runtimeClasses",
            	            		lv_runtimeClasses_6_0, 
            	            		"RuntimeClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_rulePhysicalModel267); 

                	newLeafNode(otherlv_7, grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "rulePhysicalModel"


    // $ANTLR start "entryRulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:193:1: entryRulePhysicalSystem returns [EObject current=null] : iv_rulePhysicalSystem= rulePhysicalSystem EOF ;
    public final EObject entryRulePhysicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:194:2: (iv_rulePhysicalSystem= rulePhysicalSystem EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:195:2: iv_rulePhysicalSystem= rulePhysicalSystem EOF
            {
             newCompositeNode(grammarAccess.getPhysicalSystemRule()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem303);
            iv_rulePhysicalSystem=rulePhysicalSystem();

            state._fsp--;

             current =iv_rulePhysicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalSystem313); 

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
    // $ANTLR end "entryRulePhysicalSystem"


    // $ANTLR start "rulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:202:1: rulePhysicalSystem returns [EObject current=null] : (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' ) ;
    public final EObject rulePhysicalSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_docu_2_0 = null;

        EObject lv_nodeRefs_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:205:28: ( (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:206:1: (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:206:1: (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:206:3: otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_rulePhysicalSystem350); 

                	newLeafNode(otherlv_0, grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:210:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:211:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:211:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:212:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhysicalSystem367); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:228:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==32) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:229:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:229:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:230:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePhysicalSystem393);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPhysicalSystemRule());
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_rulePhysicalSystem406); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:250:1: ( (lv_nodeRefs_4_0= ruleNodeRef ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:251:1: (lv_nodeRefs_4_0= ruleNodeRef )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:251:1: (lv_nodeRefs_4_0= ruleNodeRef )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:252:3: lv_nodeRefs_4_0= ruleNodeRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNodeRef_in_rulePhysicalSystem427);
            	    lv_nodeRefs_4_0=ruleNodeRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodeRefs",
            	            		lv_nodeRefs_4_0, 
            	            		"NodeRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_rulePhysicalSystem440); 

                	newLeafNode(otherlv_5, grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "rulePhysicalSystem"


    // $ANTLR start "entryRuleNodeRef"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:280:1: entryRuleNodeRef returns [EObject current=null] : iv_ruleNodeRef= ruleNodeRef EOF ;
    public final EObject entryRuleNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRef = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:281:2: (iv_ruleNodeRef= ruleNodeRef EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:282:2: iv_ruleNodeRef= ruleNodeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef476);
            iv_ruleNodeRef=ruleNodeRef();

            state._fsp--;

             current =iv_ruleNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef486); 

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
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:289:1: ruleNodeRef returns [EObject current=null] : (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:292:28: ( (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:293:1: (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:293:1: (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:293:3: otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleNodeRef523); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeRefAccess().getNodeRefKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:297:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:298:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:298:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:299:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeRef540); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleNodeRef557); 

                	newLeafNode(otherlv_2, grammarAccess.getNodeRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:319:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:320:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:320:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:321:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleNodeRef580);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:334:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==32) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:335:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:335:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:336:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleNodeRef601);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_4_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRuleNodeClass"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:360:1: entryRuleNodeClass returns [EObject current=null] : iv_ruleNodeClass= ruleNodeClass EOF ;
    public final EObject entryRuleNodeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeClass = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:361:2: (iv_ruleNodeClass= ruleNodeClass EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:362:2: iv_ruleNodeClass= ruleNodeClass EOF
            {
             newCompositeNode(grammarAccess.getNodeClassRule()); 
            pushFollow(FOLLOW_ruleNodeClass_in_entryRuleNodeClass638);
            iv_ruleNodeClass=ruleNodeClass();

            state._fsp--;

             current =iv_ruleNodeClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeClass648); 

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
    // $ANTLR end "entryRuleNodeClass"


    // $ANTLR start "ruleNodeClass"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:369:1: ruleNodeClass returns [EObject current=null] : (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' ) ;
    public final EObject ruleNodeClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_docu_2_0 = null;

        AntlrDatatypeRuleToken lv_priomin_10_0 = null;

        AntlrDatatypeRuleToken lv_priomax_13_0 = null;

        EObject lv_threads_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:372:28: ( (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:3: otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleNodeClass685); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeClassAccess().getNodeClassKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:377:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:378:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:378:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:379:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeClass702); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:395:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:396:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:396:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:397:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleNodeClass728);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleNodeClass741); 

                	newLeafNode(otherlv_3, grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:417:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:419:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:419:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:420:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:423:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:424:3: ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:424:3: ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:426:4: ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:426:4: ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:427:5: {...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:427:106: ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:428:6: ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:431:6: ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:431:7: {...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:431:16: (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:431:18: otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleNodeClass799); 

            	        	newLeafNode(otherlv_5, grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0());
            	        
            	    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass811); 

            	        	newLeafNode(otherlv_6, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:439:1: ( ( ruleFQN ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:440:1: ( ruleFQN )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:440:1: ( ruleFQN )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:441:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getNodeClassRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFQN_in_ruleNodeClass834);
            	    ruleFQN();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:461:4: ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:461:4: ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:462:5: {...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:462:106: ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:463:6: ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:466:6: ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:466:7: {...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:466:16: (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:466:18: otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= rulePRIO ) )
            	    {
            	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleNodeClass902); 

            	        	newLeafNode(otherlv_8, grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0());
            	        
            	    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass914); 

            	        	newLeafNode(otherlv_9, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:474:1: ( (lv_priomin_10_0= rulePRIO ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:475:1: (lv_priomin_10_0= rulePRIO )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:475:1: (lv_priomin_10_0= rulePRIO )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:476:3: lv_priomin_10_0= rulePRIO
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_4_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePRIO_in_ruleNodeClass935);
            	    lv_priomin_10_0=rulePRIO();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"priomin",
            	            		lv_priomin_10_0, 
            	            		"PRIO");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:499:4: ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:499:4: ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:500:5: {...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:500:106: ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:501:6: ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:504:6: ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:504:7: {...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:504:16: (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:504:18: otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= rulePRIO ) )
            	    {
            	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleNodeClass1003); 

            	        	newLeafNode(otherlv_11, grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0());
            	        
            	    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass1015); 

            	        	newLeafNode(otherlv_12, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:512:1: ( (lv_priomax_13_0= rulePRIO ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:513:1: (lv_priomax_13_0= rulePRIO )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:513:1: (lv_priomax_13_0= rulePRIO )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:514:3: lv_priomax_13_0= rulePRIO
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_4_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePRIO_in_ruleNodeClass1036);
            	    lv_priomax_13_0=rulePRIO();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"priomax",
            	            		lv_priomax_13_0, 
            	            		"PRIO");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	    	 				

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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:545:2: ( (lv_threads_14_0= rulePhysicalThread ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:546:1: (lv_threads_14_0= rulePhysicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:546:1: (lv_threads_14_0= rulePhysicalThread )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:547:3: lv_threads_14_0= rulePhysicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhysicalThread_in_ruleNodeClass1104);
            	    lv_threads_14_0=rulePhysicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_14_0, 
            	            		"PhysicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_15=(Token)match(input,13,FOLLOW_13_in_ruleNodeClass1117); 

                	newLeafNode(otherlv_15, grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleNodeClass"


    // $ANTLR start "entryRulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:575:1: entryRulePhysicalThread returns [EObject current=null] : iv_rulePhysicalThread= rulePhysicalThread EOF ;
    public final EObject entryRulePhysicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalThread = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:576:2: (iv_rulePhysicalThread= rulePhysicalThread EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:577:2: iv_rulePhysicalThread= rulePhysicalThread EOF
            {
             newCompositeNode(grammarAccess.getPhysicalThreadRule()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread1153);
            iv_rulePhysicalThread=rulePhysicalThread();

            state._fsp--;

             current =iv_rulePhysicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalThread1163); 

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
    // $ANTLR end "entryRulePhysicalThread"


    // $ANTLR start "rulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:584:1: rulePhysicalThread returns [EObject current=null] : ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' ) ;
    public final EObject rulePhysicalThread() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_stacksize_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_msgblocksize_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_msgpoolsize_22_0=null;
        Token otherlv_23=null;
        Enumerator lv_execmode_7_0 = null;

        AntlrDatatypeRuleToken lv_time_10_0 = null;

        AntlrDatatypeRuleToken lv_prio_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:587:28: ( ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}'
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:588:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:589:1: (lv_default_0_0= 'DefaultThread' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:589:1: (lv_default_0_0= 'DefaultThread' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:590:3: lv_default_0_0= 'DefaultThread'
                    {
                    lv_default_0_0=(Token)match(input,22,FOLLOW_22_in_rulePhysicalThread1207); 

                            newLeafNode(lv_default_0_0, grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
                    	        }
                           		setWithLastConsumed(current, "default", true, "DefaultThread");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:604:7: otherlv_1= 'Thread'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_rulePhysicalThread1238); 

                        	newLeafNode(otherlv_1, grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:608:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:609:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:609:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:610:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhysicalThread1256); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_rulePhysicalThread1273); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:630:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:632:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:632:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:633:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:636:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:637:3: ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:637:3: ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=7;
                int LA10_0 = input.LA(1);

                if ( LA10_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                    alt10=2;
                }
                else if ( LA10_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                    alt10=3;
                }
                else if ( LA10_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                    alt10=4;
                }
                else if ( LA10_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                    alt10=5;
                }
                else if ( LA10_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                    alt10=6;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:639:4: ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:639:4: ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:640:5: {...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:640:111: ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:641:6: ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:644:6: ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:644:7: {...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:644:16: (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:644:18: otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_24_in_rulePhysicalThread1331); 

            	        	newLeafNode(otherlv_5, grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0());
            	        
            	    otherlv_6=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1343); 

            	        	newLeafNode(otherlv_6, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:652:1: ( (lv_execmode_7_0= ruleExecMode ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:653:1: (lv_execmode_7_0= ruleExecMode )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:653:1: (lv_execmode_7_0= ruleExecMode )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:654:3: lv_execmode_7_0= ruleExecMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExecMode_in_rulePhysicalThread1364);
            	    lv_execmode_7_0=ruleExecMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"execmode",
            	            		lv_execmode_7_0, 
            	            		"ExecMode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:677:4: ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:677:4: ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:678:5: {...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:678:111: ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:679:6: ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:682:6: ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:682:7: {...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:682:16: (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:682:18: otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) )
            	    {
            	    otherlv_8=(Token)match(input,25,FOLLOW_25_in_rulePhysicalThread1432); 

            	        	newLeafNode(otherlv_8, grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0());
            	        
            	    otherlv_9=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1444); 

            	        	newLeafNode(otherlv_9, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:690:1: ( (lv_time_10_0= ruleTIME ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:691:1: (lv_time_10_0= ruleTIME )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:691:1: (lv_time_10_0= ruleTIME )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:692:3: lv_time_10_0= ruleTIME
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTIME_in_rulePhysicalThread1465);
            	    lv_time_10_0=ruleTIME();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"time",
            	            		lv_time_10_0, 
            	            		"TIME");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:715:4: ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:715:4: ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:716:5: {...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:716:111: ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:717:6: ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:720:6: ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:720:7: {...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:720:16: (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:720:18: otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= rulePRIO ) )
            	    {
            	    otherlv_11=(Token)match(input,26,FOLLOW_26_in_rulePhysicalThread1533); 

            	        	newLeafNode(otherlv_11, grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0());
            	        
            	    otherlv_12=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1545); 

            	        	newLeafNode(otherlv_12, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:728:1: ( (lv_prio_13_0= rulePRIO ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:729:1: (lv_prio_13_0= rulePRIO )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:729:1: (lv_prio_13_0= rulePRIO )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:730:3: lv_prio_13_0= rulePRIO
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_3_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePRIO_in_rulePhysicalThread1566);
            	    lv_prio_13_0=rulePRIO();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"prio",
            	            		lv_prio_13_0, 
            	            		"PRIO");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:753:4: ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:753:4: ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:754:5: {...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:754:111: ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:755:6: ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:758:6: ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:758:7: {...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:758:16: (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:758:18: otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) )
            	    {
            	    otherlv_14=(Token)match(input,27,FOLLOW_27_in_rulePhysicalThread1634); 

            	        	newLeafNode(otherlv_14, grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0());
            	        
            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1646); 

            	        	newLeafNode(otherlv_15, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:766:1: ( (lv_stacksize_16_0= RULE_INT ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:767:1: (lv_stacksize_16_0= RULE_INT )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:767:1: (lv_stacksize_16_0= RULE_INT )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:768:3: lv_stacksize_16_0= RULE_INT
            	    {
            	    lv_stacksize_16_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1663); 

            	    			newLeafNode(lv_stacksize_16_0, grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"stacksize",
            	            		lv_stacksize_16_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:791:4: ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:791:4: ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:792:5: {...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:792:111: ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:793:6: ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:796:6: ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:796:7: {...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:796:16: (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:796:18: otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) )
            	    {
            	    otherlv_17=(Token)match(input,28,FOLLOW_28_in_rulePhysicalThread1736); 

            	        	newLeafNode(otherlv_17, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0());
            	        
            	    otherlv_18=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1748); 

            	        	newLeafNode(otherlv_18, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:804:1: ( (lv_msgblocksize_19_0= RULE_INT ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:805:1: (lv_msgblocksize_19_0= RULE_INT )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:805:1: (lv_msgblocksize_19_0= RULE_INT )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:806:3: lv_msgblocksize_19_0= RULE_INT
            	    {
            	    lv_msgblocksize_19_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1765); 

            	    			newLeafNode(lv_msgblocksize_19_0, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"msgblocksize",
            	            		lv_msgblocksize_19_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:829:4: ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:829:4: ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:830:5: {...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:830:111: ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:831:6: ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:834:6: ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:834:7: {...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:834:16: (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:834:18: otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) )
            	    {
            	    otherlv_20=(Token)match(input,29,FOLLOW_29_in_rulePhysicalThread1838); 

            	        	newLeafNode(otherlv_20, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0());
            	        
            	    otherlv_21=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1850); 

            	        	newLeafNode(otherlv_21, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:842:1: ( (lv_msgpoolsize_22_0= RULE_INT ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:843:1: (lv_msgpoolsize_22_0= RULE_INT )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:843:1: (lv_msgpoolsize_22_0= RULE_INT )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:844:3: lv_msgpoolsize_22_0= RULE_INT
            	    {
            	    lv_msgpoolsize_22_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1867); 

            	    			newLeafNode(lv_msgpoolsize_22_0, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"msgpoolsize",
            	            		lv_msgpoolsize_22_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	

            }

            otherlv_23=(Token)match(input,13,FOLLOW_13_in_rulePhysicalThread1931); 

                	newLeafNode(otherlv_23, grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "rulePhysicalThread"


    // $ANTLR start "entryRuleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:887:1: entryRuleRuntimeClass returns [EObject current=null] : iv_ruleRuntimeClass= ruleRuntimeClass EOF ;
    public final EObject entryRuleRuntimeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuntimeClass = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:888:2: (iv_ruleRuntimeClass= ruleRuntimeClass EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:889:2: iv_ruleRuntimeClass= ruleRuntimeClass EOF
            {
             newCompositeNode(grammarAccess.getRuntimeClassRule()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass1967);
            iv_ruleRuntimeClass=ruleRuntimeClass();

            state._fsp--;

             current =iv_ruleRuntimeClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuntimeClass1977); 

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
    // $ANTLR end "entryRuleRuntimeClass"


    // $ANTLR start "ruleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:896:1: ruleRuntimeClass returns [EObject current=null] : (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) ;
    public final EObject ruleRuntimeClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_docu_2_0 = null;

        Enumerator lv_threadModel_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:899:28: ( (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:900:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:900:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:900:3: otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleRuntimeClass2014); 

                	newLeafNode(otherlv_0, grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:904:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:905:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:905:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:906:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuntimeClass2031); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuntimeClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:922:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:923:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:923:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:924:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRuntimeClass2057);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuntimeClassRule());
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRuntimeClass2070); 

                	newLeafNode(otherlv_3, grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleRuntimeClass2082); 

                	newLeafNode(otherlv_4, grammarAccess.getRuntimeClassAccess().getModelKeyword_4());
                
            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleRuntimeClass2094); 

                	newLeafNode(otherlv_5, grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:952:1: ( (lv_threadModel_6_0= ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:953:1: (lv_threadModel_6_0= ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:953:1: (lv_threadModel_6_0= ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:954:3: lv_threadModel_6_0= ruleThreadModel
            {
             
            	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleThreadModel_in_ruleRuntimeClass2115);
            lv_threadModel_6_0=ruleThreadModel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuntimeClassRule());
            	        }
                   		set(
                   			current, 
                   			"threadModel",
                    		lv_threadModel_6_0, 
                    		"ThreadModel");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleRuntimeClass2127); 

                	newLeafNode(otherlv_7, grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7());
                

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
    // $ANTLR end "ruleRuntimeClass"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:982:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:983:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:984:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation2163);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation2173); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:991:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:994:28: ( (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:995:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:995:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:995:3: otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleDocumentation2210); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:999:1: ( (lv_text_1_0= RULE_STRING ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_STRING) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1000:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1000:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1001:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation2227); 

            	    			newLeafNode(lv_text_1_0, grammarAccess.getDocumentationAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDocumentationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"text",
            	            		lv_text_1_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleDocumentation2245); 

                	newLeafNode(otherlv_2, grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_2());
                

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


    // $ANTLR start "entryRulePRIO"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1029:1: entryRulePRIO returns [String current=null] : iv_rulePRIO= rulePRIO EOF ;
    public final String entryRulePRIO() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRIO = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1033:2: (iv_rulePRIO= rulePRIO EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1034:2: iv_rulePRIO= rulePRIO EOF
            {
             newCompositeNode(grammarAccess.getPRIORule()); 
            pushFollow(FOLLOW_rulePRIO_in_entryRulePRIO2288);
            iv_rulePRIO=rulePRIO();

            state._fsp--;

             current =iv_rulePRIO.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePRIO2299); 

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
    // $ANTLR end "entryRulePRIO"


    // $ANTLR start "rulePRIO"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1044:1: rulePRIO returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken rulePRIO() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1048:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:2: (kw= '+' | kw= '-' )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            else if ( (LA13_0==35) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1050:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_rulePRIO2342); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1057:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_rulePRIO2361); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePRIO2378); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 
                

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
    // $ANTLR end "rulePRIO"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1080:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1081:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1082:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport2427);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport2437); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1092:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1093:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1093:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1093:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleImport2474); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1097:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1097:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1097:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1097:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1097:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1098:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1098:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1099:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport2497);
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

                    otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleImport2509); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1120:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleImport2528); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1124:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1125:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1125:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1126:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport2546); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1150:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1151:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1152:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN2588);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN2599); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1159:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1162:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1163:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1163:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1164:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN2646);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1174:1: (kw= '.*' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1175:2: kw= '.*'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleImportedFQN2665); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1188:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1189:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1190:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN2708);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN2719); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1197:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1200:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1201:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1201:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1201:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2759); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1208:1: (kw= '.' this_ID_2= RULE_ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==39) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1209:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,39,FOLLOW_39_in_ruleFQN2778); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2793); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
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


    // $ANTLR start "entryRuleTIME"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1229:1: entryRuleTIME returns [String current=null] : iv_ruleTIME= ruleTIME EOF ;
    public final String entryRuleTIME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTIME = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1230:2: (iv_ruleTIME= ruleTIME EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1231:2: iv_ruleTIME= ruleTIME EOF
            {
             newCompositeNode(grammarAccess.getTIMERule()); 
            pushFollow(FOLLOW_ruleTIME_in_entryRuleTIME2841);
            iv_ruleTIME=ruleTIME();

            state._fsp--;

             current =iv_ruleTIME.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTIME2852); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1238:1: ruleTIME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) ;
    public final AntlrDatatypeRuleToken ruleTIME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1241:28: ( ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1242:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1242:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            int alt17=4;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 40:
                    {
                    alt17=1;
                    }
                    break;
                case 43:
                    {
                    alt17=4;
                    }
                    break;
                case 42:
                    {
                    alt17=3;
                    }
                    break;
                case 41:
                    {
                    alt17=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1242:2: (this_INT_0= RULE_INT kw= 's' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1242:2: (this_INT_0= RULE_INT kw= 's' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1242:7: this_INT_0= RULE_INT kw= 's'
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME2893); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleTIME2911); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1256:6: (this_INT_2= RULE_INT kw= 'ms' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1256:6: (this_INT_2= RULE_INT kw= 'ms' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1256:11: this_INT_2= RULE_INT kw= 'ms'
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME2934); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
                        
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleTIME2952); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1270:6: (this_INT_4= RULE_INT kw= 'us' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1270:6: (this_INT_4= RULE_INT kw= 'us' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1270:11: this_INT_4= RULE_INT kw= 'us'
                    {
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME2975); 

                    		current.merge(this_INT_4);
                        
                     
                        newLeafNode(this_INT_4, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
                        
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleTIME2993); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1284:6: (this_INT_6= RULE_INT kw= 'ns' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1284:6: (this_INT_6= RULE_INT kw= 'ns' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1284:11: this_INT_6= RULE_INT kw= 'ns'
                    {
                    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME3016); 

                    		current.merge(this_INT_6);
                        
                     
                        newLeafNode(this_INT_6, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
                        
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleTIME3034); 

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


    // $ANTLR start "ruleExecMode"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1305:1: ruleExecMode returns [Enumerator current=null] : ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) ;
    public final Enumerator ruleExecMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1307:28: ( ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1308:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1308:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt18=1;
                }
                break;
            case 45:
                {
                alt18=2;
                }
                break;
            case 46:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1308:2: (enumLiteral_0= 'polled' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1308:2: (enumLiteral_0= 'polled' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1308:4: enumLiteral_0= 'polled'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_44_in_ruleExecMode3089); 

                            current = grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1314:6: (enumLiteral_1= 'blocked' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1314:6: (enumLiteral_1= 'blocked' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1314:8: enumLiteral_1= 'blocked'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_45_in_ruleExecMode3106); 

                            current = grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1320:6: (enumLiteral_2= 'mixed' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1320:6: (enumLiteral_2= 'mixed' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1320:8: enumLiteral_2= 'mixed'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_46_in_ruleExecMode3123); 

                            current = grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 
                        

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
    // $ANTLR end "ruleExecMode"


    // $ANTLR start "ruleThreadModel"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1330:1: ruleThreadModel returns [Enumerator current=null] : ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) ;
    public final Enumerator ruleThreadModel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1332:28: ( ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1333:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1333:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            else if ( (LA19_0==48) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1333:2: (enumLiteral_0= 'singleThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1333:2: (enumLiteral_0= 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1333:4: enumLiteral_0= 'singleThreaded'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_47_in_ruleThreadModel3168); 

                            current = grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1339:6: (enumLiteral_1= 'multiThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1339:6: (enumLiteral_1= 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1339:8: enumLiteral_1= 'multiThreaded'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_48_in_ruleThreadModel3185); 

                            current = grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleThreadModel"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePhysicalModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePhysicalModel143 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePhysicalModel155 = new BitSet(new long[]{0x0000001040026000L});
    public static final BitSet FOLLOW_ruleImport_in_rulePhysicalModel176 = new BitSet(new long[]{0x0000001040026000L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rulePhysicalModel199 = new BitSet(new long[]{0x0000000040026000L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rulePhysicalModel226 = new BitSet(new long[]{0x0000000040026000L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rulePhysicalModel253 = new BitSet(new long[]{0x0000000040026000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalModel267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalSystem313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rulePhysicalSystem350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalSystem367 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePhysicalSystem393 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePhysicalSystem406 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rulePhysicalSystem427 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalSystem440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleNodeRef523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeRef540 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNodeRef557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeRef580 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeRef601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_entryRuleNodeClass638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeClass648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNodeClass685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeClass702 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeClass728 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNodeClass741 = new BitSet(new long[]{0x0000000000340000L});
    public static final BitSet FOLLOW_18_in_ruleNodeClass799 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeClass834 = new BitSet(new long[]{0x0000000000F42000L});
    public static final BitSet FOLLOW_20_in_ruleNodeClass902 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass914 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass935 = new BitSet(new long[]{0x0000000000F42000L});
    public static final BitSet FOLLOW_21_in_ruleNodeClass1003 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass1015 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass1036 = new BitSet(new long[]{0x0000000000F42000L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_ruleNodeClass1104 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_13_in_ruleNodeClass1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread1153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalThread1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulePhysicalThread1207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_rulePhysicalThread1238 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalThread1256 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePhysicalThread1273 = new BitSet(new long[]{0x000000003F000000L});
    public static final BitSet FOLLOW_24_in_rulePhysicalThread1331 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1343 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_ruleExecMode_in_rulePhysicalThread1364 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_25_in_rulePhysicalThread1432 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1444 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTIME_in_rulePhysicalThread1465 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_26_in_rulePhysicalThread1533 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1545 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_rulePhysicalThread1566 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_27_in_rulePhysicalThread1634 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1663 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_28_in_rulePhysicalThread1736 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1748 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1765 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_29_in_rulePhysicalThread1838 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1850 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1867 = new BitSet(new long[]{0x000000003F002000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalThread1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuntimeClass1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleRuntimeClass2014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuntimeClass2031 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRuntimeClass2057 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRuntimeClass2070 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleRuntimeClass2082 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRuntimeClass2094 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_ruleThreadModel_in_ruleRuntimeClass2115 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRuntimeClass2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation2163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDocumentation2210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation2227 = new BitSet(new long[]{0x0000000200000040L});
    public static final BitSet FOLLOW_33_in_ruleDocumentation2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_entryRulePRIO2288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePRIO2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePRIO2342 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_rulePRIO2361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePRIO2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleImport2474 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport2497 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleImport2509 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31_in_ruleImport2528 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN2588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN2646 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleImportedFQN2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN2708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2759 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleFQN2778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2793 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_entryRuleTIME2841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTIME2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME2893 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTIME2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME2934 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTIME2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME2975 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleTIME2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME3016 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleTIME3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleExecMode3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleExecMode3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleExecMode3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleThreadModel3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleThreadModel3185 = new BitSet(new long[]{0x0000000000000002L});

}
