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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'DefaultThread'", "'Thread'", "'execmode'", "'interval'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'model'", "'optional'", "'mandatory'", "'attribute'", "','", "'import'", "'from'", "'.*'", "'['", "']'", "'s'", "'ms'", "'us'", "'ns'", "'false'", "'true'", "'+'", "'-'", "'.'", "'e'", "'E'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
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


        public InternalETPhysParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETPhysParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETPhysParser.tokenNames; }
    public String getGrammarFileName() { return "InternalETPhys.g"; }



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
    // InternalETPhys.g:68:1: entryRulePhysicalModel returns [EObject current=null] : iv_rulePhysicalModel= rulePhysicalModel EOF ;
    public final EObject entryRulePhysicalModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalModel = null;


        try {
            // InternalETPhys.g:69:2: (iv_rulePhysicalModel= rulePhysicalModel EOF )
            // InternalETPhys.g:70:2: iv_rulePhysicalModel= rulePhysicalModel EOF
            {
             newCompositeNode(grammarAccess.getPhysicalModelRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicalModel=rulePhysicalModel();

            state._fsp--;

             current =iv_rulePhysicalModel; 
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
    // $ANTLR end "entryRulePhysicalModel"


    // $ANTLR start "rulePhysicalModel"
    // InternalETPhys.g:77:1: rulePhysicalModel returns [EObject current=null] : (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' ) ;
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
            // InternalETPhys.g:80:28: ( (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' ) )
            // InternalETPhys.g:81:1: (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' )
            {
            // InternalETPhys.g:81:1: (otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}' )
            // InternalETPhys.g:81:3: otherlv_0= 'PhysicalModel' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0());
                
            // InternalETPhys.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalETPhys.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // InternalETPhys.g:86:1: (lv_name_1_0= ruleFQN )
            // InternalETPhys.g:87:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
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

                	newLeafNode(otherlv_2, grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalETPhys.g:107:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==37) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalETPhys.g:108:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalETPhys.g:108:1: (lv_imports_3_0= ruleImport )
            	    // InternalETPhys.g:109:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
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

            // InternalETPhys.g:125:3: ( ( (lv_systems_4_0= rulePhysicalSystem ) ) | ( (lv_nodeClasses_5_0= ruleNodeClass ) ) | ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt2=1;
                    }
                    break;
                case 18:
                    {
                    alt2=2;
                    }
                    break;
                case 31:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalETPhys.g:125:4: ( (lv_systems_4_0= rulePhysicalSystem ) )
            	    {
            	    // InternalETPhys.g:125:4: ( (lv_systems_4_0= rulePhysicalSystem ) )
            	    // InternalETPhys.g:126:1: (lv_systems_4_0= rulePhysicalSystem )
            	    {
            	    // InternalETPhys.g:126:1: (lv_systems_4_0= rulePhysicalSystem )
            	    // InternalETPhys.g:127:3: lv_systems_4_0= rulePhysicalSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_systems_4_0=rulePhysicalSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_4_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.PhysicalSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalETPhys.g:144:6: ( (lv_nodeClasses_5_0= ruleNodeClass ) )
            	    {
            	    // InternalETPhys.g:144:6: ( (lv_nodeClasses_5_0= ruleNodeClass ) )
            	    // InternalETPhys.g:145:1: (lv_nodeClasses_5_0= ruleNodeClass )
            	    {
            	    // InternalETPhys.g:145:1: (lv_nodeClasses_5_0= ruleNodeClass )
            	    // InternalETPhys.g:146:3: lv_nodeClasses_5_0= ruleNodeClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_nodeClasses_5_0=ruleNodeClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodeClasses",
            	            		lv_nodeClasses_5_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.NodeClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalETPhys.g:163:6: ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) )
            	    {
            	    // InternalETPhys.g:163:6: ( (lv_runtimeClasses_6_0= ruleRuntimeClass ) )
            	    // InternalETPhys.g:164:1: (lv_runtimeClasses_6_0= ruleRuntimeClass )
            	    {
            	    // InternalETPhys.g:164:1: (lv_runtimeClasses_6_0= ruleRuntimeClass )
            	    // InternalETPhys.g:165:3: lv_runtimeClasses_6_0= ruleRuntimeClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_runtimeClasses_6_0=ruleRuntimeClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"runtimeClasses",
            	            		lv_runtimeClasses_6_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.RuntimeClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETPhys.g:193:1: entryRulePhysicalSystem returns [EObject current=null] : iv_rulePhysicalSystem= rulePhysicalSystem EOF ;
    public final EObject entryRulePhysicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalSystem = null;


        try {
            // InternalETPhys.g:194:2: (iv_rulePhysicalSystem= rulePhysicalSystem EOF )
            // InternalETPhys.g:195:2: iv_rulePhysicalSystem= rulePhysicalSystem EOF
            {
             newCompositeNode(grammarAccess.getPhysicalSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicalSystem=rulePhysicalSystem();

            state._fsp--;

             current =iv_rulePhysicalSystem; 
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
    // $ANTLR end "entryRulePhysicalSystem"


    // $ANTLR start "rulePhysicalSystem"
    // InternalETPhys.g:202:1: rulePhysicalSystem returns [EObject current=null] : (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' ) ;
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
            // InternalETPhys.g:205:28: ( (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' ) )
            // InternalETPhys.g:206:1: (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' )
            {
            // InternalETPhys.g:206:1: (otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}' )
            // InternalETPhys.g:206:3: otherlv_0= 'PhysicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_nodeRefs_4_0= ruleNodeRef ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0());
                
            // InternalETPhys.g:210:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalETPhys.g:211:1: (lv_name_1_0= RULE_ID )
            {
            // InternalETPhys.g:211:1: (lv_name_1_0= RULE_ID )
            // InternalETPhys.g:212:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalETPhys.g:228:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==40) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalETPhys.g:229:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalETPhys.g:229:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalETPhys.g:230:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPhysicalSystemRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_8); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalETPhys.g:250:1: ( (lv_nodeRefs_4_0= ruleNodeRef ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalETPhys.g:251:1: (lv_nodeRefs_4_0= ruleNodeRef )
            	    {
            	    // InternalETPhys.g:251:1: (lv_nodeRefs_4_0= ruleNodeRef )
            	    // InternalETPhys.g:252:3: lv_nodeRefs_4_0= ruleNodeRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_nodeRefs_4_0=ruleNodeRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodeRefs",
            	            		lv_nodeRefs_4_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.NodeRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETPhys.g:280:1: entryRuleNodeRef returns [EObject current=null] : iv_ruleNodeRef= ruleNodeRef EOF ;
    public final EObject entryRuleNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRef = null;


        try {
            // InternalETPhys.g:281:2: (iv_ruleNodeRef= ruleNodeRef EOF )
            // InternalETPhys.g:282:2: iv_ruleNodeRef= ruleNodeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNodeRef=ruleNodeRef();

            state._fsp--;

             current =iv_ruleNodeRef; 
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
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // InternalETPhys.g:289:1: ruleNodeRef returns [EObject current=null] : (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:292:28: ( (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalETPhys.g:293:1: (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalETPhys.g:293:1: (otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalETPhys.g:293:3: otherlv_0= 'NodeRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeRefAccess().getNodeRefKeyword_0());
                
            // InternalETPhys.g:297:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalETPhys.g:298:1: (lv_name_1_0= RULE_ID )
            {
            // InternalETPhys.g:298:1: (lv_name_1_0= RULE_ID )
            // InternalETPhys.g:299:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getNodeRefAccess().getColonKeyword_2());
                
            // InternalETPhys.g:319:1: ( ( ruleFQN ) )
            // InternalETPhys.g:320:1: ( ruleFQN )
            {
            // InternalETPhys.g:320:1: ( ruleFQN )
            // InternalETPhys.g:321:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_10);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalETPhys.g:334:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==40) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalETPhys.g:335:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalETPhys.g:335:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalETPhys.g:336:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_4_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
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
    // InternalETPhys.g:360:1: entryRuleNodeClass returns [EObject current=null] : iv_ruleNodeClass= ruleNodeClass EOF ;
    public final EObject entryRuleNodeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeClass = null;


        try {
            // InternalETPhys.g:361:2: (iv_ruleNodeClass= ruleNodeClass EOF )
            // InternalETPhys.g:362:2: iv_ruleNodeClass= ruleNodeClass EOF
            {
             newCompositeNode(grammarAccess.getNodeClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNodeClass=ruleNodeClass();

            state._fsp--;

             current =iv_ruleNodeClass; 
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
    // $ANTLR end "entryRuleNodeClass"


    // $ANTLR start "ruleNodeClass"
    // InternalETPhys.g:369:1: ruleNodeClass returns [EObject current=null] : (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' ) ;
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
            // InternalETPhys.g:372:28: ( (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' ) )
            // InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' )
            {
            // InternalETPhys.g:373:1: (otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}' )
            // InternalETPhys.g:373:3: otherlv_0= 'NodeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_threads_14_0= rulePhysicalThread ) )* otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeClassAccess().getNodeClassKeyword_0());
                
            // InternalETPhys.g:377:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalETPhys.g:378:1: (lv_name_1_0= RULE_ID )
            {
            // InternalETPhys.g:378:1: (lv_name_1_0= RULE_ID )
            // InternalETPhys.g:379:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalETPhys.g:395:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==40) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalETPhys.g:396:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalETPhys.g:396:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalETPhys.g:397:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_11); 

                	newLeafNode(otherlv_3, grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalETPhys.g:417:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) ) )
            // InternalETPhys.g:419:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalETPhys.g:419:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?) )
            // InternalETPhys.g:420:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	
            // InternalETPhys.g:423:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?)
            // InternalETPhys.g:424:3: ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+ {...}?
            {
            // InternalETPhys.g:424:3: ( ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( LA7_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalETPhys.g:426:4: ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:426:4: ({...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) ) )
            	    // InternalETPhys.g:427:5: {...}? => ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalETPhys.g:427:106: ( ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) ) )
            	    // InternalETPhys.g:428:6: ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // InternalETPhys.g:431:6: ({...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) ) )
            	    // InternalETPhys.g:431:7: {...}? => (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // InternalETPhys.g:431:16: (otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) ) )
            	    // InternalETPhys.g:431:18: otherlv_5= 'runtime' otherlv_6= '=' ( ( ruleFQN ) )
            	    {
            	    otherlv_5=(Token)match(input,19,FOLLOW_12); 

            	        	newLeafNode(otherlv_5, grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0());
            	        
            	    otherlv_6=(Token)match(input,20,FOLLOW_3); 

            	        	newLeafNode(otherlv_6, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1());
            	        
            	    // InternalETPhys.g:439:1: ( ( ruleFQN ) )
            	    // InternalETPhys.g:440:1: ( ruleFQN )
            	    {
            	    // InternalETPhys.g:440:1: ( ruleFQN )
            	    // InternalETPhys.g:441:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getNodeClassRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_13);
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
            	    // InternalETPhys.g:461:4: ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:461:4: ({...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) ) )
            	    // InternalETPhys.g:462:5: {...}? => ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalETPhys.g:462:106: ( ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) ) )
            	    // InternalETPhys.g:463:6: ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // InternalETPhys.g:466:6: ({...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) ) )
            	    // InternalETPhys.g:466:7: {...}? => (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // InternalETPhys.g:466:16: (otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) ) )
            	    // InternalETPhys.g:466:18: otherlv_8= 'priomin' otherlv_9= '=' ( (lv_priomin_10_0= ruleInteger ) )
            	    {
            	    otherlv_8=(Token)match(input,21,FOLLOW_12); 

            	        	newLeafNode(otherlv_8, grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0());
            	        
            	    otherlv_9=(Token)match(input,20,FOLLOW_14); 

            	        	newLeafNode(otherlv_9, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1());
            	        
            	    // InternalETPhys.g:474:1: ( (lv_priomin_10_0= ruleInteger ) )
            	    // InternalETPhys.g:475:1: (lv_priomin_10_0= ruleInteger )
            	    {
            	    // InternalETPhys.g:475:1: (lv_priomin_10_0= ruleInteger )
            	    // InternalETPhys.g:476:3: lv_priomin_10_0= ruleInteger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriominIntegerParserRuleCall_4_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_13);
            	    lv_priomin_10_0=ruleInteger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"priomin",
            	            		lv_priomin_10_0, 
            	            		"org.eclipse.etrice.core.common.Base.Integer");
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
            	    // InternalETPhys.g:499:4: ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:499:4: ({...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) ) )
            	    // InternalETPhys.g:500:5: {...}? => ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalETPhys.g:500:106: ( ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) ) )
            	    // InternalETPhys.g:501:6: ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // InternalETPhys.g:504:6: ({...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) ) )
            	    // InternalETPhys.g:504:7: {...}? => (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNodeClass", "true");
            	    }
            	    // InternalETPhys.g:504:16: (otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) ) )
            	    // InternalETPhys.g:504:18: otherlv_11= 'priomax' otherlv_12= '=' ( (lv_priomax_13_0= ruleInteger ) )
            	    {
            	    otherlv_11=(Token)match(input,22,FOLLOW_12); 

            	        	newLeafNode(otherlv_11, grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0());
            	        
            	    otherlv_12=(Token)match(input,20,FOLLOW_14); 

            	        	newLeafNode(otherlv_12, grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1());
            	        
            	    // InternalETPhys.g:512:1: ( (lv_priomax_13_0= ruleInteger ) )
            	    // InternalETPhys.g:513:1: (lv_priomax_13_0= ruleInteger )
            	    {
            	    // InternalETPhys.g:513:1: (lv_priomax_13_0= ruleInteger )
            	    // InternalETPhys.g:514:3: lv_priomax_13_0= ruleInteger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getPriomaxIntegerParserRuleCall_4_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_13);
            	    lv_priomax_13_0=ruleInteger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"priomax",
            	            		lv_priomax_13_0, 
            	            		"org.eclipse.etrice.core.common.Base.Integer");
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

            // InternalETPhys.g:545:2: ( (lv_threads_14_0= rulePhysicalThread ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=23 && LA8_0<=24)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalETPhys.g:546:1: (lv_threads_14_0= rulePhysicalThread )
            	    {
            	    // InternalETPhys.g:546:1: (lv_threads_14_0= rulePhysicalThread )
            	    // InternalETPhys.g:547:3: lv_threads_14_0= rulePhysicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_15);
            	    lv_threads_14_0=rulePhysicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_14_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.PhysicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_15=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETPhys.g:575:1: entryRulePhysicalThread returns [EObject current=null] : iv_rulePhysicalThread= rulePhysicalThread EOF ;
    public final EObject entryRulePhysicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalThread = null;


        try {
            // InternalETPhys.g:576:2: (iv_rulePhysicalThread= rulePhysicalThread EOF )
            // InternalETPhys.g:577:2: iv_rulePhysicalThread= rulePhysicalThread EOF
            {
             newCompositeNode(grammarAccess.getPhysicalThreadRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePhysicalThread=rulePhysicalThread();

            state._fsp--;

             current =iv_rulePhysicalThread; 
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
    // $ANTLR end "entryRulePhysicalThread"


    // $ANTLR start "rulePhysicalThread"
    // InternalETPhys.g:584:1: rulePhysicalThread returns [EObject current=null] : ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' ) ;
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
            // InternalETPhys.g:587:28: ( ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' ) )
            // InternalETPhys.g:588:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' )
            {
            // InternalETPhys.g:588:1: ( ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}' )
            // InternalETPhys.g:588:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) ) otherlv_23= '}'
            {
            // InternalETPhys.g:588:2: ( ( (lv_default_0_0= 'DefaultThread' ) ) | otherlv_1= 'Thread' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalETPhys.g:588:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    {
                    // InternalETPhys.g:588:3: ( (lv_default_0_0= 'DefaultThread' ) )
                    // InternalETPhys.g:589:1: (lv_default_0_0= 'DefaultThread' )
                    {
                    // InternalETPhys.g:589:1: (lv_default_0_0= 'DefaultThread' )
                    // InternalETPhys.g:590:3: lv_default_0_0= 'DefaultThread'
                    {
                    lv_default_0_0=(Token)match(input,23,FOLLOW_3); 

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
                    // InternalETPhys.g:604:7: otherlv_1= 'Thread'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalETPhys.g:608:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalETPhys.g:609:1: (lv_name_2_0= RULE_ID )
            {
            // InternalETPhys.g:609:1: (lv_name_2_0= RULE_ID )
            // InternalETPhys.g:610:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_16); 

                	newLeafNode(otherlv_3, grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalETPhys.g:630:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) ) )
            // InternalETPhys.g:632:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalETPhys.g:632:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?) )
            // InternalETPhys.g:633:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	
            // InternalETPhys.g:636:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?)
            // InternalETPhys.g:637:3: ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+ {...}?
            {
            // InternalETPhys.g:637:3: ( ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=7;
                int LA10_0 = input.LA(1);

                if ( LA10_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                    alt10=2;
                }
                else if ( LA10_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                    alt10=3;
                }
                else if ( LA10_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                    alt10=4;
                }
                else if ( LA10_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                    alt10=5;
                }
                else if ( LA10_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                    alt10=6;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalETPhys.g:639:4: ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:639:4: ({...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) ) )
            	    // InternalETPhys.g:640:5: {...}? => ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalETPhys.g:640:111: ( ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) ) )
            	    // InternalETPhys.g:641:6: ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalETPhys.g:644:6: ({...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) ) )
            	    // InternalETPhys.g:644:7: {...}? => (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:644:16: (otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) ) )
            	    // InternalETPhys.g:644:18: otherlv_5= 'execmode' otherlv_6= '=' ( (lv_execmode_7_0= ruleExecMode ) )
            	    {
            	    otherlv_5=(Token)match(input,25,FOLLOW_12); 

            	        	newLeafNode(otherlv_5, grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0());
            	        
            	    otherlv_6=(Token)match(input,20,FOLLOW_17); 

            	        	newLeafNode(otherlv_6, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1());
            	        
            	    // InternalETPhys.g:652:1: ( (lv_execmode_7_0= ruleExecMode ) )
            	    // InternalETPhys.g:653:1: (lv_execmode_7_0= ruleExecMode )
            	    {
            	    // InternalETPhys.g:653:1: (lv_execmode_7_0= ruleExecMode )
            	    // InternalETPhys.g:654:3: lv_execmode_7_0= ruleExecMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
            	    lv_execmode_7_0=ruleExecMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"execmode",
            	            		lv_execmode_7_0, 
            	            		"org.eclipse.etrice.core.etphys.ETPhys.ExecMode");
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
            	    // InternalETPhys.g:677:4: ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:677:4: ({...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) ) )
            	    // InternalETPhys.g:678:5: {...}? => ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalETPhys.g:678:111: ( ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) ) )
            	    // InternalETPhys.g:679:6: ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalETPhys.g:682:6: ({...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) ) )
            	    // InternalETPhys.g:682:7: {...}? => (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:682:16: (otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) ) )
            	    // InternalETPhys.g:682:18: otherlv_8= 'interval' otherlv_9= '=' ( (lv_time_10_0= ruleTIME ) )
            	    {
            	    otherlv_8=(Token)match(input,26,FOLLOW_12); 

            	        	newLeafNode(otherlv_8, grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0());
            	        
            	    otherlv_9=(Token)match(input,20,FOLLOW_19); 

            	        	newLeafNode(otherlv_9, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1());
            	        
            	    // InternalETPhys.g:690:1: ( (lv_time_10_0= ruleTIME ) )
            	    // InternalETPhys.g:691:1: (lv_time_10_0= ruleTIME )
            	    {
            	    // InternalETPhys.g:691:1: (lv_time_10_0= ruleTIME )
            	    // InternalETPhys.g:692:3: lv_time_10_0= ruleTIME
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
            	    lv_time_10_0=ruleTIME();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"time",
            	            		lv_time_10_0, 
            	            		"org.eclipse.etrice.core.common.Base.TIME");
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
            	    // InternalETPhys.g:715:4: ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:715:4: ({...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) ) )
            	    // InternalETPhys.g:716:5: {...}? => ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalETPhys.g:716:111: ( ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) ) )
            	    // InternalETPhys.g:717:6: ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // InternalETPhys.g:720:6: ({...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) ) )
            	    // InternalETPhys.g:720:7: {...}? => (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:720:16: (otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) ) )
            	    // InternalETPhys.g:720:18: otherlv_11= 'prio' otherlv_12= '=' ( (lv_prio_13_0= ruleInteger ) )
            	    {
            	    otherlv_11=(Token)match(input,27,FOLLOW_12); 

            	        	newLeafNode(otherlv_11, grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0());
            	        
            	    otherlv_12=(Token)match(input,20,FOLLOW_14); 

            	        	newLeafNode(otherlv_12, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1());
            	        
            	    // InternalETPhys.g:728:1: ( (lv_prio_13_0= ruleInteger ) )
            	    // InternalETPhys.g:729:1: (lv_prio_13_0= ruleInteger )
            	    {
            	    // InternalETPhys.g:729:1: (lv_prio_13_0= ruleInteger )
            	    // InternalETPhys.g:730:3: lv_prio_13_0= ruleInteger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhysicalThreadAccess().getPrioIntegerParserRuleCall_3_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
            	    lv_prio_13_0=ruleInteger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"prio",
            	            		lv_prio_13_0, 
            	            		"org.eclipse.etrice.core.common.Base.Integer");
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
            	    // InternalETPhys.g:753:4: ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:753:4: ({...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) ) )
            	    // InternalETPhys.g:754:5: {...}? => ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalETPhys.g:754:111: ( ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) ) )
            	    // InternalETPhys.g:755:6: ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // InternalETPhys.g:758:6: ({...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) ) )
            	    // InternalETPhys.g:758:7: {...}? => (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:758:16: (otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) ) )
            	    // InternalETPhys.g:758:18: otherlv_14= 'stacksize' otherlv_15= '=' ( (lv_stacksize_16_0= RULE_INT ) )
            	    {
            	    otherlv_14=(Token)match(input,28,FOLLOW_12); 

            	        	newLeafNode(otherlv_14, grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0());
            	        
            	    otherlv_15=(Token)match(input,20,FOLLOW_19); 

            	        	newLeafNode(otherlv_15, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1());
            	        
            	    // InternalETPhys.g:766:1: ( (lv_stacksize_16_0= RULE_INT ) )
            	    // InternalETPhys.g:767:1: (lv_stacksize_16_0= RULE_INT )
            	    {
            	    // InternalETPhys.g:767:1: (lv_stacksize_16_0= RULE_INT )
            	    // InternalETPhys.g:768:3: lv_stacksize_16_0= RULE_INT
            	    {
            	    lv_stacksize_16_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            	    			newLeafNode(lv_stacksize_16_0, grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"stacksize",
            	            		lv_stacksize_16_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

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
            	    // InternalETPhys.g:791:4: ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:791:4: ({...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) ) )
            	    // InternalETPhys.g:792:5: {...}? => ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalETPhys.g:792:111: ( ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) ) )
            	    // InternalETPhys.g:793:6: ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // InternalETPhys.g:796:6: ({...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) ) )
            	    // InternalETPhys.g:796:7: {...}? => (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:796:16: (otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) ) )
            	    // InternalETPhys.g:796:18: otherlv_17= 'msgblocksize' otherlv_18= '=' ( (lv_msgblocksize_19_0= RULE_INT ) )
            	    {
            	    otherlv_17=(Token)match(input,29,FOLLOW_12); 

            	        	newLeafNode(otherlv_17, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0());
            	        
            	    otherlv_18=(Token)match(input,20,FOLLOW_19); 

            	        	newLeafNode(otherlv_18, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1());
            	        
            	    // InternalETPhys.g:804:1: ( (lv_msgblocksize_19_0= RULE_INT ) )
            	    // InternalETPhys.g:805:1: (lv_msgblocksize_19_0= RULE_INT )
            	    {
            	    // InternalETPhys.g:805:1: (lv_msgblocksize_19_0= RULE_INT )
            	    // InternalETPhys.g:806:3: lv_msgblocksize_19_0= RULE_INT
            	    {
            	    lv_msgblocksize_19_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            	    			newLeafNode(lv_msgblocksize_19_0, grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"msgblocksize",
            	            		lv_msgblocksize_19_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

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
            	    // InternalETPhys.g:829:4: ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalETPhys.g:829:4: ({...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) ) )
            	    // InternalETPhys.g:830:5: {...}? => ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalETPhys.g:830:111: ( ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) ) )
            	    // InternalETPhys.g:831:6: ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // InternalETPhys.g:834:6: ({...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) ) )
            	    // InternalETPhys.g:834:7: {...}? => (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePhysicalThread", "true");
            	    }
            	    // InternalETPhys.g:834:16: (otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) ) )
            	    // InternalETPhys.g:834:18: otherlv_20= 'msgpoolsize' otherlv_21= '=' ( (lv_msgpoolsize_22_0= RULE_INT ) )
            	    {
            	    otherlv_20=(Token)match(input,30,FOLLOW_12); 

            	        	newLeafNode(otherlv_20, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0());
            	        
            	    otherlv_21=(Token)match(input,20,FOLLOW_19); 

            	        	newLeafNode(otherlv_21, grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1());
            	        
            	    // InternalETPhys.g:842:1: ( (lv_msgpoolsize_22_0= RULE_INT ) )
            	    // InternalETPhys.g:843:1: (lv_msgpoolsize_22_0= RULE_INT )
            	    {
            	    // InternalETPhys.g:843:1: (lv_msgpoolsize_22_0= RULE_INT )
            	    // InternalETPhys.g:844:3: lv_msgpoolsize_22_0= RULE_INT
            	    {
            	    lv_msgpoolsize_22_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            	    			newLeafNode(lv_msgpoolsize_22_0, grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPhysicalThreadRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"msgpoolsize",
            	            		lv_msgpoolsize_22_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

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

            otherlv_23=(Token)match(input,14,FOLLOW_2); 

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
    // InternalETPhys.g:887:1: entryRuleRuntimeClass returns [EObject current=null] : iv_ruleRuntimeClass= ruleRuntimeClass EOF ;
    public final EObject entryRuleRuntimeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuntimeClass = null;


        try {
            // InternalETPhys.g:888:2: (iv_ruleRuntimeClass= ruleRuntimeClass EOF )
            // InternalETPhys.g:889:2: iv_ruleRuntimeClass= ruleRuntimeClass EOF
            {
             newCompositeNode(grammarAccess.getRuntimeClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuntimeClass=ruleRuntimeClass();

            state._fsp--;

             current =iv_ruleRuntimeClass; 
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
    // $ANTLR end "entryRuleRuntimeClass"


    // $ANTLR start "ruleRuntimeClass"
    // InternalETPhys.g:896:1: ruleRuntimeClass returns [EObject current=null] : (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) ;
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
            // InternalETPhys.g:899:28: ( (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' ) )
            // InternalETPhys.g:900:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            {
            // InternalETPhys.g:900:1: (otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}' )
            // InternalETPhys.g:900:3: otherlv_0= 'RuntimeClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'model' otherlv_5= '=' ( (lv_threadModel_6_0= ruleThreadModel ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0());
                
            // InternalETPhys.g:904:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalETPhys.g:905:1: (lv_name_1_0= RULE_ID )
            {
            // InternalETPhys.g:905:1: (lv_name_1_0= RULE_ID )
            // InternalETPhys.g:906:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuntimeClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalETPhys.g:922:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==40) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalETPhys.g:923:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalETPhys.g:923:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalETPhys.g:924:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuntimeClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_2_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_20); 

                	newLeafNode(otherlv_3, grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,32,FOLLOW_12); 

                	newLeafNode(otherlv_4, grammarAccess.getRuntimeClassAccess().getModelKeyword_4());
                
            otherlv_5=(Token)match(input,20,FOLLOW_21); 

                	newLeafNode(otherlv_5, grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5());
                
            // InternalETPhys.g:952:1: ( (lv_threadModel_6_0= ruleThreadModel ) )
            // InternalETPhys.g:953:1: (lv_threadModel_6_0= ruleThreadModel )
            {
            // InternalETPhys.g:953:1: (lv_threadModel_6_0= ruleThreadModel )
            // InternalETPhys.g:954:3: lv_threadModel_6_0= ruleThreadModel
            {
             
            	        newCompositeNode(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_22);
            lv_threadModel_6_0=ruleThreadModel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuntimeClassRule());
            	        }
                   		set(
                   			current, 
                   			"threadModel",
                    		lv_threadModel_6_0, 
                    		"org.eclipse.etrice.core.etphys.ETPhys.ThreadModel");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

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


    // $ANTLR start "entryRuleKeyValue"
    // InternalETPhys.g:984:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalETPhys.g:985:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalETPhys.g:986:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalETPhys.g:993:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:996:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalETPhys.g:997:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalETPhys.g:997:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalETPhys.g:997:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalETPhys.g:997:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalETPhys.g:998:1: (lv_key_0_0= RULE_ID )
            {
            // InternalETPhys.g:998:1: (lv_key_0_0= RULE_ID )
            // InternalETPhys.g:999:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_1=(Token)match(input,20,FOLLOW_23); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalETPhys.g:1019:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalETPhys.g:1020:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalETPhys.g:1020:1: (lv_value_2_0= ruleLiteral )
            // InternalETPhys.g:1021:3: lv_value_2_0= ruleLiteral
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
    // InternalETPhys.g:1047:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalETPhys.g:1048:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalETPhys.g:1049:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalETPhys.g:1056:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1059:28: (this_ID_0= RULE_ID )
            // InternalETPhys.g:1060:5: this_ID_0= RULE_ID
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
    // InternalETPhys.g:1075:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalETPhys.g:1076:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalETPhys.g:1077:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalETPhys.g:1084:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1087:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalETPhys.g:1088:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalETPhys.g:1088:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==35) ) {
                    int LA12_3 = input.LA(3);

                    if ( (LA12_3==RULE_ID) ) {
                        int LA12_4 = input.LA(4);

                        if ( (LA12_4==17) ) {
                            int LA12_5 = input.LA(5);

                            if ( ((LA12_5>=58 && LA12_5<=61)) ) {
                                alt12=1;
                            }
                            else if ( (LA12_5==13) ) {
                                alt12=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 12, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==34) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==35) ) {
                    int LA12_3 = input.LA(3);

                    if ( (LA12_3==RULE_ID) ) {
                        int LA12_4 = input.LA(4);

                        if ( (LA12_4==17) ) {
                            int LA12_5 = input.LA(5);

                            if ( ((LA12_5>=58 && LA12_5<=61)) ) {
                                alt12=1;
                            }
                            else if ( (LA12_5==13) ) {
                                alt12=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 12, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalETPhys.g:1089:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalETPhys.g:1099:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalETPhys.g:1115:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalETPhys.g:1116:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalETPhys.g:1117:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalETPhys.g:1124:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalETPhys.g:1127:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalETPhys.g:1128:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalETPhys.g:1128:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalETPhys.g:1128:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalETPhys.g:1128:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            else if ( (LA13_0==34) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalETPhys.g:1128:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETPhys.g:1128:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETPhys.g:1129:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETPhys.g:1129:1: (lv_optional_0_0= 'optional' )
                    // InternalETPhys.g:1130:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,33,FOLLOW_24); 

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
                    // InternalETPhys.g:1144:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_24); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalETPhys.g:1152:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalETPhys.g:1153:1: (lv_name_3_0= RULE_ID )
            {
            // InternalETPhys.g:1153:1: (lv_name_3_0= RULE_ID )
            // InternalETPhys.g:1154:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_4=(Token)match(input,17,FOLLOW_25); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalETPhys.g:1174:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalETPhys.g:1175:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalETPhys.g:1175:1: (lv_type_5_0= ruleLiteralType )
            // InternalETPhys.g:1176:3: lv_type_5_0= ruleLiteralType
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
    // InternalETPhys.g:1200:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalETPhys.g:1201:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalETPhys.g:1202:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalETPhys.g:1209:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalETPhys.g:1212:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalETPhys.g:1213:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalETPhys.g:1213:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalETPhys.g:1213:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalETPhys.g:1213:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            else if ( (LA14_0==34) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalETPhys.g:1213:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalETPhys.g:1213:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalETPhys.g:1214:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalETPhys.g:1214:1: (lv_optional_0_0= 'optional' )
                    // InternalETPhys.g:1215:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,33,FOLLOW_24); 

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
                    // InternalETPhys.g:1229:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_24); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalETPhys.g:1237:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalETPhys.g:1238:1: (lv_name_3_0= RULE_ID )
            {
            // InternalETPhys.g:1238:1: (lv_name_3_0= RULE_ID )
            // InternalETPhys.g:1239:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_4=(Token)match(input,17,FOLLOW_4); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,13,FOLLOW_26); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalETPhys.g:1263:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalETPhys.g:1264:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalETPhys.g:1264:1: (lv_values_6_0= RULE_STRING )
            // InternalETPhys.g:1265:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_27); 

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

            // InternalETPhys.g:1281:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalETPhys.g:1281:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,36,FOLLOW_26); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalETPhys.g:1285:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalETPhys.g:1286:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalETPhys.g:1286:1: (lv_values_8_0= RULE_STRING )
            	    // InternalETPhys.g:1287:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_27); 

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
            	    break loop15;
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
    // InternalETPhys.g:1315:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalETPhys.g:1316:2: (iv_ruleImport= ruleImport EOF )
            // InternalETPhys.g:1317:2: iv_ruleImport= ruleImport EOF
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
    // InternalETPhys.g:1324:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1327:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalETPhys.g:1328:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalETPhys.g:1328:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalETPhys.g:1328:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_28); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalETPhys.g:1332:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            else if ( (LA16_0==32) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalETPhys.g:1332:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalETPhys.g:1332:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalETPhys.g:1332:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalETPhys.g:1332:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalETPhys.g:1333:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalETPhys.g:1333:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalETPhys.g:1334:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_29);
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

                    otherlv_2=(Token)match(input,38,FOLLOW_26); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETPhys.g:1355:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_26); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalETPhys.g:1359:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalETPhys.g:1360:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalETPhys.g:1360:1: (lv_importURI_4_0= RULE_STRING )
            // InternalETPhys.g:1361:3: lv_importURI_4_0= RULE_STRING
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
    // InternalETPhys.g:1385:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalETPhys.g:1386:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalETPhys.g:1387:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalETPhys.g:1394:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1397:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalETPhys.g:1398:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalETPhys.g:1398:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalETPhys.g:1399:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_30);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalETPhys.g:1409:1: (kw= '.*' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalETPhys.g:1410:2: kw= '.*'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

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
    // InternalETPhys.g:1423:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalETPhys.g:1424:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalETPhys.g:1425:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalETPhys.g:1432:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1435:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalETPhys.g:1436:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalETPhys.g:1436:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalETPhys.g:1436:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalETPhys.g:1436:2: ()
            // InternalETPhys.g:1437:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,40,FOLLOW_31); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalETPhys.g:1446:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalETPhys.g:1447:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalETPhys.g:1447:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalETPhys.g:1448:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

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
            	    break loop18;
                }
            } while (true);

            otherlv_3=(Token)match(input,41,FOLLOW_2); 

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
    // InternalETPhys.g:1476:1: entryRuleTIME returns [String current=null] : iv_ruleTIME= ruleTIME EOF ;
    public final String entryRuleTIME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTIME = null;


        try {
            // InternalETPhys.g:1477:2: (iv_ruleTIME= ruleTIME EOF )
            // InternalETPhys.g:1478:2: iv_ruleTIME= ruleTIME EOF
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
    // InternalETPhys.g:1485:1: ruleTIME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) ;
    public final AntlrDatatypeRuleToken ruleTIME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1488:28: ( ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) ) )
            // InternalETPhys.g:1489:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            {
            // InternalETPhys.g:1489:1: ( (this_INT_0= RULE_INT kw= 's' ) | (this_INT_2= RULE_INT kw= 'ms' ) | (this_INT_4= RULE_INT kw= 'us' ) | (this_INT_6= RULE_INT kw= 'ns' ) )
            int alt19=4;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 44:
                    {
                    alt19=3;
                    }
                    break;
                case 43:
                    {
                    alt19=2;
                    }
                    break;
                case 42:
                    {
                    alt19=1;
                    }
                    break;
                case 45:
                    {
                    alt19=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalETPhys.g:1489:2: (this_INT_0= RULE_INT kw= 's' )
                    {
                    // InternalETPhys.g:1489:2: (this_INT_0= RULE_INT kw= 's' )
                    // InternalETPhys.g:1489:7: this_INT_0= RULE_INT kw= 's'
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_32); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,42,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETPhys.g:1503:6: (this_INT_2= RULE_INT kw= 'ms' )
                    {
                    // InternalETPhys.g:1503:6: (this_INT_2= RULE_INT kw= 'ms' )
                    // InternalETPhys.g:1503:11: this_INT_2= RULE_INT kw= 'ms'
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_33); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
                        
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalETPhys.g:1517:6: (this_INT_4= RULE_INT kw= 'us' )
                    {
                    // InternalETPhys.g:1517:6: (this_INT_4= RULE_INT kw= 'us' )
                    // InternalETPhys.g:1517:11: this_INT_4= RULE_INT kw= 'us'
                    {
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_34); 

                    		current.merge(this_INT_4);
                        
                     
                        newLeafNode(this_INT_4, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
                        
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalETPhys.g:1531:6: (this_INT_6= RULE_INT kw= 'ns' )
                    {
                    // InternalETPhys.g:1531:6: (this_INT_6= RULE_INT kw= 'ns' )
                    // InternalETPhys.g:1531:11: this_INT_6= RULE_INT kw= 'ns'
                    {
                    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_35); 

                    		current.merge(this_INT_6);
                        
                     
                        newLeafNode(this_INT_6, grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
                        
                    kw=(Token)match(input,45,FOLLOW_2); 

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
    // InternalETPhys.g:1554:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalETPhys.g:1555:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalETPhys.g:1556:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalETPhys.g:1563:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1566:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalETPhys.g:1567:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalETPhys.g:1567:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 46:
            case 47:
                {
                alt20=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 48:
            case 49:
                {
                alt20=2;
                }
                break;
            case RULE_STRING:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalETPhys.g:1568:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalETPhys.g:1578:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalETPhys.g:1588:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalETPhys.g:1604:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalETPhys.g:1605:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalETPhys.g:1606:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalETPhys.g:1613:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1616:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalETPhys.g:1617:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalETPhys.g:1617:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalETPhys.g:1617:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalETPhys.g:1617:2: ()
            // InternalETPhys.g:1618:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalETPhys.g:1623:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==46) ) {
                alt21=1;
            }
            else if ( (LA21_0==47) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalETPhys.g:1623:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalETPhys.g:1628:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalETPhys.g:1628:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalETPhys.g:1629:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalETPhys.g:1629:1: (lv_isTrue_2_0= 'true' )
                    // InternalETPhys.g:1630:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,47,FOLLOW_2); 

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
    // InternalETPhys.g:1651:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalETPhys.g:1652:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalETPhys.g:1653:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalETPhys.g:1660:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1663:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalETPhys.g:1664:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalETPhys.g:1664:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt22=2;
            switch ( input.LA(1) ) {
            case 48:
                {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_INT) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==50) ) {
                        alt22=2;
                    }
                    else if ( (LA22_3==EOF) ) {
                        alt22=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==RULE_INT) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==50) ) {
                        alt22=2;
                    }
                    else if ( (LA22_3==EOF) ) {
                        alt22=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA22_3 = input.LA(2);

                if ( (LA22_3==50) ) {
                    alt22=2;
                }
                else if ( (LA22_3==EOF) ) {
                    alt22=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt22=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalETPhys.g:1665:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalETPhys.g:1675:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalETPhys.g:1691:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalETPhys.g:1692:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalETPhys.g:1693:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalETPhys.g:1700:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1703:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalETPhys.g:1704:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalETPhys.g:1704:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalETPhys.g:1704:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalETPhys.g:1704:2: ()
            // InternalETPhys.g:1705:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalETPhys.g:1710:2: ( (lv_value_1_0= ruleReal ) )
            // InternalETPhys.g:1711:1: (lv_value_1_0= ruleReal )
            {
            // InternalETPhys.g:1711:1: (lv_value_1_0= ruleReal )
            // InternalETPhys.g:1712:3: lv_value_1_0= ruleReal
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
    // InternalETPhys.g:1736:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalETPhys.g:1737:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalETPhys.g:1738:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalETPhys.g:1745:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1748:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalETPhys.g:1749:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalETPhys.g:1749:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalETPhys.g:1749:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalETPhys.g:1749:2: ()
            // InternalETPhys.g:1750:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalETPhys.g:1755:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalETPhys.g:1756:1: (lv_value_1_0= ruleInteger )
            {
            // InternalETPhys.g:1756:1: (lv_value_1_0= ruleInteger )
            // InternalETPhys.g:1757:3: lv_value_1_0= ruleInteger
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
    // InternalETPhys.g:1781:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalETPhys.g:1782:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalETPhys.g:1783:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalETPhys.g:1790:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1793:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalETPhys.g:1794:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalETPhys.g:1794:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalETPhys.g:1794:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalETPhys.g:1794:2: ()
            // InternalETPhys.g:1795:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalETPhys.g:1800:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalETPhys.g:1801:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalETPhys.g:1801:1: (lv_value_1_0= RULE_STRING )
            // InternalETPhys.g:1802:3: lv_value_1_0= RULE_STRING
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
    // InternalETPhys.g:1826:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalETPhys.g:1827:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalETPhys.g:1828:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalETPhys.g:1835:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:1838:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalETPhys.g:1839:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalETPhys.g:1839:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT||(LA24_0>=48 && LA24_0<=49)) ) {
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
                    // InternalETPhys.g:1839:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalETPhys.g:1839:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalETPhys.g:1839:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalETPhys.g:1839:3: (kw= '+' | kw= '-' )?
                    int alt23=3;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==48) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==49) ) {
                        alt23=2;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalETPhys.g:1840:2: kw= '+'
                            {
                            kw=(Token)match(input,48,FOLLOW_19); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalETPhys.g:1847:2: kw= '-'
                            {
                            kw=(Token)match(input,49,FOLLOW_19); 

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
                    // InternalETPhys.g:1860:10: this_HEX_3= RULE_HEX
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
    // InternalETPhys.g:1875:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalETPhys.g:1876:2: (iv_ruleReal= ruleReal EOF )
            // InternalETPhys.g:1877:2: iv_ruleReal= ruleReal EOF
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
    // InternalETPhys.g:1884:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalETPhys.g:1887:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalETPhys.g:1888:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalETPhys.g:1888:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt25=2;
            switch ( input.LA(1) ) {
            case 48:
                {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_INT) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==50) ) {
                        int LA25_4 = input.LA(4);

                        if ( (LA25_4==RULE_INT) ) {
                            int LA25_5 = input.LA(5);

                            if ( (LA25_5==EOF) ) {
                                alt25=1;
                            }
                            else if ( ((LA25_5>=51 && LA25_5<=52)) ) {
                                alt25=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 25, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==RULE_INT) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==50) ) {
                        int LA25_4 = input.LA(4);

                        if ( (LA25_4==RULE_INT) ) {
                            int LA25_5 = input.LA(5);

                            if ( (LA25_5==EOF) ) {
                                alt25=1;
                            }
                            else if ( ((LA25_5>=51 && LA25_5<=52)) ) {
                                alt25=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 25, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA25_3 = input.LA(2);

                if ( (LA25_3==50) ) {
                    int LA25_4 = input.LA(3);

                    if ( (LA25_4==RULE_INT) ) {
                        int LA25_5 = input.LA(4);

                        if ( (LA25_5==EOF) ) {
                            alt25=1;
                        }
                        else if ( ((LA25_5>=51 && LA25_5<=52)) ) {
                            alt25=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalETPhys.g:1889:5: this_Decimal_0= ruleDecimal
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
                    // InternalETPhys.g:1901:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalETPhys.g:1919:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalETPhys.g:1923:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalETPhys.g:1924:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalETPhys.g:1934:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalETPhys.g:1938:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalETPhys.g:1939:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalETPhys.g:1939:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalETPhys.g:1939:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalETPhys.g:1939:2: (kw= '+' | kw= '-' )?
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==48) ) {
                alt26=1;
            }
            else if ( (LA26_0==49) ) {
                alt26=2;
            }
            switch (alt26) {
                case 1 :
                    // InternalETPhys.g:1940:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETPhys.g:1947:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_36); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,50,FOLLOW_19); 

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
    // InternalETPhys.g:1983:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalETPhys.g:1987:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalETPhys.g:1988:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalETPhys.g:1998:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalETPhys.g:2002:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalETPhys.g:2003:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalETPhys.g:2003:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalETPhys.g:2003:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalETPhys.g:2003:2: (kw= '+' | kw= '-' )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==48) ) {
                alt27=1;
            }
            else if ( (LA27_0==49) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // InternalETPhys.g:2004:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2011:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_36); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,50,FOLLOW_19); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_37); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalETPhys.g:2036:1: (kw= 'e' | kw= 'E' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==51) ) {
                alt28=1;
            }
            else if ( (LA28_0==52) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalETPhys.g:2037:2: kw= 'e'
                    {
                    kw=(Token)match(input,51,FOLLOW_38); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2044:2: kw= 'E'
                    {
                    kw=(Token)match(input,52,FOLLOW_38); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalETPhys.g:2049:2: (kw= '+' | kw= '-' )?
            int alt29=3;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==48) ) {
                alt29=1;
            }
            else if ( (LA29_0==49) ) {
                alt29=2;
            }
            switch (alt29) {
                case 1 :
                    // InternalETPhys.g:2050:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_19); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2057:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_19); 

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
    // InternalETPhys.g:2080:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalETPhys.g:2081:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalETPhys.g:2082:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalETPhys.g:2089:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalETPhys.g:2092:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalETPhys.g:2093:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalETPhys.g:2093:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalETPhys.g:2093:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalETPhys.g:2100:1: (kw= '.' this_ID_2= RULE_ID )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==50) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalETPhys.g:2101:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,50,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_39); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalETPhys.g:2121:1: ruleExecMode returns [Enumerator current=null] : ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) ;
    public final Enumerator ruleExecMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalETPhys.g:2123:28: ( ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) ) )
            // InternalETPhys.g:2124:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            {
            // InternalETPhys.g:2124:1: ( (enumLiteral_0= 'polled' ) | (enumLiteral_1= 'blocked' ) | (enumLiteral_2= 'mixed' ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt31=1;
                }
                break;
            case 54:
                {
                alt31=2;
                }
                break;
            case 55:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalETPhys.g:2124:2: (enumLiteral_0= 'polled' )
                    {
                    // InternalETPhys.g:2124:2: (enumLiteral_0= 'polled' )
                    // InternalETPhys.g:2124:4: enumLiteral_0= 'polled'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                            current = grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2130:6: (enumLiteral_1= 'blocked' )
                    {
                    // InternalETPhys.g:2130:6: (enumLiteral_1= 'blocked' )
                    // InternalETPhys.g:2130:8: enumLiteral_1= 'blocked'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                            current = grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalETPhys.g:2136:6: (enumLiteral_2= 'mixed' )
                    {
                    // InternalETPhys.g:2136:6: (enumLiteral_2= 'mixed' )
                    // InternalETPhys.g:2136:8: enumLiteral_2= 'mixed'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

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
    // InternalETPhys.g:2146:1: ruleThreadModel returns [Enumerator current=null] : ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) ;
    public final Enumerator ruleThreadModel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalETPhys.g:2148:28: ( ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) ) )
            // InternalETPhys.g:2149:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            {
            // InternalETPhys.g:2149:1: ( (enumLiteral_0= 'singleThreaded' ) | (enumLiteral_1= 'multiThreaded' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==56) ) {
                alt32=1;
            }
            else if ( (LA32_0==57) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalETPhys.g:2149:2: (enumLiteral_0= 'singleThreaded' )
                    {
                    // InternalETPhys.g:2149:2: (enumLiteral_0= 'singleThreaded' )
                    // InternalETPhys.g:2149:4: enumLiteral_0= 'singleThreaded'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                            current = grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2155:6: (enumLiteral_1= 'multiThreaded' )
                    {
                    // InternalETPhys.g:2155:6: (enumLiteral_1= 'multiThreaded' )
                    // InternalETPhys.g:2155:8: enumLiteral_1= 'multiThreaded'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

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
    // InternalETPhys.g:2165:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalETPhys.g:2167:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalETPhys.g:2168:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalETPhys.g:2168:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt33=1;
                }
                break;
            case 59:
                {
                alt33=2;
                }
                break;
            case 60:
                {
                alt33=3;
                }
                break;
            case 61:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalETPhys.g:2168:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalETPhys.g:2168:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalETPhys.g:2168:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalETPhys.g:2174:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalETPhys.g:2174:6: (enumLiteral_1= 'ptInteger' )
                    // InternalETPhys.g:2174:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalETPhys.g:2180:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalETPhys.g:2180:6: (enumLiteral_2= 'ptReal' )
                    // InternalETPhys.g:2180:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalETPhys.g:2186:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalETPhys.g:2186:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalETPhys.g:2186:8: enumLiteral_3= 'ptCharacter'
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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000208004C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000008004C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000680000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001E84000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00030000000000A0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001804000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000007E000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000007E004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0003C000000000E0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0003000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0004000000000002L});

}
