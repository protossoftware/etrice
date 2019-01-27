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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_CC_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'varargs'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'Enumeration'", "'of'", "','", "'='", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'override'", "'Operation'", "'void'", "'sends'", "'ctor'", "'dtor'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugated'", "'CompoundProtocolClass'", "'SubProtocol'", "'private'", "'Message'", "'usercode'", "'handle'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'ActorInstanceMapping'", "'/'", "'Binding'", "'and'", "'.'", "'sub'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'*'", "'ActorBehavior'", "'State'", "'Transition'", "'StateMachine'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'semantics'", "'in'", "'out'", "'@'", "'AnnotationType'", "'target'", "'optional'", "'mandatory'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'false'", "'true'", "'+'", "'-'", "'e'", "'E'", "'eventdriven'", "'datadriven'", "'sync'", "'fixed'", "'async'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    public static final int T__133=133;
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

            if ( (LA1_0==35) ) {
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

                if ( (LA2_0==115) ) {
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

            if ( ((LA4_0>=55 && LA4_0<=56)||LA4_0==67||(LA4_0>=125 && LA4_0<=127)||LA4_0==129) ) {
                alt4=1;
            }
            else if ( (LA4_0==65) ) {
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

            if ( ((LA5_0>=55 && LA5_0<=56)||(LA5_0>=125 && LA5_0<=127)||LA5_0==129) ) {
                alt5=1;
            }
            else if ( (LA5_0==67) ) {
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
    // InternalRoom.g:416:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_varargs_3_0=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:419:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) )
            // InternalRoom.g:420:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            {
            // InternalRoom.g:420:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            // InternalRoom.g:420:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )?
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
            	    
            pushFollow(FOLLOW_9);
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

            // InternalRoom.g:460:2: ( (lv_varargs_3_0= 'varargs' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRoom.g:461:1: (lv_varargs_3_0= 'varargs' )
                    {
                    // InternalRoom.g:461:1: (lv_varargs_3_0= 'varargs' )
                    // InternalRoom.g:462:3: lv_varargs_3_0= 'varargs'
                    {
                    lv_varargs_3_0=(Token)match(input,17,FOLLOW_2); 

                            newLeafNode(lv_varargs_3_0, grammarAccess.getVarDeclAccess().getVarargsVarargsKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVarDeclRule());
                    	        }
                           		setWithLastConsumed(current, "varargs", true, "varargs");
                    	    

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


    // $ANTLR start "entryRuleMessageData"
    // InternalRoom.g:483:1: entryRuleMessageData returns [EObject current=null] : iv_ruleMessageData= ruleMessageData EOF ;
    public final EObject entryRuleMessageData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageData = null;


        try {
            // InternalRoom.g:484:2: (iv_ruleMessageData= ruleMessageData EOF )
            // InternalRoom.g:485:2: iv_ruleMessageData= ruleMessageData EOF
            {
             newCompositeNode(grammarAccess.getMessageDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageData=ruleMessageData();

            state._fsp--;

             current =iv_ruleMessageData; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageData"


    // $ANTLR start "ruleMessageData"
    // InternalRoom.g:492:1: ruleMessageData returns [EObject current=null] : ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleMessageData() throws RecognitionException {
        EObject current = null;

        Token lv_deprecatedName_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:495:28: ( ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // InternalRoom.g:496:1: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // InternalRoom.g:496:1: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            // InternalRoom.g:496:2: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) )
            {
            // InternalRoom.g:496:2: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==16) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalRoom.g:496:3: ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':'
                    {
                    // InternalRoom.g:496:3: ( (lv_deprecatedName_0_0= RULE_ID ) )
                    // InternalRoom.g:497:1: (lv_deprecatedName_0_0= RULE_ID )
                    {
                    // InternalRoom.g:497:1: (lv_deprecatedName_0_0= RULE_ID )
                    // InternalRoom.g:498:3: lv_deprecatedName_0_0= RULE_ID
                    {
                    lv_deprecatedName_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    			newLeafNode(lv_deprecatedName_0_0, grammarAccess.getMessageDataAccess().getDeprecatedNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageDataRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"deprecatedName",
                            		lv_deprecatedName_0_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,16,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getMessageDataAccess().getColonKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:518:3: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:519:1: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:519:1: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:520:3: lv_refType_2_0= ruleRefableType
            {
             
            	        newCompositeNode(grammarAccess.getMessageDataAccess().getRefTypeRefableTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_refType_2_0=ruleRefableType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMessageDataRule());
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
    // $ANTLR end "ruleMessageData"


    // $ANTLR start "entryRuleRefableType"
    // InternalRoom.g:544:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // InternalRoom.g:545:2: (iv_ruleRefableType= ruleRefableType EOF )
            // InternalRoom.g:546:2: iv_ruleRefableType= ruleRefableType EOF
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
    // InternalRoom.g:553:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:556:28: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // InternalRoom.g:557:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // InternalRoom.g:557:1: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // InternalRoom.g:557:2: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // InternalRoom.g:557:2: ( ( ruleFQN ) )
            // InternalRoom.g:558:1: ( ruleFQN )
            {
            // InternalRoom.g:558:1: ( ruleFQN )
            // InternalRoom.g:559:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefableTypeRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRefableTypeAccess().getTypeDataTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_10);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:572:2: ( (lv_ref_1_0= 'ref' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoom.g:573:1: (lv_ref_1_0= 'ref' )
                    {
                    // InternalRoom.g:573:1: (lv_ref_1_0= 'ref' )
                    // InternalRoom.g:574:3: lv_ref_1_0= 'ref'
                    {
                    lv_ref_1_0=(Token)match(input,18,FOLLOW_2); 

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
    // InternalRoom.g:595:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalRoom.g:596:2: (iv_ruleDataType= ruleDataType EOF )
            // InternalRoom.g:597:2: iv_ruleDataType= ruleDataType EOF
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
    // InternalRoom.g:604:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_EnumerationType_1 = null;

        EObject this_ComplexType_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:607:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) )
            // InternalRoom.g:608:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            {
            // InternalRoom.g:608:1: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt9=1;
                }
                break;
            case 24:
                {
                alt9=2;
                }
                break;
            case 28:
            case 29:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalRoom.g:609:5: this_PrimitiveType_0= rulePrimitiveType
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
                    // InternalRoom.g:619:5: this_EnumerationType_1= ruleEnumerationType
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
                    // InternalRoom.g:629:5: this_ComplexType_2= ruleComplexType
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
    // InternalRoom.g:645:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalRoom.g:646:2: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalRoom.g:647:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalRoom.g:654:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:657:28: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // InternalRoom.g:658:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // InternalRoom.g:658:1: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            else if ( (LA10_0==28) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalRoom.g:659:5: this_DataClass_0= ruleDataClass
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
                    // InternalRoom.g:669:5: this_ExternalType_1= ruleExternalType
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
    // InternalRoom.g:685:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalRoom.g:686:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalRoom.g:687:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalRoom.g:694:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:697:28: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:698:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:698:1: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            // InternalRoom.g:698:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
                
            // InternalRoom.g:702:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:703:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:703:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:704:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_11); 

                	newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getColonKeyword_2());
                
            // InternalRoom.g:724:1: ( (lv_type_3_0= ruleLiteralType ) )
            // InternalRoom.g:725:1: (lv_type_3_0= ruleLiteralType )
            {
            // InternalRoom.g:725:1: (lv_type_3_0= ruleLiteralType )
            // InternalRoom.g:726:3: lv_type_3_0= ruleLiteralType
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTypeLiteralTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_4=(Token)match(input,20,FOLLOW_13); 

                	newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:746:1: ( (lv_targetName_5_0= RULE_STRING ) )
            // InternalRoom.g:747:1: (lv_targetName_5_0= RULE_STRING )
            {
            // InternalRoom.g:747:1: (lv_targetName_5_0= RULE_STRING )
            // InternalRoom.g:748:3: lv_targetName_5_0= RULE_STRING
            {
            lv_targetName_5_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

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

            // InternalRoom.g:764:2: (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRoom.g:764:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_6_0());
                        
                    // InternalRoom.g:768:1: ( (lv_castName_7_0= ruleFQN ) )
                    // InternalRoom.g:769:1: (lv_castName_7_0= ruleFQN )
                    {
                    // InternalRoom.g:769:1: (lv_castName_7_0= ruleFQN )
                    // InternalRoom.g:770:3: lv_castName_7_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_15);
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

                    otherlv_8=(Token)match(input,22,FOLLOW_16); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_6_2());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,23,FOLLOW_13); 

                	newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_7());
                
            // InternalRoom.g:794:1: ( (lv_defaultValueLiteral_10_0= RULE_STRING ) )
            // InternalRoom.g:795:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            {
            // InternalRoom.g:795:1: (lv_defaultValueLiteral_10_0= RULE_STRING )
            // InternalRoom.g:796:3: lv_defaultValueLiteral_10_0= RULE_STRING
            {
            lv_defaultValueLiteral_10_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalRoom.g:812:2: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRoom.g:813:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:813:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:814:3: lv_docu_11_0= ruleDocumentation
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
    // InternalRoom.g:838:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalRoom.g:839:2: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalRoom.g:840:2: iv_ruleEnumerationType= ruleEnumerationType EOF
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
    // InternalRoom.g:847:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) ;
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
            // InternalRoom.g:850:28: ( (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) )
            // InternalRoom.g:851:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            {
            // InternalRoom.g:851:1: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            // InternalRoom.g:851:3: otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_0());
                
            // InternalRoom.g:855:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:856:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:856:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:857:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            // InternalRoom.g:873:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==35) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRoom.g:874:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:874:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:875:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_19);
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

            // InternalRoom.g:891:3: (otherlv_3= 'of' ( ( ruleFQN ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRoom.g:891:5: otherlv_3= 'of' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getOfKeyword_3_0());
                        
                    // InternalRoom.g:895:1: ( ( ruleFQN ) )
                    // InternalRoom.g:896:1: ( ruleFQN )
                    {
                    // InternalRoom.g:896:1: ( ruleFQN )
                    // InternalRoom.g:897:3: ruleFQN
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

            otherlv_5=(Token)match(input,14,FOLLOW_20); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:914:1: ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoom.g:914:2: ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalRoom.g:914:2: ( (lv_literals_6_0= ruleEnumLiteral ) )
                    // InternalRoom.g:915:1: (lv_literals_6_0= ruleEnumLiteral )
                    {
                    // InternalRoom.g:915:1: (lv_literals_6_0= ruleEnumLiteral )
                    // InternalRoom.g:916:3: lv_literals_6_0= ruleEnumLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_21);
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

                    // InternalRoom.g:932:2: (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==26) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalRoom.g:932:4: otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_7=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // InternalRoom.g:936:1: ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    // InternalRoom.g:937:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    {
                    	    // InternalRoom.g:937:1: (lv_literals_8_0= ruleEnumLiteral )
                    	    // InternalRoom.g:938:3: lv_literals_8_0= ruleEnumLiteral
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop15;
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
    // InternalRoom.g:966:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalRoom.g:967:2: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalRoom.g:968:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
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
    // InternalRoom.g:975:1: ruleEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:978:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) )
            // InternalRoom.g:979:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            {
            // InternalRoom.g:979:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            // InternalRoom.g:979:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            {
            // InternalRoom.g:979:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:980:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:980:1: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:981:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

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

            // InternalRoom.g:997:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRoom.g:997:4: otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_23); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumLiteralAccess().getEqualsSignKeyword_1_0());
                        
                    // InternalRoom.g:1001:1: ( (lv_literal_2_0= ruleIntLiteral ) )
                    // InternalRoom.g:1002:1: (lv_literal_2_0= ruleIntLiteral )
                    {
                    // InternalRoom.g:1002:1: (lv_literal_2_0= ruleIntLiteral )
                    // InternalRoom.g:1003:3: lv_literal_2_0= ruleIntLiteral
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
    // InternalRoom.g:1027:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // InternalRoom.g:1028:2: (iv_ruleExternalType= ruleExternalType EOF )
            // InternalRoom.g:1029:2: iv_ruleExternalType= ruleExternalType EOF
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
    // InternalRoom.g:1036:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:1039:28: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:1040:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:1040:1: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:1040:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
                
            // InternalRoom.g:1044:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1045:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1045:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1046:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,20,FOLLOW_13); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalRoom.g:1066:1: ( (lv_targetName_3_0= RULE_STRING ) )
            // InternalRoom.g:1067:1: (lv_targetName_3_0= RULE_STRING )
            {
            // InternalRoom.g:1067:1: (lv_targetName_3_0= RULE_STRING )
            // InternalRoom.g:1068:3: lv_targetName_3_0= RULE_STRING
            {
            lv_targetName_3_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            // InternalRoom.g:1084:2: (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRoom.g:1084:4: otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_13); 

                        	newLeafNode(otherlv_4, grammarAccess.getExternalTypeAccess().getDefaultKeyword_4_0());
                        
                    // InternalRoom.g:1088:1: ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    // InternalRoom.g:1089:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:1089:1: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    // InternalRoom.g:1090:3: lv_defaultValueLiteral_5_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_5_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalRoom.g:1106:4: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRoom.g:1107:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1107:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:1108:3: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:1132:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // InternalRoom.g:1133:2: (iv_ruleDataClass= ruleDataClass EOF )
            // InternalRoom.g:1134:2: iv_ruleDataClass= ruleDataClass EOF
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
    // InternalRoom.g:1141:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) ;
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
            // InternalRoom.g:1144:28: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) )
            // InternalRoom.g:1145:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            {
            // InternalRoom.g:1145:1: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            // InternalRoom.g:1145:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
                
            // InternalRoom.g:1149:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1150:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1150:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1151:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

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

            // InternalRoom.g:1167:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRoom.g:1168:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1168:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:1169:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_26);
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

            // InternalRoom.g:1185:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRoom.g:1185:5: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                        
                    // InternalRoom.g:1189:1: ( ( ruleFQN ) )
                    // InternalRoom.g:1190:1: ( ruleFQN )
                    {
                    // InternalRoom.g:1190:1: ( ruleFQN )
                    // InternalRoom.g:1191:3: ruleFQN
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

            otherlv_5=(Token)match(input,14,FOLLOW_27); 

                	newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:1208:1: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==109) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalRoom.g:1209:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1209:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:1210:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAnnotationsAnnotationParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_27);
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
            	    break loop22;
                }
            } while (true);

            // InternalRoom.g:1226:3: (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRoom.g:1226:5: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_28); 

                        	newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                        
                    // InternalRoom.g:1230:1: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // InternalRoom.g:1231:1: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1231:1: (lv_userCode1_8_0= ruleDetailCode )
                    // InternalRoom.g:1232:3: lv_userCode1_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_29);
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

            // InternalRoom.g:1248:4: (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRoom.g:1248:6: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,32,FOLLOW_30); 

                        	newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                        
                    // InternalRoom.g:1252:1: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // InternalRoom.g:1253:1: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1253:1: (lv_userCode2_10_0= ruleDetailCode )
                    // InternalRoom.g:1254:3: lv_userCode2_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_31);
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

            // InternalRoom.g:1270:4: (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRoom.g:1270:6: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_32); 

                        	newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                        
                    // InternalRoom.g:1274:1: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // InternalRoom.g:1275:1: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1275:1: (lv_userCode3_12_0= ruleDetailCode )
                    // InternalRoom.g:1276:3: lv_userCode3_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_33);
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

            // InternalRoom.g:1292:4: ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )*
            loop26:
            do {
                int alt26=4;
                switch ( input.LA(1) ) {
                case 37:
                case 38:
                    {
                    alt26=1;
                    }
                    break;
                case 41:
                case 42:
                    {
                    alt26=2;
                    }
                    break;
                case 34:
                    {
                    alt26=3;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // InternalRoom.g:1292:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    {
            	    // InternalRoom.g:1292:5: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    // InternalRoom.g:1293:1: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // InternalRoom.g:1293:1: (lv_operations_13_0= ruleStandardOperation )
            	    // InternalRoom.g:1294:3: lv_operations_13_0= ruleStandardOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_9_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_33);
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
            	    // InternalRoom.g:1311:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    {
            	    // InternalRoom.g:1311:6: ( (lv_structors_14_0= ruleClassStructor ) )
            	    // InternalRoom.g:1312:1: (lv_structors_14_0= ruleClassStructor )
            	    {
            	    // InternalRoom.g:1312:1: (lv_structors_14_0= ruleClassStructor )
            	    // InternalRoom.g:1313:3: lv_structors_14_0= ruleClassStructor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getStructorsClassStructorParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_33);
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
            	    // InternalRoom.g:1330:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:1330:6: ( (lv_attributes_15_0= ruleAttribute ) )
            	    // InternalRoom.g:1331:1: (lv_attributes_15_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:1331:1: (lv_attributes_15_0= ruleAttribute )
            	    // InternalRoom.g:1332:3: lv_attributes_15_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_33);
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
            	    break loop26;
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
    // InternalRoom.g:1360:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalRoom.g:1361:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalRoom.g:1362:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalRoom.g:1369:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:1372:28: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:1373:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:1373:1: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // InternalRoom.g:1373:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                
            // InternalRoom.g:1377:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1378:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1378:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1379:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalRoom.g:1395:2: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRoom.g:1395:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_35); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // InternalRoom.g:1399:1: ( (lv_size_3_0= RULE_INT ) )
                    // InternalRoom.g:1400:1: (lv_size_3_0= RULE_INT )
                    {
                    // InternalRoom.g:1400:1: (lv_size_3_0= RULE_INT )
                    // InternalRoom.g:1401:3: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_36); 

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

                    otherlv_4=(Token)match(input,36,FOLLOW_8); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_37); 

                	newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getColonKeyword_3());
                
            // InternalRoom.g:1425:1: ( (lv_type_6_0= ruleRefableType ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRoom.g:1426:1: (lv_type_6_0= ruleRefableType )
                    {
                    // InternalRoom.g:1426:1: (lv_type_6_0= ruleRefableType )
                    // InternalRoom.g:1427:3: lv_type_6_0= ruleRefableType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeRefableTypeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_38);
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

            // InternalRoom.g:1443:3: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRoom.g:1443:5: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,27,FOLLOW_13); 

                        	newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                        
                    // InternalRoom.g:1447:1: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // InternalRoom.g:1448:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // InternalRoom.g:1448:1: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // InternalRoom.g:1449:3: lv_defaultValueLiteral_8_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            // InternalRoom.g:1465:4: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRoom.g:1466:1: (lv_docu_9_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1466:1: (lv_docu_9_0= ruleDocumentation )
                    // InternalRoom.g:1467:3: lv_docu_9_0= ruleDocumentation
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
    // InternalRoom.g:1493:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalRoom.g:1494:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalRoom.g:1495:2: iv_ruleStandardOperation= ruleStandardOperation EOF
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
    // InternalRoom.g:1502:1: ruleStandardOperation returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1505:28: ( ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1506:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1506:1: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // InternalRoom.g:1506:2: ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1506:2: ( (lv_override_0_0= 'override' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRoom.g:1507:1: (lv_override_0_0= 'override' )
                    {
                    // InternalRoom.g:1507:1: (lv_override_0_0= 'override' )
                    // InternalRoom.g:1508:3: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,37,FOLLOW_39); 

                            newLeafNode(lv_override_0_0, grammarAccess.getStandardOperationAccess().getOverrideOverrideKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStandardOperationRule());
                    	        }
                           		setWithLastConsumed(current, "override", true, "override");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,38,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getStandardOperationAccess().getOperationKeyword_1());
                
            // InternalRoom.g:1525:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1526:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1526:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1527:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_40); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_41); 

                	newLeafNode(otherlv_3, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_3());
                
            // InternalRoom.g:1547:1: ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRoom.g:1547:2: ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1547:2: ( (lv_arguments_4_0= ruleVarDecl ) )
                    // InternalRoom.g:1548:1: (lv_arguments_4_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1548:1: (lv_arguments_4_0= ruleVarDecl )
                    // InternalRoom.g:1549:3: lv_arguments_4_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_42);
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

                    // InternalRoom.g:1565:2: (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==26) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalRoom.g:1565:4: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // InternalRoom.g:1569:1: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1570:1: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1570:1: (lv_arguments_6_0= ruleVarDecl )
                    	    // InternalRoom.g:1571:3: lv_arguments_6_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_43); 

                	newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
                
            // InternalRoom.g:1591:1: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalRoom.g:1591:3: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_44); 

                        	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                        
                    // InternalRoom.g:1595:1: (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==39) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==RULE_ID) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalRoom.g:1595:3: otherlv_9= 'void'
                            {
                            otherlv_9=(Token)match(input,39,FOLLOW_45); 

                                	newLeafNode(otherlv_9, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1600:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1600:6: ( (lv_returnType_10_0= ruleRefableType ) )
                            // InternalRoom.g:1601:1: (lv_returnType_10_0= ruleRefableType )
                            {
                            // InternalRoom.g:1601:1: (lv_returnType_10_0= ruleRefableType )
                            // InternalRoom.g:1602:3: lv_returnType_10_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getReturnTypeRefableTypeParserRuleCall_6_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_45);
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

            // InternalRoom.g:1618:5: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRoom.g:1619:1: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1619:1: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:1620:3: lv_docu_11_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_46);
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

            // InternalRoom.g:1636:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // InternalRoom.g:1637:1: (lv_detailCode_12_0= ruleDetailCode )
            {
            // InternalRoom.g:1637:1: (lv_detailCode_12_0= ruleDetailCode )
            // InternalRoom.g:1638:3: lv_detailCode_12_0= ruleDetailCode
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
    // InternalRoom.g:1662:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // InternalRoom.g:1663:2: (iv_rulePortOperation= rulePortOperation EOF )
            // InternalRoom.g:1664:2: iv_rulePortOperation= rulePortOperation EOF
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
    // InternalRoom.g:1671:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1674:28: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1675:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1675:1: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // InternalRoom.g:1675:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
                
            // InternalRoom.g:1679:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1680:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1680:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1681:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_40); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_41); 

                	newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
                
            // InternalRoom.g:1701:1: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoom.g:1701:2: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1701:2: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // InternalRoom.g:1702:1: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1702:1: (lv_arguments_3_0= ruleVarDecl )
                    // InternalRoom.g:1703:3: lv_arguments_3_0= ruleVarDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_42);
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

                    // InternalRoom.g:1719:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==26) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalRoom.g:1719:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalRoom.g:1723:1: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1724:1: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1724:1: (lv_arguments_5_0= ruleVarDecl )
                    	    // InternalRoom.g:1725:3: lv_arguments_5_0= ruleVarDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_47); 

                	newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
                
            // InternalRoom.g:1745:1: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            else if ( (LA40_0==40) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // InternalRoom.g:1745:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    {
                    // InternalRoom.g:1745:2: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    // InternalRoom.g:1745:4: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_44); 

                        	newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                        
                    // InternalRoom.g:1749:1: (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==39) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==RULE_ID) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalRoom.g:1749:3: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,39,FOLLOW_45); 

                                	newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1754:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1754:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            // InternalRoom.g:1755:1: (lv_returnType_9_0= ruleRefableType )
                            {
                            // InternalRoom.g:1755:1: (lv_returnType_9_0= ruleRefableType )
                            // InternalRoom.g:1756:3: lv_returnType_9_0= ruleRefableType
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortOperationAccess().getReturnTypeRefableTypeParserRuleCall_5_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_45);
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
                    // InternalRoom.g:1773:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalRoom.g:1773:6: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // InternalRoom.g:1773:8: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,40,FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                        
                    // InternalRoom.g:1777:1: ( (otherlv_11= RULE_ID ) )
                    // InternalRoom.g:1778:1: (otherlv_11= RULE_ID )
                    {
                    // InternalRoom.g:1778:1: (otherlv_11= RULE_ID )
                    // InternalRoom.g:1779:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortOperationRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_45); 

                    		newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1790:5: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRoom.g:1791:1: (lv_docu_12_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1791:1: (lv_docu_12_0= ruleDocumentation )
                    // InternalRoom.g:1792:3: lv_docu_12_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_46);
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

            // InternalRoom.g:1808:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // InternalRoom.g:1809:1: (lv_detailCode_13_0= ruleDetailCode )
            {
            // InternalRoom.g:1809:1: (lv_detailCode_13_0= ruleDetailCode )
            // InternalRoom.g:1810:3: lv_detailCode_13_0= ruleDetailCode
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
    // InternalRoom.g:1834:1: entryRuleClassStructor returns [EObject current=null] : iv_ruleClassStructor= ruleClassStructor EOF ;
    public final EObject entryRuleClassStructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassStructor = null;


        try {
            // InternalRoom.g:1835:2: (iv_ruleClassStructor= ruleClassStructor EOF )
            // InternalRoom.g:1836:2: iv_ruleClassStructor= ruleClassStructor EOF
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
    // InternalRoom.g:1843:1: ruleClassStructor returns [EObject current=null] : ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleClassStructor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_detailCode_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1846:28: ( ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1847:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1847:1: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:1847:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1847:2: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) )
            // InternalRoom.g:1848:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            {
            // InternalRoom.g:1848:1: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            // InternalRoom.g:1849:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            {
            // InternalRoom.g:1849:1: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            else if ( (LA42_0==42) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalRoom.g:1850:3: lv_name_0_1= 'ctor'
                    {
                    lv_name_0_1=(Token)match(input,41,FOLLOW_46); 

                            newLeafNode(lv_name_0_1, grammarAccess.getClassStructorAccess().getNameCtorKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassStructorRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalRoom.g:1862:8: lv_name_0_2= 'dtor'
                    {
                    lv_name_0_2=(Token)match(input,42,FOLLOW_46); 

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

            // InternalRoom.g:1877:2: ( (lv_detailCode_1_0= ruleDetailCode ) )
            // InternalRoom.g:1878:1: (lv_detailCode_1_0= ruleDetailCode )
            {
            // InternalRoom.g:1878:1: (lv_detailCode_1_0= ruleDetailCode )
            // InternalRoom.g:1879:3: lv_detailCode_1_0= ruleDetailCode
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
    // InternalRoom.g:1903:1: entryRuleGeneralProtocolClass returns [EObject current=null] : iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF ;
    public final EObject entryRuleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralProtocolClass = null;


        try {
            // InternalRoom.g:1904:2: (iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF )
            // InternalRoom.g:1905:2: iv_ruleGeneralProtocolClass= ruleGeneralProtocolClass EOF
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
    // InternalRoom.g:1912:1: ruleGeneralProtocolClass returns [EObject current=null] : (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) ;
    public final EObject ruleGeneralProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject this_ProtocolClass_0 = null;

        EObject this_CompoundProtocolClass_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:1915:28: ( (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass ) )
            // InternalRoom.g:1916:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            {
            // InternalRoom.g:1916:1: (this_ProtocolClass_0= ruleProtocolClass | this_CompoundProtocolClass_1= ruleCompoundProtocolClass )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==43||(LA43_0>=125 && LA43_0<=127)) ) {
                alt43=1;
            }
            else if ( (LA43_0==49) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalRoom.g:1917:5: this_ProtocolClass_0= ruleProtocolClass
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
                    // InternalRoom.g:1927:5: this_CompoundProtocolClass_1= ruleCompoundProtocolClass
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
    // InternalRoom.g:1943:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // InternalRoom.g:1944:2: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // InternalRoom.g:1945:2: iv_ruleProtocolClass= ruleProtocolClass EOF
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
    // InternalRoom.g:1952:1: ruleProtocolClass returns [EObject current=null] : ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) ;
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
            // InternalRoom.g:1955:28: ( ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) )
            // InternalRoom.g:1956:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            {
            // InternalRoom.g:1956:1: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            // InternalRoom.g:1956:2: ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}'
            {
            // InternalRoom.g:1956:2: ( (lv_commType_0_0= ruleCommunicationType ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=125 && LA44_0<=127)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoom.g:1957:1: (lv_commType_0_0= ruleCommunicationType )
                    {
                    // InternalRoom.g:1957:1: (lv_commType_0_0= ruleCommunicationType )
                    // InternalRoom.g:1958:3: lv_commType_0_0= ruleCommunicationType
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getCommTypeCommunicationTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_48);
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

            otherlv_1=(Token)match(input,43,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolClassAccess().getProtocolClassKeyword_1());
                
            // InternalRoom.g:1978:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1979:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1979:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1980:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_25); 

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

            // InternalRoom.g:1996:2: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==35) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRoom.g:1997:1: (lv_docu_3_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1997:1: (lv_docu_3_0= ruleDocumentation )
                    // InternalRoom.g:1998:3: lv_docu_3_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_26);
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

            // InternalRoom.g:2014:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==30) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRoom.g:2014:5: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_4, grammarAccess.getProtocolClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:2018:1: ( ( ruleFQN ) )
                    // InternalRoom.g:2019:1: ( ruleFQN )
                    {
                    // InternalRoom.g:2019:1: ( ruleFQN )
                    // InternalRoom.g:2020:3: ruleFQN
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

            otherlv_6=(Token)match(input,14,FOLLOW_49); 

                	newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:2037:1: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==109) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalRoom.g:2038:1: (lv_annotations_7_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2038:1: (lv_annotations_7_0= ruleAnnotation )
            	    // InternalRoom.g:2039:3: lv_annotations_7_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_49);
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
            	    break loop47;
                }
            } while (true);

            // InternalRoom.g:2055:3: (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==31) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRoom.g:2055:5: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_50); 

                        	newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                        
                    // InternalRoom.g:2059:1: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // InternalRoom.g:2060:1: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2060:1: (lv_userCode1_9_0= ruleDetailCode )
                    // InternalRoom.g:2061:3: lv_userCode1_9_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_51);
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

            // InternalRoom.g:2077:4: (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==32) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRoom.g:2077:6: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,32,FOLLOW_52); 

                        	newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                        
                    // InternalRoom.g:2081:1: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // InternalRoom.g:2082:1: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2082:1: (lv_userCode2_11_0= ruleDetailCode )
                    // InternalRoom.g:2083:3: lv_userCode2_11_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
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

            // InternalRoom.g:2099:4: (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRoom.g:2099:6: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,33,FOLLOW_54); 

                        	newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                        
                    // InternalRoom.g:2103:1: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // InternalRoom.g:2104:1: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2104:1: (lv_userCode3_13_0= ruleDetailCode )
                    // InternalRoom.g:2105:3: lv_userCode3_13_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_55);
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

            // InternalRoom.g:2121:4: (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoom.g:2121:6: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,44,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,14,FOLLOW_56); 

                        	newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                        
                    // InternalRoom.g:2129:1: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=51 && LA51_0<=52)) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalRoom.g:2130:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2130:1: (lv_incomingMessages_16_0= ruleMessage )
                    	    // InternalRoom.g:2131:3: lv_incomingMessages_16_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_10_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_56);
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
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,15,FOLLOW_57); 

                        	newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2151:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==45) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRoom.g:2151:5: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,45,FOLLOW_5); 

                        	newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                        
                    otherlv_19=(Token)match(input,14,FOLLOW_56); 

                        	newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                        
                    // InternalRoom.g:2159:1: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=51 && LA53_0<=52)) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalRoom.g:2160:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2160:1: (lv_outgoingMessages_20_0= ruleMessage )
                    	    // InternalRoom.g:2161:3: lv_outgoingMessages_20_0= ruleMessage
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_11_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_56);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FOLLOW_58); 

                        	newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:2181:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==46) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRoom.g:2181:5: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,46,FOLLOW_59); 

                        	newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                        
                    otherlv_23=(Token)match(input,47,FOLLOW_5); 

                        	newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                        
                    // InternalRoom.g:2189:1: ( (lv_regular_24_0= rulePortClass ) )
                    // InternalRoom.g:2190:1: (lv_regular_24_0= rulePortClass )
                    {
                    // InternalRoom.g:2190:1: (lv_regular_24_0= rulePortClass )
                    // InternalRoom.g:2191:3: lv_regular_24_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_12_2_0()); 
                    	    
                    pushFollow(FOLLOW_60);
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

            // InternalRoom.g:2207:4: (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==48) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRoom.g:2207:6: otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_59); 

                        	newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugatedKeyword_13_0());
                        
                    otherlv_26=(Token)match(input,47,FOLLOW_5); 

                        	newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                        
                    // InternalRoom.g:2215:1: ( (lv_conjugated_27_0= rulePortClass ) )
                    // InternalRoom.g:2216:1: (lv_conjugated_27_0= rulePortClass )
                    {
                    // InternalRoom.g:2216:1: (lv_conjugated_27_0= rulePortClass )
                    // InternalRoom.g:2217:3: lv_conjugated_27_0= rulePortClass
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatedPortClassParserRuleCall_13_2_0()); 
                    	    
                    pushFollow(FOLLOW_61);
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

            // InternalRoom.g:2233:4: ( (lv_semantics_28_0= ruleProtocolSemantics ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==106) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRoom.g:2234:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    {
                    // InternalRoom.g:2234:1: (lv_semantics_28_0= ruleProtocolSemantics )
                    // InternalRoom.g:2235:3: lv_semantics_28_0= ruleProtocolSemantics
                    {
                     
                    	        newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_14_0()); 
                    	    
                    pushFollow(FOLLOW_62);
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
    // InternalRoom.g:2263:1: entryRuleCompoundProtocolClass returns [EObject current=null] : iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF ;
    public final EObject entryRuleCompoundProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundProtocolClass = null;


        try {
            // InternalRoom.g:2264:2: (iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF )
            // InternalRoom.g:2265:2: iv_ruleCompoundProtocolClass= ruleCompoundProtocolClass EOF
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
    // InternalRoom.g:2272:1: ruleCompoundProtocolClass returns [EObject current=null] : (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) ;
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
            // InternalRoom.g:2275:28: ( (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' ) )
            // InternalRoom.g:2276:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            {
            // InternalRoom.g:2276:1: (otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}' )
            // InternalRoom.g:2276:3: otherlv_0= 'CompoundProtocolClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_subProtocols_5_0= ruleSubProtocol ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getCompoundProtocolClassAccess().getCompoundProtocolClassKeyword_0());
                
            // InternalRoom.g:2280:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2281:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2281:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2282:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:2298:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==35) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRoom.g:2299:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2299:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:2300:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_63); 

                	newLeafNode(otherlv_3, grammarAccess.getCompoundProtocolClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:2320:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==109) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalRoom.g:2321:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2321:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:2322:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_63);
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
            	    break loop59;
                }
            } while (true);

            // InternalRoom.g:2338:3: ( (lv_subProtocols_5_0= ruleSubProtocol ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==50) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalRoom.g:2339:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    {
            	    // InternalRoom.g:2339:1: (lv_subProtocols_5_0= ruleSubProtocol )
            	    // InternalRoom.g:2340:3: lv_subProtocols_5_0= ruleSubProtocol
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundProtocolClassAccess().getSubProtocolsSubProtocolParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_64);
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
            	    break loop60;
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
    // InternalRoom.g:2368:1: entryRuleSubProtocol returns [EObject current=null] : iv_ruleSubProtocol= ruleSubProtocol EOF ;
    public final EObject entryRuleSubProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubProtocol = null;


        try {
            // InternalRoom.g:2369:2: (iv_ruleSubProtocol= ruleSubProtocol EOF )
            // InternalRoom.g:2370:2: iv_ruleSubProtocol= ruleSubProtocol EOF
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
    // InternalRoom.g:2377:1: ruleSubProtocol returns [EObject current=null] : (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSubProtocol() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:2380:28: ( (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ) )
            // InternalRoom.g:2381:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            {
            // InternalRoom.g:2381:1: (otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) )
            // InternalRoom.g:2381:3: otherlv_0= 'SubProtocol' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubProtocolAccess().getSubProtocolKeyword_0());
                
            // InternalRoom.g:2385:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:2386:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:2386:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:2387:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:2407:1: ( ( ruleFQN ) )
            // InternalRoom.g:2408:1: ( ruleFQN )
            {
            // InternalRoom.g:2408:1: ( ruleFQN )
            // InternalRoom.g:2409:3: ruleFQN
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
    // InternalRoom.g:2430:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalRoom.g:2431:2: (iv_ruleMessage= ruleMessage EOF )
            // InternalRoom.g:2432:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalRoom.g:2439:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:2442:28: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:2443:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:2443:1: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:2443:2: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:2443:2: ( (lv_priv_0_0= 'private' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==51) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRoom.g:2444:1: (lv_priv_0_0= 'private' )
                    {
                    // InternalRoom.g:2444:1: (lv_priv_0_0= 'private' )
                    // InternalRoom.g:2445:3: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,51,FOLLOW_65); 

                            newLeafNode(lv_priv_0_0, grammarAccess.getMessageAccess().getPrivPrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMessageRule());
                    	        }
                           		setWithLastConsumed(current, "priv", true, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,52,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
                
            // InternalRoom.g:2462:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:2463:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:2463:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:2464:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_66); 

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

            // InternalRoom.g:2480:2: (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==21) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRoom.g:2480:4: otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_41); 

                        	newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3_0());
                        
                    // InternalRoom.g:2484:1: ( (lv_data_4_0= ruleMessageData ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalRoom.g:2485:1: (lv_data_4_0= ruleMessageData )
                            {
                            // InternalRoom.g:2485:1: (lv_data_4_0= ruleMessageData )
                            // InternalRoom.g:2486:3: lv_data_4_0= ruleMessageData
                            {
                             
                            	        newCompositeNode(grammarAccess.getMessageAccess().getDataMessageDataParserRuleCall_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_15);
                            lv_data_4_0=ruleMessageData();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMessageRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"data",
                                    		lv_data_4_0, 
                                    		"org.eclipse.etrice.core.Room.MessageData");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,22,FOLLOW_67); 

                        	newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            // InternalRoom.g:2506:3: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==109) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalRoom.g:2507:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2507:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:2508:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_67);
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
            	    break loop64;
                }
            } while (true);

            // InternalRoom.g:2524:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==35) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRoom.g:2525:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2525:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:2526:3: lv_docu_7_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getMessageAccess().getDocuDocumentationParserRuleCall_5_0()); 
                    	    
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
    // InternalRoom.g:2550:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // InternalRoom.g:2551:2: (iv_rulePortClass= rulePortClass EOF )
            // InternalRoom.g:2552:2: iv_rulePortClass= rulePortClass EOF
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
    // InternalRoom.g:2559:1: rulePortClass returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:2562:28: ( ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:2563:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:2563:1: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            // InternalRoom.g:2563:2: () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:2563:2: ()
            // InternalRoom.g:2564:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortClassAccess().getPortClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_68); 

                	newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:2573:1: (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==53) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRoom.g:2573:3: otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) )
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_69); 

                        	newLeafNode(otherlv_2, grammarAccess.getPortClassAccess().getUsercodeKeyword_2_0());
                        
                    // InternalRoom.g:2577:1: ( (lv_userCode_3_0= ruleDetailCode ) )
                    // InternalRoom.g:2578:1: (lv_userCode_3_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2578:1: (lv_userCode_3_0= ruleDetailCode )
                    // InternalRoom.g:2579:3: lv_userCode_3_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortClassAccess().getUserCodeDetailCodeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_70);
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

            // InternalRoom.g:2595:4: ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )*
            loop67:
            do {
                int alt67=4;
                switch ( input.LA(1) ) {
                case 54:
                    {
                    alt67=1;
                    }
                    break;
                case 38:
                    {
                    alt67=2;
                    }
                    break;
                case 34:
                    {
                    alt67=3;
                    }
                    break;

                }

                switch (alt67) {
            	case 1 :
            	    // InternalRoom.g:2595:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    {
            	    // InternalRoom.g:2595:5: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    // InternalRoom.g:2596:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    {
            	    // InternalRoom.g:2596:1: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    // InternalRoom.g:2597:3: lv_msgHandlers_4_0= ruleMessageHandler
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getMsgHandlersMessageHandlerParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_70);
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
            	    // InternalRoom.g:2614:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    {
            	    // InternalRoom.g:2614:6: ( (lv_operations_5_0= rulePortOperation ) )
            	    // InternalRoom.g:2615:1: (lv_operations_5_0= rulePortOperation )
            	    {
            	    // InternalRoom.g:2615:1: (lv_operations_5_0= rulePortOperation )
            	    // InternalRoom.g:2616:3: lv_operations_5_0= rulePortOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getOperationsPortOperationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_70);
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
            	    // InternalRoom.g:2633:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:2633:6: ( (lv_attributes_6_0= ruleAttribute ) )
            	    // InternalRoom.g:2634:1: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:2634:1: (lv_attributes_6_0= ruleAttribute )
            	    // InternalRoom.g:2635:3: lv_attributes_6_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortClassAccess().getAttributesAttributeParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_70);
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
            	    break loop67;
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
    // InternalRoom.g:2663:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // InternalRoom.g:2664:2: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // InternalRoom.g:2665:2: iv_ruleMessageHandler= ruleMessageHandler EOF
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
    // InternalRoom.g:2672:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2675:28: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // InternalRoom.g:2676:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // InternalRoom.g:2676:1: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==54) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==45) ) {
                    alt68=2;
                }
                else if ( (LA68_1==44) ) {
                    alt68=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

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
                    // InternalRoom.g:2677:5: this_InMessageHandler_0= ruleInMessageHandler
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
                    // InternalRoom.g:2687:5: this_OutMessageHandler_1= ruleOutMessageHandler
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
    // InternalRoom.g:2703:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // InternalRoom.g:2704:2: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // InternalRoom.g:2705:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
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
    // InternalRoom.g:2712:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2715:28: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2716:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2716:1: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2716:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_71); 

                	newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
                
            // InternalRoom.g:2724:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2725:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2725:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2726:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_46); 

            		newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2737:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2738:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2738:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2739:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2763:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // InternalRoom.g:2764:2: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // InternalRoom.g:2765:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
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
    // InternalRoom.g:2772:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2775:28: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2776:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2776:1: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2776:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_72); 

                	newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
                
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
                
            // InternalRoom.g:2784:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2785:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2785:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:2786:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_46); 

            		newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:2797:2: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2798:1: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2798:1: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2799:3: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2823:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalRoom.g:2824:2: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalRoom.g:2825:2: iv_ruleModelComponent= ruleModelComponent EOF
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
    // InternalRoom.g:2832:1: ruleModelComponent returns [EObject current=null] : this_ActorClass_0= ruleActorClass ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:2835:28: (this_ActorClass_0= ruleActorClass )
            // InternalRoom.g:2837:5: this_ActorClass_0= ruleActorClass
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
    // InternalRoom.g:2853:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // InternalRoom.g:2854:2: (iv_ruleActorClass= ruleActorClass EOF )
            // InternalRoom.g:2855:2: iv_ruleActorClass= ruleActorClass EOF
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
    // InternalRoom.g:2862:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) ;
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
            // InternalRoom.g:2865:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalRoom.g:2866:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalRoom.g:2866:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            // InternalRoom.g:2866:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}'
            {
            // InternalRoom.g:2866:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalRoom.g:2868:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalRoom.g:2868:1: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalRoom.g:2869:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	
            // InternalRoom.g:2872:2: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalRoom.g:2873:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalRoom.g:2873:3: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop69:
            do {
                int alt69=3;
                int LA69_0 = input.LA(1);

                if ( LA69_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt69=1;
                }
                else if ( ( LA69_0 >= 125 && LA69_0 <= 127 || LA69_0 == 129 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt69=2;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalRoom.g:2875:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalRoom.g:2875:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalRoom.g:2876:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalRoom.g:2876:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalRoom.g:2877:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // InternalRoom.g:2880:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalRoom.g:2880:7: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2880:16: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalRoom.g:2881:1: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalRoom.g:2881:1: (lv_abstract_1_0= 'abstract' )
            	    // InternalRoom.g:2882:3: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,55,FOLLOW_73); 

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
            	    // InternalRoom.g:2902:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalRoom.g:2902:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalRoom.g:2903:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalRoom.g:2903:107: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalRoom.g:2904:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // InternalRoom.g:2907:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalRoom.g:2907:7: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2907:16: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalRoom.g:2908:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalRoom.g:2908:1: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalRoom.g:2909:3: lv_commType_2_0= ruleComponentCommunicationType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getCommTypeComponentCommunicationTypeEnumRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_73);
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
            	    break loop69;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            	

            }

            otherlv_3=(Token)match(input,56,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
                
            // InternalRoom.g:2943:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalRoom.g:2944:1: (lv_name_4_0= RULE_ID )
            {
            // InternalRoom.g:2944:1: (lv_name_4_0= RULE_ID )
            // InternalRoom.g:2945:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_25); 

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

            // InternalRoom.g:2961:2: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==35) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRoom.g:2962:1: (lv_docu_5_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2962:1: (lv_docu_5_0= ruleDocumentation )
                    // InternalRoom.g:2963:3: lv_docu_5_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_26);
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

            // InternalRoom.g:2979:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==30) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRoom.g:2979:5: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalRoom.g:2983:1: ( ( ruleFQN ) )
                    // InternalRoom.g:2984:1: ( ruleFQN )
                    {
                    // InternalRoom.g:2984:1: ( ruleFQN )
                    // InternalRoom.g:2985:3: ruleFQN
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

            otherlv_8=(Token)match(input,14,FOLLOW_74); 

                	newLeafNode(otherlv_8, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_5());
                
            // InternalRoom.g:3002:1: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==109) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalRoom.g:3003:1: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3003:1: (lv_annotations_9_0= ruleAnnotation )
            	    // InternalRoom.g:3004:3: lv_annotations_9_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_74);
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
            	    break loop72;
                }
            } while (true);

            // InternalRoom.g:3020:3: (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==57) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRoom.g:3020:5: otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,57,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,14,FOLLOW_75); 

                        	newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // InternalRoom.g:3028:1: ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )*
                    loop73:
                    do {
                        int alt73=3;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==63) ) {
                            alt73=1;
                        }
                        else if ( (LA73_0==48||LA73_0==60) ) {
                            alt73=2;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalRoom.g:3028:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    {
                    	    // InternalRoom.g:3028:2: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    // InternalRoom.g:3029:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    {
                    	    // InternalRoom.g:3029:1: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    // InternalRoom.g:3030:3: lv_serviceProvisionPoints_12_0= ruleSPP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceProvisionPointsSPPParserRuleCall_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_75);
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
                    	    // InternalRoom.g:3047:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3047:6: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    // InternalRoom.g:3048:1: (lv_interfacePorts_13_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3048:1: (lv_interfacePorts_13_0= rulePort )
                    	    // InternalRoom.g:3049:3: lv_interfacePorts_13_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInterfacePortsPortParserRuleCall_7_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_75);
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
                    	    break loop73;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FOLLOW_76); 

                        	newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalRoom.g:3069:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==58) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalRoom.g:3069:5: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,58,FOLLOW_4); 

                        	newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                        
                    // InternalRoom.g:3073:1: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==35) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalRoom.g:3074:1: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3074:1: (lv_structureDocu_16_0= ruleDocumentation )
                            // InternalRoom.g:3075:3: lv_structureDocu_16_0= ruleDocumentation
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

                    otherlv_17=(Token)match(input,14,FOLLOW_77); 

                        	newLeafNode(otherlv_17, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_8_2());
                        
                    // InternalRoom.g:3095:1: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==31) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalRoom.g:3095:3: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,31,FOLLOW_78); 

                                	newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                                
                            // InternalRoom.g:3099:1: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // InternalRoom.g:3100:1: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3100:1: (lv_userCode1_19_0= ruleDetailCode )
                            // InternalRoom.g:3101:3: lv_userCode1_19_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode1DetailCodeParserRuleCall_8_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_79);
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

                    // InternalRoom.g:3117:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==32) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalRoom.g:3117:6: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,32,FOLLOW_80); 

                                	newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                                
                            // InternalRoom.g:3121:1: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // InternalRoom.g:3122:1: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3122:1: (lv_userCode2_21_0= ruleDetailCode )
                            // InternalRoom.g:3123:3: lv_userCode2_21_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode2DetailCodeParserRuleCall_8_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_81);
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

                    // InternalRoom.g:3139:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==33) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalRoom.g:3139:6: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,33,FOLLOW_82); 

                                	newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                                
                            // InternalRoom.g:3143:1: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // InternalRoom.g:3144:1: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // InternalRoom.g:3144:1: (lv_userCode3_23_0= ruleDetailCode )
                            // InternalRoom.g:3145:3: lv_userCode3_23_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getUserCode3DetailCodeParserRuleCall_8_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_83);
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

                    // InternalRoom.g:3161:4: ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )*
                    loop79:
                    do {
                        int alt79=9;
                        switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt79=1;
                            }
                            break;
                        case 71:
                            {
                            alt79=2;
                            }
                            break;
                        case 64:
                            {
                            alt79=3;
                            }
                            break;
                        case 34:
                            {
                            alt79=4;
                            }
                            break;
                        case 78:
                        case 112:
                        case 128:
                            {
                            alt79=5;
                            }
                            break;
                        case 62:
                            {
                            alt79=6;
                            }
                            break;
                        case 48:
                        case 60:
                            {
                            alt79=7;
                            }
                            break;
                        case 61:
                            {
                            alt79=8;
                            }
                            break;

                        }

                        switch (alt79) {
                    	case 1 :
                    	    // InternalRoom.g:3161:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    {
                    	    // InternalRoom.g:3161:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    // InternalRoom.g:3162:1: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // InternalRoom.g:3162:1: (lv_connections_24_0= ruleLayerConnection )
                    	    // InternalRoom.g:3163:3: lv_connections_24_0= ruleLayerConnection
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getConnectionsLayerConnectionParserRuleCall_8_6_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3180:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    {
                    	    // InternalRoom.g:3180:6: ( (lv_bindings_25_0= ruleBinding ) )
                    	    // InternalRoom.g:3181:1: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // InternalRoom.g:3181:1: (lv_bindings_25_0= ruleBinding )
                    	    // InternalRoom.g:3182:3: lv_bindings_25_0= ruleBinding
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBindingsBindingParserRuleCall_8_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3199:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    {
                    	    // InternalRoom.g:3199:6: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    // InternalRoom.g:3200:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // InternalRoom.g:3200:1: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // InternalRoom.g:3201:3: lv_serviceImplementations_26_0= ruleServiceImplementation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceImplementationsServiceImplementationParserRuleCall_8_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3218:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    {
                    	    // InternalRoom.g:3218:6: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    // InternalRoom.g:3219:1: (lv_attributes_27_0= ruleAttribute )
                    	    {
                    	    // InternalRoom.g:3219:1: (lv_attributes_27_0= ruleAttribute )
                    	    // InternalRoom.g:3220:3: lv_attributes_27_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getAttributesAttributeParserRuleCall_8_6_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3237:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    {
                    	    // InternalRoom.g:3237:6: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    // InternalRoom.g:3238:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    {
                    	    // InternalRoom.g:3238:1: (lv_actorRefs_28_0= ruleActorRef )
                    	    // InternalRoom.g:3239:3: lv_actorRefs_28_0= ruleActorRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getActorRefsActorRefParserRuleCall_8_6_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3256:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    {
                    	    // InternalRoom.g:3256:6: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    // InternalRoom.g:3257:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    {
                    	    // InternalRoom.g:3257:1: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    // InternalRoom.g:3258:3: lv_serviceAccessPoints_29_0= ruleSAP
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getServiceAccessPointsSAPParserRuleCall_8_6_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3275:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3275:6: ( (lv_internalPorts_30_0= rulePort ) )
                    	    // InternalRoom.g:3276:1: (lv_internalPorts_30_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3276:1: (lv_internalPorts_30_0= rulePort )
                    	    // InternalRoom.g:3277:3: lv_internalPorts_30_0= rulePort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getInternalPortsPortParserRuleCall_8_6_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    // InternalRoom.g:3294:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    {
                    	    // InternalRoom.g:3294:6: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    // InternalRoom.g:3295:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    {
                    	    // InternalRoom.g:3295:1: (lv_externalPorts_31_0= ruleExternalPort )
                    	    // InternalRoom.g:3296:3: lv_externalPorts_31_0= ruleExternalPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getExternalPortsExternalPortParserRuleCall_8_6_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
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
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,15,FOLLOW_84); 

                        	newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7());
                        

                    }
                    break;

            }

            // InternalRoom.g:3316:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==59) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRoom.g:3316:5: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}'
                    {
                    otherlv_33=(Token)match(input,59,FOLLOW_4); 

                        	newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                        
                    // InternalRoom.g:3320:1: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==35) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRoom.g:3321:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3321:1: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // InternalRoom.g:3322:3: lv_behaviorDocu_34_0= ruleDocumentation
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

                    otherlv_35=(Token)match(input,14,FOLLOW_85); 

                        	newLeafNode(otherlv_35, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_9_2());
                        
                    // InternalRoom.g:3342:1: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==109) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalRoom.g:3343:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:3343:1: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // InternalRoom.g:3344:3: lv_behaviorAnnotations_36_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getBehaviorAnnotationsAnnotationParserRuleCall_9_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_85);
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
                    	    break loop82;
                        }
                    } while (true);

                    // InternalRoom.g:3360:3: ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )*
                    loop83:
                    do {
                        int alt83=3;
                        int LA83_0 = input.LA(1);

                        if ( ((LA83_0>=37 && LA83_0<=38)) ) {
                            alt83=1;
                        }
                        else if ( ((LA83_0>=41 && LA83_0<=42)) ) {
                            alt83=2;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalRoom.g:3360:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    {
                    	    // InternalRoom.g:3360:4: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    // InternalRoom.g:3361:1: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // InternalRoom.g:3361:1: (lv_operations_37_0= ruleStandardOperation )
                    	    // InternalRoom.g:3362:3: lv_operations_37_0= ruleStandardOperation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getOperationsStandardOperationParserRuleCall_9_4_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_86);
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
                    	    // InternalRoom.g:3379:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    {
                    	    // InternalRoom.g:3379:6: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    // InternalRoom.g:3380:1: (lv_structors_38_0= ruleClassStructor )
                    	    {
                    	    // InternalRoom.g:3380:1: (lv_structors_38_0= ruleClassStructor )
                    	    // InternalRoom.g:3381:3: lv_structors_38_0= ruleClassStructor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorClassAccess().getStructorsClassStructorParserRuleCall_9_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_86);
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
                    	    break loop83;
                        }
                    } while (true);

                    // InternalRoom.g:3397:4: ( (lv_stateMachine_39_0= ruleStateMachine ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==83) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalRoom.g:3398:1: (lv_stateMachine_39_0= ruleStateMachine )
                            {
                            // InternalRoom.g:3398:1: (lv_stateMachine_39_0= ruleStateMachine )
                            // InternalRoom.g:3399:3: lv_stateMachine_39_0= ruleStateMachine
                            {
                             
                            	        newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_9_5_0()); 
                            	    
                            pushFollow(FOLLOW_62);
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

                    otherlv_40=(Token)match(input,15,FOLLOW_62); 

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
    // InternalRoom.g:3431:1: entryRuleInterfaceItem returns [EObject current=null] : iv_ruleInterfaceItem= ruleInterfaceItem EOF ;
    public final EObject entryRuleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceItem = null;


        try {
            // InternalRoom.g:3432:2: (iv_ruleInterfaceItem= ruleInterfaceItem EOF )
            // InternalRoom.g:3433:2: iv_ruleInterfaceItem= ruleInterfaceItem EOF
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
    // InternalRoom.g:3440:1: ruleInterfaceItem returns [EObject current=null] : (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) ;
    public final EObject ruleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_SAP_1 = null;

        EObject this_SPP_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3443:28: ( (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) )
            // InternalRoom.g:3444:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            {
            // InternalRoom.g:3444:1: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            int alt86=3;
            switch ( input.LA(1) ) {
            case 48:
            case 60:
                {
                alt86=1;
                }
                break;
            case 62:
                {
                alt86=2;
                }
                break;
            case 63:
                {
                alt86=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalRoom.g:3445:5: this_Port_0= rulePort
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
                    // InternalRoom.g:3455:5: this_SAP_1= ruleSAP
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
                    // InternalRoom.g:3465:5: this_SPP_2= ruleSPP
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
    // InternalRoom.g:3481:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalRoom.g:3482:2: (iv_rulePort= rulePort EOF )
            // InternalRoom.g:3483:2: iv_rulePort= rulePort EOF
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
    // InternalRoom.g:3490:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:3493:28: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3494:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3494:1: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:3494:2: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:3494:2: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==48) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRoom.g:3495:1: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // InternalRoom.g:3495:1: (lv_conjugated_0_0= 'conjugated' )
                    // InternalRoom.g:3496:3: lv_conjugated_0_0= 'conjugated'
                    {
                    lv_conjugated_0_0=(Token)match(input,48,FOLLOW_87); 

                            newLeafNode(lv_conjugated_0_0, grammarAccess.getPortAccess().getConjugatedConjugatedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRule());
                    	        }
                           		setWithLastConsumed(current, "conjugated", true, "conjugated");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,60,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3513:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:3514:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:3514:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:3515:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalRoom.g:3531:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==35) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRoom.g:3532:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:3532:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:3533:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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
                
            // InternalRoom.g:3553:1: ( ( ruleFQN ) )
            // InternalRoom.g:3554:1: ( ruleFQN )
            {
            // InternalRoom.g:3554:1: ( ruleFQN )
            // InternalRoom.g:3555:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPortAccess().getProtocolGeneralProtocolClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_67);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3568:2: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==109) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalRoom.g:3569:1: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3569:1: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:3570:3: lv_annotations_6_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPortAccess().getAnnotationsAnnotationParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_67);
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
            	    break loop89;
                }
            } while (true);

            // InternalRoom.g:3586:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==35) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRoom.g:3587:1: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3587:1: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:3588:3: lv_docu_7_0= ruleDocumentation
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
    // InternalRoom.g:3612:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // InternalRoom.g:3613:2: (iv_ruleExternalPort= ruleExternalPort EOF )
            // InternalRoom.g:3614:2: iv_ruleExternalPort= ruleExternalPort EOF
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
    // InternalRoom.g:3621:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3624:28: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3625:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3625:1: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3625:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_87); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
                
            otherlv_1=(Token)match(input,60,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
                
            // InternalRoom.g:3633:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3634:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3634:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3635:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3654:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // InternalRoom.g:3655:2: (iv_ruleSAP= ruleSAP EOF )
            // InternalRoom.g:3656:2: iv_ruleSAP= ruleSAP EOF
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
    // InternalRoom.g:3663:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3666:28: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3667:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3667:1: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3667:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                
            // InternalRoom.g:3671:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3672:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3672:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3673:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:3693:1: ( ( ruleFQN ) )
            // InternalRoom.g:3694:1: ( ruleFQN )
            {
            // InternalRoom.g:3694:1: ( ruleFQN )
            // InternalRoom.g:3695:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSAPRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSAPAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_17);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3708:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==35) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRoom.g:3709:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3709:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3710:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSAPAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSAPRule());
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
    // $ANTLR end "ruleSAP"


    // $ANTLR start "entryRuleSPP"
    // InternalRoom.g:3734:1: entryRuleSPP returns [EObject current=null] : iv_ruleSPP= ruleSPP EOF ;
    public final EObject entryRuleSPP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPP = null;


        try {
            // InternalRoom.g:3735:2: (iv_ruleSPP= ruleSPP EOF )
            // InternalRoom.g:3736:2: iv_ruleSPP= ruleSPP EOF
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
    // InternalRoom.g:3743:1: ruleSPP returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSPP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:3746:28: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3747:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3747:1: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3747:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSPPAccess().getSPPKeyword_0());
                
            // InternalRoom.g:3751:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3752:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3752:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3753:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:3773:1: ( ( ruleFQN ) )
            // InternalRoom.g:3774:1: ( ruleFQN )
            {
            // InternalRoom.g:3774:1: ( ruleFQN )
            // InternalRoom.g:3775:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSPPAccess().getProtocolProtocolClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_17);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:3788:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==35) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalRoom.g:3789:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3789:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3790:3: lv_docu_4_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSPPAccess().getDocuDocumentationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_docu_4_0=ruleDocumentation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSPPRule());
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
    // $ANTLR end "ruleSPP"


    // $ANTLR start "entryRuleServiceImplementation"
    // InternalRoom.g:3814:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // InternalRoom.g:3815:2: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // InternalRoom.g:3816:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
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
    // InternalRoom.g:3823:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:3826:28: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3827:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3827:1: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3827:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_88); 

                	newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
                
            // InternalRoom.g:3835:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3836:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3836:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:3837:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:3856:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // InternalRoom.g:3857:2: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // InternalRoom.g:3858:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
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
    // InternalRoom.g:3865:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:3868:28: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:3869:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:3869:1: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            // InternalRoom.g:3869:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
                
            // InternalRoom.g:3873:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3874:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3874:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3875:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:3891:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==35) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRoom.g:3892:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3892:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3893:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_89); 

                	newLeafNode(otherlv_3, grammarAccess.getLogicalSystemAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:3913:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==109) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalRoom.g:3914:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3914:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3915:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_89);
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
            	    break loop94;
                }
            } while (true);

            // InternalRoom.g:3931:3: ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )*
            loop95:
            do {
                int alt95=4;
                switch ( input.LA(1) ) {
                case 75:
                    {
                    alt95=1;
                    }
                    break;
                case 71:
                    {
                    alt95=2;
                    }
                    break;
                case 66:
                    {
                    alt95=3;
                    }
                    break;

                }

                switch (alt95) {
            	case 1 :
            	    // InternalRoom.g:3931:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:3931:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    // InternalRoom.g:3932:1: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:3932:1: (lv_connections_5_0= ruleLayerConnection )
            	    // InternalRoom.g:3933:3: lv_connections_5_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getConnectionsLayerConnectionParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_90);
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
            	    // InternalRoom.g:3950:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:3950:6: ( (lv_bindings_6_0= ruleBinding ) )
            	    // InternalRoom.g:3951:1: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // InternalRoom.g:3951:1: (lv_bindings_6_0= ruleBinding )
            	    // InternalRoom.g:3952:3: lv_bindings_6_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getBindingsBindingParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_90);
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
            	    // InternalRoom.g:3969:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    {
            	    // InternalRoom.g:3969:6: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    // InternalRoom.g:3970:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    {
            	    // InternalRoom.g:3970:1: (lv_subSystems_7_0= ruleSubSystemRef )
            	    // InternalRoom.g:3971:3: lv_subSystems_7_0= ruleSubSystemRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalSystemAccess().getSubSystemsSubSystemRefParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_90);
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
            	    break loop95;
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
    // InternalRoom.g:4001:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // InternalRoom.g:4002:2: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // InternalRoom.g:4003:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
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
    // InternalRoom.g:4010:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4013:28: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4014:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4014:1: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:4014:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,66,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
                
            // InternalRoom.g:4018:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4019:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4019:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4020:3: lv_name_1_0= RULE_ID
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
                
            // InternalRoom.g:4040:1: ( ( ruleFQN ) )
            // InternalRoom.g:4041:1: ( ruleFQN )
            {
            // InternalRoom.g:4041:1: ( ruleFQN )
            // InternalRoom.g:4042:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubSystemRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_17);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:4055:2: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==35) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalRoom.g:4056:1: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4056:1: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:4057:3: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:4081:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // InternalRoom.g:4082:2: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // InternalRoom.g:4083:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
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
    // InternalRoom.g:4090:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) ;
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
            // InternalRoom.g:4093:28: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) )
            // InternalRoom.g:4094:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            {
            // InternalRoom.g:4094:1: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            // InternalRoom.g:4094:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
                
            // InternalRoom.g:4098:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4099:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4099:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4100:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:4116:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==35) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalRoom.g:4117:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4117:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:4118:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_91); 

                	newLeafNode(otherlv_3, grammarAccess.getSubSystemClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:4138:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==109) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalRoom.g:4139:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:4139:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:4140:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_91);
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
            	    break loop98;
                }
            } while (true);

            // InternalRoom.g:4156:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==31) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalRoom.g:4156:5: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_92); 

                        	newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                        
                    // InternalRoom.g:4160:1: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // InternalRoom.g:4161:1: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4161:1: (lv_userCode1_6_0= ruleDetailCode )
                    // InternalRoom.g:4162:3: lv_userCode1_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode1DetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_93);
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

            // InternalRoom.g:4178:4: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==32) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalRoom.g:4178:6: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,32,FOLLOW_94); 

                        	newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                        
                    // InternalRoom.g:4182:1: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // InternalRoom.g:4183:1: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4183:1: (lv_userCode2_8_0= ruleDetailCode )
                    // InternalRoom.g:4184:3: lv_userCode2_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode2DetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_95);
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

            // InternalRoom.g:4200:4: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==33) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalRoom.g:4200:6: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_96); 

                        	newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                        
                    // InternalRoom.g:4204:1: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // InternalRoom.g:4205:1: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4205:1: (lv_userCode3_10_0= ruleDetailCode )
                    // InternalRoom.g:4206:3: lv_userCode3_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getUserCode3DetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_97);
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

            // InternalRoom.g:4222:4: ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )*
            loop102:
            do {
                int alt102=8;
                switch ( input.LA(1) ) {
                case 69:
                    {
                    alt102=1;
                    }
                    break;
                case 68:
                    {
                    alt102=2;
                    }
                    break;
                case 75:
                    {
                    alt102=3;
                    }
                    break;
                case 71:
                    {
                    alt102=4;
                    }
                    break;
                case 78:
                case 112:
                case 128:
                    {
                    alt102=5;
                    }
                    break;
                case 63:
                    {
                    alt102=6;
                    }
                    break;
                case 48:
                case 60:
                    {
                    alt102=7;
                    }
                    break;

                }

                switch (alt102) {
            	case 1 :
            	    // InternalRoom.g:4222:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    {
            	    // InternalRoom.g:4222:5: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    // InternalRoom.g:4223:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    {
            	    // InternalRoom.g:4223:1: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    // InternalRoom.g:4224:3: lv_actorInstanceMappings_11_0= ruleActorInstanceMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4241:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    {
            	    // InternalRoom.g:4241:6: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    // InternalRoom.g:4242:1: (lv_threads_12_0= ruleLogicalThread )
            	    {
            	    // InternalRoom.g:4242:1: (lv_threads_12_0= ruleLogicalThread )
            	    // InternalRoom.g:4243:3: lv_threads_12_0= ruleLogicalThread
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getThreadsLogicalThreadParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4260:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:4260:6: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    // InternalRoom.g:4261:1: (lv_connections_13_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:4261:1: (lv_connections_13_0= ruleLayerConnection )
            	    // InternalRoom.g:4262:3: lv_connections_13_0= ruleLayerConnection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getConnectionsLayerConnectionParserRuleCall_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4279:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:4279:6: ( (lv_bindings_14_0= ruleBinding ) )
            	    // InternalRoom.g:4280:1: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // InternalRoom.g:4280:1: (lv_bindings_14_0= ruleBinding )
            	    // InternalRoom.g:4281:3: lv_bindings_14_0= ruleBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getBindingsBindingParserRuleCall_8_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4298:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    {
            	    // InternalRoom.g:4298:6: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    // InternalRoom.g:4299:1: (lv_actorRefs_15_0= ruleActorRef )
            	    {
            	    // InternalRoom.g:4299:1: (lv_actorRefs_15_0= ruleActorRef )
            	    // InternalRoom.g:4300:3: lv_actorRefs_15_0= ruleActorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getActorRefsActorRefParserRuleCall_8_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4317:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    {
            	    // InternalRoom.g:4317:6: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    // InternalRoom.g:4318:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    {
            	    // InternalRoom.g:4318:1: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    // InternalRoom.g:4319:3: lv_serviceProvisionPoints_16_0= ruleSPP
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getServiceProvisionPointsSPPParserRuleCall_8_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    // InternalRoom.g:4336:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    {
            	    // InternalRoom.g:4336:6: ( (lv_relayPorts_17_0= rulePort ) )
            	    // InternalRoom.g:4337:1: (lv_relayPorts_17_0= rulePort )
            	    {
            	    // InternalRoom.g:4337:1: (lv_relayPorts_17_0= rulePort )
            	    // InternalRoom.g:4338:3: lv_relayPorts_17_0= rulePort
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubSystemClassAccess().getRelayPortsPortParserRuleCall_8_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	    break loop102;
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
    // InternalRoom.g:4366:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // InternalRoom.g:4367:2: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // InternalRoom.g:4368:2: iv_ruleLogicalThread= ruleLogicalThread EOF
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
    // InternalRoom.g:4375:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4378:28: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:4379:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:4379:1: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:4379:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
                
            // InternalRoom.g:4383:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4384:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4384:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4385:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:4409:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // InternalRoom.g:4410:2: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // InternalRoom.g:4411:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
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
    // InternalRoom.g:4418:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
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
            // InternalRoom.g:4421:28: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // InternalRoom.g:4422:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // InternalRoom.g:4422:1: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // InternalRoom.g:4422:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,69,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
                
            // InternalRoom.g:4426:1: ( (lv_path_1_0= ruleRefPath ) )
            // InternalRoom.g:4427:1: (lv_path_1_0= ruleRefPath )
            {
            // InternalRoom.g:4427:1: (lv_path_1_0= ruleRefPath )
            // InternalRoom.g:4428:3: lv_path_1_0= ruleRefPath
            {
             
            	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_2=(Token)match(input,20,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getActorInstanceMappingAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalRoom.g:4448:1: ( (otherlv_3= RULE_ID ) )
            // InternalRoom.g:4449:1: (otherlv_3= RULE_ID )
            {
            // InternalRoom.g:4449:1: (otherlv_3= RULE_ID )
            // InternalRoom.g:4450:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_98); 

            		newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadLogicalThreadCrossReference_3_0()); 
            	

            }


            }

            // InternalRoom.g:4461:2: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==14) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalRoom.g:4461:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_99); 

                        	newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalRoom.g:4465:1: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==69) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalRoom.g:4466:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // InternalRoom.g:4466:1: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // InternalRoom.g:4467:3: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingsActorInstanceMappingParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_99);
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
                    	    break loop103;
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
    // InternalRoom.g:4495:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalRoom.g:4496:2: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalRoom.g:4497:2: iv_ruleRefPath= ruleRefPath EOF
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
    // InternalRoom.g:4504:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4507:28: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalRoom.g:4508:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalRoom.g:4508:1: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalRoom.g:4508:2: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalRoom.g:4508:2: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalRoom.g:4509:1: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalRoom.g:4509:1: (lv_refs_0_0= ruleRefSegment )
            // InternalRoom.g:4510:3: lv_refs_0_0= ruleRefSegment
            {
             
            	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_100);
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

            // InternalRoom.g:4526:2: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==70) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalRoom.g:4526:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,70,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	        
            	    // InternalRoom.g:4530:1: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalRoom.g:4531:1: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalRoom.g:4531:1: (lv_refs_2_0= ruleRefSegment )
            	    // InternalRoom.g:4532:3: lv_refs_2_0= ruleRefSegment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefPathAccess().getRefsRefSegmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_100);
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
            	    break loop105;
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
    // InternalRoom.g:4556:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalRoom.g:4557:2: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalRoom.g:4558:2: iv_ruleRefSegment= ruleRefSegment EOF
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
    // InternalRoom.g:4565:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4568:28: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalRoom.g:4569:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalRoom.g:4569:1: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalRoom.g:4569:2: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalRoom.g:4569:2: ( (lv_ref_0_0= RULE_ID ) )
            // InternalRoom.g:4570:1: (lv_ref_0_0= RULE_ID )
            {
            // InternalRoom.g:4570:1: (lv_ref_0_0= RULE_ID )
            // InternalRoom.g:4571:3: lv_ref_0_0= RULE_ID
            {
            lv_ref_0_0=(Token)match(input,RULE_ID,FOLLOW_101); 

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

            // InternalRoom.g:4587:2: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==16) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalRoom.g:4587:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_35); 

                        	newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                        
                    // InternalRoom.g:4591:1: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalRoom.g:4592:1: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalRoom.g:4592:1: (lv_idx_2_0= RULE_INT )
                    // InternalRoom.g:4593:3: lv_idx_2_0= RULE_INT
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
    // InternalRoom.g:4617:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalRoom.g:4618:2: (iv_ruleBinding= ruleBinding EOF )
            // InternalRoom.g:4619:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalRoom.g:4626:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4629:28: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // InternalRoom.g:4630:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // InternalRoom.g:4630:1: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // InternalRoom.g:4630:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
                
            // InternalRoom.g:4634:1: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4635:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4635:1: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // InternalRoom.g:4636:3: lv_endpoint1_1_0= ruleBindingEndPoint
            {
             
            	        newCompositeNode(grammarAccess.getBindingAccess().getEndpoint1BindingEndPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_102);
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

            otherlv_2=(Token)match(input,72,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
                
            // InternalRoom.g:4656:1: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4657:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4657:1: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // InternalRoom.g:4658:3: lv_endpoint2_3_0= ruleBindingEndPoint
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
    // InternalRoom.g:4682:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // InternalRoom.g:4683:2: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // InternalRoom.g:4684:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
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
    // InternalRoom.g:4691:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4694:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalRoom.g:4695:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalRoom.g:4695:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalRoom.g:4695:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalRoom.g:4695:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==RULE_ID) ) {
                int LA107_1 = input.LA(2);

                if ( (LA107_1==73) ) {
                    alt107=1;
                }
            }
            switch (alt107) {
                case 1 :
                    // InternalRoom.g:4695:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalRoom.g:4695:3: ( (otherlv_0= RULE_ID ) )
                    // InternalRoom.g:4696:1: (otherlv_0= RULE_ID )
                    {
                    // InternalRoom.g:4696:1: (otherlv_0= RULE_ID )
                    // InternalRoom.g:4697:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBindingEndPointRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_103); 

                    		newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,73,FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:4712:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4713:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4713:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4714:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBindingEndPointRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_104); 

            		newLeafNode(otherlv_2, grammarAccess.getBindingEndPointAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // InternalRoom.g:4725:2: (otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==74) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalRoom.g:4725:4: otherlv_3= 'sub' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,74,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getBindingEndPointAccess().getSubKeyword_2_0());
                        
                    // InternalRoom.g:4729:1: ( (otherlv_4= RULE_ID ) )
                    // InternalRoom.g:4730:1: (otherlv_4= RULE_ID )
                    {
                    // InternalRoom.g:4730:1: (otherlv_4= RULE_ID )
                    // InternalRoom.g:4731:3: otherlv_4= RULE_ID
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
    // InternalRoom.g:4750:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // InternalRoom.g:4751:2: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // InternalRoom.g:4752:2: iv_ruleLayerConnection= ruleLayerConnection EOF
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
    // InternalRoom.g:4759:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4762:28: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // InternalRoom.g:4763:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // InternalRoom.g:4763:1: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // InternalRoom.g:4763:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_105); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
                
            // InternalRoom.g:4767:1: ( (lv_from_1_0= ruleSAPoint ) )
            // InternalRoom.g:4768:1: (lv_from_1_0= ruleSAPoint )
            {
            // InternalRoom.g:4768:1: (lv_from_1_0= ruleSAPoint )
            // InternalRoom.g:4769:3: lv_from_1_0= ruleSAPoint
            {
             
            	        newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_106);
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

            otherlv_2=(Token)match(input,76,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
                
            // InternalRoom.g:4789:1: ( (lv_to_3_0= ruleSPPoint ) )
            // InternalRoom.g:4790:1: (lv_to_3_0= ruleSPPoint )
            {
            // InternalRoom.g:4790:1: (lv_to_3_0= ruleSPPoint )
            // InternalRoom.g:4791:3: lv_to_3_0= ruleSPPoint
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
    // InternalRoom.g:4815:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // InternalRoom.g:4816:2: (iv_ruleSAPoint= ruleSAPoint EOF )
            // InternalRoom.g:4817:2: iv_ruleSAPoint= ruleSAPoint EOF
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
    // InternalRoom.g:4824:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:4827:28: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // InternalRoom.g:4828:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // InternalRoom.g:4828:1: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==18) ) {
                alt109=1;
            }
            else if ( (LA109_0==77) ) {
                alt109=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalRoom.g:4829:5: this_RefSAPoint_0= ruleRefSAPoint
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
                    // InternalRoom.g:4839:5: this_RelaySAPoint_1= ruleRelaySAPoint
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
    // InternalRoom.g:4855:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // InternalRoom.g:4856:2: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // InternalRoom.g:4857:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
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
    // InternalRoom.g:4864:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4867:28: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4868:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4868:1: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4868:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
                
            // InternalRoom.g:4872:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4873:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4873:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4874:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4893:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // InternalRoom.g:4894:2: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // InternalRoom.g:4895:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
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
    // InternalRoom.g:4902:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4905:28: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4906:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4906:1: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4906:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
                
            // InternalRoom.g:4910:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4911:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4911:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:4912:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:4931:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // InternalRoom.g:4932:2: (iv_ruleSPPoint= ruleSPPoint EOF )
            // InternalRoom.g:4933:2: iv_ruleSPPoint= ruleSPPoint EOF
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
    // InternalRoom.g:4940:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:4943:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4944:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4944:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4944:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4944:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:4945:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:4945:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:4946:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSPPointRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_103); 

            		newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,73,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
                
            // InternalRoom.g:4961:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4962:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4962:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:4963:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:4982:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // InternalRoom.g:4983:2: (iv_ruleActorRef= ruleActorRef EOF )
            // InternalRoom.g:4984:2: iv_ruleActorRef= ruleActorRef EOF
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
    // InternalRoom.g:4991:1: ruleActorRef returns [EObject current=null] : ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:4994:28: ( ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4995:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4995:1: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:4995:2: ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:4995:2: ( (lv_refType_0_0= ruleReferenceType ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==112||LA110_0==128) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalRoom.g:4996:1: (lv_refType_0_0= ruleReferenceType )
                    {
                    // InternalRoom.g:4996:1: (lv_refType_0_0= ruleReferenceType )
                    // InternalRoom.g:4997:3: lv_refType_0_0= ruleReferenceType
                    {
                     
                    	        newCompositeNode(grammarAccess.getActorRefAccess().getRefTypeReferenceTypeEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_107);
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

            otherlv_1=(Token)match(input,78,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getActorRefAccess().getActorRefKeyword_1());
                
            // InternalRoom.g:5017:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:5018:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:5018:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:5019:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalRoom.g:5035:2: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==35) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalRoom.g:5036:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:5036:1: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:5037:3: lv_multiplicity_3_0= ruleMULTIPLICITY
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
                
            // InternalRoom.g:5057:1: ( ( ruleFQN ) )
            // InternalRoom.g:5058:1: ( ruleFQN )
            {
            // InternalRoom.g:5058:1: ( ruleFQN )
            // InternalRoom.g:5059:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getActorRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_17);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:5072:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==35) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalRoom.g:5073:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5073:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:5074:3: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:5100:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // InternalRoom.g:5101:2: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // InternalRoom.g:5102:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
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
    // InternalRoom.g:5109:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5112:28: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // InternalRoom.g:5113:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // InternalRoom.g:5113:1: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // InternalRoom.g:5114:2: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,35,FOLLOW_108); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0()); 
                
            // InternalRoom.g:5119:1: (kw= '*' | this_INT_2= RULE_INT )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==79) ) {
                alt113=1;
            }
            else if ( (LA113_0==RULE_INT) ) {
                alt113=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }
            switch (alt113) {
                case 1 :
                    // InternalRoom.g:5120:2: kw= '*'
                    {
                    kw=(Token)match(input,79,FOLLOW_36); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5126:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_36); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getMULTIPLICITYAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,36,FOLLOW_2); 

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
    // InternalRoom.g:5147:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalRoom.g:5148:2: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalRoom.g:5149:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalRoom.g:5156:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5159:28: ( (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' ) )
            // InternalRoom.g:5160:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' )
            {
            // InternalRoom.g:5160:1: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' )
            int alt114=11;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt114=1;
                }
                break;
            case 56:
                {
                alt114=2;
                }
                break;
            case 80:
                {
                alt114=3;
                }
                break;
            case 43:
                {
                alt114=4;
                }
                break;
            case 49:
                {
                alt114=5;
                }
                break;
            case 67:
                {
                alt114=6;
                }
                break;
            case 65:
                {
                alt114=7;
                }
                break;
            case 60:
                {
                alt114=8;
                }
                break;
            case 52:
                {
                alt114=9;
                }
                break;
            case 81:
                {
                alt114=10;
                }
                break;
            case 82:
                {
                alt114=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // InternalRoom.g:5161:2: kw= 'DataClass'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getDataClassKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:5168:2: kw= 'ActorClass'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorClassKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalRoom.g:5175:2: kw= 'ActorBehavior'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorBehaviorKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalRoom.g:5182:2: kw= 'ProtocolClass'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getProtocolClassKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalRoom.g:5189:2: kw= 'CompoundProtocolClass'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getCompoundProtocolClassKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalRoom.g:5196:2: kw= 'SubSystemClass'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getSubSystemClassKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalRoom.g:5203:2: kw= 'LogicalSystem'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getLogicalSystemKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalRoom.g:5210:2: kw= 'Port'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getPortKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalRoom.g:5217:2: kw= 'Message'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getMessageKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalRoom.g:5224:2: kw= 'State'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getStateKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalRoom.g:5231:2: kw= 'Transition'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getTransitionKeyword_10()); 
                        

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
    // InternalRoom.g:5246:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalRoom.g:5247:2: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalRoom.g:5248:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
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
    // InternalRoom.g:5255:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5258:28: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalRoom.g:5259:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalRoom.g:5259:1: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt115=3;
            switch ( input.LA(1) ) {
            case 81:
            case 88:
                {
                alt115=1;
                }
                break;
            case 93:
                {
                alt115=2;
                }
                break;
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt115=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalRoom.g:5260:5: this_State_0= ruleState
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
                    // InternalRoom.g:5270:5: this_ChoicePoint_1= ruleChoicePoint
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
                    // InternalRoom.g:5280:5: this_TrPoint_2= ruleTrPoint
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
    // InternalRoom.g:5298:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalRoom.g:5299:2: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalRoom.g:5300:2: iv_ruleStateGraph= ruleStateGraph EOF
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
    // InternalRoom.g:5307:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:5310:28: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:5311:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:5311:1: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalRoom.g:5311:2: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:5311:2: ()
            // InternalRoom.g:5312:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FOLLOW_109); 

                	newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalRoom.g:5321:1: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop116:
            do {
                int alt116=6;
                switch ( input.LA(1) ) {
                case 81:
                case 88:
                    {
                    alt116=1;
                    }
                    break;
                case 89:
                case 90:
                case 91:
                case 92:
                    {
                    alt116=2;
                    }
                    break;
                case 93:
                    {
                    alt116=3;
                    }
                    break;
                case 82:
                    {
                    alt116=4;
                    }
                    break;
                case 100:
                    {
                    alt116=5;
                    }
                    break;

                }

                switch (alt116) {
            	case 1 :
            	    // InternalRoom.g:5321:2: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5321:2: ( (lv_states_2_0= ruleState ) )
            	    // InternalRoom.g:5322:1: (lv_states_2_0= ruleState )
            	    {
            	    // InternalRoom.g:5322:1: (lv_states_2_0= ruleState )
            	    // InternalRoom.g:5323:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5340:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5340:6: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalRoom.g:5341:1: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5341:1: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalRoom.g:5342:3: lv_trPoints_3_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5359:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5359:6: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5360:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5360:1: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalRoom.g:5361:3: lv_chPoints_4_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5378:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5378:6: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalRoom.g:5379:1: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5379:1: (lv_transitions_5_0= ruleTransition )
            	    // InternalRoom.g:5380:3: lv_transitions_5_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5397:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5397:6: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5398:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5398:1: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalRoom.g:5399:3: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    break loop116;
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
    // InternalRoom.g:5427:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRoom.g:5428:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRoom.g:5429:2: iv_ruleStateMachine= ruleStateMachine EOF
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
    // InternalRoom.g:5436:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:5439:28: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:5440:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:5440:1: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalRoom.g:5440:2: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalRoom.g:5440:2: ()
            // InternalRoom.g:5441:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,83,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_109); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:5454:1: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop117:
            do {
                int alt117=6;
                switch ( input.LA(1) ) {
                case 81:
                case 88:
                    {
                    alt117=1;
                    }
                    break;
                case 89:
                case 90:
                case 91:
                case 92:
                    {
                    alt117=2;
                    }
                    break;
                case 93:
                    {
                    alt117=3;
                    }
                    break;
                case 82:
                    {
                    alt117=4;
                    }
                    break;
                case 100:
                    {
                    alt117=5;
                    }
                    break;

                }

                switch (alt117) {
            	case 1 :
            	    // InternalRoom.g:5454:2: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5454:2: ( (lv_states_3_0= ruleState ) )
            	    // InternalRoom.g:5455:1: (lv_states_3_0= ruleState )
            	    {
            	    // InternalRoom.g:5455:1: (lv_states_3_0= ruleState )
            	    // InternalRoom.g:5456:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5473:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5473:6: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalRoom.g:5474:1: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5474:1: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalRoom.g:5475:3: lv_trPoints_4_0= ruleTrPoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5492:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5492:6: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5493:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5493:1: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalRoom.g:5494:3: lv_chPoints_5_0= ruleChoicePoint
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5511:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5511:6: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalRoom.g:5512:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5512:1: (lv_transitions_6_0= ruleTransition )
            	    // InternalRoom.g:5513:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    // InternalRoom.g:5530:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5530:6: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5531:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5531:1: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalRoom.g:5532:3: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_109);
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
            	    break loop117;
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
    // InternalRoom.g:5560:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRoom.g:5561:2: (iv_ruleState= ruleState EOF )
            // InternalRoom.g:5562:2: iv_ruleState= ruleState EOF
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
    // InternalRoom.g:5569:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:5572:28: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalRoom.g:5573:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalRoom.g:5573:1: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==81) ) {
                alt118=1;
            }
            else if ( (LA118_0==88) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalRoom.g:5574:5: this_SimpleState_0= ruleSimpleState
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
                    // InternalRoom.g:5584:5: this_RefinedState_1= ruleRefinedState
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
    // InternalRoom.g:5600:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalRoom.g:5601:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalRoom.g:5602:2: iv_ruleSimpleState= ruleSimpleState EOF
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
    // InternalRoom.g:5609:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) ;
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
            // InternalRoom.g:5612:28: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) )
            // InternalRoom.g:5613:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            {
            // InternalRoom.g:5613:1: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            // InternalRoom.g:5613:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
                
            // InternalRoom.g:5617:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5618:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5618:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5619:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_110); 

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

            // InternalRoom.g:5635:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==35) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalRoom.g:5636:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5636:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5637:3: lv_docu_2_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDocuDocumentationParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_98);
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

            // InternalRoom.g:5653:3: (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==14) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalRoom.g:5653:5: otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_111); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalRoom.g:5657:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
                    loop120:
                    do {
                        int alt120=2;
                        int LA120_0 = input.LA(1);

                        if ( (LA120_0==109) ) {
                            alt120=1;
                        }


                        switch (alt120) {
                    	case 1 :
                    	    // InternalRoom.g:5658:1: (lv_annotations_4_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:5658:1: (lv_annotations_4_0= ruleAnnotation )
                    	    // InternalRoom.g:5659:3: lv_annotations_4_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getAnnotationsAnnotationParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_111);
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
                    	    break loop120;
                        }
                    } while (true);

                    // InternalRoom.g:5675:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==84) ) {
                        alt121=1;
                    }
                    switch (alt121) {
                        case 1 :
                            // InternalRoom.g:5675:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                            {
                            otherlv_5=(Token)match(input,84,FOLLOW_112); 

                                	newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_2_0());
                                
                            // InternalRoom.g:5679:1: ( (lv_entryCode_6_0= ruleDetailCode ) )
                            // InternalRoom.g:5680:1: (lv_entryCode_6_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5680:1: (lv_entryCode_6_0= ruleDetailCode )
                            // InternalRoom.g:5681:3: lv_entryCode_6_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_113);
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

                    // InternalRoom.g:5697:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==85) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // InternalRoom.g:5697:6: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                            {
                            otherlv_7=(Token)match(input,85,FOLLOW_114); 

                                	newLeafNode(otherlv_7, grammarAccess.getSimpleStateAccess().getExitKeyword_3_3_0());
                                
                            // InternalRoom.g:5701:1: ( (lv_exitCode_8_0= ruleDetailCode ) )
                            // InternalRoom.g:5702:1: (lv_exitCode_8_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5702:1: (lv_exitCode_8_0= ruleDetailCode )
                            // InternalRoom.g:5703:3: lv_exitCode_8_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_115);
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

                    // InternalRoom.g:5719:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==86) ) {
                        alt123=1;
                    }
                    switch (alt123) {
                        case 1 :
                            // InternalRoom.g:5719:6: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,86,FOLLOW_116); 

                                	newLeafNode(otherlv_9, grammarAccess.getSimpleStateAccess().getDoKeyword_3_4_0());
                                
                            // InternalRoom.g:5723:1: ( (lv_doCode_10_0= ruleDetailCode ) )
                            // InternalRoom.g:5724:1: (lv_doCode_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5724:1: (lv_doCode_10_0= ruleDetailCode )
                            // InternalRoom.g:5725:3: lv_doCode_10_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_117);
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

                    // InternalRoom.g:5741:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==87) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // InternalRoom.g:5741:6: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                            {
                            otherlv_11=(Token)match(input,87,FOLLOW_5); 

                                	newLeafNode(otherlv_11, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_5_0());
                                
                            // InternalRoom.g:5745:1: ( (lv_subgraph_12_0= ruleStateGraph ) )
                            // InternalRoom.g:5746:1: (lv_subgraph_12_0= ruleStateGraph )
                            {
                            // InternalRoom.g:5746:1: (lv_subgraph_12_0= ruleStateGraph )
                            // InternalRoom.g:5747:3: lv_subgraph_12_0= ruleStateGraph
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_5_1_0()); 
                            	    
                            pushFollow(FOLLOW_62);
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

                    otherlv_13=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5775:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalRoom.g:5776:2: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalRoom.g:5777:2: iv_ruleRefinedState= ruleRefinedState EOF
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
    // InternalRoom.g:5784:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:5787:28: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:5788:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:5788:1: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            // InternalRoom.g:5788:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
                
            // InternalRoom.g:5792:1: ( ( ruleFQN ) )
            // InternalRoom.g:5793:1: ( ruleFQN )
            {
            // InternalRoom.g:5793:1: ( ruleFQN )
            // InternalRoom.g:5794:3: ruleFQN
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

            // InternalRoom.g:5807:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==35) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalRoom.g:5808:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5808:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5809:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_111); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:5829:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==109) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // InternalRoom.g:5830:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:5830:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:5831:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_111);
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
            	    break loop127;
                }
            } while (true);

            // InternalRoom.g:5847:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==84) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalRoom.g:5847:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,84,FOLLOW_112); 

                        	newLeafNode(otherlv_5, grammarAccess.getRefinedStateAccess().getEntryKeyword_5_0());
                        
                    // InternalRoom.g:5851:1: ( (lv_entryCode_6_0= ruleDetailCode ) )
                    // InternalRoom.g:5852:1: (lv_entryCode_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5852:1: (lv_entryCode_6_0= ruleDetailCode )
                    // InternalRoom.g:5853:3: lv_entryCode_6_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_113);
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

            // InternalRoom.g:5869:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==85) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalRoom.g:5869:6: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,85,FOLLOW_114); 

                        	newLeafNode(otherlv_7, grammarAccess.getRefinedStateAccess().getExitKeyword_6_0());
                        
                    // InternalRoom.g:5873:1: ( (lv_exitCode_8_0= ruleDetailCode ) )
                    // InternalRoom.g:5874:1: (lv_exitCode_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5874:1: (lv_exitCode_8_0= ruleDetailCode )
                    // InternalRoom.g:5875:3: lv_exitCode_8_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_115);
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

            // InternalRoom.g:5891:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==86) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalRoom.g:5891:6: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,86,FOLLOW_116); 

                        	newLeafNode(otherlv_9, grammarAccess.getRefinedStateAccess().getDoKeyword_7_0());
                        
                    // InternalRoom.g:5895:1: ( (lv_doCode_10_0= ruleDetailCode ) )
                    // InternalRoom.g:5896:1: (lv_doCode_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5896:1: (lv_doCode_10_0= ruleDetailCode )
                    // InternalRoom.g:5897:3: lv_doCode_10_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_117);
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

            // InternalRoom.g:5913:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==87) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalRoom.g:5913:6: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                    {
                    otherlv_11=(Token)match(input,87,FOLLOW_5); 

                        	newLeafNode(otherlv_11, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_8_0());
                        
                    // InternalRoom.g:5917:1: ( (lv_subgraph_12_0= ruleStateGraph ) )
                    // InternalRoom.g:5918:1: (lv_subgraph_12_0= ruleStateGraph )
                    {
                    // InternalRoom.g:5918:1: (lv_subgraph_12_0= ruleStateGraph )
                    // InternalRoom.g:5919:3: lv_subgraph_12_0= ruleStateGraph
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_62);
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

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:5947:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalRoom.g:5948:2: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalRoom.g:5949:2: iv_ruleDetailCode= ruleDetailCode EOF
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
    // InternalRoom.g:5956:1: ruleDetailCode returns [EObject current=null] : ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_lines_1_0=null;
        Token lv_used_2_0=null;
        Token lv_lines_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:5959:28: ( ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) )
            // InternalRoom.g:5960:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            {
            // InternalRoom.g:5960:1: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==EOF||LA134_0==RULE_CC_STRING||LA134_0==15||(LA134_0>=32 && LA134_0<=34)||(LA134_0>=37 && LA134_0<=38)||(LA134_0>=41 && LA134_0<=42)||(LA134_0>=44 && LA134_0<=46)||LA134_0==48||LA134_0==54||(LA134_0>=60 && LA134_0<=64)||(LA134_0>=68 && LA134_0<=69)||LA134_0==71||LA134_0==75||LA134_0==78||LA134_0==83||(LA134_0>=85 && LA134_0<=87)||LA134_0==95||(LA134_0>=105 && LA134_0<=106)||LA134_0==112||LA134_0==128) ) {
                alt134=1;
            }
            else if ( (LA134_0==14) ) {
                alt134=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // InternalRoom.g:5960:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    {
                    // InternalRoom.g:5960:2: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    // InternalRoom.g:5960:3: () ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    {
                    // InternalRoom.g:5960:3: ()
                    // InternalRoom.g:5961:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getDetailCodeAccess().getDetailCodeAction_0_0(),
                                current);
                        

                    }

                    // InternalRoom.g:5966:2: ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    int alt132=2;
                    int LA132_0 = input.LA(1);

                    if ( (LA132_0==RULE_CC_STRING) ) {
                        alt132=1;
                    }
                    switch (alt132) {
                        case 1 :
                            // InternalRoom.g:5967:1: (lv_lines_1_0= RULE_CC_STRING )
                            {
                            // InternalRoom.g:5967:1: (lv_lines_1_0= RULE_CC_STRING )
                            // InternalRoom.g:5968:3: lv_lines_1_0= RULE_CC_STRING
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
                    // InternalRoom.g:5985:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    {
                    // InternalRoom.g:5985:6: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    // InternalRoom.g:5985:7: ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}'
                    {
                    // InternalRoom.g:5985:7: ( (lv_used_2_0= '{' ) )
                    // InternalRoom.g:5986:1: (lv_used_2_0= '{' )
                    {
                    // InternalRoom.g:5986:1: (lv_used_2_0= '{' )
                    // InternalRoom.g:5987:3: lv_used_2_0= '{'
                    {
                    lv_used_2_0=(Token)match(input,14,FOLLOW_118); 

                            newLeafNode(lv_used_2_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDetailCodeRule());
                    	        }
                           		setWithLastConsumed(current, "used", true, "{");
                    	    

                    }


                    }

                    // InternalRoom.g:6000:2: ( (lv_lines_3_0= RULE_STRING ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==RULE_STRING) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalRoom.g:6001:1: (lv_lines_3_0= RULE_STRING )
                    	    {
                    	    // InternalRoom.g:6001:1: (lv_lines_3_0= RULE_STRING )
                    	    // InternalRoom.g:6002:3: lv_lines_3_0= RULE_STRING
                    	    {
                    	    lv_lines_3_0=(Token)match(input,RULE_STRING,FOLLOW_118); 

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
                    	    break loop133;
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
    // InternalRoom.g:6030:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalRoom.g:6031:2: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalRoom.g:6032:2: iv_ruleTrPoint= ruleTrPoint EOF
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
    // InternalRoom.g:6039:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6042:28: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalRoom.g:6043:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalRoom.g:6043:1: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt135=3;
            switch ( input.LA(1) ) {
            case 89:
            case 90:
                {
                alt135=1;
                }
                break;
            case 91:
                {
                alt135=2;
                }
                break;
            case 92:
                {
                alt135=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // InternalRoom.g:6044:5: this_TransitionPoint_0= ruleTransitionPoint
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
                    // InternalRoom.g:6054:5: this_EntryPoint_1= ruleEntryPoint
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
                    // InternalRoom.g:6064:5: this_ExitPoint_2= ruleExitPoint
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
    // InternalRoom.g:6080:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalRoom.g:6081:2: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalRoom.g:6082:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
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
    // InternalRoom.g:6089:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6092:28: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalRoom.g:6093:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6093:1: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalRoom.g:6093:2: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalRoom.g:6093:2: ( (lv_handler_0_0= 'handler' ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==89) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // InternalRoom.g:6094:1: (lv_handler_0_0= 'handler' )
                    {
                    // InternalRoom.g:6094:1: (lv_handler_0_0= 'handler' )
                    // InternalRoom.g:6095:3: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,89,FOLLOW_119); 

                            newLeafNode(lv_handler_0_0, grammarAccess.getTransitionPointAccess().getHandlerHandlerKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionPointRule());
                    	        }
                           		setWithLastConsumed(current, "handler", true, "handler");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,90,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPointAccess().getTransitionPointKeyword_1());
                
            // InternalRoom.g:6112:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:6113:1: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:6113:1: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:6114:3: lv_name_2_0= RULE_ID
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
    // InternalRoom.g:6138:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalRoom.g:6139:2: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalRoom.g:6140:2: iv_ruleEntryPoint= ruleEntryPoint EOF
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
    // InternalRoom.g:6147:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6150:28: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6151:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6151:1: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6151:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,91,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
                
            // InternalRoom.g:6155:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6156:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6156:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6157:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6181:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalRoom.g:6182:2: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalRoom.g:6183:2: iv_ruleExitPoint= ruleExitPoint EOF
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
    // InternalRoom.g:6190:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:6193:28: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6194:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6194:1: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6194:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
                
            // InternalRoom.g:6198:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6199:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6199:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6200:3: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6224:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalRoom.g:6225:2: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalRoom.g:6226:2: iv_ruleChoicePoint= ruleChoicePoint EOF
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
    // InternalRoom.g:6233:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6236:28: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:6237:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:6237:1: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalRoom.g:6237:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,93,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
                
            // InternalRoom.g:6241:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6242:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6242:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6243:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalRoom.g:6259:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==35) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalRoom.g:6260:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6260:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6261:3: lv_docu_2_0= ruleDocumentation
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
    // InternalRoom.g:6285:1: entryRuleTransitionBase returns [EObject current=null] : iv_ruleTransitionBase= ruleTransitionBase EOF ;
    public final EObject entryRuleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionBase = null;


        try {
            // InternalRoom.g:6286:2: (iv_ruleTransitionBase= ruleTransitionBase EOF )
            // InternalRoom.g:6287:2: iv_ruleTransitionBase= ruleTransitionBase EOF
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
    // InternalRoom.g:6294:1: ruleTransitionBase returns [EObject current=null] : (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) ;
    public final EObject ruleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_RefinedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6297:28: ( (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) )
            // InternalRoom.g:6298:1: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            {
            // InternalRoom.g:6298:1: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==82) ) {
                alt138=1;
            }
            else if ( (LA138_0==100) ) {
                alt138=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // InternalRoom.g:6299:5: this_Transition_0= ruleTransition
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
                    // InternalRoom.g:6309:5: this_RefinedTransition_1= ruleRefinedTransition
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
    // InternalRoom.g:6325:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalRoom.g:6326:2: (iv_ruleTransition= ruleTransition EOF )
            // InternalRoom.g:6327:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalRoom.g:6334:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6337:28: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalRoom.g:6338:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalRoom.g:6338:1: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==82) ) {
                int LA139_1 = input.LA(2);

                if ( (LA139_1==RULE_ID) ) {
                    int LA139_2 = input.LA(3);

                    if ( (LA139_2==16) ) {
                        int LA139_3 = input.LA(4);

                        if ( (LA139_3==94) ) {
                            alt139=1;
                        }
                        else if ( (LA139_3==RULE_ID||(LA139_3>=101 && LA139_3<=102)) ) {
                            alt139=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 139, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 139, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA139_1==16) ) {
                    int LA139_3 = input.LA(3);

                    if ( (LA139_3==94) ) {
                        alt139=1;
                    }
                    else if ( (LA139_3==RULE_ID||(LA139_3>=101 && LA139_3<=102)) ) {
                        alt139=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 139, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 139, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }
            switch (alt139) {
                case 1 :
                    // InternalRoom.g:6339:5: this_InitialTransition_0= ruleInitialTransition
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
                    // InternalRoom.g:6349:5: this_NonInitialTransition_1= ruleNonInitialTransition
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
    // InternalRoom.g:6365:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalRoom.g:6366:2: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalRoom.g:6367:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
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
    // InternalRoom.g:6374:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6377:28: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalRoom.g:6378:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalRoom.g:6378:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt140=3;
            alt140 = dfa140.predict(input);
            switch (alt140) {
                case 1 :
                    // InternalRoom.g:6379:5: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
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
                    // InternalRoom.g:6389:5: this_ContinuationTransition_1= ruleContinuationTransition
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
                    // InternalRoom.g:6399:5: this_CPBranchTransition_2= ruleCPBranchTransition
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
    // InternalRoom.g:6415:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalRoom.g:6416:2: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalRoom.g:6417:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
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
    // InternalRoom.g:6424:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:6427:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalRoom.g:6428:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalRoom.g:6428:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt141=2;
            alt141 = dfa141.predict(input);
            switch (alt141) {
                case 1 :
                    // InternalRoom.g:6429:5: this_TriggeredTransition_0= ruleTriggeredTransition
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
                    // InternalRoom.g:6439:5: this_GuardedTransition_1= ruleGuardedTransition
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
    // InternalRoom.g:6455:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalRoom.g:6456:2: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalRoom.g:6457:2: iv_ruleInitialTransition= ruleInitialTransition EOF
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
    // InternalRoom.g:6464:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6467:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6468:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6468:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6468:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_120); 

                	newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6472:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==RULE_ID) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalRoom.g:6473:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6473:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6474:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_121); 

                	newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,94,FOLLOW_12); 

                	newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
                
            otherlv_4=(Token)match(input,20,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6502:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6503:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6503:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6504:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_110);
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

            // InternalRoom.g:6520:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==35) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalRoom.g:6521:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6521:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6522:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_98);
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

            // InternalRoom.g:6538:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==14) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalRoom.g:6538:5: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_123); 

                        	newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6542:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop144:
                    do {
                        int alt144=2;
                        int LA144_0 = input.LA(1);

                        if ( (LA144_0==109) ) {
                            alt144=1;
                        }


                        switch (alt144) {
                    	case 1 :
                    	    // InternalRoom.g:6543:1: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6543:1: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6544:3: lv_annotations_8_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_123);
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
                    	    break loop144;
                        }
                    } while (true);

                    // InternalRoom.g:6560:3: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt145=2;
                    int LA145_0 = input.LA(1);

                    if ( (LA145_0==95) ) {
                        alt145=1;
                    }
                    switch (alt145) {
                        case 1 :
                            // InternalRoom.g:6560:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,95,FOLLOW_124); 

                                	newLeafNode(otherlv_9, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_2_0());
                                
                            // InternalRoom.g:6564:1: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6565:1: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6565:1: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6566:3: lv_action_10_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_62);
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

                    otherlv_11=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6594:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalRoom.g:6595:2: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalRoom.g:6596:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
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
    // InternalRoom.g:6603:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6606:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6607:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6607:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6607:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,82,FOLLOW_120); 

                	newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6611:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==RULE_ID) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalRoom.g:6612:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6612:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6613:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_122); 

                	newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6633:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6634:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6634:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6635:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_4=(Token)match(input,20,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6655:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6656:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6656:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6657:3: lv_to_5_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_110);
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

            // InternalRoom.g:6673:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==35) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // InternalRoom.g:6674:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6674:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6675:3: lv_docu_6_0= ruleDocumentation
                    {
                     
                    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getDocuDocumentationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_98);
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

            // InternalRoom.g:6691:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==14) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalRoom.g:6691:5: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_123); 

                        	newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalRoom.g:6695:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop149:
                    do {
                        int alt149=2;
                        int LA149_0 = input.LA(1);

                        if ( (LA149_0==109) ) {
                            alt149=1;
                        }


                        switch (alt149) {
                    	case 1 :
                    	    // InternalRoom.g:6696:1: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6696:1: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6697:3: lv_annotations_8_0= ruleAnnotation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_123);
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
                    	    break loop149;
                        }
                    } while (true);

                    // InternalRoom.g:6713:3: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt150=2;
                    int LA150_0 = input.LA(1);

                    if ( (LA150_0==95) ) {
                        alt150=1;
                    }
                    switch (alt150) {
                        case 1 :
                            // InternalRoom.g:6713:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,95,FOLLOW_124); 

                                	newLeafNode(otherlv_9, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_2_0());
                                
                            // InternalRoom.g:6717:1: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6718:1: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6718:1: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6719:3: lv_action_10_0= ruleDetailCode
                            {
                             
                            	        newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_62);
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

                    otherlv_11=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6747:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalRoom.g:6748:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalRoom.g:6749:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
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
    // InternalRoom.g:6756:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) ;
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
            // InternalRoom.g:6759:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) )
            // InternalRoom.g:6760:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            {
            // InternalRoom.g:6760:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            // InternalRoom.g:6760:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_120); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6764:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==RULE_ID) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // InternalRoom.g:6765:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6765:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6766:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_122); 

                	newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6786:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6787:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6787:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6788:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_4=(Token)match(input,20,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:6808:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6809:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6809:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6810:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6826:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==35) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // InternalRoom.g:6827:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6827:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6828:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_125); 

                	newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            otherlv_8=(Token)match(input,96,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
                
            otherlv_9=(Token)match(input,14,FOLLOW_126); 

                	newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalRoom.g:6856:1: ( (lv_annotations_10_0= ruleAnnotation ) )*
            loop154:
            do {
                int alt154=2;
                int LA154_0 = input.LA(1);

                if ( (LA154_0==109) ) {
                    alt154=1;
                }


                switch (alt154) {
            	case 1 :
            	    // InternalRoom.g:6857:1: (lv_annotations_10_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:6857:1: (lv_annotations_10_0= ruleAnnotation )
            	    // InternalRoom.g:6858:3: lv_annotations_10_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getAnnotationsAnnotationParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_126);
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
            	    break loop154;
                }
            } while (true);

            // InternalRoom.g:6874:3: ( (lv_triggers_11_0= ruleTrigger ) )
            // InternalRoom.g:6875:1: (lv_triggers_11_0= ruleTrigger )
            {
            // InternalRoom.g:6875:1: (lv_triggers_11_0= ruleTrigger )
            // InternalRoom.g:6876:3: lv_triggers_11_0= ruleTrigger
            {
             
            	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_0()); 
            	    
            pushFollow(FOLLOW_127);
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

            // InternalRoom.g:6892:2: (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )*
            loop155:
            do {
                int alt155=2;
                int LA155_0 = input.LA(1);

                if ( (LA155_0==97) ) {
                    alt155=1;
                }


                switch (alt155) {
            	case 1 :
            	    // InternalRoom.g:6892:4: otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) )
            	    {
            	    otherlv_12=(Token)match(input,97,FOLLOW_126); 

            	        	newLeafNode(otherlv_12, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_12_0());
            	        
            	    // InternalRoom.g:6896:1: ( (lv_triggers_13_0= ruleTrigger ) )
            	    // InternalRoom.g:6897:1: (lv_triggers_13_0= ruleTrigger )
            	    {
            	    // InternalRoom.g:6897:1: (lv_triggers_13_0= ruleTrigger )
            	    // InternalRoom.g:6898:3: lv_triggers_13_0= ruleTrigger
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_127);
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
            	    break loop155;
                }
            } while (true);

            otherlv_14=(Token)match(input,15,FOLLOW_128); 

                	newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_13());
                
            // InternalRoom.g:6918:1: (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==95) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalRoom.g:6918:3: otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) )
                    {
                    otherlv_15=(Token)match(input,95,FOLLOW_124); 

                        	newLeafNode(otherlv_15, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_14_0());
                        
                    // InternalRoom.g:6922:1: ( (lv_action_16_0= ruleDetailCode ) )
                    // InternalRoom.g:6923:1: (lv_action_16_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6923:1: (lv_action_16_0= ruleDetailCode )
                    // InternalRoom.g:6924:3: lv_action_16_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FOLLOW_62);
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

            otherlv_17=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:6952:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalRoom.g:6953:2: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalRoom.g:6954:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
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
    // InternalRoom.g:6961:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:6964:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:6965:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:6965:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:6965:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_120); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:6969:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==RULE_ID) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // InternalRoom.g:6970:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6970:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6971:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_122); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:6991:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6992:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6992:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6993:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_4=(Token)match(input,20,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:7013:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7014:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7014:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:7015:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:7031:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==35) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // InternalRoom.g:7032:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7032:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:7033:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_129); 

                	newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // InternalRoom.g:7053:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop159:
            do {
                int alt159=2;
                int LA159_0 = input.LA(1);

                if ( (LA159_0==109) ) {
                    alt159=1;
                }


                switch (alt159) {
            	case 1 :
            	    // InternalRoom.g:7054:1: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7054:1: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:7055:3: lv_annotations_8_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_129);
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
            	    break loop159;
                }
            } while (true);

            otherlv_9=(Token)match(input,98,FOLLOW_130); 

                	newLeafNode(otherlv_9, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_9());
                
            // InternalRoom.g:7075:1: ( (lv_guard_10_0= ruleDetailCode ) )
            // InternalRoom.g:7076:1: (lv_guard_10_0= ruleDetailCode )
            {
            // InternalRoom.g:7076:1: (lv_guard_10_0= ruleDetailCode )
            // InternalRoom.g:7077:3: lv_guard_10_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_128);
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

            // InternalRoom.g:7093:2: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==95) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalRoom.g:7093:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,95,FOLLOW_124); 

                        	newLeafNode(otherlv_11, grammarAccess.getGuardedTransitionAccess().getActionKeyword_11_0());
                        
                    // InternalRoom.g:7097:1: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:7098:1: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:7098:1: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:7099:3: lv_action_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FOLLOW_62);
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

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7127:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalRoom.g:7128:2: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalRoom.g:7129:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
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
    // InternalRoom.g:7136:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:7139:28: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:7140:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:7140:1: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:7140:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_120); 

                	newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
                
            // InternalRoom.g:7144:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==RULE_ID) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // InternalRoom.g:7145:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:7145:1: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:7146:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,16,FOLLOW_122); 

                	newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
                
            // InternalRoom.g:7166:1: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7167:1: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7167:1: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:7168:3: lv_from_3_0= ruleTransitionTerminal
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            otherlv_4=(Token)match(input,20,FOLLOW_122); 

                	newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalRoom.g:7188:1: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7189:1: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7189:1: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:7190:3: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:7206:2: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==35) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalRoom.g:7207:1: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7207:1: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:7208:3: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_131); 

                	newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
                
            // InternalRoom.g:7228:1: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop163:
            do {
                int alt163=2;
                int LA163_0 = input.LA(1);

                if ( (LA163_0==109) ) {
                    alt163=1;
                }


                switch (alt163) {
            	case 1 :
            	    // InternalRoom.g:7229:1: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7229:1: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:7230:3: lv_annotations_8_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_131);
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
            	    break loop163;
                }
            } while (true);

            otherlv_9=(Token)match(input,99,FOLLOW_130); 

                	newLeafNode(otherlv_9, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_9());
                
            // InternalRoom.g:7250:1: ( (lv_condition_10_0= ruleDetailCode ) )
            // InternalRoom.g:7251:1: (lv_condition_10_0= ruleDetailCode )
            {
            // InternalRoom.g:7251:1: (lv_condition_10_0= ruleDetailCode )
            // InternalRoom.g:7252:3: lv_condition_10_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_128);
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

            // InternalRoom.g:7268:2: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt164=2;
            int LA164_0 = input.LA(1);

            if ( (LA164_0==95) ) {
                alt164=1;
            }
            switch (alt164) {
                case 1 :
                    // InternalRoom.g:7268:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,95,FOLLOW_124); 

                        	newLeafNode(otherlv_11, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_11_0());
                        
                    // InternalRoom.g:7272:1: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:7273:1: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:7273:1: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:7274:3: lv_action_12_0= ruleDetailCode
                    {
                     
                    	        newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FOLLOW_62);
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

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7302:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalRoom.g:7303:2: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalRoom.g:7304:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
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
    // InternalRoom.g:7311:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) ;
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
            // InternalRoom.g:7314:28: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) )
            // InternalRoom.g:7315:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            {
            // InternalRoom.g:7315:1: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            // InternalRoom.g:7315:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
                
            // InternalRoom.g:7319:1: ( ( ruleFQN ) )
            // InternalRoom.g:7320:1: ( ruleFQN )
            {
            // InternalRoom.g:7320:1: ( ruleFQN )
            // InternalRoom.g:7321:3: ruleFQN
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

            // InternalRoom.g:7334:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt165=2;
            int LA165_0 = input.LA(1);

            if ( (LA165_0==35) ) {
                alt165=1;
            }
            switch (alt165) {
                case 1 :
                    // InternalRoom.g:7335:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7335:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:7336:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_132); 

                	newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalRoom.g:7356:1: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop166:
            do {
                int alt166=2;
                int LA166_0 = input.LA(1);

                if ( (LA166_0==109) ) {
                    alt166=1;
                }


                switch (alt166) {
            	case 1 :
            	    // InternalRoom.g:7357:1: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7357:1: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:7358:3: lv_annotations_4_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getAnnotationsAnnotationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_132);
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
            	    break loop166;
                }
            } while (true);

            otherlv_5=(Token)match(input,95,FOLLOW_124); 

                	newLeafNode(otherlv_5, grammarAccess.getRefinedTransitionAccess().getActionKeyword_5());
                
            // InternalRoom.g:7378:1: ( (lv_action_6_0= ruleDetailCode ) )
            // InternalRoom.g:7379:1: (lv_action_6_0= ruleDetailCode )
            {
            // InternalRoom.g:7379:1: (lv_action_6_0= ruleDetailCode )
            // InternalRoom.g:7380:3: lv_action_6_0= ruleDetailCode
            {
             
            	        newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_62);
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

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

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
    // InternalRoom.g:7408:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalRoom.g:7409:2: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalRoom.g:7410:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
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
    // InternalRoom.g:7417:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7420:28: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalRoom.g:7421:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalRoom.g:7421:1: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt167=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA167_1 = input.LA(2);

                if ( (LA167_1==EOF||(LA167_1>=14 && LA167_1<=15)||LA167_1==20||LA167_1==35||(LA167_1>=81 && LA167_1<=82)||(LA167_1>=88 && LA167_1<=93)||LA167_1==100) ) {
                    alt167=1;
                }
                else if ( (LA167_1==25) ) {
                    alt167=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 167, 1, input);

                    throw nvae;
                }
                }
                break;
            case 101:
                {
                alt167=2;
                }
                break;
            case 102:
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
                    // InternalRoom.g:7422:5: this_StateTerminal_0= ruleStateTerminal
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
                    // InternalRoom.g:7432:5: this_TrPointTerminal_1= ruleTrPointTerminal
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
                    // InternalRoom.g:7442:5: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
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
                    // InternalRoom.g:7452:5: this_ChoicepointTerminal_3= ruleChoicepointTerminal
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
    // InternalRoom.g:7468:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalRoom.g:7469:2: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalRoom.g:7470:2: iv_ruleStateTerminal= ruleStateTerminal EOF
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
    // InternalRoom.g:7477:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7480:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoom.g:7481:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoom.g:7481:1: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7482:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7482:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7483:3: otherlv_0= RULE_ID
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
    // InternalRoom.g:7502:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalRoom.g:7503:2: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalRoom.g:7504:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
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
    // InternalRoom.g:7511:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7514:28: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7515:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7515:1: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7515:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
                
            // InternalRoom.g:7519:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7520:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7520:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7521:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7540:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalRoom.g:7541:2: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalRoom.g:7542:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
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
    // InternalRoom.g:7549:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7552:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7553:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7553:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7553:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7553:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7554:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7554:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7555:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubStateTrPointTerminalRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_88); 

            		newLeafNode(otherlv_0, grammarAccess.getSubStateTrPointTerminalAccess().getTrPointTrPointCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSubStateTrPointTerminalAccess().getOfKeyword_1());
                
            // InternalRoom.g:7570:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7571:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7571:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7572:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7591:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalRoom.g:7592:2: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalRoom.g:7593:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
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
    // InternalRoom.g:7600:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7603:28: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7604:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7604:1: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7604:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,102,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
                
            // InternalRoom.g:7608:1: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7609:1: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7609:1: (otherlv_1= RULE_ID )
            // InternalRoom.g:7610:3: otherlv_1= RULE_ID
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
    // InternalRoom.g:7629:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalRoom.g:7630:2: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalRoom.g:7631:2: iv_ruleTrigger= ruleTrigger EOF
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
    // InternalRoom.g:7638:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalRoom.g:7641:28: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalRoom.g:7642:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalRoom.g:7642:1: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalRoom.g:7642:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
                
            // InternalRoom.g:7646:1: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalRoom.g:7647:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalRoom.g:7647:1: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalRoom.g:7648:3: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {
             
            	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_133);
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

            // InternalRoom.g:7664:2: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop168:
            do {
                int alt168=2;
                int LA168_0 = input.LA(1);

                if ( (LA168_0==104) ) {
                    alt168=1;
                }


                switch (alt168) {
            	case 1 :
            	    // InternalRoom.g:7664:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,104,FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	        
            	    // InternalRoom.g:7668:1: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalRoom.g:7669:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalRoom.g:7669:1: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalRoom.g:7670:3: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_133);
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
            	    break loop168;
                }
            } while (true);

            // InternalRoom.g:7686:4: ( (lv_guard_4_0= ruleGuard ) )?
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==98) ) {
                alt169=1;
            }
            switch (alt169) {
                case 1 :
                    // InternalRoom.g:7687:1: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalRoom.g:7687:1: (lv_guard_4_0= ruleGuard )
                    // InternalRoom.g:7688:3: lv_guard_4_0= ruleGuard
                    {
                     
                    	        newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_134);
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

            otherlv_5=(Token)match(input,105,FOLLOW_2); 

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
    // InternalRoom.g:7716:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalRoom.g:7717:2: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalRoom.g:7718:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
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
    // InternalRoom.g:7725:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:7728:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7729:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7729:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7729:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7729:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7730:1: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7730:1: (otherlv_0= RULE_ID )
            // InternalRoom.g:7731:3: otherlv_0= RULE_ID
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
                
            // InternalRoom.g:7746:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7747:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7747:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7748:3: otherlv_2= RULE_ID
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
    // InternalRoom.g:7767:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalRoom.g:7768:2: (iv_ruleGuard= ruleGuard EOF )
            // InternalRoom.g:7769:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalRoom.g:7776:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7779:28: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:7780:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:7780:1: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:7780:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_46); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                
            // InternalRoom.g:7784:1: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalRoom.g:7785:1: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalRoom.g:7785:1: (lv_guard_1_0= ruleDetailCode )
            // InternalRoom.g:7786:3: lv_guard_1_0= ruleDetailCode
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
    // InternalRoom.g:7810:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // InternalRoom.g:7811:2: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // InternalRoom.g:7812:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
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
    // InternalRoom.g:7819:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7822:28: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // InternalRoom.g:7823:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // InternalRoom.g:7823:1: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // InternalRoom.g:7823:2: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // InternalRoom.g:7823:2: ()
            // InternalRoom.g:7824:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,106,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_135); 

                	newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalRoom.g:7837:1: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop170:
            do {
                int alt170=2;
                int LA170_0 = input.LA(1);

                if ( ((LA170_0>=107 && LA170_0<=108)) ) {
                    alt170=1;
                }


                switch (alt170) {
            	case 1 :
            	    // InternalRoom.g:7838:1: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // InternalRoom.g:7838:1: (lv_rules_3_0= ruleSemanticsRule )
            	    // InternalRoom.g:7839:3: lv_rules_3_0= ruleSemanticsRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_135);
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
            	    break loop170;
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
    // InternalRoom.g:7867:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalRoom.g:7868:2: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalRoom.g:7869:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
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
    // InternalRoom.g:7876:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:7879:28: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalRoom.g:7880:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalRoom.g:7880:1: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==107) ) {
                alt171=1;
            }
            else if ( (LA171_0==108) ) {
                alt171=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 171, 0, input);

                throw nvae;
            }
            switch (alt171) {
                case 1 :
                    // InternalRoom.g:7881:5: this_InSemanticsRule_0= ruleInSemanticsRule
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
                    // InternalRoom.g:7891:5: this_OutSemanticsRule_1= ruleOutSemanticsRule
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
    // InternalRoom.g:7907:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalRoom.g:7908:2: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalRoom.g:7909:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
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
    // InternalRoom.g:7916:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7919:28: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7920:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7920:1: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7920:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,107,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:7928:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7929:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7929:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:7930:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_136); 

            		newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:7941:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==20) ) {
                alt174=1;
            }
            switch (alt174) {
                case 1 :
                    // InternalRoom.g:7941:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_137); 

                        	newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:7945:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt173=2;
                    int LA173_0 = input.LA(1);

                    if ( ((LA173_0>=107 && LA173_0<=108)) ) {
                        alt173=1;
                    }
                    else if ( (LA173_0==21) ) {
                        alt173=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 173, 0, input);

                        throw nvae;
                    }
                    switch (alt173) {
                        case 1 :
                            // InternalRoom.g:7945:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7945:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7946:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7946:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7947:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7964:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7964:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7964:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_138); 

                                	newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:7968:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7969:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7969:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7970:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_139);
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

                            // InternalRoom.g:7986:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt172=0;
                            loop172:
                            do {
                                int alt172=2;
                                int LA172_0 = input.LA(1);

                                if ( (LA172_0==26) ) {
                                    alt172=1;
                                }


                                switch (alt172) {
                            	case 1 :
                            	    // InternalRoom.g:7986:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_138); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:7990:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7991:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7991:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7992:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_42);
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
                            	    if ( cnt172 >= 1 ) break loop172;
                                        EarlyExitException eee =
                                            new EarlyExitException(172, input);
                                        throw eee;
                                }
                                cnt172++;
                            } while (true);

                            otherlv_9=(Token)match(input,22,FOLLOW_2); 

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
    // InternalRoom.g:8020:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalRoom.g:8021:2: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalRoom.g:8022:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
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
    // InternalRoom.g:8029:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:8032:28: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:8033:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:8033:1: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:8033:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,108,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
                
            // InternalRoom.g:8041:1: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:8042:1: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:8042:1: (otherlv_2= RULE_ID )
            // InternalRoom.g:8043:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_136); 

            		newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0()); 
            	

            }


            }

            // InternalRoom.g:8054:2: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==20) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // InternalRoom.g:8054:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_137); 

                        	newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // InternalRoom.g:8058:1: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt176=2;
                    int LA176_0 = input.LA(1);

                    if ( ((LA176_0>=107 && LA176_0<=108)) ) {
                        alt176=1;
                    }
                    else if ( (LA176_0==21) ) {
                        alt176=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 176, 0, input);

                        throw nvae;
                    }
                    switch (alt176) {
                        case 1 :
                            // InternalRoom.g:8058:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:8058:2: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:8059:1: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:8059:1: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:8060:3: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:8077:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:8077:6: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:8077:8: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_138); 

                                	newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                                
                            // InternalRoom.g:8081:1: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:8082:1: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:8082:1: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:8083:3: lv_followUps_6_0= ruleSemanticsRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_139);
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

                            // InternalRoom.g:8099:2: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt175=0;
                            loop175:
                            do {
                                int alt175=2;
                                int LA175_0 = input.LA(1);

                                if ( (LA175_0==26) ) {
                                    alt175=1;
                                }


                                switch (alt175) {
                            	case 1 :
                            	    // InternalRoom.g:8099:4: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_138); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	        
                            	    // InternalRoom.g:8103:1: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:8104:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:8104:1: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:8105:3: lv_followUps_8_0= ruleSemanticsRule
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_42);
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
                            	    if ( cnt175 >= 1 ) break loop175;
                                        EarlyExitException eee =
                                            new EarlyExitException(175, input);
                                        throw eee;
                                }
                                cnt175++;
                            } while (true);

                            otherlv_9=(Token)match(input,22,FOLLOW_2); 

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
    // InternalRoom.g:8133:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalRoom.g:8134:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalRoom.g:8135:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalRoom.g:8142:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalRoom.g:8145:28: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalRoom.g:8146:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalRoom.g:8146:1: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalRoom.g:8146:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,109,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
                
            // InternalRoom.g:8150:1: ( ( ruleFQN ) )
            // InternalRoom.g:8151:1: ( ruleFQN )
            {
            // InternalRoom.g:8151:1: ( ruleFQN )
            // InternalRoom.g:8152:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_140);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalRoom.g:8165:2: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt179=2;
            int LA179_0 = input.LA(1);

            if ( (LA179_0==21) ) {
                alt179=1;
            }
            switch (alt179) {
                case 1 :
                    // InternalRoom.g:8165:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalRoom.g:8169:1: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalRoom.g:8170:1: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalRoom.g:8170:1: (lv_attributes_3_0= ruleKeyValue )
                    // InternalRoom.g:8171:3: lv_attributes_3_0= ruleKeyValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_42);
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

                    // InternalRoom.g:8187:2: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop178:
                    do {
                        int alt178=2;
                        int LA178_0 = input.LA(1);

                        if ( (LA178_0==26) ) {
                            alt178=1;
                        }


                        switch (alt178) {
                    	case 1 :
                    	    // InternalRoom.g:8187:4: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // InternalRoom.g:8191:1: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalRoom.g:8192:1: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalRoom.g:8192:1: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalRoom.g:8193:3: lv_attributes_5_0= ruleKeyValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop178;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

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
    // InternalRoom.g:8221:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalRoom.g:8222:2: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalRoom.g:8223:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalRoom.g:8230:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8233:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalRoom.g:8234:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalRoom.g:8234:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalRoom.g:8234:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalRoom.g:8234:2: ( (lv_key_0_0= RULE_ID ) )
            // InternalRoom.g:8235:1: (lv_key_0_0= RULE_ID )
            {
            // InternalRoom.g:8235:1: (lv_key_0_0= RULE_ID )
            // InternalRoom.g:8236:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_141); 

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

            otherlv_1=(Token)match(input,27,FOLLOW_142); 

                	newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
                
            // InternalRoom.g:8256:1: ( (lv_value_2_0= ruleLiteral ) )
            // InternalRoom.g:8257:1: (lv_value_2_0= ruleLiteral )
            {
            // InternalRoom.g:8257:1: (lv_value_2_0= ruleLiteral )
            // InternalRoom.g:8258:3: lv_value_2_0= ruleLiteral
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
    // InternalRoom.g:8282:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // InternalRoom.g:8283:2: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // InternalRoom.g:8284:2: iv_ruleAnnotationType= ruleAnnotationType EOF
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
    // InternalRoom.g:8291:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
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
            // InternalRoom.g:8294:28: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // InternalRoom.g:8295:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // InternalRoom.g:8295:1: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // InternalRoom.g:8295:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,110,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
                
            // InternalRoom.g:8299:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:8300:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:8300:1: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:8301:3: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:8317:2: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt180=2;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==35) ) {
                alt180=1;
            }
            switch (alt180) {
                case 1 :
                    // InternalRoom.g:8318:1: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:8318:1: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:8319:3: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_143); 

                	newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
                
            otherlv_4=(Token)match(input,111,FOLLOW_141); 

                	newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
                
            otherlv_5=(Token)match(input,27,FOLLOW_144); 

                	newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
                
            // InternalRoom.g:8347:1: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt182=2;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==29||LA182_0==43||LA182_0==49||LA182_0==52||LA182_0==56||LA182_0==60||LA182_0==65||LA182_0==67||(LA182_0>=80 && LA182_0<=82)) ) {
                alt182=1;
            }
            else if ( (LA182_0==14) ) {
                alt182=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);

                throw nvae;
            }
            switch (alt182) {
                case 1 :
                    // InternalRoom.g:8347:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // InternalRoom.g:8347:2: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8348:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8348:1: (lv_targets_6_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8349:3: lv_targets_6_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0()); 
                    	    
                    pushFollow(FOLLOW_145);
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
                    // InternalRoom.g:8366:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // InternalRoom.g:8366:6: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // InternalRoom.g:8366:8: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_146); 

                        	newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                        
                    // InternalRoom.g:8370:1: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8371:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8371:1: (lv_targets_8_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8372:3: lv_targets_8_0= ruleAnnotationTargetType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_21);
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

                    // InternalRoom.g:8388:2: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop181:
                    do {
                        int alt181=2;
                        int LA181_0 = input.LA(1);

                        if ( (LA181_0==26) ) {
                            alt181=1;
                        }


                        switch (alt181) {
                    	case 1 :
                    	    // InternalRoom.g:8388:4: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_146); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	        
                    	    // InternalRoom.g:8392:1: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // InternalRoom.g:8393:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // InternalRoom.g:8393:1: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // InternalRoom.g:8394:3: lv_targets_10_0= ruleAnnotationTargetType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop181;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_145); 

                        	newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                        

                    }


                    }
                    break;

            }

            // InternalRoom.g:8414:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop183:
            do {
                int alt183=2;
                int LA183_0 = input.LA(1);

                if ( ((LA183_0>=112 && LA183_0<=113)) ) {
                    alt183=1;
                }


                switch (alt183) {
            	case 1 :
            	    // InternalRoom.g:8415:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // InternalRoom.g:8415:1: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // InternalRoom.g:8416:3: lv_attributes_12_0= ruleAnnotationAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_145);
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
            	    break loop183;
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
    // InternalRoom.g:8444:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8445:2: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalRoom.g:8446:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalRoom.g:8453:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8456:28: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalRoom.g:8457:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalRoom.g:8457:1: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==112) ) {
                int LA184_1 = input.LA(2);

                if ( (LA184_1==114) ) {
                    int LA184_3 = input.LA(3);

                    if ( (LA184_3==RULE_ID) ) {
                        int LA184_4 = input.LA(4);

                        if ( (LA184_4==16) ) {
                            int LA184_5 = input.LA(5);

                            if ( (LA184_5==14) ) {
                                alt184=2;
                            }
                            else if ( ((LA184_5>=130 && LA184_5<=133)) ) {
                                alt184=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 184, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 184, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 184, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 184, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA184_0==113) ) {
                int LA184_2 = input.LA(2);

                if ( (LA184_2==114) ) {
                    int LA184_3 = input.LA(3);

                    if ( (LA184_3==RULE_ID) ) {
                        int LA184_4 = input.LA(4);

                        if ( (LA184_4==16) ) {
                            int LA184_5 = input.LA(5);

                            if ( (LA184_5==14) ) {
                                alt184=2;
                            }
                            else if ( ((LA184_5>=130 && LA184_5<=133)) ) {
                                alt184=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 184, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 184, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 184, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 184, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 184, 0, input);

                throw nvae;
            }
            switch (alt184) {
                case 1 :
                    // InternalRoom.g:8458:5: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalRoom.g:8468:5: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalRoom.g:8484:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8485:2: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalRoom.g:8486:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalRoom.g:8493:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalRoom.g:8496:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalRoom.g:8497:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalRoom.g:8497:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalRoom.g:8497:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalRoom.g:8497:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt185=2;
            int LA185_0 = input.LA(1);

            if ( (LA185_0==112) ) {
                alt185=1;
            }
            else if ( (LA185_0==113) ) {
                alt185=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 185, 0, input);

                throw nvae;
            }
            switch (alt185) {
                case 1 :
                    // InternalRoom.g:8497:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8497:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8498:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8498:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8499:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,112,FOLLOW_147); 

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
                    // InternalRoom.g:8513:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,113,FOLLOW_147); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,114,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8521:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8522:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8522:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8523:3: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,16,FOLLOW_11); 

                	newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
                
            // InternalRoom.g:8543:1: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalRoom.g:8544:1: (lv_type_5_0= ruleLiteralType )
            {
            // InternalRoom.g:8544:1: (lv_type_5_0= ruleLiteralType )
            // InternalRoom.g:8545:3: lv_type_5_0= ruleLiteralType
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
    // InternalRoom.g:8569:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalRoom.g:8570:2: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalRoom.g:8571:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalRoom.g:8578:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalRoom.g:8581:28: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalRoom.g:8582:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalRoom.g:8582:1: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalRoom.g:8582:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalRoom.g:8582:2: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt186=2;
            int LA186_0 = input.LA(1);

            if ( (LA186_0==112) ) {
                alt186=1;
            }
            else if ( (LA186_0==113) ) {
                alt186=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 186, 0, input);

                throw nvae;
            }
            switch (alt186) {
                case 1 :
                    // InternalRoom.g:8582:3: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8582:3: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8583:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8583:1: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8584:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,112,FOLLOW_147); 

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
                    // InternalRoom.g:8598:7: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,113,FOLLOW_147); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,114,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
                
            // InternalRoom.g:8606:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8607:1: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8607:1: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8608:3: lv_name_3_0= RULE_ID
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
                
            otherlv_5=(Token)match(input,14,FOLLOW_13); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalRoom.g:8632:1: ( (lv_values_6_0= RULE_STRING ) )
            // InternalRoom.g:8633:1: (lv_values_6_0= RULE_STRING )
            {
            // InternalRoom.g:8633:1: (lv_values_6_0= RULE_STRING )
            // InternalRoom.g:8634:3: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_21); 

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

            // InternalRoom.g:8650:2: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop187:
            do {
                int alt187=2;
                int LA187_0 = input.LA(1);

                if ( (LA187_0==26) ) {
                    alt187=1;
                }


                switch (alt187) {
            	case 1 :
            	    // InternalRoom.g:8650:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,26,FOLLOW_13); 

            	        	newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	        
            	    // InternalRoom.g:8654:1: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalRoom.g:8655:1: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8655:1: (lv_values_8_0= RULE_STRING )
            	    // InternalRoom.g:8656:3: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_21); 

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
            	    break loop187;
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
    // InternalRoom.g:8684:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoom.g:8685:2: (iv_ruleImport= ruleImport EOF )
            // InternalRoom.g:8686:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoom.g:8693:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8696:28: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8697:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8697:1: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) ) )
            // InternalRoom.g:8697:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' ) ( (lv_importURI_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,115,FOLLOW_148); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalRoom.g:8701:1: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' ) | otherlv_3= 'model' )
            int alt188=2;
            int LA188_0 = input.LA(1);

            if ( (LA188_0==RULE_ID) ) {
                alt188=1;
            }
            else if ( (LA188_0==117) ) {
                alt188=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 188, 0, input);

                throw nvae;
            }
            switch (alt188) {
                case 1 :
                    // InternalRoom.g:8701:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    {
                    // InternalRoom.g:8701:2: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from' )
                    // InternalRoom.g:8701:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) otherlv_2= 'from'
                    {
                    // InternalRoom.g:8701:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalRoom.g:8702:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalRoom.g:8702:1: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalRoom.g:8703:3: lv_importedNamespace_1_0= ruleImportedFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_149);
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

                    otherlv_2=(Token)match(input,116,FOLLOW_13); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:8724:7: otherlv_3= 'model'
                    {
                    otherlv_3=(Token)match(input,117,FOLLOW_13); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getModelKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalRoom.g:8728:2: ( (lv_importURI_4_0= RULE_STRING ) )
            // InternalRoom.g:8729:1: (lv_importURI_4_0= RULE_STRING )
            {
            // InternalRoom.g:8729:1: (lv_importURI_4_0= RULE_STRING )
            // InternalRoom.g:8730:3: lv_importURI_4_0= RULE_STRING
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
    // InternalRoom.g:8754:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalRoom.g:8755:2: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalRoom.g:8756:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalRoom.g:8763:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8766:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalRoom.g:8767:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalRoom.g:8767:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalRoom.g:8768:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FOLLOW_150);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalRoom.g:8778:1: (kw= '.*' )?
            int alt189=2;
            int LA189_0 = input.LA(1);

            if ( (LA189_0==118) ) {
                alt189=1;
            }
            switch (alt189) {
                case 1 :
                    // InternalRoom.g:8779:2: kw= '.*'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

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
    // InternalRoom.g:8792:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalRoom.g:8793:2: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalRoom.g:8794:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalRoom.g:8801:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8804:28: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalRoom.g:8805:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalRoom.g:8805:1: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalRoom.g:8805:2: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalRoom.g:8805:2: ()
            // InternalRoom.g:8806:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,35,FOLLOW_151); 

                	newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
                
            // InternalRoom.g:8815:1: ( (lv_lines_2_0= RULE_STRING ) )*
            loop190:
            do {
                int alt190=2;
                int LA190_0 = input.LA(1);

                if ( (LA190_0==RULE_STRING) ) {
                    alt190=1;
                }


                switch (alt190) {
            	case 1 :
            	    // InternalRoom.g:8816:1: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8816:1: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:8817:3: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_151); 

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
            	    break loop190;
                }
            } while (true);

            otherlv_3=(Token)match(input,36,FOLLOW_2); 

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
    // InternalRoom.g:8849:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalRoom.g:8850:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalRoom.g:8851:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalRoom.g:8858:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8861:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalRoom.g:8862:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalRoom.g:8862:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt191=3;
            switch ( input.LA(1) ) {
            case 119:
            case 120:
                {
                alt191=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 121:
            case 122:
                {
                alt191=2;
                }
                break;
            case RULE_STRING:
                {
                alt191=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 191, 0, input);

                throw nvae;
            }

            switch (alt191) {
                case 1 :
                    // InternalRoom.g:8863:5: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalRoom.g:8873:5: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalRoom.g:8883:5: this_StringLiteral_2= ruleStringLiteral
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
    // InternalRoom.g:8899:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalRoom.g:8900:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalRoom.g:8901:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalRoom.g:8908:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:8911:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalRoom.g:8912:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalRoom.g:8912:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalRoom.g:8912:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalRoom.g:8912:2: ()
            // InternalRoom.g:8913:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:8918:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt192=2;
            int LA192_0 = input.LA(1);

            if ( (LA192_0==119) ) {
                alt192=1;
            }
            else if ( (LA192_0==120) ) {
                alt192=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 192, 0, input);

                throw nvae;
            }
            switch (alt192) {
                case 1 :
                    // InternalRoom.g:8918:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,119,FOLLOW_2); 

                        	newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8923:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalRoom.g:8923:6: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalRoom.g:8924:1: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalRoom.g:8924:1: (lv_isTrue_2_0= 'true' )
                    // InternalRoom.g:8925:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,120,FOLLOW_2); 

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
    // InternalRoom.g:8946:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalRoom.g:8947:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalRoom.g:8948:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalRoom.g:8955:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8958:28: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalRoom.g:8959:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalRoom.g:8959:1: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt193=2;
            switch ( input.LA(1) ) {
            case 121:
                {
                int LA193_1 = input.LA(2);

                if ( (LA193_1==RULE_INT) ) {
                    int LA193_3 = input.LA(3);

                    if ( (LA193_3==73) ) {
                        alt193=2;
                    }
                    else if ( (LA193_3==EOF||LA193_3==22||LA193_3==26) ) {
                        alt193=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 193, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 193, 1, input);

                    throw nvae;
                }
                }
                break;
            case 122:
                {
                int LA193_2 = input.LA(2);

                if ( (LA193_2==RULE_INT) ) {
                    int LA193_3 = input.LA(3);

                    if ( (LA193_3==73) ) {
                        alt193=2;
                    }
                    else if ( (LA193_3==EOF||LA193_3==22||LA193_3==26) ) {
                        alt193=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 193, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 193, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA193_3 = input.LA(2);

                if ( (LA193_3==73) ) {
                    alt193=2;
                }
                else if ( (LA193_3==EOF||LA193_3==22||LA193_3==26) ) {
                    alt193=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 193, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt193=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 193, 0, input);

                throw nvae;
            }

            switch (alt193) {
                case 1 :
                    // InternalRoom.g:8960:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalRoom.g:8970:5: this_RealLiteral_1= ruleRealLiteral
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
    // InternalRoom.g:8986:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalRoom.g:8987:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalRoom.g:8988:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalRoom.g:8995:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:8998:28: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalRoom.g:8999:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalRoom.g:8999:1: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalRoom.g:8999:2: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalRoom.g:8999:2: ()
            // InternalRoom.g:9000:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:9005:2: ( (lv_value_1_0= ruleReal ) )
            // InternalRoom.g:9006:1: (lv_value_1_0= ruleReal )
            {
            // InternalRoom.g:9006:1: (lv_value_1_0= ruleReal )
            // InternalRoom.g:9007:3: lv_value_1_0= ruleReal
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
    // InternalRoom.g:9031:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalRoom.g:9032:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalRoom.g:9033:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalRoom.g:9040:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:9043:28: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalRoom.g:9044:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalRoom.g:9044:1: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalRoom.g:9044:2: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalRoom.g:9044:2: ()
            // InternalRoom.g:9045:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:9050:2: ( (lv_value_1_0= ruleInteger ) )
            // InternalRoom.g:9051:1: (lv_value_1_0= ruleInteger )
            {
            // InternalRoom.g:9051:1: (lv_value_1_0= ruleInteger )
            // InternalRoom.g:9052:3: lv_value_1_0= ruleInteger
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
    // InternalRoom.g:9076:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalRoom.g:9077:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalRoom.g:9078:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalRoom.g:9085:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9088:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRoom.g:9089:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:9089:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRoom.g:9089:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRoom.g:9089:2: ()
            // InternalRoom.g:9090:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                        current);
                

            }

            // InternalRoom.g:9095:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRoom.g:9096:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalRoom.g:9096:1: (lv_value_1_0= RULE_STRING )
            // InternalRoom.g:9097:3: lv_value_1_0= RULE_STRING
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
    // InternalRoom.g:9121:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalRoom.g:9122:2: (iv_ruleInteger= ruleInteger EOF )
            // InternalRoom.g:9123:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalRoom.g:9130:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9133:28: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalRoom.g:9134:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalRoom.g:9134:1: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt195=2;
            int LA195_0 = input.LA(1);

            if ( (LA195_0==RULE_INT||(LA195_0>=121 && LA195_0<=122)) ) {
                alt195=1;
            }
            else if ( (LA195_0==RULE_HEX) ) {
                alt195=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 195, 0, input);

                throw nvae;
            }
            switch (alt195) {
                case 1 :
                    // InternalRoom.g:9134:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalRoom.g:9134:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalRoom.g:9134:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalRoom.g:9134:3: (kw= '+' | kw= '-' )?
                    int alt194=3;
                    int LA194_0 = input.LA(1);

                    if ( (LA194_0==121) ) {
                        alt194=1;
                    }
                    else if ( (LA194_0==122) ) {
                        alt194=2;
                    }
                    switch (alt194) {
                        case 1 :
                            // InternalRoom.g:9135:2: kw= '+'
                            {
                            kw=(Token)match(input,121,FOLLOW_35); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:9142:2: kw= '-'
                            {
                            kw=(Token)match(input,122,FOLLOW_35); 

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
                    // InternalRoom.g:9155:10: this_HEX_3= RULE_HEX
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
    // InternalRoom.g:9170:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalRoom.g:9171:2: (iv_ruleReal= ruleReal EOF )
            // InternalRoom.g:9172:2: iv_ruleReal= ruleReal EOF
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
    // InternalRoom.g:9179:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;


         enterRule(); 
            
        try {
            // InternalRoom.g:9182:28: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalRoom.g:9183:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalRoom.g:9183:1: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt196=2;
            switch ( input.LA(1) ) {
            case 121:
                {
                int LA196_1 = input.LA(2);

                if ( (LA196_1==RULE_INT) ) {
                    int LA196_3 = input.LA(3);

                    if ( (LA196_3==73) ) {
                        int LA196_4 = input.LA(4);

                        if ( (LA196_4==RULE_INT) ) {
                            int LA196_5 = input.LA(5);

                            if ( ((LA196_5>=123 && LA196_5<=124)) ) {
                                alt196=2;
                            }
                            else if ( (LA196_5==EOF||LA196_5==22||LA196_5==26) ) {
                                alt196=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 196, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 196, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 196, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 196, 1, input);

                    throw nvae;
                }
                }
                break;
            case 122:
                {
                int LA196_2 = input.LA(2);

                if ( (LA196_2==RULE_INT) ) {
                    int LA196_3 = input.LA(3);

                    if ( (LA196_3==73) ) {
                        int LA196_4 = input.LA(4);

                        if ( (LA196_4==RULE_INT) ) {
                            int LA196_5 = input.LA(5);

                            if ( ((LA196_5>=123 && LA196_5<=124)) ) {
                                alt196=2;
                            }
                            else if ( (LA196_5==EOF||LA196_5==22||LA196_5==26) ) {
                                alt196=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 196, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 196, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 196, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 196, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA196_3 = input.LA(2);

                if ( (LA196_3==73) ) {
                    int LA196_4 = input.LA(3);

                    if ( (LA196_4==RULE_INT) ) {
                        int LA196_5 = input.LA(4);

                        if ( ((LA196_5>=123 && LA196_5<=124)) ) {
                            alt196=2;
                        }
                        else if ( (LA196_5==EOF||LA196_5==22||LA196_5==26) ) {
                            alt196=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 196, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 196, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 196, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 196, 0, input);

                throw nvae;
            }

            switch (alt196) {
                case 1 :
                    // InternalRoom.g:9184:5: this_Decimal_0= ruleDecimal
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
                    // InternalRoom.g:9196:5: this_DecimalExp_1= ruleDecimalExp
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
    // InternalRoom.g:9214:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:9218:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalRoom.g:9219:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalRoom.g:9229:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:9233:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalRoom.g:9234:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalRoom.g:9234:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalRoom.g:9234:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalRoom.g:9234:2: (kw= '+' | kw= '-' )?
            int alt197=3;
            int LA197_0 = input.LA(1);

            if ( (LA197_0==121) ) {
                alt197=1;
            }
            else if ( (LA197_0==122) ) {
                alt197=2;
            }
            switch (alt197) {
                case 1 :
                    // InternalRoom.g:9235:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9242:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_103); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,73,FOLLOW_35); 

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
    // InternalRoom.g:9278:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalRoom.g:9282:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalRoom.g:9283:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalRoom.g:9293:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalRoom.g:9297:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalRoom.g:9298:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalRoom.g:9298:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalRoom.g:9298:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalRoom.g:9298:2: (kw= '+' | kw= '-' )?
            int alt198=3;
            int LA198_0 = input.LA(1);

            if ( (LA198_0==121) ) {
                alt198=1;
            }
            else if ( (LA198_0==122) ) {
                alt198=2;
            }
            switch (alt198) {
                case 1 :
                    // InternalRoom.g:9299:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9306:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_103); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
                
            kw=(Token)match(input,73,FOLLOW_35); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
                
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_152); 

            		current.merge(this_INT_4);
                
             
                newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
                
            // InternalRoom.g:9331:1: (kw= 'e' | kw= 'E' )
            int alt199=2;
            int LA199_0 = input.LA(1);

            if ( (LA199_0==123) ) {
                alt199=1;
            }
            else if ( (LA199_0==124) ) {
                alt199=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 199, 0, input);

                throw nvae;
            }
            switch (alt199) {
                case 1 :
                    // InternalRoom.g:9332:2: kw= 'e'
                    {
                    kw=(Token)match(input,123,FOLLOW_153); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9339:2: kw= 'E'
                    {
                    kw=(Token)match(input,124,FOLLOW_153); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1()); 
                        

                    }
                    break;

            }

            // InternalRoom.g:9344:2: (kw= '+' | kw= '-' )?
            int alt200=3;
            int LA200_0 = input.LA(1);

            if ( (LA200_0==121) ) {
                alt200=1;
            }
            else if ( (LA200_0==122) ) {
                alt200=2;
            }
            switch (alt200) {
                case 1 :
                    // InternalRoom.g:9345:2: kw= '+'
                    {
                    kw=(Token)match(input,121,FOLLOW_35); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9352:2: kw= '-'
                    {
                    kw=(Token)match(input,122,FOLLOW_35); 

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
    // InternalRoom.g:9375:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalRoom.g:9376:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalRoom.g:9377:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalRoom.g:9384:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalRoom.g:9387:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoom.g:9388:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoom.g:9388:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoom.g:9388:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_154); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalRoom.g:9395:1: (kw= '.' this_ID_2= RULE_ID )*
            loop201:
            do {
                int alt201=2;
                int LA201_0 = input.LA(1);

                if ( (LA201_0==73) ) {
                    alt201=1;
                }


                switch (alt201) {
            	case 1 :
            	    // InternalRoom.g:9396:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,73,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_154); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop201;
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
    // InternalRoom.g:9416:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalRoom.g:9418:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // InternalRoom.g:9419:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // InternalRoom.g:9419:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt202=3;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt202=1;
                }
                break;
            case 126:
                {
                alt202=2;
                }
                break;
            case 127:
                {
                alt202=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 202, 0, input);

                throw nvae;
            }

            switch (alt202) {
                case 1 :
                    // InternalRoom.g:9419:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9419:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9419:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9425:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9425:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9425:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_2); 

                            current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9431:6: (enumLiteral_2= 'sync' )
                    {
                    // InternalRoom.g:9431:6: (enumLiteral_2= 'sync' )
                    // InternalRoom.g:9431:8: enumLiteral_2= 'sync'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_2); 

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
    // InternalRoom.g:9441:1: ruleReferenceType returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) ;
    public final Enumerator ruleReferenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalRoom.g:9443:28: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) )
            // InternalRoom.g:9444:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            {
            // InternalRoom.g:9444:1: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            int alt203=2;
            int LA203_0 = input.LA(1);

            if ( (LA203_0==128) ) {
                alt203=1;
            }
            else if ( (LA203_0==112) ) {
                alt203=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 203, 0, input);

                throw nvae;
            }
            switch (alt203) {
                case 1 :
                    // InternalRoom.g:9444:2: (enumLiteral_0= 'fixed' )
                    {
                    // InternalRoom.g:9444:2: (enumLiteral_0= 'fixed' )
                    // InternalRoom.g:9444:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                            current = grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9450:6: (enumLiteral_1= 'optional' )
                    {
                    // InternalRoom.g:9450:6: (enumLiteral_1= 'optional' )
                    // InternalRoom.g:9450:8: enumLiteral_1= 'optional'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

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
    // InternalRoom.g:9462:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9464:28: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalRoom.g:9465:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalRoom.g:9465:1: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt204=4;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt204=1;
                }
                break;
            case 126:
                {
                alt204=2;
                }
                break;
            case 129:
                {
                alt204=3;
                }
                break;
            case 127:
                {
                alt204=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 204, 0, input);

                throw nvae;
            }

            switch (alt204) {
                case 1 :
                    // InternalRoom.g:9465:2: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9465:2: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9465:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9471:6: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9471:6: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9471:8: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9477:6: (enumLiteral_2= 'async' )
                    {
                    // InternalRoom.g:9477:6: (enumLiteral_2= 'async' )
                    // InternalRoom.g:9477:8: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,129,FOLLOW_2); 

                            current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9483:6: (enumLiteral_3= 'sync' )
                    {
                    // InternalRoom.g:9483:6: (enumLiteral_3= 'sync' )
                    // InternalRoom.g:9483:8: enumLiteral_3= 'sync'
                    {
                    enumLiteral_3=(Token)match(input,127,FOLLOW_2); 

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
    // InternalRoom.g:9493:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalRoom.g:9495:28: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalRoom.g:9496:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalRoom.g:9496:1: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt205=4;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt205=1;
                }
                break;
            case 131:
                {
                alt205=2;
                }
                break;
            case 132:
                {
                alt205=3;
                }
                break;
            case 133:
                {
                alt205=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 205, 0, input);

                throw nvae;
            }

            switch (alt205) {
                case 1 :
                    // InternalRoom.g:9496:2: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalRoom.g:9496:2: (enumLiteral_0= 'ptBoolean' )
                    // InternalRoom.g:9496:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,130,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9502:6: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalRoom.g:9502:6: (enumLiteral_1= 'ptInteger' )
                    // InternalRoom.g:9502:8: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,131,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9508:6: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalRoom.g:9508:6: (enumLiteral_2= 'ptReal' )
                    // InternalRoom.g:9508:8: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,132,FOLLOW_2); 

                            current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9514:6: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalRoom.g:9514:6: (enumLiteral_3= 'ptCharacter' )
                    // InternalRoom.g:9514:8: enumLiteral_3= 'ptCharacter'
                    {
                    enumLiteral_3=(Token)match(input,133,FOLLOW_2); 

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
    protected DFA140 dfa140 = new DFA140(this);
    protected DFA141 dfa141 = new DFA141(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\17\5\uffff\3\53\5\uffff";
    static final String dfa_3s = "\1\u0081\5\uffff\3\u0081\5\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\3\uffff\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_5s = "\16\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\3\uffff\1\2\4\uffff\1\3\3\uffff\1\4\1\5\15\uffff\1\11\5\uffff\1\11\5\uffff\2\12\10\uffff\1\14\1\uffff\1\13\52\uffff\1\15\16\uffff\1\6\1\7\1\10\1\uffff\1\12",
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
    static final String dfa_7s = "\101\uffff";
    static final String dfa_8s = "\13\uffff\1\22\7\uffff\3\22\1\uffff\1\22\51\uffff";
    static final String dfa_9s = "\1\122\1\4\1\20\1\4\1\24\4\4\2\24\1\16\2\4\1\24\1\4\1\5\1\17\1\uffff\3\16\1\5\1\16\1\4\2\uffff\1\17\2\4\1\17\1\33\1\5\2\26\2\6\3\26\1\4\1\17\1\6\1\33\1\26\1\5\2\6\2\26\2\6\3\26\2\6\1\26\1\6\1\26\4\6\1\26";
    static final String dfa_10s = "\1\122\2\20\1\146\1\31\2\4\1\146\1\4\2\24\1\144\2\4\1\24\1\4\1\44\1\155\1\uffff\3\144\1\44\1\144\1\4\2\uffff\1\155\2\4\1\155\1\33\1\172\2\32\2\6\1\111\2\32\1\4\1\155\1\6\1\33\1\174\3\172\2\32\2\6\1\111\2\32\2\6\1\32\1\6\1\174\2\172\2\6\1\32";
    static final String dfa_11s = "\22\uffff\1\2\6\uffff\1\3\1\1\46\uffff";
    static final String dfa_12s = "\101\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\3",
            "\1\4\140\uffff\1\5\1\6",
            "\1\7\4\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\140\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\21\1\22\11\uffff\1\17\11\uffff\1\20\55\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25",
            "\1\26\36\uffff\1\27",
            "\1\22\117\uffff\1\22\1\32\1\uffff\1\32\1\31\11\uffff\1\30",
            "",
            "\1\21\1\22\23\uffff\1\20\55\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\21\1\22\23\uffff\1\20\55\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\21\1\22\23\uffff\1\20\55\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\26\36\uffff\1\27",
            "\1\21\1\22\101\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\33",
            "",
            "",
            "\1\22\5\uffff\1\35\63\uffff\1\34\25\uffff\1\22\2\uffff\1\32\1\31\11\uffff\1\30",
            "\1\36",
            "\1\37",
            "\1\22\5\uffff\1\35\63\uffff\1\34\25\uffff\1\22\2\uffff\1\32\1\31\11\uffff\1\30",
            "\1\40",
            "\1\47\1\45\1\uffff\1\46\156\uffff\1\41\1\42\1\43\1\44",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\45",
            "\1\45",
            "\1\51\3\uffff\1\50\56\uffff\1\52",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\53",
            "\1\22\117\uffff\1\22\2\uffff\1\32\1\31\11\uffff\1\30",
            "\1\54",
            "\1\55",
            "\1\51\3\uffff\1\50\140\uffff\1\56\1\57",
            "\1\66\1\64\1\uffff\1\65\156\uffff\1\60\1\61\1\62\1\63",
            "\1\71\162\uffff\1\67\1\70",
            "\1\71\162\uffff\1\67\1\70",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\64",
            "\1\64",
            "\1\51\3\uffff\1\50\56\uffff\1\72",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\71",
            "\1\71",
            "\1\51\3\uffff\1\50",
            "\1\73",
            "\1\51\3\uffff\1\50\140\uffff\1\74\1\75",
            "\1\100\162\uffff\1\76\1\77",
            "\1\100\162\uffff\1\76\1\77",
            "\1\100",
            "\1\100",
            "\1\51\3\uffff\1\50"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA140 extends DFA {

        public DFA140(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 140;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "6378:1: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_14s = "\31\uffff";
    static final String dfa_15s = "\1\122\1\4\1\20\1\4\1\24\4\4\3\24\1\16\2\4\1\5\1\140\1\4\2\16\1\5\1\16\2\uffff\1\16";
    static final String dfa_16s = "\1\122\2\20\1\146\1\31\3\4\1\146\3\24\1\43\2\4\1\44\1\155\1\4\2\43\1\44\1\16\2\uffff\1\43";
    static final String dfa_17s = "\26\uffff\1\2\1\1\1\uffff";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\3",
            "\1\4\140\uffff\1\5\1\6",
            "\1\10\4\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\140\uffff\1\15\1\16",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\20\12\uffff\1\21\11\uffff\1\17",
            "\1\22",
            "\1\23",
            "\1\24\36\uffff\1\25",
            "\1\27\1\uffff\1\26\12\uffff\1\26",
            "\1\30",
            "\1\20\24\uffff\1\17",
            "\1\20\24\uffff\1\17",
            "\1\24\36\uffff\1\25",
            "\1\20",
            "",
            "",
            "\1\20\24\uffff\1\17"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA141 extends DFA {

        public DFA141(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 141;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "6428:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0182080031088000L,0xE00840000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0182080031088000L,0xE00040000000000AL,0x0000000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000003CL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000802004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000140L,0x0600000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800800002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000840004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000066780008000L,0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000006670000C080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000066700008000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000006660000C080L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000066600008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000006640000C080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000066400008000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000808000012L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000808000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000800014080L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000800004080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000010800014080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001700380008000L,0x0000240000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x000170030000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001700300008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000170020000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001700200008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000170000000C080L,0x0000040000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0001700000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0018000000008000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0001600000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0001400000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0001000000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000008000L,0x0000040000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0004000000008000L,0x0000200000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0004000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000800200002L,0x0000200000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000800000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0060066400008000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x004006640000C080L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0040066400008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0180000000000000L,0xE000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0E00000000008000L,0x0000200000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x9001000000008000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0C00000000008000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xF001066780008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0xF00106670000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0xF001066700008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0xF00106660000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0xF001066600008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0xF00106640000C080L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0xF001066400008000L,0x0001000000004881L,0x0000000000000001L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0800000000008000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000066000008000L,0x0000200000080000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000066000008000L,0x0000000000080000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000008000L,0x0000200000000884L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000884L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x9001000380008000L,0x00012000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x900100030000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x9001000300008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x900100020000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x9001000200008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x900100000000C080L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x9001000000008000L,0x00010000000048B0L,0x0000000000000001L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000020L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000040000L,0x0000000000002000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000040L,0x0000000000008000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000008000L,0x000000103F060000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000008000L,0x0000200000F00000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x000000000000C080L,0x0000000000E00000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000008000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x000000000000C080L,0x0000000000C00000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000008000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x000000000000C080L,0x0000000000800000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000008000L,0x0000000000800000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000010L,0x0000006000000000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000008000L,0x0000200080000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x000000000000C080L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000000000L,0x0000208000000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000008000L,0x0000000200000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000008000L,0x0000000080000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000000000L,0x0000200400000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x000000000000C080L,0x0000000080000000L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000000L,0x0000200800000000L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000000L,0x0000200080000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000000000L,0x0000030400000000L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000008000L,0x0000180000000000L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0000000000200000L,0x0000180000000000L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000000000000L,0x0000180000000000L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_141 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_142 = new BitSet(new long[]{0x0000000000000160L,0x0780000000000000L});
    public static final BitSet FOLLOW_143 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_144 = new BitSet(new long[]{0x1112080020004000L,0x000000000007000AL});
    public static final BitSet FOLLOW_145 = new BitSet(new long[]{0x0000000000008000L,0x0003000000000000L});
    public static final BitSet FOLLOW_146 = new BitSet(new long[]{0x1112080020000000L,0x000000000007000AL});
    public static final BitSet FOLLOW_147 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_148 = new BitSet(new long[]{0x0000000000000010L,0x0020000000000000L});
    public static final BitSet FOLLOW_149 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_150 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_151 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_152 = new BitSet(new long[]{0x0000000000000000L,0x1800000000000000L});
    public static final BitSet FOLLOW_153 = new BitSet(new long[]{0x0000000000000040L,0x0600000000000000L});
    public static final BitSet FOLLOW_154 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});

}
