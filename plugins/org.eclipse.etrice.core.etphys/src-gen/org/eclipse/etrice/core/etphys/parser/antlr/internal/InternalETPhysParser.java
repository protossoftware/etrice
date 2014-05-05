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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'DefaultThread'", "'Thread'", "'execmode'", "'interval'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'model'", "'+'", "'-'", "'optional'", "'mandatory'", "'attribute'", "','", "'import'", "'from'", "'.*'", "'['", "']'", "'s'", "'ms'", "'us'", "'ns'", "'false'", "'true'", "'.'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_EXP=8;
    public static final int RULE_ID=4;
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
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=7;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
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
    public static final int RULE_WS=11;

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
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePhysicalModel122); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePhysicalModel155); 

                	newLeafNode(otherlv_2, grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:107:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==40) ) {
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
                case 16:
                    {
                    alt2=1;
                    }
                    break;
                case 19:
                    {
                    alt2=2;
                    }
                    break;
                case 32:
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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_rulePhysicalModel267); 

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
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_rulePhysicalSystem350); 

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

            if ( (LA3_0==43) ) {
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_rulePhysicalSystem406); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:250:1: ( (lv_nodeRefs_4_0= ruleNodeRef ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_rulePhysicalSystem440); 

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
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleNodeRef523); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleNodeRef557); 

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

            if ( (LA5_0==43) ) {
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
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleNodeClass685); 

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

            if ( (LA6_0==43) ) {
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleNodeClass741); 

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

                if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
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
            	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleNodeClass799); 

            	        	newLeafNode(otherlv_5, grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0());
            	        
            	    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleNodeClass811); 

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
            	    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleNodeClass902); 

            	        	newLeafNode(otherlv_8, grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0());
            	        
            	    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleNodeClass914); 

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
            	    otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleNodeClass1003); 

            	        	newLeafNode(otherlv_11, grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0());
            	        
            	    otherlv_12=(Token)match(input,21,FOLLOW_21_in_ruleNodeClass1015); 

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

                if ( ((LA8_0>=24 && LA8_0<=25)) ) {
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

            otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleNodeClass1117); 

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

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            else if ( (LA9_0==25) ) {
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
                    lv_default_0_0=(Token)match(input,24,FOLLOW_24_in_rulePhysicalThread1207); 

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
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_rulePhysicalThread1238); 

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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_rulePhysicalThread1273); 

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

                if ( LA10_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                    alt10=2;
                }
                else if ( LA10_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                    alt10=3;
                }
                else if ( LA10_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                    alt10=4;
                }
                else if ( LA10_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                    alt10=5;
                }
                else if ( LA10_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
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
            	    otherlv_5=(Token)match(input,26,FOLLOW_26_in_rulePhysicalThread1331); 

            	        	newLeafNode(otherlv_5, grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0());
            	        
            	    otherlv_6=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1343); 

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
            	    otherlv_8=(Token)match(input,27,FOLLOW_27_in_rulePhysicalThread1432); 

            	        	newLeafNode(otherlv_8, grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0());
            	        
            	    otherlv_9=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1444); 

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
            	    otherlv_11=(Token)match(input,28,FOLLOW_28_in_rulePhysicalThread1533); 

            	        	newLeafNode(otherlv_11, grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0());
            	        
            	    otherlv_12=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1545); 

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
            	    otherlv_14=(Token)match(input,29,FOLLOW_29_in_rulePhysicalThread1634); 

            	        	newLeafNode(otherlv_14, grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0());
            	        
            	    otherlv_15=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1646); 

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
            	    otherlv_17=(Token)match(input,30,FOLLOW_30_in_rulePhysicalThread1736); 

            	        	newLeafNode(otherlv_17, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0());
            	        
            	    otherlv_18=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1748); 

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
            	    otherlv_20=(Token)match(input,31,FOLLOW_31_in_rulePhysicalThread1838); 

            	        	newLeafNode(otherlv_20, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0());
            	        
            	    otherlv_21=(Token)match(input,21,FOLLOW_21_in_rulePhysicalThread1850); 

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

            otherlv_23=(Token)match(input,15,FOLLOW_15_in_rulePhysicalThread1931); 

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
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleRuntimeClass2014); 

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

            if ( (LA11_0==43) ) {
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleRuntimeClass2070); 

                	newLeafNode(otherlv_3, grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleRuntimeClass2082); 

                	newLeafNode(otherlv_4, grammarAccess.getRuntimeClassAccess().getModelKeyword_4());
                
            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleRuntimeClass2094); 

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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleRuntimeClass2127); 

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


    // $ANTLR start "entryRulePRIO"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:982:1: entryRulePRIO returns [String current=null] : iv_rulePRIO= rulePRIO EOF ;
    public final String entryRulePRIO() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePRIO = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:986:2: (iv_rulePRIO= rulePRIO EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:987:2: iv_rulePRIO= rulePRIO EOF
            {
             newCompositeNode(grammarAccess.getPRIORule()); 
            pushFollow(FOLLOW_rulePRIO_in_entryRulePRIO2170);
            iv_rulePRIO=rulePRIO();

            state._fsp--;

             current =iv_rulePRIO.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePRIO2181); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:997:1: rulePRIO returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken rulePRIO() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1001:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1002:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1002:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1002:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1002:2: (kw= '+' | kw= '-' )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==34) ) {
                alt12=1;
            }
            else if ( (LA12_0==35) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1003:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_rulePRIO2224); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1010:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_rulePRIO2243); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePRIO2260); 

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


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1035:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1036:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1037:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue2311);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue2321); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1044:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1047:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1048:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1048:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1048:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1048:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1049:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1050:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue2363); 

            			newLeafNode(lv_key_0_0, grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleKeyValue2380); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1070:1: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1071:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1071:1: (lv_value_2_0= ruleLiteral )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1072:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleKeyValue2401);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Literal");
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1098:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1099:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1100:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType2440);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType2451); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1107:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1110:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1111:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType2490); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1126:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1127:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1128:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute2534);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute2544); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1135:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1138:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1139:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1139:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==36) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==38) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==RULE_ID) ) {
                        int LA13_4 = input.LA(4);

                        if ( (LA13_4==18) ) {
                            int LA13_5 = input.LA(5);

                            if ( ((LA13_5>=57 && LA13_5<=60)) ) {
                                alt13=1;
                            }
                            else if ( (LA13_5==14) ) {
                                alt13=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==37) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==38) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==RULE_ID) ) {
                        int LA13_4 = input.LA(4);

                        if ( (LA13_4==18) ) {
                            int LA13_5 = input.LA(5);

                            if ( ((LA13_5>=57 && LA13_5<=60)) ) {
                                alt13=1;
                            }
                            else if ( (LA13_5==14) ) {
                                alt13=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1140:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute2591);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1150:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute2618);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1166:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1167:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1168:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute2653);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute2663); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1175:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1178:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==36) ) {
                alt14=1;
            }
            else if ( (LA14_0==37) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1179:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1180:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1180:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1181:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,36,FOLLOW_36_in_ruleSimpleAnnotationAttribute2707); 

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
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1195:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSimpleAnnotationAttribute2738); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleSimpleAnnotationAttribute2751); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1203:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1204:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1204:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1205:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute2768); 

            			newLeafNode(lv_name_3_0, grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleSimpleAnnotationAttribute2785); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1225:1: ( (lv_type_5_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1226:1: (lv_type_5_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1226:1: (lv_type_5_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1227:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute2806);
            lv_type_5_0=ruleLiteralType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleAnnotationAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_5_0, 
                    		"LiteralType");
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1251:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1252:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1253:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute2842);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute2852); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1260:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1263:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36) ) {
                alt15=1;
            }
            else if ( (LA15_0==37) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1264:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1265:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1265:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1266:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,36,FOLLOW_36_in_ruleEnumAnnotationAttribute2896); 

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
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1280:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleEnumAnnotationAttribute2927); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleEnumAnnotationAttribute2940); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1288:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1289:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1289:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1290:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute2957); 

            			newLeafNode(lv_name_3_0, grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleEnumAnnotationAttribute2974); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleEnumAnnotationAttribute2986); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1314:1: ( (lv_values_6_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1315:1: (lv_values_6_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1315:1: (lv_values_6_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1316:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute3003); 

            			newLeafNode(lv_values_6_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"values",
                    		lv_values_6_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1332:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==39) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1332:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleEnumAnnotationAttribute3021); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1336:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1337:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1337:1: (lv_values_8_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1338:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute3038); 

            	    			newLeafNode(lv_values_8_0, grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"values",
            	            		lv_values_8_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleEnumAnnotationAttribute3057); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1366:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1367:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1368:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport3093);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport3103); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1375:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1378:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1379:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1379:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1379:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleImport3140); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1383:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==33) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1383:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1383:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1383:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1383:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1384:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1384:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1385:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport3163);
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

                    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleImport3175); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1406:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleImport3194); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1410:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1411:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1411:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1412:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport3212); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1436:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1437:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1438:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3254);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN3265); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1445:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1448:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1449:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1449:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1450:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN3312);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1460:1: (kw= '.*' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==42) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1461:2: kw= '.*'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleImportedFQN3331); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1474:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1475:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1476:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation3373);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation3383); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1483:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1486:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1487:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1487:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1487:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1487:2: ()
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1488:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleDocumentation3429); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1497:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1498:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1498:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1499:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation3446); 

            	    			newLeafNode(lv_lines_2_0, grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDocumentationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"lines",
            	            		lv_lines_2_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleDocumentation3464); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1527:1: entryRuleTIME returns [String current=null] : iv_ruleTIME= ruleTIME EOF ;
    public final String entryRuleTIME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTIME = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1528:2: (iv_ruleTIME= ruleTIME EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1529:2: iv_ruleTIME= ruleTIME EOF
            {
             newCompositeNode(grammarAccess.getTIMERule()); 
            pushFollow(FOLLOW_ruleTIME_in_entryRuleTIME3501);
            iv_ruleTIME=ruleTIME();

            state._fsp--;

             current =iv_ruleTIME.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTIME3512); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1536:1: ruleTIME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) ;
    public final AntlrDatatypeRuleToken ruleTIME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1539:28: ( ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1540:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1540:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            int alt20=4;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 48:
                    {
                    alt20=4;
                    }
                    break;
                case 45:
                    {
                    alt20=1;
                    }
                    break;
                case 46:
                    {
                    alt20=2;
                    }
                    break;
                case 47:
                    {
                    alt20=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1540:2: (this_INT_0= RULE_INT kw= 's' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1540:2: (this_INT_0= RULE_INT kw= 's' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1540:7: this_INT_0= RULE_INT kw= 's'
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME3553); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleTIME3571); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1554:6: (this_INT_2= RULE_INT kw= 'ms' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1554:6: (this_INT_2= RULE_INT kw= 'ms' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1554:11: this_INT_2= RULE_INT kw= 'ms'
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME3594); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
                        
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleTIME3612); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1568:6: (this_INT_4= RULE_INT kw= 'us' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1568:6: (this_INT_4= RULE_INT kw= 'us' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1568:11: this_INT_4= RULE_INT kw= 'us'
                    {
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME3635); 

                    		current.merge(this_INT_4);
                        
                     
                        newLeafNode(this_INT_4, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
                        
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleTIME3653); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1582:6: (this_INT_6= RULE_INT kw= 'ns' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1582:6: (this_INT_6= RULE_INT kw= 'ns' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1582:11: this_INT_6= RULE_INT kw= 'ns'
                    {
                    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTIME3676); 

                    		current.merge(this_INT_6);
                        
                     
                        newLeafNode(this_INT_6, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
                        
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleTIME3694); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1605:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1606:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1607:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3737);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3747); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1614:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1617:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1618:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1618:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 49:
            case 50:
                {
                alt21=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 34:
            case 35:
            case 51:
                {
                alt21=2;
                }
                break;
            case RULE_STRING:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1619:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral3794);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1629:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3821);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1639:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral3848);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1655:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1656:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1657:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3883);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral3893); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1664:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1667:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1668:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1668:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1668:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1668:2: ()
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1669:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1674:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==49) ) {
                alt22=1;
            }
            else if ( (LA22_0==50) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1674:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleBooleanLiteral3940); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1679:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1679:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1680:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1680:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1681:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,50,FOLLOW_50_in_ruleBooleanLiteral3964); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1702:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1703:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1704:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral4014);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral4024); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1711:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1714:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1715:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1715:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt23=2;
            switch ( input.LA(1) ) {
            case 34:
                {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==RULE_INT) ) {
                    int LA23_3 = input.LA(3);

                    if ( (LA23_3==51) ) {
                        alt23=2;
                    }
                    else if ( (LA23_3==EOF) ) {
                        alt23=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA23_1==51) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==RULE_INT) ) {
                    int LA23_3 = input.LA(3);

                    if ( (LA23_3==51) ) {
                        alt23=2;
                    }
                    else if ( (LA23_3==EOF) ) {
                        alt23=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA23_2==51) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA23_3 = input.LA(2);

                if ( (LA23_3==51) ) {
                    alt23=2;
                }
                else if ( (LA23_3==EOF) ) {
                    alt23=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt23=1;
                }
                break;
            case 51:
                {
                alt23=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1716:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral4071);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1726:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral4098);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1742:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1743:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1744:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral4133);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral4143); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1751:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1754:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1755:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1755:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1755:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1755:2: ()
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1756:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1761:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1762:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1762:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1763:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral4198);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1787:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1788:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1789:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral4234);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral4244); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1796:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1799:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1800:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1800:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1800:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1800:2: ()
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1801:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1806:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1807:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1807:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1808:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral4299);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1832:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1833:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1834:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4335);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral4345); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1841:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1844:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1845:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1845:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1845:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1845:2: ()
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1846:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1851:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1852:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1852:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1853:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral4396); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1877:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1878:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1879:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger4438);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger4449); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1886:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1889:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1890:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1890:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT||(LA24_0>=34 && LA24_0<=35)) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_HEX) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1891:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger4496);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1903:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger4529);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1921:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1925:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1926:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4581);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger4592); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1936:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1940:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1941:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1941:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1941:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1941:2: (kw= '+' | kw= '-' )?
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            else if ( (LA25_0==35) ) {
                alt25=2;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1942:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleSignedInteger4635); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1949:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleSignedInteger4654); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger4671); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1972:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1976:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1977:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4727);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal4738); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1987:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1991:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:1992:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal4781); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2010:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2011:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2012:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal4830);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal4841); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2019:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2022:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2023:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2023:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt26=4;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2024:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal4888);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2036:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal4921);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2048:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal4954);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2060:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal4987);
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2078:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2082:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2083:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal5039);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal5050); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2093:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2097:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2098:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2098:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2098:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2098:2: (kw= '+' | kw= '-' )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            else if ( (LA27_0==35) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2099:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDecimal5093); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2106:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleDecimal5112); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal5129); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,51,FOLLOW_51_in_ruleDecimal5147); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal5162); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2142:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2146:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2147:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal5218);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal5229); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2157:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2161:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2162:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2162:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2162:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2162:2: (kw= '+' | kw= '-' )?
            int alt28=3;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            else if ( (LA28_0==35) ) {
                alt28=2;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2163:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDotDecimal5272); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2170:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleDotDecimal5291); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,51,FOLLOW_51_in_ruleDotDecimal5306); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal5321); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2199:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2203:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2204:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5377);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot5388); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2214:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2218:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2219:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2219:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2219:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2219:2: (kw= '+' | kw= '-' )?
            int alt29=3;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            else if ( (LA29_0==35) ) {
                alt29=2;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2220:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDecimalDot5431); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2227:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleDecimalDot5450); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot5467); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,51,FOLLOW_51_in_ruleDecimalDot5485); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2256:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2260:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2261:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5536);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp5547); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2271:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2275:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2276:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2276:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2276:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2276:2: (kw= '+' | kw= '-' )?
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                alt30=1;
            }
            else if ( (LA30_0==35) ) {
                alt30=2;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2277:2: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDecimalExp5590); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2284:2: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleDecimalExp5609); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5626); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,51,FOLLOW_51_in_ruleDecimalExp5644); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp5659); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp5679); 

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


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2327:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2328:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2329:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN5729);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN5740); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2336:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2339:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2340:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2340:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2340:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN5780); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2347:1: (kw= '.' this_ID_2= RULE_ID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==51) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2348:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,51,FOLLOW_51_in_ruleFQN5799); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN5814); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2368:1: ruleExecMode returns [Enumerator current=null] : ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) ;
    public final Enumerator ruleExecMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2370:28: ( ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2371:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2371:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt32=1;
                }
                break;
            case 53:
                {
                alt32=2;
                }
                break;
            case 54:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2371:2: (enumLiteral_0= 'polled' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2371:2: (enumLiteral_0= 'polled' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2371:4: enumLiteral_0= 'polled'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_52_in_ruleExecMode5875); 

                            current = grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2377:6: (enumLiteral_1= 'blocked' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2377:6: (enumLiteral_1= 'blocked' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2377:8: enumLiteral_1= 'blocked'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_53_in_ruleExecMode5892); 

                            current = grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2383:6: (enumLiteral_2= 'mixed' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2383:6: (enumLiteral_2= 'mixed' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2383:8: enumLiteral_2= 'mixed'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_54_in_ruleExecMode5909); 

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
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2393:1: ruleThreadModel returns [Enumerator current=null] : ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) ;
    public final Enumerator ruleThreadModel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2395:28: ( ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2396:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2396:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==55) ) {
                alt33=1;
            }
            else if ( (LA33_0==56) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2396:2: (enumLiteral_0= 'singleThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2396:2: (enumLiteral_0= 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2396:4: enumLiteral_0= 'singleThreaded'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_55_in_ruleThreadModel5954); 

                            current = grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2402:6: (enumLiteral_1= 'multiThreaded' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2402:6: (enumLiteral_1= 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2402:8: enumLiteral_1= 'multiThreaded'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_56_in_ruleThreadModel5971); 

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


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2412:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2414:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2415:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2415:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt34=1;
                }
                break;
            case 58:
                {
                alt34=2;
                }
                break;
            case 59:
                {
                alt34=3;
                }
                break;
            case 60:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2415:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2415:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2415:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_57_in_ruleLiteralType6016); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2421:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2421:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2421:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_58_in_ruleLiteralType6033); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2427:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2427:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2427:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_59_in_ruleLiteralType6050); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2433:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2433:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.etphys/src-gen/org/eclipse/etrice/core/etphys/parser/antlr/internal/InternalETPhys.g:2433:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_60_in_ruleLiteralType6067); 

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


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\12\uffff";
    static final String DFA26_eofS =
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA26_minS =
        "\3\5\1\63\1\uffff\1\5\1\10\3\uffff";
    static final String DFA26_maxS =
        "\4\63\1\uffff\1\5\1\10\3\uffff";
    static final String DFA26_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA26_specialS =
        "\12\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\3\34\uffff\1\1\1\2\17\uffff\1\4",
            "\1\3\55\uffff\1\4",
            "\1\3\55\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "2023:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePhysicalModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePhysicalModel143 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePhysicalModel155 = new BitSet(new long[]{0x0000010100098000L});
    public static final BitSet FOLLOW_ruleImport_in_rulePhysicalModel176 = new BitSet(new long[]{0x0000010100098000L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rulePhysicalModel199 = new BitSet(new long[]{0x0000000100098000L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rulePhysicalModel226 = new BitSet(new long[]{0x0000000100098000L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rulePhysicalModel253 = new BitSet(new long[]{0x0000000100098000L});
    public static final BitSet FOLLOW_15_in_rulePhysicalModel267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalSystem313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePhysicalSystem350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalSystem367 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePhysicalSystem393 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePhysicalSystem406 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rulePhysicalSystem427 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_rulePhysicalSystem440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNodeRef523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeRef540 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNodeRef557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeRef580 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeRef601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_entryRuleNodeClass638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeClass648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleNodeClass685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeClass702 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleNodeClass728 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNodeClass741 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_ruleNodeClass799 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNodeClass811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNodeClass834 = new BitSet(new long[]{0x0000000003D08000L});
    public static final BitSet FOLLOW_22_in_ruleNodeClass902 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNodeClass914 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass935 = new BitSet(new long[]{0x0000000003D08000L});
    public static final BitSet FOLLOW_23_in_ruleNodeClass1003 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNodeClass1015 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_ruleNodeClass1036 = new BitSet(new long[]{0x0000000003D08000L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_ruleNodeClass1104 = new BitSet(new long[]{0x0000000003008000L});
    public static final BitSet FOLLOW_15_in_ruleNodeClass1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread1153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalThread1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rulePhysicalThread1207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_25_in_rulePhysicalThread1238 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhysicalThread1256 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePhysicalThread1273 = new BitSet(new long[]{0x00000000FC000000L});
    public static final BitSet FOLLOW_26_in_rulePhysicalThread1331 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1343 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_ruleExecMode_in_rulePhysicalThread1364 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_27_in_rulePhysicalThread1432 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1444 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTIME_in_rulePhysicalThread1465 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_28_in_rulePhysicalThread1533 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1545 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_rulePRIO_in_rulePhysicalThread1566 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_29_in_rulePhysicalThread1634 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1663 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_30_in_rulePhysicalThread1736 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1748 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1765 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_31_in_rulePhysicalThread1838 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePhysicalThread1850 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhysicalThread1867 = new BitSet(new long[]{0x00000000FC008000L});
    public static final BitSet FOLLOW_15_in_rulePhysicalThread1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuntimeClass1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRuntimeClass2014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuntimeClass2031 = new BitSet(new long[]{0x0000080000004000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRuntimeClass2057 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRuntimeClass2070 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleRuntimeClass2082 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRuntimeClass2094 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_ruleThreadModel_in_ruleRuntimeClass2115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRuntimeClass2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_entryRulePRIO2170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePRIO2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePRIO2224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_rulePRIO2243 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePRIO2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue2311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue2363 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleKeyValue2380 = new BitSet(new long[]{0x000E000C000000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType2440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute2534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute2653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSimpleAnnotationAttribute2707 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37_in_ruleSimpleAnnotationAttribute2738 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSimpleAnnotationAttribute2751 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute2768 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleAnnotationAttribute2785 = new BitSet(new long[]{0x1E00000000000000L});
    public static final BitSet FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute2842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleEnumAnnotationAttribute2896 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37_in_ruleEnumAnnotationAttribute2927 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleEnumAnnotationAttribute2940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute2957 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEnumAnnotationAttribute2974 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEnumAnnotationAttribute2986 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute3003 = new BitSet(new long[]{0x0000008000008000L});
    public static final BitSet FOLLOW_39_in_ruleEnumAnnotationAttribute3021 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute3038 = new BitSet(new long[]{0x0000008000008000L});
    public static final BitSet FOLLOW_15_in_ruleEnumAnnotationAttribute3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport3093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleImport3140 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport3163 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleImport3175 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_33_in_ruleImport3194 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN3254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN3312 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleImportedFQN3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation3373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDocumentation3429 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation3446 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_44_in_ruleDocumentation3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_entryRuleTIME3501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTIME3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME3553 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTIME3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME3594 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleTIME3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME3635 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleTIME3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTIME3676 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleTIME3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleBooleanLiteral3940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleBooleanLiteral3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral4014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral4133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral4234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger4438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger4581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleSignedInteger4635 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_ruleSignedInteger4654 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger4671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal4727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal4738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal4830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal5039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal5050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDecimal5093 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_ruleDecimal5112 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal5129 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleDecimal5147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal5218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDotDecimal5272 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_35_in_ruleDotDecimal5291 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleDotDecimal5306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal5321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot5377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDecimalDot5431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_ruleDecimalDot5450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot5467 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleDecimalDot5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp5536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDecimalExp5590 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_ruleDecimalExp5609 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5626 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleDecimalExp5644 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp5659 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN5729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN5740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN5780 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleFQN5799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN5814 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_52_in_ruleExecMode5875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleExecMode5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleExecMode5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleThreadModel5954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleThreadModel5971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleLiteralType6016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleLiteralType6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleLiteralType6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleLiteralType6067 = new BitSet(new long[]{0x0000000000000002L});

}
