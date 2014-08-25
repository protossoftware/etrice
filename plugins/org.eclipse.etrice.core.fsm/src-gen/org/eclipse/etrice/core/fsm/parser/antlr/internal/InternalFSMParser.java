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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_EXP", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'ModelComponent'", "'extends'", "'{'", "'}'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "':'", "'initial'", "'->'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'of'", "'cp'", "'<'", "'|'", "'>'", "'in'", "'('", "','", "')'", "'out'", "'='", "'optional'", "'mandatory'", "'attribute'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'eventdriven'", "'datadriven'", "'async'", "'sync'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_EXP=8;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
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
    public static final int T__70=70;
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

                if ( ((LA1_0>=13 && LA1_0<=14)||(LA1_0>=63 && LA1_0<=66)) ) {
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
                else if ( LA2_0 >=63 && LA2_0<=66 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1) ) {
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


    // $ANTLR start "entryRuleStateGraph"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:312:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:313:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:314:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph669);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph679); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:321:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:324:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:325:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:326:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleStateGraph725); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:335:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop5:
            do {
                int alt5=6;
                switch ( input.LA(1) ) {
                case 19:
                case 24:
                    {
                    alt5=1;
                    }
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    {
                    alt5=2;
                    }
                    break;
                case 29:
                    {
                    alt5=3;
                    }
                    break;
                case 30:
                    {
                    alt5=4;
                    }
                    break;
                case 39:
                    {
                    alt5=5;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:335:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:335:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:336:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:336:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:337:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateGraph747);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:354:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:354:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:355:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:355:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:356:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraph774);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:373:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:373:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:374:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:374:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:375:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraph801);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:392:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:392:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:393:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:393:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:394:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateGraph828);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:411:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:411:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:412:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:412:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:413:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateGraph855);
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
            	    break loop5;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleStateGraph869); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:441:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:442:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:443:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine905);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine915); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:450:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:453:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:454:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:454:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:454:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:454:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:455:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleStateMachine961); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleStateMachine973); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:468:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:468:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:468:2: ( (lv_states_3_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:469:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:469:1: (lv_states_3_0= ruleState )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:470:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine995);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:487:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:487:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:488:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:488:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:489:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine1022);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:506:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:506:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:507:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:507:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:508:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine1049);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:525:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:525:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:526:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:526:1: (lv_transitions_6_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:527:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine1076);
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
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:544:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:544:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:545:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:545:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:546:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateMachine1103);
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
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleStateMachine1117); 

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


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:574:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:575:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:576:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState1153);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState1163); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:583:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:586:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:587:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:587:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            else if ( (LA7_0==24) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:588:5: this_SimpleState_0= ruleSimpleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleState_in_ruleState1210);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;

                     
                            current = this_SimpleState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:598:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState1237);
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

            if ( (LA8_0==56) ) {
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

            if ( (LA14_0==56) ) {
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:934:1: ruleDetailCode returns [EObject current=null] : ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_used_1_0=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:937:28: ( ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:1: ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:1: ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:2: () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:938:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:939:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDetailCodeAccess().getDetailCodeAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:944:2: ( (lv_used_1_0= '{' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:945:1: (lv_used_1_0= '{' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:945:1: (lv_used_1_0= '{' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:946:3: lv_used_1_0= '{'
            {
            lv_used_1_0=(Token)match(input,16,FOLLOW_16_in_ruleDetailCode1928); 

                    newLeafNode(lv_used_1_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDetailCodeRule());
            	        }
                   		setWithLastConsumed(current, "used", true, "{");
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:959:2: ( (lv_lines_2_0= RULE_STRING ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:960:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:960:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:961:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode1958); 

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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleDetailCode1976); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:989:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:990:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:991:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint2012);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint2022); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:998:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1001:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1002:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1002:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1003:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint2069);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;

                     
                            current = this_TransitionPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1013:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint2096);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;

                     
                            current = this_EntryPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1023:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint2123);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1039:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1040:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1041:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint2158);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint2168); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1048:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1051:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1052:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1052:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1052:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1052:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1053:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1053:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1054:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,25,FOLLOW_25_in_ruleTransitionPoint2211); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleTransitionPoint2237); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1071:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1072:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1072:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1073:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint2254); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1097:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1098:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1099:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint2295);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint2305); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1106:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1109:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1110:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1110:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1110:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleEntryPoint2342); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1114:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1115:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1115:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1116:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint2359); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1140:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1141:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1142:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint2400);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint2410); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1149:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1152:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1153:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1153:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1153:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleExitPoint2447); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1157:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1158:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1158:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1159:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint2464); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1183:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1184:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1185:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint2505);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint2515); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1192:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1195:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1196:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1196:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1196:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleChoicePoint2552); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1200:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1201:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1201:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1202:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint2569); 

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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1218:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1219:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1219:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1220:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint2595);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1244:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1245:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1246:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition2632);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition2642); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1253:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1256:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1257:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1257:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1258:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition2689);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;

                     
                            current = this_InitialTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1268:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition2716);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1284:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1285:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1286:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition2751);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition2761); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1293:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1296:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1297:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1297:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt24=3;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1298:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTransitionChainStartTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition2808);
                    this_TransitionChainStartTransition_0=ruleTransitionChainStartTransition();

                    state._fsp--;

                     
                            current = this_TransitionChainStartTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1308:5: this_ContinuationTransition_1= ruleContinuationTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition2835);
                    this_ContinuationTransition_1=ruleContinuationTransition();

                    state._fsp--;

                     
                            current = this_ContinuationTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1318:5: this_CPBranchTransition_2= ruleCPBranchTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition2862);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1334:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1335:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1336:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionChainStartTransitionRule()); 
            pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition2897);
            iv_ruleTransitionChainStartTransition=ruleTransitionChainStartTransition();

            state._fsp--;

             current =iv_ruleTransitionChainStartTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionChainStartTransition2907); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1343:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1346:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1347:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1347:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1348:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition2954);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1358:5: this_GuardedTransition_1= ruleGuardedTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getGuardedTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition2981);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1374:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1375:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1376:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition3016);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition3026); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1383:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1386:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1387:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1387:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1387:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleInitialTransition3063); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1391:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1392:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1392:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1393:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition3080); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleInitialTransition3098); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleInitialTransition3110); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleInitialTransition3122); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1421:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1422:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1422:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1423:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition3143);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1439:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==56) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1440:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1440:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1441:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition3164);
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

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleInitialTransition3177); 

                	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1461:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1461:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleInitialTransition3190); 

                        	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1465:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1466:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1466:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1467:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition3211);
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

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleInitialTransition3225); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1495:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1496:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1497:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition3261);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition3271); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1504:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1507:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1508:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1508:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1508:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleContinuationTransition3308); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1512:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1513:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1513:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1514:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition3325); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleContinuationTransition3343); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1534:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1535:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1535:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1536:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3364);
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleContinuationTransition3376); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1556:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1557:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1557:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1558:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3397);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1574:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==56) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1575:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1575:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1576:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition3418);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1592:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1592:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleContinuationTransition3432); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1596:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==34) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1596:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleContinuationTransition3445); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1600:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1601:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1601:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1602:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition3466);
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

                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleContinuationTransition3480); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1630:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1631:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1632:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3518);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition3528); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1639:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1642:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1643:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1643:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1643:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleTriggeredTransition3565); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1647:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1648:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1648:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1649:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3582); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleTriggeredTransition3600); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1669:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1670:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1670:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1671:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3621);
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTriggeredTransition3633); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1691:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1692:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1692:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1693:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3654);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1709:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==56) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1710:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1710:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1711:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition3675);
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

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleTriggeredTransition3688); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleTriggeredTransition3700); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleTriggeredTransition3712); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1739:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1740:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1740:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1741:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition3733);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1757:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==36) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1757:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,36,FOLLOW_36_in_ruleTriggeredTransition3746); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1761:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1762:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1762:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1763:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition3767);
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

            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleTriggeredTransition3781); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1783:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==34) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1783:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,34,FOLLOW_34_in_ruleTriggeredTransition3794); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1787:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1788:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1788:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1789:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition3815);
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

            otherlv_16=(Token)match(input,17,FOLLOW_17_in_ruleTriggeredTransition3829); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1817:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1818:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1819:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition3865);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardedTransition3875); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1826:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1829:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1830:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1830:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1830:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleGuardedTransition3912); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1834:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1835:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1835:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1836:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuardedTransition3929); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleGuardedTransition3947); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1856:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1857:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1857:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1858:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3968);
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleGuardedTransition3980); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1878:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1879:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1879:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1880:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition4001);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1896:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==56) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1897:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1897:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1898:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleGuardedTransition4022);
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

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleGuardedTransition4035); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,37,FOLLOW_37_in_ruleGuardedTransition4047); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1922:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1923:1: (lv_guard_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1923:1: (lv_guard_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1924:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition4068);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1940:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1940:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleGuardedTransition4081); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1944:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1945:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1945:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1946:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition4102);
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

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleGuardedTransition4116); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1974:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1975:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1976:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition4152);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition4162); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1983:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1986:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1987:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1987:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1987:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleCPBranchTransition4199); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1991:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1992:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1992:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:1993:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition4216); 

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

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleCPBranchTransition4234); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2013:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2014:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2014:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2015:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4255);
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleCPBranchTransition4267); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2035:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2036:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2036:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2037:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4288);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2053:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==56) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2054:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2054:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2055:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition4309);
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

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleCPBranchTransition4322); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,38,FOLLOW_38_in_ruleCPBranchTransition4334); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2079:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2080:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2080:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2081:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4355);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2097:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2097:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleCPBranchTransition4368); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2101:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2102:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2102:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2103:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4389);
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

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleCPBranchTransition4403); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2131:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2132:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2133:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
            {
             newCompositeNode(grammarAccess.getRefinedTransitionRule()); 
            pushFollow(FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition4439);
            iv_ruleRefinedTransition=ruleRefinedTransition();

            state._fsp--;

             current =iv_ruleRefinedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedTransition4449); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2140:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2143:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2144:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2144:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2144:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleRefinedTransition4486); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2148:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2149:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2149:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2150:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getTargetTransitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedTransition4509);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2163:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==56) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2164:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2164:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2165:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedTransition4530);
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRefinedTransition4543); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleRefinedTransition4555); 

                	newLeafNode(otherlv_4, grammarAccess.getRefinedTransitionAccess().getActionKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2189:1: ( (lv_action_5_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2190:1: (lv_action_5_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2190:1: (lv_action_5_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2191:3: lv_action_5_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedTransition4576);
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

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleRefinedTransition4588); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2219:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2220:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2221:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal4624);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal4634); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2228:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2231:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2232:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2232:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt44=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==41) ) {
                    alt44=3;
                }
                else if ( (LA44_1==EOF||(LA44_1>=16 && LA44_1<=17)||LA44_1==19||(LA44_1>=24 && LA44_1<=30)||LA44_1==33||LA44_1==39||LA44_1==56) ) {
                    alt44=1;
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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2233:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal4681);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;

                     
                            current = this_StateTerminal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2243:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal4708);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2253:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal4735);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2263:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal4762);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2279:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2280:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2281:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal4797);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal4807); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2288:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2291:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2292:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2292:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2293:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2293:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2294:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal4851); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2313:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2314:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2315:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal4886);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal4896); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2322:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2325:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2326:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2326:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2326:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleTrPointTerminal4933); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2330:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2331:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2331:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2332:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrPointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal4953); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2351:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2352:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2353:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal4989);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal4999); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2360:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2363:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2364:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2364:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2364:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2364:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2365:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2365:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2366:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5044); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleSubStateTrPointTerminal5056); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2381:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2382:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2382:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2383:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5076); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2402:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2403:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2404:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal5112);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal5122); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2411:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2414:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2415:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2415:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2415:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleChoicepointTerminal5159); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2419:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2420:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2420:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2421:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal5179); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2440:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2441:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2442:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger5215);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger5225); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2449:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2452:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2453:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2453:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2453:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleTrigger5262); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2457:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2458:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2458:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2459:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger5283);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2475:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==44) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2475:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleTrigger5296); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2479:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2480:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2480:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2481:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger5317);
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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2497:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==37) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2498:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2498:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2499:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger5340);
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

            otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleTrigger5353); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2527:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2528:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2529:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf5389);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf5399); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2536:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2539:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2540:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2540:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2540:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2540:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2541:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2541:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2542:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf5444); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageEObjectCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleMessageFromIf5456); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2557:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2558:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2558:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2559:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf5476); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2580:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2581:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2582:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard5514);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard5524); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2589:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2592:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2593:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2593:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2593:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleGuard5561); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2597:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2598:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2598:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2599:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard5582);
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


    // $ANTLR start "entryRuleSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2625:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2626:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2627:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule5620);
            iv_ruleSemanticsRule=ruleSemanticsRule();

            state._fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule5630); 

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
    // $ANTLR end "entryRuleSemanticsRule"


    // $ANTLR start "ruleSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2634:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2637:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2638:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2638:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==46) ) {
                alt47=1;
            }
            else if ( (LA47_0==50) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2639:5: this_InSemanticsRule_0= ruleInSemanticsRule
                    {
                     
                            newCompositeNode(grammarAccess.getSemanticsRuleAccess().getInSemanticsRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInSemanticsRule_in_ruleSemanticsRule5677);
                    this_InSemanticsRule_0=ruleInSemanticsRule();

                    state._fsp--;

                     
                            current = this_InSemanticsRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2649:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
                    {
                     
                            newCompositeNode(grammarAccess.getSemanticsRuleAccess().getOutSemanticsRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOutSemanticsRule_in_ruleSemanticsRule5704);
                    this_OutSemanticsRule_1=ruleOutSemanticsRule();

                    state._fsp--;

                     
                            current = this_OutSemanticsRule_1; 
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
    // $ANTLR end "ruleSemanticsRule"


    // $ANTLR start "entryRuleInSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2665:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2666:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2667:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getInSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleInSemanticsRule_in_entryRuleInSemanticsRule5739);
            iv_ruleInSemanticsRule=ruleInSemanticsRule();

            state._fsp--;

             current =iv_ruleInSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInSemanticsRule5749); 

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
    // $ANTLR end "entryRuleInSemanticsRule"


    // $ANTLR start "ruleInSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2674:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
    public final EObject ruleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_followUps_4_0 = null;

        EObject lv_followUps_6_0 = null;

        EObject lv_followUps_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2677:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2678:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2678:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2678:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleInSemanticsRule5786); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleInSemanticsRule5798); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2686:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2687:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2687:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2688:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInSemanticsRule5818); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2699:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2699:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleInSemanticsRule5831); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2703:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==46||LA49_0==50) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==47) ) {
                        alt49=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2703:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2703:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2704:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2704:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2705:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5853);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_4_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2722:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2722:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2722:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleInSemanticsRule5872); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2726:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2727:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2727:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2728:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5893);
                            lv_followUps_6_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_6_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2744:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt48=0;
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==48) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2744:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleInSemanticsRule5906); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2748:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2749:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2749:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2750:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5927);
                            	    lv_followUps_8_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"followUps",
                            	            		lv_followUps_8_0, 
                            	            		"SemanticsRule");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt48 >= 1 ) break loop48;
                                        EarlyExitException eee =
                                            new EarlyExitException(48, input);
                                        throw eee;
                                }
                                cnt48++;
                            } while (true);

                            otherlv_9=(Token)match(input,49,FOLLOW_49_in_ruleInSemanticsRule5941); 

                                	newLeafNode(otherlv_9, grammarAccess.getInSemanticsRuleAccess().getRightParenthesisKeyword_3_1_1_3());
                                

                            }


                            }
                            break;

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
    // $ANTLR end "ruleInSemanticsRule"


    // $ANTLR start "entryRuleOutSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2778:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2779:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2780:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getOutSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleOutSemanticsRule_in_entryRuleOutSemanticsRule5981);
            iv_ruleOutSemanticsRule=ruleOutSemanticsRule();

            state._fsp--;

             current =iv_ruleOutSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutSemanticsRule5991); 

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
    // $ANTLR end "entryRuleOutSemanticsRule"


    // $ANTLR start "ruleOutSemanticsRule"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2787:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
    public final EObject ruleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_followUps_4_0 = null;

        EObject lv_followUps_6_0 = null;

        EObject lv_followUps_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2790:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2791:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2791:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2791:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleOutSemanticsRule6028); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleOutSemanticsRule6040); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2799:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2800:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2800:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2801:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOutSemanticsRule6060); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2812:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==33) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2812:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleOutSemanticsRule6073); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2816:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==46||LA52_0==50) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==47) ) {
                        alt52=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2816:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2816:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2817:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2817:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2818:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6095);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_4_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2835:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2835:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2835:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleOutSemanticsRule6114); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2839:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2840:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2840:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2841:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6135);
                            lv_followUps_6_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_6_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2857:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt51=0;
                            loop51:
                            do {
                                int alt51=2;
                                int LA51_0 = input.LA(1);

                                if ( (LA51_0==48) ) {
                                    alt51=1;
                                }


                                switch (alt51) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2857:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleOutSemanticsRule6148); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2861:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2862:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2862:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2863:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6169);
                            	    lv_followUps_8_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"followUps",
                            	            		lv_followUps_8_0, 
                            	            		"SemanticsRule");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt51 >= 1 ) break loop51;
                                        EarlyExitException eee =
                                            new EarlyExitException(51, input);
                                        throw eee;
                                }
                                cnt51++;
                            } while (true);

                            otherlv_9=(Token)match(input,49,FOLLOW_49_in_ruleOutSemanticsRule6183); 

                                	newLeafNode(otherlv_9, grammarAccess.getOutSemanticsRuleAccess().getRightParenthesisKeyword_3_1_1_3());
                                

                            }


                            }
                            break;

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
    // $ANTLR end "ruleOutSemanticsRule"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2893:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2894:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2895:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue6225);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue6235); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2902:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2905:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2906:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2906:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2906:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2906:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2907:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2907:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2908:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue6277); 

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

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleKeyValue6294); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2928:1: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2929:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2929:1: (lv_value_2_0= ruleLiteral )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2930:3: lv_value_2_0= ruleLiteral
            {
             
            	        newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleKeyValue6315);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2956:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2957:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2958:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType6354);
            iv_ruleAnnotationTargetType=ruleAnnotationTargetType();

            state._fsp--;

             current =iv_ruleAnnotationTargetType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType6365); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2965:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2968:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2969:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType6404); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2984:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2985:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2986:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute6448);
            iv_ruleAnnotationAttribute=ruleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute6458); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2993:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2996:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2997:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2997:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==52) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==54) ) {
                    int LA54_3 = input.LA(3);

                    if ( (LA54_3==RULE_ID) ) {
                        int LA54_4 = input.LA(4);

                        if ( (LA54_4==31) ) {
                            int LA54_5 = input.LA(5);

                            if ( (LA54_5==16) ) {
                                alt54=2;
                            }
                            else if ( ((LA54_5>=67 && LA54_5<=70)) ) {
                                alt54=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 54, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 54, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA54_0==53) ) {
                int LA54_2 = input.LA(2);

                if ( (LA54_2==54) ) {
                    int LA54_3 = input.LA(3);

                    if ( (LA54_3==RULE_ID) ) {
                        int LA54_4 = input.LA(4);

                        if ( (LA54_4==31) ) {
                            int LA54_5 = input.LA(5);

                            if ( (LA54_5==16) ) {
                                alt54=2;
                            }
                            else if ( ((LA54_5>=67 && LA54_5<=70)) ) {
                                alt54=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 54, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 54, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:2998:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute6505);
                    this_SimpleAnnotationAttribute_0=ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     
                            current = this_SimpleAnnotationAttribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3008:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute6532);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3024:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3025:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3026:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute6567);
            iv_ruleSimpleAnnotationAttribute=ruleSimpleAnnotationAttribute();

            state._fsp--;

             current =iv_ruleSimpleAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute6577); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3033:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3036:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                alt55=1;
            }
            else if ( (LA55_0==53) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3037:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3038:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3038:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3039:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,52,FOLLOW_52_in_ruleSimpleAnnotationAttribute6621); 

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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3053:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleSimpleAnnotationAttribute6652); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleSimpleAnnotationAttribute6665); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3061:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3062:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3062:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3063:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute6682); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleSimpleAnnotationAttribute6699); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3083:1: ( (lv_type_5_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3084:1: (lv_type_5_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3084:1: (lv_type_5_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3085:3: lv_type_5_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute6720);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3109:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3110:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3111:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
            {
             newCompositeNode(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute6756);
            iv_ruleEnumAnnotationAttribute=ruleEnumAnnotationAttribute();

            state._fsp--;

             current =iv_ruleEnumAnnotationAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute6766); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3118:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3121:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==52) ) {
                alt56=1;
            }
            else if ( (LA56_0==53) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3122:3: ( (lv_optional_0_0= 'optional' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3123:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3123:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3124:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,52,FOLLOW_52_in_ruleEnumAnnotationAttribute6810); 

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
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3138:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleEnumAnnotationAttribute6841); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleEnumAnnotationAttribute6854); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3146:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3147:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3147:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3148:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute6871); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleEnumAnnotationAttribute6888); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleEnumAnnotationAttribute6900); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3172:1: ( (lv_values_6_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3173:1: (lv_values_6_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3173:1: (lv_values_6_0= RULE_STRING )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3174:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6917); 

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

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3190:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==48) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3190:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleEnumAnnotationAttribute6935); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3194:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3195:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3195:1: (lv_values_8_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3196:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6952); 

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
            	    break loop57;
                }
            } while (true);

            otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleEnumAnnotationAttribute6971); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3226:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3227:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3228:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN7010);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN7021); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3235:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3238:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3239:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3240:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN7068);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3250:1: (kw= '.*' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==55) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3251:2: kw= '.*'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleImportedFQN7087); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3264:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3265:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3266:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation7129);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation7139); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3273:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3276:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3277:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3277:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3277:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3277:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3278:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleDocumentation7185); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3287:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_STRING) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3288:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3288:1: (lv_lines_2_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3289:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation7202); 

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
            	    break loop59;
                }
            } while (true);

            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleDocumentation7220); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3321:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3322:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3323:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral7260);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral7270); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3330:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3333:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3334:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3334:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 58:
            case 59:
                {
                alt60=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 60:
            case 61:
            case 62:
                {
                alt60=2;
                }
                break;
            case RULE_STRING:
                {
                alt60=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3335:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral7317);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3345:5: this_NumberLiteral_1= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral7344);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3355:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral7371);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3371:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3372:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3373:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral7406);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral7416); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3380:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3383:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3384:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3384:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3384:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3384:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3385:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3390:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==58) ) {
                alt61=1;
            }
            else if ( (LA61_0==59) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3390:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleBooleanLiteral7463); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3395:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3395:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3396:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3396:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3397:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,59,FOLLOW_59_in_ruleBooleanLiteral7487); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3418:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3419:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3420:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral7537);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral7547); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3427:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3430:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3431:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3431:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt62=2;
            switch ( input.LA(1) ) {
            case 60:
                {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==RULE_INT) ) {
                    int LA62_3 = input.LA(3);

                    if ( (LA62_3==62) ) {
                        alt62=2;
                    }
                    else if ( (LA62_3==EOF) ) {
                        alt62=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA62_1==62) ) {
                    alt62=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;
                }
                }
                break;
            case 61:
                {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==RULE_INT) ) {
                    int LA62_3 = input.LA(3);

                    if ( (LA62_3==62) ) {
                        alt62=2;
                    }
                    else if ( (LA62_3==EOF) ) {
                        alt62=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA62_2==62) ) {
                    alt62=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA62_3 = input.LA(2);

                if ( (LA62_3==62) ) {
                    alt62=2;
                }
                else if ( (LA62_3==EOF) ) {
                    alt62=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt62=1;
                }
                break;
            case 62:
                {
                alt62=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3432:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleNumberLiteral7594);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3442:5: this_RealLiteral_1= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumberLiteral7621);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3458:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3459:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3460:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7656);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral7666); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3467:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3470:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3471:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3471:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3471:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3471:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3472:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3477:2: ( (lv_value_1_0= ruleReal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3478:1: (lv_value_1_0= ruleReal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3478:1: (lv_value_1_0= ruleReal )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3479:3: lv_value_1_0= ruleReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReal_in_ruleRealLiteral7721);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3503:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3504:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3505:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral7757);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral7767); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3512:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3515:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3516:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3516:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3516:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3516:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3517:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3522:2: ( (lv_value_1_0= ruleInteger ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3523:1: (lv_value_1_0= ruleInteger )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3523:1: (lv_value_1_0= ruleInteger )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3524:3: lv_value_1_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleIntLiteral7822);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3548:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3549:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3550:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral7858);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral7868); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3557:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3560:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3561:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3561:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3561:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3561:2: ()
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3562:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3567:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3568:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3568:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3569:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral7919); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3593:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3594:2: (iv_ruleInteger= ruleInteger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3595:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger7961);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger7972); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3602:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_SignedInteger_0 = null;

        AntlrDatatypeRuleToken this_Hexadecimal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3605:28: ( (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3606:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3606:1: (this_SignedInteger_0= ruleSignedInteger | this_Hexadecimal_1= ruleHexadecimal )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_INT||(LA63_0>=60 && LA63_0<=61)) ) {
                alt63=1;
            }
            else if ( (LA63_0==RULE_HEX) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3607:5: this_SignedInteger_0= ruleSignedInteger
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSignedInteger_in_ruleInteger8019);
                    this_SignedInteger_0=ruleSignedInteger();

                    state._fsp--;


                    		current.merge(this_SignedInteger_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3619:5: this_Hexadecimal_1= ruleHexadecimal
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHexadecimal_in_ruleInteger8052);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3637:1: entryRuleSignedInteger returns [String current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final String entryRuleSignedInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInteger = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3641:2: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3642:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger8104);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger8115); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3652:1: ruleSignedInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3656:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3657:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3657:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3657:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3657:2: (kw= '+' | kw= '-' )?
            int alt64=3;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==60) ) {
                alt64=1;
            }
            else if ( (LA64_0==61) ) {
                alt64=2;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3658:2: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleSignedInteger8158); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3665:2: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleSignedInteger8177); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInteger8194); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3688:1: entryRuleHexadecimal returns [String current=null] : iv_ruleHexadecimal= ruleHexadecimal EOF ;
    public final String entryRuleHexadecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHexadecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3692:2: (iv_ruleHexadecimal= ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3693:2: iv_ruleHexadecimal= ruleHexadecimal EOF
            {
             newCompositeNode(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal8250);
            iv_ruleHexadecimal=ruleHexadecimal();

            state._fsp--;

             current =iv_ruleHexadecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal8261); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3703:1: ruleHexadecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_HEX_0= RULE_HEX ;
    public final AntlrDatatypeRuleToken ruleHexadecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3707:28: (this_HEX_0= RULE_HEX )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3708:5: this_HEX_0= RULE_HEX
            {
            this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal8304); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3726:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3727:2: (iv_ruleReal= ruleReal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3728:2: iv_ruleReal= ruleReal EOF
            {
             newCompositeNode(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal8353);
            iv_ruleReal=ruleReal();

            state._fsp--;

             current =iv_ruleReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal8364); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3735:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DotDecimal_1 = null;

        AntlrDatatypeRuleToken this_DecimalDot_2 = null;

        AntlrDatatypeRuleToken this_DecimalExp_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3738:28: ( (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3739:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3739:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )
            int alt65=4;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3740:5: this_Decimal_0= ruleDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDecimal_in_ruleReal8411);
                    this_Decimal_0=ruleDecimal();

                    state._fsp--;


                    		current.merge(this_Decimal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3752:5: this_DotDecimal_1= ruleDotDecimal
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDotDecimal_in_ruleReal8444);
                    this_DotDecimal_1=ruleDotDecimal();

                    state._fsp--;


                    		current.merge(this_DotDecimal_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3764:5: this_DecimalDot_2= ruleDecimalDot
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalDot_in_ruleReal8477);
                    this_DecimalDot_2=ruleDecimalDot();

                    state._fsp--;


                    		current.merge(this_DecimalDot_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3776:5: this_DecimalExp_3= ruleDecimalExp
                    {
                     
                            newCompositeNode(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDecimalExp_in_ruleReal8510);
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3794:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3798:2: (iv_ruleDecimal= ruleDecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3799:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal8562);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal8573); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3809:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3813:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3814:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3814:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3814:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3814:2: (kw= '+' | kw= '-' )?
            int alt66=3;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==60) ) {
                alt66=1;
            }
            else if ( (LA66_0==61) ) {
                alt66=2;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3815:2: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleDecimal8616); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3822:2: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleDecimal8635); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal8652); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,62,FOLLOW_62_in_ruleDecimal8670); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimal8685); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3858:1: entryRuleDotDecimal returns [String current=null] : iv_ruleDotDecimal= ruleDotDecimal EOF ;
    public final String entryRuleDotDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3862:2: (iv_ruleDotDecimal= ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3863:2: iv_ruleDotDecimal= ruleDotDecimal EOF
            {
             newCompositeNode(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal8741);
            iv_ruleDotDecimal=ruleDotDecimal();

            state._fsp--;

             current =iv_ruleDotDecimal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal8752); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3873:1: ruleDotDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDotDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3877:28: ( ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3878:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3878:1: ( (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3878:2: (kw= '+' | kw= '-' )? kw= '.' this_INT_3= RULE_INT
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3878:2: (kw= '+' | kw= '-' )?
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==60) ) {
                alt67=1;
            }
            else if ( (LA67_0==61) ) {
                alt67=2;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3879:2: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleDotDecimal8795); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3886:2: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleDotDecimal8814); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,62,FOLLOW_62_in_ruleDotDecimal8829); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDotDecimal8844); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3915:1: entryRuleDecimalDot returns [String current=null] : iv_ruleDecimalDot= ruleDecimalDot EOF ;
    public final String entryRuleDecimalDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalDot = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3919:2: (iv_ruleDecimalDot= ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3920:2: iv_ruleDecimalDot= ruleDecimalDot EOF
            {
             newCompositeNode(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot8900);
            iv_ruleDecimalDot=ruleDecimalDot();

            state._fsp--;

             current =iv_ruleDecimalDot.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot8911); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3930:1: ruleDecimalDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleDecimalDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3934:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3935:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3935:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3935:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.'
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3935:2: (kw= '+' | kw= '-' )?
            int alt68=3;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==60) ) {
                alt68=1;
            }
            else if ( (LA68_0==61) ) {
                alt68=2;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3936:2: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleDecimalDot8954); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3943:2: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleDecimalDot8973); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalDot8990); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,62,FOLLOW_62_in_ruleDecimalDot9008); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3972:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3976:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3977:2: iv_ruleDecimalExp= ruleDecimalExp EOF
            {
             newCompositeNode(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp9059);
            iv_ruleDecimalExp=ruleDecimalExp();

            state._fsp--;

             current =iv_ruleDecimalExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp9070); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3987:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_EXP_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3991:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3992:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3992:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3992:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT this_EXP_5= RULE_EXP
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3992:2: (kw= '+' | kw= '-' )?
            int alt69=3;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==60) ) {
                alt69=1;
            }
            else if ( (LA69_0==61) ) {
                alt69=2;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:3993:2: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleDecimalExp9113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4000:2: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleDecimalExp9132); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp9149); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,62,FOLLOW_62_in_ruleDecimalExp9167); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDecimalExp9182); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            this_EXP_5=(Token)match(input,RULE_EXP,FOLLOW_RULE_EXP_in_ruleDecimalExp9202); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4043:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4044:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4045:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN9252);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN9263); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4052:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4055:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4056:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4056:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4056:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN9303); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4063:1: (kw= '.' this_ID_2= RULE_ID )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==62) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4064:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleFQN9322); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN9337); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop70;
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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4084:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4086:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4087:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4087:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt71=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt71=1;
                }
                break;
            case 64:
                {
                alt71=2;
                }
                break;
            case 65:
                {
                alt71=3;
                }
                break;
            case 66:
                {
                alt71=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4087:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4087:2: (enumLiteral_0= 'eventdriven' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4087:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_63_in_ruleComponentCommunicationType9398); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4093:6: (enumLiteral_1= 'datadriven' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4093:6: (enumLiteral_1= 'datadriven' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4093:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_64_in_ruleComponentCommunicationType9415); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4099:6: (enumLiteral_2= 'async' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4099:6: (enumLiteral_2= 'async' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4099:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_65_in_ruleComponentCommunicationType9432); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4105:6: (enumLiteral_3= 'sync' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4105:6: (enumLiteral_3= 'sync' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4105:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_66_in_ruleComponentCommunicationType9449); 

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
    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4115:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4117:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4118:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4118:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt72=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt72=1;
                }
                break;
            case 68:
                {
                alt72=2;
                }
                break;
            case 69:
                {
                alt72=3;
                }
                break;
            case 70:
                {
                alt72=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4118:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4118:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4118:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_67_in_ruleLiteralType9494); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4124:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4124:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4124:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_68_in_ruleLiteralType9511); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4130:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4130:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4130:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_69_in_ruleLiteralType9528); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4136:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4136:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.fsm/src-gen/org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.g:4136:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,70,FOLLOW_70_in_ruleLiteralType9545); 

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
    protected DFA65 dfa65 = new DFA65(this);
    static final String DFA24_eotS =
        "\32\uffff";
    static final String DFA24_eofS =
        "\13\uffff\1\22\7\uffff\3\22\1\uffff\1\22\2\uffff";
    static final String DFA24_minS =
        "\1\36\1\4\1\37\1\4\1\41\4\4\2\41\1\20\2\4\1\41\1\4\1\5\1\21\1\uffff"+
        "\3\20\1\5\1\20\2\uffff";
    static final String DFA24_maxS =
        "\1\36\2\37\1\52\1\51\2\4\1\52\1\4\2\41\1\70\2\4\1\41\1\4\1\71\1"+
        "\46\1\uffff\3\70\1\71\1\47\2\uffff";
    static final String DFA24_acceptS =
        "\22\uffff\1\2\5\uffff\1\1\1\3";
    static final String DFA24_specialS =
        "\32\uffff}>";
    static final String[] DFA24_transitionS = {
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
            "\1\21\1\22\1\uffff\1\22\4\uffff\7\22\10\uffff\1\22\1\uffff"+
            "\1\17\16\uffff\1\20",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25",
            "\1\26\63\uffff\1\27",
            "\1\22\20\uffff\1\22\1\30\1\uffff\1\30\1\31",
            "",
            "\1\21\1\22\1\uffff\1\22\4\uffff\7\22\10\uffff\1\22\20\uffff"+
            "\1\20",
            "\1\21\1\22\1\uffff\1\22\4\uffff\7\22\10\uffff\1\22\20\uffff"+
            "\1\20",
            "\1\21\1\22\1\uffff\1\22\4\uffff\7\22\10\uffff\1\22\20\uffff"+
            "\1\20",
            "\1\26\63\uffff\1\27",
            "\1\21\1\22\1\uffff\1\22\4\uffff\7\22\10\uffff\1\22",
            "",
            ""
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
            return "1297:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String DFA25_eotS =
        "\31\uffff";
    static final String DFA25_eofS =
        "\31\uffff";
    static final String DFA25_minS =
        "\1\36\1\4\1\37\1\4\1\41\4\4\2\41\1\20\2\4\1\41\1\5\1\43\1\4\2\20"+
        "\1\5\1\20\2\uffff\1\20";
    static final String DFA25_maxS =
        "\1\36\2\37\1\52\1\51\2\4\1\52\1\4\2\41\1\70\2\4\1\41\1\71\1\45"+
        "\1\4\2\70\1\71\1\20\2\uffff\1\70";
    static final String DFA25_acceptS =
        "\26\uffff\1\2\1\1\1\uffff";
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
            "\1\20\30\uffff\1\21\16\uffff\1\17",
            "\1\22",
            "\1\23",
            "\1\7",
            "\1\24\63\uffff\1\25",
            "\1\27\1\uffff\1\26",
            "\1\30",
            "\1\20\47\uffff\1\17",
            "\1\20\47\uffff\1\17",
            "\1\24\63\uffff\1\25",
            "\1\20",
            "",
            "",
            "\1\20\47\uffff\1\17"
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
            return "1347:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
    static final String DFA65_eotS =
        "\12\uffff";
    static final String DFA65_eofS =
        "\5\uffff\1\7\1\11\3\uffff";
    static final String DFA65_minS =
        "\3\6\1\76\1\uffff\1\6\1\10\3\uffff";
    static final String DFA65_maxS =
        "\4\76\1\uffff\1\6\1\10\3\uffff";
    static final String DFA65_acceptS =
        "\4\uffff\1\2\2\uffff\1\3\1\4\1\1";
    static final String DFA65_specialS =
        "\12\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\3\65\uffff\1\1\1\2\1\4",
            "\1\3\67\uffff\1\4",
            "\1\3\67\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3739:1: (this_Decimal_0= ruleDecimal | this_DotDecimal_1= ruleDotDecimal | this_DecimalDot_2= ruleDecimalDot | this_DecimalExp_3= ruleDecimalExp )";
        }
    }
 

    public static final BitSet FOLLOW_ruleFSMModel_in_entryRuleFSMModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFSMModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelComponent_in_ruleFSMModel130 = new BitSet(new long[]{0x8000000000006002L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleModelComponent_in_entryRuleModelComponent166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelComponent176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModelComponent264 = new BitSet(new long[]{0x8000000000006000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleComponentCommunicationType_in_ruleModelComponent352 = new BitSet(new long[]{0x8000000000006000L,0x0000000000000007L});
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
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleStateGraph725 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraph747 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraph774 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraph801 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateGraph828 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateGraph855 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_17_in_ruleStateGraph869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleStateMachine961 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStateMachine973 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine995 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine1022 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine1049 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine1076 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateMachine1103 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_17_in_ruleStateMachine1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState1153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_ruleState1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState1272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleState1319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState1336 = new BitSet(new long[]{0x0100000000010002L});
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
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState1640 = new BitSet(new long[]{0x0100000000010000L});
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
    public static final BitSet FOLLOW_16_in_ruleDetailCode1928 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode1958 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleDetailCode1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint2012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint2158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTransitionPoint2211 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTransitionPoint2237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint2295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleEntryPoint2342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint2400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleExitPoint2447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint2505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleChoicePoint2552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint2569 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition2632 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition2751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition2897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionChainStartTransition2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition3016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleInitialTransition3063 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition3080 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleInitialTransition3098 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleInitialTransition3110 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleInitialTransition3122 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition3143 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition3164 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInitialTransition3177 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleInitialTransition3190 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition3211 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInitialTransition3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition3261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleContinuationTransition3308 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition3325 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleContinuationTransition3343 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3364 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleContinuationTransition3376 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition3397 = new BitSet(new long[]{0x0100000000010002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition3418 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleContinuationTransition3432 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleContinuationTransition3445 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition3466 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleContinuationTransition3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTriggeredTransition3565 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3582 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleTriggeredTransition3600 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3621 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTriggeredTransition3633 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition3654 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition3675 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTriggeredTransition3688 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTriggeredTransition3700 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTriggeredTransition3712 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition3733 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_36_in_ruleTriggeredTransition3746 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition3767 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_17_in_ruleTriggeredTransition3781 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleTriggeredTransition3794 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition3815 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTriggeredTransition3829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition3865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardedTransition3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleGuardedTransition3912 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuardedTransition3929 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleGuardedTransition3947 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition3968 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleGuardedTransition3980 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition4001 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleGuardedTransition4022 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGuardedTransition4035 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleGuardedTransition4047 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition4068 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleGuardedTransition4081 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition4102 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGuardedTransition4116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition4152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleCPBranchTransition4199 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition4216 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCPBranchTransition4234 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4255 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleCPBranchTransition4267 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition4288 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition4309 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCPBranchTransition4322 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCPBranchTransition4334 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4355 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34_in_ruleCPBranchTransition4368 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition4389 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCPBranchTransition4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition4439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedTransition4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleRefinedTransition4486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedTransition4509 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedTransition4530 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRefinedTransition4543 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRefinedTransition4555 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedTransition4576 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRefinedTransition4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal4624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal4735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal4797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal4886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTrPointTerminal4933 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal4989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5044 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSubStateTrPointTerminal5056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal5112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleChoicepointTerminal5159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger5215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger5225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTrigger5262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger5283 = new BitSet(new long[]{0x0000302000000000L});
    public static final BitSet FOLLOW_44_in_ruleTrigger5296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger5317 = new BitSet(new long[]{0x0000302000000000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger5340 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTrigger5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf5389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf5444 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleMessageFromIf5456 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf5476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard5514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGuard5561 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule5620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule5630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInSemanticsRule_in_ruleSemanticsRule5677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutSemanticsRule_in_ruleSemanticsRule5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInSemanticsRule_in_entryRuleInSemanticsRule5739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInSemanticsRule5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleInSemanticsRule5786 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleInSemanticsRule5798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInSemanticsRule5818 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleInSemanticsRule5831 = new BitSet(new long[]{0x0004C00000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleInSemanticsRule5872 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5893 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleInSemanticsRule5906 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5927 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_49_in_ruleInSemanticsRule5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutSemanticsRule_in_entryRuleOutSemanticsRule5981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutSemanticsRule5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOutSemanticsRule6028 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleOutSemanticsRule6040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOutSemanticsRule6060 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleOutSemanticsRule6073 = new BitSet(new long[]{0x0004C00000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOutSemanticsRule6114 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6135 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleOutSemanticsRule6148 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule6169 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_49_in_ruleOutSemanticsRule6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue6225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue6235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue6277 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleKeyValue6294 = new BitSet(new long[]{0x7C000000000000E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleKeyValue6315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType6354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType6365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType6404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute6448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute6458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_ruleAnnotationAttribute6505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_ruleAnnotationAttribute6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute6567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute6577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSimpleAnnotationAttribute6621 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_53_in_ruleSimpleAnnotationAttribute6652 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleSimpleAnnotationAttribute6665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAnnotationAttribute6682 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSimpleAnnotationAttribute6699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000078L});
    public static final BitSet FOLLOW_ruleLiteralType_in_ruleSimpleAnnotationAttribute6720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute6756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleEnumAnnotationAttribute6810 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_53_in_ruleEnumAnnotationAttribute6841 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleEnumAnnotationAttribute6854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAnnotationAttribute6871 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEnumAnnotationAttribute6888 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEnumAnnotationAttribute6900 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6917 = new BitSet(new long[]{0x0001000000020000L});
    public static final BitSet FOLLOW_48_in_ruleEnumAnnotationAttribute6935 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumAnnotationAttribute6952 = new BitSet(new long[]{0x0001000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEnumAnnotationAttribute6971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN7010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN7021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN7068 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleImportedFQN7087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation7129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation7139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleDocumentation7185 = new BitSet(new long[]{0x0200000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation7202 = new BitSet(new long[]{0x0200000000000020L});
    public static final BitSet FOLLOW_57_in_ruleDocumentation7220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral7260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral7270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral7344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral7371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral7406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral7416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBooleanLiteral7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleBooleanLiteral7487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral7537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleNumberLiteral7594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumberLiteral7621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral7666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_ruleRealLiteral7721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral7757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral7767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleIntLiteral7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral7858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral7868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral7919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger7961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger7972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_ruleInteger8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_ruleInteger8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger8104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger8115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSignedInteger8158 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_61_in_ruleSignedInteger8177 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInteger8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal8250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal8304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal8353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal8364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_ruleReal8411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_ruleReal8444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_ruleReal8477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_ruleReal8510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal8562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal8573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleDecimal8616 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_61_in_ruleDecimal8635 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal8652 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleDecimal8670 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimal8685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal8741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal8752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleDotDecimal8795 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleDotDecimal8814 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleDotDecimal8829 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDotDecimal8844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot8900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot8911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleDecimalDot8954 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_61_in_ruleDecimalDot8973 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalDot8990 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleDecimalDot9008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp9059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp9070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleDecimalExp9113 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_61_in_ruleDecimalExp9132 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp9149 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleDecimalExp9167 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDecimalExp9182 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_EXP_in_ruleDecimalExp9202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN9252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN9263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN9303 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleFQN9322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN9337 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleComponentCommunicationType9398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleComponentCommunicationType9415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleComponentCommunicationType9432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleComponentCommunicationType9449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleLiteralType9494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleLiteralType9511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleLiteralType9528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleLiteralType9545 = new BitSet(new long[]{0x0000000000000002L});

}
