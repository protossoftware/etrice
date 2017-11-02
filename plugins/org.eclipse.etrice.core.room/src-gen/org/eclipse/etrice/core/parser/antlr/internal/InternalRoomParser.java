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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_CC_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'Enumeration'", "'of'", "','", "'='", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'override'", "'Operation'", "'void'", "'sends'", "'ctor'", "'dtor'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugated'", "'CompoundProtocolClass'", "'SubProtocol'", "'private'", "'Message'", "'usercode'", "'handle'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'ActorInstanceMapping'", "'/'", "'Binding'", "'and'", "'.'", "'sub'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'*'", "'ActorBehavior'", "'StateMachine'", "'State'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'Transition'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'semantics'", "'in'", "'out'", "'@'", "'AnnotationType'", "'target'", "'optional'", "'mandatory'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'false'", "'true'", "'+'", "'-'", "'e'", "'E'", "'eventdriven'", "'datadriven'", "'sync'", "'fixed'", "'async'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
    };
    public static final int RULE_HEX=8;
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int RULE_CC_STRING=7;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

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

            if ( (LA1_0==34) ) {
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

            otherlv_3=(Token)match(input,14,FOLLOW_6); 

                	newLeafNode(otherlv_3, grammarAccess.getRoomModelAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:125:1: ( (lv_imports_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==114) ) {
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

            otherlv_14=(Token)match(input,15,FOLLOW_2); 

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

            if ( ((LA4_0>=54 && LA4_0<=55)||LA4_0==66||(LA4_0>=124 && LA4_0<=126)||LA4_0==128) ) {
                alt4=1;
            }
            else if ( (LA4_0==64) ) {
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

            if ( ((LA5_0>=54 && LA5_0<=55)||(LA5_0>=124 && LA5_0<=126)||LA5_0==128) ) {
                alt5=1;
            }
            else if ( (LA5_0==66) ) {
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

            otherlv_1=(Token)match(input,16,FOLLOW_3); 

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

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRoom.g:497:1: (lv_ref_1_0= 'ref' )
                    {
                    // InternalRoom.g:497:1: (lv_ref_1_0= 'ref' )
                    // InternalRoom.g:498:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,17,FOLLOW_2); 

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
            case 18:
                {
                alt7=1;
                }
                break;
            case 23:
                {
                alt7=2;
                }
                break;
            case 27:
            case 28:
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

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
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
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_10); 

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

            otherlv_4=(Token)match(input,19,FOLLOW_12); 

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

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoom.g:688:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_3); 

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

                    otherlv_8=(Token)match(input,21,FOLLOW_15); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_6_2());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,22,FOLLOW_12); 

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

            if ( (LA10_0==34) ) {
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
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

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

            if ( (LA11_0==34) ) {
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

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRoom.g:815:5: otherlv_3= 'of' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_3); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_19); 

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

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalRoom.g:856:4: otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_7=(Token)match(input,25,FOLLOW_3); 

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

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

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

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRoom.g:921:4: otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) )
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_22); 

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
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

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

            otherlv_2=(Token)match(input,19,FOLLOW_12); 

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

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoom.g:1008:4: otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_12); 

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

            if ( (LA17_0==34) ) {
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
            otherlv_0=(Token)match(input,28,FOLLOW_3); 

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

            if ( (LA18_0==34) ) {
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

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRoom.g:1109:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,29,FOLLOW_3); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_26); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:1132:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==108) ) {
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

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRoom.g:1150:5: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_27); 

                        	newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                        
                    // InternalRoom.g:1154:1: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // InternalRoom.g:1155:1: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1155:1: (lv_userCode1_8_0= ruleDetailCode )
                    // InternalRoom.g:1156:3: lv_userCode1_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_28);
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

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRoom.g:1172:6: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,31,FOLLOW_29); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                        
                    // InternalRoom.g:1176:1: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // InternalRoom.g:1177:1: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1177:1: (lv_userCode2_10_0= ruleDetailCode )
                    // InternalRoom.g:1178:3: lv_userCode2_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_30);
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

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRoom.g:1194:6: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,32,FOLLOW_31); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                        
                    // InternalRoom.g:1198:1: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // InternalRoom.g:1199:1: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1199:1: (lv_userCode3_12_0= ruleDetailCode )
                    // InternalRoom.g:1200:3: lv_userCode3_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_32);
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
                case 36:
                case 37:
                    {
                    alt24=1;
                    }
                    break;
                case 40:
                case 41:
                    {
                    alt24=2;
                    }
                    break;
                case 33:
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
            	    	    
            	    pushFollow(FOLLOW_32);
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
            	    	    
            	    pushFollow(FOLLOW_32);
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
            	    	    
            	    pushFollow(FOLLOW_32);
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

            otherlv_16=(Token)match(input,15,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // InternalRoom.g:1301:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1302:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1302:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1303:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRoom.g:1319:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // InternalRoom.g:1323:1: ( (lv_size_3_0= RULE_INT ) )
                    // InternalRoom.g:1324:1: (lv_size_3_0= RULE_INT )
                    {
                    // InternalRoom.g:1324:1: (lv_size_3_0= RULE_INT )
                    // InternalRoom.g:1325:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_35); 

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

                    otherlv_4=(Token)match(input,35,FOLLOW_8); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_36); 

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
                    	    
                    pushFollow(FOLLOW_37);
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

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRoom.g:1367:5: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,26,FOLLOW_12); 

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

            if ( (LA28_0==34) ) {
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

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRoom.g:1431:1: (lv_override_0_0= 'override' )
                    {
                    // InternalRoom.g:1431:1: (lv_override_0_0= 'override' )
                    // InternalRoom.g:1432:3: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,36,FOLLOW_38); 

                            newLeafNode(lv_override_0_0, grammarAccess.getStandardOperationAccess().getOverrideOverrideKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStandardOperationRule());
                    	        }
                           		setWithLastConsumed(current, "override", true, "override");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,37,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getStandardOperationAccess().getOperationKeyword_1());
                
            // InternalRoom.g:1449:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1450:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1450:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1451:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_39); 

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

            otherlv_3=(Token)match(input,20,FOLLOW_40); 

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
                    	    
                    pushFollow(FOLLOW_41);
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

                        if ( (LA30_0==25) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalRoom.g:1489:4: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,25,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // InternalRoom.g:1493:1: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1494:1: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1494:1: (lv_arguments_6_0= ruleVarDecl )
                    	    // InternalRoom.g:1495:3: lv_arguments_6_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_41);
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

            otherlv_7=(Token)match(input,21,FOLLOW_42); 

                	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
                
            // InternalRoom.g:1515:1: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==16) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRoom.g:1515:3: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_43); 

                        	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                        
                    // InternalRoom.g:1519:1: (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==38) ) {
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
                            otherlv_9=(Token)match(input,38,FOLLOW_44); 

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
                            	    
                            pushFollow(FOLLOW_44);
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

            if ( (LA34_0==34) ) {
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
                    	    
                    pushFollow(FOLLOW_45);
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
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // InternalRoom.g:1603:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1604:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1604:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1605:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_39); 

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

            otherlv_2=(Token)match(input,20,FOLLOW_40); 

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
                    	    
                    pushFollow(FOLLOW_41);
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

                        if ( (LA35_0==25) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalRoom.g:1643:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalRoom.g:1647:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1648:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1648:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // InternalRoom.g:1649:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_41);
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

            otherlv_6=(Token)match(input,21,FOLLOW_46); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // InternalRoom.g:1669:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            else if ( (LA38_0==39) ) {
                alt38=2;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoom.g:1669:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    {
                    // InternalRoom.g:1669:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    // InternalRoom.g:1669:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_43); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // InternalRoom.g:1673:1: (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==38) ) {
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
                            otherlv_8=(Token)match(input,38,FOLLOW_44); 

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
                            	    
                            pushFollow(FOLLOW_44);
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
                    otherlv_10=(Token)match(input,39,FOLLOW_3); 

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
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_44); 

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

            if ( (LA39_0==34) ) {
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
                    	    
                    pushFollow(FOLLOW_45);
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

            if ( (LA40_0==40) ) {
                alt40=1;
            }
            else if ( (LA40_0==41) ) {
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
                    lv_name_0_1=(Token)match(input,40,FOLLOW_45); 

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
                    lv_name_0_2=(Token)match(input,41,FOLLOW_45); 

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

            if ( (LA41_0==42||(LA41_0>=124 && LA41_0<=126)) ) {
                alt41=1;
            }
            else if ( (LA41_0==48) ) {
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

            if ( ((LA42_0>=124 && LA42_0<=126)) ) {
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
                    	    
                    pushFollow(FOLLOW_47);
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

            otherlv_1=(Token)match(input,42,FOLLOW_3); 

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

            if ( (LA43_0==34) ) {
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

            if ( (LA44_0==29) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoom.g:1938:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_3); 

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

            otherlv_6=(Token)match(input,14,FOLLOW_48); 

                	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:1961:1: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==108) ) {
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
            	    	    
            	    pushFollow(FOLLOW_48);
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

            if ( (LA46_0==30) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRoom.g:1979:5: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_49); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                        
                    // InternalRoom.g:1983:1: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // InternalRoom.g:1984:1: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1984:1: (lv_userCode1_9_0= ruleDetailCode )
                    // InternalRoom.g:1985:3: lv_userCode1_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_50);
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

            if ( (LA47_0==31) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRoom.g:2001:6: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,31,FOLLOW_51); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                        
                    // InternalRoom.g:2005:1: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // InternalRoom.g:2006:1: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2006:1: (lv_userCode2_11_0= ruleDetailCode )
                    // InternalRoom.g:2007:3: lv_userCode2_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_52);
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

            if ( (LA48_0==32) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRoom.g:2023:6: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,32,FOLLOW_53); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                        
                    // InternalRoom.g:2027:1: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // InternalRoom.g:2028:1: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2028:1: (lv_userCode3_13_0= ruleDetailCode )
                    // InternalRoom.g:2029:3: lv_userCode3_13_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_54);
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

            if ( (LA50_0==43) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRoom.g:2045:6: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,43,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,14,FOLLOW_55); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // InternalRoom.g:2053:1: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( ((LA49_0>=50 && LA49_0<=51)) ) {
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
                    	    	    
                    	    pushFollow(FOLLOW_55);
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

                    otherlv_17=(Token)match(input,15,FOLLOW_56); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2075:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoom.g:2075:5: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,44,FOLLOW_5); 

                        	newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                        
                    otherlv_19=(Token)match(input,14,FOLLOW_55); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // InternalRoom.g:2083:1: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=50 && LA51_0<=51)) ) {
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
                    	    	    
                    	    pushFollow(FOLLOW_55);
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

                    otherlv_21=(Token)match(input,15,FOLLOW_57); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2105:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==45) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRoom.g:2105:5: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,45,FOLLOW_58); 

                        	newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                        
                    otherlv_23=(Token)match(input,46,FOLLOW_5); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                        
                    // InternalRoom.g:2113:1: ( (lv_regular_24_0= rulePortClass ) )
                    // InternalRoom.g:2114:1: (lv_regular_24_0= rulePortClass )
                    {
                    // InternalRoom.g:2114:1: (lv_regular_24_0= rulePortClass )
                    // InternalRoom.g:2115:3: lv_regular_24_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FOLLOW_59);
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

            if ( (LA54_0==47) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRoom.g:2131:6: otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,47,FOLLOW_58); 

                        	newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugatedKeyword_13_0());
                        
                    otherlv_26=(Token)match(input,46,FOLLOW_5); 

                        	newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                        
                    // InternalRoom.g:2139:1: ( (lv_conjugated_27_0= rulePortClass ) )
                    // InternalRoom.g:2140:1: (lv_conjugated_27_0= rulePortClass )
                    {
                    // InternalRoom.g:2140:1: (lv_conjugated_27_0= rulePortClass )
                    // InternalRoom.g:2141:3: lv_conjugated_27_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatedPortClassParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FOLLOW_60);
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

            if ( (LA55_0==105) ) {
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
                    	    
                    pushFollow(FOLLOW_61);
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

            otherlv_29=(Token)match(input,15,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

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

            if ( (LA56_0==34) ) {
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

            otherlv_3=(Token)match(input,14,FOLLOW_62); 

                	newLeafNode(otherlv_3, grammarAccess.getCompoundProtocolClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:2244:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==108) ) {
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
            	    	    
            	    pushFollow(FOLLOW_62);
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

                if ( (LA58_0==49) ) {
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
            	    	    
            	    pushFollow(FOLLOW_63);
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

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

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
    // InternalRoom.g:2363:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token lv_priv_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_data_4_0 = null;

        EObject lv_annotations_6_0 = null;

        EObject lv_docu_7_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2366:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:2367:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:2367:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:2367:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_data_4_0= ruleVarDecl ) )? otherlv_5= ')' ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:2367:2: ( (lv_priv_0_0= 'private' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==50) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRoom.g:2368:1: (lv_priv_0_0= 'private' )
                    {
                    // InternalRoom.g:2368:1: (lv_priv_0_0= 'private' )
                    // InternalRoom.g:2369:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,50,FOLLOW_64); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,51,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // InternalRoom.g:2386:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:2387:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:2387:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:2388:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_39); 

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

            otherlv_3=(Token)match(input,20,FOLLOW_40); 

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

            otherlv_5=(Token)match(input,21,FOLLOW_65); 

                	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_5());
                
            // InternalRoom.g:2430:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==108) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalRoom.g:2431:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2431:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:2432:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_65);
            	    lv_annotations_6_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMessageRule());
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
            	    break loop61;
                }
            } while (true);

            // InternalRoom.g:2448:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==34) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRoom.g:2449:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2449:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:2450:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_7_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMessageRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_7_0, 
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
    // InternalRoom.g:2474:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // InternalRoom.g:2475:2: (iv_rulePortClass= rulePortClass EOF )
            // InternalRoom.g:2476:2: iv_rulePortClass= rulePortClass EOF
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
    // InternalRoom.g:2483:1: rulePortClass returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:2486:28: ( ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:2487:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:2487:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            // InternalRoom.g:2487:2: () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:2487:2: ()
            // InternalRoom.g:2488:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassAccess().getPortClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_66); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:2497:1: (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==52) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRoom.g:2497:3: otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_67); 

                        	newLeafNode(otherlv_2, grammarAccess.getPortClassAccess().getUsercodeKeyword_2_0());
                        
                    // InternalRoom.g:2501:1: ( (lv_userCode_3_0= ruleDetailCode ) )
                    // InternalRoom.g:2502:1: (lv_userCode_3_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2502:1: (lv_userCode_3_0= ruleDetailCode )
                    // InternalRoom.g:2503:3: lv_userCode_3_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_68);
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

            // InternalRoom.g:2519:4: ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )*
            loop64:
            do {
                int alt64=4;
                switch ( input.LA(1) ) {
                case 53:
                    {
                    alt64=1;
                    }
                    break;
                case 37:
                    {
                    alt64=2;
                    }
                    break;
                case 33:
                    {
                    alt64=3;
                    }
                    break;

                }

                switch (alt64) {
            	case 1 :
            	    // InternalRoom.g:2519:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    {
            	    // InternalRoom.g:2519:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    // InternalRoom.g:2520:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    {
            	    // InternalRoom.g:2520:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    // InternalRoom.g:2521:3: lv_msgHandlers_4_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_68);
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
            	    // InternalRoom.g:2538:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    {
            	    // InternalRoom.g:2538:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    // InternalRoom.g:2539:1: (lv_operations_5_0= rulePortOperation )
            	    {
            	    // InternalRoom.g:2539:1: (lv_operations_5_0= rulePortOperation )
            	    // InternalRoom.g:2540:3: lv_operations_5_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_68);
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
            	    // InternalRoom.g:2557:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:2557:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    // InternalRoom.g:2558:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:2558:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalRoom.g:2559:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_68);
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
            	    break loop64;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:2587:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // InternalRoom.g:2588:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // InternalRoom.g:2589:2: iv_ruleMessageHandler= ruleMessageHandler EOF
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
    // InternalRoom.g:2596:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2599:28: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // InternalRoom.g:2600:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // InternalRoom.g:2600:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==53) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==44) ) {
                    alt65=2;
                }
                else if ( (LA65_1==43) ) {
                    alt65=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalRoom.g:2601:5: this_InMessageHandler_0= ruleInMessageHandler
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
                    // InternalRoom.g:2611:5: this_OutMessageHandler_1= ruleOutMessageHandler
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
    // InternalRoom.g:2627:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // InternalRoom.g:2628:2: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // InternalRoom.g:2629:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
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
    // InternalRoom.g:2636:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2639:28: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2640:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2640:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2640:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_69); 

                	newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,43,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
                
            // InternalRoom.g:2648:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2649:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2649:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2650:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_45); 

            		newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2661:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2662:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2662:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2663:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2687:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // InternalRoom.g:2688:2: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // InternalRoom.g:2689:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
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
    // InternalRoom.g:2696:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2699:28: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2700:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2700:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2700:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_70); 

                	newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
                
            // InternalRoom.g:2708:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2709:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2709:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2710:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_45); 

            		newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2721:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2722:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2722:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2723:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2747:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalRoom.g:2748:2: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalRoom.g:2749:2: iv_ruleModelComponent= ruleModelComponent EOF
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
    // InternalRoom.g:2756:1: ruleModelComponent returns [EObject current=null] : this_ActorClass_0= ruleActorClass ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2759:28: (this_ActorClass_0= ruleActorClass )
            // InternalRoom.g:2761:5: this_ActorClass_0= ruleActorClass
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
    // InternalRoom.g:2777:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // InternalRoom.g:2778:2: (iv_ruleActorClass= ruleActorClass EOF )
            // InternalRoom.g:2779:2: iv_ruleActorClass= ruleActorClass EOF
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
    // InternalRoom.g:2786:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) ;
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
            // InternalRoom.g:2789:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalRoom.g:2790:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalRoom.g:2790:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            // InternalRoom.g:2790:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}'
            {
            // InternalRoom.g:2790:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalRoom.g:2792:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalRoom.g:2792:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalRoom.g:2793:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	
            // InternalRoom.g:2796:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalRoom.g:2797:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalRoom.g:2797:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( LA66_0 == 54 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt66=1;
                }
                else if ( ( LA66_0 >= 124 && LA66_0 <= 126 || LA66_0 == 128 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalRoom.g:2799:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalRoom.g:2799:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalRoom.g:2800:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalRoom.g:2800:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalRoom.g:2801:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // InternalRoom.g:2804:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalRoom.g:2804:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2804:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalRoom.g:2805:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalRoom.g:2805:1: (lv_abstract_1_0= 'abstract' )
            	    // InternalRoom.g:2806:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,54,FOLLOW_71); 

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
            	    // InternalRoom.g:2826:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalRoom.g:2826:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalRoom.g:2827:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalRoom.g:2827:107: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalRoom.g:2828:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // InternalRoom.g:2831:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalRoom.g:2831:7: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2831:16: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalRoom.g:2832:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalRoom.g:2832:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalRoom.g:2833:3: lv_commType_2_0= ruleComponentCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_71);
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
            	    break loop66;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,55,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // InternalRoom.g:2867:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalRoom.g:2868:1: (lv_name_4_0= RULE_ID )
            {
            // InternalRoom.g:2868:1: (lv_name_4_0= RULE_ID )
            // InternalRoom.g:2869:3: lv_name_4_0= RULE_ID
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

            // InternalRoom.g:2885:2: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==34) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRoom.g:2886:1: (lv_docu_5_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2886:1: (lv_docu_5_0= ruleDocumentation )
                    // InternalRoom.g:2887:3: lv_docu_5_0= ruleDocumentation
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

            // InternalRoom.g:2903:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==29) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRoom.g:2903:5: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:2907:1: ( ( ruleFQN ) )
                    // InternalRoom.g:2908:1: ( ruleFQN )
                    {
                    // InternalRoom.g:2908:1: ( ruleFQN )
                    // InternalRoom.g:2909:3: ruleFQN
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

            otherlv_8=(Token)match(input,14,FOLLOW_72); 

                	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:2926:1: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==108) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalRoom.g:2927:1: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2927:1: (lv_annotations_9_0= ruleAnnotation )
            	    // InternalRoom.g:2928:3: lv_annotations_9_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
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
            	    break loop69;
                }
            } while (true);

            // InternalRoom.g:2944:3: (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==56) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRoom.g:2944:5: otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,56,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,14,FOLLOW_73); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // InternalRoom.g:2952:1: ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )*
                    loop70:
                    do {
                        int alt70=3;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==62) ) {
                            alt70=1;
                        }
                        else if ( (LA70_0==47||LA70_0==59) ) {
                            alt70=2;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalRoom.g:2952:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    {
                    	    // InternalRoom.g:2952:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    // InternalRoom.g:2953:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    {
                    	    // InternalRoom.g:2953:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    // InternalRoom.g:2954:3: lv_serviceProvisionPoints_12_0= ruleSPP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceProvisionPointsSPPParserRuleCall_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_73);
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
                    	    // InternalRoom.g:2971:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:2971:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    // InternalRoom.g:2972:1: (lv_interfacePorts_13_0= rulePort )
                    	    {
                    	    // InternalRoom.g:2972:1: (lv_interfacePorts_13_0= rulePort )
                    	    // InternalRoom.g:2973:3: lv_interfacePorts_13_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInterfacePortsPortParserRuleCall_7_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_73);
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
                    	    break loop70;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FOLLOW_74); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2993:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==57) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRoom.g:2993:5: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,57,FOLLOW_4); 

                        	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                        
                    // InternalRoom.g:2997:1: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==34) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalRoom.g:2998:1: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // InternalRoom.g:2998:1: (lv_structureDocu_16_0= ruleDocumentation )
                            // InternalRoom.g:2999:3: lv_structureDocu_16_0= ruleDocumentation
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

                    otherlv_17=(Token)match(input,14,FOLLOW_75); 

                        	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // InternalRoom.g:3019:1: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==30) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalRoom.g:3019:3: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,30,FOLLOW_76); 

                                	newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                                
                            // InternalRoom.g:3023:1: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // InternalRoom.g:3024:1: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3024:1: (lv_userCode1_19_0= ruleDetailCode )
                            // InternalRoom.g:3025:3: lv_userCode1_19_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_77);
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

                    // InternalRoom.g:3041:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==31) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalRoom.g:3041:6: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,31,FOLLOW_78); 

                                	newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                                
                            // InternalRoom.g:3045:1: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // InternalRoom.g:3046:1: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3046:1: (lv_userCode2_21_0= ruleDetailCode )
                            // InternalRoom.g:3047:3: lv_userCode2_21_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_79);
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

                    // InternalRoom.g:3063:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==32) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalRoom.g:3063:6: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,32,FOLLOW_80); 

                                	newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                                
                            // InternalRoom.g:3067:1: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // InternalRoom.g:3068:1: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3068:1: (lv_userCode3_23_0= ruleDetailCode )
                            // InternalRoom.g:3069:3: lv_userCode3_23_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_8_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_81);
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

                    // InternalRoom.g:3085:4: ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )*
                    loop76:
                    do {
                        int alt76=9;
                        switch ( input.LA(1) ) {
                        case 74:
                            {
                            alt76=1;
                            }
                            break;
                        case 70:
                            {
                            alt76=2;
                            }
                            break;
                        case 63:
                            {
                            alt76=3;
                            }
                            break;
                        case 33:
                            {
                            alt76=4;
                            }
                            break;
                        case 77:
                        case 111:
                        case 127:
                            {
                            alt76=5;
                            }
                            break;
                        case 61:
                            {
                            alt76=6;
                            }
                            break;
                        case 47:
                        case 59:
                            {
                            alt76=7;
                            }
                            break;
                        case 60:
                            {
                            alt76=8;
                            }
                            break;

                        }

                        switch (alt76) {
                    	case 1 :
                    	    // InternalRoom.g:3085:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    {
                    	    // InternalRoom.g:3085:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    // InternalRoom.g:3086:1: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // InternalRoom.g:3086:1: (lv_connections_24_0= ruleLayerConnection )
                    	    // InternalRoom.g:3087:3: lv_connections_24_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_8_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3104:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    {
                    	    // InternalRoom.g:3104:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    // InternalRoom.g:3105:1: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // InternalRoom.g:3105:1: (lv_bindings_25_0= ruleBinding )
                    	    // InternalRoom.g:3106:3: lv_bindings_25_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_8_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3123:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    {
                    	    // InternalRoom.g:3123:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    // InternalRoom.g:3124:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // InternalRoom.g:3124:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // InternalRoom.g:3125:3: lv_serviceImplementations_26_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_8_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3142:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    {
                    	    // InternalRoom.g:3142:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    // InternalRoom.g:3143:1: (lv_attributes_27_0= ruleAttribute )
                    	    {
                    	    // InternalRoom.g:3143:1: (lv_attributes_27_0= ruleAttribute )
                    	    // InternalRoom.g:3144:3: lv_attributes_27_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_8_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3161:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    {
                    	    // InternalRoom.g:3161:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    // InternalRoom.g:3162:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    {
                    	    // InternalRoom.g:3162:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    // InternalRoom.g:3163:3: lv_actorRefs_28_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_8_6_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3180:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    {
                    	    // InternalRoom.g:3180:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    // InternalRoom.g:3181:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    {
                    	    // InternalRoom.g:3181:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    // InternalRoom.g:3182:3: lv_serviceAccessPoints_29_0= ruleSAP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceAccessPointsSAPParserRuleCall_8_6_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3199:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3199:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    // InternalRoom.g:3200:1: (lv_internalPorts_30_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3200:1: (lv_internalPorts_30_0= rulePort )
                    	    // InternalRoom.g:3201:3: lv_internalPorts_30_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInternalPortsPortParserRuleCall_8_6_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    // InternalRoom.g:3218:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    {
                    	    // InternalRoom.g:3218:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    // InternalRoom.g:3219:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    {
                    	    // InternalRoom.g:3219:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    // InternalRoom.g:3220:3: lv_externalPorts_31_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExternalPortsExternalPortParserRuleCall_8_6_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_81);
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
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,15,FOLLOW_82); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7());
                        

                    }
                    break;

            }

            // InternalRoom.g:3240:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==58) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalRoom.g:3240:5: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}'
                    {
                    otherlv_33=(Token)match(input,58,FOLLOW_4); 

                        	newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                        
                    // InternalRoom.g:3244:1: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==34) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalRoom.g:3245:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3245:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // InternalRoom.g:3246:3: lv_behaviorDocu_34_0= ruleDocumentation
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

                    otherlv_35=(Token)match(input,14,FOLLOW_83); 

                        	newLeafNode(otherlv_35, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2());
                        
                    // InternalRoom.g:3266:1: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==108) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalRoom.g:3267:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:3267:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // InternalRoom.g:3268:3: lv_behaviorAnnotations_36_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorAnnotationsAnnotationParserRuleCall_9_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    break loop79;
                        }
                    } while (true);

                    // InternalRoom.g:3284:3: ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )*
                    loop80:
                    do {
                        int alt80=3;
                        int LA80_0 = input.LA(1);

                        if ( ((LA80_0>=36 && LA80_0<=37)) ) {
                            alt80=1;
                        }
                        else if ( ((LA80_0>=40 && LA80_0<=41)) ) {
                            alt80=2;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // InternalRoom.g:3284:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    {
                    	    // InternalRoom.g:3284:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    // InternalRoom.g:3285:1: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // InternalRoom.g:3285:1: (lv_operations_37_0= ruleStandardOperation )
                    	    // InternalRoom.g:3286:3: lv_operations_37_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_9_4_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_84);
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
                    	    // InternalRoom.g:3303:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    {
                    	    // InternalRoom.g:3303:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    // InternalRoom.g:3304:1: (lv_structors_38_0= ruleClassStructor )
                    	    {
                    	    // InternalRoom.g:3304:1: (lv_structors_38_0= ruleClassStructor )
                    	    // InternalRoom.g:3305:3: lv_structors_38_0= ruleClassStructor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStructorsClassStructorParserRuleCall_9_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_84);
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
                    	    break loop80;
                        }
                    } while (true);

                    // InternalRoom.g:3321:4: ( (lv_stateMachine_39_0= ruleStateMachine ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==80) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRoom.g:3322:1: (lv_stateMachine_39_0= ruleStateMachine )
                            {
                            // InternalRoom.g:3322:1: (lv_stateMachine_39_0= ruleStateMachine )
                            // InternalRoom.g:3323:3: lv_stateMachine_39_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_9_5_0()); 
                            	    
                            pushFollow(FOLLOW_61);
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

                    otherlv_40=(Token)match(input,15,FOLLOW_61); 

                        	newLeafNode(otherlv_40, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_9_6());
                        

                    }
                    break;

            }

            otherlv_41=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:3355:1: entryRuleInterfaceItem returns [EObject current=null] : iv_ruleInterfaceItem= ruleInterfaceItem EOF ;
    public final EObject entryRuleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceItem = null;


        try {
            // InternalRoom.g:3356:2: (iv_ruleInterfaceItem= ruleInterfaceItem EOF )
            // InternalRoom.g:3357:2: iv_ruleInterfaceItem= ruleInterfaceItem EOF
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
    // InternalRoom.g:3364:1: ruleInterfaceItem returns [EObject current=null] : (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) ;
    public final EObject ruleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_SAP_1 = null;

        EObject this_SPP_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3367:28: ( (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) )
            // InternalRoom.g:3368:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            {
            // InternalRoom.g:3368:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            int alt83=3;
            switch ( input.LA(1) ) {
            case 47:
            case 59:
                {
                alt83=1;
                }
                break;
            case 61:
                {
                alt83=2;
                }
                break;
            case 62:
                {
                alt83=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalRoom.g:3369:5: this_Port_0= rulePort
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
                    // InternalRoom.g:3379:5: this_SAP_1= ruleSAP
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
                    // InternalRoom.g:3389:5: this_SPP_2= ruleSPP
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
    // InternalRoom.g:3405:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalRoom.g:3406:2: (iv_rulePort= rulePort EOF )
            // InternalRoom.g:3407:2: iv_rulePort= rulePort EOF
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
    // InternalRoom.g:3414:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_conjugated_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_multiplicity_3_0 = null;

        EObject lv_annotations_6_0 = null;

        EObject lv_docu_7_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3417:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3418:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3418:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:3418:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:3418:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==47) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalRoom.g:3419:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // InternalRoom.g:3419:1: (lv_conjugated_0_0= 'conjugated' )
                    // InternalRoom.g:3420:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,47,FOLLOW_85); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,59,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3437:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:3438:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:3438:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:3439:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            // InternalRoom.g:3455:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==34) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRoom.g:3456:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:3456:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:3457:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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

            otherlv_4=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getPortAccess().getColonKeyword_4());
                
            // InternalRoom.g:3477:1: ( ( ruleFQN ) )
            // InternalRoom.g:3478:1: ( ruleFQN )
            {
            // InternalRoom.g:3478:1: ( ruleFQN )
            // InternalRoom.g:3479:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolGeneralProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_65);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3492:2: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==108) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalRoom.g:3493:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3493:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:3494:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_65);
            	    lv_annotations_6_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPortRule());
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
            	    break loop86;
                }
            } while (true);

            // InternalRoom.g:3510:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==34) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRoom.g:3511:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3511:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:3512:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_7_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRule());
                    	        }
                           		set(
                           			current, 
                           			"docu",
                            		lv_docu_7_0, 
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
    // InternalRoom.g:3536:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // InternalRoom.g:3537:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // InternalRoom.g:3538:2: iv_ruleExternalPort= ruleExternalPort EOF
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
    // InternalRoom.g:3545:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3548:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3549:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3549:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3549:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_85); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,59,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3557:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3558:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3558:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3559:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3578:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // InternalRoom.g:3579:2: (iv_ruleSAP= ruleSAP EOF )
            // InternalRoom.g:3580:2: iv_ruleSAP= ruleSAP EOF
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
    // InternalRoom.g:3587:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3590:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:3591:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:3591:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:3591:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                
            // InternalRoom.g:3595:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3596:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3596:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3597:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSAPAccess().getColonKeyword_2());
                
            // InternalRoom.g:3617:1: ( ( ruleFQN ) )
            // InternalRoom.g:3618:1: ( ruleFQN )
            {
            // InternalRoom.g:3618:1: ( ruleFQN )
            // InternalRoom.g:3619:3: ruleFQN
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
    // InternalRoom.g:3640:1: entryRuleSPP returns [EObject current=null] : iv_ruleSPP= ruleSPP EOF ;
    public final EObject entryRuleSPP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPP = null;


        try {
            // InternalRoom.g:3641:2: (iv_ruleSPP= ruleSPP EOF )
            // InternalRoom.g:3642:2: iv_ruleSPP= ruleSPP EOF
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
    // InternalRoom.g:3649:1: ruleSPP returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSPP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3652:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:3653:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:3653:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:3653:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPAccess().getSPPKeyword_0());
                
            // InternalRoom.g:3657:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3658:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3658:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3659:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSPPAccess().getColonKeyword_2());
                
            // InternalRoom.g:3679:1: ( ( ruleFQN ) )
            // InternalRoom.g:3680:1: ( ruleFQN )
            {
            // InternalRoom.g:3680:1: ( ruleFQN )
            // InternalRoom.g:3681:3: ruleFQN
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
    // InternalRoom.g:3702:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // InternalRoom.g:3703:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // InternalRoom.g:3704:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
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
    // InternalRoom.g:3711:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3714:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3715:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3715:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3715:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_86); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // InternalRoom.g:3723:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3724:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3724:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3725:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3744:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // InternalRoom.g:3745:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // InternalRoom.g:3746:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
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
    // InternalRoom.g:3753:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:3756:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:3757:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:3757:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            // InternalRoom.g:3757:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // InternalRoom.g:3761:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3762:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3762:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3763:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:3779:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==34) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRoom.g:3780:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3780:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3781:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_87); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:3801:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==108) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalRoom.g:3802:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3802:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3803:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_87);
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
            	    break loop89;
                }
            } while (true);

            // InternalRoom.g:3819:3: ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )*
            loop90:
            do {
                int alt90=4;
                switch ( input.LA(1) ) {
                case 74:
                    {
                    alt90=1;
                    }
                    break;
                case 70:
                    {
                    alt90=2;
                    }
                    break;
                case 65:
                    {
                    alt90=3;
                    }
                    break;

                }

                switch (alt90) {
            	case 1 :
            	    // InternalRoom.g:3819:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:3819:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    // InternalRoom.g:3820:1: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:3820:1: (lv_connections_5_0= ruleLayerConnection )
            	    // InternalRoom.g:3821:3: lv_connections_5_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_88);
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
            	    // InternalRoom.g:3838:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:3838:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    // InternalRoom.g:3839:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // InternalRoom.g:3839:1: (lv_bindings_6_0= ruleBinding )
            	    // InternalRoom.g:3840:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_88);
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
            	    // InternalRoom.g:3857:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    {
            	    // InternalRoom.g:3857:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    // InternalRoom.g:3858:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    {
            	    // InternalRoom.g:3858:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    // InternalRoom.g:3859:3: lv_subSystems_7_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_88);
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
            	    break loop90;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:3889:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // InternalRoom.g:3890:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // InternalRoom.g:3891:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
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
    // InternalRoom.g:3898:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3901:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3902:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3902:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3902:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // InternalRoom.g:3906:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3907:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3907:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3908:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSubSystemRefAccess().getColonKeyword_2());
                
            // InternalRoom.g:3928:1: ( ( ruleFQN ) )
            // InternalRoom.g:3929:1: ( ruleFQN )
            {
            // InternalRoom.g:3929:1: ( ruleFQN )
            // InternalRoom.g:3930:3: ruleFQN
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

            // InternalRoom.g:3943:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==34) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRoom.g:3944:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3944:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3945:3: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3969:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // InternalRoom.g:3970:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // InternalRoom.g:3971:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
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
    // InternalRoom.g:3978:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) ;
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
            // InternalRoom.g:3981:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) )
            // InternalRoom.g:3982:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            {
            // InternalRoom.g:3982:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            // InternalRoom.g:3982:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // InternalRoom.g:3986:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3987:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3987:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3988:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:4004:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==34) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalRoom.g:4005:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4005:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:4006:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_89); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:4026:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==108) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalRoom.g:4027:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:4027:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:4028:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_89);
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
            	    break loop93;
                }
            } while (true);

            // InternalRoom.g:4044:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==30) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalRoom.g:4044:5: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_90); 

                        	newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                        
                    // InternalRoom.g:4048:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // InternalRoom.g:4049:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4049:1: (lv_userCode1_6_0= ruleDetailCode )
                    // InternalRoom.g:4050:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_91);
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

            // InternalRoom.g:4066:4: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==31) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalRoom.g:4066:6: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_92); 

                        	newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                        
                    // InternalRoom.g:4070:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // InternalRoom.g:4071:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4071:1: (lv_userCode2_8_0= ruleDetailCode )
                    // InternalRoom.g:4072:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_93);
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

            // InternalRoom.g:4088:4: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==32) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalRoom.g:4088:6: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,32,FOLLOW_94); 

                        	newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                        
                    // InternalRoom.g:4092:1: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // InternalRoom.g:4093:1: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4093:1: (lv_userCode3_10_0= ruleDetailCode )
                    // InternalRoom.g:4094:3: lv_userCode3_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_95);
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

            // InternalRoom.g:4110:4: ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )*
            loop97:
            do {
                int alt97=8;
                switch ( input.LA(1) ) {
                case 68:
                    {
                    alt97=1;
                    }
                    break;
                case 67:
                    {
                    alt97=2;
                    }
                    break;
                case 74:
                    {
                    alt97=3;
                    }
                    break;
                case 70:
                    {
                    alt97=4;
                    }
                    break;
                case 77:
                case 111:
                case 127:
                    {
                    alt97=5;
                    }
                    break;
                case 62:
                    {
                    alt97=6;
                    }
                    break;
                case 47:
                case 59:
                    {
                    alt97=7;
                    }
                    break;

                }

                switch (alt97) {
            	case 1 :
            	    // InternalRoom.g:4110:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    {
            	    // InternalRoom.g:4110:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    // InternalRoom.g:4111:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    {
            	    // InternalRoom.g:4111:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    // InternalRoom.g:4112:3: lv_actorInstanceMappings_11_0= ruleActorInstanceMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4129:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    {
            	    // InternalRoom.g:4129:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    // InternalRoom.g:4130:1: (lv_threads_12_0= ruleLogicalThread )
            	    {
            	    // InternalRoom.g:4130:1: (lv_threads_12_0= ruleLogicalThread )
            	    // InternalRoom.g:4131:3: lv_threads_12_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4148:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:4148:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    // InternalRoom.g:4149:1: (lv_connections_13_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:4149:1: (lv_connections_13_0= ruleLayerConnection )
            	    // InternalRoom.g:4150:3: lv_connections_13_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4167:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:4167:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    // InternalRoom.g:4168:1: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // InternalRoom.g:4168:1: (lv_bindings_14_0= ruleBinding )
            	    // InternalRoom.g:4169:3: lv_bindings_14_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_8_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4186:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    {
            	    // InternalRoom.g:4186:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    // InternalRoom.g:4187:1: (lv_actorRefs_15_0= ruleActorRef )
            	    {
            	    // InternalRoom.g:4187:1: (lv_actorRefs_15_0= ruleActorRef )
            	    // InternalRoom.g:4188:3: lv_actorRefs_15_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_8_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4205:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    {
            	    // InternalRoom.g:4205:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    // InternalRoom.g:4206:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    {
            	    // InternalRoom.g:4206:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    // InternalRoom.g:4207:3: lv_serviceProvisionPoints_16_0= ruleSPP
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getServiceProvisionPointsSPPParserRuleCall_8_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    // InternalRoom.g:4224:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    {
            	    // InternalRoom.g:4224:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    // InternalRoom.g:4225:1: (lv_relayPorts_17_0= rulePort )
            	    {
            	    // InternalRoom.g:4225:1: (lv_relayPorts_17_0= rulePort )
            	    // InternalRoom.g:4226:3: lv_relayPorts_17_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_8_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_95);
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
            	    break loop97;
                }
            } while (true);

            otherlv_18=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:4254:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // InternalRoom.g:4255:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // InternalRoom.g:4256:2: iv_ruleLogicalThread= ruleLogicalThread EOF
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
    // InternalRoom.g:4263:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4266:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:4267:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:4267:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:4267:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // InternalRoom.g:4271:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4272:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4272:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4273:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:4297:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // InternalRoom.g:4298:2: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // InternalRoom.g:4299:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
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
    // InternalRoom.g:4306:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
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
            // InternalRoom.g:4309:28: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // InternalRoom.g:4310:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // InternalRoom.g:4310:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // InternalRoom.g:4310:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
                
            // InternalRoom.g:4314:1: ( (lv_path_1_0= ruleRefPath ) )
            // InternalRoom.g:4315:1: (lv_path_1_0= ruleRefPath )
            {
            // InternalRoom.g:4315:1: (lv_path_1_0= ruleRefPath )
            // InternalRoom.g:4316:3: lv_path_1_0= ruleRefPath
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

            otherlv_2=(Token)match(input,19,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalRoom.g:4336:1: ( (otherlv_3= RULE_ID ) )
            // InternalRoom.g:4337:1: (otherlv_3= RULE_ID )
            {
            // InternalRoom.g:4337:1: (otherlv_3= RULE_ID )
            // InternalRoom.g:4338:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_96); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadLogicalThreadCrossReference_3_0()); 
            	

            }


            }

            // InternalRoom.g:4349:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==14) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalRoom.g:4349:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_97); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalRoom.g:4353:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==68) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalRoom.g:4354:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // InternalRoom.g:4354:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // InternalRoom.g:4355:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_97);
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
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:4383:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalRoom.g:4384:2: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalRoom.g:4385:2: iv_ruleRefPath= ruleRefPath EOF
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
    // InternalRoom.g:4392:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4395:28: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalRoom.g:4396:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalRoom.g:4396:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalRoom.g:4396:2: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalRoom.g:4396:2: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalRoom.g:4397:1: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalRoom.g:4397:1: (lv_refs_0_0= ruleRefSegment )
            // InternalRoom.g:4398:3: lv_refs_0_0= ruleRefSegment
            {
             
            	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_98);
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

            // InternalRoom.g:4414:2: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==69) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalRoom.g:4414:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,69,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // InternalRoom.g:4418:1: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalRoom.g:4419:1: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalRoom.g:4419:1: (lv_refs_2_0= ruleRefSegment )
            	    // InternalRoom.g:4420:3: lv_refs_2_0= ruleRefSegment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_98);
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
            	    break loop100;
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
    // InternalRoom.g:4444:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalRoom.g:4445:2: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalRoom.g:4446:2: iv_ruleRefSegment= ruleRefSegment EOF
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
    // InternalRoom.g:4453:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4456:28: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalRoom.g:4457:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalRoom.g:4457:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalRoom.g:4457:2: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalRoom.g:4457:2: ( (lv_ref_0_0= RULE_ID ) )
            // InternalRoom.g:4458:1: (lv_ref_0_0= RULE_ID )
            {
            // InternalRoom.g:4458:1: (lv_ref_0_0= RULE_ID )
            // InternalRoom.g:4459:3: lv_ref_0_0= RULE_ID
            {
            lv_ref_0_0=(Token)match(input,RULE_ID,FOLLOW_99); 

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

            // InternalRoom.g:4475:2: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==16) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalRoom.g:4475:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_34); 

                        	newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                        
                    // InternalRoom.g:4479:1: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalRoom.g:4480:1: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalRoom.g:4480:1: (lv_idx_2_0= RULE_INT )
                    // InternalRoom.g:4481:3: lv_idx_2_0= RULE_INT
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
    // InternalRoom.g:4505:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalRoom.g:4506:2: (iv_ruleBinding= ruleBinding EOF )
            // InternalRoom.g:4507:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalRoom.g:4514:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4517:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // InternalRoom.g:4518:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // InternalRoom.g:4518:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // InternalRoom.g:4518:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // InternalRoom.g:4522:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4523:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4523:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // InternalRoom.g:4524:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_100);
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

            otherlv_2=(Token)match(input,71,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // InternalRoom.g:4544:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4545:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4545:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // InternalRoom.g:4546:3: lv_endpoint2_3_0= ruleBindingEndPoint
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
    // InternalRoom.g:4570:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // InternalRoom.g:4571:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // InternalRoom.g:4572:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
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
    // InternalRoom.g:4579:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4582:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalRoom.g:4583:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalRoom.g:4583:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalRoom.g:4583:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalRoom.g:4583:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_ID) ) {
                int LA102_1 = input.LA(2);

                if ( (LA102_1==72) ) {
                    alt102=1;
                }
            }
            switch (alt102) {
                case 1 :
                    // InternalRoom.g:4583:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalRoom.g:4583:3: ( (otherlv_0= RULE_ID ) )
                    // InternalRoom.g:4584:1: (otherlv_0= RULE_ID )
                    {
                    // InternalRoom.g:4584:1: (otherlv_0= RULE_ID )
                    // InternalRoom.g:4585:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_101); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,72,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:4600:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4601:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4601:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4602:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_102); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // InternalRoom.g:4613:2: (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==73) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalRoom.g:4613:4: otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,73,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getBindingEndPointAccess().getSubKeyword_2_0());
                        
                    // InternalRoom.g:4617:1: ( (otherlv_4= RULE_ID ) )
                    // InternalRoom.g:4618:1: (otherlv_4= RULE_ID )
                    {
                    // InternalRoom.g:4618:1: (otherlv_4= RULE_ID )
                    // InternalRoom.g:4619:3: otherlv_4= RULE_ID
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
    // InternalRoom.g:4638:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // InternalRoom.g:4639:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // InternalRoom.g:4640:2: iv_ruleLayerConnection= ruleLayerConnection EOF
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
    // InternalRoom.g:4647:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4650:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // InternalRoom.g:4651:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // InternalRoom.g:4651:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // InternalRoom.g:4651:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_103); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // InternalRoom.g:4655:1: ( (lv_from_1_0= ruleSAPoint ) )
            // InternalRoom.g:4656:1: (lv_from_1_0= ruleSAPoint )
            {
            // InternalRoom.g:4656:1: (lv_from_1_0= ruleSAPoint )
            // InternalRoom.g:4657:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_104);
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

            otherlv_2=(Token)match(input,75,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // InternalRoom.g:4677:1: ( (lv_to_3_0= ruleSPPoint ) )
            // InternalRoom.g:4678:1: (lv_to_3_0= ruleSPPoint )
            {
            // InternalRoom.g:4678:1: (lv_to_3_0= ruleSPPoint )
            // InternalRoom.g:4679:3: lv_to_3_0= ruleSPPoint
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
    // InternalRoom.g:4703:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // InternalRoom.g:4704:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // InternalRoom.g:4705:2: iv_ruleSAPoint= ruleSAPoint EOF
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
    // InternalRoom.g:4712:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4715:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // InternalRoom.g:4716:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // InternalRoom.g:4716:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==17) ) {
                alt104=1;
            }
            else if ( (LA104_0==76) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // InternalRoom.g:4717:5: this_RefSAPoint_0= ruleRefSAPoint
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
                    // InternalRoom.g:4727:5: this_RelaySAPoint_1= ruleRelaySAPoint
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
    // InternalRoom.g:4743:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // InternalRoom.g:4744:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // InternalRoom.g:4745:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
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
    // InternalRoom.g:4752:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4755:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4756:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4756:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4756:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // InternalRoom.g:4760:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4761:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4761:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4762:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4781:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // InternalRoom.g:4782:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // InternalRoom.g:4783:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
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
    // InternalRoom.g:4790:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4793:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4794:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4794:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4794:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // InternalRoom.g:4798:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4799:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4799:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4800:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4819:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // InternalRoom.g:4820:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // InternalRoom.g:4821:2: iv_ruleSPPoint= ruleSPPoint EOF
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
    // InternalRoom.g:4828:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4831:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4832:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4832:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4832:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4832:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:4833:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:4833:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:4834:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_101); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // InternalRoom.g:4849:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4850:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4850:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4851:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:4870:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // InternalRoom.g:4871:2: (iv_ruleActorRef= ruleActorRef EOF )
            // InternalRoom.g:4872:2: iv_ruleActorRef= ruleActorRef EOF
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
    // InternalRoom.g:4879:1: ruleActorRef returns [EObject current=null] : ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:4882:28: ( ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4883:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4883:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:4883:2: ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:4883:2: ( (lv_refType_0_0= ruleReferenceType ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==111||LA105_0==127) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalRoom.g:4884:1: (lv_refType_0_0= ruleReferenceType )
                    {
                    // InternalRoom.g:4884:1: (lv_refType_0_0= ruleReferenceType )
                    // InternalRoom.g:4885:3: lv_refType_0_0= ruleReferenceType
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getRefTypeReferenceTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_105);
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

            otherlv_1=(Token)match(input,77,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getActorRefAccess().getActorRefKeyword_1());
                
            // InternalRoom.g:4905:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:4906:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:4906:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:4907:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            // InternalRoom.g:4923:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==34) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalRoom.g:4924:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:4924:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:4925:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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

            otherlv_4=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getActorRefAccess().getColonKeyword_4());
                
            // InternalRoom.g:4945:1: ( ( ruleFQN ) )
            // InternalRoom.g:4946:1: ( ruleFQN )
            {
            // InternalRoom.g:4946:1: ( ruleFQN )
            // InternalRoom.g:4947:3: ruleFQN
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

            // InternalRoom.g:4960:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==34) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalRoom.g:4961:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4961:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:4962:3: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:4988:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // InternalRoom.g:4989:2: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // InternalRoom.g:4990:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
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
    // InternalRoom.g:4997:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5000:28: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // InternalRoom.g:5001:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // InternalRoom.g:5001:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // InternalRoom.g:5002:2: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,34,FOLLOW_106); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0()); 
                
            // InternalRoom.g:5007:1: (kw= '*' | this_INT_2= RULE_INT )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==78) ) {
                alt108=1;
            }
            else if ( (LA108_0==RULE_INT) ) {
                alt108=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // InternalRoom.g:5008:2: kw= '*'
                    {
                    kw=(Token)match(input,78,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5014:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_35); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getMULTIPLICITYAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,35,FOLLOW_2); 

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
    // InternalRoom.g:5035:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalRoom.g:5036:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalRoom.g:5037:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalRoom.g:5044:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5047:28: ( (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' ) )
            // InternalRoom.g:5048:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' )
            {
            // InternalRoom.g:5048:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' )
            int alt109=9;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt109=1;
                }
                break;
            case 55:
                {
                alt109=2;
                }
                break;
            case 79:
                {
                alt109=3;
                }
                break;
            case 42:
                {
                alt109=4;
                }
                break;
            case 48:
                {
                alt109=5;
                }
                break;
            case 66:
                {
                alt109=6;
                }
                break;
            case 64:
                {
                alt109=7;
                }
                break;
            case 59:
                {
                alt109=8;
                }
                break;
            case 51:
                {
                alt109=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalRoom.g:5049:2: kw= 'DataClass'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getDataClassKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5056:2: kw= 'ActorClass'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorClassKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:5063:2: kw= 'ActorBehavior'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorBehaviorKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalRoom.g:5070:2: kw= 'ProtocolClass'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getProtocolClassKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalRoom.g:5077:2: kw= 'CompoundProtocolClass'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getCompoundProtocolClassKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalRoom.g:5084:2: kw= 'SubSystemClass'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getSubSystemClassKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalRoom.g:5091:2: kw= 'LogicalSystem'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getLogicalSystemKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalRoom.g:5098:2: kw= 'Port'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getPortKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalRoom.g:5105:2: kw= 'Message'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getMessageKeyword_8()); 
                        

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
    // InternalRoom.g:5120:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalRoom.g:5121:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalRoom.g:5122:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
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
    // InternalRoom.g:5129:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5132:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalRoom.g:5133:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalRoom.g:5133:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt110=3;
            switch ( input.LA(1) ) {
            case 81:
            case 86:
                {
                alt110=1;
                }
                break;
            case 91:
                {
                alt110=2;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt110=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalRoom.g:5134:5: this_State_0= ruleState
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
                    // InternalRoom.g:5144:5: this_ChoicePoint_1= ruleChoicePoint
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
                    // InternalRoom.g:5154:5: this_TrPoint_2= ruleTrPoint
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
    // InternalRoom.g:5172:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalRoom.g:5173:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalRoom.g:5174:2: iv_ruleStateGraph= ruleStateGraph EOF
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
    // InternalRoom.g:5181:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:5184:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:5185:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:5185:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalRoom.g:5185:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:5185:2: ()
            // InternalRoom.g:5186:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_107); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:5195:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop111:
            do {
                int alt111=6;
                switch ( input.LA(1) ) {
                case 81:
                case 86:
                    {
                    alt111=1;
                    }
                    break;
                case 87:
                case 88:
                case 89:
                case 90:
                    {
                    alt111=2;
                    }
                    break;
                case 91:
                    {
                    alt111=3;
                    }
                    break;
                case 92:
                    {
                    alt111=4;
                    }
                    break;
                case 99:
                    {
                    alt111=5;
                    }
                    break;

                }

                switch (alt111) {
            	case 1 :
            	    // InternalRoom.g:5195:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5195:2: ( (lv_states_2_0= ruleState ) )
            	    // InternalRoom.g:5196:1: (lv_states_2_0= ruleState )
            	    {
            	    // InternalRoom.g:5196:1: (lv_states_2_0= ruleState )
            	    // InternalRoom.g:5197:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5214:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5214:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalRoom.g:5215:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5215:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalRoom.g:5216:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5233:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5233:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5234:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5234:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalRoom.g:5235:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5252:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5252:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalRoom.g:5253:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5253:1: (lv_transitions_5_0= ruleTransition )
            	    // InternalRoom.g:5254:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5271:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5271:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5272:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5272:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalRoom.g:5273:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    break loop111;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5301:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRoom.g:5302:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRoom.g:5303:2: iv_ruleStateMachine= ruleStateMachine EOF
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
    // InternalRoom.g:5310:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:5313:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:5314:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:5314:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalRoom.g:5314:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalRoom.g:5314:2: ()
            // InternalRoom.g:5315:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,80,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_107); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:5328:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop112:
            do {
                int alt112=6;
                switch ( input.LA(1) ) {
                case 81:
                case 86:
                    {
                    alt112=1;
                    }
                    break;
                case 87:
                case 88:
                case 89:
                case 90:
                    {
                    alt112=2;
                    }
                    break;
                case 91:
                    {
                    alt112=3;
                    }
                    break;
                case 92:
                    {
                    alt112=4;
                    }
                    break;
                case 99:
                    {
                    alt112=5;
                    }
                    break;

                }

                switch (alt112) {
            	case 1 :
            	    // InternalRoom.g:5328:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5328:2: ( (lv_states_3_0= ruleState ) )
            	    // InternalRoom.g:5329:1: (lv_states_3_0= ruleState )
            	    {
            	    // InternalRoom.g:5329:1: (lv_states_3_0= ruleState )
            	    // InternalRoom.g:5330:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5347:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5347:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalRoom.g:5348:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5348:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalRoom.g:5349:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5366:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5366:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5367:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5367:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalRoom.g:5368:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5385:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5385:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalRoom.g:5386:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5386:1: (lv_transitions_6_0= ruleTransition )
            	    // InternalRoom.g:5387:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    // InternalRoom.g:5404:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5404:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5405:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5405:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalRoom.g:5406:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_107);
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
            	    break loop112;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5434:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRoom.g:5435:2: (iv_ruleState= ruleState EOF )
            // InternalRoom.g:5436:2: iv_ruleState= ruleState EOF
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
    // InternalRoom.g:5443:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5446:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalRoom.g:5447:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalRoom.g:5447:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==81) ) {
                alt113=1;
            }
            else if ( (LA113_0==86) ) {
                alt113=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }
            switch (alt113) {
                case 1 :
                    // InternalRoom.g:5448:5: this_SimpleState_0= ruleSimpleState
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
                    // InternalRoom.g:5458:5: this_RefinedState_1= ruleRefinedState
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
    // InternalRoom.g:5474:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalRoom.g:5475:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalRoom.g:5476:2: iv_ruleSimpleState= ruleSimpleState EOF
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
    // InternalRoom.g:5483:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) ;
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
            // InternalRoom.g:5486:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? ) )
            // InternalRoom.g:5487:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            {
            // InternalRoom.g:5487:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )? )
            // InternalRoom.g:5487:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // InternalRoom.g:5491:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5492:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5492:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5493:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_108); 

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

            // InternalRoom.g:5509:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==34) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalRoom.g:5510:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5510:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5511:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_96);
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

            // InternalRoom.g:5527:3: (otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==14) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalRoom.g:5527:5: otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_109); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalRoom.g:5531:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==82) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalRoom.g:5531:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                            {
                            otherlv_4=(Token)match(input,82,FOLLOW_110); 

                                	newLeafNode(otherlv_4, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_1_0());
                                
                            // InternalRoom.g:5535:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                            // InternalRoom.g:5536:1: (lv_entryCode_5_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5536:1: (lv_entryCode_5_0= ruleDetailCode )
                            // InternalRoom.g:5537:3: lv_entryCode_5_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_111);
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

                    // InternalRoom.g:5553:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==83) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalRoom.g:5553:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                            {
                            otherlv_6=(Token)match(input,83,FOLLOW_112); 

                                	newLeafNode(otherlv_6, grammarAccess.getSimpleStateAccess().getExitKeyword_3_2_0());
                                
                            // InternalRoom.g:5557:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                            // InternalRoom.g:5558:1: (lv_exitCode_7_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5558:1: (lv_exitCode_7_0= ruleDetailCode )
                            // InternalRoom.g:5559:3: lv_exitCode_7_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_113);
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

                    // InternalRoom.g:5575:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==84) ) {
                        alt117=1;
                    }
                    switch (alt117) {
                        case 1 :
                            // InternalRoom.g:5575:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,84,FOLLOW_114); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDoKeyword_3_3_0());
                                
                            // InternalRoom.g:5579:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                            // InternalRoom.g:5580:1: (lv_doCode_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5580:1: (lv_doCode_9_0= ruleDetailCode )
                            // InternalRoom.g:5581:3: lv_doCode_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_115);
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

                    // InternalRoom.g:5597:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==85) ) {
                        alt118=1;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalRoom.g:5597:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                            {
                            otherlv_10=(Token)match(input,85,FOLLOW_5); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_4_0());
                                
                            // InternalRoom.g:5601:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                            // InternalRoom.g:5602:1: (lv_subgraph_11_0= ruleStateGraph )
                            {
                            // InternalRoom.g:5602:1: (lv_subgraph_11_0= ruleStateGraph )
                            // InternalRoom.g:5603:3: lv_subgraph_11_0= ruleStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_61);
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

                    otherlv_12=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5631:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalRoom.g:5632:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalRoom.g:5633:2: iv_ruleRefinedState= ruleRefinedState EOF
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
    // InternalRoom.g:5640:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:5643:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:5644:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:5644:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}' )
            // InternalRoom.g:5644:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )? (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )? (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )? (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // InternalRoom.g:5648:1: ( ( ruleFQN ) )
            // InternalRoom.g:5649:1: ( ruleFQN )
            {
            // InternalRoom.g:5649:1: ( ruleFQN )
            // InternalRoom.g:5650:3: ruleFQN
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

            // InternalRoom.g:5663:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==34) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalRoom.g:5664:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5664:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5665:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_109); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:5685:1: (otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==82) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalRoom.g:5685:3: otherlv_4= 'entry' ( (lv_entryCode_5_0= ruleDetailCode ) )
                    {
                    otherlv_4=(Token)match(input,82,FOLLOW_110); 

                        	newLeafNode(otherlv_4, grammarAccess.getRefinedStateAccess().getEntryKeyword_4_0());
                        
                    // InternalRoom.g:5689:1: ( (lv_entryCode_5_0= ruleDetailCode ) )
                    // InternalRoom.g:5690:1: (lv_entryCode_5_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5690:1: (lv_entryCode_5_0= ruleDetailCode )
                    // InternalRoom.g:5691:3: lv_entryCode_5_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_111);
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

            // InternalRoom.g:5707:4: (otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==83) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalRoom.g:5707:6: otherlv_6= 'exit' ( (lv_exitCode_7_0= ruleDetailCode ) )
                    {
                    otherlv_6=(Token)match(input,83,FOLLOW_112); 

                        	newLeafNode(otherlv_6, grammarAccess.getRefinedStateAccess().getExitKeyword_5_0());
                        
                    // InternalRoom.g:5711:1: ( (lv_exitCode_7_0= ruleDetailCode ) )
                    // InternalRoom.g:5712:1: (lv_exitCode_7_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5712:1: (lv_exitCode_7_0= ruleDetailCode )
                    // InternalRoom.g:5713:3: lv_exitCode_7_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_113);
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

            // InternalRoom.g:5729:4: (otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==84) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalRoom.g:5729:6: otherlv_8= 'do' ( (lv_doCode_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,84,FOLLOW_114); 

                        	newLeafNode(otherlv_8, grammarAccess.getRefinedStateAccess().getDoKeyword_6_0());
                        
                    // InternalRoom.g:5733:1: ( (lv_doCode_9_0= ruleDetailCode ) )
                    // InternalRoom.g:5734:1: (lv_doCode_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5734:1: (lv_doCode_9_0= ruleDetailCode )
                    // InternalRoom.g:5735:3: lv_doCode_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_115);
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

            // InternalRoom.g:5751:4: (otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==85) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalRoom.g:5751:6: otherlv_10= 'subgraph' ( (lv_subgraph_11_0= ruleStateGraph ) )
                    {
                    otherlv_10=(Token)match(input,85,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_7_0());
                        
                    // InternalRoom.g:5755:1: ( (lv_subgraph_11_0= ruleStateGraph ) )
                    // InternalRoom.g:5756:1: (lv_subgraph_11_0= ruleStateGraph )
                    {
                    // InternalRoom.g:5756:1: (lv_subgraph_11_0= ruleStateGraph )
                    // InternalRoom.g:5757:3: lv_subgraph_11_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_61);
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

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5785:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalRoom.g:5786:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalRoom.g:5787:2: iv_ruleDetailCode= ruleDetailCode EOF
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
    // InternalRoom.g:5794:1: ruleDetailCode returns [EObject current=null] : ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_lines_1_0=null;
        Token lv_used_2_0=null;
        Token lv_lines_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5797:28: ( ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) )
            // InternalRoom.g:5798:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            {
            // InternalRoom.g:5798:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==EOF||LA127_0==RULE_CC_STRING||LA127_0==15||(LA127_0>=31 && LA127_0<=33)||(LA127_0>=36 && LA127_0<=37)||(LA127_0>=40 && LA127_0<=41)||(LA127_0>=43 && LA127_0<=45)||LA127_0==47||LA127_0==53||(LA127_0>=59 && LA127_0<=63)||(LA127_0>=67 && LA127_0<=68)||LA127_0==70||LA127_0==74||LA127_0==77||LA127_0==80||(LA127_0>=83 && LA127_0<=85)||LA127_0==94||(LA127_0>=104 && LA127_0<=105)||LA127_0==111||LA127_0==127) ) {
                alt127=1;
            }
            else if ( (LA127_0==14) ) {
                alt127=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // InternalRoom.g:5798:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    {
                    // InternalRoom.g:5798:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    // InternalRoom.g:5798:3: () ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    {
                    // InternalRoom.g:5798:3: ()
                    // InternalRoom.g:5799:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getDetailCodeAccess().getDetailCodeAction_0_0(),
                                current);
                        

                    }

                    // InternalRoom.g:5804:2: ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==RULE_CC_STRING) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // InternalRoom.g:5805:1: (lv_lines_1_0= RULE_CC_STRING )
                            {
                            // InternalRoom.g:5805:1: (lv_lines_1_0= RULE_CC_STRING )
                            // InternalRoom.g:5806:3: lv_lines_1_0= RULE_CC_STRING
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
                    // InternalRoom.g:5823:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    {
                    // InternalRoom.g:5823:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    // InternalRoom.g:5823:7: ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}'
                    {
                    // InternalRoom.g:5823:7: ( (lv_used_2_0= '{' ) )
                    // InternalRoom.g:5824:1: (lv_used_2_0= '{' )
                    {
                    // InternalRoom.g:5824:1: (lv_used_2_0= '{' )
                    // InternalRoom.g:5825:3: lv_used_2_0= '{'
                    {
                    lv_used_2_0=(Token)match(input,14,FOLLOW_116); 

                            newLeafNode(lv_used_2_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDetailCodeRule());
                    	        }
                           		setWithLastConsumed(current, "used", true, "{");
                    	    

                    }


                    }

                    // InternalRoom.g:5838:2: ( (lv_lines_3_0= RULE_STRING ) )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==RULE_STRING) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // InternalRoom.g:5839:1: (lv_lines_3_0= RULE_STRING )
                    	    {
                    	    // InternalRoom.g:5839:1: (lv_lines_3_0= RULE_STRING )
                    	    // InternalRoom.g:5840:3: lv_lines_3_0= RULE_STRING
                    	    {
                    	    lv_lines_3_0=(Token)match(input,RULE_STRING,FOLLOW_116); 

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
                    	    break loop126;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5868:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalRoom.g:5869:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalRoom.g:5870:2: iv_ruleTrPoint= ruleTrPoint EOF
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
    // InternalRoom.g:5877:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5880:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalRoom.g:5881:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalRoom.g:5881:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt128=3;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt128=1;
                }
                break;
            case 89:
                {
                alt128=2;
                }
                break;
            case 90:
                {
                alt128=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // InternalRoom.g:5882:5: this_TransitionPoint_0= ruleTransitionPoint
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
                    // InternalRoom.g:5892:5: this_EntryPoint_1= ruleEntryPoint
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
                    // InternalRoom.g:5902:5: this_ExitPoint_2= ruleExitPoint
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
    // InternalRoom.g:5918:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalRoom.g:5919:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalRoom.g:5920:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
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
    // InternalRoom.g:5927:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5930:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalRoom.g:5931:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5931:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalRoom.g:5931:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalRoom.g:5931:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==87) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalRoom.g:5932:1: (lv_handler_0_0= 'handler' )
                    {
                    // InternalRoom.g:5932:1: (lv_handler_0_0= 'handler' )
                    // InternalRoom.g:5933:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,87,FOLLOW_117); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,88,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // InternalRoom.g:5950:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:5951:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:5951:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:5952:3: lv_name_2_0= RULE_ID
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
    // InternalRoom.g:5976:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalRoom.g:5977:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalRoom.g:5978:2: iv_ruleEntryPoint= ruleEntryPoint EOF
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
    // InternalRoom.g:5985:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5988:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:5989:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5989:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:5989:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // InternalRoom.g:5993:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5994:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5994:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5995:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6019:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalRoom.g:6020:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalRoom.g:6021:2: iv_ruleExitPoint= ruleExitPoint EOF
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
    // InternalRoom.g:6028:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6031:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6032:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6032:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6032:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,90,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // InternalRoom.g:6036:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6037:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6037:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6038:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6062:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalRoom.g:6063:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalRoom.g:6064:2: iv_ruleChoicePoint= ruleChoicePoint EOF
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
    // InternalRoom.g:6071:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6074:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:6075:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:6075:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalRoom.g:6075:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,91,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // InternalRoom.g:6079:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6080:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6080:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6081:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:6097:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==34) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalRoom.g:6098:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6098:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6099:3: lv_docu_2_0= ruleDocumentation
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
    // InternalRoom.g:6125:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalRoom.g:6126:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalRoom.g:6127:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalRoom.g:6134:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6137:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalRoom.g:6138:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalRoom.g:6138:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==92) ) {
                int LA131_1 = input.LA(2);

                if ( (LA131_1==RULE_ID) ) {
                    int LA131_2 = input.LA(3);

                    if ( (LA131_2==16) ) {
                        int LA131_3 = input.LA(4);

                        if ( (LA131_3==93) ) {
                            alt131=1;
                        }
                        else if ( (LA131_3==RULE_ID||(LA131_3>=100 && LA131_3<=101)) ) {
                            alt131=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 131, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA131_1==16) ) {
                    int LA131_3 = input.LA(3);

                    if ( (LA131_3==93) ) {
                        alt131=1;
                    }
                    else if ( (LA131_3==RULE_ID||(LA131_3>=100 && LA131_3<=101)) ) {
                        alt131=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalRoom.g:6139:5: this_InitialTransition_0= ruleInitialTransition
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
                    // InternalRoom.g:6149:5: this_NonInitialTransition_1= ruleNonInitialTransition
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
    // InternalRoom.g:6165:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalRoom.g:6166:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalRoom.g:6167:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
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
    // InternalRoom.g:6174:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6177:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalRoom.g:6178:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalRoom.g:6178:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt132=3;
            alt132 = dfa132.predict(input);
            switch (alt132) {
                case 1 :
                    // InternalRoom.g:6179:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
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
                    // InternalRoom.g:6189:5: this_ContinuationTransition_1= ruleContinuationTransition
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
                    // InternalRoom.g:6199:5: this_CPBranchTransition_2= ruleCPBranchTransition
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
    // InternalRoom.g:6215:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalRoom.g:6216:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalRoom.g:6217:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
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
    // InternalRoom.g:6224:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6227:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalRoom.g:6228:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalRoom.g:6228:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt133=2;
            alt133 = dfa133.predict(input);
            switch (alt133) {
                case 1 :
                    // InternalRoom.g:6229:5: this_TriggeredTransition_0= ruleTriggeredTransition
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
                    // InternalRoom.g:6239:5: this_GuardedTransition_1= ruleGuardedTransition
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
    // InternalRoom.g:6255:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalRoom.g:6256:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalRoom.g:6257:2: iv_ruleInitialTransition= ruleInitialTransition EOF
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
    // InternalRoom.g:6264:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // InternalRoom.g:6267:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // InternalRoom.g:6268:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // InternalRoom.g:6268:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // InternalRoom.g:6268:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,92,FOLLOW_118); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6272:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==RULE_ID) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalRoom.g:6273:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6273:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6274:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_119); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,93,FOLLOW_11); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,19,FOLLOW_120); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6302:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6303:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6303:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6304:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_108);
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

            // InternalRoom.g:6320:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==34) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalRoom.g:6321:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6321:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6322:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_96);
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

            // InternalRoom.g:6338:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==14) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalRoom.g:6338:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_121); 

                        	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6342:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt136=2;
                    int LA136_0 = input.LA(1);

                    if ( (LA136_0==94) ) {
                        alt136=1;
                    }
                    switch (alt136) {
                        case 1 :
                            // InternalRoom.g:6342:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,94,FOLLOW_122); 

                                	newLeafNode(otherlv_8, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_1_0());
                                
                            // InternalRoom.g:6346:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // InternalRoom.g:6347:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6347:1: (lv_action_9_0= ruleDetailCode )
                            // InternalRoom.g:6348:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_61);
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

                    otherlv_10=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6376:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalRoom.g:6377:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalRoom.g:6378:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
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
    // InternalRoom.g:6385:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) ;
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
            // InternalRoom.g:6388:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? ) )
            // InternalRoom.g:6389:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            {
            // InternalRoom.g:6389:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )? )
            // InternalRoom.g:6389:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,92,FOLLOW_118); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6393:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==RULE_ID) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalRoom.g:6394:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6394:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6395:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_120); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6415:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6416:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6416:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6417:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,19,FOLLOW_120); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6437:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6438:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6438:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6439:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_108);
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

            // InternalRoom.g:6455:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==34) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // InternalRoom.g:6456:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6456:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6457:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_96);
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

            // InternalRoom.g:6473:3: (otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}' )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==14) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalRoom.g:6473:5: otherlv_7= '{' (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )? otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_121); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6477:1: (otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) ) )?
                    int alt140=2;
                    int LA140_0 = input.LA(1);

                    if ( (LA140_0==94) ) {
                        alt140=1;
                    }
                    switch (alt140) {
                        case 1 :
                            // InternalRoom.g:6477:3: otherlv_8= 'action' ( (lv_action_9_0= ruleDetailCode ) )
                            {
                            otherlv_8=(Token)match(input,94,FOLLOW_122); 

                                	newLeafNode(otherlv_8, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_1_0());
                                
                            // InternalRoom.g:6481:1: ( (lv_action_9_0= ruleDetailCode ) )
                            // InternalRoom.g:6482:1: (lv_action_9_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6482:1: (lv_action_9_0= ruleDetailCode )
                            // InternalRoom.g:6483:3: lv_action_9_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_61);
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

                    otherlv_10=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6511:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalRoom.g:6512:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalRoom.g:6513:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
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
    // InternalRoom.g:6520:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) ;
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
            // InternalRoom.g:6523:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' ) )
            // InternalRoom.g:6524:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            {
            // InternalRoom.g:6524:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}' )
            // InternalRoom.g:6524:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_triggers_10_0= ruleTrigger ) ) (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )* otherlv_13= '}' (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_118); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6528:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==RULE_ID) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalRoom.g:6529:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6529:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6530:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_120); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6550:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6551:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6551:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6552:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,19,FOLLOW_120); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6572:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6573:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6573:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6574:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6590:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==34) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalRoom.g:6591:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6591:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6592:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_123); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,95,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,14,FOLLOW_124); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalRoom.g:6620:1: ( (lv_triggers_10_0= ruleTrigger ) )
            // InternalRoom.g:6621:1: (lv_triggers_10_0= ruleTrigger )
            {
            // InternalRoom.g:6621:1: (lv_triggers_10_0= ruleTrigger )
            // InternalRoom.g:6622:3: lv_triggers_10_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_125);
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

            // InternalRoom.g:6638:2: (otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) ) )*
            loop144:
            do {
                int alt144=2;
                int LA144_0 = input.LA(1);

                if ( (LA144_0==96) ) {
                    alt144=1;
                }


                switch (alt144) {
            	case 1 :
            	    // InternalRoom.g:6638:4: otherlv_11= 'or' ( (lv_triggers_12_0= ruleTrigger ) )
            	    {
            	    otherlv_11=(Token)match(input,96,FOLLOW_124); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_11_0());
            	        
            	    // InternalRoom.g:6642:1: ( (lv_triggers_12_0= ruleTrigger ) )
            	    // InternalRoom.g:6643:1: (lv_triggers_12_0= ruleTrigger )
            	    {
            	    // InternalRoom.g:6643:1: (lv_triggers_12_0= ruleTrigger )
            	    // InternalRoom.g:6644:3: lv_triggers_12_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_125);
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
            	    break loop144;
                }
            } while (true);

            otherlv_13=(Token)match(input,15,FOLLOW_121); 

                	newLeafNode(otherlv_13, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_12());
                
            // InternalRoom.g:6664:1: (otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==94) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalRoom.g:6664:3: otherlv_14= 'action' ( (lv_action_15_0= ruleDetailCode ) )
                    {
                    otherlv_14=(Token)match(input,94,FOLLOW_122); 

                        	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_13_0());
                        
                    // InternalRoom.g:6668:1: ( (lv_action_15_0= ruleDetailCode ) )
                    // InternalRoom.g:6669:1: (lv_action_15_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6669:1: (lv_action_15_0= ruleDetailCode )
                    // InternalRoom.g:6670:3: lv_action_15_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_13_1_0()); 
                    	    
                    pushFollow(FOLLOW_61);
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

            otherlv_16=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6698:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalRoom.g:6699:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalRoom.g:6700:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
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
    // InternalRoom.g:6707:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:6710:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:6711:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:6711:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // InternalRoom.g:6711:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'guard' ( (lv_guard_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_118); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6715:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==RULE_ID) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalRoom.g:6716:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6716:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6717:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_120); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6737:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6738:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6738:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6739:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,19,FOLLOW_120); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6759:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6760:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6760:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6761:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6777:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==34) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalRoom.g:6778:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6778:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6779:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_126); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,97,FOLLOW_127); 

                	newLeafNode(otherlv_8, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_8());
                
            // InternalRoom.g:6803:1: ( (lv_guard_9_0= ruleDetailCode ) )
            // InternalRoom.g:6804:1: (lv_guard_9_0= ruleDetailCode )
            {
            // InternalRoom.g:6804:1: (lv_guard_9_0= ruleDetailCode )
            // InternalRoom.g:6805:3: lv_guard_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_121);
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

            // InternalRoom.g:6821:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==94) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // InternalRoom.g:6821:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,94,FOLLOW_122); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardedTransitionAccess().getActionKeyword_10_0());
                        
                    // InternalRoom.g:6825:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // InternalRoom.g:6826:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6826:1: (lv_action_11_0= ruleDetailCode )
                    // InternalRoom.g:6827:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_61);
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

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6855:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalRoom.g:6856:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalRoom.g:6857:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
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
    // InternalRoom.g:6864:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) ;
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
            // InternalRoom.g:6867:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' ) )
            // InternalRoom.g:6868:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            {
            // InternalRoom.g:6868:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}' )
            // InternalRoom.g:6868:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'cond' ( (lv_condition_9_0= ruleDetailCode ) ) (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_118); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6872:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==RULE_ID) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalRoom.g:6873:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6873:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6874:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_120); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6894:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6895:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6895:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6896:3: lv_from_3_0= ruleTransitionTerminal
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

            otherlv_4=(Token)match(input,19,FOLLOW_120); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6916:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6917:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6917:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6918:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6934:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==34) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalRoom.g:6935:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6935:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6936:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_128); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,98,FOLLOW_127); 

                	newLeafNode(otherlv_8, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_8());
                
            // InternalRoom.g:6960:1: ( (lv_condition_9_0= ruleDetailCode ) )
            // InternalRoom.g:6961:1: (lv_condition_9_0= ruleDetailCode )
            {
            // InternalRoom.g:6961:1: (lv_condition_9_0= ruleDetailCode )
            // InternalRoom.g:6962:3: lv_condition_9_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_121);
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

            // InternalRoom.g:6978:2: (otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==94) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalRoom.g:6978:4: otherlv_10= 'action' ( (lv_action_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,94,FOLLOW_122); 

                        	newLeafNode(otherlv_10, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_10_0());
                        
                    // InternalRoom.g:6982:1: ( (lv_action_11_0= ruleDetailCode ) )
                    // InternalRoom.g:6983:1: (lv_action_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6983:1: (lv_action_11_0= ruleDetailCode )
                    // InternalRoom.g:6984:3: lv_action_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_61);
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

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7012:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalRoom.g:7013:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalRoom.g:7014:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
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
    // InternalRoom.g:7021:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) ;
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
            // InternalRoom.g:7024:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' ) )
            // InternalRoom.g:7025:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            {
            // InternalRoom.g:7025:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}' )
            // InternalRoom.g:7025:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'action' ( (lv_action_5_0= ruleDetailCode ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,99,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // InternalRoom.g:7029:1: ( ( ruleFQN ) )
            // InternalRoom.g:7030:1: ( ruleFQN )
            {
            // InternalRoom.g:7030:1: ( ruleFQN )
            // InternalRoom.g:7031:3: ruleFQN
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

            // InternalRoom.g:7044:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==34) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // InternalRoom.g:7045:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7045:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:7046:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_129); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,94,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getRefinedTransitionAccess().getActionKeyword_4());
                
            // InternalRoom.g:7070:1: ( (lv_action_5_0= ruleDetailCode ) )
            // InternalRoom.g:7071:1: (lv_action_5_0= ruleDetailCode )
            {
            // InternalRoom.g:7071:1: (lv_action_5_0= ruleDetailCode )
            // InternalRoom.g:7072:3: lv_action_5_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_61);
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

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7100:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalRoom.g:7101:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalRoom.g:7102:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
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
    // InternalRoom.g:7109:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7112:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalRoom.g:7113:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalRoom.g:7113:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt153=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA153_1 = input.LA(2);

                if ( (LA153_1==24) ) {
                    alt153=3;
                }
                else if ( (LA153_1==EOF||(LA153_1>=14 && LA153_1<=15)||LA153_1==19||LA153_1==34||LA153_1==81||(LA153_1>=86 && LA153_1<=92)||LA153_1==99) ) {
                    alt153=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 153, 1, input);

                    throw nvae;
                }
                }
                break;
            case 100:
                {
                alt153=2;
                }
                break;
            case 101:
                {
                alt153=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalRoom.g:7114:5: this_StateTerminal_0= ruleStateTerminal
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
                    // InternalRoom.g:7124:5: this_TrPointTerminal_1= ruleTrPointTerminal
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
                    // InternalRoom.g:7134:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
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
                    // InternalRoom.g:7144:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
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
    // InternalRoom.g:7160:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalRoom.g:7161:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalRoom.g:7162:2: iv_ruleStateTerminal= ruleStateTerminal EOF
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
    // InternalRoom.g:7169:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7172:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoom.g:7173:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoom.g:7173:1: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7174:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7174:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7175:3: otherlv_0= RULE_ID
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
    // InternalRoom.g:7194:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalRoom.g:7195:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalRoom.g:7196:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
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
    // InternalRoom.g:7203:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7206:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7207:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7207:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7207:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // InternalRoom.g:7211:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7212:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7212:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7213:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7232:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalRoom.g:7233:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalRoom.g:7234:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
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
    // InternalRoom.g:7241:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7244:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7245:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7245:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7245:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7245:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7246:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7246:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7247:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_86); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // InternalRoom.g:7262:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7263:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7263:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7264:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7283:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalRoom.g:7284:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalRoom.g:7285:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
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
    // InternalRoom.g:7292:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7295:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7296:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7296:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7296:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // InternalRoom.g:7300:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7301:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7301:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7302:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7321:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalRoom.g:7322:2: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalRoom.g:7323:2: iv_ruleTrigger= ruleTrigger EOF
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
    // InternalRoom.g:7330:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalRoom.g:7333:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalRoom.g:7334:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalRoom.g:7334:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalRoom.g:7334:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // InternalRoom.g:7338:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalRoom.g:7339:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalRoom.g:7339:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalRoom.g:7340:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_130);
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

            // InternalRoom.g:7356:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop154:
            do {
                int alt154=2;
                int LA154_0 = input.LA(1);

                if ( (LA154_0==103) ) {
                    alt154=1;
                }


                switch (alt154) {
            	case 1 :
            	    // InternalRoom.g:7356:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,103,FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // InternalRoom.g:7360:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalRoom.g:7361:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalRoom.g:7361:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalRoom.g:7362:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_130);
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
            	    break loop154;
                }
            } while (true);

            // InternalRoom.g:7378:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==97) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // InternalRoom.g:7379:1: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalRoom.g:7379:1: (lv_guard_4_0= ruleGuard )
                    // InternalRoom.g:7380:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_131);
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

            otherlv_5=(Token)match(input,104,FOLLOW_2); 

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
    // InternalRoom.g:7408:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalRoom.g:7409:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalRoom.g:7410:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
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
    // InternalRoom.g:7417:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7420:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7421:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7421:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7421:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7421:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7422:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7422:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7423:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageFromIfRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            		newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageEObjectCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
                
            // InternalRoom.g:7438:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7439:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7439:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7440:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7459:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalRoom.g:7460:2: (iv_ruleGuard= ruleGuard EOF )
            // InternalRoom.g:7461:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalRoom.g:7468:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7471:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:7472:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:7472:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:7472:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_45); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // InternalRoom.g:7476:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalRoom.g:7477:1: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalRoom.g:7477:1: (lv_guard_1_0= ruleDetailCode )
            // InternalRoom.g:7478:3: lv_guard_1_0= ruleDetailCode
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
    // InternalRoom.g:7502:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // InternalRoom.g:7503:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // InternalRoom.g:7504:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
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
    // InternalRoom.g:7511:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7514:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // InternalRoom.g:7515:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // InternalRoom.g:7515:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // InternalRoom.g:7515:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // InternalRoom.g:7515:2: ()
            // InternalRoom.g:7516:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,105,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_132); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:7529:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop156:
            do {
                int alt156=2;
                int LA156_0 = input.LA(1);

                if ( ((LA156_0>=106 && LA156_0<=107)) ) {
                    alt156=1;
                }


                switch (alt156) {
            	case 1 :
            	    // InternalRoom.g:7530:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // InternalRoom.g:7530:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // InternalRoom.g:7531:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_132);
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
            	    break loop156;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7559:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalRoom.g:7560:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalRoom.g:7561:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
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
    // InternalRoom.g:7568:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7571:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalRoom.g:7572:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalRoom.g:7572:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==106) ) {
                alt157=1;
            }
            else if ( (LA157_0==107) ) {
                alt157=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 157, 0, input);

                throw nvae;
            }
            switch (alt157) {
                case 1 :
                    // InternalRoom.g:7573:5: this_InSemanticsRule_0= ruleInSemanticsRule
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
                    // InternalRoom.g:7583:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
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
    // InternalRoom.g:7599:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalRoom.g:7600:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalRoom.g:7601:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
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
    // InternalRoom.g:7608:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7611:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7612:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7612:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7612:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,106,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7620:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7621:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7621:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7622:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_133); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7633:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==19) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalRoom.g:7633:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_134); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7637:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt159=2;
                    int LA159_0 = input.LA(1);

                    if ( ((LA159_0>=106 && LA159_0<=107)) ) {
                        alt159=1;
                    }
                    else if ( (LA159_0==20) ) {
                        alt159=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 159, 0, input);

                        throw nvae;
                    }
                    switch (alt159) {
                        case 1 :
                            // InternalRoom.g:7637:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7637:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7638:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7638:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7639:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7656:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7656:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7656:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,20,FOLLOW_135); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7660:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7661:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7661:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7662:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_136);
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

                            // InternalRoom.g:7678:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt158=0;
                            loop158:
                            do {
                                int alt158=2;
                                int LA158_0 = input.LA(1);

                                if ( (LA158_0==25) ) {
                                    alt158=1;
                                }


                                switch (alt158) {
                            	case 1 :
                            	    // InternalRoom.g:7678:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_135); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7682:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7683:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7683:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7684:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_41);
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
                            	    if ( cnt158 >= 1 ) break loop158;
                                        EarlyExitException eee =
                                            new EarlyExitException(158, input);
                                        throw eee;
                                }
                                cnt158++;
                            } while (true);

                            otherlv_9=(Token)match(input,21,FOLLOW_2); 

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
    // InternalRoom.g:7712:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalRoom.g:7713:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalRoom.g:7714:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
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
    // InternalRoom.g:7721:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7724:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7725:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7725:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7725:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,107,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7733:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7734:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7734:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7735:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_133); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7746:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==19) ) {
                alt163=1;
            }
            switch (alt163) {
                case 1 :
                    // InternalRoom.g:7746:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_134); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7750:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt162=2;
                    int LA162_0 = input.LA(1);

                    if ( ((LA162_0>=106 && LA162_0<=107)) ) {
                        alt162=1;
                    }
                    else if ( (LA162_0==20) ) {
                        alt162=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 162, 0, input);

                        throw nvae;
                    }
                    switch (alt162) {
                        case 1 :
                            // InternalRoom.g:7750:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7750:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7751:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7751:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7752:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7769:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7769:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7769:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,20,FOLLOW_135); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7773:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7774:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7774:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7775:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_136);
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

                            // InternalRoom.g:7791:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt161=0;
                            loop161:
                            do {
                                int alt161=2;
                                int LA161_0 = input.LA(1);

                                if ( (LA161_0==25) ) {
                                    alt161=1;
                                }


                                switch (alt161) {
                            	case 1 :
                            	    // InternalRoom.g:7791:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_135); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7795:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7796:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7796:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7797:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_41);
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
                            	    if ( cnt161 >= 1 ) break loop161;
                                        EarlyExitException eee =
                                            new EarlyExitException(161, input);
                                        throw eee;
                                }
                                cnt161++;
                            } while (true);

                            otherlv_9=(Token)match(input,21,FOLLOW_2); 

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
    // InternalRoom.g:7825:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalRoom.g:7826:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalRoom.g:7827:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalRoom.g:7834:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalRoom.g:7837:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalRoom.g:7838:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalRoom.g:7838:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalRoom.g:7838:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,108,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // InternalRoom.g:7842:1: ( ( ruleFQN ) )
            // InternalRoom.g:7843:1: ( ruleFQN )
            {
            // InternalRoom.g:7843:1: ( ruleFQN )
            // InternalRoom.g:7844:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_137);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:7857:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==20) ) {
                alt165=1;
            }
            switch (alt165) {
                case 1 :
                    // InternalRoom.g:7857:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalRoom.g:7861:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalRoom.g:7862:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalRoom.g:7862:1: (lv_attributes_3_0= ruleKeyValue )
                    // InternalRoom.g:7863:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_41);
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

                    // InternalRoom.g:7879:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop164:
                    do {
                        int alt164=2;
                        int LA164_0 = input.LA(1);

                        if ( (LA164_0==25) ) {
                            alt164=1;
                        }


                        switch (alt164) {
                    	case 1 :
                    	    // InternalRoom.g:7879:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // InternalRoom.g:7883:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalRoom.g:7884:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalRoom.g:7884:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalRoom.g:7885:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_41);
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
                    	    break loop164;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,21,FOLLOW_2); 

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
    // InternalRoom.g:7913:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalRoom.g:7914:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalRoom.g:7915:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalRoom.g:7922:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7925:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalRoom.g:7926:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalRoom.g:7926:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalRoom.g:7926:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalRoom.g:7926:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalRoom.g:7927:1: (lv_key_0_0= RULE_ID )
            {
            // InternalRoom.g:7927:1: (lv_key_0_0= RULE_ID )
            // InternalRoom.g:7928:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_138); 

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

            otherlv_1=(Token)match(input,26,FOLLOW_139); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalRoom.g:7948:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalRoom.g:7949:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalRoom.g:7949:1: (lv_value_2_0= ruleLiteral )
            // InternalRoom.g:7950:3: lv_value_2_0= ruleLiteral
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
    // InternalRoom.g:7974:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // InternalRoom.g:7975:2: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // InternalRoom.g:7976:2: iv_ruleAnnotationType= ruleAnnotationType EOF
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
    // InternalRoom.g:7983:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
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
            // InternalRoom.g:7986:28: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // InternalRoom.g:7987:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // InternalRoom.g:7987:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // InternalRoom.g:7987:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,109,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
                
            // InternalRoom.g:7991:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:7992:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:7992:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:7993:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:8009:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt166=2;
            int LA166_0 = input.LA(1);

            if ( (LA166_0==34) ) {
                alt166=1;
            }
            switch (alt166) {
                case 1 :
                    // InternalRoom.g:8010:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:8010:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:8011:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_140); 

                	newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,110,FOLLOW_138); 

                	newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
                
            otherlv_5=(Token)match(input,26,FOLLOW_141); 

                	newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
                
            // InternalRoom.g:8039:1: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt168=2;
            int LA168_0 = input.LA(1);

            if ( (LA168_0==28||LA168_0==42||LA168_0==48||LA168_0==51||LA168_0==55||LA168_0==59||LA168_0==64||LA168_0==66||LA168_0==79) ) {
                alt168=1;
            }
            else if ( (LA168_0==14) ) {
                alt168=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 168, 0, input);

                throw nvae;
            }
            switch (alt168) {
                case 1 :
                    // InternalRoom.g:8039:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // InternalRoom.g:8039:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8040:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8040:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8041:3: lv_targets_6_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_142);
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
                    // InternalRoom.g:8058:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // InternalRoom.g:8058:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // InternalRoom.g:8058:8: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_143); 

                        	newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                        
                    // InternalRoom.g:8062:1: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8063:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8063:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8064:3: lv_targets_8_0= ruleAnnotationTargetType
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

                    // InternalRoom.g:8080:2: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop167:
                    do {
                        int alt167=2;
                        int LA167_0 = input.LA(1);

                        if ( (LA167_0==25) ) {
                            alt167=1;
                        }


                        switch (alt167) {
                    	case 1 :
                    	    // InternalRoom.g:8080:4: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,25,FOLLOW_143); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	        
                    	    // InternalRoom.g:8084:1: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // InternalRoom.g:8085:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // InternalRoom.g:8085:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // InternalRoom.g:8086:3: lv_targets_10_0= ruleAnnotationTargetType
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
                    	    break loop167;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_142); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                        

                    }


                    }
                    break;

            }

            // InternalRoom.g:8106:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop169:
            do {
                int alt169=2;
                int LA169_0 = input.LA(1);

                if ( ((LA169_0>=111 && LA169_0<=112)) ) {
                    alt169=1;
                }


                switch (alt169) {
            	case 1 :
            	    // InternalRoom.g:8107:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // InternalRoom.g:8107:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // InternalRoom.g:8108:3: lv_attributes_12_0= ruleAnnotationAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_142);
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
            	    break loop169;
                }
            } while (true);

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:8136:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8137:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalRoom.g:8138:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalRoom.g:8145:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8148:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalRoom.g:8149:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalRoom.g:8149:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==111) ) {
                int LA170_1 = input.LA(2);

                if ( (LA170_1==113) ) {
                    int LA170_3 = input.LA(3);

                    if ( (LA170_3==RULE_ID) ) {
                        int LA170_4 = input.LA(4);

                        if ( (LA170_4==16) ) {
                            int LA170_5 = input.LA(5);

                            if ( (LA170_5==14) ) {
                                alt170=2;
                            }
                            else if ( ((LA170_5>=129 && LA170_5<=132)) ) {
                                alt170=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 170, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 170, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 170, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 170, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA170_0==112) ) {
                int LA170_2 = input.LA(2);

                if ( (LA170_2==113) ) {
                    int LA170_3 = input.LA(3);

                    if ( (LA170_3==RULE_ID) ) {
                        int LA170_4 = input.LA(4);

                        if ( (LA170_4==16) ) {
                            int LA170_5 = input.LA(5);

                            if ( (LA170_5==14) ) {
                                alt170=2;
                            }
                            else if ( ((LA170_5>=129 && LA170_5<=132)) ) {
                                alt170=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 170, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 170, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 170, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 170, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 170, 0, input);

                throw nvae;
            }
            switch (alt170) {
                case 1 :
                    // InternalRoom.g:8150:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalRoom.g:8160:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalRoom.g:8176:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8177:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalRoom.g:8178:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalRoom.g:8185:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalRoom.g:8188:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalRoom.g:8189:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalRoom.g:8189:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalRoom.g:8189:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalRoom.g:8189:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==111) ) {
                alt171=1;
            }
            else if ( (LA171_0==112) ) {
                alt171=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // InternalRoom.g:8189:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8189:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8190:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8190:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8191:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,111,FOLLOW_144); 

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
                    // InternalRoom.g:8205:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,112,FOLLOW_144); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,113,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8213:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8214:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8214:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8215:3: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,16,FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalRoom.g:8235:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalRoom.g:8236:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalRoom.g:8236:1: (lv_type_5_0= ruleLiteralType )
            // InternalRoom.g:8237:3: lv_type_5_0= ruleLiteralType
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
    // InternalRoom.g:8261:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalRoom.g:8262:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalRoom.g:8263:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalRoom.g:8270:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalRoom.g:8273:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalRoom.g:8274:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalRoom.g:8274:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalRoom.g:8274:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalRoom.g:8274:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==111) ) {
                alt172=1;
            }
            else if ( (LA172_0==112) ) {
                alt172=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 172, 0, input);

                throw nvae;
            }
            switch (alt172) {
                case 1 :
                    // InternalRoom.g:8274:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8274:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8275:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8275:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8276:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,111,FOLLOW_144); 

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
                    // InternalRoom.g:8290:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,112,FOLLOW_144); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,113,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8298:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8299:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8299:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8300:3: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,16,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_12); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:8324:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalRoom.g:8325:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalRoom.g:8325:1: (lv_values_6_0= RULE_STRING )
            // InternalRoom.g:8326:3: lv_values_6_0= RULE_STRING
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

            // InternalRoom.g:8342:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop173:
            do {
                int alt173=2;
                int LA173_0 = input.LA(1);

                if ( (LA173_0==25) ) {
                    alt173=1;
                }


                switch (alt173) {
            	case 1 :
            	    // InternalRoom.g:8342:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,25,FOLLOW_12); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalRoom.g:8346:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalRoom.g:8347:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8347:1: (lv_values_8_0= RULE_STRING )
            	    // InternalRoom.g:8348:3: lv_values_8_0= RULE_STRING
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
            	    break loop173;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:8376:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoom.g:8377:2: (iv_ruleImport= ruleImport EOF )
            // InternalRoom.g:8378:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoom.g:8385:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8388:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8389:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8389:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalRoom.g:8389:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,114,FOLLOW_145); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalRoom.g:8393:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==RULE_ID) ) {
                alt174=1;
            }
            else if ( (LA174_0==116) ) {
                alt174=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 174, 0, input);

                throw nvae;
            }
            switch (alt174) {
                case 1 :
                    // InternalRoom.g:8393:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalRoom.g:8393:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalRoom.g:8393:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalRoom.g:8393:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalRoom.g:8394:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalRoom.g:8394:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalRoom.g:8395:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_146);
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

                    otherlv_2=(Token)match(input,115,FOLLOW_12); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:8416:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,116,FOLLOW_12); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:8420:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalRoom.g:8421:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalRoom.g:8421:1: (lv_importURI_4_0= RULE_STRING )
            // InternalRoom.g:8422:3: lv_importURI_4_0= RULE_STRING
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
    // InternalRoom.g:8446:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalRoom.g:8447:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalRoom.g:8448:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalRoom.g:8455:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8458:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalRoom.g:8459:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalRoom.g:8459:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalRoom.g:8460:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_147);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalRoom.g:8470:1: (kw= '.*' )?
            int alt175=2;
            int LA175_0 = input.LA(1);

            if ( (LA175_0==117) ) {
                alt175=1;
            }
            switch (alt175) {
                case 1 :
                    // InternalRoom.g:8471:2: kw= '.*'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

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
    // InternalRoom.g:8484:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalRoom.g:8485:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalRoom.g:8486:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalRoom.g:8493:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8496:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalRoom.g:8497:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalRoom.g:8497:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalRoom.g:8497:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalRoom.g:8497:2: ()
            // InternalRoom.g:8498:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,34,FOLLOW_148); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalRoom.g:8507:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop176:
            do {
                int alt176=2;
                int LA176_0 = input.LA(1);

                if ( (LA176_0==RULE_STRING) ) {
                    alt176=1;
                }


                switch (alt176) {
            	case 1 :
            	    // InternalRoom.g:8508:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8508:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:8509:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_148); 

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
            	    break loop176;
                }
            } while (true);

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

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
    // InternalRoom.g:8541:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalRoom.g:8542:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalRoom.g:8543:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalRoom.g:8550:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8553:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalRoom.g:8554:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalRoom.g:8554:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt177=3;
            switch ( input.LA(1) ) {
            case 118:
            case 119:
                {
                alt177=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 120:
            case 121:
                {
                alt177=2;
                }
                break;
            case RULE_STRING:
                {
                alt177=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 177, 0, input);

                throw nvae;
            }

            switch (alt177) {
                case 1 :
                    // InternalRoom.g:8555:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalRoom.g:8565:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalRoom.g:8575:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalRoom.g:8591:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalRoom.g:8592:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalRoom.g:8593:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalRoom.g:8600:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8603:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalRoom.g:8604:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalRoom.g:8604:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalRoom.g:8604:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalRoom.g:8604:2: ()
            // InternalRoom.g:8605:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8610:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==118) ) {
                alt178=1;
            }
            else if ( (LA178_0==119) ) {
                alt178=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 178, 0, input);

                throw nvae;
            }
            switch (alt178) {
                case 1 :
                    // InternalRoom.g:8610:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,118,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8615:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalRoom.g:8615:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalRoom.g:8616:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalRoom.g:8616:1: (lv_isTrue_2_0= 'true' )
                    // InternalRoom.g:8617:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,119,FOLLOW_2); 

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
    // InternalRoom.g:8638:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalRoom.g:8639:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalRoom.g:8640:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalRoom.g:8647:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8650:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalRoom.g:8651:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalRoom.g:8651:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt179=2;
            switch ( input.LA(1) ) {
            case 120:
                {
                int LA179_1 = input.LA(2);

                if ( (LA179_1==RULE_INT) ) {
                    int LA179_3 = input.LA(3);

                    if ( (LA179_3==EOF||LA179_3==21||LA179_3==25) ) {
                        alt179=1;
                    }
                    else if ( (LA179_3==72) ) {
                        alt179=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 179, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 179, 1, input);

                    throw nvae;
                }
                }
                break;
            case 121:
                {
                int LA179_2 = input.LA(2);

                if ( (LA179_2==RULE_INT) ) {
                    int LA179_3 = input.LA(3);

                    if ( (LA179_3==EOF||LA179_3==21||LA179_3==25) ) {
                        alt179=1;
                    }
                    else if ( (LA179_3==72) ) {
                        alt179=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 179, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 179, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA179_3 = input.LA(2);

                if ( (LA179_3==EOF||LA179_3==21||LA179_3==25) ) {
                    alt179=1;
                }
                else if ( (LA179_3==72) ) {
                    alt179=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 179, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt179=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 179, 0, input);

                throw nvae;
            }

            switch (alt179) {
                case 1 :
                    // InternalRoom.g:8652:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalRoom.g:8662:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalRoom.g:8678:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalRoom.g:8679:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalRoom.g:8680:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalRoom.g:8687:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8690:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalRoom.g:8691:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalRoom.g:8691:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalRoom.g:8691:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalRoom.g:8691:2: ()
            // InternalRoom.g:8692:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8697:2: ( (lv_value_1_0= ruleReal ) )
            // InternalRoom.g:8698:1: (lv_value_1_0= ruleReal )
            {
            // InternalRoom.g:8698:1: (lv_value_1_0= ruleReal )
            // InternalRoom.g:8699:3: lv_value_1_0= ruleReal
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
    // InternalRoom.g:8723:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalRoom.g:8724:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalRoom.g:8725:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalRoom.g:8732:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8735:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalRoom.g:8736:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalRoom.g:8736:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalRoom.g:8736:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalRoom.g:8736:2: ()
            // InternalRoom.g:8737:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8742:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalRoom.g:8743:1: (lv_value_1_0= ruleInteger )
            {
            // InternalRoom.g:8743:1: (lv_value_1_0= ruleInteger )
            // InternalRoom.g:8744:3: lv_value_1_0= ruleInteger
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
    // InternalRoom.g:8768:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalRoom.g:8769:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalRoom.g:8770:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalRoom.g:8777:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8780:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8781:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8781:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRoom.g:8781:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRoom.g:8781:2: ()
            // InternalRoom.g:8782:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8787:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRoom.g:8788:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalRoom.g:8788:1: (lv_value_1_0= RULE_STRING )
            // InternalRoom.g:8789:3: lv_value_1_0= RULE_STRING
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
    // InternalRoom.g:8813:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalRoom.g:8814:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalRoom.g:8815:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalRoom.g:8822:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8825:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalRoom.g:8826:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalRoom.g:8826:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt181=2;
            int LA181_0 = input.LA(1);

            if ( (LA181_0==RULE_INT||(LA181_0>=120 && LA181_0<=121)) ) {
                alt181=1;
            }
            else if ( (LA181_0==RULE_HEX) ) {
                alt181=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 181, 0, input);

                throw nvae;
            }
            switch (alt181) {
                case 1 :
                    // InternalRoom.g:8826:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalRoom.g:8826:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalRoom.g:8826:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalRoom.g:8826:3: (kw= '+' | kw= '-' )?
                    int alt180=3;
                    int LA180_0 = input.LA(1);

                    if ( (LA180_0==120) ) {
                        alt180=1;
                    }
                    else if ( (LA180_0==121) ) {
                        alt180=2;
                    }
                    switch (alt180) {
                        case 1 :
                            // InternalRoom.g:8827:2: kw= '+'
                            {
                            kw=(Token)match(input,120,FOLLOW_34); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:8834:2: kw= '-'
                            {
                            kw=(Token)match(input,121,FOLLOW_34); 

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
                    // InternalRoom.g:8847:10: this_HEX_3= RULE_HEX
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
    // InternalRoom.g:8862:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalRoom.g:8863:2: (iv_ruleReal= ruleReal EOF )
            // InternalRoom.g:8864:2: iv_ruleReal= ruleReal EOF
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
    // InternalRoom.g:8871:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8874:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalRoom.g:8875:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalRoom.g:8875:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt182=2;
            switch ( input.LA(1) ) {
            case 120:
                {
                int LA182_1 = input.LA(2);

                if ( (LA182_1==RULE_INT) ) {
                    int LA182_3 = input.LA(3);

                    if ( (LA182_3==72) ) {
                        int LA182_4 = input.LA(4);

                        if ( (LA182_4==RULE_INT) ) {
                            int LA182_5 = input.LA(5);

                            if ( (LA182_5==EOF||LA182_5==21||LA182_5==25) ) {
                                alt182=1;
                            }
                            else if ( ((LA182_5>=122 && LA182_5<=123)) ) {
                                alt182=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 182, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 182, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 182, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 182, 1, input);

                    throw nvae;
                }
                }
                break;
            case 121:
                {
                int LA182_2 = input.LA(2);

                if ( (LA182_2==RULE_INT) ) {
                    int LA182_3 = input.LA(3);

                    if ( (LA182_3==72) ) {
                        int LA182_4 = input.LA(4);

                        if ( (LA182_4==RULE_INT) ) {
                            int LA182_5 = input.LA(5);

                            if ( (LA182_5==EOF||LA182_5==21||LA182_5==25) ) {
                                alt182=1;
                            }
                            else if ( ((LA182_5>=122 && LA182_5<=123)) ) {
                                alt182=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 182, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 182, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 182, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 182, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA182_3 = input.LA(2);

                if ( (LA182_3==72) ) {
                    int LA182_4 = input.LA(3);

                    if ( (LA182_4==RULE_INT) ) {
                        int LA182_5 = input.LA(4);

                        if ( (LA182_5==EOF||LA182_5==21||LA182_5==25) ) {
                            alt182=1;
                        }
                        else if ( ((LA182_5>=122 && LA182_5<=123)) ) {
                            alt182=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 182, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 182, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 182, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);

                throw nvae;
            }

            switch (alt182) {
                case 1 :
                    // InternalRoom.g:8876:5: this_Decimal_0= ruleDecimal
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
                    // InternalRoom.g:8888:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalRoom.g:8906:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:8910:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalRoom.g:8911:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalRoom.g:8921:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:8925:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalRoom.g:8926:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalRoom.g:8926:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalRoom.g:8926:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalRoom.g:8926:2: (kw= '+' | kw= '-' )?
            int alt183=3;
            int LA183_0 = input.LA(1);

            if ( (LA183_0==120) ) {
                alt183=1;
            }
            else if ( (LA183_0==121) ) {
                alt183=2;
            }
            switch (alt183) {
                case 1 :
                    // InternalRoom.g:8927:2: kw= '+'
                    {
                    kw=(Token)match(input,120,FOLLOW_34); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8934:2: kw= '-'
                    {
                    kw=(Token)match(input,121,FOLLOW_34); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_101); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,72,FOLLOW_34); 

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
    // InternalRoom.g:8970:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:8974:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalRoom.g:8975:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalRoom.g:8985:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:8989:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalRoom.g:8990:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalRoom.g:8990:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalRoom.g:8990:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalRoom.g:8990:2: (kw= '+' | kw= '-' )?
            int alt184=3;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==120) ) {
                alt184=1;
            }
            else if ( (LA184_0==121) ) {
                alt184=2;
            }
            switch (alt184) {
                case 1 :
                    // InternalRoom.g:8991:2: kw= '+'
                    {
                    kw=(Token)match(input,120,FOLLOW_34); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8998:2: kw= '-'
                    {
                    kw=(Token)match(input,121,FOLLOW_34); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_101); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,72,FOLLOW_34); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_149); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalRoom.g:9023:1: (kw= 'e' | kw= 'E' )
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==122) ) {
                alt185=1;
            }
            else if ( (LA185_0==123) ) {
                alt185=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }
            switch (alt185) {
                case 1 :
                    // InternalRoom.g:9024:2: kw= 'e'
                    {
                    kw=(Token)match(input,122,FOLLOW_150); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9031:2: kw= 'E'
                    {
                    kw=(Token)match(input,123,FOLLOW_150); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalRoom.g:9036:2: (kw= '+' | kw= '-' )?
            int alt186=3;
            int LA186_0 = input.LA(1);

            if ( (LA186_0==120) ) {
                alt186=1;
            }
            else if ( (LA186_0==121) ) {
                alt186=2;
            }
            switch (alt186) {
                case 1 :
                    // InternalRoom.g:9037:2: kw= '+'
                    {
                    kw=(Token)match(input,120,FOLLOW_34); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9044:2: kw= '-'
                    {
                    kw=(Token)match(input,121,FOLLOW_34); 

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
    // InternalRoom.g:9067:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalRoom.g:9068:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalRoom.g:9069:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalRoom.g:9076:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9079:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoom.g:9080:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoom.g:9080:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoom.g:9080:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_151); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalRoom.g:9087:1: (kw= '.' this_ID_2= RULE_ID )*
            loop187:
            do {
                int alt187=2;
                int LA187_0 = input.LA(1);

                if ( (LA187_0==72) ) {
                    alt187=1;
                }


                switch (alt187) {
            	case 1 :
            	    // InternalRoom.g:9088:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_151); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop187;
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
    // InternalRoom.g:9108:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalRoom.g:9110:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // InternalRoom.g:9111:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // InternalRoom.g:9111:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt188=3;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt188=1;
                }
                break;
            case 125:
                {
                alt188=2;
                }
                break;
            case 126:
                {
                alt188=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 188, 0, input);

                throw nvae;
            }

            switch (alt188) {
                case 1 :
                    // InternalRoom.g:9111:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9111:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9111:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,124,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9117:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9117:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9117:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9123:6: (enumLiteral_2= 'sync' )
                    {
                    // InternalRoom.g:9123:6: (enumLiteral_2= 'sync' )
                    // InternalRoom.g:9123:8: enumLiteral_2= 'sync'
                    {
                    enumLiteral_2=(Token)match(input,126,FOLLOW_2); 

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
    // InternalRoom.g:9133:1: ruleReferenceType returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) ;
    public final Enumerator ruleReferenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalRoom.g:9135:28: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) )
            // InternalRoom.g:9136:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            {
            // InternalRoom.g:9136:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==127) ) {
                alt189=1;
            }
            else if ( (LA189_0==111) ) {
                alt189=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 189, 0, input);

                throw nvae;
            }
            switch (alt189) {
                case 1 :
                    // InternalRoom.g:9136:2: (enumLiteral_0= 'fixed' )
                    {
                    // InternalRoom.g:9136:2: (enumLiteral_0= 'fixed' )
                    // InternalRoom.g:9136:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,127,FOLLOW_2); 

                            current = grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9142:6: (enumLiteral_1= 'optional' )
                    {
                    // InternalRoom.g:9142:6: (enumLiteral_1= 'optional' )
                    // InternalRoom.g:9142:8: enumLiteral_1= 'optional'
                    {
                    enumLiteral_1=(Token)match(input,111,FOLLOW_2); 

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
    // InternalRoom.g:9154:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9156:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalRoom.g:9157:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalRoom.g:9157:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt190=4;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt190=1;
                }
                break;
            case 125:
                {
                alt190=2;
                }
                break;
            case 128:
                {
                alt190=3;
                }
                break;
            case 126:
                {
                alt190=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 190, 0, input);

                throw nvae;
            }

            switch (alt190) {
                case 1 :
                    // InternalRoom.g:9157:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9157:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9157:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,124,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9163:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9163:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9163:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9169:6: (enumLiteral_2= 'async' )
                    {
                    // InternalRoom.g:9169:6: (enumLiteral_2= 'async' )
                    // InternalRoom.g:9169:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,128,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9175:6: (enumLiteral_3= 'sync' )
                    {
                    // InternalRoom.g:9175:6: (enumLiteral_3= 'sync' )
                    // InternalRoom.g:9175:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,126,FOLLOW_2); 

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
    // InternalRoom.g:9185:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9187:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalRoom.g:9188:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalRoom.g:9188:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt191=4;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt191=1;
                }
                break;
            case 130:
                {
                alt191=2;
                }
                break;
            case 131:
                {
                alt191=3;
                }
                break;
            case 132:
                {
                alt191=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 191, 0, input);

                throw nvae;
            }

            switch (alt191) {
                case 1 :
                    // InternalRoom.g:9188:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalRoom.g:9188:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalRoom.g:9188:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,129,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9194:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalRoom.g:9194:6: (enumLiteral_1= 'ptInteger' )
                    // InternalRoom.g:9194:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,130,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9200:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalRoom.g:9200:6: (enumLiteral_2= 'ptReal' )
                    // InternalRoom.g:9200:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,131,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9206:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalRoom.g:9206:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalRoom.g:9206:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,132,FOLLOW_2); 

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
    protected DFA132 dfa132 = new DFA132(this);
    protected DFA133 dfa133 = new DFA133(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\17\5\uffff\3\52\5\uffff";
    static final String dfa_3s = "\1\u0080\5\uffff\3\u0080\5\uffff";
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
    static final String dfa_9s = "\1\134\1\4\1\20\1\4\1\23\4\4\2\23\1\16\2\4\1\23\1\5\1\17\1\uffff\1\4\2\16\1\5\1\16\2\uffff\1\16";
    static final String dfa_10s = "\1\134\2\20\1\145\1\30\2\4\1\145\1\4\2\23\1\143\2\4\1\23\1\43\1\142\1\uffff\1\4\2\143\1\43\1\143\2\uffff\1\143";
    static final String dfa_11s = "\21\uffff\1\2\5\uffff\1\1\1\3\1\uffff";
    static final String dfa_12s = "\32\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\3",
            "\1\4\137\uffff\1\5\1\6",
            "\1\7\4\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\137\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\20\1\21\10\uffff\1\22\11\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25\35\uffff\1\26",
            "\1\21\116\uffff\1\21\1\27\1\uffff\1\27\1\30",
            "",
            "\1\31",
            "\1\20\1\21\22\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\20\1\21\22\uffff\1\17\56\uffff\1\21\4\uffff\7\21\6\uffff\1\21",
            "\1\25\35\uffff\1\26",
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

    class DFA132 extends DFA {

        public DFA132(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 132;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "6178:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_14s = "\31\uffff";
    static final String dfa_15s = "\1\134\1\4\1\20\1\4\1\23\4\4\3\23\1\16\2\4\1\5\1\137\1\4\2\16\1\5\1\16\2\uffff\1\16";
    static final String dfa_16s = "\1\134\2\20\1\145\1\30\3\4\1\145\3\23\1\42\2\4\1\43\1\141\1\4\2\42\1\43\1\16\2\uffff\1\42";
    static final String dfa_17s = "\26\uffff\1\2\1\1\1\uffff";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\3",
            "\1\4\137\uffff\1\5\1\6",
            "\1\10\4\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\137\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\20\11\uffff\1\21\11\uffff\1\17",
            "\1\22",
            "\1\23",
            "\1\24\35\uffff\1\25",
            "\1\27\1\uffff\1\26",
            "\1\30",
            "\1\20\23\uffff\1\17",
            "\1\20\23\uffff\1\17",
            "\1\24\35\uffff\1\25",
            "\1\20",
            "",
            "",
            "\1\20\23\uffff\1\17"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA133 extends DFA {

        public DFA133(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 133;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "6228:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00C1040018848000L,0x7004200000000005L,0x0000000000000001L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00C1040018848000L,0x7000200000000005L,0x0000000000000001L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000001EL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000401004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000140L,0x0300000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000400400002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000420004000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000333C0008000L,0x0000100000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000003338000C080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000033380008000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000003330000C080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000033300008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000003320000C080L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000033200008000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000404000012L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000404000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000400014080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000400004080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008400014080L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000B801C0008000L,0x0000120000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000B8018000C080L,0x0000020000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000B80180008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000B8010000C080L,0x0000020000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000B80100008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000B8000000C080L,0x0000020000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000B80000008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x000C000000008000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000B00000008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000A00000008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000800000008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000008000L,0x0000020000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0002000000008000L,0x0000100000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0002000000008000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000400000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0030033200008000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x002003320000C080L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0020033200008000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x00C0000000000000L,0x7000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0700000000008000L,0x0000100000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x4800800000008000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0600000000008000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xF8008333C0008000L,0x8000800000002440L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xF80083338000C080L,0x8000800000002440L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xF800833380008000L,0x8000800000002440L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0xF80083330000C080L,0x8000800000002440L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0xF800833300008000L,0x8000800000002440L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0xF80083320000C080L,0x8000800000002440L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0xF800833200008000L,0x8000800000002440L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0400000000008000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000033000008000L,0x0000100000010000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000033000008000L,0x0000000000010000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000008000L,0x0000100000000442L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000442L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x48008001C0008000L,0x8000900000002458L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x480080018000C080L,0x8000800000002458L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x4800800180008000L,0x8000800000002458L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x480080010000C080L,0x8000800000002458L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x4800800100008000L,0x8000800000002458L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x480080000000C080L,0x8000800000002458L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x4800800000008000L,0x8000800000002458L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000040L,0x0000000000004000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000008000L,0x000000081FC20000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000400004002L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000008000L,0x00000000003C0000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x000000000000C080L,0x0000000000380000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000008000L,0x0000000000380000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x000000000000C080L,0x0000000000300000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000008000L,0x0000000000300000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x000000000000C080L,0x0000000000200000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000008000L,0x0000000000200000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000010L,0x0000003000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000008000L,0x0000000040000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x000000000000C080L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000008000L,0x0000000100000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x000000000000C080L,0x0000000040000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000000000L,0x0000018200000000L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000008000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0000000000100000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000000000L,0x00000C0000000000L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000000000160L,0x03C0000000000000L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_141 = new BitSet(new long[]{0x0889040010004000L,0x0000000000008005L});
    public static final BitSet FOLLOW_142 = new BitSet(new long[]{0x0000000000008000L,0x0001800000000000L});
    public static final BitSet FOLLOW_143 = new BitSet(new long[]{0x0889040010000000L,0x0000000000008005L});
    public static final BitSet FOLLOW_144 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_145 = new BitSet(new long[]{0x0000000000000010L,0x0010000000000000L});
    public static final BitSet FOLLOW_146 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_147 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_148 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_149 = new BitSet(new long[]{0x0000000000000000L,0x0C00000000000000L});
    public static final BitSet FOLLOW_150 = new BitSet(new long[]{0x0000000000000040L,0x0300000000000000L});
    public static final BitSet FOLLOW_151 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});

}
