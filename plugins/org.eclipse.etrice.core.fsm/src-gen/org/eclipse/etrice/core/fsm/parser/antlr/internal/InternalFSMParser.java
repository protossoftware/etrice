package org.eclipse.etrice.core.fsm.parser.antlr.internal; 

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
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFSMParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'ModelComponent'", "'extends'", "'{'", "'}'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "':'", "'initial'", "'->'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'of'", "'cp'", "'<'", "'|'", "'>'", "'='", "'optional'", "'mandatory'", "'attribute'", "','", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'eventdriven'", "'datadriven'", "'async'", "'sync'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_EXP=8;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
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
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
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
    public static final int RULE_STRING=5;
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


        public InternalFSMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFSMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFSMParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g"; }



     	private FSMGrammarAccess grammarAccess;
     	
        public InternalFSMParser(TokenStream input, FSMGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "FSMModel";	
       	}
       	
       	@Override
       	protected FSMGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFSMModel"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:68:1: entryRuleFSMModel returns [EObject current=null] : iv_ruleFSMModel= ruleFSMModel EOF ;
    public final EObject entryRuleFSMModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFSMModel = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:69:2: (iv_ruleFSMModel= ruleFSMModel EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:70:2: iv_ruleFSMModel= ruleFSMModel EOF
            {
             newCompositeNode(grammarAccess.getFSMModelRule()); 
            pushFollow(FOLLOW_ruleFSMModel_in_entryRuleFSMModel75);
            iv_ruleFSMModel=ruleFSMModel();

            state._fsp--;

             current =iv_ruleFSMModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFSMModel85); 

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
    // $ANTLR end "entryRuleFSMModel"


    // $ANTLR start "ruleFSMModel"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:77:1: ruleFSMModel returns [EObject current=null] : ( (lv_components_0_0= ruleModelComponent ) )* ;
    public final EObject ruleFSMModel() throws RecognitionException {
        EObject current = null;

        EObject lv_components_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:80:28: ( ( (lv_components_0_0= ruleModelComponent ) )* )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:81:1: ( (lv_components_0_0= ruleModelComponent ) )*
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:81:1: ( (lv_components_0_0= ruleModelComponent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=14)||(LA1_0>=59 && LA1_0<=62)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:82:1: (lv_components_0_0= ruleModelComponent )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:82:1: (lv_components_0_0= ruleModelComponent )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:83:3: lv_components_0_0= ruleModelComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFSMModelAccess().getComponentsModelComponentParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModelComponent_in_ruleFSMModel130);
            	    lv_components_0_0=ruleModelComponent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFSMModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_0_0, 
            	            		"ModelComponent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleFSMModel"


    // $ANTLR start "entryRuleModelComponent"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:107:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:108:2: (iv_ruleModelComponent= ruleModelComponent EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:109:2: iv_ruleModelComponent= ruleModelComponent EOF
            {
             newCompositeNode(grammarAccess.getModelComponentRule()); 
            pushFollow(FOLLOW_ruleModelComponent_in_entryRuleModelComponent166);
            iv_ruleModelComponent=ruleModelComponent();

            state._fsp--;

             current =iv_ruleModelComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelComponent176); 

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
    // $ANTLR end "entryRuleModelComponent"


    // $ANTLR start "ruleModelComponent"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:116:1: ruleModelComponent returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) ) ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token otherlv_3=null;
        Token lv_componentName_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_commType_2_0 = null;

        EObject lv_stateMachine_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:119:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:120:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:120:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:120:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:120:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:122:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:122:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:123:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:126:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:127:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:127:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( LA2_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 >=59 && LA2_0<=62 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:129:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:129:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:130:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:130:111: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:131:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:134:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:134:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "true");
            	    }
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:134:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:135:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:135:1: (lv_abstract_1_0= 'abstract' )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:136:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,13,FOLLOW_13_in_ruleModelComponent264); 

            	            newLeafNode(lv_abstract_1_0, grammarAccess.getModelComponentAccess().getAbstractAbstractKeyword_0_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getModelComponentRule());
            	    	        }
            	           		setWithLastConsumed(current, "abstract", true, "abstract");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:156:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:156:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:157:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:157:111: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:158:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:161:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:161:7: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "true");
            	    }
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:161:16: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:162:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:162:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:163:3: lv_commType_2_0= ruleComponentCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelComponentAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentCommunicationType_in_ruleModelComponent352);
            	    lv_commType_2_0=ruleComponentCommunicationType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelComponentRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"commType",
            	            		lv_commType_2_0, 
            	            		"ComponentCommunicationType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleModelComponent404); 

                	newLeafNode(otherlv_3, grammarAccess.getModelComponentAccess().getModelComponentKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:197:1: ( (lv_componentName_4_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:198:1: (lv_componentName_4_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:198:1: (lv_componentName_4_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:199:3: lv_componentName_4_0= RULE_ID
            {
            lv_componentName_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelComponent421); 

            			newLeafNode(lv_componentName_4_0, grammarAccess.getModelComponentAccess().getComponentNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModelComponentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"componentName",
                    		lv_componentName_4_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:215:2: (otherlv_5= 'extends' ( ( ruleFQN ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:215:4: otherlv_5= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleModelComponent439); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelComponentAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:219:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:220:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:220:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:221:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelComponentRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getModelComponentAccess().getBaseModelComponentCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleModelComponent462);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:234:4: ( (lv_stateMachine_7_0= ruleStateMachine ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:235:1: (lv_stateMachine_7_0= ruleStateMachine )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:235:1: (lv_stateMachine_7_0= ruleStateMachine )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:236:3: lv_stateMachine_7_0= ruleStateMachine
            {
             
            	        newCompositeNode(grammarAccess.getModelComponentAccess().getStateMachineStateMachineParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleStateMachine_in_ruleModelComponent485);
            lv_stateMachine_7_0=ruleStateMachine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelComponentRule());
            	        }
                   		set(
                   			current, 
                   			"stateMachine",
                    		lv_stateMachine_7_0, 
                    		"StateMachine");
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
    // $ANTLR end "ruleModelComponent"


    // $ANTLR start "entryRuleStateGraphNode"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:260:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:261:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:262:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             newCompositeNode(grammarAccess.getStateGraphNodeRule()); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode521);
            iv_ruleStateGraphNode=ruleStateGraphNode();

            state._fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode531); 

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
    // $ANTLR end "entryRuleStateGraphNode"


    // $ANTLR start "ruleStateGraphNode"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:269:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:272:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:273:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:273:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 19:
            case 24:
                {
                alt4=1;
                }
                break;
            case 29:
                {
                alt4=2;
                }
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:274:5: this_State_0= ruleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode578);
                    this_State_0=ruleState();

                    state._fsp--;

                     
                            current = this_State_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:284:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode605);
                    this_ChoicePoint_1=ruleChoicePoint();

                    state._fsp--;

                     
                            current = this_ChoicePoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:294:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode632);
                    this_TrPoint_2=ruleTrPoint();

                    state._fsp--;

                     
                            current = this_TrPoint_2; 
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
    // $ANTLR end "ruleStateGraphNode"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:312:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:313:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:314:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState669);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState679); 

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:321:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:324:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:326:5: this_SimpleState_0= ruleSimpleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleState_in_ruleState726);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;

                     
                            current = this_SimpleState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:336:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState753);
                    this_RefinedState_1=ruleRefinedState();

                    state._fsp--;

                     
                            current = this_RefinedState_1; 
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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStateGraph"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:352:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:353:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:354:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph788);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph798); 

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
    // $ANTLR end "entryRuleStateGraph"


    // $ANTLR start "ruleStateGraph"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:361:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleStateGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_7=null;
        EObject lv_states_2_0 = null;

        EObject lv_trPoints_3_0 = null;

        EObject lv_chPoints_4_0 = null;

        EObject lv_transitions_5_0 = null;

        EObject lv_refinedTransitions_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:364:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:365:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:365:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:365:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:365:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:366:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleStateGraph844); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:375:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop6:
            do {
                int alt6=6;
                switch ( input.LA(1) ) {
                case 19:
                case 24:
                    {
                    alt6=1;
                    }
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 39:
                    {
                    alt6=5;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:375:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:375:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:376:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:376:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:377:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateGraph866);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_2_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:394:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:394:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:395:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:395:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:396:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraph893);
            	    lv_trPoints_3_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"trPoints",
            	            		lv_trPoints_3_0, 
            	            		"TrPoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:413:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:413:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:414:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:414:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:415:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraph920);
            	    lv_chPoints_4_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"chPoints",
            	            		lv_chPoints_4_0, 
            	            		"ChoicePoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:432:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:432:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:433:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:433:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:434:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateGraph947);
            	    lv_transitions_5_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_5_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:451:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:451:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:452:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:452:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:453:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateGraph974);
            	    lv_refinedTransitions_6_0=ruleRefinedTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"refinedTransitions",
            	            		lv_refinedTransitions_6_0, 
            	            		"RefinedTransition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleStateGraph988); 

                	newLeafNode(otherlv_7, grammarAccess.getStateGraphAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleStateGraph"


    // $ANTLR start "entryRuleStateMachine"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:481:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:482:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:483:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine1024);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine1034); 

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
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:490:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        EObject lv_states_3_0 = null;

        EObject lv_trPoints_4_0 = null;

        EObject lv_chPoints_5_0 = null;

        EObject lv_transitions_6_0 = null;

        EObject lv_refinedTransitions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:493:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:494:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:494:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:494:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:494:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:495:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleStateMachine1080); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleStateMachine1092); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:508:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop7:
            do {
                int alt7=6;
                switch ( input.LA(1) ) {
                case 19:
                case 24:
                    {
                    alt7=1;
                    }
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    {
                    alt7=2;
                    }
                    break;
                case 29:
                    {
                    alt7=3;
                    }
                    break;
                case 30:
                    {
                    alt7=4;
                    }
                    break;
                case 39:
                    {
                    alt7=5;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:508:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:508:2: ( (lv_states_3_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:509:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:509:1: (lv_states_3_0= ruleState )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:510:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine1114);
            	    lv_states_3_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_3_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:527:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:527:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:528:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:528:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:529:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine1141);
            	    lv_trPoints_4_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"trPoints",
            	            		lv_trPoints_4_0, 
            	            		"TrPoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:546:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:546:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:547:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:547:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:548:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine1168);
            	    lv_chPoints_5_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"chPoints",
            	            		lv_chPoints_5_0, 
            	            		"ChoicePoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:565:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:565:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:566:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:566:1: (lv_transitions_6_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:567:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine1195);
            	    lv_transitions_6_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_6_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:584:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:584:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:585:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:585:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:586:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateMachine1222);
            	    lv_refinedTransitions_7_0=ruleRefinedTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"refinedTransitions",
            	            		lv_refinedTransitions_7_0, 
            	            		"RefinedTransition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleStateMachine1236); 

                	newLeafNode(otherlv_8, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleSimpleState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:614:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:615:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:616:2: iv_ruleSimpleState= ruleSimpleState EOF
            {
             newCompositeNode(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_ruleSimpleState_in_entryRuleSimpleState1272);
            iv_ruleSimpleState=ruleSimpleState();

            state._fsp--;

             current =iv_ruleSimpleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleState1282); 

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
    // $ANTLR end "entryRuleSimpleState"


    // $ANTLR start "ruleSimpleState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:623:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) ;
    public final EObject ruleSimpleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_doCode_9_0 = null;

        EObject lv_subgraph_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:626:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:627:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:627:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:627:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleSimpleState1319); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:631:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:632:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:632:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:633:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleState1336); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimpleStateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:649:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==52) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:650:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:650:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:651:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSimpleState1362);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:667:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==16) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:667:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleSimpleState1376); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:671:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==20) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:671:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleSimpleState1389); 

                                	newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_1_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:675:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:676:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:676:1: (lv_entryCode_5_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:677:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState1410);
                            lv_entryCode_5_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"entryCode",
                                    		lv_entryCode_5_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:693:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:693:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleSimpleState1425); 

                                	newLeafNode(otherlv_6, grammarAccess.getSimpleStateAccess().getExitKeyword_3_2_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:697:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:698:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:698:1: (lv_exitCode_7_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:699:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState1446);
                            lv_exitCode_7_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"exitCode",
                                    		lv_exitCode_7_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:715:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:715:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleSimpleState1461); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDoKeyword_3_3_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:719:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:720:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:720:1: (lv_doCode_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:721:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState1482);
                            lv_doCode_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"doCode",
                                    		lv_doCode_9_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:737:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==23) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:737:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleSimpleState1497); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:741:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:742:1: (lv_subgraph_11_0= ruleStateGraph )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:742:1: (lv_subgraph_11_0= ruleStateGraph )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:743:3: lv_subgraph_11_0= ruleStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleStateGraph_in_ruleSimpleState1518);
                            lv_subgraph_11_0=ruleStateGraph();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"subgraph",
                                    		lv_subgraph_11_0, 
                                    		"StateGraph");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleSimpleState1532); 

                        	newLeafNode(otherlv_12, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_3_5());
                        

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
    // $ANTLR end "ruleSimpleState"


    // $ANTLR start "entryRuleRefinedState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:771:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:772:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:773:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             newCompositeNode(grammarAccess.getRefinedStateRule()); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState1570);
            iv_ruleRefinedState=ruleRefinedState();

            state._fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState1580); 

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
    // $ANTLR end "entryRuleRefinedState"


    // $ANTLR start "ruleRefinedState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:780:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleRefinedState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_docu_2_0 = null;

        EObject lv_entryCode_5_0 = null;

        EObject lv_exitCode_7_0 = null;

        EObject lv_doCode_9_0 = null;

        EObject lv_subgraph_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:783:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:784:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:784:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:784:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleRefinedState1617); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:788:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:789:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:789:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:790:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedStateRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedStateAccess().getTargetStateCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState1640);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:803:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==52) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:804:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:804:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:805:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedState1661);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRefinedState1674); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:825:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:825:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleRefinedState1687); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:829:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:830:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:830:1: (lv_entryCode_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:831:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState1708);
                    lv_entryCode_5_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"entryCode",
                            		lv_entryCode_5_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:847:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:847:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleRefinedState1723); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:851:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:852:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:852:1: (lv_exitCode_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:853:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState1744);
                    lv_exitCode_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"exitCode",
                            		lv_exitCode_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:869:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:869:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleRefinedState1759); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:873:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:874:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:874:1: (lv_doCode_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:875:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState1780);
                    lv_doCode_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"doCode",
                            		lv_doCode_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:891:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:891:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleRefinedState1795); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:895:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:896:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:896:1: (lv_subgraph_11_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:897:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState1816);
                    lv_subgraph_11_0=ruleStateGraph();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"subgraph",
                            		lv_subgraph_11_0, 
                            		"StateGraph");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleRefinedState1830); 

                	newLeafNode(otherlv_12, grammarAccess.getRefinedStateAccess().getRightCurlyBracketKeyword_8());
                

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
    // $ANTLR end "ruleRefinedState"


    // $ANTLR start "entryRuleDetailCode"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:925:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:926:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:927:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             newCompositeNode(grammarAccess.getDetailCodeRule()); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode1866);
            iv_ruleDetailCode=ruleDetailCode();

            state._fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode1876); 

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
    // $ANTLR end "entryRuleDetailCode"


    // $ANTLR start "ruleDetailCode"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:934:1: ruleDetailCode returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:937:28: ( ( () otherlv_1= '{' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:1: ( () otherlv_1= '{' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:1: ( () otherlv_1= '{' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:2: () otherlv_1= '{' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:939:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDetailCodeAccess().getDetailCodeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleDetailCode1922); 

                	newLeafNode(otherlv_1, grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:948:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:949:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:949:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:950:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode1939); 

            	    			newLeafNode(lv_lines_2_0, grammarAccess.getDetailCodeAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDetailCodeRule());
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleDetailCode1957); 

                	newLeafNode(otherlv_3, grammarAccess.getDetailCodeAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleDetailCode"


    // $ANTLR start "entryRuleTrPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:978:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:979:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:980:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint1993);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint2003); 

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
    // $ANTLR end "entryRuleTrPoint"


    // $ANTLR start "ruleTrPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:987:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:990:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:991:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:991:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 25:
            case 26:
                {
                alt20=1;
                }
                break;
            case 27:
                {
                alt20=2;
                }
                break;
            case 28:
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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:992:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint2050);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;

                     
                            current = this_TransitionPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1002:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint2077);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;

                     
                            current = this_EntryPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1012:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint2104);
                    this_ExitPoint_2=ruleExitPoint();

                    state._fsp--;

                     
                            current = this_ExitPoint_2; 
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
    // $ANTLR end "ruleTrPoint"


    // $ANTLR start "entryRuleTransitionPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1028:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1029:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1030:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint2139);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint2149); 

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
    // $ANTLR end "entryRuleTransitionPoint"


    // $ANTLR start "ruleTransitionPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1037:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1040:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1041:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1041:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1041:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1041:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1042:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1042:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1043:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,25,FOLLOW_25_in_ruleTransitionPoint2192); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleTransitionPoint2218); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1060:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1061:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1061:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1062:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint2235); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTransitionPointAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleTransitionPoint"


    // $ANTLR start "entryRuleEntryPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1086:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1087:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1088:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint2276);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint2286); 

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
    // $ANTLR end "entryRuleEntryPoint"


    // $ANTLR start "ruleEntryPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1095:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1098:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1099:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1099:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1099:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleEntryPoint2323); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1103:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1104:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1104:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1105:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint2340); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEntryPointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntryPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleEntryPoint"


    // $ANTLR start "entryRuleExitPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1129:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1130:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1131:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint2381);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint2391); 

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
    // $ANTLR end "entryRuleExitPoint"


    // $ANTLR start "ruleExitPoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1138:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1141:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1142:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1142:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1142:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleExitPoint2428); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1146:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1147:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1147:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1148:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint2445); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExitPointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExitPointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleExitPoint"


    // $ANTLR start "entryRuleChoicePoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1172:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1173:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1174:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint2486);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint2496); 

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
    // $ANTLR end "entryRuleChoicePoint"


    // $ANTLR start "ruleChoicePoint"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1181:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1184:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1185:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1185:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1185:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleChoicePoint2533); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1189:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1190:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1190:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1191:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint2550); 

            			newLeafNode(lv_name_1_0, grammarAccess.getChoicePointAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicePointRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1207:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==52) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1208:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1208:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1209:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint2576);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getChoicePointRule());
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
    // $ANTLR end "ruleChoicePoint"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1233:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1234:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1235:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition2613);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition2623); 

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1242:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1245:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1246:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1246:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==RULE_ID) ) {
                    int LA23_2 = input.LA(3);

                    if ( (LA23_2==31) ) {
                        int LA23_3 = input.LA(4);

                        if ( (LA23_3==RULE_ID||LA23_3==40||LA23_3==42) ) {
                            alt23=2;
                        }
                        else if ( (LA23_3==32) ) {
                            alt23=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 23, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA23_1==31) ) {
                    int LA23_3 = input.LA(3);

                    if ( (LA23_3==RULE_ID||LA23_3==40||LA23_3==42) ) {
                        alt23=2;
                    }
                    else if ( (LA23_3==32) ) {
                        alt23=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1247:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition2670);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;

                     
                            current = this_InitialTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1257:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition2697);
                    this_NonInitialTransition_1=ruleNonInitialTransition();

                    state._fsp--;

                     
                            current = this_NonInitialTransition_1; 
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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleNonInitialTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1273:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1274:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1275:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition2732);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition2742); 

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
    // $ANTLR end "entryRuleNonInitialTransition"


    // $ANTLR start "ruleNonInitialTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1282:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1285:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1286:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1286:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt24=3;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1287:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTransitionChainStartTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition2789);
                    this_TransitionChainStartTransition_0=ruleTransitionChainStartTransition();

                    state._fsp--;

                     
                            current = this_TransitionChainStartTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1297:5: this_ContinuationTransition_1= ruleContinuationTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition2816);
                    this_ContinuationTransition_1=ruleContinuationTransition();

                    state._fsp--;

                     
                            current = this_ContinuationTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1307:5: this_CPBranchTransition_2= ruleCPBranchTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition2843);
                    this_CPBranchTransition_2=ruleCPBranchTransition();

                    state._fsp--;

                     
                            current = this_CPBranchTransition_2; 
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
    // $ANTLR end "ruleNonInitialTransition"


    // $ANTLR start "entryRuleTransitionChainStartTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1323:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1324:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1325:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionChainStartTransitionRule()); 
            pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition2878);
            iv_ruleTransitionChainStartTransition=ruleTransitionChainStartTransition();

            state._fsp--;

             current =iv_ruleTransitionChainStartTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionChainStartTransition2888); 

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
    // $ANTLR end "entryRuleTransitionChainStartTransition"


    // $ANTLR start "ruleTransitionChainStartTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1332:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1335:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1336:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1336:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1337:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition2935);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1347:5: this_GuardedTransition_1= ruleGuardedTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getGuardedTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition2962);
                    this_GuardedTransition_1=ruleGuardedTransition();

                    state._fsp--;

                     
                            current = this_GuardedTransition_1; 
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
    // $ANTLR end "ruleTransitionChainStartTransition"


    // $ANTLR start "entryRuleInitialTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1363:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1364:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1365:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition2997);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition3007); 

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
    // $ANTLR end "entryRuleInitialTransition"


    // $ANTLR start "ruleInitialTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1372:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleInitialTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1375:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1376:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1376:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1376:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleInitialTransition3044); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1380:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1381:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1381:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1382:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition3061); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getInitialTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInitialTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleInitialTransition3079); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleInitialTransition3091); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleInitialTransition3103); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1410:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1411:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1411:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1412:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition3124);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1428:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1429:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1429:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1430:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition3145);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleInitialTransition3158); 

                	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1450:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1450:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleInitialTransition3171); 

                        	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1454:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1455:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1455:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1456:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition3192);
                    lv_action_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleInitialTransition3206); 

                	newLeafNode(otherlv_10, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_9());
                

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
    // $ANTLR end "ruleInitialTransition"


    // $ANTLR start "entryRuleContinuationTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1484:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1485:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1486:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition3242);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition3252); 

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
    // $ANTLR end "entryRuleContinuationTransition"


    // $ANTLR start "ruleContinuationTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1493:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
    public final EObject ruleContinuationTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_action_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1496:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1497:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1497:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1497:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleContinuationTransition3289); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1501:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1502:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1502:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1503:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition3306); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getContinuationTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContinuationTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleContinuationTransition3324); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1523:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1524:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1524:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1525:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3345);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleContinuationTransition3357); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1545:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1546:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1546:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1547:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3378);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1563:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==52) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1564:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1564:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1565:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition3399);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1581:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1581:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleContinuationTransition3413); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1585:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==34) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1585:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleContinuationTransition3426); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1589:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1590:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1590:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1591:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition3447);
                            lv_action_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"action",
                                    		lv_action_9_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleContinuationTransition3461); 

                        	newLeafNode(otherlv_10, grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_2());
                        

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
    // $ANTLR end "ruleContinuationTransition"


    // $ANTLR start "entryRuleTriggeredTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1619:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1620:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1621:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3499);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition3509); 

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
    // $ANTLR end "entryRuleTriggeredTransition"


    // $ANTLR start "ruleTriggeredTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1628:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_triggers_10_0 = null;

        EObject lv_triggers_12_0 = null;

        EObject lv_action_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1631:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1632:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1632:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1632:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleTriggeredTransition3546); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1636:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1637:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1637:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1638:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3563); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getTriggeredTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleTriggeredTransition3581); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1658:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1659:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1659:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1660:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3602);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTriggeredTransition3614); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1680:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1681:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1681:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1682:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3635);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1698:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==52) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1699:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1699:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1700:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition3656);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleTriggeredTransition3669); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleTriggeredTransition3681); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleTriggeredTransition3693); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1728:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1729:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1729:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1730:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition3714);
            lv_triggers_10_0=ruleTrigger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		add(
                   			current, 
                   			"triggers",
                    		lv_triggers_10_0, 
                    		"Trigger");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1746:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==36) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1746:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,36,FOLLOW_36_in_ruleTriggeredTransition3727); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1750:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1751:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1751:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1752:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition3748);
            	    lv_triggers_12_0=ruleTrigger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"triggers",
            	            		lv_triggers_12_0, 
            	            		"Trigger");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleTriggeredTransition3762); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1772:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==34) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1772:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,34,FOLLOW_34_in_ruleTriggeredTransition3775); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1776:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1777:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1777:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1778:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition3796);
                    lv_action_15_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_15_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,17,FOLLOW_17_in_ruleTriggeredTransition3810); 

                	newLeafNode(otherlv_16, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_14());
                

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
    // $ANTLR end "ruleTriggeredTransition"


    // $ANTLR start "entryRuleGuardedTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1806:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1807:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1808:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition3846);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardedTransition3856); 

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
    // $ANTLR end "entryRuleGuardedTransition"


    // $ANTLR start "ruleGuardedTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1815:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleGuardedTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_guard_9_0 = null;

        EObject lv_action_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1818:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1819:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1819:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1819:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleGuardedTransition3893); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1823:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1824:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1824:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1825:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuardedTransition3910); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getGuardedTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleGuardedTransition3928); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1845:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1846:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1846:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1847:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3949);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleGuardedTransition3961); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1867:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1868:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1868:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1869:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3982);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1885:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==52) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1886:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1886:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1887:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleGuardedTransition4003);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleGuardedTransition4016); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,37,FOLLOW_37_in_ruleGuardedTransition4028); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1911:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1912:1: (lv_guard_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1912:1: (lv_guard_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1913:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition4049);
            lv_guard_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"guard",
                    		lv_guard_9_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1929:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1929:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleGuardedTransition4062); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1933:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1934:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1934:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1935:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition4083);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleGuardedTransition4097); 

                	newLeafNode(otherlv_12, grammarAccess.getGuardedTransitionAccess().getRightCurlyBracketKeyword_11());
                

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
    // $ANTLR end "ruleGuardedTransition"


    // $ANTLR start "entryRuleCPBranchTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1963:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1964:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1965:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition4133);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition4143); 

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
    // $ANTLR end "entryRuleCPBranchTransition"


    // $ANTLR start "ruleCPBranchTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1972:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_action_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1975:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1976:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1976:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1976:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleCPBranchTransition4180); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1980:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1981:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1981:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1982:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition4197); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getCPBranchTransitionAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleCPBranchTransition4215); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2002:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2003:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2003:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2004:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4236);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_3_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleCPBranchTransition4248); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2024:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2025:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2025:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2026:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4269);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_5_0, 
                    		"TransitionTerminal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2042:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==52) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2043:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2043:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2044:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition4290);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_6_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleCPBranchTransition4303); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,38,FOLLOW_38_in_ruleCPBranchTransition4315); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2068:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2069:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2069:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2070:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4336);
            lv_condition_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_9_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2086:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2086:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleCPBranchTransition4349); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2090:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2091:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2091:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2092:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4370);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleCPBranchTransition4384); 

                	newLeafNode(otherlv_12, grammarAccess.getCPBranchTransitionAccess().getRightCurlyBracketKeyword_11());
                

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
    // $ANTLR end "ruleCPBranchTransition"


    // $ANTLR start "entryRuleRefinedTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2120:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2121:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2122:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
            {
             newCompositeNode(grammarAccess.getRefinedTransitionRule()); 
            pushFollow(FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition4420);
            iv_ruleRefinedTransition=ruleRefinedTransition();

            state._fsp--;

             current =iv_ruleRefinedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedTransition4430); 

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
    // $ANTLR end "entryRuleRefinedTransition"


    // $ANTLR start "ruleRefinedTransition"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2129:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) ;
    public final EObject ruleRefinedTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_docu_2_0 = null;

        EObject lv_action_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2132:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2133:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2133:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2133:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleRefinedTransition4467); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2137:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2138:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2138:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2139:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getTargetTransitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedTransition4490);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2152:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==52) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2153:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2153:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2154:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedTransition4511);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRefinedTransition4524); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleRefinedTransition4536); 

                	newLeafNode(otherlv_4, grammarAccess.getRefinedTransitionAccess().getActionKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2178:1: ( (lv_action_5_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2179:1: (lv_action_5_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2179:1: (lv_action_5_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2180:3: lv_action_5_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedTransition4557);
            lv_action_5_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"action",
                    		lv_action_5_0, 
                    		"DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleRefinedTransition4569); 

                	newLeafNode(otherlv_6, grammarAccess.getRefinedTransitionAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleRefinedTransition"


    // $ANTLR start "entryRuleTransitionTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2208:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2209:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2210:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal4605);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal4615); 

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
    // $ANTLR end "entryRuleTransitionTerminal"


    // $ANTLR start "ruleTransitionTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2217:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2220:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2221:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2221:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt44=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==EOF||(LA44_1>=16 && LA44_1<=17)||LA44_1==19||(LA44_1>=24 && LA44_1<=30)||LA44_1==33||LA44_1==39||LA44_1==52) ) {
                    alt44=1;
                }
                else if ( (LA44_1==41) ) {
                    alt44=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                alt44=2;
                }
                break;
            case 42:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2222:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal4662);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;

                     
                            current = this_StateTerminal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2232:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal4689);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2242:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal4716);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2252:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal4743);
                    this_ChoicepointTerminal_3=ruleChoicepointTerminal();

                    state._fsp--;

                     
                            current = this_ChoicepointTerminal_3; 
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
    // $ANTLR end "ruleTransitionTerminal"


    // $ANTLR start "entryRuleStateTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2268:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2269:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2270:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal4778);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal4788); 

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
    // $ANTLR end "entryRuleStateTerminal"


    // $ANTLR start "ruleStateTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2277:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2280:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2281:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2281:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2282:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2282:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2283:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal4832); 

            		newLeafNode(otherlv_0, grammarAccess.getStateTerminalAccess().getStateStateCrossReference_0()); 
            	

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
    // $ANTLR end "ruleStateTerminal"


    // $ANTLR start "entryRuleTrPointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2302:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2303:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2304:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal4867);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal4877); 

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
    // $ANTLR end "entryRuleTrPointTerminal"


    // $ANTLR start "ruleTrPointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2311:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2314:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2315:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2315:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2315:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleTrPointTerminal4914); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2319:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2320:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2320:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2321:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrPointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal4934); 

            		newLeafNode(otherlv_1, grammarAccess.getTrPointTerminalAccess().getTrPointTrPointCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleTrPointTerminal"


    // $ANTLR start "entryRuleSubStateTrPointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2340:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2341:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2342:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal4970);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal4980); 

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
    // $ANTLR end "entryRuleSubStateTrPointTerminal"


    // $ANTLR start "ruleSubStateTrPointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2349:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2352:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2353:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2353:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2353:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2353:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2354:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2354:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2355:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5025); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleSubStateTrPointTerminal5037); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2370:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2371:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2371:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2372:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5057); 

            		newLeafNode(otherlv_2, grammarAccess.getSubStateTrPointTerminalAccess().getStateStateCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleSubStateTrPointTerminal"


    // $ANTLR start "entryRuleChoicepointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2391:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2392:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2393:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal5093);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal5103); 

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
    // $ANTLR end "entryRuleChoicepointTerminal"


    // $ANTLR start "ruleChoicepointTerminal"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2400:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2403:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2404:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2404:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2404:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleChoicepointTerminal5140); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2408:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2409:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2409:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2410:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal5160); 

            		newLeafNode(otherlv_1, grammarAccess.getChoicepointTerminalAccess().getCpChoicePointCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleChoicepointTerminal"


    // $ANTLR start "entryRuleTrigger"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2429:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2430:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2431:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger5196);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger5206); 

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
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2438:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_msgFromIfPairs_1_0 = null;

        EObject lv_msgFromIfPairs_3_0 = null;

        EObject lv_guard_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2441:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2442:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2442:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2442:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleTrigger5243); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2446:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2447:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2447:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2448:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger5264);
            lv_msgFromIfPairs_1_0=ruleMessageFromIf();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggerRule());
            	        }
                   		add(
                   			current, 
                   			"msgFromIfPairs",
                    		lv_msgFromIfPairs_1_0, 
                    		"MessageFromIf");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2464:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==44) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2464:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleTrigger5277); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2468:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2469:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2469:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2470:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger5298);
            	    lv_msgFromIfPairs_3_0=ruleMessageFromIf();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"msgFromIfPairs",
            	            		lv_msgFromIfPairs_3_0, 
            	            		"MessageFromIf");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2486:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==37) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2487:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2487:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2488:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger5321);
                    lv_guard_4_0=ruleGuard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggerRule());
                    	        }
                           		set(
                           			current, 
                           			"guard",
                            		lv_guard_4_0, 
                            		"Guard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleTrigger5334); 

                	newLeafNode(otherlv_5, grammarAccess.getTriggerAccess().getGreaterThanSignKeyword_4());
                

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
    // $ANTLR end "ruleTrigger"


    // $ANTLR start "entryRuleMessageFromIf"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2516:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2517:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2518:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf5370);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf5380); 

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
    // $ANTLR end "entryRuleMessageFromIf"


    // $ANTLR start "ruleMessageFromIf"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2525:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2528:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2529:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2529:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2529:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2529:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2530:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2530:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2531:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf5425); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageAbstractMessageCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleMessageFromIf5437); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2546:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2547:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2547:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2548:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf5457); 

            		newLeafNode(otherlv_2, grammarAccess.getMessageFromIfAccess().getFromAbstractInterfaceItemCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleMessageFromIf"


    // $ANTLR start "entryRuleGuard"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2571:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2572:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2573:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard5497);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard5507); 

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
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2580:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2583:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2584:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2584:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2584:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleGuard5544); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2588:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2589:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2589:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2590:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard5565);
            lv_guard_1_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardRule());
            	        }
                   		set(
                   			current, 
                   			"guard",
                    		lv_guard_1_0, 
                    		"DetailCode");
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
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2616:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2617:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2618:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue5603);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue5613); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2625:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2628:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2629:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2629:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2629:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2629:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2630:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2630:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2631:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue5655); 

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

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleKeyValue5672); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2651:1: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2652:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2652:1: (lv_value_2_0= ruleLiteral )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2653:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleKeyValue5693);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2679:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2680:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2681:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType5732);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType5743); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2688:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2691:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2692:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType5782); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2707:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2708:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2709:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute5826);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute5836); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2716:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2719:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2720:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2720:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==47) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==49) ) {
                    int LA47_3 = input.LA(3);

                    if ( (LA47_3==RULE_ID) ) {
                        int LA47_4 = input.LA(4);

                        if ( (LA47_4==31) ) {
                            int LA47_5 = input.LA(5);

                            if ( ((LA47_5>=63 && LA47_5<=66)) ) {
                                alt47=1;
                            }
                            else if ( (LA47_5==16) ) {
                                alt47=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 47, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 47, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA47_0==48) ) {
                int LA47_2 = input.LA(2);

                if ( (LA47_2==49) ) {
                    int LA47_3 = input.LA(3);

                    if ( (LA47_3==RULE_ID) ) {
                        int LA47_4 = input.LA(4);

                        if ( (LA47_4==31) ) {
                            int LA47_5 = input.LA(5);

                            if ( ((LA47_5>=63 && LA47_5<=66)) ) {
                                alt47=1;
                            }
                            else if ( (LA47_5==16) ) {
                                alt47=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 47, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 47, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2721:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute5883);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2731:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute5910);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2747:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2748:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2749:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute5945);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute5955); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2756:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2759:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==47) ) {
                alt48=1;
            }
            else if ( (LA48_0==48) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2760:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2761:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2761:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2762:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,47,FOLLOW_47_in_ruleSimpleAnnotationAttribute5999); 

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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2776:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleSimpleAnnotationAttribute6030); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleSimpleAnnotationAttribute6043); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2784:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2785:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2785:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2786:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute6060); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleSimpleAnnotationAttribute6077); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2806:1: ( (lv_type_5_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2807:1: (lv_type_5_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2807:1: (lv_type_5_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2808:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute6098);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2832:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2833:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2834:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute6134);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute6144); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2841:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2844:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==47) ) {
                alt49=1;
            }
            else if ( (LA49_0==48) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2845:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2846:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2846:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2847:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,47,FOLLOW_47_in_ruleEnumAnnotationAttribute6188); 

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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2861:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleEnumAnnotationAttribute6219); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleEnumAnnotationAttribute6232); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2869:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2870:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2870:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2871:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute6249); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleEnumAnnotationAttribute6266); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleEnumAnnotationAttribute6278); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2895:1: ( (lv_values_6_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2896:1: (lv_values_6_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2896:1: (lv_values_6_0= RULE_STRING )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2897:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6295); 

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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2913:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==50) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2913:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,50,FOLLOW_50_in_ruleEnumAnnotationAttribute6313); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2917:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2918:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2918:1: (lv_values_8_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2919:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6330); 

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
            	    break loop50;
                }
            } while (true);

            otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleEnumAnnotationAttribute6349); 

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


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2949:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2950:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2951:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN6388);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN6399); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2958:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2961:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2962:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2962:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2963:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN6446);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2973:1: (kw= '.*' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==51) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2974:2: kw= '.*'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleImportedFQN6465); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2987:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2988:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2989:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation6507);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation6517); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2996:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2999:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3000:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3000:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3000:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3000:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3001:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleDocumentation6563); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3010:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_STRING) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3011:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3011:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3012:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation6580); 

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
            	    break loop52;
                }
            } while (true);

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleDocumentation6598); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3044:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3045:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3046:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral6638);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral6648); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3053:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3056:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3057:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3057:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt53=3;
            switch ( input.LA(1) ) {
            case 54:
            case 55:
                {
                alt53=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 56:
            case 57:
            case 58:
                {
                alt53=2;
                }
                break;
            case RULE_STRING:
                {
                alt53=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3058:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral6695);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3068:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral6722);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3078:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral6749);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3094:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3095:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3096:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral6784);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral6794); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3103:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3106:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3107:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3107:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3107:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3107:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3108:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3113:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==54) ) {
                alt54=1;
            }
            else if ( (LA54_0==55) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3113:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleBooleanLiteral6841); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3118:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3118:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3119:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3119:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3120:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,55,FOLLOW_55_in_ruleBooleanLiteral6865); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3141:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3142:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3143:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral6915);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral6925); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3150:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3153:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3154:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3154:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt55=2;
            switch ( input.LA(1) ) {
            case 56:
                {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==58) ) {
                    alt55=2;
                }
                else if ( (LA55_1==RULE_INT) ) {
                    int LA55_3 = input.LA(3);

                    if ( (LA55_3==58) ) {
                        alt55=2;
                    }
                    else if ( (LA55_3==EOF) ) {
                        alt55=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA55_2 = input.LA(2);

                if ( (LA55_2==RULE_INT) ) {
                    int LA55_3 = input.LA(3);

                    if ( (LA55_3==58) ) {
                        alt55=2;
                    }
                    else if ( (LA55_3==EOF) ) {
                        alt55=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA55_2==58) ) {
                    alt55=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA55_3 = input.LA(2);

                if ( (LA55_3==58) ) {
                    alt55=2;
                }
                else if ( (LA55_3==EOF) ) {
                    alt55=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt55=1;
                }
                break;
            case 58:
                {
                alt55=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3155:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral6972);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3165:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral6999);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3181:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3182:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3183:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7034);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral7044); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3190:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3193:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3194:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3194:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3194:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3194:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3195:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3200:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3201:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3201:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3202:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral7099);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3226:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3227:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3228:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral7135);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral7145); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3235:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3238:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3240:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3245:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3246:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3246:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3247:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral7200);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3271:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3272:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3273:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral7236);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral7246); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3280:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3283:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3284:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3284:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3284:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3284:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3285:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3290:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3291:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3291:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3292:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral7297); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3316:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3317:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3318:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger7339);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger7350); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3325:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3328:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3329:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3329:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_INT||(LA56_0>=56 && LA56_0<=57)) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_HEX) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3330:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger7397);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3342:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger7430);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3360:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3364:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3365:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger7482);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger7493); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3375:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3379:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3380:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3380:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3380:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3380:2: (kw= '+' | kw= '-' )?
            int alt57=3;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==56) ) {
                alt57=1;
            }
            else if ( (LA57_0==57) ) {
                alt57=2;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3381:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleSignedInteger7536); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3388:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleSignedInteger7555); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger7572); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3411:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3415:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3416:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal7628);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal7639); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3426:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3430:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3431:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal7682); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3449:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3450:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3451:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal7731);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal7742); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3458:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3461:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3462:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3462:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt58=4;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3463:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal7789);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3475:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal7822);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3487:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal7855);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3499:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal7888);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3517:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3521:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3522:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal7940);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal7951); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3532:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3536:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3537:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3537:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3537:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3537:2: (kw= '+' | kw= '-' )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==56) ) {
                alt59=1;
            }
            else if ( (LA59_0==57) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3538:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleDecimal7994); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3545:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleDecimal8013); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal8030); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,58,FOLLOW_58_in_ruleDecimal8048); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal8063); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3581:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3585:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3586:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal8119);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal8130); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3596:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3600:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3601:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3601:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3601:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3601:2: (kw= '+' | kw= '-' )?
            int alt60=3;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            else if ( (LA60_0==57) ) {
                alt60=2;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3602:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleDotDecimal8173); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3609:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleDotDecimal8192); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,58,FOLLOW_58_in_ruleDotDecimal8207); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal8222); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3638:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3642:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3643:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot8278);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot8289); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3653:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3657:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3658:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3658:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3658:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3658:2: (kw= '+' | kw= '-' )?
            int alt61=3;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==56) ) {
                alt61=1;
            }
            else if ( (LA61_0==57) ) {
                alt61=2;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3659:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleDecimalDot8332); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3666:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleDecimalDot8351); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot8368); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,58,FOLLOW_58_in_ruleDecimalDot8386); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3695:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3699:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3700:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp8437);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp8448); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3710:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3714:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3715:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3715:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3715:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3715:2: (kw= '+' | kw= '-' )?
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==56) ) {
                alt62=1;
            }
            else if ( (LA62_0==57) ) {
                alt62=2;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3716:2: kw= '+'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleDecimalExp8491); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3723:2: kw= '-'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleDecimalExp8510); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp8527); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,58,FOLLOW_58_in_ruleDecimalExp8545); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp8560); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp8580); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3766:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3767:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3768:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN8630);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN8641); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3775:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3778:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3779:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3779:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3779:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN8681); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3786:1: (kw= '.' this_ID_2= RULE_ID )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==58) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3787:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,58,FOLLOW_58_in_ruleFQN8700); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN8715); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop63;
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


    // $ANTLR start "ruleComponentCommunicationType"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3807:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3809:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3810:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3810:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt64=1;
                }
                break;
            case 60:
                {
                alt64=2;
                }
                break;
            case 61:
                {
                alt64=3;
                }
                break;
            case 62:
                {
                alt64=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3810:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3810:2: (enumLiteral_0= 'eventdriven' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3810:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_59_in_ruleComponentCommunicationType8776); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3816:6: (enumLiteral_1= 'datadriven' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3816:6: (enumLiteral_1= 'datadriven' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3816:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_60_in_ruleComponentCommunicationType8793); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3822:6: (enumLiteral_2= 'async' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3822:6: (enumLiteral_2= 'async' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3822:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_61_in_ruleComponentCommunicationType8810); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3828:6: (enumLiteral_3= 'sync' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3828:6: (enumLiteral_3= 'sync' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3828:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_62_in_ruleComponentCommunicationType8827); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getComponentCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleComponentCommunicationType"


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3838:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3840:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3841:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3841:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt65=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt65=1;
                }
                break;
            case 64:
                {
                alt65=2;
                }
                break;
            case 65:
                {
                alt65=3;
                }
                break;
            case 66:
                {
                alt65=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3841:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3841:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3841:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_63_in_ruleLiteralType8872); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3847:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3847:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3847:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_64_in_ruleLiteralType8889); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3853:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3853:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3853:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_65_in_ruleLiteralType8906); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3859:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3859:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3859:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_66_in_ruleLiteralType8923); 

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


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA58 dfa58 = new DFA58(this);
    static final String DFA24_eotS =
        "\32\uffff";
    static final String DFA24_eofS =
        "\14\uffff\1\21\6\uffff\2\21\1\uffff\1\21\2\uffff\1\21";
    static final String DFA24_minS =
        "\1\36\1\4\1\37\1\4\1\41\4\4\3\41\1\20\2\4\1\5\1\21\1\uffff\1\4"+
        "\2\20\1\5\1\20\2\uffff\1\20";
    static final String DFA24_maxS =
        "\1\36\2\37\1\52\1\51\3\4\1\52\3\41\1\64\2\4\1\65\1\46\1\uffff\1"+
        "\4\2\64\1\65\1\47\2\uffff\1\64";
    static final String DFA24_acceptS =
        "\21\uffff\1\2\5\uffff\1\1\1\3\1\uffff";
    static final String DFA24_specialS =
        "\32\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1",
            "\1\2\32\uffff\1\3",
            "\1\3",
            "\1\4\43\uffff\1\5\1\uffff\1\6",
            "\1\10\7\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\43\uffff\1\15\1\uffff\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\1\uffff"+
            "\1\22\12\uffff\1\17",
            "\1\23",
            "\1\24",
            "\1\25\57\uffff\1\26",
            "\1\21\20\uffff\1\21\1\27\1\uffff\1\27\1\30",
            "",
            "\1\31",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\14\uffff"+
            "\1\17",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\14\uffff"+
            "\1\17",
            "\1\25\57\uffff\1\26",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21",
            "",
            "",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\14\uffff"+
            "\1\17"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1286:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String DFA25_eotS =
        "\31\uffff";
    static final String DFA25_eofS =
        "\31\uffff";
    static final String DFA25_minS =
        "\1\36\1\4\1\37\1\4\1\41\4\4\2\41\1\20\2\4\1\41\1\4\1\5\1\43\3\20"+
        "\1\5\1\20\2\uffff";
    static final String DFA25_maxS =
        "\1\36\2\37\1\52\1\51\2\4\1\52\1\4\2\41\1\64\2\4\1\41\1\4\1\65\1"+
        "\45\3\64\1\65\1\20\2\uffff";
    static final String DFA25_acceptS =
        "\27\uffff\1\1\1\2";
    static final String DFA25_specialS =
        "\31\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1",
            "\1\2\32\uffff\1\3",
            "\1\3",
            "\1\4\43\uffff\1\5\1\uffff\1\6",
            "\1\7\7\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\43\uffff\1\14\1\uffff\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\21\30\uffff\1\17\12\uffff\1\20",
            "\1\22",
            "\1\23",
            "\1\7",
            "\1\24",
            "\1\25\57\uffff\1\26",
            "\1\27\1\uffff\1\30",
            "\1\21\43\uffff\1\20",
            "\1\21\43\uffff\1\20",
            "\1\21\43\uffff\1\20",
            "\1\25\57\uffff\1\26",
            "\1\21",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1336:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
    static final String DFA58_eotS =
        "\12\uffff";
    static final String DFA58_eofS =
        "\5\uffff\1\7\1\10\3\uffff";
    static final String DFA58_minS =
        "\3\6\1\72\1\uffff\1\6\1\10\3\uffff";
    static final String DFA58_maxS =
        "\4\72\1\uffff\1\6\1\10\3\uffff";
    static final String DFA58_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\1\1\4";
    static final String DFA58_specialS =
        "\12\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\3\61\uffff\1\1\1\2\1\4",
            "\1\3\63\uffff\1\4",
            "\1\3\63\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "3462:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleFSMModel_in_entryRuleFSMModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFSMModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelComponent_in_ruleFSMModel130 = new BitSet(new long[]{0x7800000000006002L});
    public static final BitSet FOLLOW_ruleModelComponent_in_entryRuleModelComponent166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelComponent176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModelComponent264 = new BitSet(new long[]{0x7800000000006000L});
    public static final BitSet FOLLOW_ruleComponentCommunicationType_in_ruleModelComponent352 = new BitSet(new long[]{0x7800000000006000L});
    public static final BitSet FOLLOW_14_in_ruleModelComponent404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelComponent421 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleModelComponent439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleModelComponent462 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleModelComponent485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_ruleState726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleStateGraph844 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraph866 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraph893 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraph920 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateGraph947 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateGraph974 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_17_in_ruleStateGraph988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine1024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleStateMachine1080 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStateMachine1092 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine1114 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine1141 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine1168 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine1195 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateMachine1222 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_17_in_ruleStateMachine1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState1272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleState1319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState1336 = new BitSet(new long[]{0x0010000000010002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSimpleState1362 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleSimpleState1376 = new BitSet(new long[]{0x0000000000F20000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleState1389 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState1410 = new BitSet(new long[]{0x0000000000E20000L});
    public static final BitSet FOLLOW_21_in_ruleSimpleState1425 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState1446 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_22_in_ruleSimpleState1461 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState1482 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_23_in_ruleSimpleState1497 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleSimpleState1518 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSimpleState1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRefinedState1617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState1640 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedState1661 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRefinedState1674 = new BitSet(new long[]{0x0000000000F20000L});
    public static final BitSet FOLLOW_20_in_ruleRefinedState1687 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState1708 = new BitSet(new long[]{0x0000000000E20000L});
    public static final BitSet FOLLOW_21_in_ruleRefinedState1723 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState1744 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_22_in_ruleRefinedState1759 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState1780 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_23_in_ruleRefinedState1795 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState1816 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRefinedState1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDetailCode1922 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode1939 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleDetailCode1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint1993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint2139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTransitionPoint2192 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTransitionPoint2218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint2276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleEntryPoint2323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint2381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleExitPoint2428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint2486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleChoicePoint2533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint2550 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition2613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition2732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition2878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionChainStartTransition2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition2997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleInitialTransition3044 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition3061 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleInitialTransition3079 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleInitialTransition3091 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleInitialTransition3103 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition3124 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition3145 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInitialTransition3158 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleInitialTransition3171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition3192 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInitialTransition3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition3242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleContinuationTransition3289 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition3306 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleContinuationTransition3324 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3345 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleContinuationTransition3357 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3378 = new BitSet(new long[]{0x0010000000010002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition3399 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleContinuationTransition3413 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleContinuationTransition3426 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition3447 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleContinuationTransition3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTriggeredTransition3546 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3563 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleTriggeredTransition3581 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3602 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTriggeredTransition3614 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3635 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition3656 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTriggeredTransition3669 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTriggeredTransition3681 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTriggeredTransition3693 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition3714 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_36_in_ruleTriggeredTransition3727 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition3748 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_17_in_ruleTriggeredTransition3762 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleTriggeredTransition3775 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition3796 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTriggeredTransition3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition3846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardedTransition3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleGuardedTransition3893 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuardedTransition3910 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleGuardedTransition3928 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3949 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleGuardedTransition3961 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3982 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleGuardedTransition4003 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGuardedTransition4016 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleGuardedTransition4028 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition4049 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleGuardedTransition4062 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition4083 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGuardedTransition4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition4133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleCPBranchTransition4180 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition4197 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCPBranchTransition4215 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4236 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleCPBranchTransition4248 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4269 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition4290 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCPBranchTransition4303 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCPBranchTransition4315 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4336 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleCPBranchTransition4349 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4370 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCPBranchTransition4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition4420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedTransition4430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleRefinedTransition4467 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedTransition4490 = new BitSet(new long[]{0x0010000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedTransition4511 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRefinedTransition4524 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRefinedTransition4536 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedTransition4557 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRefinedTransition4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal4605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal4615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal4716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal4778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal4867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTrPointTerminal4914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal4934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal4970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal4980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5025 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSubStateTrPointTerminal5037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal5093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal5103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleChoicepointTerminal5140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger5196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger5206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTrigger5243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger5264 = new BitSet(new long[]{0x0000302000000000L});
    public static final BitSet FOLLOW_44_in_ruleTrigger5277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger5298 = new BitSet(new long[]{0x0000302000000000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger5321 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTrigger5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf5370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf5425 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleMessageFromIf5437 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard5497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard5507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGuard5544 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard5565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue5603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue5655 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleKeyValue5672 = new BitSet(new long[]{0x07C00000000000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType5732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType5743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute5826 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute5945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSimpleAnnotationAttribute5999 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_48_in_ruleSimpleAnnotationAttribute6030 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleSimpleAnnotationAttribute6043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute6060 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSimpleAnnotationAttribute6077 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute6134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEnumAnnotationAttribute6188 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_48_in_ruleEnumAnnotationAttribute6219 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleEnumAnnotationAttribute6232 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute6249 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEnumAnnotationAttribute6266 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEnumAnnotationAttribute6278 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6295 = new BitSet(new long[]{0x0004000000020000L});
    public static final BitSet FOLLOW_50_in_ruleEnumAnnotationAttribute6313 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6330 = new BitSet(new long[]{0x0004000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEnumAnnotationAttribute6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN6388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN6446 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleImportedFQN6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation6507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDocumentation6563 = new BitSet(new long[]{0x0020000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation6580 = new BitSet(new long[]{0x0020000000000020L});
    public static final BitSet FOLLOW_53_in_ruleDocumentation6598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral6638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral6749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral6784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral6794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleBooleanLiteral6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleBooleanLiteral6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral6915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral6972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral6999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral7099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral7135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral7145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral7200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral7236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral7246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral7297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger7339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger7350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger7397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger7430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger7482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSignedInteger7536 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_57_in_ruleSignedInteger7555 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger7572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal7628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal7639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal7682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal7731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal7742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal7789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal7855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal7888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal7940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal7951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDecimal7994 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_57_in_ruleDecimal8013 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal8030 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleDecimal8048 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal8063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal8119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal8130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDotDecimal8173 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_57_in_ruleDotDecimal8192 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleDotDecimal8207 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal8222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot8278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot8289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDecimalDot8332 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_57_in_ruleDecimalDot8351 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot8368 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleDecimalDot8386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp8437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp8448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDecimalExp8491 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_57_in_ruleDecimalExp8510 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp8527 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleDecimalExp8545 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp8560 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp8580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN8630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN8641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN8681 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleFQN8700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN8715 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_59_in_ruleComponentCommunicationType8776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleComponentCommunicationType8793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleComponentCommunicationType8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleComponentCommunicationType8827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleLiteralType8872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleLiteralType8889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLiteralType8906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleLiteralType8923 = new BitSet(new long[]{0x0000000000000002L});

}
