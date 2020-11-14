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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_CC_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'RoomModel'", "'{'", "'}'", "':'", "'varargs'", "'ref'", "'PrimitiveType'", "'->'", "'('", "')'", "'default'", "'Enumeration'", "'of'", "','", "'='", "'ExternalType'", "'DataClass'", "'extends'", "'usercode1'", "'usercode2'", "'usercode3'", "'Attribute'", "'['", "']'", "'override'", "'Operation'", "'void'", "'sends'", "'ctor'", "'dtor'", "'ProtocolClass'", "'incoming'", "'outgoing'", "'regular'", "'PortClass'", "'conjugated'", "'private'", "'Message'", "'usercode'", "'handle'", "'abstract'", "'ActorClass'", "'Interface'", "'Structure'", "'Behavior'", "'Port'", "'external'", "'SAP'", "'SPP'", "'ServiceImplementation'", "'LogicalSystem'", "'SubSystemRef'", "'SubSystemClass'", "'LogicalThread'", "'ActorInstanceMapping'", "'/'", "'Binding'", "'and'", "'.'", "'LayerConnection'", "'satisfied_by'", "'relay_sap'", "'ActorRef'", "'*'", "'ActorBehavior'", "'CompoundProtocolClass'", "'State'", "'Transition'", "'StateMachine'", "'entry'", "'exit'", "'do'", "'subgraph'", "'RefinedState'", "'handler'", "'TransitionPoint'", "'EntryPoint'", "'ExitPoint'", "'ChoicePoint'", "'initial'", "'action'", "'triggers'", "'or'", "'guard'", "'cond'", "'RefinedTransition'", "'my'", "'cp'", "'<'", "'|'", "'>'", "'semantics'", "'in'", "'out'", "'@'", "'AnnotationType'", "'target'", "'optional'", "'mandatory'", "'attribute'", "'import'", "'from'", "'model'", "'.*'", "'false'", "'true'", "'+'", "'-'", "'e'", "'E'", "'eventdriven'", "'datadriven'", "'sync'", "'fixed'", "'async'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'"
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
    // InternalRoom.g:65:1: entryRuleRoomModel returns [EObject current=null] : iv_ruleRoomModel= ruleRoomModel EOF ;
    public final EObject entryRuleRoomModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomModel = null;


        try {
            // InternalRoom.g:65:50: (iv_ruleRoomModel= ruleRoomModel EOF )
            // InternalRoom.g:66:2: iv_ruleRoomModel= ruleRoomModel EOF
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
    // InternalRoom.g:72:1: ruleRoomModel returns [EObject current=null] : (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' ) ;
    public final EObject ruleRoomModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_docu_2_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_imports_5_0 = null;

        EObject lv_annotationTypes_6_0 = null;

        EObject lv_roomClasses_7_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:78:2: ( (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' ) )
            // InternalRoom.g:79:2: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:79:2: (otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}' )
            // InternalRoom.g:80:3: otherlv_0= 'RoomModel' ( (lv_name_1_0= ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( (lv_imports_5_0= ruleImport ) )* ( (lv_annotationTypes_6_0= ruleAnnotationType ) )* ( (lv_roomClasses_7_0= ruleRoomClass ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRoomModelAccess().getRoomModelKeyword_0());
            		
            // InternalRoom.g:84:3: ( (lv_name_1_0= ruleFQN ) )
            // InternalRoom.g:85:4: (lv_name_1_0= ruleFQN )
            {
            // InternalRoom.g:85:4: (lv_name_1_0= ruleFQN )
            // InternalRoom.g:86:5: lv_name_1_0= ruleFQN
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

            // InternalRoom.g:103:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==35) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalRoom.g:104:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:104:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:105:5: lv_docu_2_0= ruleDocumentation
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
            		
            // InternalRoom.g:126:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==107) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRoom.g:127:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:127:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:128:5: lv_annotations_4_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getRoomModelAccess().getAnnotationsAnnotationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomModelRule());
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
            	    break loop2;
                }
            } while (true);

            // InternalRoom.g:145:3: ( (lv_imports_5_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==113) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRoom.g:146:4: (lv_imports_5_0= ruleImport )
            	    {
            	    // InternalRoom.g:146:4: (lv_imports_5_0= ruleImport )
            	    // InternalRoom.g:147:5: lv_imports_5_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getRoomModelAccess().getImportsImportParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_imports_5_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_5_0,
            	    						"org.eclipse.etrice.core.common.Base.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalRoom.g:164:3: ( (lv_annotationTypes_6_0= ruleAnnotationType ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==108) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRoom.g:165:4: (lv_annotationTypes_6_0= ruleAnnotationType )
            	    {
            	    // InternalRoom.g:165:4: (lv_annotationTypes_6_0= ruleAnnotationType )
            	    // InternalRoom.g:166:5: lv_annotationTypes_6_0= ruleAnnotationType
            	    {

            	    					newCompositeNode(grammarAccess.getRoomModelAccess().getAnnotationTypesAnnotationTypeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotationTypes_6_0=ruleAnnotationType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotationTypes",
            	    						lv_annotationTypes_6_0,
            	    						"org.eclipse.etrice.core.common.Base.AnnotationType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalRoom.g:183:3: ( (lv_roomClasses_7_0= ruleRoomClass ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19||LA5_0==24||(LA5_0>=28 && LA5_0<=29)||LA5_0==43||(LA5_0>=53 && LA5_0<=54)||LA5_0==63||LA5_0==65||(LA5_0>=123 && LA5_0<=125)||LA5_0==127) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRoom.g:184:4: (lv_roomClasses_7_0= ruleRoomClass )
            	    {
            	    // InternalRoom.g:184:4: (lv_roomClasses_7_0= ruleRoomClass )
            	    // InternalRoom.g:185:5: lv_roomClasses_7_0= ruleRoomClass
            	    {

            	    					newCompositeNode(grammarAccess.getRoomModelAccess().getRoomClassesRoomClassParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_roomClasses_7_0=ruleRoomClass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"roomClasses",
            	    						lv_roomClasses_7_0,
            	    						"org.eclipse.etrice.core.Room.RoomClass");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRoomModelAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleRoomClass"
    // InternalRoom.g:210:1: entryRuleRoomClass returns [EObject current=null] : iv_ruleRoomClass= ruleRoomClass EOF ;
    public final EObject entryRuleRoomClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoomClass = null;


        try {
            // InternalRoom.g:210:50: (iv_ruleRoomClass= ruleRoomClass EOF )
            // InternalRoom.g:211:2: iv_ruleRoomClass= ruleRoomClass EOF
            {
             newCompositeNode(grammarAccess.getRoomClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoomClass=ruleRoomClass();

            state._fsp--;

             current =iv_ruleRoomClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoomClass"


    // $ANTLR start "ruleRoomClass"
    // InternalRoom.g:217:1: ruleRoomClass returns [EObject current=null] : (this_DataType_0= ruleDataType | this_ProtocolClass_1= ruleProtocolClass | this_StructureClass_2= ruleStructureClass ) ;
    public final EObject ruleRoomClass() throws RecognitionException {
        EObject current = null;

        EObject this_DataType_0 = null;

        EObject this_ProtocolClass_1 = null;

        EObject this_StructureClass_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:223:2: ( (this_DataType_0= ruleDataType | this_ProtocolClass_1= ruleProtocolClass | this_StructureClass_2= ruleStructureClass ) )
            // InternalRoom.g:224:2: (this_DataType_0= ruleDataType | this_ProtocolClass_1= ruleProtocolClass | this_StructureClass_2= ruleStructureClass )
            {
            // InternalRoom.g:224:2: (this_DataType_0= ruleDataType | this_ProtocolClass_1= ruleProtocolClass | this_StructureClass_2= ruleStructureClass )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 19:
            case 24:
            case 28:
            case 29:
                {
                alt6=1;
                }
                break;
            case 123:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==43) ) {
                    alt6=2;
                }
                else if ( ((LA6_2>=53 && LA6_2<=54)||(LA6_2>=123 && LA6_2<=125)||LA6_2==127) ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case 124:
                {
                int LA6_3 = input.LA(2);

                if ( ((LA6_3>=53 && LA6_3<=54)||(LA6_3>=123 && LA6_3<=125)||LA6_3==127) ) {
                    alt6=3;
                }
                else if ( (LA6_3==43) ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            case 125:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==43) ) {
                    alt6=2;
                }
                else if ( ((LA6_4>=53 && LA6_4<=54)||(LA6_4>=123 && LA6_4<=125)||LA6_4==127) ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 4, input);

                    throw nvae;
                }
                }
                break;
            case 43:
                {
                alt6=2;
                }
                break;
            case 53:
            case 54:
            case 63:
            case 65:
            case 127:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalRoom.g:225:3: this_DataType_0= ruleDataType
                    {

                    			newCompositeNode(grammarAccess.getRoomClassAccess().getDataTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataType_0=ruleDataType();

                    state._fsp--;


                    			current = this_DataType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoom.g:234:3: this_ProtocolClass_1= ruleProtocolClass
                    {

                    			newCompositeNode(grammarAccess.getRoomClassAccess().getProtocolClassParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ProtocolClass_1=ruleProtocolClass();

                    state._fsp--;


                    			current = this_ProtocolClass_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoom.g:243:3: this_StructureClass_2= ruleStructureClass
                    {

                    			newCompositeNode(grammarAccess.getRoomClassAccess().getStructureClassParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StructureClass_2=ruleStructureClass();

                    state._fsp--;


                    			current = this_StructureClass_2;
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
    // $ANTLR end "ruleRoomClass"


    // $ANTLR start "entryRuleStructureClass"
    // InternalRoom.g:255:1: entryRuleStructureClass returns [EObject current=null] : iv_ruleStructureClass= ruleStructureClass EOF ;
    public final EObject entryRuleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureClass = null;


        try {
            // InternalRoom.g:255:55: (iv_ruleStructureClass= ruleStructureClass EOF )
            // InternalRoom.g:256:2: iv_ruleStructureClass= ruleStructureClass EOF
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
    // InternalRoom.g:262:1: ruleStructureClass returns [EObject current=null] : (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) ;
    public final EObject ruleStructureClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorContainerClass_0 = null;

        EObject this_LogicalSystem_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:268:2: ( (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem ) )
            // InternalRoom.g:269:2: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            {
            // InternalRoom.g:269:2: (this_ActorContainerClass_0= ruleActorContainerClass | this_LogicalSystem_1= ruleLogicalSystem )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=53 && LA7_0<=54)||LA7_0==65||(LA7_0>=123 && LA7_0<=125)||LA7_0==127) ) {
                alt7=1;
            }
            else if ( (LA7_0==63) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalRoom.g:270:3: this_ActorContainerClass_0= ruleActorContainerClass
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
                    // InternalRoom.g:279:3: this_LogicalSystem_1= ruleLogicalSystem
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
    // InternalRoom.g:291:1: entryRuleActorContainerClass returns [EObject current=null] : iv_ruleActorContainerClass= ruleActorContainerClass EOF ;
    public final EObject entryRuleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorContainerClass = null;


        try {
            // InternalRoom.g:291:60: (iv_ruleActorContainerClass= ruleActorContainerClass EOF )
            // InternalRoom.g:292:2: iv_ruleActorContainerClass= ruleActorContainerClass EOF
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
    // InternalRoom.g:298:1: ruleActorContainerClass returns [EObject current=null] : (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) ;
    public final EObject ruleActorContainerClass() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;

        EObject this_SubSystemClass_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:304:2: ( (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass ) )
            // InternalRoom.g:305:2: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            {
            // InternalRoom.g:305:2: (this_ActorClass_0= ruleActorClass | this_SubSystemClass_1= ruleSubSystemClass )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=53 && LA8_0<=54)||(LA8_0>=123 && LA8_0<=125)||LA8_0==127) ) {
                alt8=1;
            }
            else if ( (LA8_0==65) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoom.g:306:3: this_ActorClass_0= ruleActorClass
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
                    // InternalRoom.g:315:3: this_SubSystemClass_1= ruleSubSystemClass
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
    // InternalRoom.g:327:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalRoom.g:327:48: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalRoom.g:328:2: iv_ruleVarDecl= ruleVarDecl EOF
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
    // InternalRoom.g:334:1: ruleVarDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_varargs_3_0=null;
        EObject lv_refType_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:340:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? ) )
            // InternalRoom.g:341:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            {
            // InternalRoom.g:341:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )? )
            // InternalRoom.g:342:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_refType_2_0= ruleRefableType ) ) ( (lv_varargs_3_0= 'varargs' ) )?
            {
            // InternalRoom.g:342:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:343:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:343:4: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:344:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
            		
            // InternalRoom.g:364:3: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:365:4: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:365:4: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:366:5: lv_refType_2_0= ruleRefableType
            {

            					newCompositeNode(grammarAccess.getVarDeclAccess().getRefTypeRefableTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
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

            // InternalRoom.g:383:3: ( (lv_varargs_3_0= 'varargs' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoom.g:384:4: (lv_varargs_3_0= 'varargs' )
                    {
                    // InternalRoom.g:384:4: (lv_varargs_3_0= 'varargs' )
                    // InternalRoom.g:385:5: lv_varargs_3_0= 'varargs'
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
    // InternalRoom.g:401:1: entryRuleMessageData returns [EObject current=null] : iv_ruleMessageData= ruleMessageData EOF ;
    public final EObject entryRuleMessageData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageData = null;


        try {
            // InternalRoom.g:401:52: (iv_ruleMessageData= ruleMessageData EOF )
            // InternalRoom.g:402:2: iv_ruleMessageData= ruleMessageData EOF
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
    // InternalRoom.g:408:1: ruleMessageData returns [EObject current=null] : ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) ;
    public final EObject ruleMessageData() throws RecognitionException {
        EObject current = null;

        Token lv_deprecatedName_0_0=null;
        Token otherlv_1=null;
        EObject lv_refType_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:414:2: ( ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) ) )
            // InternalRoom.g:415:2: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            {
            // InternalRoom.g:415:2: ( ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) ) )
            // InternalRoom.g:416:3: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )? ( (lv_refType_2_0= ruleRefableType ) )
            {
            // InternalRoom.g:416:3: ( ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==16) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // InternalRoom.g:417:4: ( (lv_deprecatedName_0_0= RULE_ID ) ) otherlv_1= ':'
                    {
                    // InternalRoom.g:417:4: ( (lv_deprecatedName_0_0= RULE_ID ) )
                    // InternalRoom.g:418:5: (lv_deprecatedName_0_0= RULE_ID )
                    {
                    // InternalRoom.g:418:5: (lv_deprecatedName_0_0= RULE_ID )
                    // InternalRoom.g:419:6: lv_deprecatedName_0_0= RULE_ID
                    {
                    lv_deprecatedName_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            // InternalRoom.g:440:3: ( (lv_refType_2_0= ruleRefableType ) )
            // InternalRoom.g:441:4: (lv_refType_2_0= ruleRefableType )
            {
            // InternalRoom.g:441:4: (lv_refType_2_0= ruleRefableType )
            // InternalRoom.g:442:5: lv_refType_2_0= ruleRefableType
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
    // InternalRoom.g:463:1: entryRuleRefableType returns [EObject current=null] : iv_ruleRefableType= ruleRefableType EOF ;
    public final EObject entryRuleRefableType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefableType = null;


        try {
            // InternalRoom.g:463:52: (iv_ruleRefableType= ruleRefableType EOF )
            // InternalRoom.g:464:2: iv_ruleRefableType= ruleRefableType EOF
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
    // InternalRoom.g:470:1: ruleRefableType returns [EObject current=null] : ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) ;
    public final EObject ruleRefableType() throws RecognitionException {
        EObject current = null;

        Token lv_ref_1_0=null;


        	enterRule();

        try {
            // InternalRoom.g:476:2: ( ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? ) )
            // InternalRoom.g:477:2: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            {
            // InternalRoom.g:477:2: ( ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )? )
            // InternalRoom.g:478:3: ( ( ruleFQN ) ) ( (lv_ref_1_0= 'ref' ) )?
            {
            // InternalRoom.g:478:3: ( ( ruleFQN ) )
            // InternalRoom.g:479:4: ( ruleFQN )
            {
            // InternalRoom.g:479:4: ( ruleFQN )
            // InternalRoom.g:480:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefableTypeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRefableTypeAccess().getTypeDataTypeCrossReference_0_0());
            				
            pushFollow(FOLLOW_12);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:494:3: ( (lv_ref_1_0= 'ref' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRoom.g:495:4: (lv_ref_1_0= 'ref' )
                    {
                    // InternalRoom.g:495:4: (lv_ref_1_0= 'ref' )
                    // InternalRoom.g:496:5: lv_ref_1_0= 'ref'
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
    // InternalRoom.g:512:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalRoom.g:512:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalRoom.g:513:2: iv_ruleDataType= ruleDataType EOF
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
    // InternalRoom.g:519:1: ruleDataType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_EnumerationType_1 = null;

        EObject this_ComplexType_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:525:2: ( (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType ) )
            // InternalRoom.g:526:2: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            {
            // InternalRoom.g:526:2: (this_PrimitiveType_0= rulePrimitiveType | this_EnumerationType_1= ruleEnumerationType | this_ComplexType_2= ruleComplexType )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt12=1;
                }
                break;
            case 24:
                {
                alt12=2;
                }
                break;
            case 28:
            case 29:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalRoom.g:527:3: this_PrimitiveType_0= rulePrimitiveType
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
                    // InternalRoom.g:536:3: this_EnumerationType_1= ruleEnumerationType
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
                    // InternalRoom.g:545:3: this_ComplexType_2= ruleComplexType
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
    // InternalRoom.g:557:1: entryRuleComplexType returns [EObject current=null] : iv_ruleComplexType= ruleComplexType EOF ;
    public final EObject entryRuleComplexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexType = null;


        try {
            // InternalRoom.g:557:52: (iv_ruleComplexType= ruleComplexType EOF )
            // InternalRoom.g:558:2: iv_ruleComplexType= ruleComplexType EOF
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
    // InternalRoom.g:564:1: ruleComplexType returns [EObject current=null] : (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) ;
    public final EObject ruleComplexType() throws RecognitionException {
        EObject current = null;

        EObject this_DataClass_0 = null;

        EObject this_ExternalType_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:570:2: ( (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType ) )
            // InternalRoom.g:571:2: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            {
            // InternalRoom.g:571:2: (this_DataClass_0= ruleDataClass | this_ExternalType_1= ruleExternalType )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==28) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalRoom.g:572:3: this_DataClass_0= ruleDataClass
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
                    // InternalRoom.g:581:3: this_ExternalType_1= ruleExternalType
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
    // InternalRoom.g:593:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalRoom.g:593:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalRoom.g:594:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalRoom.g:600:1: rulePrimitiveType returns [EObject current=null] : (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:606:2: ( (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:607:2: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:607:2: (otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )? )
            // InternalRoom.g:608:3: otherlv_0= 'PrimitiveType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleLiteralType ) ) otherlv_4= '->' ( (lv_targetName_5_0= RULE_STRING ) ) (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )? otherlv_9= 'default' ( (lv_defaultValueLiteral_10_0= RULE_STRING ) ) ( (lv_docu_11_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_0());
            		
            // InternalRoom.g:612:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:613:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:613:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:614:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getPrimitiveTypeAccess().getColonKeyword_2());
            		
            // InternalRoom.g:634:3: ( (lv_type_3_0= ruleLiteralType ) )
            // InternalRoom.g:635:4: (lv_type_3_0= ruleLiteralType )
            {
            // InternalRoom.g:635:4: (lv_type_3_0= ruleLiteralType )
            // InternalRoom.g:636:5: lv_type_3_0= ruleLiteralType
            {

            					newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getTypeLiteralTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:657:3: ( (lv_targetName_5_0= RULE_STRING ) )
            // InternalRoom.g:658:4: (lv_targetName_5_0= RULE_STRING )
            {
            // InternalRoom.g:658:4: (lv_targetName_5_0= RULE_STRING )
            // InternalRoom.g:659:5: lv_targetName_5_0= RULE_STRING
            {
            lv_targetName_5_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

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

            // InternalRoom.g:675:3: (otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRoom.g:676:4: otherlv_6= '(' ( (lv_castName_7_0= ruleFQN ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimitiveTypeAccess().getLeftParenthesisKeyword_6_0());
                    			
                    // InternalRoom.g:680:4: ( (lv_castName_7_0= ruleFQN ) )
                    // InternalRoom.g:681:5: (lv_castName_7_0= ruleFQN )
                    {
                    // InternalRoom.g:681:5: (lv_castName_7_0= ruleFQN )
                    // InternalRoom.g:682:6: lv_castName_7_0= ruleFQN
                    {

                    						newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getCastNameFQNParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    otherlv_8=(Token)match(input,22,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getPrimitiveTypeAccess().getRightParenthesisKeyword_6_2());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,23,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getPrimitiveTypeAccess().getDefaultKeyword_7());
            		
            // InternalRoom.g:708:3: ( (lv_defaultValueLiteral_10_0= RULE_STRING ) )
            // InternalRoom.g:709:4: (lv_defaultValueLiteral_10_0= RULE_STRING )
            {
            // InternalRoom.g:709:4: (lv_defaultValueLiteral_10_0= RULE_STRING )
            // InternalRoom.g:710:5: lv_defaultValueLiteral_10_0= RULE_STRING
            {
            lv_defaultValueLiteral_10_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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

            // InternalRoom.g:726:3: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRoom.g:727:4: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:727:4: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:728:5: lv_docu_11_0= ruleDocumentation
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
    // InternalRoom.g:749:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalRoom.g:749:56: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalRoom.g:750:2: iv_ruleEnumerationType= ruleEnumerationType EOF
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
    // InternalRoom.g:756:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) ;
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
            // InternalRoom.g:762:2: ( (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' ) )
            // InternalRoom.g:763:2: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            {
            // InternalRoom.g:763:2: (otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}' )
            // InternalRoom.g:764:3: otherlv_0= 'Enumeration' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'of' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_0());
            		
            // InternalRoom.g:768:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:769:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:769:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:770:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

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

            // InternalRoom.g:786:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoom.g:787:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:787:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:788:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getEnumerationTypeAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_21);
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

            // InternalRoom.g:805:3: (otherlv_3= 'of' ( ( ruleFQN ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRoom.g:806:4: otherlv_3= 'of' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getOfKeyword_3_0());
                    			
                    // InternalRoom.g:810:4: ( ( ruleFQN ) )
                    // InternalRoom.g:811:5: ( ruleFQN )
                    {
                    // InternalRoom.g:811:5: ( ruleFQN )
                    // InternalRoom.g:812:6: ruleFQN
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

            otherlv_5=(Token)match(input,14,FOLLOW_22); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalRoom.g:831:3: ( ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRoom.g:832:4: ( (lv_literals_6_0= ruleEnumLiteral ) ) (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalRoom.g:832:4: ( (lv_literals_6_0= ruleEnumLiteral ) )
                    // InternalRoom.g:833:5: (lv_literals_6_0= ruleEnumLiteral )
                    {
                    // InternalRoom.g:833:5: (lv_literals_6_0= ruleEnumLiteral )
                    // InternalRoom.g:834:6: lv_literals_6_0= ruleEnumLiteral
                    {

                    						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_23);
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

                    // InternalRoom.g:851:4: (otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==26) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalRoom.g:852:5: otherlv_7= ',' ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_7=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalRoom.g:856:5: ( (lv_literals_8_0= ruleEnumLiteral ) )
                    	    // InternalRoom.g:857:6: (lv_literals_8_0= ruleEnumLiteral )
                    	    {
                    	    // InternalRoom.g:857:6: (lv_literals_8_0= ruleEnumLiteral )
                    	    // InternalRoom.g:858:7: lv_literals_8_0= ruleEnumLiteral
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLiteralsEnumLiteralParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_23);
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
                    	    break loop18;
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
    // InternalRoom.g:885:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalRoom.g:885:52: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalRoom.g:886:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
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
    // InternalRoom.g:892:1: ruleEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:898:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? ) )
            // InternalRoom.g:899:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            {
            // InternalRoom.g:899:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )? )
            // InternalRoom.g:900:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            {
            // InternalRoom.g:900:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRoom.g:901:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRoom.g:901:4: (lv_name_0_0= RULE_ID )
            // InternalRoom.g:902:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

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

            // InternalRoom.g:918:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRoom.g:919:4: otherlv_1= '=' ( (lv_literal_2_0= ruleIntLiteral ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_25); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumLiteralAccess().getEqualsSignKeyword_1_0());
                    			
                    // InternalRoom.g:923:4: ( (lv_literal_2_0= ruleIntLiteral ) )
                    // InternalRoom.g:924:5: (lv_literal_2_0= ruleIntLiteral )
                    {
                    // InternalRoom.g:924:5: (lv_literal_2_0= ruleIntLiteral )
                    // InternalRoom.g:925:6: lv_literal_2_0= ruleIntLiteral
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
    // InternalRoom.g:947:1: entryRuleExternalType returns [EObject current=null] : iv_ruleExternalType= ruleExternalType EOF ;
    public final EObject entryRuleExternalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalType = null;


        try {
            // InternalRoom.g:947:53: (iv_ruleExternalType= ruleExternalType EOF )
            // InternalRoom.g:948:2: iv_ruleExternalType= ruleExternalType EOF
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
    // InternalRoom.g:954:1: ruleExternalType returns [EObject current=null] : (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:960:2: ( (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:961:2: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:961:2: (otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:962:3: otherlv_0= 'ExternalType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '->' ( (lv_targetName_3_0= RULE_STRING ) ) (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )? ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getExternalTypeAccess().getExternalTypeKeyword_0());
            		
            // InternalRoom.g:966:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:967:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:967:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:968:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_2=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getExternalTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalRoom.g:988:3: ( (lv_targetName_3_0= RULE_STRING ) )
            // InternalRoom.g:989:4: (lv_targetName_3_0= RULE_STRING )
            {
            // InternalRoom.g:989:4: (lv_targetName_3_0= RULE_STRING )
            // InternalRoom.g:990:5: lv_targetName_3_0= RULE_STRING
            {
            lv_targetName_3_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

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

            // InternalRoom.g:1006:3: (otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRoom.g:1007:4: otherlv_4= 'default' ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getExternalTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRoom.g:1011:4: ( (lv_defaultValueLiteral_5_0= RULE_STRING ) )
                    // InternalRoom.g:1012:5: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:1012:5: (lv_defaultValueLiteral_5_0= RULE_STRING )
                    // InternalRoom.g:1013:6: lv_defaultValueLiteral_5_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_5_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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

            // InternalRoom.g:1030:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRoom.g:1031:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1031:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:1032:5: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:1053:1: entryRuleDataClass returns [EObject current=null] : iv_ruleDataClass= ruleDataClass EOF ;
    public final EObject entryRuleDataClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataClass = null;


        try {
            // InternalRoom.g:1053:50: (iv_ruleDataClass= ruleDataClass EOF )
            // InternalRoom.g:1054:2: iv_ruleDataClass= ruleDataClass EOF
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
    // InternalRoom.g:1060:1: ruleDataClass returns [EObject current=null] : (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) ;
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
            // InternalRoom.g:1066:2: ( (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' ) )
            // InternalRoom.g:1067:2: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            {
            // InternalRoom.g:1067:2: (otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}' )
            // InternalRoom.g:1068:3: otherlv_0= 'DataClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_annotations_6_0= ruleAnnotation ) )* (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )? (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )? ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDataClassAccess().getDataClassKeyword_0());
            		
            // InternalRoom.g:1072:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1073:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1073:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1074:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            // InternalRoom.g:1090:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRoom.g:1091:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1091:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:1092:5: lv_docu_2_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getDataClassAccess().getDocuDocumentationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_28);
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
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==30) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRoom.g:1110:4: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataClassAccess().getExtendsKeyword_3_0());
                    			
                    // InternalRoom.g:1114:4: ( ( ruleFQN ) )
                    // InternalRoom.g:1115:5: ( ruleFQN )
                    {
                    // InternalRoom.g:1115:5: ( ruleFQN )
                    // InternalRoom.g:1116:6: ruleFQN
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

            otherlv_5=(Token)match(input,14,FOLLOW_29); 

            			newLeafNode(otherlv_5, grammarAccess.getDataClassAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalRoom.g:1135:3: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==107) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalRoom.g:1136:4: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1136:4: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:1137:5: lv_annotations_6_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getDataClassAccess().getAnnotationsAnnotationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_29);
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
            	    break loop25;
                }
            } while (true);

            // InternalRoom.g:1154:3: (otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRoom.g:1155:4: otherlv_7= 'usercode1' ( (lv_userCode1_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_30); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataClassAccess().getUsercode1Keyword_6_0());
                    			
                    // InternalRoom.g:1159:4: ( (lv_userCode1_8_0= ruleDetailCode ) )
                    // InternalRoom.g:1160:5: (lv_userCode1_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1160:5: (lv_userCode1_8_0= ruleDetailCode )
                    // InternalRoom.g:1161:6: lv_userCode1_8_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getDataClassAccess().getUserCode1DetailCodeParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_31);
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

            // InternalRoom.g:1179:3: (otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRoom.g:1180:4: otherlv_9= 'usercode2' ( (lv_userCode2_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,32,FOLLOW_32); 

                    				newLeafNode(otherlv_9, grammarAccess.getDataClassAccess().getUsercode2Keyword_7_0());
                    			
                    // InternalRoom.g:1184:4: ( (lv_userCode2_10_0= ruleDetailCode ) )
                    // InternalRoom.g:1185:5: (lv_userCode2_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1185:5: (lv_userCode2_10_0= ruleDetailCode )
                    // InternalRoom.g:1186:6: lv_userCode2_10_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getDataClassAccess().getUserCode2DetailCodeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_33);
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

            // InternalRoom.g:1204:3: (otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRoom.g:1205:4: otherlv_11= 'usercode3' ( (lv_userCode3_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_34); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataClassAccess().getUsercode3Keyword_8_0());
                    			
                    // InternalRoom.g:1209:4: ( (lv_userCode3_12_0= ruleDetailCode ) )
                    // InternalRoom.g:1210:5: (lv_userCode3_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1210:5: (lv_userCode3_12_0= ruleDetailCode )
                    // InternalRoom.g:1211:6: lv_userCode3_12_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getDataClassAccess().getUserCode3DetailCodeParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_35);
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

            // InternalRoom.g:1229:3: ( ( (lv_operations_13_0= ruleStandardOperation ) ) | ( (lv_structors_14_0= ruleClassStructor ) ) | ( (lv_attributes_15_0= ruleAttribute ) ) )*
            loop29:
            do {
                int alt29=4;
                switch ( input.LA(1) ) {
                case 37:
                case 38:
                    {
                    alt29=1;
                    }
                    break;
                case 41:
                case 42:
                    {
                    alt29=2;
                    }
                    break;
                case 34:
                    {
                    alt29=3;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // InternalRoom.g:1230:4: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    {
            	    // InternalRoom.g:1230:4: ( (lv_operations_13_0= ruleStandardOperation ) )
            	    // InternalRoom.g:1231:5: (lv_operations_13_0= ruleStandardOperation )
            	    {
            	    // InternalRoom.g:1231:5: (lv_operations_13_0= ruleStandardOperation )
            	    // InternalRoom.g:1232:6: lv_operations_13_0= ruleStandardOperation
            	    {

            	    						newCompositeNode(grammarAccess.getDataClassAccess().getOperationsStandardOperationParserRuleCall_9_0_0());
            	    					
            	    pushFollow(FOLLOW_35);
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
            	    // InternalRoom.g:1250:4: ( (lv_structors_14_0= ruleClassStructor ) )
            	    {
            	    // InternalRoom.g:1250:4: ( (lv_structors_14_0= ruleClassStructor ) )
            	    // InternalRoom.g:1251:5: (lv_structors_14_0= ruleClassStructor )
            	    {
            	    // InternalRoom.g:1251:5: (lv_structors_14_0= ruleClassStructor )
            	    // InternalRoom.g:1252:6: lv_structors_14_0= ruleClassStructor
            	    {

            	    						newCompositeNode(grammarAccess.getDataClassAccess().getStructorsClassStructorParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
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
            	    // InternalRoom.g:1270:4: ( (lv_attributes_15_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:1270:4: ( (lv_attributes_15_0= ruleAttribute ) )
            	    // InternalRoom.g:1271:5: (lv_attributes_15_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:1271:5: (lv_attributes_15_0= ruleAttribute )
            	    // InternalRoom.g:1272:6: lv_attributes_15_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getDataClassAccess().getAttributesAttributeParserRuleCall_9_2_0());
            	    					
            	    pushFollow(FOLLOW_35);
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
            	    break loop29;
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
    // InternalRoom.g:1298:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalRoom.g:1298:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalRoom.g:1299:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalRoom.g:1305:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:1311:2: ( (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:1312:2: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:1312:2: (otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )? )
            // InternalRoom.g:1313:3: otherlv_0= 'Attribute' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_type_6_0= ruleRefableType ) )? (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )? ( (lv_docu_9_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
            		
            // InternalRoom.g:1317:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1318:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1318:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1319:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

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

            // InternalRoom.g:1335:3: (otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRoom.g:1336:4: otherlv_2= '[' ( (lv_size_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_37); 

                    				newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoom.g:1340:4: ( (lv_size_3_0= RULE_INT ) )
                    // InternalRoom.g:1341:5: (lv_size_3_0= RULE_INT )
                    {
                    // InternalRoom.g:1341:5: (lv_size_3_0= RULE_INT )
                    // InternalRoom.g:1342:6: lv_size_3_0= RULE_INT
                    {
                    lv_size_3_0=(Token)match(input,RULE_INT,FOLLOW_38); 

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

                    otherlv_4=(Token)match(input,36,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_39); 

            			newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getColonKeyword_3());
            		
            // InternalRoom.g:1367:3: ( (lv_type_6_0= ruleRefableType ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRoom.g:1368:4: (lv_type_6_0= ruleRefableType )
                    {
                    // InternalRoom.g:1368:4: (lv_type_6_0= ruleRefableType )
                    // InternalRoom.g:1369:5: lv_type_6_0= ruleRefableType
                    {

                    					newCompositeNode(grammarAccess.getAttributeAccess().getTypeRefableTypeParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_40);
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

            // InternalRoom.g:1386:3: (otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRoom.g:1387:4: otherlv_7= '=' ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getEqualsSignKeyword_5_0());
                    			
                    // InternalRoom.g:1391:4: ( (lv_defaultValueLiteral_8_0= RULE_STRING ) )
                    // InternalRoom.g:1392:5: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    {
                    // InternalRoom.g:1392:5: (lv_defaultValueLiteral_8_0= RULE_STRING )
                    // InternalRoom.g:1393:6: lv_defaultValueLiteral_8_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_8_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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

            // InternalRoom.g:1410:3: ( (lv_docu_9_0= ruleDocumentation ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==35) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRoom.g:1411:4: (lv_docu_9_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1411:4: (lv_docu_9_0= ruleDocumentation )
                    // InternalRoom.g:1412:5: lv_docu_9_0= ruleDocumentation
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
    // InternalRoom.g:1433:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalRoom.g:1433:58: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalRoom.g:1434:2: iv_ruleStandardOperation= ruleStandardOperation EOF
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
    // InternalRoom.g:1440:1: ruleStandardOperation returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1446:2: ( ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1447:2: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1447:2: ( ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) ) )
            // InternalRoom.g:1448:3: ( (lv_override_0_0= 'override' ) )? otherlv_1= 'Operation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )? otherlv_7= ')' (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )? ( (lv_docu_11_0= ruleDocumentation ) )? ( (lv_detailCode_12_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1448:3: ( (lv_override_0_0= 'override' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalRoom.g:1449:4: (lv_override_0_0= 'override' )
                    {
                    // InternalRoom.g:1449:4: (lv_override_0_0= 'override' )
                    // InternalRoom.g:1450:5: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,37,FOLLOW_41); 

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
            		
            // InternalRoom.g:1466:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1467:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1467:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1468:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_42); 

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

            otherlv_3=(Token)match(input,21,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalRoom.g:1488:3: ( ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRoom.g:1489:4: ( (lv_arguments_4_0= ruleVarDecl ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1489:4: ( (lv_arguments_4_0= ruleVarDecl ) )
                    // InternalRoom.g:1490:5: (lv_arguments_4_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1490:5: (lv_arguments_4_0= ruleVarDecl )
                    // InternalRoom.g:1491:6: lv_arguments_4_0= ruleVarDecl
                    {

                    						newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_44);
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

                    // InternalRoom.g:1508:4: (otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==26) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalRoom.g:1509:5: otherlv_5= ',' ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getStandardOperationAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalRoom.g:1513:5: ( (lv_arguments_6_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1514:6: (lv_arguments_6_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1514:6: (lv_arguments_6_0= ruleVarDecl )
                    	    // InternalRoom.g:1515:7: lv_arguments_6_0= ruleVarDecl
                    	    {

                    	    							newCompositeNode(grammarAccess.getStandardOperationAccess().getArgumentsVarDeclParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_44);
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
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_45); 

            			newLeafNode(otherlv_7, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
            		
            // InternalRoom.g:1538:3: (otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoom.g:1539:4: otherlv_8= ':' (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_46); 

                    				newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getColonKeyword_6_0());
                    			
                    // InternalRoom.g:1543:4: (otherlv_9= 'void' | ( (lv_returnType_10_0= ruleRefableType ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==39) ) {
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
                            // InternalRoom.g:1544:5: otherlv_9= 'void'
                            {
                            otherlv_9=(Token)match(input,39,FOLLOW_47); 

                            					newLeafNode(otherlv_9, grammarAccess.getStandardOperationAccess().getVoidKeyword_6_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1549:5: ( (lv_returnType_10_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1549:5: ( (lv_returnType_10_0= ruleRefableType ) )
                            // InternalRoom.g:1550:6: (lv_returnType_10_0= ruleRefableType )
                            {
                            // InternalRoom.g:1550:6: (lv_returnType_10_0= ruleRefableType )
                            // InternalRoom.g:1551:7: lv_returnType_10_0= ruleRefableType
                            {

                            							newCompositeNode(grammarAccess.getStandardOperationAccess().getReturnTypeRefableTypeParserRuleCall_6_1_1_0());
                            						
                            pushFollow(FOLLOW_47);
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

            // InternalRoom.g:1570:3: ( (lv_docu_11_0= ruleDocumentation ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRoom.g:1571:4: (lv_docu_11_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1571:4: (lv_docu_11_0= ruleDocumentation )
                    // InternalRoom.g:1572:5: lv_docu_11_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getStandardOperationAccess().getDocuDocumentationParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_48);
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

            // InternalRoom.g:1589:3: ( (lv_detailCode_12_0= ruleDetailCode ) )
            // InternalRoom.g:1590:4: (lv_detailCode_12_0= ruleDetailCode )
            {
            // InternalRoom.g:1590:4: (lv_detailCode_12_0= ruleDetailCode )
            // InternalRoom.g:1591:5: lv_detailCode_12_0= ruleDetailCode
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
    // InternalRoom.g:1612:1: entryRulePortOperation returns [EObject current=null] : iv_rulePortOperation= rulePortOperation EOF ;
    public final EObject entryRulePortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortOperation = null;


        try {
            // InternalRoom.g:1612:54: (iv_rulePortOperation= rulePortOperation EOF )
            // InternalRoom.g:1613:2: iv_rulePortOperation= rulePortOperation EOF
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
    // InternalRoom.g:1619:1: rulePortOperation returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) ;
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
            // InternalRoom.g:1625:2: ( (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1626:2: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1626:2: (otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) ) )
            // InternalRoom.g:1627:3: otherlv_0= 'Operation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )? otherlv_6= ')' ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )? ( (lv_docu_12_0= ruleDocumentation ) )? ( (lv_detailCode_13_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPortOperationAccess().getOperationKeyword_0());
            		
            // InternalRoom.g:1631:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:1632:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:1632:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:1633:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_42); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getPortOperationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalRoom.g:1653:3: ( ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRoom.g:1654:4: ( (lv_arguments_3_0= ruleVarDecl ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    {
                    // InternalRoom.g:1654:4: ( (lv_arguments_3_0= ruleVarDecl ) )
                    // InternalRoom.g:1655:5: (lv_arguments_3_0= ruleVarDecl )
                    {
                    // InternalRoom.g:1655:5: (lv_arguments_3_0= ruleVarDecl )
                    // InternalRoom.g:1656:6: lv_arguments_3_0= ruleVarDecl
                    {

                    						newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_44);
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

                    // InternalRoom.g:1673:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==26) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalRoom.g:1674:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPortOperationAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalRoom.g:1678:5: ( (lv_arguments_5_0= ruleVarDecl ) )
                    	    // InternalRoom.g:1679:6: (lv_arguments_5_0= ruleVarDecl )
                    	    {
                    	    // InternalRoom.g:1679:6: (lv_arguments_5_0= ruleVarDecl )
                    	    // InternalRoom.g:1680:7: lv_arguments_5_0= ruleVarDecl
                    	    {

                    	    							newCompositeNode(grammarAccess.getPortOperationAccess().getArgumentsVarDeclParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_44);
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
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_49); 

            			newLeafNode(otherlv_6, grammarAccess.getPortOperationAccess().getRightParenthesisKeyword_4());
            		
            // InternalRoom.g:1703:3: ( (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) ) | (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) ) )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==16) ) {
                alt43=1;
            }
            else if ( (LA43_0==40) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // InternalRoom.g:1704:4: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    {
                    // InternalRoom.g:1704:4: (otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) ) )
                    // InternalRoom.g:1705:5: otherlv_7= ':' (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_46); 

                    					newLeafNode(otherlv_7, grammarAccess.getPortOperationAccess().getColonKeyword_5_0_0());
                    				
                    // InternalRoom.g:1709:5: (otherlv_8= 'void' | ( (lv_returnType_9_0= ruleRefableType ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==39) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_ID) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalRoom.g:1710:6: otherlv_8= 'void'
                            {
                            otherlv_8=(Token)match(input,39,FOLLOW_47); 

                            						newLeafNode(otherlv_8, grammarAccess.getPortOperationAccess().getVoidKeyword_5_0_1_0());
                            					

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:1715:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            {
                            // InternalRoom.g:1715:6: ( (lv_returnType_9_0= ruleRefableType ) )
                            // InternalRoom.g:1716:7: (lv_returnType_9_0= ruleRefableType )
                            {
                            // InternalRoom.g:1716:7: (lv_returnType_9_0= ruleRefableType )
                            // InternalRoom.g:1717:8: lv_returnType_9_0= ruleRefableType
                            {

                            								newCompositeNode(grammarAccess.getPortOperationAccess().getReturnTypeRefableTypeParserRuleCall_5_0_1_1_0());
                            							
                            pushFollow(FOLLOW_47);
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
                    // InternalRoom.g:1737:4: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    {
                    // InternalRoom.g:1737:4: (otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) ) )
                    // InternalRoom.g:1738:5: otherlv_10= 'sends' ( (otherlv_11= RULE_ID ) )
                    {
                    otherlv_10=(Token)match(input,40,FOLLOW_3); 

                    					newLeafNode(otherlv_10, grammarAccess.getPortOperationAccess().getSendsKeyword_5_1_0());
                    				
                    // InternalRoom.g:1742:5: ( (otherlv_11= RULE_ID ) )
                    // InternalRoom.g:1743:6: (otherlv_11= RULE_ID )
                    {
                    // InternalRoom.g:1743:6: (otherlv_11= RULE_ID )
                    // InternalRoom.g:1744:7: otherlv_11= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getPortOperationRule());
                    							}
                    						
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_47); 

                    							newLeafNode(otherlv_11, grammarAccess.getPortOperationAccess().getSendsMsgMessageCrossReference_5_1_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalRoom.g:1757:3: ( (lv_docu_12_0= ruleDocumentation ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==35) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoom.g:1758:4: (lv_docu_12_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1758:4: (lv_docu_12_0= ruleDocumentation )
                    // InternalRoom.g:1759:5: lv_docu_12_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getPortOperationAccess().getDocuDocumentationParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_48);
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

            // InternalRoom.g:1776:3: ( (lv_detailCode_13_0= ruleDetailCode ) )
            // InternalRoom.g:1777:4: (lv_detailCode_13_0= ruleDetailCode )
            {
            // InternalRoom.g:1777:4: (lv_detailCode_13_0= ruleDetailCode )
            // InternalRoom.g:1778:5: lv_detailCode_13_0= ruleDetailCode
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
    // InternalRoom.g:1799:1: entryRuleClassStructor returns [EObject current=null] : iv_ruleClassStructor= ruleClassStructor EOF ;
    public final EObject entryRuleClassStructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassStructor = null;


        try {
            // InternalRoom.g:1799:54: (iv_ruleClassStructor= ruleClassStructor EOF )
            // InternalRoom.g:1800:2: iv_ruleClassStructor= ruleClassStructor EOF
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
    // InternalRoom.g:1806:1: ruleClassStructor returns [EObject current=null] : ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleClassStructor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_detailCode_1_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:1812:2: ( ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:1813:2: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:1813:2: ( ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:1814:3: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) ) ( (lv_detailCode_1_0= ruleDetailCode ) )
            {
            // InternalRoom.g:1814:3: ( ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) ) )
            // InternalRoom.g:1815:4: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            {
            // InternalRoom.g:1815:4: ( (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' ) )
            // InternalRoom.g:1816:5: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            {
            // InternalRoom.g:1816:5: (lv_name_0_1= 'ctor' | lv_name_0_2= 'dtor' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            else if ( (LA45_0==42) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalRoom.g:1817:6: lv_name_0_1= 'ctor'
                    {
                    lv_name_0_1=(Token)match(input,41,FOLLOW_48); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getClassStructorAccess().getNameCtorKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassStructorRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRoom.g:1828:6: lv_name_0_2= 'dtor'
                    {
                    lv_name_0_2=(Token)match(input,42,FOLLOW_48); 

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

            // InternalRoom.g:1841:3: ( (lv_detailCode_1_0= ruleDetailCode ) )
            // InternalRoom.g:1842:4: (lv_detailCode_1_0= ruleDetailCode )
            {
            // InternalRoom.g:1842:4: (lv_detailCode_1_0= ruleDetailCode )
            // InternalRoom.g:1843:5: lv_detailCode_1_0= ruleDetailCode
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


    // $ANTLR start "entryRuleProtocolClass"
    // InternalRoom.g:1864:1: entryRuleProtocolClass returns [EObject current=null] : iv_ruleProtocolClass= ruleProtocolClass EOF ;
    public final EObject entryRuleProtocolClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolClass = null;


        try {
            // InternalRoom.g:1864:54: (iv_ruleProtocolClass= ruleProtocolClass EOF )
            // InternalRoom.g:1865:2: iv_ruleProtocolClass= ruleProtocolClass EOF
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
    // InternalRoom.g:1871:1: ruleProtocolClass returns [EObject current=null] : ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) ;
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
            // InternalRoom.g:1877:2: ( ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' ) )
            // InternalRoom.g:1878:2: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            {
            // InternalRoom.g:1878:2: ( ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}' )
            // InternalRoom.g:1879:3: ( (lv_commType_0_0= ruleCommunicationType ) )? otherlv_1= 'ProtocolClass' ( (lv_name_2_0= RULE_ID ) ) ( (lv_docu_3_0= ruleDocumentation ) )? (otherlv_4= 'extends' ( ( ruleFQN ) ) )? otherlv_6= '{' ( (lv_annotations_7_0= ruleAnnotation ) )* (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )? (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )? (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )? (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )? (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )? (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )? (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )? ( (lv_semantics_28_0= ruleProtocolSemantics ) )? otherlv_29= '}'
            {
            // InternalRoom.g:1879:3: ( (lv_commType_0_0= ruleCommunicationType ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=123 && LA46_0<=125)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRoom.g:1880:4: (lv_commType_0_0= ruleCommunicationType )
                    {
                    // InternalRoom.g:1880:4: (lv_commType_0_0= ruleCommunicationType )
                    // InternalRoom.g:1881:5: lv_commType_0_0= ruleCommunicationType
                    {

                    					newCompositeNode(grammarAccess.getProtocolClassAccess().getCommTypeCommunicationTypeEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_50);
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
            		
            // InternalRoom.g:1902:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:1903:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:1903:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:1904:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            // InternalRoom.g:1920:3: ( (lv_docu_3_0= ruleDocumentation ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==35) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRoom.g:1921:4: (lv_docu_3_0= ruleDocumentation )
                    {
                    // InternalRoom.g:1921:4: (lv_docu_3_0= ruleDocumentation )
                    // InternalRoom.g:1922:5: lv_docu_3_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getProtocolClassAccess().getDocuDocumentationParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_28);
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

            // InternalRoom.g:1939:3: (otherlv_4= 'extends' ( ( ruleFQN ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRoom.g:1940:4: otherlv_4= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getProtocolClassAccess().getExtendsKeyword_4_0());
                    			
                    // InternalRoom.g:1944:4: ( ( ruleFQN ) )
                    // InternalRoom.g:1945:5: ( ruleFQN )
                    {
                    // InternalRoom.g:1945:5: ( ruleFQN )
                    // InternalRoom.g:1946:6: ruleFQN
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

            otherlv_6=(Token)match(input,14,FOLLOW_51); 

            			newLeafNode(otherlv_6, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalRoom.g:1965:3: ( (lv_annotations_7_0= ruleAnnotation ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==107) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalRoom.g:1966:4: (lv_annotations_7_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:1966:4: (lv_annotations_7_0= ruleAnnotation )
            	    // InternalRoom.g:1967:5: lv_annotations_7_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getProtocolClassAccess().getAnnotationsAnnotationParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_51);
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
            	    break loop49;
                }
            } while (true);

            // InternalRoom.g:1984:3: (otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRoom.g:1985:4: otherlv_8= 'usercode1' ( (lv_userCode1_9_0= ruleDetailCode ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_52); 

                    				newLeafNode(otherlv_8, grammarAccess.getProtocolClassAccess().getUsercode1Keyword_7_0());
                    			
                    // InternalRoom.g:1989:4: ( (lv_userCode1_9_0= ruleDetailCode ) )
                    // InternalRoom.g:1990:5: (lv_userCode1_9_0= ruleDetailCode )
                    {
                    // InternalRoom.g:1990:5: (lv_userCode1_9_0= ruleDetailCode )
                    // InternalRoom.g:1991:6: lv_userCode1_9_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode1DetailCodeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_53);
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

            // InternalRoom.g:2009:3: (otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==32) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRoom.g:2010:4: otherlv_10= 'usercode2' ( (lv_userCode2_11_0= ruleDetailCode ) )
                    {
                    otherlv_10=(Token)match(input,32,FOLLOW_54); 

                    				newLeafNode(otherlv_10, grammarAccess.getProtocolClassAccess().getUsercode2Keyword_8_0());
                    			
                    // InternalRoom.g:2014:4: ( (lv_userCode2_11_0= ruleDetailCode ) )
                    // InternalRoom.g:2015:5: (lv_userCode2_11_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2015:5: (lv_userCode2_11_0= ruleDetailCode )
                    // InternalRoom.g:2016:6: lv_userCode2_11_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode2DetailCodeParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_55);
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

            // InternalRoom.g:2034:3: (otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==33) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoom.g:2035:4: otherlv_12= 'usercode3' ( (lv_userCode3_13_0= ruleDetailCode ) )
                    {
                    otherlv_12=(Token)match(input,33,FOLLOW_56); 

                    				newLeafNode(otherlv_12, grammarAccess.getProtocolClassAccess().getUsercode3Keyword_9_0());
                    			
                    // InternalRoom.g:2039:4: ( (lv_userCode3_13_0= ruleDetailCode ) )
                    // InternalRoom.g:2040:5: (lv_userCode3_13_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2040:5: (lv_userCode3_13_0= ruleDetailCode )
                    // InternalRoom.g:2041:6: lv_userCode3_13_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getProtocolClassAccess().getUserCode3DetailCodeParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_57);
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

            // InternalRoom.g:2059:3: (otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==44) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRoom.g:2060:4: otherlv_14= 'incoming' otherlv_15= '{' ( (lv_incomingMessages_16_0= ruleMessage ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,44,FOLLOW_5); 

                    				newLeafNode(otherlv_14, grammarAccess.getProtocolClassAccess().getIncomingKeyword_10_0());
                    			
                    otherlv_15=(Token)match(input,14,FOLLOW_58); 

                    				newLeafNode(otherlv_15, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_10_1());
                    			
                    // InternalRoom.g:2068:4: ( (lv_incomingMessages_16_0= ruleMessage ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=49 && LA53_0<=50)) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalRoom.g:2069:5: (lv_incomingMessages_16_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2069:5: (lv_incomingMessages_16_0= ruleMessage )
                    	    // InternalRoom.g:2070:6: lv_incomingMessages_16_0= ruleMessage
                    	    {

                    	    						newCompositeNode(grammarAccess.getProtocolClassAccess().getIncomingMessagesMessageParserRuleCall_10_2_0());
                    	    					
                    	    pushFollow(FOLLOW_58);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,15,FOLLOW_59); 

                    				newLeafNode(otherlv_17, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_10_3());
                    			

                    }
                    break;

            }

            // InternalRoom.g:2092:3: (otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==45) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRoom.g:2093:4: otherlv_18= 'outgoing' otherlv_19= '{' ( (lv_outgoingMessages_20_0= ruleMessage ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,45,FOLLOW_5); 

                    				newLeafNode(otherlv_18, grammarAccess.getProtocolClassAccess().getOutgoingKeyword_11_0());
                    			
                    otherlv_19=(Token)match(input,14,FOLLOW_58); 

                    				newLeafNode(otherlv_19, grammarAccess.getProtocolClassAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalRoom.g:2101:4: ( (lv_outgoingMessages_20_0= ruleMessage ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( ((LA55_0>=49 && LA55_0<=50)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalRoom.g:2102:5: (lv_outgoingMessages_20_0= ruleMessage )
                    	    {
                    	    // InternalRoom.g:2102:5: (lv_outgoingMessages_20_0= ruleMessage )
                    	    // InternalRoom.g:2103:6: lv_outgoingMessages_20_0= ruleMessage
                    	    {

                    	    						newCompositeNode(grammarAccess.getProtocolClassAccess().getOutgoingMessagesMessageParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_58);
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
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,15,FOLLOW_60); 

                    				newLeafNode(otherlv_21, grammarAccess.getProtocolClassAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalRoom.g:2125:3: (otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==46) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRoom.g:2126:4: otherlv_22= 'regular' otherlv_23= 'PortClass' ( (lv_regular_24_0= rulePortClass ) )
                    {
                    otherlv_22=(Token)match(input,46,FOLLOW_61); 

                    				newLeafNode(otherlv_22, grammarAccess.getProtocolClassAccess().getRegularKeyword_12_0());
                    			
                    otherlv_23=(Token)match(input,47,FOLLOW_5); 

                    				newLeafNode(otherlv_23, grammarAccess.getProtocolClassAccess().getPortClassKeyword_12_1());
                    			
                    // InternalRoom.g:2134:4: ( (lv_regular_24_0= rulePortClass ) )
                    // InternalRoom.g:2135:5: (lv_regular_24_0= rulePortClass )
                    {
                    // InternalRoom.g:2135:5: (lv_regular_24_0= rulePortClass )
                    // InternalRoom.g:2136:6: lv_regular_24_0= rulePortClass
                    {

                    						newCompositeNode(grammarAccess.getProtocolClassAccess().getRegularPortClassParserRuleCall_12_2_0());
                    					
                    pushFollow(FOLLOW_62);
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

            // InternalRoom.g:2154:3: (otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRoom.g:2155:4: otherlv_25= 'conjugated' otherlv_26= 'PortClass' ( (lv_conjugated_27_0= rulePortClass ) )
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_61); 

                    				newLeafNode(otherlv_25, grammarAccess.getProtocolClassAccess().getConjugatedKeyword_13_0());
                    			
                    otherlv_26=(Token)match(input,47,FOLLOW_5); 

                    				newLeafNode(otherlv_26, grammarAccess.getProtocolClassAccess().getPortClassKeyword_13_1());
                    			
                    // InternalRoom.g:2163:4: ( (lv_conjugated_27_0= rulePortClass ) )
                    // InternalRoom.g:2164:5: (lv_conjugated_27_0= rulePortClass )
                    {
                    // InternalRoom.g:2164:5: (lv_conjugated_27_0= rulePortClass )
                    // InternalRoom.g:2165:6: lv_conjugated_27_0= rulePortClass
                    {

                    						newCompositeNode(grammarAccess.getProtocolClassAccess().getConjugatedPortClassParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_63);
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

            // InternalRoom.g:2183:3: ( (lv_semantics_28_0= ruleProtocolSemantics ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==104) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRoom.g:2184:4: (lv_semantics_28_0= ruleProtocolSemantics )
                    {
                    // InternalRoom.g:2184:4: (lv_semantics_28_0= ruleProtocolSemantics )
                    // InternalRoom.g:2185:5: lv_semantics_28_0= ruleProtocolSemantics
                    {

                    					newCompositeNode(grammarAccess.getProtocolClassAccess().getSemanticsProtocolSemanticsParserRuleCall_14_0());
                    				
                    pushFollow(FOLLOW_64);
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


    // $ANTLR start "entryRuleMessage"
    // InternalRoom.g:2210:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalRoom.g:2210:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalRoom.g:2211:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalRoom.g:2217:1: ruleMessage returns [EObject current=null] : ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:2223:2: ( ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:2224:2: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:2224:2: ( ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:2225:3: ( (lv_priv_0_0= 'private' ) )? otherlv_1= 'Message' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )? ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:2225:3: ( (lv_priv_0_0= 'private' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==49) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRoom.g:2226:4: (lv_priv_0_0= 'private' )
                    {
                    // InternalRoom.g:2226:4: (lv_priv_0_0= 'private' )
                    // InternalRoom.g:2227:5: lv_priv_0_0= 'private'
                    {
                    lv_priv_0_0=(Token)match(input,49,FOLLOW_65); 

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
            		
            // InternalRoom.g:2243:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:2244:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:2244:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:2245:5: lv_name_2_0= RULE_ID
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

            // InternalRoom.g:2261:3: (otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==21) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRoom.g:2262:4: otherlv_3= '(' ( (lv_data_4_0= ruleMessageData ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_43); 

                    				newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalRoom.g:2266:4: ( (lv_data_4_0= ruleMessageData ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==RULE_ID) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalRoom.g:2267:5: (lv_data_4_0= ruleMessageData )
                            {
                            // InternalRoom.g:2267:5: (lv_data_4_0= ruleMessageData )
                            // InternalRoom.g:2268:6: lv_data_4_0= ruleMessageData
                            {

                            						newCompositeNode(grammarAccess.getMessageAccess().getDataMessageDataParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_17);
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

            // InternalRoom.g:2290:3: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==107) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalRoom.g:2291:4: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2291:4: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:2292:5: lv_annotations_6_0= ruleAnnotation
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
            	    break loop63;
                }
            } while (true);

            // InternalRoom.g:2309:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==35) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRoom.g:2310:4: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2310:4: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:2311:5: lv_docu_7_0= ruleDocumentation
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
    // InternalRoom.g:2332:1: entryRulePortClass returns [EObject current=null] : iv_rulePortClass= rulePortClass EOF ;
    public final EObject entryRulePortClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortClass = null;


        try {
            // InternalRoom.g:2332:50: (iv_rulePortClass= rulePortClass EOF )
            // InternalRoom.g:2333:2: iv_rulePortClass= rulePortClass EOF
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
    // InternalRoom.g:2339:1: rulePortClass returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:2345:2: ( ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:2346:2: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:2346:2: ( () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}' )
            // InternalRoom.g:2347:3: () otherlv_1= '{' (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )? ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:2347:3: ()
            // InternalRoom.g:2348:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPortClassAccess().getPortClassAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_68); 

            			newLeafNode(otherlv_1, grammarAccess.getPortClassAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRoom.g:2358:3: (otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==51) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRoom.g:2359:4: otherlv_2= 'usercode' ( (lv_userCode_3_0= ruleDetailCode ) )
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_69); 

                    				newLeafNode(otherlv_2, grammarAccess.getPortClassAccess().getUsercodeKeyword_2_0());
                    			
                    // InternalRoom.g:2363:4: ( (lv_userCode_3_0= ruleDetailCode ) )
                    // InternalRoom.g:2364:5: (lv_userCode_3_0= ruleDetailCode )
                    {
                    // InternalRoom.g:2364:5: (lv_userCode_3_0= ruleDetailCode )
                    // InternalRoom.g:2365:6: lv_userCode_3_0= ruleDetailCode
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

            // InternalRoom.g:2383:3: ( ( (lv_msgHandlers_4_0= ruleMessageHandler ) ) | ( (lv_operations_5_0= rulePortOperation ) ) | ( (lv_attributes_6_0= ruleAttribute ) ) )*
            loop66:
            do {
                int alt66=4;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    alt66=1;
                    }
                    break;
                case 38:
                    {
                    alt66=2;
                    }
                    break;
                case 34:
                    {
                    alt66=3;
                    }
                    break;

                }

                switch (alt66) {
            	case 1 :
            	    // InternalRoom.g:2384:4: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    {
            	    // InternalRoom.g:2384:4: ( (lv_msgHandlers_4_0= ruleMessageHandler ) )
            	    // InternalRoom.g:2385:5: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    {
            	    // InternalRoom.g:2385:5: (lv_msgHandlers_4_0= ruleMessageHandler )
            	    // InternalRoom.g:2386:6: lv_msgHandlers_4_0= ruleMessageHandler
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
            	    // InternalRoom.g:2404:4: ( (lv_operations_5_0= rulePortOperation ) )
            	    {
            	    // InternalRoom.g:2404:4: ( (lv_operations_5_0= rulePortOperation ) )
            	    // InternalRoom.g:2405:5: (lv_operations_5_0= rulePortOperation )
            	    {
            	    // InternalRoom.g:2405:5: (lv_operations_5_0= rulePortOperation )
            	    // InternalRoom.g:2406:6: lv_operations_5_0= rulePortOperation
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
            	    // InternalRoom.g:2424:4: ( (lv_attributes_6_0= ruleAttribute ) )
            	    {
            	    // InternalRoom.g:2424:4: ( (lv_attributes_6_0= ruleAttribute ) )
            	    // InternalRoom.g:2425:5: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalRoom.g:2425:5: (lv_attributes_6_0= ruleAttribute )
            	    // InternalRoom.g:2426:6: lv_attributes_6_0= ruleAttribute
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
            	    break loop66;
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
    // InternalRoom.g:2452:1: entryRuleMessageHandler returns [EObject current=null] : iv_ruleMessageHandler= ruleMessageHandler EOF ;
    public final EObject entryRuleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageHandler = null;


        try {
            // InternalRoom.g:2452:55: (iv_ruleMessageHandler= ruleMessageHandler EOF )
            // InternalRoom.g:2453:2: iv_ruleMessageHandler= ruleMessageHandler EOF
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
    // InternalRoom.g:2459:1: ruleMessageHandler returns [EObject current=null] : (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) ;
    public final EObject ruleMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject this_InMessageHandler_0 = null;

        EObject this_OutMessageHandler_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:2465:2: ( (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler ) )
            // InternalRoom.g:2466:2: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            {
            // InternalRoom.g:2466:2: (this_InMessageHandler_0= ruleInMessageHandler | this_OutMessageHandler_1= ruleOutMessageHandler )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==52) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==45) ) {
                    alt67=2;
                }
                else if ( (LA67_1==44) ) {
                    alt67=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalRoom.g:2467:3: this_InMessageHandler_0= ruleInMessageHandler
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
                    // InternalRoom.g:2476:3: this_OutMessageHandler_1= ruleOutMessageHandler
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
    // InternalRoom.g:2488:1: entryRuleInMessageHandler returns [EObject current=null] : iv_ruleInMessageHandler= ruleInMessageHandler EOF ;
    public final EObject entryRuleInMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInMessageHandler = null;


        try {
            // InternalRoom.g:2488:57: (iv_ruleInMessageHandler= ruleInMessageHandler EOF )
            // InternalRoom.g:2489:2: iv_ruleInMessageHandler= ruleInMessageHandler EOF
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
    // InternalRoom.g:2495:1: ruleInMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleInMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:2501:2: ( (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2502:2: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2502:2: (otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2503:3: otherlv_0= 'handle' otherlv_1= 'incoming' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_71); 

            			newLeafNode(otherlv_0, grammarAccess.getInMessageHandlerAccess().getHandleKeyword_0());
            		
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInMessageHandlerAccess().getIncomingKeyword_1());
            		
            // InternalRoom.g:2511:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2512:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2512:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:2513:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInMessageHandlerRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(otherlv_2, grammarAccess.getInMessageHandlerAccess().getMsgMessageCrossReference_2_0());
            				

            }


            }

            // InternalRoom.g:2524:3: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2525:4: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2525:4: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2526:5: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2547:1: entryRuleOutMessageHandler returns [EObject current=null] : iv_ruleOutMessageHandler= ruleOutMessageHandler EOF ;
    public final EObject entryRuleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutMessageHandler = null;


        try {
            // InternalRoom.g:2547:58: (iv_ruleOutMessageHandler= ruleOutMessageHandler EOF )
            // InternalRoom.g:2548:2: iv_ruleOutMessageHandler= ruleOutMessageHandler EOF
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
    // InternalRoom.g:2554:1: ruleOutMessageHandler returns [EObject current=null] : (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) ;
    public final EObject ruleOutMessageHandler() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_detailCode_3_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:2560:2: ( (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:2561:2: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:2561:2: (otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) ) )
            // InternalRoom.g:2562:3: otherlv_0= 'handle' otherlv_1= 'outgoing' ( (otherlv_2= RULE_ID ) ) ( (lv_detailCode_3_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_72); 

            			newLeafNode(otherlv_0, grammarAccess.getOutMessageHandlerAccess().getHandleKeyword_0());
            		
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOutMessageHandlerAccess().getOutgoingKeyword_1());
            		
            // InternalRoom.g:2570:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:2571:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:2571:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:2572:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutMessageHandlerRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(otherlv_2, grammarAccess.getOutMessageHandlerAccess().getMsgMessageCrossReference_2_0());
            				

            }


            }

            // InternalRoom.g:2583:3: ( (lv_detailCode_3_0= ruleDetailCode ) )
            // InternalRoom.g:2584:4: (lv_detailCode_3_0= ruleDetailCode )
            {
            // InternalRoom.g:2584:4: (lv_detailCode_3_0= ruleDetailCode )
            // InternalRoom.g:2585:5: lv_detailCode_3_0= ruleDetailCode
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
    // InternalRoom.g:2606:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalRoom.g:2606:55: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalRoom.g:2607:2: iv_ruleModelComponent= ruleModelComponent EOF
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
    // InternalRoom.g:2613:1: ruleModelComponent returns [EObject current=null] : this_ActorClass_0= ruleActorClass ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_ActorClass_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:2619:2: (this_ActorClass_0= ruleActorClass )
            // InternalRoom.g:2620:2: this_ActorClass_0= ruleActorClass
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
    // InternalRoom.g:2631:1: entryRuleActorClass returns [EObject current=null] : iv_ruleActorClass= ruleActorClass EOF ;
    public final EObject entryRuleActorClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorClass = null;


        try {
            // InternalRoom.g:2631:51: (iv_ruleActorClass= ruleActorClass EOF )
            // InternalRoom.g:2632:2: iv_ruleActorClass= ruleActorClass EOF
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
    // InternalRoom.g:2638:1: ruleActorClass returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) ;
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
            // InternalRoom.g:2644:2: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalRoom.g:2645:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalRoom.g:2645:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}' )
            // InternalRoom.g:2646:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) ) otherlv_3= 'ActorClass' ( (lv_name_4_0= RULE_ID ) ) ( (lv_docu_5_0= ruleDocumentation ) )? (otherlv_6= 'extends' ( ( ruleFQN ) ) )? otherlv_8= '{' ( (lv_annotations_9_0= ruleAnnotation ) )* (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )? (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )? (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )? otherlv_41= '}'
            {
            // InternalRoom.g:2646:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) ) )
            // InternalRoom.g:2647:4: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            {
            // InternalRoom.g:2647:4: ( ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* ) )
            // InternalRoom.g:2648:5: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            				
            // InternalRoom.g:2651:5: ( ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )* )
            // InternalRoom.g:2652:6: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            {
            // InternalRoom.g:2652:6: ( ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) ) )*
            loop68:
            do {
                int alt68=3;
                int LA68_0 = input.LA(1);

                if ( LA68_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
                    alt68=1;
                }
                else if ( ( LA68_0 >= 123 && LA68_0 <= 125 || LA68_0 == 127 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
                    alt68=2;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalRoom.g:2653:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalRoom.g:2653:4: ({...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) ) )
            	    // InternalRoom.g:2654:5: {...}? => ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // InternalRoom.g:2654:107: ( ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) ) )
            	    // InternalRoom.g:2655:6: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 0);
            	    					
            	    // InternalRoom.g:2658:9: ({...}? => ( (lv_abstract_1_0= 'abstract' ) ) )
            	    // InternalRoom.g:2658:10: {...}? => ( (lv_abstract_1_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2658:19: ( (lv_abstract_1_0= 'abstract' ) )
            	    // InternalRoom.g:2658:20: (lv_abstract_1_0= 'abstract' )
            	    {
            	    // InternalRoom.g:2658:20: (lv_abstract_1_0= 'abstract' )
            	    // InternalRoom.g:2659:10: lv_abstract_1_0= 'abstract'
            	    {
            	    lv_abstract_1_0=(Token)match(input,53,FOLLOW_73); 

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
            	    // InternalRoom.g:2676:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    {
            	    // InternalRoom.g:2676:4: ({...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) ) )
            	    // InternalRoom.g:2677:5: {...}? => ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "getUnorderedGroupHelper().canSelect(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // InternalRoom.g:2677:107: ( ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) ) )
            	    // InternalRoom.g:2678:6: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getActorClassAccess().getUnorderedGroup_0(), 1);
            	    					
            	    // InternalRoom.g:2681:9: ({...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) ) )
            	    // InternalRoom.g:2681:10: {...}? => ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleActorClass", "true");
            	    }
            	    // InternalRoom.g:2681:19: ( (lv_commType_2_0= ruleComponentCommunicationType ) )
            	    // InternalRoom.g:2681:20: (lv_commType_2_0= ruleComponentCommunicationType )
            	    {
            	    // InternalRoom.g:2681:20: (lv_commType_2_0= ruleComponentCommunicationType )
            	    // InternalRoom.g:2682:10: lv_commType_2_0= ruleComponentCommunicationType
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
            	    break loop68;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getActorClassAccess().getUnorderedGroup_0());
            				

            }

            otherlv_3=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getActorClassAccess().getActorClassKeyword_1());
            		
            // InternalRoom.g:2715:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalRoom.g:2716:4: (lv_name_4_0= RULE_ID )
            {
            // InternalRoom.g:2716:4: (lv_name_4_0= RULE_ID )
            // InternalRoom.g:2717:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            // InternalRoom.g:2733:3: ( (lv_docu_5_0= ruleDocumentation ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==35) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRoom.g:2734:4: (lv_docu_5_0= ruleDocumentation )
                    {
                    // InternalRoom.g:2734:4: (lv_docu_5_0= ruleDocumentation )
                    // InternalRoom.g:2735:5: lv_docu_5_0= ruleDocumentation
                    {

                    					newCompositeNode(grammarAccess.getActorClassAccess().getDocuDocumentationParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_28);
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

            // InternalRoom.g:2752:3: (otherlv_6= 'extends' ( ( ruleFQN ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==30) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRoom.g:2753:4: otherlv_6= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getActorClassAccess().getExtendsKeyword_4_0());
                    			
                    // InternalRoom.g:2757:4: ( ( ruleFQN ) )
                    // InternalRoom.g:2758:5: ( ruleFQN )
                    {
                    // InternalRoom.g:2758:5: ( ruleFQN )
                    // InternalRoom.g:2759:6: ruleFQN
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
            		
            // InternalRoom.g:2778:3: ( (lv_annotations_9_0= ruleAnnotation ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==107) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalRoom.g:2779:4: (lv_annotations_9_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:2779:4: (lv_annotations_9_0= ruleAnnotation )
            	    // InternalRoom.g:2780:5: lv_annotations_9_0= ruleAnnotation
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
            	    break loop71;
                }
            } while (true);

            // InternalRoom.g:2797:3: (otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==55) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRoom.g:2798:4: otherlv_10= 'Interface' otherlv_11= '{' ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,55,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getActorClassAccess().getInterfaceKeyword_7_0());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_75); 

                    				newLeafNode(otherlv_11, grammarAccess.getActorClassAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalRoom.g:2806:4: ( ( (lv_serviceProvisionPoints_12_0= ruleSPP ) ) | ( (lv_interfacePorts_13_0= rulePort ) ) )*
                    loop72:
                    do {
                        int alt72=3;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==61) ) {
                            alt72=1;
                        }
                        else if ( (LA72_0==48||LA72_0==58) ) {
                            alt72=2;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalRoom.g:2807:5: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    {
                    	    // InternalRoom.g:2807:5: ( (lv_serviceProvisionPoints_12_0= ruleSPP ) )
                    	    // InternalRoom.g:2808:6: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    {
                    	    // InternalRoom.g:2808:6: (lv_serviceProvisionPoints_12_0= ruleSPP )
                    	    // InternalRoom.g:2809:7: lv_serviceProvisionPoints_12_0= ruleSPP
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
                    	    // InternalRoom.g:2827:5: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:2827:5: ( (lv_interfacePorts_13_0= rulePort ) )
                    	    // InternalRoom.g:2828:6: (lv_interfacePorts_13_0= rulePort )
                    	    {
                    	    // InternalRoom.g:2828:6: (lv_interfacePorts_13_0= rulePort )
                    	    // InternalRoom.g:2829:7: lv_interfacePorts_13_0= rulePort
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
                    	    break loop72;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FOLLOW_76); 

                    				newLeafNode(otherlv_14, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalRoom.g:2852:3: (otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==56) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalRoom.g:2853:4: otherlv_15= 'Structure' ( (lv_structureDocu_16_0= ruleDocumentation ) )? otherlv_17= '{' (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )? (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )? (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )? ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )* otherlv_32= '}'
                    {
                    otherlv_15=(Token)match(input,56,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getActorClassAccess().getStructureKeyword_8_0());
                    			
                    // InternalRoom.g:2857:4: ( (lv_structureDocu_16_0= ruleDocumentation ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==35) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalRoom.g:2858:5: (lv_structureDocu_16_0= ruleDocumentation )
                            {
                            // InternalRoom.g:2858:5: (lv_structureDocu_16_0= ruleDocumentation )
                            // InternalRoom.g:2859:6: lv_structureDocu_16_0= ruleDocumentation
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
                    			
                    // InternalRoom.g:2880:4: (otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==31) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalRoom.g:2881:5: otherlv_18= 'usercode1' ( (lv_userCode1_19_0= ruleDetailCode ) )
                            {
                            otherlv_18=(Token)match(input,31,FOLLOW_78); 

                            					newLeafNode(otherlv_18, grammarAccess.getActorClassAccess().getUsercode1Keyword_8_3_0());
                            				
                            // InternalRoom.g:2885:5: ( (lv_userCode1_19_0= ruleDetailCode ) )
                            // InternalRoom.g:2886:6: (lv_userCode1_19_0= ruleDetailCode )
                            {
                            // InternalRoom.g:2886:6: (lv_userCode1_19_0= ruleDetailCode )
                            // InternalRoom.g:2887:7: lv_userCode1_19_0= ruleDetailCode
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

                    // InternalRoom.g:2905:4: (otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==32) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalRoom.g:2906:5: otherlv_20= 'usercode2' ( (lv_userCode2_21_0= ruleDetailCode ) )
                            {
                            otherlv_20=(Token)match(input,32,FOLLOW_80); 

                            					newLeafNode(otherlv_20, grammarAccess.getActorClassAccess().getUsercode2Keyword_8_4_0());
                            				
                            // InternalRoom.g:2910:5: ( (lv_userCode2_21_0= ruleDetailCode ) )
                            // InternalRoom.g:2911:6: (lv_userCode2_21_0= ruleDetailCode )
                            {
                            // InternalRoom.g:2911:6: (lv_userCode2_21_0= ruleDetailCode )
                            // InternalRoom.g:2912:7: lv_userCode2_21_0= ruleDetailCode
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

                    // InternalRoom.g:2930:4: (otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==33) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalRoom.g:2931:5: otherlv_22= 'usercode3' ( (lv_userCode3_23_0= ruleDetailCode ) )
                            {
                            otherlv_22=(Token)match(input,33,FOLLOW_82); 

                            					newLeafNode(otherlv_22, grammarAccess.getActorClassAccess().getUsercode3Keyword_8_5_0());
                            				
                            // InternalRoom.g:2935:5: ( (lv_userCode3_23_0= ruleDetailCode ) )
                            // InternalRoom.g:2936:6: (lv_userCode3_23_0= ruleDetailCode )
                            {
                            // InternalRoom.g:2936:6: (lv_userCode3_23_0= ruleDetailCode )
                            // InternalRoom.g:2937:7: lv_userCode3_23_0= ruleDetailCode
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

                    // InternalRoom.g:2955:4: ( ( (lv_connections_24_0= ruleLayerConnection ) ) | ( (lv_bindings_25_0= ruleBinding ) ) | ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) ) | ( (lv_attributes_27_0= ruleAttribute ) ) | ( (lv_actorRefs_28_0= ruleActorRef ) ) | ( (lv_serviceAccessPoints_29_0= ruleSAP ) ) | ( (lv_internalPorts_30_0= rulePort ) ) | ( (lv_externalPorts_31_0= ruleExternalPort ) ) )*
                    loop78:
                    do {
                        int alt78=9;
                        switch ( input.LA(1) ) {
                        case 72:
                            {
                            alt78=1;
                            }
                            break;
                        case 69:
                            {
                            alt78=2;
                            }
                            break;
                        case 62:
                            {
                            alt78=3;
                            }
                            break;
                        case 34:
                            {
                            alt78=4;
                            }
                            break;
                        case 75:
                        case 110:
                        case 126:
                            {
                            alt78=5;
                            }
                            break;
                        case 60:
                            {
                            alt78=6;
                            }
                            break;
                        case 48:
                        case 58:
                            {
                            alt78=7;
                            }
                            break;
                        case 59:
                            {
                            alt78=8;
                            }
                            break;

                        }

                        switch (alt78) {
                    	case 1 :
                    	    // InternalRoom.g:2956:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    {
                    	    // InternalRoom.g:2956:5: ( (lv_connections_24_0= ruleLayerConnection ) )
                    	    // InternalRoom.g:2957:6: (lv_connections_24_0= ruleLayerConnection )
                    	    {
                    	    // InternalRoom.g:2957:6: (lv_connections_24_0= ruleLayerConnection )
                    	    // InternalRoom.g:2958:7: lv_connections_24_0= ruleLayerConnection
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
                    	    // InternalRoom.g:2976:5: ( (lv_bindings_25_0= ruleBinding ) )
                    	    {
                    	    // InternalRoom.g:2976:5: ( (lv_bindings_25_0= ruleBinding ) )
                    	    // InternalRoom.g:2977:6: (lv_bindings_25_0= ruleBinding )
                    	    {
                    	    // InternalRoom.g:2977:6: (lv_bindings_25_0= ruleBinding )
                    	    // InternalRoom.g:2978:7: lv_bindings_25_0= ruleBinding
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
                    	    // InternalRoom.g:2996:5: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    {
                    	    // InternalRoom.g:2996:5: ( (lv_serviceImplementations_26_0= ruleServiceImplementation ) )
                    	    // InternalRoom.g:2997:6: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    {
                    	    // InternalRoom.g:2997:6: (lv_serviceImplementations_26_0= ruleServiceImplementation )
                    	    // InternalRoom.g:2998:7: lv_serviceImplementations_26_0= ruleServiceImplementation
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
                    	    // InternalRoom.g:3016:5: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    {
                    	    // InternalRoom.g:3016:5: ( (lv_attributes_27_0= ruleAttribute ) )
                    	    // InternalRoom.g:3017:6: (lv_attributes_27_0= ruleAttribute )
                    	    {
                    	    // InternalRoom.g:3017:6: (lv_attributes_27_0= ruleAttribute )
                    	    // InternalRoom.g:3018:7: lv_attributes_27_0= ruleAttribute
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
                    	    // InternalRoom.g:3036:5: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    {
                    	    // InternalRoom.g:3036:5: ( (lv_actorRefs_28_0= ruleActorRef ) )
                    	    // InternalRoom.g:3037:6: (lv_actorRefs_28_0= ruleActorRef )
                    	    {
                    	    // InternalRoom.g:3037:6: (lv_actorRefs_28_0= ruleActorRef )
                    	    // InternalRoom.g:3038:7: lv_actorRefs_28_0= ruleActorRef
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
                    	    // InternalRoom.g:3056:5: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    {
                    	    // InternalRoom.g:3056:5: ( (lv_serviceAccessPoints_29_0= ruleSAP ) )
                    	    // InternalRoom.g:3057:6: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    {
                    	    // InternalRoom.g:3057:6: (lv_serviceAccessPoints_29_0= ruleSAP )
                    	    // InternalRoom.g:3058:7: lv_serviceAccessPoints_29_0= ruleSAP
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
                    	    // InternalRoom.g:3076:5: ( (lv_internalPorts_30_0= rulePort ) )
                    	    {
                    	    // InternalRoom.g:3076:5: ( (lv_internalPorts_30_0= rulePort ) )
                    	    // InternalRoom.g:3077:6: (lv_internalPorts_30_0= rulePort )
                    	    {
                    	    // InternalRoom.g:3077:6: (lv_internalPorts_30_0= rulePort )
                    	    // InternalRoom.g:3078:7: lv_internalPorts_30_0= rulePort
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
                    	    // InternalRoom.g:3096:5: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    {
                    	    // InternalRoom.g:3096:5: ( (lv_externalPorts_31_0= ruleExternalPort ) )
                    	    // InternalRoom.g:3097:6: (lv_externalPorts_31_0= ruleExternalPort )
                    	    {
                    	    // InternalRoom.g:3097:6: (lv_externalPorts_31_0= ruleExternalPort )
                    	    // InternalRoom.g:3098:7: lv_externalPorts_31_0= ruleExternalPort
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
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,15,FOLLOW_84); 

                    				newLeafNode(otherlv_32, grammarAccess.getActorClassAccess().getRightCurlyBracketKeyword_8_7());
                    			

                    }
                    break;

            }

            // InternalRoom.g:3121:3: (otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==57) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalRoom.g:3122:4: otherlv_33= 'Behavior' ( (lv_behaviorDocu_34_0= ruleDocumentation ) )? otherlv_35= '{' ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )* ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )* ( (lv_stateMachine_39_0= ruleStateMachine ) )? otherlv_40= '}'
                    {
                    otherlv_33=(Token)match(input,57,FOLLOW_4); 

                    				newLeafNode(otherlv_33, grammarAccess.getActorClassAccess().getBehaviorKeyword_9_0());
                    			
                    // InternalRoom.g:3126:4: ( (lv_behaviorDocu_34_0= ruleDocumentation ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==35) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalRoom.g:3127:5: (lv_behaviorDocu_34_0= ruleDocumentation )
                            {
                            // InternalRoom.g:3127:5: (lv_behaviorDocu_34_0= ruleDocumentation )
                            // InternalRoom.g:3128:6: lv_behaviorDocu_34_0= ruleDocumentation
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
                    			
                    // InternalRoom.g:3149:4: ( (lv_behaviorAnnotations_36_0= ruleAnnotation ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==107) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // InternalRoom.g:3150:5: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:3150:5: (lv_behaviorAnnotations_36_0= ruleAnnotation )
                    	    // InternalRoom.g:3151:6: lv_behaviorAnnotations_36_0= ruleAnnotation
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
                    	    break loop81;
                        }
                    } while (true);

                    // InternalRoom.g:3168:4: ( ( (lv_operations_37_0= ruleStandardOperation ) ) | ( (lv_structors_38_0= ruleClassStructor ) ) )*
                    loop82:
                    do {
                        int alt82=3;
                        int LA82_0 = input.LA(1);

                        if ( ((LA82_0>=37 && LA82_0<=38)) ) {
                            alt82=1;
                        }
                        else if ( ((LA82_0>=41 && LA82_0<=42)) ) {
                            alt82=2;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalRoom.g:3169:5: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    {
                    	    // InternalRoom.g:3169:5: ( (lv_operations_37_0= ruleStandardOperation ) )
                    	    // InternalRoom.g:3170:6: (lv_operations_37_0= ruleStandardOperation )
                    	    {
                    	    // InternalRoom.g:3170:6: (lv_operations_37_0= ruleStandardOperation )
                    	    // InternalRoom.g:3171:7: lv_operations_37_0= ruleStandardOperation
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
                    	    // InternalRoom.g:3189:5: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    {
                    	    // InternalRoom.g:3189:5: ( (lv_structors_38_0= ruleClassStructor ) )
                    	    // InternalRoom.g:3190:6: (lv_structors_38_0= ruleClassStructor )
                    	    {
                    	    // InternalRoom.g:3190:6: (lv_structors_38_0= ruleClassStructor )
                    	    // InternalRoom.g:3191:7: lv_structors_38_0= ruleClassStructor
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
                    	    break loop82;
                        }
                    } while (true);

                    // InternalRoom.g:3209:4: ( (lv_stateMachine_39_0= ruleStateMachine ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==81) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalRoom.g:3210:5: (lv_stateMachine_39_0= ruleStateMachine )
                            {
                            // InternalRoom.g:3210:5: (lv_stateMachine_39_0= ruleStateMachine )
                            // InternalRoom.g:3211:6: lv_stateMachine_39_0= ruleStateMachine
                            {

                            						newCompositeNode(grammarAccess.getActorClassAccess().getStateMachineStateMachineParserRuleCall_9_5_0());
                            					
                            pushFollow(FOLLOW_64);
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

                    otherlv_40=(Token)match(input,15,FOLLOW_64); 

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
    // InternalRoom.g:3241:1: entryRuleInterfaceItem returns [EObject current=null] : iv_ruleInterfaceItem= ruleInterfaceItem EOF ;
    public final EObject entryRuleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceItem = null;


        try {
            // InternalRoom.g:3241:54: (iv_ruleInterfaceItem= ruleInterfaceItem EOF )
            // InternalRoom.g:3242:2: iv_ruleInterfaceItem= ruleInterfaceItem EOF
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
    // InternalRoom.g:3248:1: ruleInterfaceItem returns [EObject current=null] : (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) ;
    public final EObject ruleInterfaceItem() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_SAP_1 = null;

        EObject this_SPP_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:3254:2: ( (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP ) )
            // InternalRoom.g:3255:2: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            {
            // InternalRoom.g:3255:2: (this_Port_0= rulePort | this_SAP_1= ruleSAP | this_SPP_2= ruleSPP )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 48:
            case 58:
                {
                alt85=1;
                }
                break;
            case 60:
                {
                alt85=2;
                }
                break;
            case 61:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalRoom.g:3256:3: this_Port_0= rulePort
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
                    // InternalRoom.g:3265:3: this_SAP_1= ruleSAP
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
                    // InternalRoom.g:3274:3: this_SPP_2= ruleSPP
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
    // InternalRoom.g:3286:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalRoom.g:3286:45: (iv_rulePort= rulePort EOF )
            // InternalRoom.g:3287:2: iv_rulePort= rulePort EOF
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
    // InternalRoom.g:3293:1: rulePort returns [EObject current=null] : ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:3299:2: ( ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3300:2: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3300:2: ( ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )? )
            // InternalRoom.g:3301:3: ( (lv_conjugated_0_0= 'conjugated' ) )? otherlv_1= 'Port' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_annotations_6_0= ruleAnnotation ) )* ( (lv_docu_7_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:3301:3: ( (lv_conjugated_0_0= 'conjugated' ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==48) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalRoom.g:3302:4: (lv_conjugated_0_0= 'conjugated' )
                    {
                    // InternalRoom.g:3302:4: (lv_conjugated_0_0= 'conjugated' )
                    // InternalRoom.g:3303:5: lv_conjugated_0_0= 'conjugated'
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

            otherlv_1=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPortAccess().getPortKeyword_1());
            		
            // InternalRoom.g:3319:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:3320:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:3320:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:3321:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

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

            // InternalRoom.g:3337:3: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==35) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRoom.g:3338:4: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:3338:4: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:3339:5: lv_multiplicity_3_0= ruleMULTIPLICITY
                    {

                    					newCompositeNode(grammarAccess.getPortAccess().getMultiplicityMULTIPLICITYParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_10);
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
            		
            // InternalRoom.g:3360:3: ( ( ruleFQN ) )
            // InternalRoom.g:3361:4: ( ruleFQN )
            {
            // InternalRoom.g:3361:4: ( ruleFQN )
            // InternalRoom.g:3362:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPortAccess().getProtocolProtocolClassCrossReference_5_0());
            				
            pushFollow(FOLLOW_67);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:3376:3: ( (lv_annotations_6_0= ruleAnnotation ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==107) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalRoom.g:3377:4: (lv_annotations_6_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3377:4: (lv_annotations_6_0= ruleAnnotation )
            	    // InternalRoom.g:3378:5: lv_annotations_6_0= ruleAnnotation
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
            	    break loop88;
                }
            } while (true);

            // InternalRoom.g:3395:3: ( (lv_docu_7_0= ruleDocumentation ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==35) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalRoom.g:3396:4: (lv_docu_7_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3396:4: (lv_docu_7_0= ruleDocumentation )
                    // InternalRoom.g:3397:5: lv_docu_7_0= ruleDocumentation
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
    // InternalRoom.g:3418:1: entryRuleExternalPort returns [EObject current=null] : iv_ruleExternalPort= ruleExternalPort EOF ;
    public final EObject entryRuleExternalPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalPort = null;


        try {
            // InternalRoom.g:3418:53: (iv_ruleExternalPort= ruleExternalPort EOF )
            // InternalRoom.g:3419:2: iv_ruleExternalPort= ruleExternalPort EOF
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
    // InternalRoom.g:3425:1: ruleExternalPort returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExternalPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:3431:2: ( (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3432:2: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3432:2: (otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3433:3: otherlv_0= 'external' otherlv_1= 'Port' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_87); 

            			newLeafNode(otherlv_0, grammarAccess.getExternalPortAccess().getExternalKeyword_0());
            		
            otherlv_1=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalPortAccess().getPortKeyword_1());
            		
            // InternalRoom.g:3441:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3442:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3442:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:3443:5: otherlv_2= RULE_ID
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
    // InternalRoom.g:3458:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // InternalRoom.g:3458:44: (iv_ruleSAP= ruleSAP EOF )
            // InternalRoom.g:3459:2: iv_ruleSAP= ruleSAP EOF
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
    // InternalRoom.g:3465:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:3471:2: ( (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3472:2: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3472:2: (otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3473:3: otherlv_0= 'SAP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
            		
            // InternalRoom.g:3477:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3478:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3478:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3479:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
            		
            // InternalRoom.g:3499:3: ( ( ruleFQN ) )
            // InternalRoom.g:3500:4: ( ruleFQN )
            {
            // InternalRoom.g:3500:4: ( ruleFQN )
            // InternalRoom.g:3501:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSAPRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSAPAccess().getProtocolProtocolClassCrossReference_3_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:3515:3: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==35) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRoom.g:3516:4: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3516:4: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3517:5: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3538:1: entryRuleSPP returns [EObject current=null] : iv_ruleSPP= ruleSPP EOF ;
    public final EObject entryRuleSPP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPP = null;


        try {
            // InternalRoom.g:3538:44: (iv_ruleSPP= ruleSPP EOF )
            // InternalRoom.g:3539:2: iv_ruleSPP= ruleSPP EOF
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
    // InternalRoom.g:3545:1: ruleSPP returns [EObject current=null] : (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSPP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:3551:2: ( (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3552:2: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3552:2: (otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3553:3: otherlv_0= 'SPP' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSPPAccess().getSPPKeyword_0());
            		
            // InternalRoom.g:3557:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3558:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3558:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3559:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
            		
            // InternalRoom.g:3579:3: ( ( ruleFQN ) )
            // InternalRoom.g:3580:4: ( ruleFQN )
            {
            // InternalRoom.g:3580:4: ( ruleFQN )
            // InternalRoom.g:3581:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSPPRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSPPAccess().getProtocolProtocolClassCrossReference_3_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:3595:3: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==35) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRoom.g:3596:4: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3596:4: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3597:5: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3618:1: entryRuleServiceImplementation returns [EObject current=null] : iv_ruleServiceImplementation= ruleServiceImplementation EOF ;
    public final EObject entryRuleServiceImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceImplementation = null;


        try {
            // InternalRoom.g:3618:62: (iv_ruleServiceImplementation= ruleServiceImplementation EOF )
            // InternalRoom.g:3619:2: iv_ruleServiceImplementation= ruleServiceImplementation EOF
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
    // InternalRoom.g:3625:1: ruleServiceImplementation returns [EObject current=null] : (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleServiceImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:3631:2: ( (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:3632:2: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:3632:2: (otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:3633:3: otherlv_0= 'ServiceImplementation' otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_88); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceImplementationAccess().getServiceImplementationKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getServiceImplementationAccess().getOfKeyword_1());
            		
            // InternalRoom.g:3641:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:3642:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:3642:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:3643:5: otherlv_2= RULE_ID
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
    // InternalRoom.g:3658:1: entryRuleLogicalSystem returns [EObject current=null] : iv_ruleLogicalSystem= ruleLogicalSystem EOF ;
    public final EObject entryRuleLogicalSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalSystem = null;


        try {
            // InternalRoom.g:3658:54: (iv_ruleLogicalSystem= ruleLogicalSystem EOF )
            // InternalRoom.g:3659:2: iv_ruleLogicalSystem= ruleLogicalSystem EOF
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
    // InternalRoom.g:3665:1: ruleLogicalSystem returns [EObject current=null] : (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:3671:2: ( (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:3672:2: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:3672:2: (otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}' )
            // InternalRoom.g:3673:3: otherlv_0= 'LogicalSystem' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLogicalSystemAccess().getLogicalSystemKeyword_0());
            		
            // InternalRoom.g:3677:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3678:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3678:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3679:5: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:3695:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==35) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalRoom.g:3696:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3696:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3697:5: lv_docu_2_0= ruleDocumentation
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
            		
            // InternalRoom.g:3718:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==107) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalRoom.g:3719:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3719:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3720:5: lv_annotations_4_0= ruleAnnotation
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
            	    break loop93;
                }
            } while (true);

            // InternalRoom.g:3737:3: ( ( (lv_connections_5_0= ruleLayerConnection ) ) | ( (lv_bindings_6_0= ruleBinding ) ) | ( (lv_subSystems_7_0= ruleSubSystemRef ) ) )*
            loop94:
            do {
                int alt94=4;
                switch ( input.LA(1) ) {
                case 72:
                    {
                    alt94=1;
                    }
                    break;
                case 69:
                    {
                    alt94=2;
                    }
                    break;
                case 64:
                    {
                    alt94=3;
                    }
                    break;

                }

                switch (alt94) {
            	case 1 :
            	    // InternalRoom.g:3738:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:3738:4: ( (lv_connections_5_0= ruleLayerConnection ) )
            	    // InternalRoom.g:3739:5: (lv_connections_5_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:3739:5: (lv_connections_5_0= ruleLayerConnection )
            	    // InternalRoom.g:3740:6: lv_connections_5_0= ruleLayerConnection
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
            	    // InternalRoom.g:3758:4: ( (lv_bindings_6_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:3758:4: ( (lv_bindings_6_0= ruleBinding ) )
            	    // InternalRoom.g:3759:5: (lv_bindings_6_0= ruleBinding )
            	    {
            	    // InternalRoom.g:3759:5: (lv_bindings_6_0= ruleBinding )
            	    // InternalRoom.g:3760:6: lv_bindings_6_0= ruleBinding
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
            	    // InternalRoom.g:3778:4: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    {
            	    // InternalRoom.g:3778:4: ( (lv_subSystems_7_0= ruleSubSystemRef ) )
            	    // InternalRoom.g:3779:5: (lv_subSystems_7_0= ruleSubSystemRef )
            	    {
            	    // InternalRoom.g:3779:5: (lv_subSystems_7_0= ruleSubSystemRef )
            	    // InternalRoom.g:3780:6: lv_subSystems_7_0= ruleSubSystemRef
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
            	    break loop94;
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
    // InternalRoom.g:3806:1: entryRuleSubSystemRef returns [EObject current=null] : iv_ruleSubSystemRef= ruleSubSystemRef EOF ;
    public final EObject entryRuleSubSystemRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemRef = null;


        try {
            // InternalRoom.g:3806:53: (iv_ruleSubSystemRef= ruleSubSystemRef EOF )
            // InternalRoom.g:3807:2: iv_ruleSubSystemRef= ruleSubSystemRef EOF
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
    // InternalRoom.g:3813:1: ruleSubSystemRef returns [EObject current=null] : (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) ;
    public final EObject ruleSubSystemRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_docu_4_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:3819:2: ( (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:3820:2: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:3820:2: (otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )? )
            // InternalRoom.g:3821:3: otherlv_0= 'SubSystemRef' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_docu_4_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,64,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubSystemRefAccess().getSubSystemRefKeyword_0());
            		
            // InternalRoom.g:3825:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3826:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3826:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3827:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
            		
            // InternalRoom.g:3847:3: ( ( ruleFQN ) )
            // InternalRoom.g:3848:4: ( ruleFQN )
            {
            // InternalRoom.g:3848:4: ( ruleFQN )
            // InternalRoom.g:3849:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubSystemRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubSystemRefAccess().getTypeSubSystemClassCrossReference_3_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:3863:3: ( (lv_docu_4_0= ruleDocumentation ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==35) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalRoom.g:3864:4: (lv_docu_4_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3864:4: (lv_docu_4_0= ruleDocumentation )
                    // InternalRoom.g:3865:5: lv_docu_4_0= ruleDocumentation
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
    // InternalRoom.g:3886:1: entryRuleSubSystemClass returns [EObject current=null] : iv_ruleSubSystemClass= ruleSubSystemClass EOF ;
    public final EObject entryRuleSubSystemClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystemClass = null;


        try {
            // InternalRoom.g:3886:55: (iv_ruleSubSystemClass= ruleSubSystemClass EOF )
            // InternalRoom.g:3887:2: iv_ruleSubSystemClass= ruleSubSystemClass EOF
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
    // InternalRoom.g:3893:1: ruleSubSystemClass returns [EObject current=null] : (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) ;
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
            // InternalRoom.g:3899:2: ( (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' ) )
            // InternalRoom.g:3900:2: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            {
            // InternalRoom.g:3900:2: (otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}' )
            // InternalRoom.g:3901:3: otherlv_0= 'SubSystemClass' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )? (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )? (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )? ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubSystemClassAccess().getSubSystemClassKeyword_0());
            		
            // InternalRoom.g:3905:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:3906:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:3906:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:3907:5: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:3923:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==35) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalRoom.g:3924:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:3924:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:3925:5: lv_docu_2_0= ruleDocumentation
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
            		
            // InternalRoom.g:3946:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==107) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalRoom.g:3947:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:3947:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:3948:5: lv_annotations_4_0= ruleAnnotation
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
            	    break loop97;
                }
            } while (true);

            // InternalRoom.g:3965:3: (otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==31) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalRoom.g:3966:4: otherlv_5= 'usercode1' ( (lv_userCode1_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_92); 

                    				newLeafNode(otherlv_5, grammarAccess.getSubSystemClassAccess().getUsercode1Keyword_5_0());
                    			
                    // InternalRoom.g:3970:4: ( (lv_userCode1_6_0= ruleDetailCode ) )
                    // InternalRoom.g:3971:5: (lv_userCode1_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:3971:5: (lv_userCode1_6_0= ruleDetailCode )
                    // InternalRoom.g:3972:6: lv_userCode1_6_0= ruleDetailCode
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

            // InternalRoom.g:3990:3: (otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==32) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalRoom.g:3991:4: otherlv_7= 'usercode2' ( (lv_userCode2_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,32,FOLLOW_94); 

                    				newLeafNode(otherlv_7, grammarAccess.getSubSystemClassAccess().getUsercode2Keyword_6_0());
                    			
                    // InternalRoom.g:3995:4: ( (lv_userCode2_8_0= ruleDetailCode ) )
                    // InternalRoom.g:3996:5: (lv_userCode2_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:3996:5: (lv_userCode2_8_0= ruleDetailCode )
                    // InternalRoom.g:3997:6: lv_userCode2_8_0= ruleDetailCode
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

            // InternalRoom.g:4015:3: (otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==33) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalRoom.g:4016:4: otherlv_9= 'usercode3' ( (lv_userCode3_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_96); 

                    				newLeafNode(otherlv_9, grammarAccess.getSubSystemClassAccess().getUsercode3Keyword_7_0());
                    			
                    // InternalRoom.g:4020:4: ( (lv_userCode3_10_0= ruleDetailCode ) )
                    // InternalRoom.g:4021:5: (lv_userCode3_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:4021:5: (lv_userCode3_10_0= ruleDetailCode )
                    // InternalRoom.g:4022:6: lv_userCode3_10_0= ruleDetailCode
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

            // InternalRoom.g:4040:3: ( ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) ) | ( (lv_threads_12_0= ruleLogicalThread ) ) | ( (lv_connections_13_0= ruleLayerConnection ) ) | ( (lv_bindings_14_0= ruleBinding ) ) | ( (lv_actorRefs_15_0= ruleActorRef ) ) | ( (lv_serviceProvisionPoints_16_0= ruleSPP ) ) | ( (lv_relayPorts_17_0= rulePort ) ) )*
            loop101:
            do {
                int alt101=8;
                switch ( input.LA(1) ) {
                case 67:
                    {
                    alt101=1;
                    }
                    break;
                case 66:
                    {
                    alt101=2;
                    }
                    break;
                case 72:
                    {
                    alt101=3;
                    }
                    break;
                case 69:
                    {
                    alt101=4;
                    }
                    break;
                case 75:
                case 110:
                case 126:
                    {
                    alt101=5;
                    }
                    break;
                case 61:
                    {
                    alt101=6;
                    }
                    break;
                case 48:
                case 58:
                    {
                    alt101=7;
                    }
                    break;

                }

                switch (alt101) {
            	case 1 :
            	    // InternalRoom.g:4041:4: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    {
            	    // InternalRoom.g:4041:4: ( (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping ) )
            	    // InternalRoom.g:4042:5: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    {
            	    // InternalRoom.g:4042:5: (lv_actorInstanceMappings_11_0= ruleActorInstanceMapping )
            	    // InternalRoom.g:4043:6: lv_actorInstanceMappings_11_0= ruleActorInstanceMapping
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
            	    // InternalRoom.g:4061:4: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    {
            	    // InternalRoom.g:4061:4: ( (lv_threads_12_0= ruleLogicalThread ) )
            	    // InternalRoom.g:4062:5: (lv_threads_12_0= ruleLogicalThread )
            	    {
            	    // InternalRoom.g:4062:5: (lv_threads_12_0= ruleLogicalThread )
            	    // InternalRoom.g:4063:6: lv_threads_12_0= ruleLogicalThread
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
            	    // InternalRoom.g:4081:4: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    {
            	    // InternalRoom.g:4081:4: ( (lv_connections_13_0= ruleLayerConnection ) )
            	    // InternalRoom.g:4082:5: (lv_connections_13_0= ruleLayerConnection )
            	    {
            	    // InternalRoom.g:4082:5: (lv_connections_13_0= ruleLayerConnection )
            	    // InternalRoom.g:4083:6: lv_connections_13_0= ruleLayerConnection
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
            	    // InternalRoom.g:4101:4: ( (lv_bindings_14_0= ruleBinding ) )
            	    {
            	    // InternalRoom.g:4101:4: ( (lv_bindings_14_0= ruleBinding ) )
            	    // InternalRoom.g:4102:5: (lv_bindings_14_0= ruleBinding )
            	    {
            	    // InternalRoom.g:4102:5: (lv_bindings_14_0= ruleBinding )
            	    // InternalRoom.g:4103:6: lv_bindings_14_0= ruleBinding
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
            	    // InternalRoom.g:4121:4: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    {
            	    // InternalRoom.g:4121:4: ( (lv_actorRefs_15_0= ruleActorRef ) )
            	    // InternalRoom.g:4122:5: (lv_actorRefs_15_0= ruleActorRef )
            	    {
            	    // InternalRoom.g:4122:5: (lv_actorRefs_15_0= ruleActorRef )
            	    // InternalRoom.g:4123:6: lv_actorRefs_15_0= ruleActorRef
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
            	    // InternalRoom.g:4141:4: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    {
            	    // InternalRoom.g:4141:4: ( (lv_serviceProvisionPoints_16_0= ruleSPP ) )
            	    // InternalRoom.g:4142:5: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    {
            	    // InternalRoom.g:4142:5: (lv_serviceProvisionPoints_16_0= ruleSPP )
            	    // InternalRoom.g:4143:6: lv_serviceProvisionPoints_16_0= ruleSPP
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
            	    // InternalRoom.g:4161:4: ( (lv_relayPorts_17_0= rulePort ) )
            	    {
            	    // InternalRoom.g:4161:4: ( (lv_relayPorts_17_0= rulePort ) )
            	    // InternalRoom.g:4162:5: (lv_relayPorts_17_0= rulePort )
            	    {
            	    // InternalRoom.g:4162:5: (lv_relayPorts_17_0= rulePort )
            	    // InternalRoom.g:4163:6: lv_relayPorts_17_0= rulePort
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
            	    break loop101;
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
    // InternalRoom.g:4189:1: entryRuleLogicalThread returns [EObject current=null] : iv_ruleLogicalThread= ruleLogicalThread EOF ;
    public final EObject entryRuleLogicalThread() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalThread = null;


        try {
            // InternalRoom.g:4189:54: (iv_ruleLogicalThread= ruleLogicalThread EOF )
            // InternalRoom.g:4190:2: iv_ruleLogicalThread= ruleLogicalThread EOF
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
    // InternalRoom.g:4196:1: ruleLogicalThread returns [EObject current=null] : (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLogicalThread() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalRoom.g:4202:2: ( (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:4203:2: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:4203:2: (otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:4204:3: otherlv_0= 'LogicalThread' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLogicalThreadAccess().getLogicalThreadKeyword_0());
            		
            // InternalRoom.g:4208:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:4209:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:4209:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:4210:5: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:4230:1: entryRuleActorInstanceMapping returns [EObject current=null] : iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF ;
    public final EObject entryRuleActorInstanceMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorInstanceMapping = null;


        try {
            // InternalRoom.g:4230:61: (iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF )
            // InternalRoom.g:4231:2: iv_ruleActorInstanceMapping= ruleActorInstanceMapping EOF
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
    // InternalRoom.g:4237:1: ruleActorInstanceMapping returns [EObject current=null] : (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) ;
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
            // InternalRoom.g:4243:2: ( (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? ) )
            // InternalRoom.g:4244:2: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            {
            // InternalRoom.g:4244:2: (otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )? )
            // InternalRoom.g:4245:3: otherlv_0= 'ActorInstanceMapping' ( (lv_path_1_0= ruleRefPath ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorInstanceMappingAccess().getActorInstanceMappingKeyword_0());
            		
            // InternalRoom.g:4249:3: ( (lv_path_1_0= ruleRefPath ) )
            // InternalRoom.g:4250:4: (lv_path_1_0= ruleRefPath )
            {
            // InternalRoom.g:4250:4: (lv_path_1_0= ruleRefPath )
            // InternalRoom.g:4251:5: lv_path_1_0= ruleRefPath
            {

            					newCompositeNode(grammarAccess.getActorInstanceMappingAccess().getPathRefPathParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
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
            		
            // InternalRoom.g:4272:3: ( (otherlv_3= RULE_ID ) )
            // InternalRoom.g:4273:4: (otherlv_3= RULE_ID )
            {
            // InternalRoom.g:4273:4: (otherlv_3= RULE_ID )
            // InternalRoom.g:4274:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorInstanceMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_98); 

            					newLeafNode(otherlv_3, grammarAccess.getActorInstanceMappingAccess().getThreadLogicalThreadCrossReference_3_0());
            				

            }


            }

            // InternalRoom.g:4285:3: (otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}' )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==14) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalRoom.g:4286:4: otherlv_4= '{' ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )* otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_99); 

                    				newLeafNode(otherlv_4, grammarAccess.getActorInstanceMappingAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalRoom.g:4290:4: ( (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==67) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // InternalRoom.g:4291:5: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    {
                    	    // InternalRoom.g:4291:5: (lv_actorInstanceMappings_5_0= ruleActorInstanceMapping )
                    	    // InternalRoom.g:4292:6: lv_actorInstanceMappings_5_0= ruleActorInstanceMapping
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
                    	    break loop102;
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
    // InternalRoom.g:4318:1: entryRuleRefPath returns [EObject current=null] : iv_ruleRefPath= ruleRefPath EOF ;
    public final EObject entryRuleRefPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefPath = null;


        try {
            // InternalRoom.g:4318:48: (iv_ruleRefPath= ruleRefPath EOF )
            // InternalRoom.g:4319:2: iv_ruleRefPath= ruleRefPath EOF
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
    // InternalRoom.g:4325:1: ruleRefPath returns [EObject current=null] : ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) ;
    public final EObject ruleRefPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_0_0 = null;

        EObject lv_refs_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:4331:2: ( ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* ) )
            // InternalRoom.g:4332:2: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            {
            // InternalRoom.g:4332:2: ( ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )* )
            // InternalRoom.g:4333:3: ( (lv_refs_0_0= ruleRefSegment ) ) (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            {
            // InternalRoom.g:4333:3: ( (lv_refs_0_0= ruleRefSegment ) )
            // InternalRoom.g:4334:4: (lv_refs_0_0= ruleRefSegment )
            {
            // InternalRoom.g:4334:4: (lv_refs_0_0= ruleRefSegment )
            // InternalRoom.g:4335:5: lv_refs_0_0= ruleRefSegment
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

            // InternalRoom.g:4352:3: (otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) ) )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==68) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // InternalRoom.g:4353:4: otherlv_1= '/' ( (lv_refs_2_0= ruleRefSegment ) )
            	    {
            	    otherlv_1=(Token)match(input,68,FOLLOW_3); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefPathAccess().getSolidusKeyword_1_0());
            	    			
            	    // InternalRoom.g:4357:4: ( (lv_refs_2_0= ruleRefSegment ) )
            	    // InternalRoom.g:4358:5: (lv_refs_2_0= ruleRefSegment )
            	    {
            	    // InternalRoom.g:4358:5: (lv_refs_2_0= ruleRefSegment )
            	    // InternalRoom.g:4359:6: lv_refs_2_0= ruleRefSegment
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
            	    break loop104;
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
    // InternalRoom.g:4381:1: entryRuleRefSegment returns [EObject current=null] : iv_ruleRefSegment= ruleRefSegment EOF ;
    public final EObject entryRuleRefSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSegment = null;


        try {
            // InternalRoom.g:4381:51: (iv_ruleRefSegment= ruleRefSegment EOF )
            // InternalRoom.g:4382:2: iv_ruleRefSegment= ruleRefSegment EOF
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
    // InternalRoom.g:4388:1: ruleRefSegment returns [EObject current=null] : ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleRefSegment() throws RecognitionException {
        EObject current = null;

        Token lv_ref_0_0=null;
        Token otherlv_1=null;
        Token lv_idx_2_0=null;


        	enterRule();

        try {
            // InternalRoom.g:4394:2: ( ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? ) )
            // InternalRoom.g:4395:2: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            {
            // InternalRoom.g:4395:2: ( ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )? )
            // InternalRoom.g:4396:3: ( (lv_ref_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            {
            // InternalRoom.g:4396:3: ( (lv_ref_0_0= RULE_ID ) )
            // InternalRoom.g:4397:4: (lv_ref_0_0= RULE_ID )
            {
            // InternalRoom.g:4397:4: (lv_ref_0_0= RULE_ID )
            // InternalRoom.g:4398:5: lv_ref_0_0= RULE_ID
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

            // InternalRoom.g:4414:3: (otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==16) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalRoom.g:4415:4: otherlv_1= ':' ( (lv_idx_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_37); 

                    				newLeafNode(otherlv_1, grammarAccess.getRefSegmentAccess().getColonKeyword_1_0());
                    			
                    // InternalRoom.g:4419:4: ( (lv_idx_2_0= RULE_INT ) )
                    // InternalRoom.g:4420:5: (lv_idx_2_0= RULE_INT )
                    {
                    // InternalRoom.g:4420:5: (lv_idx_2_0= RULE_INT )
                    // InternalRoom.g:4421:6: lv_idx_2_0= RULE_INT
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
    // InternalRoom.g:4442:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalRoom.g:4442:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalRoom.g:4443:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalRoom.g:4449:1: ruleBinding returns [EObject current=null] : (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_endpoint1_1_0 = null;

        EObject lv_endpoint2_3_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:4455:2: ( (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) ) )
            // InternalRoom.g:4456:2: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            {
            // InternalRoom.g:4456:2: (otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) ) )
            // InternalRoom.g:4457:3: otherlv_0= 'Binding' ( (lv_endpoint1_1_0= ruleBindingEndPoint ) ) otherlv_2= 'and' ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBindingAccess().getBindingKeyword_0());
            		
            // InternalRoom.g:4461:3: ( (lv_endpoint1_1_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4462:4: (lv_endpoint1_1_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4462:4: (lv_endpoint1_1_0= ruleBindingEndPoint )
            // InternalRoom.g:4463:5: lv_endpoint1_1_0= ruleBindingEndPoint
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

            otherlv_2=(Token)match(input,70,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getBindingAccess().getAndKeyword_2());
            		
            // InternalRoom.g:4484:3: ( (lv_endpoint2_3_0= ruleBindingEndPoint ) )
            // InternalRoom.g:4485:4: (lv_endpoint2_3_0= ruleBindingEndPoint )
            {
            // InternalRoom.g:4485:4: (lv_endpoint2_3_0= ruleBindingEndPoint )
            // InternalRoom.g:4486:5: lv_endpoint2_3_0= ruleBindingEndPoint
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
    // InternalRoom.g:4507:1: entryRuleBindingEndPoint returns [EObject current=null] : iv_ruleBindingEndPoint= ruleBindingEndPoint EOF ;
    public final EObject entryRuleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingEndPoint = null;


        try {
            // InternalRoom.g:4507:56: (iv_ruleBindingEndPoint= ruleBindingEndPoint EOF )
            // InternalRoom.g:4508:2: iv_ruleBindingEndPoint= ruleBindingEndPoint EOF
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
    // InternalRoom.g:4514:1: ruleBindingEndPoint returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleBindingEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:4520:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4521:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4521:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4522:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4522:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_ID) ) {
                int LA106_1 = input.LA(2);

                if ( (LA106_1==71) ) {
                    alt106=1;
                }
            }
            switch (alt106) {
                case 1 :
                    // InternalRoom.g:4523:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalRoom.g:4523:4: ( (otherlv_0= RULE_ID ) )
                    // InternalRoom.g:4524:5: (otherlv_0= RULE_ID )
                    {
                    // InternalRoom.g:4524:5: (otherlv_0= RULE_ID )
                    // InternalRoom.g:4525:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBindingEndPointRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_103); 

                    						newLeafNode(otherlv_0, grammarAccess.getBindingEndPointAccess().getActorRefActorContainerRefCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,71,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getBindingEndPointAccess().getFullStopKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRoom.g:4541:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4542:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4542:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:4543:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBindingEndPointRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalRoom.g:4558:1: entryRuleLayerConnection returns [EObject current=null] : iv_ruleLayerConnection= ruleLayerConnection EOF ;
    public final EObject entryRuleLayerConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerConnection = null;


        try {
            // InternalRoom.g:4558:56: (iv_ruleLayerConnection= ruleLayerConnection EOF )
            // InternalRoom.g:4559:2: iv_ruleLayerConnection= ruleLayerConnection EOF
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
    // InternalRoom.g:4565:1: ruleLayerConnection returns [EObject current=null] : (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) ;
    public final EObject ruleLayerConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:4571:2: ( (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) ) )
            // InternalRoom.g:4572:2: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            {
            // InternalRoom.g:4572:2: (otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) ) )
            // InternalRoom.g:4573:3: otherlv_0= 'LayerConnection' ( (lv_from_1_0= ruleSAPoint ) ) otherlv_2= 'satisfied_by' ( (lv_to_3_0= ruleSPPoint ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_104); 

            			newLeafNode(otherlv_0, grammarAccess.getLayerConnectionAccess().getLayerConnectionKeyword_0());
            		
            // InternalRoom.g:4577:3: ( (lv_from_1_0= ruleSAPoint ) )
            // InternalRoom.g:4578:4: (lv_from_1_0= ruleSAPoint )
            {
            // InternalRoom.g:4578:4: (lv_from_1_0= ruleSAPoint )
            // InternalRoom.g:4579:5: lv_from_1_0= ruleSAPoint
            {

            					newCompositeNode(grammarAccess.getLayerConnectionAccess().getFromSAPointParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_105);
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

            otherlv_2=(Token)match(input,73,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getLayerConnectionAccess().getSatisfied_byKeyword_2());
            		
            // InternalRoom.g:4600:3: ( (lv_to_3_0= ruleSPPoint ) )
            // InternalRoom.g:4601:4: (lv_to_3_0= ruleSPPoint )
            {
            // InternalRoom.g:4601:4: (lv_to_3_0= ruleSPPoint )
            // InternalRoom.g:4602:5: lv_to_3_0= ruleSPPoint
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
    // InternalRoom.g:4623:1: entryRuleSAPoint returns [EObject current=null] : iv_ruleSAPoint= ruleSAPoint EOF ;
    public final EObject entryRuleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAPoint = null;


        try {
            // InternalRoom.g:4623:48: (iv_ruleSAPoint= ruleSAPoint EOF )
            // InternalRoom.g:4624:2: iv_ruleSAPoint= ruleSAPoint EOF
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
    // InternalRoom.g:4630:1: ruleSAPoint returns [EObject current=null] : (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) ;
    public final EObject ruleSAPoint() throws RecognitionException {
        EObject current = null;

        EObject this_RefSAPoint_0 = null;

        EObject this_RelaySAPoint_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:4636:2: ( (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint ) )
            // InternalRoom.g:4637:2: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            {
            // InternalRoom.g:4637:2: (this_RefSAPoint_0= ruleRefSAPoint | this_RelaySAPoint_1= ruleRelaySAPoint )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==18) ) {
                alt107=1;
            }
            else if ( (LA107_0==74) ) {
                alt107=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // InternalRoom.g:4638:3: this_RefSAPoint_0= ruleRefSAPoint
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
                    // InternalRoom.g:4647:3: this_RelaySAPoint_1= ruleRelaySAPoint
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
    // InternalRoom.g:4659:1: entryRuleRefSAPoint returns [EObject current=null] : iv_ruleRefSAPoint= ruleRefSAPoint EOF ;
    public final EObject entryRuleRefSAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSAPoint = null;


        try {
            // InternalRoom.g:4659:51: (iv_ruleRefSAPoint= ruleRefSAPoint EOF )
            // InternalRoom.g:4660:2: iv_ruleRefSAPoint= ruleRefSAPoint EOF
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
    // InternalRoom.g:4666:1: ruleRefSAPoint returns [EObject current=null] : (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRefSAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoom.g:4672:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4673:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4673:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4674:3: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRefSAPointAccess().getRefKeyword_0());
            		
            // InternalRoom.g:4678:3: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4679:4: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4679:4: (otherlv_1= RULE_ID )
            // InternalRoom.g:4680:5: otherlv_1= RULE_ID
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
    // InternalRoom.g:4695:1: entryRuleRelaySAPoint returns [EObject current=null] : iv_ruleRelaySAPoint= ruleRelaySAPoint EOF ;
    public final EObject entryRuleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelaySAPoint = null;


        try {
            // InternalRoom.g:4695:53: (iv_ruleRelaySAPoint= ruleRelaySAPoint EOF )
            // InternalRoom.g:4696:2: iv_ruleRelaySAPoint= ruleRelaySAPoint EOF
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
    // InternalRoom.g:4702:1: ruleRelaySAPoint returns [EObject current=null] : (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRelaySAPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoom.g:4708:2: ( (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:4709:2: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:4709:2: (otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:4710:3: otherlv_0= 'relay_sap' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRelaySAPointAccess().getRelay_sapKeyword_0());
            		
            // InternalRoom.g:4714:3: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:4715:4: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:4715:4: (otherlv_1= RULE_ID )
            // InternalRoom.g:4716:5: otherlv_1= RULE_ID
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
    // InternalRoom.g:4731:1: entryRuleSPPoint returns [EObject current=null] : iv_ruleSPPoint= ruleSPPoint EOF ;
    public final EObject entryRuleSPPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSPPoint = null;


        try {
            // InternalRoom.g:4731:48: (iv_ruleSPPoint= ruleSPPoint EOF )
            // InternalRoom.g:4732:2: iv_ruleSPPoint= ruleSPPoint EOF
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
    // InternalRoom.g:4738:1: ruleSPPoint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSPPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:4744:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:4745:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:4745:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:4746:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:4746:3: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:4747:4: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:4747:4: (otherlv_0= RULE_ID )
            // InternalRoom.g:4748:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSPPointRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_103); 

            					newLeafNode(otherlv_0, grammarAccess.getSPPointAccess().getRefActorContainerRefCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,71,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSPPointAccess().getFullStopKeyword_1());
            		
            // InternalRoom.g:4763:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:4764:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:4764:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:4765:5: otherlv_2= RULE_ID
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
    // InternalRoom.g:4780:1: entryRuleActorRef returns [EObject current=null] : iv_ruleActorRef= ruleActorRef EOF ;
    public final EObject entryRuleActorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorRef = null;


        try {
            // InternalRoom.g:4780:49: (iv_ruleActorRef= ruleActorRef EOF )
            // InternalRoom.g:4781:2: iv_ruleActorRef= ruleActorRef EOF
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
    // InternalRoom.g:4787:1: ruleActorRef returns [EObject current=null] : ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) ;
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
            // InternalRoom.g:4793:2: ( ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:4794:2: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:4794:2: ( ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )? )
            // InternalRoom.g:4795:3: ( (lv_refType_0_0= ruleReferenceType ) )? otherlv_1= 'ActorRef' ( (lv_name_2_0= RULE_ID ) ) ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )? otherlv_4= ':' ( ( ruleFQN ) ) ( (lv_docu_6_0= ruleDocumentation ) )?
            {
            // InternalRoom.g:4795:3: ( (lv_refType_0_0= ruleReferenceType ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==110||LA108_0==126) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalRoom.g:4796:4: (lv_refType_0_0= ruleReferenceType )
                    {
                    // InternalRoom.g:4796:4: (lv_refType_0_0= ruleReferenceType )
                    // InternalRoom.g:4797:5: lv_refType_0_0= ruleReferenceType
                    {

                    					newCompositeNode(grammarAccess.getActorRefAccess().getRefTypeReferenceTypeEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_106);
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

            otherlv_1=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getActorRefAccess().getActorRefKeyword_1());
            		
            // InternalRoom.g:4818:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:4819:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:4819:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:4820:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_36); 

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

            // InternalRoom.g:4836:3: ( (lv_multiplicity_3_0= ruleMULTIPLICITY ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==35) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalRoom.g:4837:4: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    {
                    // InternalRoom.g:4837:4: (lv_multiplicity_3_0= ruleMULTIPLICITY )
                    // InternalRoom.g:4838:5: lv_multiplicity_3_0= ruleMULTIPLICITY
                    {

                    					newCompositeNode(grammarAccess.getActorRefAccess().getMultiplicityMULTIPLICITYParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_10);
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
            		
            // InternalRoom.g:4859:3: ( ( ruleFQN ) )
            // InternalRoom.g:4860:4: ( ruleFQN )
            {
            // InternalRoom.g:4860:4: ( ruleFQN )
            // InternalRoom.g:4861:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActorRefAccess().getTypeActorClassCrossReference_5_0());
            				
            pushFollow(FOLLOW_19);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:4875:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==35) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalRoom.g:4876:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:4876:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:4877:5: lv_docu_6_0= ruleDocumentation
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
    // InternalRoom.g:4898:1: entryRuleMULTIPLICITY returns [String current=null] : iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF ;
    public final String entryRuleMULTIPLICITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMULTIPLICITY = null;


        try {
            // InternalRoom.g:4898:52: (iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF )
            // InternalRoom.g:4899:2: iv_ruleMULTIPLICITY= ruleMULTIPLICITY EOF
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
    // InternalRoom.g:4905:1: ruleMULTIPLICITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMULTIPLICITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalRoom.g:4911:2: ( (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' ) )
            // InternalRoom.g:4912:2: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            {
            // InternalRoom.g:4912:2: (kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']' )
            // InternalRoom.g:4913:3: kw= '[' (kw= '*' | this_INT_2= RULE_INT ) kw= ']'
            {
            kw=(Token)match(input,35,FOLLOW_107); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoom.g:4918:3: (kw= '*' | this_INT_2= RULE_INT )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==76) ) {
                alt111=1;
            }
            else if ( (LA111_0==RULE_INT) ) {
                alt111=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalRoom.g:4919:4: kw= '*'
                    {
                    kw=(Token)match(input,76,FOLLOW_38); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getMULTIPLICITYAccess().getAsteriskKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:4925:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_38); 

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
    // InternalRoom.g:4942:1: entryRuleAnnotationTargetType returns [String current=null] : iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF ;
    public final String entryRuleAnnotationTargetType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationTargetType = null;


        try {
            // InternalRoom.g:4942:60: (iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF )
            // InternalRoom.g:4943:2: iv_ruleAnnotationTargetType= ruleAnnotationTargetType EOF
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
    // InternalRoom.g:4949:1: ruleAnnotationTargetType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationTargetType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRoom.g:4955:2: ( (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' ) )
            // InternalRoom.g:4956:2: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' )
            {
            // InternalRoom.g:4956:2: (kw= 'DataClass' | kw= 'ActorClass' | kw= 'ActorBehavior' | kw= 'ProtocolClass' | kw= 'CompoundProtocolClass' | kw= 'SubSystemClass' | kw= 'LogicalSystem' | kw= 'Port' | kw= 'Message' | kw= 'State' | kw= 'Transition' | kw= 'RoomModel' )
            int alt112=12;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt112=1;
                }
                break;
            case 54:
                {
                alt112=2;
                }
                break;
            case 77:
                {
                alt112=3;
                }
                break;
            case 43:
                {
                alt112=4;
                }
                break;
            case 78:
                {
                alt112=5;
                }
                break;
            case 65:
                {
                alt112=6;
                }
                break;
            case 63:
                {
                alt112=7;
                }
                break;
            case 58:
                {
                alt112=8;
                }
                break;
            case 50:
                {
                alt112=9;
                }
                break;
            case 79:
                {
                alt112=10;
                }
                break;
            case 80:
                {
                alt112=11;
                }
                break;
            case 13:
                {
                alt112=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalRoom.g:4957:3: kw= 'DataClass'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getDataClassKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRoom.g:4963:3: kw= 'ActorClass'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorClassKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRoom.g:4969:3: kw= 'ActorBehavior'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getActorBehaviorKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRoom.g:4975:3: kw= 'ProtocolClass'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getProtocolClassKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRoom.g:4981:3: kw= 'CompoundProtocolClass'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getCompoundProtocolClassKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRoom.g:4987:3: kw= 'SubSystemClass'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getSubSystemClassKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRoom.g:4993:3: kw= 'LogicalSystem'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getLogicalSystemKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRoom.g:4999:3: kw= 'Port'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getPortKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRoom.g:5005:3: kw= 'Message'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getMessageKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRoom.g:5011:3: kw= 'State'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getStateKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRoom.g:5017:3: kw= 'Transition'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getTransitionKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRoom.g:5023:3: kw= 'RoomModel'
                    {
                    kw=(Token)match(input,13,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAnnotationTargetTypeAccess().getRoomModelKeyword_11());
                    		

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
    // InternalRoom.g:5032:1: entryRuleStateGraphNode returns [EObject current=null] : iv_ruleStateGraphNode= ruleStateGraphNode EOF ;
    public final EObject entryRuleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraphNode = null;


        try {
            // InternalRoom.g:5032:55: (iv_ruleStateGraphNode= ruleStateGraphNode EOF )
            // InternalRoom.g:5033:2: iv_ruleStateGraphNode= ruleStateGraphNode EOF
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
    // InternalRoom.g:5039:1: ruleStateGraphNode returns [EObject current=null] : (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) ;
    public final EObject ruleStateGraphNode() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;

        EObject this_ChoicePoint_1 = null;

        EObject this_TrPoint_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:5045:2: ( (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint ) )
            // InternalRoom.g:5046:2: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            {
            // InternalRoom.g:5046:2: (this_State_0= ruleState | this_ChoicePoint_1= ruleChoicePoint | this_TrPoint_2= ruleTrPoint )
            int alt113=3;
            switch ( input.LA(1) ) {
            case 79:
            case 86:
                {
                alt113=1;
                }
                break;
            case 91:
                {
                alt113=2;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt113=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalRoom.g:5047:3: this_State_0= ruleState
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
                    // InternalRoom.g:5056:3: this_ChoicePoint_1= ruleChoicePoint
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
                    // InternalRoom.g:5065:3: this_TrPoint_2= ruleTrPoint
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
    // InternalRoom.g:5077:1: entryRuleStateGraph returns [EObject current=null] : iv_ruleStateGraph= ruleStateGraph EOF ;
    public final EObject entryRuleStateGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateGraph = null;


        try {
            // InternalRoom.g:5077:51: (iv_ruleStateGraph= ruleStateGraph EOF )
            // InternalRoom.g:5078:2: iv_ruleStateGraph= ruleStateGraph EOF
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
    // InternalRoom.g:5084:1: ruleStateGraph returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) ;
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
            // InternalRoom.g:5090:2: ( ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' ) )
            // InternalRoom.g:5091:2: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            {
            // InternalRoom.g:5091:2: ( () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}' )
            // InternalRoom.g:5092:3: () otherlv_1= '{' ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )* otherlv_7= '}'
            {
            // InternalRoom.g:5092:3: ()
            // InternalRoom.g:5093:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateGraphAccess().getStateGraphAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_108); 

            			newLeafNode(otherlv_1, grammarAccess.getStateGraphAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRoom.g:5103:3: ( ( (lv_states_2_0= ruleState ) ) | ( (lv_trPoints_3_0= ruleTrPoint ) ) | ( (lv_chPoints_4_0= ruleChoicePoint ) ) | ( (lv_transitions_5_0= ruleTransition ) ) | ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) ) )*
            loop114:
            do {
                int alt114=6;
                switch ( input.LA(1) ) {
                case 79:
                case 86:
                    {
                    alt114=1;
                    }
                    break;
                case 87:
                case 88:
                case 89:
                case 90:
                    {
                    alt114=2;
                    }
                    break;
                case 91:
                    {
                    alt114=3;
                    }
                    break;
                case 80:
                    {
                    alt114=4;
                    }
                    break;
                case 98:
                    {
                    alt114=5;
                    }
                    break;

                }

                switch (alt114) {
            	case 1 :
            	    // InternalRoom.g:5104:4: ( (lv_states_2_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5104:4: ( (lv_states_2_0= ruleState ) )
            	    // InternalRoom.g:5105:5: (lv_states_2_0= ruleState )
            	    {
            	    // InternalRoom.g:5105:5: (lv_states_2_0= ruleState )
            	    // InternalRoom.g:5106:6: lv_states_2_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getStatesStateParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5124:4: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5124:4: ( (lv_trPoints_3_0= ruleTrPoint ) )
            	    // InternalRoom.g:5125:5: (lv_trPoints_3_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5125:5: (lv_trPoints_3_0= ruleTrPoint )
            	    // InternalRoom.g:5126:6: lv_trPoints_3_0= ruleTrPoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getTrPointsTrPointParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5144:4: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5144:4: ( (lv_chPoints_4_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5145:5: (lv_chPoints_4_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5145:5: (lv_chPoints_4_0= ruleChoicePoint )
            	    // InternalRoom.g:5146:6: lv_chPoints_4_0= ruleChoicePoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getChPointsChoicePointParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5164:4: ( (lv_transitions_5_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5164:4: ( (lv_transitions_5_0= ruleTransition ) )
            	    // InternalRoom.g:5165:5: (lv_transitions_5_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5165:5: (lv_transitions_5_0= ruleTransition )
            	    // InternalRoom.g:5166:6: lv_transitions_5_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getTransitionsTransitionParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5184:4: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5184:4: ( (lv_refinedTransitions_6_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5185:5: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5185:5: (lv_refinedTransitions_6_0= ruleRefinedTransition )
            	    // InternalRoom.g:5186:6: lv_refinedTransitions_6_0= ruleRefinedTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateGraphAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    break loop114;
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
    // InternalRoom.g:5212:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRoom.g:5212:53: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRoom.g:5213:2: iv_ruleStateMachine= ruleStateMachine EOF
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
    // InternalRoom.g:5219:1: ruleStateMachine returns [EObject current=null] : ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) ;
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
            // InternalRoom.g:5225:2: ( ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' ) )
            // InternalRoom.g:5226:2: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            {
            // InternalRoom.g:5226:2: ( () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}' )
            // InternalRoom.g:5227:3: () otherlv_1= 'StateMachine' otherlv_2= '{' ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )* otherlv_8= '}'
            {
            // InternalRoom.g:5227:3: ()
            // InternalRoom.g:5228:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateMachineAccess().getStateGraphAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,81,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getStateMachineAccess().getStateMachineKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_108); 

            			newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRoom.g:5242:3: ( ( (lv_states_3_0= ruleState ) ) | ( (lv_trPoints_4_0= ruleTrPoint ) ) | ( (lv_chPoints_5_0= ruleChoicePoint ) ) | ( (lv_transitions_6_0= ruleTransition ) ) | ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) ) )*
            loop115:
            do {
                int alt115=6;
                switch ( input.LA(1) ) {
                case 79:
                case 86:
                    {
                    alt115=1;
                    }
                    break;
                case 87:
                case 88:
                case 89:
                case 90:
                    {
                    alt115=2;
                    }
                    break;
                case 91:
                    {
                    alt115=3;
                    }
                    break;
                case 80:
                    {
                    alt115=4;
                    }
                    break;
                case 98:
                    {
                    alt115=5;
                    }
                    break;

                }

                switch (alt115) {
            	case 1 :
            	    // InternalRoom.g:5243:4: ( (lv_states_3_0= ruleState ) )
            	    {
            	    // InternalRoom.g:5243:4: ( (lv_states_3_0= ruleState ) )
            	    // InternalRoom.g:5244:5: (lv_states_3_0= ruleState )
            	    {
            	    // InternalRoom.g:5244:5: (lv_states_3_0= ruleState )
            	    // InternalRoom.g:5245:6: lv_states_3_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStateParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5263:4: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    {
            	    // InternalRoom.g:5263:4: ( (lv_trPoints_4_0= ruleTrPoint ) )
            	    // InternalRoom.g:5264:5: (lv_trPoints_4_0= ruleTrPoint )
            	    {
            	    // InternalRoom.g:5264:5: (lv_trPoints_4_0= ruleTrPoint )
            	    // InternalRoom.g:5265:6: lv_trPoints_4_0= ruleTrPoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getTrPointsTrPointParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5283:4: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    {
            	    // InternalRoom.g:5283:4: ( (lv_chPoints_5_0= ruleChoicePoint ) )
            	    // InternalRoom.g:5284:5: (lv_chPoints_5_0= ruleChoicePoint )
            	    {
            	    // InternalRoom.g:5284:5: (lv_chPoints_5_0= ruleChoicePoint )
            	    // InternalRoom.g:5285:6: lv_chPoints_5_0= ruleChoicePoint
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getChPointsChoicePointParserRuleCall_3_2_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5303:4: ( (lv_transitions_6_0= ruleTransition ) )
            	    {
            	    // InternalRoom.g:5303:4: ( (lv_transitions_6_0= ruleTransition ) )
            	    // InternalRoom.g:5304:5: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // InternalRoom.g:5304:5: (lv_transitions_6_0= ruleTransition )
            	    // InternalRoom.g:5305:6: lv_transitions_6_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getTransitionsTransitionParserRuleCall_3_3_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    // InternalRoom.g:5323:4: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    {
            	    // InternalRoom.g:5323:4: ( (lv_refinedTransitions_7_0= ruleRefinedTransition ) )
            	    // InternalRoom.g:5324:5: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    {
            	    // InternalRoom.g:5324:5: (lv_refinedTransitions_7_0= ruleRefinedTransition )
            	    // InternalRoom.g:5325:6: lv_refinedTransitions_7_0= ruleRefinedTransition
            	    {

            	    						newCompositeNode(grammarAccess.getStateMachineAccess().getRefinedTransitionsRefinedTransitionParserRuleCall_3_4_0());
            	    					
            	    pushFollow(FOLLOW_108);
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
            	    break loop115;
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
    // InternalRoom.g:5351:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRoom.g:5351:46: (iv_ruleState= ruleState EOF )
            // InternalRoom.g:5352:2: iv_ruleState= ruleState EOF
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
    // InternalRoom.g:5358:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_RefinedState_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:5364:2: ( (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState ) )
            // InternalRoom.g:5365:2: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            {
            // InternalRoom.g:5365:2: (this_SimpleState_0= ruleSimpleState | this_RefinedState_1= ruleRefinedState )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==79) ) {
                alt116=1;
            }
            else if ( (LA116_0==86) ) {
                alt116=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    // InternalRoom.g:5366:3: this_SimpleState_0= ruleSimpleState
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
                    // InternalRoom.g:5375:3: this_RefinedState_1= ruleRefinedState
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
    // InternalRoom.g:5387:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // InternalRoom.g:5387:52: (iv_ruleSimpleState= ruleSimpleState EOF )
            // InternalRoom.g:5388:2: iv_ruleSimpleState= ruleSimpleState EOF
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
    // InternalRoom.g:5394:1: ruleSimpleState returns [EObject current=null] : (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) ;
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
            // InternalRoom.g:5400:2: ( (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? ) )
            // InternalRoom.g:5401:2: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            {
            // InternalRoom.g:5401:2: (otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )? )
            // InternalRoom.g:5402:3: otherlv_0= 'State' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            {
            otherlv_0=(Token)match(input,79,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleStateAccess().getStateKeyword_0());
            		
            // InternalRoom.g:5406:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5407:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5407:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5408:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_109); 

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

            // InternalRoom.g:5424:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==35) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalRoom.g:5425:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5425:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5426:5: lv_docu_2_0= ruleDocumentation
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

            // InternalRoom.g:5443:3: (otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==14) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalRoom.g:5444:4: otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_110); 

                    				newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalRoom.g:5448:4: ( (lv_annotations_4_0= ruleAnnotation ) )*
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( (LA118_0==107) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // InternalRoom.g:5449:5: (lv_annotations_4_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:5449:5: (lv_annotations_4_0= ruleAnnotation )
                    	    // InternalRoom.g:5450:6: lv_annotations_4_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getSimpleStateAccess().getAnnotationsAnnotationParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_110);
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
                    	    break loop118;
                        }
                    } while (true);

                    // InternalRoom.g:5467:4: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==82) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalRoom.g:5468:5: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                            {
                            otherlv_5=(Token)match(input,82,FOLLOW_111); 

                            					newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getEntryKeyword_3_2_0());
                            				
                            // InternalRoom.g:5472:5: ( (lv_entryCode_6_0= ruleDetailCode ) )
                            // InternalRoom.g:5473:6: (lv_entryCode_6_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5473:6: (lv_entryCode_6_0= ruleDetailCode )
                            // InternalRoom.g:5474:7: lv_entryCode_6_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getEntryCodeDetailCodeParserRuleCall_3_2_1_0());
                            						
                            pushFollow(FOLLOW_112);
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

                    // InternalRoom.g:5492:4: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==83) ) {
                        alt120=1;
                    }
                    switch (alt120) {
                        case 1 :
                            // InternalRoom.g:5493:5: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                            {
                            otherlv_7=(Token)match(input,83,FOLLOW_113); 

                            					newLeafNode(otherlv_7, grammarAccess.getSimpleStateAccess().getExitKeyword_3_3_0());
                            				
                            // InternalRoom.g:5497:5: ( (lv_exitCode_8_0= ruleDetailCode ) )
                            // InternalRoom.g:5498:6: (lv_exitCode_8_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5498:6: (lv_exitCode_8_0= ruleDetailCode )
                            // InternalRoom.g:5499:7: lv_exitCode_8_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getExitCodeDetailCodeParserRuleCall_3_3_1_0());
                            						
                            pushFollow(FOLLOW_114);
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

                    // InternalRoom.g:5517:4: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==84) ) {
                        alt121=1;
                    }
                    switch (alt121) {
                        case 1 :
                            // InternalRoom.g:5518:5: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,84,FOLLOW_115); 

                            					newLeafNode(otherlv_9, grammarAccess.getSimpleStateAccess().getDoKeyword_3_4_0());
                            				
                            // InternalRoom.g:5522:5: ( (lv_doCode_10_0= ruleDetailCode ) )
                            // InternalRoom.g:5523:6: (lv_doCode_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:5523:6: (lv_doCode_10_0= ruleDetailCode )
                            // InternalRoom.g:5524:7: lv_doCode_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getDoCodeDetailCodeParserRuleCall_3_4_1_0());
                            						
                            pushFollow(FOLLOW_116);
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

                    // InternalRoom.g:5542:4: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==85) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // InternalRoom.g:5543:5: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                            {
                            otherlv_11=(Token)match(input,85,FOLLOW_5); 

                            					newLeafNode(otherlv_11, grammarAccess.getSimpleStateAccess().getSubgraphKeyword_3_5_0());
                            				
                            // InternalRoom.g:5547:5: ( (lv_subgraph_12_0= ruleStateGraph ) )
                            // InternalRoom.g:5548:6: (lv_subgraph_12_0= ruleStateGraph )
                            {
                            // InternalRoom.g:5548:6: (lv_subgraph_12_0= ruleStateGraph )
                            // InternalRoom.g:5549:7: lv_subgraph_12_0= ruleStateGraph
                            {

                            							newCompositeNode(grammarAccess.getSimpleStateAccess().getSubgraphStateGraphParserRuleCall_3_5_1_0());
                            						
                            pushFollow(FOLLOW_64);
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
    // InternalRoom.g:5576:1: entryRuleRefinedState returns [EObject current=null] : iv_ruleRefinedState= ruleRefinedState EOF ;
    public final EObject entryRuleRefinedState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedState = null;


        try {
            // InternalRoom.g:5576:53: (iv_ruleRefinedState= ruleRefinedState EOF )
            // InternalRoom.g:5577:2: iv_ruleRefinedState= ruleRefinedState EOF
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
    // InternalRoom.g:5583:1: ruleRefinedState returns [EObject current=null] : (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:5589:2: ( (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:5590:2: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:5590:2: (otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}' )
            // InternalRoom.g:5591:3: otherlv_0= 'RefinedState' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )? (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )? (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )? (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRefinedStateAccess().getRefinedStateKeyword_0());
            		
            // InternalRoom.g:5595:3: ( ( ruleFQN ) )
            // InternalRoom.g:5596:4: ( ruleFQN )
            {
            // InternalRoom.g:5596:4: ( ruleFQN )
            // InternalRoom.g:5597:5: ruleFQN
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

            // InternalRoom.g:5611:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==35) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalRoom.g:5612:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:5612:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:5613:5: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_110); 

            			newLeafNode(otherlv_3, grammarAccess.getRefinedStateAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalRoom.g:5634:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==107) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // InternalRoom.g:5635:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:5635:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:5636:5: lv_annotations_4_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getRefinedStateAccess().getAnnotationsAnnotationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_110);
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
            	    break loop125;
                }
            } while (true);

            // InternalRoom.g:5653:3: (otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==82) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalRoom.g:5654:4: otherlv_5= 'entry' ( (lv_entryCode_6_0= ruleDetailCode ) )
                    {
                    otherlv_5=(Token)match(input,82,FOLLOW_111); 

                    				newLeafNode(otherlv_5, grammarAccess.getRefinedStateAccess().getEntryKeyword_5_0());
                    			
                    // InternalRoom.g:5658:4: ( (lv_entryCode_6_0= ruleDetailCode ) )
                    // InternalRoom.g:5659:5: (lv_entryCode_6_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5659:5: (lv_entryCode_6_0= ruleDetailCode )
                    // InternalRoom.g:5660:6: lv_entryCode_6_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getEntryCodeDetailCodeParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_112);
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

            // InternalRoom.g:5678:3: (otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==83) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalRoom.g:5679:4: otherlv_7= 'exit' ( (lv_exitCode_8_0= ruleDetailCode ) )
                    {
                    otherlv_7=(Token)match(input,83,FOLLOW_113); 

                    				newLeafNode(otherlv_7, grammarAccess.getRefinedStateAccess().getExitKeyword_6_0());
                    			
                    // InternalRoom.g:5683:4: ( (lv_exitCode_8_0= ruleDetailCode ) )
                    // InternalRoom.g:5684:5: (lv_exitCode_8_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5684:5: (lv_exitCode_8_0= ruleDetailCode )
                    // InternalRoom.g:5685:6: lv_exitCode_8_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getExitCodeDetailCodeParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_114);
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

            // InternalRoom.g:5703:3: (otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==84) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalRoom.g:5704:4: otherlv_9= 'do' ( (lv_doCode_10_0= ruleDetailCode ) )
                    {
                    otherlv_9=(Token)match(input,84,FOLLOW_115); 

                    				newLeafNode(otherlv_9, grammarAccess.getRefinedStateAccess().getDoKeyword_7_0());
                    			
                    // InternalRoom.g:5708:4: ( (lv_doCode_10_0= ruleDetailCode ) )
                    // InternalRoom.g:5709:5: (lv_doCode_10_0= ruleDetailCode )
                    {
                    // InternalRoom.g:5709:5: (lv_doCode_10_0= ruleDetailCode )
                    // InternalRoom.g:5710:6: lv_doCode_10_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getDoCodeDetailCodeParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_116);
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

            // InternalRoom.g:5728:3: (otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==85) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalRoom.g:5729:4: otherlv_11= 'subgraph' ( (lv_subgraph_12_0= ruleStateGraph ) )
                    {
                    otherlv_11=(Token)match(input,85,FOLLOW_5); 

                    				newLeafNode(otherlv_11, grammarAccess.getRefinedStateAccess().getSubgraphKeyword_8_0());
                    			
                    // InternalRoom.g:5733:4: ( (lv_subgraph_12_0= ruleStateGraph ) )
                    // InternalRoom.g:5734:5: (lv_subgraph_12_0= ruleStateGraph )
                    {
                    // InternalRoom.g:5734:5: (lv_subgraph_12_0= ruleStateGraph )
                    // InternalRoom.g:5735:6: lv_subgraph_12_0= ruleStateGraph
                    {

                    						newCompositeNode(grammarAccess.getRefinedStateAccess().getSubgraphStateGraphParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_64);
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
    // InternalRoom.g:5761:1: entryRuleDetailCode returns [EObject current=null] : iv_ruleDetailCode= ruleDetailCode EOF ;
    public final EObject entryRuleDetailCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailCode = null;


        try {
            // InternalRoom.g:5761:51: (iv_ruleDetailCode= ruleDetailCode EOF )
            // InternalRoom.g:5762:2: iv_ruleDetailCode= ruleDetailCode EOF
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
    // InternalRoom.g:5768:1: ruleDetailCode returns [EObject current=null] : ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleDetailCode() throws RecognitionException {
        EObject current = null;

        Token lv_lines_1_0=null;
        Token lv_used_2_0=null;
        Token lv_lines_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRoom.g:5774:2: ( ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) ) )
            // InternalRoom.g:5775:2: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            {
            // InternalRoom.g:5775:2: ( ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? ) | ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' ) )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==EOF||LA132_0==RULE_CC_STRING||LA132_0==15||(LA132_0>=32 && LA132_0<=34)||(LA132_0>=37 && LA132_0<=38)||(LA132_0>=41 && LA132_0<=42)||(LA132_0>=44 && LA132_0<=46)||LA132_0==48||LA132_0==52||(LA132_0>=58 && LA132_0<=62)||(LA132_0>=66 && LA132_0<=67)||LA132_0==69||LA132_0==72||LA132_0==75||LA132_0==81||(LA132_0>=83 && LA132_0<=85)||LA132_0==93||(LA132_0>=103 && LA132_0<=104)||LA132_0==110||LA132_0==126) ) {
                alt132=1;
            }
            else if ( (LA132_0==14) ) {
                alt132=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalRoom.g:5776:3: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    {
                    // InternalRoom.g:5776:3: ( () ( (lv_lines_1_0= RULE_CC_STRING ) )? )
                    // InternalRoom.g:5777:4: () ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    {
                    // InternalRoom.g:5777:4: ()
                    // InternalRoom.g:5778:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDetailCodeAccess().getDetailCodeAction_0_0(),
                    						current);
                    				

                    }

                    // InternalRoom.g:5784:4: ( (lv_lines_1_0= RULE_CC_STRING ) )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==RULE_CC_STRING) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // InternalRoom.g:5785:5: (lv_lines_1_0= RULE_CC_STRING )
                            {
                            // InternalRoom.g:5785:5: (lv_lines_1_0= RULE_CC_STRING )
                            // InternalRoom.g:5786:6: lv_lines_1_0= RULE_CC_STRING
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
                    // InternalRoom.g:5804:3: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    {
                    // InternalRoom.g:5804:3: ( ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}' )
                    // InternalRoom.g:5805:4: ( (lv_used_2_0= '{' ) ) ( (lv_lines_3_0= RULE_STRING ) )* otherlv_4= '}'
                    {
                    // InternalRoom.g:5805:4: ( (lv_used_2_0= '{' ) )
                    // InternalRoom.g:5806:5: (lv_used_2_0= '{' )
                    {
                    // InternalRoom.g:5806:5: (lv_used_2_0= '{' )
                    // InternalRoom.g:5807:6: lv_used_2_0= '{'
                    {
                    lv_used_2_0=(Token)match(input,14,FOLLOW_117); 

                    						newLeafNode(lv_used_2_0, grammarAccess.getDetailCodeAccess().getUsedLeftCurlyBracketKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDetailCodeRule());
                    						}
                    						setWithLastConsumed(current, "used", true, "{");
                    					

                    }


                    }

                    // InternalRoom.g:5819:4: ( (lv_lines_3_0= RULE_STRING ) )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==RULE_STRING) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // InternalRoom.g:5820:5: (lv_lines_3_0= RULE_STRING )
                    	    {
                    	    // InternalRoom.g:5820:5: (lv_lines_3_0= RULE_STRING )
                    	    // InternalRoom.g:5821:6: lv_lines_3_0= RULE_STRING
                    	    {
                    	    lv_lines_3_0=(Token)match(input,RULE_STRING,FOLLOW_117); 

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
                    	    break loop131;
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
    // InternalRoom.g:5846:1: entryRuleTrPoint returns [EObject current=null] : iv_ruleTrPoint= ruleTrPoint EOF ;
    public final EObject entryRuleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPoint = null;


        try {
            // InternalRoom.g:5846:48: (iv_ruleTrPoint= ruleTrPoint EOF )
            // InternalRoom.g:5847:2: iv_ruleTrPoint= ruleTrPoint EOF
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
    // InternalRoom.g:5853:1: ruleTrPoint returns [EObject current=null] : (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) ;
    public final EObject ruleTrPoint() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionPoint_0 = null;

        EObject this_EntryPoint_1 = null;

        EObject this_ExitPoint_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:5859:2: ( (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint ) )
            // InternalRoom.g:5860:2: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            {
            // InternalRoom.g:5860:2: (this_TransitionPoint_0= ruleTransitionPoint | this_EntryPoint_1= ruleEntryPoint | this_ExitPoint_2= ruleExitPoint )
            int alt133=3;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt133=1;
                }
                break;
            case 89:
                {
                alt133=2;
                }
                break;
            case 90:
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
                    // InternalRoom.g:5861:3: this_TransitionPoint_0= ruleTransitionPoint
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
                    // InternalRoom.g:5870:3: this_EntryPoint_1= ruleEntryPoint
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
                    // InternalRoom.g:5879:3: this_ExitPoint_2= ruleExitPoint
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
    // InternalRoom.g:5891:1: entryRuleTransitionPoint returns [EObject current=null] : iv_ruleTransitionPoint= ruleTransitionPoint EOF ;
    public final EObject entryRuleTransitionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionPoint = null;


        try {
            // InternalRoom.g:5891:56: (iv_ruleTransitionPoint= ruleTransitionPoint EOF )
            // InternalRoom.g:5892:2: iv_ruleTransitionPoint= ruleTransitionPoint EOF
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
    // InternalRoom.g:5898:1: ruleTransitionPoint returns [EObject current=null] : ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTransitionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_handler_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalRoom.g:5904:2: ( ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalRoom.g:5905:2: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5905:2: ( ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalRoom.g:5906:3: ( (lv_handler_0_0= 'handler' ) )? otherlv_1= 'TransitionPoint' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalRoom.g:5906:3: ( (lv_handler_0_0= 'handler' ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==87) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalRoom.g:5907:4: (lv_handler_0_0= 'handler' )
                    {
                    // InternalRoom.g:5907:4: (lv_handler_0_0= 'handler' )
                    // InternalRoom.g:5908:5: lv_handler_0_0= 'handler'
                    {
                    lv_handler_0_0=(Token)match(input,87,FOLLOW_118); 

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
            		
            // InternalRoom.g:5924:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoom.g:5925:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoom.g:5925:4: (lv_name_2_0= RULE_ID )
            // InternalRoom.g:5926:5: lv_name_2_0= RULE_ID
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
    // InternalRoom.g:5946:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalRoom.g:5946:51: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalRoom.g:5947:2: iv_ruleEntryPoint= ruleEntryPoint EOF
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
    // InternalRoom.g:5953:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalRoom.g:5959:2: ( (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:5960:2: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:5960:2: (otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:5961:3: otherlv_0= 'EntryPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryPointKeyword_0());
            		
            // InternalRoom.g:5965:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:5966:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:5966:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:5967:5: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:5987:1: entryRuleExitPoint returns [EObject current=null] : iv_ruleExitPoint= ruleExitPoint EOF ;
    public final EObject entryRuleExitPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPoint = null;


        try {
            // InternalRoom.g:5987:50: (iv_ruleExitPoint= ruleExitPoint EOF )
            // InternalRoom.g:5988:2: iv_ruleExitPoint= ruleExitPoint EOF
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
    // InternalRoom.g:5994:1: ruleExitPoint returns [EObject current=null] : (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalRoom.g:6000:2: ( (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoom.g:6001:2: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoom.g:6001:2: (otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoom.g:6002:3: otherlv_0= 'ExitPoint' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,90,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getExitPointAccess().getExitPointKeyword_0());
            		
            // InternalRoom.g:6006:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6007:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6007:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6008:5: lv_name_1_0= RULE_ID
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
    // InternalRoom.g:6028:1: entryRuleChoicePoint returns [EObject current=null] : iv_ruleChoicePoint= ruleChoicePoint EOF ;
    public final EObject entryRuleChoicePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicePoint = null;


        try {
            // InternalRoom.g:6028:52: (iv_ruleChoicePoint= ruleChoicePoint EOF )
            // InternalRoom.g:6029:2: iv_ruleChoicePoint= ruleChoicePoint EOF
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
    // InternalRoom.g:6035:1: ruleChoicePoint returns [EObject current=null] : (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) ;
    public final EObject ruleChoicePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_docu_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:6041:2: ( (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? ) )
            // InternalRoom.g:6042:2: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            {
            // InternalRoom.g:6042:2: (otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? )
            // InternalRoom.g:6043:3: otherlv_0= 'ChoicePoint' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )?
            {
            otherlv_0=(Token)match(input,91,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getChoicePointAccess().getChoicePointKeyword_0());
            		
            // InternalRoom.g:6047:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:6048:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:6048:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:6049:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

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

            // InternalRoom.g:6065:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==35) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalRoom.g:6066:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6066:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:6067:5: lv_docu_2_0= ruleDocumentation
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
    // InternalRoom.g:6088:1: entryRuleTransitionBase returns [EObject current=null] : iv_ruleTransitionBase= ruleTransitionBase EOF ;
    public final EObject entryRuleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionBase = null;


        try {
            // InternalRoom.g:6088:55: (iv_ruleTransitionBase= ruleTransitionBase EOF )
            // InternalRoom.g:6089:2: iv_ruleTransitionBase= ruleTransitionBase EOF
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
    // InternalRoom.g:6095:1: ruleTransitionBase returns [EObject current=null] : (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) ;
    public final EObject ruleTransitionBase() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_RefinedTransition_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:6101:2: ( (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition ) )
            // InternalRoom.g:6102:2: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            {
            // InternalRoom.g:6102:2: (this_Transition_0= ruleTransition | this_RefinedTransition_1= ruleRefinedTransition )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==80) ) {
                alt136=1;
            }
            else if ( (LA136_0==98) ) {
                alt136=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // InternalRoom.g:6103:3: this_Transition_0= ruleTransition
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
                    // InternalRoom.g:6112:3: this_RefinedTransition_1= ruleRefinedTransition
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
    // InternalRoom.g:6124:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalRoom.g:6124:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalRoom.g:6125:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalRoom.g:6131:1: ruleTransition returns [EObject current=null] : (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_InitialTransition_0 = null;

        EObject this_NonInitialTransition_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:6137:2: ( (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition ) )
            // InternalRoom.g:6138:2: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            {
            // InternalRoom.g:6138:2: (this_InitialTransition_0= ruleInitialTransition | this_NonInitialTransition_1= ruleNonInitialTransition )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==80) ) {
                int LA137_1 = input.LA(2);

                if ( (LA137_1==RULE_ID) ) {
                    int LA137_2 = input.LA(3);

                    if ( (LA137_2==16) ) {
                        int LA137_3 = input.LA(4);

                        if ( (LA137_3==RULE_ID||(LA137_3>=99 && LA137_3<=100)) ) {
                            alt137=2;
                        }
                        else if ( (LA137_3==92) ) {
                            alt137=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 137, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 137, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA137_1==16) ) {
                    int LA137_3 = input.LA(3);

                    if ( (LA137_3==RULE_ID||(LA137_3>=99 && LA137_3<=100)) ) {
                        alt137=2;
                    }
                    else if ( (LA137_3==92) ) {
                        alt137=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 137, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 137, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // InternalRoom.g:6139:3: this_InitialTransition_0= ruleInitialTransition
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
                    // InternalRoom.g:6148:3: this_NonInitialTransition_1= ruleNonInitialTransition
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
    // InternalRoom.g:6160:1: entryRuleNonInitialTransition returns [EObject current=null] : iv_ruleNonInitialTransition= ruleNonInitialTransition EOF ;
    public final EObject entryRuleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonInitialTransition = null;


        try {
            // InternalRoom.g:6160:61: (iv_ruleNonInitialTransition= ruleNonInitialTransition EOF )
            // InternalRoom.g:6161:2: iv_ruleNonInitialTransition= ruleNonInitialTransition EOF
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
    // InternalRoom.g:6167:1: ruleNonInitialTransition returns [EObject current=null] : (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) ;
    public final EObject ruleNonInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionChainStartTransition_0 = null;

        EObject this_ContinuationTransition_1 = null;

        EObject this_CPBranchTransition_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:6173:2: ( (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition ) )
            // InternalRoom.g:6174:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            {
            // InternalRoom.g:6174:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )
            int alt138=3;
            alt138 = dfa138.predict(input);
            switch (alt138) {
                case 1 :
                    // InternalRoom.g:6175:3: this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition
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
                    // InternalRoom.g:6184:3: this_ContinuationTransition_1= ruleContinuationTransition
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
                    // InternalRoom.g:6193:3: this_CPBranchTransition_2= ruleCPBranchTransition
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
    // InternalRoom.g:6205:1: entryRuleTransitionChainStartTransition returns [EObject current=null] : iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF ;
    public final EObject entryRuleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionChainStartTransition = null;


        try {
            // InternalRoom.g:6205:71: (iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF )
            // InternalRoom.g:6206:2: iv_ruleTransitionChainStartTransition= ruleTransitionChainStartTransition EOF
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
    // InternalRoom.g:6212:1: ruleTransitionChainStartTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) ;
    public final EObject ruleTransitionChainStartTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_GuardedTransition_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:6218:2: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition ) )
            // InternalRoom.g:6219:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            {
            // InternalRoom.g:6219:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )
            int alt139=2;
            alt139 = dfa139.predict(input);
            switch (alt139) {
                case 1 :
                    // InternalRoom.g:6220:3: this_TriggeredTransition_0= ruleTriggeredTransition
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
                    // InternalRoom.g:6229:3: this_GuardedTransition_1= ruleGuardedTransition
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
    // InternalRoom.g:6241:1: entryRuleInitialTransition returns [EObject current=null] : iv_ruleInitialTransition= ruleInitialTransition EOF ;
    public final EObject entryRuleInitialTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialTransition = null;


        try {
            // InternalRoom.g:6241:58: (iv_ruleInitialTransition= ruleInitialTransition EOF )
            // InternalRoom.g:6242:2: iv_ruleInitialTransition= ruleInitialTransition EOF
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
    // InternalRoom.g:6248:1: ruleInitialTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6254:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6255:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6255:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6256:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' otherlv_3= 'initial' otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,80,FOLLOW_119); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialTransitionAccess().getTransitionKeyword_0());
            		
            // InternalRoom.g:6260:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==RULE_ID) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // InternalRoom.g:6261:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6261:4: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6262:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_120); 

            			newLeafNode(otherlv_2, grammarAccess.getInitialTransitionAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,92,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getInitialTransitionAccess().getInitialKeyword_3());
            		
            otherlv_4=(Token)match(input,20,FOLLOW_121); 

            			newLeafNode(otherlv_4, grammarAccess.getInitialTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:6290:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6291:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6291:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6292:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getInitialTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_109);
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

            // InternalRoom.g:6309:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==35) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalRoom.g:6310:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6310:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6311:5: lv_docu_6_0= ruleDocumentation
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

            // InternalRoom.g:6328:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==14) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalRoom.g:6329:4: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_122); 

                    				newLeafNode(otherlv_7, grammarAccess.getInitialTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                    			
                    // InternalRoom.g:6333:4: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop142:
                    do {
                        int alt142=2;
                        int LA142_0 = input.LA(1);

                        if ( (LA142_0==107) ) {
                            alt142=1;
                        }


                        switch (alt142) {
                    	case 1 :
                    	    // InternalRoom.g:6334:5: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6334:5: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6335:6: lv_annotations_8_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getInitialTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_122);
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
                    	    break loop142;
                        }
                    } while (true);

                    // InternalRoom.g:6352:4: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt143=2;
                    int LA143_0 = input.LA(1);

                    if ( (LA143_0==93) ) {
                        alt143=1;
                    }
                    switch (alt143) {
                        case 1 :
                            // InternalRoom.g:6353:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,93,FOLLOW_123); 

                            					newLeafNode(otherlv_9, grammarAccess.getInitialTransitionAccess().getActionKeyword_7_2_0());
                            				
                            // InternalRoom.g:6357:5: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6358:6: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6358:6: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6359:7: lv_action_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getInitialTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0());
                            						
                            pushFollow(FOLLOW_64);
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
    // InternalRoom.g:6386:1: entryRuleContinuationTransition returns [EObject current=null] : iv_ruleContinuationTransition= ruleContinuationTransition EOF ;
    public final EObject entryRuleContinuationTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuationTransition = null;


        try {
            // InternalRoom.g:6386:63: (iv_ruleContinuationTransition= ruleContinuationTransition EOF )
            // InternalRoom.g:6387:2: iv_ruleContinuationTransition= ruleContinuationTransition EOF
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
    // InternalRoom.g:6393:1: ruleContinuationTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) ;
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
            // InternalRoom.g:6399:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? ) )
            // InternalRoom.g:6400:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            {
            // InternalRoom.g:6400:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )? )
            // InternalRoom.g:6401:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            {
            otherlv_0=(Token)match(input,80,FOLLOW_119); 

            			newLeafNode(otherlv_0, grammarAccess.getContinuationTransitionAccess().getTransitionKeyword_0());
            		
            // InternalRoom.g:6405:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==RULE_ID) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalRoom.g:6406:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6406:4: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6407:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_121); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuationTransitionAccess().getColonKeyword_2());
            		
            // InternalRoom.g:6427:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6428:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6428:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6429:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getContinuationTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,20,FOLLOW_121); 

            			newLeafNode(otherlv_4, grammarAccess.getContinuationTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:6450:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6451:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6451:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6452:5: lv_to_5_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getContinuationTransitionAccess().getToTransitionTerminalParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_109);
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

            // InternalRoom.g:6469:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==35) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalRoom.g:6470:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6470:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6471:5: lv_docu_6_0= ruleDocumentation
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

            // InternalRoom.g:6488:3: (otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}' )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==14) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalRoom.g:6489:4: otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )? otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_122); 

                    				newLeafNode(otherlv_7, grammarAccess.getContinuationTransitionAccess().getLeftCurlyBracketKeyword_7_0());
                    			
                    // InternalRoom.g:6493:4: ( (lv_annotations_8_0= ruleAnnotation ) )*
                    loop147:
                    do {
                        int alt147=2;
                        int LA147_0 = input.LA(1);

                        if ( (LA147_0==107) ) {
                            alt147=1;
                        }


                        switch (alt147) {
                    	case 1 :
                    	    // InternalRoom.g:6494:5: (lv_annotations_8_0= ruleAnnotation )
                    	    {
                    	    // InternalRoom.g:6494:5: (lv_annotations_8_0= ruleAnnotation )
                    	    // InternalRoom.g:6495:6: lv_annotations_8_0= ruleAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getContinuationTransitionAccess().getAnnotationsAnnotationParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_122);
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
                    	    break loop147;
                        }
                    } while (true);

                    // InternalRoom.g:6512:4: (otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) ) )?
                    int alt148=2;
                    int LA148_0 = input.LA(1);

                    if ( (LA148_0==93) ) {
                        alt148=1;
                    }
                    switch (alt148) {
                        case 1 :
                            // InternalRoom.g:6513:5: otherlv_9= 'action' ( (lv_action_10_0= ruleDetailCode ) )
                            {
                            otherlv_9=(Token)match(input,93,FOLLOW_123); 

                            					newLeafNode(otherlv_9, grammarAccess.getContinuationTransitionAccess().getActionKeyword_7_2_0());
                            				
                            // InternalRoom.g:6517:5: ( (lv_action_10_0= ruleDetailCode ) )
                            // InternalRoom.g:6518:6: (lv_action_10_0= ruleDetailCode )
                            {
                            // InternalRoom.g:6518:6: (lv_action_10_0= ruleDetailCode )
                            // InternalRoom.g:6519:7: lv_action_10_0= ruleDetailCode
                            {

                            							newCompositeNode(grammarAccess.getContinuationTransitionAccess().getActionDetailCodeParserRuleCall_7_2_1_0());
                            						
                            pushFollow(FOLLOW_64);
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
    // InternalRoom.g:6546:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // InternalRoom.g:6546:60: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // InternalRoom.g:6547:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
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
    // InternalRoom.g:6553:1: ruleTriggeredTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) ;
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
            // InternalRoom.g:6559:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' ) )
            // InternalRoom.g:6560:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            {
            // InternalRoom.g:6560:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}' )
            // InternalRoom.g:6561:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' otherlv_8= 'triggers' otherlv_9= '{' ( (lv_annotations_10_0= ruleAnnotation ) )* ( (lv_triggers_11_0= ruleTrigger ) ) (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )* otherlv_14= '}' (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_119); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggeredTransitionAccess().getTransitionKeyword_0());
            		
            // InternalRoom.g:6565:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==RULE_ID) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalRoom.g:6566:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6566:4: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6567:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_121); 

            			newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getColonKeyword_2());
            		
            // InternalRoom.g:6587:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6588:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6588:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6589:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,20,FOLLOW_121); 

            			newLeafNode(otherlv_4, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:6610:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6611:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6611:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6612:5: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6629:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==35) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // InternalRoom.g:6630:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6630:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6631:5: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_124); 

            			newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,94,FOLLOW_5); 

            			newLeafNode(otherlv_8, grammarAccess.getTriggeredTransitionAccess().getTriggersKeyword_8());
            		
            otherlv_9=(Token)match(input,14,FOLLOW_125); 

            			newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalRoom.g:6660:3: ( (lv_annotations_10_0= ruleAnnotation ) )*
            loop152:
            do {
                int alt152=2;
                int LA152_0 = input.LA(1);

                if ( (LA152_0==107) ) {
                    alt152=1;
                }


                switch (alt152) {
            	case 1 :
            	    // InternalRoom.g:6661:4: (lv_annotations_10_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:6661:4: (lv_annotations_10_0= ruleAnnotation )
            	    // InternalRoom.g:6662:5: lv_annotations_10_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getAnnotationsAnnotationParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_125);
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
            	    break loop152;
                }
            } while (true);

            // InternalRoom.g:6679:3: ( (lv_triggers_11_0= ruleTrigger ) )
            // InternalRoom.g:6680:4: (lv_triggers_11_0= ruleTrigger )
            {
            // InternalRoom.g:6680:4: (lv_triggers_11_0= ruleTrigger )
            // InternalRoom.g:6681:5: lv_triggers_11_0= ruleTrigger
            {

            					newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_126);
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

            // InternalRoom.g:6698:3: (otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) ) )*
            loop153:
            do {
                int alt153=2;
                int LA153_0 = input.LA(1);

                if ( (LA153_0==95) ) {
                    alt153=1;
                }


                switch (alt153) {
            	case 1 :
            	    // InternalRoom.g:6699:4: otherlv_12= 'or' ( (lv_triggers_13_0= ruleTrigger ) )
            	    {
            	    otherlv_12=(Token)match(input,95,FOLLOW_125); 

            	    				newLeafNode(otherlv_12, grammarAccess.getTriggeredTransitionAccess().getOrKeyword_12_0());
            	    			
            	    // InternalRoom.g:6703:4: ( (lv_triggers_13_0= ruleTrigger ) )
            	    // InternalRoom.g:6704:5: (lv_triggers_13_0= ruleTrigger )
            	    {
            	    // InternalRoom.g:6704:5: (lv_triggers_13_0= ruleTrigger )
            	    // InternalRoom.g:6705:6: lv_triggers_13_0= ruleTrigger
            	    {

            	    						newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getTriggersTriggerParserRuleCall_12_1_0());
            	    					
            	    pushFollow(FOLLOW_126);
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
            	    break loop153;
                }
            } while (true);

            otherlv_14=(Token)match(input,15,FOLLOW_127); 

            			newLeafNode(otherlv_14, grammarAccess.getTriggeredTransitionAccess().getRightCurlyBracketKeyword_13());
            		
            // InternalRoom.g:6727:3: (otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) ) )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==93) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // InternalRoom.g:6728:4: otherlv_15= 'action' ( (lv_action_16_0= ruleDetailCode ) )
                    {
                    otherlv_15=(Token)match(input,93,FOLLOW_123); 

                    				newLeafNode(otherlv_15, grammarAccess.getTriggeredTransitionAccess().getActionKeyword_14_0());
                    			
                    // InternalRoom.g:6732:4: ( (lv_action_16_0= ruleDetailCode ) )
                    // InternalRoom.g:6733:5: (lv_action_16_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6733:5: (lv_action_16_0= ruleDetailCode )
                    // InternalRoom.g:6734:6: lv_action_16_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getTriggeredTransitionAccess().getActionDetailCodeParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_64);
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
    // InternalRoom.g:6760:1: entryRuleGuardedTransition returns [EObject current=null] : iv_ruleGuardedTransition= ruleGuardedTransition EOF ;
    public final EObject entryRuleGuardedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedTransition = null;


        try {
            // InternalRoom.g:6760:58: (iv_ruleGuardedTransition= ruleGuardedTransition EOF )
            // InternalRoom.g:6761:2: iv_ruleGuardedTransition= ruleGuardedTransition EOF
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
    // InternalRoom.g:6767:1: ruleGuardedTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:6773:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:6774:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:6774:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:6775:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'guard' ( (lv_guard_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_119); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardedTransitionAccess().getTransitionKeyword_0());
            		
            // InternalRoom.g:6779:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==RULE_ID) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // InternalRoom.g:6780:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6780:4: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6781:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_121); 

            			newLeafNode(otherlv_2, grammarAccess.getGuardedTransitionAccess().getColonKeyword_2());
            		
            // InternalRoom.g:6801:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6802:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6802:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6803:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,20,FOLLOW_121); 

            			newLeafNode(otherlv_4, grammarAccess.getGuardedTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:6824:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6825:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6825:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:6826:5: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:6843:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==35) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // InternalRoom.g:6844:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:6844:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:6845:5: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_128); 

            			newLeafNode(otherlv_7, grammarAccess.getGuardedTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalRoom.g:6866:3: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop157:
            do {
                int alt157=2;
                int LA157_0 = input.LA(1);

                if ( (LA157_0==107) ) {
                    alt157=1;
                }


                switch (alt157) {
            	case 1 :
            	    // InternalRoom.g:6867:4: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:6867:4: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:6868:5: lv_annotations_8_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_128);
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
            	    break loop157;
                }
            } while (true);

            otherlv_9=(Token)match(input,96,FOLLOW_129); 

            			newLeafNode(otherlv_9, grammarAccess.getGuardedTransitionAccess().getGuardKeyword_9());
            		
            // InternalRoom.g:6889:3: ( (lv_guard_10_0= ruleDetailCode ) )
            // InternalRoom.g:6890:4: (lv_guard_10_0= ruleDetailCode )
            {
            // InternalRoom.g:6890:4: (lv_guard_10_0= ruleDetailCode )
            // InternalRoom.g:6891:5: lv_guard_10_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getGuardedTransitionAccess().getGuardDetailCodeParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_127);
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

            // InternalRoom.g:6908:3: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==93) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // InternalRoom.g:6909:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,93,FOLLOW_123); 

                    				newLeafNode(otherlv_11, grammarAccess.getGuardedTransitionAccess().getActionKeyword_11_0());
                    			
                    // InternalRoom.g:6913:4: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:6914:5: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:6914:5: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:6915:6: lv_action_12_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getGuardedTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_64);
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
    // InternalRoom.g:6941:1: entryRuleCPBranchTransition returns [EObject current=null] : iv_ruleCPBranchTransition= ruleCPBranchTransition EOF ;
    public final EObject entryRuleCPBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCPBranchTransition = null;


        try {
            // InternalRoom.g:6941:59: (iv_ruleCPBranchTransition= ruleCPBranchTransition EOF )
            // InternalRoom.g:6942:2: iv_ruleCPBranchTransition= ruleCPBranchTransition EOF
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
    // InternalRoom.g:6948:1: ruleCPBranchTransition returns [EObject current=null] : (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) ;
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
            // InternalRoom.g:6954:2: ( (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' ) )
            // InternalRoom.g:6955:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            {
            // InternalRoom.g:6955:2: (otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}' )
            // InternalRoom.g:6956:3: otherlv_0= 'Transition' ( (lv_name_1_0= RULE_ID ) )? otherlv_2= ':' ( (lv_from_3_0= ruleTransitionTerminal ) ) otherlv_4= '->' ( (lv_to_5_0= ruleTransitionTerminal ) ) ( (lv_docu_6_0= ruleDocumentation ) )? otherlv_7= '{' ( (lv_annotations_8_0= ruleAnnotation ) )* otherlv_9= 'cond' ( (lv_condition_10_0= ruleDetailCode ) ) (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_119); 

            			newLeafNode(otherlv_0, grammarAccess.getCPBranchTransitionAccess().getTransitionKeyword_0());
            		
            // InternalRoom.g:6960:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==RULE_ID) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // InternalRoom.g:6961:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRoom.g:6961:4: (lv_name_1_0= RULE_ID )
                    // InternalRoom.g:6962:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_121); 

            			newLeafNode(otherlv_2, grammarAccess.getCPBranchTransitionAccess().getColonKeyword_2());
            		
            // InternalRoom.g:6982:3: ( (lv_from_3_0= ruleTransitionTerminal ) )
            // InternalRoom.g:6983:4: (lv_from_3_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:6983:4: (lv_from_3_0= ruleTransitionTerminal )
            // InternalRoom.g:6984:5: lv_from_3_0= ruleTransitionTerminal
            {

            					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getFromTransitionTerminalParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,20,FOLLOW_121); 

            			newLeafNode(otherlv_4, grammarAccess.getCPBranchTransitionAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalRoom.g:7005:3: ( (lv_to_5_0= ruleTransitionTerminal ) )
            // InternalRoom.g:7006:4: (lv_to_5_0= ruleTransitionTerminal )
            {
            // InternalRoom.g:7006:4: (lv_to_5_0= ruleTransitionTerminal )
            // InternalRoom.g:7007:5: lv_to_5_0= ruleTransitionTerminal
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

            // InternalRoom.g:7024:3: ( (lv_docu_6_0= ruleDocumentation ) )?
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==35) ) {
                alt160=1;
            }
            switch (alt160) {
                case 1 :
                    // InternalRoom.g:7025:4: (lv_docu_6_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7025:4: (lv_docu_6_0= ruleDocumentation )
                    // InternalRoom.g:7026:5: lv_docu_6_0= ruleDocumentation
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

            otherlv_7=(Token)match(input,14,FOLLOW_130); 

            			newLeafNode(otherlv_7, grammarAccess.getCPBranchTransitionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalRoom.g:7047:3: ( (lv_annotations_8_0= ruleAnnotation ) )*
            loop161:
            do {
                int alt161=2;
                int LA161_0 = input.LA(1);

                if ( (LA161_0==107) ) {
                    alt161=1;
                }


                switch (alt161) {
            	case 1 :
            	    // InternalRoom.g:7048:4: (lv_annotations_8_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7048:4: (lv_annotations_8_0= ruleAnnotation )
            	    // InternalRoom.g:7049:5: lv_annotations_8_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getAnnotationsAnnotationParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_130);
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
            	    break loop161;
                }
            } while (true);

            otherlv_9=(Token)match(input,97,FOLLOW_129); 

            			newLeafNode(otherlv_9, grammarAccess.getCPBranchTransitionAccess().getCondKeyword_9());
            		
            // InternalRoom.g:7070:3: ( (lv_condition_10_0= ruleDetailCode ) )
            // InternalRoom.g:7071:4: (lv_condition_10_0= ruleDetailCode )
            {
            // InternalRoom.g:7071:4: (lv_condition_10_0= ruleDetailCode )
            // InternalRoom.g:7072:5: lv_condition_10_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getConditionDetailCodeParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_127);
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

            // InternalRoom.g:7089:3: (otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) ) )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==93) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // InternalRoom.g:7090:4: otherlv_11= 'action' ( (lv_action_12_0= ruleDetailCode ) )
                    {
                    otherlv_11=(Token)match(input,93,FOLLOW_123); 

                    				newLeafNode(otherlv_11, grammarAccess.getCPBranchTransitionAccess().getActionKeyword_11_0());
                    			
                    // InternalRoom.g:7094:4: ( (lv_action_12_0= ruleDetailCode ) )
                    // InternalRoom.g:7095:5: (lv_action_12_0= ruleDetailCode )
                    {
                    // InternalRoom.g:7095:5: (lv_action_12_0= ruleDetailCode )
                    // InternalRoom.g:7096:6: lv_action_12_0= ruleDetailCode
                    {

                    						newCompositeNode(grammarAccess.getCPBranchTransitionAccess().getActionDetailCodeParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_64);
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
    // InternalRoom.g:7122:1: entryRuleRefinedTransition returns [EObject current=null] : iv_ruleRefinedTransition= ruleRefinedTransition EOF ;
    public final EObject entryRuleRefinedTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinedTransition = null;


        try {
            // InternalRoom.g:7122:58: (iv_ruleRefinedTransition= ruleRefinedTransition EOF )
            // InternalRoom.g:7123:2: iv_ruleRefinedTransition= ruleRefinedTransition EOF
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
    // InternalRoom.g:7129:1: ruleRefinedTransition returns [EObject current=null] : (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) ;
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
            // InternalRoom.g:7135:2: ( (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' ) )
            // InternalRoom.g:7136:2: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            {
            // InternalRoom.g:7136:2: (otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}' )
            // InternalRoom.g:7137:3: otherlv_0= 'RefinedTransition' ( ( ruleFQN ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' ( (lv_annotations_4_0= ruleAnnotation ) )* otherlv_5= 'action' ( (lv_action_6_0= ruleDetailCode ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRefinedTransitionAccess().getRefinedTransitionKeyword_0());
            		
            // InternalRoom.g:7141:3: ( ( ruleFQN ) )
            // InternalRoom.g:7142:4: ( ruleFQN )
            {
            // InternalRoom.g:7142:4: ( ruleFQN )
            // InternalRoom.g:7143:5: ruleFQN
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

            // InternalRoom.g:7157:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt163=2;
            int LA163_0 = input.LA(1);

            if ( (LA163_0==35) ) {
                alt163=1;
            }
            switch (alt163) {
                case 1 :
                    // InternalRoom.g:7158:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:7158:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:7159:5: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_131); 

            			newLeafNode(otherlv_3, grammarAccess.getRefinedTransitionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalRoom.g:7180:3: ( (lv_annotations_4_0= ruleAnnotation ) )*
            loop164:
            do {
                int alt164=2;
                int LA164_0 = input.LA(1);

                if ( (LA164_0==107) ) {
                    alt164=1;
                }


                switch (alt164) {
            	case 1 :
            	    // InternalRoom.g:7181:4: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalRoom.g:7181:4: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalRoom.g:7182:5: lv_annotations_4_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getAnnotationsAnnotationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_131);
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
            	    break loop164;
                }
            } while (true);

            otherlv_5=(Token)match(input,93,FOLLOW_123); 

            			newLeafNode(otherlv_5, grammarAccess.getRefinedTransitionAccess().getActionKeyword_5());
            		
            // InternalRoom.g:7203:3: ( (lv_action_6_0= ruleDetailCode ) )
            // InternalRoom.g:7204:4: (lv_action_6_0= ruleDetailCode )
            {
            // InternalRoom.g:7204:4: (lv_action_6_0= ruleDetailCode )
            // InternalRoom.g:7205:5: lv_action_6_0= ruleDetailCode
            {

            					newCompositeNode(grammarAccess.getRefinedTransitionAccess().getActionDetailCodeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_64);
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
    // InternalRoom.g:7230:1: entryRuleTransitionTerminal returns [EObject current=null] : iv_ruleTransitionTerminal= ruleTransitionTerminal EOF ;
    public final EObject entryRuleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionTerminal = null;


        try {
            // InternalRoom.g:7230:59: (iv_ruleTransitionTerminal= ruleTransitionTerminal EOF )
            // InternalRoom.g:7231:2: iv_ruleTransitionTerminal= ruleTransitionTerminal EOF
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
    // InternalRoom.g:7237:1: ruleTransitionTerminal returns [EObject current=null] : (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) ;
    public final EObject ruleTransitionTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_StateTerminal_0 = null;

        EObject this_TrPointTerminal_1 = null;

        EObject this_SubStateTrPointTerminal_2 = null;

        EObject this_ChoicepointTerminal_3 = null;



        	enterRule();

        try {
            // InternalRoom.g:7243:2: ( (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal ) )
            // InternalRoom.g:7244:2: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            {
            // InternalRoom.g:7244:2: (this_StateTerminal_0= ruleStateTerminal | this_TrPointTerminal_1= ruleTrPointTerminal | this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal | this_ChoicepointTerminal_3= ruleChoicepointTerminal )
            int alt165=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA165_1 = input.LA(2);

                if ( (LA165_1==25) ) {
                    alt165=3;
                }
                else if ( (LA165_1==EOF||(LA165_1>=14 && LA165_1<=15)||LA165_1==20||LA165_1==35||(LA165_1>=79 && LA165_1<=80)||(LA165_1>=86 && LA165_1<=91)||LA165_1==98) ) {
                    alt165=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 165, 1, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                alt165=2;
                }
                break;
            case 100:
                {
                alt165=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 165, 0, input);

                throw nvae;
            }

            switch (alt165) {
                case 1 :
                    // InternalRoom.g:7245:3: this_StateTerminal_0= ruleStateTerminal
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
                    // InternalRoom.g:7254:3: this_TrPointTerminal_1= ruleTrPointTerminal
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
                    // InternalRoom.g:7263:3: this_SubStateTrPointTerminal_2= ruleSubStateTrPointTerminal
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
                    // InternalRoom.g:7272:3: this_ChoicepointTerminal_3= ruleChoicepointTerminal
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
    // InternalRoom.g:7284:1: entryRuleStateTerminal returns [EObject current=null] : iv_ruleStateTerminal= ruleStateTerminal EOF ;
    public final EObject entryRuleStateTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateTerminal = null;


        try {
            // InternalRoom.g:7284:54: (iv_ruleStateTerminal= ruleStateTerminal EOF )
            // InternalRoom.g:7285:2: iv_ruleStateTerminal= ruleStateTerminal EOF
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
    // InternalRoom.g:7291:1: ruleStateTerminal returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleStateTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoom.g:7297:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoom.g:7298:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoom.g:7298:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7299:3: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7299:3: (otherlv_0= RULE_ID )
            // InternalRoom.g:7300:4: otherlv_0= RULE_ID
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
    // InternalRoom.g:7314:1: entryRuleTrPointTerminal returns [EObject current=null] : iv_ruleTrPointTerminal= ruleTrPointTerminal EOF ;
    public final EObject entryRuleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrPointTerminal = null;


        try {
            // InternalRoom.g:7314:56: (iv_ruleTrPointTerminal= ruleTrPointTerminal EOF )
            // InternalRoom.g:7315:2: iv_ruleTrPointTerminal= ruleTrPointTerminal EOF
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
    // InternalRoom.g:7321:1: ruleTrPointTerminal returns [EObject current=null] : (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoom.g:7327:2: ( (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7328:2: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7328:2: (otherlv_0= 'my' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7329:3: otherlv_0= 'my' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTrPointTerminalAccess().getMyKeyword_0());
            		
            // InternalRoom.g:7333:3: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7334:4: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7334:4: (otherlv_1= RULE_ID )
            // InternalRoom.g:7335:5: otherlv_1= RULE_ID
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
    // InternalRoom.g:7350:1: entryRuleSubStateTrPointTerminal returns [EObject current=null] : iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF ;
    public final EObject entryRuleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStateTrPointTerminal = null;


        try {
            // InternalRoom.g:7350:64: (iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF )
            // InternalRoom.g:7351:2: iv_ruleSubStateTrPointTerminal= ruleSubStateTrPointTerminal EOF
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
    // InternalRoom.g:7357:1: ruleSubStateTrPointTerminal returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubStateTrPointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:7363:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7364:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7364:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7365:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'of' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7365:3: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7366:4: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7366:4: (otherlv_0= RULE_ID )
            // InternalRoom.g:7367:5: otherlv_0= RULE_ID
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
            		
            // InternalRoom.g:7382:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7383:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7383:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:7384:5: otherlv_2= RULE_ID
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
    // InternalRoom.g:7399:1: entryRuleChoicepointTerminal returns [EObject current=null] : iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF ;
    public final EObject entryRuleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoicepointTerminal = null;


        try {
            // InternalRoom.g:7399:60: (iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF )
            // InternalRoom.g:7400:2: iv_ruleChoicepointTerminal= ruleChoicepointTerminal EOF
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
    // InternalRoom.g:7406:1: ruleChoicepointTerminal returns [EObject current=null] : (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleChoicepointTerminal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoom.g:7412:2: ( (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRoom.g:7413:2: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRoom.g:7413:2: (otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) ) )
            // InternalRoom.g:7414:3: otherlv_0= 'cp' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getChoicepointTerminalAccess().getCpKeyword_0());
            		
            // InternalRoom.g:7418:3: ( (otherlv_1= RULE_ID ) )
            // InternalRoom.g:7419:4: (otherlv_1= RULE_ID )
            {
            // InternalRoom.g:7419:4: (otherlv_1= RULE_ID )
            // InternalRoom.g:7420:5: otherlv_1= RULE_ID
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
    // InternalRoom.g:7435:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // InternalRoom.g:7435:48: (iv_ruleTrigger= ruleTrigger EOF )
            // InternalRoom.g:7436:2: iv_ruleTrigger= ruleTrigger EOF
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
    // InternalRoom.g:7442:1: ruleTrigger returns [EObject current=null] : (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) ;
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
            // InternalRoom.g:7448:2: ( (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' ) )
            // InternalRoom.g:7449:2: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            {
            // InternalRoom.g:7449:2: (otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>' )
            // InternalRoom.g:7450:3: otherlv_0= '<' ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) ) (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )* ( (lv_guard_4_0= ruleGuard ) )? otherlv_5= '>'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggerAccess().getLessThanSignKeyword_0());
            		
            // InternalRoom.g:7454:3: ( (lv_msgFromIfPairs_1_0= ruleMessageFromIf ) )
            // InternalRoom.g:7455:4: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            {
            // InternalRoom.g:7455:4: (lv_msgFromIfPairs_1_0= ruleMessageFromIf )
            // InternalRoom.g:7456:5: lv_msgFromIfPairs_1_0= ruleMessageFromIf
            {

            					newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_132);
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

            // InternalRoom.g:7473:3: (otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) ) )*
            loop166:
            do {
                int alt166=2;
                int LA166_0 = input.LA(1);

                if ( (LA166_0==102) ) {
                    alt166=1;
                }


                switch (alt166) {
            	case 1 :
            	    // InternalRoom.g:7474:4: otherlv_2= '|' ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    {
            	    otherlv_2=(Token)match(input,102,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTriggerAccess().getVerticalLineKeyword_2_0());
            	    			
            	    // InternalRoom.g:7478:4: ( (lv_msgFromIfPairs_3_0= ruleMessageFromIf ) )
            	    // InternalRoom.g:7479:5: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    {
            	    // InternalRoom.g:7479:5: (lv_msgFromIfPairs_3_0= ruleMessageFromIf )
            	    // InternalRoom.g:7480:6: lv_msgFromIfPairs_3_0= ruleMessageFromIf
            	    {

            	    						newCompositeNode(grammarAccess.getTriggerAccess().getMsgFromIfPairsMessageFromIfParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_132);
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
            	    break loop166;
                }
            } while (true);

            // InternalRoom.g:7498:3: ( (lv_guard_4_0= ruleGuard ) )?
            int alt167=2;
            int LA167_0 = input.LA(1);

            if ( (LA167_0==96) ) {
                alt167=1;
            }
            switch (alt167) {
                case 1 :
                    // InternalRoom.g:7499:4: (lv_guard_4_0= ruleGuard )
                    {
                    // InternalRoom.g:7499:4: (lv_guard_4_0= ruleGuard )
                    // InternalRoom.g:7500:5: lv_guard_4_0= ruleGuard
                    {

                    					newCompositeNode(grammarAccess.getTriggerAccess().getGuardGuardParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_133);
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
    // InternalRoom.g:7525:1: entryRuleMessageFromIf returns [EObject current=null] : iv_ruleMessageFromIf= ruleMessageFromIf EOF ;
    public final EObject entryRuleMessageFromIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageFromIf = null;


        try {
            // InternalRoom.g:7525:54: (iv_ruleMessageFromIf= ruleMessageFromIf EOF )
            // InternalRoom.g:7526:2: iv_ruleMessageFromIf= ruleMessageFromIf EOF
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
    // InternalRoom.g:7532:1: ruleMessageFromIf returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMessageFromIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRoom.g:7538:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRoom.g:7539:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRoom.g:7539:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalRoom.g:7540:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRoom.g:7540:3: ( (otherlv_0= RULE_ID ) )
            // InternalRoom.g:7541:4: (otherlv_0= RULE_ID )
            {
            // InternalRoom.g:7541:4: (otherlv_0= RULE_ID )
            // InternalRoom.g:7542:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageFromIfRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_0, grammarAccess.getMessageFromIfAccess().getMessageEObjectCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMessageFromIfAccess().getColonKeyword_1());
            		
            // InternalRoom.g:7557:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7558:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7558:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:7559:5: otherlv_2= RULE_ID
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
    // InternalRoom.g:7574:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // InternalRoom.g:7574:46: (iv_ruleGuard= ruleGuard EOF )
            // InternalRoom.g:7575:2: iv_ruleGuard= ruleGuard EOF
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
    // InternalRoom.g:7581:1: ruleGuard returns [EObject current=null] : (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_guard_1_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:7587:2: ( (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) ) )
            // InternalRoom.g:7588:2: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            {
            // InternalRoom.g:7588:2: (otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) ) )
            // InternalRoom.g:7589:3: otherlv_0= 'guard' ( (lv_guard_1_0= ruleDetailCode ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
            		
            // InternalRoom.g:7593:3: ( (lv_guard_1_0= ruleDetailCode ) )
            // InternalRoom.g:7594:4: (lv_guard_1_0= ruleDetailCode )
            {
            // InternalRoom.g:7594:4: (lv_guard_1_0= ruleDetailCode )
            // InternalRoom.g:7595:5: lv_guard_1_0= ruleDetailCode
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
    // InternalRoom.g:7616:1: entryRuleProtocolSemantics returns [EObject current=null] : iv_ruleProtocolSemantics= ruleProtocolSemantics EOF ;
    public final EObject entryRuleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProtocolSemantics = null;


        try {
            // InternalRoom.g:7616:58: (iv_ruleProtocolSemantics= ruleProtocolSemantics EOF )
            // InternalRoom.g:7617:2: iv_ruleProtocolSemantics= ruleProtocolSemantics EOF
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
    // InternalRoom.g:7623:1: ruleProtocolSemantics returns [EObject current=null] : ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) ;
    public final EObject ruleProtocolSemantics() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rules_3_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:7629:2: ( ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' ) )
            // InternalRoom.g:7630:2: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            {
            // InternalRoom.g:7630:2: ( () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}' )
            // InternalRoom.g:7631:3: () otherlv_1= 'semantics' otherlv_2= '{' ( (lv_rules_3_0= ruleSemanticsRule ) )* otherlv_4= '}'
            {
            // InternalRoom.g:7631:3: ()
            // InternalRoom.g:7632:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProtocolSemanticsAccess().getProtocolSemanticsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,104,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getProtocolSemanticsAccess().getSemanticsKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_134); 

            			newLeafNode(otherlv_2, grammarAccess.getProtocolSemanticsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRoom.g:7646:3: ( (lv_rules_3_0= ruleSemanticsRule ) )*
            loop168:
            do {
                int alt168=2;
                int LA168_0 = input.LA(1);

                if ( ((LA168_0>=105 && LA168_0<=106)) ) {
                    alt168=1;
                }


                switch (alt168) {
            	case 1 :
            	    // InternalRoom.g:7647:4: (lv_rules_3_0= ruleSemanticsRule )
            	    {
            	    // InternalRoom.g:7647:4: (lv_rules_3_0= ruleSemanticsRule )
            	    // InternalRoom.g:7648:5: lv_rules_3_0= ruleSemanticsRule
            	    {

            	    					newCompositeNode(grammarAccess.getProtocolSemanticsAccess().getRulesSemanticsRuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_134);
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
            	    break loop168;
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
    // InternalRoom.g:7673:1: entryRuleSemanticsRule returns [EObject current=null] : iv_ruleSemanticsRule= ruleSemanticsRule EOF ;
    public final EObject entryRuleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticsRule = null;


        try {
            // InternalRoom.g:7673:54: (iv_ruleSemanticsRule= ruleSemanticsRule EOF )
            // InternalRoom.g:7674:2: iv_ruleSemanticsRule= ruleSemanticsRule EOF
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
    // InternalRoom.g:7680:1: ruleSemanticsRule returns [EObject current=null] : (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) ;
    public final EObject ruleSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject this_InSemanticsRule_0 = null;

        EObject this_OutSemanticsRule_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:7686:2: ( (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule ) )
            // InternalRoom.g:7687:2: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            {
            // InternalRoom.g:7687:2: (this_InSemanticsRule_0= ruleInSemanticsRule | this_OutSemanticsRule_1= ruleOutSemanticsRule )
            int alt169=2;
            int LA169_0 = input.LA(1);

            if ( (LA169_0==105) ) {
                alt169=1;
            }
            else if ( (LA169_0==106) ) {
                alt169=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 169, 0, input);

                throw nvae;
            }
            switch (alt169) {
                case 1 :
                    // InternalRoom.g:7688:3: this_InSemanticsRule_0= ruleInSemanticsRule
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
                    // InternalRoom.g:7697:3: this_OutSemanticsRule_1= ruleOutSemanticsRule
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
    // InternalRoom.g:7709:1: entryRuleInSemanticsRule returns [EObject current=null] : iv_ruleInSemanticsRule= ruleInSemanticsRule EOF ;
    public final EObject entryRuleInSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInSemanticsRule = null;


        try {
            // InternalRoom.g:7709:56: (iv_ruleInSemanticsRule= ruleInSemanticsRule EOF )
            // InternalRoom.g:7710:2: iv_ruleInSemanticsRule= ruleInSemanticsRule EOF
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
    // InternalRoom.g:7716:1: ruleInSemanticsRule returns [EObject current=null] : (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7722:2: ( (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7723:2: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7723:2: (otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7724:3: otherlv_0= 'in' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,105,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getInSemanticsRuleAccess().getInKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInSemanticsRuleAccess().getColonKeyword_1());
            		
            // InternalRoom.g:7732:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7733:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7733:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:7734:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInSemanticsRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_135); 

            					newLeafNode(otherlv_2, grammarAccess.getInSemanticsRuleAccess().getMsgEObjectCrossReference_2_0());
            				

            }


            }

            // InternalRoom.g:7745:3: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==20) ) {
                alt172=1;
            }
            switch (alt172) {
                case 1 :
                    // InternalRoom.g:7746:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_136); 

                    				newLeafNode(otherlv_3, grammarAccess.getInSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalRoom.g:7750:4: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt171=2;
                    int LA171_0 = input.LA(1);

                    if ( ((LA171_0>=105 && LA171_0<=106)) ) {
                        alt171=1;
                    }
                    else if ( (LA171_0==21) ) {
                        alt171=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 171, 0, input);

                        throw nvae;
                    }
                    switch (alt171) {
                        case 1 :
                            // InternalRoom.g:7751:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7751:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7752:6: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7752:6: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7753:7: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7771:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7771:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7772:6: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_137); 

                            						newLeafNode(otherlv_5, grammarAccess.getInSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                            					
                            // InternalRoom.g:7776:6: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7777:7: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7777:7: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7778:8: lv_followUps_6_0= ruleSemanticsRule
                            {

                            								newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0());
                            							
                            pushFollow(FOLLOW_138);
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

                            // InternalRoom.g:7795:6: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt170=0;
                            loop170:
                            do {
                                int alt170=2;
                                int LA170_0 = input.LA(1);

                                if ( (LA170_0==26) ) {
                                    alt170=1;
                                }


                                switch (alt170) {
                            	case 1 :
                            	    // InternalRoom.g:7796:7: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_137); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getInSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	    						
                            	    // InternalRoom.g:7800:7: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7801:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7801:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7802:9: lv_followUps_8_0= ruleSemanticsRule
                            	    {

                            	    									newCompositeNode(grammarAccess.getInSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_44);
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
                            	    if ( cnt170 >= 1 ) break loop170;
                                        EarlyExitException eee =
                                            new EarlyExitException(170, input);
                                        throw eee;
                                }
                                cnt170++;
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
    // InternalRoom.g:7831:1: entryRuleOutSemanticsRule returns [EObject current=null] : iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF ;
    public final EObject entryRuleOutSemanticsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutSemanticsRule = null;


        try {
            // InternalRoom.g:7831:57: (iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF )
            // InternalRoom.g:7832:2: iv_ruleOutSemanticsRule= ruleOutSemanticsRule EOF
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
    // InternalRoom.g:7838:1: ruleOutSemanticsRule returns [EObject current=null] : (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) ;
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
            // InternalRoom.g:7844:2: ( (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? ) )
            // InternalRoom.g:7845:2: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            {
            // InternalRoom.g:7845:2: (otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )? )
            // InternalRoom.g:7846:3: otherlv_0= 'out' otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,106,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getOutSemanticsRuleAccess().getOutKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOutSemanticsRuleAccess().getColonKeyword_1());
            		
            // InternalRoom.g:7854:3: ( (otherlv_2= RULE_ID ) )
            // InternalRoom.g:7855:4: (otherlv_2= RULE_ID )
            {
            // InternalRoom.g:7855:4: (otherlv_2= RULE_ID )
            // InternalRoom.g:7856:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutSemanticsRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_135); 

            					newLeafNode(otherlv_2, grammarAccess.getOutSemanticsRuleAccess().getMsgEObjectCrossReference_2_0());
            				

            }


            }

            // InternalRoom.g:7867:3: (otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) ) )?
            int alt175=2;
            int LA175_0 = input.LA(1);

            if ( (LA175_0==20) ) {
                alt175=1;
            }
            switch (alt175) {
                case 1 :
                    // InternalRoom.g:7868:4: otherlv_3= '->' ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_136); 

                    				newLeafNode(otherlv_3, grammarAccess.getOutSemanticsRuleAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                    			
                    // InternalRoom.g:7872:4: ( ( (lv_followUps_4_0= ruleSemanticsRule ) ) | (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' ) )
                    int alt174=2;
                    int LA174_0 = input.LA(1);

                    if ( ((LA174_0>=105 && LA174_0<=106)) ) {
                        alt174=1;
                    }
                    else if ( (LA174_0==21) ) {
                        alt174=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 174, 0, input);

                        throw nvae;
                    }
                    switch (alt174) {
                        case 1 :
                            // InternalRoom.g:7873:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            {
                            // InternalRoom.g:7873:5: ( (lv_followUps_4_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7874:6: (lv_followUps_4_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7874:6: (lv_followUps_4_0= ruleSemanticsRule )
                            // InternalRoom.g:7875:7: lv_followUps_4_0= ruleSemanticsRule
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
                            // InternalRoom.g:7893:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            {
                            // InternalRoom.g:7893:5: (otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')' )
                            // InternalRoom.g:7894:6: otherlv_5= '(' ( (lv_followUps_6_0= ruleSemanticsRule ) ) (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+ otherlv_9= ')'
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_137); 

                            						newLeafNode(otherlv_5, grammarAccess.getOutSemanticsRuleAccess().getLeftParenthesisKeyword_3_1_1_0());
                            					
                            // InternalRoom.g:7898:6: ( (lv_followUps_6_0= ruleSemanticsRule ) )
                            // InternalRoom.g:7899:7: (lv_followUps_6_0= ruleSemanticsRule )
                            {
                            // InternalRoom.g:7899:7: (lv_followUps_6_0= ruleSemanticsRule )
                            // InternalRoom.g:7900:8: lv_followUps_6_0= ruleSemanticsRule
                            {

                            								newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_1_0());
                            							
                            pushFollow(FOLLOW_138);
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

                            // InternalRoom.g:7917:6: (otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) ) )+
                            int cnt173=0;
                            loop173:
                            do {
                                int alt173=2;
                                int LA173_0 = input.LA(1);

                                if ( (LA173_0==26) ) {
                                    alt173=1;
                                }


                                switch (alt173) {
                            	case 1 :
                            	    // InternalRoom.g:7918:7: otherlv_7= ',' ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,26,FOLLOW_137); 

                            	    							newLeafNode(otherlv_7, grammarAccess.getOutSemanticsRuleAccess().getCommaKeyword_3_1_1_2_0());
                            	    						
                            	    // InternalRoom.g:7922:7: ( (lv_followUps_8_0= ruleSemanticsRule ) )
                            	    // InternalRoom.g:7923:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    {
                            	    // InternalRoom.g:7923:8: (lv_followUps_8_0= ruleSemanticsRule )
                            	    // InternalRoom.g:7924:9: lv_followUps_8_0= ruleSemanticsRule
                            	    {

                            	    									newCompositeNode(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsSemanticsRuleParserRuleCall_3_1_1_2_1_0());
                            	    								
                            	    pushFollow(FOLLOW_44);
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
                            	    if ( cnt173 >= 1 ) break loop173;
                                        EarlyExitException eee =
                                            new EarlyExitException(173, input);
                                        throw eee;
                                }
                                cnt173++;
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
    // InternalRoom.g:7953:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalRoom.g:7953:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalRoom.g:7954:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalRoom.g:7960:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) ;
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
            // InternalRoom.g:7966:2: ( (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? ) )
            // InternalRoom.g:7967:2: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            {
            // InternalRoom.g:7967:2: (otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )? )
            // InternalRoom.g:7968:3: otherlv_0= '@' ( ( ruleFQN ) ) (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,107,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalRoom.g:7972:3: ( ( ruleFQN ) )
            // InternalRoom.g:7973:4: ( ruleFQN )
            {
            // InternalRoom.g:7973:4: ( ruleFQN )
            // InternalRoom.g:7974:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0());
            				
            pushFollow(FOLLOW_139);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoom.g:7988:3: (otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')' )?
            int alt177=2;
            int LA177_0 = input.LA(1);

            if ( (LA177_0==21) ) {
                alt177=1;
            }
            switch (alt177) {
                case 1 :
                    // InternalRoom.g:7989:4: otherlv_2= '(' ( (lv_attributes_3_0= ruleKeyValue ) ) (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalRoom.g:7993:4: ( (lv_attributes_3_0= ruleKeyValue ) )
                    // InternalRoom.g:7994:5: (lv_attributes_3_0= ruleKeyValue )
                    {
                    // InternalRoom.g:7994:5: (lv_attributes_3_0= ruleKeyValue )
                    // InternalRoom.g:7995:6: lv_attributes_3_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_44);
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

                    // InternalRoom.g:8012:4: (otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) ) )*
                    loop176:
                    do {
                        int alt176=2;
                        int LA176_0 = input.LA(1);

                        if ( (LA176_0==26) ) {
                            alt176=1;
                        }


                        switch (alt176) {
                    	case 1 :
                    	    // InternalRoom.g:8013:5: otherlv_4= ',' ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,26,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getAnnotationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRoom.g:8017:5: ( (lv_attributes_5_0= ruleKeyValue ) )
                    	    // InternalRoom.g:8018:6: (lv_attributes_5_0= ruleKeyValue )
                    	    {
                    	    // InternalRoom.g:8018:6: (lv_attributes_5_0= ruleKeyValue )
                    	    // InternalRoom.g:8019:7: lv_attributes_5_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getAnnotationAccess().getAttributesKeyValueParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_44);
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
                    	    break loop176;
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
    // InternalRoom.g:8046:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalRoom.g:8046:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalRoom.g:8047:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalRoom.g:8053:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:8059:2: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalRoom.g:8060:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalRoom.g:8060:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalRoom.g:8061:3: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalRoom.g:8061:3: ( (lv_key_0_0= RULE_ID ) )
            // InternalRoom.g:8062:4: (lv_key_0_0= RULE_ID )
            {
            // InternalRoom.g:8062:4: (lv_key_0_0= RULE_ID )
            // InternalRoom.g:8063:5: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_140); 

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

            otherlv_1=(Token)match(input,27,FOLLOW_141); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalRoom.g:8083:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalRoom.g:8084:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalRoom.g:8084:4: (lv_value_2_0= ruleLiteral )
            // InternalRoom.g:8085:5: lv_value_2_0= ruleLiteral
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
    // InternalRoom.g:8106:1: entryRuleAnnotationType returns [EObject current=null] : iv_ruleAnnotationType= ruleAnnotationType EOF ;
    public final EObject entryRuleAnnotationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationType = null;


        try {
            // InternalRoom.g:8106:55: (iv_ruleAnnotationType= ruleAnnotationType EOF )
            // InternalRoom.g:8107:2: iv_ruleAnnotationType= ruleAnnotationType EOF
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
    // InternalRoom.g:8113:1: ruleAnnotationType returns [EObject current=null] : (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) ;
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
            // InternalRoom.g:8119:2: ( (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' ) )
            // InternalRoom.g:8120:2: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            {
            // InternalRoom.g:8120:2: (otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}' )
            // InternalRoom.g:8121:3: otherlv_0= 'AnnotationType' ( (lv_name_1_0= RULE_ID ) ) ( (lv_docu_2_0= ruleDocumentation ) )? otherlv_3= '{' otherlv_4= 'target' otherlv_5= '=' ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) ) ( (lv_attributes_12_0= ruleAnnotationAttribute ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,108,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationTypeAccess().getAnnotationTypeKeyword_0());
            		
            // InternalRoom.g:8125:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoom.g:8126:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoom.g:8126:4: (lv_name_1_0= RULE_ID )
            // InternalRoom.g:8127:5: lv_name_1_0= RULE_ID
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

            // InternalRoom.g:8143:3: ( (lv_docu_2_0= ruleDocumentation ) )?
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==35) ) {
                alt178=1;
            }
            switch (alt178) {
                case 1 :
                    // InternalRoom.g:8144:4: (lv_docu_2_0= ruleDocumentation )
                    {
                    // InternalRoom.g:8144:4: (lv_docu_2_0= ruleDocumentation )
                    // InternalRoom.g:8145:5: lv_docu_2_0= ruleDocumentation
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

            otherlv_3=(Token)match(input,14,FOLLOW_142); 

            			newLeafNode(otherlv_3, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,109,FOLLOW_140); 

            			newLeafNode(otherlv_4, grammarAccess.getAnnotationTypeAccess().getTargetKeyword_4());
            		
            otherlv_5=(Token)match(input,27,FOLLOW_143); 

            			newLeafNode(otherlv_5, grammarAccess.getAnnotationTypeAccess().getEqualsSignKeyword_5());
            		
            // InternalRoom.g:8174:3: ( ( (lv_targets_6_0= ruleAnnotationTargetType ) ) | (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' ) )
            int alt180=2;
            int LA180_0 = input.LA(1);

            if ( (LA180_0==13||LA180_0==29||LA180_0==43||LA180_0==50||LA180_0==54||LA180_0==58||LA180_0==63||LA180_0==65||(LA180_0>=77 && LA180_0<=80)) ) {
                alt180=1;
            }
            else if ( (LA180_0==14) ) {
                alt180=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 180, 0, input);

                throw nvae;
            }
            switch (alt180) {
                case 1 :
                    // InternalRoom.g:8175:4: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    {
                    // InternalRoom.g:8175:4: ( (lv_targets_6_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8176:5: (lv_targets_6_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8176:5: (lv_targets_6_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8177:6: lv_targets_6_0= ruleAnnotationTargetType
                    {

                    						newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_144);
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
                    // InternalRoom.g:8195:4: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    {
                    // InternalRoom.g:8195:4: (otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}' )
                    // InternalRoom.g:8196:5: otherlv_7= '{' ( (lv_targets_8_0= ruleAnnotationTargetType ) ) (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )* otherlv_11= '}'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_145); 

                    					newLeafNode(otherlv_7, grammarAccess.getAnnotationTypeAccess().getLeftCurlyBracketKeyword_6_1_0());
                    				
                    // InternalRoom.g:8200:5: ( (lv_targets_8_0= ruleAnnotationTargetType ) )
                    // InternalRoom.g:8201:6: (lv_targets_8_0= ruleAnnotationTargetType )
                    {
                    // InternalRoom.g:8201:6: (lv_targets_8_0= ruleAnnotationTargetType )
                    // InternalRoom.g:8202:7: lv_targets_8_0= ruleAnnotationTargetType
                    {

                    							newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_1_0());
                    						
                    pushFollow(FOLLOW_23);
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

                    // InternalRoom.g:8219:5: (otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) ) )*
                    loop179:
                    do {
                        int alt179=2;
                        int LA179_0 = input.LA(1);

                        if ( (LA179_0==26) ) {
                            alt179=1;
                        }


                        switch (alt179) {
                    	case 1 :
                    	    // InternalRoom.g:8220:6: otherlv_9= ',' ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    {
                    	    otherlv_9=(Token)match(input,26,FOLLOW_145); 

                    	    						newLeafNode(otherlv_9, grammarAccess.getAnnotationTypeAccess().getCommaKeyword_6_1_2_0());
                    	    					
                    	    // InternalRoom.g:8224:6: ( (lv_targets_10_0= ruleAnnotationTargetType ) )
                    	    // InternalRoom.g:8225:7: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    {
                    	    // InternalRoom.g:8225:7: (lv_targets_10_0= ruleAnnotationTargetType )
                    	    // InternalRoom.g:8226:8: lv_targets_10_0= ruleAnnotationTargetType
                    	    {

                    	    								newCompositeNode(grammarAccess.getAnnotationTypeAccess().getTargetsAnnotationTargetTypeParserRuleCall_6_1_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_23);
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
                    	    break loop179;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_144); 

                    					newLeafNode(otherlv_11, grammarAccess.getAnnotationTypeAccess().getRightCurlyBracketKeyword_6_1_3());
                    				

                    }


                    }
                    break;

            }

            // InternalRoom.g:8250:3: ( (lv_attributes_12_0= ruleAnnotationAttribute ) )*
            loop181:
            do {
                int alt181=2;
                int LA181_0 = input.LA(1);

                if ( ((LA181_0>=110 && LA181_0<=111)) ) {
                    alt181=1;
                }


                switch (alt181) {
            	case 1 :
            	    // InternalRoom.g:8251:4: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    {
            	    // InternalRoom.g:8251:4: (lv_attributes_12_0= ruleAnnotationAttribute )
            	    // InternalRoom.g:8252:5: lv_attributes_12_0= ruleAnnotationAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAnnotationTypeAccess().getAttributesAnnotationAttributeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_144);
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
            	    break loop181;
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
    // InternalRoom.g:8277:1: entryRuleAnnotationAttribute returns [EObject current=null] : iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF ;
    public final EObject entryRuleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8277:60: (iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF )
            // InternalRoom.g:8278:2: iv_ruleAnnotationAttribute= ruleAnnotationAttribute EOF
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
    // InternalRoom.g:8284:1: ruleAnnotationAttribute returns [EObject current=null] : (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) ;
    public final EObject ruleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleAnnotationAttribute_0 = null;

        EObject this_EnumAnnotationAttribute_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:8290:2: ( (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute ) )
            // InternalRoom.g:8291:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            {
            // InternalRoom.g:8291:2: (this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute | this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute )
            int alt182=2;
            int LA182_0 = input.LA(1);

            if ( (LA182_0==110) ) {
                int LA182_1 = input.LA(2);

                if ( (LA182_1==112) ) {
                    int LA182_3 = input.LA(3);

                    if ( (LA182_3==RULE_ID) ) {
                        int LA182_4 = input.LA(4);

                        if ( (LA182_4==16) ) {
                            int LA182_5 = input.LA(5);

                            if ( (LA182_5==14) ) {
                                alt182=2;
                            }
                            else if ( ((LA182_5>=128 && LA182_5<=131)) ) {
                                alt182=1;
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
            else if ( (LA182_0==111) ) {
                int LA182_2 = input.LA(2);

                if ( (LA182_2==112) ) {
                    int LA182_3 = input.LA(3);

                    if ( (LA182_3==RULE_ID) ) {
                        int LA182_4 = input.LA(4);

                        if ( (LA182_4==16) ) {
                            int LA182_5 = input.LA(5);

                            if ( (LA182_5==14) ) {
                                alt182=2;
                            }
                            else if ( ((LA182_5>=128 && LA182_5<=131)) ) {
                                alt182=1;
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
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);

                throw nvae;
            }
            switch (alt182) {
                case 1 :
                    // InternalRoom.g:8292:3: this_SimpleAnnotationAttribute_0= ruleSimpleAnnotationAttribute
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
                    // InternalRoom.g:8301:3: this_EnumAnnotationAttribute_1= ruleEnumAnnotationAttribute
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
    // InternalRoom.g:8313:1: entryRuleSimpleAnnotationAttribute returns [EObject current=null] : iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF ;
    public final EObject entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAnnotationAttribute = null;


        try {
            // InternalRoom.g:8313:66: (iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF )
            // InternalRoom.g:8314:2: iv_ruleSimpleAnnotationAttribute= ruleSimpleAnnotationAttribute EOF
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
    // InternalRoom.g:8320:1: ruleSimpleAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) ;
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
            // InternalRoom.g:8326:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) ) )
            // InternalRoom.g:8327:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            {
            // InternalRoom.g:8327:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) ) )
            // InternalRoom.g:8328:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_type_5_0= ruleLiteralType ) )
            {
            // InternalRoom.g:8328:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt183=2;
            int LA183_0 = input.LA(1);

            if ( (LA183_0==110) ) {
                alt183=1;
            }
            else if ( (LA183_0==111) ) {
                alt183=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 183, 0, input);

                throw nvae;
            }
            switch (alt183) {
                case 1 :
                    // InternalRoom.g:8329:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8329:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8330:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8330:5: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8331:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,110,FOLLOW_146); 

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
                    // InternalRoom.g:8344:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,111,FOLLOW_146); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,112,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalRoom.g:8353:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8354:4: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8354:4: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8355:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            otherlv_4=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3());
            		
            // InternalRoom.g:8375:3: ( (lv_type_5_0= ruleLiteralType ) )
            // InternalRoom.g:8376:4: (lv_type_5_0= ruleLiteralType )
            {
            // InternalRoom.g:8376:4: (lv_type_5_0= ruleLiteralType )
            // InternalRoom.g:8377:5: lv_type_5_0= ruleLiteralType
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
    // InternalRoom.g:8398:1: entryRuleEnumAnnotationAttribute returns [EObject current=null] : iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF ;
    public final EObject entryRuleEnumAnnotationAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAnnotationAttribute = null;


        try {
            // InternalRoom.g:8398:64: (iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF )
            // InternalRoom.g:8399:2: iv_ruleEnumAnnotationAttribute= ruleEnumAnnotationAttribute EOF
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
    // InternalRoom.g:8405:1: ruleEnumAnnotationAttribute returns [EObject current=null] : ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) ;
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
            // InternalRoom.g:8411:2: ( ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' ) )
            // InternalRoom.g:8412:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            {
            // InternalRoom.g:8412:2: ( ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}' )
            // InternalRoom.g:8413:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' ) otherlv_2= 'attribute' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' otherlv_5= '{' ( (lv_values_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )* otherlv_9= '}'
            {
            // InternalRoom.g:8413:3: ( ( (lv_optional_0_0= 'optional' ) ) | otherlv_1= 'mandatory' )
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==110) ) {
                alt184=1;
            }
            else if ( (LA184_0==111) ) {
                alt184=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 184, 0, input);

                throw nvae;
            }
            switch (alt184) {
                case 1 :
                    // InternalRoom.g:8414:4: ( (lv_optional_0_0= 'optional' ) )
                    {
                    // InternalRoom.g:8414:4: ( (lv_optional_0_0= 'optional' ) )
                    // InternalRoom.g:8415:5: (lv_optional_0_0= 'optional' )
                    {
                    // InternalRoom.g:8415:5: (lv_optional_0_0= 'optional' )
                    // InternalRoom.g:8416:6: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,110,FOLLOW_146); 

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
                    // InternalRoom.g:8429:4: otherlv_1= 'mandatory'
                    {
                    otherlv_1=(Token)match(input,111,FOLLOW_146); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,112,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1());
            		
            // InternalRoom.g:8438:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalRoom.g:8439:4: (lv_name_3_0= RULE_ID )
            {
            // InternalRoom.g:8439:4: (lv_name_3_0= RULE_ID )
            // InternalRoom.g:8440:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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
            		
            otherlv_5=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalRoom.g:8464:3: ( (lv_values_6_0= RULE_STRING ) )
            // InternalRoom.g:8465:4: (lv_values_6_0= RULE_STRING )
            {
            // InternalRoom.g:8465:4: (lv_values_6_0= RULE_STRING )
            // InternalRoom.g:8466:5: lv_values_6_0= RULE_STRING
            {
            lv_values_6_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

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

            // InternalRoom.g:8482:3: (otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) ) )*
            loop185:
            do {
                int alt185=2;
                int LA185_0 = input.LA(1);

                if ( (LA185_0==26) ) {
                    alt185=1;
                }


                switch (alt185) {
            	case 1 :
            	    // InternalRoom.g:8483:4: otherlv_7= ',' ( (lv_values_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,26,FOLLOW_15); 

            	    				newLeafNode(otherlv_7, grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalRoom.g:8487:4: ( (lv_values_8_0= RULE_STRING ) )
            	    // InternalRoom.g:8488:5: (lv_values_8_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8488:5: (lv_values_8_0= RULE_STRING )
            	    // InternalRoom.g:8489:6: lv_values_8_0= RULE_STRING
            	    {
            	    lv_values_8_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

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
            	    break loop185;
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
    // InternalRoom.g:8514:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoom.g:8514:47: (iv_ruleImport= ruleImport EOF )
            // InternalRoom.g:8515:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoom.g:8521:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_4=null;
        Token lv_importURI_5_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:8527:2: ( (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) ) )
            // InternalRoom.g:8528:2: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            {
            // InternalRoom.g:8528:2: (otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) ) )
            // InternalRoom.g:8529:3: otherlv_0= 'import' ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,113,FOLLOW_147); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalRoom.g:8533:3: ( ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? ) | (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) ) )
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==RULE_ID) ) {
                alt187=1;
            }
            else if ( (LA187_0==115) ) {
                alt187=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 187, 0, input);

                throw nvae;
            }
            switch (alt187) {
                case 1 :
                    // InternalRoom.g:8534:4: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    {
                    // InternalRoom.g:8534:4: ( ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )? )
                    // InternalRoom.g:8535:5: ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    {
                    // InternalRoom.g:8535:5: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
                    // InternalRoom.g:8536:6: (lv_importedNamespace_1_0= ruleImportedFQN )
                    {
                    // InternalRoom.g:8536:6: (lv_importedNamespace_1_0= ruleImportedFQN )
                    // InternalRoom.g:8537:7: lv_importedNamespace_1_0= ruleImportedFQN
                    {

                    							newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_148);
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

                    // InternalRoom.g:8554:5: (otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) ) )?
                    int alt186=2;
                    int LA186_0 = input.LA(1);

                    if ( (LA186_0==114) ) {
                        alt186=1;
                    }
                    switch (alt186) {
                        case 1 :
                            // InternalRoom.g:8555:6: otherlv_2= 'from' ( (lv_importURI_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,114,FOLLOW_15); 

                            						newLeafNode(otherlv_2, grammarAccess.getImportAccess().getFromKeyword_1_0_1_0());
                            					
                            // InternalRoom.g:8559:6: ( (lv_importURI_3_0= RULE_STRING ) )
                            // InternalRoom.g:8560:7: (lv_importURI_3_0= RULE_STRING )
                            {
                            // InternalRoom.g:8560:7: (lv_importURI_3_0= RULE_STRING )
                            // InternalRoom.g:8561:8: lv_importURI_3_0= RULE_STRING
                            {
                            lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            								newLeafNode(lv_importURI_3_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0_1_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getImportRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"importURI",
                            									lv_importURI_3_0,
                            									"org.eclipse.xtext.common.Terminals.STRING");
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:8580:4: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    {
                    // InternalRoom.g:8580:4: (otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) ) )
                    // InternalRoom.g:8581:5: otherlv_4= 'model' ( (lv_importURI_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,115,FOLLOW_15); 

                    					newLeafNode(otherlv_4, grammarAccess.getImportAccess().getModelKeyword_1_1_0());
                    				
                    // InternalRoom.g:8585:5: ( (lv_importURI_5_0= RULE_STRING ) )
                    // InternalRoom.g:8586:6: (lv_importURI_5_0= RULE_STRING )
                    {
                    // InternalRoom.g:8586:6: (lv_importURI_5_0= RULE_STRING )
                    // InternalRoom.g:8587:7: lv_importURI_5_0= RULE_STRING
                    {
                    lv_importURI_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    							newLeafNode(lv_importURI_5_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getImportRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"importURI",
                    								lv_importURI_5_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

                    }


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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalRoom.g:8609:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalRoom.g:8609:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalRoom.g:8610:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalRoom.g:8616:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:8622:2: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // InternalRoom.g:8623:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // InternalRoom.g:8623:2: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // InternalRoom.g:8624:3: this_FQN_0= ruleFQN (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_149);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalRoom.g:8634:3: (kw= '.*' )?
            int alt188=2;
            int LA188_0 = input.LA(1);

            if ( (LA188_0==116) ) {
                alt188=1;
            }
            switch (alt188) {
                case 1 :
                    // InternalRoom.g:8635:4: kw= '.*'
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
    // InternalRoom.g:8645:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalRoom.g:8645:54: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalRoom.g:8646:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalRoom.g:8652:1: ruleDocumentation returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_lines_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRoom.g:8658:2: ( ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' ) )
            // InternalRoom.g:8659:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            {
            // InternalRoom.g:8659:2: ( () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']' )
            // InternalRoom.g:8660:3: () otherlv_1= '[' ( (lv_lines_2_0= RULE_STRING ) )* otherlv_3= ']'
            {
            // InternalRoom.g:8660:3: ()
            // InternalRoom.g:8661:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDocumentationAccess().getDocumentationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_150); 

            			newLeafNode(otherlv_1, grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRoom.g:8671:3: ( (lv_lines_2_0= RULE_STRING ) )*
            loop189:
            do {
                int alt189=2;
                int LA189_0 = input.LA(1);

                if ( (LA189_0==RULE_STRING) ) {
                    alt189=1;
                }


                switch (alt189) {
            	case 1 :
            	    // InternalRoom.g:8672:4: (lv_lines_2_0= RULE_STRING )
            	    {
            	    // InternalRoom.g:8672:4: (lv_lines_2_0= RULE_STRING )
            	    // InternalRoom.g:8673:5: lv_lines_2_0= RULE_STRING
            	    {
            	    lv_lines_2_0=(Token)match(input,RULE_STRING,FOLLOW_150); 

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
            	    break loop189;
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
    // InternalRoom.g:8697:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalRoom.g:8697:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalRoom.g:8698:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalRoom.g:8704:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_StringLiteral_2 = null;



        	enterRule();

        try {
            // InternalRoom.g:8710:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // InternalRoom.g:8711:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // InternalRoom.g:8711:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt190=3;
            switch ( input.LA(1) ) {
            case 117:
            case 118:
                {
                alt190=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX:
            case 119:
            case 120:
                {
                alt190=2;
                }
                break;
            case RULE_STRING:
                {
                alt190=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 190, 0, input);

                throw nvae;
            }

            switch (alt190) {
                case 1 :
                    // InternalRoom.g:8712:3: this_BooleanLiteral_0= ruleBooleanLiteral
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
                    // InternalRoom.g:8721:3: this_NumberLiteral_1= ruleNumberLiteral
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
                    // InternalRoom.g:8730:3: this_StringLiteral_2= ruleStringLiteral
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
    // InternalRoom.g:8742:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalRoom.g:8742:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalRoom.g:8743:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalRoom.g:8749:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalRoom.g:8755:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalRoom.g:8756:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalRoom.g:8756:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalRoom.g:8757:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalRoom.g:8757:3: ()
            // InternalRoom.g:8758:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalRoom.g:8764:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt191=2;
            int LA191_0 = input.LA(1);

            if ( (LA191_0==117) ) {
                alt191=1;
            }
            else if ( (LA191_0==118) ) {
                alt191=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 191, 0, input);

                throw nvae;
            }
            switch (alt191) {
                case 1 :
                    // InternalRoom.g:8765:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:8770:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalRoom.g:8770:4: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalRoom.g:8771:5: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalRoom.g:8771:5: (lv_isTrue_2_0= 'true' )
                    // InternalRoom.g:8772:6: lv_isTrue_2_0= 'true'
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
    // InternalRoom.g:8789:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalRoom.g:8789:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalRoom.g:8790:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
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
    // InternalRoom.g:8796:1: ruleNumberLiteral returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:8802:2: ( (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalRoom.g:8803:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalRoom.g:8803:2: (this_IntLiteral_0= ruleIntLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt192=2;
            switch ( input.LA(1) ) {
            case 119:
                {
                int LA192_1 = input.LA(2);

                if ( (LA192_1==RULE_INT) ) {
                    int LA192_3 = input.LA(3);

                    if ( (LA192_3==71) ) {
                        alt192=2;
                    }
                    else if ( (LA192_3==EOF||LA192_3==22||LA192_3==26) ) {
                        alt192=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 192, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 192, 1, input);

                    throw nvae;
                }
                }
                break;
            case 120:
                {
                int LA192_2 = input.LA(2);

                if ( (LA192_2==RULE_INT) ) {
                    int LA192_3 = input.LA(3);

                    if ( (LA192_3==71) ) {
                        alt192=2;
                    }
                    else if ( (LA192_3==EOF||LA192_3==22||LA192_3==26) ) {
                        alt192=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 192, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 192, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA192_3 = input.LA(2);

                if ( (LA192_3==71) ) {
                    alt192=2;
                }
                else if ( (LA192_3==EOF||LA192_3==22||LA192_3==26) ) {
                    alt192=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 192, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt192=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 192, 0, input);

                throw nvae;
            }

            switch (alt192) {
                case 1 :
                    // InternalRoom.g:8804:3: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalRoom.g:8813:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalRoom.g:8825:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalRoom.g:8825:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalRoom.g:8826:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalRoom.g:8832:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleReal ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:8838:2: ( ( () ( (lv_value_1_0= ruleReal ) ) ) )
            // InternalRoom.g:8839:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            {
            // InternalRoom.g:8839:2: ( () ( (lv_value_1_0= ruleReal ) ) )
            // InternalRoom.g:8840:3: () ( (lv_value_1_0= ruleReal ) )
            {
            // InternalRoom.g:8840:3: ()
            // InternalRoom.g:8841:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
            					current);
            			

            }

            // InternalRoom.g:8847:3: ( (lv_value_1_0= ruleReal ) )
            // InternalRoom.g:8848:4: (lv_value_1_0= ruleReal )
            {
            // InternalRoom.g:8848:4: (lv_value_1_0= ruleReal )
            // InternalRoom.g:8849:5: lv_value_1_0= ruleReal
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
    // InternalRoom.g:8870:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalRoom.g:8870:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalRoom.g:8871:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalRoom.g:8877:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleInteger ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoom.g:8883:2: ( ( () ( (lv_value_1_0= ruleInteger ) ) ) )
            // InternalRoom.g:8884:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            {
            // InternalRoom.g:8884:2: ( () ( (lv_value_1_0= ruleInteger ) ) )
            // InternalRoom.g:8885:3: () ( (lv_value_1_0= ruleInteger ) )
            {
            // InternalRoom.g:8885:3: ()
            // InternalRoom.g:8886:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
            					current);
            			

            }

            // InternalRoom.g:8892:3: ( (lv_value_1_0= ruleInteger ) )
            // InternalRoom.g:8893:4: (lv_value_1_0= ruleInteger )
            {
            // InternalRoom.g:8893:4: (lv_value_1_0= ruleInteger )
            // InternalRoom.g:8894:5: lv_value_1_0= ruleInteger
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
    // InternalRoom.g:8915:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalRoom.g:8915:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalRoom.g:8916:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalRoom.g:8922:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalRoom.g:8928:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRoom.g:8929:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRoom.g:8929:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRoom.g:8930:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRoom.g:8930:3: ()
            // InternalRoom.g:8931:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            					current);
            			

            }

            // InternalRoom.g:8937:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRoom.g:8938:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalRoom.g:8938:4: (lv_value_1_0= RULE_STRING )
            // InternalRoom.g:8939:5: lv_value_1_0= RULE_STRING
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
    // InternalRoom.g:8959:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // InternalRoom.g:8959:47: (iv_ruleInteger= ruleInteger EOF )
            // InternalRoom.g:8960:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalRoom.g:8966:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_HEX_3=null;


        	enterRule();

        try {
            // InternalRoom.g:8972:2: ( ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX ) )
            // InternalRoom.g:8973:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            {
            // InternalRoom.g:8973:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) | this_HEX_3= RULE_HEX )
            int alt194=2;
            int LA194_0 = input.LA(1);

            if ( (LA194_0==RULE_INT||(LA194_0>=119 && LA194_0<=120)) ) {
                alt194=1;
            }
            else if ( (LA194_0==RULE_HEX) ) {
                alt194=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 194, 0, input);

                throw nvae;
            }
            switch (alt194) {
                case 1 :
                    // InternalRoom.g:8974:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalRoom.g:8974:3: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
                    // InternalRoom.g:8975:4: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalRoom.g:8975:4: (kw= '+' | kw= '-' )?
                    int alt193=3;
                    int LA193_0 = input.LA(1);

                    if ( (LA193_0==119) ) {
                        alt193=1;
                    }
                    else if ( (LA193_0==120) ) {
                        alt193=2;
                    }
                    switch (alt193) {
                        case 1 :
                            // InternalRoom.g:8976:5: kw= '+'
                            {
                            kw=(Token)match(input,119,FOLLOW_37); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getIntegerAccess().getPlusSignKeyword_0_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalRoom.g:8982:5: kw= '-'
                            {
                            kw=(Token)match(input,120,FOLLOW_37); 

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
                    // InternalRoom.g:8997:3: this_HEX_3= RULE_HEX
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
    // InternalRoom.g:9008:1: entryRuleReal returns [String current=null] : iv_ruleReal= ruleReal EOF ;
    public final String entryRuleReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReal = null;


        try {
            // InternalRoom.g:9008:44: (iv_ruleReal= ruleReal EOF )
            // InternalRoom.g:9009:2: iv_ruleReal= ruleReal EOF
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
    // InternalRoom.g:9015:1: ruleReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) ;
    public final AntlrDatatypeRuleToken ruleReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Decimal_0 = null;

        AntlrDatatypeRuleToken this_DecimalExp_1 = null;



        	enterRule();

        try {
            // InternalRoom.g:9021:2: ( (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp ) )
            // InternalRoom.g:9022:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            {
            // InternalRoom.g:9022:2: (this_Decimal_0= ruleDecimal | this_DecimalExp_1= ruleDecimalExp )
            int alt195=2;
            switch ( input.LA(1) ) {
            case 119:
                {
                int LA195_1 = input.LA(2);

                if ( (LA195_1==RULE_INT) ) {
                    int LA195_3 = input.LA(3);

                    if ( (LA195_3==71) ) {
                        int LA195_4 = input.LA(4);

                        if ( (LA195_4==RULE_INT) ) {
                            int LA195_5 = input.LA(5);

                            if ( ((LA195_5>=121 && LA195_5<=122)) ) {
                                alt195=2;
                            }
                            else if ( (LA195_5==EOF||LA195_5==22||LA195_5==26) ) {
                                alt195=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 195, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 195, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 195, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 195, 1, input);

                    throw nvae;
                }
                }
                break;
            case 120:
                {
                int LA195_2 = input.LA(2);

                if ( (LA195_2==RULE_INT) ) {
                    int LA195_3 = input.LA(3);

                    if ( (LA195_3==71) ) {
                        int LA195_4 = input.LA(4);

                        if ( (LA195_4==RULE_INT) ) {
                            int LA195_5 = input.LA(5);

                            if ( ((LA195_5>=121 && LA195_5<=122)) ) {
                                alt195=2;
                            }
                            else if ( (LA195_5==EOF||LA195_5==22||LA195_5==26) ) {
                                alt195=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 195, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 195, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 195, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 195, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA195_3 = input.LA(2);

                if ( (LA195_3==71) ) {
                    int LA195_4 = input.LA(3);

                    if ( (LA195_4==RULE_INT) ) {
                        int LA195_5 = input.LA(4);

                        if ( ((LA195_5>=121 && LA195_5<=122)) ) {
                            alt195=2;
                        }
                        else if ( (LA195_5==EOF||LA195_5==22||LA195_5==26) ) {
                            alt195=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 195, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 195, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 195, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 195, 0, input);

                throw nvae;
            }

            switch (alt195) {
                case 1 :
                    // InternalRoom.g:9023:3: this_Decimal_0= ruleDecimal
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
                    // InternalRoom.g:9034:3: this_DecimalExp_1= ruleDecimalExp
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
    // InternalRoom.g:9048:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRoom.g:9050:2: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalRoom.g:9051:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalRoom.g:9060:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRoom.g:9067:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT ) )
            // InternalRoom.g:9068:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            {
            // InternalRoom.g:9068:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT )
            // InternalRoom.g:9069:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT
            {
            // InternalRoom.g:9069:3: (kw= '+' | kw= '-' )?
            int alt196=3;
            int LA196_0 = input.LA(1);

            if ( (LA196_0==119) ) {
                alt196=1;
            }
            else if ( (LA196_0==120) ) {
                alt196=2;
            }
            switch (alt196) {
                case 1 :
                    // InternalRoom.g:9070:4: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_37); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9076:4: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_37); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_103); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,71,FOLLOW_37); 

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
    // InternalRoom.g:9108:1: entryRuleDecimalExp returns [String current=null] : iv_ruleDecimalExp= ruleDecimalExp EOF ;
    public final String entryRuleDecimalExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalExp = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRoom.g:9110:2: (iv_ruleDecimalExp= ruleDecimalExp EOF )
            // InternalRoom.g:9111:2: iv_ruleDecimalExp= ruleDecimalExp EOF
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
    // InternalRoom.g:9120:1: ruleDecimalExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDecimalExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRoom.g:9127:2: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            // InternalRoom.g:9128:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            {
            // InternalRoom.g:9128:2: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
            // InternalRoom.g:9129:3: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
            {
            // InternalRoom.g:9129:3: (kw= '+' | kw= '-' )?
            int alt197=3;
            int LA197_0 = input.LA(1);

            if ( (LA197_0==119) ) {
                alt197=1;
            }
            else if ( (LA197_0==120) ) {
                alt197=2;
            }
            switch (alt197) {
                case 1 :
                    // InternalRoom.g:9130:4: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_37); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9136:4: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_37); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_103); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1());
            		
            kw=(Token)match(input,71,FOLLOW_37); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDecimalExpAccess().getFullStopKeyword_2());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_151); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3());
            		
            // InternalRoom.g:9161:3: (kw= 'e' | kw= 'E' )
            int alt198=2;
            int LA198_0 = input.LA(1);

            if ( (LA198_0==121) ) {
                alt198=1;
            }
            else if ( (LA198_0==122) ) {
                alt198=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 198, 0, input);

                throw nvae;
            }
            switch (alt198) {
                case 1 :
                    // InternalRoom.g:9162:4: kw= 'e'
                    {
                    kw=(Token)match(input,121,FOLLOW_152); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9168:4: kw= 'E'
                    {
                    kw=(Token)match(input,122,FOLLOW_152); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getEKeyword_4_1());
                    			

                    }
                    break;

            }

            // InternalRoom.g:9174:3: (kw= '+' | kw= '-' )?
            int alt199=3;
            int LA199_0 = input.LA(1);

            if ( (LA199_0==119) ) {
                alt199=1;
            }
            else if ( (LA199_0==120) ) {
                alt199=2;
            }
            switch (alt199) {
                case 1 :
                    // InternalRoom.g:9175:4: kw= '+'
                    {
                    kw=(Token)match(input,119,FOLLOW_37); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalExpAccess().getPlusSignKeyword_5_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRoom.g:9181:4: kw= '-'
                    {
                    kw=(Token)match(input,120,FOLLOW_37); 

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
    // InternalRoom.g:9201:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalRoom.g:9201:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalRoom.g:9202:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalRoom.g:9208:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRoom.g:9214:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoom.g:9215:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoom.g:9215:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoom.g:9216:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_153); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalRoom.g:9223:3: (kw= '.' this_ID_2= RULE_ID )*
            loop200:
            do {
                int alt200=2;
                int LA200_0 = input.LA(1);

                if ( (LA200_0==71) ) {
                    alt200=1;
                }


                switch (alt200) {
            	case 1 :
            	    // InternalRoom.g:9224:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,71,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_153); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop200;
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
    // InternalRoom.g:9241:1: ruleCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) ;
    public final Enumerator ruleCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalRoom.g:9247:2: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) ) )
            // InternalRoom.g:9248:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            {
            // InternalRoom.g:9248:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'sync' ) )
            int alt201=3;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt201=1;
                }
                break;
            case 124:
                {
                alt201=2;
                }
                break;
            case 125:
                {
                alt201=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 201, 0, input);

                throw nvae;
            }

            switch (alt201) {
                case 1 :
                    // InternalRoom.g:9249:3: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9249:3: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9250:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9257:3: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9257:3: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9258:4: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9265:3: (enumLiteral_2= 'sync' )
                    {
                    // InternalRoom.g:9265:3: (enumLiteral_2= 'sync' )
                    // InternalRoom.g:9266:4: enumLiteral_2= 'sync'
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
    // InternalRoom.g:9276:1: ruleReferenceType returns [Enumerator current=null] : ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) ;
    public final Enumerator ruleReferenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRoom.g:9282:2: ( ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) ) )
            // InternalRoom.g:9283:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            {
            // InternalRoom.g:9283:2: ( (enumLiteral_0= 'fixed' ) | (enumLiteral_1= 'optional' ) )
            int alt202=2;
            int LA202_0 = input.LA(1);

            if ( (LA202_0==126) ) {
                alt202=1;
            }
            else if ( (LA202_0==110) ) {
                alt202=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 202, 0, input);

                throw nvae;
            }
            switch (alt202) {
                case 1 :
                    // InternalRoom.g:9284:3: (enumLiteral_0= 'fixed' )
                    {
                    // InternalRoom.g:9284:3: (enumLiteral_0= 'fixed' )
                    // InternalRoom.g:9285:4: enumLiteral_0= 'fixed'
                    {
                    enumLiteral_0=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getReferenceTypeAccess().getFIXEDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9292:3: (enumLiteral_1= 'optional' )
                    {
                    // InternalRoom.g:9292:3: (enumLiteral_1= 'optional' )
                    // InternalRoom.g:9293:4: enumLiteral_1= 'optional'
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
    // InternalRoom.g:9303:1: ruleComponentCommunicationType returns [Enumerator current=null] : ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) ;
    public final Enumerator ruleComponentCommunicationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRoom.g:9309:2: ( ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) ) )
            // InternalRoom.g:9310:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            {
            // InternalRoom.g:9310:2: ( (enumLiteral_0= 'eventdriven' ) | (enumLiteral_1= 'datadriven' ) | (enumLiteral_2= 'async' ) | (enumLiteral_3= 'sync' ) )
            int alt203=4;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt203=1;
                }
                break;
            case 124:
                {
                alt203=2;
                }
                break;
            case 127:
                {
                alt203=3;
                }
                break;
            case 125:
                {
                alt203=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 203, 0, input);

                throw nvae;
            }

            switch (alt203) {
                case 1 :
                    // InternalRoom.g:9311:3: (enumLiteral_0= 'eventdriven' )
                    {
                    // InternalRoom.g:9311:3: (enumLiteral_0= 'eventdriven' )
                    // InternalRoom.g:9312:4: enumLiteral_0= 'eventdriven'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComponentCommunicationTypeAccess().getEVENT_DRIVENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9319:3: (enumLiteral_1= 'datadriven' )
                    {
                    // InternalRoom.g:9319:3: (enumLiteral_1= 'datadriven' )
                    // InternalRoom.g:9320:4: enumLiteral_1= 'datadriven'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComponentCommunicationTypeAccess().getDATA_DRIVENEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9327:3: (enumLiteral_2= 'async' )
                    {
                    // InternalRoom.g:9327:3: (enumLiteral_2= 'async' )
                    // InternalRoom.g:9328:4: enumLiteral_2= 'async'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComponentCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9335:3: (enumLiteral_3= 'sync' )
                    {
                    // InternalRoom.g:9335:3: (enumLiteral_3= 'sync' )
                    // InternalRoom.g:9336:4: enumLiteral_3= 'sync'
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
    // InternalRoom.g:9346:1: ruleLiteralType returns [Enumerator current=null] : ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) ;
    public final Enumerator ruleLiteralType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRoom.g:9352:2: ( ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) ) )
            // InternalRoom.g:9353:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            {
            // InternalRoom.g:9353:2: ( (enumLiteral_0= 'ptBoolean' ) | (enumLiteral_1= 'ptInteger' ) | (enumLiteral_2= 'ptReal' ) | (enumLiteral_3= 'ptCharacter' ) )
            int alt204=4;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt204=1;
                }
                break;
            case 129:
                {
                alt204=2;
                }
                break;
            case 130:
                {
                alt204=3;
                }
                break;
            case 131:
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
                    // InternalRoom.g:9354:3: (enumLiteral_0= 'ptBoolean' )
                    {
                    // InternalRoom.g:9354:3: (enumLiteral_0= 'ptBoolean' )
                    // InternalRoom.g:9355:4: enumLiteral_0= 'ptBoolean'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoom.g:9362:3: (enumLiteral_1= 'ptInteger' )
                    {
                    // InternalRoom.g:9362:3: (enumLiteral_1= 'ptInteger' )
                    // InternalRoom.g:9363:4: enumLiteral_1= 'ptInteger'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoom.g:9370:3: (enumLiteral_2= 'ptReal' )
                    {
                    // InternalRoom.g:9370:3: (enumLiteral_2= 'ptReal' )
                    // InternalRoom.g:9371:4: enumLiteral_2= 'ptReal'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoom.g:9378:3: (enumLiteral_3= 'ptCharacter' )
                    {
                    // InternalRoom.g:9378:3: (enumLiteral_3= 'ptCharacter' )
                    // InternalRoom.g:9379:4: enumLiteral_3= 'ptCharacter'
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


    protected DFA138 dfa138 = new DFA138(this);
    protected DFA139 dfa139 = new DFA139(this);
    static final String dfa_1s = "\101\uffff";
    static final String dfa_2s = "\13\uffff\1\22\7\uffff\3\22\1\uffff\1\22\51\uffff";
    static final String dfa_3s = "\1\120\1\4\1\20\1\4\1\24\4\4\2\24\1\16\2\4\1\24\1\4\1\5\1\17\1\uffff\3\16\1\5\1\16\1\4\2\uffff\1\17\2\4\1\17\1\33\1\5\2\26\2\6\3\26\1\4\1\17\1\6\1\33\1\26\1\5\2\6\2\26\2\6\3\26\2\6\1\26\1\6\1\26\4\6\1\26";
    static final String dfa_4s = "\1\120\2\20\1\144\1\31\2\4\1\144\1\4\2\24\1\142\2\4\1\24\1\4\1\44\1\153\1\uffff\3\142\1\44\1\142\1\4\2\uffff\1\153\2\4\1\153\1\33\1\170\2\32\2\6\1\107\2\32\1\4\1\153\1\6\1\33\1\172\3\170\2\32\2\6\1\107\2\32\2\6\1\32\1\6\1\172\2\170\2\6\1\32";
    static final String dfa_5s = "\22\uffff\1\2\6\uffff\1\1\1\3\46\uffff";
    static final String dfa_6s = "\101\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
            "\1\3",
            "\1\4\136\uffff\1\5\1\6",
            "\1\7\4\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13\136\uffff\1\14\1\15",
            "\1\16",
            "\1\7",
            "\1\7",
            "\1\21\1\22\11\uffff\1\17\11\uffff\1\20\53\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\23",
            "\1\24",
            "\1\7",
            "\1\25",
            "\1\26\36\uffff\1\27",
            "\1\22\115\uffff\1\22\1\31\1\uffff\1\31\1\32\11\uffff\1\30",
            "",
            "\1\21\1\22\23\uffff\1\20\53\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\21\1\22\23\uffff\1\20\53\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\21\1\22\23\uffff\1\20\53\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\26\36\uffff\1\27",
            "\1\21\1\22\77\uffff\2\22\5\uffff\6\22\6\uffff\1\22",
            "\1\33",
            "",
            "",
            "\1\22\5\uffff\1\35\61\uffff\1\34\25\uffff\1\22\2\uffff\1\31\1\32\11\uffff\1\30",
            "\1\36",
            "\1\37",
            "\1\22\5\uffff\1\35\61\uffff\1\34\25\uffff\1\22\2\uffff\1\31\1\32\11\uffff\1\30",
            "\1\40",
            "\1\47\1\45\1\uffff\1\46\154\uffff\1\41\1\42\1\43\1\44",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\45",
            "\1\45",
            "\1\51\3\uffff\1\50\54\uffff\1\52",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\53",
            "\1\22\115\uffff\1\22\2\uffff\1\31\1\32\11\uffff\1\30",
            "\1\54",
            "\1\55",
            "\1\51\3\uffff\1\50\136\uffff\1\56\1\57",
            "\1\66\1\64\1\uffff\1\65\154\uffff\1\60\1\61\1\62\1\63",
            "\1\71\160\uffff\1\67\1\70",
            "\1\71\160\uffff\1\67\1\70",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\64",
            "\1\64",
            "\1\51\3\uffff\1\50\54\uffff\1\72",
            "\1\51\3\uffff\1\50",
            "\1\51\3\uffff\1\50",
            "\1\71",
            "\1\71",
            "\1\51\3\uffff\1\50",
            "\1\73",
            "\1\51\3\uffff\1\50\136\uffff\1\74\1\75",
            "\1\100\160\uffff\1\76\1\77",
            "\1\100\160\uffff\1\76\1\77",
            "\1\100",
            "\1\100",
            "\1\51\3\uffff\1\50"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA138 extends DFA {

        public DFA138(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 138;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "6174:2: (this_TransitionChainStartTransition_0= ruleTransitionChainStartTransition | this_ContinuationTransition_1= ruleContinuationTransition | this_CPBranchTransition_2= ruleCPBranchTransition )";
        }
    }
    static final String dfa_8s = "\31\uffff";
    static final String dfa_9s = "\1\120\1\4\1\20\1\4\1\24\4\4\3\24\1\16\2\4\1\5\1\136\1\4\2\16\1\5\1\16\2\uffff\1\16";
    static final String dfa_10s = "\1\120\2\20\1\144\1\31\3\4\1\144\3\24\1\43\2\4\1\44\1\153\1\4\2\43\1\44\1\16\2\uffff\1\43";
    static final String dfa_11s = "\26\uffff\1\2\1\1\1\uffff";
    static final String dfa_12s = "\31\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2\13\uffff\1\3",
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

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA139 extends DFA {

        public DFA139(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 139;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "6219:2: (this_TriggeredTransition_0= ruleTriggeredTransition | this_GuardedTransition_1= ruleGuardedTransition )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x8060080031088000L,0xB802180000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x8060080031088000L,0xB802100000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x8060080031088000L,0xB800100000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x8060080031088000L,0xB800000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000802004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000140L,0x0180000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800800002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000840004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000066780008000L,0x0000080000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000006670000C080L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000066700008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000006660000C080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000066600008000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000006640000C080L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000066400008000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000808000012L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000808000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000800014080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000800004080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000004080L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000010800014080L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001700380008000L,0x0000090000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000170030000C080L,0x0000010000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001700300008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000170020000C080L,0x0000010000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0001700200008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x000170000000C080L,0x0000010000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0001700000008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0006000000008000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0001600000008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0001400000008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0001000000008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000008000L,0x0000010000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000800200002L,0x0000080000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000800000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0018066400008000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x001006640000C080L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0010066400008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0060000000000000L,0xB800000000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0380000000008000L,0x0000080000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x2401000000008000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0300000000008000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x7C01066780008000L,0x4000400000000920L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x7C0106670000C080L,0x4000400000000920L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x7C01066700008000L,0x4000400000000920L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x7C0106660000C080L,0x4000400000000920L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x7C01066600008000L,0x4000400000000920L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x7C0106640000C080L,0x4000400000000920L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x7C01066400008000L,0x4000400000000920L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0200000000008000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000066000008000L,0x0000080000020000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000066000008000L,0x0000000000020000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000008000L,0x0000080000000121L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000121L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x2401000380008000L,0x400048000000092CL});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x240100030000C080L,0x400040000000092CL});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x2401000300008000L,0x400040000000092CL});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x240100020000C080L,0x400040000000092CL});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x2401000200008000L,0x400040000000092CL});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x240100000000C080L,0x400040000000092CL});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x2401000000008000L,0x400040000000092CL});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000400L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000008000L,0x000000040FC18000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000008000L,0x00000800003C0000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x000000000000C080L,0x0000000000380000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000008000L,0x0000000000380000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x000000000000C080L,0x0000000000300000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000008000L,0x0000000000300000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x000000000000C080L,0x0000000000200000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000008000L,0x0000000000200000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000010L,0x0000001800000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000008000L,0x0000080020000000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x000000000000C080L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0000082000000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000008000L,0x0000000080000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000008000L,0x0000000020000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000000000L,0x0000080100000000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x000000000000C080L,0x0000000020000000L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000000000L,0x0000080200000000L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000000L,0x0000080020000000L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000000L,0x000000C100000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0000000000008000L,0x0000060000000000L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000000200000L,0x0000060000000000L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_141 = new BitSet(new long[]{0x0000000000000160L,0x01E0000000000000L});
    public static final BitSet FOLLOW_142 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_143 = new BitSet(new long[]{0x8444080020006000L,0x000000000001E002L});
    public static final BitSet FOLLOW_144 = new BitSet(new long[]{0x0000000000008000L,0x0000C00000000000L});
    public static final BitSet FOLLOW_145 = new BitSet(new long[]{0x8444080020002000L,0x000000000001E002L});
    public static final BitSet FOLLOW_146 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_147 = new BitSet(new long[]{0x0000000000000010L,0x0008000000000000L});
    public static final BitSet FOLLOW_148 = new BitSet(new long[]{0x0000000000000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_149 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_150 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_151 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_152 = new BitSet(new long[]{0x0000000000000040L,0x0180000000000000L});
    public static final BitSet FOLLOW_153 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});

}
