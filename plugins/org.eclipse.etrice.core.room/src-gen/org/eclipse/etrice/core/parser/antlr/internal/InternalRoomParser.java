package org.eclipse.etrice.core.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.etrice.core.services.RoomGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoomParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_MULTIPLICITY", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'='", "'Operation'", "','", "'void'", "'sends'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugate'", "'private'", "'Message'", "'usercode'", "'handle'", "'semantics'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'conjugated'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'of'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'prio'", "'.'", "'Binding'", "'and'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'data_driven'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'['", "']'", "'@'", "'import'", "'from'", "'model'", "'*'"
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
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_MULTIPLICITY=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_INT=7;
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
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalRoomParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRoomParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRoomParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g"; }



     	private RoomGrammarAccess grammarAccess;
     	
        public InternalRoomParser(TokenStream input, RoomGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RoomModel";	
       	}
       	
       	@Override
       	protected RoomGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoomModel"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:67:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:68:2: (iv_ruleRoomModel= ruleRoomModel EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:69:2: iv_ruleRoomModel= ruleRoomModel EOF
            {
             newCompositeNode(grammarAccess.getRoomModelRule()); 
            pushFollow(FOLLOW_ruleRoomModel_in_entryRuleRoomModel75);
            iv_ruleRoomModel=ruleRoomModel();

            state._fsp--;

             current =iv_ruleRoomModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoomModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoomModel"


    // $ANTLR start "ruleRoomModel"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:76:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_docu_2_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_primitiveTypes_5_0 = null;

        EObject lv_externalTypes_6_0 = null;

        EObject lv_dataClasses_7_0 = null;

        EObject lv_protocolClasses_8_0 = null;

        EObject lv_actorClasses_9_0 = null;

        EObject lv_subSystemClasses_10_0 = null;

        EObject lv_systems_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:79:28: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleRoomModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getRoomModelAccess().getRoomModelKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:84:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:85:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:85:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:86:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getRoomModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRoomModel143);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:102:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==94) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:103:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:103:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:104:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRoomModel164);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRoomModel177); 

                	newLeafNode(otherlv_3, grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:124:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==97) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: (lv_imports_4_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: (lv_imports_4_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:3: lv_imports_4_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleRoomModel198);
            	    lv_imports_4_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_4_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )*
            loop3:
            do {
                int alt3=8;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt3=1;
                    }
                    break;
                case 22:
                    {
                    alt3=2;
                    }
                    break;
                case 23:
                    {
                    alt3=3;
                    }
                    break;
                case 34:
                    {
                    alt3=4;
                    }
                    break;
                case 45:
                case 46:
                    {
                    alt3=5;
                    }
                    break;
                case 59:
                    {
                    alt3=6;
                    }
                    break;
                case 57:
                    {
                    alt3=7;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:142:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:144:3: lv_primitiveTypes_5_0= rulePrimitiveType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getPrimitiveTypesPrimitiveTypeParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimitiveType_in_ruleRoomModel221);
            	    lv_primitiveTypes_5_0=rulePrimitiveType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"primitiveTypes",
            	            		lv_primitiveTypes_5_0, 
            	            		"PrimitiveType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:161:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:161:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:1: (lv_externalTypes_6_0= ruleExternalType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:1: (lv_externalTypes_6_0= ruleExternalType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:163:3: lv_externalTypes_6_0= ruleExternalType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getExternalTypesExternalTypeParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalType_in_ruleRoomModel248);
            	    lv_externalTypes_6_0=ruleExternalType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"externalTypes",
            	            		lv_externalTypes_6_0, 
            	            		"ExternalType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:180:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:180:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:1: (lv_dataClasses_7_0= ruleDataClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:1: (lv_dataClasses_7_0= ruleDataClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:182:3: lv_dataClasses_7_0= ruleDataClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDataClassesDataClassParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataClass_in_ruleRoomModel275);
            	    lv_dataClasses_7_0=ruleDataClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dataClasses",
            	            		lv_dataClasses_7_0, 
            	            		"DataClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_protocolClasses_8_0= ruleProtocolClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:199:6: ( (lv_protocolClasses_8_0= ruleProtocolClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_protocolClasses_8_0= ruleProtocolClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:1: (lv_protocolClasses_8_0= ruleProtocolClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:201:3: lv_protocolClasses_8_0= ruleProtocolClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesProtocolClassParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleProtocolClass_in_ruleRoomModel302);
            	    lv_protocolClasses_8_0=ruleProtocolClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"protocolClasses",
            	            		lv_protocolClasses_8_0, 
            	            		"ProtocolClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:218:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:218:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:1: (lv_actorClasses_9_0= ruleActorClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:1: (lv_actorClasses_9_0= ruleActorClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:220:3: lv_actorClasses_9_0= ruleActorClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getActorClassesActorClassParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorClass_in_ruleRoomModel329);
            	    lv_actorClasses_9_0=ruleActorClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorClasses",
            	            		lv_actorClasses_9_0, 
            	            		"ActorClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:237:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:237:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:239:3: lv_subSystemClasses_10_0= ruleSubSystemClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSubSystemClassesSubSystemClassParserRuleCall_5_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleRoomModel356);
            	    lv_subSystemClasses_10_0=ruleSubSystemClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystemClasses",
            	            		lv_subSystemClasses_10_0, 
            	            		"SubSystemClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:256:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:256:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:1: (lv_systems_11_0= ruleLogicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:1: (lv_systems_11_0= ruleLogicalSystem )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:258:3: lv_systems_11_0= ruleLogicalSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSystemsLogicalSystemParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleRoomModel383);
            	    lv_systems_11_0=ruleLogicalSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_11_0, 
            	            		"LogicalSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleRoomModel397); 

                	newLeafNode(otherlv_12, grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoomModel"


    // $ANTLR start "entryRuleStructureClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:288:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:289:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:290:2: iv_ruleStructureClass= ruleStructureClass EOF
            {
             newCompositeNode(grammarAccess.getStructureClassRule()); 
            pushFollow(FOLLOW_ruleStructureClass_in_entryRuleStructureClass435);
            iv_ruleStructureClass=ruleStructureClass();

            state._fsp--;

             current =iv_ruleStructureClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructureClass445); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructureClass"


    // $ANTLR start "ruleStructureClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:297:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:300:28: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=45 && LA4_0<=46)||LA4_0==59) ) {
                alt4=1;
            }
            else if ( (LA4_0==57) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:5: this_ActorContainerClass_0= ruleActorContainerClass
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getActorContainerClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleActorContainerClass_in_ruleStructureClass492);
                    this_ActorContainerClass_0=ruleActorContainerClass();

                    state._fsp--;

                     
                            current = this_ActorContainerClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:312:5: this_LogicalSystem_1= ruleLogicalSystem
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getLogicalSystemParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLogicalSystem_in_ruleStructureClass519);
                    this_LogicalSystem_1=ruleLogicalSystem();

                    state._fsp--;

                     
                            current = this_LogicalSystem_1; 
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
    // $ANTLR end "ruleStructureClass"


    // $ANTLR start "entryRuleActorContainerClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:328:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:329:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:330:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
            {
             newCompositeNode(grammarAccess.getActorContainerClassRule()); 
            pushFollow(FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass554);
            iv_ruleActorContainerClass=ruleActorContainerClass();

            state._fsp--;

             current =iv_ruleActorContainerClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorContainerClass564); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorContainerClass"


    // $ANTLR start "ruleActorContainerClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:337:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:340:28: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:341:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:341:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=45 && LA5_0<=46)) ) {
                alt5=1;
            }
            else if ( (LA5_0==59) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:342:5: this_ActorClass_0= ruleActorClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getActorClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleActorClass_in_ruleActorContainerClass611);
                    this_ActorClass_0=ruleActorClass();

                    state._fsp--;

                     
                            current = this_ActorClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:352:5: this_SubSystemClass_1= ruleSubSystemClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getSubSystemClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass638);
                    this_SubSystemClass_1=ruleSubSystemClass();

                    state._fsp--;

                     
                            current = this_SubSystemClass_1; 
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
    // $ANTLR end "ruleActorContainerClass"


    // $ANTLR start "entryRuleVarDecl"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:368:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:369:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:370:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
             newCompositeNode(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_ruleVarDecl_in_entryRuleVarDecl673);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;

             current =iv_ruleVarDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarDecl683); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:377:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ( (lv_ref_3_0= 'ref' ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_ref_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:380:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ( (lv_ref_3_0= 'ref' ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ( (lv_ref_3_0= 'ref' ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ( (lv_ref_3_0= 'ref' ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) ( (lv_ref_3_0= 'ref' ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:383:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarDecl725); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleVarDecl742); 

                	newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:403:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:405:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDeclRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVarDeclAccess().getTypeDataTypeCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleVarDecl765);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:418:2: ( (lv_ref_3_0= 'ref' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:419:1: (lv_ref_3_0= 'ref' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:419:1: (lv_ref_3_0= 'ref' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:420:3: lv_ref_3_0= 'ref'
                    {
                    lv_ref_3_0=(Token)match(input,16,FOLLOW_16_in_ruleVarDecl783); 

                            newLeafNode(lv_ref_3_0, grammarAccess.getVarDeclAccess().getRefRefKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVarDeclRule());
                    	        }
                           		setWithLastConsumed(current, "ref", true, "ref");
                    	    

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
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleDataType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:441:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType833);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType843); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:450:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ComplexType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:453:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:454:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:454:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=22 && LA7_0<=23)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:455:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleDataType890);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:465:5: this_ComplexType_1= ruleComplexType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getComplexTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleComplexType_in_ruleDataType917);
                    this_ComplexType_1=ruleComplexType();

                    state._fsp--;

                     
                            current = this_ComplexType_1; 
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleComplexType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:481:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:482:2: (iv_ruleComplexType= ruleComplexType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:483:2: iv_ruleComplexType= ruleComplexType EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_ruleComplexType_in_entryRuleComplexType952);
            iv_ruleComplexType=ruleComplexType();

            state._fsp--;

             current =iv_ruleComplexType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexType962); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexType"


    // $ANTLR start "ruleComplexType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:490:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:493:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:494:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:494:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:495:5: this_DataClass_0= ruleDataClass
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getDataClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDataClass_in_ruleComplexType1009);
                    this_DataClass_0=ruleDataClass();

                    state._fsp--;

                     
                            current = this_DataClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:505:5: this_ExternalType_1= ruleExternalType
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getExternalTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleExternalType_in_ruleComplexType1036);
                    this_ExternalType_1=ruleExternalType();

                    state._fsp--;

                     
                            current = this_ExternalType_1; 
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
    // $ANTLR end "ruleComplexType"


    // $ANTLR start "entryRulePrimitiveType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:521:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:522:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:523:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1071);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveType1081); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:530:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_defaultValueLiteral_8_0=null;
        AntlrDatatypeRuleToken lv_targetName_3_0 = null;

        AntlrDatatypeRuleToken lv_castName_5_0 = null;

        EObject lv_docu_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:533:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )? otherlv_7= 'default' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_rulePrimitiveType1118); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:538:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:539:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:539:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:540:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimitiveType1135); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_rulePrimitiveType1152); 

                	newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:560:1: ( (lv_targetName_3_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:1: (lv_targetName_3_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:1: (lv_targetName_3_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:3: lv_targetName_3_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTargetNameFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1173);
            lv_targetName_3_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		set(
                   			current, 
                   			"targetName",
                    		lv_targetName_3_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:578:2: (otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:578:4: otherlv_4= '(' ( (lv_castName_5_0= ruleFQN ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_rulePrimitiveType1186); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:582:1: ( (lv_castName_5_0= ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:583:1: (lv_castName_5_0= ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:583:1: (lv_castName_5_0= ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:584:3: lv_castName_5_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1207);
                    lv_castName_5_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"castName",
                            		lv_castName_5_0, 
                            		"FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_rulePrimitiveType1219); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_4_2());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_21_in_rulePrimitiveType1233); 

                	newLeafNode(otherlv_7, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:608:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:609:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:609:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:610:3: lv_defaultValueLiteral_8_0= RULE_STRING
            {
            lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePrimitiveType1250); 

            			newLeafNode(lv_defaultValueLiteral_8_0, grammarAccess.getPrimitiveTypeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"defaultValueLiteral",
                    		lv_defaultValueLiteral_8_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:626:2: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==94) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:627:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:627:1: (lv_docu_9_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:628:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePrimitiveType1276);
                    lv_docu_9_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_9_0, 
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
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleExternalType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:652:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:653:2: (iv_ruleExternalType= ruleExternalType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:654:2: iv_ruleExternalType= ruleExternalType EOF
            {
             newCompositeNode(grammarAccess.getExternalTypeRule()); 
            pushFollow(FOLLOW_ruleExternalType_in_entryRuleExternalType1313);
            iv_ruleExternalType=ruleExternalType();

            state._fsp--;

             current =iv_ruleExternalType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalType1323); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalType"


    // $ANTLR start "ruleExternalType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:661:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleExternalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_targetName_3_0 = null;

        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:664:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:665:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:665:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:665:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleExternalType1360); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:669:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:670:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:670:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:671:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalType1377); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExternalTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleExternalType1394); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:691:1: ( (lv_targetName_3_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:692:1: (lv_targetName_3_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:692:1: (lv_targetName_3_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:693:3: lv_targetName_3_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getExternalTypeAccess().getTargetNameFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleExternalType1415);
            lv_targetName_3_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExternalTypeRule());
            	        }
                   		set(
                   			current, 
                   			"targetName",
                    		lv_targetName_3_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:709:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==94) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:710:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:710:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:711:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalTypeAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleExternalType1436);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExternalTypeRule());
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
    // $ANTLR end "ruleExternalType"


    // $ANTLR start "entryRuleDataClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:735:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:736:2: (iv_ruleDataClass= ruleDataClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:737:2: iv_ruleDataClass= ruleDataClass EOF
            {
             newCompositeNode(grammarAccess.getDataClassRule()); 
            pushFollow(FOLLOW_ruleDataClass_in_entryRuleDataClass1473);
            iv_ruleDataClass=ruleDataClass();

            state._fsp--;

             current =iv_ruleDataClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataClass1483); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataClass"


    // $ANTLR start "ruleDataClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:744:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_7_0 = null;

        EObject lv_userCode2_9_0 = null;

        EObject lv_userCode3_11_0 = null;

        EObject lv_attributes_12_0 = null;

        EObject lv_operations_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:747:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:748:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? ( (lv_attributes_12_0= ruleAttribute ) )+ ( (lv_operations_13_0= ruleStandardOperation ) )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDataClass1520); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:752:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:753:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:753:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:754:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataClass1537); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDataClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDataClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:770:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==94) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:771:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:771:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:772:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleDataClass1563);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:788:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:788:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDataClass1577); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:792:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:793:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:793:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:794:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataClass1600);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleDataClass1614); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:811:1: (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:811:3: otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleDataClass1627); 

                        	newLeafNode(otherlv_6, grammarAccess.getDataClassAccess().getUsercode1Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:815:1: ( (lv_userCode1_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:816:1: (lv_userCode1_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:816:1: (lv_userCode1_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:817:3: lv_userCode1_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1648);
                    lv_userCode1_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:833:4: (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:833:6: otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleDataClass1663); 

                        	newLeafNode(otherlv_8, grammarAccess.getDataClassAccess().getUsercode2Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:837:1: ( (lv_userCode2_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:838:1: (lv_userCode2_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:838:1: (lv_userCode2_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:839:3: lv_userCode2_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1684);
                    lv_userCode2_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:4: (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:6: otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleDataClass1699); 

                        	newLeafNode(otherlv_10, grammarAccess.getDataClassAccess().getUsercode3Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:859:1: ( (lv_userCode3_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:860:1: (lv_userCode3_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:860:1: (lv_userCode3_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:861:3: lv_userCode3_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1720);
                    lv_userCode3_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:877:4: ( (lv_attributes_12_0= ruleAttribute ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:878:1: (lv_attributes_12_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:878:1: (lv_attributes_12_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:879:3: lv_attributes_12_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleDataClass1743);
            	    lv_attributes_12_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_12_0, 
            	            		"Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:895:3: ( (lv_operations_13_0= ruleStandardOperation ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:896:1: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:896:1: (lv_operations_13_0= ruleStandardOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:897:3: lv_operations_13_0= ruleStandardOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleDataClass1765);
            	    lv_operations_13_0=ruleStandardOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_13_0, 
            	            		"StandardOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_14=(Token)match(input,14,FOLLOW_14_in_ruleDataClass1778); 

                	newLeafNode(otherlv_14, grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataClass"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:925:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:926:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:927:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1814);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1824); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:934:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( (lv_size_2_0= RULE_MULTIPLICITY ) )? otherlv_3= ':' ( ( ruleFQN ) ) ( (lv_ref_5_0= 'ref' ) )? (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )? ( (lv_docu_8_0= ruleDocumentation ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_size_2_0=null;
        Token otherlv_3=null;
        Token lv_ref_5_0=null;
        Token otherlv_6=null;
        Token lv_defaultValueLiteral_7_0=null;
        EObject lv_docu_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:937:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( (lv_size_2_0= RULE_MULTIPLICITY ) )? otherlv_3= ':' ( ( ruleFQN ) ) ( (lv_ref_5_0= 'ref' ) )? (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )? ( (lv_docu_8_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:938:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( (lv_size_2_0= RULE_MULTIPLICITY ) )? otherlv_3= ':' ( ( ruleFQN ) ) ( (lv_ref_5_0= 'ref' ) )? (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )? ( (lv_docu_8_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:938:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( (lv_size_2_0= RULE_MULTIPLICITY ) )? otherlv_3= ':' ( ( ruleFQN ) ) ( (lv_ref_5_0= 'ref' ) )? (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )? ( (lv_docu_8_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:938:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) ( (lv_size_2_0= RULE_MULTIPLICITY ) )? otherlv_3= ':' ( ( ruleFQN ) ) ( (lv_ref_5_0= 'ref' ) )? (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )? ( (lv_docu_8_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleAttribute1861); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:942:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:943:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:943:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:944:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1878); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:960:2: ( (lv_size_2_0= RULE_MULTIPLICITY ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_MULTIPLICITY) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:961:1: (lv_size_2_0= RULE_MULTIPLICITY )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:961:1: (lv_size_2_0= RULE_MULTIPLICITY )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:962:3: lv_size_2_0= RULE_MULTIPLICITY
                    {
                    lv_size_2_0=(Token)match(input,RULE_MULTIPLICITY,FOLLOW_RULE_MULTIPLICITY_in_ruleAttribute1900); 

                    			newLeafNode(lv_size_2_0, grammarAccess.getAttributeAccess().getSizeMULTIPLICITYTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"size",
                            		lv_size_2_0, 
                            		"MULTIPLICITY");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAttribute1918); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:982:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:983:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:983:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:984:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleAttribute1941);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:997:2: ( (lv_ref_5_0= 'ref' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:998:1: (lv_ref_5_0= 'ref' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:998:1: (lv_ref_5_0= 'ref' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:999:3: lv_ref_5_0= 'ref'
                    {
                    lv_ref_5_0=(Token)match(input,16,FOLLOW_16_in_ruleAttribute1959); 

                            newLeafNode(lv_ref_5_0, grammarAccess.getAttributeAccess().getRefRefKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "ref", true, "ref");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1012:3: (otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1012:5: otherlv_6= '=' ( (lv_defaultValueLiteral_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleAttribute1986); 

                        	newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getEqualsSignKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1016:1: ( (lv_defaultValueLiteral_7_0= RULE_STRING ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1017:1: (lv_defaultValueLiteral_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1017:1: (lv_defaultValueLiteral_7_0= RULE_STRING )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1018:3: lv_defaultValueLiteral_7_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttribute2003); 

                    			newLeafNode(lv_defaultValueLiteral_7_0, grammarAccess.getAttributeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1034:4: ( (lv_docu_8_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==94) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1035:1: (lv_docu_8_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1035:1: (lv_docu_8_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1036:3: lv_docu_8_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleAttribute2031);
                    lv_docu_8_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_8_0, 
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleStandardOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1062:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1063:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1064:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2070);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStandardOperation2080); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStandardOperation"


    // $ANTLR start "ruleStandardOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1071:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
    public final EObject ruleStandardOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_ref_10_0=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_docu_11_0 = null;

        EObject lv_detailCode_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1074:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1075:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1075:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1075:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleStandardOperation2117); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1079:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1080:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1080:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1081:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStandardOperation2134); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStandardOperationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleStandardOperation2151); 

                	newLeafNode(otherlv_2, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1101:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1101:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1101:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1102:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1102:1: (lv_arguments_3_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1103:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2173);
                    lv_arguments_3_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_3_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1119:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==31) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1119:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleStandardOperation2186); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStandardOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1123:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1124:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1124:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1125:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2207);
                    	    lv_arguments_5_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_5_0, 
                    	            		"VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleStandardOperation2223); 

                	newLeafNode(otherlv_6, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1145:1: (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==15) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1145:3: otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleStandardOperation2236); 

                        	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getColonKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1149:1: (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==32) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_ID) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1149:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,32,FOLLOW_32_in_ruleStandardOperation2249); 

                                	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getVoidKeyword_5_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:6: ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:6: ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:7: ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )?
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1154:7: ( ( ruleFQN ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1155:1: ( ruleFQN )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1155:1: ( ruleFQN )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1156:3: ruleFQN
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getStandardOperationRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getReturntypeDataTypeCrossReference_5_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFQN_in_ruleStandardOperation2279);
                            ruleFQN();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1169:2: ( (lv_ref_10_0= 'ref' ) )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==16) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1170:1: (lv_ref_10_0= 'ref' )
                                    {
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1170:1: (lv_ref_10_0= 'ref' )
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1171:3: lv_ref_10_0= 'ref'
                                    {
                                    lv_ref_10_0=(Token)match(input,16,FOLLOW_16_in_ruleStandardOperation2297); 

                                            newLeafNode(lv_ref_10_0, grammarAccess.getStandardOperationAccess().getRefRefKeyword_5_1_1_1_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getStandardOperationRule());
                                    	        }
                                           		setWithLastConsumed(current, "ref", true, "ref");
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1184:7: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==94) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1185:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1185:1: (lv_docu_11_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1186:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleStandardOperation2336);
                    lv_docu_11_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_11_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1202:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1203:1: (lv_detailCode_12_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1203:1: (lv_detailCode_12_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1204:3: lv_detailCode_12_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleStandardOperation2358);
            lv_detailCode_12_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_12_0, 
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
    // $ANTLR end "ruleStandardOperation"


    // $ANTLR start "entryRulePortOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1228:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1229:2: (iv_rulePortOperation= rulePortOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1230:2: iv_rulePortOperation= rulePortOperation EOF
            {
             newCompositeNode(grammarAccess.getPortOperationRule()); 
            pushFollow(FOLLOW_rulePortOperation_in_entryRulePortOperation2394);
            iv_rulePortOperation=rulePortOperation();

            state._fsp--;

             current =iv_rulePortOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortOperation2404); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortOperation"


    // $ANTLR start "rulePortOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1237:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )? ( (lv_docu_13_0= ruleDocumentation ) )? ( (lv_detailCode_14_0= ruleDetailCode ) ) ) ;
    public final EObject rulePortOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_ref_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_docu_13_0 = null;

        EObject lv_detailCode_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1240:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )? ( (lv_docu_13_0= ruleDocumentation ) )? ( (lv_detailCode_14_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1241:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )? ( (lv_docu_13_0= ruleDocumentation ) )? ( (lv_detailCode_14_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1241:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )? ( (lv_docu_13_0= ruleDocumentation ) )? ( (lv_detailCode_14_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1241:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )? ( (lv_docu_13_0= ruleDocumentation ) )? ( (lv_detailCode_14_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePortOperation2441); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1245:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1246:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1246:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1247:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2458); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPortOperationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_rulePortOperation2475); 

                	newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1267:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1267:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1267:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1268:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1268:1: (lv_arguments_3_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1269:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2497);
                    lv_arguments_3_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_3_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1285:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==31) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1285:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_31_in_rulePortOperation2510); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1289:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1290:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1290:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1291:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2531);
                    	    lv_arguments_5_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_5_0, 
                    	            		"VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_rulePortOperation2547); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1311:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) ) | (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==15) ) {
                alt33=1;
            }
            else if ( (LA33_0==33) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1311:2: (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1311:2: (otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1311:4: otherlv_7= ':' (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_rulePortOperation2561); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1315:1: (otherlv_8= 'void' | ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==32) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==RULE_ID) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1315:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,32,FOLLOW_32_in_rulePortOperation2574); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:6: ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:6: ( ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )? )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:7: ( ( ruleFQN ) ) ( (lv_ref_10_0= 'ref' ) )?
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:7: ( ( ruleFQN ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1321:1: ( ruleFQN )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1321:1: ( ruleFQN )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1322:3: ruleFQN
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getPortOperationRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getPortOperationAccess().getReturntypeDataTypeCrossReference_5_0_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleFQN_in_rulePortOperation2604);
                            ruleFQN();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1335:2: ( (lv_ref_10_0= 'ref' ) )?
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==16) ) {
                                alt31=1;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1336:1: (lv_ref_10_0= 'ref' )
                                    {
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1336:1: (lv_ref_10_0= 'ref' )
                                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1337:3: lv_ref_10_0= 'ref'
                                    {
                                    lv_ref_10_0=(Token)match(input,16,FOLLOW_16_in_rulePortOperation2622); 

                                            newLeafNode(lv_ref_10_0, grammarAccess.getPortOperationAccess().getRefRefKeyword_5_0_1_1_1_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                                    	        }
                                           		setWithLastConsumed(current, "ref", true, "ref");
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1351:6: (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1351:6: (otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1351:8: otherlv_11= 'sends' ( (otherlv_12= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_33_in_rulePortOperation2658); 

                        	newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1355:1: ( (otherlv_12= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1356:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1356:1: (otherlv_12= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1357:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2678); 

                    		newLeafNode(otherlv_12, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1368:5: ( (lv_docu_13_0= ruleDocumentation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==94) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1369:1: (lv_docu_13_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1369:1: (lv_docu_13_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1370:3: lv_docu_13_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePortOperation2702);
                    lv_docu_13_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_13_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1386:3: ( (lv_detailCode_14_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1387:1: (lv_detailCode_14_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1387:1: (lv_detailCode_14_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1388:3: lv_detailCode_14_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getPortOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_rulePortOperation2724);
            lv_detailCode_14_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_14_0, 
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
    // $ANTLR end "rulePortOperation"


    // $ANTLR start "entryRuleProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1412:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1413:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1414:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassRule()); 
            pushFollow(FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2760);
            iv_ruleProtocolClass=ruleProtocolClass();

            state._fsp--;

             current =iv_ruleProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClass2770); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocolClass"


    // $ANTLR start "ruleProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1421:1: ruleProtocolClass returns [EObject current=null] : (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' ) ;
    public final EObject ruleProtocolClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_7_0 = null;

        EObject lv_userCode2_9_0 = null;

        EObject lv_userCode3_11_0 = null;

        EObject lv_incomingMessages_14_0 = null;

        EObject lv_outgoingMessages_18_0 = null;

        EObject lv_regular_22_0 = null;

        EObject lv_conjugate_25_0 = null;

        EObject lv_semantics_26_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:28: ( (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:1: (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:1: (otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1425:3: otherlv_0= 'ProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )? (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )? (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )? (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )? (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )? ( (lv_semantics_26_0= ruleProtocolSemantics ) )? otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleProtocolClass2807); 

                	newLeafNode(otherlv_0, grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1429:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1430:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1430:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1431:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProtocolClass2824); 

            			newLeafNode(lv_name_1_0, grammarAccess.getProtocolClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1447:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==94) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1448:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1448:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1449:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleProtocolClass2850);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1465:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==24) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1465:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleProtocolClass2864); 

                        	newLeafNode(otherlv_3, grammarAccess.getProtocolClassAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1469:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1470:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1470:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1471:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getProtocolClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClass2887);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass2901); 

                	newLeafNode(otherlv_5, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1488:1: (otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1488:3: otherlv_6= 'usercode1' ( (lv_userCode1_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleProtocolClass2914); 

                        	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1492:1: ( (lv_userCode1_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1493:1: (lv_userCode1_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1493:1: (lv_userCode1_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1494:3: lv_userCode1_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass2935);
                    lv_userCode1_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1510:4: (otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==26) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1510:6: otherlv_8= 'usercode2' ( (lv_userCode2_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleProtocolClass2950); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1514:1: ( (lv_userCode2_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1515:1: (lv_userCode2_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1515:1: (lv_userCode2_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1516:3: lv_userCode2_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass2971);
                    lv_userCode2_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:4: (otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==27) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:6: otherlv_10= 'usercode3' ( (lv_userCode3_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleProtocolClass2986); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1536:1: ( (lv_userCode3_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1537:1: (lv_userCode3_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1537:1: (lv_userCode3_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1538:3: lv_userCode3_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass3007);
                    lv_userCode3_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1554:4: (otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1554:6: otherlv_12= 'incoming' otherlv_13= '{' ( (lv_incomingMessages_14_0= ruleMessage ) )* otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,35,FOLLOW_35_in_ruleProtocolClass3022); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getIncomingKeyword_8_0());
                        
                    otherlv_13=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3034); 

                        	newLeafNode(otherlv_13, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1562:1: ( (lv_incomingMessages_14_0= ruleMessage ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=40 && LA40_0<=41)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1563:1: (lv_incomingMessages_14_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1563:1: (lv_incomingMessages_14_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1564:3: lv_incomingMessages_14_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_8_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3055);
                    	    lv_incomingMessages_14_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"incomingMessages",
                    	            		lv_incomingMessages_14_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3068); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_8_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1584:3: (otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==36) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1584:5: otherlv_16= 'outgoing' otherlv_17= '{' ( (lv_outgoingMessages_18_0= ruleMessage ) )* otherlv_19= '}'
                    {
                    otherlv_16=(Token)match(input,36,FOLLOW_36_in_ruleProtocolClass3083); 

                        	newLeafNode(otherlv_16, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_9_0());
                        
                    otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3095); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1592:1: ( (lv_outgoingMessages_18_0= ruleMessage ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=40 && LA42_0<=41)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1593:1: (lv_outgoingMessages_18_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1593:1: (lv_outgoingMessages_18_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1594:3: lv_outgoingMessages_18_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_9_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3116);
                    	    lv_outgoingMessages_18_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outgoingMessages",
                    	            		lv_outgoingMessages_18_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3129); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_9_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1614:3: (otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==37) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1614:5: otherlv_20= 'regular' otherlv_21= 'PortClass' ( (lv_regular_22_0= rulePortClass ) )
                    {
                    otherlv_20=(Token)match(input,37,FOLLOW_37_in_ruleProtocolClass3144); 

                        	newLeafNode(otherlv_20, grammarAccess.getProtocolClassAccess().getRegularKeyword_10_0());
                        
                    otherlv_21=(Token)match(input,38,FOLLOW_38_in_ruleProtocolClass3156); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getPortClassKeyword_10_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1622:1: ( (lv_regular_22_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1623:1: (lv_regular_22_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1623:1: (lv_regular_22_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1624:3: lv_regular_22_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3177);
                    lv_regular_22_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"regular",
                            		lv_regular_22_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1640:4: (otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1640:6: otherlv_23= 'conjugate' otherlv_24= 'PortClass' ( (lv_conjugate_25_0= rulePortClass ) )
                    {
                    otherlv_23=(Token)match(input,39,FOLLOW_39_in_ruleProtocolClass3192); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getConjugateKeyword_11_0());
                        
                    otherlv_24=(Token)match(input,38,FOLLOW_38_in_ruleProtocolClass3204); 

                        	newLeafNode(otherlv_24, grammarAccess.getProtocolClassAccess().getPortClassKeyword_11_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1648:1: ( (lv_conjugate_25_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1649:1: (lv_conjugate_25_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1649:1: (lv_conjugate_25_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1650:3: lv_conjugate_25_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatePortClassParserRuleCall_11_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3225);
                    lv_conjugate_25_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"conjugate",
                            		lv_conjugate_25_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1666:4: ( (lv_semantics_26_0= ruleProtocolSemantics ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==44) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1667:1: (lv_semantics_26_0= ruleProtocolSemantics )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1667:1: (lv_semantics_26_0= ruleProtocolSemantics )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1668:3: lv_semantics_26_0= ruleProtocolSemantics
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3248);
                    lv_semantics_26_0=ruleProtocolSemantics();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"semantics",
                            		lv_semantics_26_0, 
                            		"ProtocolSemantics");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_27=(Token)match(input,14,FOLLOW_14_in_ruleProtocolClass3261); 

                	newLeafNode(otherlv_27, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProtocolClass"


    // $ANTLR start "entryRuleMessage"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1696:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1697:2: (iv_ruleMessage= ruleMessage EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1698:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage3297);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage3307); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1705:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token lv_priv_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_data_4_0 = null;

        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1708:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1709:2: ( (lv_priv_0_0= 'private' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==40) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1710:1: (lv_priv_0_0= 'private' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1710:1: (lv_priv_0_0= 'private' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1711:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,40,FOLLOW_40_in_ruleMessage3350); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleMessage3376); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1728:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1729:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1729:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1730:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage3393); 

            			newLeafNode(lv_name_2_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleMessage3410); 

                	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1750:1: ( (lv_data_4_0= ruleVarDecl ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1751:1: (lv_data_4_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1751:1: (lv_data_4_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1752:3: lv_data_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDataVarDeclParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleMessage3431);
                    lv_data_4_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
                    	        }
                           		set(
                           			current, 
                           			"data",
                            		lv_data_4_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMessage3444); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1772:1: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==94) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1773:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1773:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1774:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleMessage3465);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
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


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRulePortClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1798:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1799:2: (iv_rulePortClass= rulePortClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1800:2: iv_rulePortClass= rulePortClass EOF
            {
             newCompositeNode(grammarAccess.getPortClassRule()); 
            pushFollow(FOLLOW_rulePortClass_in_entryRulePortClass3502);
            iv_rulePortClass=rulePortClass();

            state._fsp--;

             current =iv_rulePortClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClass3512); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortClass"


    // $ANTLR start "rulePortClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1807:1: rulePortClass returns [EObject current=null] : (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) ;
    public final EObject rulePortClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_userCode_2_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_msgHandlers_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1810:28: ( (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1811:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1811:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1811:3: otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePortClass3549); 

                	newLeafNode(otherlv_0, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1815:1: (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==42) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1815:3: otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) )
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_rulePortClass3562); 

                        	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getUsercodeKeyword_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1819:1: ( (lv_userCode_2_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1820:1: (lv_userCode_2_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1820:1: (lv_userCode_2_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1821:3: lv_userCode_2_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_rulePortClass3583);
                    lv_userCode_2_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode",
                            		lv_userCode_2_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1837:4: ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=4;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    alt51=1;
                    }
                    break;
                case 30:
                    {
                    alt51=2;
                    }
                    break;
                case 43:
                    {
                    alt51=3;
                    }
                    break;

                }

                switch (alt51) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1837:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1837:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1838:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1838:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1839:3: lv_attributes_3_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_rulePortClass3607);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_3_0, 
            	            		"Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1856:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1856:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1857:1: (lv_operations_4_0= rulePortOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1857:1: (lv_operations_4_0= rulePortOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1858:3: lv_operations_4_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortOperation_in_rulePortClass3634);
            	    lv_operations_4_0=rulePortOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_4_0, 
            	            		"PortOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1875:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1875:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1876:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1876:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1877:3: lv_msgHandlers_5_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageHandler_in_rulePortClass3661);
            	    lv_msgHandlers_5_0=ruleMessageHandler();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"msgHandlers",
            	            		lv_msgHandlers_5_0, 
            	            		"MessageHandler");
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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_rulePortClass3675); 

                	newLeafNode(otherlv_6, grammarAccess.getPortClassAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortClass"


    // $ANTLR start "entryRuleMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1905:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1906:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1907:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getMessageHandlerRule()); 
            pushFollow(FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler3711);
            iv_ruleMessageHandler=ruleMessageHandler();

            state._fsp--;

             current =iv_ruleMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageHandler3721); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageHandler"


    // $ANTLR start "ruleMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1914:1: ruleMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_detailCode_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1917:28: ( (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1918:1: (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1918:1: (otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1918:3: otherlv_0= 'handle' ( (otherlv_1= RULE_ID ) ) ( (lv_detailCode_2_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleMessageHandler3758); 

                	newLeafNode(otherlv_0, grammarAccess.getMessageHandlerAccess().getHandleKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1922:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1923:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1923:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1924:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageHandlerRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageHandler3778); 

            		newLeafNode(otherlv_1, grammarAccess.getMessageHandlerAccess().getMsgMessageCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1935:2: ( (lv_detailCode_2_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1936:1: (lv_detailCode_2_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1936:1: (lv_detailCode_2_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1937:3: lv_detailCode_2_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleMessageHandler3799);
            lv_detailCode_2_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_2_0, 
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
    // $ANTLR end "ruleMessageHandler"


    // $ANTLR start "entryRuleProtocolSemantics"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1961:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1962:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1963:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             newCompositeNode(grammarAccess.getProtocolSemanticsRule()); 
            pushFollow(FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics3835);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();

            state._fsp--;

             current =iv_ruleProtocolSemantics; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolSemantics3845); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProtocolSemantics"


    // $ANTLR start "ruleProtocolSemantics"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1970:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1973:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1974:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1975:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleProtocolSemantics3891); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleProtocolSemantics3903); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1988:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1989:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1989:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1990:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics3924);
            	    lv_rules_3_0=ruleSemanticsRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolSemanticsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_3_0, 
            	            		"SemanticsRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleProtocolSemantics3937); 

                	newLeafNode(otherlv_4, grammarAccess.getProtocolSemanticsAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProtocolSemantics"


    // $ANTLR start "entryRuleSemanticsRule"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2018:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2019:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2020:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule3973);
            iv_ruleSemanticsRule=ruleSemanticsRule();

            state._fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule3983); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2027:1: ruleSemanticsRule returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_followUps_2_0 = null;

        EObject lv_followUps_4_0 = null;

        EObject lv_followUps_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2030:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2031:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2031:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2031:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2031:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2032:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2032:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2033:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSemanticsRuleRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSemanticsRule4028); 

            		newLeafNode(otherlv_0, grammarAccess.getSemanticsRuleAccess().getMsgMessageCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2044:2: (otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==18) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2044:4: otherlv_1= '->' ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) )
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSemanticsRule4041); 

                        	newLeafNode(otherlv_1, grammarAccess.getSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2048:1: ( ( (lv_followUps_2_0= ruleSemanticsRule ) ) | (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' ) )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==RULE_ID) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==19) ) {
                        alt54=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2048:2: ( (lv_followUps_2_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2048:2: ( (lv_followUps_2_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2049:1: (lv_followUps_2_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2049:1: (lv_followUps_2_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2050:3: lv_followUps_2_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4063);
                            lv_followUps_2_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_2_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2067:6: (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2067:6: (otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')' )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2067:8: otherlv_3= '(' ( (lv_followUps_4_0= ruleSemanticsRule ) ) (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+ otherlv_7= ')'
                            {
                            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleSemanticsRule4082); 

                                	newLeafNode(otherlv_3, grammarAccess.getSemanticsRuleAccess().getLeftParenthesisKeyword_1_1_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2071:1: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2072:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2072:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2073:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4103);
                            lv_followUps_4_0=ruleSemanticsRule();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"followUps",
                                    		lv_followUps_4_0, 
                                    		"SemanticsRule");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2089:2: (otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) ) )+
                            int cnt53=0;
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==31) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2089:4: otherlv_5= ',' ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleSemanticsRule4116); 

                            	        	newLeafNode(otherlv_5, grammarAccess.getSemanticsRuleAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2093:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2094:1: (lv_followUps_6_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2094:1: (lv_followUps_6_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2095:3: lv_followUps_6_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_1_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4137);
                            	    lv_followUps_6_0=ruleSemanticsRule();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getSemanticsRuleRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"followUps",
                            	            		lv_followUps_6_0, 
                            	            		"SemanticsRule");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt53 >= 1 ) break loop53;
                                        EarlyExitException eee =
                                            new EarlyExitException(53, input);
                                        throw eee;
                                }
                                cnt53++;
                            } while (true);

                            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleSemanticsRule4151); 

                                	newLeafNode(otherlv_7, grammarAccess.getSemanticsRuleAccess().getRightParenthesisKeyword_1_1_1_3());
                                

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
    // $ANTLR end "ruleSemanticsRule"


    // $ANTLR start "entryRuleActorClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2123:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2124:2: (iv_ruleActorClass= ruleActorClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:2: iv_ruleActorClass= ruleActorClass EOF
            {
             newCompositeNode(grammarAccess.getActorClassRule()); 
            pushFollow(FOLLOW_ruleActorClass_in_entryRuleActorClass4191);
            iv_ruleActorClass=ruleActorClass();

            state._fsp--;

             current =iv_ruleActorClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClass4201); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorClass"


    // $ANTLR start "ruleActorClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2132:1: ruleActorClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' ) ;
    public final EObject ruleActorClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        EObject lv_docu_3_0 = null;

        EObject lv_ifPorts_9_0 = null;

        EObject lv_ifSPPs_10_0 = null;

        EObject lv_structureDocu_13_0 = null;

        EObject lv_userCode1_16_0 = null;

        EObject lv_userCode2_18_0 = null;

        EObject lv_userCode3_20_0 = null;

        EObject lv_intPorts_21_0 = null;

        EObject lv_extPorts_22_0 = null;

        EObject lv_serviceImplementations_23_0 = null;

        EObject lv_strSAPs_24_0 = null;

        EObject lv_attributes_25_0 = null;

        EObject lv_actorRefs_26_0 = null;

        EObject lv_bindings_27_0 = null;

        EObject lv_connections_28_0 = null;

        EObject lv_behaviorDocu_31_0 = null;

        EObject lv_annotations_33_0 = null;

        EObject lv_operations_34_0 = null;

        EObject lv_stateMachine_35_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2135:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2136:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2136:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2136:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'ActorClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )? (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )? (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )? otherlv_37= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2136:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==45) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2137:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2137:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2138:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,45,FOLLOW_45_in_ruleActorClass4244); 

                            newLeafNode(lv_abstract_0_0, grammarAccess.getActorClassAccess().getAbstractAbstractKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                           		setWithLastConsumed(current, "abstract", true, "abstract");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleActorClass4270); 

                	newLeafNode(otherlv_1, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2155:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2156:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2156:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2157:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClass4287); 

            			newLeafNode(lv_name_2_0, grammarAccess.getActorClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2173:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==94) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2174:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2174:1: (lv_docu_3_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2175:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4313);
                    lv_docu_3_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_3_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2191:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==24) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2191:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleActorClass4327); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2195:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2196:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2196:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2197:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleActorClass4350);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4364); 

                	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2214:1: (otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==47) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2214:3: otherlv_7= 'Interface' otherlv_8= '{' ( (lv_ifPorts_9_0= rulePort ) )* ( (lv_ifSPPs_10_0= ruleSPPRef ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,47,FOLLOW_47_in_ruleActorClass4377); 

                        	newLeafNode(otherlv_7, grammarAccess.getActorClassAccess().getInterfaceKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4389); 

                        	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2222:1: ( (lv_ifPorts_9_0= rulePort ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( ((LA59_0>=50 && LA59_0<=51)) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2223:1: (lv_ifPorts_9_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2223:1: (lv_ifPorts_9_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2224:3: lv_ifPorts_9_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfPortsPortParserRuleCall_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass4410);
                    	    lv_ifPorts_9_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifPorts",
                    	            		lv_ifPorts_9_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2240:3: ( (lv_ifSPPs_10_0= ruleSPPRef ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==54) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2241:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2241:1: (lv_ifSPPs_10_0= ruleSPPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2242:3: lv_ifSPPs_10_0= ruleSPPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfSPPsSPPRefParserRuleCall_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSPPRef_in_ruleActorClass4432);
                    	    lv_ifSPPs_10_0=ruleSPPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifSPPs",
                    	            		lv_ifSPPs_10_0, 
                    	            		"SPPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4445); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_6_4());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2262:3: (otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==48) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2262:5: otherlv_12= 'Structure' ( (lv_structureDocu_13_0= ruleDocumentation ) )? otherlv_14= '{' (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )? (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )? (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )* ( (lv_strSAPs_24_0= ruleSAPRef ) )* ( (lv_attributes_25_0= ruleAttribute ) )* ( (lv_actorRefs_26_0= ruleActorRef ) )* ( (lv_bindings_27_0= ruleBinding ) )* ( (lv_connections_28_0= ruleLayerConnection ) )* otherlv_29= '}'
                    {
                    otherlv_12=(Token)match(input,48,FOLLOW_48_in_ruleActorClass4460); 

                        	newLeafNode(otherlv_12, grammarAccess.getActorClassAccess().getStructureKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2266:1: ( (lv_structureDocu_13_0= ruleDocumentation ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==94) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2267:1: (lv_structureDocu_13_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2267:1: (lv_structureDocu_13_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2268:3: lv_structureDocu_13_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStructureDocuDocumentationParserRuleCall_7_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4481);
                            lv_structureDocu_13_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"structureDocu",
                                    		lv_structureDocu_13_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4494); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2288:1: (otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==25) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2288:3: otherlv_15= 'usercode1' ( (lv_userCode1_16_0= ruleDetailCode ) )
                            {
                            otherlv_15=(Token)match(input,25,FOLLOW_25_in_ruleActorClass4507); 

                                	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getUsercode1Keyword_7_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2292:1: ( (lv_userCode1_16_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2293:1: (lv_userCode1_16_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2293:1: (lv_userCode1_16_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2294:3: lv_userCode1_16_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_7_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4528);
                            lv_userCode1_16_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode1",
                                    		lv_userCode1_16_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2310:4: (otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==26) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2310:6: otherlv_17= 'usercode2' ( (lv_userCode2_18_0= ruleDetailCode ) )
                            {
                            otherlv_17=(Token)match(input,26,FOLLOW_26_in_ruleActorClass4543); 

                                	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getUsercode2Keyword_7_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2314:1: ( (lv_userCode2_18_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2315:1: (lv_userCode2_18_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2315:1: (lv_userCode2_18_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2316:3: lv_userCode2_18_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_7_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4564);
                            lv_userCode2_18_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode2",
                                    		lv_userCode2_18_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2332:4: (otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==27) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2332:6: otherlv_19= 'usercode3' ( (lv_userCode3_20_0= ruleDetailCode ) )
                            {
                            otherlv_19=(Token)match(input,27,FOLLOW_27_in_ruleActorClass4579); 

                                	newLeafNode(otherlv_19, grammarAccess.getActorClassAccess().getUsercode3Keyword_7_5_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2336:1: ( (lv_userCode3_20_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2337:1: (lv_userCode3_20_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2337:1: (lv_userCode3_20_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2338:3: lv_userCode3_20_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_7_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass4600);
                            lv_userCode3_20_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode3",
                                    		lv_userCode3_20_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2354:4: ( ( (lv_intPorts_21_0= rulePort ) ) | ( (lv_extPorts_22_0= ruleExternalPort ) ) )*
                    loop66:
                    do {
                        int alt66=3;
                        int LA66_0 = input.LA(1);

                        if ( ((LA66_0>=50 && LA66_0<=51)) ) {
                            alt66=1;
                        }
                        else if ( (LA66_0==52) ) {
                            alt66=2;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2354:5: ( (lv_intPorts_21_0= rulePort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2354:5: ( (lv_intPorts_21_0= rulePort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2355:1: (lv_intPorts_21_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2355:1: (lv_intPorts_21_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2356:3: lv_intPorts_21_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIntPortsPortParserRuleCall_7_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass4624);
                    	    lv_intPorts_21_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"intPorts",
                    	            		lv_intPorts_21_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2373:6: ( (lv_extPorts_22_0= ruleExternalPort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2373:6: ( (lv_extPorts_22_0= ruleExternalPort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2374:1: (lv_extPorts_22_0= ruleExternalPort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2374:1: (lv_extPorts_22_0= ruleExternalPort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2375:3: lv_extPorts_22_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExtPortsExternalPortParserRuleCall_7_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExternalPort_in_ruleActorClass4651);
                    	    lv_extPorts_22_0=ruleExternalPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"extPorts",
                    	            		lv_extPorts_22_0, 
                    	            		"ExternalPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2391:4: ( (lv_serviceImplementations_23_0= ruleServiceImplementation ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==55) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2392:1: (lv_serviceImplementations_23_0= ruleServiceImplementation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2392:1: (lv_serviceImplementations_23_0= ruleServiceImplementation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2393:3: lv_serviceImplementations_23_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_7_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleServiceImplementation_in_ruleActorClass4674);
                    	    lv_serviceImplementations_23_0=ruleServiceImplementation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceImplementations",
                    	            		lv_serviceImplementations_23_0, 
                    	            		"ServiceImplementation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2409:3: ( (lv_strSAPs_24_0= ruleSAPRef ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==53) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2410:1: (lv_strSAPs_24_0= ruleSAPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2410:1: (lv_strSAPs_24_0= ruleSAPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2411:3: lv_strSAPs_24_0= ruleSAPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStrSAPsSAPRefParserRuleCall_7_8_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSAPRef_in_ruleActorClass4696);
                    	    lv_strSAPs_24_0=ruleSAPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"strSAPs",
                    	            		lv_strSAPs_24_0, 
                    	            		"SAPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2427:3: ( (lv_attributes_25_0= ruleAttribute ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==28) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2428:1: (lv_attributes_25_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2428:1: (lv_attributes_25_0= ruleAttribute )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2429:3: lv_attributes_25_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_7_9_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleActorClass4718);
                    	    lv_attributes_25_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_25_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2445:3: ( (lv_actorRefs_26_0= ruleActorRef ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==68) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2446:1: (lv_actorRefs_26_0= ruleActorRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2446:1: (lv_actorRefs_26_0= ruleActorRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2447:3: lv_actorRefs_26_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_7_10_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorRef_in_ruleActorClass4740);
                    	    lv_actorRefs_26_0=ruleActorRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorRefs",
                    	            		lv_actorRefs_26_0, 
                    	            		"ActorRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2463:3: ( (lv_bindings_27_0= ruleBinding ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==63) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2464:1: (lv_bindings_27_0= ruleBinding )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2464:1: (lv_bindings_27_0= ruleBinding )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2465:3: lv_bindings_27_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_7_11_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinding_in_ruleActorClass4762);
                    	    lv_bindings_27_0=ruleBinding();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"bindings",
                    	            		lv_bindings_27_0, 
                    	            		"Binding");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2481:3: ( (lv_connections_28_0= ruleLayerConnection ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==65) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2482:1: (lv_connections_28_0= ruleLayerConnection )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2482:1: (lv_connections_28_0= ruleLayerConnection )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2483:3: lv_connections_28_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_7_12_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleActorClass4784);
                    	    lv_connections_28_0=ruleLayerConnection();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_28_0, 
                    	            		"LayerConnection");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_29=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4797); 

                        	newLeafNode(otherlv_29, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_13());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2503:3: (otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==49) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2503:5: otherlv_30= 'Behavior' ( (lv_behaviorDocu_31_0= ruleDocumentation ) )? otherlv_32= '{' ( (lv_annotations_33_0= ruleAnnotation ) )* ( (lv_operations_34_0= ruleStandardOperation ) )* ( (lv_stateMachine_35_0= ruleStateMachine ) )? otherlv_36= '}'
                    {
                    otherlv_30=(Token)match(input,49,FOLLOW_49_in_ruleActorClass4812); 

                        	newLeafNode(otherlv_30, grammarAccess.getActorClassAccess().getBehaviorKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2507:1: ( (lv_behaviorDocu_31_0= ruleDocumentation ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==94) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2508:1: (lv_behaviorDocu_31_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2508:1: (lv_behaviorDocu_31_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2509:3: lv_behaviorDocu_31_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorDocuDocumentationParserRuleCall_8_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass4833);
                            lv_behaviorDocu_31_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"behaviorDocu",
                                    		lv_behaviorDocu_31_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_32=(Token)match(input,13,FOLLOW_13_in_ruleActorClass4846); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2529:1: ( (lv_annotations_33_0= ruleAnnotation ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==96) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2530:1: (lv_annotations_33_0= ruleAnnotation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2530:1: (lv_annotations_33_0= ruleAnnotation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2531:3: lv_annotations_33_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_8_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAnnotation_in_ruleActorClass4867);
                    	    lv_annotations_33_0=ruleAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"annotations",
                    	            		lv_annotations_33_0, 
                    	            		"Annotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2547:3: ( (lv_operations_34_0= ruleStandardOperation ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==30) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2548:1: (lv_operations_34_0= ruleStandardOperation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2548:1: (lv_operations_34_0= ruleStandardOperation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2549:3: lv_operations_34_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_8_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleActorClass4889);
                    	    lv_operations_34_0=ruleStandardOperation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_34_0, 
                    	            		"StandardOperation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2565:3: ( (lv_stateMachine_35_0= ruleStateMachine ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( ((LA77_0>=69 && LA77_0<=70)) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2566:1: (lv_stateMachine_35_0= ruleStateMachine )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2566:1: (lv_stateMachine_35_0= ruleStateMachine )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2567:3: lv_stateMachine_35_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_8_5_0()); 
                            	    
                            pushFollow(FOLLOW_ruleStateMachine_in_ruleActorClass4911);
                            lv_stateMachine_35_0=ruleStateMachine();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"stateMachine",
                                    		lv_stateMachine_35_0, 
                                    		"StateMachine");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_36=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4924); 

                        	newLeafNode(otherlv_36, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_6());
                        

                    }
                    break;

            }

            otherlv_37=(Token)match(input,14,FOLLOW_14_in_ruleActorClass4938); 

                	newLeafNode(otherlv_37, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorClass"


    // $ANTLR start "entryRulePort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2601:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2602:2: (iv_rulePort= rulePort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2603:2: iv_rulePort= rulePort EOF
            {
             newCompositeNode(grammarAccess.getPortRule()); 
            pushFollow(FOLLOW_rulePort_in_entryRulePort4976);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePort4986); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2610:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_multiplicity_3_0=null;
        Token otherlv_4=null;
        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2613:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2614:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==50) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2615:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2615:1: (lv_conjugated_0_0= 'conjugated' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2616:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,50,FOLLOW_50_in_rulePort5029); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_rulePort5055); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2633:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2634:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2634:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2635:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePort5072); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPortAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2651:2: ( (lv_multiplicity_3_0= RULE_MULTIPLICITY ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_MULTIPLICITY) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2652:1: (lv_multiplicity_3_0= RULE_MULTIPLICITY )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2652:1: (lv_multiplicity_3_0= RULE_MULTIPLICITY )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2653:3: lv_multiplicity_3_0= RULE_MULTIPLICITY
                    {
                    lv_multiplicity_3_0=(Token)match(input,RULE_MULTIPLICITY,FOLLOW_RULE_MULTIPLICITY_in_rulePort5094); 

                    			newLeafNode(lv_multiplicity_3_0, grammarAccess.getPortAccess().getMultiplicityMULTIPLICITYTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"MULTIPLICITY");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePort5112); 

                	newLeafNode(otherlv_4, grammarAccess.getPortAccess().getColonKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2673:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2674:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2674:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2675:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePort5135);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2688:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==94) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2689:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2689:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2690:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePort5156);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
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


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleExternalPort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2714:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2715:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2716:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             newCompositeNode(grammarAccess.getExternalPortRule()); 
            pushFollow(FOLLOW_ruleExternalPort_in_entryRuleExternalPort5193);
            iv_ruleExternalPort=ruleExternalPort();

            state._fsp--;

             current =iv_ruleExternalPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalPort5203); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalPort"


    // $ANTLR start "ruleExternalPort"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2723:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2726:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2727:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2727:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2727:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleExternalPort5240); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleExternalPort5252); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2735:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2736:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2736:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2737:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalPortRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalPort5272); 

            		newLeafNode(otherlv_2, grammarAccess.getExternalPortAccess().getIfportPortCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleExternalPort"


    // $ANTLR start "entryRuleSAPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2756:1: entryRuleSAPRef returns [EObject current=null] : iv_ruleSAPRef= ruleSAPRef EOF ;
    public final EObject entryRuleSAPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2757:2: (iv_ruleSAPRef= ruleSAPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2758:2: iv_ruleSAPRef= ruleSAPRef EOF
            {
             newCompositeNode(grammarAccess.getSAPRefRule()); 
            pushFollow(FOLLOW_ruleSAPRef_in_entryRuleSAPRef5308);
            iv_ruleSAPRef=ruleSAPRef();

            state._fsp--;

             current =iv_ruleSAPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPRef5318); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSAPRef"


    // $ANTLR start "ruleSAPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2765:1: ruleSAPRef returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2768:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2769:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2769:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2769:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleSAPRef5355); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPRefAccess().getSAPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2773:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2774:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2774:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2775:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSAPRef5372); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSAPRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSAPRef5389); 

                	newLeafNode(otherlv_2, grammarAccess.getSAPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2795:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2796:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2796:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2797:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSAPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSAPRef5412);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleSAPRef"


    // $ANTLR start "entryRuleSPPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2818:1: entryRuleSPPRef returns [EObject current=null] : iv_ruleSPPRef= ruleSPPRef EOF ;
    public final EObject entryRuleSPPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2819:2: (iv_ruleSPPRef= ruleSPPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2820:2: iv_ruleSPPRef= ruleSPPRef EOF
            {
             newCompositeNode(grammarAccess.getSPPRefRule()); 
            pushFollow(FOLLOW_ruleSPPRef_in_entryRuleSPPRef5448);
            iv_ruleSPPRef=ruleSPPRef();

            state._fsp--;

             current =iv_ruleSPPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPRef5458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPPRef"


    // $ANTLR start "ruleSPPRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2827:1: ruleSPPRef returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2830:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2831:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2831:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2831:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleSPPRef5495); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPRefAccess().getSPPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2835:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2836:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2836:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2837:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPRef5512); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSPPRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSPPRef5529); 

                	newLeafNode(otherlv_2, grammarAccess.getSPPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2857:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2858:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2858:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2859:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSPPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSPPRef5552);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleSPPRef"


    // $ANTLR start "entryRuleServiceImplementation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2880:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2881:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2882:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             newCompositeNode(grammarAccess.getServiceImplementationRule()); 
            pushFollow(FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation5588);
            iv_ruleServiceImplementation=ruleServiceImplementation();

            state._fsp--;

             current =iv_ruleServiceImplementation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleServiceImplementation5598); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceImplementation"


    // $ANTLR start "ruleServiceImplementation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2889:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2892:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2893:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2893:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2893:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleServiceImplementation5635); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleServiceImplementation5647); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2901:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2902:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2902:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2903:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getServiceImplementationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleServiceImplementation5667); 

            		newLeafNode(otherlv_2, grammarAccess.getServiceImplementationAccess().getSppSPPRefCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleServiceImplementation"


    // $ANTLR start "entryRuleLogicalSystem"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2922:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2923:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2924:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             newCompositeNode(grammarAccess.getLogicalSystemRule()); 
            pushFollow(FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem5703);
            iv_ruleLogicalSystem=ruleLogicalSystem();

            state._fsp--;

             current =iv_ruleLogicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalSystem5713); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalSystem"


    // $ANTLR start "ruleLogicalSystem"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2931:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_docu_2_0 = null;

        EObject lv_subSystems_4_0 = null;

        EObject lv_bindings_5_0 = null;

        EObject lv_connections_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2934:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2935:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2935:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2935:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_subSystems_4_0= ruleSubSystemRef ) )* ( (lv_bindings_5_0= ruleBinding ) )* ( (lv_connections_6_0= ruleLayerConnection ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleLogicalSystem5750); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2939:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2940:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2940:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2941:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalSystem5767); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2957:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==94) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2958:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2958:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2959:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleLogicalSystem5793);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleLogicalSystem5806); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2979:1: ( (lv_subSystems_4_0= ruleSubSystemRef ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==58) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2980:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2980:1: (lv_subSystems_4_0= ruleSubSystemRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2981:3: lv_subSystems_4_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem5827);
            	    lv_subSystems_4_0=ruleSubSystemRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystems",
            	            		lv_subSystems_4_0, 
            	            		"SubSystemRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2997:3: ( (lv_bindings_5_0= ruleBinding ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==63) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2998:1: (lv_bindings_5_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2998:1: (lv_bindings_5_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2999:3: lv_bindings_5_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleLogicalSystem5849);
            	    lv_bindings_5_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_5_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3015:3: ( (lv_connections_6_0= ruleLayerConnection ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==65) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3016:1: (lv_connections_6_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3016:1: (lv_connections_6_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3017:3: lv_connections_6_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleLogicalSystem5871);
            	    lv_connections_6_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_6_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleLogicalSystem5884); 

                	newLeafNode(otherlv_7, grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalSystem"


    // $ANTLR start "entryRuleSubSystemRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3047:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3048:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3049:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             newCompositeNode(grammarAccess.getSubSystemRefRule()); 
            pushFollow(FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef5922);
            iv_ruleSubSystemRef=ruleSubSystemRef();

            state._fsp--;

             current =iv_ruleSubSystemRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemRef5932); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubSystemRef"


    // $ANTLR start "ruleSubSystemRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3056:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3059:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3060:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3060:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3060:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleSubSystemRef5969); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3064:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3065:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3065:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3066:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemRef5986); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSubSystemRef6003); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3086:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3087:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3087:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3088:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemRef6026);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3101:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==94) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3102:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3102:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3103:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemRef6047);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemRefRule());
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
    // $ANTLR end "ruleSubSystemRef"


    // $ANTLR start "entryRuleSubSystemClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3127:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3128:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3129:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             newCompositeNode(grammarAccess.getSubSystemClassRule()); 
            pushFollow(FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass6084);
            iv_ruleSubSystemClass=ruleSubSystemClass();

            state._fsp--;

             current =iv_ruleSubSystemClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemClass6094); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubSystemClass"


    // $ANTLR start "ruleSubSystemClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3136:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_16=null;
        EObject lv_docu_2_0 = null;

        EObject lv_userCode1_5_0 = null;

        EObject lv_userCode2_7_0 = null;

        EObject lv_userCode3_9_0 = null;

        EObject lv_relayPorts_10_0 = null;

        EObject lv_ifSPPs_11_0 = null;

        EObject lv_actorRefs_12_0 = null;

        EObject lv_bindings_13_0 = null;

        EObject lv_connections_14_0 = null;

        EObject lv_threads_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3139:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3140:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )? (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )? (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )? ( (lv_relayPorts_10_0= rulePort ) )* ( (lv_ifSPPs_11_0= ruleSPPRef ) )* ( (lv_actorRefs_12_0= ruleActorRef ) )* ( (lv_bindings_13_0= ruleBinding ) )* ( (lv_connections_14_0= ruleLayerConnection ) )* ( (lv_threads_15_0= ruleLogicalThread ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleSubSystemClass6131); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3144:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3145:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3145:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3146:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemClass6148); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3162:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==94) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3163:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3163:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3164:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemClass6174);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleSubSystemClass6187); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3184:1: (otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==25) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3184:3: otherlv_4= 'usercode1' ( (lv_userCode1_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSubSystemClass6200); 

                        	newLeafNode(otherlv_4, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3188:1: ( (lv_userCode1_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3189:1: (lv_userCode1_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3189:1: (lv_userCode1_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3190:3: lv_userCode1_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6221);
                    lv_userCode1_5_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_5_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3206:4: (otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==26) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3206:6: otherlv_6= 'usercode2' ( (lv_userCode2_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleSubSystemClass6236); 

                        	newLeafNode(otherlv_6, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3210:1: ( (lv_userCode2_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3211:1: (lv_userCode2_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3211:1: (lv_userCode2_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3212:3: lv_userCode2_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6257);
                    lv_userCode2_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_7_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3228:4: (otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==27) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3228:6: otherlv_8= 'usercode3' ( (lv_userCode3_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleSubSystemClass6272); 

                        	newLeafNode(otherlv_8, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3232:1: ( (lv_userCode3_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3233:1: (lv_userCode3_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3233:1: (lv_userCode3_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3234:3: lv_userCode3_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass6293);
                    lv_userCode3_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3250:4: ( (lv_relayPorts_10_0= rulePort ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( ((LA91_0>=50 && LA91_0<=51)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3251:1: (lv_relayPorts_10_0= rulePort )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3251:1: (lv_relayPorts_10_0= rulePort )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3252:3: lv_relayPorts_10_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePort_in_ruleSubSystemClass6316);
            	    lv_relayPorts_10_0=rulePort();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relayPorts",
            	            		lv_relayPorts_10_0, 
            	            		"Port");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3268:3: ( (lv_ifSPPs_11_0= ruleSPPRef ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==54) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3269:1: (lv_ifSPPs_11_0= ruleSPPRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3269:1: (lv_ifSPPs_11_0= ruleSPPRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3270:3: lv_ifSPPs_11_0= ruleSPPRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getIfSPPsSPPRefParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSPPRef_in_ruleSubSystemClass6338);
            	    lv_ifSPPs_11_0=ruleSPPRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ifSPPs",
            	            		lv_ifSPPs_11_0, 
            	            		"SPPRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3286:3: ( (lv_actorRefs_12_0= ruleActorRef ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==68) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3287:1: (lv_actorRefs_12_0= ruleActorRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3287:1: (lv_actorRefs_12_0= ruleActorRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3288:3: lv_actorRefs_12_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorRef_in_ruleSubSystemClass6360);
            	    lv_actorRefs_12_0=ruleActorRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorRefs",
            	            		lv_actorRefs_12_0, 
            	            		"ActorRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3304:3: ( (lv_bindings_13_0= ruleBinding ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==63) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3305:1: (lv_bindings_13_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3305:1: (lv_bindings_13_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3306:3: lv_bindings_13_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleSubSystemClass6382);
            	    lv_bindings_13_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_13_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3322:3: ( (lv_connections_14_0= ruleLayerConnection ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==65) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3323:1: (lv_connections_14_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3323:1: (lv_connections_14_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3324:3: lv_connections_14_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleSubSystemClass6404);
            	    lv_connections_14_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_14_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3340:3: ( (lv_threads_15_0= ruleLogicalThread ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==60) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3341:1: (lv_threads_15_0= ruleLogicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3341:1: (lv_threads_15_0= ruleLogicalThread )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3342:3: lv_threads_15_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalThread_in_ruleSubSystemClass6426);
            	    lv_threads_15_0=ruleLogicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_15_0, 
            	            		"LogicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            otherlv_16=(Token)match(input,14,FOLLOW_14_in_ruleSubSystemClass6439); 

                	newLeafNode(otherlv_16, grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_13());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubSystemClass"


    // $ANTLR start "entryRuleLogicalThread"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3370:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3371:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3372:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             newCompositeNode(grammarAccess.getLogicalThreadRule()); 
            pushFollow(FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread6475);
            iv_ruleLogicalThread=ruleLogicalThread();

            state._fsp--;

             current =iv_ruleLogicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalThread6485); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalThread"


    // $ANTLR start "ruleLogicalThread"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3379:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_prio_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_instances_6_0 = null;

        EObject lv_instances_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3382:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3383:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3383:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3383:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleLogicalThread6522); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3387:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3389:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalThread6539); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleLogicalThread6556); 

                	newLeafNode(otherlv_2, grammarAccess.getLogicalThreadAccess().getPrioKeyword_2());
                
            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleLogicalThread6568); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalThreadAccess().getEqualsSignKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3413:1: ( (lv_prio_4_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3414:1: (lv_prio_4_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3414:1: (lv_prio_4_0= RULE_INT )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3415:3: lv_prio_4_0= RULE_INT
            {
            lv_prio_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLogicalThread6585); 

            			newLeafNode(lv_prio_4_0, grammarAccess.getLogicalThreadAccess().getPrioINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalThreadRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"prio",
                    		lv_prio_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleLogicalThread6602); 

                	newLeafNode(otherlv_5, grammarAccess.getLogicalThreadAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3435:1: ( (lv_instances_6_0= ruleActorInstancePath ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3436:1: (lv_instances_6_0= ruleActorInstancePath )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3436:1: (lv_instances_6_0= ruleActorInstancePath )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3437:3: lv_instances_6_0= ruleActorInstancePath
            {
             
            	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6623);
            lv_instances_6_0=ruleActorInstancePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLogicalThreadRule());
            	        }
                   		add(
                   			current, 
                   			"instances",
                    		lv_instances_6_0, 
                    		"ActorInstancePath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3453:2: (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==31) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3453:4: otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    {
            	    otherlv_7=(Token)match(input,31,FOLLOW_31_in_ruleLogicalThread6636); 

            	        	newLeafNode(otherlv_7, grammarAccess.getLogicalThreadAccess().getCommaKeyword_7_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3457:1: ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3458:1: (lv_instances_8_0= ruleActorInstancePath )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3458:1: (lv_instances_8_0= ruleActorInstancePath )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3459:3: lv_instances_8_0= ruleActorInstancePath
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6657);
            	    lv_instances_8_0=ruleActorInstancePath();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalThreadRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instances",
            	            		lv_instances_8_0, 
            	            		"ActorInstancePath");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleLogicalThread6671); 

                	newLeafNode(otherlv_9, grammarAccess.getLogicalThreadAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalThread"


    // $ANTLR start "entryRuleActorInstancePath"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3487:1: entryRuleActorInstancePath returns [EObject current=null] : iv_ruleActorInstancePath= ruleActorInstancePath EOF ;
    public final EObject entryRuleActorInstancePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstancePath = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3488:2: (iv_ruleActorInstancePath= ruleActorInstancePath EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3489:2: iv_ruleActorInstancePath= ruleActorInstancePath EOF
            {
             newCompositeNode(grammarAccess.getActorInstancePathRule()); 
            pushFollow(FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath6707);
            iv_ruleActorInstancePath=ruleActorInstancePath();

            state._fsp--;

             current =iv_ruleActorInstancePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstancePath6717); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorInstancePath"


    // $ANTLR start "ruleActorInstancePath"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3496:1: ruleActorInstancePath returns [EObject current=null] : ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleActorInstancePath() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;
        Token otherlv_1=null;
        Token lv_segments_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3499:28: ( ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3500:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3500:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3500:2: ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3500:2: ( (lv_segments_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3501:1: (lv_segments_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3501:1: (lv_segments_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3502:3: lv_segments_0_0= RULE_ID
            {
            lv_segments_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath6759); 

            			newLeafNode(lv_segments_0_0, grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstancePathRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"segments",
                    		lv_segments_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3518:2: (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==62) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3518:4: otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleActorInstancePath6777); 

            	        	newLeafNode(otherlv_1, grammarAccess.getActorInstancePathAccess().getFullStopKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3522:1: ( (lv_segments_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3523:1: (lv_segments_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3523:1: (lv_segments_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3524:3: lv_segments_2_0= RULE_ID
            	    {
            	    lv_segments_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath6794); 

            	    			newLeafNode(lv_segments_2_0, grammarAccess.getActorInstancePathAccess().getSegmentsIDTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getActorInstancePathRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"segments",
            	            		lv_segments_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
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
    // $ANTLR end "ruleActorInstancePath"


    // $ANTLR start "entryRuleBinding"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3548:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3549:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3550:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding6837);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding6847); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3557:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3560:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3561:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3561:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3561:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleBinding6884); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3565:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3566:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3566:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3567:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding6905);
            lv_endpoint1_1_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint1",
                    		lv_endpoint1_1_0, 
                    		"BindingEndPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,64,FOLLOW_64_in_ruleBinding6917); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3587:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3588:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3588:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3589:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding6938);
            lv_endpoint2_3_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint2",
                    		lv_endpoint2_3_0, 
                    		"BindingEndPoint");
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
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleBindingEndPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3613:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3614:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3615:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             newCompositeNode(grammarAccess.getBindingEndPointRule()); 
            pushFollow(FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint6974);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();

            state._fsp--;

             current =iv_ruleBindingEndPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingEndPoint6984); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBindingEndPoint"


    // $ANTLR start "ruleBindingEndPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3622:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3625:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_ID) ) {
                int LA99_1 = input.LA(2);

                if ( (LA99_1==62) ) {
                    alt99=1;
                }
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3626:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3627:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3627:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3628:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint7030); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleBindingEndPoint7042); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3643:3: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3644:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3644:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3645:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint7064); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleBindingEndPoint"


    // $ANTLR start "entryRuleLayerConnection"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3664:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3665:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3666:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             newCompositeNode(grammarAccess.getLayerConnectionRule()); 
            pushFollow(FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection7100);
            iv_ruleLayerConnection=ruleLayerConnection();

            state._fsp--;

             current =iv_ruleLayerConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerConnection7110); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerConnection"


    // $ANTLR start "ruleLayerConnection"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3673:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3676:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3677:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3677:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3677:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_65_in_ruleLayerConnection7147); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3681:1: ( (lv_from_1_0= ruleSAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3682:1: (lv_from_1_0= ruleSAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3682:1: (lv_from_1_0= ruleSAPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3683:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSAPoint_in_ruleLayerConnection7168);
            lv_from_1_0=ruleSAPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_1_0, 
                    		"SAPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,66,FOLLOW_66_in_ruleLayerConnection7180); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3703:1: ( (lv_to_3_0= ruleSPPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3704:1: (lv_to_3_0= ruleSPPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3704:1: (lv_to_3_0= ruleSPPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3705:3: lv_to_3_0= ruleSPPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleSPPoint_in_ruleLayerConnection7201);
            lv_to_3_0=ruleSPPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_3_0, 
                    		"SPPoint");
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
    // $ANTLR end "ruleLayerConnection"


    // $ANTLR start "entryRuleSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3729:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3730:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3731:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             newCompositeNode(grammarAccess.getSAPointRule()); 
            pushFollow(FOLLOW_ruleSAPoint_in_entryRuleSAPoint7237);
            iv_ruleSAPoint=ruleSAPoint();

            state._fsp--;

             current =iv_ruleSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPoint7247); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSAPoint"


    // $ANTLR start "ruleSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3738:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3741:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3742:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3742:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==16) ) {
                alt100=1;
            }
            else if ( (LA100_0==67) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3743:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRefSAPoint_in_ruleSAPoint7294);
                    this_RefSAPoint_0=ruleRefSAPoint();

                    state._fsp--;

                     
                            current = this_RefSAPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3753:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRelaySAPoint_in_ruleSAPoint7321);
                    this_RelaySAPoint_1=ruleRelaySAPoint();

                    state._fsp--;

                     
                            current = this_RelaySAPoint_1; 
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
    // $ANTLR end "ruleSAPoint"


    // $ANTLR start "entryRuleRefSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3769:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3770:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3771:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             newCompositeNode(grammarAccess.getRefSAPointRule()); 
            pushFollow(FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint7356);
            iv_ruleRefSAPoint=ruleRefSAPoint();

            state._fsp--;

             current =iv_ruleRefSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefSAPoint7366); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefSAPoint"


    // $ANTLR start "ruleRefSAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3778:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3781:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3782:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3782:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3782:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleRefSAPoint7403); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3786:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3787:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3787:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3788:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefSAPoint7423); 

            		newLeafNode(otherlv_1, grammarAccess.getRefSAPointAccess().getRefActorContainerRefCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleRefSAPoint"


    // $ANTLR start "entryRuleRelaySAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3807:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3808:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3809:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             newCompositeNode(grammarAccess.getRelaySAPointRule()); 
            pushFollow(FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint7459);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();

            state._fsp--;

             current =iv_ruleRelaySAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelaySAPoint7469); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelaySAPoint"


    // $ANTLR start "ruleRelaySAPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3816:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3819:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3820:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3820:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3820:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleRelaySAPoint7506); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3824:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3825:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3825:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3826:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRelaySAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelaySAPoint7526); 

            		newLeafNode(otherlv_1, grammarAccess.getRelaySAPointAccess().getRelaySPPRefCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleRelaySAPoint"


    // $ANTLR start "entryRuleSPPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3845:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3846:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3847:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             newCompositeNode(grammarAccess.getSPPointRule()); 
            pushFollow(FOLLOW_ruleSPPoint_in_entryRuleSPPoint7562);
            iv_ruleSPPoint=ruleSPPoint();

            state._fsp--;

             current =iv_ruleSPPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPoint7572); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPPoint"


    // $ANTLR start "ruleSPPoint"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3854:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3857:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3858:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3858:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3858:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3858:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3859:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3859:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3860:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint7617); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleSPPoint7629); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3875:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3876:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3876:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3877:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint7649); 

            		newLeafNode(otherlv_2, grammarAccess.getSPPointAccess().getServiceSPPRefCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleSPPoint"


    // $ANTLR start "entryRuleActorRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3896:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3897:2: (iv_ruleActorRef= ruleActorRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3898:2: iv_ruleActorRef= ruleActorRef EOF
            {
             newCompositeNode(grammarAccess.getActorRefRule()); 
            pushFollow(FOLLOW_ruleActorRef_in_entryRuleActorRef7685);
            iv_ruleActorRef=ruleActorRef();

            state._fsp--;

             current =iv_ruleActorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorRef7695); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActorRef"


    // $ANTLR start "ruleActorRef"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3905:1: ruleActorRef returns [EObject current=null] : (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3908:28: ( (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3909:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3909:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3909:3: otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleActorRef7732); 

                	newLeafNode(otherlv_0, grammarAccess.getActorRefAccess().getActorRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3913:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3914:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3914:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3915:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorRef7749); 

            			newLeafNode(lv_name_1_0, grammarAccess.getActorRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleActorRef7766); 

                	newLeafNode(otherlv_2, grammarAccess.getActorRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3935:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3936:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3936:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3937:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorRef7789);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3950:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==94) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3951:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3951:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3952:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorRef7810);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
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
    // $ANTLR end "ruleActorRef"


    // $ANTLR start "entryRuleStateGraphNode"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3976:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3977:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3978:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             newCompositeNode(grammarAccess.getStateGraphNodeRule()); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode7847);
            iv_ruleStateGraphNode=ruleStateGraphNode();

            state._fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode7857); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3985:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3988:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3989:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3989:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 71:
            case 76:
                {
                alt102=1;
                }
                break;
            case 81:
                {
                alt102=2;
                }
                break;
            case 77:
            case 78:
            case 79:
            case 80:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3990:5: this_State_0= ruleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode7904);
                    this_State_0=ruleState();

                    state._fsp--;

                     
                            current = this_State_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4000:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode7931);
                    this_ChoicePoint_1=ruleChoicePoint();

                    state._fsp--;

                     
                            current = this_ChoicePoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4010:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode7958);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4028:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4029:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4030:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState7995);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState8005); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4037:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4040:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4041:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4041:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==71) ) {
                alt103=1;
            }
            else if ( (LA103_0==76) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4042:5: this_SimpleState_0= ruleSimpleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleState_in_ruleState8052);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;

                     
                            current = this_SimpleState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4052:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState8079);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4068:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4069:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4070:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph8114);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph8124); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4077:1: ruleStateGraph returns [EObject current=null] : (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine ) ;
    public final EObject ruleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject this_PlainStateGraph_0 = null;

        EObject this_StateMachine_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4080:28: ( (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4081:1: (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4081:1: (this_PlainStateGraph_0= rulePlainStateGraph | this_StateMachine_1= ruleStateMachine )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==13) ) {
                alt104=1;
            }
            else if ( ((LA104_0>=69 && LA104_0<=70)) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4082:5: this_PlainStateGraph_0= rulePlainStateGraph
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphAccess().getPlainStateGraphParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePlainStateGraph_in_ruleStateGraph8171);
                    this_PlainStateGraph_0=rulePlainStateGraph();

                    state._fsp--;

                     
                            current = this_PlainStateGraph_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4092:5: this_StateMachine_1= ruleStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphAccess().getStateMachineParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleStateGraph8198);
                    this_StateMachine_1=ruleStateMachine();

                    state._fsp--;

                     
                            current = this_StateMachine_1; 
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
    // $ANTLR end "ruleStateGraph"


    // $ANTLR start "entryRulePlainStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4108:1: entryRulePlainStateGraph returns [EObject current=null] : iv_rulePlainStateGraph= rulePlainStateGraph EOF ;
    public final EObject entryRulePlainStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4109:2: (iv_rulePlainStateGraph= rulePlainStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4110:2: iv_rulePlainStateGraph= rulePlainStateGraph EOF
            {
             newCompositeNode(grammarAccess.getPlainStateGraphRule()); 
            pushFollow(FOLLOW_rulePlainStateGraph_in_entryRulePlainStateGraph8233);
            iv_rulePlainStateGraph=rulePlainStateGraph();

            state._fsp--;

             current =iv_rulePlainStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlainStateGraph8243); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlainStateGraph"


    // $ANTLR start "rulePlainStateGraph"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4117:1: rulePlainStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' ) ;
    public final EObject rulePlainStateGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_states_2_0 = null;

        EObject lv_trPoints_3_0 = null;

        EObject lv_chPoints_4_0 = null;

        EObject lv_transitions_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4120:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4121:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4121:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4121:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )* otherlv_6= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4121:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4122:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPlainStateGraphAccess().getPlainStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_rulePlainStateGraph8289); 

                	newLeafNode(otherlv_1, grammarAccess.getPlainStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4131:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) )*
            loop105:
            do {
                int alt105=5;
                switch ( input.LA(1) ) {
                case 71:
                case 76:
                    {
                    alt105=1;
                    }
                    break;
                case 77:
                case 78:
                case 79:
                case 80:
                    {
                    alt105=2;
                    }
                    break;
                case 81:
                    {
                    alt105=3;
                    }
                    break;
                case 82:
                    {
                    alt105=4;
                    }
                    break;

                }

                switch (alt105) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4131:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4131:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4132:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4133:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_rulePlainStateGraph8311);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4150:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4150:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4151:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4151:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4152:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_rulePlainStateGraph8338);
            	    lv_trPoints_3_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4169:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4169:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4170:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4170:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4171:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_rulePlainStateGraph8365);
            	    lv_chPoints_4_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4188:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4188:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4189:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4189:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4190:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlainStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_rulePlainStateGraph8392);
            	    lv_transitions_5_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlainStateGraphRule());
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

            	default :
            	    break loop105;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_rulePlainStateGraph8406); 

                	newLeafNode(otherlv_6, grammarAccess.getPlainStateGraphAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlainStateGraph"


    // $ANTLR start "entryRuleStateMachine"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4218:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4219:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4220:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine8442);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine8452); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4227:1: ruleStateMachine returns [EObject current=null] : ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token lv_dataDriven_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_states_4_0 = null;

        EObject lv_trPoints_5_0 = null;

        EObject lv_chPoints_6_0 = null;

        EObject lv_transitions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4230:28: ( ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4231:1: ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4231:1: ( () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4231:2: () ( (lv_dataDriven_1_0= 'data_driven' ) )? otherlv_2= 'StateMachine' otherlv_3= '{' ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )* otherlv_8= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4231:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4232:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateMachineAction_0(),
                        current);
                

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4237:2: ( (lv_dataDriven_1_0= 'data_driven' ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==69) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4238:1: (lv_dataDriven_1_0= 'data_driven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4238:1: (lv_dataDriven_1_0= 'data_driven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4239:3: lv_dataDriven_1_0= 'data_driven'
                    {
                    lv_dataDriven_1_0=(Token)match(input,69,FOLLOW_69_in_ruleStateMachine8504); 

                            newLeafNode(lv_dataDriven_1_0, grammarAccess.getStateMachineAccess().getDataDrivenData_drivenKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateMachineRule());
                    	        }
                           		setWithLastConsumed(current, "dataDriven", true, "data_driven");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleStateMachine8530); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getStateMachineKeyword_2());
                
            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleStateMachine8542); 

                	newLeafNode(otherlv_3, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4260:1: ( ( (lv_states_4_0= ruleState ) ) | ( (lv_trPoints_5_0= ruleTrPoint ) ) | ( (lv_chPoints_6_0= ruleChoicePoint ) ) | ( (lv_transitions_7_0= ruleTransition ) ) )*
            loop107:
            do {
                int alt107=5;
                switch ( input.LA(1) ) {
                case 71:
                case 76:
                    {
                    alt107=1;
                    }
                    break;
                case 77:
                case 78:
                case 79:
                case 80:
                    {
                    alt107=2;
                    }
                    break;
                case 81:
                    {
                    alt107=3;
                    }
                    break;
                case 82:
                    {
                    alt107=4;
                    }
                    break;

                }

                switch (alt107) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4260:2: ( (lv_states_4_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4260:2: ( (lv_states_4_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4261:1: (lv_states_4_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4261:1: (lv_states_4_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4262:3: lv_states_4_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine8564);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_4_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4279:6: ( (lv_trPoints_5_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4279:6: ( (lv_trPoints_5_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4280:1: (lv_trPoints_5_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4280:1: (lv_trPoints_5_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4281:3: lv_trPoints_5_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine8591);
            	    lv_trPoints_5_0=ruleTrPoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"trPoints",
            	            		lv_trPoints_5_0, 
            	            		"TrPoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4298:6: ( (lv_chPoints_6_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4298:6: ( (lv_chPoints_6_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4299:1: (lv_chPoints_6_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4299:1: (lv_chPoints_6_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4300:3: lv_chPoints_6_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine8618);
            	    lv_chPoints_6_0=ruleChoicePoint();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"chPoints",
            	            		lv_chPoints_6_0, 
            	            		"ChoicePoint");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4317:6: ( (lv_transitions_7_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4317:6: ( (lv_transitions_7_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4318:1: (lv_transitions_7_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4318:1: (lv_transitions_7_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4319:3: lv_transitions_7_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_4_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine8645);
            	    lv_transitions_7_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateMachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_7_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleStateMachine8659); 

                	newLeafNode(otherlv_8, grammarAccess.getStateMachineAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4347:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4348:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4349:2: iv_ruleSimpleState= ruleSimpleState EOF
            {
             newCompositeNode(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_ruleSimpleState_in_entryRuleSimpleState8695);
            iv_ruleSimpleState=ruleSimpleState();

            state._fsp--;

             current =iv_ruleSimpleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleState8705); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4356:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4359:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4360:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4360:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4360:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleSimpleState8742); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4364:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4365:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4365:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4366:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleState8759); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4382:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==94) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4383:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4383:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4384:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSimpleState8785);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4400:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}' )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==13) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4400:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleSimpleState8799); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4404:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==72) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4404:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,72,FOLLOW_72_in_ruleSimpleState8812); 

                                	newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4408:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4409:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4409:1: (lv_entryCode_5_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4410:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState8833);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4426:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==73) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4426:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,73,FOLLOW_73_in_ruleSimpleState8848); 

                                	newLeafNode(otherlv_6, grammarAccess.getSimpleStateAccess().getExitKeyword_3_2_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4430:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4431:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4431:1: (lv_exitCode_7_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4432:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState8869);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4448:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==74) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4448:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,74,FOLLOW_74_in_ruleSimpleState8884); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDoKeyword_3_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4452:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4453:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4453:1: (lv_doCode_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4454:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState8905);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4470:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==75) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4470:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= rulePlainStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,75,FOLLOW_75_in_ruleSimpleState8920); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4474:1: ( (lv_subgraph_11_0= rulePlainStateGraph ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4475:1: (lv_subgraph_11_0= rulePlainStateGraph )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4475:1: (lv_subgraph_11_0= rulePlainStateGraph )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4476:3: lv_subgraph_11_0= rulePlainStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphPlainStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_rulePlainStateGraph_in_ruleSimpleState8941);
                            lv_subgraph_11_0=rulePlainStateGraph();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"subgraph",
                                    		lv_subgraph_11_0, 
                                    		"PlainStateGraph");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleSimpleState8955); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4504:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4505:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4506:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             newCompositeNode(grammarAccess.getRefinedStateRule()); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState8993);
            iv_ruleRefinedState=ruleRefinedState();

            state._fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState9003); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4513:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4516:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4517:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4517:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4517:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_76_in_ruleRefinedState9040); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4521:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4522:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4522:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4523:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedStateRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedStateAccess().getTargetStateCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState9063);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4536:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==94) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4537:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4537:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4538:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedState9084);
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRefinedState9097); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4558:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==72) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4558:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,72,FOLLOW_72_in_ruleRefinedState9110); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4562:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4563:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4563:1: (lv_entryCode_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4564:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9131);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4580:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==73) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4580:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,73,FOLLOW_73_in_ruleRefinedState9146); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4584:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4585:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4585:1: (lv_exitCode_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4586:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9167);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4602:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==74) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4602:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,74,FOLLOW_74_in_ruleRefinedState9182); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4606:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4607:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4607:1: (lv_doCode_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4608:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState9203);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4624:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==75) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4624:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,75,FOLLOW_75_in_ruleRefinedState9218); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4628:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4629:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4629:1: (lv_subgraph_11_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4630:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState9239);
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

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleRefinedState9253); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4658:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4659:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4660:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             newCompositeNode(grammarAccess.getDetailCodeRule()); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode9289);
            iv_ruleDetailCode=ruleDetailCode();

            state._fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode9299); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4667:1: ruleDetailCode returns [EObject current=null] : (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_commands_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4670:28: ( (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4671:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4671:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4671:3: otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleDetailCode9336); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4675:1: ( (lv_commands_1_0= RULE_STRING ) )+
            int cnt119=0;
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==RULE_STRING) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4676:1: (lv_commands_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4676:1: (lv_commands_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4677:3: lv_commands_1_0= RULE_STRING
            	    {
            	    lv_commands_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode9353); 

            	    			newLeafNode(lv_commands_1_0, grammarAccess.getDetailCodeAccess().getCommandsSTRINGTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDetailCodeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"commands",
            	            		lv_commands_1_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt119 >= 1 ) break loop119;
                        EarlyExitException eee =
                            new EarlyExitException(119, input);
                        throw eee;
                }
                cnt119++;
            } while (true);

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleDetailCode9371); 

                	newLeafNode(otherlv_2, grammarAccess.getDetailCodeAccess().getRightCurlyBracketKeyword_2());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4705:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4706:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4707:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint9407);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint9417); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4714:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4717:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4718:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4718:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt120=3;
            switch ( input.LA(1) ) {
            case 77:
            case 78:
                {
                alt120=1;
                }
                break;
            case 79:
                {
                alt120=2;
                }
                break;
            case 80:
                {
                alt120=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint9464);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;

                     
                            current = this_TransitionPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4729:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint9491);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;

                     
                            current = this_EntryPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4739:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint9518);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4755:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4756:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4757:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint9553);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint9563); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4764:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4767:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4768:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4768:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4768:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4768:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==77) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4769:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4769:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,77,FOLLOW_77_in_ruleTransitionPoint9606); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,78,FOLLOW_78_in_ruleTransitionPoint9632); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4787:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4788:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4788:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4789:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint9649); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4813:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4814:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4815:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint9690);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint9700); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4822:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4825:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4826:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4826:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4826:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,79,FOLLOW_79_in_ruleEntryPoint9737); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4830:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4831:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4831:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4832:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint9754); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4856:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4857:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4858:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint9795);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint9805); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4865:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4868:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4869:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4869:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4869:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,80,FOLLOW_80_in_ruleExitPoint9842); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4873:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4874:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4874:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4875:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint9859); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4899:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4900:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4901:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint9900);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint9910); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4908:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4911:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4912:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4912:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4912:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_81_in_ruleChoicePoint9947); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4916:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4917:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4917:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4918:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint9964); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4934:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==94) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4935:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4935:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4936:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint9990);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4960:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4961:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4962:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition10027);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition10037); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4969:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4972:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4973:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4973:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==82) ) {
                int LA123_1 = input.LA(2);

                if ( (LA123_1==RULE_ID) ) {
                    int LA123_2 = input.LA(3);

                    if ( (LA123_2==15) ) {
                        int LA123_3 = input.LA(4);

                        if ( (LA123_3==RULE_ID||(LA123_3>=89 && LA123_3<=90)) ) {
                            alt123=2;
                        }
                        else if ( (LA123_3==83) ) {
                            alt123=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 123, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 123, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA123_1==15) ) {
                    int LA123_3 = input.LA(3);

                    if ( (LA123_3==RULE_ID||(LA123_3>=89 && LA123_3<=90)) ) {
                        alt123=2;
                    }
                    else if ( (LA123_3==83) ) {
                        alt123=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 123, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 123, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4974:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition10084);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;

                     
                            current = this_InitialTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4984:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition10111);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5000:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5001:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5002:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition10146);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition10156); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5009:1: ruleNonInitialTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;

        EObject this_ContinuationTransition_2 = null;

        EObject this_CPBranchTransition_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5012:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5013:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5013:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )
            int alt124=4;
            alt124 = dfa124.predict(input);
            switch (alt124) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5014:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition10203);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5024:5: this_GuardedTransition_1= ruleGuardedTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getGuardedTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGuardedTransition_in_ruleNonInitialTransition10230);
                    this_GuardedTransition_1=ruleGuardedTransition();

                    state._fsp--;

                     
                            current = this_GuardedTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5034:5: this_ContinuationTransition_2= ruleContinuationTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition10257);
                    this_ContinuationTransition_2=ruleContinuationTransition();

                    state._fsp--;

                     
                            current = this_ContinuationTransition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5044:5: this_CPBranchTransition_3= ruleCPBranchTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition10284);
                    this_CPBranchTransition_3=ruleCPBranchTransition();

                    state._fsp--;

                     
                            current = this_CPBranchTransition_3; 
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


    // $ANTLR start "entryRuleInitialTransition"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5060:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5061:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5062:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition10319);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition10329); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5069:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5072:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleInitialTransition10366); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5077:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_ID) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5078:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5078:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5079:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition10383); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleInitialTransition10401); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,83,FOLLOW_83_in_ruleInitialTransition10413); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleInitialTransition10425); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5107:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5108:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5108:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5109:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition10446);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5125:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==94) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5126:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5126:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5127:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition10467);
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

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleInitialTransition10480); 

                	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5147:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==84) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5147:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,84,FOLLOW_84_in_ruleInitialTransition10493); 

                        	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5151:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5152:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5152:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5153:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition10514);
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

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleInitialTransition10528); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5181:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5182:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5183:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition10564);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition10574); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5190:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5193:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5194:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5194:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5194:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleContinuationTransition10611); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5198:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==RULE_ID) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5199:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5199:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5200:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition10628); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleContinuationTransition10646); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5220:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5221:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5221:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5222:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10667);
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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleContinuationTransition10679); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5242:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5243:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5243:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5244:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10700);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5260:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==94) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5261:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5261:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5262:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition10721);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5278:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==13) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5278:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleContinuationTransition10735); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5282:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==84) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5282:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,84,FOLLOW_84_in_ruleContinuationTransition10748); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5286:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5287:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5287:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5288:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition10769);
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

                    otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleContinuationTransition10783); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5316:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5317:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5318:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition10821);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition10831); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5325:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5328:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5329:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5329:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5329:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleTriggeredTransition10868); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5333:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==RULE_ID) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5334:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5334:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5335:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition10885); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleTriggeredTransition10903); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5355:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5356:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5356:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5357:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10924);
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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTriggeredTransition10936); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5377:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5378:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5378:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5379:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10957);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5395:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==94) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5396:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5396:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5397:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition10978);
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

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition10991); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,85,FOLLOW_85_in_ruleTriggeredTransition11003); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition11015); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5425:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5426:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5426:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5427:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition11036);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5443:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==86) ) {
                    alt134=1;
                }


                switch (alt134) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5443:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,86,FOLLOW_86_in_ruleTriggeredTransition11049); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5447:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5448:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5448:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5449:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition11070);
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
            	    break loop134;
                }
            } while (true);

            otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleTriggeredTransition11084); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5469:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==84) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5469:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,84,FOLLOW_84_in_ruleTriggeredTransition11097); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5473:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5474:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5474:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5475:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition11118);
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

            otherlv_16=(Token)match(input,14,FOLLOW_14_in_ruleTriggeredTransition11132); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5503:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5504:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5505:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition11168);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardedTransition11178); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5512:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5515:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5516:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5516:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5516:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleGuardedTransition11215); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5520:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==RULE_ID) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5521:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5521:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5522:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuardedTransition11232); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleGuardedTransition11250); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5542:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5543:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5543:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5544:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11271);
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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleGuardedTransition11283); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5564:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5565:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5565:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5566:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11304);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5582:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==94) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5583:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5583:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5584:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleGuardedTransition11325);
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

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleGuardedTransition11338); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,87,FOLLOW_87_in_ruleGuardedTransition11350); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5608:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5609:1: (lv_guard_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5609:1: (lv_guard_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5610:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition11371);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5626:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==84) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5626:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,84,FOLLOW_84_in_ruleGuardedTransition11384); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5630:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5631:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5631:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5632:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition11405);
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

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleGuardedTransition11419); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5660:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5661:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5662:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition11455);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition11465); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5669:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5672:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5673:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5673:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5673:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleCPBranchTransition11502); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5677:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==RULE_ID) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5678:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5678:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5679:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition11519); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleCPBranchTransition11537); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5699:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5700:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5700:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5701:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11558);
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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleCPBranchTransition11570); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5721:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5722:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5722:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5723:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11591);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5739:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==94) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5740:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5740:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5741:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition11612);
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

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleCPBranchTransition11625); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,88,FOLLOW_88_in_ruleCPBranchTransition11637); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5765:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5766:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5766:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5767:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11658);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5783:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==84) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5783:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,84,FOLLOW_84_in_ruleCPBranchTransition11671); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5787:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5788:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5788:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5789:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11692);
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

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleCPBranchTransition11706); 

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


    // $ANTLR start "entryRuleTransitionTerminal"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5817:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5818:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5819:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal11742);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal11752); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5826:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5829:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5830:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5830:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt142=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA142_1 = input.LA(2);

                if ( (LA142_1==56) ) {
                    alt142=3;
                }
                else if ( (LA142_1==EOF||(LA142_1>=13 && LA142_1<=14)||LA142_1==18||LA142_1==71||(LA142_1>=76 && LA142_1<=82)||LA142_1==94) ) {
                    alt142=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 142, 1, input);

                    throw nvae;
                }
                }
                break;
            case 89:
                {
                alt142=2;
                }
                break;
            case 90:
                {
                alt142=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }

            switch (alt142) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5831:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal11799);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;

                     
                            current = this_StateTerminal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5841:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal11826);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5851:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal11853);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5861:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal11880);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5877:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5878:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5879:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal11915);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal11925); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5886:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5889:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5890:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5890:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5891:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5891:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5892:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal11969); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5911:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5912:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5913:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal12004);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal12014); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5920:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5923:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_89_in_ruleTrPointTerminal12051); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5928:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5929:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5929:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5930:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrPointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal12071); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5949:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5950:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5951:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal12107);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal12117); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5958:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5961:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5962:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5963:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5963:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5964:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12162); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleSubStateTrPointTerminal12174); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5979:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5980:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5980:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5981:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12194); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6000:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6001:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6002:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal12230);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal12240); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6009:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6012:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6013:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,90,FOLLOW_90_in_ruleChoicepointTerminal12277); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6017:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6018:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6018:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6019:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal12297); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6038:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6039:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6040:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger12333);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger12343); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6047:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6050:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6051:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6051:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6051:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_91_in_ruleTrigger12380); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6055:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6056:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6056:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6057:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger12401);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6073:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop143:
            do {
                int alt143=2;
                int LA143_0 = input.LA(1);

                if ( (LA143_0==92) ) {
                    alt143=1;
                }


                switch (alt143) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6073:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,92,FOLLOW_92_in_ruleTrigger12414); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6077:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6078:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6078:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6079:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger12435);
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
            	    break loop143;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6095:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==87) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6096:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6096:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6097:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger12458);
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

            otherlv_5=(Token)match(input,93,FOLLOW_93_in_ruleTrigger12471); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6125:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6126:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6127:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf12507);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf12517); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6134:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6137:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6139:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6139:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6140:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf12562); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageMessageCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMessageFromIf12574); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6155:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6156:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6156:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6157:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf12594); 

            		newLeafNode(otherlv_2, grammarAccess.getMessageFromIfAccess().getFromInterfaceItemCrossReference_2_0()); 
            	

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6176:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6177:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6178:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard12630);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard12640); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6185:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6188:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6189:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6189:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6189:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,87,FOLLOW_87_in_ruleGuard12677); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6193:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6194:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6194:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6195:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard12698);
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


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6219:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6220:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6221:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation12734);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation12744); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6228:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6231:28: ( (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6232:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6232:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6232:3: otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_94_in_ruleDocumentation12781); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6236:1: ( (lv_text_1_0= RULE_STRING ) )+
            int cnt145=0;
            loop145:
            do {
                int alt145=2;
                int LA145_0 = input.LA(1);

                if ( (LA145_0==RULE_STRING) ) {
                    alt145=1;
                }


                switch (alt145) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6237:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6237:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6238:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation12798); 

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
            	    if ( cnt145 >= 1 ) break loop145;
                        EarlyExitException eee =
                            new EarlyExitException(145, input);
                        throw eee;
                }
                cnt145++;
            } while (true);

            otherlv_2=(Token)match(input,95,FOLLOW_95_in_ruleDocumentation12816); 

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


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6266:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6267:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6268:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation12852);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation12862); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6275:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6278:28: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6279:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6279:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6279:3: otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,96,FOLLOW_96_in_ruleAnnotation12899); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6283:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6284:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6284:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6285:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotation12916); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6301:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==19) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6301:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleAnnotation12934); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6305:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6306:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6306:1: (lv_attributes_3_0= ruleKeyValue )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6307:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation12955);
                    lv_attributes_3_0=ruleKeyValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	        }
                           		add(
                           			current, 
                           			"attributes",
                            		lv_attributes_3_0, 
                            		"KeyValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6323:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop146:
                    do {
                        int alt146=2;
                        int LA146_0 = input.LA(1);

                        if ( (LA146_0==31) ) {
                            alt146=1;
                        }


                        switch (alt146) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6323:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleAnnotation12968); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6327:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6328:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6328:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6329:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation12989);
                    	    lv_attributes_5_0=ruleKeyValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_5_0, 
                    	            		"KeyValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop146;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleAnnotation13003); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6357:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6358:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6359:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue13041);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue13051); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6366:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6369:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6370:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6370:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6370:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6370:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6371:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6371:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6372:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue13093); 

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

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleKeyValue13110); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6392:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6393:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6393:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6394:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyValue13127); 

            			newLeafNode(lv_value_2_0, grammarAccess.getKeyValueAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
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
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6418:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6419:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6420:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport13168);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport13178); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6427:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6430:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6431:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6431:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6431:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_97_in_ruleImport13215); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6435:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==RULE_ID) ) {
                alt148=1;
            }
            else if ( (LA148_0==99) ) {
                alt148=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }
            switch (alt148) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6435:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6435:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6435:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6435:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6436:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6436:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6437:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport13238);
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

                    otherlv_2=(Token)match(input,98,FOLLOW_98_in_ruleImport13250); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6458:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,99,FOLLOW_99_in_ruleImport13269); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6462:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6463:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6463:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6464:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport13287); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6488:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6489:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6490:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN13329);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN13340); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6497:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6500:28: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6501:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6501:1: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6502:5: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN13387);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6512:1: (kw= '.' kw= '*' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==62) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6513:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleImportedFQN13406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0()); 
                        
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleImportedFQN13419); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1()); 
                        

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6532:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6533:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6534:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN13462);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN13473); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6541:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6544:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6545:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6545:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6545:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN13513); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6552:1: (kw= '.' this_ID_2= RULE_ID )*
            loop150:
            do {
                int alt150=2;
                int LA150_0 = input.LA(1);

                if ( (LA150_0==62) ) {
                    int LA150_2 = input.LA(2);

                    if ( (LA150_2==RULE_ID) ) {
                        alt150=1;
                    }


                }


                switch (alt150) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6553:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleFQN13532); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN13547); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop150;
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


    protected DFA124 dfa124 = new DFA124(this);
    static final String DFA124_eotS =
        "\33\uffff";
    static final String DFA124_eofS =
        "\14\uffff\1\22\6\uffff\3\22\4\uffff\1\22";
    static final String DFA124_minS =
        "\1\122\1\4\1\17\1\4\1\22\4\4\3\22\1\15\3\4\1\5\1\16\1\uffff\3\15"+
        "\1\5\3\uffff\1\15";
    static final String DFA124_maxS =
        "\1\122\2\17\1\132\1\70\3\4\1\132\3\22\1\136\3\4\1\5\1\130\1\uffff"+
        "\3\136\1\137\3\uffff\1\122";
    static final String DFA124_acceptS =
        "\22\uffff\1\3\4\uffff\1\1\1\2\1\4\1\uffff";
    static final String DFA124_specialS =
        "\33\uffff}>";
    static final String[] DFA124_transitionS = {
            "\1\1",
            "\1\2\12\uffff\1\3",
            "\1\3",
            "\1\4\124\uffff\1\5\1\6",
            "\1\10\45\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\124\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\21\1\22\51\uffff\1\17\16\uffff\1\22\4\uffff\7\22\13\uffff"+
            "\1\20",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\22\105\uffff\1\22\1\27\1\uffff\1\30\1\31",
            "",
            "\1\21\1\22\70\uffff\1\22\4\uffff\7\22\13\uffff\1\20",
            "\1\21\1\22\70\uffff\1\22\4\uffff\7\22\13\uffff\1\20",
            "\1\21\1\22\70\uffff\1\22\4\uffff\7\22\13\uffff\1\20",
            "\1\26\131\uffff\1\32",
            "",
            "",
            "",
            "\1\21\1\22\70\uffff\1\22\4\uffff\7\22"
    };

    static final short[] DFA124_eot = DFA.unpackEncodedString(DFA124_eotS);
    static final short[] DFA124_eof = DFA.unpackEncodedString(DFA124_eofS);
    static final char[] DFA124_min = DFA.unpackEncodedStringToUnsignedChars(DFA124_minS);
    static final char[] DFA124_max = DFA.unpackEncodedStringToUnsignedChars(DFA124_maxS);
    static final short[] DFA124_accept = DFA.unpackEncodedString(DFA124_acceptS);
    static final short[] DFA124_special = DFA.unpackEncodedString(DFA124_specialS);
    static final short[][] DFA124_transition;

    static {
        int numStates = DFA124_transitionS.length;
        DFA124_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA124_transition[i] = DFA.unpackEncodedString(DFA124_transitionS[i]);
        }
    }

    class DFA124 extends DFA {

        public DFA124(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 124;
            this.eot = DFA124_eot;
            this.eof = DFA124_eof;
            this.min = DFA124_min;
            this.max = DFA124_max;
            this.accept = DFA124_accept;
            this.special = DFA124_special;
            this.transition = DFA124_transition;
        }
        public String getDescription() {
            return "5013:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition | this_ContinuationTransition_2= ruleContinuationTransition | this_CPBranchTransition_3= ruleCPBranchTransition )";
        }
    }
 

    public static final BitSet FOLLOW_ruleRoomModel_in_entryRuleRoomModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoomModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleRoomModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRoomModel143 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRoomModel164 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRoomModel177 = new BitSet(new long[]{0x0A00600400C24000L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoomModel198 = new BitSet(new long[]{0x0A00600400C24000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleRoomModel221 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleRoomModel248 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleRoomModel275 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_ruleRoomModel302 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleRoomModel329 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleRoomModel356 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleRoomModel383 = new BitSet(new long[]{0x0A00600400C24000L});
    public static final BitSet FOLLOW_14_in_ruleRoomModel397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructureClass_in_entryRuleStructureClass435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructureClass445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_ruleStructureClass492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleStructureClass519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorContainerClass_in_entryRuleActorContainerClass554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorContainerClass564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleActorContainerClass611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleActorContainerClass638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarDecl_in_entryRuleVarDecl673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarDecl683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarDecl725 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVarDecl742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVarDecl765 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleVarDecl783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleDataType890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_ruleDataType917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_entryRuleComplexType952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexType962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleComplexType1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleComplexType1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1071 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrimitiveType1118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimitiveType1135 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrimitiveType1152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1173 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_rulePrimitiveType1186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1207 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulePrimitiveType1219 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePrimitiveType1233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePrimitiveType1250 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePrimitiveType1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_entryRuleExternalType1313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalType1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleExternalType1360 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalType1377 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleExternalType1394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleExternalType1415 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleExternalType1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_entryRuleDataClass1473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataClass1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDataClass1520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataClass1537 = new BitSet(new long[]{0x0000000001002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleDataClass1563 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleDataClass1577 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataClass1600 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDataClass1614 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_25_in_ruleDataClass1627 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1648 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_26_in_ruleDataClass1663 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1684 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_27_in_ruleDataClass1699 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1720 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleDataClass1743 = new BitSet(new long[]{0x000000005E004000L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleDataClass1765 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_14_in_ruleDataClass1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAttribute1861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1878 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_RULE_MULTIPLICITY_in_ruleAttribute1900 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttribute1918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleAttribute1941 = new BitSet(new long[]{0x0000000020010002L,0x0000000040000000L});
    public static final BitSet FOLLOW_16_in_ruleAttribute1959 = new BitSet(new long[]{0x0000000020000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_29_in_ruleAttribute1986 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute2003 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleAttribute2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStandardOperation2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleStandardOperation2117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStandardOperation2134 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleStandardOperation2151 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2173 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleStandardOperation2186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2207 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleStandardOperation2223 = new BitSet(new long[]{0x000000000000A000L,0x0000000040000000L});
    public static final BitSet FOLLOW_15_in_ruleStandardOperation2236 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_32_in_ruleStandardOperation2249 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleStandardOperation2279 = new BitSet(new long[]{0x0000000000012000L,0x0000000040000000L});
    public static final BitSet FOLLOW_16_in_ruleStandardOperation2297 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleStandardOperation2336 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleStandardOperation2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortOperation_in_entryRulePortOperation2394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortOperation2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePortOperation2441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2458 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePortOperation2475 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2497 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_rulePortOperation2510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2531 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_rulePortOperation2547 = new BitSet(new long[]{0x000000020000A000L,0x0000000040000000L});
    public static final BitSet FOLLOW_15_in_rulePortOperation2561 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_32_in_rulePortOperation2574 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePortOperation2604 = new BitSet(new long[]{0x0000000000012000L,0x0000000040000000L});
    public static final BitSet FOLLOW_16_in_rulePortOperation2622 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_33_in_rulePortOperation2658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2678 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePortOperation2702 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortOperation2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClass2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleProtocolClass2807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProtocolClass2824 = new BitSet(new long[]{0x0000000001002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleProtocolClass2850 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClass2864 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClass2887 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass2901 = new BitSet(new long[]{0x000010B80E004000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClass2914 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass2935 = new BitSet(new long[]{0x000010B80C004000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClass2950 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass2971 = new BitSet(new long[]{0x000010B808004000L});
    public static final BitSet FOLLOW_27_in_ruleProtocolClass2986 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass3007 = new BitSet(new long[]{0x000010B800004000L});
    public static final BitSet FOLLOW_35_in_ruleProtocolClass3022 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3034 = new BitSet(new long[]{0x0000030000004000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3055 = new BitSet(new long[]{0x0000030000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3068 = new BitSet(new long[]{0x000010B000004000L});
    public static final BitSet FOLLOW_36_in_ruleProtocolClass3083 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3095 = new BitSet(new long[]{0x0000030000004000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3116 = new BitSet(new long[]{0x0000030000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3129 = new BitSet(new long[]{0x000010A000004000L});
    public static final BitSet FOLLOW_37_in_ruleProtocolClass3144 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleProtocolClass3156 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3177 = new BitSet(new long[]{0x0000108000004000L});
    public static final BitSet FOLLOW_39_in_ruleProtocolClass3192 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleProtocolClass3204 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3225 = new BitSet(new long[]{0x0000100000004000L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3248 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleProtocolClass3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage3297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleMessage3350 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleMessage3376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage3393 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMessage3410 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleMessage3431 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMessage3444 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleMessage3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClass_in_entryRulePortClass3502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClass3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePortClass3549 = new BitSet(new long[]{0x00000C005E000000L});
    public static final BitSet FOLLOW_42_in_rulePortClass3562 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortClass3583 = new BitSet(new long[]{0x00000C005E000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_rulePortClass3607 = new BitSet(new long[]{0x00000C005E004000L});
    public static final BitSet FOLLOW_rulePortOperation_in_rulePortClass3634 = new BitSet(new long[]{0x00000C005E004000L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_rulePortClass3661 = new BitSet(new long[]{0x00000C005E004000L});
    public static final BitSet FOLLOW_14_in_rulePortClass3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler3711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageHandler3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleMessageHandler3758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageHandler3778 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleMessageHandler3799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics3835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolSemantics3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleProtocolSemantics3891 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolSemantics3903 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics3924 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleProtocolSemantics3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule3973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSemanticsRule4028 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleSemanticsRule4041 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSemanticsRule4082 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4103 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSemanticsRule4116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleSemanticsRule4137 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleSemanticsRule4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_entryRuleActorClass4191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClass4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleActorClass4244 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleActorClass4270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClass4287 = new BitSet(new long[]{0x0000000001002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4313 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_24_in_ruleActorClass4327 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClass4350 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4364 = new BitSet(new long[]{0x0003800000004000L});
    public static final BitSet FOLLOW_47_in_ruleActorClass4377 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4389 = new BitSet(new long[]{0x004C000000004000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass4410 = new BitSet(new long[]{0x004C000000004000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleActorClass4432 = new BitSet(new long[]{0x0040000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4445 = new BitSet(new long[]{0x0003000000004000L});
    public static final BitSet FOLLOW_48_in_ruleActorClass4460 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4481 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4494 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_25_in_ruleActorClass4507 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4528 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_26_in_ruleActorClass4543 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4564 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_27_in_ruleActorClass4579 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass4600 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass4624 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExternalPort_in_ruleActorClass4651 = new BitSet(new long[]{0x80BC00001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_ruleActorClass4674 = new BitSet(new long[]{0x80A000001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSAPRef_in_ruleActorClass4696 = new BitSet(new long[]{0x802000001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleActorClass4718 = new BitSet(new long[]{0x800000001E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleActorClass4740 = new BitSet(new long[]{0x8000000000004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleActorClass4762 = new BitSet(new long[]{0x8000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleActorClass4784 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4797 = new BitSet(new long[]{0x0002000000004000L});
    public static final BitSet FOLLOW_49_in_ruleActorClass4812 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass4833 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass4846 = new BitSet(new long[]{0x0000000040004000L,0x0000000100000060L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleActorClass4867 = new BitSet(new long[]{0x0000000040004000L,0x0000000100000060L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleActorClass4889 = new BitSet(new long[]{0x0000000040004000L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleActorClass4911 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4924 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorClass4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort4976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rulePort5029 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_rulePort5055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePort5072 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_RULE_MULTIPLICITY_in_rulePort5094 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePort5112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePort5135 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePort5156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalPort_in_entryRuleExternalPort5193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalPort5203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleExternalPort5240 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleExternalPort5252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalPort5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPRef_in_entryRuleSAPRef5308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPRef5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSAPRef5355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSAPRef5372 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSAPRef5389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSAPRef5412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPRef_in_entryRuleSPPRef5448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPRef5458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleSPPRef5495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPRef5512 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSPPRef5529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSPPRef5552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation5588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleServiceImplementation5598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleServiceImplementation5635 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleServiceImplementation5647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleServiceImplementation5667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem5703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalSystem5713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleLogicalSystem5750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalSystem5767 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleLogicalSystem5793 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalSystem5806 = new BitSet(new long[]{0x8400000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem5827 = new BitSet(new long[]{0x8400000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleLogicalSystem5849 = new BitSet(new long[]{0x8000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleLogicalSystem5871 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleLogicalSystem5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef5922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemRef5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSubSystemRef5969 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemRef5986 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubSystemRef6003 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemRef6026 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemRef6047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass6084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemClass6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSubSystemClass6131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemClass6148 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemClass6174 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemClass6187 = new BitSet(new long[]{0x904C00000E004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_25_in_ruleSubSystemClass6200 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6221 = new BitSet(new long[]{0x904C00000C004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_26_in_ruleSubSystemClass6236 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6257 = new BitSet(new long[]{0x904C000008004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_27_in_ruleSubSystemClass6272 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass6293 = new BitSet(new long[]{0x904C000000004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_rulePort_in_ruleSubSystemClass6316 = new BitSet(new long[]{0x904C000000004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleSubSystemClass6338 = new BitSet(new long[]{0x9040000000004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleSubSystemClass6360 = new BitSet(new long[]{0x9000000000004000L,0x0000000000000012L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleSubSystemClass6382 = new BitSet(new long[]{0x9000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleSubSystemClass6404 = new BitSet(new long[]{0x1000000000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_ruleSubSystemClass6426 = new BitSet(new long[]{0x1000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemClass6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread6475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalThread6485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleLogicalThread6522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalThread6539 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleLogicalThread6556 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleLogicalThread6568 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLogicalThread6585 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalThread6602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6623 = new BitSet(new long[]{0x0000000080004000L});
    public static final BitSet FOLLOW_31_in_ruleLogicalThread6636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread6657 = new BitSet(new long[]{0x0000000080004000L});
    public static final BitSet FOLLOW_14_in_ruleLogicalThread6671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath6707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstancePath6717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath6759 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleActorInstancePath6777 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath6794 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding6837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding6847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleBinding6884 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding6905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleBinding6917 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding6938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint6974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingEndPoint6984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint7030 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleBindingEndPoint7042 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection7100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerConnection7110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLayerConnection7147 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleSAPoint_in_ruleLayerConnection7168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleLayerConnection7180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSPPoint_in_ruleLayerConnection7201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPoint_in_entryRuleSAPoint7237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPoint7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_ruleSAPoint7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_ruleSAPoint7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint7356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefSAPoint7366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleRefSAPoint7403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefSAPoint7423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint7459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelaySAPoint7469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRelaySAPoint7506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelaySAPoint7526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPoint_in_entryRuleSPPoint7562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPoint7572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint7617 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSPPoint7629 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint7649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorRef_in_entryRuleActorRef7685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorRef7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleActorRef7732 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorRef7749 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleActorRef7766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorRef7789 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorRef7810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode7847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode7857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode7904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode7931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode7958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState7995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState8005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_ruleState8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState8079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph8114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph8124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_ruleStateGraph8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleStateGraph8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_entryRulePlainStateGraph8233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlainStateGraph8243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePlainStateGraph8289 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleState_in_rulePlainStateGraph8311 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleTrPoint_in_rulePlainStateGraph8338 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_rulePlainStateGraph8365 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleTransition_in_rulePlainStateGraph8392 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_14_in_rulePlainStateGraph8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine8442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine8452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleStateMachine8504 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleStateMachine8530 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStateMachine8542 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine8564 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine8591 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine8618 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine8645 = new BitSet(new long[]{0x0000000000004000L,0x000000000007F080L});
    public static final BitSet FOLLOW_14_in_ruleStateMachine8659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState8695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState8705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleSimpleState8742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState8759 = new BitSet(new long[]{0x0000000000002002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSimpleState8785 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleSimpleState8799 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_72_in_ruleSimpleState8812 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState8833 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_73_in_ruleSimpleState8848 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState8869 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_74_in_ruleSimpleState8884 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState8905 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleSimpleState8920 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePlainStateGraph_in_ruleSimpleState8941 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleState8955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState8993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState9003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleRefinedState9040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState9063 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedState9084 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedState9097 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_72_in_ruleRefinedState9110 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9131 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_73_in_ruleRefinedState9146 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9167 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_74_in_ruleRefinedState9182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState9203 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleRefinedState9218 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState9239 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRefinedState9253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode9289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode9299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleDetailCode9336 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode9353 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleDetailCode9371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint9407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint9417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint9464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint9491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint9518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint9553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint9563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleTransitionPoint9606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleTransitionPoint9632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint9649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint9690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint9700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleEntryPoint9737 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint9754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint9795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleExitPoint9842 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint9859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint9900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint9910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleChoicePoint9947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint9964 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint9990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition10027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition10037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition10084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition10111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition10146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition10156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleNonInitialTransition10203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_ruleNonInitialTransition10230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition10257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition10284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition10319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition10329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleInitialTransition10366 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition10383 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInitialTransition10401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_ruleInitialTransition10413 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleInitialTransition10425 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition10446 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition10467 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInitialTransition10480 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleInitialTransition10493 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition10514 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInitialTransition10528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition10564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition10574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleContinuationTransition10611 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition10628 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleContinuationTransition10646 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10667 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleContinuationTransition10679 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition10700 = new BitSet(new long[]{0x0000000000002002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition10721 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleContinuationTransition10735 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleContinuationTransition10748 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition10769 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleContinuationTransition10783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition10821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition10831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTriggeredTransition10868 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition10885 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTriggeredTransition10903 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10924 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTriggeredTransition10936 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition10957 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition10978 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition10991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleTriggeredTransition11003 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition11015 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition11036 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleTriggeredTransition11049 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition11070 = new BitSet(new long[]{0x0000000000004000L,0x0000000000400000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition11084 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleTriggeredTransition11097 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition11118 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition11132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition11168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardedTransition11178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleGuardedTransition11215 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuardedTransition11232 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGuardedTransition11250 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11271 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleGuardedTransition11283 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition11304 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleGuardedTransition11325 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGuardedTransition11338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleGuardedTransition11350 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition11371 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleGuardedTransition11384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition11405 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGuardedTransition11419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition11455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition11465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleCPBranchTransition11502 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition11519 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCPBranchTransition11537 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11558 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCPBranchTransition11570 = new BitSet(new long[]{0x0000000000000010L,0x0000000006000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition11591 = new BitSet(new long[]{0x0000000000002000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition11612 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCPBranchTransition11625 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_ruleCPBranchTransition11637 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11658 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleCPBranchTransition11671 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition11692 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCPBranchTransition11706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal11742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal11752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal11799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal11826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal11853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal11880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal11915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal11925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal11969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal12004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleTrPointTerminal12051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal12071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal12107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal12117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12162 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleSubStateTrPointTerminal12174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal12194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal12230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal12240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleChoicepointTerminal12277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal12297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger12333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger12343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleTrigger12380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger12401 = new BitSet(new long[]{0x0000000000000000L,0x0000000030800000L});
    public static final BitSet FOLLOW_92_in_ruleTrigger12414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger12435 = new BitSet(new long[]{0x0000000000000000L,0x0000000030800000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger12458 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ruleTrigger12471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf12507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf12517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf12562 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMessageFromIf12574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf12594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard12630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard12640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleGuard12677 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard12698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation12734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation12744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleDocumentation12781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation12798 = new BitSet(new long[]{0x0000000000000020L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleDocumentation12816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation12852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation12862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleAnnotation12899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation12916 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleAnnotation12934 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation12955 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_31_in_ruleAnnotation12968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation12989 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_ruleAnnotation13003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue13041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue13051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue13093 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleKeyValue13110 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyValue13127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport13168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport13178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleImport13215 = new BitSet(new long[]{0x0000000000000010L,0x0000000800000000L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport13238 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleImport13250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_99_in_ruleImport13269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport13287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN13329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN13340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN13387 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleImportedFQN13406 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleImportedFQN13419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN13462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN13473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN13513 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleFQN13532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN13547 = new BitSet(new long[]{0x4000000000000002L});

}