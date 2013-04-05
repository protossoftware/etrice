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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'DefaultThread'", "'Thread'", "'execmode'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'model'", "'['", "']'", "'+'", "'-'", "'import'", "'from'", "'.*'", "'.'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'"
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=6;
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

                if ( (LA1_0==35) ) {
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
                case 29:
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

            if ( (LA3_0==31) ) {
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

            if ( (LA5_0==31) ) {
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:369:1: ruleNodeClass returns [EObject current=null] : (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'runtime' otherlv_5= '=' ( ( ruleFQN ) ) otherlv_7= 'priomin' otherlv_8= '=' ( (lv_priomin_9_0= rulePRIO ) ) otherlv_10= 'priomax' otherlv_11= '=' ( (lv_priomax_12_0= rulePRIO ) ) ( (lv_threads_13_0= rulePhysicalThread ) )* otherlv_14= '}' ) ;
    public final EObject ruleNodeClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        EObject lv_docu_2_0 = null;

        AntlrDatatypeRuleToken lv_priomin_9_0 = null;

        AntlrDatatypeRuleToken lv_priomax_12_0 = null;

        EObject lv_threads_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:372:28: ( (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'runtime' otherlv_5= '=' ( ( ruleFQN ) ) otherlv_7= 'priomin' otherlv_8= '=' ( (lv_priomin_9_0= rulePRIO ) ) otherlv_10= 'priomax' otherlv_11= '=' ( (lv_priomax_12_0= rulePRIO ) ) ( (lv_threads_13_0= rulePhysicalThread ) )* otherlv_14= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'runtime' otherlv_5= '=' ( ( ruleFQN ) ) otherlv_7= 'priomin' otherlv_8= '=' ( (lv_priomin_9_0= rulePRIO ) ) otherlv_10= 'priomax' otherlv_11= '=' ( (lv_priomax_12_0= rulePRIO ) ) ( (lv_threads_13_0= rulePhysicalThread ) )* otherlv_14= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'runtime' otherlv_5= '=' ( ( ruleFQN ) ) otherlv_7= 'priomin' otherlv_8= '=' ( (lv_priomin_9_0= rulePRIO ) ) otherlv_10= 'priomax' otherlv_11= '=' ( (lv_priomax_12_0= rulePRIO ) ) ( (lv_threads_13_0= rulePhysicalThread ) )* otherlv_14= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:373:3: otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'runtime' otherlv_5= '=' ( ( ruleFQN ) ) otherlv_7= 'priomin' otherlv_8= '=' ( (lv_priomin_9_0= rulePRIO ) ) otherlv_10= 'priomax' otherlv_11= '=' ( (lv_priomax_12_0= rulePRIO ) ) ( (lv_threads_13_0= rulePhysicalThread ) )* otherlv_14= '}'
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

            if ( (LA6_0==31) ) {
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
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleNodeClass753); 

                	newLeafNode(otherlv_4, grammarAccess.getNodeClassAccess().getRuntimeKeyword_4());
                
            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass765); 

                	newLeafNode(otherlv_5, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_5());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:425:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:426:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:426:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:427:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeClassRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleNodeClass788);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleNodeClass800); 

                	newLeafNode(otherlv_7, grammarAccess.getNodeClassAccess().getPriominKeyword_7());
                
            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass812); 

                	newLeafNode(otherlv_8, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_8());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:448:1: ( (lv_priomin_9_0= rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:449:1: (lv_priomin_9_0= rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:449:1: (lv_priomin_9_0= rulePRIO )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:450:3: lv_priomin_9_0= rulePRIO
            {
             
            	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_rulePRIO_in_ruleNodeClass833);
            lv_priomin_9_0=rulePRIO();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	        }
                   		set(
                   			current, 
                   			"priomin",
                    		lv_priomin_9_0, 
                    		"PRIO");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleNodeClass845); 

                	newLeafNode(otherlv_10, grammarAccess.getNodeClassAccess().getPriomaxKeyword_10());
                
            otherlv_11=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass857); 

                	newLeafNode(otherlv_11, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_11());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:474:1: ( (lv_priomax_12_0= rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:475:1: (lv_priomax_12_0= rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:475:1: (lv_priomax_12_0= rulePRIO )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:476:3: lv_priomax_12_0= rulePRIO
            {
             
            	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_12_0()); 
            	    
            pushFollow(FOLLOW_rulePRIO_in_ruleNodeClass878);
            lv_priomax_12_0=rulePRIO();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	        }
                   		set(
                   			current, 
                   			"priomax",
                    		lv_priomax_12_0, 
                    		"PRIO");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:492:2: ( (lv_threads_13_0= rulePhysicalThread ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=22 && LA7_0<=23)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:493:1: (lv_threads_13_0= rulePhysicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:493:1: (lv_threads_13_0= rulePhysicalThread )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:494:3: lv_threads_13_0= rulePhysicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_13_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhysicalThread_in_ruleNodeClass899);
            	    lv_threads_13_0=rulePhysicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_13_0, 
            	            		"PhysicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleNodeClass912); 

                	newLeafNode(otherlv_14, grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_14());
                

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:522:1: entryRulePhysicalThread returns [EObject current=null] : iv_rulePhysicalThread= rulePhysicalThread EOF ;
    public final EObject entryRulePhysicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalThread = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:523:2: (iv_rulePhysicalThread= rulePhysicalThread EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:524:2: iv_rulePhysicalThread= rulePhysicalThread EOF
            {
             newCompositeNode(grammarAccess.getPhysicalThreadRule()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread948);
            iv_rulePhysicalThread=rulePhysicalThread();

            state._fsp--;

             current =iv_rulePhysicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalThread958); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:531:1: rulePhysicalThread returns [EObject current=null] : ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'execmode' otherlv_5= '=' ( (lv_execmode_6_0= ruleExecMode ) ) otherlv_7= 'prio' otherlv_8= '=' ( (lv_prio_9_0= rulePRIO ) ) otherlv_10= 'stacksize' otherlv_11= '=' ( (lv_stacksize_12_0= RULE_INT ) ) otherlv_13= 'msgblocksize' otherlv_14= '=' ( (lv_msgblocksize_15_0= RULE_INT ) ) otherlv_16= 'msgpoolsize' otherlv_17= '=' ( (lv_msgpoolsize_18_0= RULE_INT ) ) otherlv_19= '}' ) ;
    public final EObject rulePhysicalThread() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_stacksize_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_msgblocksize_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_msgpoolsize_18_0=null;
        Token otherlv_19=null;
        Enumerator lv_execmode_6_0 = null;

        AntlrDatatypeRuleToken lv_prio_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:534:28: ( ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'execmode' otherlv_5= '=' ( (lv_execmode_6_0= ruleExecMode ) ) otherlv_7= 'prio' otherlv_8= '=' ( (lv_prio_9_0= rulePRIO ) ) otherlv_10= 'stacksize' otherlv_11= '=' ( (lv_stacksize_12_0= RULE_INT ) ) otherlv_13= 'msgblocksize' otherlv_14= '=' ( (lv_msgblocksize_15_0= RULE_INT ) ) otherlv_16= 'msgpoolsize' otherlv_17= '=' ( (lv_msgpoolsize_18_0= RULE_INT ) ) otherlv_19= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'execmode' otherlv_5= '=' ( (lv_execmode_6_0= ruleExecMode ) ) otherlv_7= 'prio' otherlv_8= '=' ( (lv_prio_9_0= rulePRIO ) ) otherlv_10= 'stacksize' otherlv_11= '=' ( (lv_stacksize_12_0= RULE_INT ) ) otherlv_13= 'msgblocksize' otherlv_14= '=' ( (lv_msgblocksize_15_0= RULE_INT ) ) otherlv_16= 'msgpoolsize' otherlv_17= '=' ( (lv_msgpoolsize_18_0= RULE_INT ) ) otherlv_19= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'execmode' otherlv_5= '=' ( (lv_execmode_6_0= ruleExecMode ) ) otherlv_7= 'prio' otherlv_8= '=' ( (lv_prio_9_0= rulePRIO ) ) otherlv_10= 'stacksize' otherlv_11= '=' ( (lv_stacksize_12_0= RULE_INT ) ) otherlv_13= 'msgblocksize' otherlv_14= '=' ( (lv_msgblocksize_15_0= RULE_INT ) ) otherlv_16= 'msgpoolsize' otherlv_17= '=' ( (lv_msgpoolsize_18_0= RULE_INT ) ) otherlv_19= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'execmode' otherlv_5= '=' ( (lv_execmode_6_0= ruleExecMode ) ) otherlv_7= 'prio' otherlv_8= '=' ( (lv_prio_9_0= rulePRIO ) ) otherlv_10= 'stacksize' otherlv_11= '=' ( (lv_stacksize_12_0= RULE_INT ) ) otherlv_13= 'msgblocksize' otherlv_14= '=' ( (lv_msgblocksize_15_0= RULE_INT ) ) otherlv_16= 'msgpoolsize' otherlv_17= '=' ( (lv_msgpoolsize_18_0= RULE_INT ) ) otherlv_19= '}'
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:535:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:536:1: (lv_default_0_0= 'DefaultThread' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:536:1: (lv_default_0_0= 'DefaultThread' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:537:3: lv_default_0_0= 'DefaultThread'
                    {
                    lv_default_0_0=(Token)match(input,22,FOLLOW_22_in_rulePhysicalThread1002); 

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
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:551:7: otherlv_1= 'Thread'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_rulePhysicalThread1033); 

                        	newLeafNode(otherlv_1, grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:555:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:556:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:556:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:557:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhysicalThread1051); 

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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_rulePhysicalThread1068); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_4=(Token)match(input,24,FOLLOW_24_in_rulePhysicalThread1080); 

                	newLeafNode(otherlv_4, grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3());
                
            otherlv_5=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1092); 

                	newLeafNode(otherlv_5, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_4());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:585:1: ( (lv_execmode_6_0= ruleExecMode ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:586:1: (lv_execmode_6_0= ruleExecMode )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:586:1: (lv_execmode_6_0= ruleExecMode )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:587:3: lv_execmode_6_0= ruleExecMode
            {
             
            	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleExecMode_in_rulePhysicalThread1113);
            lv_execmode_6_0=ruleExecMode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	        }
                   		set(
                   			current, 
                   			"execmode",
                    		lv_execmode_6_0, 
                    		"ExecMode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_25_in_rulePhysicalThread1125); 

                	newLeafNode(otherlv_7, grammarAccess.getPhysicalThreadAccess().getPrioKeyword_6());
                
            otherlv_8=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1137); 

                	newLeafNode(otherlv_8, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_7());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:611:1: ( (lv_prio_9_0= rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:612:1: (lv_prio_9_0= rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:612:1: (lv_prio_9_0= rulePRIO )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:613:3: lv_prio_9_0= rulePRIO
            {
             
            	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_rulePRIO_in_rulePhysicalThread1158);
            lv_prio_9_0=rulePRIO();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	        }
                   		set(
                   			current, 
                   			"prio",
                    		lv_prio_9_0, 
                    		"PRIO");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_10=(Token)match(input,26,FOLLOW_26_in_rulePhysicalThread1170); 

                	newLeafNode(otherlv_10, grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_9());
                
            otherlv_11=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1182); 

                	newLeafNode(otherlv_11, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_10());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:637:1: ( (lv_stacksize_12_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:638:1: (lv_stacksize_12_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:638:1: (lv_stacksize_12_0= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:639:3: lv_stacksize_12_0= RULE_INT
            {
            lv_stacksize_12_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1199); 

            			newLeafNode(lv_stacksize_12_0, grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_11_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"stacksize",
                    		lv_stacksize_12_0, 
                    		"INT");
            	    

            }


            }

            otherlv_13=(Token)match(input,27,FOLLOW_27_in_rulePhysicalThread1216); 

                	newLeafNode(otherlv_13, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_12());
                
            otherlv_14=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1228); 

                	newLeafNode(otherlv_14, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_13());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:663:1: ( (lv_msgblocksize_15_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:664:1: (lv_msgblocksize_15_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:664:1: (lv_msgblocksize_15_0= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:665:3: lv_msgblocksize_15_0= RULE_INT
            {
            lv_msgblocksize_15_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1245); 

            			newLeafNode(lv_msgblocksize_15_0, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_14_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"msgblocksize",
                    		lv_msgblocksize_15_0, 
                    		"INT");
            	    

            }


            }

            otherlv_16=(Token)match(input,28,FOLLOW_28_in_rulePhysicalThread1262); 

                	newLeafNode(otherlv_16, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_15());
                
            otherlv_17=(Token)match(input,19,FOLLOW_19_in_rulePhysicalThread1274); 

                	newLeafNode(otherlv_17, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_16());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:689:1: ( (lv_msgpoolsize_18_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:690:1: (lv_msgpoolsize_18_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:690:1: (lv_msgpoolsize_18_0= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:691:3: lv_msgpoolsize_18_0= RULE_INT
            {
            lv_msgpoolsize_18_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhysicalThread1291); 

            			newLeafNode(lv_msgpoolsize_18_0, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_17_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"msgpoolsize",
                    		lv_msgpoolsize_18_0, 
                    		"INT");
            	    

            }


            }

            otherlv_19=(Token)match(input,13,FOLLOW_13_in_rulePhysicalThread1308); 

                	newLeafNode(otherlv_19, grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_18());
                

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:719:1: entryRuleRuntimeClass returns [EObject current=null] : iv_ruleRuntimeClass= ruleRuntimeClass EOF ;
    public final EObject entryRuleRuntimeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuntimeClass = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:720:2: (iv_ruleRuntimeClass= ruleRuntimeClass EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:721:2: iv_ruleRuntimeClass= ruleRuntimeClass EOF
            {
             newCompositeNode(grammarAccess.getRuntimeClassRule()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass1344);
            iv_ruleRuntimeClass=ruleRuntimeClass();

            state._fsp--;

             current =iv_ruleRuntimeClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuntimeClass1354); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:728:1: ruleRuntimeClass returns [EObject current=null] : (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) ;
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
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:731:28: ( (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:732:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:732:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:732:3: otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleRuntimeClass1391); 

                	newLeafNode(otherlv_0, grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:736:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:737:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:737:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:738:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuntimeClass1408); 

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

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:754:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==31) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:755:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:755:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:756:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRuntimeClass1434);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRuntimeClass1447); 

                	newLeafNode(otherlv_3, grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleRuntimeClass1459); 

                	newLeafNode(otherlv_4, grammarAccess.getRuntimeClassAccess().getModelKeyword_4());
                
            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleRuntimeClass1471); 

                	newLeafNode(otherlv_5, grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:784:1: ( (lv_threadModel_6_0= ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:785:1: (lv_threadModel_6_0= ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:785:1: (lv_threadModel_6_0= ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:786:3: lv_threadModel_6_0= ruleThreadModel
            {
             
            	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleThreadModel_in_ruleRuntimeClass1492);
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

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleRuntimeClass1504); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:814:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:815:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:816:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation1540);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation1550); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:823:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:826:28: ( (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:827:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:827:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:827:3: otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDocumentation1587); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:831:1: ( (lv_text_1_0= RULE_STRING ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_STRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:832:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:832:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:833:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation1604); 

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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleDocumentation1622); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:861:1: entryRulePRIO returns [String current=null] : iv_rulePRIO= rulePRIO EOF ;
    public final String entryRulePRIO() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRIO = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:865:2: (iv_rulePRIO= rulePRIO EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:866:2: iv_rulePRIO= rulePRIO EOF
            {
             newCompositeNode(grammarAccess.getPRIORule()); 
            pushFollow(FOLLOW_rulePRIO_in_entryRulePRIO1665);
            iv_rulePRIO=rulePRIO();

            state._fsp--;

             current =iv_rulePRIO.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePRIO1676); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:876:1: rulePRIO returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken rulePRIO() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:880:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:881:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:881:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:881:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:881:2: (kw= '+' | kw= '-' )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==33) ) {
                alt11=1;
            }
            else if ( (LA11_0==34) ) {
                alt11=2;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:882:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_rulePRIO1719); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:889:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_rulePRIO1738); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePRIO1755); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:912:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:913:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:914:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport1804);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport1814); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:921:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:924:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:925:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:925:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:925:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleImport1851); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:929:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==30) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:929:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:929:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:929:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:929:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:930:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:930:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:931:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport1874);
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

                    otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleImport1886); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:952:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleImport1905); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:956:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:957:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:957:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:958:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport1923); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:982:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:983:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:984:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1965);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN1976); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:991:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:994:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:995:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:995:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:996:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN2023);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1006:1: (kw= '.*' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1007:2: kw= '.*'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleImportedFQN2042); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1020:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1021:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1022:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN2085);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN2096); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1029:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1032:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1033:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1033:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1033:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2136); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1040:1: (kw= '.' this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==38) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1041:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleFQN2155); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN2170); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
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


    // $ANTLR start "ruleExecMode"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1061:1: ruleExecMode returns [Enumerator current=null] : ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) ;
    public final Enumerator ruleExecMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1063:28: ( ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1064:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1064:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt15=1;
                }
                break;
            case 40:
                {
                alt15=2;
                }
                break;
            case 41:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1064:2: (enumLiteral_0= 'polled' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1064:2: (enumLiteral_0= 'polled' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1064:4: enumLiteral_0= 'polled'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_39_in_ruleExecMode2231); 

                            current = grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1070:6: (enumLiteral_1= 'blocked' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1070:6: (enumLiteral_1= 'blocked' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1070:8: enumLiteral_1= 'blocked'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_40_in_ruleExecMode2248); 

                            current = grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1076:6: (enumLiteral_2= 'mixed' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1076:6: (enumLiteral_2= 'mixed' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1076:8: enumLiteral_2= 'mixed'
                    {
                    enumLiteral_2=(Token)match(input,41,FOLLOW_41_in_ruleExecMode2265); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1086:1: ruleThreadModel returns [Enumerator current=null] : ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) ;
    public final Enumerator ruleThreadModel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1088:28: ( ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            else if ( (LA16_0==43) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:2: (enumLiteral_0= 'singleThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:2: (enumLiteral_0= 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1089:4: enumLiteral_0= 'singleThreaded'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_42_in_ruleThreadModel2310); 

                            current = grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1095:6: (enumLiteral_1= 'multiThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1095:6: (enumLiteral_1= 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1095:8: enumLiteral_1= 'multiThreaded'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_43_in_ruleThreadModel2327); 

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
    public static final BitSet FOLLOW_12_in_rulePhysicalModel155 = new BitSet(new long[]{0x0000000820026000L});
    public static final BitSet FOLLOW_ruleImport_in_rulePhysicalModel176 = new BitSet(new long[]{0x0000000820026000L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rulePhysicalModel199 = new BitSet(new long[]{0x0000000020026000L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rulePhysicalModel226 = new BitSet(new long[]{0x0000000020026000L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rulePhysicalModel253 = new BitSet(new long[]{0x0000000020026000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalModel267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalSystem313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rulePhysicalSystem350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalSystem367 = new BitSet(new long[]{0x0000000080001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePhysicalSystem393 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePhysicalSystem406 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rulePhysicalSystem427 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalSystem440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleNodeRef523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeRef540 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNodeRef557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeRef580 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeRef601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_entryRuleNodeClass638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeClass648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNodeClass685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeClass702 = new BitSet(new long[]{0x0000000080001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeClass728 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNodeClass741 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNodeClass753 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeClass788 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleNodeClass800 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass812 = new BitSet(new long[]{0x0000000600000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass833 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNodeClass845 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass857 = new BitSet(new long[]{0x0000000600000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass878 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_ruleNodeClass899 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_13_in_ruleNodeClass912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalThread958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulePhysicalThread1002 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_rulePhysicalThread1033 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalThread1051 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePhysicalThread1068 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePhysicalThread1080 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1092 = new BitSet(new long[]{0x0000038000000000L});
    public static final BitSet FOLLOW_ruleExecMode_in_rulePhysicalThread1113 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePhysicalThread1125 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1137 = new BitSet(new long[]{0x0000000600000020L});
    public static final BitSet FOLLOW_rulePRIO_in_rulePhysicalThread1158 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePhysicalThread1170 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1199 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePhysicalThread1216 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1245 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePhysicalThread1262 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePhysicalThread1274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1291 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePhysicalThread1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass1344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuntimeClass1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleRuntimeClass1391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuntimeClass1408 = new BitSet(new long[]{0x0000000080001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRuntimeClass1434 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRuntimeClass1447 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleRuntimeClass1459 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRuntimeClass1471 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_ruleThreadModel_in_ruleRuntimeClass1492 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRuntimeClass1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation1540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDocumentation1587 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation1604 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_32_in_ruleDocumentation1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_entryRulePRIO1665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePRIO1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePRIO1719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_34_in_rulePRIO1738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePRIO1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport1804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleImport1851 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport1874 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleImport1886 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30_in_ruleImport1905 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN1965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN2023 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleImportedFQN2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN2085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2136 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleFQN2155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN2170 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_39_in_ruleExecMode2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleExecMode2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleExecMode2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleThreadModel2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleThreadModel2327 = new BitSet(new long[]{0x0000000000000002L});

}
