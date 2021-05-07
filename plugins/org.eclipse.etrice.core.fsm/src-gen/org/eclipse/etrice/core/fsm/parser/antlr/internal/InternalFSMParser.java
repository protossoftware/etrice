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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_CC_STRING", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'ModelComponent'", "'extends'", "'{'", "'}'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "':'", "'initial'", "'->'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'of'", "'cp'", "'<'", "'|'", "'>'", "'in'", "'('", "','", "')'", "'out'", "'@'", "'='", "'optional'", "'mandatory'", "'attribute'", "'.*'", "'['", "']'", "'false'", "'true'", "'+'", "'-'", "'.'", "'e'", "'E'", "'eventdriven'", "'datadriven'", "'async'", "'sync'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_HEX=8;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=5;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
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
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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


        public InternalFSMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFSMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFSMParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFSM.g"; }



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
    // InternalFSM.g:65:1: entryRuleFSMModel returns [EObject current=null] : iv_ruleFSMModel= ruleFSMModel EOF ;
    public final EObject entryRuleFSMModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFSMModel = null;


        try {
            // InternalFSM.g:65:49: (iv_ruleFSMModel= ruleFSMModel EOF )
            // InternalFSM.g:66:2: iv_ruleFSMModel= ruleFSMModel EOF
            {
             newCompositeNode(grammarAccess.getFSMModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFSMModel=ruleFSMModel();

            state._fsp--;

             current =iv_ruleFSMModel; 
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
    // $ANTLR end "entryRuleFSMModel"


    // $ANTLR start "ruleFSMModel"
    // InternalFSM.g:72:1: ruleFSMModel returns [EObject current=null] : ( (lv_components_0_0= ruleModelComponent ) )* ;
    public final EObject ruleFSMModel() throws RecognitionException {
        EObject current = null;

        EObject lv_components_0_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:78:2: ( ( (lv_components_0_0= ruleModelComponent ) )* )
            // InternalFSM.g:79:2: ( (lv_components_0_0= ruleModelComponent ) )*
            {
            // InternalFSM.g:79:2: ( (lv_components_0_0= ruleModelComponent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=14)||(LA1_0>=66 && LA1_0<=69)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFSM.g:80:3: (lv_components_0_0= ruleModelComponent )
            	    {
            	    // InternalFSM.g:80:3: (lv_components_0_0= ruleModelComponent )
            	    // InternalFSM.g:81:4: lv_components_0_0= ruleModelComponent
            	    {

            	    				newCompositeNode(grammarAccess.getFSMModelAccess().getComponentsModelComponentParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_components_0_0=ruleModelComponent();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getFSMModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"components",
            	    					lv_components_0_0,
            	    					"org.eclipse.etrice.core.fsm.FSM.ModelComponent");
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
    // InternalFSM.g:101:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalFSM.g:101:55: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalFSM.g:102:2: iv_ruleModelComponent= ruleModelComponent EOF
            {
             newCompositeNode(grammarAccess.getModelComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelComponent=ruleModelComponent();

            state._fsp--;

             current =iv_ruleModelComponent; 
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
    // $ANTLR end "entryRuleModelComponent"


    // $ANTLR start "ruleModelComponent"
    // InternalFSM.g:108:1: ruleModelComponent returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) ) ;
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
            // InternalFSM.g:114:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) ) )
            // InternalFSM.g:115:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) )
            {
            // InternalFSM.g:115:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) ) )
            // InternalFSM.g:116:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ModelComponent' ( (lv_componentName_4_0= RULE_ID ) ) (otherlv_5= 'extends' ( ( ruleFQN ) ) )? ( (lv_stateMachine_7_0= ruleStateMachine ) )
            {
            // InternalFSM.g:116:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalFSM.g:117:4: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalFSM.g:117:4: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalFSM.g:118:5: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            				
            // InternalFSM.g:121:5: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalFSM.g:122:6: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalFSM.g:122:6: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( LA2_0 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 >= 66 && LA2_0 <= 69 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFSM.g:123:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalFSM.g:123:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalFSM.g:124:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalFSM.g:124:111: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalFSM.g:125:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalFSM.g:128:9: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalFSM.g:128:10: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "true");
            	    }
            	    // InternalFSM.g:128:19: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalFSM.g:128:20: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalFSM.g:128:20: (lv_abstract_1_0= 'abstract' )
            	    // InternalFSM.g:129:10: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,13,FOLLOW_4); 

            	    										newLeafNode(lv_abstract_1_0, grammarAccess.getModelComponentAccess().getAbstractAbstractKeyword_0_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getModelComponentRule());
            	    										}
            	    										setWithLastConsumed(current, "abstract", lv_abstract_1_0 != null, "abstract");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelComponentAccess().getUnorderedGroup_0());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFSM.g:146:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalFSM.g:146:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalFSM.g:147:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalFSM.g:147:111: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalFSM.g:148:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalFSM.g:151:9: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalFSM.g:151:10: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModelComponent", "true");
            	    }
            	    // InternalFSM.g:151:19: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalFSM.g:151:20: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalFSM.g:151:20: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalFSM.g:152:10: lv_commType_2_0= ruleComponentCommunicationType
            	    {

            	    										newCompositeNode(grammarAccess.getModelComponentAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_commType_2_0=ruleComponentCommunicationType();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getModelComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"commType",
            	    											lv_commType_2_0,
            	    											"org.eclipse.etrice.core.fsm.FSM.ComponentCommunicationType");
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

            otherlv_3=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getModelComponentAccess().getModelComponentKeyword_1());
            		
            // InternalFSM.g:185:3: ( (lv_componentName_4_0= RULE_ID ) )
            // InternalFSM.g:186:4: (lv_componentName_4_0= RULE_ID )
            {
            // InternalFSM.g:186:4: (lv_componentName_4_0= RULE_ID )
            // InternalFSM.g:187:5: lv_componentName_4_0= RULE_ID
            {
            lv_componentName_4_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_componentName_4_0, grammarAccess.getModelComponentAccess().getComponentNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"componentName",
            						lv_componentName_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFSM.g:203:3: (otherlv_5= 'extends' ( ( ruleFQN ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFSM.g:204:4: otherlv_5= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_5, grammarAccess.getModelComponentAccess().getExtendsKeyword_3_0());
                    			
                    // InternalFSM.g:208:4: ( ( ruleFQN ) )
                    // InternalFSM.g:209:5: ( ruleFQN )
                    {
                    // InternalFSM.g:209:5: ( ruleFQN )
                    // InternalFSM.g:210:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelComponentRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelComponentAccess().getBaseModelComponentCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalFSM.g:225:3: ( (lv_stateMachine_7_0= ruleStateMachine ) )
            // InternalFSM.g:226:4: (lv_stateMachine_7_0= ruleStateMachine )
            {
            // InternalFSM.g:226:4: (lv_stateMachine_7_0= ruleStateMachine )
            // InternalFSM.g:227:5: lv_stateMachine_7_0= ruleStateMachine
            {

            					newCompositeNode(grammarAccess.getModelComponentAccess().getStateMachineStateMachineParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_stateMachine_7_0=ruleStateMachine();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelComponentRule());
            					}
            					set(
            						current,
            						"stateMachine",
            						lv_stateMachine_7_0,
            						"org.eclipse.etrice.core.fsm.FSM.StateMachine");
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
    // InternalFSM.g:248:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalFSM.g:248:55: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalFSM.g:249:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             newCompositeNode(grammarAccess.getStateGraphNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateGraphNode=ruleStateGraphNode();

            state._fsp--;

             current =iv_ruleStateGraphNode; 
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
    // $ANTLR end "entryRuleStateGraphNode"


    // $ANTLR start "ruleStateGraphNode"
    // InternalFSM.g:255:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;



        	enterRule();

        try {
            // InternalFSM.g:261:2: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalFSM.g:262:2: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalFSM.g:262:2: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
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
                    // InternalFSM.g:263:3: this_State_0= ruleState
                    {

                    			newCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_State_0=ruleState();

                    state._fsp--;


                    			current = this_State_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:272:3: this_ChoicePoint_1= ruleChoicePoint
                    {

                    			newCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ChoicePoint_1=ruleChoicePoint();

                    state._fsp--;


                    			current = this_ChoicePoint_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFSM.g:281:3: this_TrPoint_2= ruleTrPoint
                    {

                    			newCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:293:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalFSM.g:293:51: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalFSM.g:294:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
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
    // $ANTLR end "entryRuleStateGraph"


    // $ANTLR start "ruleStateGraph"
    // InternalFSM.g:300:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalFSM.g:306:2: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalFSM.g:307:2: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalFSM.g:307:2: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalFSM.g:308:3: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalFSM.g:308:3: ()
            // InternalFSM.g:309:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalFSM.g:319:3: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
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
            	    // InternalFSM.g:320:4: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalFSM.g:320:4: ( (lv_states_2_0= ruleState ) )
            	    // InternalFSM.g:321:5: (lv_states_2_0= ruleState )
            	    {
            	    // InternalFSM.g:321:5: (lv_states_2_0= ruleState )
            	    // InternalFSM.g:322:6: lv_states_2_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"states",
            	    							lv_states_2_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.State");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFSM.g:340:4: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalFSM.g:340:4: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalFSM.g:341:5: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalFSM.g:341:5: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalFSM.g:342:6: lv_trPoints_3_0= ruleTrPoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_trPoints_3_0=ruleTrPoint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"trPoints",
            	    							lv_trPoints_3_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.TrPoint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalFSM.g:360:4: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalFSM.g:360:4: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalFSM.g:361:5: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalFSM.g:361:5: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalFSM.g:362:6: lv_chPoints_4_0= ruleChoicePoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_chPoints_4_0=ruleChoicePoint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"chPoints",
            	    							lv_chPoints_4_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.ChoicePoint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalFSM.g:380:4: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalFSM.g:380:4: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalFSM.g:381:5: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalFSM.g:381:5: (lv_transitions_5_0= ruleTransition )
            	    // InternalFSM.g:382:6: lv_transitions_5_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_transitions_5_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"transitions",
            	    							lv_transitions_5_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalFSM.g:400:4: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalFSM.g:400:4: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalFSM.g:401:5: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalFSM.g:401:5: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalFSM.g:402:6: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_refinedTransitions_6_0=ruleRefinedTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"refinedTransitions",
            	    							lv_refinedTransitions_6_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.RefinedTransition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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
    // InternalFSM.g:428:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalFSM.g:428:53: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalFSM.g:429:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
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
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // InternalFSM.g:435:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalFSM.g:441:2: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalFSM.g:442:2: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalFSM.g:442:2: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalFSM.g:443:3: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalFSM.g:443:3: ()
            // InternalFSM.g:444:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalFSM.g:458:3: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
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
            	    // InternalFSM.g:459:4: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalFSM.g:459:4: ( (lv_states_3_0= ruleState ) )
            	    // InternalFSM.g:460:5: (lv_states_3_0= ruleState )
            	    {
            	    // InternalFSM.g:460:5: (lv_states_3_0= ruleState )
            	    // InternalFSM.g:461:6: lv_states_3_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_states_3_0=ruleState();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"states",
            	    							lv_states_3_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.State");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFSM.g:479:4: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalFSM.g:479:4: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalFSM.g:480:5: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalFSM.g:480:5: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalFSM.g:481:6: lv_trPoints_4_0= ruleTrPoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_trPoints_4_0=ruleTrPoint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"trPoints",
            	    							lv_trPoints_4_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.TrPoint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalFSM.g:499:4: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalFSM.g:499:4: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalFSM.g:500:5: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalFSM.g:500:5: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalFSM.g:501:6: lv_chPoints_5_0= ruleChoicePoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_chPoints_5_0=ruleChoicePoint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"chPoints",
            	    							lv_chPoints_5_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.ChoicePoint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalFSM.g:519:4: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalFSM.g:519:4: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalFSM.g:520:5: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalFSM.g:520:5: (lv_transitions_6_0= ruleTransition )
            	    // InternalFSM.g:521:6: lv_transitions_6_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_transitions_6_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"transitions",
            	    							lv_transitions_6_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalFSM.g:539:4: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalFSM.g:539:4: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalFSM.g:540:5: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalFSM.g:540:5: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalFSM.g:541:6: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_refinedTransitions_7_0=ruleRefinedTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"refinedTransitions",
            	    							lv_refinedTransitions_7_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.RefinedTransition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

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
    // InternalFSM.g:567:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalFSM.g:567:46: (iv_ruleState= ruleState EOF )
            // InternalFSM.g:568:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalFSM.g:574:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:580:2: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalFSM.g:581:2: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalFSM.g:581:2: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
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
                    // InternalFSM.g:582:3: this_SimpleState_0= ruleSimpleState
                    {

                    			newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;


                    			current = this_SimpleState_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:591:3: this_RefinedState_1= ruleRefinedState
                    {

                    			newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:603:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalFSM.g:603:52: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalFSM.g:604:2: iv_ruleSimpleState= ruleSimpleState EOF
            {
             newCompositeNode(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleState=ruleSimpleState();

            state._fsp--;

             current =iv_ruleSimpleState; 
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
    // $ANTLR end "entryRuleSimpleState"


    // $ANTLR start "ruleSimpleState"
    // InternalFSM.g:610:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) ;
    public final EObject ruleSimpleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_entryCode_6_0 = null;

        EObject lv_exitCode_8_0 = null;

        EObject lv_doCode_10_0 = null;

        EObject lv_subgraph_12_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:616:2: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) )
            // InternalFSM.g:617:2: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            {
            // InternalFSM.g:617:2: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            // InternalFSM.g:618:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
            		
            // InternalFSM.g:622:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFSM.g:623:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFSM.g:623:4: (lv_name_1_0= RULE_ID )
            // InternalFSM.g:624:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSimpleStateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFSM.g:640:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==57) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFSM.g:641:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalFSM.g:641:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalFSM.g:642:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSimpleStateRule());
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

            // InternalFSM.g:659:3: (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==16) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFSM.g:660:4: otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalFSM.g:664:4: ( (lv_annotations_4_0= ruleAnnotation ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==51) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalFSM.g:665:5: (lv_annotations_4_0= ruleAnnotation )
                    	    {
                    	    // InternalFSM.g:665:5: (lv_annotations_4_0= ruleAnnotation )
                    	    // InternalFSM.g:666:6: lv_annotations_4_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getSimpleStateAccess().getAnnotationsAnnotationParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_annotations_4_0=ruleAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotations",
                    	    							lv_annotations_4_0,
                    	    							"org.eclipse.etrice.core.common.Base.Annotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // InternalFSM.g:683:4: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==20) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalFSM.g:684:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                            {
                            otherlv_5=(Token)match(input,20,FOLLOW_12); 

                            					newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_2_0());
                            				
                            // InternalFSM.g:688:5: ( (lv_entryCode_6_0= ruleDetailCode ) )
                            // InternalFSM.g:689:6: (lv_entryCode_6_0= ruleDetailCode )
                            {
                            // InternalFSM.g:689:6: (lv_entryCode_6_0= ruleDetailCode )
                            // InternalFSM.g:690:7: lv_entryCode_6_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_2_1_0());
                            						
                            pushFollow(FOLLOW_13);
                            lv_entryCode_6_0=ruleDetailCode();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            							}
                            							set(
                            								current,
                            								"entryCode",
                            								lv_entryCode_6_0,
                            								"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalFSM.g:708:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==21) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalFSM.g:709:5: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                            {
                            otherlv_7=(Token)match(input,21,FOLLOW_14); 

                            					newLeafNode(otherlv_7, grammarAccess.getSimpleStateAccess().getExitKeyword_3_3_0());
                            				
                            // InternalFSM.g:713:5: ( (lv_exitCode_8_0= ruleDetailCode ) )
                            // InternalFSM.g:714:6: (lv_exitCode_8_0= ruleDetailCode )
                            {
                            // InternalFSM.g:714:6: (lv_exitCode_8_0= ruleDetailCode )
                            // InternalFSM.g:715:7: lv_exitCode_8_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_3_1_0());
                            						
                            pushFollow(FOLLOW_15);
                            lv_exitCode_8_0=ruleDetailCode();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            							}
                            							set(
                            								current,
                            								"exitCode",
                            								lv_exitCode_8_0,
                            								"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalFSM.g:733:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==22) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalFSM.g:734:5: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,22,FOLLOW_16); 

                            					newLeafNode(otherlv_9, grammarAccess.getSimpleStateAccess().getDoKeyword_3_4_0());
                            				
                            // InternalFSM.g:738:5: ( (lv_doCode_10_0= ruleDetailCode ) )
                            // InternalFSM.g:739:6: (lv_doCode_10_0= ruleDetailCode )
                            {
                            // InternalFSM.g:739:6: (lv_doCode_10_0= ruleDetailCode )
                            // InternalFSM.g:740:7: lv_doCode_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_4_1_0());
                            						
                            pushFollow(FOLLOW_17);
                            lv_doCode_10_0=ruleDetailCode();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            							}
                            							set(
                            								current,
                            								"doCode",
                            								lv_doCode_10_0,
                            								"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalFSM.g:758:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalFSM.g:759:5: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                            {
                            otherlv_11=(Token)match(input,23,FOLLOW_8); 

                            					newLeafNode(otherlv_11, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_5_0());
                            				
                            // InternalFSM.g:763:5: ( (lv_subgraph_12_0= ruleStateGraph ) )
                            // InternalFSM.g:764:6: (lv_subgraph_12_0= ruleStateGraph )
                            {
                            // InternalFSM.g:764:6: (lv_subgraph_12_0= ruleStateGraph )
                            // InternalFSM.g:765:7: lv_subgraph_12_0= ruleStateGraph
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_5_1_0());
                            						
                            pushFollow(FOLLOW_18);
                            lv_subgraph_12_0=ruleStateGraph();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            							}
                            							set(
                            								current,
                            								"subgraph",
                            								lv_subgraph_12_0,
                            								"org.eclipse.etrice.core.fsm.FSM.StateGraph");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_3_6());
                    			

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
    // InternalFSM.g:792:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalFSM.g:792:53: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalFSM.g:793:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             newCompositeNode(grammarAccess.getRefinedStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefinedState=ruleRefinedState();

            state._fsp--;

             current =iv_ruleRefinedState; 
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
    // $ANTLR end "entryRuleRefinedState"


    // $ANTLR start "ruleRefinedState"
    // InternalFSM.g:799:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleRefinedState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_entryCode_6_0 = null;

        EObject lv_exitCode_8_0 = null;

        EObject lv_doCode_10_0 = null;

        EObject lv_subgraph_12_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:805:2: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) )
            // InternalFSM.g:806:2: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            {
            // InternalFSM.g:806:2: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            // InternalFSM.g:807:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
            		
            // InternalFSM.g:811:3: ( ( ruleFQN ) )
            // InternalFSM.g:812:4: ( ruleFQN )
            {
            // InternalFSM.g:812:4: ( ruleFQN )
            // InternalFSM.g:813:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefinedStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRefinedStateAccess().getTargetStateCrossReference_1_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:827:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==57) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFSM.g:828:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalFSM.g:828:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalFSM.g:829:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRefinedStateRule());
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

            otherlv_3=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalFSM.g:850:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==51) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalFSM.g:851:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalFSM.g:851:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalFSM.g:852:5: lv_annotations_4_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getRefinedStateAccess().getAnnotationsAnnotationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRefinedStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_4_0,
            	    						"org.eclipse.etrice.core.common.Base.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalFSM.g:869:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalFSM.g:870:4: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_5, grammarAccess.getRefinedStateAccess().getEntryKeyword_5_0());
                    			
                    // InternalFSM.g:874:4: ( (lv_entryCode_6_0= ruleDetailCode ) )
                    // InternalFSM.g:875:5: (lv_entryCode_6_0= ruleDetailCode )
                    {
                    // InternalFSM.g:875:5: (lv_entryCode_6_0= ruleDetailCode )
                    // InternalFSM.g:876:6: lv_entryCode_6_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_entryCode_6_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    						}
                    						set(
                    							current,
                    							"entryCode",
                    							lv_entryCode_6_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalFSM.g:894:3: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalFSM.g:895:4: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_7, grammarAccess.getRefinedStateAccess().getExitKeyword_6_0());
                    			
                    // InternalFSM.g:899:4: ( (lv_exitCode_8_0= ruleDetailCode ) )
                    // InternalFSM.g:900:5: (lv_exitCode_8_0= ruleDetailCode )
                    {
                    // InternalFSM.g:900:5: (lv_exitCode_8_0= ruleDetailCode )
                    // InternalFSM.g:901:6: lv_exitCode_8_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_exitCode_8_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    						}
                    						set(
                    							current,
                    							"exitCode",
                    							lv_exitCode_8_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalFSM.g:919:3: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFSM.g:920:4: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_9, grammarAccess.getRefinedStateAccess().getDoKeyword_7_0());
                    			
                    // InternalFSM.g:924:4: ( (lv_doCode_10_0= ruleDetailCode ) )
                    // InternalFSM.g:925:5: (lv_doCode_10_0= ruleDetailCode )
                    {
                    // InternalFSM.g:925:5: (lv_doCode_10_0= ruleDetailCode )
                    // InternalFSM.g:926:6: lv_doCode_10_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_doCode_10_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    						}
                    						set(
                    							current,
                    							"doCode",
                    							lv_doCode_10_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalFSM.g:944:3: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalFSM.g:945:4: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                    {
                    otherlv_11=(Token)match(input,23,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_8_0());
                    			
                    // InternalFSM.g:949:4: ( (lv_subgraph_12_0= ruleStateGraph ) )
                    // InternalFSM.g:950:5: (lv_subgraph_12_0= ruleStateGraph )
                    {
                    // InternalFSM.g:950:5: (lv_subgraph_12_0= ruleStateGraph )
                    // InternalFSM.g:951:6: lv_subgraph_12_0= ruleStateGraph
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_subgraph_12_0=ruleStateGraph();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    						}
                    						set(
                    							current,
                    							"subgraph",
                    							lv_subgraph_12_0,
                    							"org.eclipse.etrice.core.fsm.FSM.StateGraph");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getRefinedStateAccess().getRightCurlyBracketKeyword_9());
            		

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
    // InternalFSM.g:977:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalFSM.g:977:51: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalFSM.g:978:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             newCompositeNode(grammarAccess.getDetailCodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDetailCode=ruleDetailCode();

            state._fsp--;

             current =iv_ruleDetailCode; 
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
    // $ANTLR end "entryRuleDetailCode"


    // $ANTLR start "ruleDetailCode"
    // InternalFSM.g:984:1: ruleDetailCode returns [EObject current=null] : ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_lines_1_0=null;
        Token lv_used_2_0=null;
        Token lv_lines_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFSM.g:990:2: ( ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) )
            // InternalFSM.g:991:2: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            {
            // InternalFSM.g:991:2: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EOF||LA23_0==RULE_CC_STRING||LA23_0==17||(LA23_0>=21 && LA23_0<=23)||LA23_0==34||LA23_0==45) ) {
                alt23=1;
            }
            else if ( (LA23_0==16) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalFSM.g:992:3: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    {
                    // InternalFSM.g:992:3: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    // InternalFSM.g:993:4: () ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    {
                    // InternalFSM.g:993:4: ()
                    // InternalFSM.g:994:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDetailCodeAccess().getDetailCodeAction_0_0(),
                    						current);
                    				

                    }

                    // InternalFSM.g:1000:4: ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_CC_STRING) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalFSM.g:1001:5: (lv_lines_1_0= RULE_CC_STRING )
                            {
                            // InternalFSM.g:1001:5: (lv_lines_1_0= RULE_CC_STRING )
                            // InternalFSM.g:1002:6: lv_lines_1_0= RULE_CC_STRING
                            {
                            lv_lines_1_0=(Token)match(input,RULE_CC_STRING,FOLLOW_2); 

                            						newLeafNode(lv_lines_1_0, grammarAccess.getDetailCodeAccess().getLinesCC_STRINGTerminalRuleCall_0_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getDetailCodeRule());
                            						}
                            						addWithLastConsumed(
                            							current,
                            							"lines",
                            							lv_lines_1_0,
                            							"org.eclipse.etrice.core.common.Base.CC_STRING");
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFSM.g:1020:3: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    {
                    // InternalFSM.g:1020:3: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    // InternalFSM.g:1021:4: ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}'
                    {
                    // InternalFSM.g:1021:4: ( (lv_used_2_0= '{' ) )
                    // InternalFSM.g:1022:5: (lv_used_2_0= '{' )
                    {
                    // InternalFSM.g:1022:5: (lv_used_2_0= '{' )
                    // InternalFSM.g:1023:6: lv_used_2_0= '{'
                    {
                    lv_used_2_0=(Token)match(input,16,FOLLOW_20); 

                    						newLeafNode(lv_used_2_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDetailCodeRule());
                    						}
                    						setWithLastConsumed(current, "used", lv_used_2_0 != null, "{");
                    					

                    }


                    }

                    // InternalFSM.g:1035:4: ( (lv_lines_3_0= RULE_STRING ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_STRING) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalFSM.g:1036:5: (lv_lines_3_0= RULE_STRING )
                    	    {
                    	    // InternalFSM.g:1036:5: (lv_lines_3_0= RULE_STRING )
                    	    // InternalFSM.g:1037:6: lv_lines_3_0= RULE_STRING
                    	    {
                    	    lv_lines_3_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

                    	    						newLeafNode(lv_lines_3_0, grammarAccess.getDetailCodeAccess().getLinesSTRINGTerminalRuleCall_1_1_0());
                    	    					

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getDetailCodeRule());
                    	    						}
                    	    						addWithLastConsumed(
                    	    							current,
                    	    							"lines",
                    	    							lv_lines_3_0,
                    	    							"org.eclipse.xtext.common.Terminals.STRING");
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getDetailCodeAccess().getRightCurlyBracketKeyword_1_2());
                    			

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
    // $ANTLR end "ruleDetailCode"


    // $ANTLR start "entryRuleTrPoint"
    // InternalFSM.g:1062:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalFSM.g:1062:48: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalFSM.g:1063:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
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
    // $ANTLR end "entryRuleTrPoint"


    // $ANTLR start "ruleTrPoint"
    // InternalFSM.g:1069:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;



        	enterRule();

        try {
            // InternalFSM.g:1075:2: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalFSM.g:1076:2: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalFSM.g:1076:2: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 25:
            case 26:
                {
                alt24=1;
                }
                break;
            case 27:
                {
                alt24=2;
                }
                break;
            case 28:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalFSM.g:1077:3: this_TransitionPoint_0= ruleTransitionPoint
                    {

                    			newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;


                    			current = this_TransitionPoint_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:1086:3: this_EntryPoint_1= ruleEntryPoint
                    {

                    			newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;


                    			current = this_EntryPoint_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFSM.g:1095:3: this_ExitPoint_2= ruleExitPoint
                    {

                    			newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:1107:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalFSM.g:1107:56: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalFSM.g:1108:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
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
    // $ANTLR end "entryRuleTransitionPoint"


    // $ANTLR start "ruleTransitionPoint"
    // InternalFSM.g:1114:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalFSM.g:1120:2: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalFSM.g:1121:2: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalFSM.g:1121:2: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalFSM.g:1122:3: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalFSM.g:1122:3: ( (lv_handler_0_0= 'handler' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalFSM.g:1123:4: (lv_handler_0_0= 'handler' )
                    {
                    // InternalFSM.g:1123:4: (lv_handler_0_0= 'handler' )
                    // InternalFSM.g:1124:5: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,25,FOLLOW_21); 

                    					newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTransitionPointRule());
                    					}
                    					setWithLastConsumed(current, "handler", lv_handler_0_0 != null, "handler");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
            		
            // InternalFSM.g:1140:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalFSM.g:1141:4: (lv_name_2_0= RULE_ID )
            {
            // InternalFSM.g:1141:4: (lv_name_2_0= RULE_ID )
            // InternalFSM.g:1142:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTransitionPointAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // InternalFSM.g:1162:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalFSM.g:1162:51: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalFSM.g:1163:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
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
    // $ANTLR end "entryRuleEntryPoint"


    // $ANTLR start "ruleEntryPoint"
    // InternalFSM.g:1169:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFSM.g:1175:2: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFSM.g:1176:2: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFSM.g:1176:2: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFSM.g:1177:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
            		
            // InternalFSM.g:1181:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFSM.g:1182:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFSM.g:1182:4: (lv_name_1_0= RULE_ID )
            // InternalFSM.g:1183:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntryPointAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntryPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // InternalFSM.g:1203:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalFSM.g:1203:50: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalFSM.g:1204:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
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
    // $ANTLR end "entryRuleExitPoint"


    // $ANTLR start "ruleExitPoint"
    // InternalFSM.g:1210:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFSM.g:1216:2: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFSM.g:1217:2: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFSM.g:1217:2: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFSM.g:1218:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
            		
            // InternalFSM.g:1222:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFSM.g:1223:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFSM.g:1223:4: (lv_name_1_0= RULE_ID )
            // InternalFSM.g:1224:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getExitPointAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExitPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // InternalFSM.g:1244:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalFSM.g:1244:52: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalFSM.g:1245:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
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
    // $ANTLR end "entryRuleChoicePoint"


    // $ANTLR start "ruleChoicePoint"
    // InternalFSM.g:1251:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:1257:2: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalFSM.g:1258:2: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalFSM.g:1258:2: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalFSM.g:1259:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
            		
            // InternalFSM.g:1263:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFSM.g:1264:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFSM.g:1264:4: (lv_name_1_0= RULE_ID )
            // InternalFSM.g:1265:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getChoicePointAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoicePointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFSM.g:1281:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==57) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalFSM.g:1282:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalFSM.g:1282:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalFSM.g:1283:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getChoicePointRule());
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


    // $ANTLR start "entryRuleTransitionBase"
    // InternalFSM.g:1304:1: entryRuleTransitionBase returns [EObject current=null] : iv_ruleTransitionBase= ruleTransitionBase EOF ;
    public final EObject entryRuleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionBase = null;


        try {
            // InternalFSM.g:1304:55: (iv_ruleTransitionBase= ruleTransitionBase EOF )
            // InternalFSM.g:1305:2: iv_ruleTransitionBase= ruleTransitionBase EOF
            {
             newCompositeNode(grammarAccess.getTransitionBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionBase=ruleTransitionBase();

            state._fsp--;

             current =iv_ruleTransitionBase; 
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
    // $ANTLR end "entryRuleTransitionBase"


    // $ANTLR start "ruleTransitionBase"
    // InternalFSM.g:1311:1: ruleTransitionBase returns [EObject current=null] : (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) ;
    public final EObject ruleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_RefinedTransition_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:1317:2: ( (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) )
            // InternalFSM.g:1318:2: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            {
            // InternalFSM.g:1318:2: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                alt27=1;
            }
            else if ( (LA27_0==39) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalFSM.g:1319:3: this_Transition_0= ruleTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionBaseAccess().getTransitionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Transition_0=ruleTransition();

                    state._fsp--;


                    			current = this_Transition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:1328:3: this_RefinedTransition_1= ruleRefinedTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionBaseAccess().getRefinedTransitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RefinedTransition_1=ruleRefinedTransition();

                    state._fsp--;


                    			current = this_RefinedTransition_1;
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
    // $ANTLR end "ruleTransitionBase"


    // $ANTLR start "entryRuleTransition"
    // InternalFSM.g:1340:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalFSM.g:1340:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalFSM.g:1341:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalFSM.g:1347:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:1353:2: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalFSM.g:1354:2: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalFSM.g:1354:2: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==RULE_ID) ) {
                    int LA28_2 = input.LA(3);

                    if ( (LA28_2==31) ) {
                        int LA28_3 = input.LA(4);

                        if ( (LA28_3==RULE_ID||LA28_3==40||LA28_3==42) ) {
                            alt28=2;
                        }
                        else if ( (LA28_3==32) ) {
                            alt28=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA28_1==31) ) {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==RULE_ID||LA28_3==40||LA28_3==42) ) {
                        alt28=2;
                    }
                    else if ( (LA28_3==32) ) {
                        alt28=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalFSM.g:1355:3: this_InitialTransition_0= ruleInitialTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;


                    			current = this_InitialTransition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:1364:3: this_NonInitialTransition_1= ruleNonInitialTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:1376:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalFSM.g:1376:61: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalFSM.g:1377:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
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
    // $ANTLR end "entryRuleNonInitialTransition"


    // $ANTLR start "ruleNonInitialTransition"
    // InternalFSM.g:1383:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;



        	enterRule();

        try {
            // InternalFSM.g:1389:2: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalFSM.g:1390:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalFSM.g:1390:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalFSM.g:1391:3: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
                    {

                    			newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTransitionChainStartTransitionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TransitionChainStartTransition_0=ruleTransitionChainStartTransition();

                    state._fsp--;


                    			current = this_TransitionChainStartTransition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:1400:3: this_ContinuationTransition_1= ruleContinuationTransition
                    {

                    			newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContinuationTransition_1=ruleContinuationTransition();

                    state._fsp--;


                    			current = this_ContinuationTransition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFSM.g:1409:3: this_CPBranchTransition_2= ruleCPBranchTransition
                    {

                    			newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:1421:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalFSM.g:1421:71: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalFSM.g:1422:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionChainStartTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionChainStartTransition=ruleTransitionChainStartTransition();

            state._fsp--;

             current =iv_ruleTransitionChainStartTransition; 
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
    // $ANTLR end "entryRuleTransitionChainStartTransition"


    // $ANTLR start "ruleTransitionChainStartTransition"
    // InternalFSM.g:1428:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:1434:2: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalFSM.g:1435:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalFSM.g:1435:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalFSM.g:1436:3: this_TriggeredTransition_0= ruleTriggeredTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getTriggeredTransitionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;


                    			current = this_TriggeredTransition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:1445:3: this_GuardedTransition_1= ruleGuardedTransition
                    {

                    			newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getGuardedTransitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:1457:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalFSM.g:1457:58: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalFSM.g:1458:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
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
    // $ANTLR end "entryRuleInitialTransition"


    // $ANTLR start "ruleInitialTransition"
    // InternalFSM.g:1464:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
    public final EObject ruleInitialTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_annotations_8_0 = null;

        EObject lv_action_10_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:1470:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalFSM.g:1471:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalFSM.g:1471:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalFSM.g:1472:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
            		
            // InternalFSM.g:1476:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalFSM.g:1477:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFSM.g:1477:4: (lv_name_1_0= RULE_ID )
                    // InternalFSM.g:1478:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getInitialTransitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInitialTransitionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,32,FOLLOW_26); 

            			newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
            		
            otherlv_4=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalFSM.g:1506:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalFSM.g:1507:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:1507:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalFSM.g:1508:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:1525:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==57) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalFSM.g:1526:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalFSM.g:1526:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalFSM.g:1527:5: lv_docu_6_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    					}
                    					set(
                    						current,
                    						"docu",
                    						lv_docu_6_0,
                    						"org.eclipse.etrice.core.common.Base.Documentation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFSM.g:1544:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalFSM.g:1545:4: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_28); 

                    				newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                    			
                    // InternalFSM.g:1549:4: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==51) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalFSM.g:1550:5: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalFSM.g:1550:5: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalFSM.g:1551:6: lv_annotations_8_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getInitialTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    lv_annotations_8_0=ruleAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotations",
                    	    							lv_annotations_8_0,
                    	    							"org.eclipse.etrice.core.common.Base.Annotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // InternalFSM.g:1568:4: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==34) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalFSM.g:1569:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,34,FOLLOW_29); 

                            					newLeafNode(otherlv_9, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_2_0());
                            				
                            // InternalFSM.g:1573:5: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalFSM.g:1574:6: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalFSM.g:1574:6: (lv_action_10_0= ruleDetailCode )
                            // InternalFSM.g:1575:7: lv_action_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0());
                            						
                            pushFollow(FOLLOW_18);
                            lv_action_10_0=ruleDetailCode();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                            							}
                            							set(
                            								current,
                            								"action",
                            								lv_action_10_0,
                            								"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_7_3());
                    			

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
    // $ANTLR end "ruleInitialTransition"


    // $ANTLR start "entryRuleContinuationTransition"
    // InternalFSM.g:1602:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalFSM.g:1602:63: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalFSM.g:1603:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
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
    // $ANTLR end "entryRuleContinuationTransition"


    // $ANTLR start "ruleContinuationTransition"
    // InternalFSM.g:1609:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
    public final EObject ruleContinuationTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_annotations_8_0 = null;

        EObject lv_action_10_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:1615:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalFSM.g:1616:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalFSM.g:1616:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalFSM.g:1617:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
            		
            // InternalFSM.g:1621:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalFSM.g:1622:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFSM.g:1622:4: (lv_name_1_0= RULE_ID )
                    // InternalFSM.g:1623:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getContinuationTransitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContinuationTransitionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
            		
            // InternalFSM.g:1643:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalFSM.g:1644:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:1644:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalFSM.g:1645:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_3_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalFSM.g:1666:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalFSM.g:1667:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:1667:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalFSM.g:1668:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:1685:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==57) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalFSM.g:1686:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalFSM.g:1686:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalFSM.g:1687:5: lv_docu_6_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                    					}
                    					set(
                    						current,
                    						"docu",
                    						lv_docu_6_0,
                    						"org.eclipse.etrice.core.common.Base.Documentation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFSM.g:1704:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalFSM.g:1705:4: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_28); 

                    				newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                    			
                    // InternalFSM.g:1709:4: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==51) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalFSM.g:1710:5: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalFSM.g:1710:5: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalFSM.g:1711:6: lv_annotations_8_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getContinuationTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    lv_annotations_8_0=ruleAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotations",
                    	    							lv_annotations_8_0,
                    	    							"org.eclipse.etrice.core.common.Base.Annotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    // InternalFSM.g:1728:4: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==34) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalFSM.g:1729:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,34,FOLLOW_29); 

                            					newLeafNode(otherlv_9, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_2_0());
                            				
                            // InternalFSM.g:1733:5: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalFSM.g:1734:6: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalFSM.g:1734:6: (lv_action_10_0= ruleDetailCode )
                            // InternalFSM.g:1735:7: lv_action_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0());
                            						
                            pushFollow(FOLLOW_18);
                            lv_action_10_0=ruleDetailCode();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                            							}
                            							set(
                            								current,
                            								"action",
                            								lv_action_10_0,
                            								"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getContinuationTransitionAccess().getRightCurlyBracketKeyword_7_3());
                    			

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
    // InternalFSM.g:1762:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalFSM.g:1762:60: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalFSM.g:1763:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
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
    // $ANTLR end "entryRuleTriggeredTransition"


    // $ANTLR start "ruleTriggeredTransition"
    // InternalFSM.g:1769:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_annotations_10_0 = null;

        EObject lv_triggers_11_0 = null;

        EObject lv_triggers_13_0 = null;

        EObject lv_action_16_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:1775:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) )
            // InternalFSM.g:1776:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            {
            // InternalFSM.g:1776:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            // InternalFSM.g:1777:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
            		
            // InternalFSM.g:1781:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalFSM.g:1782:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFSM.g:1782:4: (lv_name_1_0= RULE_ID )
                    // InternalFSM.g:1783:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getTriggeredTransitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTriggeredTransitionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
            		
            // InternalFSM.g:1803:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalFSM.g:1804:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:1804:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalFSM.g:1805:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_3_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalFSM.g:1826:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalFSM.g:1827:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:1827:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalFSM.g:1828:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_19);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:1845:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==57) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalFSM.g:1846:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalFSM.g:1846:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalFSM.g:1847:5: lv_docu_6_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    					}
                    					set(
                    						current,
                    						"docu",
                    						lv_docu_6_0,
                    						"org.eclipse.etrice.core.common.Base.Documentation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_30); 

            			newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
            		
            otherlv_9=(Token)match(input,16,FOLLOW_31); 

            			newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalFSM.g:1876:3: ( (lv_annotations_10_0= ruleAnnotation ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==51) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalFSM.g:1877:4: (lv_annotations_10_0= ruleAnnotation )
            	    {
            	    // InternalFSM.g:1877:4: (lv_annotations_10_0= ruleAnnotation )
            	    // InternalFSM.g:1878:5: lv_annotations_10_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getAnnotationsAnnotationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_annotations_10_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_10_0,
            	    						"org.eclipse.etrice.core.common.Base.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // InternalFSM.g:1895:3: ( (lv_triggers_11_0= ruleTrigger ) )
            // InternalFSM.g:1896:4: (lv_triggers_11_0= ruleTrigger )
            {
            // InternalFSM.g:1896:4: (lv_triggers_11_0= ruleTrigger )
            // InternalFSM.g:1897:5: lv_triggers_11_0= ruleTrigger
            {

            					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_32);
            lv_triggers_11_0=ruleTrigger();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            					}
            					add(
            						current,
            						"triggers",
            						lv_triggers_11_0,
            						"org.eclipse.etrice.core.fsm.FSM.Trigger");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:1914:3: (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==36) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalFSM.g:1915:4: otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) )
            	    {
            	    otherlv_12=(Token)match(input,36,FOLLOW_31); 

            	    				newLeafNode(otherlv_12, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_12_0());
            	    			
            	    // InternalFSM.g:1919:4: ( (lv_triggers_13_0= ruleTrigger ) )
            	    // InternalFSM.g:1920:5: (lv_triggers_13_0= ruleTrigger )
            	    {
            	    // InternalFSM.g:1920:5: (lv_triggers_13_0= ruleTrigger )
            	    // InternalFSM.g:1921:6: lv_triggers_13_0= ruleTrigger
            	    {

            	    						newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_12_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_triggers_13_0=ruleTrigger();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"triggers",
            	    							lv_triggers_13_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.Trigger");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_14=(Token)match(input,17,FOLLOW_33); 

            			newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_13());
            		
            // InternalFSM.g:1943:3: (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==34) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalFSM.g:1944:4: otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) )
                    {
                    otherlv_15=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_15, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_14_0());
                    			
                    // InternalFSM.g:1948:4: ( (lv_action_16_0= ruleDetailCode ) )
                    // InternalFSM.g:1949:5: (lv_action_16_0= ruleDetailCode )
                    {
                    // InternalFSM.g:1949:5: (lv_action_16_0= ruleDetailCode )
                    // InternalFSM.g:1950:6: lv_action_16_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_action_16_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_16_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_15());
            		

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
    // InternalFSM.g:1976:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalFSM.g:1976:58: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalFSM.g:1977:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
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
    // $ANTLR end "entryRuleGuardedTransition"


    // $ANTLR start "ruleGuardedTransition"
    // InternalFSM.g:1983:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleGuardedTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_annotations_8_0 = null;

        EObject lv_guard_10_0 = null;

        EObject lv_action_12_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:1989:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalFSM.g:1990:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalFSM.g:1990:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalFSM.g:1991:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
            		
            // InternalFSM.g:1995:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalFSM.g:1996:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFSM.g:1996:4: (lv_name_1_0= RULE_ID )
                    // InternalFSM.g:1997:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getGuardedTransitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGuardedTransitionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
            		
            // InternalFSM.g:2017:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalFSM.g:2018:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:2018:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalFSM.g:2019:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_3_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalFSM.g:2040:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalFSM.g:2041:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:2041:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalFSM.g:2042:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_19);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2059:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==57) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalFSM.g:2060:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalFSM.g:2060:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalFSM.g:2061:5: lv_docu_6_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    					}
                    					set(
                    						current,
                    						"docu",
                    						lv_docu_6_0,
                    						"org.eclipse.etrice.core.common.Base.Documentation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_34); 

            			newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalFSM.g:2082:3: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==51) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalFSM.g:2083:4: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalFSM.g:2083:4: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalFSM.g:2084:5: lv_annotations_8_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_annotations_8_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_8_0,
            	    						"org.eclipse.etrice.core.common.Base.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_9=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_9, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_9());
            		
            // InternalFSM.g:2105:3: ( (lv_guard_10_0= ruleDetailCode ) )
            // InternalFSM.g:2106:4: (lv_guard_10_0= ruleDetailCode )
            {
            // InternalFSM.g:2106:4: (lv_guard_10_0= ruleDetailCode )
            // InternalFSM.g:2107:5: lv_guard_10_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_33);
            lv_guard_10_0=ruleDetailCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            					}
            					set(
            						current,
            						"guard",
            						lv_guard_10_0,
            						"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2124:3: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==34) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalFSM.g:2125:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_11, grammarAccess.getGuardedTransitionAccess().getActionKeyword_11_0());
                    			
                    // InternalFSM.g:2129:4: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalFSM.g:2130:5: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalFSM.g:2130:5: (lv_action_12_0= ruleDetailCode )
                    // InternalFSM.g:2131:6: lv_action_12_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_action_12_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_12_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getGuardedTransitionAccess().getRightCurlyBracketKeyword_12());
            		

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
    // InternalFSM.g:2157:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalFSM.g:2157:59: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalFSM.g:2158:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
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
    // $ANTLR end "entryRuleCPBranchTransition"


    // $ANTLR start "ruleCPBranchTransition"
    // InternalFSM.g:2164:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;

        EObject lv_docu_6_0 = null;

        EObject lv_annotations_8_0 = null;

        EObject lv_condition_10_0 = null;

        EObject lv_action_12_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:2170:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalFSM.g:2171:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalFSM.g:2171:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalFSM.g:2172:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
            		
            // InternalFSM.g:2176:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalFSM.g:2177:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFSM.g:2177:4: (lv_name_1_0= RULE_ID )
                    // InternalFSM.g:2178:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getCPBranchTransitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCPBranchTransitionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
            		
            // InternalFSM.g:2198:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalFSM.g:2199:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:2199:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalFSM.g:2200:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_from_3_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_3_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalFSM.g:2221:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalFSM.g:2222:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalFSM.g:2222:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalFSM.g:2223:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_19);
            lv_to_5_0=ruleTransitionTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"org.eclipse.etrice.core.fsm.FSM.TransitionTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2240:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==57) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalFSM.g:2241:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalFSM.g:2241:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalFSM.g:2242:5: lv_docu_6_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    					}
                    					set(
                    						current,
                    						"docu",
                    						lv_docu_6_0,
                    						"org.eclipse.etrice.core.common.Base.Documentation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_36); 

            			newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalFSM.g:2263:3: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==51) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalFSM.g:2264:4: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalFSM.g:2264:4: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalFSM.g:2265:5: lv_annotations_8_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_annotations_8_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_8_0,
            	    						"org.eclipse.etrice.core.common.Base.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_9=(Token)match(input,38,FOLLOW_35); 

            			newLeafNode(otherlv_9, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_9());
            		
            // InternalFSM.g:2286:3: ( (lv_condition_10_0= ruleDetailCode ) )
            // InternalFSM.g:2287:4: (lv_condition_10_0= ruleDetailCode )
            {
            // InternalFSM.g:2287:4: (lv_condition_10_0= ruleDetailCode )
            // InternalFSM.g:2288:5: lv_condition_10_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_33);
            lv_condition_10_0=ruleDetailCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_10_0,
            						"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2305:3: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==34) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalFSM.g:2306:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_11, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_11_0());
                    			
                    // InternalFSM.g:2310:4: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalFSM.g:2311:5: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalFSM.g:2311:5: (lv_action_12_0= ruleDetailCode )
                    // InternalFSM.g:2312:6: lv_action_12_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_action_12_0=ruleDetailCode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_12_0,
                    							"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getCPBranchTransitionAccess().getRightCurlyBracketKeyword_12());
            		

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
    // InternalFSM.g:2338:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalFSM.g:2338:58: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalFSM.g:2339:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
            {
             newCompositeNode(grammarAccess.getRefinedTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefinedTransition=ruleRefinedTransition();

            state._fsp--;

             current =iv_ruleRefinedTransition; 
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
    // $ANTLR end "entryRuleRefinedTransition"


    // $ANTLR start "ruleRefinedTransition"
    // InternalFSM.g:2345:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) ;
    public final EObject ruleRefinedTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_action_6_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:2351:2: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) )
            // InternalFSM.g:2352:2: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            {
            // InternalFSM.g:2352:2: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            // InternalFSM.g:2353:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
            		
            // InternalFSM.g:2357:3: ( ( ruleFQN ) )
            // InternalFSM.g:2358:4: ( ruleFQN )
            {
            // InternalFSM.g:2358:4: ( ruleFQN )
            // InternalFSM.g:2359:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefinedTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getTargetTransitionCrossReference_1_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2373:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==57) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalFSM.g:2374:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalFSM.g:2374:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalFSM.g:2375:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
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

            otherlv_3=(Token)match(input,16,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalFSM.g:2396:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==51) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalFSM.g:2397:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalFSM.g:2397:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalFSM.g:2398:5: lv_annotations_4_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getAnnotationsAnnotationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_4_0,
            	    						"org.eclipse.etrice.core.common.Base.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_29); 

            			newLeafNode(otherlv_5, grammarAccess.getRefinedTransitionAccess().getActionKeyword_5());
            		
            // InternalFSM.g:2419:3: ( (lv_action_6_0= ruleDetailCode ) )
            // InternalFSM.g:2420:4: (lv_action_6_0= ruleDetailCode )
            {
            // InternalFSM.g:2420:4: (lv_action_6_0= ruleDetailCode )
            // InternalFSM.g:2421:5: lv_action_6_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_18);
            lv_action_6_0=ruleDetailCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_6_0,
            						"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRefinedTransitionAccess().getRightCurlyBracketKeyword_7());
            		

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
    // InternalFSM.g:2446:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalFSM.g:2446:59: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalFSM.g:2447:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
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
    // $ANTLR end "entryRuleTransitionTerminal"


    // $ANTLR start "ruleTransitionTerminal"
    // InternalFSM.g:2453:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;



        	enterRule();

        try {
            // InternalFSM.g:2459:2: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalFSM.g:2460:2: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalFSM.g:2460:2: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt56=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==EOF||(LA56_1>=16 && LA56_1<=17)||LA56_1==19||(LA56_1>=24 && LA56_1<=30)||LA56_1==33||LA56_1==39||LA56_1==57) ) {
                    alt56=1;
                }
                else if ( (LA56_1==41) ) {
                    alt56=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                alt56=2;
                }
                break;
            case 42:
                {
                alt56=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalFSM.g:2461:3: this_StateTerminal_0= ruleStateTerminal
                    {

                    			newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;


                    			current = this_StateTerminal_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:2470:3: this_TrPointTerminal_1= ruleTrPointTerminal
                    {

                    			newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;


                    			current = this_TrPointTerminal_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFSM.g:2479:3: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {

                    			newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;


                    			current = this_SubStateTrPointTerminal_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFSM.g:2488:3: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {

                    			newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:2500:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalFSM.g:2500:54: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalFSM.g:2501:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
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
    // $ANTLR end "entryRuleStateTerminal"


    // $ANTLR start "ruleStateTerminal"
    // InternalFSM.g:2507:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFSM.g:2513:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFSM.g:2514:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFSM.g:2514:2: ( (otherlv_0= RULE_ID ) )
            // InternalFSM.g:2515:3: (otherlv_0= RULE_ID )
            {
            // InternalFSM.g:2515:3: (otherlv_0= RULE_ID )
            // InternalFSM.g:2516:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStateTerminalRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFSM.g:2530:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalFSM.g:2530:56: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalFSM.g:2531:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
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
    // $ANTLR end "entryRuleTrPointTerminal"


    // $ANTLR start "ruleTrPointTerminal"
    // InternalFSM.g:2537:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalFSM.g:2543:2: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalFSM.g:2544:2: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalFSM.g:2544:2: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalFSM.g:2545:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
            		
            // InternalFSM.g:2549:3: ( (otherlv_1= RULE_ID ) )
            // InternalFSM.g:2550:4: (otherlv_1= RULE_ID )
            {
            // InternalFSM.g:2550:4: (otherlv_1= RULE_ID )
            // InternalFSM.g:2551:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTrPointTerminalRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFSM.g:2566:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalFSM.g:2566:64: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalFSM.g:2567:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
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
    // $ANTLR end "entryRuleSubStateTrPointTerminal"


    // $ANTLR start "ruleSubStateTrPointTerminal"
    // InternalFSM.g:2573:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalFSM.g:2579:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalFSM.g:2580:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalFSM.g:2580:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalFSM.g:2581:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalFSM.g:2581:3: ( (otherlv_0= RULE_ID ) )
            // InternalFSM.g:2582:4: (otherlv_0= RULE_ID )
            {
            // InternalFSM.g:2582:4: (otherlv_0= RULE_ID )
            // InternalFSM.g:2583:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
            		
            // InternalFSM.g:2598:3: ( (otherlv_2= RULE_ID ) )
            // InternalFSM.g:2599:4: (otherlv_2= RULE_ID )
            {
            // InternalFSM.g:2599:4: (otherlv_2= RULE_ID )
            // InternalFSM.g:2600:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFSM.g:2615:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalFSM.g:2615:60: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalFSM.g:2616:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
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
    // $ANTLR end "entryRuleChoicepointTerminal"


    // $ANTLR start "ruleChoicepointTerminal"
    // InternalFSM.g:2622:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalFSM.g:2628:2: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalFSM.g:2629:2: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalFSM.g:2629:2: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalFSM.g:2630:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
            		
            // InternalFSM.g:2634:3: ( (otherlv_1= RULE_ID ) )
            // InternalFSM.g:2635:4: (otherlv_1= RULE_ID )
            {
            // InternalFSM.g:2635:4: (otherlv_1= RULE_ID )
            // InternalFSM.g:2636:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFSM.g:2651:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalFSM.g:2651:48: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalFSM.g:2652:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
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
    // $ANTLR end "entryRuleTrigger"


    // $ANTLR start "ruleTrigger"
    // InternalFSM.g:2658:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalFSM.g:2664:2: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalFSM.g:2665:2: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalFSM.g:2665:2: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalFSM.g:2666:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
            		
            // InternalFSM.g:2670:3: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalFSM.g:2671:4: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalFSM.g:2671:4: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalFSM.g:2672:5: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {

            					newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_39);
            lv_msgFromIfPairs_1_0=ruleMessageFromIf();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggerRule());
            					}
            					add(
            						current,
            						"msgFromIfPairs",
            						lv_msgFromIfPairs_1_0,
            						"org.eclipse.etrice.core.fsm.FSM.MessageFromIf");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:2689:3: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==44) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalFSM.g:2690:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,44,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	    			
            	    // InternalFSM.g:2694:4: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalFSM.g:2695:5: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalFSM.g:2695:5: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalFSM.g:2696:6: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {

            	    						newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_msgFromIfPairs_3_0=ruleMessageFromIf();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTriggerRule());
            	    						}
            	    						add(
            	    							current,
            	    							"msgFromIfPairs",
            	    							lv_msgFromIfPairs_3_0,
            	    							"org.eclipse.etrice.core.fsm.FSM.MessageFromIf");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalFSM.g:2714:3: ( (lv_guard_4_0= ruleGuard ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==37) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalFSM.g:2715:4: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalFSM.g:2715:4: (lv_guard_4_0= ruleGuard )
                    // InternalFSM.g:2716:5: lv_guard_4_0= ruleGuard
                    {

                    					newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_40);
                    lv_guard_4_0=ruleGuard();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTriggerRule());
                    					}
                    					set(
                    						current,
                    						"guard",
                    						lv_guard_4_0,
                    						"org.eclipse.etrice.core.fsm.FSM.Guard");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

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
    // InternalFSM.g:2741:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalFSM.g:2741:54: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalFSM.g:2742:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
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
    // $ANTLR end "entryRuleMessageFromIf"


    // $ANTLR start "ruleMessageFromIf"
    // InternalFSM.g:2748:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalFSM.g:2754:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalFSM.g:2755:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalFSM.g:2755:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalFSM.g:2756:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalFSM.g:2756:3: ( (otherlv_0= RULE_ID ) )
            // InternalFSM.g:2757:4: (otherlv_0= RULE_ID )
            {
            // InternalFSM.g:2757:4: (otherlv_0= RULE_ID )
            // InternalFSM.g:2758:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageFromIfRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageEObjectCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
            		
            // InternalFSM.g:2773:3: ( (otherlv_2= RULE_ID ) )
            // InternalFSM.g:2774:4: (otherlv_2= RULE_ID )
            {
            // InternalFSM.g:2774:4: (otherlv_2= RULE_ID )
            // InternalFSM.g:2775:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageFromIfRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFSM.g:2790:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalFSM.g:2790:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalFSM.g:2791:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
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
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // InternalFSM.g:2797:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:2803:2: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalFSM.g:2804:2: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalFSM.g:2804:2: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalFSM.g:2805:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
            		
            // InternalFSM.g:2809:3: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalFSM.g:2810:4: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalFSM.g:2810:4: (lv_guard_1_0= ruleDetailCode )
            // InternalFSM.g:2811:5: lv_guard_1_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_guard_1_0=ruleDetailCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardRule());
            					}
            					set(
            						current,
            						"guard",
            						lv_guard_1_0,
            						"org.eclipse.etrice.core.fsm.FSM.DetailCode");
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
    // InternalFSM.g:2832:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalFSM.g:2832:54: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalFSM.g:2833:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getSemanticsRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSemanticsRule=ruleSemanticsRule();

            state._fsp--;

             current =iv_ruleSemanticsRule; 
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
    // $ANTLR end "entryRuleSemanticsRule"


    // $ANTLR start "ruleSemanticsRule"
    // InternalFSM.g:2839:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:2845:2: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalFSM.g:2846:2: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalFSM.g:2846:2: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==46) ) {
                alt59=1;
            }
            else if ( (LA59_0==50) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalFSM.g:2847:3: this_InSemanticsRule_0= ruleInSemanticsRule
                    {

                    			newCompositeNode(grammarAccess.getSemanticsRuleAccess().getInSemanticsRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InSemanticsRule_0=ruleInSemanticsRule();

                    state._fsp--;


                    			current = this_InSemanticsRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFSM.g:2856:3: this_OutSemanticsRule_1= ruleOutSemanticsRule
                    {

                    			newCompositeNode(grammarAccess.getSemanticsRuleAccess().getOutSemanticsRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
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
    // InternalFSM.g:2868:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalFSM.g:2868:56: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalFSM.g:2869:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getInSemanticsRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInSemanticsRule=ruleInSemanticsRule();

            state._fsp--;

             current =iv_ruleInSemanticsRule; 
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
    // $ANTLR end "entryRuleInSemanticsRule"


    // $ANTLR start "ruleInSemanticsRule"
    // InternalFSM.g:2875:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalFSM.g:2881:2: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalFSM.g:2882:2: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalFSM.g:2882:2: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalFSM.g:2883:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
            		
            // InternalFSM.g:2891:3: ( (otherlv_2= RULE_ID ) )
            // InternalFSM.g:2892:4: (otherlv_2= RULE_ID )
            {
            // InternalFSM.g:2892:4: (otherlv_2= RULE_ID )
            // InternalFSM.g:2893:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0());
            				

            }


            }

            // InternalFSM.g:2904:3: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==33) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalFSM.g:2905:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_43); 

                    				newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalFSM.g:2909:4: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==46||LA61_0==50) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==47) ) {
                        alt61=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalFSM.g:2910:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalFSM.g:2910:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalFSM.g:2911:6: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalFSM.g:2911:6: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalFSM.g:2912:7: lv_followUps_4_0= ruleSemanticsRule
                            {

                            							newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            							}
                            							add(
                            								current,
                            								"followUps",
                            								lv_followUps_4_0,
                            								"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFSM.g:2930:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalFSM.g:2930:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalFSM.g:2931:6: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,47,FOLLOW_44); 

                            						newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                            					
                            // InternalFSM.g:2935:6: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalFSM.g:2936:7: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalFSM.g:2936:7: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalFSM.g:2937:8: lv_followUps_6_0= ruleSemanticsRule
                            {

                            								newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0());
                            							
                            pushFollow(FOLLOW_45);
                            lv_followUps_6_0=ruleSemanticsRule();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            								}
                            								add(
                            									current,
                            									"followUps",
                            									lv_followUps_6_0,
                            									"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalFSM.g:2954:6: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt60=0;
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==48) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // InternalFSM.g:2955:7: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,48,FOLLOW_44); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	    						
                            	    // InternalFSM.g:2959:7: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalFSM.g:2960:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalFSM.g:2960:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalFSM.g:2961:9: lv_followUps_8_0= ruleSemanticsRule
                            	    {

                            	    									newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_46);
                            	    lv_followUps_8_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getInSemanticsRuleRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"followUps",
                            	    										lv_followUps_8_0,
                            	    										"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt60 >= 1 ) break loop60;
                                        EarlyExitException eee =
                                            new EarlyExitException(60, input);
                                        throw eee;
                                }
                                cnt60++;
                            } while (true);

                            otherlv_9=(Token)match(input,49,FOLLOW_2); 

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
    // InternalFSM.g:2990:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalFSM.g:2990:57: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalFSM.g:2991:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getOutSemanticsRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutSemanticsRule=ruleOutSemanticsRule();

            state._fsp--;

             current =iv_ruleOutSemanticsRule; 
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
    // $ANTLR end "entryRuleOutSemanticsRule"


    // $ANTLR start "ruleOutSemanticsRule"
    // InternalFSM.g:2997:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalFSM.g:3003:2: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalFSM.g:3004:2: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalFSM.g:3004:2: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalFSM.g:3005:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
            		
            // InternalFSM.g:3013:3: ( (otherlv_2= RULE_ID ) )
            // InternalFSM.g:3014:4: (otherlv_2= RULE_ID )
            {
            // InternalFSM.g:3014:4: (otherlv_2= RULE_ID )
            // InternalFSM.g:3015:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0());
            				

            }


            }

            // InternalFSM.g:3026:3: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==33) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalFSM.g:3027:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_43); 

                    				newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalFSM.g:3031:4: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==46||LA64_0==50) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==47) ) {
                        alt64=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalFSM.g:3032:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalFSM.g:3032:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalFSM.g:3033:6: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalFSM.g:3033:6: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalFSM.g:3034:7: lv_followUps_4_0= ruleSemanticsRule
                            {

                            							newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            							}
                            							add(
                            								current,
                            								"followUps",
                            								lv_followUps_4_0,
                            								"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalFSM.g:3052:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalFSM.g:3052:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalFSM.g:3053:6: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,47,FOLLOW_44); 

                            						newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                            					
                            // InternalFSM.g:3057:6: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalFSM.g:3058:7: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalFSM.g:3058:7: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalFSM.g:3059:8: lv_followUps_6_0= ruleSemanticsRule
                            {

                            								newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0());
                            							
                            pushFollow(FOLLOW_45);
                            lv_followUps_6_0=ruleSemanticsRule();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            								}
                            								add(
                            									current,
                            									"followUps",
                            									lv_followUps_6_0,
                            									"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalFSM.g:3076:6: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt63=0;
                            loop63:
                            do {
                                int alt63=2;
                                int LA63_0 = input.LA(1);

                                if ( (LA63_0==48) ) {
                                    alt63=1;
                                }


                                switch (alt63) {
                            	case 1 :
                            	    // InternalFSM.g:3077:7: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,48,FOLLOW_44); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	    						
                            	    // InternalFSM.g:3081:7: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalFSM.g:3082:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalFSM.g:3082:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalFSM.g:3083:9: lv_followUps_8_0= ruleSemanticsRule
                            	    {

                            	    									newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_46);
                            	    lv_followUps_8_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    									if (current==null) {
                            	    										current = createModelElementForParent(grammarAccess.getOutSemanticsRuleRule());
                            	    									}
                            	    									add(
                            	    										current,
                            	    										"followUps",
                            	    										lv_followUps_8_0,
                            	    										"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
                            	    									afterParserOrEnumRuleCall();
                            	    								

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt63 >= 1 ) break loop63;
                                        EarlyExitException eee =
                                            new EarlyExitException(63, input);
                                        throw eee;
                                }
                                cnt63++;
                            } while (true);

                            otherlv_9=(Token)match(input,49,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAnnotation"
    // InternalFSM.g:3112:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalFSM.g:3112:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalFSM.g:3113:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
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
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalFSM.g:3119:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:3125:2: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalFSM.g:3126:2: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalFSM.g:3126:2: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalFSM.g:3127:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalFSM.g:3131:3: ( ( ruleFQN ) )
            // InternalFSM.g:3132:4: ( ruleFQN )
            {
            // InternalFSM.g:3132:4: ( ruleFQN )
            // InternalFSM.g:3133:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0());
            				
            pushFollow(FOLLOW_47);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFSM.g:3147:3: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==47) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalFSM.g:3148:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalFSM.g:3152:4: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalFSM.g:3153:5: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalFSM.g:3153:5: (lv_attributes_3_0= ruleKeyValue )
                    // InternalFSM.g:3154:6: lv_attributes_3_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_attributes_3_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_3_0,
                    							"org.eclipse.etrice.core.common.Base.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalFSM.g:3171:4: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==48) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalFSM.g:3172:5: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,48,FOLLOW_5); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalFSM.g:3176:5: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalFSM.g:3177:6: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalFSM.g:3177:6: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalFSM.g:3178:7: lv_attributes_5_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_46);
                    	    lv_attributes_5_0=ruleKeyValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_5_0,
                    	    								"org.eclipse.etrice.core.common.Base.KeyValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,49,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_2_3());
                    			

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
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleKeyValue"
    // InternalFSM.g:3205:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalFSM.g:3205:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalFSM.g:3206:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalFSM.g:3212:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:3218:2: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalFSM.g:3219:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalFSM.g:3219:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalFSM.g:3220:3: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalFSM.g:3220:3: ( (lv_key_0_0= RULE_ID ) )
            // InternalFSM.g:3221:4: (lv_key_0_0= RULE_ID )
            {
            // InternalFSM.g:3221:4: (lv_key_0_0= RULE_ID )
            // InternalFSM.g:3222:5: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_48); 

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

            otherlv_1=(Token)match(input,52,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalFSM.g:3242:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalFSM.g:3243:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalFSM.g:3243:4: (lv_value_2_0= ruleLiteral )
            // InternalFSM.g:3244:5: lv_value_2_0= ruleLiteral
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
    // InternalFSM.g:3265:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalFSM.g:3265:60: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalFSM.g:3266:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalFSM.g:3272:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalFSM.g:3278:2: (this_ID_0= RULE_ID )
            // InternalFSM.g:3279:2: this_ID_0= RULE_ID
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
    // InternalFSM.g:3289:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalFSM.g:3289:60: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalFSM.g:3290:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalFSM.g:3296:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:3302:2: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalFSM.g:3303:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalFSM.g:3303:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==53) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==55) ) {
                    int LA68_3 = input.LA(3);

                    if ( (LA68_3==RULE_ID) ) {
                        int LA68_4 = input.LA(4);

                        if ( (LA68_4==31) ) {
                            int LA68_5 = input.LA(5);

                            if ( (LA68_5==16) ) {
                                alt68=2;
                            }
                            else if ( ((LA68_5>=70 && LA68_5<=73)) ) {
                                alt68=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 68, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 68, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA68_0==54) ) {
                int LA68_2 = input.LA(2);

                if ( (LA68_2==55) ) {
                    int LA68_3 = input.LA(3);

                    if ( (LA68_3==RULE_ID) ) {
                        int LA68_4 = input.LA(4);

                        if ( (LA68_4==31) ) {
                            int LA68_5 = input.LA(5);

                            if ( (LA68_5==16) ) {
                                alt68=2;
                            }
                            else if ( ((LA68_5>=70 && LA68_5<=73)) ) {
                                alt68=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 68, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 68, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalFSM.g:3304:3: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalFSM.g:3313:3: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalFSM.g:3325:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalFSM.g:3325:66: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalFSM.g:3326:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalFSM.g:3332:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalFSM.g:3338:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalFSM.g:3339:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalFSM.g:3339:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalFSM.g:3340:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalFSM.g:3340:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==53) ) {
                alt69=1;
            }
            else if ( (LA69_0==54) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalFSM.g:3341:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalFSM.g:3341:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalFSM.g:3342:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalFSM.g:3342:5: (lv_optional_0_0= 'optional' )
                    // InternalFSM.g:3343:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,53,FOLLOW_50); 

                    						newLeafNode(lv_optional_0_0, grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleAnnotationAttributeRule());
                    						}
                    						setWithLastConsumed(current, "optional", lv_optional_0_0 != null, "optional");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFSM.g:3356:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_50); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,55,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalFSM.g:3365:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalFSM.g:3366:4: (lv_name_3_0= RULE_ID )
            {
            // InternalFSM.g:3366:4: (lv_name_3_0= RULE_ID )
            // InternalFSM.g:3367:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_51); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
            		
            // InternalFSM.g:3387:3: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalFSM.g:3388:4: (lv_type_5_0= ruleLiteralType )
            {
            // InternalFSM.g:3388:4: (lv_type_5_0= ruleLiteralType )
            // InternalFSM.g:3389:5: lv_type_5_0= ruleLiteralType
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
    // InternalFSM.g:3410:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalFSM.g:3410:64: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalFSM.g:3411:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalFSM.g:3417:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalFSM.g:3423:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalFSM.g:3424:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalFSM.g:3424:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalFSM.g:3425:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalFSM.g:3425:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==53) ) {
                alt70=1;
            }
            else if ( (LA70_0==54) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalFSM.g:3426:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalFSM.g:3426:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalFSM.g:3427:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalFSM.g:3427:5: (lv_optional_0_0= 'optional' )
                    // InternalFSM.g:3428:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,53,FOLLOW_50); 

                    						newLeafNode(lv_optional_0_0, grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEnumAnnotationAttributeRule());
                    						}
                    						setWithLastConsumed(current, "optional", lv_optional_0_0 != null, "optional");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFSM.g:3441:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_50); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,55,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalFSM.g:3450:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalFSM.g:3451:4: (lv_name_3_0= RULE_ID )
            {
            // InternalFSM.g:3451:4: (lv_name_3_0= RULE_ID )
            // InternalFSM.g:3452:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            otherlv_4=(Token)match(input,31,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
            		
            otherlv_5=(Token)match(input,16,FOLLOW_52); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalFSM.g:3476:3: ( (lv_values_6_0= RULE_STRING ) )
            // InternalFSM.g:3477:4: (lv_values_6_0= RULE_STRING )
            {
            // InternalFSM.g:3477:4: (lv_values_6_0= RULE_STRING )
            // InternalFSM.g:3478:5: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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

            // InternalFSM.g:3494:3: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==48) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalFSM.g:3495:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,48,FOLLOW_52); 

            	    				newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalFSM.g:3499:4: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalFSM.g:3500:5: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalFSM.g:3500:5: (lv_values_8_0= RULE_STRING )
            	    // InternalFSM.g:3501:6: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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
            	    break loop71;
                }
            } while (true);

            otherlv_9=(Token)match(input,17,FOLLOW_2); 

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
    // InternalFSM.g:3526:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalFSM.g:3526:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalFSM.g:3527:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalFSM.g:3533:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:3539:2: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalFSM.g:3540:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalFSM.g:3540:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalFSM.g:3541:3: this_FQN_0= ruleFQN (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalFSM.g:3551:3: (kw= '.*' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==56) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalFSM.g:3552:4: kw= '.*'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

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
    // InternalFSM.g:3562:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalFSM.g:3562:54: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalFSM.g:3563:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalFSM.g:3569:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalFSM.g:3575:2: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalFSM.g:3576:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalFSM.g:3576:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalFSM.g:3577:3: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalFSM.g:3577:3: ()
            // InternalFSM.g:3578:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,57,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalFSM.g:3588:3: ( (lv_lines_2_0= RULE_STRING ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_STRING) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalFSM.g:3589:4: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalFSM.g:3589:4: (lv_lines_2_0= RULE_STRING )
            	    // InternalFSM.g:3590:5: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_55); 

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
            	    break loop73;
                }
            } while (true);

            otherlv_3=(Token)match(input,58,FOLLOW_2); 

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
    // InternalFSM.g:3614:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalFSM.g:3614:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalFSM.g:3615:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalFSM.g:3621:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;



        	enterRule();

        try {
            // InternalFSM.g:3627:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalFSM.g:3628:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalFSM.g:3628:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt74=3;
            switch ( input.LA(1) ) {
            case 59:
            case 60:
                {
                alt74=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 61:
            case 62:
                {
                alt74=2;
                }
                break;
            case RULE_STRING:
                {
                alt74=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalFSM.g:3629:3: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalFSM.g:3638:3: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalFSM.g:3647:3: this_StringLiteral_2= ruleStringLiteral
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
    // InternalFSM.g:3659:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalFSM.g:3659:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalFSM.g:3660:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalFSM.g:3666:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalFSM.g:3672:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalFSM.g:3673:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalFSM.g:3673:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalFSM.g:3674:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalFSM.g:3674:3: ()
            // InternalFSM.g:3675:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalFSM.g:3681:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==59) ) {
                alt75=1;
            }
            else if ( (LA75_0==60) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalFSM.g:3682:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalFSM.g:3687:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalFSM.g:3687:4: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalFSM.g:3688:5: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalFSM.g:3688:5: (lv_isTrue_2_0= 'true' )
                    // InternalFSM.g:3689:6: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,60,FOLLOW_2); 

                    						newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "isTrue", lv_isTrue_2_0 != null, "true");
                    					

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
    // InternalFSM.g:3706:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalFSM.g:3706:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalFSM.g:3707:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalFSM.g:3713:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:3719:2: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalFSM.g:3720:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalFSM.g:3720:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt76=2;
            switch ( input.LA(1) ) {
            case 61:
                {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==RULE_INT) ) {
                    int LA76_3 = input.LA(3);

                    if ( (LA76_3==EOF||(LA76_3>=48 && LA76_3<=49)) ) {
                        alt76=1;
                    }
                    else if ( (LA76_3==63) ) {
                        alt76=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }
                }
                break;
            case 62:
                {
                int LA76_2 = input.LA(2);

                if ( (LA76_2==RULE_INT) ) {
                    int LA76_3 = input.LA(3);

                    if ( (LA76_3==EOF||(LA76_3>=48 && LA76_3<=49)) ) {
                        alt76=1;
                    }
                    else if ( (LA76_3==63) ) {
                        alt76=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA76_3 = input.LA(2);

                if ( (LA76_3==EOF||(LA76_3>=48 && LA76_3<=49)) ) {
                    alt76=1;
                }
                else if ( (LA76_3==63) ) {
                    alt76=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt76=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalFSM.g:3721:3: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalFSM.g:3730:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalFSM.g:3742:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalFSM.g:3742:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalFSM.g:3743:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalFSM.g:3749:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:3755:2: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalFSM.g:3756:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalFSM.g:3756:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalFSM.g:3757:3: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalFSM.g:3757:3: ()
            // InternalFSM.g:3758:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
            					current);
            			

            }

            // InternalFSM.g:3764:3: ( (lv_value_1_0= ruleReal ) )
            // InternalFSM.g:3765:4: (lv_value_1_0= ruleReal )
            {
            // InternalFSM.g:3765:4: (lv_value_1_0= ruleReal )
            // InternalFSM.g:3766:5: lv_value_1_0= ruleReal
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
    // InternalFSM.g:3787:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalFSM.g:3787:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalFSM.g:3788:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalFSM.g:3794:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalFSM.g:3800:2: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalFSM.g:3801:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalFSM.g:3801:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalFSM.g:3802:3: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalFSM.g:3802:3: ()
            // InternalFSM.g:3803:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
            					current);
            			

            }

            // InternalFSM.g:3809:3: ( (lv_value_1_0= ruleInteger ) )
            // InternalFSM.g:3810:4: (lv_value_1_0= ruleInteger )
            {
            // InternalFSM.g:3810:4: (lv_value_1_0= ruleInteger )
            // InternalFSM.g:3811:5: lv_value_1_0= ruleInteger
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
    // InternalFSM.g:3832:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalFSM.g:3832:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalFSM.g:3833:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalFSM.g:3839:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFSM.g:3845:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalFSM.g:3846:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalFSM.g:3846:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalFSM.g:3847:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalFSM.g:3847:3: ()
            // InternalFSM.g:3848:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            					current);
            			

            }

            // InternalFSM.g:3854:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalFSM.g:3855:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalFSM.g:3855:4: (lv_value_1_0= RULE_STRING )
            // InternalFSM.g:3856:5: lv_value_1_0= RULE_STRING
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
    // InternalFSM.g:3876:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalFSM.g:3876:47: (iv_ruleInteger= ruleInteger EOF )
            // InternalFSM.g:3877:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalFSM.g:3883:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;


        	enterRule();

        try {
            // InternalFSM.g:3889:2: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalFSM.g:3890:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalFSM.g:3890:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_INT||(LA78_0>=61 && LA78_0<=62)) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_HEX) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalFSM.g:3891:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalFSM.g:3891:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalFSM.g:3892:4: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalFSM.g:3892:4: (kw= '+' | kw= '-' )?
                    int alt77=3;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==61) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==62) ) {
                        alt77=2;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalFSM.g:3893:5: kw= '+'
                            {
                            kw=(Token)match(input,61,FOLLOW_56); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalFSM.g:3899:5: kw= '-'
                            {
                            kw=(Token)match(input,62,FOLLOW_56); 

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
                    // InternalFSM.g:3914:3: this_HEX_3= RULE_HEX
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
    // InternalFSM.g:3925:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalFSM.g:3925:44: (iv_ruleReal= ruleReal EOF )
            // InternalFSM.g:3926:2: iv_ruleReal= ruleReal EOF
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
    // InternalFSM.g:3932:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;



        	enterRule();

        try {
            // InternalFSM.g:3938:2: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalFSM.g:3939:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalFSM.g:3939:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt79=2;
            switch ( input.LA(1) ) {
            case 61:
                {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==RULE_INT) ) {
                    int LA79_3 = input.LA(3);

                    if ( (LA79_3==63) ) {
                        int LA79_4 = input.LA(4);

                        if ( (LA79_4==RULE_INT) ) {
                            int LA79_5 = input.LA(5);

                            if ( (LA79_5==EOF||(LA79_5>=48 && LA79_5<=49)) ) {
                                alt79=1;
                            }
                            else if ( ((LA79_5>=64 && LA79_5<=65)) ) {
                                alt79=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 79, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 79, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;
                }
                }
                break;
            case 62:
                {
                int LA79_2 = input.LA(2);

                if ( (LA79_2==RULE_INT) ) {
                    int LA79_3 = input.LA(3);

                    if ( (LA79_3==63) ) {
                        int LA79_4 = input.LA(4);

                        if ( (LA79_4==RULE_INT) ) {
                            int LA79_5 = input.LA(5);

                            if ( (LA79_5==EOF||(LA79_5>=48 && LA79_5<=49)) ) {
                                alt79=1;
                            }
                            else if ( ((LA79_5>=64 && LA79_5<=65)) ) {
                                alt79=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 79, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 79, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA79_3 = input.LA(2);

                if ( (LA79_3==63) ) {
                    int LA79_4 = input.LA(3);

                    if ( (LA79_4==RULE_INT) ) {
                        int LA79_5 = input.LA(4);

                        if ( (LA79_5==EOF||(LA79_5>=48 && LA79_5<=49)) ) {
                            alt79=1;
                        }
                        else if ( ((LA79_5>=64 && LA79_5<=65)) ) {
                            alt79=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 79, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalFSM.g:3940:3: this_Decimal_0= ruleDecimal
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
                    // InternalFSM.g:3951:3: this_DecimalExp_1= ruleDecimalExp
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
    // InternalFSM.g:3965:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalFSM.g:3967:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalFSM.g:3968:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalFSM.g:3977:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalFSM.g:3984:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalFSM.g:3985:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalFSM.g:3985:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalFSM.g:3986:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalFSM.g:3986:3: (kw= '+' | kw= '-' )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==61) ) {
                alt80=1;
            }
            else if ( (LA80_0==62) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // InternalFSM.g:3987:4: kw= '+'
                    {
                    kw=(Token)match(input,61,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalFSM.g:3993:4: kw= '-'
                    {
                    kw=(Token)match(input,62,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_57); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,63,FOLLOW_56); 

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
    // InternalFSM.g:4025:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalFSM.g:4027:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalFSM.g:4028:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalFSM.g:4037:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalFSM.g:4044:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalFSM.g:4045:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalFSM.g:4045:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalFSM.g:4046:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalFSM.g:4046:3: (kw= '+' | kw= '-' )?
            int alt81=3;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==61) ) {
                alt81=1;
            }
            else if ( (LA81_0==62) ) {
                alt81=2;
            }
            switch (alt81) {
                case 1 :
                    // InternalFSM.g:4047:4: kw= '+'
                    {
                    kw=(Token)match(input,61,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalFSM.g:4053:4: kw= '-'
                    {
                    kw=(Token)match(input,62,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_57); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,63,FOLLOW_56); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_58); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3());
            		
            // InternalFSM.g:4078:3: (kw= 'e' | kw= 'E' )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==64) ) {
                alt82=1;
            }
            else if ( (LA82_0==65) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalFSM.g:4079:4: kw= 'e'
                    {
                    kw=(Token)match(input,64,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalFSM.g:4085:4: kw= 'E'
                    {
                    kw=(Token)match(input,65,FOLLOW_59); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalFSM.g:4091:3: (kw= '+' | kw= '-' )?
            int alt83=3;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==61) ) {
                alt83=1;
            }
            else if ( (LA83_0==62) ) {
                alt83=2;
            }
            switch (alt83) {
                case 1 :
                    // InternalFSM.g:4092:4: kw= '+'
                    {
                    kw=(Token)match(input,61,FOLLOW_56); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalFSM.g:4098:4: kw= '-'
                    {
                    kw=(Token)match(input,62,FOLLOW_56); 

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
    // InternalFSM.g:4118:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalFSM.g:4118:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalFSM.g:4119:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalFSM.g:4125:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalFSM.g:4131:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalFSM.g:4132:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalFSM.g:4132:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalFSM.g:4133:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_60); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalFSM.g:4140:3: (kw= '.' this_ID_2= RULE_ID )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==63) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalFSM.g:4141:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,63,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_60); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop84;
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
    // InternalFSM.g:4158:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalFSM.g:4164:2: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalFSM.g:4165:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalFSM.g:4165:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt85=4;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt85=1;
                }
                break;
            case 67:
                {
                alt85=2;
                }
                break;
            case 68:
                {
                alt85=3;
                }
                break;
            case 69:
                {
                alt85=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalFSM.g:4166:3: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalFSM.g:4166:3: (enumLiteral_0= 'eventdriven' )
                    // InternalFSM.g:4167:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFSM.g:4174:3: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalFSM.g:4174:3: (enumLiteral_1= 'datadriven' )
                    // InternalFSM.g:4175:4: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFSM.g:4182:3: (enumLiteral_2= 'async' )
                    {
                    // InternalFSM.g:4182:3: (enumLiteral_2= 'async' )
                    // InternalFSM.g:4183:4: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalFSM.g:4190:3: (enumLiteral_3= 'sync' )
                    {
                    // InternalFSM.g:4190:3: (enumLiteral_3= 'sync' )
                    // InternalFSM.g:4191:4: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_2); 

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
    // InternalFSM.g:4201:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalFSM.g:4207:2: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalFSM.g:4208:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalFSM.g:4208:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt86=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt86=1;
                }
                break;
            case 71:
                {
                alt86=2;
                }
                break;
            case 72:
                {
                alt86=3;
                }
                break;
            case 73:
                {
                alt86=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalFSM.g:4209:3: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalFSM.g:4209:3: (enumLiteral_0= 'ptBoolean' )
                    // InternalFSM.g:4210:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFSM.g:4217:3: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalFSM.g:4217:3: (enumLiteral_1= 'ptInteger' )
                    // InternalFSM.g:4218:4: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFSM.g:4225:3: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalFSM.g:4225:3: (enumLiteral_2= 'ptReal' )
                    // InternalFSM.g:4226:4: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalFSM.g:4233:3: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalFSM.g:4233:3: (enumLiteral_3= 'ptCharacter' )
                    // InternalFSM.g:4234:4: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,73,FOLLOW_2); 

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


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String dfa_1s = "\101\uffff";
    static final String dfa_2s = "\13\uffff\1\21\7\uffff\2\21\1\uffff\1\21\3\uffff\1\21\46\uffff";
    static final String dfa_3s = "\1\36\1\4\1\37\1\4\1\41\4\4\2\41\1\20\2\4\1\41\1\6\1\21\1\uffff\1\4\2\20\1\6\1\20\1\4\2\uffff\1\20\1\21\2\4\1\21\1\64\1\6\2\60\2\7\3\60\1\4\1\21\1\7\1\64\1\60\1\6\2\7\2\60\2\7\3\60\2\7\1\60\1\7\1\60\4\7\1\60";
    static final String dfa_4s = "\1\36\2\37\1\52\1\51\2\4\1\52\1\4\2\41\1\71\2\4\1\41\1\72\1\63\1\uffff\1\4\2\71\1\72\1\47\1\4\2\uffff\1\71\1\77\2\4\1\77\1\64\1\76\2\61\2\7\1\77\2\61\1\4\1\63\1\7\1\64\1\101\3\76\2\61\2\7\1\77\2\61\2\7\1\61\1\7\1\101\2\76\2\7\1\61";
    static final String dfa_5s = "\21\uffff\1\2\6\uffff\1\1\1\3\47\uffff";
    static final String dfa_6s = "\101\uffff}>";
    static final String[] dfa_7s = {
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
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\1\uffff\1\22\17\uffff\1\17",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25\63\uffff\1\26",
            "\1\21\20\uffff\1\21\1\30\1\uffff\1\30\1\31\14\uffff\1\27",
            "",
            "\1\32",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\21\uffff\1\17",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\21\uffff\1\17",
            "\1\25\63\uffff\1\26",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21",
            "\1\33",
            "",
            "",
            "\1\20\1\21\1\uffff\1\21\4\uffff\7\21\10\uffff\1\21\21\uffff\1\17",
            "\1\21\20\uffff\1\21\2\uffff\1\30\1\31\10\uffff\1\35\3\uffff\1\27\13\uffff\1\34",
            "\1\36",
            "\1\37",
            "\1\21\20\uffff\1\21\2\uffff\1\30\1\31\10\uffff\1\35\3\uffff\1\27\13\uffff\1\34",
            "\1\40",
            "\1\47\1\45\1\46\62\uffff\1\41\1\42\1\43\1\44",
            "\1\50\1\51",
            "\1\50\1\51",
            "\1\45",
            "\1\45",
            "\1\50\1\51\15\uffff\1\52",
            "\1\50\1\51",
            "\1\50\1\51",
            "\1\53",
            "\1\21\20\uffff\1\21\2\uffff\1\30\1\31\14\uffff\1\27",
            "\1\54",
            "\1\55",
            "\1\50\1\51\16\uffff\1\56\1\57",
            "\1\66\1\64\1\65\62\uffff\1\60\1\61\1\62\1\63",
            "\1\71\65\uffff\1\67\1\70",
            "\1\71\65\uffff\1\67\1\70",
            "\1\50\1\51",
            "\1\50\1\51",
            "\1\64",
            "\1\64",
            "\1\50\1\51\15\uffff\1\72",
            "\1\50\1\51",
            "\1\50\1\51",
            "\1\71",
            "\1\71",
            "\1\50\1\51",
            "\1\73",
            "\1\50\1\51\16\uffff\1\74\1\75",
            "\1\100\65\uffff\1\76\1\77",
            "\1\100\65\uffff\1\76\1\77",
            "\1\100",
            "\1\100",
            "\1\50\1\51"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1390:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_8s = "\31\uffff";
    static final String dfa_9s = "\1\36\1\4\1\37\1\4\1\41\4\4\2\41\1\20\2\4\1\41\1\6\1\43\1\4\2\20\1\6\1\20\2\uffff\1\20";
    static final String dfa_10s = "\1\36\2\37\1\52\1\51\2\4\1\52\1\4\2\41\1\71\2\4\1\41\1\72\1\63\1\4\2\71\1\72\1\20\2\uffff\1\71";
    static final String dfa_11s = "\26\uffff\1\1\1\2\1\uffff";
    static final String dfa_12s = "\31\uffff}>";
    static final String[] dfa_13s = {
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
            "\1\20\30\uffff\1\21\17\uffff\1\17",
            "\1\22",
            "\1\23",
            "\1\7",
            "\1\24\63\uffff\1\25",
            "\1\26\1\uffff\1\27\15\uffff\1\27",
            "\1\30",
            "\1\20\50\uffff\1\17",
            "\1\20\50\uffff\1\17",
            "\1\24\63\uffff\1\25",
            "\1\20",
            "",
            "",
            "\1\20\50\uffff\1\17"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1435:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006002L,0x000000000000003CL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006000L,0x000000000000003CL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000807F0A0000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0200000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000000F20000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000E30020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000E20000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000C30020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000C20000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000830020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0200000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000050000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0008000400020000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000030020L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0008080000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0008002000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400030020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0008004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0008000400000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000302000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004C00000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x78000000000001C0L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001000000020000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0400000000000040L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x6000000000000080L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000002L});

}
