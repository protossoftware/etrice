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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'Enumeration'", "'of'", "','", "'='", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'override'", "'Operation'", "'void'", "'sends'", "'ctor'", "'dtor'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugated'", "'CompoundProtocolClass'", "'SubProtocol'", "'private'", "'Message'", "'usercode'", "'handle'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'ActorInstanceMapping'", "'/'", "'Binding'", "'and'", "'.'", "'sub'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'*'", "'ActorBehavior'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'semantics'", "'in'", "'out'", "'@'", "'AnnotationType'", "'target'", "'optional'", "'mandatory'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'false'", "'true'", "'+'", "'-'", "'e'", "'E'", "'eventdriven'", "'datadriven'", "'sync'", "'fixed'", "'async'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    public static final int RULE_HEX=7;
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
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int RULE_STRING=5;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__129=129;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__130=130;
    public static final int T__74=74;
    public static final int T__131=131;
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
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
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
    public String getGrammarFileName() { return "InternalRoom.g"; }



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
    // InternalRoom.g:68:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // InternalRoom.g:69:2: (iv_ruleRoomModel= ruleRoomModel EOF )
            // InternalRoom.g:70:2: iv_ruleRoomModel= ruleRoomModel EOF
            {
             newCompositeNode(grammarAccess.getRoomModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoomModel=ruleRoomModel();

            state._fsp--;

             current =iv_ruleRoomModel; 
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
    // $ANTLR end "entryRuleRoomModel"


    // $ANTLR start "ruleRoomModel"
    // InternalRoom.g:77:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )* otherlv_14= '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_docu_2_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_primitiveTypes_5_0 = null;

        EObject lv_enumerationTypes_6_0 = null;

        EObject lv_externalTypes_7_0 = null;

        EObject lv_dataClasses_8_0 = null;

        EObject lv_protocolClasses_9_0 = null;

        EObject lv_actorClasses_10_0 = null;

        EObject lv_subSystemClasses_11_0 = null;

        EObject lv_systems_12_0 = null;

        EObject lv_annotationTypes_13_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:80:28: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )* otherlv_14= '}' ) )
            // InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )* otherlv_14= '}' )
            {
            // InternalRoom.g:81:1: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )* otherlv_14= '}' )
            // InternalRoom.g:81:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_imports_4_0= ruleImport ) )* ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRoomModelAccess().getRoomModelKeyword_0());
                
            // InternalRoom.g:85:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalRoom.g:86:1: (lv_name_1_0= ruleFQN )
            {
            // InternalRoom.g:86:1: (lv_name_1_0= ruleFQN )
            // InternalRoom.g:87:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getRoomModelAccess().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.etrice.core.common.Base.FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:103:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==33) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalRoom.g:104:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:104:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:105:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_6); 

                	newLeafNode(otherlv_3, grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:125:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==113) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRoom.g:126:1: (lv_imports_4_0= ruleImport )
            	    {
            	    // InternalRoom.g:126:1: (lv_imports_4_0= ruleImport )
            	    // InternalRoom.g:127:3: lv_imports_4_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_imports_4_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_4_0, 
            	            		"org.eclipse.etrice.core.common.Base.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalRoom.g:143:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )*
            loop3:
            do {
                int alt3=10;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalRoom.g:143:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    {
            	    // InternalRoom.g:143:4: ( (lv_primitiveTypes_5_0= rulePrimitiveType ) )
            	    // InternalRoom.g:144:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    {
            	    // InternalRoom.g:144:1: (lv_primitiveTypes_5_0= rulePrimitiveType )
            	    // InternalRoom.g:145:3: lv_primitiveTypes_5_0= rulePrimitiveType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getPrimitiveTypesPrimitiveTypeParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_primitiveTypes_5_0=rulePrimitiveType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"primitiveTypes",
            	            		lv_primitiveTypes_5_0, 
            	            		"org.eclipse.etrice.core.Room.PrimitiveType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoom.g:162:6: ( (lv_enumerationTypes_6_0= ruleEnumerationType ) )
            	    {
            	    // InternalRoom.g:162:6: ( (lv_enumerationTypes_6_0= ruleEnumerationType ) )
            	    // InternalRoom.g:163:1: (lv_enumerationTypes_6_0= ruleEnumerationType )
            	    {
            	    // InternalRoom.g:163:1: (lv_enumerationTypes_6_0= ruleEnumerationType )
            	    // InternalRoom.g:164:3: lv_enumerationTypes_6_0= ruleEnumerationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getEnumerationTypesEnumerationTypeParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_enumerationTypes_6_0=ruleEnumerationType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"enumerationTypes",
            	            		lv_enumerationTypes_6_0, 
            	            		"org.eclipse.etrice.core.Room.EnumerationType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoom.g:181:6: ( (lv_externalTypes_7_0= ruleExternalType ) )
            	    {
            	    // InternalRoom.g:181:6: ( (lv_externalTypes_7_0= ruleExternalType ) )
            	    // InternalRoom.g:182:1: (lv_externalTypes_7_0= ruleExternalType )
            	    {
            	    // InternalRoom.g:182:1: (lv_externalTypes_7_0= ruleExternalType )
            	    // InternalRoom.g:183:3: lv_externalTypes_7_0= ruleExternalType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getExternalTypesExternalTypeParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_externalTypes_7_0=ruleExternalType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"externalTypes",
            	            		lv_externalTypes_7_0, 
            	            		"org.eclipse.etrice.core.Room.ExternalType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRoom.g:200:6: ( (lv_dataClasses_8_0= ruleDataClass ) )
            	    {
            	    // InternalRoom.g:200:6: ( (lv_dataClasses_8_0= ruleDataClass ) )
            	    // InternalRoom.g:201:1: (lv_dataClasses_8_0= ruleDataClass )
            	    {
            	    // InternalRoom.g:201:1: (lv_dataClasses_8_0= ruleDataClass )
            	    // InternalRoom.g:202:3: lv_dataClasses_8_0= ruleDataClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getDataClassesDataClassParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_dataClasses_8_0=ruleDataClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dataClasses",
            	            		lv_dataClasses_8_0, 
            	            		"org.eclipse.etrice.core.Room.DataClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRoom.g:219:6: ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) )
            	    {
            	    // InternalRoom.g:219:6: ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) )
            	    // InternalRoom.g:220:1: (lv_protocolClasses_9_0= ruleGeneralProtocolClass )
            	    {
            	    // InternalRoom.g:220:1: (lv_protocolClasses_9_0= ruleGeneralProtocolClass )
            	    // InternalRoom.g:221:3: lv_protocolClasses_9_0= ruleGeneralProtocolClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getProtocolClassesGeneralProtocolClassParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_protocolClasses_9_0=ruleGeneralProtocolClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"protocolClasses",
            	            		lv_protocolClasses_9_0, 
            	            		"org.eclipse.etrice.core.Room.GeneralProtocolClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRoom.g:238:6: ( (lv_actorClasses_10_0= ruleActorClass ) )
            	    {
            	    // InternalRoom.g:238:6: ( (lv_actorClasses_10_0= ruleActorClass ) )
            	    // InternalRoom.g:239:1: (lv_actorClasses_10_0= ruleActorClass )
            	    {
            	    // InternalRoom.g:239:1: (lv_actorClasses_10_0= ruleActorClass )
            	    // InternalRoom.g:240:3: lv_actorClasses_10_0= ruleActorClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getActorClassesActorClassParserRuleCall_5_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_actorClasses_10_0=ruleActorClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorClasses",
            	            		lv_actorClasses_10_0, 
            	            		"org.eclipse.etrice.core.Room.ActorClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRoom.g:257:6: ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) )
            	    {
            	    // InternalRoom.g:257:6: ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) )
            	    // InternalRoom.g:258:1: (lv_subSystemClasses_11_0= ruleSubSystemClass )
            	    {
            	    // InternalRoom.g:258:1: (lv_subSystemClasses_11_0= ruleSubSystemClass )
            	    // InternalRoom.g:259:3: lv_subSystemClasses_11_0= ruleSubSystemClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSubSystemClassesSubSystemClassParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_subSystemClasses_11_0=ruleSubSystemClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystemClasses",
            	            		lv_subSystemClasses_11_0, 
            	            		"org.eclipse.etrice.core.Room.SubSystemClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRoom.g:276:6: ( (lv_systems_12_0= ruleLogicalSystem ) )
            	    {
            	    // InternalRoom.g:276:6: ( (lv_systems_12_0= ruleLogicalSystem ) )
            	    // InternalRoom.g:277:1: (lv_systems_12_0= ruleLogicalSystem )
            	    {
            	    // InternalRoom.g:277:1: (lv_systems_12_0= ruleLogicalSystem )
            	    // InternalRoom.g:278:3: lv_systems_12_0= ruleLogicalSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getSystemsLogicalSystemParserRuleCall_5_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_systems_12_0=ruleLogicalSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_12_0, 
            	            		"org.eclipse.etrice.core.Room.LogicalSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRoom.g:295:6: ( (lv_annotationTypes_13_0= ruleAnnotationType ) )
            	    {
            	    // InternalRoom.g:295:6: ( (lv_annotationTypes_13_0= ruleAnnotationType ) )
            	    // InternalRoom.g:296:1: (lv_annotationTypes_13_0= ruleAnnotationType )
            	    {
            	    // InternalRoom.g:296:1: (lv_annotationTypes_13_0= ruleAnnotationType )
            	    // InternalRoom.g:297:3: lv_annotationTypes_13_0= ruleAnnotationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRoomModelAccess().getAnnotationTypesAnnotationTypeParserRuleCall_5_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_annotationTypes_13_0=ruleAnnotationType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotationTypes",
            	            		lv_annotationTypes_13_0, 
            	            		"org.eclipse.etrice.core.common.Base.AnnotationType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_14=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_14, grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // InternalRoom.g:327:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // InternalRoom.g:328:2: (iv_ruleStructureClass= ruleStructureClass EOF )
            // InternalRoom.g:329:2: iv_ruleStructureClass= ruleStructureClass EOF
            {
             newCompositeNode(grammarAccess.getStructureClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructureClass=ruleStructureClass();

            state._fsp--;

             current =iv_ruleStructureClass; 
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
    // $ANTLR end "entryRuleStructureClass"


    // $ANTLR start "ruleStructureClass"
    // InternalRoom.g:336:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:339:28: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // InternalRoom.g:340:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // InternalRoom.g:340:1: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=53 && LA4_0<=54)||LA4_0==65||(LA4_0>=123 && LA4_0<=125)||LA4_0==127) ) {
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
                    // InternalRoom.g:341:5: this_ActorContainerClass_0= ruleActorContainerClass
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getActorContainerClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ActorContainerClass_0=ruleActorContainerClass();

                    state._fsp--;

                     
                            current = this_ActorContainerClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:351:5: this_LogicalSystem_1= ruleLogicalSystem
                    {
                     
                            newCompositeNode(grammarAccess.getStructureClassAccess().getLogicalSystemParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:367:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // InternalRoom.g:368:2: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // InternalRoom.g:369:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
            {
             newCompositeNode(grammarAccess.getActorContainerClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorContainerClass=ruleActorContainerClass();

            state._fsp--;

             current =iv_ruleActorContainerClass; 
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
    // $ANTLR end "entryRuleActorContainerClass"


    // $ANTLR start "ruleActorContainerClass"
    // InternalRoom.g:376:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:379:28: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // InternalRoom.g:380:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // InternalRoom.g:380:1: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=53 && LA5_0<=54)||(LA5_0>=123 && LA5_0<=125)||LA5_0==127) ) {
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
                    // InternalRoom.g:381:5: this_ActorClass_0= ruleActorClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getActorClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ActorClass_0=ruleActorClass();

                    state._fsp--;

                     
                            current = this_ActorClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:391:5: this_SubSystemClass_1= ruleSubSystemClass
                    {
                     
                            newCompositeNode(grammarAccess.getActorContainerClassAccess().getSubSystemClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:407:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalRoom.g:408:2: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalRoom.g:409:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
             newCompositeNode(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;

             current =iv_ruleVarDecl; 
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
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalRoom.g:416:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:419:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // InternalRoom.g:420:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // InternalRoom.g:420:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) )
            // InternalRoom.g:420:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) )
            {
            // InternalRoom.g:420:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:421:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:421:1: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:422:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getColonKeyword_1());
                
            // InternalRoom.g:442:1: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:443:1: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:443:1: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:444:3: lv_refType_2_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getVarDeclAccess().getRefTypeRefableTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_refType_2_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarDeclRule());
            	        }
                   		set(
                   			current, 
                   			"refType",
                    		lv_refType_2_0, 
                    		"org.eclipse.etrice.core.Room.RefableType");
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
    // InternalRoom.g:468:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // InternalRoom.g:469:2: (iv_ruleRefableType= ruleRefableType EOF )
            // InternalRoom.g:470:2: iv_ruleRefableType= ruleRefableType EOF
            {
             newCompositeNode(grammarAccess.getRefableTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefableType=ruleRefableType();

            state._fsp--;

             current =iv_ruleRefableType; 
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
    // $ANTLR end "entryRuleRefableType"


    // $ANTLR start "ruleRefableType"
    // InternalRoom.g:477:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:480:28: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // InternalRoom.g:481:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // InternalRoom.g:481:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // InternalRoom.g:481:2: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // InternalRoom.g:481:2: ( ( ruleFQN ) )
            // InternalRoom.g:482:1: ( ruleFQN )
            {
            // InternalRoom.g:482:1: ( ruleFQN )
            // InternalRoom.g:483:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefableTypeRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefableTypeAccess().getTypeDataTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_9);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:496:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRoom.g:497:1: (lv_ref_1_0= 'ref' )
                    {
                    // InternalRoom.g:497:1: (lv_ref_1_0= 'ref' )
                    // InternalRoom.g:498:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,16,FOLLOW_2); 

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
    // InternalRoom.g:519:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalRoom.g:520:2: (iv_ruleDataType= ruleDataType EOF )
            // InternalRoom.g:521:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalRoom.g:528:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_EnumerationType_1 = null;

        EObject this_ComplexType_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:531:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) )
            // InternalRoom.g:532:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            {
            // InternalRoom.g:532:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt7=1;
                }
                break;
            case 22:
                {
                alt7=2;
                }
                break;
            case 26:
            case 27:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalRoom.g:533:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:543:5: this_EnumerationType_1= ruleEnumerationType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getEnumerationTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EnumerationType_1=ruleEnumerationType();

                    state._fsp--;

                     
                            current = this_EnumerationType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:553:5: this_ComplexType_2= ruleComplexType
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeAccess().getComplexTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ComplexType_2=ruleComplexType();

                    state._fsp--;

                     
                            current = this_ComplexType_2; 
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
    // InternalRoom.g:569:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalRoom.g:570:2: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalRoom.g:571:2: iv_ruleComplexType= ruleComplexType EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexType=ruleComplexType();

            state._fsp--;

             current =iv_ruleComplexType; 
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
    // $ANTLR end "entryRuleComplexType"


    // $ANTLR start "ruleComplexType"
    // InternalRoom.g:578:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:581:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // InternalRoom.g:582:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // InternalRoom.g:582:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            else if ( (LA8_0==26) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoom.g:583:5: this_DataClass_0= ruleDataClass
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getDataClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DataClass_0=ruleDataClass();

                    state._fsp--;

                     
                            current = this_DataClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:593:5: this_ExternalType_1= ruleExternalType
                    {
                     
                            newCompositeNode(grammarAccess.getComplexTypeAccess().getExternalTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:609:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalRoom.g:610:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalRoom.g:611:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
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
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalRoom.g:618:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_targetName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_defaultValueLiteral_10_0=null;
        Enumerator lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_castName_7_0 = null;

        EObject lv_docu_11_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:621:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:622:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:622:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            // InternalRoom.g:622:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // InternalRoom.g:626:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:627:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:627:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:628:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getColonKeyword_2());
                
            // InternalRoom.g:648:1: ( (lv_type_3_0= ruleLiteralType ) )
            // InternalRoom.g:649:1: (lv_type_3_0= ruleLiteralType )
            {
            // InternalRoom.g:649:1: (lv_type_3_0= ruleLiteralType )
            // InternalRoom.g:650:3: lv_type_3_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTypeLiteralTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_11);
            lv_type_3_0=ruleLiteralType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"org.eclipse.etrice.core.common.Base.LiteralType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_12); 

                	newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:670:1: ( (lv_targetName_5_0= RULE_STRING ) )
            // InternalRoom.g:671:1: (lv_targetName_5_0= RULE_STRING )
            {
            // InternalRoom.g:671:1: (lv_targetName_5_0= RULE_STRING )
            // InternalRoom.g:672:3: lv_targetName_5_0= RULE_STRING
            {
            lv_targetName_5_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            			newLeafNode(lv_targetName_5_0, grammarAccess.getPrimitiveTypeAccess().getTargetNameSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"targetName",
                    		lv_targetName_5_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalRoom.g:688:2: (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoom.g:688:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_6_0());
                        
                    // InternalRoom.g:692:1: ( (lv_castName_7_0= ruleFQN ) )
                    // InternalRoom.g:693:1: (lv_castName_7_0= ruleFQN )
                    {
                    // InternalRoom.g:693:1: (lv_castName_7_0= ruleFQN )
                    // InternalRoom.g:694:3: lv_castName_7_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_14);
                    lv_castName_7_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"castName",
                            		lv_castName_7_0, 
                            		"org.eclipse.etrice.core.common.Base.FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,20,FOLLOW_15); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_6_2());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,21,FOLLOW_12); 

                	newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_7());
                
            // InternalRoom.g:718:1: ( (lv_defaultValueLiteral_10_0= RULE_STRING ) )
            // InternalRoom.g:719:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            {
            // InternalRoom.g:719:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            // InternalRoom.g:720:3: lv_defaultValueLiteral_10_0= RULE_STRING
            {
            lv_defaultValueLiteral_10_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            			newLeafNode(lv_defaultValueLiteral_10_0, grammarAccess.getPrimitiveTypeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimitiveTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"defaultValueLiteral",
                    		lv_defaultValueLiteral_10_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalRoom.g:736:2: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==33) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRoom.g:737:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:737:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:738:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getDocuDocumentationParserRuleCall_9_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_11_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_11_0, 
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
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleEnumerationType"
    // InternalRoom.g:762:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalRoom.g:763:2: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalRoom.g:764:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;

             current =iv_ruleEnumerationType; 
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
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // InternalRoom.g:771:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_docu_2_0 = null;

        EObject lv_literals_6_0 = null;

        EObject lv_literals_8_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:774:28: ( (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) )
            // InternalRoom.g:775:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            {
            // InternalRoom.g:775:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            // InternalRoom.g:775:3: otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_0());
                
            // InternalRoom.g:779:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:780:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:780:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:781:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEnumerationTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumerationTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:797:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==33) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRoom.g:798:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:798:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:799:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_18);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
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

            // InternalRoom.g:815:3: (otherlv_3= 'of' ( ( ruleFQN ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRoom.g:815:5: otherlv_3= 'of' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getOfKeyword_3_0());
                        
                    // InternalRoom.g:819:1: ( ( ruleFQN ) )
                    // InternalRoom.g:820:1: ( ruleFQN )
                    {
                    // InternalRoom.g:820:1: ( ruleFQN )
                    // InternalRoom.g:821:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEnumerationTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getPrimitiveTypePrimitiveTypeCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_19); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:838:1: ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRoom.g:838:2: ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalRoom.g:838:2: ( (lv_literals_6_0= ruleEnumLiteral ) )
                    // InternalRoom.g:839:1: (lv_literals_6_0= ruleEnumLiteral )
                    {
                    // InternalRoom.g:839:1: (lv_literals_6_0= ruleEnumLiteral )
                    // InternalRoom.g:840:3: lv_literals_6_0= ruleEnumLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
                    lv_literals_6_0=ruleEnumLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"literals",
                            		lv_literals_6_0, 
                            		"org.eclipse.etrice.core.Room.EnumLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalRoom.g:856:2: (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==24) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalRoom.g:856:4: otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_7=(Token)match(input,24,FOLLOW_3); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // InternalRoom.g:860:1: ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    // InternalRoom.g:861:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    {
                    	    // InternalRoom.g:861:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    // InternalRoom.g:862:3: lv_literals_8_0= ruleEnumLiteral
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
                    	    lv_literals_8_0=ruleEnumLiteral();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"literals",
                    	            		lv_literals_8_0, 
                    	            		"org.eclipse.etrice.core.Room.EnumLiteral");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalRoom.g:890:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalRoom.g:891:2: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalRoom.g:892:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral; 
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
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalRoom.g:899:1: ruleEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:902:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) )
            // InternalRoom.g:903:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            {
            // InternalRoom.g:903:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            // InternalRoom.g:903:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            {
            // InternalRoom.g:903:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:904:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:904:1: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:905:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:921:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRoom.g:921:4: otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_22); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumLiteralAccess().getEqualsSignKeyword_1_0());
                        
                    // InternalRoom.g:925:1: ( (lv_literal_2_0= ruleIntLiteral ) )
                    // InternalRoom.g:926:1: (lv_literal_2_0= ruleIntLiteral )
                    {
                    // InternalRoom.g:926:1: (lv_literal_2_0= ruleIntLiteral )
                    // InternalRoom.g:927:3: lv_literal_2_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralAccess().getLiteralIntLiteralParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_literal_2_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralRule());
                    	        }
                           		set(
                           			current, 
                           			"literal",
                            		lv_literal_2_0, 
                            		"org.eclipse.etrice.core.common.Base.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRuleExternalType"
    // InternalRoom.g:951:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // InternalRoom.g:952:2: (iv_ruleExternalType= ruleExternalType EOF )
            // InternalRoom.g:953:2: iv_ruleExternalType= ruleExternalType EOF
            {
             newCompositeNode(grammarAccess.getExternalTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalType=ruleExternalType();

            state._fsp--;

             current =iv_ruleExternalType; 
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
    // $ANTLR end "entryRuleExternalType"


    // $ANTLR start "ruleExternalType"
    // InternalRoom.g:960:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject ruleExternalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_targetName_3_0=null;
        Token otherlv_4=null;
        Token lv_defaultValueLiteral_5_0=null;
        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:963:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:964:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:964:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:964:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // InternalRoom.g:968:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:969:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:969:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:970:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExternalTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_12); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalRoom.g:990:1: ( (lv_targetName_3_0= RULE_STRING ) )
            // InternalRoom.g:991:1: (lv_targetName_3_0= RULE_STRING )
            {
            // InternalRoom.g:991:1: (lv_targetName_3_0= RULE_STRING )
            // InternalRoom.g:992:3: lv_targetName_3_0= RULE_STRING
            {
            lv_targetName_3_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            			newLeafNode(lv_targetName_3_0, grammarAccess.getExternalTypeAccess().getTargetNameSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"targetName",
                    		lv_targetName_3_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalRoom.g:1008:2: (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoom.g:1008:4: otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_12); 

                        	newLeafNode(otherlv_4, grammarAccess.getExternalTypeAccess().getDefaultKeyword_4_0());
                        
                    // InternalRoom.g:1012:1: ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    // InternalRoom.g:1013:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:1013:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    // InternalRoom.g:1014:3: lv_defaultValueLiteral_5_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_5_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

                    			newLeafNode(lv_defaultValueLiteral_5_0, grammarAccess.getExternalTypeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getExternalTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_5_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1030:4: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRoom.g:1031:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1031:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:1032:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalTypeAccess().getDocuDocumentationParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExternalTypeRule());
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


            }


            }

             leaveRule(); 
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
    // InternalRoom.g:1056:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // InternalRoom.g:1057:2: (iv_ruleDataClass= ruleDataClass EOF )
            // InternalRoom.g:1058:2: iv_ruleDataClass= ruleDataClass EOF
            {
             newCompositeNode(grammarAccess.getDataClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataClass=ruleDataClass();

            state._fsp--;

             current =iv_ruleDataClass; 
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
    // $ANTLR end "entryRuleDataClass"


    // $ANTLR start "ruleDataClass"
    // InternalRoom.g:1065:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) ;
    public final EObject ruleDataClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_16=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_6_0 = null;

        EObject lv_userCode1_8_0 = null;

        EObject lv_userCode2_10_0 = null;

        EObject lv_userCode3_12_0 = null;

        EObject lv_operations_13_0 = null;

        EObject lv_structors_14_0 = null;

        EObject lv_attributes_15_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1068:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) )
            // InternalRoom.g:1069:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            {
            // InternalRoom.g:1069:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            // InternalRoom.g:1069:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // InternalRoom.g:1073:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1074:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1074:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1075:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDataClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDataClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:1091:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRoom.g:1092:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1092:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:1093:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_25);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
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

            // InternalRoom.g:1109:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRoom.g:1109:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // InternalRoom.g:1113:1: ( ( ruleFQN ) )
                    // InternalRoom.g:1114:1: ( ruleFQN )
                    {
                    // InternalRoom.g:1114:1: ( ruleFQN )
                    // InternalRoom.g:1115:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDataClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getBaseDataClassCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_26); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:1132:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==107) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalRoom.g:1133:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1133:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:1134:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAnnotationsAnnotationParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_26);
            	    lv_annotations_6_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_6_0, 
            	            		"org.eclipse.etrice.core.common.Base.Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalRoom.g:1150:3: (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRoom.g:1150:5: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,29,FOLLOW_5); 

                        	newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                        
                    // InternalRoom.g:1154:1: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // InternalRoom.g:1155:1: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1155:1: (lv_userCode1_8_0= ruleDetailCode )
                    // InternalRoom.g:1156:3: lv_userCode1_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_27);
                    lv_userCode1_8_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_8_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1172:4: (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRoom.g:1172:6: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_5); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                        
                    // InternalRoom.g:1176:1: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // InternalRoom.g:1177:1: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1177:1: (lv_userCode2_10_0= ruleDetailCode )
                    // InternalRoom.g:1178:3: lv_userCode2_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_28);
                    lv_userCode2_10_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_10_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1194:4: (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRoom.g:1194:6: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,31,FOLLOW_5); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                        
                    // InternalRoom.g:1198:1: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // InternalRoom.g:1199:1: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1199:1: (lv_userCode3_12_0= ruleDetailCode )
                    // InternalRoom.g:1200:3: lv_userCode3_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_29);
                    lv_userCode3_12_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_12_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1216:4: ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )*
            loop24:
            do {
                int alt24=4;
                switch ( input.LA(1) ) {
                case 35:
                case 36:
                    {
                    alt24=1;
                    }
                    break;
                case 39:
                case 40:
                    {
                    alt24=2;
                    }
                    break;
                case 32:
                    {
                    alt24=3;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // InternalRoom.g:1216:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    {
            	    // InternalRoom.g:1216:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    // InternalRoom.g:1217:1: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // InternalRoom.g:1217:1: (lv_operations_13_0= ruleStandardOperation )
            	    // InternalRoom.g:1218:3: lv_operations_13_0= ruleStandardOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_9_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_29);
            	    lv_operations_13_0=ruleStandardOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_13_0, 
            	            		"org.eclipse.etrice.core.Room.StandardOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoom.g:1235:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    {
            	    // InternalRoom.g:1235:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    // InternalRoom.g:1236:1: (lv_structors_14_0= ruleClassStructor )
            	    {
            	    // InternalRoom.g:1236:1: (lv_structors_14_0= ruleClassStructor )
            	    // InternalRoom.g:1237:3: lv_structors_14_0= ruleClassStructor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getStructorsClassStructorParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_29);
            	    lv_structors_14_0=ruleClassStructor();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"structors",
            	            		lv_structors_14_0, 
            	            		"org.eclipse.etrice.core.Room.ClassStructor");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoom.g:1254:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:1254:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    // InternalRoom.g:1255:1: (lv_attributes_15_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:1255:1: (lv_attributes_15_0= ruleAttribute )
            	    // InternalRoom.g:1256:3: lv_attributes_15_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_29);
            	    lv_attributes_15_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_15_0, 
            	            		"org.eclipse.etrice.core.Room.Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_16=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_16, grammarAccess.getDataClassAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
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
    // InternalRoom.g:1284:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalRoom.g:1285:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalRoom.g:1286:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalRoom.g:1293:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
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
        EObject lv_type_6_0 = null;

        EObject lv_docu_9_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1296:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:1297:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:1297:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // InternalRoom.g:1297:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // InternalRoom.g:1301:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1302:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1302:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1303:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:1319:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRoom.g:1319:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_31); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // InternalRoom.g:1323:1: ( (lv_size_3_0= RULE_INT ) )
                    // InternalRoom.g:1324:1: (lv_size_3_0= RULE_INT )
                    {
                    // InternalRoom.g:1324:1: (lv_size_3_0= RULE_INT )
                    // InternalRoom.g:1325:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_32); 

                    			newLeafNode(lv_size_3_0, grammarAccess.getAttributeAccess().getSizeINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"size",
                            		lv_size_3_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,34,FOLLOW_8); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_33); 

                	newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getColonKeyword_3());
                
            // InternalRoom.g:1349:1: ( (lv_type_6_0= ruleRefableType ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRoom.g:1350:1: (lv_type_6_0= ruleRefableType )
                    {
                    // InternalRoom.g:1350:1: (lv_type_6_0= ruleRefableType )
                    // InternalRoom.g:1351:3: lv_type_6_0= ruleRefableType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeRefableTypeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_type_6_0=ruleRefableType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_6_0, 
                            		"org.eclipse.etrice.core.Room.RefableType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalRoom.g:1367:3: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRoom.g:1367:5: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_12); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                        
                    // InternalRoom.g:1371:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // InternalRoom.g:1372:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // InternalRoom.g:1372:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // InternalRoom.g:1373:3: lv_defaultValueLiteral_8_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

                    			newLeafNode(lv_defaultValueLiteral_8_0, grammarAccess.getAttributeAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_8_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1389:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRoom.g:1390:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1390:1: (lv_docu_9_0= ruleDocumentation )
                    // InternalRoom.g:1391:3: lv_docu_9_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_9_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_9_0, 
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleStandardOperation"
    // InternalRoom.g:1417:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalRoom.g:1418:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalRoom.g:1419:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
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
    // $ANTLR end "entryRuleStandardOperation"


    // $ANTLR start "ruleStandardOperation"
    // InternalRoom.g:1426:1: ruleStandardOperation returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
    public final EObject ruleStandardOperation() throws RecognitionException {
        EObject current = null;

        Token lv_override_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_returnType_10_0 = null;

        EObject lv_docu_11_0 = null;

        EObject lv_detailCode_12_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1429:28: ( ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1430:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1430:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // InternalRoom.g:1430:2: ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1430:2: ( (lv_override_0_0= 'override' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==35) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRoom.g:1431:1: (lv_override_0_0= 'override' )
                    {
                    // InternalRoom.g:1431:1: (lv_override_0_0= 'override' )
                    // InternalRoom.g:1432:3: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,35,FOLLOW_35); 

                            newLeafNode(lv_override_0_0, grammarAccess.getStandardOperationAccess().getOverrideOverrideKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStandardOperationRule());
                    	        }
                           		setWithLastConsumed(current, "override", true, "override");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,36,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getStandardOperationAccess().getOperationKeyword_1());
                
            // InternalRoom.g:1449:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1450:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1450:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1451:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            			newLeafNode(lv_name_2_0, grammarAccess.getStandardOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_37); 

                	newLeafNode(otherlv_3, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_3());
                
            // InternalRoom.g:1471:1: ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRoom.g:1471:2: ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1471:2: ( (lv_arguments_4_0= ruleVarDecl ) )
                    // InternalRoom.g:1472:1: (lv_arguments_4_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1472:1: (lv_arguments_4_0= ruleVarDecl )
                    // InternalRoom.g:1473:3: lv_arguments_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_arguments_4_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_4_0, 
                            		"org.eclipse.etrice.core.Room.VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalRoom.g:1489:2: (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==24) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalRoom.g:1489:4: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,24,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // InternalRoom.g:1493:1: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1494:1: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1494:1: (lv_arguments_6_0= ruleVarDecl )
                    	    // InternalRoom.g:1495:3: lv_arguments_6_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
                    	    lv_arguments_6_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_6_0, 
                    	            		"org.eclipse.etrice.core.Room.VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_39); 

                	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
                
            // InternalRoom.g:1515:1: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==15) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRoom.g:1515:3: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_40); 

                        	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                        
                    // InternalRoom.g:1519:1: (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==37) ) {
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
                            // InternalRoom.g:1519:3: otherlv_9= 'void'
                            {
                            otherlv_9=(Token)match(input,37,FOLLOW_4); 

                                	newLeafNode(otherlv_9, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1524:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1524:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            // InternalRoom.g:1525:1: (lv_returnType_10_0= ruleRefableType )
                            {
                            // InternalRoom.g:1525:1: (lv_returnType_10_0= ruleRefableType )
                            // InternalRoom.g:1526:3: lv_returnType_10_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getReturnTypeRefableTypeParserRuleCall_6_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_4);
                            lv_returnType_10_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returnType",
                                    		lv_returnType_10_0, 
                                    		"org.eclipse.etrice.core.Room.RefableType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalRoom.g:1542:5: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==33) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalRoom.g:1543:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1543:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:1544:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_11_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_11_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalRoom.g:1560:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // InternalRoom.g:1561:1: (lv_detailCode_12_0= ruleDetailCode )
            {
            // InternalRoom.g:1561:1: (lv_detailCode_12_0= ruleDetailCode )
            // InternalRoom.g:1562:3: lv_detailCode_12_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDetailCodeDetailCodeParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_detailCode_12_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_12_0, 
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
    // $ANTLR end "ruleStandardOperation"


    // $ANTLR start "entryRulePortOperation"
    // InternalRoom.g:1586:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // InternalRoom.g:1587:2: (iv_rulePortOperation= rulePortOperation EOF )
            // InternalRoom.g:1588:2: iv_rulePortOperation= rulePortOperation EOF
            {
             newCompositeNode(grammarAccess.getPortOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePortOperation=rulePortOperation();

            state._fsp--;

             current =iv_rulePortOperation; 
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
    // $ANTLR end "entryRulePortOperation"


    // $ANTLR start "rulePortOperation"
    // InternalRoom.g:1595:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
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

        EObject lv_returnType_9_0 = null;

        EObject lv_docu_12_0 = null;

        EObject lv_detailCode_13_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1598:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1599:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1599:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // InternalRoom.g:1599:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // InternalRoom.g:1603:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1604:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1604:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1605:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPortOperationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_37); 

                	newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
                
            // InternalRoom.g:1625:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRoom.g:1625:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1625:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // InternalRoom.g:1626:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1626:1: (lv_arguments_3_0= ruleVarDecl )
                    // InternalRoom.g:1627:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_arguments_3_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_3_0, 
                            		"org.eclipse.etrice.core.Room.VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalRoom.g:1643:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==24) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalRoom.g:1643:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalRoom.g:1647:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1648:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1648:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // InternalRoom.g:1649:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
                    	    lv_arguments_5_0=ruleVarDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_5_0, 
                    	            		"org.eclipse.etrice.core.Room.VarDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_41); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // InternalRoom.g:1669:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==15) ) {
                alt38=1;
            }
            else if ( (LA38_0==38) ) {
                alt38=2;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoom.g:1669:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    {
                    // InternalRoom.g:1669:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    // InternalRoom.g:1669:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_40); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // InternalRoom.g:1673:1: (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==37) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==RULE_ID) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalRoom.g:1673:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,37,FOLLOW_4); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1678:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1678:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            // InternalRoom.g:1679:1: (lv_returnType_9_0= ruleRefableType )
                            {
                            // InternalRoom.g:1679:1: (lv_returnType_9_0= ruleRefableType )
                            // InternalRoom.g:1680:3: lv_returnType_9_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortOperationAccess().getReturnTypeRefableTypeParserRuleCall_5_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_4);
                            lv_returnType_9_0=ruleRefableType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"returnType",
                                    		lv_returnType_9_0, 
                                    		"org.eclipse.etrice.core.Room.RefableType");
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
                    // InternalRoom.g:1697:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalRoom.g:1697:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // InternalRoom.g:1697:8: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,38,FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // InternalRoom.g:1701:1: ( (otherlv_11= RULE_ID ) )
                    // InternalRoom.g:1702:1: (otherlv_11= RULE_ID )
                    {
                    // InternalRoom.g:1702:1: (otherlv_11= RULE_ID )
                    // InternalRoom.g:1703:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_4); 

                    		newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1714:5: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==33) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRoom.g:1715:1: (lv_docu_12_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1715:1: (lv_docu_12_0= ruleDocumentation )
                    // InternalRoom.g:1716:3: lv_docu_12_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_12_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_12_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalRoom.g:1732:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // InternalRoom.g:1733:1: (lv_detailCode_13_0= ruleDetailCode )
            {
            // InternalRoom.g:1733:1: (lv_detailCode_13_0= ruleDetailCode )
            // InternalRoom.g:1734:3: lv_detailCode_13_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getPortOperationAccess().getDetailCodeDetailCodeParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_detailCode_13_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortOperationRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_13_0, 
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
    // $ANTLR end "rulePortOperation"


    // $ANTLR start "entryRuleClassStructor"
    // InternalRoom.g:1758:1: entryRuleClassStructor returns [EObject current=null] : iv_ruleClassStructor= ruleClassStructor EOF ;
    public final EObject entryRuleClassStructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassStructor = null;


        try {
            // InternalRoom.g:1759:2: (iv_ruleClassStructor= ruleClassStructor EOF )
            // InternalRoom.g:1760:2: iv_ruleClassStructor= ruleClassStructor EOF
            {
             newCompositeNode(grammarAccess.getClassStructorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassStructor=ruleClassStructor();

            state._fsp--;

             current =iv_ruleClassStructor; 
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
    // $ANTLR end "entryRuleClassStructor"


    // $ANTLR start "ruleClassStructor"
    // InternalRoom.g:1767:1: ruleClassStructor returns [EObject current=null] : ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleClassStructor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_detailCode_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1770:28: ( ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1771:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1771:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:1771:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1771:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) )
            // InternalRoom.g:1772:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            {
            // InternalRoom.g:1772:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            // InternalRoom.g:1773:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            {
            // InternalRoom.g:1773:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==39) ) {
                alt40=1;
            }
            else if ( (LA40_0==40) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalRoom.g:1774:3: lv_name_0_1= 'ctor'
                    {
                    lv_name_0_1=(Token)match(input,39,FOLLOW_5); 

                            newLeafNode(lv_name_0_1, grammarAccess.getClassStructorAccess().getNameCtorKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassStructorRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalRoom.g:1786:8: lv_name_0_2= 'dtor'
                    {
                    lv_name_0_2=(Token)match(input,40,FOLLOW_5); 

                            newLeafNode(lv_name_0_2, grammarAccess.getClassStructorAccess().getNameDtorKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassStructorRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalRoom.g:1801:2: ( (lv_detailCode_1_0= ruleDetailCode ) )
            // InternalRoom.g:1802:1: (lv_detailCode_1_0= ruleDetailCode )
            {
            // InternalRoom.g:1802:1: (lv_detailCode_1_0= ruleDetailCode )
            // InternalRoom.g:1803:3: lv_detailCode_1_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getClassStructorAccess().getDetailCodeDetailCodeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_detailCode_1_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassStructorRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_1_0, 
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
    // $ANTLR end "ruleClassStructor"


    // $ANTLR start "entryRuleGeneralProtocolClass"
    // InternalRoom.g:1827:1: entryRuleGeneralProtocolClass returns [EObject current=null] : iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF ;
    public final EObject entryRuleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralProtocolClass = null;


        try {
            // InternalRoom.g:1828:2: (iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF )
            // InternalRoom.g:1829:2: iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getGeneralProtocolClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralProtocolClass=ruleGeneralProtocolClass();

            state._fsp--;

             current =iv_ruleGeneralProtocolClass; 
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
    // $ANTLR end "entryRuleGeneralProtocolClass"


    // $ANTLR start "ruleGeneralProtocolClass"
    // InternalRoom.g:1836:1: ruleGeneralProtocolClass returns [EObject current=null] : (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) ;
    public final EObject ruleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject this_ProtocolClass_0 = null;

        EObject this_CompoundProtocolClass_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1839:28: ( (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) )
            // InternalRoom.g:1840:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            {
            // InternalRoom.g:1840:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41||(LA41_0>=123 && LA41_0<=125)) ) {
                alt41=1;
            }
            else if ( (LA41_0==47) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalRoom.g:1841:5: this_ProtocolClass_0= ruleProtocolClass
                    {
                     
                            newCompositeNode(grammarAccess.getGeneralProtocolClassAccess().getProtocolClassParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ProtocolClass_0=ruleProtocolClass();

                    state._fsp--;

                     
                            current = this_ProtocolClass_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:1851:5: this_CompoundProtocolClass_1= ruleCompoundProtocolClass
                    {
                     
                            newCompositeNode(grammarAccess.getGeneralProtocolClassAccess().getCompoundProtocolClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:1867:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // InternalRoom.g:1868:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // InternalRoom.g:1869:2: iv_ruleProtocolClass= ruleProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getProtocolClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocolClass=ruleProtocolClass();

            state._fsp--;

             current =iv_ruleProtocolClass; 
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
    // $ANTLR end "entryRuleProtocolClass"


    // $ANTLR start "ruleProtocolClass"
    // InternalRoom.g:1876:1: ruleProtocolClass returns [EObject current=null] : ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) ;
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

        EObject lv_conjugated_27_0 = null;

        EObject lv_semantics_28_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1879:28: ( ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) )
            // InternalRoom.g:1880:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            {
            // InternalRoom.g:1880:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            // InternalRoom.g:1880:2: ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}'
            {
            // InternalRoom.g:1880:2: ( (lv_commType_0_0= ruleCommunicationType ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=123 && LA42_0<=125)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRoom.g:1881:1: (lv_commType_0_0= ruleCommunicationType )
                    {
                    // InternalRoom.g:1881:1: (lv_commType_0_0= ruleCommunicationType )
                    // InternalRoom.g:1882:3: lv_commType_0_0= ruleCommunicationType
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getCommTypeCommunicationTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_42);
                    lv_commType_0_0=ruleCommunicationType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"commType",
                            		lv_commType_0_0, 
                            		"org.eclipse.etrice.core.Room.CommunicationType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,41,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_1());
                
            // InternalRoom.g:1902:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1903:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1903:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1904:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            			newLeafNode(lv_name_2_0, grammarAccess.getProtocolClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:1920:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==33) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRoom.g:1921:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1921:1: (lv_docu_3_0= ruleDocumentation )
                    // InternalRoom.g:1922:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_25);
                    lv_docu_3_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_3_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalRoom.g:1938:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoom.g:1938:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_3); 

                        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:1942:1: ( ( ruleFQN ) )
                    // InternalRoom.g:1943:1: ( ruleFQN )
                    {
                    // InternalRoom.g:1943:1: ( ruleFQN )
                    // InternalRoom.g:1944:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getProtocolClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getBaseProtocolClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_43); 

                	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:1961:1: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==107) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalRoom.g:1962:1: (lv_annotations_7_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1962:1: (lv_annotations_7_0= ruleAnnotation )
            	    // InternalRoom.g:1963:3: lv_annotations_7_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_43);
            	    lv_annotations_7_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_7_0, 
            	            		"org.eclipse.etrice.core.common.Base.Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalRoom.g:1979:3: (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==29) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRoom.g:1979:5: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,29,FOLLOW_5); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                        
                    // InternalRoom.g:1983:1: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // InternalRoom.g:1984:1: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1984:1: (lv_userCode1_9_0= ruleDetailCode )
                    // InternalRoom.g:1985:3: lv_userCode1_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_44);
                    lv_userCode1_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_9_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2001:4: (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==30) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRoom.g:2001:6: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                        
                    // InternalRoom.g:2005:1: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // InternalRoom.g:2006:1: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2006:1: (lv_userCode2_11_0= ruleDetailCode )
                    // InternalRoom.g:2007:3: lv_userCode2_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_45);
                    lv_userCode2_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_11_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2023:4: (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==31) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRoom.g:2023:6: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,31,FOLLOW_5); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                        
                    // InternalRoom.g:2027:1: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // InternalRoom.g:2028:1: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2028:1: (lv_userCode3_13_0= ruleDetailCode )
                    // InternalRoom.g:2029:3: lv_userCode3_13_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_46);
                    lv_userCode3_13_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_13_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2045:4: (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==42) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRoom.g:2045:6: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,42,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,13,FOLLOW_47); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // InternalRoom.g:2053:1: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( ((LA49_0>=49 && LA49_0<=50)) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalRoom.g:2054:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2054:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    // InternalRoom.g:2055:3: lv_incomingMessages_16_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_10_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_47);
                    	    lv_incomingMessages_16_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"incomingMessages",
                    	            		lv_incomingMessages_16_0, 
                    	            		"org.eclipse.etrice.core.Room.Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,14,FOLLOW_48); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2075:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==43) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoom.g:2075:5: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,43,FOLLOW_5); 

                        	newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                        
                    otherlv_19=(Token)match(input,13,FOLLOW_47); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // InternalRoom.g:2083:1: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=49 && LA51_0<=50)) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalRoom.g:2084:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2084:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    // InternalRoom.g:2085:3: lv_outgoingMessages_20_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_11_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_47);
                    	    lv_outgoingMessages_20_0=ruleMessage();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outgoingMessages",
                    	            		lv_outgoingMessages_20_0, 
                    	            		"org.eclipse.etrice.core.Room.Message");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,14,FOLLOW_49); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2105:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==44) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRoom.g:2105:5: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,44,FOLLOW_50); 

                        	newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                        
                    otherlv_23=(Token)match(input,45,FOLLOW_5); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                        
                    // InternalRoom.g:2113:1: ( (lv_regular_24_0= rulePortClass ) )
                    // InternalRoom.g:2114:1: (lv_regular_24_0= rulePortClass )
                    {
                    // InternalRoom.g:2114:1: (lv_regular_24_0= rulePortClass )
                    // InternalRoom.g:2115:3: lv_regular_24_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FOLLOW_51);
                    lv_regular_24_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"regular",
                            		lv_regular_24_0, 
                            		"org.eclipse.etrice.core.Room.PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2131:4: (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==46) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRoom.g:2131:6: otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,46,FOLLOW_50); 

                        	newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugatedKeyword_13_0());
                        
                    otherlv_26=(Token)match(input,45,FOLLOW_5); 

                        	newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                        
                    // InternalRoom.g:2139:1: ( (lv_conjugated_27_0= rulePortClass ) )
                    // InternalRoom.g:2140:1: (lv_conjugated_27_0= rulePortClass )
                    {
                    // InternalRoom.g:2140:1: (lv_conjugated_27_0= rulePortClass )
                    // InternalRoom.g:2141:3: lv_conjugated_27_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatedPortClassParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FOLLOW_52);
                    lv_conjugated_27_0=rulePortClass();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"conjugated",
                            		lv_conjugated_27_0, 
                            		"org.eclipse.etrice.core.Room.PortClass");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2157:4: ( (lv_semantics_28_0= ruleProtocolSemantics ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==104) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRoom.g:2158:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    {
                    // InternalRoom.g:2158:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    // InternalRoom.g:2159:3: lv_semantics_28_0= ruleProtocolSemantics
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_14_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_semantics_28_0=ruleProtocolSemantics();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProtocolClassRule());
                    	        }
                           		set(
                           			current, 
                           			"semantics",
                            		lv_semantics_28_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.ProtocolSemantics");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_29=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:2187:1: entryRuleCompoundProtocolClass returns [EObject current=null] : iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF ;
    public final EObject entryRuleCompoundProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundProtocolClass = null;


        try {
            // InternalRoom.g:2188:2: (iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF )
            // InternalRoom.g:2189:2: iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF
            {
             newCompositeNode(grammarAccess.getCompoundProtocolClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompoundProtocolClass=ruleCompoundProtocolClass();

            state._fsp--;

             current =iv_ruleCompoundProtocolClass; 
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
    // $ANTLR end "entryRuleCompoundProtocolClass"


    // $ANTLR start "ruleCompoundProtocolClass"
    // InternalRoom.g:2196:1: ruleCompoundProtocolClass returns [EObject current=null] : (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) ;
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
            // InternalRoom.g:2199:28: ( (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) )
            // InternalRoom.g:2200:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            {
            // InternalRoom.g:2200:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            // InternalRoom.g:2200:3: otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getCompoundProtocolClassAccess().getCompoundProtocolClassKeyword_0());
                
            // InternalRoom.g:2204:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2205:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2205:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2206:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCompoundProtocolClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompoundProtocolClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:2222:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==33) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRoom.g:2223:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2223:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:2224:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_54); 

                	newLeafNode(otherlv_3, grammarAccess.getCompoundProtocolClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:2244:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==107) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalRoom.g:2245:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2245:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:2246:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
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
            	    break loop57;
                }
            } while (true);

            // InternalRoom.g:2262:3: ( (lv_subProtocols_5_0= ruleSubProtocol ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==48) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalRoom.g:2263:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    {
            	    // InternalRoom.g:2263:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    // InternalRoom.g:2264:3: lv_subProtocols_5_0= ruleSubProtocol
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getSubProtocolsSubProtocolParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_55);
            	    lv_subProtocols_5_0=ruleSubProtocol();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundProtocolClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subProtocols",
            	            		lv_subProtocols_5_0, 
            	            		"org.eclipse.etrice.core.Room.SubProtocol");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:2292:1: entryRuleSubProtocol returns [EObject current=null] : iv_ruleSubProtocol= ruleSubProtocol EOF ;
    public final EObject entryRuleSubProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProtocol = null;


        try {
            // InternalRoom.g:2293:2: (iv_ruleSubProtocol= ruleSubProtocol EOF )
            // InternalRoom.g:2294:2: iv_ruleSubProtocol= ruleSubProtocol EOF
            {
             newCompositeNode(grammarAccess.getSubProtocolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubProtocol=ruleSubProtocol();

            state._fsp--;

             current =iv_ruleSubProtocol; 
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
    // $ANTLR end "entryRuleSubProtocol"


    // $ANTLR start "ruleSubProtocol"
    // InternalRoom.g:2301:1: ruleSubProtocol returns [EObject current=null] : (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSubProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:2304:28: ( (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:2305:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:2305:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:2305:3: otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubProtocolAccess().getSubProtocolKeyword_0());
                
            // InternalRoom.g:2309:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2310:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2310:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2311:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubProtocolAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubProtocolRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSubProtocolAccess().getColonKeyword_2());
                
            // InternalRoom.g:2331:1: ( ( ruleFQN ) )
            // InternalRoom.g:2332:1: ( ruleFQN )
            {
            // InternalRoom.g:2332:1: ( ruleFQN )
            // InternalRoom.g:2333:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubProtocolRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubProtocolAccess().getProtocolGeneralProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // InternalRoom.g:2354:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalRoom.g:2355:2: (iv_ruleMessage= ruleMessage EOF )
            // InternalRoom.g:2356:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
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
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalRoom.g:2363:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:2366:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:2367:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:2367:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:2367:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:2367:2: ( (lv_priv_0_0= 'private' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==49) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRoom.g:2368:1: (lv_priv_0_0= 'private' )
                    {
                    // InternalRoom.g:2368:1: (lv_priv_0_0= 'private' )
                    // InternalRoom.g:2369:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,49,FOLLOW_56); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,50,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // InternalRoom.g:2386:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:2387:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:2387:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:2388:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            			newLeafNode(lv_name_2_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_37); 

                	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3());
                
            // InternalRoom.g:2408:1: ( (lv_data_4_0= ruleVarDecl ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRoom.g:2409:1: (lv_data_4_0= ruleVarDecl )
                    {
                    // InternalRoom.g:2409:1: (lv_data_4_0= ruleVarDecl )
                    // InternalRoom.g:2410:3: lv_data_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDataVarDeclParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_14);
                    lv_data_4_0=ruleVarDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
                    	        }
                           		set(
                           			current, 
                           			"data",
                            		lv_data_4_0, 
                            		"org.eclipse.etrice.core.Room.VarDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_16); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_5());
                
            // InternalRoom.g:2430:1: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==33) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRoom.g:2431:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2431:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:2432:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
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


            }


            }

             leaveRule(); 
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
    // InternalRoom.g:2456:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // InternalRoom.g:2457:2: (iv_rulePortClass= rulePortClass EOF )
            // InternalRoom.g:2458:2: iv_rulePortClass= rulePortClass EOF
            {
             newCompositeNode(grammarAccess.getPortClassRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePortClass=rulePortClass();

            state._fsp--;

             current =iv_rulePortClass; 
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
    // $ANTLR end "entryRulePortClass"


    // $ANTLR start "rulePortClass"
    // InternalRoom.g:2465:1: rulePortClass returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) ;
    public final EObject rulePortClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_userCode_3_0 = null;

        EObject lv_msgHandlers_4_0 = null;

        EObject lv_operations_5_0 = null;

        EObject lv_attributes_6_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2468:28: ( ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:2469:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:2469:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            // InternalRoom.g:2469:2: () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:2469:2: ()
            // InternalRoom.g:2470:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassAccess().getPortClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_57); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:2479:1: (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==51) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRoom.g:2479:3: otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) )
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getPortClassAccess().getUsercodeKeyword_2_0());
                        
                    // InternalRoom.g:2483:1: ( (lv_userCode_3_0= ruleDetailCode ) )
                    // InternalRoom.g:2484:1: (lv_userCode_3_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2484:1: (lv_userCode_3_0= ruleDetailCode )
                    // InternalRoom.g:2485:3: lv_userCode_3_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_58);
                    lv_userCode_3_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode",
                            		lv_userCode_3_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:2501:4: ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )*
            loop63:
            do {
                int alt63=4;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    alt63=1;
                    }
                    break;
                case 36:
                    {
                    alt63=2;
                    }
                    break;
                case 32:
                    {
                    alt63=3;
                    }
                    break;

                }

                switch (alt63) {
            	case 1 :
            	    // InternalRoom.g:2501:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    {
            	    // InternalRoom.g:2501:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    // InternalRoom.g:2502:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    {
            	    // InternalRoom.g:2502:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    // InternalRoom.g:2503:3: lv_msgHandlers_4_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_58);
            	    lv_msgHandlers_4_0=ruleMessageHandler();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"msgHandlers",
            	            		lv_msgHandlers_4_0, 
            	            		"org.eclipse.etrice.core.Room.MessageHandler");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoom.g:2520:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    {
            	    // InternalRoom.g:2520:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    // InternalRoom.g:2521:1: (lv_operations_5_0= rulePortOperation )
            	    {
            	    // InternalRoom.g:2521:1: (lv_operations_5_0= rulePortOperation )
            	    // InternalRoom.g:2522:3: lv_operations_5_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_58);
            	    lv_operations_5_0=rulePortOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_5_0, 
            	            		"org.eclipse.etrice.core.Room.PortOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoom.g:2539:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:2539:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    // InternalRoom.g:2540:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:2540:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalRoom.g:2541:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_58);
            	    lv_attributes_6_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_6_0, 
            	            		"org.eclipse.etrice.core.Room.Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getPortClassAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
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
    // InternalRoom.g:2569:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // InternalRoom.g:2570:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // InternalRoom.g:2571:2: iv_ruleMessageHandler= ruleMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getMessageHandlerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageHandler=ruleMessageHandler();

            state._fsp--;

             current =iv_ruleMessageHandler; 
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
    // $ANTLR end "entryRuleMessageHandler"


    // $ANTLR start "ruleMessageHandler"
    // InternalRoom.g:2578:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2581:28: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // InternalRoom.g:2582:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // InternalRoom.g:2582:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==52) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==43) ) {
                    alt64=2;
                }
                else if ( (LA64_1==42) ) {
                    alt64=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalRoom.g:2583:5: this_InMessageHandler_0= ruleInMessageHandler
                    {
                     
                            newCompositeNode(grammarAccess.getMessageHandlerAccess().getInMessageHandlerParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_InMessageHandler_0=ruleInMessageHandler();

                    state._fsp--;

                     
                            current = this_InMessageHandler_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:2593:5: this_OutMessageHandler_1= ruleOutMessageHandler
                    {
                     
                            newCompositeNode(grammarAccess.getMessageHandlerAccess().getOutMessageHandlerParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:2609:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // InternalRoom.g:2610:2: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // InternalRoom.g:2611:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getInMessageHandlerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInMessageHandler=ruleInMessageHandler();

            state._fsp--;

             current =iv_ruleInMessageHandler; 
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
    // $ANTLR end "entryRuleInMessageHandler"


    // $ANTLR start "ruleInMessageHandler"
    // InternalRoom.g:2618:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2621:28: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2622:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2622:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2622:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_59); 

                	newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,42,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
                
            // InternalRoom.g:2630:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2631:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2631:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2632:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_5); 

            		newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2643:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2644:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2644:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2645:3: lv_detailCode_3_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getInMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_detailCode_3_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_3_0, 
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
    // $ANTLR end "ruleInMessageHandler"


    // $ANTLR start "entryRuleOutMessageHandler"
    // InternalRoom.g:2669:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // InternalRoom.g:2670:2: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // InternalRoom.g:2671:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
            {
             newCompositeNode(grammarAccess.getOutMessageHandlerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutMessageHandler=ruleOutMessageHandler();

            state._fsp--;

             current =iv_ruleOutMessageHandler; 
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
    // $ANTLR end "entryRuleOutMessageHandler"


    // $ANTLR start "ruleOutMessageHandler"
    // InternalRoom.g:2678:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2681:28: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2682:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2682:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2682:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_60); 

                	newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,43,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
                
            // InternalRoom.g:2690:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2691:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2691:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2692:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_5); 

            		newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2703:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2704:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2704:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2705:3: lv_detailCode_3_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getOutMessageHandlerAccess().getDetailCodeDetailCodeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_detailCode_3_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOutMessageHandlerRule());
            	        }
                   		set(
                   			current, 
                   			"detailCode",
                    		lv_detailCode_3_0, 
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
    // $ANTLR end "ruleOutMessageHandler"


    // $ANTLR start "entryRuleModelComponent"
    // InternalRoom.g:2729:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalRoom.g:2730:2: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalRoom.g:2731:2: iv_ruleModelComponent= ruleModelComponent EOF
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
    // InternalRoom.g:2738:1: ruleModelComponent returns [EObject current=null] : this_ActorClass_0= ruleActorClass ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2741:28: (this_ActorClass_0= ruleActorClass )
            // InternalRoom.g:2743:5: this_ActorClass_0= ruleActorClass
            {
             
                    newCompositeNode(grammarAccess.getModelComponentAccess().getActorClassParserRuleCall()); 
                
            pushFollow(FOLLOW_2);
            this_ActorClass_0=ruleActorClass();

            state._fsp--;

             
                    current = this_ActorClass_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleActorClass"
    // InternalRoom.g:2759:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // InternalRoom.g:2760:2: (iv_ruleActorClass= ruleActorClass EOF )
            // InternalRoom.g:2761:2: iv_ruleActorClass= ruleActorClass EOF
            {
             newCompositeNode(grammarAccess.getActorClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorClass=ruleActorClass();

            state._fsp--;

             current =iv_ruleActorClass; 
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
    // $ANTLR end "entryRuleActorClass"


    // $ANTLR start "ruleActorClass"
    // InternalRoom.g:2768:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) ;
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
        Token otherlv_40=null;
        Token otherlv_41=null;
        Enumerator lv_commType_2_0 = null;

        EObject lv_docu_5_0 = null;

        EObject lv_annotations_9_0 = null;

        EObject lv_serviceProvisionPoints_12_0 = null;

        EObject lv_interfacePorts_13_0 = null;

        EObject lv_structureDocu_16_0 = null;

        EObject lv_userCode1_19_0 = null;

        EObject lv_userCode2_21_0 = null;

        EObject lv_userCode3_23_0 = null;

        EObject lv_connections_24_0 = null;

        EObject lv_bindings_25_0 = null;

        EObject lv_serviceImplementations_26_0 = null;

        EObject lv_attributes_27_0 = null;

        EObject lv_actorRefs_28_0 = null;

        EObject lv_serviceAccessPoints_29_0 = null;

        EObject lv_internalPorts_30_0 = null;

        EObject lv_externalPorts_31_0 = null;

        EObject lv_behaviorDocu_34_0 = null;

        EObject lv_behaviorAnnotations_36_0 = null;

        EObject lv_operations_37_0 = null;

        EObject lv_structors_38_0 = null;

        EObject lv_stateMachine_39_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2771:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalRoom.g:2772:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalRoom.g:2772:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            // InternalRoom.g:2772:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}'
            {
            // InternalRoom.g:2772:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalRoom.g:2774:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalRoom.g:2774:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalRoom.g:2775:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	
            // InternalRoom.g:2778:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalRoom.g:2779:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalRoom.g:2779:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop65:
            do {
                int alt65=3;
                int LA65_0 = input.LA(1);

                if ( LA65_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt65=1;
                }
                else if ( ( LA65_0 >= 123 && LA65_0 <= 125 || LA65_0 == 127 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt65=2;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalRoom.g:2781:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalRoom.g:2781:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalRoom.g:2782:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalRoom.g:2782:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalRoom.g:2783:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // InternalRoom.g:2786:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalRoom.g:2786:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2786:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalRoom.g:2787:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalRoom.g:2787:1: (lv_abstract_1_0= 'abstract' )
            	    // InternalRoom.g:2788:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,53,FOLLOW_61); 

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
            	    // InternalRoom.g:2808:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalRoom.g:2808:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalRoom.g:2809:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalRoom.g:2809:107: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalRoom.g:2810:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // InternalRoom.g:2813:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalRoom.g:2813:7: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2813:16: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalRoom.g:2814:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalRoom.g:2814:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalRoom.g:2815:3: lv_commType_2_0= ruleComponentCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_61);
            	    lv_commType_2_0=ruleComponentCommunicationType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,54,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // InternalRoom.g:2849:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalRoom.g:2850:1: (lv_name_4_0= RULE_ID )
            {
            // InternalRoom.g:2850:1: (lv_name_4_0= RULE_ID )
            // InternalRoom.g:2851:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            			newLeafNode(lv_name_4_0, grammarAccess.getActorClassAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:2867:2: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==33) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRoom.g:2868:1: (lv_docu_5_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2868:1: (lv_docu_5_0= ruleDocumentation )
                    // InternalRoom.g:2869:3: lv_docu_5_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_25);
                    lv_docu_5_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_5_0, 
                            		"org.eclipse.etrice.core.common.Base.Documentation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalRoom.g:2885:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==28) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRoom.g:2885:5: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:2889:1: ( ( ruleFQN ) )
                    // InternalRoom.g:2890:1: ( ruleFQN )
                    {
                    // InternalRoom.g:2890:1: ( ruleFQN )
                    // InternalRoom.g:2891:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getActorClassRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getBaseActorClassCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_62); 

                	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:2908:1: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==107) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalRoom.g:2909:1: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2909:1: (lv_annotations_9_0= ruleAnnotation )
            	    // InternalRoom.g:2910:3: lv_annotations_9_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_62);
            	    lv_annotations_9_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_9_0, 
            	            		"org.eclipse.etrice.core.common.Base.Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

            // InternalRoom.g:2926:3: (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==55) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRoom.g:2926:5: otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,55,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,13,FOLLOW_63); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // InternalRoom.g:2934:1: ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )*
                    loop69:
                    do {
                        int alt69=3;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==61) ) {
                            alt69=1;
                        }
                        else if ( (LA69_0==46||LA69_0==58) ) {
                            alt69=2;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalRoom.g:2934:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    {
                    	    // InternalRoom.g:2934:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    // InternalRoom.g:2935:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    {
                    	    // InternalRoom.g:2935:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    // InternalRoom.g:2936:3: lv_serviceProvisionPoints_12_0= ruleSPP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceProvisionPointsSPPParserRuleCall_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_63);
                    	    lv_serviceProvisionPoints_12_0=ruleSPP();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceProvisionPoints",
                    	            		lv_serviceProvisionPoints_12_0, 
                    	            		"org.eclipse.etrice.core.Room.SPP");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRoom.g:2953:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:2953:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    // InternalRoom.g:2954:1: (lv_interfacePorts_13_0= rulePort )
                    	    {
                    	    // InternalRoom.g:2954:1: (lv_interfacePorts_13_0= rulePort )
                    	    // InternalRoom.g:2955:3: lv_interfacePorts_13_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInterfacePortsPortParserRuleCall_7_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_63);
                    	    lv_interfacePorts_13_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"interfacePorts",
                    	            		lv_interfacePorts_13_0, 
                    	            		"org.eclipse.etrice.core.Room.Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,14,FOLLOW_64); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2975:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==56) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalRoom.g:2975:5: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,56,FOLLOW_4); 

                        	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                        
                    // InternalRoom.g:2979:1: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==33) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalRoom.g:2980:1: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // InternalRoom.g:2980:1: (lv_structureDocu_16_0= ruleDocumentation )
                            // InternalRoom.g:2981:3: lv_structureDocu_16_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStructureDocuDocumentationParserRuleCall_8_1_0()); 
                            	    
                            pushFollow(FOLLOW_5);
                            lv_structureDocu_16_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"structureDocu",
                                    		lv_structureDocu_16_0, 
                                    		"org.eclipse.etrice.core.common.Base.Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,13,FOLLOW_65); 

                        	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // InternalRoom.g:3001:1: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==29) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalRoom.g:3001:3: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,29,FOLLOW_5); 

                                	newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                                
                            // InternalRoom.g:3005:1: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // InternalRoom.g:3006:1: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3006:1: (lv_userCode1_19_0= ruleDetailCode )
                            // InternalRoom.g:3007:3: lv_userCode1_19_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_66);
                            lv_userCode1_19_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode1",
                                    		lv_userCode1_19_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:3023:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==30) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalRoom.g:3023:6: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,30,FOLLOW_5); 

                                	newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                                
                            // InternalRoom.g:3027:1: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // InternalRoom.g:3028:1: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3028:1: (lv_userCode2_21_0= ruleDetailCode )
                            // InternalRoom.g:3029:3: lv_userCode2_21_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_67);
                            lv_userCode2_21_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode2",
                                    		lv_userCode2_21_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:3045:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==31) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalRoom.g:3045:6: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,31,FOLLOW_5); 

                                	newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                                
                            // InternalRoom.g:3049:1: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // InternalRoom.g:3050:1: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3050:1: (lv_userCode3_23_0= ruleDetailCode )
                            // InternalRoom.g:3051:3: lv_userCode3_23_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_8_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_68);
                            lv_userCode3_23_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"userCode3",
                                    		lv_userCode3_23_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:3067:4: ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )*
                    loop75:
                    do {
                        int alt75=9;
                        switch ( input.LA(1) ) {
                        case 73:
                            {
                            alt75=1;
                            }
                            break;
                        case 69:
                            {
                            alt75=2;
                            }
                            break;
                        case 62:
                            {
                            alt75=3;
                            }
                            break;
                        case 32:
                            {
                            alt75=4;
                            }
                            break;
                        case 76:
                        case 110:
                        case 126:
                            {
                            alt75=5;
                            }
                            break;
                        case 60:
                            {
                            alt75=6;
                            }
                            break;
                        case 46:
                        case 58:
                            {
                            alt75=7;
                            }
                            break;
                        case 59:
                            {
                            alt75=8;
                            }
                            break;

                        }

                        switch (alt75) {
                    	case 1 :
                    	    // InternalRoom.g:3067:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    {
                    	    // InternalRoom.g:3067:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    // InternalRoom.g:3068:1: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // InternalRoom.g:3068:1: (lv_connections_24_0= ruleLayerConnection )
                    	    // InternalRoom.g:3069:3: lv_connections_24_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_8_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_connections_24_0=ruleLayerConnection();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_24_0, 
                    	            		"org.eclipse.etrice.core.Room.LayerConnection");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRoom.g:3086:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    {
                    	    // InternalRoom.g:3086:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    // InternalRoom.g:3087:1: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // InternalRoom.g:3087:1: (lv_bindings_25_0= ruleBinding )
                    	    // InternalRoom.g:3088:3: lv_bindings_25_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_8_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_bindings_25_0=ruleBinding();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"bindings",
                    	            		lv_bindings_25_0, 
                    	            		"org.eclipse.etrice.core.Room.Binding");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalRoom.g:3105:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    {
                    	    // InternalRoom.g:3105:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    // InternalRoom.g:3106:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // InternalRoom.g:3106:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // InternalRoom.g:3107:3: lv_serviceImplementations_26_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_8_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_serviceImplementations_26_0=ruleServiceImplementation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceImplementations",
                    	            		lv_serviceImplementations_26_0, 
                    	            		"org.eclipse.etrice.core.Room.ServiceImplementation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalRoom.g:3124:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    {
                    	    // InternalRoom.g:3124:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    // InternalRoom.g:3125:1: (lv_attributes_27_0= ruleAttribute )
                    	    {
                    	    // InternalRoom.g:3125:1: (lv_attributes_27_0= ruleAttribute )
                    	    // InternalRoom.g:3126:3: lv_attributes_27_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_8_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_attributes_27_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_27_0, 
                    	            		"org.eclipse.etrice.core.Room.Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // InternalRoom.g:3143:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    {
                    	    // InternalRoom.g:3143:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    // InternalRoom.g:3144:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    {
                    	    // InternalRoom.g:3144:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    // InternalRoom.g:3145:3: lv_actorRefs_28_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_8_6_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_actorRefs_28_0=ruleActorRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorRefs",
                    	            		lv_actorRefs_28_0, 
                    	            		"org.eclipse.etrice.core.Room.ActorRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // InternalRoom.g:3162:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    {
                    	    // InternalRoom.g:3162:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    // InternalRoom.g:3163:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    {
                    	    // InternalRoom.g:3163:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    // InternalRoom.g:3164:3: lv_serviceAccessPoints_29_0= ruleSAP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceAccessPointsSAPParserRuleCall_8_6_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_serviceAccessPoints_29_0=ruleSAP();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"serviceAccessPoints",
                    	            		lv_serviceAccessPoints_29_0, 
                    	            		"org.eclipse.etrice.core.Room.SAP");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // InternalRoom.g:3181:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3181:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    // InternalRoom.g:3182:1: (lv_internalPorts_30_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3182:1: (lv_internalPorts_30_0= rulePort )
                    	    // InternalRoom.g:3183:3: lv_internalPorts_30_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInternalPortsPortParserRuleCall_8_6_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_internalPorts_30_0=rulePort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"internalPorts",
                    	            		lv_internalPorts_30_0, 
                    	            		"org.eclipse.etrice.core.Room.Port");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 8 :
                    	    // InternalRoom.g:3200:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    {
                    	    // InternalRoom.g:3200:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    // InternalRoom.g:3201:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    {
                    	    // InternalRoom.g:3201:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    // InternalRoom.g:3202:3: lv_externalPorts_31_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExternalPortsExternalPortParserRuleCall_8_6_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_68);
                    	    lv_externalPorts_31_0=ruleExternalPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"externalPorts",
                    	            		lv_externalPorts_31_0, 
                    	            		"org.eclipse.etrice.core.Room.ExternalPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,14,FOLLOW_69); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7());
                        

                    }
                    break;

            }

            // InternalRoom.g:3222:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==57) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalRoom.g:3222:5: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}'
                    {
                    otherlv_33=(Token)match(input,57,FOLLOW_4); 

                        	newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                        
                    // InternalRoom.g:3226:1: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==33) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalRoom.g:3227:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3227:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // InternalRoom.g:3228:3: lv_behaviorDocu_34_0= ruleDocumentation
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorDocuDocumentationParserRuleCall_9_1_0()); 
                            	    
                            pushFollow(FOLLOW_5);
                            lv_behaviorDocu_34_0=ruleDocumentation();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"behaviorDocu",
                                    		lv_behaviorDocu_34_0, 
                                    		"org.eclipse.etrice.core.common.Base.Documentation");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_35=(Token)match(input,13,FOLLOW_70); 

                        	newLeafNode(otherlv_35, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2());
                        
                    // InternalRoom.g:3248:1: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==107) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalRoom.g:3249:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:3249:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // InternalRoom.g:3250:3: lv_behaviorAnnotations_36_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorAnnotationsAnnotationParserRuleCall_9_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_70);
                    	    lv_behaviorAnnotations_36_0=ruleAnnotation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"behaviorAnnotations",
                    	            		lv_behaviorAnnotations_36_0, 
                    	            		"org.eclipse.etrice.core.common.Base.Annotation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    // InternalRoom.g:3266:3: ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )*
                    loop79:
                    do {
                        int alt79=3;
                        int LA79_0 = input.LA(1);

                        if ( ((LA79_0>=35 && LA79_0<=36)) ) {
                            alt79=1;
                        }
                        else if ( ((LA79_0>=39 && LA79_0<=40)) ) {
                            alt79=2;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalRoom.g:3266:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    {
                    	    // InternalRoom.g:3266:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    // InternalRoom.g:3267:1: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // InternalRoom.g:3267:1: (lv_operations_37_0= ruleStandardOperation )
                    	    // InternalRoom.g:3268:3: lv_operations_37_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_9_4_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_71);
                    	    lv_operations_37_0=ruleStandardOperation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_37_0, 
                    	            		"org.eclipse.etrice.core.Room.StandardOperation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRoom.g:3285:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    {
                    	    // InternalRoom.g:3285:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    // InternalRoom.g:3286:1: (lv_structors_38_0= ruleClassStructor )
                    	    {
                    	    // InternalRoom.g:3286:1: (lv_structors_38_0= ruleClassStructor )
                    	    // InternalRoom.g:3287:3: lv_structors_38_0= ruleClassStructor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStructorsClassStructorParserRuleCall_9_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_71);
                    	    lv_structors_38_0=ruleClassStructor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"structors",
                    	            		lv_structors_38_0, 
                    	            		"org.eclipse.etrice.core.Room.ClassStructor");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    // InternalRoom.g:3303:4: ( (lv_stateMachine_39_0= ruleStateMachine ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==79) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalRoom.g:3304:1: (lv_stateMachine_39_0= ruleStateMachine )
                            {
                            // InternalRoom.g:3304:1: (lv_stateMachine_39_0= ruleStateMachine )
                            // InternalRoom.g:3305:3: lv_stateMachine_39_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_9_5_0()); 
                            	    
                            pushFollow(FOLLOW_53);
                            lv_stateMachine_39_0=ruleStateMachine();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getActorClassRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"stateMachine",
                                    		lv_stateMachine_39_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.StateMachine");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_40=(Token)match(input,14,FOLLOW_53); 

                        	newLeafNode(otherlv_40, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9_6());
                        

                    }
                    break;

            }

            otherlv_41=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_41, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleInterfaceItem"
    // InternalRoom.g:3337:1: entryRuleInterfaceItem returns [EObject current=null] : iv_ruleInterfaceItem= ruleInterfaceItem EOF ;
    public final EObject entryRuleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceItem = null;


        try {
            // InternalRoom.g:3338:2: (iv_ruleInterfaceItem= ruleInterfaceItem EOF )
            // InternalRoom.g:3339:2: iv_ruleInterfaceItem= ruleInterfaceItem EOF
            {
             newCompositeNode(grammarAccess.getInterfaceItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceItem=ruleInterfaceItem();

            state._fsp--;

             current =iv_ruleInterfaceItem; 
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
    // $ANTLR end "entryRuleInterfaceItem"


    // $ANTLR start "ruleInterfaceItem"
    // InternalRoom.g:3346:1: ruleInterfaceItem returns [EObject current=null] : (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) ;
    public final EObject ruleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_SAP_1 = null;

        EObject this_SPP_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3349:28: ( (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) )
            // InternalRoom.g:3350:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            {
            // InternalRoom.g:3350:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            int alt82=3;
            switch ( input.LA(1) ) {
            case 46:
            case 58:
                {
                alt82=1;
                }
                break;
            case 60:
                {
                alt82=2;
                }
                break;
            case 61:
                {
                alt82=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRoom.g:3351:5: this_Port_0= rulePort
                    {
                     
                            newCompositeNode(grammarAccess.getInterfaceItemAccess().getPortParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Port_0=rulePort();

                    state._fsp--;

                     
                            current = this_Port_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:3361:5: this_SAP_1= ruleSAP
                    {
                     
                            newCompositeNode(grammarAccess.getInterfaceItemAccess().getSAPParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SAP_1=ruleSAP();

                    state._fsp--;

                     
                            current = this_SAP_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:3371:5: this_SPP_2= ruleSPP
                    {
                     
                            newCompositeNode(grammarAccess.getInterfaceItemAccess().getSPPParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SPP_2=ruleSPP();

                    state._fsp--;

                     
                            current = this_SPP_2; 
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
    // $ANTLR end "ruleInterfaceItem"


    // $ANTLR start "entryRulePort"
    // InternalRoom.g:3387:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalRoom.g:3388:2: (iv_rulePort= rulePort EOF )
            // InternalRoom.g:3389:2: iv_rulePort= rulePort EOF
            {
             newCompositeNode(grammarAccess.getPortRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
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
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // InternalRoom.g:3396:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:3399:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3400:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3400:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:3400:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:3400:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==46) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalRoom.g:3401:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // InternalRoom.g:3401:1: (lv_conjugated_0_0= 'conjugated' )
                    // InternalRoom.g:3402:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,46,FOLLOW_72); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,58,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3419:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:3420:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:3420:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:3421:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPortAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:3437:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==33) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalRoom.g:3438:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:3438:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:3439:3: lv_multiplicity_3_0= ruleMULTIPLICITY
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getMultiplicityMULTIPLICITYParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_multiplicity_3_0=ruleMULTIPLICITY();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"org.eclipse.etrice.core.Room.MULTIPLICITY");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getPortAccess().getColonKeyword_4());
                
            // InternalRoom.g:3459:1: ( ( ruleFQN ) )
            // InternalRoom.g:3460:1: ( ruleFQN )
            {
            // InternalRoom.g:3460:1: ( ruleFQN )
            // InternalRoom.g:3461:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolGeneralProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_16);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3474:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==33) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRoom.g:3475:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3475:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:3476:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
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


            }


            }

             leaveRule(); 
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
    // InternalRoom.g:3500:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // InternalRoom.g:3501:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // InternalRoom.g:3502:2: iv_ruleExternalPort= ruleExternalPort EOF
            {
             newCompositeNode(grammarAccess.getExternalPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalPort=ruleExternalPort();

            state._fsp--;

             current =iv_ruleExternalPort; 
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
    // $ANTLR end "entryRuleExternalPort"


    // $ANTLR start "ruleExternalPort"
    // InternalRoom.g:3509:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3512:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3513:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3513:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3513:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_72); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,58,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3521:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3522:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3522:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3523:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalPortRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getExternalPortAccess().getInterfacePortPortCrossReference_2_0()); 
            	

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


    // $ANTLR start "entryRuleSAP"
    // InternalRoom.g:3542:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // InternalRoom.g:3543:2: (iv_ruleSAP= ruleSAP EOF )
            // InternalRoom.g:3544:2: iv_ruleSAP= ruleSAP EOF
            {
             newCompositeNode(grammarAccess.getSAPRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSAP=ruleSAP();

            state._fsp--;

             current =iv_ruleSAP; 
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
    // $ANTLR end "entryRuleSAP"


    // $ANTLR start "ruleSAP"
    // InternalRoom.g:3551:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3554:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:3555:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:3555:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:3555:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                
            // InternalRoom.g:3559:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3560:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3560:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3561:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSAPAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSAPAccess().getColonKeyword_2());
                
            // InternalRoom.g:3581:1: ( ( ruleFQN ) )
            // InternalRoom.g:3582:1: ( ruleFQN )
            {
            // InternalRoom.g:3582:1: ( ruleFQN )
            // InternalRoom.g:3583:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSAPAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleSAP"


    // $ANTLR start "entryRuleSPP"
    // InternalRoom.g:3604:1: entryRuleSPP returns [EObject current=null] : iv_ruleSPP= ruleSPP EOF ;
    public final EObject entryRuleSPP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPP = null;


        try {
            // InternalRoom.g:3605:2: (iv_ruleSPP= ruleSPP EOF )
            // InternalRoom.g:3606:2: iv_ruleSPP= ruleSPP EOF
            {
             newCompositeNode(grammarAccess.getSPPRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSPP=ruleSPP();

            state._fsp--;

             current =iv_ruleSPP; 
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
    // $ANTLR end "entryRuleSPP"


    // $ANTLR start "ruleSPP"
    // InternalRoom.g:3613:1: ruleSPP returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3616:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:3617:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:3617:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:3617:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPAccess().getSPPKeyword_0());
                
            // InternalRoom.g:3621:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3622:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3622:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3623:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSPPAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSPPAccess().getColonKeyword_2());
                
            // InternalRoom.g:3643:1: ( ( ruleFQN ) )
            // InternalRoom.g:3644:1: ( ruleFQN )
            {
            // InternalRoom.g:3644:1: ( ruleFQN )
            // InternalRoom.g:3645:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSPPAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleSPP"


    // $ANTLR start "entryRuleServiceImplementation"
    // InternalRoom.g:3666:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // InternalRoom.g:3667:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // InternalRoom.g:3668:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
            {
             newCompositeNode(grammarAccess.getServiceImplementationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceImplementation=ruleServiceImplementation();

            state._fsp--;

             current =iv_ruleServiceImplementation; 
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
    // $ANTLR end "entryRuleServiceImplementation"


    // $ANTLR start "ruleServiceImplementation"
    // InternalRoom.g:3675:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3678:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3679:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3679:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3679:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_73); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,23,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // InternalRoom.g:3687:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3688:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3688:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3689:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getServiceImplementationRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getServiceImplementationAccess().getSppSPPCrossReference_2_0()); 
            	

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
    // InternalRoom.g:3708:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // InternalRoom.g:3709:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // InternalRoom.g:3710:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
            {
             newCompositeNode(grammarAccess.getLogicalSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicalSystem=ruleLogicalSystem();

            state._fsp--;

             current =iv_ruleLogicalSystem; 
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
    // $ANTLR end "entryRuleLogicalSystem"


    // $ANTLR start "ruleLogicalSystem"
    // InternalRoom.g:3717:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleLogicalSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_connections_5_0 = null;

        EObject lv_bindings_6_0 = null;

        EObject lv_subSystems_7_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3720:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:3721:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:3721:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            // InternalRoom.g:3721:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // InternalRoom.g:3725:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3726:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3726:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3727:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:3743:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==33) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalRoom.g:3744:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3744:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3745:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_74); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:3765:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==107) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalRoom.g:3766:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3766:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3767:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_74);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
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
            	    break loop87;
                }
            } while (true);

            // InternalRoom.g:3783:3: ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )*
            loop88:
            do {
                int alt88=4;
                switch ( input.LA(1) ) {
                case 73:
                    {
                    alt88=1;
                    }
                    break;
                case 69:
                    {
                    alt88=2;
                    }
                    break;
                case 64:
                    {
                    alt88=3;
                    }
                    break;

                }

                switch (alt88) {
            	case 1 :
            	    // InternalRoom.g:3783:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:3783:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    // InternalRoom.g:3784:1: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:3784:1: (lv_connections_5_0= ruleLayerConnection )
            	    // InternalRoom.g:3785:3: lv_connections_5_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
            	    lv_connections_5_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_5_0, 
            	            		"org.eclipse.etrice.core.Room.LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoom.g:3802:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:3802:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    // InternalRoom.g:3803:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // InternalRoom.g:3803:1: (lv_bindings_6_0= ruleBinding )
            	    // InternalRoom.g:3804:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
            	    lv_bindings_6_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_6_0, 
            	            		"org.eclipse.etrice.core.Room.Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoom.g:3821:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    {
            	    // InternalRoom.g:3821:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    // InternalRoom.g:3822:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    {
            	    // InternalRoom.g:3822:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    // InternalRoom.g:3823:3: lv_subSystems_7_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
            	    lv_subSystems_7_0=ruleSubSystemRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLogicalSystemRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subSystems",
            	            		lv_subSystems_7_0, 
            	            		"org.eclipse.etrice.core.Room.SubSystemRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getLogicalSystemAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // InternalRoom.g:3853:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // InternalRoom.g:3854:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // InternalRoom.g:3855:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
            {
             newCompositeNode(grammarAccess.getSubSystemRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubSystemRef=ruleSubSystemRef();

            state._fsp--;

             current =iv_ruleSubSystemRef; 
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
    // $ANTLR end "entryRuleSubSystemRef"


    // $ANTLR start "ruleSubSystemRef"
    // InternalRoom.g:3862:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3865:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3866:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3866:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3866:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,64,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // InternalRoom.g:3870:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3871:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3871:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3872:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemRefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemRefAccess().getColonKeyword_2());
                
            // InternalRoom.g:3892:1: ( ( ruleFQN ) )
            // InternalRoom.g:3893:1: ( ruleFQN )
            {
            // InternalRoom.g:3893:1: ( ruleFQN )
            // InternalRoom.g:3894:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_16);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3907:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==33) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalRoom.g:3908:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3908:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3909:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemRefRule());
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
    // $ANTLR end "ruleSubSystemRef"


    // $ANTLR start "entryRuleSubSystemClass"
    // InternalRoom.g:3933:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // InternalRoom.g:3934:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // InternalRoom.g:3935:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
            {
             newCompositeNode(grammarAccess.getSubSystemClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubSystemClass=ruleSubSystemClass();

            state._fsp--;

             current =iv_ruleSubSystemClass; 
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
    // $ANTLR end "entryRuleSubSystemClass"


    // $ANTLR start "ruleSubSystemClass"
    // InternalRoom.g:3942:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) ;
    public final EObject ruleSubSystemClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_18=null;
        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_userCode1_6_0 = null;

        EObject lv_userCode2_8_0 = null;

        EObject lv_userCode3_10_0 = null;

        EObject lv_actorInstanceMappings_11_0 = null;

        EObject lv_threads_12_0 = null;

        EObject lv_connections_13_0 = null;

        EObject lv_bindings_14_0 = null;

        EObject lv_actorRefs_15_0 = null;

        EObject lv_serviceProvisionPoints_16_0 = null;

        EObject lv_relayPorts_17_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3945:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) )
            // InternalRoom.g:3946:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            {
            // InternalRoom.g:3946:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            // InternalRoom.g:3946:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // InternalRoom.g:3950:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3951:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3951:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3952:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSubSystemClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:3968:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==33) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRoom.g:3969:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3969:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3970:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_76); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:3990:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==107) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalRoom.g:3991:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3991:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3992:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_76);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
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
            	    break loop91;
                }
            } while (true);

            // InternalRoom.g:4008:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==29) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalRoom.g:4008:5: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,29,FOLLOW_5); 

                        	newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                        
                    // InternalRoom.g:4012:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // InternalRoom.g:4013:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4013:1: (lv_userCode1_6_0= ruleDetailCode )
                    // InternalRoom.g:4014:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_77);
                    lv_userCode1_6_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode1",
                            		lv_userCode1_6_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:4030:4: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==30) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRoom.g:4030:6: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_5); 

                        	newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                        
                    // InternalRoom.g:4034:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // InternalRoom.g:4035:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4035:1: (lv_userCode2_8_0= ruleDetailCode )
                    // InternalRoom.g:4036:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_78);
                    lv_userCode2_8_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode2",
                            		lv_userCode2_8_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:4052:4: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==31) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalRoom.g:4052:6: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,31,FOLLOW_5); 

                        	newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                        
                    // InternalRoom.g:4056:1: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // InternalRoom.g:4057:1: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4057:1: (lv_userCode3_10_0= ruleDetailCode )
                    // InternalRoom.g:4058:3: lv_userCode3_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_79);
                    lv_userCode3_10_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
                    	        }
                           		set(
                           			current, 
                           			"userCode3",
                            		lv_userCode3_10_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:4074:4: ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )*
            loop95:
            do {
                int alt95=8;
                switch ( input.LA(1) ) {
                case 67:
                    {
                    alt95=1;
                    }
                    break;
                case 66:
                    {
                    alt95=2;
                    }
                    break;
                case 73:
                    {
                    alt95=3;
                    }
                    break;
                case 69:
                    {
                    alt95=4;
                    }
                    break;
                case 76:
                case 110:
                case 126:
                    {
                    alt95=5;
                    }
                    break;
                case 61:
                    {
                    alt95=6;
                    }
                    break;
                case 46:
                case 58:
                    {
                    alt95=7;
                    }
                    break;

                }

                switch (alt95) {
            	case 1 :
            	    // InternalRoom.g:4074:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    {
            	    // InternalRoom.g:4074:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    // InternalRoom.g:4075:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    {
            	    // InternalRoom.g:4075:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    // InternalRoom.g:4076:3: lv_actorInstanceMappings_11_0= ruleActorInstanceMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_actorInstanceMappings_11_0=ruleActorInstanceMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorInstanceMappings",
            	            		lv_actorInstanceMappings_11_0, 
            	            		"org.eclipse.etrice.core.Room.ActorInstanceMapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoom.g:4093:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    {
            	    // InternalRoom.g:4093:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    // InternalRoom.g:4094:1: (lv_threads_12_0= ruleLogicalThread )
            	    {
            	    // InternalRoom.g:4094:1: (lv_threads_12_0= ruleLogicalThread )
            	    // InternalRoom.g:4095:3: lv_threads_12_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_threads_12_0=ruleLogicalThread();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"threads",
            	            		lv_threads_12_0, 
            	            		"org.eclipse.etrice.core.Room.LogicalThread");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoom.g:4112:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:4112:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    // InternalRoom.g:4113:1: (lv_connections_13_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:4113:1: (lv_connections_13_0= ruleLayerConnection )
            	    // InternalRoom.g:4114:3: lv_connections_13_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_connections_13_0=ruleLayerConnection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connections",
            	            		lv_connections_13_0, 
            	            		"org.eclipse.etrice.core.Room.LayerConnection");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRoom.g:4131:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:4131:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    // InternalRoom.g:4132:1: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // InternalRoom.g:4132:1: (lv_bindings_14_0= ruleBinding )
            	    // InternalRoom.g:4133:3: lv_bindings_14_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_8_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_bindings_14_0=ruleBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_14_0, 
            	            		"org.eclipse.etrice.core.Room.Binding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRoom.g:4150:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    {
            	    // InternalRoom.g:4150:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    // InternalRoom.g:4151:1: (lv_actorRefs_15_0= ruleActorRef )
            	    {
            	    // InternalRoom.g:4151:1: (lv_actorRefs_15_0= ruleActorRef )
            	    // InternalRoom.g:4152:3: lv_actorRefs_15_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_8_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_actorRefs_15_0=ruleActorRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actorRefs",
            	            		lv_actorRefs_15_0, 
            	            		"org.eclipse.etrice.core.Room.ActorRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRoom.g:4169:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    {
            	    // InternalRoom.g:4169:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    // InternalRoom.g:4170:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    {
            	    // InternalRoom.g:4170:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    // InternalRoom.g:4171:3: lv_serviceProvisionPoints_16_0= ruleSPP
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getServiceProvisionPointsSPPParserRuleCall_8_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_serviceProvisionPoints_16_0=ruleSPP();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"serviceProvisionPoints",
            	            		lv_serviceProvisionPoints_16_0, 
            	            		"org.eclipse.etrice.core.Room.SPP");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRoom.g:4188:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    {
            	    // InternalRoom.g:4188:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    // InternalRoom.g:4189:1: (lv_relayPorts_17_0= rulePort )
            	    {
            	    // InternalRoom.g:4189:1: (lv_relayPorts_17_0= rulePort )
            	    // InternalRoom.g:4190:3: lv_relayPorts_17_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_8_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
            	    lv_relayPorts_17_0=rulePort();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubSystemClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relayPorts",
            	            		lv_relayPorts_17_0, 
            	            		"org.eclipse.etrice.core.Room.Port");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            otherlv_18=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_18, grammarAccess.getSubSystemClassAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
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
    // InternalRoom.g:4218:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // InternalRoom.g:4219:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // InternalRoom.g:4220:2: iv_ruleLogicalThread= ruleLogicalThread EOF
            {
             newCompositeNode(grammarAccess.getLogicalThreadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicalThread=ruleLogicalThread();

            state._fsp--;

             current =iv_ruleLogicalThread; 
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
    // $ANTLR end "entryRuleLogicalThread"


    // $ANTLR start "ruleLogicalThread"
    // InternalRoom.g:4227:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4230:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:4231:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:4231:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:4231:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // InternalRoom.g:4235:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4236:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4236:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4237:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLogicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLogicalThreadRule());
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
    // $ANTLR end "ruleLogicalThread"


    // $ANTLR start "entryRuleActorInstanceMapping"
    // InternalRoom.g:4261:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // InternalRoom.g:4262:2: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // InternalRoom.g:4263:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
            {
             newCompositeNode(grammarAccess.getActorInstanceMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorInstanceMapping=ruleActorInstanceMapping();

            state._fsp--;

             current =iv_ruleActorInstanceMapping; 
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
    // $ANTLR end "entryRuleActorInstanceMapping"


    // $ANTLR start "ruleActorInstanceMapping"
    // InternalRoom.g:4270:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_path_1_0 = null;

        EObject lv_actorInstanceMappings_5_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4273:28: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // InternalRoom.g:4274:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // InternalRoom.g:4274:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // InternalRoom.g:4274:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
                
            // InternalRoom.g:4278:1: ( (lv_path_1_0= ruleRefPath ) )
            // InternalRoom.g:4279:1: (lv_path_1_0= ruleRefPath )
            {
            // InternalRoom.g:4279:1: (lv_path_1_0= ruleRefPath )
            // InternalRoom.g:4280:3: lv_path_1_0= ruleRefPath
            {
             
            	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_11);
            lv_path_1_0=ruleRefPath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActorInstanceMappingRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_1_0, 
                    		"org.eclipse.etrice.core.Room.RefPath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalRoom.g:4300:1: ( (otherlv_3= RULE_ID ) )
            // InternalRoom.g:4301:1: (otherlv_3= RULE_ID )
            {
            // InternalRoom.g:4301:1: (otherlv_3= RULE_ID )
            // InternalRoom.g:4302:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_80); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadLogicalThreadCrossReference_3_0()); 
            	

            }


            }

            // InternalRoom.g:4313:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==13) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalRoom.g:4313:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_81); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalRoom.g:4317:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==67) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalRoom.g:4318:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // InternalRoom.g:4318:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // InternalRoom.g:4319:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
                    	    lv_actorInstanceMappings_5_0=ruleActorInstanceMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getActorInstanceMappingRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actorInstanceMappings",
                    	            		lv_actorInstanceMappings_5_0, 
                    	            		"org.eclipse.etrice.core.Room.ActorInstanceMapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorInstanceMappingAccess().getRightCurlyBracketKeyword_4_2());
                        

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
    // $ANTLR end "ruleActorInstanceMapping"


    // $ANTLR start "entryRuleRefPath"
    // InternalRoom.g:4347:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalRoom.g:4348:2: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalRoom.g:4349:2: iv_ruleRefPath= ruleRefPath EOF
            {
             newCompositeNode(grammarAccess.getRefPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefPath=ruleRefPath();

            state._fsp--;

             current =iv_ruleRefPath; 
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
    // $ANTLR end "entryRuleRefPath"


    // $ANTLR start "ruleRefPath"
    // InternalRoom.g:4356:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4359:28: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalRoom.g:4360:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalRoom.g:4360:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalRoom.g:4360:2: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalRoom.g:4360:2: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalRoom.g:4361:1: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalRoom.g:4361:1: (lv_refs_0_0= ruleRefSegment )
            // InternalRoom.g:4362:3: lv_refs_0_0= ruleRefSegment
            {
             
            	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_82);
            lv_refs_0_0=ruleRefSegment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefPathRule());
            	        }
                   		add(
                   			current, 
                   			"refs",
                    		lv_refs_0_0, 
                    		"org.eclipse.etrice.core.Room.RefSegment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:4378:2: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==68) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalRoom.g:4378:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,68,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // InternalRoom.g:4382:1: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalRoom.g:4383:1: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalRoom.g:4383:1: (lv_refs_2_0= ruleRefSegment )
            	    // InternalRoom.g:4384:3: lv_refs_2_0= ruleRefSegment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_82);
            	    lv_refs_2_0=ruleRefSegment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRefPathRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"refs",
            	            		lv_refs_2_0, 
            	            		"org.eclipse.etrice.core.Room.RefSegment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleRefPath"


    // $ANTLR start "entryRuleRefSegment"
    // InternalRoom.g:4408:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalRoom.g:4409:2: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalRoom.g:4410:2: iv_ruleRefSegment= ruleRefSegment EOF
            {
             newCompositeNode(grammarAccess.getRefSegmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefSegment=ruleRefSegment();

            state._fsp--;

             current =iv_ruleRefSegment; 
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
    // $ANTLR end "entryRuleRefSegment"


    // $ANTLR start "ruleRefSegment"
    // InternalRoom.g:4417:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4420:28: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalRoom.g:4421:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalRoom.g:4421:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalRoom.g:4421:2: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalRoom.g:4421:2: ( (lv_ref_0_0= RULE_ID ) )
            // InternalRoom.g:4422:1: (lv_ref_0_0= RULE_ID )
            {
            // InternalRoom.g:4422:1: (lv_ref_0_0= RULE_ID )
            // InternalRoom.g:4423:3: lv_ref_0_0= RULE_ID
            {
            lv_ref_0_0=(Token)match(input,RULE_ID,FOLLOW_83); 

            			newLeafNode(lv_ref_0_0, grammarAccess.getRefSegmentAccess().getRefIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSegmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ref",
                    		lv_ref_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:4439:2: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==15) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalRoom.g:4439:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_31); 

                        	newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                        
                    // InternalRoom.g:4443:1: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalRoom.g:4444:1: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalRoom.g:4444:1: (lv_idx_2_0= RULE_INT )
                    // InternalRoom.g:4445:3: lv_idx_2_0= RULE_INT
                    {
                    lv_idx_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			newLeafNode(lv_idx_2_0, grammarAccess.getRefSegmentAccess().getIdxINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRefSegmentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"idx",
                            		lv_idx_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

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
    // $ANTLR end "ruleRefSegment"


    // $ANTLR start "entryRuleBinding"
    // InternalRoom.g:4469:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalRoom.g:4470:2: (iv_ruleBinding= ruleBinding EOF )
            // InternalRoom.g:4471:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
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
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalRoom.g:4478:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4481:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // InternalRoom.g:4482:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // InternalRoom.g:4482:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // InternalRoom.g:4482:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // InternalRoom.g:4486:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4487:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4487:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // InternalRoom.g:4488:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_84);
            lv_endpoint1_1_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint1",
                    		lv_endpoint1_1_0, 
                    		"org.eclipse.etrice.core.Room.BindingEndPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // InternalRoom.g:4508:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4509:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4509:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // InternalRoom.g:4510:3: lv_endpoint2_3_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint2BindingEndPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_endpoint2_3_0=ruleBindingEndPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBindingRule());
            	        }
                   		set(
                   			current, 
                   			"endpoint2",
                    		lv_endpoint2_3_0, 
                    		"org.eclipse.etrice.core.Room.BindingEndPoint");
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
    // InternalRoom.g:4534:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // InternalRoom.g:4535:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // InternalRoom.g:4536:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
            {
             newCompositeNode(grammarAccess.getBindingEndPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBindingEndPoint=ruleBindingEndPoint();

            state._fsp--;

             current =iv_ruleBindingEndPoint; 
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
    // $ANTLR end "entryRuleBindingEndPoint"


    // $ANTLR start "ruleBindingEndPoint"
    // InternalRoom.g:4543:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4546:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalRoom.g:4547:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalRoom.g:4547:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalRoom.g:4547:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalRoom.g:4547:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_ID) ) {
                int LA100_1 = input.LA(2);

                if ( (LA100_1==71) ) {
                    alt100=1;
                }
            }
            switch (alt100) {
                case 1 :
                    // InternalRoom.g:4547:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalRoom.g:4547:3: ( (otherlv_0= RULE_ID ) )
                    // InternalRoom.g:4548:1: (otherlv_0= RULE_ID )
                    {
                    // InternalRoom.g:4548:1: (otherlv_0= RULE_ID )
                    // InternalRoom.g:4549:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_85); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,71,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:4564:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4565:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4565:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4566:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_86); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // InternalRoom.g:4577:2: (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==72) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalRoom.g:4577:4: otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,72,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getBindingEndPointAccess().getSubKeyword_2_0());
                        
                    // InternalRoom.g:4581:1: ( (otherlv_4= RULE_ID ) )
                    // InternalRoom.g:4582:1: (otherlv_4= RULE_ID )
                    {
                    // InternalRoom.g:4582:1: (otherlv_4= RULE_ID )
                    // InternalRoom.g:4583:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalRoom.g:4602:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // InternalRoom.g:4603:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // InternalRoom.g:4604:2: iv_ruleLayerConnection= ruleLayerConnection EOF
            {
             newCompositeNode(grammarAccess.getLayerConnectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayerConnection=ruleLayerConnection();

            state._fsp--;

             current =iv_ruleLayerConnection; 
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
    // $ANTLR end "entryRuleLayerConnection"


    // $ANTLR start "ruleLayerConnection"
    // InternalRoom.g:4611:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4614:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // InternalRoom.g:4615:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // InternalRoom.g:4615:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // InternalRoom.g:4615:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_87); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // InternalRoom.g:4619:1: ( (lv_from_1_0= ruleSAPoint ) )
            // InternalRoom.g:4620:1: (lv_from_1_0= ruleSAPoint )
            {
            // InternalRoom.g:4620:1: (lv_from_1_0= ruleSAPoint )
            // InternalRoom.g:4621:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_88);
            lv_from_1_0=ruleSAPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"from",
                    		lv_from_1_0, 
                    		"org.eclipse.etrice.core.Room.SAPoint");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,74,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // InternalRoom.g:4641:1: ( (lv_to_3_0= ruleSPPoint ) )
            // InternalRoom.g:4642:1: (lv_to_3_0= ruleSPPoint )
            {
            // InternalRoom.g:4642:1: (lv_to_3_0= ruleSPPoint )
            // InternalRoom.g:4643:3: lv_to_3_0= ruleSPPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getToSPPointParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_to_3_0=ruleSPPoint();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerConnectionRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_3_0, 
                    		"org.eclipse.etrice.core.Room.SPPoint");
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
    // InternalRoom.g:4667:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // InternalRoom.g:4668:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // InternalRoom.g:4669:2: iv_ruleSAPoint= ruleSAPoint EOF
            {
             newCompositeNode(grammarAccess.getSAPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSAPoint=ruleSAPoint();

            state._fsp--;

             current =iv_ruleSAPoint; 
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
    // $ANTLR end "entryRuleSAPoint"


    // $ANTLR start "ruleSAPoint"
    // InternalRoom.g:4676:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4679:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // InternalRoom.g:4680:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // InternalRoom.g:4680:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==16) ) {
                alt102=1;
            }
            else if ( (LA102_0==75) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalRoom.g:4681:5: this_RefSAPoint_0= ruleRefSAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRefSAPointParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RefSAPoint_0=ruleRefSAPoint();

                    state._fsp--;

                     
                            current = this_RefSAPoint_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:4691:5: this_RelaySAPoint_1= ruleRelaySAPoint
                    {
                     
                            newCompositeNode(grammarAccess.getSAPointAccess().getRelaySAPointParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalRoom.g:4707:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // InternalRoom.g:4708:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // InternalRoom.g:4709:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
            {
             newCompositeNode(grammarAccess.getRefSAPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefSAPoint=ruleRefSAPoint();

            state._fsp--;

             current =iv_ruleRefSAPoint; 
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
    // $ANTLR end "entryRuleRefSAPoint"


    // $ANTLR start "ruleRefSAPoint"
    // InternalRoom.g:4716:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4719:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4720:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4720:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4720:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // InternalRoom.g:4724:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4725:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4725:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4726:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefSAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalRoom.g:4745:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // InternalRoom.g:4746:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // InternalRoom.g:4747:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
            {
             newCompositeNode(grammarAccess.getRelaySAPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelaySAPoint=ruleRelaySAPoint();

            state._fsp--;

             current =iv_ruleRelaySAPoint; 
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
    // $ANTLR end "entryRuleRelaySAPoint"


    // $ANTLR start "ruleRelaySAPoint"
    // InternalRoom.g:4754:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4757:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4758:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4758:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4758:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // InternalRoom.g:4762:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4763:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4763:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4764:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRelaySAPointRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_1, grammarAccess.getRelaySAPointAccess().getRelaySPPCrossReference_1_0()); 
            	

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
    // InternalRoom.g:4783:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // InternalRoom.g:4784:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // InternalRoom.g:4785:2: iv_ruleSPPoint= ruleSPPoint EOF
            {
             newCompositeNode(grammarAccess.getSPPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSPPoint=ruleSPPoint();

            state._fsp--;

             current =iv_ruleSPPoint; 
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
    // $ANTLR end "entryRuleSPPoint"


    // $ANTLR start "ruleSPPoint"
    // InternalRoom.g:4792:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4795:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4796:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4796:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4796:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4796:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:4797:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:4797:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:4798:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_85); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,71,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // InternalRoom.g:4813:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4814:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4814:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4815:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getSPPointAccess().getServiceSPPCrossReference_2_0()); 
            	

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
    // InternalRoom.g:4834:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // InternalRoom.g:4835:2: (iv_ruleActorRef= ruleActorRef EOF )
            // InternalRoom.g:4836:2: iv_ruleActorRef= ruleActorRef EOF
            {
             newCompositeNode(grammarAccess.getActorRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorRef=ruleActorRef();

            state._fsp--;

             current =iv_ruleActorRef; 
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
    // $ANTLR end "entryRuleActorRef"


    // $ANTLR start "ruleActorRef"
    // InternalRoom.g:4843:1: ruleActorRef returns [EObject current=null] : ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
    public final EObject ruleActorRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Enumerator lv_refType_0_0 = null;

        AntlrDatatypeRuleToken lv_multiplicity_3_0 = null;

        EObject lv_docu_6_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4846:28: ( ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4847:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4847:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:4847:2: ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:4847:2: ( (lv_refType_0_0= ruleReferenceType ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==110||LA103_0==126) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalRoom.g:4848:1: (lv_refType_0_0= ruleReferenceType )
                    {
                    // InternalRoom.g:4848:1: (lv_refType_0_0= ruleReferenceType )
                    // InternalRoom.g:4849:3: lv_refType_0_0= ruleReferenceType
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getRefTypeReferenceTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_89);
                    lv_refType_0_0=ruleReferenceType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
                    	        }
                           		set(
                           			current, 
                           			"refType",
                            		lv_refType_0_0, 
                            		"org.eclipse.etrice.core.Room.ReferenceType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,76,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getActorRefAccess().getActorRefKeyword_1());
                
            // InternalRoom.g:4869:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:4870:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:4870:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:4871:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			newLeafNode(lv_name_2_0, grammarAccess.getActorRefAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:4887:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==33) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalRoom.g:4888:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:4888:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:4889:3: lv_multiplicity_3_0= ruleMULTIPLICITY
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getMultiplicityMULTIPLICITYParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_multiplicity_3_0=ruleMULTIPLICITY();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_3_0, 
                            		"org.eclipse.etrice.core.Room.MULTIPLICITY");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getActorRefAccess().getColonKeyword_4());
                
            // InternalRoom.g:4909:1: ( ( ruleFQN ) )
            // InternalRoom.g:4910:1: ( ruleFQN )
            {
            // InternalRoom.g:4910:1: ( ruleFQN )
            // InternalRoom.g:4911:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_16);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:4924:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==33) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalRoom.g:4925:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4925:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:4926:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_6_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getActorRefRule());
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


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleMULTIPLICITY"
    // InternalRoom.g:4952:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // InternalRoom.g:4953:2: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // InternalRoom.g:4954:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
            {
             newCompositeNode(grammarAccess.getMULTIPLICITYRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMULTIPLICITY=ruleMULTIPLICITY();

            state._fsp--;

             current =iv_ruleMULTIPLICITY.getText(); 
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
    // $ANTLR end "entryRuleMULTIPLICITY"


    // $ANTLR start "ruleMULTIPLICITY"
    // InternalRoom.g:4961:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4964:28: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // InternalRoom.g:4965:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // InternalRoom.g:4965:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // InternalRoom.g:4966:2: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,33,FOLLOW_90); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0()); 
                
            // InternalRoom.g:4971:1: (kw= '*' | this_INT_2= RULE_INT )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==77) ) {
                alt106=1;
            }
            else if ( (LA106_0==RULE_INT) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalRoom.g:4972:2: kw= '*'
                    {
                    kw=(Token)match(input,77,FOLLOW_32); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:4978:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_32); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getMULTIPLICITYAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,34,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAnnotationTargetType"
    // InternalRoom.g:4999:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalRoom.g:5000:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalRoom.g:5001:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalRoom.g:5008:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5011:28: ( (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' ) )
            // InternalRoom.g:5012:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' )
            {
            // InternalRoom.g:5012:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' )
            int alt107=7;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt107=1;
                }
                break;
            case 54:
                {
                alt107=2;
                }
                break;
            case 78:
                {
                alt107=3;
                }
                break;
            case 41:
                {
                alt107=4;
                }
                break;
            case 47:
                {
                alt107=5;
                }
                break;
            case 65:
                {
                alt107=6;
                }
                break;
            case 63:
                {
                alt107=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalRoom.g:5013:2: kw= 'DataClass'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getDataClassKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5020:2: kw= 'ActorClass'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorClassKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:5027:2: kw= 'ActorBehavior'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorBehaviorKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalRoom.g:5034:2: kw= 'ProtocolClass'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getProtocolClassKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalRoom.g:5041:2: kw= 'CompoundProtocolClass'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getCompoundProtocolClassKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalRoom.g:5048:2: kw= 'SubSystemClass'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getSubSystemClassKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalRoom.g:5055:2: kw= 'LogicalSystem'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getLogicalSystemKeyword_6()); 
                        

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
    // $ANTLR end "ruleAnnotationTargetType"


    // $ANTLR start "entryRuleStateGraphNode"
    // InternalRoom.g:5070:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalRoom.g:5071:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalRoom.g:5072:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
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
    // InternalRoom.g:5079:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5082:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalRoom.g:5083:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalRoom.g:5083:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt108=3;
            switch ( input.LA(1) ) {
            case 80:
            case 85:
                {
                alt108=1;
                }
                break;
            case 90:
                {
                alt108=2;
                }
                break;
            case 86:
            case 87:
            case 88:
            case 89:
                {
                alt108=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalRoom.g:5084:5: this_State_0= ruleState
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
                    // InternalRoom.g:5094:5: this_ChoicePoint_1= ruleChoicePoint
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
                    // InternalRoom.g:5104:5: this_TrPoint_2= ruleTrPoint
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
    // InternalRoom.g:5122:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalRoom.g:5123:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalRoom.g:5124:2: iv_ruleStateGraph= ruleStateGraph EOF
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
    // InternalRoom.g:5131:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:5134:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:5135:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:5135:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalRoom.g:5135:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:5135:2: ()
            // InternalRoom.g:5136:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_91); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:5145:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop109:
            do {
                int alt109=6;
                switch ( input.LA(1) ) {
                case 80:
                case 85:
                    {
                    alt109=1;
                    }
                    break;
                case 86:
                case 87:
                case 88:
                case 89:
                    {
                    alt109=2;
                    }
                    break;
                case 90:
                    {
                    alt109=3;
                    }
                    break;
                case 91:
                    {
                    alt109=4;
                    }
                    break;
                case 98:
                    {
                    alt109=5;
                    }
                    break;

                }

                switch (alt109) {
            	case 1 :
            	    // InternalRoom.g:5145:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5145:2: ( (lv_states_2_0= ruleState ) )
            	    // InternalRoom.g:5146:1: (lv_states_2_0= ruleState )
            	    {
            	    // InternalRoom.g:5146:1: (lv_states_2_0= ruleState )
            	    // InternalRoom.g:5147:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5164:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5164:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalRoom.g:5165:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5165:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalRoom.g:5166:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5183:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5183:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5184:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5184:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalRoom.g:5185:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5202:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5202:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalRoom.g:5203:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5203:1: (lv_transitions_5_0= ruleTransition )
            	    // InternalRoom.g:5204:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5221:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5221:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5222:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5222:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalRoom.g:5223:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    break loop109;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:5251:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRoom.g:5252:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRoom.g:5253:2: iv_ruleStateMachine= ruleStateMachine EOF
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
    // InternalRoom.g:5260:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:5263:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:5264:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:5264:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalRoom.g:5264:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalRoom.g:5264:2: ()
            // InternalRoom.g:5265:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,79,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_91); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:5278:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop110:
            do {
                int alt110=6;
                switch ( input.LA(1) ) {
                case 80:
                case 85:
                    {
                    alt110=1;
                    }
                    break;
                case 86:
                case 87:
                case 88:
                case 89:
                    {
                    alt110=2;
                    }
                    break;
                case 90:
                    {
                    alt110=3;
                    }
                    break;
                case 91:
                    {
                    alt110=4;
                    }
                    break;
                case 98:
                    {
                    alt110=5;
                    }
                    break;

                }

                switch (alt110) {
            	case 1 :
            	    // InternalRoom.g:5278:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5278:2: ( (lv_states_3_0= ruleState ) )
            	    // InternalRoom.g:5279:1: (lv_states_3_0= ruleState )
            	    {
            	    // InternalRoom.g:5279:1: (lv_states_3_0= ruleState )
            	    // InternalRoom.g:5280:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5297:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5297:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalRoom.g:5298:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5298:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalRoom.g:5299:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5316:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5316:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5317:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5317:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalRoom.g:5318:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5335:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5335:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalRoom.g:5336:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5336:1: (lv_transitions_6_0= ruleTransition )
            	    // InternalRoom.g:5337:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    // InternalRoom.g:5354:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5354:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5355:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5355:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalRoom.g:5356:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    break loop110;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:5384:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRoom.g:5385:2: (iv_ruleState= ruleState EOF )
            // InternalRoom.g:5386:2: iv_ruleState= ruleState EOF
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
    // InternalRoom.g:5393:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5396:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalRoom.g:5397:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalRoom.g:5397:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==80) ) {
                alt111=1;
            }
            else if ( (LA111_0==85) ) {
                alt111=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalRoom.g:5398:5: this_SimpleState_0= ruleSimpleState
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
                    // InternalRoom.g:5408:5: this_RefinedState_1= ruleRefinedState
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
    // InternalRoom.g:5424:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalRoom.g:5425:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalRoom.g:5426:2: iv_ruleSimpleState= ruleSimpleState EOF
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
    // InternalRoom.g:5433:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) ;
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
            // InternalRoom.g:5436:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) )
            // InternalRoom.g:5437:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // InternalRoom.g:5437:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            // InternalRoom.g:5437:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,80,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // InternalRoom.g:5441:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5442:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5442:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5443:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_92); 

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

            // InternalRoom.g:5459:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==33) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalRoom.g:5460:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5460:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5461:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_80);
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

            // InternalRoom.g:5477:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==13) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalRoom.g:5477:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_93); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalRoom.g:5481:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==81) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalRoom.g:5481:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,81,FOLLOW_5); 

                                	newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_1_0());
                                
                            // InternalRoom.g:5485:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // InternalRoom.g:5486:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5486:1: (lv_entryCode_5_0= ruleDetailCode )
                            // InternalRoom.g:5487:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_94);
                            lv_entryCode_5_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"entryCode",
                                    		lv_entryCode_5_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:5503:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==82) ) {
                        alt114=1;
                    }
                    switch (alt114) {
                        case 1 :
                            // InternalRoom.g:5503:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,82,FOLLOW_5); 

                                	newLeafNode(otherlv_6, grammarAccess.getSimpleStateAccess().getExitKeyword_3_2_0());
                                
                            // InternalRoom.g:5507:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // InternalRoom.g:5508:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5508:1: (lv_exitCode_7_0= ruleDetailCode )
                            // InternalRoom.g:5509:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_95);
                            lv_exitCode_7_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"exitCode",
                                    		lv_exitCode_7_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:5525:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==83) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalRoom.g:5525:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,83,FOLLOW_5); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDoKeyword_3_3_0());
                                
                            // InternalRoom.g:5529:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // InternalRoom.g:5530:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5530:1: (lv_doCode_9_0= ruleDetailCode )
                            // InternalRoom.g:5531:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_96);
                            lv_doCode_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"doCode",
                                    		lv_doCode_9_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalRoom.g:5547:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==84) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalRoom.g:5547:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,84,FOLLOW_5); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // InternalRoom.g:5551:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                            // InternalRoom.g:5552:1: (lv_subgraph_11_0= ruleStateGraph )
                            {
                            // InternalRoom.g:5552:1: (lv_subgraph_11_0= ruleStateGraph )
                            // InternalRoom.g:5553:3: lv_subgraph_11_0= ruleStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_53);
                            lv_subgraph_11_0=ruleStateGraph();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"subgraph",
                                    		lv_subgraph_11_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.StateGraph");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:5581:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalRoom.g:5582:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalRoom.g:5583:2: iv_ruleRefinedState= ruleRefinedState EOF
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
    // InternalRoom.g:5590:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:5593:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:5594:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:5594:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // InternalRoom.g:5594:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // InternalRoom.g:5598:1: ( ( ruleFQN ) )
            // InternalRoom.g:5599:1: ( ruleFQN )
            {
            // InternalRoom.g:5599:1: ( ruleFQN )
            // InternalRoom.g:5600:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedStateRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedStateAccess().getTargetStateCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:5613:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==33) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalRoom.g:5614:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5614:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5615:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

            otherlv_3=(Token)match(input,13,FOLLOW_93); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:5635:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==81) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalRoom.g:5635:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,81,FOLLOW_5); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // InternalRoom.g:5639:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // InternalRoom.g:5640:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5640:1: (lv_entryCode_5_0= ruleDetailCode )
                    // InternalRoom.g:5641:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_94);
                    lv_entryCode_5_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"entryCode",
                            		lv_entryCode_5_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:5657:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==82) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalRoom.g:5657:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,82,FOLLOW_5); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // InternalRoom.g:5661:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // InternalRoom.g:5662:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5662:1: (lv_exitCode_7_0= ruleDetailCode )
                    // InternalRoom.g:5663:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_95);
                    lv_exitCode_7_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"exitCode",
                            		lv_exitCode_7_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:5679:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==83) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalRoom.g:5679:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,83,FOLLOW_5); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // InternalRoom.g:5683:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // InternalRoom.g:5684:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5684:1: (lv_doCode_9_0= ruleDetailCode )
                    // InternalRoom.g:5685:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_96);
                    lv_doCode_9_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"doCode",
                            		lv_doCode_9_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:5701:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==84) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalRoom.g:5701:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,84,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // InternalRoom.g:5705:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // InternalRoom.g:5706:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // InternalRoom.g:5706:1: (lv_subgraph_11_0= ruleStateGraph )
                    // InternalRoom.g:5707:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_subgraph_11_0=ruleStateGraph();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefinedStateRule());
                    	        }
                           		set(
                           			current, 
                           			"subgraph",
                            		lv_subgraph_11_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.StateGraph");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:5735:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalRoom.g:5736:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalRoom.g:5737:2: iv_ruleDetailCode= ruleDetailCode EOF
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
    // InternalRoom.g:5744:1: ruleDetailCode returns [EObject current=null] : ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_used_1_0=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5747:28: ( ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' ) )
            // InternalRoom.g:5748:1: ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            {
            // InternalRoom.g:5748:1: ( () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}' )
            // InternalRoom.g:5748:2: () ( (lv_used_1_0= '{' ) ) ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= '}'
            {
            // InternalRoom.g:5748:2: ()
            // InternalRoom.g:5749:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDetailCodeAccess().getDetailCodeAction_0(),
                        current);
                

            }

            // InternalRoom.g:5754:2: ( (lv_used_1_0= '{' ) )
            // InternalRoom.g:5755:1: (lv_used_1_0= '{' )
            {
            // InternalRoom.g:5755:1: (lv_used_1_0= '{' )
            // InternalRoom.g:5756:3: lv_used_1_0= '{'
            {
            lv_used_1_0=(Token)match(input,13,FOLLOW_97); 

                    newLeafNode(lv_used_1_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDetailCodeRule());
            	        }
                   		setWithLastConsumed(current, "used", true, "{");
            	    

            }


            }

            // InternalRoom.g:5769:2: ( (lv_lines_2_0= RULE_STRING ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==RULE_STRING) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // InternalRoom.g:5770:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:5770:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:5771:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_97); 

            	    			newLeafNode(lv_lines_2_0, grammarAccess.getDetailCodeAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDetailCodeRule());
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
            	    break loop123;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:5799:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalRoom.g:5800:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalRoom.g:5801:2: iv_ruleTrPoint= ruleTrPoint EOF
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
    // InternalRoom.g:5808:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5811:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalRoom.g:5812:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalRoom.g:5812:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt124=3;
            switch ( input.LA(1) ) {
            case 86:
            case 87:
                {
                alt124=1;
                }
                break;
            case 88:
                {
                alt124=2;
                }
                break;
            case 89:
                {
                alt124=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalRoom.g:5813:5: this_TransitionPoint_0= ruleTransitionPoint
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
                    // InternalRoom.g:5823:5: this_EntryPoint_1= ruleEntryPoint
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
                    // InternalRoom.g:5833:5: this_ExitPoint_2= ruleExitPoint
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
    // InternalRoom.g:5849:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalRoom.g:5850:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalRoom.g:5851:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
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
    // InternalRoom.g:5858:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5861:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalRoom.g:5862:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5862:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalRoom.g:5862:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalRoom.g:5862:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==86) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalRoom.g:5863:1: (lv_handler_0_0= 'handler' )
                    {
                    // InternalRoom.g:5863:1: (lv_handler_0_0= 'handler' )
                    // InternalRoom.g:5864:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,86,FOLLOW_98); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,87,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // InternalRoom.g:5881:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:5882:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:5882:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:5883:3: lv_name_2_0= RULE_ID
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
    // InternalRoom.g:5907:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalRoom.g:5908:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalRoom.g:5909:2: iv_ruleEntryPoint= ruleEntryPoint EOF
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
    // InternalRoom.g:5916:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5919:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:5920:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5920:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:5920:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,88,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // InternalRoom.g:5924:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5925:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5925:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5926:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:5950:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalRoom.g:5951:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalRoom.g:5952:2: iv_ruleExitPoint= ruleExitPoint EOF
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
    // InternalRoom.g:5959:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5962:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:5963:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5963:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:5963:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // InternalRoom.g:5967:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5968:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5968:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5969:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:5993:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalRoom.g:5994:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalRoom.g:5995:2: iv_ruleChoicePoint= ruleChoicePoint EOF
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
    // InternalRoom.g:6002:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6005:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:6006:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:6006:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalRoom.g:6006:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,90,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // InternalRoom.g:6010:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6011:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6011:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6012:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

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

            // InternalRoom.g:6028:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==33) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalRoom.g:6029:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6029:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6030:3: lv_docu_2_0= ruleDocumentation
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


    // $ANTLR start "entryRuleTransition"
    // InternalRoom.g:6056:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalRoom.g:6057:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalRoom.g:6058:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalRoom.g:6065:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6068:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalRoom.g:6069:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalRoom.g:6069:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==91) ) {
                int LA127_1 = input.LA(2);

                if ( (LA127_1==RULE_ID) ) {
                    int LA127_2 = input.LA(3);

                    if ( (LA127_2==15) ) {
                        int LA127_3 = input.LA(4);

                        if ( (LA127_3==RULE_ID||(LA127_3>=99 && LA127_3<=100)) ) {
                            alt127=2;
                        }
                        else if ( (LA127_3==92) ) {
                            alt127=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 127, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 127, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA127_1==15) ) {
                    int LA127_3 = input.LA(3);

                    if ( (LA127_3==RULE_ID||(LA127_3>=99 && LA127_3<=100)) ) {
                        alt127=2;
                    }
                    else if ( (LA127_3==92) ) {
                        alt127=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 127, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 127, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // InternalRoom.g:6070:5: this_InitialTransition_0= ruleInitialTransition
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
                    // InternalRoom.g:6080:5: this_NonInitialTransition_1= ruleNonInitialTransition
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
    // InternalRoom.g:6096:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalRoom.g:6097:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalRoom.g:6098:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
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
    // InternalRoom.g:6105:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6108:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalRoom.g:6109:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalRoom.g:6109:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt128=3;
            alt128 = dfa128.predict(input);
            switch (alt128) {
                case 1 :
                    // InternalRoom.g:6110:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
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
                    // InternalRoom.g:6120:5: this_ContinuationTransition_1= ruleContinuationTransition
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
                    // InternalRoom.g:6130:5: this_CPBranchTransition_2= ruleCPBranchTransition
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
    // InternalRoom.g:6146:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalRoom.g:6147:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalRoom.g:6148:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
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
    // InternalRoom.g:6155:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6158:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalRoom.g:6159:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalRoom.g:6159:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt129=2;
            alt129 = dfa129.predict(input);
            switch (alt129) {
                case 1 :
                    // InternalRoom.g:6160:5: this_TriggeredTransition_0= ruleTriggeredTransition
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
                    // InternalRoom.g:6170:5: this_GuardedTransition_1= ruleGuardedTransition
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
    // InternalRoom.g:6186:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalRoom.g:6187:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalRoom.g:6188:2: iv_ruleInitialTransition= ruleInitialTransition EOF
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
    // InternalRoom.g:6195:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // InternalRoom.g:6198:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // InternalRoom.g:6199:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // InternalRoom.g:6199:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // InternalRoom.g:6199:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,91,FOLLOW_99); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6203:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==RULE_ID) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalRoom.g:6204:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6204:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6205:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_100); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,92,FOLLOW_11); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,18,FOLLOW_101); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6233:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6234:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6234:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6235:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_92);
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

            // InternalRoom.g:6251:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==33) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalRoom.g:6252:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6252:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6253:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_80);
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

            // InternalRoom.g:6269:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==13) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalRoom.g:6269:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_102); 

                        	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6273:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt132=2;
                    int LA132_0 = input.LA(1);

                    if ( (LA132_0==93) ) {
                        alt132=1;
                    }
                    switch (alt132) {
                        case 1 :
                            // InternalRoom.g:6273:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,93,FOLLOW_5); 

                                	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_1_0());
                                
                            // InternalRoom.g:6277:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // InternalRoom.g:6278:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6278:1: (lv_action_9_0= ruleDetailCode )
                            // InternalRoom.g:6279:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_53);
                            lv_action_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getInitialTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"action",
                                    		lv_action_9_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,14,FOLLOW_2); 

                        	newLeafNode(otherlv_10, grammarAccess.getInitialTransitionAccess().getRightCurlyBracketKeyword_7_2());
                        

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
    // InternalRoom.g:6307:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalRoom.g:6308:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalRoom.g:6309:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
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
    // InternalRoom.g:6316:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // InternalRoom.g:6319:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // InternalRoom.g:6320:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // InternalRoom.g:6320:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // InternalRoom.g:6320:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,91,FOLLOW_99); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6324:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==RULE_ID) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalRoom.g:6325:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6325:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6326:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_101); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6346:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6347:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6347:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6348:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_11);
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

            otherlv_4=(Token)match(input,18,FOLLOW_101); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6368:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6369:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6369:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6370:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_92);
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

            // InternalRoom.g:6386:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==33) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalRoom.g:6387:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6387:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6388:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_80);
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

            // InternalRoom.g:6404:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==13) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalRoom.g:6404:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_102); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6408:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==93) ) {
                        alt136=1;
                    }
                    switch (alt136) {
                        case 1 :
                            // InternalRoom.g:6408:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,93,FOLLOW_5); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // InternalRoom.g:6412:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // InternalRoom.g:6413:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6413:1: (lv_action_9_0= ruleDetailCode )
                            // InternalRoom.g:6414:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_53);
                            lv_action_9_0=ruleDetailCode();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getContinuationTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"action",
                                    		lv_action_9_0, 
                                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:6442:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalRoom.g:6443:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalRoom.g:6444:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
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
    // InternalRoom.g:6451:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
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
            // InternalRoom.g:6454:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // InternalRoom.g:6455:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // InternalRoom.g:6455:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // InternalRoom.g:6455:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_99); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6459:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==RULE_ID) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalRoom.g:6460:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6460:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6461:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_101); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6481:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6482:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6482:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6483:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_11);
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

            otherlv_4=(Token)match(input,18,FOLLOW_101); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6503:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6504:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6504:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6505:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_4);
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

            // InternalRoom.g:6521:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==33) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // InternalRoom.g:6522:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6522:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6523:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

            otherlv_7=(Token)match(input,13,FOLLOW_103); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,94,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,13,FOLLOW_104); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalRoom.g:6551:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // InternalRoom.g:6552:1: (lv_triggers_10_0= ruleTrigger )
            {
            // InternalRoom.g:6552:1: (lv_triggers_10_0= ruleTrigger )
            // InternalRoom.g:6553:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_105);
            lv_triggers_10_0=ruleTrigger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	        }
                   		add(
                   			current, 
                   			"triggers",
                    		lv_triggers_10_0, 
                    		"org.eclipse.etrice.core.fsm.FSM.Trigger");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:6569:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop140:
            do {
                int alt140=2;
                int LA140_0 = input.LA(1);

                if ( (LA140_0==95) ) {
                    alt140=1;
                }


                switch (alt140) {
            	case 1 :
            	    // InternalRoom.g:6569:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,95,FOLLOW_104); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // InternalRoom.g:6573:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // InternalRoom.g:6574:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // InternalRoom.g:6574:1: (lv_triggers_12_0= ruleTrigger )
            	    // InternalRoom.g:6575:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_105);
            	    lv_triggers_12_0=ruleTrigger();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"triggers",
            	            		lv_triggers_12_0, 
            	            		"org.eclipse.etrice.core.fsm.FSM.Trigger");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop140;
                }
            } while (true);

            otherlv_13=(Token)match(input,14,FOLLOW_102); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // InternalRoom.g:6595:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==93) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalRoom.g:6595:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,93,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // InternalRoom.g:6599:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // InternalRoom.g:6600:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6600:1: (lv_action_15_0= ruleDetailCode )
                    // InternalRoom.g:6601:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_action_15_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTriggeredTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_15_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:6629:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalRoom.g:6630:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalRoom.g:6631:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
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
    // InternalRoom.g:6638:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:6641:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:6642:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:6642:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // InternalRoom.g:6642:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_99); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6646:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==RULE_ID) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalRoom.g:6647:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6647:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6648:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_101); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6668:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6669:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6669:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6670:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_11);
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

            otherlv_4=(Token)match(input,18,FOLLOW_101); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6690:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6691:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6691:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6692:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_4);
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

            // InternalRoom.g:6708:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==33) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalRoom.g:6709:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6709:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6710:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

            otherlv_7=(Token)match(input,13,FOLLOW_106); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,96,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // InternalRoom.g:6734:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // InternalRoom.g:6735:1: (lv_guard_9_0= ruleDetailCode )
            {
            // InternalRoom.g:6735:1: (lv_guard_9_0= ruleDetailCode )
            // InternalRoom.g:6736:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_102);
            lv_guard_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"guard",
                    		lv_guard_9_0, 
                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:6752:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==93) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalRoom.g:6752:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,93,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // InternalRoom.g:6756:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // InternalRoom.g:6757:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6757:1: (lv_action_11_0= ruleDetailCode )
                    // InternalRoom.g:6758:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardedTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:6786:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalRoom.g:6787:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalRoom.g:6788:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
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
    // InternalRoom.g:6795:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:6798:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:6799:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:6799:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // InternalRoom.g:6799:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_99); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6803:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==RULE_ID) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalRoom.g:6804:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6804:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6805:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_101); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6825:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6826:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6826:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6827:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_11);
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

            otherlv_4=(Token)match(input,18,FOLLOW_101); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6847:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6848:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6848:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6849:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_4);
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

            // InternalRoom.g:6865:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==33) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalRoom.g:6866:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6866:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6867:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

            otherlv_7=(Token)match(input,13,FOLLOW_107); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,97,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // InternalRoom.g:6891:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // InternalRoom.g:6892:1: (lv_condition_9_0= ruleDetailCode )
            {
            // InternalRoom.g:6892:1: (lv_condition_9_0= ruleDetailCode )
            // InternalRoom.g:6893:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_102);
            lv_condition_9_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_9_0, 
                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:6909:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==93) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalRoom.g:6909:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,93,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // InternalRoom.g:6913:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // InternalRoom.g:6914:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6914:1: (lv_action_11_0= ruleDetailCode )
                    // InternalRoom.g:6915:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
                    lv_action_11_0=ruleDetailCode();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCPBranchTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"action",
                            		lv_action_11_0, 
                            		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:6943:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalRoom.g:6944:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalRoom.g:6945:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
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
    // InternalRoom.g:6952:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) ;
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
            // InternalRoom.g:6955:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) )
            // InternalRoom.g:6956:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            {
            // InternalRoom.g:6956:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            // InternalRoom.g:6956:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // InternalRoom.g:6960:1: ( ( ruleFQN ) )
            // InternalRoom.g:6961:1: ( ruleFQN )
            {
            // InternalRoom.g:6961:1: ( ruleFQN )
            // InternalRoom.g:6962:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefinedTransitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getTargetTransitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:6975:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==33) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // InternalRoom.g:6976:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6976:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6977:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
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

            otherlv_3=(Token)match(input,13,FOLLOW_108); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,93,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getRefinedTransitionAccess().getActionKeyword_4());
                
            // InternalRoom.g:7001:1: ( (lv_action_5_0= ruleDetailCode ) )
            // InternalRoom.g:7002:1: (lv_action_5_0= ruleDetailCode )
            {
            // InternalRoom.g:7002:1: (lv_action_5_0= ruleDetailCode )
            // InternalRoom.g:7003:3: lv_action_5_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_53);
            lv_action_5_0=ruleDetailCode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefinedTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"action",
                    		lv_action_5_0, 
                    		"org.eclipse.etrice.core.fsm.FSM.DetailCode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:7031:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalRoom.g:7032:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalRoom.g:7033:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
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
    // InternalRoom.g:7040:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7043:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalRoom.g:7044:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalRoom.g:7044:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt149=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA149_1 = input.LA(2);

                if ( (LA149_1==EOF||(LA149_1>=13 && LA149_1<=14)||LA149_1==18||LA149_1==33||LA149_1==80||(LA149_1>=85 && LA149_1<=91)||LA149_1==98) ) {
                    alt149=1;
                }
                else if ( (LA149_1==23) ) {
                    alt149=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 149, 1, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                alt149=2;
                }
                break;
            case 100:
                {
                alt149=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalRoom.g:7045:5: this_StateTerminal_0= ruleStateTerminal
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
                    // InternalRoom.g:7055:5: this_TrPointTerminal_1= ruleTrPointTerminal
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
                    // InternalRoom.g:7065:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
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
                    // InternalRoom.g:7075:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
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
    // InternalRoom.g:7091:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalRoom.g:7092:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalRoom.g:7093:2: iv_ruleStateTerminal= ruleStateTerminal EOF
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
    // InternalRoom.g:7100:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7103:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoom.g:7104:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoom.g:7104:1: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7105:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7105:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7106:3: otherlv_0= RULE_ID
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
    // InternalRoom.g:7125:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalRoom.g:7126:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalRoom.g:7127:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
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
    // InternalRoom.g:7134:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7137:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7138:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7138:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7138:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // InternalRoom.g:7142:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7143:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7143:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7144:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7163:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalRoom.g:7164:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalRoom.g:7165:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
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
    // InternalRoom.g:7172:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7175:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7176:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7176:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7176:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7176:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7177:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7177:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7178:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_73); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // InternalRoom.g:7193:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7194:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7194:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7195:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7214:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalRoom.g:7215:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalRoom.g:7216:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
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
    // InternalRoom.g:7223:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7226:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7227:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7227:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7227:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // InternalRoom.g:7231:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7232:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7232:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7233:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7252:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalRoom.g:7253:2: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalRoom.g:7254:2: iv_ruleTrigger= ruleTrigger EOF
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
    // InternalRoom.g:7261:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalRoom.g:7264:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalRoom.g:7265:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalRoom.g:7265:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalRoom.g:7265:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // InternalRoom.g:7269:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalRoom.g:7270:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalRoom.g:7270:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalRoom.g:7271:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_109);
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

            // InternalRoom.g:7287:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop150:
            do {
                int alt150=2;
                int LA150_0 = input.LA(1);

                if ( (LA150_0==102) ) {
                    alt150=1;
                }


                switch (alt150) {
            	case 1 :
            	    // InternalRoom.g:7287:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,102,FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // InternalRoom.g:7291:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalRoom.g:7292:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalRoom.g:7292:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalRoom.g:7293:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    break loop150;
                }
            } while (true);

            // InternalRoom.g:7309:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==96) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalRoom.g:7310:1: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalRoom.g:7310:1: (lv_guard_4_0= ruleGuard )
                    // InternalRoom.g:7311:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_110);
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

            otherlv_5=(Token)match(input,103,FOLLOW_2); 

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
    // InternalRoom.g:7339:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalRoom.g:7340:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalRoom.g:7341:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
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
    // InternalRoom.g:7348:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7351:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7352:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7352:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7352:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7352:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7353:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7353:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7354:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageEObjectCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // InternalRoom.g:7369:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7370:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7370:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7371:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7390:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalRoom.g:7391:2: (iv_ruleGuard= ruleGuard EOF )
            // InternalRoom.g:7392:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalRoom.g:7399:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7402:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:7403:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:7403:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:7403:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // InternalRoom.g:7407:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalRoom.g:7408:1: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalRoom.g:7408:1: (lv_guard_1_0= ruleDetailCode )
            // InternalRoom.g:7409:3: lv_guard_1_0= ruleDetailCode
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


    // $ANTLR start "entryRuleProtocolSemantics"
    // InternalRoom.g:7433:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // InternalRoom.g:7434:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // InternalRoom.g:7435:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
            {
             newCompositeNode(grammarAccess.getProtocolSemanticsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProtocolSemantics=ruleProtocolSemantics();

            state._fsp--;

             current =iv_ruleProtocolSemantics; 
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
    // $ANTLR end "entryRuleProtocolSemantics"


    // $ANTLR start "ruleProtocolSemantics"
    // InternalRoom.g:7442:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7445:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // InternalRoom.g:7446:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // InternalRoom.g:7446:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // InternalRoom.g:7446:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // InternalRoom.g:7446:2: ()
            // InternalRoom.g:7447:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,104,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_111); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:7460:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop152:
            do {
                int alt152=2;
                int LA152_0 = input.LA(1);

                if ( ((LA152_0>=105 && LA152_0<=106)) ) {
                    alt152=1;
                }


                switch (alt152) {
            	case 1 :
            	    // InternalRoom.g:7461:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // InternalRoom.g:7461:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // InternalRoom.g:7462:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
            	    lv_rules_3_0=ruleSemanticsRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProtocolSemanticsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_3_0, 
            	            		"org.eclipse.etrice.core.fsm.FSM.SemanticsRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop152;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRoom.g:7490:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalRoom.g:7491:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalRoom.g:7492:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
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
    // InternalRoom.g:7499:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7502:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalRoom.g:7503:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalRoom.g:7503:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==105) ) {
                alt153=1;
            }
            else if ( (LA153_0==106) ) {
                alt153=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }
            switch (alt153) {
                case 1 :
                    // InternalRoom.g:7504:5: this_InSemanticsRule_0= ruleInSemanticsRule
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
                    // InternalRoom.g:7514:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
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
    // InternalRoom.g:7530:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalRoom.g:7531:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalRoom.g:7532:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
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
    // InternalRoom.g:7539:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7542:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7543:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7543:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7543:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,105,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7551:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7552:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7552:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7553:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_112); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7564:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==18) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalRoom.g:7564:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_113); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7568:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt155=2;
                    int LA155_0 = input.LA(1);

                    if ( ((LA155_0>=105 && LA155_0<=106)) ) {
                        alt155=1;
                    }
                    else if ( (LA155_0==19) ) {
                        alt155=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 155, 0, input);

                        throw nvae;
                    }
                    switch (alt155) {
                        case 1 :
                            // InternalRoom.g:7568:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7568:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7569:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7569:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7570:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7587:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7587:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7587:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,19,FOLLOW_114); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7591:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7592:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7592:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7593:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_115);
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

                            // InternalRoom.g:7609:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt154=0;
                            loop154:
                            do {
                                int alt154=2;
                                int LA154_0 = input.LA(1);

                                if ( (LA154_0==24) ) {
                                    alt154=1;
                                }


                                switch (alt154) {
                            	case 1 :
                            	    // InternalRoom.g:7609:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,24,FOLLOW_114); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7613:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7614:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7614:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7615:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_38);
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
                            	    if ( cnt154 >= 1 ) break loop154;
                                        EarlyExitException eee =
                                            new EarlyExitException(154, input);
                                        throw eee;
                                }
                                cnt154++;
                            } while (true);

                            otherlv_9=(Token)match(input,20,FOLLOW_2); 

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
    // InternalRoom.g:7643:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalRoom.g:7644:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalRoom.g:7645:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
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
    // InternalRoom.g:7652:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7655:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7656:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7656:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7656:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,106,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7664:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7665:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7665:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7666:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_112); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7677:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==18) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalRoom.g:7677:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_113); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7681:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt158=2;
                    int LA158_0 = input.LA(1);

                    if ( ((LA158_0>=105 && LA158_0<=106)) ) {
                        alt158=1;
                    }
                    else if ( (LA158_0==19) ) {
                        alt158=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 158, 0, input);

                        throw nvae;
                    }
                    switch (alt158) {
                        case 1 :
                            // InternalRoom.g:7681:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7681:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7682:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7682:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7683:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7700:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7700:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7700:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,19,FOLLOW_114); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7704:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7705:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7705:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7706:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_115);
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

                            // InternalRoom.g:7722:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt157=0;
                            loop157:
                            do {
                                int alt157=2;
                                int LA157_0 = input.LA(1);

                                if ( (LA157_0==24) ) {
                                    alt157=1;
                                }


                                switch (alt157) {
                            	case 1 :
                            	    // InternalRoom.g:7722:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,24,FOLLOW_114); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7726:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7727:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7727:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7728:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_38);
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
                            	    if ( cnt157 >= 1 ) break loop157;
                                        EarlyExitException eee =
                                            new EarlyExitException(157, input);
                                        throw eee;
                                }
                                cnt157++;
                            } while (true);

                            otherlv_9=(Token)match(input,20,FOLLOW_2); 

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
    // InternalRoom.g:7756:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalRoom.g:7757:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalRoom.g:7758:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalRoom.g:7765:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalRoom.g:7768:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalRoom.g:7769:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalRoom.g:7769:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalRoom.g:7769:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,107,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // InternalRoom.g:7773:1: ( ( ruleFQN ) )
            // InternalRoom.g:7774:1: ( ruleFQN )
            {
            // InternalRoom.g:7774:1: ( ruleFQN )
            // InternalRoom.g:7775:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_116);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:7788:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==19) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // InternalRoom.g:7788:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalRoom.g:7792:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalRoom.g:7793:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalRoom.g:7793:1: (lv_attributes_3_0= ruleKeyValue )
                    // InternalRoom.g:7794:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_38);
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

                    // InternalRoom.g:7810:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop160:
                    do {
                        int alt160=2;
                        int LA160_0 = input.LA(1);

                        if ( (LA160_0==24) ) {
                            alt160=1;
                        }


                        switch (alt160) {
                    	case 1 :
                    	    // InternalRoom.g:7810:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // InternalRoom.g:7814:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalRoom.g:7815:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalRoom.g:7815:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalRoom.g:7816:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
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
                    	    break loop160;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_2); 

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
    // InternalRoom.g:7844:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalRoom.g:7845:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalRoom.g:7846:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalRoom.g:7853:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7856:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalRoom.g:7857:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalRoom.g:7857:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalRoom.g:7857:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalRoom.g:7857:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalRoom.g:7858:1: (lv_key_0_0= RULE_ID )
            {
            // InternalRoom.g:7858:1: (lv_key_0_0= RULE_ID )
            // InternalRoom.g:7859:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_117); 

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

            otherlv_1=(Token)match(input,25,FOLLOW_118); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalRoom.g:7879:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalRoom.g:7880:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalRoom.g:7880:1: (lv_value_2_0= ruleLiteral )
            // InternalRoom.g:7881:3: lv_value_2_0= ruleLiteral
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


    // $ANTLR start "entryRuleAnnotationType"
    // InternalRoom.g:7905:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // InternalRoom.g:7906:2: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // InternalRoom.g:7907:2: iv_ruleAnnotationType= ruleAnnotationType EOF
            {
             newCompositeNode(grammarAccess.getAnnotationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationType=ruleAnnotationType();

            state._fsp--;

             current =iv_ruleAnnotationType; 
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
    // $ANTLR end "entryRuleAnnotationType"


    // $ANTLR start "ruleAnnotationType"
    // InternalRoom.g:7914:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
    public final EObject ruleAnnotationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_docu_2_0 = null;

        AntlrDatatypeRuleToken lv_targets_6_0 = null;

        AntlrDatatypeRuleToken lv_targets_8_0 = null;

        AntlrDatatypeRuleToken lv_targets_10_0 = null;

        EObject lv_attributes_12_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7917:28: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // InternalRoom.g:7918:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // InternalRoom.g:7918:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // InternalRoom.g:7918:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,108,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
                
            // InternalRoom.g:7922:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:7923:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:7923:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:7924:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalRoom.g:7940:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==33) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalRoom.g:7941:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7941:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:7942:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_docu_2_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
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

            otherlv_3=(Token)match(input,13,FOLLOW_119); 

                	newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,109,FOLLOW_117); 

                	newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
                
            otherlv_5=(Token)match(input,25,FOLLOW_120); 

                	newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
                
            // InternalRoom.g:7970:1: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==27||LA164_0==41||LA164_0==47||LA164_0==54||LA164_0==63||LA164_0==65||LA164_0==78) ) {
                alt164=1;
            }
            else if ( (LA164_0==13) ) {
                alt164=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 164, 0, input);

                throw nvae;
            }
            switch (alt164) {
                case 1 :
                    // InternalRoom.g:7970:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // InternalRoom.g:7970:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:7971:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:7971:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    // InternalRoom.g:7972:3: lv_targets_6_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_121);
                    lv_targets_6_0=ruleAnnotationTargetType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"targets",
                            		lv_targets_6_0, 
                            		"org.eclipse.etrice.core.Room.AnnotationTargetType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:7989:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // InternalRoom.g:7989:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // InternalRoom.g:7989:8: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_122); 

                        	newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                        
                    // InternalRoom.g:7993:1: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:7994:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:7994:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    // InternalRoom.g:7995:3: lv_targets_8_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_20);
                    lv_targets_8_0=ruleAnnotationTargetType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"targets",
                            		lv_targets_8_0, 
                            		"org.eclipse.etrice.core.Room.AnnotationTargetType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalRoom.g:8011:2: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop163:
                    do {
                        int alt163=2;
                        int LA163_0 = input.LA(1);

                        if ( (LA163_0==24) ) {
                            alt163=1;
                        }


                        switch (alt163) {
                    	case 1 :
                    	    // InternalRoom.g:8011:4: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,24,FOLLOW_122); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	        
                    	    // InternalRoom.g:8015:1: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // InternalRoom.g:8016:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // InternalRoom.g:8016:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // InternalRoom.g:8017:3: lv_targets_10_0= ruleAnnotationTargetType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
                    	    lv_targets_10_0=ruleAnnotationTargetType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"targets",
                    	            		lv_targets_10_0, 
                    	            		"org.eclipse.etrice.core.Room.AnnotationTargetType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop163;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FOLLOW_121); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                        

                    }


                    }
                    break;

            }

            // InternalRoom.g:8037:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop165:
            do {
                int alt165=2;
                int LA165_0 = input.LA(1);

                if ( ((LA165_0>=110 && LA165_0<=111)) ) {
                    alt165=1;
                }


                switch (alt165) {
            	case 1 :
            	    // InternalRoom.g:8038:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // InternalRoom.g:8038:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // InternalRoom.g:8039:3: lv_attributes_12_0= ruleAnnotationAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_121);
            	    lv_attributes_12_0=ruleAnnotationAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAnnotationTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_12_0, 
            	            		"org.eclipse.etrice.core.common.Base.AnnotationAttribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop165;
                }
            } while (true);

            otherlv_13=(Token)match(input,14,FOLLOW_2); 

                	newLeafNode(otherlv_13, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationType"


    // $ANTLR start "entryRuleAnnotationAttribute"
    // InternalRoom.g:8067:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8068:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalRoom.g:8069:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalRoom.g:8076:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8079:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalRoom.g:8080:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalRoom.g:8080:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==110) ) {
                int LA166_1 = input.LA(2);

                if ( (LA166_1==112) ) {
                    int LA166_3 = input.LA(3);

                    if ( (LA166_3==RULE_ID) ) {
                        int LA166_4 = input.LA(4);

                        if ( (LA166_4==15) ) {
                            int LA166_5 = input.LA(5);

                            if ( ((LA166_5>=128 && LA166_5<=131)) ) {
                                alt166=1;
                            }
                            else if ( (LA166_5==13) ) {
                                alt166=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 166, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 166, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 166, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 166, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA166_0==111) ) {
                int LA166_2 = input.LA(2);

                if ( (LA166_2==112) ) {
                    int LA166_3 = input.LA(3);

                    if ( (LA166_3==RULE_ID) ) {
                        int LA166_4 = input.LA(4);

                        if ( (LA166_4==15) ) {
                            int LA166_5 = input.LA(5);

                            if ( ((LA166_5>=128 && LA166_5<=131)) ) {
                                alt166=1;
                            }
                            else if ( (LA166_5==13) ) {
                                alt166=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 166, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 166, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 166, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 166, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 166, 0, input);

                throw nvae;
            }
            switch (alt166) {
                case 1 :
                    // InternalRoom.g:8081:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalRoom.g:8091:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalRoom.g:8107:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8108:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalRoom.g:8109:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalRoom.g:8116:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalRoom.g:8119:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalRoom.g:8120:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalRoom.g:8120:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalRoom.g:8120:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalRoom.g:8120:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( (LA167_0==110) ) {
                alt167=1;
            }
            else if ( (LA167_0==111) ) {
                alt167=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 167, 0, input);

                throw nvae;
            }
            switch (alt167) {
                case 1 :
                    // InternalRoom.g:8120:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8120:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8121:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8121:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8122:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,110,FOLLOW_123); 

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
                    // InternalRoom.g:8136:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,111,FOLLOW_123); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,112,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8144:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8145:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8145:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8146:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_4=(Token)match(input,15,FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalRoom.g:8166:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalRoom.g:8167:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalRoom.g:8167:1: (lv_type_5_0= ruleLiteralType )
            // InternalRoom.g:8168:3: lv_type_5_0= ruleLiteralType
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
    // InternalRoom.g:8192:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalRoom.g:8193:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalRoom.g:8194:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalRoom.g:8201:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalRoom.g:8204:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalRoom.g:8205:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalRoom.g:8205:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalRoom.g:8205:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalRoom.g:8205:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==110) ) {
                alt168=1;
            }
            else if ( (LA168_0==111) ) {
                alt168=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 168, 0, input);

                throw nvae;
            }
            switch (alt168) {
                case 1 :
                    // InternalRoom.g:8205:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8205:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8206:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8206:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8207:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,110,FOLLOW_123); 

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
                    // InternalRoom.g:8221:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,111,FOLLOW_123); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,112,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8229:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8230:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8230:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8231:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            otherlv_4=(Token)match(input,15,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,13,FOLLOW_12); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:8255:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalRoom.g:8256:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalRoom.g:8256:1: (lv_values_6_0= RULE_STRING )
            // InternalRoom.g:8257:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

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

            // InternalRoom.g:8273:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop169:
            do {
                int alt169=2;
                int LA169_0 = input.LA(1);

                if ( (LA169_0==24) ) {
                    alt169=1;
                }


                switch (alt169) {
            	case 1 :
            	    // InternalRoom.g:8273:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,24,FOLLOW_12); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalRoom.g:8277:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalRoom.g:8278:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8278:1: (lv_values_8_0= RULE_STRING )
            	    // InternalRoom.g:8279:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

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
            	    break loop169;
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
    // InternalRoom.g:8307:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoom.g:8308:2: (iv_ruleImport= ruleImport EOF )
            // InternalRoom.g:8309:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoom.g:8316:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8319:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8320:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8320:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalRoom.g:8320:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,113,FOLLOW_124); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalRoom.g:8324:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==RULE_ID) ) {
                alt170=1;
            }
            else if ( (LA170_0==115) ) {
                alt170=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 170, 0, input);

                throw nvae;
            }
            switch (alt170) {
                case 1 :
                    // InternalRoom.g:8324:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalRoom.g:8324:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalRoom.g:8324:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalRoom.g:8324:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalRoom.g:8325:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalRoom.g:8325:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalRoom.g:8326:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_125);
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

                    otherlv_2=(Token)match(input,114,FOLLOW_12); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:8347:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,115,FOLLOW_12); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:8351:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalRoom.g:8352:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalRoom.g:8352:1: (lv_importURI_4_0= RULE_STRING )
            // InternalRoom.g:8353:3: lv_importURI_4_0= RULE_STRING
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
    // InternalRoom.g:8377:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalRoom.g:8378:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalRoom.g:8379:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalRoom.g:8386:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8389:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalRoom.g:8390:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalRoom.g:8390:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalRoom.g:8391:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_126);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalRoom.g:8401:1: (kw= '.*' )?
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==116) ) {
                alt171=1;
            }
            switch (alt171) {
                case 1 :
                    // InternalRoom.g:8402:2: kw= '.*'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

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
    // InternalRoom.g:8415:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalRoom.g:8416:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalRoom.g:8417:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalRoom.g:8424:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8427:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalRoom.g:8428:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalRoom.g:8428:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalRoom.g:8428:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalRoom.g:8428:2: ()
            // InternalRoom.g:8429:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,33,FOLLOW_127); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalRoom.g:8438:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop172:
            do {
                int alt172=2;
                int LA172_0 = input.LA(1);

                if ( (LA172_0==RULE_STRING) ) {
                    alt172=1;
                }


                switch (alt172) {
            	case 1 :
            	    // InternalRoom.g:8439:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8439:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:8440:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_127); 

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
            	    break loop172;
                }
            } while (true);

            otherlv_3=(Token)match(input,34,FOLLOW_2); 

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
    // InternalRoom.g:8472:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalRoom.g:8473:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalRoom.g:8474:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalRoom.g:8481:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8484:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalRoom.g:8485:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalRoom.g:8485:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt173=3;
            switch ( input.LA(1) ) {
            case 117:
            case 118:
                {
                alt173=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 119:
            case 120:
                {
                alt173=2;
                }
                break;
            case RULE_STRING:
                {
                alt173=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 173, 0, input);

                throw nvae;
            }

            switch (alt173) {
                case 1 :
                    // InternalRoom.g:8486:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalRoom.g:8496:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalRoom.g:8506:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalRoom.g:8522:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalRoom.g:8523:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalRoom.g:8524:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalRoom.g:8531:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8534:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalRoom.g:8535:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalRoom.g:8535:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalRoom.g:8535:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalRoom.g:8535:2: ()
            // InternalRoom.g:8536:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8541:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==117) ) {
                alt174=1;
            }
            else if ( (LA174_0==118) ) {
                alt174=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 174, 0, input);

                throw nvae;
            }
            switch (alt174) {
                case 1 :
                    // InternalRoom.g:8541:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,117,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8546:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalRoom.g:8546:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalRoom.g:8547:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalRoom.g:8547:1: (lv_isTrue_2_0= 'true' )
                    // InternalRoom.g:8548:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,118,FOLLOW_2); 

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
    // InternalRoom.g:8569:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalRoom.g:8570:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalRoom.g:8571:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalRoom.g:8578:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8581:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalRoom.g:8582:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalRoom.g:8582:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt175=2;
            switch ( input.LA(1) ) {
            case 119:
                {
                int LA175_1 = input.LA(2);

                if ( (LA175_1==RULE_INT) ) {
                    int LA175_3 = input.LA(3);

                    if ( (LA175_3==71) ) {
                        alt175=2;
                    }
                    else if ( (LA175_3==EOF||LA175_3==20||LA175_3==24) ) {
                        alt175=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 175, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 175, 1, input);

                    throw nvae;
                }
                }
                break;
            case 120:
                {
                int LA175_2 = input.LA(2);

                if ( (LA175_2==RULE_INT) ) {
                    int LA175_3 = input.LA(3);

                    if ( (LA175_3==71) ) {
                        alt175=2;
                    }
                    else if ( (LA175_3==EOF||LA175_3==20||LA175_3==24) ) {
                        alt175=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 175, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 175, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA175_3 = input.LA(2);

                if ( (LA175_3==71) ) {
                    alt175=2;
                }
                else if ( (LA175_3==EOF||LA175_3==20||LA175_3==24) ) {
                    alt175=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 175, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt175=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 175, 0, input);

                throw nvae;
            }

            switch (alt175) {
                case 1 :
                    // InternalRoom.g:8583:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalRoom.g:8593:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalRoom.g:8609:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalRoom.g:8610:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalRoom.g:8611:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalRoom.g:8618:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8621:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalRoom.g:8622:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalRoom.g:8622:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalRoom.g:8622:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalRoom.g:8622:2: ()
            // InternalRoom.g:8623:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8628:2: ( (lv_value_1_0= ruleReal ) )
            // InternalRoom.g:8629:1: (lv_value_1_0= ruleReal )
            {
            // InternalRoom.g:8629:1: (lv_value_1_0= ruleReal )
            // InternalRoom.g:8630:3: lv_value_1_0= ruleReal
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
    // InternalRoom.g:8654:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalRoom.g:8655:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalRoom.g:8656:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalRoom.g:8663:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8666:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalRoom.g:8667:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalRoom.g:8667:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalRoom.g:8667:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalRoom.g:8667:2: ()
            // InternalRoom.g:8668:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8673:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalRoom.g:8674:1: (lv_value_1_0= ruleInteger )
            {
            // InternalRoom.g:8674:1: (lv_value_1_0= ruleInteger )
            // InternalRoom.g:8675:3: lv_value_1_0= ruleInteger
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
    // InternalRoom.g:8699:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalRoom.g:8700:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalRoom.g:8701:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalRoom.g:8708:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8711:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8712:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8712:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRoom.g:8712:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRoom.g:8712:2: ()
            // InternalRoom.g:8713:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8718:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRoom.g:8719:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalRoom.g:8719:1: (lv_value_1_0= RULE_STRING )
            // InternalRoom.g:8720:3: lv_value_1_0= RULE_STRING
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
    // InternalRoom.g:8744:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalRoom.g:8745:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalRoom.g:8746:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalRoom.g:8753:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8756:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalRoom.g:8757:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalRoom.g:8757:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==RULE_INT||(LA177_0>=119 && LA177_0<=120)) ) {
                alt177=1;
            }
            else if ( (LA177_0==RULE_HEX) ) {
                alt177=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;
            }
            switch (alt177) {
                case 1 :
                    // InternalRoom.g:8757:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalRoom.g:8757:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalRoom.g:8757:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalRoom.g:8757:3: (kw= '+' | kw= '-' )?
                    int alt176=3;
                    int LA176_0 = input.LA(1);

                    if ( (LA176_0==119) ) {
                        alt176=1;
                    }
                    else if ( (LA176_0==120) ) {
                        alt176=2;
                    }
                    switch (alt176) {
                        case 1 :
                            // InternalRoom.g:8758:2: kw= '+'
                            {
                            kw=(Token)match(input,119,FOLLOW_31); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:8765:2: kw= '-'
                            {
                            kw=(Token)match(input,120,FOLLOW_31); 

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
                    // InternalRoom.g:8778:10: this_HEX_3= RULE_HEX
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
    // InternalRoom.g:8793:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalRoom.g:8794:2: (iv_ruleReal= ruleReal EOF )
            // InternalRoom.g:8795:2: iv_ruleReal= ruleReal EOF
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
    // InternalRoom.g:8802:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8805:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalRoom.g:8806:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalRoom.g:8806:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt178=2;
            switch ( input.LA(1) ) {
            case 119:
                {
                int LA178_1 = input.LA(2);

                if ( (LA178_1==RULE_INT) ) {
                    int LA178_3 = input.LA(3);

                    if ( (LA178_3==71) ) {
                        int LA178_4 = input.LA(4);

                        if ( (LA178_4==RULE_INT) ) {
                            int LA178_5 = input.LA(5);

                            if ( ((LA178_5>=121 && LA178_5<=122)) ) {
                                alt178=2;
                            }
                            else if ( (LA178_5==EOF||LA178_5==20||LA178_5==24) ) {
                                alt178=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 178, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 178, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 178, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 178, 1, input);

                    throw nvae;
                }
                }
                break;
            case 120:
                {
                int LA178_2 = input.LA(2);

                if ( (LA178_2==RULE_INT) ) {
                    int LA178_3 = input.LA(3);

                    if ( (LA178_3==71) ) {
                        int LA178_4 = input.LA(4);

                        if ( (LA178_4==RULE_INT) ) {
                            int LA178_5 = input.LA(5);

                            if ( ((LA178_5>=121 && LA178_5<=122)) ) {
                                alt178=2;
                            }
                            else if ( (LA178_5==EOF||LA178_5==20||LA178_5==24) ) {
                                alt178=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 178, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 178, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 178, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 178, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA178_3 = input.LA(2);

                if ( (LA178_3==71) ) {
                    int LA178_4 = input.LA(3);

                    if ( (LA178_4==RULE_INT) ) {
                        int LA178_5 = input.LA(4);

                        if ( ((LA178_5>=121 && LA178_5<=122)) ) {
                            alt178=2;
                        }
                        else if ( (LA178_5==EOF||LA178_5==20||LA178_5==24) ) {
                            alt178=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 178, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 178, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 178, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 178, 0, input);

                throw nvae;
            }

            switch (alt178) {
                case 1 :
                    // InternalRoom.g:8807:5: this_Decimal_0= ruleDecimal
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
                    // InternalRoom.g:8819:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalRoom.g:8837:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:8841:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalRoom.g:8842:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalRoom.g:8852:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:8856:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalRoom.g:8857:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalRoom.g:8857:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalRoom.g:8857:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalRoom.g:8857:2: (kw= '+' | kw= '-' )?
            int alt179=3;
            int LA179_0 = input.LA(1);

            if ( (LA179_0==119) ) {
                alt179=1;
            }
            else if ( (LA179_0==120) ) {
                alt179=2;
            }
            switch (alt179) {
                case 1 :
                    // InternalRoom.g:8858:2: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_31); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8865:2: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_31); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_85); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,71,FOLLOW_31); 

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
    // InternalRoom.g:8901:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:8905:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalRoom.g:8906:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalRoom.g:8916:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:8920:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalRoom.g:8921:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalRoom.g:8921:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalRoom.g:8921:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalRoom.g:8921:2: (kw= '+' | kw= '-' )?
            int alt180=3;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==119) ) {
                alt180=1;
            }
            else if ( (LA180_0==120) ) {
                alt180=2;
            }
            switch (alt180) {
                case 1 :
                    // InternalRoom.g:8922:2: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_31); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8929:2: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_31); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_85); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,71,FOLLOW_31); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_128); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalRoom.g:8954:1: (kw= 'e' | kw= 'E' )
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==121) ) {
                alt181=1;
            }
            else if ( (LA181_0==122) ) {
                alt181=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 181, 0, input);

                throw nvae;
            }
            switch (alt181) {
                case 1 :
                    // InternalRoom.g:8955:2: kw= 'e'
                    {
                    kw=(Token)match(input,121,FOLLOW_129); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8962:2: kw= 'E'
                    {
                    kw=(Token)match(input,122,FOLLOW_129); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalRoom.g:8967:2: (kw= '+' | kw= '-' )?
            int alt182=3;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==119) ) {
                alt182=1;
            }
            else if ( (LA182_0==120) ) {
                alt182=2;
            }
            switch (alt182) {
                case 1 :
                    // InternalRoom.g:8968:2: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_31); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8975:2: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_31); 

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
    // InternalRoom.g:8998:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalRoom.g:8999:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalRoom.g:9000:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalRoom.g:9007:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9010:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoom.g:9011:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoom.g:9011:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoom.g:9011:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_130); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalRoom.g:9018:1: (kw= '.' this_ID_2= RULE_ID )*
            loop183:
            do {
                int alt183=2;
                int LA183_0 = input.LA(1);

                if ( (LA183_0==71) ) {
                    alt183=1;
                }


                switch (alt183) {
            	case 1 :
            	    // InternalRoom.g:9019:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,71,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_130); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop183;
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


    // $ANTLR start "ruleCommunicationType"
    // InternalRoom.g:9039:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalRoom.g:9041:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // InternalRoom.g:9042:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // InternalRoom.g:9042:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt184=3;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt184=1;
                }
                break;
            case 124:
                {
                alt184=2;
                }
                break;
            case 125:
                {
                alt184=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 184, 0, input);

                throw nvae;
            }

            switch (alt184) {
                case 1 :
                    // InternalRoom.g:9042:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9042:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9042:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9048:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9048:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9048:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9054:6: (enumLiteral_2= 'sync' )
                    {
                    // InternalRoom.g:9054:6: (enumLiteral_2= 'sync' )
                    // InternalRoom.g:9054:8: enumLiteral_2= 'sync'
                    {
                    enumLiteral_2=(Token)match(input,125,FOLLOW_2); 

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


    // $ANTLR start "ruleReferenceType"
    // InternalRoom.g:9064:1: ruleReferenceType returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) ;
    public final Enumerator ruleReferenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalRoom.g:9066:28: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) )
            // InternalRoom.g:9067:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            {
            // InternalRoom.g:9067:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==126) ) {
                alt185=1;
            }
            else if ( (LA185_0==110) ) {
                alt185=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }
            switch (alt185) {
                case 1 :
                    // InternalRoom.g:9067:2: (enumLiteral_0= 'fixed' )
                    {
                    // InternalRoom.g:9067:2: (enumLiteral_0= 'fixed' )
                    // InternalRoom.g:9067:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,126,FOLLOW_2); 

                            current = grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9073:6: (enumLiteral_1= 'optional' )
                    {
                    // InternalRoom.g:9073:6: (enumLiteral_1= 'optional' )
                    // InternalRoom.g:9073:8: enumLiteral_1= 'optional'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                            current = grammarAccess.getReferenceTypeAccess().getOPTIONALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getReferenceTypeAccess().getOPTIONALEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "ruleComponentCommunicationType"
    // InternalRoom.g:9085:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9087:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalRoom.g:9088:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalRoom.g:9088:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt186=4;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt186=1;
                }
                break;
            case 124:
                {
                alt186=2;
                }
                break;
            case 127:
                {
                alt186=3;
                }
                break;
            case 125:
                {
                alt186=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 186, 0, input);

                throw nvae;
            }

            switch (alt186) {
                case 1 :
                    // InternalRoom.g:9088:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9088:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9088:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9094:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9094:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9094:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9100:6: (enumLiteral_2= 'async' )
                    {
                    // InternalRoom.g:9100:6: (enumLiteral_2= 'async' )
                    // InternalRoom.g:9100:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9106:6: (enumLiteral_3= 'sync' )
                    {
                    // InternalRoom.g:9106:6: (enumLiteral_3= 'sync' )
                    // InternalRoom.g:9106:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,125,FOLLOW_2); 

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
    // InternalRoom.g:9116:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9118:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalRoom.g:9119:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalRoom.g:9119:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt187=4;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt187=1;
                }
                break;
            case 129:
                {
                alt187=2;
                }
                break;
            case 130:
                {
                alt187=3;
                }
                break;
            case 131:
                {
                alt187=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 187, 0, input);

                throw nvae;
            }

            switch (alt187) {
                case 1 :
                    // InternalRoom.g:9119:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalRoom.g:9119:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalRoom.g:9119:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9125:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalRoom.g:9125:6: (enumLiteral_1= 'ptInteger' )
                    // InternalRoom.g:9125:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9131:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalRoom.g:9131:6: (enumLiteral_2= 'ptReal' )
                    // InternalRoom.g:9131:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9137:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalRoom.g:9137:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalRoom.g:9137:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,131,FOLLOW_2); 

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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA128 dfa128 = new DFA128(this);
    protected DFA129 dfa129 = new DFA129(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\16\5\uffff\3\51\5\uffff";
    static final String dfa_3s = "\1\177\5\uffff\3\177\5\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\3\uffff\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_5s = "\16\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\2\uffff\1\2\4\uffff\1\3\3\uffff\1\4\1\5\15\uffff\1\11\5\uffff\1\11\5\uffff\2\12\10\uffff\1\14\1\uffff\1\13\52\uffff\1\15\16\uffff\1\6\1\7\1\10\1\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\11\13\uffff\2\12\104\uffff\3\12\1\uffff\1\12",
            "\1\11\13\uffff\2\12\104\uffff\3\12\1\uffff\1\12",
            "\1\11\13\uffff\2\12\104\uffff\3\12\1\uffff\1\12",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 143:3: ( ( (lv_primitiveTypes_5_0= rulePrimitiveType ) ) | ( (lv_enumerationTypes_6_0= ruleEnumerationType ) ) | ( (lv_externalTypes_7_0= ruleExternalType ) ) | ( (lv_dataClasses_8_0= ruleDataClass ) ) | ( (lv_protocolClasses_9_0= ruleGeneralProtocolClass ) ) | ( (lv_actorClasses_10_0= ruleActorClass ) ) | ( (lv_subSystemClasses_11_0= ruleSubSystemClass ) ) | ( (lv_systems_12_0= ruleLogicalSystem ) ) | ( (lv_annotationTypes_13_0= ruleAnnotationType ) ) )*";
        }
    }
    static final String dfa_7s = "\32\uffff";
    static final String dfa_8s = "\13\uffff\1\21\7\uffff\2\21\1\uffff\1\21\2\uffff\1\21";
    static final String dfa_9s = "\1\133\1\4\1\17\1\4\1\22\4\4\2\22\1\15\2\4\1\22\1\5\1\16\1\uffff\1\4\2\15\1\5\1\15\2\uffff\1\15";
    static final String dfa_10s = "\1\133\2\17\1\144\1\27\2\4\1\144\1\4\2\22\1\142\2\4\1\22\1\42\1\141\1\uffff\1\4\2\142\1\42\1\142\2\uffff\1\142";
    static final String dfa_11s = "\21\uffff\1\2\5\uffff\1\1\1\3\1\uffff";
    static final String dfa_12s = "\32\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2\12\uffff\1\3",
            "\1\3",
            "\1\4\136\uffff\1\5\1\6",
            "\1\7\4\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\136\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\20\1\21\10\uffff\1\22\11\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25\34\uffff\1\26",
            "\1\21\116\uffff\1\21\1\27\1\uffff\1\27\1\30",
            "",
            "\1\31",
            "\1\20\1\21\22\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\20\1\21\22\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\25\34\uffff\1\26",
            "\1\20\1\21\101\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "",
            "",
            "\1\20\1\21\22\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA128 extends DFA {

        public DFA128(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 128;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "6109:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_14s = "\31\uffff";
    static final String dfa_15s = "\1\133\1\4\1\17\1\4\1\22\4\4\3\22\1\15\3\4\1\5\1\136\3\15\1\5\1\15\2\uffff";
    static final String dfa_16s = "\1\133\2\17\1\144\1\27\3\4\1\144\3\22\1\41\3\4\1\42\1\140\3\41\1\42\1\15\2\uffff";
    static final String dfa_17s = "\27\uffff\1\1\1\2";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2\12\uffff\1\3",
            "\1\3",
            "\1\4\136\uffff\1\5\1\6",
            "\1\10\4\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\136\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\21\11\uffff\1\17\11\uffff\1\20",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25\34\uffff\1\26",
            "\1\27\1\uffff\1\30",
            "\1\21\23\uffff\1\20",
            "\1\21\23\uffff\1\20",
            "\1\21\23\uffff\1\20",
            "\1\25\34\uffff\1\26",
            "\1\21",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA129 extends DFA {

        public DFA129(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 129;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "6159:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x806082000C424000L,0xB802100000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x806082000C424000L,0xB800100000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200802000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000000000C0L,0x0180000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000210002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000199E0004000L,0x0000080000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000199C0004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000019980004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000019900004000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000202000012L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000000020000A000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000000420000A000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00005C00E0004000L,0x0000090000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00005C00C0004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00005C0080004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x00005C0000004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0006000000004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000580000004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000500000004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000400000004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000004000L,0x0000010000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0001000000004000L,0x0000080000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0001000000004000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0018019900004000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0010019900004000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0060000000000000L,0xB800000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0380000000004000L,0x0000080000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x2400400000004000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0300000000004000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x7C004199E0004000L,0x4000400000001220L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x7C004199C0004000L,0x4000400000001220L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x7C00419980004000L,0x4000400000001220L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x7C00419900004000L,0x4000400000001220L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0200000000004000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000019800004000L,0x0000080000008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000019800004000L,0x0000000000008000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000004000L,0x0000080000000221L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000221L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x24004000E0004000L,0x400048000000122CL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x24004000C0004000L,0x400040000000122CL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x2400400080004000L,0x400040000000122CL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x2400400000004000L,0x400040000000122CL});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000800L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000040L,0x0000000000002000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000004000L,0x000000040FE10000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000200002002L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000004000L,0x00000000001E0000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000004000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000004000L,0x0000000000180000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000004000L,0x0000000000100000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000010L,0x0000001800000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000004000L,0x0000000020000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000004000L,0x0000000080000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x000000C100000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000004000L,0x0000060000000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000080000L,0x0000060000000000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x00000000000000E0L,0x01E0000000000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x8040820008002000L,0x0000000000004002L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000004000L,0x0000C00000000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x8040820008000000L,0x0000000000004002L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000010L,0x0008000000000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000400000020L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000000040L,0x0180000000000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});

}
