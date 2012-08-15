package org.eclipse.etrice.core.parser.antlr.internal; 

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
import org.eclipse.etrice.core.services.RoomGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoomParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'='", "'Operation'", "'~'", "','", "'void'", "'sends'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugate'", "'CompoundProtocolClass'", "'SubProtocol'", "'private'", "'Message'", "'usercode'", "'handle'", "'semantics'", "'in'", "'out'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'conjugated'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'of'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'prio'", "'.'", "'Binding'", "'and'", "'sub'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'@'", "'import'", "'from'", "'model'", "'.*'", "'*'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'eventdriven'", "'datadriven'", "'sync'", "'async'"
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
    public static final int T__11=11;
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
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
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
    public static final int T__114=114;
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
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__113=113;
    public static final int T__112=112;
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
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:68:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:69:2: (iv_ruleRoomModel= ruleRoomModel EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:70:2: iv_ruleRoomModel= ruleRoomModel EOF
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:77:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:80:28: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:81:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRoomModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getRoomModelAccess().getRoomModelKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:86:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:87:3: lv_name_1_0= ruleFQN
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:103:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==28) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:104:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:104:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:105:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRoomModel177); 

                	newLeafNode(otherlv_3, grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:125:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==102) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:1: (lv_imports_4_0= ruleImport )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:126:1: (lv_imports_4_0= ruleImport )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:127:3: lv_imports_4_0= ruleImport
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )*
            loop3:
            do {
                int alt3=8;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:143:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:144:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:144:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:145:3: lv_primitiveTypes_5_0= rulePrimitiveType
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:162:6: ( (lv_externalTypes_6_0= ruleExternalType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:163:1: (lv_externalTypes_6_0= ruleExternalType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:163:1: (lv_externalTypes_6_0= ruleExternalType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:164:3: lv_externalTypes_6_0= ruleExternalType
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:181:6: ( (lv_dataClasses_7_0= ruleDataClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:182:1: (lv_dataClasses_7_0= ruleDataClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:182:1: (lv_dataClasses_7_0= ruleDataClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:183:3: lv_dataClasses_7_0= ruleDataClass
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:6: ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:200:6: ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:201:1: (lv_protocolClasses_8_0= ruleGeneralProtocolClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:201:1: (lv_protocolClasses_8_0= ruleGeneralProtocolClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:202:3: lv_protocolClasses_8_0= ruleGeneralProtocolClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesGeneralProtocolClassParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleGeneralProtocolClass_in_ruleRoomModel302);
            	    lv_protocolClasses_8_0=ruleGeneralProtocolClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"protocolClasses",
            	            		lv_protocolClasses_8_0, 
            	            		"GeneralProtocolClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:219:6: ( (lv_actorClasses_9_0= ruleActorClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:220:1: (lv_actorClasses_9_0= ruleActorClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:220:1: (lv_actorClasses_9_0= ruleActorClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:221:3: lv_actorClasses_9_0= ruleActorClass
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:238:6: ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:239:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:239:1: (lv_subSystemClasses_10_0= ruleSubSystemClass )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:240:3: lv_subSystemClasses_10_0= ruleSubSystemClass
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:257:6: ( (lv_systems_11_0= ruleLogicalSystem ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:258:1: (lv_systems_11_0= ruleLogicalSystem )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:258:1: (lv_systems_11_0= ruleLogicalSystem )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:259:3: lv_systems_11_0= ruleLogicalSystem
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

            otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleRoomModel397); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:289:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:290:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:291:2: iv_ruleStructureClass= ruleStructureClass EOF
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:298:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:301:28: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:302:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=51 && LA4_0<=52)||LA4_0==65||(LA4_0>=111 && LA4_0<=114)) ) {
                alt4=1;
            }
            else if ( (LA4_0==63) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:303:5: this_ActorContainerClass_0= ruleActorContainerClass
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:313:5: this_LogicalSystem_1= ruleLogicalSystem
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:329:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:330:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:331:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:338:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:341:28: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:342:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:342:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=51 && LA5_0<=52)||(LA5_0>=111 && LA5_0<=114)) ) {
                alt5=1;
            }
            else if ( (LA5_0==65) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:343:5: this_ActorClass_0= ruleActorClass
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:353:5: this_SubSystemClass_1= ruleSubSystemClass
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:369:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:370:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:371:2: iv_ruleVarDecl= ruleVarDecl EOF
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:378:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:381:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:382:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:383:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:383:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:384:3: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleVarDecl742); 

                	newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:404:1: ( (lv_refType_2_0= ruleRefableType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:405:1: (lv_refType_2_0= ruleRefableType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:405:1: (lv_refType_2_0= ruleRefableType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:406:3: lv_refType_2_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getVarDeclAccess().getRefTypeRefableTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRefableType_in_ruleVarDecl763);
            lv_refType_2_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
            	        }
                   		set(
                   			current, 
                   			"refType",
                    		lv_refType_2_0, 
                    		"RefableType");
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
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleRefableType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:430:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:431:2: (iv_ruleRefableType= ruleRefableType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:432:2: iv_ruleRefableType= ruleRefableType EOF
            {
             newCompositeNode(grammarAccess.getRefableTypeRule()); 
            pushFollow(FOLLOW_ruleRefableType_in_entryRuleRefableType799);
            iv_ruleRefableType=ruleRefableType();

            state._fsp--;

             current =iv_ruleRefableType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefableType809); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefableType"


    // $ANTLR start "ruleRefableType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:439:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:442:28: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:2: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:443:2: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:444:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:444:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:445:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefableTypeRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefableTypeAccess().getTypeDataTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefableType857);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:458:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:459:1: (lv_ref_1_0= 'ref' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:459:1: (lv_ref_1_0= 'ref' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:460:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,15,FOLLOW_15_in_ruleRefableType875); 

                            newLeafNode(lv_ref_1_0, grammarAccess.getRefableTypeAccess().getRefRefKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRefableTypeRule());
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
    // $ANTLR end "ruleRefableType"


    // $ANTLR start "entryRuleDataType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:481:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:482:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:483:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType925);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType935); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:490:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ComplexType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:493:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:494:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:494:1: (this_PrimitiveType_0= rulePrimitiveType | this_ComplexType_1= ruleComplexType )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=21 && LA7_0<=22)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:495:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleDataType982);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:505:5: this_ComplexType_1= ruleComplexType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getComplexTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleComplexType_in_ruleDataType1009);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:521:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:522:2: (iv_ruleComplexType= ruleComplexType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:523:2: iv_ruleComplexType= ruleComplexType EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_ruleComplexType_in_entryRuleComplexType1044);
            iv_ruleComplexType=ruleComplexType();

            state._fsp--;

             current =iv_ruleComplexType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexType1054); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:530:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:533:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:534:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:535:5: this_DataClass_0= ruleDataClass
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getDataClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDataClass_in_ruleComplexType1101);
                    this_DataClass_0=ruleDataClass();

                    state._fsp--;

                     
                            current = this_DataClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:545:5: this_ExternalType_1= ruleExternalType
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getExternalTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleExternalType_in_ruleComplexType1128);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:561:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:562:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:563:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1163);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveType1173); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:570:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= ruleFQN ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_defaultValueLiteral_10_0=null;
        Enumerator lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_targetName_5_0 = null;

        AntlrDatatypeRuleToken lv_castName_7_0 = null;

        EObject lv_docu_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:573:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= ruleFQN ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:574:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= ruleFQN ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:574:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= ruleFQN ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:574:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= ruleFQN ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_rulePrimitiveType1210); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:578:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:579:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:579:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:580:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimitiveType1227); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePrimitiveType1244); 

                	newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:600:1: ( (lv_type_3_0= ruleLiteralType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:601:1: (lv_type_3_0= ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:601:1: (lv_type_3_0= ruleLiteralType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:602:3: lv_type_3_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTypeLiteralTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralType_in_rulePrimitiveType1265);
            lv_type_3_0=ruleLiteralType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"LiteralType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_rulePrimitiveType1277); 

                	newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:622:1: ( (lv_targetName_5_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:623:1: (lv_targetName_5_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:623:1: (lv_targetName_5_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:624:3: lv_targetName_5_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTargetNameFQNParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1298);
            lv_targetName_5_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		set(
                   			current, 
                   			"targetName",
                    		lv_targetName_5_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:640:2: (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:640:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_rulePrimitiveType1311); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:644:1: ( (lv_castName_7_0= ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:645:1: (lv_castName_7_0= ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:645:1: (lv_castName_7_0= ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:646:3: lv_castName_7_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_rulePrimitiveType1332);
                    lv_castName_7_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"castName",
                            		lv_castName_7_0, 
                            		"FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_rulePrimitiveType1344); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_6_2());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_20_in_rulePrimitiveType1358); 

                	newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_7());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:670:1: ( (lv_defaultValueLiteral_10_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:671:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:671:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:672:3: lv_defaultValueLiteral_10_0= RULE_STRING
            {
            lv_defaultValueLiteral_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePrimitiveType1375); 

            			newLeafNode(lv_defaultValueLiteral_10_0, grammarAccess.getPrimitiveTypeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"defaultValueLiteral",
                    		lv_defaultValueLiteral_10_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:688:2: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:689:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:689:1: (lv_docu_11_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:690:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getDocuDocumentationParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePrimitiveType1401);
                    lv_docu_11_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
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


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:714:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:715:2: (iv_ruleExternalType= ruleExternalType EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:716:2: iv_ruleExternalType= ruleExternalType EOF
            {
             newCompositeNode(grammarAccess.getExternalTypeRule()); 
            pushFollow(FOLLOW_ruleExternalType_in_entryRuleExternalType1438);
            iv_ruleExternalType=ruleExternalType();

            state._fsp--;

             current =iv_ruleExternalType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalType1448); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:723:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleExternalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_targetName_3_0 = null;

        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:726:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:727:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:727:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:727:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleExternalType1485); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:731:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:732:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:732:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:733:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalType1502); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleExternalType1519); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:753:1: ( (lv_targetName_3_0= ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:754:1: (lv_targetName_3_0= ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:754:1: (lv_targetName_3_0= ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:755:3: lv_targetName_3_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getExternalTypeAccess().getTargetNameFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleExternalType1540);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:771:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:772:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:772:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:773:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalTypeAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleExternalType1561);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:797:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:798:2: (iv_ruleDataClass= ruleDataClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:799:2: iv_ruleDataClass= ruleDataClass EOF
            {
             newCompositeNode(grammarAccess.getDataClassRule()); 
            pushFollow(FOLLOW_ruleDataClass_in_entryRuleDataClass1598);
            iv_ruleDataClass=ruleDataClass();

            state._fsp--;

             current =iv_ruleDataClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataClass1608); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:806:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( (lv_attributes_13_0= ruleAttribute ) )+ ( (lv_operations_14_0= ruleStandardOperation ) )* otherlv_15= '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_15=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_6_0 = null;

        EObject lv_userCode1_8_0 = null;

        EObject lv_userCode2_10_0 = null;

        EObject lv_userCode3_12_0 = null;

        EObject lv_attributes_13_0 = null;

        EObject lv_operations_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:809:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( (lv_attributes_13_0= ruleAttribute ) )+ ( (lv_operations_14_0= ruleStandardOperation ) )* otherlv_15= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( (lv_attributes_13_0= ruleAttribute ) )+ ( (lv_operations_14_0= ruleStandardOperation ) )* otherlv_15= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( (lv_attributes_13_0= ruleAttribute ) )+ ( (lv_operations_14_0= ruleStandardOperation ) )* otherlv_15= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:810:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( (lv_attributes_13_0= ruleAttribute ) )+ ( (lv_operations_14_0= ruleStandardOperation ) )* otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleDataClass1645); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:814:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:815:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:815:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:816:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataClass1662); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:832:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:833:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:833:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:834:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleDataClass1688);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:850:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:850:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleDataClass1702); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:854:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:855:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:856:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDataClass1725);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleDataClass1739); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:873:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==101) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:874:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:874:1: (lv_annotations_6_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:875:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAnnotationsAnnotationParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleDataClass1760);
            	    lv_annotations_6_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_6_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:891:3: (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:891:5: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleDataClass1774); 

                        	newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:895:1: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:896:1: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:896:1: (lv_userCode1_8_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:897:3: lv_userCode1_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1795);
                    lv_userCode1_8_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_8_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:913:4: (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:913:6: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleDataClass1810); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:917:1: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:918:1: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:918:1: (lv_userCode2_10_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:919:3: lv_userCode2_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1831);
                    lv_userCode2_10_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_10_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:935:4: (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:935:6: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleDataClass1846); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:939:1: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:940:1: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:940:1: (lv_userCode3_12_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:941:3: lv_userCode3_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleDataClass1867);
                    lv_userCode3_12_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_12_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:957:4: ( (lv_attributes_13_0= ruleAttribute ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:958:1: (lv_attributes_13_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:958:1: (lv_attributes_13_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:959:3: lv_attributes_13_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleDataClass1890);
            	    lv_attributes_13_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_13_0, 
            	            		"Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:975:3: ( (lv_operations_14_0= ruleStandardOperation ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==31) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:976:1: (lv_operations_14_0= ruleStandardOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:976:1: (lv_operations_14_0= ruleStandardOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:977:3: lv_operations_14_0= ruleStandardOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleDataClass1912);
            	    lv_operations_14_0=ruleStandardOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_14_0, 
            	            		"StandardOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_15=(Token)match(input,13,FOLLOW_13_in_ruleDataClass1925); 

                	newLeafNode(otherlv_15, grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1005:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1006:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1007:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1961);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1971); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1014:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_size_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_defaultValueLiteral_8_0=null;
        EObject lv_refType_6_0 = null;

        EObject lv_docu_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1017:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1018:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1018:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1018:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_refType_6_0= ruleRefableType ) ) (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleAttribute2008); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1022:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1023:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1023:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1024:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute2025); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1040:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1040:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleAttribute2043); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1044:1: ( (lv_size_3_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1045:1: (lv_size_3_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1045:1: (lv_size_3_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1046:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAttribute2060); 

                    			newLeafNode(lv_size_3_0, grammarAccess.getAttributeAccess().getSizeINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"size",
                            		lv_size_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleAttribute2077); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAttribute2091); 

                	newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1070:1: ( (lv_refType_6_0= ruleRefableType ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1071:1: (lv_refType_6_0= ruleRefableType )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1071:1: (lv_refType_6_0= ruleRefableType )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1072:3: lv_refType_6_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeAccess().getRefTypeRefableTypeParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleRefableType_in_ruleAttribute2112);
            lv_refType_6_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"refType",
                    		lv_refType_6_0, 
                    		"RefableType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1088:2: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1088:4: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleAttribute2125); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1092:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1093:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1093:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1094:3: lv_defaultValueLiteral_8_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttribute2142); 

                    			newLeafNode(lv_defaultValueLiteral_8_0, grammarAccess.getAttributeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1110:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1111:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1111:1: (lv_docu_9_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1112:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleAttribute2170);
                    lv_docu_9_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleStandardOperation"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1138:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1139:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1140:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2209);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStandardOperation2219); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1147:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_destructor_1_0= '~' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
    public final EObject ruleStandardOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_destructor_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_returntype_10_0 = null;

        EObject lv_docu_11_0 = null;

        EObject lv_detailCode_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1150:28: ( (otherlv_0= 'Operation' ( (lv_destructor_1_0= '~' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1151:1: (otherlv_0= 'Operation' ( (lv_destructor_1_0= '~' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1151:1: (otherlv_0= 'Operation' ( (lv_destructor_1_0= '~' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1151:3: otherlv_0= 'Operation' ( (lv_destructor_1_0= '~' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleStandardOperation2256); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1155:1: ( (lv_destructor_1_0= '~' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1156:1: (lv_destructor_1_0= '~' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1156:1: (lv_destructor_1_0= '~' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1157:3: lv_destructor_1_0= '~'
                    {
                    lv_destructor_1_0=(Token)match(input,32,FOLLOW_32_in_ruleStandardOperation2274); 

                            newLeafNode(lv_destructor_1_0, grammarAccess.getStandardOperationAccess().getDestructorTildeKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStandardOperationRule());
                    	        }
                           		setWithLastConsumed(current, "destructor", true, "~");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1170:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1171:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1171:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1172:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStandardOperation2305); 

            			newLeafNode(lv_name_2_0, grammarAccess.getStandardOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleStandardOperation2322); 

                	newLeafNode(otherlv_3, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1192:1: ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1192:2: ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1192:2: ( (lv_arguments_4_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1193:1: (lv_arguments_4_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1193:1: (lv_arguments_4_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1194:3: lv_arguments_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2344);
                    lv_arguments_4_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_4_0, 
                            		"VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1210:2: (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==33) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1210:4: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleStandardOperation2357); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1214:1: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1215:1: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1215:1: (lv_arguments_6_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1216:3: lv_arguments_6_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_ruleStandardOperation2378);
                    	    lv_arguments_6_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_6_0, 
                    	            		"VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleStandardOperation2394); 

                	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1236:1: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==14) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1236:3: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleStandardOperation2407); 

                        	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1240:1: (otherlv_9= 'void' | ( (lv_returntype_10_0= ruleRefableType ) ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==34) ) {
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
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1240:3: otherlv_9= 'void'
                            {
                            otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleStandardOperation2420); 

                                	newLeafNode(otherlv_9, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1245:6: ( (lv_returntype_10_0= ruleRefableType ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1245:6: ( (lv_returntype_10_0= ruleRefableType ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1246:1: (lv_returntype_10_0= ruleRefableType )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1246:1: (lv_returntype_10_0= ruleRefableType )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1247:3: lv_returntype_10_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getReturntypeRefableTypeParserRuleCall_6_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleRefableType_in_ruleStandardOperation2447);
                            lv_returntype_10_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returntype",
                                    		lv_returntype_10_0, 
                                    		"RefableType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1263:5: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==28) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1264:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1264:1: (lv_docu_11_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1265:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleStandardOperation2471);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1281:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1282:1: (lv_detailCode_12_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1282:1: (lv_detailCode_12_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1283:3: lv_detailCode_12_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDetailCodeDetailCodeParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleStandardOperation2493);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1307:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1308:2: (iv_rulePortOperation= rulePortOperation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1309:2: iv_rulePortOperation= rulePortOperation EOF
            {
             newCompositeNode(grammarAccess.getPortOperationRule()); 
            pushFollow(FOLLOW_rulePortOperation_in_entryRulePortOperation2529);
            iv_rulePortOperation=rulePortOperation();

            state._fsp--;

             current =iv_rulePortOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortOperation2539); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1316:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
    public final EObject rulePortOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_returntype_9_0 = null;

        EObject lv_docu_12_0 = null;

        EObject lv_detailCode_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1319:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1320:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_rulePortOperation2576); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1324:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1325:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1325:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1326:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2593); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_rulePortOperation2610); 

                	newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1346:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1346:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1346:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1347:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1347:1: (lv_arguments_3_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1348:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2632);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1364:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==33) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1364:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_rulePortOperation2645); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1368:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1369:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1369:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1370:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVarDecl_in_rulePortOperation2666);
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

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_rulePortOperation2682); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1390:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            else if ( (LA32_0==35) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1390:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1390:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1390:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_14_in_rulePortOperation2696); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1394:1: (otherlv_8= 'void' | ( (lv_returntype_9_0= ruleRefableType ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==34) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_ID) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1394:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,34,FOLLOW_34_in_rulePortOperation2709); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1399:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1399:6: ( (lv_returntype_9_0= ruleRefableType ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1400:1: (lv_returntype_9_0= ruleRefableType )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1400:1: (lv_returntype_9_0= ruleRefableType )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1401:3: lv_returntype_9_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortOperationAccess().getReturntypeRefableTypeParserRuleCall_5_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleRefableType_in_rulePortOperation2736);
                            lv_returntype_9_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returntype",
                                    		lv_returntype_9_0, 
                                    		"RefableType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1418:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1418:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1418:8: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_35_in_rulePortOperation2757); 

                        	newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1422:1: ( (otherlv_11= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1423:1: (otherlv_11= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1423:1: (otherlv_11= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1424:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortOperation2777); 

                    		newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1435:5: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==28) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1436:1: (lv_docu_12_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1436:1: (lv_docu_12_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1437:3: lv_docu_12_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePortOperation2801);
                    lv_docu_12_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_12_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1453:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1454:1: (lv_detailCode_13_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1454:1: (lv_detailCode_13_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1455:3: lv_detailCode_13_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getPortOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_rulePortOperation2823);
            lv_detailCode_13_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_13_0, 
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


    // $ANTLR start "entryRuleGeneralProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1479:1: entryRuleGeneralProtocolClass returns [EObject current=null] : iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF ;
    public final EObject entryRuleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1480:2: (iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1481:2: iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getGeneralProtocolClassRule()); 
            pushFollow(FOLLOW_ruleGeneralProtocolClass_in_entryRuleGeneralProtocolClass2859);
            iv_ruleGeneralProtocolClass=ruleGeneralProtocolClass();

            state._fsp--;

             current =iv_ruleGeneralProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneralProtocolClass2869); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneralProtocolClass"


    // $ANTLR start "ruleGeneralProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1488:1: ruleGeneralProtocolClass returns [EObject current=null] : (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) ;
    public final EObject ruleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject this_ProtocolClass_0 = null;

        EObject this_CompoundProtocolClass_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1491:28: ( (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1492:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1492:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36||(LA34_0>=111 && LA34_0<=113)) ) {
                alt34=1;
            }
            else if ( (LA34_0==42) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1493:5: this_ProtocolClass_0= ruleProtocolClass
                    {
                     
                            newCompositeNode(grammarAccess.getGeneralProtocolClassAccess().getProtocolClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleProtocolClass_in_ruleGeneralProtocolClass2916);
                    this_ProtocolClass_0=ruleProtocolClass();

                    state._fsp--;

                     
                            current = this_ProtocolClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1503:5: this_CompoundProtocolClass_1= ruleCompoundProtocolClass
                    {
                     
                            newCompositeNode(grammarAccess.getGeneralProtocolClassAccess().getCompoundProtocolClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCompoundProtocolClass_in_ruleGeneralProtocolClass2943);
                    this_CompoundProtocolClass_1=ruleCompoundProtocolClass();

                    state._fsp--;

                     
                            current = this_CompoundProtocolClass_1; 
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
    // $ANTLR end "ruleGeneralProtocolClass"


    // $ANTLR start "entryRuleProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1519:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1520:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1521:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassRule()); 
            pushFollow(FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2978);
            iv_ruleProtocolClass=ruleProtocolClass();

            state._fsp--;

             current =iv_ruleProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolClass2988); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1528:1: ruleProtocolClass returns [EObject current=null] : ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) ;
    public final EObject ruleProtocolClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Enumerator lv_commType_0_0 = null;

        EObject lv_docu_3_0 = null;

        EObject lv_annotations_7_0 = null;

        EObject lv_userCode1_9_0 = null;

        EObject lv_userCode2_11_0 = null;

        EObject lv_userCode3_13_0 = null;

        EObject lv_incomingMessages_16_0 = null;

        EObject lv_outgoingMessages_20_0 = null;

        EObject lv_regular_24_0 = null;

        EObject lv_conjugate_27_0 = null;

        EObject lv_semantics_28_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1531:28: ( ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:2: ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1532:2: ( (lv_commType_0_0= ruleCommunicationType ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=111 && LA35_0<=113)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1533:1: (lv_commType_0_0= ruleCommunicationType )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1533:1: (lv_commType_0_0= ruleCommunicationType )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1534:3: lv_commType_0_0= ruleCommunicationType
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getCommTypeCommunicationTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCommunicationType_in_ruleProtocolClass3034);
                    lv_commType_0_0=ruleCommunicationType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"commType",
                            		lv_commType_0_0, 
                            		"CommunicationType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleProtocolClass3047); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1554:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1555:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1555:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1556:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProtocolClass3064); 

            			newLeafNode(lv_name_2_0, grammarAccess.getProtocolClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1572:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1573:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1573:1: (lv_docu_3_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1574:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleProtocolClass3090);
                    lv_docu_3_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1590:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==23) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1590:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleProtocolClass3104); 

                        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassAccess().getExtendsKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1594:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1595:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1595:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1596:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getProtocolClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleProtocolClass3127);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleProtocolClass3141); 

                	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1613:1: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==101) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1614:1: (lv_annotations_7_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1614:1: (lv_annotations_7_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1615:3: lv_annotations_7_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleProtocolClass3162);
            	    lv_annotations_7_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_7_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1631:3: (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==24) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1631:5: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleProtocolClass3176); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1635:1: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1636:1: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1636:1: (lv_userCode1_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1637:3: lv_userCode1_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass3197);
                    lv_userCode1_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_9_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1653:4: (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==25) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1653:6: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleProtocolClass3212); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1657:1: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1658:1: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1658:1: (lv_userCode2_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1659:3: lv_userCode2_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass3233);
                    lv_userCode2_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_11_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1675:4: (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==26) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1675:6: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleProtocolClass3248); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1679:1: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1680:1: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1680:1: (lv_userCode3_13_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1681:3: lv_userCode3_13_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleProtocolClass3269);
                    lv_userCode3_13_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_13_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1697:4: (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==37) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1697:6: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,37,FOLLOW_37_in_ruleProtocolClass3284); 

                        	newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,12,FOLLOW_12_in_ruleProtocolClass3296); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1705:1: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=44 && LA42_0<=45)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1706:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1706:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1707:3: lv_incomingMessages_16_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_10_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3317);
                    	    lv_incomingMessages_16_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"incomingMessages",
                    	            		lv_incomingMessages_16_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3330); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1727:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1727:5: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,38,FOLLOW_38_in_ruleProtocolClass3345); 

                        	newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                        
                    otherlv_19=(Token)match(input,12,FOLLOW_12_in_ruleProtocolClass3357); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1735:1: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( ((LA44_0>=44 && LA44_0<=45)) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1736:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1736:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1737:3: lv_outgoingMessages_20_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_11_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMessage_in_ruleProtocolClass3378);
                    	    lv_outgoingMessages_20_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outgoingMessages",
                    	            		lv_outgoingMessages_20_0, 
                    	            		"Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3391); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1757:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1757:5: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,39,FOLLOW_39_in_ruleProtocolClass3406); 

                        	newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                        
                    otherlv_23=(Token)match(input,40,FOLLOW_40_in_ruleProtocolClass3418); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1765:1: ( (lv_regular_24_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1766:1: (lv_regular_24_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1766:1: (lv_regular_24_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1767:3: lv_regular_24_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3439);
                    lv_regular_24_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"regular",
                            		lv_regular_24_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1783:4: (otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1783:6: otherlv_25= 'conjugate' otherlv_26= 'PortClass' ( (lv_conjugate_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,41,FOLLOW_41_in_ruleProtocolClass3454); 

                        	newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugateKeyword_13_0());
                        
                    otherlv_26=(Token)match(input,40,FOLLOW_40_in_ruleProtocolClass3466); 

                        	newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1791:1: ( (lv_conjugate_27_0= rulePortClass ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1792:1: (lv_conjugate_27_0= rulePortClass )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1792:1: (lv_conjugate_27_0= rulePortClass )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1793:3: lv_conjugate_27_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatePortClassParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePortClass_in_ruleProtocolClass3487);
                    lv_conjugate_27_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"conjugate",
                            		lv_conjugate_27_0, 
                            		"PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1809:4: ( (lv_semantics_28_0= ruleProtocolSemantics ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==48) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1810:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1810:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1811:3: lv_semantics_28_0= ruleProtocolSemantics
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_14_0()); 
                    	    
                    pushFollow(FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3510);
                    lv_semantics_28_0=ruleProtocolSemantics();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"semantics",
                            		lv_semantics_28_0, 
                            		"ProtocolSemantics");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_29=(Token)match(input,13,FOLLOW_13_in_ruleProtocolClass3523); 

                	newLeafNode(otherlv_29, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_15());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleCompoundProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1839:1: entryRuleCompoundProtocolClass returns [EObject current=null] : iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF ;
    public final EObject entryRuleCompoundProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundProtocolClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1840:2: (iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1841:2: iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getCompoundProtocolClassRule()); 
            pushFollow(FOLLOW_ruleCompoundProtocolClass_in_entryRuleCompoundProtocolClass3559);
            iv_ruleCompoundProtocolClass=ruleCompoundProtocolClass();

            state._fsp--;

             current =iv_ruleCompoundProtocolClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundProtocolClass3569); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundProtocolClass"


    // $ANTLR start "ruleCompoundProtocolClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1848:1: ruleCompoundProtocolClass returns [EObject current=null] : (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )+ otherlv_6= '}' ) ;
    public final EObject ruleCompoundProtocolClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_subProtocols_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1851:28: ( (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1852:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1852:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )+ otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1852:3: otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleCompoundProtocolClass3606); 

                	newLeafNode(otherlv_0, grammarAccess.getCompoundProtocolClassAccess().getCompoundProtocolClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1856:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1857:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1857:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1858:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompoundProtocolClass3623); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCompoundProtocolClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompoundProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1874:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==28) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1875:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1875:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1876:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCompoundProtocolClass3649);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleCompoundProtocolClass3662); 

                	newLeafNode(otherlv_3, grammarAccess.getCompoundProtocolClassAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1896:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==101) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1897:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1897:1: (lv_annotations_4_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1898:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleCompoundProtocolClass3683);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_4_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1914:3: ( (lv_subProtocols_5_0= ruleSubProtocol ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==43) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1915:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1915:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1916:3: lv_subProtocols_5_0= ruleSubProtocol
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getSubProtocolsSubProtocolParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubProtocol_in_ruleCompoundProtocolClass3705);
            	    lv_subProtocols_5_0=ruleSubProtocol();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subProtocols",
            	            		lv_subProtocols_5_0, 
            	            		"SubProtocol");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleCompoundProtocolClass3718); 

                	newLeafNode(otherlv_6, grammarAccess.getCompoundProtocolClassAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundProtocolClass"


    // $ANTLR start "entryRuleSubProtocol"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1944:1: entryRuleSubProtocol returns [EObject current=null] : iv_ruleSubProtocol= ruleSubProtocol EOF ;
    public final EObject entryRuleSubProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProtocol = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1945:2: (iv_ruleSubProtocol= ruleSubProtocol EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1946:2: iv_ruleSubProtocol= ruleSubProtocol EOF
            {
             newCompositeNode(grammarAccess.getSubProtocolRule()); 
            pushFollow(FOLLOW_ruleSubProtocol_in_entryRuleSubProtocol3754);
            iv_ruleSubProtocol=ruleSubProtocol();

            state._fsp--;

             current =iv_ruleSubProtocol; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubProtocol3764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubProtocol"


    // $ANTLR start "ruleSubProtocol"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1953:1: ruleSubProtocol returns [EObject current=null] : (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSubProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1956:28: ( (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1957:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1957:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1957:3: otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleSubProtocol3801); 

                	newLeafNode(otherlv_0, grammarAccess.getSubProtocolAccess().getSubProtocolKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1961:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1962:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1962:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1963:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubProtocol3818); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubProtocolAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubProtocolRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSubProtocol3835); 

                	newLeafNode(otherlv_2, grammarAccess.getSubProtocolAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1983:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1984:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1984:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:1985:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubProtocolRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubProtocolAccess().getProtocolGeneralProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubProtocol3858);
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
    // $ANTLR end "ruleSubProtocol"


    // $ANTLR start "entryRuleMessage"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2006:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2007:2: (iv_ruleMessage= ruleMessage EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2008:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_ruleMessage_in_entryRuleMessage3894);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessage3904); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2015:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2018:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2019:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2019:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2019:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2019:2: ( (lv_priv_0_0= 'private' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2020:1: (lv_priv_0_0= 'private' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2020:1: (lv_priv_0_0= 'private' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2021:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,44,FOLLOW_44_in_ruleMessage3947); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleMessage3973); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2038:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2039:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2039:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2040:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessage3990); 

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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleMessage4007); 

                	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2060:1: ( (lv_data_4_0= ruleVarDecl ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2061:1: (lv_data_4_0= ruleVarDecl )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2061:1: (lv_data_4_0= ruleVarDecl )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2062:3: lv_data_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDataVarDeclParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarDecl_in_ruleMessage4028);
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

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleMessage4041); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2082:1: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==28) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2083:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2083:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2084:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleMessage4062);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2108:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2109:2: (iv_rulePortClass= rulePortClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2110:2: iv_rulePortClass= rulePortClass EOF
            {
             newCompositeNode(grammarAccess.getPortClassRule()); 
            pushFollow(FOLLOW_rulePortClass_in_entryRulePortClass4099);
            iv_rulePortClass=rulePortClass();

            state._fsp--;

             current =iv_rulePortClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortClass4109); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2117:1: rulePortClass returns [EObject current=null] : (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2120:28: ( (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2121:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2121:1: (otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2121:3: otherlv_0= '{' (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )? ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_rulePortClass4146); 

                	newLeafNode(otherlv_0, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:1: (otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==46) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2125:3: otherlv_1= 'usercode' ( (lv_userCode_2_0= ruleDetailCode ) )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_46_in_rulePortClass4159); 

                        	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getUsercodeKeyword_1_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2129:1: ( (lv_userCode_2_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2130:1: (lv_userCode_2_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2130:1: (lv_userCode_2_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2131:3: lv_userCode_2_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_rulePortClass4180);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:4: ( ( (lv_attributes_3_0= ruleAttribute ) ) | ( (lv_operations_4_0= rulePortOperation ) ) | ( (lv_msgHandlers_5_0= ruleMessageHandler ) ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=4;
                switch ( input.LA(1) ) {
                case 27:
                    {
                    alt56=1;
                    }
                    break;
                case 31:
                    {
                    alt56=2;
                    }
                    break;
                case 47:
                    {
                    alt56=3;
                    }
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2147:5: ( (lv_attributes_3_0= ruleAttribute ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2148:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2148:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2149:3: lv_attributes_3_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAttribute_in_rulePortClass4204);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2166:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2166:6: ( (lv_operations_4_0= rulePortOperation ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2167:1: (lv_operations_4_0= rulePortOperation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2167:1: (lv_operations_4_0= rulePortOperation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2168:3: lv_operations_4_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePortOperation_in_rulePortClass4231);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2185:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2185:6: ( (lv_msgHandlers_5_0= ruleMessageHandler ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2186:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2186:1: (lv_msgHandlers_5_0= ruleMessageHandler )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2187:3: lv_msgHandlers_5_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageHandler_in_rulePortClass4258);
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
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_rulePortClass4272); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2215:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2216:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2217:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getMessageHandlerRule()); 
            pushFollow(FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler4308);
            iv_ruleMessageHandler=ruleMessageHandler();

            state._fsp--;

             current =iv_ruleMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageHandler4318); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2224:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2227:28: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2228:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2228:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==47) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==38) ) {
                    alt57=2;
                }
                else if ( (LA57_1==37) ) {
                    alt57=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2229:5: this_InMessageHandler_0= ruleInMessageHandler
                    {
                     
                            newCompositeNode(grammarAccess.getMessageHandlerAccess().getInMessageHandlerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInMessageHandler_in_ruleMessageHandler4365);
                    this_InMessageHandler_0=ruleInMessageHandler();

                    state._fsp--;

                     
                            current = this_InMessageHandler_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2239:5: this_OutMessageHandler_1= ruleOutMessageHandler
                    {
                     
                            newCompositeNode(grammarAccess.getMessageHandlerAccess().getOutMessageHandlerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOutMessageHandler_in_ruleMessageHandler4392);
                    this_OutMessageHandler_1=ruleOutMessageHandler();

                    state._fsp--;

                     
                            current = this_OutMessageHandler_1; 
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
    // $ANTLR end "ruleMessageHandler"


    // $ANTLR start "entryRuleInMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2255:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2256:2: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2257:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getInMessageHandlerRule()); 
            pushFollow(FOLLOW_ruleInMessageHandler_in_entryRuleInMessageHandler4427);
            iv_ruleInMessageHandler=ruleInMessageHandler();

            state._fsp--;

             current =iv_ruleInMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInMessageHandler4437); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInMessageHandler"


    // $ANTLR start "ruleInMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2264:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2267:28: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2268:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2268:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2268:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleInMessageHandler4474); 

                	newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleInMessageHandler4486); 

                	newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2276:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2277:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2277:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2278:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInMessageHandler4506); 

            		newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2289:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2290:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2290:1: (lv_detailCode_3_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2291:3: lv_detailCode_3_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getInMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleInMessageHandler4527);
            lv_detailCode_3_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_3_0, 
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
    // $ANTLR end "ruleInMessageHandler"


    // $ANTLR start "entryRuleOutMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2315:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2316:2: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2317:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getOutMessageHandlerRule()); 
            pushFollow(FOLLOW_ruleOutMessageHandler_in_entryRuleOutMessageHandler4563);
            iv_ruleOutMessageHandler=ruleOutMessageHandler();

            state._fsp--;

             current =iv_ruleOutMessageHandler; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutMessageHandler4573); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutMessageHandler"


    // $ANTLR start "ruleOutMessageHandler"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2324:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2327:28: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2328:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2328:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2328:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleOutMessageHandler4610); 

                	newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleOutMessageHandler4622); 

                	newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2336:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2337:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2337:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2338:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOutMessageHandler4642); 

            		newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2349:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2350:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2350:1: (lv_detailCode_3_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2351:3: lv_detailCode_3_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getOutMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleOutMessageHandler4663);
            lv_detailCode_3_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOutMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_3_0, 
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
    // $ANTLR end "ruleOutMessageHandler"


    // $ANTLR start "entryRuleProtocolSemantics"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2375:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2376:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2377:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             newCompositeNode(grammarAccess.getProtocolSemanticsRule()); 
            pushFollow(FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics4699);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();

            state._fsp--;

             current =iv_ruleProtocolSemantics; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProtocolSemantics4709); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2384:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2387:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2388:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2388:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2388:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2388:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2389:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleProtocolSemantics4755); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleProtocolSemantics4767); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2402:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=49 && LA58_0<=50)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2403:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2403:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2404:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics4788);
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
            	    break loop58;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleProtocolSemantics4801); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2432:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2433:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2434:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule4837);
            iv_ruleSemanticsRule=ruleSemanticsRule();

            state._fsp--;

             current =iv_ruleSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSemanticsRule4847); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2441:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2444:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2445:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2445:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==49) ) {
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
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2446:5: this_InSemanticsRule_0= ruleInSemanticsRule
                    {
                     
                            newCompositeNode(grammarAccess.getSemanticsRuleAccess().getInSemanticsRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInSemanticsRule_in_ruleSemanticsRule4894);
                    this_InSemanticsRule_0=ruleInSemanticsRule();

                    state._fsp--;

                     
                            current = this_InSemanticsRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2456:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
                    {
                     
                            newCompositeNode(grammarAccess.getSemanticsRuleAccess().getOutSemanticsRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOutSemanticsRule_in_ruleSemanticsRule4921);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2472:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2473:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2474:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getInSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleInSemanticsRule_in_entryRuleInSemanticsRule4956);
            iv_ruleInSemanticsRule=ruleInSemanticsRule();

            state._fsp--;

             current =iv_ruleInSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInSemanticsRule4966); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2481:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2484:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2485:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2485:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2485:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleInSemanticsRule5003); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleInSemanticsRule5015); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2493:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2494:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2494:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2495:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInSemanticsRule5035); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2506:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==17) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2506:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleInSemanticsRule5048); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2510:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( ((LA61_0>=49 && LA61_0<=50)) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==18) ) {
                        alt61=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2510:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2510:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2511:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2511:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2512:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5070);
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
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2529:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2529:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2529:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleInSemanticsRule5089); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2533:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2534:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2534:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2535:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5110);
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

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2551:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt60=0;
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==33) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2551:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleInSemanticsRule5123); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2555:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2556:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2556:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2557:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5144);
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
                            	    if ( cnt60 >= 1 ) break loop60;
                                        EarlyExitException eee =
                                            new EarlyExitException(60, input);
                                        throw eee;
                                }
                                cnt60++;
                            } while (true);

                            otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleInSemanticsRule5158); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2585:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2586:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2587:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
            {
             newCompositeNode(grammarAccess.getOutSemanticsRuleRule()); 
            pushFollow(FOLLOW_ruleOutSemanticsRule_in_entryRuleOutSemanticsRule5198);
            iv_ruleOutSemanticsRule=ruleOutSemanticsRule();

            state._fsp--;

             current =iv_ruleOutSemanticsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutSemanticsRule5208); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2594:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2597:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2598:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2598:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2598:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleOutSemanticsRule5245); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleOutSemanticsRule5257); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2606:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2607:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2607:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2608:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOutSemanticsRule5277); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2619:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==17) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2619:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleOutSemanticsRule5290); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2623:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( ((LA64_0>=49 && LA64_0<=50)) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==18) ) {
                        alt64=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2623:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2623:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2624:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2624:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2625:3: lv_followUps_4_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5312);
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
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2642:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2642:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2642:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleOutSemanticsRule5331); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2646:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2647:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2647:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2648:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5352);
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

                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2664:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt63=0;
                            loop63:
                            do {
                                int alt63=2;
                                int LA63_0 = input.LA(1);

                                if ( (LA63_0==33) ) {
                                    alt63=1;
                                }


                                switch (alt63) {
                            	case 1 :
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2664:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleOutSemanticsRule5365); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2668:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2669:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2669:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2670:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5386);
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
                            	    if ( cnt63 >= 1 ) break loop63;
                                        EarlyExitException eee =
                                            new EarlyExitException(63, input);
                                        throw eee;
                                }
                                cnt63++;
                            } while (true);

                            otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleOutSemanticsRule5400); 

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


    // $ANTLR start "entryRuleActorClass"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2698:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2699:2: (iv_ruleActorClass= ruleActorClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2700:2: iv_ruleActorClass= ruleActorClass EOF
            {
             newCompositeNode(grammarAccess.getActorClassRule()); 
            pushFollow(FOLLOW_ruleActorClass_in_entryRuleActorClass5440);
            iv_ruleActorClass=ruleActorClass();

            state._fsp--;

             current =iv_ruleActorClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorClass5450); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2707:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )? otherlv_40= '}' ) ;
    public final EObject ruleActorClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Enumerator lv_commType_2_0 = null;

        EObject lv_docu_5_0 = null;

        EObject lv_annotations_9_0 = null;

        EObject lv_ifPorts_12_0 = null;

        EObject lv_ifSPPs_13_0 = null;

        EObject lv_structureDocu_16_0 = null;

        EObject lv_userCode1_19_0 = null;

        EObject lv_userCode2_21_0 = null;

        EObject lv_userCode3_23_0 = null;

        EObject lv_intPorts_24_0 = null;

        EObject lv_extPorts_25_0 = null;

        EObject lv_serviceImplementations_26_0 = null;

        EObject lv_strSAPs_27_0 = null;

        EObject lv_attributes_28_0 = null;

        EObject lv_actorRefs_29_0 = null;

        EObject lv_bindings_30_0 = null;

        EObject lv_connections_31_0 = null;

        EObject lv_behaviorDocu_34_0 = null;

        EObject lv_behaviorAnnotations_36_0 = null;

        EObject lv_operations_37_0 = null;

        EObject lv_stateMachine_38_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2710:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )? otherlv_40= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2711:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )? otherlv_40= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2711:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )? otherlv_40= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2711:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )? otherlv_40= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2711:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2713:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2713:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2714:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2717:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2718:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2718:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) ) )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( LA66_0 ==51 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt66=1;
                }
                else if ( LA66_0 >=111 && LA66_0<=114 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2720:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2720:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2721:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2721:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2722:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2725:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2725:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2725:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2726:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2726:1: (lv_abstract_1_0= 'abstract' )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2727:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,51,FOLLOW_51_in_ruleActorClass5538); 

            	            newLeafNode(lv_abstract_1_0, grammarAccess.getActorClassAccess().getAbstractAbstractKeyword_0_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getActorClassRule());
            	    	        }
            	           		setWithLastConsumed(current, "abstract", true, "abstract");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2747:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2747:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2748:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2748:107: ( ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2749:6: ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2752:6: ({...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2752:7: {...}? => ( (lv_commType_2_0= ruleActorCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2752:16: ( (lv_commType_2_0= ruleActorCommunicationType ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2753:1: (lv_commType_2_0= ruleActorCommunicationType )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2753:1: (lv_commType_2_0= ruleActorCommunicationType )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2754:3: lv_commType_2_0= ruleActorCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getCommTypeActorCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorCommunicationType_in_ruleActorClass5626);
            	    lv_commType_2_0=ruleActorCommunicationType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"commType",
            	            		lv_commType_2_0, 
            	            		"ActorCommunicationType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleActorClass5678); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2788:1: ( (lv_name_4_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2789:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2789:1: (lv_name_4_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2790:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorClass5695); 

            			newLeafNode(lv_name_4_0, grammarAccess.getActorClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2806:2: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==28) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2807:1: (lv_docu_5_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2807:1: (lv_docu_5_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2808:3: lv_docu_5_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass5721);
                    lv_docu_5_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_5_0, 
                            		"Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2824:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==23) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2824:5: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleActorClass5735); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2828:1: ( ( ruleFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2829:1: ( ruleFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2829:1: ( ruleFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2830:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleActorClass5758);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,12,FOLLOW_12_in_ruleActorClass5772); 

                	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2847:1: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==101) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:1: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2848:1: (lv_annotations_9_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2849:3: lv_annotations_9_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleActorClass5793);
            	    lv_annotations_9_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_9_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2865:3: (otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==53) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2865:5: otherlv_10= 'Interface' otherlv_11= '{' ( (lv_ifPorts_12_0= rulePort ) )* ( (lv_ifSPPs_13_0= ruleSPPRef ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,53,FOLLOW_53_in_ruleActorClass5807); 

                        	newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,12,FOLLOW_12_in_ruleActorClass5819); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2873:1: ( (lv_ifPorts_12_0= rulePort ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( ((LA70_0>=56 && LA70_0<=57)) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2874:1: (lv_ifPorts_12_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2874:1: (lv_ifPorts_12_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2875:3: lv_ifPorts_12_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfPortsPortParserRuleCall_7_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass5840);
                    	    lv_ifPorts_12_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifPorts",
                    	            		lv_ifPorts_12_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2891:3: ( (lv_ifSPPs_13_0= ruleSPPRef ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==60) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2892:1: (lv_ifSPPs_13_0= ruleSPPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2892:1: (lv_ifSPPs_13_0= ruleSPPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2893:3: lv_ifSPPs_13_0= ruleSPPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIfSPPsSPPRefParserRuleCall_7_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSPPRef_in_ruleActorClass5862);
                    	    lv_ifSPPs_13_0=ruleSPPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ifSPPs",
                    	            		lv_ifSPPs_13_0, 
                    	            		"SPPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleActorClass5875); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==54) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2913:5: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )* ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )* ( (lv_strSAPs_27_0= ruleSAPRef ) )* ( (lv_attributes_28_0= ruleAttribute ) )* ( (lv_actorRefs_29_0= ruleActorRef ) )* ( (lv_bindings_30_0= ruleBinding ) )* ( (lv_connections_31_0= ruleLayerConnection ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,54,FOLLOW_54_in_ruleActorClass5890); 

                        	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2917:1: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==28) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2918:1: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2918:1: (lv_structureDocu_16_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2919:3: lv_structureDocu_16_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStructureDocuDocumentationParserRuleCall_8_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass5911);
                            lv_structureDocu_16_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"structureDocu",
                                    		lv_structureDocu_16_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,12,FOLLOW_12_in_ruleActorClass5924); 

                        	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2939:1: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==24) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2939:3: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,24,FOLLOW_24_in_ruleActorClass5937); 

                                	newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2943:1: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2944:1: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2944:1: (lv_userCode1_19_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2945:3: lv_userCode1_19_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass5958);
                            lv_userCode1_19_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode1",
                                    		lv_userCode1_19_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2961:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==25) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2961:6: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,25,FOLLOW_25_in_ruleActorClass5973); 

                                	newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2965:1: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2966:1: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2966:1: (lv_userCode2_21_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2967:3: lv_userCode2_21_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass5994);
                            lv_userCode2_21_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode2",
                                    		lv_userCode2_21_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2983:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==26) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2983:6: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,26,FOLLOW_26_in_ruleActorClass6009); 

                                	newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2987:1: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2988:1: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2988:1: (lv_userCode3_23_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:2989:3: lv_userCode3_23_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_8_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleActorClass6030);
                            lv_userCode3_23_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode3",
                                    		lv_userCode3_23_0, 
                                    		"DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3005:4: ( ( (lv_intPorts_24_0= rulePort ) ) | ( (lv_extPorts_25_0= ruleExternalPort ) ) )*
                    loop77:
                    do {
                        int alt77=3;
                        int LA77_0 = input.LA(1);

                        if ( ((LA77_0>=56 && LA77_0<=57)) ) {
                            alt77=1;
                        }
                        else if ( (LA77_0==58) ) {
                            alt77=2;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3005:5: ( (lv_intPorts_24_0= rulePort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3005:5: ( (lv_intPorts_24_0= rulePort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3006:1: (lv_intPorts_24_0= rulePort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3006:1: (lv_intPorts_24_0= rulePort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3007:3: lv_intPorts_24_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getIntPortsPortParserRuleCall_8_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePort_in_ruleActorClass6054);
                    	    lv_intPorts_24_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"intPorts",
                    	            		lv_intPorts_24_0, 
                    	            		"Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3024:6: ( (lv_extPorts_25_0= ruleExternalPort ) )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3024:6: ( (lv_extPorts_25_0= ruleExternalPort ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3025:1: (lv_extPorts_25_0= ruleExternalPort )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3025:1: (lv_extPorts_25_0= ruleExternalPort )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3026:3: lv_extPorts_25_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExtPortsExternalPortParserRuleCall_8_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExternalPort_in_ruleActorClass6081);
                    	    lv_extPorts_25_0=ruleExternalPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"extPorts",
                    	            		lv_extPorts_25_0, 
                    	            		"ExternalPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3042:4: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==61) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3043:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3043:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3044:3: lv_serviceImplementations_26_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_8_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleServiceImplementation_in_ruleActorClass6104);
                    	    lv_serviceImplementations_26_0=ruleServiceImplementation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceImplementations",
                    	            		lv_serviceImplementations_26_0, 
                    	            		"ServiceImplementation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3060:3: ( (lv_strSAPs_27_0= ruleSAPRef ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==59) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3061:1: (lv_strSAPs_27_0= ruleSAPRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3061:1: (lv_strSAPs_27_0= ruleSAPRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3062:3: lv_strSAPs_27_0= ruleSAPRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStrSAPsSAPRefParserRuleCall_8_8_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSAPRef_in_ruleActorClass6126);
                    	    lv_strSAPs_27_0=ruleSAPRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"strSAPs",
                    	            		lv_strSAPs_27_0, 
                    	            		"SAPRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3078:3: ( (lv_attributes_28_0= ruleAttribute ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==27) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3079:1: (lv_attributes_28_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3079:1: (lv_attributes_28_0= ruleAttribute )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3080:3: lv_attributes_28_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_8_9_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleActorClass6148);
                    	    lv_attributes_28_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_28_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop80;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3096:3: ( (lv_actorRefs_29_0= ruleActorRef ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==75) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3097:1: (lv_actorRefs_29_0= ruleActorRef )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3097:1: (lv_actorRefs_29_0= ruleActorRef )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3098:3: lv_actorRefs_29_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_8_10_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleActorRef_in_ruleActorClass6170);
                    	    lv_actorRefs_29_0=ruleActorRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorRefs",
                    	            		lv_actorRefs_29_0, 
                    	            		"ActorRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3114:3: ( (lv_bindings_30_0= ruleBinding ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==69) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3115:1: (lv_bindings_30_0= ruleBinding )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3115:1: (lv_bindings_30_0= ruleBinding )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3116:3: lv_bindings_30_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_8_11_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinding_in_ruleActorClass6192);
                    	    lv_bindings_30_0=ruleBinding();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"bindings",
                    	            		lv_bindings_30_0, 
                    	            		"Binding");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3132:3: ( (lv_connections_31_0= ruleLayerConnection ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==72) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3133:1: (lv_connections_31_0= ruleLayerConnection )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3133:1: (lv_connections_31_0= ruleLayerConnection )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3134:3: lv_connections_31_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_8_12_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleActorClass6214);
                    	    lv_connections_31_0=ruleLayerConnection();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_31_0, 
                    	            		"LayerConnection");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,13,FOLLOW_13_in_ruleActorClass6227); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_13());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3154:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==55) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3154:5: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( (lv_operations_37_0= ruleStandardOperation ) )* ( (lv_stateMachine_38_0= ruleStateMachine ) )? otherlv_39= '}'
                    {
                    otherlv_33=(Token)match(input,55,FOLLOW_55_in_ruleActorClass6242); 

                        	newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3158:1: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==28) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3159:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3159:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3160:3: lv_behaviorDocu_34_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorDocuDocumentationParserRuleCall_9_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDocumentation_in_ruleActorClass6263);
                            lv_behaviorDocu_34_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"behaviorDocu",
                                    		lv_behaviorDocu_34_0, 
                                    		"Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_35=(Token)match(input,12,FOLLOW_12_in_ruleActorClass6276); 

                        	newLeafNode(otherlv_35, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3180:1: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==101) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3181:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3181:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3182:3: lv_behaviorAnnotations_36_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorAnnotationsAnnotationParserRuleCall_9_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAnnotation_in_ruleActorClass6297);
                    	    lv_behaviorAnnotations_36_0=ruleAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"behaviorAnnotations",
                    	            		lv_behaviorAnnotations_36_0, 
                    	            		"Annotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3198:3: ( (lv_operations_37_0= ruleStandardOperation ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==31) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3199:1: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3199:1: (lv_operations_37_0= ruleStandardOperation )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3200:3: lv_operations_37_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_9_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStandardOperation_in_ruleActorClass6319);
                    	    lv_operations_37_0=ruleStandardOperation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_37_0, 
                    	            		"StandardOperation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3216:3: ( (lv_stateMachine_38_0= ruleStateMachine ) )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==76) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3217:1: (lv_stateMachine_38_0= ruleStateMachine )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3217:1: (lv_stateMachine_38_0= ruleStateMachine )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3218:3: lv_stateMachine_38_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_9_5_0()); 
                            	    
                            pushFollow(FOLLOW_ruleStateMachine_in_ruleActorClass6341);
                            lv_stateMachine_38_0=ruleStateMachine();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"stateMachine",
                                    		lv_stateMachine_38_0, 
                                    		"StateMachine");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_39=(Token)match(input,13,FOLLOW_13_in_ruleActorClass6354); 

                        	newLeafNode(otherlv_39, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9_6());
                        

                    }
                    break;

            }

            otherlv_40=(Token)match(input,13,FOLLOW_13_in_ruleActorClass6368); 

                	newLeafNode(otherlv_40, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3252:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3253:2: (iv_rulePort= rulePort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3254:2: iv_rulePort= rulePort EOF
            {
             newCompositeNode(grammarAccess.getPortRule()); 
            pushFollow(FOLLOW_rulePort_in_entryRulePort6406);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePort6416); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3261:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_multiplicity_3_0 = null;

        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3264:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3265:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3265:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3265:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3265:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==56) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3266:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3266:1: (lv_conjugated_0_0= 'conjugated' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3267:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,56,FOLLOW_56_in_rulePort6459); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_rulePort6485); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3284:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3285:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3285:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3286:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePort6502); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3302:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==28) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3303:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3303:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3304:3: lv_multiplicity_3_0= ruleMULTIPLICITY
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getMultiplicityMULTIPLICITYParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMULTIPLICITY_in_rulePort6528);
                    lv_multiplicity_3_0=ruleMULTIPLICITY();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"MULTIPLICITY");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_rulePort6541); 

                	newLeafNode(otherlv_4, grammarAccess.getPortAccess().getColonKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3324:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3325:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3325:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3326:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolGeneralProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_rulePort6564);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3339:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==28) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3340:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3340:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3341:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_rulePort6585);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3365:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3366:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3367:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             newCompositeNode(grammarAccess.getExternalPortRule()); 
            pushFollow(FOLLOW_ruleExternalPort_in_entryRuleExternalPort6622);
            iv_ruleExternalPort=ruleExternalPort();

            state._fsp--;

             current =iv_ruleExternalPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalPort6632); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3374:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3377:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3378:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3378:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3378:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleExternalPort6669); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleExternalPort6681); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3386:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3387:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3387:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3388:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalPortRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalPort6701); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3407:1: entryRuleSAPRef returns [EObject current=null] : iv_ruleSAPRef= ruleSAPRef EOF ;
    public final EObject entryRuleSAPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3408:2: (iv_ruleSAPRef= ruleSAPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3409:2: iv_ruleSAPRef= ruleSAPRef EOF
            {
             newCompositeNode(grammarAccess.getSAPRefRule()); 
            pushFollow(FOLLOW_ruleSAPRef_in_entryRuleSAPRef6737);
            iv_ruleSAPRef=ruleSAPRef();

            state._fsp--;

             current =iv_ruleSAPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPRef6747); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3416:1: ruleSAPRef returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3419:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3420:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3420:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3420:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleSAPRef6784); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPRefAccess().getSAPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3424:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3425:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3425:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3426:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSAPRef6801); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSAPRef6818); 

                	newLeafNode(otherlv_2, grammarAccess.getSAPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3446:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3447:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3447:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3448:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSAPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSAPRef6841);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3469:1: entryRuleSPPRef returns [EObject current=null] : iv_ruleSPPRef= ruleSPPRef EOF ;
    public final EObject entryRuleSPPRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3470:2: (iv_ruleSPPRef= ruleSPPRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3471:2: iv_ruleSPPRef= ruleSPPRef EOF
            {
             newCompositeNode(grammarAccess.getSPPRefRule()); 
            pushFollow(FOLLOW_ruleSPPRef_in_entryRuleSPPRef6877);
            iv_ruleSPPRef=ruleSPPRef();

            state._fsp--;

             current =iv_ruleSPPRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPRef6887); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3478:1: ruleSPPRef returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPPRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3481:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3482:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3482:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3482:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleSPPRef6924); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPRefAccess().getSPPKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3486:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3487:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3487:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3488:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPRef6941); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSPPRef6958); 

                	newLeafNode(otherlv_2, grammarAccess.getSPPRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3508:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3509:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3509:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3510:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSPPRefAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSPPRef6981);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3531:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3532:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3533:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             newCompositeNode(grammarAccess.getServiceImplementationRule()); 
            pushFollow(FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation7017);
            iv_ruleServiceImplementation=ruleServiceImplementation();

            state._fsp--;

             current =iv_ruleServiceImplementation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleServiceImplementation7027); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3540:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3543:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3544:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3544:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3544:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleServiceImplementation7064); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleServiceImplementation7076); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3552:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3553:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3553:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3554:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getServiceImplementationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleServiceImplementation7096); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3573:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3574:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3575:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             newCompositeNode(grammarAccess.getLogicalSystemRule()); 
            pushFollow(FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem7132);
            iv_ruleLogicalSystem=ruleLogicalSystem();

            state._fsp--;

             current =iv_ruleLogicalSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalSystem7142); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3582:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subSystems_5_0= ruleSubSystemRef ) )* ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* otherlv_8= '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_subSystems_5_0 = null;

        EObject lv_bindings_6_0 = null;

        EObject lv_connections_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3585:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subSystems_5_0= ruleSubSystemRef ) )* ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3586:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subSystems_5_0= ruleSubSystemRef ) )* ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3586:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subSystems_5_0= ruleSubSystemRef ) )* ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3586:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subSystems_5_0= ruleSubSystemRef ) )* ( (lv_bindings_6_0= ruleBinding ) )* ( (lv_connections_7_0= ruleLayerConnection ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleLogicalSystem7179); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3590:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3591:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3591:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3592:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalSystem7196); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3608:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==28) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3609:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3609:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3610:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleLogicalSystem7222);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleLogicalSystem7235); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3630:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==101) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3631:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3631:1: (lv_annotations_4_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3632:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleLogicalSystem7256);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_4_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3648:3: ( (lv_subSystems_5_0= ruleSubSystemRef ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==64) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3649:1: (lv_subSystems_5_0= ruleSubSystemRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3649:1: (lv_subSystems_5_0= ruleSubSystemRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3650:3: lv_subSystems_5_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem7278);
            	    lv_subSystems_5_0=ruleSubSystemRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystems",
            	            		lv_subSystems_5_0, 
            	            		"SubSystemRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3666:3: ( (lv_bindings_6_0= ruleBinding ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==69) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3667:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3667:1: (lv_bindings_6_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3668:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleLogicalSystem7300);
            	    lv_bindings_6_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_6_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3684:3: ( (lv_connections_7_0= ruleLayerConnection ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==72) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3685:1: (lv_connections_7_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3685:1: (lv_connections_7_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3686:3: lv_connections_7_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleLogicalSystem7322);
            	    lv_connections_7_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_7_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleLogicalSystem7335); 

                	newLeafNode(otherlv_8, grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3716:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3717:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3718:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             newCompositeNode(grammarAccess.getSubSystemRefRule()); 
            pushFollow(FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef7373);
            iv_ruleSubSystemRef=ruleSubSystemRef();

            state._fsp--;

             current =iv_ruleSubSystemRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemRef7383); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3725:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3728:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3729:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3729:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3729:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleSubSystemRef7420); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3733:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3734:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3734:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3735:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemRef7437); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleSubSystemRef7454); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemRefAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3755:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3756:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3756:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3757:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleSubSystemRef7477);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3770:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==28) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3771:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3771:1: (lv_docu_4_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3772:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemRef7498);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3796:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3797:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3798:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             newCompositeNode(grammarAccess.getSubSystemClassRule()); 
            pushFollow(FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass7535);
            iv_ruleSubSystemClass=ruleSubSystemClass();

            state._fsp--;

             current =iv_ruleSubSystemClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubSystemClass7545); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3805:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( (lv_relayPorts_11_0= rulePort ) )* ( (lv_ifSPPs_12_0= ruleSPPRef ) )* ( (lv_actorRefs_13_0= ruleActorRef ) )* ( (lv_bindings_14_0= ruleBinding ) )* ( (lv_connections_15_0= ruleLayerConnection ) )* ( (lv_threads_16_0= ruleLogicalThread ) )* otherlv_17= '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_17=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_userCode1_6_0 = null;

        EObject lv_userCode2_8_0 = null;

        EObject lv_userCode3_10_0 = null;

        EObject lv_relayPorts_11_0 = null;

        EObject lv_ifSPPs_12_0 = null;

        EObject lv_actorRefs_13_0 = null;

        EObject lv_bindings_14_0 = null;

        EObject lv_connections_15_0 = null;

        EObject lv_threads_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3808:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( (lv_relayPorts_11_0= rulePort ) )* ( (lv_ifSPPs_12_0= ruleSPPRef ) )* ( (lv_actorRefs_13_0= ruleActorRef ) )* ( (lv_bindings_14_0= ruleBinding ) )* ( (lv_connections_15_0= ruleLayerConnection ) )* ( (lv_threads_16_0= ruleLogicalThread ) )* otherlv_17= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3809:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( (lv_relayPorts_11_0= rulePort ) )* ( (lv_ifSPPs_12_0= ruleSPPRef ) )* ( (lv_actorRefs_13_0= ruleActorRef ) )* ( (lv_bindings_14_0= ruleBinding ) )* ( (lv_connections_15_0= ruleLayerConnection ) )* ( (lv_threads_16_0= ruleLogicalThread ) )* otherlv_17= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3809:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( (lv_relayPorts_11_0= rulePort ) )* ( (lv_ifSPPs_12_0= ruleSPPRef ) )* ( (lv_actorRefs_13_0= ruleActorRef ) )* ( (lv_bindings_14_0= ruleBinding ) )* ( (lv_connections_15_0= ruleLayerConnection ) )* ( (lv_threads_16_0= ruleLogicalThread ) )* otherlv_17= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3809:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( (lv_relayPorts_11_0= rulePort ) )* ( (lv_ifSPPs_12_0= ruleSPPRef ) )* ( (lv_actorRefs_13_0= ruleActorRef ) )* ( (lv_bindings_14_0= ruleBinding ) )* ( (lv_connections_15_0= ruleLayerConnection ) )* ( (lv_threads_16_0= ruleLogicalThread ) )* otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_65_in_ruleSubSystemClass7582); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3813:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3814:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3814:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3815:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubSystemClass7599); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3831:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==28) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3832:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3832:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3833:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSubSystemClass7625);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleSubSystemClass7638); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3853:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==101) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3854:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3854:1: (lv_annotations_4_0= ruleAnnotation )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3855:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnnotation_in_ruleSubSystemClass7659);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_4_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3871:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==24) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3871:5: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleSubSystemClass7673); 

                        	newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3875:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3876:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3876:1: (lv_userCode1_6_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3877:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass7694);
                    lv_userCode1_6_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_6_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3893:4: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==25) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3893:6: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleSubSystemClass7709); 

                        	newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3897:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3898:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3898:1: (lv_userCode2_8_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3899:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass7730);
                    lv_userCode2_8_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_8_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3915:4: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==26) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3915:6: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleSubSystemClass7745); 

                        	newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3919:1: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3920:1: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3920:1: (lv_userCode3_10_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3921:3: lv_userCode3_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleSubSystemClass7766);
                    lv_userCode3_10_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_10_0, 
                            		"DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3937:4: ( (lv_relayPorts_11_0= rulePort ) )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( ((LA104_0>=56 && LA104_0<=57)) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3938:1: (lv_relayPorts_11_0= rulePort )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3938:1: (lv_relayPorts_11_0= rulePort )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3939:3: lv_relayPorts_11_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePort_in_ruleSubSystemClass7789);
            	    lv_relayPorts_11_0=rulePort();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relayPorts",
            	            		lv_relayPorts_11_0, 
            	            		"Port");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3955:3: ( (lv_ifSPPs_12_0= ruleSPPRef ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==60) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3956:1: (lv_ifSPPs_12_0= ruleSPPRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3956:1: (lv_ifSPPs_12_0= ruleSPPRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3957:3: lv_ifSPPs_12_0= ruleSPPRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getIfSPPsSPPRefParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSPPRef_in_ruleSubSystemClass7811);
            	    lv_ifSPPs_12_0=ruleSPPRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ifSPPs",
            	            		lv_ifSPPs_12_0, 
            	            		"SPPRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3973:3: ( (lv_actorRefs_13_0= ruleActorRef ) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==75) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3974:1: (lv_actorRefs_13_0= ruleActorRef )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3974:1: (lv_actorRefs_13_0= ruleActorRef )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3975:3: lv_actorRefs_13_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorRef_in_ruleSubSystemClass7833);
            	    lv_actorRefs_13_0=ruleActorRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorRefs",
            	            		lv_actorRefs_13_0, 
            	            		"ActorRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop106;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3991:3: ( (lv_bindings_14_0= ruleBinding ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==69) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3992:1: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3992:1: (lv_bindings_14_0= ruleBinding )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:3993:3: lv_bindings_14_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBinding_in_ruleSubSystemClass7855);
            	    lv_bindings_14_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_14_0, 
            	            		"Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4009:3: ( (lv_connections_15_0= ruleLayerConnection ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==72) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4010:1: (lv_connections_15_0= ruleLayerConnection )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4010:1: (lv_connections_15_0= ruleLayerConnection )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4011:3: lv_connections_15_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLayerConnection_in_ruleSubSystemClass7877);
            	    lv_connections_15_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_15_0, 
            	            		"LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4027:3: ( (lv_threads_16_0= ruleLogicalThread ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==66) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4028:1: (lv_threads_16_0= ruleLogicalThread )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4028:1: (lv_threads_16_0= ruleLogicalThread )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4029:3: lv_threads_16_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_13_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalThread_in_ruleSubSystemClass7899);
            	    lv_threads_16_0=ruleLogicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_16_0, 
            	            		"LogicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);

            otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleSubSystemClass7912); 

                	newLeafNode(otherlv_17, grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_14());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4057:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4058:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4059:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             newCompositeNode(grammarAccess.getLogicalThreadRule()); 
            pushFollow(FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread7948);
            iv_ruleLogicalThread=ruleLogicalThread();

            state._fsp--;

             current =iv_ruleLogicalThread; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalThread7958); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4066:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4069:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4070:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4070:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4070:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'prio' otherlv_3= '=' ( (lv_prio_4_0= RULE_INT ) ) otherlv_5= '{' ( (lv_instances_6_0= ruleActorInstancePath ) ) (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleLogicalThread7995); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4074:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4075:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4075:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4076:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLogicalThread8012); 

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

            otherlv_2=(Token)match(input,67,FOLLOW_67_in_ruleLogicalThread8029); 

                	newLeafNode(otherlv_2, grammarAccess.getLogicalThreadAccess().getPrioKeyword_2());
                
            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleLogicalThread8041); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalThreadAccess().getEqualsSignKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4100:1: ( (lv_prio_4_0= RULE_INT ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4101:1: (lv_prio_4_0= RULE_INT )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4101:1: (lv_prio_4_0= RULE_INT )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4102:3: lv_prio_4_0= RULE_INT
            {
            lv_prio_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLogicalThread8058); 

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

            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleLogicalThread8075); 

                	newLeafNode(otherlv_5, grammarAccess.getLogicalThreadAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4122:1: ( (lv_instances_6_0= ruleActorInstancePath ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4123:1: (lv_instances_6_0= ruleActorInstancePath )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4123:1: (lv_instances_6_0= ruleActorInstancePath )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4124:3: lv_instances_6_0= ruleActorInstancePath
            {
             
            	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread8096);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4140:2: (otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==33) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4140:4: otherlv_7= ',' ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    {
            	    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleLogicalThread8109); 

            	        	newLeafNode(otherlv_7, grammarAccess.getLogicalThreadAccess().getCommaKeyword_7_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4144:1: ( (lv_instances_8_0= ruleActorInstancePath ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4145:1: (lv_instances_8_0= ruleActorInstancePath )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4145:1: (lv_instances_8_0= ruleActorInstancePath )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4146:3: lv_instances_8_0= ruleActorInstancePath
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalThreadAccess().getInstancesActorInstancePathParserRuleCall_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleActorInstancePath_in_ruleLogicalThread8130);
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
            	    break loop110;
                }
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_13_in_ruleLogicalThread8144); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4174:1: entryRuleActorInstancePath returns [EObject current=null] : iv_ruleActorInstancePath= ruleActorInstancePath EOF ;
    public final EObject entryRuleActorInstancePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstancePath = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4175:2: (iv_ruleActorInstancePath= ruleActorInstancePath EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4176:2: iv_ruleActorInstancePath= ruleActorInstancePath EOF
            {
             newCompositeNode(grammarAccess.getActorInstancePathRule()); 
            pushFollow(FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath8180);
            iv_ruleActorInstancePath=ruleActorInstancePath();

            state._fsp--;

             current =iv_ruleActorInstancePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorInstancePath8190); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4183:1: ruleActorInstancePath returns [EObject current=null] : ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleActorInstancePath() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;
        Token otherlv_1=null;
        Token lv_segments_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4186:28: ( ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4187:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4187:1: ( ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4187:2: ( (lv_segments_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4187:2: ( (lv_segments_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4188:1: (lv_segments_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4188:1: (lv_segments_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4189:3: lv_segments_0_0= RULE_ID
            {
            lv_segments_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath8232); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4205:2: (otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==68) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4205:4: otherlv_1= '.' ( (lv_segments_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleActorInstancePath8250); 

            	        	newLeafNode(otherlv_1, grammarAccess.getActorInstancePathAccess().getFullStopKeyword_1_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4209:1: ( (lv_segments_2_0= RULE_ID ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4210:1: (lv_segments_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4210:1: (lv_segments_2_0= RULE_ID )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4211:3: lv_segments_2_0= RULE_ID
            	    {
            	    lv_segments_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorInstancePath8267); 

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
            	    break loop111;
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4235:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4236:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4237:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding8310);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding8320); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4244:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4247:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4248:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleBinding8357); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4252:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4253:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4253:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4254:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding8378);
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

            otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleBinding8390); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4274:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4275:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4275:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4276:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleBindingEndPoint_in_ruleBinding8411);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4300:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4301:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4302:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             newCompositeNode(grammarAccess.getBindingEndPointRule()); 
            pushFollow(FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint8447);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();

            state._fsp--;

             current =iv_ruleBindingEndPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingEndPoint8457); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4309:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4312:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_ID) ) {
                int LA112_1 = input.LA(2);

                if ( (LA112_1==68) ) {
                    alt112=1;
                }
            }
            switch (alt112) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4313:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4314:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4314:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4315:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint8503); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleBindingEndPoint8515); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4330:3: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4331:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4331:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4332:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint8537); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4343:2: (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==71) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4343:4: otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,71,FOLLOW_71_in_ruleBindingEndPoint8550); 

                        	newLeafNode(otherlv_3, grammarAccess.getBindingEndPointAccess().getSubKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4347:1: ( (otherlv_4= RULE_ID ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4348:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4348:1: (otherlv_4= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4349:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBindingEndPoint8570); 

                    		newLeafNode(otherlv_4, grammarAccess.getBindingEndPointAccess().getSubSubProtocolCrossReference_2_1_0()); 
                    	

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
    // $ANTLR end "ruleBindingEndPoint"


    // $ANTLR start "entryRuleLayerConnection"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4368:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4369:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4370:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             newCompositeNode(grammarAccess.getLayerConnectionRule()); 
            pushFollow(FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection8608);
            iv_ruleLayerConnection=ruleLayerConnection();

            state._fsp--;

             current =iv_ruleLayerConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerConnection8618); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4377:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4380:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4381:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4381:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4381:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleLayerConnection8655); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4385:1: ( (lv_from_1_0= ruleSAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4386:1: (lv_from_1_0= ruleSAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4386:1: (lv_from_1_0= ruleSAPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4387:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSAPoint_in_ruleLayerConnection8676);
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

            otherlv_2=(Token)match(input,73,FOLLOW_73_in_ruleLayerConnection8688); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4407:1: ( (lv_to_3_0= ruleSPPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4408:1: (lv_to_3_0= ruleSPPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4408:1: (lv_to_3_0= ruleSPPoint )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4409:3: lv_to_3_0= ruleSPPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleSPPoint_in_ruleLayerConnection8709);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4433:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4434:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4435:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             newCompositeNode(grammarAccess.getSAPointRule()); 
            pushFollow(FOLLOW_ruleSAPoint_in_entryRuleSAPoint8745);
            iv_ruleSAPoint=ruleSAPoint();

            state._fsp--;

             current =iv_ruleSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSAPoint8755); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4442:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4445:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4446:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4446:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==15) ) {
                alt114=1;
            }
            else if ( (LA114_0==74) ) {
                alt114=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4447:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRefSAPoint_in_ruleSAPoint8802);
                    this_RefSAPoint_0=ruleRefSAPoint();

                    state._fsp--;

                     
                            current = this_RefSAPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4457:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRelaySAPoint_in_ruleSAPoint8829);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4473:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4474:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4475:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             newCompositeNode(grammarAccess.getRefSAPointRule()); 
            pushFollow(FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint8864);
            iv_ruleRefSAPoint=ruleRefSAPoint();

            state._fsp--;

             current =iv_ruleRefSAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefSAPoint8874); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4482:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4485:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4486:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4486:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4486:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleRefSAPoint8911); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4490:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4491:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4491:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4492:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefSAPoint8931); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4511:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4512:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4513:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             newCompositeNode(grammarAccess.getRelaySAPointRule()); 
            pushFollow(FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint8967);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();

            state._fsp--;

             current =iv_ruleRelaySAPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelaySAPoint8977); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4520:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4523:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4524:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4524:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4524:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleRelaySAPoint9014); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4528:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4529:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4529:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4530:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRelaySAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelaySAPoint9034); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4549:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4550:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4551:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             newCompositeNode(grammarAccess.getSPPointRule()); 
            pushFollow(FOLLOW_ruleSPPoint_in_entryRuleSPPoint9070);
            iv_ruleSPPoint=ruleSPPoint();

            state._fsp--;

             current =iv_ruleSPPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPPoint9080); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4558:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4561:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4562:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4562:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4562:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4562:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4563:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4563:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4564:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint9125); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleSPPoint9137); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4579:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4580:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4580:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4581:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPPoint9157); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4600:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4601:2: (iv_ruleActorRef= ruleActorRef EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4602:2: iv_ruleActorRef= ruleActorRef EOF
            {
             newCompositeNode(grammarAccess.getActorRefRule()); 
            pushFollow(FOLLOW_ruleActorRef_in_entryRuleActorRef9193);
            iv_ruleActorRef=ruleActorRef();

            state._fsp--;

             current =iv_ruleActorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActorRef9203); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4609:1: ruleActorRef returns [EObject current=null] : (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( ( ruleFQN ) ) ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_size_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_docu_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4612:28: ( (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( ( ruleFQN ) ) ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4613:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( ( ruleFQN ) ) ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4613:1: (otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( ( ruleFQN ) ) ( (lv_docu_7_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4613:3: otherlv_0= 'ActorRef' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( ( ruleFQN ) ) ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleActorRef9240); 

                	newLeafNode(otherlv_0, grammarAccess.getActorRefAccess().getActorRefKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4617:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4618:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4618:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4619:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActorRef9257); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4635:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==28) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4635:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleActorRef9275); 

                        	newLeafNode(otherlv_2, grammarAccess.getActorRefAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4639:1: ( (lv_size_3_0= RULE_INT ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4640:1: (lv_size_3_0= RULE_INT )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4640:1: (lv_size_3_0= RULE_INT )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4641:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleActorRef9292); 

                    			newLeafNode(lv_size_3_0, grammarAccess.getActorRefAccess().getSizeINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"size",
                            		lv_size_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleActorRef9309); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorRefAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleActorRef9323); 

                	newLeafNode(otherlv_5, grammarAccess.getActorRefAccess().getColonKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4665:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4666:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4666:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4667:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleActorRef9346);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4680:2: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==28) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4681:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4681:1: (lv_docu_7_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4682:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getDocuDocumentationParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleActorRef9367);
                    lv_docu_7_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_7_0, 
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4706:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4707:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4708:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
            {
             newCompositeNode(grammarAccess.getStateGraphNodeRule()); 
            pushFollow(FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode9404);
            iv_ruleStateGraphNode=ruleStateGraphNode();

            state._fsp--;

             current =iv_ruleStateGraphNode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraphNode9414); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4715:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4718:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4719:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt117=3;
            switch ( input.LA(1) ) {
            case 77:
            case 82:
                {
                alt117=1;
                }
                break;
            case 87:
                {
                alt117=2;
                }
                break;
            case 83:
            case 84:
            case 85:
            case 86:
                {
                alt117=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4720:5: this_State_0= ruleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateGraphNode9461);
                    this_State_0=ruleState();

                    state._fsp--;

                     
                            current = this_State_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4730:5: this_ChoicePoint_1= ruleChoicePoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getChoicePointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraphNode9488);
                    this_ChoicePoint_1=ruleChoicePoint();

                    state._fsp--;

                     
                            current = this_ChoicePoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4740:5: this_TrPoint_2= ruleTrPoint
                    {
                     
                            newCompositeNode(grammarAccess.getStateGraphNodeAccess().getTrPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraphNode9515);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4758:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4759:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4760:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState9552);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState9562); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4767:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4770:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4771:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4771:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==77) ) {
                alt118=1;
            }
            else if ( (LA118_0==82) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4772:5: this_SimpleState_0= ruleSimpleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleState_in_ruleState9609);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;

                     
                            current = this_SimpleState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4782:5: this_RefinedState_1= ruleRefinedState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getRefinedStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefinedState_in_ruleState9636);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4798:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4799:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4800:2: iv_ruleStateGraph= ruleStateGraph EOF
            {
             newCompositeNode(grammarAccess.getStateGraphRule()); 
            pushFollow(FOLLOW_ruleStateGraph_in_entryRuleStateGraph9671);
            iv_ruleStateGraph=ruleStateGraph();

            state._fsp--;

             current =iv_ruleStateGraph; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateGraph9681); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4807:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4810:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4811:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4811:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4811:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4811:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4812:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleStateGraph9727); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4821:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop119:
            do {
                int alt119=6;
                switch ( input.LA(1) ) {
                case 77:
                case 82:
                    {
                    alt119=1;
                    }
                    break;
                case 83:
                case 84:
                case 85:
                case 86:
                    {
                    alt119=2;
                    }
                    break;
                case 87:
                    {
                    alt119=3;
                    }
                    break;
                case 88:
                    {
                    alt119=4;
                    }
                    break;
                case 95:
                    {
                    alt119=5;
                    }
                    break;

                }

                switch (alt119) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4821:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4821:2: ( (lv_states_2_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4822:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4822:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4823:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateGraph9749);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4840:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4840:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4841:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4841:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4842:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateGraph9776);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4859:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4859:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4860:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4860:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4861:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateGraph9803);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4878:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4878:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4879:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4879:1: (lv_transitions_5_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4880:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateGraph9830);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4897:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4897:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4898:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4898:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4899:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateGraph9857);
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
            	    break loop119;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleStateGraph9871); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4927:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4928:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4929:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine9907);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine9917); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4936:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4939:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4940:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4940:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4940:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4940:2: ()
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4941:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleStateMachine9963); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleStateMachine9975); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4954:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop120:
            do {
                int alt120=6;
                switch ( input.LA(1) ) {
                case 77:
                case 82:
                    {
                    alt120=1;
                    }
                    break;
                case 83:
                case 84:
                case 85:
                case 86:
                    {
                    alt120=2;
                    }
                    break;
                case 87:
                    {
                    alt120=3;
                    }
                    break;
                case 88:
                    {
                    alt120=4;
                    }
                    break;
                case 95:
                    {
                    alt120=5;
                    }
                    break;

                }

                switch (alt120) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4954:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4954:2: ( (lv_states_3_0= ruleState ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4955:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4955:1: (lv_states_3_0= ruleState )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4956:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachine9997);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4973:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4973:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4974:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4974:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4975:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrPoint_in_ruleStateMachine10024);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4992:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4992:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4993:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4993:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:4994:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleChoicePoint_in_ruleStateMachine10051);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5011:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5011:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5012:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5012:1: (lv_transitions_6_0= ruleTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5013:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStateMachine10078);
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
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5030:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5030:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5031:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5031:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5032:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRefinedTransition_in_ruleStateMachine10105);
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
            	    break loop120;
                }
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleStateMachine10119); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5060:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5061:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5062:2: iv_ruleSimpleState= ruleSimpleState EOF
            {
             newCompositeNode(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_ruleSimpleState_in_entryRuleSimpleState10155);
            iv_ruleSimpleState=ruleSimpleState();

            state._fsp--;

             current =iv_ruleSimpleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleState10165); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5069:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5072:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5073:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,77,FOLLOW_77_in_ruleSimpleState10202); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5077:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5078:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5078:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5079:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleState10219); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5095:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==28) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5096:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5096:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5097:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleSimpleState10245);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5113:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==12) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5113:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleSimpleState10259); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5117:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==78) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5117:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,78,FOLLOW_78_in_ruleSimpleState10272); 

                                	newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5121:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5122:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5122:1: (lv_entryCode_5_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5123:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState10293);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5139:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==79) ) {
                        alt123=1;
                    }
                    switch (alt123) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5139:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,79,FOLLOW_79_in_ruleSimpleState10308); 

                                	newLeafNode(otherlv_6, grammarAccess.getSimpleStateAccess().getExitKeyword_3_2_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5143:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5144:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5144:1: (lv_exitCode_7_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5145:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState10329);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5161:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==80) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5161:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,80,FOLLOW_80_in_ruleSimpleState10344); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDoKeyword_3_3_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5165:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5166:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5166:1: (lv_doCode_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5167:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleSimpleState10365);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5183:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==81) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5183:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,81,FOLLOW_81_in_ruleSimpleState10380); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5187:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5188:1: (lv_subgraph_11_0= ruleStateGraph )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5188:1: (lv_subgraph_11_0= ruleStateGraph )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5189:3: lv_subgraph_11_0= ruleStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleStateGraph_in_ruleSimpleState10401);
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

                    otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleSimpleState10415); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5217:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5218:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5219:2: iv_ruleRefinedState= ruleRefinedState EOF
            {
             newCompositeNode(grammarAccess.getRefinedStateRule()); 
            pushFollow(FOLLOW_ruleRefinedState_in_entryRuleRefinedState10453);
            iv_ruleRefinedState=ruleRefinedState();

            state._fsp--;

             current =iv_ruleRefinedState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedState10463); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5226:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5229:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5230:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5230:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5230:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleRefinedState10500); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5234:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5235:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5235:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5236:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedStateRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedStateAccess().getTargetStateCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedState10523);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5249:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==28) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5250:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5250:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5251:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedState10544);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRefinedState10557); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5271:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==78) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5271:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,78,FOLLOW_78_in_ruleRefinedState10570); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5275:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5276:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5276:1: (lv_entryCode_5_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5277:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState10591);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5293:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==79) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5293:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,79,FOLLOW_79_in_ruleRefinedState10606); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5297:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5298:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5298:1: (lv_exitCode_7_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5299:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState10627);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5315:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==80) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5315:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,80,FOLLOW_80_in_ruleRefinedState10642); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5319:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5320:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5320:1: (lv_doCode_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5321:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedState10663);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5337:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==81) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5337:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,81,FOLLOW_81_in_ruleRefinedState10678); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5341:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5342:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5342:1: (lv_subgraph_11_0= ruleStateGraph )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5343:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStateGraph_in_ruleRefinedState10699);
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

            otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleRefinedState10713); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5371:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5372:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5373:2: iv_ruleDetailCode= ruleDetailCode EOF
            {
             newCompositeNode(grammarAccess.getDetailCodeRule()); 
            pushFollow(FOLLOW_ruleDetailCode_in_entryRuleDetailCode10749);
            iv_ruleDetailCode=ruleDetailCode();

            state._fsp--;

             current =iv_ruleDetailCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetailCode10759); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5380:1: ruleDetailCode returns [EObject current=null] : (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_commands_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5383:28: ( (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5384:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5384:1: (otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5384:3: otherlv_0= '{' ( (lv_commands_1_0= RULE_STRING ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleDetailCode10796); 

                	newLeafNode(otherlv_0, grammarAccess.getDetailCodeAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5388:1: ( (lv_commands_1_0= RULE_STRING ) )+
            int cnt132=0;
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==RULE_STRING) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5389:1: (lv_commands_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5389:1: (lv_commands_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5390:3: lv_commands_1_0= RULE_STRING
            	    {
            	    lv_commands_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDetailCode10813); 

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
            	    if ( cnt132 >= 1 ) break loop132;
                        EarlyExitException eee =
                            new EarlyExitException(132, input);
                        throw eee;
                }
                cnt132++;
            } while (true);

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleDetailCode10831); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5418:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5419:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5420:2: iv_ruleTrPoint= ruleTrPoint EOF
            {
             newCompositeNode(grammarAccess.getTrPointRule()); 
            pushFollow(FOLLOW_ruleTrPoint_in_entryRuleTrPoint10867);
            iv_ruleTrPoint=ruleTrPoint();

            state._fsp--;

             current =iv_ruleTrPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPoint10877); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5427:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5430:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5431:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5431:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt133=3;
            switch ( input.LA(1) ) {
            case 83:
            case 84:
                {
                alt133=1;
                }
                break;
            case 85:
                {
                alt133=2;
                }
                break;
            case 86:
                {
                alt133=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5432:5: this_TransitionPoint_0= ruleTransitionPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getTransitionPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionPoint_in_ruleTrPoint10924);
                    this_TransitionPoint_0=ruleTransitionPoint();

                    state._fsp--;

                     
                            current = this_TransitionPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5442:5: this_EntryPoint_1= ruleEntryPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getEntryPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryPoint_in_ruleTrPoint10951);
                    this_EntryPoint_1=ruleEntryPoint();

                    state._fsp--;

                     
                            current = this_EntryPoint_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5452:5: this_ExitPoint_2= ruleExitPoint
                    {
                     
                            newCompositeNode(grammarAccess.getTrPointAccess().getExitPointParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExitPoint_in_ruleTrPoint10978);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5468:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5469:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5470:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
            {
             newCompositeNode(grammarAccess.getTransitionPointRule()); 
            pushFollow(FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint11013);
            iv_ruleTransitionPoint=ruleTransitionPoint();

            state._fsp--;

             current =iv_ruleTransitionPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionPoint11023); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5477:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5480:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5481:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==83) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5482:1: (lv_handler_0_0= 'handler' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5482:1: (lv_handler_0_0= 'handler' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5483:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,83,FOLLOW_83_in_ruleTransitionPoint11066); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,84,FOLLOW_84_in_ruleTransitionPoint11092); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5500:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5501:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5501:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5502:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionPoint11109); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5526:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5527:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5528:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
             newCompositeNode(grammarAccess.getEntryPointRule()); 
            pushFollow(FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint11150);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;

             current =iv_ruleEntryPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPoint11160); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5535:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5538:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5539:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5539:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5539:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,85,FOLLOW_85_in_ruleEntryPoint11197); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5543:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5544:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5544:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5545:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPoint11214); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5569:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5570:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5571:2: iv_ruleExitPoint= ruleExitPoint EOF
            {
             newCompositeNode(grammarAccess.getExitPointRule()); 
            pushFollow(FOLLOW_ruleExitPoint_in_entryRuleExitPoint11255);
            iv_ruleExitPoint=ruleExitPoint();

            state._fsp--;

             current =iv_ruleExitPoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPoint11265); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5578:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5581:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5582:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5582:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5582:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,86,FOLLOW_86_in_ruleExitPoint11302); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5586:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5587:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5587:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5588:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPoint11319); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5612:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5613:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5614:2: iv_ruleChoicePoint= ruleChoicePoint EOF
            {
             newCompositeNode(grammarAccess.getChoicePointRule()); 
            pushFollow(FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint11360);
            iv_ruleChoicePoint=ruleChoicePoint();

            state._fsp--;

             current =iv_ruleChoicePoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicePoint11370); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5621:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5624:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5625:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5625:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5625:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,87,FOLLOW_87_in_ruleChoicePoint11407); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5629:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5630:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5630:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5631:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicePoint11424); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5647:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==28) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5648:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5648:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5649:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getChoicePointAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleChoicePoint11450);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5673:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5674:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5675:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition11487);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition11497); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5682:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5685:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5686:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5686:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==88) ) {
                int LA136_1 = input.LA(2);

                if ( (LA136_1==RULE_ID) ) {
                    int LA136_2 = input.LA(3);

                    if ( (LA136_2==14) ) {
                        int LA136_3 = input.LA(4);

                        if ( (LA136_3==89) ) {
                            alt136=1;
                        }
                        else if ( (LA136_3==RULE_ID||(LA136_3>=96 && LA136_3<=97)) ) {
                            alt136=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 136, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 136, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA136_1==14) ) {
                    int LA136_3 = input.LA(3);

                    if ( (LA136_3==89) ) {
                        alt136=1;
                    }
                    else if ( (LA136_3==RULE_ID||(LA136_3>=96 && LA136_3<=97)) ) {
                        alt136=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 136, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 136, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5687:5: this_InitialTransition_0= ruleInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getInitialTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInitialTransition_in_ruleTransition11544);
                    this_InitialTransition_0=ruleInitialTransition();

                    state._fsp--;

                     
                            current = this_InitialTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5697:5: this_NonInitialTransition_1= ruleNonInitialTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getNonInitialTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNonInitialTransition_in_ruleTransition11571);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5713:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5714:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5715:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getNonInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition11606);
            iv_ruleNonInitialTransition=ruleNonInitialTransition();

            state._fsp--;

             current =iv_ruleNonInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonInitialTransition11616); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5722:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5725:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5726:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5726:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt137=3;
            alt137 = dfa137.predict(input);
            switch (alt137) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5727:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getTransitionChainStartTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition11663);
                    this_TransitionChainStartTransition_0=ruleTransitionChainStartTransition();

                    state._fsp--;

                     
                            current = this_TransitionChainStartTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5737:5: this_ContinuationTransition_1= ruleContinuationTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getContinuationTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition11690);
                    this_ContinuationTransition_1=ruleContinuationTransition();

                    state._fsp--;

                     
                            current = this_ContinuationTransition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5747:5: this_CPBranchTransition_2= ruleCPBranchTransition
                    {
                     
                            newCompositeNode(grammarAccess.getNonInitialTransitionAccess().getCPBranchTransitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition11717);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5763:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5764:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5765:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionChainStartTransitionRule()); 
            pushFollow(FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition11752);
            iv_ruleTransitionChainStartTransition=ruleTransitionChainStartTransition();

            state._fsp--;

             current =iv_ruleTransitionChainStartTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionChainStartTransition11762); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5772:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5775:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5776:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5776:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt138=2;
            alt138 = dfa138.predict(input);
            switch (alt138) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5777:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition11809);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;

                     
                            current = this_TriggeredTransition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5787:5: this_GuardedTransition_1= ruleGuardedTransition
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionChainStartTransitionAccess().getGuardedTransitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition11836);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5803:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5804:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5805:2: iv_ruleInitialTransition= ruleInitialTransition EOF
            {
             newCompositeNode(grammarAccess.getInitialTransitionRule()); 
            pushFollow(FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition11871);
            iv_ruleInitialTransition=ruleInitialTransition();

            state._fsp--;

             current =iv_ruleInitialTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitialTransition11881); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5812:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5815:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5816:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5816:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5816:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_88_in_ruleInitialTransition11918); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5820:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==RULE_ID) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5821:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5821:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5822:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInitialTransition11935); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleInitialTransition11953); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,89,FOLLOW_89_in_ruleInitialTransition11965); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleInitialTransition11977); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5850:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5851:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5851:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5852:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition11998);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5868:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==28) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5869:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5869:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5870:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleInitialTransition12019);
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

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleInitialTransition12032); 

                	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5890:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==90) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5890:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,90,FOLLOW_90_in_ruleInitialTransition12045); 

                        	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_8_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5894:1: ( (lv_action_9_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5895:1: (lv_action_9_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5895:1: (lv_action_9_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5896:3: lv_action_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleInitialTransition12066);
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

            otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleInitialTransition12080); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5924:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5925:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5926:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
            {
             newCompositeNode(grammarAccess.getContinuationTransitionRule()); 
            pushFollow(FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition12116);
            iv_ruleContinuationTransition=ruleContinuationTransition();

            state._fsp--;

             current =iv_ruleContinuationTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContinuationTransition12126); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5933:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5936:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5937:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5937:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5937:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,88,FOLLOW_88_in_ruleContinuationTransition12163); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5941:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==RULE_ID) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5942:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5942:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5943:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContinuationTransition12180); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleContinuationTransition12198); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5963:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5964:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5964:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5965:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition12219);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleContinuationTransition12231); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5985:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5986:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5986:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:5987:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition12252);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6003:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==28) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6004:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6004:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6005:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleContinuationTransition12273);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6021:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==12) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6021:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleContinuationTransition12287); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6025:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt144=2;
                    int LA144_0 = input.LA(1);

                    if ( (LA144_0==90) ) {
                        alt144=1;
                    }
                    switch (alt144) {
                        case 1 :
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6025:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,90,FOLLOW_90_in_ruleContinuationTransition12300); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6029:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6030:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6030:1: (lv_action_9_0= ruleDetailCode )
                            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6031:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleDetailCode_in_ruleContinuationTransition12321);
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

                    otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleContinuationTransition12335); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6059:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6060:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6061:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition12373);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;

             current =iv_ruleTriggeredTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition12383); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6068:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6071:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6072:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6072:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6072:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_88_in_ruleTriggeredTransition12420); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6076:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==RULE_ID) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6077:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6077:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6078:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition12437); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleTriggeredTransition12455); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6098:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6099:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6099:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6100:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition12476);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTriggeredTransition12488); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6120:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6121:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6121:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6122:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition12509);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6138:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==28) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6139:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6139:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6140:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleTriggeredTransition12530);
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

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleTriggeredTransition12543); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,91,FOLLOW_91_in_ruleTriggeredTransition12555); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,12,FOLLOW_12_in_ruleTriggeredTransition12567); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6168:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6169:1: (lv_triggers_10_0= ruleTrigger )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6169:1: (lv_triggers_10_0= ruleTrigger )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6170:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition12588);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6186:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);

                if ( (LA148_0==92) ) {
                    alt148=1;
                }


                switch (alt148) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6186:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,92,FOLLOW_92_in_ruleTriggeredTransition12601); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6190:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6191:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6191:1: (lv_triggers_12_0= ruleTrigger )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6192:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggeredTransition12622);
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
            	    break loop148;
                }
            } while (true);

            otherlv_13=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition12636); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6212:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==90) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6212:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,90,FOLLOW_90_in_ruleTriggeredTransition12649); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6216:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6217:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6217:1: (lv_action_15_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6218:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleTriggeredTransition12670);
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

            otherlv_16=(Token)match(input,13,FOLLOW_13_in_ruleTriggeredTransition12684); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6246:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6247:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6248:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
            {
             newCompositeNode(grammarAccess.getGuardedTransitionRule()); 
            pushFollow(FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition12720);
            iv_ruleGuardedTransition=ruleGuardedTransition();

            state._fsp--;

             current =iv_ruleGuardedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardedTransition12730); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6255:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6258:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6259:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_88_in_ruleGuardedTransition12767); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6263:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==RULE_ID) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6264:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6264:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6265:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuardedTransition12784); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleGuardedTransition12802); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6285:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6286:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6286:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6287:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition12823);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleGuardedTransition12835); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6307:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6308:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6308:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6309:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition12856);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6325:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==28) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6326:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6326:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6327:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleGuardedTransition12877);
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

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleGuardedTransition12890); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,93,FOLLOW_93_in_ruleGuardedTransition12902); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6351:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6352:1: (lv_guard_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6352:1: (lv_guard_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6353:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition12923);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6369:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==90) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6369:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,90,FOLLOW_90_in_ruleGuardedTransition12936); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6373:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6374:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6374:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6375:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleGuardedTransition12957);
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

            otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleGuardedTransition12971); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6403:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6404:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6405:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
            {
             newCompositeNode(grammarAccess.getCPBranchTransitionRule()); 
            pushFollow(FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition13007);
            iv_ruleCPBranchTransition=ruleCPBranchTransition();

            state._fsp--;

             current =iv_ruleCPBranchTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCPBranchTransition13017); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6412:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6415:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6416:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6416:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6416:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_88_in_ruleCPBranchTransition13054); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6420:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==RULE_ID) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6421:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6421:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6422:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCPBranchTransition13071); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleCPBranchTransition13089); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6442:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6443:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6443:1: (lv_from_3_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6444:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition13110);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleCPBranchTransition13122); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6464:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6465:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6465:1: (lv_to_5_0= ruleTransitionTerminal )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6466:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition13143);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6482:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==28) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6483:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6483:1: (lv_docu_6_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6484:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleCPBranchTransition13164);
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

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleCPBranchTransition13177); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,94,FOLLOW_94_in_ruleCPBranchTransition13189); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6508:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6509:1: (lv_condition_9_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6509:1: (lv_condition_9_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6510:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition13210);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6526:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==90) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6526:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,90,FOLLOW_90_in_ruleCPBranchTransition13223); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6530:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6531:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6531:1: (lv_action_11_0= ruleDetailCode )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6532:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDetailCode_in_ruleCPBranchTransition13244);
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

            otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleCPBranchTransition13258); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6560:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6561:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6562:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
            {
             newCompositeNode(grammarAccess.getRefinedTransitionRule()); 
            pushFollow(FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition13294);
            iv_ruleRefinedTransition=ruleRefinedTransition();

            state._fsp--;

             current =iv_ruleRefinedTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefinedTransition13304); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6569:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6572:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6573:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6573:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6573:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_95_in_ruleRefinedTransition13341); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6577:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6578:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6578:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6579:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getTargetTransitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleRefinedTransition13364);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6592:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==28) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6593:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6593:1: (lv_docu_2_0= ruleDocumentation )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6594:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDocumentation_in_ruleRefinedTransition13385);
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

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleRefinedTransition13398); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,90,FOLLOW_90_in_ruleRefinedTransition13410); 

                	newLeafNode(otherlv_4, grammarAccess.getRefinedTransitionAccess().getActionKeyword_4());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6618:1: ( (lv_action_5_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6619:1: (lv_action_5_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6619:1: (lv_action_5_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6620:3: lv_action_5_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleRefinedTransition13431);
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

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleRefinedTransition13443); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6648:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6649:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6650:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
            {
             newCompositeNode(grammarAccess.getTransitionTerminalRule()); 
            pushFollow(FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal13479);
            iv_ruleTransitionTerminal=ruleTransitionTerminal();

            state._fsp--;

             current =iv_ruleTransitionTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionTerminal13489); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6657:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6660:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6661:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6661:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt157=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA157_1 = input.LA(2);

                if ( (LA157_1==EOF||(LA157_1>=12 && LA157_1<=13)||LA157_1==17||LA157_1==28||LA157_1==77||(LA157_1>=82 && LA157_1<=88)||LA157_1==95) ) {
                    alt157=1;
                }
                else if ( (LA157_1==62) ) {
                    alt157=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 157, 1, input);

                    throw nvae;
                }
                }
                break;
            case 96:
                {
                alt157=2;
                }
                break;
            case 97:
                {
                alt157=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 157, 0, input);

                throw nvae;
            }

            switch (alt157) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6662:5: this_StateTerminal_0= ruleStateTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getStateTerminalParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal13536);
                    this_StateTerminal_0=ruleStateTerminal();

                    state._fsp--;

                     
                            current = this_StateTerminal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6672:5: this_TrPointTerminal_1= ruleTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getTrPointTerminalParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal13563);
                    this_TrPointTerminal_1=ruleTrPointTerminal();

                    state._fsp--;

                     
                            current = this_TrPointTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6682:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getSubStateTrPointTerminalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal13590);
                    this_SubStateTrPointTerminal_2=ruleSubStateTrPointTerminal();

                    state._fsp--;

                     
                            current = this_SubStateTrPointTerminal_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6692:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionTerminalAccess().getChoicepointTerminalParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal13617);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6708:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6709:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6710:2: iv_ruleStateTerminal= ruleStateTerminal EOF
            {
             newCompositeNode(grammarAccess.getStateTerminalRule()); 
            pushFollow(FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal13652);
            iv_ruleStateTerminal=ruleStateTerminal();

            state._fsp--;

             current =iv_ruleStateTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateTerminal13662); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6717:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6720:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6721:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6721:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6722:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6722:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6723:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStateTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateTerminal13706); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6742:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6743:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6744:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal13741);
            iv_ruleTrPointTerminal=ruleTrPointTerminal();

            state._fsp--;

             current =iv_ruleTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrPointTerminal13751); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6751:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6754:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6755:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6755:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6755:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_96_in_ruleTrPointTerminal13788); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6759:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6760:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6760:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6761:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrPointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTrPointTerminal13808); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6780:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6781:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6782:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
            {
             newCompositeNode(grammarAccess.getSubStateTrPointTerminalRule()); 
            pushFollow(FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal13844);
            iv_ruleSubStateTrPointTerminal=ruleSubStateTrPointTerminal();

            state._fsp--;

             current =iv_ruleSubStateTrPointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal13854); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6789:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6792:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6793:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6793:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6793:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6793:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6794:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6794:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6795:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal13899); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleSubStateTrPointTerminal13911); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6810:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6811:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6811:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6812:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal13931); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6831:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6832:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6833:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
            {
             newCompositeNode(grammarAccess.getChoicepointTerminalRule()); 
            pushFollow(FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal13967);
            iv_ruleChoicepointTerminal=ruleChoicepointTerminal();

            state._fsp--;

             current =iv_ruleChoicepointTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoicepointTerminal13977); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6840:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6843:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6844:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6844:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6844:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_97_in_ruleChoicepointTerminal14014); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6848:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6849:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6849:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6850:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getChoicepointTerminalRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoicepointTerminal14034); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6869:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6870:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6871:2: iv_ruleTrigger= ruleTrigger EOF
            {
             newCompositeNode(grammarAccess.getTriggerRule()); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger14070);
            iv_ruleTrigger=ruleTrigger();

            state._fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger14080); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6878:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6881:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6882:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6882:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6882:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_98_in_ruleTrigger14117); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6886:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6887:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6887:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6888:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger14138);
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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6904:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop158:
            do {
                int alt158=2;
                int LA158_0 = input.LA(1);

                if ( (LA158_0==99) ) {
                    alt158=1;
                }


                switch (alt158) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6904:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,99,FOLLOW_99_in_ruleTrigger14151); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6908:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6909:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6909:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6910:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMessageFromIf_in_ruleTrigger14172);
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
            	    break loop158;
                }
            } while (true);

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6926:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==93) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6927:1: (lv_guard_4_0= ruleGuard )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6927:1: (lv_guard_4_0= ruleGuard )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6928:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuard_in_ruleTrigger14195);
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

            otherlv_5=(Token)match(input,100,FOLLOW_100_in_ruleTrigger14208); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6956:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6957:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6958:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
            {
             newCompositeNode(grammarAccess.getMessageFromIfRule()); 
            pushFollow(FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf14244);
            iv_ruleMessageFromIf=ruleMessageFromIf();

            state._fsp--;

             current =iv_ruleMessageFromIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageFromIf14254); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6965:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6968:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6969:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6969:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6969:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6969:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6970:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6970:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6971:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf14299); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageMessageCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleMessageFromIf14311); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6986:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6987:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6987:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:6988:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMessageFromIf14331); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7007:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7008:2: (iv_ruleGuard= ruleGuard EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7009:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard14367);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard14377); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7016:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7019:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7020:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7020:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7020:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,93,FOLLOW_93_in_ruleGuard14414); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7024:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7025:1: (lv_guard_1_0= ruleDetailCode )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7025:1: (lv_guard_1_0= ruleDetailCode )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7026:3: lv_guard_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardAccess().getGuardDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDetailCode_in_ruleGuard14435);
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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7050:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7051:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7052:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation14471);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation14481); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7059:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7062:28: ( (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7063:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7063:1: (otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7063:3: otherlv_0= '[' ( (lv_text_1_0= RULE_STRING ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleDocumentation14518); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7067:1: ( (lv_text_1_0= RULE_STRING ) )+
            int cnt160=0;
            loop160:
            do {
                int alt160=2;
                int LA160_0 = input.LA(1);

                if ( (LA160_0==RULE_STRING) ) {
                    alt160=1;
                }


                switch (alt160) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7068:1: (lv_text_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7068:1: (lv_text_1_0= RULE_STRING )
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7069:3: lv_text_1_0= RULE_STRING
            	    {
            	    lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDocumentation14535); 

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
            	    if ( cnt160 >= 1 ) break loop160;
                        EarlyExitException eee =
                            new EarlyExitException(160, input);
                        throw eee;
                }
                cnt160++;
            } while (true);

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleDocumentation14553); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7097:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7098:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7099:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation14589);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation14599); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7106:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7109:28: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7110:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7110:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7110:3: otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,101,FOLLOW_101_in_ruleAnnotation14636); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7114:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7115:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7115:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7116:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotation14653); 

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

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7132:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==18) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7132:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAnnotation14671); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7136:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7137:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7137:1: (lv_attributes_3_0= ruleKeyValue )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7138:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation14692);
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

                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7154:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop161:
                    do {
                        int alt161=2;
                        int LA161_0 = input.LA(1);

                        if ( (LA161_0==33) ) {
                            alt161=1;
                        }


                        switch (alt161) {
                    	case 1 :
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7154:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleAnnotation14705); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7158:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7159:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7159:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7160:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleKeyValue_in_ruleAnnotation14726);
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
                    	    break loop161;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleAnnotation14740); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7188:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7189:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7190:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue14778);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue14788); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7197:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7200:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7201:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7201:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7201:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7201:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7202:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7202:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7203:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValue14830); 

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

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleKeyValue14847); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7223:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7224:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7224:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7225:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyValue14864); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7249:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7250:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7251:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport14905);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport14915); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7258:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7261:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7262:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7262:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7262:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,102,FOLLOW_102_in_ruleImport14952); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7266:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==RULE_ID) ) {
                alt163=1;
            }
            else if ( (LA163_0==104) ) {
                alt163=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 163, 0, input);

                throw nvae;
            }
            switch (alt163) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7266:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7266:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7266:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7266:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7267:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7267:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7268:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImportedFQN_in_ruleImport14975);
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

                    otherlv_2=(Token)match(input,103,FOLLOW_103_in_ruleImport14987); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7289:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,104,FOLLOW_104_in_ruleImport15006); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7293:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7294:1: (lv_importURI_4_0= RULE_STRING )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7294:1: (lv_importURI_4_0= RULE_STRING )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7295:3: lv_importURI_4_0= RULE_STRING
            {
            lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport15024); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7319:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7320:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7321:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN15066);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN15077); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7328:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7331:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7332:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7332:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7333:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFQN_in_ruleImportedFQN15124);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7343:1: (kw= '.*' )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==105) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7344:2: kw= '.*'
                    {
                    kw=(Token)match(input,105,FOLLOW_105_in_ruleImportedFQN15143); 

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7357:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7358:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7359:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN15186);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN15197); 

            }

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
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7366:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7369:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7370:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7370:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7370:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN15237); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7377:1: (kw= '.' this_ID_2= RULE_ID )*
            loop165:
            do {
                int alt165=2;
                int LA165_0 = input.LA(1);

                if ( (LA165_0==68) ) {
                    alt165=1;
                }


                switch (alt165) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7378:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,68,FOLLOW_68_in_ruleFQN15256); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN15271); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop165;
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


    // $ANTLR start "entryRuleMULTIPLICITY"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7398:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7399:2: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7400:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
            {
             newCompositeNode(grammarAccess.getMULTIPLICITYRule()); 
            pushFollow(FOLLOW_ruleMULTIPLICITY_in_entryRuleMULTIPLICITY15319);
            iv_ruleMULTIPLICITY=ruleMULTIPLICITY();

            state._fsp--;

             current =iv_ruleMULTIPLICITY.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMULTIPLICITY15330); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMULTIPLICITY"


    // $ANTLR start "ruleMULTIPLICITY"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7407:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7410:28: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7411:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7411:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7412:2: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,28,FOLLOW_28_in_ruleMULTIPLICITY15368); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0()); 
                
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7417:1: (kw= '*' | this_INT_2= RULE_INT )
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==106) ) {
                alt166=1;
            }
            else if ( (LA166_0==RULE_INT) ) {
                alt166=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 166, 0, input);

                throw nvae;
            }
            switch (alt166) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7418:2: kw= '*'
                    {
                    kw=(Token)match(input,106,FOLLOW_106_in_ruleMULTIPLICITY15382); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7424:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleMULTIPLICITY15403); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getMULTIPLICITYAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,29,FOLLOW_29_in_ruleMULTIPLICITY15422); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getRightSquareBracketKeyword_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMULTIPLICITY"


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7445:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7447:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7448:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7448:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt167=4;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt167=1;
                }
                break;
            case 108:
                {
                alt167=2;
                }
                break;
            case 109:
                {
                alt167=3;
                }
                break;
            case 110:
                {
                alt167=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 167, 0, input);

                throw nvae;
            }

            switch (alt167) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7448:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7448:2: (enumLiteral_0= 'ptBoolean' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7448:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_107_in_ruleLiteralType15476); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7454:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7454:6: (enumLiteral_1= 'ptInteger' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7454:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_108_in_ruleLiteralType15493); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7460:6: (enumLiteral_2= 'ptReal' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7460:6: (enumLiteral_2= 'ptReal' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7460:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,109,FOLLOW_109_in_ruleLiteralType15510); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7466:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7466:6: (enumLiteral_3= 'ptCharacter' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7466:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,110,FOLLOW_110_in_ruleLiteralType15527); 

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


    // $ANTLR start "ruleCommunicationType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7476:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7478:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7479:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7479:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt168=3;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt168=1;
                }
                break;
            case 112:
                {
                alt168=2;
                }
                break;
            case 113:
                {
                alt168=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 168, 0, input);

                throw nvae;
            }

            switch (alt168) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7479:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7479:2: (enumLiteral_0= 'eventdriven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7479:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_111_in_ruleCommunicationType15572); 

                            current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7485:6: (enumLiteral_1= 'datadriven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7485:6: (enumLiteral_1= 'datadriven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7485:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_112_in_ruleCommunicationType15589); 

                            current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7491:6: (enumLiteral_2= 'sync' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7491:6: (enumLiteral_2= 'sync' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7491:8: enumLiteral_2= 'sync'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_113_in_ruleCommunicationType15606); 

                            current = grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

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
    // $ANTLR end "ruleCommunicationType"


    // $ANTLR start "ruleActorCommunicationType"
    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7501:1: ruleActorCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleActorCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7503:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7504:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7504:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt169=4;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt169=1;
                }
                break;
            case 112:
                {
                alt169=2;
                }
                break;
            case 114:
                {
                alt169=3;
                }
                break;
            case 113:
                {
                alt169=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 169, 0, input);

                throw nvae;
            }

            switch (alt169) {
                case 1 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7504:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7504:2: (enumLiteral_0= 'eventdriven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7504:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_111_in_ruleActorCommunicationType15651); 

                            current = grammarAccess.getActorCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getActorCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7510:6: (enumLiteral_1= 'datadriven' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7510:6: (enumLiteral_1= 'datadriven' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7510:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_112_in_ruleActorCommunicationType15668); 

                            current = grammarAccess.getActorCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getActorCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7516:6: (enumLiteral_2= 'async' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7516:6: (enumLiteral_2= 'async' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7516:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_114_in_ruleActorCommunicationType15685); 

                            current = grammarAccess.getActorCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getActorCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7522:6: (enumLiteral_3= 'sync' )
                    {
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7522:6: (enumLiteral_3= 'sync' )
                    // ../org.eclipse.etrice.core.room/src-gen/org/eclipse/etrice/core/parser/antlr/internal/InternalRoom.g:7522:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,113,FOLLOW_113_in_ruleActorCommunicationType15702); 

                            current = grammarAccess.getActorCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getActorCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleActorCommunicationType"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA137 dfa137 = new DFA137(this);
    protected DFA138 dfa138 = new DFA138(this);
    static final String DFA3_eotS =
        "\14\uffff";
    static final String DFA3_eofS =
        "\14\uffff";
    static final String DFA3_minS =
        "\1\15\4\uffff\3\44\4\uffff";
    static final String DFA3_maxS =
        "\1\162\4\uffff\3\162\4\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\10\1\1\1\2\1\3\3\uffff\1\4\1\5\1\6\1\7";
    static final String DFA3_specialS =
        "\14\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\2\uffff\1\2\4\uffff\1\3\1\4\15\uffff\1\10\5\uffff\1\10"+
            "\10\uffff\2\11\12\uffff\1\13\1\uffff\1\12\55\uffff\1\5\1\6\1"+
            "\7\1\11",
            "",
            "",
            "",
            "",
            "\1\10\16\uffff\2\11\72\uffff\4\11",
            "\1\10\16\uffff\2\11\72\uffff\4\11",
            "\1\10\16\uffff\2\11\72\uffff\4\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 143:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_externalTypes_6_0= ruleExternalType ) ) | ( (lv_dataClasses_7_0= ruleDataClass ) ) | ( (lv_protocolClasses_8_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_9_0= ruleActorClass ) ) | ( (lv_subSystemClasses_10_0= ruleSubSystemClass ) ) | ( (lv_systems_11_0= ruleLogicalSystem ) ) )*";
        }
    }
    static final String DFA137_eotS =
        "\32\uffff";
    static final String DFA137_eofS =
        "\13\uffff\1\22\7\uffff\3\22\3\uffff\1\22";
    static final String DFA137_minS =
        "\1\130\1\4\1\16\1\4\1\21\4\4\2\21\1\14\2\4\1\21\1\4\1\5\1\15\1"+
        "\uffff\3\14\1\5\2\uffff\1\14";
    static final String DFA137_maxS =
        "\1\130\2\16\1\141\1\76\2\4\1\141\1\4\2\21\1\137\2\4\1\21\1\4\1"+
        "\5\1\136\1\uffff\3\137\1\35\2\uffff\1\137";
    static final String DFA137_acceptS =
        "\22\uffff\1\2\4\uffff\1\3\1\1\1\uffff";
    static final String DFA137_specialS =
        "\32\uffff}>";
    static final String[] DFA137_transitionS = {
            "\1\1",
            "\1\2\11\uffff\1\3",
            "\1\3",
            "\1\4\133\uffff\1\5\1\6",
            "\1\7\54\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\133\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\21\1\22\16\uffff\1\20\41\uffff\1\17\16\uffff\1\22\4\uffff"+
            "\7\22\6\uffff\1\22",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25",
            "\1\26",
            "\1\22\114\uffff\1\22\1\30\1\uffff\1\30\1\27",
            "",
            "\1\21\1\22\16\uffff\1\20\60\uffff\1\22\4\uffff\7\22\6\uffff"+
            "\1\22",
            "\1\21\1\22\16\uffff\1\20\60\uffff\1\22\4\uffff\7\22\6\uffff"+
            "\1\22",
            "\1\21\1\22\16\uffff\1\20\60\uffff\1\22\4\uffff\7\22\6\uffff"+
            "\1\22",
            "\1\26\27\uffff\1\31",
            "",
            "",
            "\1\21\1\22\77\uffff\1\22\4\uffff\7\22\6\uffff\1\22"
    };

    static final short[] DFA137_eot = DFA.unpackEncodedString(DFA137_eotS);
    static final short[] DFA137_eof = DFA.unpackEncodedString(DFA137_eofS);
    static final char[] DFA137_min = DFA.unpackEncodedStringToUnsignedChars(DFA137_minS);
    static final char[] DFA137_max = DFA.unpackEncodedStringToUnsignedChars(DFA137_maxS);
    static final short[] DFA137_accept = DFA.unpackEncodedString(DFA137_acceptS);
    static final short[] DFA137_special = DFA.unpackEncodedString(DFA137_specialS);
    static final short[][] DFA137_transition;

    static {
        int numStates = DFA137_transitionS.length;
        DFA137_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA137_transition[i] = DFA.unpackEncodedString(DFA137_transitionS[i]);
        }
    }

    class DFA137 extends DFA {

        public DFA137(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 137;
            this.eot = DFA137_eot;
            this.eof = DFA137_eof;
            this.min = DFA137_min;
            this.max = DFA137_max;
            this.accept = DFA137_accept;
            this.special = DFA137_special;
            this.transition = DFA137_transition;
        }
        public String getDescription() {
            return "5726:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String DFA138_eotS =
        "\31\uffff";
    static final String DFA138_eofS =
        "\31\uffff";
    static final String DFA138_minS =
        "\1\130\1\4\1\16\1\4\1\21\4\4\3\21\1\14\2\4\1\5\1\133\1\4\2\14\1"+
        "\5\2\uffff\2\14";
    static final String DFA138_maxS =
        "\1\130\2\16\1\141\1\76\3\4\1\141\3\21\1\76\2\4\1\5\1\135\1\4\2"+
        "\34\1\35\2\uffff\1\34\1\14";
    static final String DFA138_acceptS =
        "\25\uffff\1\1\1\2\2\uffff";
    static final String DFA138_specialS =
        "\31\uffff}>";
    static final String[] DFA138_transitionS = {
            "\1\1",
            "\1\2\11\uffff\1\3",
            "\1\3",
            "\1\4\133\uffff\1\5\1\6",
            "\1\10\54\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\133\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\20\17\uffff\1\17\41\uffff\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25\1\uffff\1\26",
            "\1\27",
            "\1\20\17\uffff\1\17",
            "\1\20\17\uffff\1\17",
            "\1\24\27\uffff\1\30",
            "",
            "",
            "\1\20\17\uffff\1\17",
            "\1\20"
    };

    static final short[] DFA138_eot = DFA.unpackEncodedString(DFA138_eotS);
    static final short[] DFA138_eof = DFA.unpackEncodedString(DFA138_eofS);
    static final char[] DFA138_min = DFA.unpackEncodedStringToUnsignedChars(DFA138_minS);
    static final char[] DFA138_max = DFA.unpackEncodedStringToUnsignedChars(DFA138_maxS);
    static final short[] DFA138_accept = DFA.unpackEncodedString(DFA138_acceptS);
    static final short[] DFA138_special = DFA.unpackEncodedString(DFA138_specialS);
    static final short[][] DFA138_transition;

    static {
        int numStates = DFA138_transitionS.length;
        DFA138_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA138_transition[i] = DFA.unpackEncodedString(DFA138_transitionS[i]);
        }
    }

    class DFA138 extends DFA {

        public DFA138(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 138;
            this.eot = DFA138_eot;
            this.eof = DFA138_eof;
            this.min = DFA138_min;
            this.max = DFA138_max;
            this.accept = DFA138_accept;
            this.special = DFA138_special;
            this.transition = DFA138_transition;
        }
        public String getDescription() {
            return "5776:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_ruleRoomModel_in_entryRuleRoomModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoomModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoomModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRoomModel143 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRoomModel164 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRoomModel177 = new BitSet(new long[]{0x8018041000612000L,0x0007804000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleRoomModel198 = new BitSet(new long[]{0x8018041000612000L,0x0007804000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleRoomModel221 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleRoomModel248 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleRoomModel275 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleGeneralProtocolClass_in_ruleRoomModel302 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_ruleRoomModel329 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_ruleRoomModel356 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_ruleRoomModel383 = new BitSet(new long[]{0x8018041000612000L,0x0007800000000002L});
    public static final BitSet FOLLOW_13_in_ruleRoomModel397 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarDecl725 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVarDecl742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleVarDecl763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefableType_in_entryRuleRefableType799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefableType809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefableType857 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleRefableType875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleDataType982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_ruleDataType1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexType_in_entryRuleComplexType1044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexType1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_ruleComplexType1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_ruleComplexType1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimitiveType1210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimitiveType1227 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePrimitiveType1244 = new BitSet(new long[]{0x0000000000000000L,0x0000780000000000L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rulePrimitiveType1265 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulePrimitiveType1277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1298 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_rulePrimitiveType1311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePrimitiveType1332 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimitiveType1344 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulePrimitiveType1358 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePrimitiveType1375 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePrimitiveType1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalType_in_entryRuleExternalType1438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalType1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleExternalType1485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalType1502 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExternalType1519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleExternalType1540 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleExternalType1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataClass_in_entryRuleDataClass1598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataClass1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDataClass1645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataClass1662 = new BitSet(new long[]{0x0000000010801000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleDataClass1688 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_ruleDataClass1702 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDataClass1725 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDataClass1739 = new BitSet(new long[]{0x000000000F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleDataClass1760 = new BitSet(new long[]{0x000000000F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_24_in_ruleDataClass1774 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1795 = new BitSet(new long[]{0x000000000F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_25_in_ruleDataClass1810 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1831 = new BitSet(new long[]{0x000000000F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_26_in_ruleDataClass1846 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleDataClass1867 = new BitSet(new long[]{0x000000000F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleDataClass1890 = new BitSet(new long[]{0x000000008F002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleDataClass1912 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_13_in_ruleDataClass1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAttribute2008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute2025 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_28_in_ruleAttribute2043 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAttribute2060 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAttribute2077 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAttribute2091 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleAttribute2112 = new BitSet(new long[]{0x0000000050000002L});
    public static final BitSet FOLLOW_30_in_ruleAttribute2125 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute2142 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleAttribute2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation2209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStandardOperation2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleStandardOperation2256 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_32_in_ruleStandardOperation2274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStandardOperation2305 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStandardOperation2322 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2344 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_33_in_ruleStandardOperation2357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleStandardOperation2378 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_19_in_ruleStandardOperation2394 = new BitSet(new long[]{0x0000000010005000L});
    public static final BitSet FOLLOW_14_in_ruleStandardOperation2407 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_ruleStandardOperation2420 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleRefableType_in_ruleStandardOperation2447 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleStandardOperation2471 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleStandardOperation2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortOperation_in_entryRulePortOperation2529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortOperation2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rulePortOperation2576 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2593 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePortOperation2610 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2632 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_33_in_rulePortOperation2645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_rulePortOperation2666 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_19_in_rulePortOperation2682 = new BitSet(new long[]{0x0000000810005000L});
    public static final BitSet FOLLOW_14_in_rulePortOperation2696 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_rulePortOperation2709 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleRefableType_in_rulePortOperation2736 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_35_in_rulePortOperation2757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortOperation2777 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePortOperation2801 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortOperation2823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneralProtocolClass_in_entryRuleGeneralProtocolClass2859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneralProtocolClass2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_ruleGeneralProtocolClass2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundProtocolClass_in_ruleGeneralProtocolClass2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolClass_in_entryRuleProtocolClass2978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolClass2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommunicationType_in_ruleProtocolClass3034 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleProtocolClass3047 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProtocolClass3064 = new BitSet(new long[]{0x0000000010801000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleProtocolClass3090 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_ruleProtocolClass3104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleProtocolClass3127 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass3141 = new BitSet(new long[]{0x000102E007002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleProtocolClass3162 = new BitSet(new long[]{0x000102E007002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_24_in_ruleProtocolClass3176 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass3197 = new BitSet(new long[]{0x000102E006002000L});
    public static final BitSet FOLLOW_25_in_ruleProtocolClass3212 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass3233 = new BitSet(new long[]{0x000102E004002000L});
    public static final BitSet FOLLOW_26_in_ruleProtocolClass3248 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleProtocolClass3269 = new BitSet(new long[]{0x000102E000002000L});
    public static final BitSet FOLLOW_37_in_ruleProtocolClass3284 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass3296 = new BitSet(new long[]{0x0000300000002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3317 = new BitSet(new long[]{0x0000300000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3330 = new BitSet(new long[]{0x000102C000002000L});
    public static final BitSet FOLLOW_38_in_ruleProtocolClass3345 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolClass3357 = new BitSet(new long[]{0x0000300000002000L});
    public static final BitSet FOLLOW_ruleMessage_in_ruleProtocolClass3378 = new BitSet(new long[]{0x0000300000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3391 = new BitSet(new long[]{0x0001028000002000L});
    public static final BitSet FOLLOW_39_in_ruleProtocolClass3406 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleProtocolClass3418 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3439 = new BitSet(new long[]{0x0001020000002000L});
    public static final BitSet FOLLOW_41_in_ruleProtocolClass3454 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleProtocolClass3466 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePortClass_in_ruleProtocolClass3487 = new BitSet(new long[]{0x0001000000002000L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_ruleProtocolClass3510 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolClass3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundProtocolClass_in_entryRuleCompoundProtocolClass3559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundProtocolClass3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCompoundProtocolClass3606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompoundProtocolClass3623 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCompoundProtocolClass3649 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCompoundProtocolClass3662 = new BitSet(new long[]{0x0000080000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleCompoundProtocolClass3683 = new BitSet(new long[]{0x0000080000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSubProtocol_in_ruleCompoundProtocolClass3705 = new BitSet(new long[]{0x0000080000002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_13_in_ruleCompoundProtocolClass3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubProtocol_in_entryRuleSubProtocol3754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubProtocol3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleSubProtocol3801 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubProtocol3818 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubProtocol3835 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubProtocol3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessage_in_entryRuleMessage3894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessage3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleMessage3947 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleMessage3973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessage3990 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMessage4007 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_ruleVarDecl_in_ruleMessage4028 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMessage4041 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleMessage4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortClass_in_entryRulePortClass4099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortClass4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePortClass4146 = new BitSet(new long[]{0x0000C0008F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_46_in_rulePortClass4159 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_rulePortClass4180 = new BitSet(new long[]{0x0000C0008F000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAttribute_in_rulePortClass4204 = new BitSet(new long[]{0x0000C0008F002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_rulePortOperation_in_rulePortClass4231 = new BitSet(new long[]{0x0000C0008F002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_rulePortClass4258 = new BitSet(new long[]{0x0000C0008F002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_13_in_rulePortClass4272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageHandler_in_entryRuleMessageHandler4308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageHandler4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInMessageHandler_in_ruleMessageHandler4365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutMessageHandler_in_ruleMessageHandler4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInMessageHandler_in_entryRuleInMessageHandler4427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInMessageHandler4437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleInMessageHandler4474 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInMessageHandler4486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInMessageHandler4506 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInMessageHandler4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutMessageHandler_in_entryRuleOutMessageHandler4563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutMessageHandler4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOutMessageHandler4610 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleOutMessageHandler4622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOutMessageHandler4642 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleOutMessageHandler4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProtocolSemantics_in_entryRuleProtocolSemantics4699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProtocolSemantics4709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleProtocolSemantics4755 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleProtocolSemantics4767 = new BitSet(new long[]{0x0006000000002000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleProtocolSemantics4788 = new BitSet(new long[]{0x0006000000002000L});
    public static final BitSet FOLLOW_13_in_ruleProtocolSemantics4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_entryRuleSemanticsRule4837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSemanticsRule4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInSemanticsRule_in_ruleSemanticsRule4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutSemanticsRule_in_ruleSemanticsRule4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInSemanticsRule_in_entryRuleInSemanticsRule4956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInSemanticsRule4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInSemanticsRule5003 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInSemanticsRule5015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInSemanticsRule5035 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleInSemanticsRule5048 = new BitSet(new long[]{0x0006000000040000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInSemanticsRule5089 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5110 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleInSemanticsRule5123 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleInSemanticsRule5144 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_19_in_ruleInSemanticsRule5158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutSemanticsRule_in_entryRuleOutSemanticsRule5198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutSemanticsRule5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOutSemanticsRule5245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOutSemanticsRule5257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOutSemanticsRule5277 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleOutSemanticsRule5290 = new BitSet(new long[]{0x0006000000040000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOutSemanticsRule5331 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5352 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleOutSemanticsRule5365 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_ruleSemanticsRule_in_ruleOutSemanticsRule5386 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_19_in_ruleOutSemanticsRule5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorClass_in_entryRuleActorClass5440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorClass5450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleActorClass5538 = new BitSet(new long[]{0x0018000000000000L,0x0007800000000000L});
    public static final BitSet FOLLOW_ruleActorCommunicationType_in_ruleActorClass5626 = new BitSet(new long[]{0x0018000000000000L,0x0007800000000000L});
    public static final BitSet FOLLOW_52_in_ruleActorClass5678 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorClass5695 = new BitSet(new long[]{0x0000000010801000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass5721 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_ruleActorClass5735 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorClass5758 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass5772 = new BitSet(new long[]{0x00E0000000002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleActorClass5793 = new BitSet(new long[]{0x00E0000000002000L,0x0000002000000000L});
    public static final BitSet FOLLOW_53_in_ruleActorClass5807 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass5819 = new BitSet(new long[]{0x1300000000002000L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass5840 = new BitSet(new long[]{0x1300000000002000L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleActorClass5862 = new BitSet(new long[]{0x1000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass5875 = new BitSet(new long[]{0x00C0000000002000L});
    public static final BitSet FOLLOW_54_in_ruleActorClass5890 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass5911 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass5924 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_24_in_ruleActorClass5937 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass5958 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_25_in_ruleActorClass5973 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass5994 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_26_in_ruleActorClass6009 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleActorClass6030 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_rulePort_in_ruleActorClass6054 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_ruleExternalPort_in_ruleActorClass6081 = new BitSet(new long[]{0x2F0000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_ruleActorClass6104 = new BitSet(new long[]{0x280000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_ruleSAPRef_in_ruleActorClass6126 = new BitSet(new long[]{0x080000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleActorClass6148 = new BitSet(new long[]{0x000000000F002000L,0x0000002000000920L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleActorClass6170 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000920L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleActorClass6192 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000120L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleActorClass6214 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000100L});
    public static final BitSet FOLLOW_13_in_ruleActorClass6227 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_55_in_ruleActorClass6242 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorClass6263 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleActorClass6276 = new BitSet(new long[]{0x0000000080002000L,0x0000002000001000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleActorClass6297 = new BitSet(new long[]{0x0000000080002000L,0x0000002000001000L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleActorClass6319 = new BitSet(new long[]{0x0000000080002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleActorClass6341 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass6354 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleActorClass6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort6406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort6416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rulePort6459 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_rulePort6485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePort6502 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_ruleMULTIPLICITY_in_rulePort6528 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePort6541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_rulePort6564 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rulePort6585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalPort_in_entryRuleExternalPort6622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalPort6632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleExternalPort6669 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleExternalPort6681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalPort6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPRef_in_entryRuleSAPRef6737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPRef6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSAPRef6784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSAPRef6801 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSAPRef6818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSAPRef6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPRef_in_entryRuleSPPRef6877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPRef6887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSPPRef6924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPRef6941 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSPPRef6958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSPPRef6981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleServiceImplementation_in_entryRuleServiceImplementation7017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleServiceImplementation7027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleServiceImplementation7064 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleServiceImplementation7076 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleServiceImplementation7096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalSystem_in_entryRuleLogicalSystem7132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalSystem7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleLogicalSystem7179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalSystem7196 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleLogicalSystem7222 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalSystem7235 = new BitSet(new long[]{0x0000000000002000L,0x0000002000000121L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleLogicalSystem7256 = new BitSet(new long[]{0x0000000000002000L,0x0000002000000121L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_ruleLogicalSystem7278 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000121L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleLogicalSystem7300 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000120L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleLogicalSystem7322 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000100L});
    public static final BitSet FOLLOW_13_in_ruleLogicalSystem7335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemRef_in_entryRuleSubSystemRef7373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemRef7383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleSubSystemRef7420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemRef7437 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSubSystemRef7454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleSubSystemRef7477 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemRef7498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubSystemClass_in_entryRuleSubSystemClass7535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubSystemClass7545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleSubSystemClass7582 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubSystemClass7599 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSubSystemClass7625 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSubSystemClass7638 = new BitSet(new long[]{0x1300000007002000L,0x0000002000000924L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleSubSystemClass7659 = new BitSet(new long[]{0x1300000007002000L,0x0000002000000924L});
    public static final BitSet FOLLOW_24_in_ruleSubSystemClass7673 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass7694 = new BitSet(new long[]{0x1300000006002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_25_in_ruleSubSystemClass7709 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass7730 = new BitSet(new long[]{0x1300000004002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_26_in_ruleSubSystemClass7745 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSubSystemClass7766 = new BitSet(new long[]{0x1300000000002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_rulePort_in_ruleSubSystemClass7789 = new BitSet(new long[]{0x1300000000002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_ruleSPPRef_in_ruleSubSystemClass7811 = new BitSet(new long[]{0x1000000000002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_ruleActorRef_in_ruleSubSystemClass7833 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000924L});
    public static final BitSet FOLLOW_ruleBinding_in_ruleSubSystemClass7855 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000124L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_ruleSubSystemClass7877 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000104L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_ruleSubSystemClass7899 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000004L});
    public static final BitSet FOLLOW_13_in_ruleSubSystemClass7912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalThread_in_entryRuleLogicalThread7948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalThread7958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleLogicalThread7995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLogicalThread8012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleLogicalThread8029 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLogicalThread8041 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLogicalThread8058 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLogicalThread8075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread8096 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_33_in_ruleLogicalThread8109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_ruleLogicalThread8130 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_13_in_ruleLogicalThread8144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorInstancePath_in_entryRuleActorInstancePath8180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorInstancePath8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath8232 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleActorInstancePath8250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorInstancePath8267 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding8310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding8320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleBinding8357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding8378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleBinding8390 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_ruleBinding8411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingEndPoint_in_entryRuleBindingEndPoint8447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingEndPoint8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint8503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleBindingEndPoint8515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint8537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleBindingEndPoint8550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBindingEndPoint8570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerConnection_in_entryRuleLayerConnection8608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerConnection8618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleLayerConnection8655 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleSAPoint_in_ruleLayerConnection8676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleLayerConnection8688 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSPPoint_in_ruleLayerConnection8709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSAPoint_in_entryRuleSAPoint8745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSAPoint8755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_ruleSAPoint8802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_ruleSAPoint8829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefSAPoint_in_entryRuleRefSAPoint8864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefSAPoint8874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleRefSAPoint8911 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefSAPoint8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelaySAPoint_in_entryRuleRelaySAPoint8967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelaySAPoint8977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleRelaySAPoint9014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelaySAPoint9034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPPoint_in_entryRuleSPPoint9070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPPoint9080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint9125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleSPPoint9137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPPoint9157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActorRef_in_entryRuleActorRef9193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActorRef9203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleActorRef9240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActorRef9257 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_28_in_ruleActorRef9275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleActorRef9292 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleActorRef9309 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleActorRef9323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleActorRef9346 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleActorRef9367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraphNode_in_entryRuleStateGraphNode9404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraphNode9414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraphNode9461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraphNode9488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraphNode9515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState9552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState9562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_ruleState9609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_ruleState9636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateGraph_in_entryRuleStateGraph9671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateGraph9681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStateGraph9727 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateGraph9749 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateGraph9776 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateGraph9803 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateGraph9830 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateGraph9857 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_13_in_ruleStateGraph9871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine9907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine9917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleStateMachine9963 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleStateMachine9975 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachine9997 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleTrPoint_in_ruleStateMachine10024 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_ruleStateMachine10051 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateMachine10078 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_ruleStateMachine10105 = new BitSet(new long[]{0x0000000000002000L,0x0000000081FC2000L});
    public static final BitSet FOLLOW_13_in_ruleStateMachine10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState10155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState10165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleSimpleState10202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState10219 = new BitSet(new long[]{0x0000000010001002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleSimpleState10245 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSimpleState10259 = new BitSet(new long[]{0x0000000000002000L,0x000000000003C000L});
    public static final BitSet FOLLOW_78_in_ruleSimpleState10272 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState10293 = new BitSet(new long[]{0x0000000000002000L,0x0000000000038000L});
    public static final BitSet FOLLOW_79_in_ruleSimpleState10308 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState10329 = new BitSet(new long[]{0x0000000000002000L,0x0000000000030000L});
    public static final BitSet FOLLOW_80_in_ruleSimpleState10344 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleSimpleState10365 = new BitSet(new long[]{0x0000000000002000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleSimpleState10380 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleSimpleState10401 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSimpleState10415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedState_in_entryRuleRefinedState10453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedState10463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleRefinedState10500 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedState10523 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedState10544 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRefinedState10557 = new BitSet(new long[]{0x0000000000002000L,0x000000000003C000L});
    public static final BitSet FOLLOW_78_in_ruleRefinedState10570 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState10591 = new BitSet(new long[]{0x0000000000002000L,0x0000000000038000L});
    public static final BitSet FOLLOW_79_in_ruleRefinedState10606 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState10627 = new BitSet(new long[]{0x0000000000002000L,0x0000000000030000L});
    public static final BitSet FOLLOW_80_in_ruleRefinedState10642 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedState10663 = new BitSet(new long[]{0x0000000000002000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleRefinedState10678 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStateGraph_in_ruleRefinedState10699 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedState10713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetailCode_in_entryRuleDetailCode10749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetailCode10759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDetailCode10796 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDetailCode10813 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ruleDetailCode10831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPoint_in_entryRuleTrPoint10867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPoint10877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_ruleTrPoint10924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_ruleTrPoint10951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_ruleTrPoint10978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionPoint_in_entryRuleTransitionPoint11013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionPoint11023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleTransitionPoint11066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleTransitionPoint11092 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionPoint11109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPoint_in_entryRuleEntryPoint11150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPoint11160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleEntryPoint11197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPoint11214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPoint_in_entryRuleExitPoint11255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPoint11265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleExitPoint11302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPoint11319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicePoint_in_entryRuleChoicePoint11360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicePoint11370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleChoicePoint11407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicePoint11424 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleChoicePoint11450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition11487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition11497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_ruleTransition11544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_ruleTransition11571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonInitialTransition_in_entryRuleNonInitialTransition11606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonInitialTransition11616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_ruleNonInitialTransition11663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_ruleNonInitialTransition11690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_ruleNonInitialTransition11717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionChainStartTransition_in_entryRuleTransitionChainStartTransition11752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionChainStartTransition11762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleTransitionChainStartTransition11809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_ruleTransitionChainStartTransition11836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitialTransition_in_entryRuleInitialTransition11871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitialTransition11881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleInitialTransition11918 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInitialTransition11935 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInitialTransition11953 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ruleInitialTransition11965 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInitialTransition11977 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleInitialTransition11998 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleInitialTransition12019 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInitialTransition12032 = new BitSet(new long[]{0x0000000000002000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleInitialTransition12045 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleInitialTransition12066 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInitialTransition12080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContinuationTransition_in_entryRuleContinuationTransition12116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContinuationTransition12126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleContinuationTransition12163 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContinuationTransition12180 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleContinuationTransition12198 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition12219 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleContinuationTransition12231 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleContinuationTransition12252 = new BitSet(new long[]{0x0000000010001002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleContinuationTransition12273 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleContinuationTransition12287 = new BitSet(new long[]{0x0000000000002000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleContinuationTransition12300 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleContinuationTransition12321 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleContinuationTransition12335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition12373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition12383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleTriggeredTransition12420 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition12437 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTriggeredTransition12455 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition12476 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTriggeredTransition12488 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleTriggeredTransition12509 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleTriggeredTransition12530 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition12543 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_ruleTriggeredTransition12555 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTriggeredTransition12567 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition12588 = new BitSet(new long[]{0x0000000000002000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleTriggeredTransition12601 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggeredTransition12622 = new BitSet(new long[]{0x0000000000002000L,0x0000000010000000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition12636 = new BitSet(new long[]{0x0000000000002000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleTriggeredTransition12649 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleTriggeredTransition12670 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTriggeredTransition12684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardedTransition_in_entryRuleGuardedTransition12720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardedTransition12730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleGuardedTransition12767 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuardedTransition12784 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGuardedTransition12802 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition12823 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGuardedTransition12835 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleGuardedTransition12856 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleGuardedTransition12877 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGuardedTransition12890 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ruleGuardedTransition12902 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition12923 = new BitSet(new long[]{0x0000000000002000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleGuardedTransition12936 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuardedTransition12957 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGuardedTransition12971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCPBranchTransition_in_entryRuleCPBranchTransition13007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCPBranchTransition13017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleCPBranchTransition13054 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCPBranchTransition13071 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCPBranchTransition13089 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition13110 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCPBranchTransition13122 = new BitSet(new long[]{0x0000000000000010L,0x0000000300000000L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_ruleCPBranchTransition13143 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleCPBranchTransition13164 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCPBranchTransition13177 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ruleCPBranchTransition13189 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition13210 = new BitSet(new long[]{0x0000000000002000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleCPBranchTransition13223 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleCPBranchTransition13244 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCPBranchTransition13258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefinedTransition_in_entryRuleRefinedTransition13294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefinedTransition13304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleRefinedTransition13341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleRefinedTransition13364 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_ruleDocumentation_in_ruleRefinedTransition13385 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRefinedTransition13398 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleRefinedTransition13410 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleRefinedTransition13431 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRefinedTransition13443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionTerminal_in_entryRuleTransitionTerminal13479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionTerminal13489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_ruleTransitionTerminal13536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_ruleTransitionTerminal13563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_ruleTransitionTerminal13590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_ruleTransitionTerminal13617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateTerminal_in_entryRuleStateTerminal13652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateTerminal13662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateTerminal13706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrPointTerminal_in_entryRuleTrPointTerminal13741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrPointTerminal13751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleTrPointTerminal13788 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTrPointTerminal13808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubStateTrPointTerminal_in_entryRuleSubStateTrPointTerminal13844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubStateTrPointTerminal13854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal13899 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSubStateTrPointTerminal13911 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubStateTrPointTerminal13931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoicepointTerminal_in_entryRuleChoicepointTerminal13967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoicepointTerminal13977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleChoicepointTerminal14014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoicepointTerminal14034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger14070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger14080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleTrigger14117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger14138 = new BitSet(new long[]{0x0000000000000000L,0x0000001820000000L});
    public static final BitSet FOLLOW_99_in_ruleTrigger14151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_ruleTrigger14172 = new BitSet(new long[]{0x0000000000000000L,0x0000001820000000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTrigger14195 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleTrigger14208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMessageFromIf_in_entryRuleMessageFromIf14244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageFromIf14254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf14299 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMessageFromIf14311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMessageFromIf14331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard14367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard14377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleGuard14414 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleDetailCode_in_ruleGuard14435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation14471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation14481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDocumentation14518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDocumentation14535 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_29_in_ruleDocumentation14553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation14589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation14599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleAnnotation14636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation14653 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleAnnotation14671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation14692 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_33_in_ruleAnnotation14705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleKeyValue_in_ruleAnnotation14726 = new BitSet(new long[]{0x0000000200080000L});
    public static final BitSet FOLLOW_19_in_ruleAnnotation14740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue14778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue14788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValue14830 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleKeyValue14847 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyValue14864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport14905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport14915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleImport14952 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_ruleImport14975 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_ruleImport14987 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_104_in_ruleImport15006 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport15024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN15066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN15077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleImportedFQN15124 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_ruleImportedFQN15143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN15186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN15197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN15237 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleFQN15256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN15271 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMULTIPLICITY_in_entryRuleMULTIPLICITY15319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMULTIPLICITY15330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleMULTIPLICITY15368 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_ruleMULTIPLICITY15382 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleMULTIPLICITY15403 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMULTIPLICITY15422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleLiteralType15476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleLiteralType15493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleLiteralType15510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleLiteralType15527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleCommunicationType15572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleCommunicationType15589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleCommunicationType15606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleActorCommunicationType15651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleActorCommunicationType15668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleActorCommunicationType15685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleActorCommunicationType15702 = new BitSet(new long[]{0x0000000000000002L});

}
